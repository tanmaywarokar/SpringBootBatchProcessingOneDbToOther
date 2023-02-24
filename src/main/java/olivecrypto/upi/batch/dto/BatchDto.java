package olivecrypto.upi.batch.dto;

import java.util.Date;

public class BatchDto {

	//pan_validation_mv
	private String partyId;


	private String createdBy;
	
	private Date createdDate;
	
	private String panNo;
	
	private String prefMobileNo;
	
	//tbl_cbs_tranlog
	
	private long id;

	private String txnid;

	private String msgid;

	private String orgTxnId;

	public Date txnDate;

	public String type;
	public Long amount;
	public String rrn;
	public String stan;

	public String cbsRc;
	public String upiRc;
	public String customerAccount;// credit or debit
	public String debitAccount;
	public String creditAccount;

	public String reversalStatus;
	public boolean reversal = false;
	public String customerId;
	public String remarks;
	public String seqNo;
	public String name;
	public String payeeVpa;
	public String payerVpa;
	public String commissionAmount;
	public String tranType;
	public String customerRefId;
	public String debitBankName;
	public String creditBankName;
	public String othersAccount;
	public String channel;
	public String appid;
	public String preApproved;// Y|N
	public String approvalNum;

	public String mccCode;

	public String remitterName;
	public String beneficiaryName;

	public String payerCode;
	public String payeeCode;
	public String subType;
	public String creditAccounutType;
	public String debitAccounutType;
	public String orderid;
	private String debitIfsc;
	private String creditIfsc;
	public Date cbsTxndate;
	public String initMode;
	public String purposeCode;
	public String otherMobileno;
	public String gmtDate; 

	public String payerAccountType;
	public String payeeAccountType;

	public String serverIp;
	
	 
	public Date createDate=new Date();

	public String payerConsentName;

	public String payerConsentType;

	public String payerConsentValue;

	public String adjCode;
	public String adjFlag;
	
	private String batchId;
	
	public String conCode;
	public Long baseAmount;
	public String baseCurr;
	public String fx;
	public String mkup;
	
	//Custom data
	public String documentType;
	public String transactionType;
	public String rbiPurpose;
	public String itType;
	
