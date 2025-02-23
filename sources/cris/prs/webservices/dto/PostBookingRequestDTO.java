package cris.prs.webservices.dto;

import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public final class PostBookingRequestDTO implements Serializable {
    private static final long serialVersionUID = 1;
    private Date bookingDate;
    private Integer dmrcDestStnIndex;
    private Integer dmrcSrcStnIndex;
    private String error;
    private Boolean inProcess;
    private String jDate;
    private C1303ol metroPsgnQRdata;
    private String passengerOptedServiceToken;
    private String passengerOptedServiceValue;
    private PnrEnquiryResponseDTO pnrEnquiryResponseDTO;
    private String pnrNumber;
    private Xp postBookingServices;
    private Integer prsAmount;
    private String reconStatus = null;
    private Integer resPaymentType;
    private Integer segregateBookingEnquiry;
    private Double serviceCharge;
    private Double serviceChargeGST;
    private String serviceId;
    private Integer serviceStatus;
    private Double totalPayableAmount;
    private Integer transactionStatus;
    private String txnId;
    private Integer webserviceCallingSource;

    public Date getBookingDate() {
        return this.bookingDate;
    }

    public Integer getDmrcDestStnIndex() {
        return this.dmrcDestStnIndex;
    }

    public Integer getDmrcSrcStnIndex() {
        return this.dmrcSrcStnIndex;
    }

    public String getError() {
        return this.error;
    }

    public Boolean getInProcess() {
        return this.inProcess;
    }

    public C1303ol getMetroPsgnQRdata() {
        return this.metroPsgnQRdata;
    }

    public String getPassengerOptedServiceToken() {
        return this.passengerOptedServiceToken;
    }

    public String getPassengerOptedServiceValue() {
        return this.passengerOptedServiceValue;
    }

    public PnrEnquiryResponseDTO getPnrEnquiryResponseDTO() {
        return this.pnrEnquiryResponseDTO;
    }

    public String getPnrNumber() {
        return this.pnrNumber;
    }

    public Xp getPostBookingServices() {
        return this.postBookingServices;
    }

    public Integer getPrsAmount() {
        return this.prsAmount;
    }

    public String getReconStatus() {
        return this.reconStatus;
    }

    public Integer getResPaymentType() {
        return this.resPaymentType;
    }

    public Integer getSegregateBookingEnquiry() {
        return this.segregateBookingEnquiry;
    }

    public Double getServiceCharge() {
        return this.serviceCharge;
    }

    public Double getServiceChargeGST() {
        return this.serviceChargeGST;
    }

    public String getServiceId() {
        return this.serviceId;
    }

    public Integer getServiceStatus() {
        return this.serviceStatus;
    }

    public Double getTotalPayableAmount() {
        return this.totalPayableAmount;
    }

    public Integer getTransactionStatus() {
        return this.transactionStatus;
    }

    public String getTxnId() {
        return this.txnId;
    }

    public Integer getWebserviceCallingSource() {
        return this.webserviceCallingSource;
    }

    public String getjDate() {
        return this.jDate;
    }

    public void setBookingDate(Date date) {
        this.bookingDate = date;
    }

    public void setDmrcDestStnIndex(Integer num) {
        this.dmrcDestStnIndex = num;
    }

    public void setDmrcSrcStnIndex(Integer num) {
        this.dmrcSrcStnIndex = num;
    }

    public void setError(String str) {
        this.error = str;
    }

    public void setInProcess(Boolean bool) {
        this.inProcess = bool;
    }

    public void setMetroPsgnQRdata(C1303ol olVar) {
        this.metroPsgnQRdata = olVar;
    }

    public void setPassengerOptedServiceToken(String str) {
        this.passengerOptedServiceToken = str;
    }

    public void setPassengerOptedServiceValue(String str) {
        this.passengerOptedServiceValue = str;
    }

    public void setPnrEnquiryResponseDTO(PnrEnquiryResponseDTO pnrEnquiryResponseDTO2) {
        this.pnrEnquiryResponseDTO = pnrEnquiryResponseDTO2;
    }

    public void setPnrNumber(String str) {
        this.pnrNumber = str;
    }

    public void setPostBookingServices(Xp xp) {
        this.postBookingServices = xp;
    }

    public void setPrsAmount(Integer num) {
        this.prsAmount = num;
    }

    public void setReconStatus(String str) {
        this.reconStatus = str;
    }

    public void setResPaymentType(Integer num) {
        this.resPaymentType = num;
    }

    public void setSegregateBookingEnquiry(Integer num) {
        this.segregateBookingEnquiry = num;
    }

    public void setServiceCharge(Double d) {
        this.serviceCharge = d;
    }

    public void setServiceChargeGST(Double d) {
        this.serviceChargeGST = d;
    }

    public void setServiceId(String str) {
        this.serviceId = str;
    }

    public void setServiceStatus(Integer num) {
        this.serviceStatus = num;
    }

    public void setTotalPayableAmount(Double d) {
        this.totalPayableAmount = d;
    }

    public void setTransactionStatus(Integer num) {
        this.transactionStatus = num;
    }

    public void setTxnId(String str) {
        this.txnId = str;
    }

    public void setWebserviceCallingSource(Integer num) {
        this.webserviceCallingSource = num;
    }

    public void setjDate(String str) {
        this.jDate = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PostBookingRequestDTO [postBookingServices=");
        sb.append(this.postBookingServices);
        sb.append(", pnrNumber=");
        sb.append(this.pnrNumber);
        sb.append(", txnId=");
        sb.append(this.txnId);
        sb.append(", serviceId=");
        sb.append(this.serviceId);
        sb.append(", pnrEnquiryResponseDTO=");
        sb.append(this.pnrEnquiryResponseDTO);
        sb.append(", prsAmount=");
        sb.append(this.prsAmount);
        sb.append(", totalPayableAmount=");
        sb.append(this.totalPayableAmount);
        sb.append(", passengerOptedServiceToken=");
        sb.append(this.passengerOptedServiceToken);
        sb.append(", passengerOptedServiceValue=");
        sb.append(this.passengerOptedServiceValue);
        sb.append(", bookingDate=");
        sb.append(this.bookingDate);
        sb.append(", inProcess=");
        sb.append(this.inProcess);
        sb.append(", transactionStatus=");
        sb.append(this.transactionStatus);
        sb.append(", serviceStatus=");
        sb.append(this.serviceStatus);
        sb.append(", webserviceCallingSource=");
        sb.append(this.webserviceCallingSource);
        sb.append(", resPaymentType=");
        sb.append(this.resPaymentType);
        sb.append(", reconStatus=");
        sb.append(this.reconStatus);
        sb.append(", dmrcSrcStnIndex=");
        sb.append(this.dmrcSrcStnIndex);
        sb.append(", dmrcDestStnIndex=");
        sb.append(this.dmrcDestStnIndex);
        sb.append(", jDate=");
        sb.append(this.jDate);
        sb.append(", serviceCharge=");
        sb.append(this.serviceCharge);
        sb.append(", serviceChargeGST=");
        sb.append(this.serviceChargeGST);
        sb.append(", metroPsgnQRdata=");
        sb.append(this.metroPsgnQRdata);
        sb.append(", SegregateBookingEnquiry=");
        sb.append(this.dmrcDestStnIndex);
        sb.append(", jDate=");
        return C0709Uj.j(sb, this.jDate, "]");
    }
}
