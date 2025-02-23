package cris.org.in.ima.model;

public final class RecentSearchStationModel {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;

    public RecentSearchStationModel() {
    }

    public RecentSearchStationModel(String str, String str2, String str3, String str4, String str5) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("RecentSearchStationModel{fromStn='");
        sb.append(this.a);
        sb.append("', toStn='");
        sb.append(this.b);
        sb.append("', journeyDate='");
        sb.append(this.c);
        sb.append("', recentclass='");
        return C0709Uj.j(sb, this.d, "'}");
    }
}
