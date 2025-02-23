package defpackage;

import java.text.DateFormat;
import java.util.Date;

/* renamed from: jn  reason: default package and case insensitive filesystem */
/* compiled from: NumericDate */
public final class C1201jn {
    public long a;

    public C1201jn(long j) {
        this.a = j;
    }

    public final boolean a() {
        long j = this.a;
        long j2 = 1000 * j;
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if ((i <= 0 || j2 >= j) && ((i >= 0 || j2 <= j) && (i != 0 || j2 == 0))) {
            return true;
        }
        return false;
    }

    public final boolean equals(Object obj) {
        if (this == obj || ((obj instanceof C1201jn) && this.a == ((C1201jn) obj).a)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        long j = this.a;
        return (int) (j ^ (j >>> 32));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("NumericDate{");
        sb.append(this.a);
        if (a()) {
            DateFormat dateTimeInstance = DateFormat.getDateTimeInstance(2, 1);
            long j = this.a;
            long j2 = 1000 * j;
            if (a()) {
                Date date = new Date(j2);
                sb.append(" -> ");
                sb.append(dateTimeInstance.format(date));
            } else {
                StringBuilder sb2 = new StringBuilder("converting ");
                sb2.append(j);
                sb2.append(" seconds to milliseconds (x1000) resulted in long integer overflow (");
                throw new ArithmeticException(lf.l(sb2, j2, ")"));
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
