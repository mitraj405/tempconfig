package defpackage;

import cris.prs.webservices.dto.TrainBtwnStnsDTO;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/* renamed from: xA  reason: default package and case insensitive filesystem */
/* compiled from: TrainBtwnStnsRespDto */
public final class C1475xA implements Serializable {
    private static final long serialVersionUID = 1;
    private List<TrainBtwnStnsDTO> alternateTrainBtwnStnsList;
    private String errorMessage;
    private Integer maxNoOfVikalpTrains;
    private List<String> quotaList;
    private String serverId;
    private Date timeStamp;
    private List<TrainBtwnStnsDTO> trainBtwnStnsList;
    private Boolean vikalpInSpecialTrains;
    private boolean vikalpInSpecialTrainsAccomFlag;
    private String vikalpSpecialTrainsMsg;

    public List<TrainBtwnStnsDTO> getAlternateTrainBtwnStnsList() {
        return this.alternateTrainBtwnStnsList;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public Integer getMaxNoOfVikalpTrains() {
        return this.maxNoOfVikalpTrains;
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

    public List<TrainBtwnStnsDTO> getTrainBtwnStnsList() {
        return this.trainBtwnStnsList;
    }

    public Boolean getVikalpInSpecialTrains() {
        return this.vikalpInSpecialTrains;
    }

    public boolean getVikalpInSpecialTrainsAccomFlag() {
        return this.vikalpInSpecialTrainsAccomFlag;
    }

    public String getVikalpSpecialTrainsMsg() {
        return this.vikalpSpecialTrainsMsg;
    }

    public void setAlternateTrainBtwnStnsList(List<TrainBtwnStnsDTO> list) {
        this.alternateTrainBtwnStnsList = list;
    }

    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public void setMaxNoOfVikalpTrains(Integer num) {
        this.maxNoOfVikalpTrains = num;
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

    public void setTrainBtwnStnsList(List<TrainBtwnStnsDTO> list) {
        this.trainBtwnStnsList = list;
    }

    public void setVikalpInSpecialTrains(Boolean bool) {
        this.vikalpInSpecialTrains = bool;
    }

    public void setVikalpInSpecialTrainsAccomFlag(boolean z) {
        this.vikalpInSpecialTrainsAccomFlag = z;
    }

    public void setVikalpSpecialTrainsMsg(String str) {
        this.vikalpSpecialTrainsMsg = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("TrainBtwnStnsRespDto [trainBtwnStnsList=");
        sb.append(this.trainBtwnStnsList);
        sb.append(", alternateTrainBtwnStnsList=");
        sb.append(this.alternateTrainBtwnStnsList);
        sb.append(", quotaList=");
        sb.append(this.quotaList);
        sb.append(", errorMessage=");
        sb.append(this.errorMessage);
        sb.append(", maxNoOfVikalpTrains=");
        sb.append(this.maxNoOfVikalpTrains);
        sb.append(", vikalpInSpecialTrains=");
        sb.append(this.vikalpInSpecialTrains);
        sb.append(", vikalpSpecialTrainsMsg=");
        sb.append(this.vikalpSpecialTrainsMsg);
        sb.append(", serverId=");
        sb.append(this.serverId);
        sb.append(", timeStamp=");
        sb.append(this.timeStamp);
        sb.append(", vikalpInSpecialTrainsAccomFlag=");
        return xx.G(sb, this.vikalpInSpecialTrainsAccomFlag, "]");
    }
}
