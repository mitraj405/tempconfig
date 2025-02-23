package defpackage;

import java.io.PrintStream;
import java.util.Arrays;

/* renamed from: T9  reason: default package */
/* compiled from: Easing */
public class T9 {
    public static final T9 a = new T9();

    /* renamed from: a  reason: collision with other field name */
    public static final String[] f544a = {"standard", "accelerate", "decelerate", "linear"};

    /* renamed from: a  reason: collision with other field name */
    public String f545a = "identity";

    /* renamed from: T9$a */
    /* compiled from: Easing */
    public static class a extends T9 {
        public final double a;
        public final double b;
        public final double c;
        public final double d;

        public a(String str) {
            this.f545a = str;
            int indexOf = str.indexOf(40);
            int indexOf2 = str.indexOf(44, indexOf);
            this.a = Double.parseDouble(str.substring(indexOf + 1, indexOf2).trim());
            int i = indexOf2 + 1;
            int indexOf3 = str.indexOf(44, i);
            this.b = Double.parseDouble(str.substring(i, indexOf3).trim());
            int i2 = indexOf3 + 1;
            int indexOf4 = str.indexOf(44, i2);
            this.c = Double.parseDouble(str.substring(i2, indexOf4).trim());
            int i3 = indexOf4 + 1;
            this.d = Double.parseDouble(str.substring(i3, str.indexOf(41, i3)).trim());
        }

        public final double a(double d2) {
            if (d2 <= 0.0d) {
                return 0.0d;
            }
            if (d2 >= 1.0d) {
                return 1.0d;
            }
            double d3 = 0.5d;
            double d4 = 0.5d;
            while (d3 > 0.01d) {
                d3 *= 0.5d;
                if (d(d4) < d2) {
                    d4 += d3;
                } else {
                    d4 -= d3;
                }
            }
            double d5 = d4 - d3;
            double d6 = d(d5);
            double d7 = d4 + d3;
            double d8 = d(d7);
            double e = e(d5);
            return (((d2 - d6) * (e(d7) - e)) / (d8 - d6)) + e;
        }

        public final double b(double d2) {
            double d3 = 0.5d;
            double d4 = 0.5d;
            while (d3 > 1.0E-4d) {
                d3 *= 0.5d;
                if (d(d4) < d2) {
                    d4 += d3;
                } else {
                    d4 -= d3;
                }
            }
            double d5 = d4 - d3;
            double d6 = d(d5);
            double d7 = d4 + d3;
            return (e(d7) - e(d5)) / (d(d7) - d6);
        }

        public final double d(double d2) {
            double d3 = 1.0d - d2;
            double d4 = 3.0d * d3;
            double d5 = d3 * d4 * d2;
            double d6 = d4 * d2 * d2;
            return (this.c * d6) + (this.a * d5) + (d2 * d2 * d2);
        }

        public final double e(double d2) {
            double d3 = 1.0d - d2;
            double d4 = 3.0d * d3;
            double d5 = d3 * d4 * d2;
            double d6 = d4 * d2 * d2;
            return (this.d * d6) + (this.b * d5) + (d2 * d2 * d2);
        }
    }

    public static T9 c(String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("cubic")) {
            return new a(str);
        }
        if (str.startsWith("spline")) {
            return new Zx(str);
        }
        if (str.startsWith("Schlick")) {
            return new lv(str);
        }
        char c = 65535;
        switch (str.hashCode()) {
            case -1354466595:
                if (str.equals("accelerate")) {
                    c = 0;
                    break;
                }
                break;
            case -1263948740:
                if (str.equals("decelerate")) {
                    c = 1;
                    break;
                }
                break;
            case -1197605014:
                if (str.equals("anticipate")) {
                    c = 2;
                    break;
                }
                break;
            case -1102672091:
                if (str.equals("linear")) {
                    c = 3;
                    break;
                }
                break;
            case -749065269:
                if (str.equals("overshoot")) {
                    c = 4;
                    break;
                }
                break;
            case 1312628413:
                if (str.equals("standard")) {
                    c = 5;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return new a("cubic(0.4, 0.05, 0.8, 0.7)");
            case 1:
                return new a("cubic(0.0, 0.0, 0.2, 0.95)");
            case 2:
                return new a("cubic(0.36, 0, 0.66, -0.56)");
            case 3:
                return new a("cubic(1, 1, 0, 0)");
            case 4:
                return new a("cubic(0.34, 1.56, 0.64, 1)");
            case 5:
                return new a("cubic(0.4, 0.0, 0.2, 1)");
            default:
                PrintStream printStream = System.err;
                printStream.println("transitionEasing syntax error syntax:transitionEasing=\"cubic(1.0,0.5,0.0,0.6)\" or " + Arrays.toString(f544a));
                return a;
        }
    }

    public double b(double d) {
        return 1.0d;
    }

    public final String toString() {
        return this.f545a;
    }

    public double a(double d) {
        return d;
    }
}
