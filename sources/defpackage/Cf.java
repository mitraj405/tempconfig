package defpackage;

import cris.prs.webservices.dto.JourneyDetailDTO;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* renamed from: Cf  reason: default package */
/* compiled from: IndirectTbisResponseDTO */
public final class Cf implements Serializable {
    private static final long serialVersionUID = 1;
    private List<JourneyDetailDTO> alternateJourneyDetailDTO;
    private boolean bookingEnable;
    private String errorMessage;
    private List<String> fromStation;
    private String info;
    private List<JourneyDetailDTO> journeyDetailDTO;
    private List<String> quotaList;
    private String serverId;
    private Date timeStamp;
    private List<String> toStation;
    private List<String> viaStation;

    public List<JourneyDetailDTO> getAlternateJourneyDetailDTO() {
        return this.alternateJourneyDetailDTO;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public List<String> getFromStation() {
        return this.fromStation;
    }

    public String getInfo() {
        return this.info;
    }

    public List<JourneyDetailDTO> getJourneyDetailDTO() {
        return this.journeyDetailDTO;
    }

    public List<String> getQuotaList() {
        return this.quotaList;
    }

    public String getServerId() {
        return this.serverId;
    }

    public Date getTimeStamp() {
        return this.timeStamp;
    }

    public List<String> getToStation() {
        return this.toStation;
    }

    public List<String> getViaStation() {
        return this.viaStation;
    }

    public boolean isBookingEnable() {
        return this.bookingEnable;
    }

    public void setAlternateJourneyDetailDTO(List<JourneyDetailDTO> list) {
        this.alternateJourneyDetailDTO = list;
    }

    public void setBookingEnable(boolean z) {
        this.bookingEnable = z;
    }

    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public void setFromStation(List<String> list) {
        this.fromStation = list;
    }

    public void setInfo(String str) {
        this.info = str;
    }

    public void setJourneyDetailDTO(List<JourneyDetailDTO> list) {
        this.journeyDetailDTO = list;
    }

    public void setQuotaList(List<String> list) {
        this.quotaList = list;
    }

    public void setServerId(String str) {
        this.serverId = str;
    }

    public void setTimeStamp(Date date) {
        this.timeStamp = date;
    }

    public void setToStation(List<String> list) {
        this.toStation = list;
    }

    public void setViaStation(List<String> list) {
        this.viaStation = list;
    }
}
