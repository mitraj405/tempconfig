package defpackage;

import cris.prs.webservices.dto.AvlFareResponseDTO;
import cris.prs.webservices.dto.BookingResponseDTO;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* renamed from: dm  reason: default package and case insensitive filesystem */
/* compiled from: MultiLapBookingResponseDTO */
public final class C1074dm implements Serializable {
    private static final long serialVersionUID = 1;
    private AvlFareResponseDTO avlFareResponseDTO;
    private C1100f2 avlResponseDTO;
    private boolean bankErrorFlag;
    private String bankName;
    private String bankNameDis;
    private String bankPaymentMode;
    private Date bookingDate;
    private List<BookingResponseDTO> bookingResponseDTO;
    private String errorMessage;
    private String qrCodeText;
    private Integer retryAfterMili;
    private boolean retryBooking;
    private String serverId;
    private Date timeStamp;
    private Double totalCollectibleAmount;
    private Long transactionId;
    private JB userDetail;

    public AvlFareResponseDTO getAvlFareResponseDTO() {
        return this.avlFareResponseDTO;
    }

    public C1100f2 getAvlResponseDTO() {
        return this.avlResponseDTO;
    }

    public String getBankName() {
        return this.bankName;
    }

    public String getBankNameDis() {
        return this.bankNameDis;
    }

    public String getBankPaymentMode() {
        return this.bankPaymentMode;
    }

    public Date getBookingDate() {
        return this.bookingDate;
    }

    public List<BookingResponseDTO> getBookingResponseDTO() {
        return this.bookingResponseDTO;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public String getQrCodeText() {
        return this.qrCodeText;
    }

    public Integer getRetryAfterMili() {
        return this.retryAfterMili;
    }

    public String getServerId() {
        return this.serverId;
    }

    public Date getTimeStamp() {
        return this.timeStamp;
    }

    public Double getTotalCollectibleAmount() {
        return this.totalCollectibleAmount;
    }

    public Long getTransactionId() {
        return this.transactionId;
    }

    public JB getUserDetail() {
        return this.userDetail;
    }

    public boolean isBankErrorFlag() {
        return this.bankErrorFlag;
    }

    public boolean isRetryBooking() {
        return this.retryBooking;
    }

    public void setAvlFareResponseDTO(AvlFareResponseDTO avlFareResponseDTO2) {
        this.avlFareResponseDTO = avlFareResponseDTO2;
    }

    public void setAvlResponseDTO(C1100f2 f2Var) {
        this.avlResponseDTO = f2Var;
    }

    public void setBankErrorFlag(boolean z) {
        this.bankErrorFlag = z;
    }

    public void setBankName(String str) {
        this.bankName = str;
    }

    public void setBankNameDis(String str) {
        this.bankNameDis = str;
    }

    public void setBankPaymentMode(String str) {
        this.bankPaymentMode = str;
    }

    public void setBookingDate(Date date) {
        this.bookingDate = date;
    }

    public void setBookingResponseDTO(List<BookingResponseDTO> list) {
        this.bookingResponseDTO = list;
    }

    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public void setQrCodeText(String str) {
        this.qrCodeText = str;
    }

    public void setRetryAfterMili(Integer num) {
        this.retryAfterMili = num;
    }

    public void setRetryBooking(boolean z) {
        this.retryBooking = z;
    }

    public void setServerId(String str) {
        this.serverId = str;
    }

    public void setTimeStamp(Date date) {
        this.timeStamp = date;
    }

    public void setTotalCollectibleAmount(Double d) {
        this.totalCollectibleAmount = d;
    }

    public void setTransactionId(Long l) {
        this.transactionId = l;
    }

    public void setUserDetail(JB jb) {
        this.userDetail = jb;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("MultiLapBookingResponseDTO [bookingResponseDTO=");
        sb.append(this.bookingResponseDTO);
        sb.append(", userDetail=");
        sb.append(this.userDetail);
        sb.append(", avlResponseDTO=");
        sb.append(this.avlResponseDTO);
        sb.append(", qrCodeText=");
        sb.append(this.qrCodeText);
        sb.append(", transactionId=");
        sb.append(this.transactionId);
        sb.append(", bankName=");
        sb.append(this.bankName);
        sb.append(", bankNameDis=");
        sb.append(this.bankNameDis);
        sb.append(", bankPaymentMode=");
        sb.append(this.bankPaymentMode);
        sb.append(", bookingDate=");
        sb.append(this.bookingDate);
        sb.append(", totalCollectibleAmount=");
        sb.append(this.totalCollectibleAmount);
        sb.append(", retryBooking=");
        sb.append(this.retryBooking);
        sb.append(", errorMessage=");
        return C0709Uj.j(sb, this.errorMessage, "]");
    }
}
