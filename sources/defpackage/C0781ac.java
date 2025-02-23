package defpackage;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* renamed from: ac  reason: default package and case insensitive filesystem */
/* compiled from: FetchFareResponseDTO */
public final class C0781ac implements Serializable {
    private static final long serialVersionUID = 1;
    private List<C1187j2> bankDetailDTO;
    public String date;
    public int dest;
    public String error;
    private C1087eb ewalletDTO;
    private List<Do> fareBreakup;
    public String minimumInterchange;
    public int productId;
    public int psgnCount;
    private double serviceCharge;
    private double serviceChargeGST;
    public int serviceId;
    public String shortestPath;
    public int src;
    private String stations;
    private double ticketCharge;
    private Date timeStamp;
    private double totalPayableAmount;

    public List<C1187j2> getBankDetailDTO() {
        return this.bankDetailDTO;
    }

    public String getDate() {
        return this.date;
    }

    public int getDest() {
        return this.dest;
    }

    public String getError() {
        return this.error;
    }

    public C1087eb getEwalletDTO() {
        return this.ewalletDTO;
    }

    public List<Do> getFareBreakup() {
        return this.fareBreakup;
    }

    public String getMinimumInterchange() {
        return this.minimumInterchange;
    }

    public int getProductId() {
        return this.productId;
    }

    public int getPsgnCount() {
        return this.psgnCount;
    }

    public double getServiceCharge() {
        return this.serviceCharge;
    }

    public double getServiceChargeGST() {
        return this.serviceChargeGST;
    }

    public int getServiceId() {
        return this.serviceId;
    }

    public String getShortestPath() {
        return this.shortestPath;
    }

    public int getSrc() {
        return this.src;
    }

    public String getStations() {
        return this.stations;
    }

    public double getTicketCharge() {
        return this.ticketCharge;
    }

    public Date getTimeStamp() {
        return this.timeStamp;
    }

    public double getTotalPayableAmount() {
        return this.totalPayableAmount;
    }

    public void setBankDetailDTO(List<C1187j2> list) {
        this.bankDetailDTO = list;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public void setDest(int i) {
        this.dest = i;
    }

    public void setError(String str) {
        this.error = str;
    }

    public void setEwalletDTO(C1087eb ebVar) {
        this.ewalletDTO = ebVar;
    }

    public void setFareBreakup(List<Do> list) {
        this.fareBreakup = list;
    }

    public void setMinimumInterchange(String str) {
        this.minimumInterchange = str;
    }

    public void setProductId(int i) {
        this.productId = i;
    }

    public void setPsgnCount(int i) {
        this.psgnCount = i;
    }

    public void setServiceCharge(double d) {
        this.serviceCharge = d;
    }

    public void setServiceChargeGST(double d) {
        this.serviceChargeGST = d;
    }

    public void setServiceId(int i) {
        this.serviceId = i;
    }

    public void setShortestPath(String str) {
        this.shortestPath = str;
    }

    public void setSrc(int i) {
        this.src = i;
    }

    public void setStations(String str) {
        this.stations = str;
    }

    public void setTicketCharge(double d) {
        this.ticketCharge = d;
    }

    public void setTimeStamp(Date date2) {
        this.timeStamp = date2;
    }

    public void setTotalPayableAmount(double d) {
        this.totalPayableAmount = d;
    }

    public String toString() {
        return "FetchFareResponseDTO [shortestPath=" + this.shortestPath + ", minimumInterchange=" + this.minimumInterchange + ", src=" + this.src + ", dest=" + this.dest + ", date=" + this.date + ", psgnCount=" + this.psgnCount + ", productId=" + this.productId + ", serviceId=" + this.serviceId + ", stations=" + this.stations + ", error=" + this.error + ", fareBreakup=" + this.fareBreakup + ", totalPayableAmount=" + this.totalPayableAmount + ", bankDetailDTO=" + this.bankDetailDTO + ", ewalletDTO=" + this.ewalletDTO + ", timeStamp=" + this.timeStamp + ", serviceCharge=" + this.serviceCharge + ", ticketCharge=" + this.ticketCharge + ", serviceChargeGST=" + this.serviceChargeGST + "]";
    }
}
