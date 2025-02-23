package cris.prs.webservices.dto;

import java.io.Serializable;
import java.util.List;

public final class InformationMessageDTO implements Serializable {
    private static final long serialVersionUID = 1;
    private String acceptButton;
    private List<Object> adsDTO;
    private String message;
    private String paramName;
    private Boolean popup;
    private String rejectButton;
    private String url;

    public InformationMessageDTO(String str, String str2, Boolean bool) {
        this.message = str2;
        this.popup = bool;
        this.paramName = str;
    }

    public String getAcceptButton() {
        return this.acceptButton;
    }

    public List<Object> getAdsDTO() {
        return this.adsDTO;
    }

    public String getMessage() {
        return this.message;
    }

    public String getParamName() {
        return this.paramName;
    }

    public Boolean getPopup() {
        return this.popup;
    }

    public String getRejectButton() {
        return this.rejectButton;
    }

    public String getUrl() {
        return this.url;
    }

    public void setAcceptButton(String str) {
        this.acceptButton = str;
    }

    public void setAdsDTO(List<Object> list) {
        this.adsDTO = list;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setParamName(String str) {
        this.paramName = str;
    }

    public void setPopup(Boolean bool) {
        this.popup = bool;
    }

    public void setRejectButton(String str) {
        this.rejectButton = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("InformationMessageDTO [message=");
        sb.append(this.message);
        sb.append(", popup=");
        sb.append(this.popup);
        sb.append(", paramName=");
        return C0709Uj.j(sb, this.paramName, "]");
    }

    public InformationMessageDTO(String str, String str2, String str3, Boolean bool) {
        this.message = str2;
        this.popup = bool;
        this.paramName = str;
        this.url = str3;
    }

    public InformationMessageDTO(String str, String str2, Boolean bool, String str3, String str4) {
        this.message = str2;
        this.popup = bool;
        this.paramName = str;
        this.acceptButton = str3;
        this.rejectButton = str4;
    }

    public InformationMessageDTO(String str, List<Object> list) {
        this.paramName = str;
        this.adsDTO = list;
    }

    public InformationMessageDTO() {
    }
}