	public String getItType() {
		return itType;
	}
	public void setItType(String itType) {
		this.itType = itType;
	}
	public String getRbiPurpose() {
		return rbiPurpose;
	}
	public void setRbiPurpose(String rbiPurpose) {
		this.rbiPurpose = rbiPurpose;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String getDocumentType() {
		return documentType;
	}
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}
	public String getPartyId() {
		return partyId;
	}
	public void setPartyId(String partyId) {
		this.partyId = partyId;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getPanNo() {
		return panNo;
	}
	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}
	public String getPrefMobileNo() {
		return prefMobileNo;
	}
	public void setPrefMobileNo(String prefMobileNo) {
		this.prefMobileNo = prefMobileNo;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTxnid() {
		return txnid;
	}
	public void setTxnid(String txnid) {
		this.txnid = txnid;
	}
	public String getMsgid() {
		return msgid;
	}
	public void setMsgid(String msgid) {
		this.msgid = msgid;
	}
	public String getOrgTxnId() {
		return orgTxnId;
	}
	public void setOrgTxnId(String orgTxnId) {
		this.orgTxnId = orgTxnId;
	}
	public Date getTxnDate() {
		return txnDate;
	}
	public void setTxnDate(Date txnDate) {
		this.txnDate = txnDate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public String getRrn() {
		return rrn;
	}
	public void setRrn(String rrn) {
		this.rrn = rrn;
	}
	public String getStan() {
		return stan;
	}
	public void setStan(String stan) {
		this.stan = stan;
	}
	public String getCbsRc() {
		return cbsRc;
	}
	public void setCbsRc(String cbsRc) {
		this.cbsRc = cbsRc;
	}
	public String getUpiRc() {
		return upiRc;
	}
	public void setUpiRc(String upiRc) {
		this.upiRc = upiRc;
	}
	public String getCustomerAccount() {
		return customerAccount;
	}
	public void setCustomerAccount(String customerAccount) {
		this.customerAccount = customerAccount;
	}
	public String getDebitAccount() {
		return debitAccount;
	}
	public void setDebitAccount(String debitAccount) {
		this.debitAccount = debitAccount;
	}
	public String getCreditAccount() {
		return creditAccount;
	}
	public void setCreditAccount(String creditAccount) {
		this.creditAccount = creditAccount;
	}
	public String getReversalStatus() {
		return reversalStatus;
	}
	public void setReversalStatus(String reversalStatus) {
		this.reversalStatus = reversalStatus;
	}
	public boolean isReversal() {
		return reversal;
	}
	public void setReversal(boolean reversal) {
		this.reversal = reversal;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getSeqNo() {
		return seqNo;
	}
	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPayeeVpa() {
		return payeeVpa;
	}
	public void setPayeeVpa(String payeeVpa) {
		this.payeeVpa = payeeVpa;
	}
	public String getPayerVpa() {
		return payerVpa;
	}
	public void setPayerVpa(String payerVpa) {
		this.payerVpa = payerVpa;
	}
	public String getCommissionAmount() {
		return commissionAmount;
	}
	public void setCommissionAmount(String commissionAmount) {
		this.commissionAmount = commissionAmount;
	}
	public String getTranType() {
		return tranType;
	}
	public void setTranType(String tranType) {
		this.tranType = tranType;
	}
	public String getCustomerRefId() {
		return customerRefId;
	}
	public void setCustomerRefId(String customerRefId) {
		this.customerRefId = customerRefId;
	}
	public String getDebitBankName() {
		return debitBankName;
	}
	public void setDebitBankName(String debitBankName) {
		this.debitBankName = debitBankName;
	}
	public String getCreditBankName() {
		return creditBankName;
	}
	public void setCreditBankName(String creditBankName) {
		this.creditBankName = creditBankName;
	}
	public String getOthersAccount() {
		return othersAccount;
	}
	public void setOthersAccount(String othersAccount) {
		this.othersAccount = othersAccount;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getPreApproved() {
		return preApproved;
	}
	public void setPreApproved(String preApproved) {
		this.preApproved = preApproved;
	}
	public String getApprovalNum() {
		return approvalNum;
	}
	public void setApprovalNum(String approvalNum) {
		this.approvalNum = approvalNum;
	}
	public String getMccCode() {
		return mccCode;
	}
	public void setMccCode(String mccCode) {
		this.mccCode = mccCode;
	}
	public String getRemitterName() {
		return remitterName;
	}
	public void setRemitterName(String remitterName) {
		this.remitterName = remitterName;
	}
	public String getBeneficiaryName() {
		return beneficiaryName;
	}
	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}
	public String getPayerCode() {
		return payerCode;
	}
	public void setPayerCode(String payerCode) {
		this.payerCode = payerCode;
	}
	public String getPayeeCode() {
		return payeeCode;
	}
	public void setPayeeCode(String payeeCode) {
		this.payeeCode = payeeCode;
	}
	public String getSubType() {
		return subType;
	}
	public void setSubType(String subType) {
		this.subType = subType;
	}
	public String getCreditAccounutType() {
		return creditAccounutType;
	}
	public void setCreditAccounutType(String creditAccounutType) {
		this.creditAccounutType = creditAccounutType;
	}
	public String getDebitAccounutType() {
		return debitAccounutType;
	}
	public void setDebitAccounutType(String debitAccounutType) {
		this.debitAccounutType = debitAccounutType;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getDebitIfsc() {
		return debitIfsc;
	}
	public void setDebitIfsc(String debitIfsc) {
		this.debitIfsc = debitIfsc;
	}
	public String getCreditIfsc() {
		return creditIfsc;
	}
	public void setCreditIfsc(String creditIfsc) {
		this.creditIfsc = creditIfsc;
	}
	public Date getCbsTxndate() {
		return cbsTxndate;
	}
	public void setCbsTxndate(Date cbsTxndate) {
		this.cbsTxndate = cbsTxndate;
	}
	public String getInitMode() {
		return initMode;
	}
	public void setInitMode(String initMode) {
		this.initMode = initMode;
	}
	public String getPurposeCode() {
		return purposeCode;
	}
	public void setPurposeCode(String purposeCode) {
		this.purposeCode = purposeCode;
	}
	public String getOtherMobileno() {
		return otherMobileno;
	}
	public void setOtherMobileno(String otherMobileno) {
		this.otherMobileno = otherMobileno;
	}
	public String getGmtDate() {
		return gmtDate;
	}
	public void setGmtDate(String gmtDate) {
		this.gmtDate = gmtDate;
	}
	public String getPayerAccountType() {
		return payerAccountType;
	}
	public void setPayerAccountType(String payerAccountType) {
		this.payerAccountType = payerAccountType;
	}
	public String getPayeeAccountType() {
		return payeeAccountType;
	}
	public void setPayeeAccountType(String payeeAccountType) {
		this.payeeAccountType = payeeAccountType;
	}
	public String getServerIp() {
		return serverIp;
	}
	public void setServerIp(String serverIp) {
		this.serverIp = serverIp;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getPayerConsentName() {
		return payerConsentName;
	}
	public void setPayerConsentName(String payerConsentName) {
		this.payerConsentName = payerConsentName;
	}
	public String getPayerConsentType() {
		return payerConsentType;
	}
	public void setPayerConsentType(String payerConsentType) {
		this.payerConsentType = payerConsentType;
	}
	public String getPayerConsentValue() {
		return payerConsentValue;
	}
	public void setPayerConsentValue(String payerConsentValue) {
		this.payerConsentValue = payerConsentValue;
	}
	public String getAdjCode() {
		return adjCode;
	}
	public void setAdjCode(String adjCode) {
		this.adjCode = adjCode;
	}
	public String getAdjFlag() {
		return adjFlag;
	}
	public void setAdjFlag(String adjFlag) {
		this.adjFlag = adjFlag;
	}
	public String getBatchId() {
		return batchId;
	}
	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}
	public String getConCode() {
		return conCode;
	}
	public void setConCode(String conCode) {
		this.conCode = conCode;
	}
	public Long getBaseAmount() {
		return baseAmount;
	}
	public void setBaseAmount(Long baseAmount) {
		this.baseAmount = baseAmount;
	}
	public String getBaseCurr() {
		return baseCurr;
	}
	public void setBaseCurr(String baseCurr) {
		this.baseCurr = baseCurr;
	}
	public String getFx() {
		return fx;
	}
	public void setFx(String fx) {
		this.fx = fx;
	}
	public String getMkup() {
		return mkup;
	}
	public void setMkup(String mkup) {
		this.mkup = mkup;
	}
	
}
