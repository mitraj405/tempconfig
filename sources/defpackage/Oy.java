package defpackage;

import cris.prs.webservices.dto.InformationMessageDTO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* renamed from: Oy  reason: default package */
/* compiled from: SupportedAppVersionDTO */
public final class Oy implements Serializable {
    private static final long serialVersionUID = 1;
    private String appURL;
    private ArrayList<InformationMessageDTO> disableRange;
    private String error;
    private Boolean forceUpdate;
    private ArrayList<String> infoMsg;
    private C0824ch juspayLoadDTO;
    private String serverId;
    private Date timeStamp;
    private Boolean updateRequired;

    public String getAppURL() {
        return this.appURL;
    }

    public ArrayList<InformationMessageDTO> getDisableRange() {
        return this.disableRange;
    }

    public String getError() {
        return this.error;
    }

    public Boolean getForceUpdate() {
        return this.forceUpdate;
    }

    public ArrayList<String> getInfoMsg() {
        return this.infoMsg;
    }

    public C0824ch getJuspayLoadDTO() {
        return this.juspayLoadDTO;
    }

    public String getServerId() {
        return this.serverId;
    }

    public Date getTimeStamp() {
        return this.timeStamp;
    }

    public Boolean getUpdateRequired() {
        return this.updateRequired;
    }

    public void setAppURL(String str) {
        this.appURL = str;
    }

    public void setDisableRange(ArrayList<InformationMessageDTO> arrayList) {
        this.disableRange = arrayList;
    }

    public void setError(String str) {
        this.error = str;
    }

    public void setForceUpdate(Boolean bool) {
        this.forceUpdate = bool;
    }

    public void setInfoMsg(ArrayList<String> arrayList) {
        this.infoMsg = arrayList;
    }

    public void setJuspayLoadDTO(C0824ch chVar) {
        this.juspayLoadDTO = chVar;
    }

    public void setServerId(String str) {
        this.serverId = str;
    }

    public void setTimeStamp(Date date) {
        this.timeStamp = date;
    }

    public void setUpdateRequired(Boolean bool) {
        this.updateRequired = bool;
    }

    public String toString() {
        return "SupportedAppVersionDTO [error=" + this.error + ", updateRequired=" + this.updateRequired + ", forceUpdate=" + this.forceUpdate + ", appURL=" + this.appURL + ", infoMsg=" + this.infoMsg + ", disableRange=" + this.disableRange + ", serverId=" + this.serverId + ", timeStamp=" + this.timeStamp + ", juspayLoadDTO=" + this.juspayLoadDTO + "]";
    }
}
