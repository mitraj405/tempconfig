package cris.org.in.ima.model;

public final class StationModel {
    public Boolean a = Boolean.FALSE;

    /* renamed from: a  reason: collision with other field name */
    public String f5341a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;

    public final String toString() {
        StringBuilder sb = new StringBuilder("StationModel{isHeader=null, stationCode='");
        sb.append(this.f5341a);
        sb.append("', stationNameEn='");
        sb.append(this.b);
        sb.append("', stationNameHi='");
        sb.append(this.d);
        sb.append("', stationCityEn='");
        sb.append(this.c);
        sb.append("', stationCityHi='");
        return C0709Uj.j(sb, this.e, "', headerName='null', selected=false}");
    }
}
