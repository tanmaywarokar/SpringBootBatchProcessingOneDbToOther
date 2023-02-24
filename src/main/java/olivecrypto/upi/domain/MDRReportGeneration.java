package olivecrypto.upi.domain;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
@Entity
@Table(name = "tbl_merchant_mdr_summary")
public class MDRReportGeneration implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private long Id;
	@Column(name = "AGGREGATOR_CODE")
	private String aggregatorCode;
	@Column(name = "MERCHANT_CODE")
	private String merchantCode;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE")
	private Date createdDate;
	@Column(name = "TXN_AMOUNT", length = 13)
	private BigDecimal txnAmount;
	
	@Column(name="TXN_COUNT")
	private int txnCount;
	
	@Column(name = "MDR_CHARGES",  length = 10)
	private BigDecimal mdrCharges;
	@Column(name = "COST",  length = 10)
	private BigDecimal cost;
	
	@Column(name="VPA")
	private String vpa;
	
	@Column(name="TXN_DATE")
	private Date txnDate;
	
	@Column(name="CATEGORY")
	private String category;
	
	@Column(name="PAYEE_ACCOUNT")
	private String payeeAccount;
	
	@Column(name="PAYEE_IFSC")
	private String payeeIfsc;
	
	@Column(name="PAYER_ACCOUNT")
	private String payerAccount;
	
	@Column(name="PAYER_IFSC")
	private String payerIfsc;
	
	@Column(name="PAYER_NAME")
	private String payerName;
	
	@Column(name="PAYER_VPA")
	private String payerVpa;
	@Column
	private String download;
    @Column(name="CRN")
    private String crnNumber;
    
    @Column(name="LOB")
    private String lob;
    
    @Column(name="REFID")
    private String refId;
    
    @Column(name="GST")
    private BigDecimal gst;
    
    @Column(name="NetAmount")
    private BigDecimal netAmount;
   //added 28-09 
    @Column(name = "TXN_ID")
    private String txnid;
    
    //added as per  MPR file 
    @Column(name = "ResponseCode")
    private String responseCode;
    
    @Column(name = "DEBIT_NBIN")
    private String debitNbin;
    
    @Column(name = "TXN_STATUS")
    private String transcationStatus;
    
    @Column(name = "MCC_CODE")
    private String mccCode;
    
    @Column(name = "ORDER_ID")
    private String orderId;
    
    public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getDebitNbin() {
		return debitNbin;
	}
	public void setDebitNbin(String debitNbin) {
		this.debitNbin = debitNbin;
	}
	public String getTranscationStatus() {
		return transcationStatus;
	}
	public void setTranscationStatus(String transcationStatus) {
		this.transcationStatus = transcationStatus;
	}
	public String getMccCode() {
		return mccCode;
	}
	public void setMccCode(String mccCode) {
		this.mccCode = mccCode;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getRemakes() {
		return remakes;
	}
	public void setRemakes(String remakes) {
		this.remakes = remakes;
	}
	@Column(name = "REMARKS")
    private String remakes;
    
	public String getPayeeAccount() {
		return payeeAccount;
	}
	public void setPayeeAccount(String payeeAccount) {
		this.payeeAccount = payeeAccount;
	}
	public String getPayeeIfsc() {
		return payeeIfsc;
	}
	public void setPayeeIfsc(String payeeIfsc) {
		this.payeeIfsc = payeeIfsc;
	}
	public String getPayerAccount() {
		return payerAccount;
	}
	public void setPayerAccount(String payerAccount) {
		this.payerAccount = payerAccount;
	}
	public String getPayerIfsc() {
		return payerIfsc;
	}
	public void setPayerIfsc(String payerIfsc) {
		this.payerIfsc = payerIfsc;
	}
	public String getPayerName() {
		return payerName;
	}
	public void setPayerName(String payerName) {
		this.payerName = payerName;
	}
	public String getPayerVpa() {
		return payerVpa;
	}
	public void setPayerVpa(String payerVpa) {
		this.payerVpa = payerVpa;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getVpa() {
		return vpa;
	}
	public void setVpa(String vpa) {
		this.vpa = vpa;
	}
	
	
	public Date getTxnDate() {
		return txnDate;
	}
	public void setTxnDate(Date txnDate) {
		this.txnDate = txnDate;
	}
	public BigDecimal getCost() {
		return cost;
	}
	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public String getAggregatorCode() {
		return aggregatorCode;
	}
	public void setAggregatorCode(String aggregatorCode) {
		this.aggregatorCode = aggregatorCode;
	}
	public String getMerchantCode() {
		return merchantCode;
	}
	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public BigDecimal getTxnAmount() {
		return txnAmount;
	}
	public void setTxnAmount(BigDecimal txnAmount) {
		this.txnAmount = txnAmount;
	}
	public BigDecimal getMdrCharges() {
		return mdrCharges;
	}
	public void setMdrCharges(BigDecimal mdrCharges) {
		this.mdrCharges = mdrCharges;
	}
	public int getTxnCount() {
		return txnCount;
	}
	public void setTxnCount(int txnCount) {
		this.txnCount = txnCount;
	}
	public String getDownload() {
		return download;
	}
	public void setDownload(String download) {
		this.download = download;
	}
	public String getCrnNumber() {
		return crnNumber;
	}
	public void setCrnNumber(String crnNumber) {
		this.crnNumber = crnNumber;
	}
	public String getLob() {
		return lob;
	}
	public void setLob(String lob) {
		this.lob = lob;
	}
	public String getRefId() {
		return refId;
	}
	public void setRefId(String refId) {
		this.refId = refId;
	}
	
	public BigDecimal getNetAmount() {
		return netAmount;
	}
	public void setNetAmount(BigDecimal netAmount) {
		this.netAmount = netAmount;
	}
	public BigDecimal getGst() {
		return gst;
	}
	public void setGst(BigDecimal gst) {
		this.gst = gst;
	}
	public String getTxnid() {
		return txnid;
	}
	public void setTxnid(String txnid) {
		this.txnid = txnid;
	}



}