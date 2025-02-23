package defpackage;

/* renamed from: py  reason: default package and case insensitive filesystem */
/* compiled from: Strings.kt */
public class C1337py extends C1268my {
    public static final int U0(CharSequence charSequence) {
        C1177ig.f(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static final int V0(CharSequence charSequence, String str, int i, boolean z) {
        C1177ig.f(charSequence, "<this>");
        C1177ig.f(str, "string");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(str, i);
        }
        return W0(charSequence, str, i, charSequence.length(), z, false);
    }

    public static final int W0(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2) {
        C1070dg dgVar;
        if (!z2) {
            if (i < 0) {
                i = 0;
            }
            int length = charSequence.length();
            if (i2 > length) {
                i2 = length;
            }
            dgVar = new C1112fg(i, i2);
        } else {
            int U0 = U0(charSequence);
            if (i > U0) {
                i = U0;
            }
            if (i2 < 0) {
                i2 = 0;
            }
            dgVar = new C1070dg(i, i2, -1);
        }
        boolean z3 = charSequence instanceof String;
        int i3 = dgVar.c;
        int i4 = dgVar.e;
        int i5 = dgVar.d;
        if (!z3 || !(charSequence2 instanceof String)) {
            if ((i4 > 0 && i3 <= i5) || (i4 < 0 && i5 <= i3)) {
                while (!Z0(charSequence2, charSequence, i3, charSequence2.length(), z)) {
                    if (i3 != i5) {
                        i3 += i4;
                    }
                }
                return i3;
            }
        } else if ((i4 > 0 && i3 <= i5) || (i4 < 0 && i5 <= i3)) {
            while (true) {
                if (!C1268my.S0(i3, charSequence2.length(), (String) charSequence2, (String) charSequence, z)) {
                    if (i3 == i5) {
                        break;
                    }
                    i3 += i4;
                } else {
                    return i3;
                }
            }
        }
        return -1;
    }

    public static int X0(CharSequence charSequence, char c) {
        C1177ig.f(charSequence, "<this>");
        if (charSequence instanceof String) {
            return ((String) charSequence).indexOf(c, 0);
        }
        char[] cArr = {c};
        if (charSequence instanceof String) {
            return ((String) charSequence).indexOf(c, 0);
        }
        C1112fg fgVar = new C1112fg(0, U0(charSequence));
        C1091eg egVar = new C1091eg(0, fgVar.d, fgVar.e);
        while (egVar.a) {
            int nextInt = egVar.nextInt();
            if (C1354qp.H(cArr[0], charSequence.charAt(nextInt), false)) {
                return nextInt;
            }
        }
        return -1;
    }

    public static /* synthetic */ int Y0(CharSequence charSequence, String str, int i, boolean z, int i2) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return V0(charSequence, str, i, z);
    }

    public static final boolean Z0(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z) {
        C1177ig.f(charSequence, "<this>");
        C1177ig.f(charSequence2, "other");
        if (i < 0 || charSequence.length() - i2 < 0 || i > charSequence2.length() - i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (!C1354qp.H(charSequence.charAt(0 + i3), charSequence2.charAt(i + i3), z)) {
                return false;
            }
        }
        return true;
    }

    public static String a1(String str, String str2) {
        C1177ig.f(str2, "delimiter");
        int Y0 = Y0(str, str2, 0, false, 6);
        if (Y0 == -1) {
            return str;
        }
        String substring = str.substring(str2.length() + Y0, str.length());
        C1177ig.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static final String b1(String str, String str2) {
        C1177ig.f(str, "<this>");
        C1177ig.f(str2, "missingDelimiterValue");
        int lastIndexOf = str.lastIndexOf(46, U0(str));
        if (lastIndexOf == -1) {
            return str2;
        }
        String substring = str.substring(lastIndexOf + 1, str.length());
        C1177ig.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }
}
