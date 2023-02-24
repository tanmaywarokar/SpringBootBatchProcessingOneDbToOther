package olivecrypto.upi.batch.domain3;

import java.util.Date;

public class IdbDB {

	public String rrnNo;
	public Date txnDate;
	public String account;
	public Long amount;
	public String remarks;
	public String txnStatus;
	public String respCode;
	public Long chargeAmount;
	public Date chargeDate;
	public String failureCode;
	public String cbsRrnNo;
	
	public String getRrnNo() {
		return rrnNo;
	}
	public void setRrnNo(String rrnNo) {
		this.rrnNo = rrnNo;
	}
	public Date getTxnDate() {
		return txnDate;
	}
	public void setTxnDate(Date txnDate) {
		this.txnDate = txnDate;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
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
	public String getRespCode() {
		return respCode;
	}
	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}
	public Long getChargeAmount() {
		return chargeAmount;
	}
	public void setChargeAmount(Long chargeAmount) {
		this.chargeAmount = chargeAmount;
	}
	public Date getChargeDate() {
		return chargeDate;
	}
	public void setChargeDate(Date chargeDate) {
		this.chargeDate = chargeDate;
	}
	public String getFailureCode() {
		return failureCode;
	}
	public void setFailureCode(String failureCode) {
		this.failureCode = failureCode;
	}
	public String getCbsRrnNo() {
		return cbsRrnNo;
	}
	public void setCbsRrnNo(String cbsRrnNo) {
		this.cbsRrnNo = cbsRrnNo;
	}
	
}
