package defpackage;

import cris.prs.webservices.dto.MaxWLRacCnfDTO;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* renamed from: JD  reason: default package and case insensitive filesystem */
/* compiled from: WlPredictionOutputDTO */
public final class C0549JD {
    public String errorMessage;
    public ArrayList<MaxWLRacCnfDTO> maxWlRacCnfList;
    public String passengerChartStatus;
    public Double probability;

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public ArrayList<MaxWLRacCnfDTO> getMaxRacCnfList() {
        return this.maxWlRacCnfList;
    }

    public String getPassengerChartStatus() {
        return this.passengerChartStatus;
    }

    public Double getProbability() {
        return this.probability;
    }

    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public void setMaxRacCnfList(ArrayList<MaxWLRacCnfDTO> arrayList) {
        this.maxWlRacCnfList = arrayList;
    }

    public void setPassengerChartStatus(String str) {
        this.passengerChartStatus = str;
    }

    public void setProbability(Double d) {
        this.probability = d;
    }

    public String toString() {
        return "WlPredictionOutputDTO [errorMessage=" + this.errorMessage + ", maxRacCnfList=" + this.maxWlRacCnfList + ", passengerChartStatus=" + this.passengerChartStatus + ", probability=" + this.probability + "]";
    }
}
