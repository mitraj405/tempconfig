package defpackage;

import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.RingtoneManager;
import com.momagic.C0835h;
import com.momagic.H;
import in.juspay.hypersdk.analytics.LogConstants;
import java.math.BigInteger;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: Q7  reason: default package */
/* compiled from: DATBNotificationChannelHandler */
public final class Q7 {
    public static String a(Context context, NotificationManager notificationManager, C1203jp jpVar) {
        int i;
        Object opt;
        JSONArray jSONArray;
        Object opt2;
        JSONArray jSONArray2;
        boolean z;
        Context context2 = context;
        NotificationManager notificationManager2 = notificationManager;
        C1203jp jpVar2 = jpVar;
        if (context2 == null) {
            return null;
        }
        try {
            C1139gq c = C1139gq.c(context);
            if (c.e("customChannelCurrentDate").equalsIgnoreCase(H.p()) || notificationManager.getNotificationChannels().size() <= 49) {
                String str = jpVar2.O;
                if (str == null || str.isEmpty()) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject(jpVar2.O);
                if (jSONObject.length() == 0) {
                    return null;
                }
                String optString = jSONObject.optString("i");
                if (!optString.isEmpty()) {
                    String optString2 = jSONObject.optString("n");
                    int i2 = jpVar2.e;
                    boolean z2 = true;
                    if (i2 != 1) {
                        i = 2;
                        if (i2 != 2) {
                            i = 3;
                            if (i2 != 3) {
                                i = 4;
                            }
                        }
                    } else {
                        i = 1;
                    }
                    NotificationChannel notificationChannel = new NotificationChannel(optString, optString2, i);
                    if (jSONObject.has("gi")) {
                        String optString3 = jSONObject.optString("gi");
                        if (!optString3.isEmpty()) {
                            notificationManager2.createNotificationChannelGroup(new NotificationChannelGroup(optString3, jSONObject.optString("gn")));
                            notificationChannel.setGroup(optString3);
                        }
                    }
                    if (jSONObject.has("d")) {
                        notificationChannel.setDescription(jSONObject.optString("d"));
                    }
                    int i3 = jpVar2.d;
                    int i4 = -1;
                    if (i3 != -1) {
                        if (i3 != 0) {
                            i4 = 1;
                        } else {
                            i4 = 0;
                        }
                    }
                    notificationChannel.setLockscreenVisibility(i4);
                    int i5 = jpVar2.k;
                    if (i5 != 0) {
                        if (i5 == 1) {
                            z = true;
                        } else {
                            z = false;
                        }
                        notificationChannel.setShowBadge(z);
                    }
                    if (!jpVar2.r.isEmpty()) {
                        if (!jpVar2.r.equalsIgnoreCase(LogConstants.DEFAULT_CHANNEL)) {
                            if (jpVar2.r.equalsIgnoreCase("off")) {
                                notificationChannel.enableLights(false);
                            } else {
                                notificationChannel.enableLights(true);
                                if (d(jpVar2.r) != 0) {
                                    notificationChannel.setLightColor(d(jpVar2.r));
                                }
                            }
                        }
                    }
                    if (!jpVar2.P.isEmpty() && !jpVar2.P.equalsIgnoreCase(LogConstants.DEFAULT_CHANNEL)) {
                        if (jpVar2.P.equalsIgnoreCase("off")) {
                            notificationChannel.enableVibration(false);
                        } else {
                            notificationChannel.enableVibration(true);
                            if (e(jpVar2.P) != null) {
                                notificationChannel.setVibrationPattern(e(jpVar2.P));
                            }
                        }
                    }
                    if (jSONObject.has("chnl_bdnd")) {
                        if (jSONObject.optInt("chnl_bdnd") != 1) {
                            z2 = false;
                        }
                        notificationChannel.setBypassDnd(z2);
                    }
                    if (!jpVar2.q.isEmpty() && !jpVar2.q.equalsIgnoreCase(LogConstants.DEFAULT_CHANNEL)) {
                        notificationChannel.setSound(H.o(context2, jpVar2.q), (AudioAttributes) null);
                    }
                    if (jSONObject.has("delchnl_id") && (opt2 = jSONObject.opt("delchnl_id")) != null) {
                        try {
                            if (opt2 instanceof String) {
                                jSONArray2 = new JSONArray((String) opt2);
                            } else {
                                jSONArray2 = (JSONArray) opt2;
                            }
                            for (int i6 = 0; i6 < jSONArray2.length(); i6++) {
                                notificationManager2.deleteNotificationChannel(String.valueOf(jSONArray2.get(i6)));
                            }
                        } catch (Exception e) {
                            H.r(context2, e.toString(), "deleteNotificationChannel()", "DATBNotificationChannelHandler");
                        }
                    }
                    if (jSONObject.has("delgrp_id") && (opt = jSONObject.opt("delgrp_id")) != null) {
                        try {
                            if (opt instanceof String) {
                                jSONArray = new JSONArray((String) opt);
                            } else {
                                jSONArray = (JSONArray) opt;
                            }
                            for (int i7 = 0; i7 < jSONArray.length(); i7++) {
                                notificationManager2.deleteNotificationChannelGroup(String.valueOf(jSONArray.get(i7)));
                            }
                        } catch (Exception e2) {
                            H.r(context2, e2.toString(), "deleteNotificationChannelGroup()", "DATBNotificationChannelHandler");
                        }
                    }
                    notificationManager2.createNotificationChannel(notificationChannel);
                }
                return optString;
            }
            c.h("customChannelCurrentDate", H.p());
            H.r(context2, "Limit exceed; cannot create more channels", "createCustomNotificationChannel()", "DATBNotificationChannelHandler");
            return null;
        } catch (Exception e3) {
            e3.toString();
            H.r(context2, "Channel Name and id should not be empty. " + e3, "createCustomNotificationChannel()", "DATBNotificationChannelHandler");
            return null;
        }
    }

