package cris.prs.webservices.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public final class TrainBtwnStnsRespDto implements Serializable {
    private static final long serialVersionUID = 1;
    private String accountLink;
    private boolean alternateEnquiryFlag;
    private List<TrainBtwnStnsDTO> alternateTrainBtwnStnsList;
    private E4 captchaDto;
    private Boolean captchaReq;
    private String errorMessage;
    private Integer maxNoOfVikalpTrains;
    private Boolean oneStopJourny;
    private List<String> quotaList;
    private String sectorName;
    private String serverId;
    private Boolean serveyFlag;
    private Date timeStamp;
    private List<TrainBtwnStnsDTO> trainBtwnStnsList;
    private Boolean vikalpInSpecialTrains;
    private boolean vikalpInSpecialTrainsAccomFlag;
    private String vikalpSpecialTrainsMsg;

    public String getAccountLink() {
        return this.accountLink;
    }

    public List<TrainBtwnStnsDTO> getAlternateTrainBtwnStnsList() {
        return this.alternateTrainBtwnStnsList;
    }

    public E4 getCaptchaDto() {
        return this.captchaDto;
    }

    public Boolean getCaptchaReq() {
        return this.captchaReq;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public Integer getMaxNoOfVikalpTrains() {
        return this.maxNoOfVikalpTrains;
    }

    public Boolean getOneStopJourny() {
        return this.oneStopJourny;
    }

    public List<String> getQuotaList() {
        return this.quotaList;
    }

    public String getSectorName() {
        return this.sectorName;
    }

    public String getServerId() {
        return this.serverId;
    }

    public Boolean getServeyFlag() {
        return this.serveyFlag;
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

    public boolean isAlternateEnquiryFlag() {
        return this.alternateEnquiryFlag;
    }

    public void setAccountLink(String str) {
        this.accountLink = str;
    }

    public void setAlternateEnquiryFlag(boolean z) {
        this.alternateEnquiryFlag = z;
    }

    public void setAlternateTrainBtwnStnsList(List<TrainBtwnStnsDTO> list) {
        this.alternateTrainBtwnStnsList = list;
    }

    public void setCaptchaDto(E4 e4) {
        this.captchaDto = e4;
    }

    public void setCaptchaReq(Boolean bool) {
        this.captchaReq = bool;
    }

    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public void setMaxNoOfVikalpTrains(Integer num) {
        this.maxNoOfVikalpTrains = num;
    }

    public void setOneStopJourny(Boolean bool) {
        this.oneStopJourny = bool;
    }

    public void setQuotaList(List<String> list) {
        this.quotaList = list;
    }

    public void setSectorName(String str) {
        this.sectorName = str;
    }

    public void setServerId(String str) {
        this.serverId = str;
    }

    public void setServeyFlag(Boolean bool) {
        this.serveyFlag = bool;
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
}
