package defpackage;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* renamed from: Zb  reason: default package and case insensitive filesystem */
/* compiled from: FetchFareRequestDTO */
public final class C0766Zb implements Serializable {
    private static final long serialVersionUID = 1;
    public Integer destStnCode;
    public Integer fromStnCode;
    public String jDate;
    private String pnrNumber;
    public Xp postBookingService;
    public Integer psgnCount;
    private String txnId;

    public Integer getDestStnCode() {
        return this.destStnCode;
    }

    public Integer getFromStnCode() {
        return this.fromStnCode;
    }

    public String getPnrNumber() {
        return this.pnrNumber;
    }

    public Xp getPostBookingService() {
        return this.postBookingService;
    }

    public Integer getPsgnCount() {
        return this.psgnCount;
    }

    public String getTxnId() {
        return this.txnId;
    }

    public String getjDate() {
        return this.jDate;
    }

    public void setDestStnCode(Integer num) {
        this.destStnCode = num;
    }

    public void setFromStnCode(Integer num) {
        this.fromStnCode = num;
    }

    public void setPnrNumber(String str) {
        this.pnrNumber = str;
    }

    public void setPostBookingService(Xp xp) {
        this.postBookingService = xp;
    }

    public void setPsgnCount(Integer num) {
        this.psgnCount = num;
    }

    public void setTxnId(String str) {
        this.txnId = str;
    }

    public void setjDate(String str) {
        this.jDate = str;
    }

    public String toString() {
        return "FetchFareRequestDTO [fromStnCode=" + this.fromStnCode + ", destStnCode=" + this.destStnCode + ", jDate=" + this.jDate + ", psgnCount=" + this.psgnCount + "]";
    }
}
