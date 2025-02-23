package cris.prs.webservices.dto;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public final class MaxWLRacCnfDTO {
    public Date jdate;
    public Integer lastYearRunningNumber;
    public String lastYearRunningStatus;

    public Date getJdate() {
        return this.jdate;
    }

    public Integer getLastYearRunningNumber() {
        return this.lastYearRunningNumber;
    }

    public String getLastYearRunningStatus() {
        return this.lastYearRunningStatus;
    }

    public void setJdate(Date date) {
        this.jdate = date;
    }

    public void setLastYearRunningNumber(Integer num) {
        this.lastYearRunningNumber = num;
    }

    public void setLastYearRunningStatus(String str) {
        this.lastYearRunningStatus = str;
    }

    public String toString() {
        return "MaxWLRacCnfDTO [lastYearRunningNumber=" + this.lastYearRunningNumber + ", lastYearRunningStatus=" + this.lastYearRunningStatus + ", jdate=" + this.jdate + "]";
    }
}
