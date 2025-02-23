package defpackage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* renamed from: Z2  reason: default package */
/* compiled from: BoardingStnListDTO */
public final class Z2 implements Serializable {
    private static final long serialVersionUID = 1;
    private List<C0794b3> bkgCfgs;
    private ArrayList<a> boardingStationList = new ArrayList<>();
    private String errorMessage;
    private boolean mealChoiceenable;
    private List<Lk> mealDetailsDTO;
    private C1262mo secQ;
    private String serverId;
    private Date timeStamp;

    /* renamed from: Z2$a */
    /* compiled from: BoardingStnListDTO */
    public static class a implements Serializable {
        private static final long serialVersionUID = 1;
        private String arrivalTime;
        private Date boardingDate;
        private String dayCount;
        private String departureTime;
        private String distance;
        private String haltTime;
        private String routeNumber;
        private String stationName;
        private String stnNameCode;
        private String stnSerialNumber;

        public String getArrivalTime() {
            return this.arrivalTime;
        }

        public Date getBoardingDate() {
            return this.boardingDate;
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

        public String getStationName() {
            return this.stationName;
        }

        public String getStnNameCode() {
            return this.stnNameCode;
        }

        public String getStnSerialNumber() {
            return this.stnSerialNumber;
        }

        public void setArrivalTime(String str) {
            this.arrivalTime = str;
        }

        public void setBoardingDate(Date date) {
            this.boardingDate = date;
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

        public void setStationName(String str) {
            this.stationName = str;
        }

        public void setStnNameCode(String str) {
            this.stnNameCode = str;
        }

        public void setStnSerialNumber(String str) {
            this.stnSerialNumber = str;
        }

        public String toString() {
            return "BoardingStations [stnNameCode=" + this.stnNameCode + ", stationName=" + this.stationName + ", arrivalTime=" + this.arrivalTime + ", departureTime=" + this.departureTime + ", routeNumber=" + this.routeNumber + ", haltTime=" + this.haltTime + ", distance=" + this.distance + ", dayCount=" + this.dayCount + ", stnSerialNumber=" + this.stnSerialNumber + ", boardingDate=" + this.boardingDate + "]";
        }
    }

    public List<C0794b3> getBkgCfgs() {
        return this.bkgCfgs;
    }

    public ArrayList<a> getBoardingStationList() {
        return this.boardingStationList;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public List<Lk> getMealDetailsDTO() {
        return this.mealDetailsDTO;
    }

    public C1262mo getSecQ() {
        return this.secQ;
    }

    public String getServerId() {
        return this.serverId;
    }

    public Date getTimeStamp() {
        return this.timeStamp;
    }

    public boolean isMealChoiceenable() {
        return this.mealChoiceenable;
    }

    public void setBkgCfgs(List<C0794b3> list) {
        this.bkgCfgs = list;
    }

    public void setBoardingStationList(ArrayList<a> arrayList) {
        this.boardingStationList = arrayList;
    }

    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public void setMealChoiceenable(boolean z) {
        this.mealChoiceenable = z;
    }

    public void setMealDetailsDTO(List<Lk> list) {
        this.mealDetailsDTO = list;
    }

    public void setSecQ(C1262mo moVar) {
        this.secQ = moVar;
    }

    public void setServerId(String str) {
        this.serverId = str;
    }

    public void setTimeStamp(Date date) {
        this.timeStamp = date;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("BoardingStnListDTO [boardingStationList=");
        sb.append(this.boardingStationList);
        sb.append(", errorMessage=");
        return C0709Uj.j(sb, this.errorMessage, "]");
    }
}
