package defpackage;

import android.os.Bundle;
import com.google.firebase.analytics.FirebaseAnalytics;
import cris.org.in.ima.IrctcImaApplication;
import java.text.SimpleDateFormat;

/* renamed from: z0  reason: default package and case insensitive filesystem */
/* compiled from: AnalyticsUtils */
public final class C1507z0 {
    public static final /* synthetic */ int a = 0;

    static {
        C1354qp.R(C1507z0.class);
    }

    public static String a(String str) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").format(new SimpleDateFormat("yyyyMMdd").parse(str));
        } catch (Exception unused) {
            return null;
        }
    }

    public static void b() {
        IrctcImaApplication.f4146a.logEvent(FirebaseAnalytics.Event.ADD_PAYMENT_INFO, new Bundle());
    }

    public static void c(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_CATEGORY, "Trains");
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, str);
        bundle.putString(FirebaseAnalytics.Param.START_DATE, a(str2));
        bundle.putString("origin", str3);
        bundle.putString(FirebaseAnalytics.Param.DESTINATION, str4);
        bundle.putString(FirebaseAnalytics.Param.TRAVEL_CLASS, str5);
        bundle.putString("journey_quota", str6);
        bundle.putString(FirebaseAnalytics.Param.CURRENCY, "INR");
        bundle.putString("value", str7);
        bundle.putString("adult_passenger", str8);
        bundle.putString("child_passenger", str9);
        bundle.putString("payment_flag", str10);
        IrctcImaApplication.f4146a.logEvent("AvlInfo", bundle);
        str10.equalsIgnoreCase("Y");
    }

    public static void d(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.SEARCH_TERM, "TrainSchedule");
        bundle.putString(FirebaseAnalytics.Param.ITEM_CATEGORY, "Trains");
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, str);
        IrctcImaApplication.f4146a.logEvent(FirebaseAnalytics.Event.VIEW_ITEM, bundle);
    }
}
