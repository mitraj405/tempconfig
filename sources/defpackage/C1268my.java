package defpackage;

import java.util.Collection;
import java.util.Iterator;

/* renamed from: my  reason: default package and case insensitive filesystem */
/* compiled from: StringsJVM.kt */
public class C1268my extends C1248ly {
    public static final boolean R0(String str) {
        boolean z;
        C1177ig.f(str, "<this>");
        if (str.length() == 0) {
            return true;
        }
        C1112fg fgVar = new C1112fg(0, str.length() - 1);
        if (!(fgVar instanceof Collection) || !((Collection) fgVar).isEmpty()) {
            Iterator it = fgVar.iterator();
            while (true) {
                if (((C1091eg) it).a) {
                    if (!C1354qp.b0(str.charAt(((C0823cg) it).nextInt()))) {
                        z = false;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        z = true;
        if (z) {
            return true;
        }
        return false;
    }

    public static final boolean S0(int i, int i2, String str, String str2, boolean z) {
        C1177ig.f(str, "<this>");
        C1177ig.f(str2, "other");
        if (!z) {
            return str.regionMatches(0, str2, i, i2);
        }
        return str.regionMatches(z, 0, str2, i, i2);
    }

    public static String T0(String str, String str2, String str3) {
        int V0 = C1337py.V0(str, str2, 0, false);
        if (V0 < 0) {
            return str;
        }
        int length = str2.length();
        int i = 1;
        if (length >= 1) {
            i = length;
        }
        int length2 = str3.length() + (str.length() - length);
        if (length2 >= 0) {
            StringBuilder sb = new StringBuilder(length2);
            int i2 = 0;
            do {
                sb.append(str, i2, V0);
                sb.append(str3);
                i2 = V0 + length;
                if (V0 >= str.length() || (V0 = C1337py.V0(str, str2, V0 + i, false)) <= 0) {
                    sb.append(str, i2, str.length());
                    String sb2 = sb.toString();
                    C1177ig.e(sb2, "stringBuilder.append(this, i, length).toString()");
                }
                sb.append(str, i2, V0);
                sb.append(str3);
                i2 = V0 + length;
                break;
            } while ((V0 = C1337py.V0(str, str2, V0 + i, false)) <= 0);
            sb.append(str, i2, str.length());
            String sb22 = sb.toString();
            C1177ig.e(sb22, "stringBuilder.append(this, i, length).toString()");
            return sb22;
        }
        throw new OutOfMemoryError();
    }
}
