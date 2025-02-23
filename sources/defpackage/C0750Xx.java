package defpackage;

import java.io.Serializable;
import java.util.Date;

/* renamed from: Xx  reason: default package and case insensitive filesystem */
/* compiled from: StatusDTO */
public class C0750Xx implements Serializable {
    private boolean errorFlag;
    private String errorMsg;
    private Date journeyDate;

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public Date getJourneyDate() {
        return this.journeyDate;
    }

    public boolean isErrorFlag() {
        return this.errorFlag;
    }

    public void setErrorFlag(boolean z) {
        this.errorFlag = z;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public void setJourneyDate(Date date) {
        this.journeyDate = date;
    }

    public String toString() {
        return "StatusDTO [errorFlag=" + this.errorFlag + ", errorMsg=" + this.errorMsg + ", journeyDate=" + this.journeyDate + "]";
    }
}
