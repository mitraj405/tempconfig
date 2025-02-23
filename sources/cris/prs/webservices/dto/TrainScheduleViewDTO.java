package cris.prs.webservices.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public final class TrainScheduleViewDTO implements Serializable {
    private static final long serialVersionUID = 1;
    private int duration;
    private String errorMessage;
    private String serverId;
    private String stationFrom;
    private ArrayList<a> stationList = new ArrayList<>();
    private String stationTo;
    private Date timeStamp;
    private String trainName;
    private String trainNumber;
    private Byte trainOwner;
    private String trainRunsOnFri;
    private String trainRunsOnMon;
    private String trainRunsOnSat;
    private String trainRunsOnSun;
    private String trainRunsOnThu;
    private String trainRunsOnTue;
    private String trainRunsOnWed;
    private List<String> trainType;

    public static class a implements Serializable {
        private static final long serialVersionUID = 1;
        private String arrivalTime;
        private Boolean boardingDisabled;
        private String dayCount;
        private String departureTime;
        private String distance;
        private String haltTime;
        private String routeNumber;
        private String stationCode;
        private String stationName;
        private String stnSerialNumber;

        public String getArrivalTime() {
            return this.arrivalTime;
        }

        public Boolean getBoardingDisabled() {
            return this.boardingDisabled;
        }

        public String getDayCount() {
            return this.dayCount;
        }

        public String getDepartureTime() {
            return this.departureTime;
        }

        public String getDistance() {
            return this.distance;
        }

        public String getHaltTime() {
            return this.haltTime;
        }

        public String getRouteNumber() {
            return this.routeNumber;
        }

        public String getStationCode() {
            return this.stationCode;
        }

        public String getStationName() {
            return this.stationName;
        }

        public String getStnSerialNumber() {
            return this.stnSerialNumber;
        }

        public void setArrivalTime(String str) {
            this.arrivalTime = str;
        }

        public void setBoardingDisabled(Boolean bool) {
            this.boardingDisabled = bool;
        }

        public void setDayCount(String str) {
            this.dayCount = str;
        }

        public void setDepartureTime(String str) {
            this.departureTime = str;
        }

        public void setDistance(String str) {
            this.distance = str;
        }

        public void setHaltTime(String str) {
            this.haltTime = str;
        }

        public void setRouteNumber(String str) {
            this.routeNumber = str;
        }

        public void setStationCode(String str) {
            this.stationCode = str;
        }

        public void setStationName(String str) {
            this.stationName = str;
        }

        public void setStnSerialNumber(String str) {
            this.stnSerialNumber = str;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Stations [stationCode=");
            sb.append(this.stationCode);
            sb.append(", stationName=");
            sb.append(this.stationName);
            sb.append(", arrivalTime=");
            sb.append(this.arrivalTime);
            sb.append(", departureTime=");
            sb.append(this.departureTime);
            sb.append(", routeNumber=");
            sb.append(this.routeNumber);
            sb.append(", haltTime=");
            sb.append(this.haltTime);
            sb.append(", distance=");
            sb.append(this.distance);
            sb.append(", dayCount=");
            sb.append(this.dayCount);
            sb.append(", stnSerialNumber=");
            return C0709Uj.j(sb, this.stnSerialNumber, "]");
        }
    }

    public int getDuration() {
        return this.duration;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public String getServerId() {
        return this.serverId;
    }

    public String getStationFrom() {
        return this.stationFrom;
    }

    public ArrayList<a> getStationList() {
        return this.stationList;
    }

    public String getStationTo() {
        return this.stationTo;
    }

    public Date getTimeStamp() {
        return this.timeStamp;
    }

    public String getTrainName() {
        return this.trainName;
    }

    public String getTrainNumber() {
        return this.trainNumber;
    }

    public Byte getTrainOwner() {
        return this.trainOwner;
    }

    public String getTrainRunsOnFri() {
        return this.trainRunsOnFri;
    }

    public String getTrainRunsOnMon() {
        return this.trainRunsOnMon;
    }

    public String getTrainRunsOnSat() {
        return this.trainRunsOnSat;
    }

    public String getTrainRunsOnSun() {
        return this.trainRunsOnSun;
    }

    public String getTrainRunsOnThu() {
        return this.trainRunsOnThu;
    }

    public String getTrainRunsOnTue() {
        return this.trainRunsOnTue;
    }

    public String getTrainRunsOnWed() {
        return this.trainRunsOnWed;
    }

    public List<String> getTrainType() {
        return this.trainType;
    }

    public void setDuration(int i) {
        this.duration = i;
    }

    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public void setServerId(String str) {
        this.serverId = str;
    }

    public void setStationFrom(String str) {
        this.stationFrom = str;
    }

    public void setStationList(ArrayList<a> arrayList) {
        this.stationList = arrayList;
    }

    public void setStationTo(String str) {
        this.stationTo = str;
    }

    public void setTimeStamp(Date date) {
        this.timeStamp = date;
    }

    public void setTrainName(String str) {
        this.trainName = str;
    }

    public void setTrainNumber(String str) {
        this.trainNumber = str;
    }

    public void setTrainOwner(Byte b) {
        this.trainOwner = b;
    }

    public void setTrainRunsOnFri(String str) {
        this.trainRunsOnFri = str;
    }

    public void setTrainRunsOnMon(String str) {
        this.trainRunsOnMon = str;
    }

    public void setTrainRunsOnSat(String str) {
        this.trainRunsOnSat = str;
    }

    public void setTrainRunsOnSun(String str) {
        this.trainRunsOnSun = str;
    }

    public void setTrainRunsOnThu(String str) {
        this.trainRunsOnThu = str;
    }

    public void setTrainRunsOnTue(String str) {
        this.trainRunsOnTue = str;
    }

    public void setTrainRunsOnWed(String str) {
        this.trainRunsOnWed = str;
    }

    public void setTrainType(List<String> list) {
        this.trainType = list;
    }

    public String toString() {
        return "TrainScheduleViewDTO [trainNumber=" + this.trainNumber + ", trainName=" + this.trainName + ", stationFrom=" + this.stationFrom + ", stationTo=" + this.stationTo + ", trainOwner=" + this.trainOwner + ", trainRunsOnMon=" + this.trainRunsOnMon + ", trainRunsOnTue=" + this.trainRunsOnTue + ", trainRunsOnWed=" + this.trainRunsOnWed + ", trainRunsOnThu=" + this.trainRunsOnThu + ", trainRunsOnFri=" + this.trainRunsOnFri + ", trainRunsOnSat=" + this.trainRunsOnSat + ", trainRunsOnSun=" + this.trainRunsOnSun + ", errorMessage=" + this.errorMessage + ", serverId=" + this.serverId + ", timeStamp=" + this.timeStamp + ", trainType=" + this.trainType + ", duration=" + this.duration + ", stationList=" + this.stationList + "]";
    }
}
