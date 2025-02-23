package defpackage;

import cris.prs.webservices.dto.RecentTransactionsDTO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* renamed from: Ds  reason: default package and case insensitive filesystem */
/* compiled from: RecentTransactionsList */
public final class C0488Ds implements Serializable {
    private static final long serialVersionUID = 1;
    private Boolean displayDisable;
    private String errorMsg;
    private ArrayList<RecentTransactionsDTO> lastTxnList = new ArrayList<>();
    private String lastTxnListInfoMsg;
    private ArrayList<RecentTransactionsDTO> recentCancellationList = new ArrayList<>();
    private String recentCancellationListInfoMsg;
    private String serverId;
    private Date timeStamp;
    private String upcomingjourneyInfoMsg;
    private ArrayList<RecentTransactionsDTO> upcomingjourneyList = new ArrayList<>();

    public Boolean getDisplayDisable() {
        return this.displayDisable;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public ArrayList<RecentTransactionsDTO> getLastTxnList() {
        return this.lastTxnList;
    }

    public String getLastTxnListInfoMsg() {
        return this.lastTxnListInfoMsg;
    }

    public ArrayList<RecentTransactionsDTO> getRecentCancellationList() {
        return this.recentCancellationList;
    }

    public String getRecentCancellationListInfoMsg() {
        return this.recentCancellationListInfoMsg;
    }

    public String getServerId() {
        return this.serverId;
    }

    public Date getTimeStamp() {
        return this.timeStamp;
    }

    public String getUpcomingjourneyInfoMsg() {
        return this.upcomingjourneyInfoMsg;
    }

    public ArrayList<RecentTransactionsDTO> getUpcomingjourneyList() {
        return this.upcomingjourneyList;
    }

    public void setDisplayDisable(Boolean bool) {
        this.displayDisable = bool;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public void setLastTxnList(ArrayList<RecentTransactionsDTO> arrayList) {
        this.lastTxnList = arrayList;
    }

    public void setLastTxnListInfoMsg(String str) {
        this.lastTxnListInfoMsg = str;
    }

    public void setRecentCancellationList(ArrayList<RecentTransactionsDTO> arrayList) {
        this.recentCancellationList = arrayList;
    }

    public void setRecentCancellationListInfoMsg(String str) {
        this.recentCancellationListInfoMsg = str;
    }

    public void setServerId(String str) {
        this.serverId = str;
    }

    public void setTimeStamp(Date date) {
        this.timeStamp = date;
    }

    public void setUpcomingjourneyInfoMsg(String str) {
        this.upcomingjourneyInfoMsg = str;
    }

    public void setUpcomingjourneyList(ArrayList<RecentTransactionsDTO> arrayList) {
        this.upcomingjourneyList = arrayList;
    }

    public String toString() {
        return "RecentTransactionsList [errorMsg=" + this.errorMsg + ", upcomingjourneyList=" + this.upcomingjourneyList + ", lastTxnList=" + this.lastTxnList + ", recentCancellationList=" + this.recentCancellationList + ", upcomingjourneyInfoMsg=" + this.upcomingjourneyInfoMsg + ", lastTxnListInfoMsg=" + this.lastTxnListInfoMsg + ", recentCancellationListInfoMsg=" + this.recentCancellationListInfoMsg + ", displayDisable=" + this.displayDisable + ", serverId=" + this.serverId + ", timeStamp=" + this.timeStamp + "]";
    }
}
