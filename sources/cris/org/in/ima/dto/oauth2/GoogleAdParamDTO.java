package cris.org.in.ima.dto.oauth2;

import java.io.Serializable;

public final class GoogleAdParamDTO implements Serializable {
    private String age;
    private String arrivalDate;
    private String departureDate;
    private String destination;
    private String gender;
    private String jClass;
    private String mealType;
    private String quata;
    private String source;
    private String status;
    private String ticketStatus;
    private String trainType;

    public String getAge() {
        return this.age;
    }

    public String getArrivalDate() {
        return this.arrivalDate;
    }

    public String getDepartureDate() {
        return this.departureDate;
    }

    public String getDestination() {
        return this.destination;
    }

    public String getGender() {
        return this.gender;
    }

    public String getMealType() {
        return this.mealType;
    }

    public String getQuata() {
        return this.quata;
    }

    public String getSource() {
        return this.source;
    }

    public String getStatus() {
        return this.status;
    }

    public String getTicketStatus() {
        return this.ticketStatus;
    }

    public String getTrainType() {
        return this.trainType;
    }

    public String getjClass() {
        return this.jClass;
    }

    public void setAge(String str) {
        this.age = str;
    }

    public void setArrivalDate(String str) {
        this.arrivalDate = str;
    }

    public void setDepartureDate(String str) {
        this.departureDate = str;
    }

    public void setDestination(String str) {
        this.destination = str;
    }

    public void setGender(String str) {
        this.gender = str;
    }

    public void setMealType(String str) {
        this.mealType = str;
    }

    public void setQuata(String str) {
        this.quata = str;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setTicketStatus(String str) {
        this.ticketStatus = str;
    }

    public void setTrainType(String str) {
        this.trainType = str;
    }

    public void setjClass(String str) {
        this.jClass = str;
    }
}
