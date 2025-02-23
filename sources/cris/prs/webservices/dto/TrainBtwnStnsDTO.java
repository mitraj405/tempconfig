package cris.prs.webservices.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class TrainBtwnStnsDTO implements Serializable {
    private static final long serialVersionUID = 1;
    private Long arrTime;
    private String arrivalTime;
    private boolean atasOpted;
    private List<String> avlClasses;
    private ArrayList<C1060d2> avlDayList;
    private List<ClassAvlDTO> classAvlDTO;
    private Long depTime;
    private String departureDate;
    private String departureTime;
    private int distance;
    private String duration;
    private boolean flexiFlag;
    private String fromStnCode;
    private Date journeyDate;
    private String jrnyClass;
    private String quotaCode;
    private String runningFri;
    private String runningMon;
    private String runningSat;
    private String runningSun;
    private String runningThu;
    private String runningTue;
    private String runningWed;
    private Integer sNo;
    private Date startingDate;
    private Integer tabIndex;
    private String toStnCode;
    private Integer totalFare;
    private String trainName;
    private String trainNumber;
    private Byte trainOwner;
    private List<String> trainType;
    private String trainsiteId;

    public Long getArrTime() {
        return this.arrTime;
    }

    public String getArrivalTime() {
        return this.arrivalTime;
    }

    public List<String> getAvlClasses() {
        return this.avlClasses;
    }

    public ArrayList<C1060d2> getAvlDayList() {
        return this.avlDayList;
    }

    public List<ClassAvlDTO> getClassAvlDTO() {
        return this.classAvlDTO;
    }

    public Long getDepTime() {
        return this.depTime;
    }

    public String getDepartureDate() {
        return this.departureDate;
    }

    public String getDepartureTime() {
        return this.departureTime;
    }

    public int getDistance() {
        return this.distance;
    }

    public String getDuration() {
        return this.duration;
    }

    public String getFromStnCode() {
        return this.fromStnCode;
    }

    public Date getJourneyDate() {
        return this.journeyDate;
    }

    public String getJrnyClass() {
        return this.jrnyClass;
    }

    public String getQuotaCode() {
        return this.quotaCode;
    }

    public String getRunningFri() {
        return this.runningFri;
    }

    public String getRunningMon() {
        return this.runningMon;
    }

    public String getRunningSat() {
        return this.runningSat;
    }

    public String getRunningSun() {
        return this.runningSun;
    }

    public String getRunningThu() {
        return this.runningThu;
    }

    public String getRunningTue() {
        return this.runningTue;
    }

    public String getRunningWed() {
        return this.runningWed;
    }

    public Date getStartingDate() {
        return this.startingDate;
    }

    public Integer getTabIndex() {
        return this.tabIndex;
    }

    public String getToStnCode() {
        return this.toStnCode;
    }

    public Integer getTotalFare() {
        return this.totalFare;
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

    public List<String> getTrainType() {
        return this.trainType;
    }

    public String getTrainsiteId() {
        return this.trainsiteId;
    }

    public Integer getsNo() {
        return this.sNo;
    }

    public boolean isAtasOpted() {
        return this.atasOpted;
    }

    public boolean isFlexiFlag() {
        return this.flexiFlag;
    }

    public void setArrTime(Long l) {
        this.arrTime = l;
    }

    public void setArrivalTime(String str) {
        this.arrivalTime = str;
    }

    public void setAtasOpted(boolean z) {
        this.atasOpted = z;
    }

    public void setAvlClasses(List<String> list) {
        this.avlClasses = list;
    }

    public void setAvlDayList(ArrayList<C1060d2> arrayList) {
        this.avlDayList = arrayList;
    }

    public void setClassAvlDTO(List<ClassAvlDTO> list) {
        this.classAvlDTO = list;
    }

    public void setDepTime(Long l) {
        this.depTime = l;
    }

    public void setDepartureDate(String str) {
        this.departureDate = str;
    }

    public void setDepartureTime(String str) {
        this.departureTime = str;
    }

    public void setDistance(int i) {
        this.distance = i;
    }

    public void setDuration(String str) {
        this.duration = str;
    }

    public void setFlexiFlag(boolean z) {
        this.flexiFlag = z;
    }

    public void setFromStnCode(String str) {
        this.fromStnCode = str;
    }

    public void setJourneyDate(Date date) {
        this.journeyDate = date;
    }

    public void setJrnyClass(String str) {
        this.jrnyClass = str;
    }

    public void setQuotaCode(String str) {
        this.quotaCode = str;
    }

    public void setRunningFri(String str) {
        this.runningFri = str;
    }

    public void setRunningMon(String str) {
        this.runningMon = str;
    }

    public void setRunningSat(String str) {
        this.runningSat = str;
    }

    public void setRunningSun(String str) {
        this.runningSun = str;
    }

    public void setRunningThu(String str) {
        this.runningThu = str;
    }

    public void setRunningTue(String str) {
        this.runningTue = str;
    }

    public void setRunningWed(String str) {
        this.runningWed = str;
    }

    public void setStartingDate(Date date) {
        this.startingDate = date;
    }

    public void setTabIndex(Integer num) {
        this.tabIndex = num;
    }

    public void setToStnCode(String str) {
        this.toStnCode = str;
    }

    public void setTotalFare(Integer num) {
        this.totalFare = num;
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

    public void setTrainType(List<String> list) {
        this.trainType = list;
    }

    public void setTrainsiteId(String str) {
        this.trainsiteId = str;
    }

    public void setsNo(Integer num) {
        this.sNo = num;
    }
}
