package olivecrypto.upi.batch.processors;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import olivecrypto.upi.batch.dao3.IdbDAO;
import olivecrypto.upi.batch.domain3.IdbDB;


@Component
public class CustomWriterIdb implements ItemWriter<IdbDB> {
	
	@Autowired
	IdbDAO idbRepository;
//	Logger logger = LoggerFactory.getLogger("BATCHLOG");
	
	@Override
	public void write(List<? extends IdbDB> list) throws Exception {
		for (IdbDB data : list) {
//			logger.debug("Custom Writer writing (saving) to other DB for CRN::{}", data.getRrnNo());
			System.out.println("Custom Writer writing (saving) to other DB for CRN::" + data.getRrnNo());
			try {
			idbRepository.insert(data);
			}
			catch(Exception ex){
				if(ex.getMessage().contains("java.sql.SQLIntegrityConstraintViolationException")) {
					System.out.println("Duplicate Primary Key RRN");
				}
			}
		}
	}
}