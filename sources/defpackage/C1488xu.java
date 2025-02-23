package defpackage;

import android.util.Log;
import java.lang.reflect.Array;
import rx.Subscription;

/* renamed from: xu  reason: default package and case insensitive filesystem */
/* compiled from: RxJavaHooks */
public class C1488xu implements C0505Fd, IC, ILoggerFactory {
    public static boolean a = true;

    /* renamed from: a  reason: collision with other field name */
    public static final int[][] f7066a = {new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, new int[]{1, 2, 3, 4, 0, 6, 7, 8, 9, 5}, new int[]{2, 3, 4, 0, 1, 7, 8, 9, 5, 6}, new int[]{3, 4, 0, 1, 2, 8, 9, 5, 6, 7}, new int[]{4, 0, 1, 2, 3, 9, 5, 6, 7, 8}, new int[]{5, 9, 8, 7, 6, 0, 4, 3, 2, 1}, new int[]{6, 5, 9, 8, 7, 1, 0, 4, 3, 2}, new int[]{7, 6, 5, 9, 8, 2, 1, 0, 4, 3}, new int[]{8, 7, 6, 5, 9, 3, 2, 1, 0, 4}, new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0}};
    public static final int[][] b = {new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, new int[]{1, 5, 7, 6, 2, 8, 3, 0, 9, 4}, new int[]{5, 8, 0, 3, 7, 9, 6, 1, 4, 2}, new int[]{8, 9, 1, 6, 0, 4, 3, 5, 2, 7}, new int[]{9, 4, 5, 3, 1, 2, 6, 8, 7, 0}, new int[]{4, 2, 8, 6, 5, 7, 3, 9, 0, 1}, new int[]{2, 7, 9, 3, 8, 0, 6, 4, 1, 5}, new int[]{7, 0, 4, 6, 9, 1, 3, 2, 5, 8}};

    public static void d(int i, String str, String str2) {
        String concat = "BMP:".concat(str);
        if (str2.length() > 4000) {
            int length = str2.length() / 4000;
            int i2 = 0;
            while (i2 <= length) {
                int i3 = i2 + 1;
                int i4 = i3 * 4000;
                if (i4 >= str2.length()) {
                    StringBuilder m = lf.m("Part ", i2, ": ");
                    m.append(str2.substring(i2 * 4000));
                    Log.println(i, concat, m.toString());
                } else {
                    StringBuilder m2 = lf.m("Part ", i2, ": ");
                    m2.append(str2.substring(i2 * 4000, i4));
                    Log.println(i, concat, m2.toString());
                }
                i2 = i3;
            }
            return;
        }
        Log.println(i, concat, str2);
    }

    public static void e(int i, String str, String str2, Throwable... thArr) {
        if (i >= 5) {
            if (thArr.length > 0) {
                d(i, str, str2 + 10 + Log.getStackTraceString(thArr[0]));
                return;
            }
            d(i, str, str2);
        }
    }

    public static void f(String str, String str2, Throwable... thArr) {
        e(4, str, str2, thArr);
    }

    public static void g(String str, String str2, Throwable... thArr) {
        e(5, str, str2, thArr);
    }

    public static String h(x3 x3Var) {
        StringBuilder sb = new StringBuilder(x3Var.size());
        for (int i = 0; i < x3Var.size(); i++) {
            byte a2 = x3Var.a(i);
            if (a2 == 34) {
                sb.append("\\\"");
            } else if (a2 == 39) {
                sb.append("\\'");
            } else if (a2 != 92) {
                switch (a2) {
                    case 7:
                        sb.append("\\a");
                        break;
                    case 8:
                        sb.append("\\b");
                        break;
                    case 9:
                        sb.append("\\t");
                        break;
                    case 10:
                        sb.append("\\n");
                        break;
                    case 11:
                        sb.append("\\v");
                        break;
                    case 12:
                        sb.append("\\f");
                        break;
                    case 13:
                        sb.append("\\r");
                        break;
                    default:
                        if (a2 >= 32 && a2 <= 126) {
                            sb.append((char) a2);
                            break;
                        } else {
                            sb.append('\\');
                            sb.append((char) (((a2 >>> 6) & 3) + 48));
                            sb.append((char) (((a2 >>> 3) & 7) + 48));
                            sb.append((char) ((a2 & 7) + 48));
                            break;
                        }
                        break;
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }

    public static String i() {
        if (a) {
            return "https://secure.paytm.in/oltp";
        }
        return "https://pguat.paytm.com/oltp";
    }

    public static String j(String str, String str2) {
        int[] iArr = new int[2];
        iArr[1] = str2.length() + 1;
        iArr[0] = str.length() + 1;
        int[][] iArr2 = (int[][]) Array.newInstance(Integer.TYPE, iArr);
        for (int i = 0; i < str.length(); i++) {
            for (int i2 = 0; i2 < str2.length(); i2++) {
                if (str.charAt(i) == str2.charAt(i2)) {
                    iArr2[i + 1][i2 + 1] = iArr2[i][i2] + 1;
                } else {
                    int[] iArr3 = iArr2[i + 1];
                    int i3 = i2 + 1;
                    iArr3[i3] = Math.max(iArr3[i2], iArr2[i][i3]);
                }
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        int length = str.length();
        int length2 = str2.length();
        while (length != 0 && length2 != 0) {
            int[] iArr4 = iArr2[length];
            int i4 = iArr4[length2];
            int i5 = length - 1;
            if (i4 == iArr2[i5][length2]) {
                length--;
            } else {
                if (i4 != iArr4[length2 - 1]) {
                    stringBuffer.append(str.charAt(i5));
                    length--;
                }
                length2--;
            }
        }
        return stringBuffer.reverse().toString();
    }

    public static boolean k(String str) {
        int length = str.length();
        int[] iArr = new int[length];
        int i = 0;
        while (i < str.length()) {
            int i2 = i + 1;
            iArr[i] = Integer.parseInt(str.substring(i, i2));
            i = i2;
        }
        int[] iArr2 = new int[length];
        int i3 = 0;
        while (i3 < length) {
            int i4 = i3 + 1;
            iArr2[i3] = iArr[length - i4];
            i3 = i4;
        }
        int i5 = 0;
        for (int i6 = 0; i6 < length; i6++) {
            i5 = f7066a[i5][b[i6 % 8][iArr2[i6]]];
        }
        if (i5 == 0) {
            return true;
        }
        return false;
    }

    public Bi b(String str) {
        return C1351qm.a;
    }

    public Object c(Object obj) {
        Subscription subscription = (Subscription) obj;
        Cu.f3555a.c().getClass();
        return subscription;
    }

    public void a() {
    }

    public void onAnimationCancel() {
    }
}
