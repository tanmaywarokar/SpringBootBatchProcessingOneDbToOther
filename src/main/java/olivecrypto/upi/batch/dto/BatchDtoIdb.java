package olivecrypto.upi.batch.dto;

import java.util.Date;

public class BatchDtoIdb {

	//pan_validation_mv
	private String refId;


	
	private Date txnDate;
	
	private String payeeAccount;
	
	private Long txnAmount;
	
	//tbl_cbs_tranlog
	
//	private long id;

	private String remarks;

	private String txnStatus;

	private String responseCode;

	public Long chargeAmount;

	public Date  createdDate;
	
//	private String failureCode;
//
//
//	public String getFailureCode() {
//		return failureCode;
//	}
//
//	public void setFailureCode(String failureCode) {
//		this.failureCode = failureCode;
//	}

	public void setRefId(String refId) {
		this.refId = refId;
	}

	public String getRefId() {
		return refId;
	}

	public void setRrnNo(String refId) {
		this.refId = refId;
	}

	public Date getTxnDate() {
		return txnDate;
	}

	public void setTxnDate(Date txnDate) {
		this.txnDate = txnDate;
	}

	public String getPayeeAccount() {
		return payeeAccount;
	}

	public void setPayeeAccount(String payeeAccount) {
		this.payeeAccount = payeeAccount;
	}

	public Long getTxnAmount() {
		return txnAmount;
	}

	public void setTxnAmount(Long txnAmount) {
		this.txnAmount = txnAmount;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getTxnStatus() {
		return txnStatus;
	}

	public void setTxnStatus(String txnStatus) {
		this.txnStatus = txnStatus;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public Long getChargeAmount() {
		return chargeAmount;
	}

	public void setChargeAmount(Long chargeAmount) {
		this.chargeAmount = chargeAmount;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
		
}
