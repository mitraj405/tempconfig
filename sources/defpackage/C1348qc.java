package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.StrictMode;
import com.google.common.base.Ascii;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.momagic.H;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

/* renamed from: qc  reason: default package and case insensitive filesystem */
/* compiled from: FirebaseAnalyticsTrack */
public final class C1348qc {
    public static Class<?> a;

    /* renamed from: a  reason: collision with other field name */
    public static AtomicLong f6896a;

    /* renamed from: a  reason: collision with other field name */
    public static C1203jp f6897a;
    public static AtomicLong b;

    /* renamed from: a  reason: collision with other field name */
    public final Context f6898a;

    /* renamed from: a  reason: collision with other field name */
    public Object f6899a;

    public C1348qc(Context context) {
        this.f6898a = context;
    }

    @SuppressLint({"SimpleDateFormat"})
    public static Date a(String str) {
        try {
            return new SimpleDateFormat("hh:mm:ss aa").parse(str);
        } catch (ParseException unused) {
            return new Date(0);
        }
    }

    public static Bundle b(C1203jp jpVar) {
        String str;
        String str2 = jpVar.f5531e;
        if (str2 == null) {
            return null;
        }
        try {
            HashMap hashMap = new HashMap();
            String[] split = str2.split("\\?");
            if (split.length > 1) {
                for (String split2 : split[1].split("&")) {
                    String[] split3 = split2.split("=");
                    String decode = URLDecoder.decode(split3[0], "UTF-8");
                    if (split3.length > 1) {
                        str = URLDecoder.decode(split3[1], "UTF-8");
                    } else {
                        str = "";
                    }
                    List list = (List) hashMap.get(decode);
                    if (list == null) {
                        list = new ArrayList();
                        hashMap.put(decode, list);
                    }
                    list.add(str);
                }
            }
            JSONObject jSONObject = new JSONObject(hashMap);
            String optString = jSONObject.optString("utm_source");
            String optString2 = jSONObject.optString("utm_medium");
            String optString3 = jSONObject.optString("utm_campaign");
            String optString4 = jSONObject.optString("utm_term");
            String optString5 = jSONObject.optString("utm_content");
            String replaceAll = optString.replaceAll("]", "").replaceAll("\\[", "");
            String replaceAll2 = optString2.replaceAll("]", "").replaceAll("\\[", "");
            String replaceAll3 = optString3.replaceAll("]", "").replaceAll("\\[", "");
            String replaceAll4 = optString4.replaceAll("]", "").replaceAll("\\[", "");
            String replaceAll5 = optString5.replaceAll("]", "").replaceAll("\\[", "");
            Bundle bundle = new Bundle();
            if (replaceAll != null && !replaceAll.isEmpty()) {
                bundle.putString("source", replaceAll);
            }
            if (replaceAll2 != null && !replaceAll2.isEmpty()) {
                bundle.putString("medium", replaceAll2);
            }
            bundle.putString("notification_id", jpVar.f5529c);
            if (replaceAll3 != null && !replaceAll3.isEmpty()) {
                bundle.putString("campaign", replaceAll3);
            }
            if (replaceAll4 != null && !replaceAll4.isEmpty()) {
                bundle.putString(FirebaseAnalytics.Param.TERM, replaceAll4);
            }
            if (replaceAll5 != null && !replaceAll5.isEmpty()) {
                bundle.putString(FirebaseAnalytics.Param.CONTENT, replaceAll5);
            }
            return bundle;
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    public static String d() {
        long j;
        long j2;
        long j3;
        boolean z = false;
        try {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
            DatagramSocket datagramSocket = new DatagramSocket();
            datagramSocket.setSoTimeout(30000);
            byte[] bArr = new byte[48];
            DatagramPacket datagramPacket = new DatagramPacket(bArr, 48, InetAddress.getByName("pool.ntp.org"), 123);
            bArr[0] = Ascii.ESC;
            long currentTimeMillis = System.currentTimeMillis();
            long j4 = currentTimeMillis / 1000;
            long j5 = j4 + 2208988800L;
            bArr[40] = (byte) ((int) (j5 >> 24));
            bArr[41] = (byte) ((int) (j5 >> 16));
            bArr[42] = (byte) ((int) (j5 >> 8));
            bArr[43] = (byte) ((int) (j5 >> 0));
            long j6 = ((currentTimeMillis - (j4 * 1000)) * 4294967296L) / 1000;
            bArr[44] = (byte) ((int) (j6 >> 24));
            bArr[45] = (byte) ((int) (j6 >> 16));
            bArr[46] = (byte) ((int) (j6 >> 8));
            bArr[47] = (byte) ((int) (Math.random() * 255.0d));
            DatagramSocket datagramSocket2 = datagramSocket;
            datagramSocket2.send(datagramPacket);
            datagramSocket2.receive(new DatagramPacket(bArr, 48));
            j2 = System.nanoTime() / 1000;
            long nanoTime = (j2 - (System.nanoTime() / 1000)) + currentTimeMillis;
            datagramSocket2.close();
            long b2 = C1267mx.b(24, bArr);
            long b3 = C1267mx.b(32, bArr);
            j = nanoTime + (((C1267mx.b(40, bArr) - nanoTime) + (b3 - b2)) / 2);
            z = true;
        } catch (Exception unused) {
            j2 = 0;
            j = 0;
        }
        if (z) {
            j3 = ((System.nanoTime() / 1000) + j) - j2;
            System.out.println(new Date(j3).toString());
        } else {
            j3 = 0;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss aa");
        String format = simpleDateFormat.format(new Date(j3));
        Date date = new Date();
        try {
            date = simpleDateFormat.parse(format);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Date a2 = a("12:00:00 PM");
        Date a3 = a("02:00:00 PM");
        Date a4 = a("04:00:00 PM");
        Date a5 = a("06:00:00 PM");
        Date a6 = a("08:00:00 PM");
        Date a7 = a("10:00:00 PM");
        Date a8 = a("12:00:00 AM");
        Date a9 = a("02:00:00 AM");
        Date a10 = a("04:00:00 AM");
        Date a11 = a("06:00:00 AM");
        Date a12 = a("08:00:00 AM");
        Date a13 = a("10:00:00 AM");
        if (date.after(a2) && date.before(a3)) {
            return "12-2 PM";
        }
        if (date.after(a3) && date.before(a4)) {
            return "2-4 PM";
        }
        if (date.after(a4) && date.before(a5)) {
            return "4-6 PM";
        }
        if (date.after(a5) && date.before(a6)) {
            return "6-8 PM";
        }
        if (date.after(a6) && date.before(a7)) {
            return "8-10 PM";
        }
        if (date.after(a7) && date.before(a8)) {
            return "10-12 AM";
        }
        if (date.after(a8) && date.before(a9)) {
            return "12-2 AM";
        }
        if (date.after(a9) && date.before(a10)) {
            return "2-4 AM";
        }
        if (date.after(a10) && date.before(a11)) {
            return "4-6 AM";
        }
        if (date.after(a11) && date.before(a12)) {
            return "6-8 AM";
        }
        if (date.after(a12) && date.before(a13)) {
            return "8-10 AM";
        }
        if (!date.after(a13) || !date.before(a2)) {
            return "";
        }
        return "10-12 PM";
    }

    public static Method e(Class cls) {
        try {
            return cls.getMethod("logEvent", new Class[]{String.class, Bundle.class});
        } catch (Exception unused) {
            return null;
        }
    }

    public final Object c(Context context) {
        Method method;
        if (context != null && this.f6899a == null) {
            try {
                method = a.getMethod("getInstance", new Class[]{Context.class});
            } catch (Exception unused) {
                method = null;
            }
            try {
                this.f6899a = method.invoke((Object) null, new Object[]{context});
            } catch (Throwable th) {
                H.w(this.f6898a, th.toString(), "FirebaseAnalyticsClass", "getInstanceOfFirebaseAnalytics");
                return null;
            }
        }
        return this.f6899a;
    }
}