    public static String b(Context context, NotificationManager notificationManager, C1203jp jpVar) {
        String str = null;
        if (context == null) {
            return null;
        }
        try {
            String string = context.getString(C0772Zr.default_notification_channel_id);
            try {
                NotificationChannel notificationChannel = new NotificationChannel(string, "Updates and Notifications", 4);
                if (!jpVar.q.isEmpty()) {
                    notificationChannel.setSound(H.o(context, jpVar.q), (AudioAttributes) null);
                } else {
                    notificationChannel.setSound(RingtoneManager.getDefaultUri(2), (AudioAttributes) null);
                }
                notificationManager.createNotificationChannel(notificationChannel);
                return string;
            } catch (Exception e) {
                e = e;
                str = string;
                e.toString();
                H.r(context, e.toString(), "createDefaultNotificationChannel()", "DATBNotificationChannelHandler");
                return str;
            }
        } catch (Exception e2) {
            e = e2;
            e.toString();
            H.r(context, e.toString(), "createDefaultNotificationChannel()", "DATBNotificationChannelHandler");
            return str;
        }
    }

    public static String c(Context context, NotificationManager notificationManager, C1203jp jpVar) {
        String str;
        if (context == null) {
            return null;
        }
        try {
            String str2 = jpVar.N;
            if (str2 != null && !str2.isEmpty()) {
                String trim = jpVar.N.trim();
                if (notificationManager.getNotificationChannel(trim) != null) {
                    return trim;
                }
            }
            String str3 = jpVar.O;
            if (str3 == null || str3.isEmpty()) {
                str = b(context, notificationManager, jpVar);
            } else {
                str = a(context, notificationManager, jpVar);
            }
            return str;
        } catch (Exception e) {
            H.r(context, e.toString(), "createNotificationChannel()", "DATBNotificationChannelHandler");
            return null;
        }
    }

    public static int d(String str) {
        try {
            if (Pattern.compile("^([A-Fa-f0-9]{8})$").matcher(str).matches()) {
                return new BigInteger(str, 16).intValue();
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    public static long[] e(String str) {
        JSONArray jSONArray;
        try {
            if (str instanceof String) {
                jSONArray = new JSONArray(str);
            } else {
                jSONArray = (JSONArray) str;
            }
            long[] jArr = new long[jSONArray.length()];
            for (int i = 0; i < jSONArray.length(); i++) {
                jArr[i] = jSONArray.optLong(i);
            }
            return jArr;
        } catch (Exception e) {
            H.r(C0835h.f4046a, e.toString(), "Util", "parseVibrationPattern");
            return null;
        }
    }
}
