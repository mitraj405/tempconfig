package defpackage;

/* renamed from: lv  reason: default package */
/* compiled from: Schlick */
public final class lv extends T9 {
    public final double a;
    public final double b;

    public lv(String str) {
        this.f545a = str;
        int indexOf = str.indexOf(40);
        int indexOf2 = str.indexOf(44, indexOf);
        this.a = Double.parseDouble(str.substring(indexOf + 1, indexOf2).trim());
        int i = indexOf2 + 1;
        this.b = Double.parseDouble(str.substring(i, str.indexOf(44, i)).trim());
    }

    public final double a(double d) {
        double d2 = this.b;
        int i = (d > d2 ? 1 : (d == d2 ? 0 : -1));
        double d3 = this.a;
        if (i < 0) {
            return (d2 * d) / (((d2 - d) * d3) + d);
        }
        return ((d - 1.0d) * (1.0d - d2)) / ((1.0d - d) - ((d2 - d) * d3));
    }

    public final double b(double d) {
        double d2 = this.b;
        int i = (d > d2 ? 1 : (d == d2 ? 0 : -1));
        double d3 = this.a;
        if (i < 0) {
            double d4 = d3 * d2 * d2;
            double d5 = ((d2 - d) * d3) + d;
            return d4 / (d5 * d5);
        }
        double d6 = d2 - 1.0d;
        double d7 = (((d2 - d) * (-d3)) - d) + 1.0d;
        return ((d6 * d3) * d6) / (d7 * d7);
    }
}
