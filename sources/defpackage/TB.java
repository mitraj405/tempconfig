package defpackage;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import java.util.regex.Pattern;

/* renamed from: TB  reason: default package */
/* compiled from: Utility */
public final class TB {
    public static boolean a(String str) {
        try {
            int parseInt = Integer.parseInt(str);
            if ((parseInt < 508500 || parseInt > 508999) && ((parseInt < 606985 || parseInt > 607384) && ((parseInt < 607385 || parseInt > 607484) && ((parseInt < 607485 || parseInt > 607984) && ((parseInt < 608001 || parseInt > 608100) && ((parseInt < 608101 || parseInt > 608200) && ((parseInt < 608201 || parseInt > 608300) && ((parseInt < 608301 || parseInt > 608350) && ((parseInt < 608351 || parseInt > 608500) && ((parseInt < 652150 || parseInt > 652849) && ((parseInt < 652850 || parseInt > 653049) && (parseInt < 653050 || parseInt > 653149)))))))))))) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str) || !Pattern.compile("^(\\+\\d{1,3}[- ]?)?(0{1})?([9,8,7])\\d{9}$", 2).matcher(str).matches()) {
            return false;
        }
        return true;
    }

    public static void c(View view, boolean z, Context context) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        if (z) {
            inputMethodManager.toggleSoftInput(2, 0);
        } else {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static double d(double d) {
        double pow = (double) ((long) Math.pow(10.0d, (double) 2));
        return ((double) Math.round(d * pow)) / pow;
    }
}
