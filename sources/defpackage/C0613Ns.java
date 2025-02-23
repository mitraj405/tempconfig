package defpackage;

import cris.prs.webservices.dto.PassengerDetailDTO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* renamed from: Ns  reason: default package and case insensitive filesystem */
/* compiled from: RefundDTO */
public final class C0613Ns implements Serializable {
    private static final long serialVersionUID = 1;
    private String errorMsg;
    private ArrayList<a> refundDetail = new ArrayList<>();
    private String serverId;
    private Date timeStamp;

    /* renamed from: Ns$a */
    /* compiled from: RefundDTO */
    public static final class a implements Serializable {
        private static final long serialVersionUID = 1;
        private String BankName;
        private String EtRefundId;
        private String boardingStation;
        private boolean eTicketFlag;
        private Date etRefundActualRefndDate;
        private Double etRefundAmount;
        private String etRefundBankName;
        private String etRefundBankTransactionId;
        private String etRefundCancellationType;
        private String etRefundCancellation_id;
        private String etRefundPaymentMode;
        private Double etRefundRefundAmount;
        private Date etRefundRefundInitiatedDate;
        private Integer etRefundServiceProviderId;
        private String etRefundSettlement_id;
        private String etRefundStatus;
        private Date etRefundTransDate;
        private String etRefundType;
        private String fromStation;
        private Date journeyDate;
        private String journeyQuota;
        private String lapNumber;
        private String metroFromStation;
        private boolean metroServiceOpted;
        private String metroToStation;
        private String pnr;
        private boolean postMealOpted;
        private ArrayList<PassengerDetailDTO> psgnDtlList;
        private String refundStatusDes;
        private Integer refundStatusId;
        private String reservationId;
        private Integer softFlag;
        private Double ticketAmount;
        private String toStation;
        private String trainName;
        private String trainNo;
        private Date transactionDate;
        private String transactionId;
        private String transactionIdNew;
        private float travelnsuranceRefundAmount;

        public String getBankName() {
            return this.BankName;
        }

        public String getBoardingStation() {
            return this.boardingStation;
        }

        public Date getEtRefundActualRefndDate() {
            return this.etRefundActualRefndDate;
        }

        public Double getEtRefundAmount() {
            return this.etRefundAmount;
        }

        public String getEtRefundBankName() {
            return this.etRefundBankName;
        }

        public String getEtRefundBankTransactionId() {
            return this.etRefundBankTransactionId;
        }

        public String getEtRefundCancellationType() {
            return this.etRefundCancellationType;
        }

        public String getEtRefundCancellation_id() {
            return this.etRefundCancellation_id;
        }

        public String getEtRefundId() {
            return this.EtRefundId;
        }

        public String getEtRefundPaymentMode() {
            return this.etRefundPaymentMode;
        }

        public Double getEtRefundRefundAmount() {
            return this.etRefundRefundAmount;
        }

        public Date getEtRefundRefundInitiatedDate() {
            return this.etRefundRefundInitiatedDate;
        }

        public Integer getEtRefundServiceProviderId() {
            return this.etRefundServiceProviderId;
        }

        public String getEtRefundSettlement_id() {
            return this.etRefundSettlement_id;
        }

        public String getEtRefundStatus() {
            return this.etRefundStatus;
        }

        public Date getEtRefundTransDate() {
            return this.etRefundTransDate;
        }

        public String getEtRefundType() {
            return this.etRefundType;
        }

        public String getFromStation() {
            return this.fromStation;
        }

        public Date getJourneyDate() {
            return this.journeyDate;
        }

        public String getJourneyQuota() {
            return this.journeyQuota;
        }

        public String getLapNumber() {
            return this.lapNumber;
        }

        public String getMetroFromStation() {
            return this.metroFromStation;
        }

        public String getMetroToStation() {
            return this.metroToStation;
        }

        public String getPnr() {
            return this.pnr;
        }

        public ArrayList<PassengerDetailDTO> getPsgnDtlList() {
            return this.psgnDtlList;
        }

        public String getRefundStatusDes() {
            return this.refundStatusDes;
        }

