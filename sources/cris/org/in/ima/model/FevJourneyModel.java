package cris.org.in.ima.model;

import java.io.Serializable;

public final class FevJourneyModel implements Serializable {
    public Long a;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;

    public final String toString() {
        StringBuilder sb = new StringBuilder("FevJourneyModel{trainNumber='");
        sb.append(this.c);
        sb.append("', trainName='null', fromStnCode='");
        sb.append(this.d);
        sb.append("', toStnCode='");
        sb.append(this.e);
        sb.append("', jouneyClass='");
        sb.append(this.f);
        sb.append("', quota='");
        return C0709Uj.j(sb, this.g, "', journeyDate='null', isChecked=false}");
    }
}
