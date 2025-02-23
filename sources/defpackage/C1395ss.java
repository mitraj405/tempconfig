package defpackage;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* renamed from: ss  reason: default package and case insensitive filesystem */
/* compiled from: RateUsDTO */
public final class C1395ss {
    private int application;
    private int page;
    private int rating;
    private int ratingReason;
    private String remarks;
    private long userId;

    public int getApplication() {
        return this.application;
    }

    public int getPage() {
        return this.page;
    }

    public int getRating() {
        return this.rating;
    }

    public int getRatingReason() {
        return this.ratingReason;
    }

    public String getRemarks() {
        return this.remarks;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setApplication(int i) {
        this.application = i;
    }

    public void setPage(int i) {
        this.page = i;
    }

    public void setRating(int i) {
        this.rating = i;
    }

    public void setRatingReason(int i) {
        this.ratingReason = i;
    }

    public void setRemarks(String str) {
        this.remarks = str;
    }

    public void setUserId(long j) {
        this.userId = j;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("RateUsDTO [rating=");
        sb.append(this.rating);
        sb.append(", ratingReason=");
        sb.append(this.ratingReason);
        sb.append(", remarks=");
        sb.append(this.remarks);
        sb.append(", application=");
        sb.append(this.application);
        sb.append(", page=");
        sb.append(this.page);
        sb.append(", userId=");
        return lf.l(sb, this.userId, "]");
    }
}
