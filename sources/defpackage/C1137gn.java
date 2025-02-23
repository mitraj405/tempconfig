package defpackage;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import com.momagic.C0835h;
import com.momagic.H;
import com.momagic.NotificationActionReceiver;
import com.momagic.NotificationDismissedReceiver;
import com.momagic.TargetActivity;
import java.util.regex.Pattern;

/* renamed from: gn  reason: default package and case insensitive filesystem */
/* compiled from: NotificationPreview */
public final class C1137gn {
    public static int a;

    /* renamed from: a  reason: collision with other field name */
    public static long f5469a;
    public static int b;

    /* renamed from: b  reason: collision with other field name */
    public static long f5470b;

    public static int i() {
        int identifier = C0835h.f4046a.getResources().getIdentifier("ic_stat_datb_default", "drawable", C0835h.f4046a.getPackageName());
        if (identifier != 0) {
            return identifier;
        }
        return 17301598;
    }

    public static Intent j(C1203jp jpVar, String str, String str2, String str3, String str4, String str5, String str6, int i) {
        Intent intent;
        String str7;
        String str8 = jpVar.f5525a;
        if ((str8 == null || str8.isEmpty()) && ((str7 = jpVar.f5525a) == null || str7.isEmpty())) {
            if ((str.contains("{~TOKEN~}") || str.contains("{~DEVICEID~}") || str.contains("{~UUID~}") || str.contains("{~FCMTOKEN~}")) && C1139gq.c(C0835h.f4046a).e("deviceToken") != null) {
                str = str.replace("{~TOKEN~}", C1139gq.c(C0835h.f4046a).e("deviceToken")).replace("{~DEVICEID~}", H.g(C0835h.f4046a)).replace("{~UUID~}", H.g(C0835h.f4046a)).replace("{~FCMTOKEN~}", C1139gq.c(C0835h.f4046a).e("deviceToken"));
            }
            if ((str2.contains("{~TOKEN~}") || str2.contains("{~DEVICEID~}") || str2.contains("{~UUID~}") || str2.contains("{~FCMTOKEN~}")) && C1139gq.c(C0835h.f4046a).e("deviceToken") != null) {
                str2 = str2.replace("{~TOKEN~}", C1139gq.c(C0835h.f4046a).e("deviceToken")).replace("{~DEVICEID~}", H.g(C0835h.f4046a)).replace("{~UUID~}", H.g(C0835h.f4046a)).replace("{~FCMTOKEN~}", C1139gq.c(C0835h.f4046a).e("deviceToken"));
            }
            if ((str3.contains("{~TOKEN~}") || str3.contains("{~DEVICEID~}") || str3.contains("{~UUID~}") || str3.contains("{~FCMTOKEN~}")) && C1139gq.c(C0835h.f4046a).e("deviceToken") != null) {
                str3 = str3.replace("{~TOKEN~}", C1139gq.c(C0835h.f4046a).e("deviceToken")).replace("{~DEVICEID~}", H.g(C0835h.f4046a)).replace("{~UUID~}", H.g(C0835h.f4046a)).replace("{~FCMTOKEN~}", C1139gq.c(C0835h.f4046a).e("deviceToken"));
            }
        }
        if (Build.VERSION.SDK_INT >= 31) {
            intent = new Intent(C0835h.f4046a, TargetActivity.class);
        } else {
            intent = new Intent(C0835h.f4046a, NotificationActionReceiver.class);
        }
        if (str == null) {
            str = "";
        }
        intent.putExtra("WEB_URL", str);
        intent.putExtra("keyNotificationId", i);
        intent.putExtra("keyInApp", jpVar.c);
        intent.putExtra("cid", jpVar.f5529c);
        intent.putExtra("rid", jpVar.f5530d);
        intent.putExtra("btn", 1);
        intent.putExtra("ap", jpVar.w);
        intent.putExtra("call", str4);
        intent.putExtra("act1ID", jpVar.u);
        intent.putExtra("act2ID", jpVar.v);
        intent.putExtra("landingURL", str);
        intent.putExtra("act1title", jpVar.m);
        intent.putExtra("act2title", jpVar.o);
        intent.putExtra("act1URL", str2);
        intent.putExtra("act2URL", str3);
        intent.putExtra("clickIndex", str5);
        intent.putExtra("lastclickIndex", str6);
        intent.putExtra("push_type", jpVar.K);
        intent.putExtra("cfgfordomain", jpVar.l);
        intent.putExtra("ti", jpVar.f5532f);
        return intent;
    }

    public static Intent k(C1203jp jpVar, int i) {
        Intent intent;
        Class<NotificationDismissedReceiver> cls = NotificationDismissedReceiver.class;
        if (Build.VERSION.SDK_INT >= 31) {
            intent = new Intent(C0835h.f4046a, cls);
        } else {
            intent = new Intent(C0835h.f4046a, cls);
        }
        intent.putExtra("WEB_URL", jpVar.f5531e);
        intent.putExtra("keyNotificationId", i);
        intent.putExtra("keyInApp", jpVar.c);
        intent.putExtra("cid", jpVar.f5529c);
        intent.putExtra("rid", jpVar.f5530d);
        intent.putExtra("btn", 3);
        intent.putExtra("ap", jpVar.w);
        intent.putExtra("call", "phone");
        intent.putExtra("act1ID", jpVar.u);
        intent.putExtra("act2ID", jpVar.v);
        intent.putExtra("landingURL", jpVar.f5531e);
        intent.putExtra("act1title", jpVar.m);
        intent.putExtra("act2title", jpVar.o);
        intent.putExtra("act1URL", jpVar.n);
        intent.putExtra("act2URL", jpVar.p);
        intent.putExtra("clickIndex", "0");
        intent.putExtra("lastclickIndex", "0");
        intent.putExtra("push_type", jpVar.K);
        intent.putExtra("cfgfordomain", jpVar.l);
        return intent;
    }

    public static boolean l(String str) {
        return Pattern.compile("[0-9]").matcher(str).find();
    }

    public static PendingIntent m(String str) {
        if (str == null || str.isEmpty()) {
            Intent intent = new Intent();
            intent.setFlags(268468224);
            intent.setAction("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.TEXT", "no url found here");
            intent.setType("text/plain");
            return PendingIntent.getActivity(C0835h.f4046a, (int) System.currentTimeMillis(), intent, 201326592);
        }
        Intent intent2 = new Intent();
        intent2.setFlags(268468224);
        intent2.setAction("android.intent.action.SEND");
        intent2.putExtra("android.intent.extra.TEXT", str);
        intent2.setType("text/plain");
        return PendingIntent.getActivity(C0835h.f4046a, (int) System.currentTimeMillis(), intent2, 201326592);
    }
}
