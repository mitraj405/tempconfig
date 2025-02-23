package cris.prs.webservices.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* compiled from: FevJourneyListDTO */
public final class b implements Serializable {
    private static final long serialVersionUID = 1;
    int displayCount = 0;
    private String error;
    private ArrayList<a> fevJourneyLists = new ArrayList<>();
    private String serverId;
    private Date timeStamp;

    /* compiled from: FevJourneyListDTO */
    public static class a implements Serializable {
        private static final long serialVersionUID = 1;
        private String cls;
        private String fromStnCode;
        private Long id;
        private String quota;
        private Boolean recent = Boolean.FALSE;
        private String toStnCode;
        private String trainNumber;

        public String getCls() {
            return this.cls;
        }

        public String getFromStnCode() {
            return this.fromStnCode;
        }

        public Long getId() {
            return this.id;
        }

        public String getQuota() {
            return this.quota;
        }

        public Boolean getRecent() {
            return this.recent;
        }

        public String getToStnCode() {
            return this.toStnCode;
        }

        public String getTrainNumber() {
            return this.trainNumber;
        }

        public void setCls(String str) {
            this.cls = str;
        }

        public void setFromStnCode(String str) {
            this.fromStnCode = str;
        }

        public void setId(Long l) {
            this.id = l;
        }

        public void setQuota(String str) {
            this.quota = str;
        }

        public void setRecent(Boolean bool) {
            this.recent = bool;
        }

        public void setToStnCode(String str) {
            this.toStnCode = str;
        }

        public void setTrainNumber(String str) {
            this.trainNumber = str;
        }

        public String toString() {
            return "FevJourneyList [trainNumber=" + this.trainNumber + ", fromStnCode=" + this.fromStnCode + ", toStnCode=" + this.toStnCode + ", cls=" + this.cls + ", quota=" + this.quota + ", id=" + this.id + ", recent=" + this.recent + "]";
        }
    }

    public int getDisplayCount() {
        return this.displayCount;
    }

    public String getError() {
        return this.error;
    }

    public ArrayList<a> getFevJourneyLists() {
        return this.fevJourneyLists;
    }

    public String getServerId() {
        return this.serverId;
    }

    public Date getTimeStamp() {
        return this.timeStamp;
    }

    public void setDisplayCount(int i) {
        this.displayCount = i;
    }

    public void setError(String str) {
        this.error = str;
    }

    public void setFevJourneyLists(ArrayList<a> arrayList) {
        this.fevJourneyLists = arrayList;
    }

    public void setServerId(String str) {
        this.serverId = str;
    }

    public void setTimeStamp(Date date) {
        this.timeStamp = date;
    }

    public String toString() {
        return "FevJourneyListDTO [fevJourneyLists=" + this.fevJourneyLists + ", error=" + this.error + ", serverId=" + this.serverId + ", timeStamp=" + this.timeStamp + "]";
    }
}
