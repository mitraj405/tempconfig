package defpackage;

import java.io.Serializable;

/* renamed from: ge  reason: default package and case insensitive filesystem */
/* compiled from: GSTDetailsDTO */
public final class C1133ge implements Serializable {
    private static final long serialVersionUID = 5320963601284424206L;
    private String area;
    private String city;
    private boolean error;
    private String flat;
    private C0541Ie gstApiResponseDTO;
    private String gstIn;
    private String nameOnGst;
    private String pin;
    private String state;
    private String street;
    private Integer transactionCode;
    private String transactionDate;
    private Long transactionId;
    private String transactionTypeRcvr;

    public String getArea() {
        return this.area;
    }

    public String getCity() {
        return this.city;
    }

    public String getFlat() {
        return this.flat;
    }

    public C0541Ie getGstApiResponseDTO() {
        return this.gstApiResponseDTO;
    }

    public String getGstIn() {
        return this.gstIn;
    }

    public String getNameOnGst() {
        return this.nameOnGst;
    }

    public String getPin() {
        return this.pin;
    }

    public String getState() {
        return this.state;
    }

    public String getStreet() {
        return this.street;
    }

    public Integer getTransactionCode() {
        return this.transactionCode;
    }

    public String getTransactionDate() {
        return this.transactionDate;
    }

    public Long getTransactionId() {
        return this.transactionId;
    }

    public String getTransactionTypeRcvr() {
        return this.transactionTypeRcvr;
    }

    public boolean isError() {
        return this.error;
    }

    public void setArea(String str) {
        this.area = str;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public void setError(boolean z) {
        this.error = z;
    }

    public void setFlat(String str) {
        this.flat = str;
    }

    public void setGstApiResponseDTO(C0541Ie ie) {
        this.gstApiResponseDTO = ie;
    }

    public void setGstIn(String str) {
        this.gstIn = str;
    }

    public void setNameOnGst(String str) {
        this.nameOnGst = str;
    }

    public void setPin(String str) {
        this.pin = str;
    }

    public void setState(String str) {
        this.state = str;
    }

    public void setStreet(String str) {
        this.street = str;
    }

    public void setTransactionCode(Integer num) {
        this.transactionCode = num;
    }

    public void setTransactionDate(String str) {
        this.transactionDate = str;
    }

    public void setTransactionId(Long l) {
        this.transactionId = l;
    }

    public void setTransactionTypeRcvr(String str) {
        this.transactionTypeRcvr = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GSTDetailsDTO [gstIn=");
        sb.append(this.gstIn);
        sb.append(", nameOnGst=");
        sb.append(this.nameOnGst);
        sb.append(", flat=");
        sb.append(this.flat);
        sb.append(", street=");
        sb.append(this.street);
        sb.append(", area=");
        sb.append(this.area);
        sb.append(", pin=");
        sb.append(this.pin);
        sb.append(", state=");
        sb.append(this.state);
        sb.append(", city=");
        sb.append(this.city);
        sb.append(", error=");
        sb.append(this.error);
        sb.append(", transactionId=");
        sb.append(this.transactionId);
        sb.append(", transactionTypeRcvr=");
        sb.append(this.transactionTypeRcvr);
        sb.append(", transactionCode=");
        sb.append(this.transactionCode);
        sb.append(", transactionDate=");
        return C0709Uj.j(sb, this.transactionDate, "]");
    }
}
