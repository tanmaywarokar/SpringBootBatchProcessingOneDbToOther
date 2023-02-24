package olivecrypto.upi.batch.processors;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import olivecrypto.upi.batch.domain3.IdbDB;
import olivecrypto.upi.batch.dto.BatchDtoIdb;

@Component
public class CustomProcessorIdb implements ItemProcessor<BatchDtoIdb, IdbDB> {
//	Logger logger = LoggerFactory.getLogger("BATCHLOG");
	
	@Override
	public IdbDB process(BatchDtoIdb pan) throws Exception {
//		logger.debug("BatchProcessor : Processing data ::Fetched ResultSet::{}",new Gson().toJson(pan));
		System.out.println("BatchProcessor : Processing data ::Fetched ResultSet::"+new Gson().toJson(pan));
		IdbDB lrsDb = new IdbDB();
		lrsDb.setRrnNo(pan.getRefId());
		lrsDb.setTxnDate(pan.getTxnDate());
		lrsDb.setAccount(pan.getPayeeAccount());
		lrsDb.setAmount(pan.getTxnAmount());
		lrsDb.setRemarks(pan.getRemarks());
		lrsDb.setTxnStatus(pan.getTxnStatus());
		lrsDb.setRespCode(pan.getResponseCode());
		lrsDb.setChargeAmount(pan.getChargeAmount());
		lrsDb.setChargeDate(pan.getCreatedDate());
		lrsDb.setFailureCode(pan.getResponseCode()!= "00" ? pan.getResponseCode() : "");
		lrsDb.setCbsRrnNo(pan.getRefId());
		return lrsDb;
	}
}