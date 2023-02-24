package olivecrypto.upi.batch.processors;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import olivecrypto.upi.batch.dto.BatchDto;
import olivecrypto.upi.batch.dto.BatchDtoIdb;

@Component
public class CustomReaderIdb extends JdbcCursorItemReader<BatchDtoIdb> implements ItemReader<BatchDtoIdb>{
	
	@Autowired
	DataSource dataSource;
	
//	Logger logger = LoggerFactory.getLogger("BATCHLOG");

	@Value("${idb.batch.schedule.fetchsize}")
	String fetchSize;
	
	@PostConstruct
	public void init() {
		setDataSource(dataSource);
//		logger.debug("Custom Reader connected to db");
		System.out.println("Custom Reader connected to db");
        setSql("select refid as 'RRN', TXN_DATE as 'TXN_DATE', PAYEE_ACCOUNT as 'PAYEE_ACCOUNT', TXN_AMOUNT as 'TXN_AMOUNT', REMARKS as 'REMARKS', TXN_STATUS as 'TXN_STATUS', RESPONSECODE as 'RESPONSECODE', CHARG_AMOUNT as 'CHARG_AMOUNT', RESPONSECODE as 'RESPONSECODE', CREATED_DATE as 'CHARGE_DATE' FROM TBL_MERCHANT_MDR_SUMMARY;");
		setFetchSize(Integer.parseInt(fetchSize));
		setRowMapper(new BatchDtoMapper());
	}
	
	
	
	public class BatchDtoMapper implements RowMapper<BatchDtoIdb> {
		@Override
		public BatchDtoIdb mapRow(ResultSet rs, int rowNum) throws SQLException {
			BatchDtoIdb idbDb  = new BatchDtoIdb();
			
			idbDb.setRrnNo(rs.getString("RRN"));
			idbDb.setTxnDate(rs.getDate("TXN_DATE"));
			idbDb.setPayeeAccount(rs.getString("PAYEE_ACCOUNT"));
			idbDb.setTxnAmount(rs.getLong("TXN_AMOUNT"));
			idbDb.setRemarks(rs.getString("REMARKS"));
			idbDb.setTxnStatus(rs.getString("TXN_STATUS"));
			idbDb.setResponseCode((rs.getString("RESPONSECODE")));
			idbDb.setChargeAmount(rs.getLong("CHARG_AMOUNT"));
//			idbDb.setFailureCode(rs.getString("RESPONSECODE"));
			idbDb.setCreatedDate(rs.getDate("CHARGE_DATE"));
			return idbDb;
		}
	}
}