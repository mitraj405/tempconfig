package defpackage;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* renamed from: Dp  reason: default package and case insensitive filesystem */
/* compiled from: PledgeDTO */
public final class C0486Dp implements Serializable {
    private static final long serialVersionUID = 1;
    private String location;
    private String pnr;
    private Integer psgnCount;
    private Long reservationId;
    private Long userId;

    public String getLocation() {
        return this.location;
    }

    public String getPnr() {
        return this.pnr;
    }

    public Integer getPsgnCount() {
        return this.psgnCount;
    }

    public Long getReservationId() {
        return this.reservationId;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setLocation(String str) {
        this.location = str;
    }

    public void setPnr(String str) {
        this.pnr = str;
    }

    public void setPsgnCount(Integer num) {
        this.psgnCount = num;
    }

    public void setReservationId(Long l) {
        this.reservationId = l;
    }

    public void setUserId(Long l) {
        this.userId = l;
    }

    public String toString() {
        return "PledgeDTO [location=" + this.location + ", pnr=" + this.pnr + ", psgnCount=" + this.psgnCount + "]";
    }
}
