package olivecrypto.upi.batch.config;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;


@Configuration
@EnableJpaRepositories(basePackages = "olivecrypto.upi.batch.dao3",
      entityManagerFactoryRef = "idbEntityManagerFactory",
      transactionManagerRef= "idbTransactionManager")
@PropertySource("classpath:db.properties")
public class IdbDbConfig {

	Logger logger= LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Environment env;
	
	
  @Bean(name = "idbDataSource")    
  public DataSource getidbDataSource() {
  	HikariConfig config = new HikariConfig();
		config.setJdbcUrl(env.getRequiredProperty("idb.datasource.url"));
		config.setDriverClassName(env.getRequiredProperty("idb.datasource.driver"));
		config.setUsername(env.getRequiredProperty("idb.datasource.username"));
//		EncryptedPropertyOverriderConfigurer ec=new EncryptedPropertyOverriderConfigurer();
//		config.setPassword(new String(aepsPasswordService.decrypt(env.getRequiredProperty("cbs.db.password").trim())));
//		EncryptedPropertyOverriderConfigurer ec=new EncryptedPropertyOverriderConfigurer();
		config.setPassword(env.getRequiredProperty("idb.datasource.password"));
		boolean dbPasswordFlag = Boolean.valueOf(env.getProperty("idb.plainpassword.flag", "false"));
		if (dbPasswordFlag) {
			config.setPassword(env.getRequiredProperty("idb.datasource.password"));
		}
		Long connTimeout = env.getRequiredProperty("idb.db.connection.timeout", Long.class);
		if(connTimeout == null || connTimeout == 0) {
			connTimeout = 30000L;
		}
		config.setConnectionTimeout(connTimeout);
		config.addDataSourceProperty("cachePrepStmts", true);
	 	config.setConnectionTestQuery(env.getRequiredProperty("idb.db.hikari.jdbc.validationQuery"));
		config.setAutoCommit(Boolean.getBoolean(env.getRequiredProperty("idb.db.hikari.autoCommit")));
		config.setMaximumPoolSize(Integer.parseInt(env.getRequiredProperty("idb.db.hikari.maxpoolsize")));
		config.setIdleTimeout(Long.parseLong(env.getRequiredProperty("idb.db.hikari.idleTimeout")));
		config.setMaxLifetime(Long.parseLong(env.getRequiredProperty("idb.db.hikari.maxLifetime")));
	 	config.setPoolName(env.getRequiredProperty("idb.db.hikari.poolName"));
	 	config.setValidationTimeout(TimeUnit.MINUTES.toMillis(1));
		config.setLeakDetectionThreshold(5000);
		
		return new HikariDataSource(config);
  }
  
  @Bean(name = "idbTransactionManager")
  public PlatformTransactionManager cbsTransactionManager(
          final @Qualifier("idbEntityManagerFactory") LocalContainerEntityManagerFactoryBean idbEntityManagerFactory) {
      return new JpaTransactionManager(idbEntityManagerFactory.getObject());
  }
  
  @Bean(name = "idbEntityManagerFactory")
  public LocalContainerEntityManagerFactoryBean idbEntityManagerFactory()
	{
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(Boolean.TRUE);
		vendorAdapter.setShowSql(Boolean.TRUE);

		factory.setDataSource(getidbDataSource());
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan("olivecrypto.upi.domain");
		factory.setJpaProperties(getHibernateProperties());
		factory.afterPropertiesSet();
		factory.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());
		return factory;
	}
  
  private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.show_sql",env.getRequiredProperty("hibernate.show_sql"));
		properties.put("hibernate.dialect",env.getRequiredProperty("idb.jpa.database-platform"));
		properties.put("hibernate.hbm2ddl.auto",env.getRequiredProperty("hibernate.hbm2ddl.idb.auto"));
		 
		properties.put("hibernate.generate_statistics", env.getProperty("hibernate.generate.statistics",Boolean.class,true));
		    
		return properties;
	}
}