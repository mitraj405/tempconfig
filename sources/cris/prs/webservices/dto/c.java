package cris.prs.webservices.dto;

import java.io.Serializable;
import java.util.List;

/* compiled from: VikalpDTO */
public final class c implements Serializable {
    private static final long serialVersionUID = 1;
    private String boarding;
    private String from;
    private String journeyDate;
    private String jrnyClass;
    List<PassengerDetailDTO> psgnDtlListvikalp;
    private String to;
    private String trainNo;

    public String getBoarding() {
        return this.boarding;
    }

    public String getFrom() {
        return this.from;
    }

    public String getJourneyDate() {
        return this.journeyDate;
    }

    public String getJrnyClass() {
        return this.jrnyClass;
    }

    public List<PassengerDetailDTO> getPsgnDtlListvikalp() {
        return this.psgnDtlListvikalp;
    }

    public String getTo() {
        return this.to;
    }

    public String getTrainNo() {
        return this.trainNo;
    }

    public void setBoarding(String str) {
        this.boarding = str;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public void setJourneyDate(String str) {
        this.journeyDate = str;
    }

    public void setJrnyClass(String str) {
        this.jrnyClass = str;
    }

    public void setPsgnDtlListvikalp(List<PassengerDetailDTO> list) {
        this.psgnDtlListvikalp = list;
    }

    public void setTo(String str) {
        this.to = str;
    }

    public void setTrainNo(String str) {
        this.trainNo = str;
    }

    public String toString() {
        return "VikalpDTO [trainNo=" + this.trainNo + ", from=" + this.from + ", to=" + this.to + ", journeyDate=" + this.journeyDate + ", boarding=" + this.boarding + ", jrnyClass=" + this.jrnyClass + ", psgnDtlListvikalp=" + this.psgnDtlListvikalp + " ]";
    }
}
