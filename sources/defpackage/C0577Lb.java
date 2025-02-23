package defpackage;

import android.content.Context;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.momagic.C0835h;
import com.momagic.H;

/* renamed from: Lb  reason: default package and case insensitive filesystem */
/* compiled from: FCMTokenGenerator */
public final class C0577Lb {
    public static FirebaseApp a;

    public static String a() {
        Context context = C0835h.f4046a;
        if (context != null) {
            try {
                String apiKey = FirebaseOptions.fromResource(context).getApiKey();
                if (apiKey != null) {
                    return apiKey;
                }
            } catch (Exception e) {
                H.r(C0835h.f4046a, e.toString(), "FCMTokenGenerator", "getAPiKey");
            }
        }
        return "";
    }

    public static String b() {
        Context context = C0835h.f4046a;
        if (context != null) {
            try {
                String projectId = FirebaseOptions.fromResource(context).getProjectId();
                if (projectId != null) {
                    return projectId;
                }
            } catch (Exception e) {
                H.r(C0835h.f4046a, e.toString(), "FCMTokenGenerator", "getProjectID");
            }
        }
        return "";
    }

    public static void c(String str) {
        String str2;
        if (a == null && b() != (str2 = "") && a() != str2 && str != str2) {
            FirebaseOptions.Builder gcmSenderId = new FirebaseOptions.Builder().setGcmSenderId(str);
            Context context = C0835h.f4046a;
            if (context != null) {
                try {
                    String applicationId = FirebaseOptions.fromResource(context).getApplicationId();
                    if (applicationId != null) {
                        str2 = applicationId;
                    }
                } catch (Exception e) {
                    H.r(C0835h.f4046a, e.toString(), "FCMTokenGeneration", "getAppID");
                }
            }
            FirebaseApp initializeApp = FirebaseApp.initializeApp(C0835h.f4046a, gcmSenderId.setApplicationId(str2).setApiKey(a()).setProjectId(b()).build(), "MOMAGIC");
            a = initializeApp;
            initializeApp.getName();
        }
    }
}
