package defpackage;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* renamed from: Wx  reason: default package and case insensitive filesystem */
/* compiled from: StationDataDTO */
public final class C0742Wx implements Serializable {
    private static final long serialVersionUID = 1;
    private String ec;
    private String en;
    private String hc;
    private String hi;
    private Boolean ps;
    private String sc;
    private String se;
    private String sh;
    private String tg;

    public String getEc() {
        return this.ec;
    }

    public String getEn() {
        return this.en;
    }

    public String getHc() {
        return this.hc;
    }

    public String getHi() {
        return this.hi;
    }

    public Boolean getPs() {
        return this.ps;
    }

    public String getSc() {
        return this.sc;
    }

    public String getSe() {
        return this.se;
    }

    public String getSh() {
        return this.sh;
    }

    public String getTg() {
        return this.tg;
    }

    public void setEc(String str) {
        this.ec = str;
    }

    public void setEn(String str) {
        this.en = str;
    }

    public void setHc(String str) {
        this.hc = str;
    }

    public void setHi(String str) {
        this.hi = str;
    }

    public void setPs(Boolean bool) {
        this.ps = bool;
    }

    public void setSc(String str) {
        this.sc = str;
    }

    public void setSe(String str) {
        this.se = str;
    }

    public void setSh(String str) {
        this.sh = str;
    }

    public void setTg(String str) {
        this.tg = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StationDataDTO [sc=");
        sb.append(this.sc);
        sb.append(", en=");
        sb.append(this.en);
        sb.append(", hi=");
        sb.append(this.hi);
        sb.append(", ps=");
        sb.append(this.ps);
        sb.append(", ec=");
        sb.append(this.ec);
        sb.append(", hc=");
        sb.append(this.hc);
        sb.append(", se=");
        sb.append(this.se);
        sb.append(", sh=");
        sb.append(this.sh);
        sb.append(", tg=");
        return C0709Uj.j(sb, this.tg, "]");
    }
}
