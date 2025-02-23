package defpackage;

import cris.prs.webservices.dto.PassengerDetailDTO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* renamed from: qx  reason: default package and case insensitive filesystem */
/* compiled from: SoftDTO */
public final class C1358qx implements Serializable {
    private static final long serialVersionUID = 1;
    private int bankId;
    private String cls;
    private String error;
    private ArrayList<PassengerDetailDTO> passengerDetailDTO;
    private String serverId;
    private List<C1311ox> softAccountSummaryDTO;
    private Date timeStamp;

    public int getBankId() {
        return this.bankId;
    }

    public String getCls() {
        return this.cls;
    }

    public String getError() {
        return this.error;
    }

    public ArrayList<PassengerDetailDTO> getPassengerDetailDTO() {
        return this.passengerDetailDTO;
    }

    public String getServerId() {
        return this.serverId;
    }

    public List<C1311ox> getSoftAccountSummaryDTO() {
        return this.softAccountSummaryDTO;
    }

    public Date getTimeStamp() {
        return this.timeStamp;
    }

    public void setBankId(int i) {
        this.bankId = i;
    }

    public void setCls(String str) {
        this.cls = str;
    }

    public void setError(String str) {
        this.error = str;
    }

    public void setPassengerDetailDTO(ArrayList<PassengerDetailDTO> arrayList) {
        this.passengerDetailDTO = arrayList;
    }

    public void setServerId(String str) {
        this.serverId = str;
    }

    public void setSoftAccountSummaryDTO(List<C1311ox> list) {
        this.softAccountSummaryDTO = list;
    }

    public void setTimeStamp(Date date) {
        this.timeStamp = date;
    }

    public String toString() {
        return "SoftDTO [passengerDetailDTO=" + this.passengerDetailDTO + ", error=" + this.error + ", serverId=" + this.serverId + ", timeStamp=" + this.timeStamp + "]";
    }
}
