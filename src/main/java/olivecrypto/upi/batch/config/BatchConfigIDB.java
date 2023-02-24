package olivecrypto.upi.batch.config;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import olivecrypto.upi.batch.domain3.IdbDB;
import olivecrypto.upi.batch.dto.BatchDtoIdb;
import olivecrypto.upi.batch.processors.CustomProcessorIdb;
import olivecrypto.upi.batch.processors.CustomReaderIdb;
import olivecrypto.upi.batch.processors.CustomWriterIdb;

@Configuration
@EnableBatchProcessing
@EnableScheduling
public class BatchConfigIDB {
	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;
		
	@Autowired
	CustomReaderIdb customReader;
	
	@Autowired
	CustomWriterIdb customWriter;

	@Autowired
	CustomProcessorIdb customProcessor;
	
	@Autowired
	JobLauncher jobLauncher;
	
//	Logger logger = LoggerFactory.getLogger("BATCHLOG");
	
	@Scheduled(cron = "${idb.batch.schedule.cron}")
	public void perform() {
//		logger.debug("perform method in batchConfig");
		System.out.println("perform method in batchConfig");

//		logger.debug("Job started at:{}",new Date());
		System.out.println("Job started at: " + new Date());
		JobParameters param = new JobParametersBuilder().addString("JobID", String.valueOf(System.currentTimeMillis()))
				.toJobParameters();

		try {
			JobExecution execution = jobLauncher.run(createJob(), param);
//			logger.debug("Job finished with status :{}", execution.getStatus());
			System.out.println("Job finished with status :" + execution.getStatus());
//			logger.debug("Job ends........."+"jobexcution > "+execution.getFailureExceptions()+"	> StepExceutions=="+execution.getStepExecutions());
			System.out.println("Job ends........."+"jobexcution > "+execution.getFailureExceptions()+"	> StepExceutions=="+execution.getStepExecutions());
		}
		catch(Exception e) {
//			logger.error("Exception while batch config::{}",e);	
			System.out.println("Exception while batch config:: " + e);	
			e.printStackTrace();
		}

	}
	
	@Bean
	public Job createJob() {
//		logger.debug("Creating Job");
		System.out.println("Creating Job");
		return jobBuilderFactory.get("MyJob")
				.incrementer(new RunIdIncrementer())
				.flow(createStep()).end().build();
	}

	@Bean
	public Step createStep() {
//		logger.debug("Creating Step");
		System.out.println("Creating Step");
		return stepBuilderFactory.get("MyStep")
				.<BatchDtoIdb, IdbDB> chunk(2)
				.reader(customReader)
				.processor(customProcessor)
				.writer(customWriter)
				.build();
	}
}