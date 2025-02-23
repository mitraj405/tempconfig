package kotlin.time;

/* compiled from: Duration.kt */
public final class Duration implements Comparable<Duration> {
    public static final long b = Long.MAX_VALUE;
    public static final /* synthetic */ int c = 0;

    /* renamed from: c  reason: collision with other field name */
    public static final long f5560c = -9223372036854775805L;
    public final long a;

    static {
        int i = F9.a;
    }

    public /* synthetic */ Duration(long j) {
        this.a = j;
    }

    public static final void a(StringBuilder sb, int i, int i2, int i3, String str) {
        CharSequence charSequence;
        boolean z;
        sb.append(i);
        if (i2 != 0) {
            sb.append('.');
            String valueOf = String.valueOf(i2);
            C1177ig.f(valueOf, "<this>");
            if (i3 >= 0) {
                if (i3 <= valueOf.length()) {
                    charSequence = valueOf.subSequence(0, valueOf.length());
                } else {
                    StringBuilder sb2 = new StringBuilder(i3);
                    C1112fg fgVar = new C1112fg(1, i3 - valueOf.length());
                    C1091eg egVar = new C1091eg(1, fgVar.d, fgVar.e);
                    while (egVar.a) {
                        egVar.nextInt();
                        sb2.append('0');
                    }
                    sb2.append(valueOf);
                    charSequence = sb2;
                }
                String obj = charSequence.toString();
                int i4 = -1;
                int length = obj.length() - 1;
                if (length >= 0) {
                    while (true) {
                        int i5 = length - 1;
                        if (obj.charAt(length) != '0') {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            i4 = length;
                            break;
                        } else if (i5 < 0) {
                            break;
                        } else {
                            length = i5;
                        }
                    }
                }
                int i6 = i4 + 1;
                if (i6 < 3) {
                    sb.append(obj, 0, i6);
                } else {
                    sb.append(obj, 0, ((i6 + 2) / 3) * 3);
                }
            } else {
                throw new IllegalArgumentException(C1058d.y("Desired length ", i3, " is less than zero."));
            }
        }
        sb.append(str);
    }

    public static final boolean f(long j) {
        if (j == b || j == f5560c) {
            return true;
        }
        return false;
    }

    public static final long h(long j, C0513G9 g9) {
        C0513G9 g92;
        C1177ig.f(g9, "unit");
        if (j == b) {
            return Long.MAX_VALUE;
        }
        if (j == f5560c) {
            return Long.MIN_VALUE;
        }
        boolean z = true;
        long j2 = j >> 1;
        if ((((int) j) & 1) != 0) {
            z = false;
        }
        if (z) {
            g92 = C0513G9.NANOSECONDS;
        } else {
            g92 = C0513G9.MILLISECONDS;
        }
        C1177ig.f(g92, "sourceUnit");
        return g9.f3590a.convert(j2, g92.f3590a);
    }

    public final int compareTo(Object obj) {
        long j = ((Duration) obj).a;
        long j2 = this.a;
        long j3 = j2 ^ j;
        int i = 0;
        if (j3 < 0 || (((int) j3) & 1) == 0) {
            int i2 = (j2 > j ? 1 : (j2 == j ? 0 : -1));
            if (i2 < 0) {
                i = -1;
            } else if (i2 != 0) {
                i = 1;
            }
            return i;
        }
        int i3 = (((int) j2) & 1) - (((int) j) & 1);
        if (j2 < 0) {
            i = 1;
        }
        if (i != 0) {
            return -i3;
        }
        return i3;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Duration)) {
            return false;
        }
        if (this.a != ((Duration) obj).a) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Long.hashCode(this.a);
    }

    public final String toString() {
        boolean z;
        boolean z2;
        int i;
        int i2;
        int i3;
        int i4;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        int i5;
        boolean z7;
        long j;
        long j2 = this.a;
        int i6 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        if (i6 == 0) {
            return "0s";
        }
        if (j2 == b) {
            return "Infinity";
        }
        if (j2 == f5560c) {
            return "-Infinity";
        }
        if (i6 < 0) {
            z = true;
        } else {
            z = false;
        }
        StringBuilder sb = new StringBuilder();
        if (z) {
            sb.append('-');
        }
        if (i6 < 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            j2 = ((long) (((int) j2) & 1)) + ((-(j2 >> 1)) << 1);
            int i7 = F9.a;
        }
        long h = h(j2, C0513G9.DAYS);
        if (f(j2)) {
            i = 0;
        } else {
            i = (int) (h(j2, C0513G9.HOURS) % ((long) 24));
        }
        if (f(j2)) {
            i2 = 0;
        } else {
            i2 = (int) (h(j2, C0513G9.MINUTES) % ((long) 60));
        }
        if (f(j2)) {
            i3 = 0;
        } else {
            i3 = (int) (h(j2, C0513G9.SECONDS) % ((long) 60));
        }
        if (f(j2)) {
            i4 = 0;
        } else {
            if ((((int) j2) & 1) == 1) {
                z7 = true;
            } else {
                z7 = false;
            }
            long j3 = j2 >> 1;
            if (z7) {
                j = (j3 % ((long) 1000)) * ((long) 1000000);
            } else {
                j = j3 % ((long) 1000000000);
            }
            i4 = (int) j;
        }
        if (h != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (i != 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (i2 != 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (i3 == 0 && i4 == 0) {
            z6 = false;
        } else {
            z6 = true;
        }
        if (z3) {
            sb.append(h);
            sb.append('d');
            i5 = 1;
        } else {
            i5 = 0;
        }
        if (z4 || (z3 && (z5 || z6))) {
            int i8 = i5 + 1;
            if (i5 > 0) {
                sb.append(' ');
            }
            sb.append(i);
            sb.append('h');
            i5 = i8;
        }
        if (z5 || (z6 && (z4 || z3))) {
            int i9 = i5 + 1;
            if (i5 > 0) {
                sb.append(' ');
            }
            sb.append(i2);
            sb.append('m');
            i5 = i9;
        }
        if (z6) {
            int i10 = i5 + 1;
            if (i5 > 0) {
                sb.append(' ');
            }
            if (i3 != 0 || z3 || z4 || z5) {
                a(sb, i3, i4, 9, "s");
            } else if (i4 >= 1000000) {
                a(sb, i4 / 1000000, i4 % 1000000, 6, "ms");
            } else if (i4 >= 1000) {
                a(sb, i4 / 1000, i4 % 1000, 3, "us");
            } else {
                sb.append(i4);
                sb.append("ns");
            }
            i5 = i10;
        }
        if (z && i5 > 1) {
            sb.insert(1, '(').append(')');
        }
        String sb2 = sb.toString();
        C1177ig.e(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