        public Integer getRefundStatusId() {
            return this.refundStatusId;
        }

        public String getReservationId() {
            return this.reservationId;
        }

        public Integer getSoftFlag() {
            return this.softFlag;
        }

        public Double getTicketAmount() {
            return this.ticketAmount;
        }

        public String getToStation() {
            return this.toStation;
        }

        public String getTrainName() {
            return this.trainName;
        }

        public String getTrainNo() {
            return this.trainNo;
        }

        public Date getTransactionDate() {
            return this.transactionDate;
        }

        public String getTransactionId() {
            return this.transactionId;
        }

        public String getTransactionIdNew() {
            return this.transactionIdNew;
        }

        public float getTravelnsuranceRefundAmount() {
            return this.travelnsuranceRefundAmount;
        }

        public boolean isMetroServiceOpted() {
            return this.metroServiceOpted;
        }

        public boolean isPostMealOpted() {
            return this.postMealOpted;
        }

        public boolean iseTicketFlag() {
            return this.eTicketFlag;
        }

        public void setBankName(String str) {
            this.BankName = str;
        }

        public void setBoardingStation(String str) {
            this.boardingStation = str;
        }

        public void setEtRefundActualRefndDate(Date date) {
            this.etRefundActualRefndDate = date;
        }

        public void setEtRefundAmount(Double d) {
            this.etRefundAmount = d;
        }

        public void setEtRefundBankName(String str) {
            this.etRefundBankName = str;
        }

        public void setEtRefundBankTransactionId(String str) {
            this.etRefundBankTransactionId = str;
        }

        public void setEtRefundCancellationType(String str) {
            this.etRefundCancellationType = str;
        }

        public void setEtRefundCancellation_id(String str) {
            this.etRefundCancellation_id = str;
        }

        public void setEtRefundId(String str) {
            this.EtRefundId = str;
        }

        public void setEtRefundPaymentMode(String str) {
            this.etRefundPaymentMode = str;
        }

        public void setEtRefundRefundAmount(Double d) {
            this.etRefundRefundAmount = d;
        }

        public void setEtRefundRefundInitiatedDate(Date date) {
            this.etRefundRefundInitiatedDate = date;
        }

        public void setEtRefundServiceProviderId(Integer num) {
            this.etRefundServiceProviderId = num;
        }

        public void setEtRefundSettlement_id(String str) {
            this.etRefundSettlement_id = str;
        }

        public void setEtRefundStatus(String str) {
            this.etRefundStatus = str;
        }

        public void setEtRefundTransDate(Date date) {
            this.etRefundTransDate = date;
        }

        public void setEtRefundType(String str) {
            this.etRefundType = str;
        }

        public void setFromStation(String str) {
            this.fromStation = str;
        }

        public void setJourneyDate(Date date) {
            this.journeyDate = date;
        }

        public void setJourneyQuota(String str) {
            this.journeyQuota = str;
        }

        public void setLapNumber(String str) {
            this.lapNumber = str;
        }

        public void setMetroFromStation(String str) {
            this.metroFromStation = str;
        }

        public void setMetroServiceOpted(boolean z) {
            this.metroServiceOpted = z;
        }

        public void setMetroToStation(String str) {
            this.metroToStation = str;
        }

        public void setPnr(String str) {
            this.pnr = str;
        }

        public void setPostMealOpted(boolean z) {
            this.postMealOpted = z;
        }

        public void setPsgnDtlList(ArrayList<PassengerDetailDTO> arrayList) {
            this.psgnDtlList = arrayList;
        }

        public void setRefundStatusDes(String str) {
            this.refundStatusDes = str;
        }

        public void setRefundStatusId(Integer num) {
            this.refundStatusId = num;
        }

        public void setReservationId(String str) {
            this.reservationId = str;
        }

        public void setSoftFlag(Integer num) {
            this.softFlag = num;
        }

        public void setTicketAmount(Double d) {
            this.ticketAmount = d;
        }

        public void setToStation(String str) {
            this.toStation = str;
        }

        public void setTrainName(String str) {
            this.trainName = str;
        }

