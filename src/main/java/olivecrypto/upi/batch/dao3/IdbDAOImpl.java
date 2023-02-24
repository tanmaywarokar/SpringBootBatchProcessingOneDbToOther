package olivecrypto.upi.batch.dao3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;

import olivecrypto.upi.batch.domain3.IdbDB;

@Repository
@PropertySource("classpath:db.properties")
public class IdbDAOImpl implements IdbDAO {
	Logger logger = LoggerFactory.getLogger("BATCHLOG");
	@Autowired
	private Environment env;
	
	public IdbDAOImpl(){}

 
    
    public void insert(IdbDB lrsDb) throws SQLException { 
		Connection con = null;
		try {
			
//			System.out.println("Inserting data to TBL_UPI_CHG_DUMP table ::" + new Gson().toJson(lrsDb));
			logger.debug("Inserting data to TBL_UPI_CHG_DUMP table ::{}", new Gson().toJson(lrsDb));
			String query = "INSERT INTO TBL_UPI_CHG_DUMP (RRN,TXN_DATE,PAYEE_ACCOUNT,TXN_AMOUNT,REMARKS,TXN_STATUS,RESPONSECODE,CHARG_AMOUNT,FAILURE_CODE,CHARGE_DATE,CBS_RRN) values(?,?,?,?,?,?,?,?,?,?,?)";
			
			String driver = env.getProperty("idb.datasource.cj.driver");
			String url = env.getProperty("idb.datasource.url");
			String user = env.getProperty("idb.datasource.username");
			String pass = env.getProperty("idb.datasource.password");
			
			java.sql.Date sqlTranDate=null;
			java.sql.Date sqlChargeDate=null;
			
			Date tranDate = lrsDb.getTxnDate();
			Date chargeDate = lrsDb.getChargeDate();

			if(tranDate!=null) {
			    sqlTranDate = new java.sql.Date(tranDate.getTime());
			}
			
			if(chargeDate!=null) {
				sqlChargeDate = new java.sql.Date(chargeDate.getTime());
			}

//			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pass);
			PreparedStatement pstmt = con.prepareStatement(query);		
			pstmt.setString(1, lrsDb.getRrnNo()!=null?lrsDb.getRrnNo():"");
			pstmt.setDate(2, sqlTranDate!=null?sqlTranDate:null);
			pstmt.setString(3, lrsDb.getAccount()!=null?lrsDb.getAccount():"");
			pstmt.setLong(4, lrsDb.getAmount()!=null?lrsDb.getAmount():0L);
			pstmt.setString(5, lrsDb.getRemarks()!=null? lrsDb.getRemarks():"");
			pstmt.setString(6, lrsDb.getTxnStatus()!=null?lrsDb.getTxnStatus():"");
			pstmt.setString(7, lrsDb.getRespCode()!=null?lrsDb.getRespCode():"");
			pstmt.setLong(8, lrsDb.getChargeAmount()!=null?lrsDb.getChargeAmount():0L);
			pstmt.setString(9, lrsDb.getFailureCode()!=null?lrsDb.getFailureCode():"");
			pstmt.setDate(10, sqlChargeDate!=null?sqlChargeDate:null);
			pstmt.setString(11, lrsDb.getCbsRrnNo()!=null?lrsDb.getCbsRrnNo():"");
			
            int rowAffected = pstmt.executeUpdate();
            
            if(rowAffected>0) {
            	logger.debug("Data updated into the IDB DB... rows added::{}", rowAffected);
//            	System.out.println("Data updated into the DB... rows added::" + rowAffected);
            }
//            con.close();
		}
//		catch(Exception ex){
//			if(ex.getMessage().contains("java.sql.SQLIntegrityConstraintViolationException")) {
//				System.out.println("Duplicate Primary Key RRN");
//			}
//		}
		catch(Exception e) {
			logger.error(e.getMessage());
//			System.out.println("error::" + e.getMessage());
			e.printStackTrace();
		}
		finally {
			logger.debug("Closing DB connection...!!!");
//			System.out.println("Closing DB connection...!!!");
		}
    }
    	
}
