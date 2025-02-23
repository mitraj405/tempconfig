package cris.prs.webservices.dto;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public final class JourneyDetailDTO implements Serializable {
    private static final long serialVersionUID = 1;
    private String info;
    private Boolean principalChangeflag;
    private Integer totalDuration;
    private Integer totaldistance;
    private List<TrainBtwnStnsDTO> trainBtwnStnsDTO;
    private Integer waitingTime;

    public String getInfo() {
        return this.info;
    }

    public Boolean getPrincipalChangeflag() {
        return this.principalChangeflag;
    }

    public Integer getTotalDuration() {
        return this.totalDuration;
    }

    public Integer getTotaldistance() {
        return this.totaldistance;
    }

    public List<TrainBtwnStnsDTO> getTrainBtwnStnsDTO() {
        return this.trainBtwnStnsDTO;
    }

    public Integer getWaitingTime() {
        return this.waitingTime;
    }

    public void setInfo(String str) {
        this.info = str;
    }

    public void setPrincipalChangeflag(Boolean bool) {
        this.principalChangeflag = bool;
    }

    public void setTotalDuration(Integer num) {
        this.totalDuration = num;
    }

    public void setTotaldistance(Integer num) {
        this.totaldistance = num;
    }

    public void setTrainBtwnStnsDTO(List<TrainBtwnStnsDTO> list) {
        this.trainBtwnStnsDTO = list;
    }

    public void setWaitingTime(Integer num) {
        this.waitingTime = num;
    }
}
