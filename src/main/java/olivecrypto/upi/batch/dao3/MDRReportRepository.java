package olivecrypto.upi.batch.dao3;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import olivecrypto.upi.domain.MDRReportGeneration;


@Repository
public interface MDRReportRepository extends CrudRepository<MDRReportGeneration, Long> {

	//public MDRReportGeneration save(BigDecimal mdrCharges);

	List<MDRReportGeneration>findByAggregatorCodeOrderByCreatedDateDesc(String aggregatorCode);
	List<MDRReportGeneration>findByMerchantCodeOrderByCreatedDateDesc(String merchantCode);
	List<MDRReportGeneration> findByAggregatorCodeAndMerchantCodeOrderByCreatedDateDesc(String aggregatorCode, String merchantCode); 
	
	List<MDRReportGeneration> findByCreatedDateBetweenAndMerchantCodeOrderByCreatedDateDesc(Date fromDate, Date toDate, String merchantCode);
	
	List<MDRReportGeneration> findByCreatedDateBetweenAndAggregatorCodeOrderByCreatedDateDesc(Date fromDate, Date toDate, String aggregatorCode);
	
	List<MDRReportGeneration> findByCreatedDateBetweenAndAggregatorCodeAndMerchantCodeOrderByCreatedDateDesc(Date fromDate, Date toDate, String aggregatorCode, String merchantCode);
	
	List<MDRReportGeneration> findByCreatedDateBetweenOrderByCreatedDateDesc(Date fromDate, Date toDate);
	
	//@Query(value = "select mp.aggregatorCode,mp.createdDate,mp.category,mp.crn,mp.lob,mp.merchantcode,mp.mdrcharges,mp.payeeacount,mp.cost,mp.payeeifsc,mp.payerName,mp.payerVpa,mp.refid,mp.txnCount,mp.txnAmount,mp.taxDate,mp.vpa,mp.download,mp.payerAccount,mp.payerifsc from tbl_merchant_mdr_summary mp where mp.createddate>=:fromDate and mp.createddate<=:toDate", nativeQuery = true)
	
	@Query(value = "select mp.id ,mp.aggregator_Code,mp.category,mp.cost,mp.created_date,mp.crn,mp.lob,mp.mdr_charges,mp.merchant_code,mp.payee_account,mp.payee_ifsc,mp.payer_account,mp.payer_ifsc,mp.payer_Name,mp.payer_Vpa,mp.refid,mp.txn_Amount,mp.txn_count,mp.txn_Date,mp.vpa,mp.download from tbl_merchant_mdr_summary mp where  mp.created_date>=:fromDate and mp.created_date<=:toDate", nativeQuery = true)
	
	List<Object[]> findSummaryDate(@Param("fromDate") Date startDate, @Param("toDate") Date endDate);
	
	@Query(value = "select mp.id ,mp.aggregator_Code,mp.category,mp.cost,mp.created_date,mp.crn,mp.lob,mp.mdr_charges,mp.merchant_code,mp.payee_account,mp.payee_ifsc,mp.payer_account,mp.payer_ifsc,mp.payer_Name,mp.payer_Vpa,mp.refid,mp.txn_Amount,mp.txn_count,mp.txn_Date,mp.vpa,mp.download from tbl_merchant_mdr_summary mp where mp.download ='N' and mp.created_date>=:fromDate and mp.created_date<=:toDate", nativeQuery = true)
	
	List<Object[]> findSummaryDate1(@Param("fromDate") Date startDate, @Param("toDate") Date endDate);
	
//	List<MDRReportGeneration> findByIdBetweenOrderByIdDesc(long startId, long endId);
//	
//	List<MDRReportGeneration> findAllById(long id) ;
	
//	@Query(value = "update tbl_merchant_mdr_summary set download ='Y' where id in(?1)", nativeQuery = true)
//	@Transactional
//	@Modifying
//	int updateDownloadByIdIn(List<Long> ids);
	
	
	
	
	
}