        public void setTrainNo(String str) {
            this.trainNo = str;
        }

        public void setTransactionDate(Date date) {
            this.transactionDate = date;
        }

        public void setTransactionId(String str) {
            this.transactionId = str;
        }

        public void setTransactionIdNew(String str) {
            this.transactionIdNew = str;
        }

        public void setTravelnsuranceRefundAmount(float f) {
            this.travelnsuranceRefundAmount = f;
        }

        public void seteTicketFlag(boolean z) {
            this.eTicketFlag = z;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("RefundDetail [EtRefundId=");
            sb.append(this.EtRefundId);
            sb.append(", transactionId=");
            sb.append(this.transactionId);
            sb.append(", etRefundCancellation_id=");
            sb.append(this.etRefundCancellation_id);
            sb.append(", etRefundSettlement_id=");
            sb.append(this.etRefundSettlement_id);
            sb.append(", etRefundTransDate=");
            sb.append(this.etRefundTransDate);
            sb.append(", etRefundAmount=");
            sb.append(this.etRefundAmount);
            sb.append(", etRefundRefundAmount=");
            sb.append(this.etRefundRefundAmount);
            sb.append(", etRefundCancellationType=");
            sb.append(this.etRefundCancellationType);
            sb.append(", etRefundStatus=");
            sb.append(this.etRefundStatus);
            sb.append(", etRefundBankName=");
            sb.append(this.etRefundBankName);
            sb.append(", etRefundServiceProviderId=");
            sb.append(this.etRefundServiceProviderId);
            sb.append(", etRefundRefundInitiatedDate=");
            sb.append(this.etRefundRefundInitiatedDate);
            sb.append(", etRefundBankTransactionId=");
            sb.append(this.etRefundBankTransactionId);
            sb.append(", etRefundType=");
            sb.append(this.etRefundType);
            sb.append(", etRefundPaymentMode=");
            sb.append(this.etRefundPaymentMode);
            sb.append(", etRefundActualRefndDate=");
            sb.append(this.etRefundActualRefndDate);
            sb.append(", reservationId=");
            sb.append(this.reservationId);
            sb.append(", transactionDate=");
            sb.append(this.transactionDate);
            sb.append(", ticketAmount=");
            sb.append(this.ticketAmount);
            sb.append(", BankName=");
            sb.append(this.BankName);
            sb.append(", eTicketFlag=");
            sb.append(this.eTicketFlag);
            sb.append(", psgnDtlList=");
            sb.append(this.psgnDtlList);
            sb.append(", journeyDate=");
            sb.append(this.journeyDate);
            sb.append(", trainNo=");
            sb.append(this.trainNo);
            sb.append(", trainName=");
            sb.append(this.trainName);
            sb.append(", pnr=");
            sb.append(this.pnr);
            sb.append(", fromStation=");
            sb.append(this.fromStation);
            sb.append(", toStation=");
            sb.append(this.toStation);
            sb.append(", boardingStation=");
            sb.append(this.boardingStation);
            sb.append(", journeyQuota=");
            sb.append(this.journeyQuota);
            sb.append(", softFlag=");
            sb.append(this.softFlag);
            sb.append(", refundStatusId=");
            sb.append(this.refundStatusId);
            sb.append(", refundStatusDes=");
            return C0709Uj.j(sb, this.refundStatusDes, "]");
        }
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public ArrayList<a> getRefundDetail() {
        return this.refundDetail;
    }

    public String getServerId() {
        return this.serverId;
    }

    public Date getTimeStamp() {
        return this.timeStamp;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public void setRefundDetail(ArrayList<a> arrayList) {
        this.refundDetail = arrayList;
    }

    public void setServerId(String str) {
        this.serverId = str;
    }

    public void setTimeStamp(Date date) {
        this.timeStamp = date;
    }

    public String toString() {
        return "RefundDTO [refundDetail=" + this.refundDetail + ", errorMsg=" + this.errorMsg + ", serverId=" + this.serverId + ", timeStamp=" + this.timeStamp + "]";
    }
}
