package defpackage;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Handler;
import android.text.InputFilter;
import android.text.Spannable;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.common.net.HttpHeaders;
import cris.org.in.ima.IrctcImaApplication;
import cris.org.in.ima.activities.IRCTCConnectActivity;
import cris.org.in.ima.dto.oauth2.GoogleAdParamDTO;
import cris.org.in.ima.fragment.MyAccountFragment;
import cris.org.in.ima.model.FevJourneyModel;
import cris.org.in.ima.model.MasterPassengerModel;
import cris.org.in.ima.model.StationModel;
import cris.org.in.ima.utils.NoUnderlineSpan;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.MaxWLRacCnfDTO;
import cris.prs.webservices.dto.MealItemDetails;
import cris.prs.webservices.dto.RecentTransactionsDTO;
import defpackage.d7;
import in.juspay.hyper.constants.LogCategory;
import in.juspay.hypersdk.core.PaymentConstants;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;

/* renamed from: I5  reason: default package and case insensitive filesystem */
/* compiled from: CommonUtil */
public final class C0535I5 {
    public static int a = 0;

    /* renamed from: a  reason: collision with other field name */
    public static C0488Ds f3615a = null;

    /* renamed from: a  reason: collision with other field name */
    public static b f3616a = new b();

    /* renamed from: a  reason: collision with other field name */
    public static C0549JD f3617a = null;

    /* renamed from: a  reason: collision with other field name */
    public static KD f3618a = null;

    /* renamed from: a  reason: collision with other field name */
    public static AlertDialog f3619a = null;

    /* renamed from: a  reason: collision with other field name */
    public static String f3620a = null;

    /* renamed from: a  reason: collision with other field name */
    public static final SimpleDateFormat f3621a = new SimpleDateFormat("ddMMyyyy");

    /* renamed from: a  reason: collision with other field name */
    public static ArrayList<String> f3622a = null;

    /* renamed from: a  reason: collision with other field name */
    public static HashMap<String, String> f3623a = null;

    /* renamed from: a  reason: collision with other field name */
    public static final CopyOnWriteArrayList f3624a = new CopyOnWriteArrayList();

    /* renamed from: a  reason: collision with other field name */
    public static boolean f3625a = false;
    public static int b;

    /* renamed from: b  reason: collision with other field name */
    public static String f3626b;

    /* renamed from: b  reason: collision with other field name */
    public static ArrayList<MaxWLRacCnfDTO> f3627b;

    /* renamed from: b  reason: collision with other field name */
    public static HashMap<String, String> f3628b = null;

    /* renamed from: b  reason: collision with other field name */
    public static final CopyOnWriteArrayList f3629b = new CopyOnWriteArrayList();

    /* renamed from: b  reason: collision with other field name */
    public static boolean f3630b = true;
    public static int c;

    /* renamed from: c  reason: collision with other field name */
    public static String f3631c;

    /* renamed from: c  reason: collision with other field name */
    public static ArrayList<MasterPassengerModel> f3632c = new ArrayList<>();

    /* renamed from: c  reason: collision with other field name */
    public static HashMap<String, String> f3633c = null;

    /* renamed from: c  reason: collision with other field name */
    public static boolean f3634c;
    public static int d = 0;

    /* renamed from: d  reason: collision with other field name */
    public static String f3635d;

    /* renamed from: d  reason: collision with other field name */
    public static ArrayList<StationModel> f3636d = new ArrayList<>();

    /* renamed from: d  reason: collision with other field name */
    public static HashMap<String, ArrayList<String>> f3637d = null;

    /* renamed from: d  reason: collision with other field name */
    public static boolean f3638d = false;
    public static int e = 0;

    /* renamed from: e  reason: collision with other field name */
    public static String f3639e;

    /* renamed from: e  reason: collision with other field name */
    public static ArrayList<FevJourneyModel> f3640e = new ArrayList<>();

    /* renamed from: e  reason: collision with other field name */
    public static boolean f3641e = false;
    public static String f;

    /* renamed from: f  reason: collision with other field name */
    public static ArrayList<RecentTransactionsDTO> f3642f = new ArrayList<>();

    /* renamed from: f  reason: collision with other field name */
    public static boolean f3643f = false;
    public static String g = "";

    /* renamed from: g  reason: collision with other field name */
    public static ArrayList<RecentTransactionsDTO> f3644g = new ArrayList<>();

    /* renamed from: g  reason: collision with other field name */
    public static boolean f3645g = false;
    public static String h = "";

    /* renamed from: h  reason: collision with other field name */
    public static final ArrayList<String> f3646h = new ArrayList<>();

    /* renamed from: h  reason: collision with other field name */
    public static boolean f3647h = false;
    public static String i = "";

    /* renamed from: i  reason: collision with other field name */
    public static boolean f3648i = false;
    public static String j = "";

    /* renamed from: j  reason: collision with other field name */
    public static boolean f3649j = false;
    public static String k = null;

    /* renamed from: k  reason: collision with other field name */
    public static boolean f3650k = false;
    public static String l = null;

    /* renamed from: l  reason: collision with other field name */
    public static boolean f3651l = false;
    public static final String m = "";

    /* renamed from: m  reason: collision with other field name */
    public static boolean f3652m = false;
    public static boolean n = false;
    public static boolean o;

    /* renamed from: I5$a */
    /* compiled from: CommonUtil */
    public class a implements NativeAdListener {
        public final void onAdClicked(Ad ad) {
            AlertDialog alertDialog = C0535I5.f3619a;
        }

        public final void onAdLoaded(Ad ad) {
            AlertDialog alertDialog = C0535I5.f3619a;
        }

        public final void onError(Ad ad, AdError adError) {
            AlertDialog alertDialog = C0535I5.f3619a;
            adError.getErrorMessage();
        }

        public final void onLoggingImpression(Ad ad) {
            AlertDialog alertDialog = C0535I5.f3619a;
        }

        public final void onMediaDownloaded(Ad ad) {
            AlertDialog alertDialog = C0535I5.f3619a;
        }
    }

    /* renamed from: I5$b */
    /* compiled from: CommonUtil */
    public static class b {
        public Boolean a;

        /* renamed from: a  reason: collision with other field name */
        public Long f3653a;

        /* renamed from: a  reason: collision with other field name */
        public String f3654a;

        /* renamed from: a  reason: collision with other field name */
        public Date f3655a;
    }

    static {
        C1354qp.R(C0535I5.class);
        new ArrayList();
        new Date();
    }

    public static String A(Date date, Date date2) {
        long time = date2.getTime() - date.getTime();
        long j2 = (time / 60000) % 60;
        long j3 = time / 3600000;
        if (j3 == 0) {
            return j2 + "m";
        }
        return j3 + "h :" + j2 + "m";
    }

    public static ArrayList<MasterPassengerModel> B() {
        return f3632c;
    }

    public static CopyOnWriteArrayList C() {
        return f3624a;
    }

    public static HashMap<String, ArrayList<String>> D() {
        return f3637d;
    }

    public static int E() {
        return d;
    }

    public static String F(Date date) {
        if (date != null) {
            return new SimpleDateFormat("dd MMM, yyyy").format(date);
        }
        return "";
    }

    public static C0479D5 G(FragmentActivity fragmentActivity, int i2) {
        return new C0479D5(fragmentActivity, i2);
    }

    public static void H(Activity activity, View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        if (inputMethodManager != null && view != null && view.getWindowToken() != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 2);
        }
    }

    public static void I(Activity activity) {
        InputMethodManager inputMethodManager;
        if (activity != null && activity.getCurrentFocus() != null && (inputMethodManager = (InputMethodManager) activity.getSystemService("input_method")) != null) {
            inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
        }
    }

    public static boolean J(String str) {
        if (str.contains(new String[]{"webtoken"}[0])) {
            return true;
        }
        return false;
    }

    public static boolean K(String str) {
        if (Pattern.compile("^[a-zA-Z0-9]+$").matcher(str).matches()) {
            return true;
        }
        return false;
    }

    public static boolean L() {
        return f3647h;
    }

    public static boolean M() {
        String str;
        HashMap<String, String> hashMap = C1450w1.f7023c;
        if (hashMap == null || (str = hashMap.get("FORCE_LOGIN_TIME")) == null || str.equals("")) {
            return true;
        }
        String[] split = str.split(",");
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date());
        long j2 = ((long) (instance.get(14) + ((instance.get(13) + ((instance.get(12) + (instance.get(11) * 60)) * 60)) * 1000))) + C1450w1.f7015b;
        for (String str2 : split) {
            if (!str2.equals("")) {
                String[] split2 = str2.split("-");
                int parseInt = Integer.parseInt(split2[1]) * 60 * 1000;
                if (j2 >= ((long) (Integer.parseInt(split2[0]) * 60 * 1000)) && j2 <= ((long) parseInt)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean N(String str) {
        return Pattern.compile("^[6-9]\\d{9}$").matcher(str).matches();
    }

    public static boolean O(ConnectivityManager connectivityManager, Context context) {
        boolean z;
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                t0(context, context.getString(R.string.data_connection_error_message));
            }
            return z;
        } catch (Exception e2) {
            e2.getMessage();
            if (context != null) {
                t0(context, context.getString(R.string.unable_process_message));
            }
            return false;
        }
    }

    public static boolean P(String str) {
        if (Pattern.compile("[a-zA-Z\\s]*").matcher(str).matches()) {
            return true;
        }
        return false;
    }

    public static String Q(String str) {
        String str2;
        String[] strArr;
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        String str3;
        HashMap<String, String> hashMap = C1450w1.f7023c;
        String str4 = null;
        if (hashMap == null || (str2 = hashMap.get(str)) == null || str2.equals("")) {
            return null;
        }
        String[] split = str2.split(",");
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date());
        long j2 = (long) (instance.get(12) + (instance.get(11) * 60));
        int length = split.length;
        int i2 = 0;
        char c2 = 0;
        boolean z = false;
        while (true) {
            if (i2 >= length) {
                break;
            }
            String str5 = split[i2];
            if (!str5.equals("")) {
                String[] split2 = str5.split("-");
                int parseInt = Integer.parseInt(split2[c2]);
                int parseInt2 = Integer.parseInt(split2[1]);
                int i3 = parseInt / 60;
                int i4 = parseInt % 60;
                int i5 = parseInt2 / 60;
                int i6 = parseInt2 % 60;
                StringBuilder sb = new StringBuilder();
                if (i3 > 9) {
                    obj = Integer.valueOf(i3);
                } else {
                    obj = lf.h("0", i3);
                }
                sb.append(obj);
                sb.append(":");
                if (i4 > 9) {
                    obj2 = Integer.valueOf(i4);
                } else {
                    obj2 = lf.h("0", i4);
                }
                sb.append(obj2);
                sb.append(" Hrs");
                String sb2 = sb.toString();
                StringBuilder sb3 = new StringBuilder();
                strArr = split;
                if (i5 > 9) {
                    obj3 = Integer.valueOf(i5);
                } else {
                    obj3 = lf.h("0", i5);
                }
                sb3.append(obj3);
                sb3.append(":");
                if (i6 > 9) {
                    obj4 = Integer.valueOf(i6);
                } else {
                    obj4 = lf.h("0", i6);
                }
                sb3.append(obj4);
                sb3.append(" Hrs");
                String sb4 = sb3.toString();
                c2 = 0;
                if (j2 >= ((long) Integer.parseInt(split2[0])) && j2 <= ((long) Integer.parseInt(split2[1]))) {
                    z = true;
                }
                if (IrctcImaApplication.e.equalsIgnoreCase("hi")) {
                    str3 = xx.D(sb2, " से ", sb4);
                } else {
                    str3 = xx.D(sb2, " to ", sb4);
                }
                if (z) {
                    str4 = str3;
                    break;
                }
                if (str4 != null) {
                    str3 = xx.D(str4, ", ", str3);
                }
                str4 = str3;
            } else {
                strArr = split;
            }
            i2++;
            split = strArr;
        }
        if (z) {
            return str4;
        }
        return null;
    }

    public static boolean R() {
        if (C0793b1.a.f3912a != null) {
            return true;
        }
        return false;
    }

    public static boolean S(String str) {
        if (Pattern.compile("^(?=.*[0-9])(?=.*[a-zA-Z])([a-zA-Z0-9]+)$").matcher(str).matches()) {
            return true;
        }
        return false;
    }

    public static boolean T(String str) {
        if (Pattern.compile("^(?=.*[0-9])[A-Z0-9]{6,10}$").matcher(str).matches()) {
            return true;
        }
        return false;
    }

    public static String U(Date date) {
        if (IrctcImaApplication.e.equals("hi")) {
            return new SimpleDateFormat("EEE, dd MMM", new Locale("hi", "IN")).format(date);
        }
        new SimpleDateFormat("yyyy-MM-dd");
        return new SimpleDateFormat("EEE, dd MMM").format(date);
    }

    public static String V(Date date) {
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return new SimpleDateFormat("HH:mm").format(date);
    }

    public static void W(String str, boolean z, C0822cf cfVar, String str2, String str3) {
        try {
            C0822cf.f3936a = z;
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put("requestId", UUID.randomUUID().toString());
            jSONObject.put(PaymentConstants.SERVICE, C1450w1.f7008a.getServiceUrl());
            String str4 = "";
            String str5 = C1480xl.f7038a.f7046c;
            if (str5 != null) {
                str4 = str5;
            }
            if (!(str2 == null || str3 == null)) {
                jSONObject2.put(PaymentConstants.ORDER_DETAILS_CAMEL, str2);
                jSONObject2.put(PaymentConstants.SIGNATURE, str3);
            }
            jSONObject2.put(LogCategory.ACTION, "resumePayment");
            jSONObject2.put("status", z);
            jSONObject2.put("txnReference", str4);
            jSONObject2.put("reason", str);
            jSONObject.put(PaymentConstants.PAYLOAD, jSONObject2);
            C0822cf.f3936a = z;
            cfVar.getClass();
            jSONObject.toString();
            cfVar.getHyperServices().process(jSONObject);
        } catch (Exception e2) {
            C0822cf.f3936a = !z;
            e2.getMessage();
        }
    }

    public static String X(Date date) {
        if (IrctcImaApplication.e.equals("hi")) {
            return new SimpleDateFormat("HH:mm:ss dd MMM, yyyy", new Locale("hi", "IN")).format(date);
        }
        return new SimpleDateFormat("HH:mm:ss dd MMM, yyyy").format(date);
    }

    public static void Y(Activity activity, AdManagerAdView adManagerAdView, GoogleAdParamDTO googleAdParamDTO) {
        AdManagerAdRequest.Builder builder;
        AdManagerAdRequest.Builder builder2;
        AdManagerAdRequest.Builder builder3;
        AdManagerAdRequest.Builder builder4;
        AdManagerAdRequest.Builder builder5;
        AdManagerAdRequest.Builder builder6;
        AdManagerAdRequest.Builder builder7;
        AdManagerAdRequest.Builder builder8;
        AdManagerAdRequest.Builder builder9;
        AdManagerAdRequest.Builder builder10;
        AdManagerAdRequest.Builder builder11;
        try {
            AdManagerAdRequest.Builder builder12 = new AdManagerAdRequest.Builder();
            if (googleAdParamDTO != null) {
                if (googleAdParamDTO.getGender() != null) {
                    builder2 = builder12.addCustomTargeting("Gender", googleAdParamDTO.getGender().trim());
                } else {
                    builder2 = builder12.addCustomTargeting("Gender", "0");
                }
                if (googleAdParamDTO.getAge() != null) {
                    builder3 = builder2.addCustomTargeting(HttpHeaders.AGE, googleAdParamDTO.getAge().trim());
                } else {
                    builder3 = builder2.addCustomTargeting(HttpHeaders.AGE, "0");
                }
                if (googleAdParamDTO.getSource() != null) {
                    builder4 = builder3.addCustomTargeting("Source", googleAdParamDTO.getSource().trim());
                } else {
                    builder4 = builder3.addCustomTargeting("Source", "0");
                }
                if (googleAdParamDTO.getDestination() != null) {
                    builder5 = builder4.addCustomTargeting("Destination", googleAdParamDTO.getDestination().trim());
                } else {
                    builder5 = builder4.addCustomTargeting("Destination", "0");
                }
                if (googleAdParamDTO.getDepartureDate() != null) {
                    builder6 = builder5.addCustomTargeting("Departure", googleAdParamDTO.getDepartureDate().trim());
                } else {
                    builder6 = builder5.addCustomTargeting("Departure", "0");
                }
                if (googleAdParamDTO.getArrivalDate() != null) {
                    builder7 = builder6.addCustomTargeting("Arrival", googleAdParamDTO.getArrivalDate().trim());
                } else {
                    builder7 = builder6.addCustomTargeting("Arrival", "0");
                }
                if (googleAdParamDTO.getjClass() != null) {
                    builder8 = builder7.addCustomTargeting("Class", googleAdParamDTO.getjClass().trim());
                } else {
                    builder8 = builder7.addCustomTargeting("Class", "0");
                }
                if (googleAdParamDTO.getTrainType() != null) {
                    builder9 = builder8.addCustomTargeting("TrainType", googleAdParamDTO.getTrainType().trim());
                } else {
                    builder9 = builder8.addCustomTargeting("TrainType", "0");
                }
                if (googleAdParamDTO.getQuata() != null) {
                    builder10 = builder9.addCustomTargeting("Quota", googleAdParamDTO.getQuata().trim());
                } else {
                    builder10 = builder9.addCustomTargeting("Quota", "0");
                }
                if (googleAdParamDTO.getMealType() != null) {
                    builder11 = builder10.addCustomTargeting("Meal", googleAdParamDTO.getMealType().trim());
                } else {
                    builder11 = builder10.addCustomTargeting("Meal", "0");
                }
                if (googleAdParamDTO.getTicketStatus() != null) {
                    builder = builder11.addCustomTargeting("Status", googleAdParamDTO.getTicketStatus().trim());
                } else {
                    builder = builder11.addCustomTargeting("Status", "0");
                }
            } else {
                builder = builder12.addCustomTargeting("Gender", "0").addCustomTargeting(HttpHeaders.AGE, "0").addCustomTargeting("Source", "0").addCustomTargeting("Destination", "0").addCustomTargeting("Departure", "0").addCustomTargeting("Arrival", "0").addCustomTargeting("Classes", "0").addCustomTargeting("TrainType", "0").addCustomTargeting("Quota", "0").addCustomTargeting("Meal", "0").addCustomTargeting("Status", "0");
            }
            AdManagerAdRequest build = builder.build();
            NativeAd nativeAd = new NativeAd((Context) activity, activity.getString(R.string.native_ad_p_id));
            nativeAd.loadAd(nativeAd.buildLoadAdConfig().withAdListener(new a()).build());
            adManagerAdView.loadAd(build);
        } catch (Exception e2) {
            e2.getMessage();
        }
    }

    public static void Z(FragmentActivity fragmentActivity, InterstitialAd interstitialAd, boolean z) {
        if (interstitialAd != null) {
            interstitialAd.show(fragmentActivity);
        } else if (z) {
            v(fragmentActivity);
        }
    }

    public static void a(EditText editText, int i2) {
        editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i2)});
    }

    public static void a0(Context context) {
        String string = context.getSharedPreferences("Settings", 0).getString("My_Lang", "en");
        IrctcImaApplication.e = string;
        i0(context, string);
    }

    public static String b(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
        try {
            return simpleDateFormat.format(simpleDateFormat.parse(str));
        } catch (Exception e2) {
            e2.getMessage();
            return "";
        }
    }

    public static void b0(AppCompatActivity appCompatActivity) {
        ProgressDialog show = ProgressDialog.show(appCompatActivity, appCompatActivity.getString(R.string.loading_only), appCompatActivity.getString(R.string.Loading_Country));
        HashMap<String, String> hashMap = new HashMap<>();
        f3623a = hashMap;
        hashMap.put("India", "94");
        f3622a = new ArrayList<>();
        String f2 = C0657Qt.f();
        ((Om) C0657Qt.b()).i1(f2 + "country").c(C1181iv.a()).a(E0.a()).b(new C0526H5(show, appCompatActivity));
    }

    public static String c(Date date) {
        if (date == null) {
            return "";
        }
        return new SimpleDateFormat("dd/MM/yyyy").format(date);
    }

    public static String c0(String str) {
        return str.replaceAll("\\w(?=\\w{4})", "*");
    }

    public static String d(Date date) {
        if (IrctcImaApplication.e.equals("hi")) {
            Locale locale = new Locale("hi", "IN");
            if (date == null) {
                return "";
            }
            new SimpleDateFormat("yyyy-MM-dd");
            return new SimpleDateFormat("EEE, dd MMM", locale).format(date);
        } else if (date == null) {
            return "";
        } else {
            new SimpleDateFormat("yyyy-MM-dd");
            return new SimpleDateFormat("EEE, dd MMM").format(date);
        }
    }

    public static String d0(String str) {
        try {
            if (!str.contains("@")) {
                str = t(str, ("USR_DES-" + C1450w1.f7021c + C1450w1.f7026d + IrctcImaApplication.c).substring(0, 16));
            }
            if (str != null && !str.equals("")) {
                if (str.length() != 0) {
                    String[] split = str.split("@");
                    int length = split[0].length();
                    if (length <= 4) {
                        return str;
                    }
                    int i2 = length - 4;
                    StringBuilder sb = new StringBuilder(i2);
                    for (int i3 = 0; i3 < i2; i3++) {
                        sb.append('*');
                    }
                    String str2 = (sb + split[0].substring(i2, length)) + "@" + split[1];
                    if (str.length() == str2.length()) {
                        return str2;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return "";
    }

    public static String e(String str) {
        if (str == null) {
            return "";
        }
        if (IrctcImaApplication.e.equals("hi")) {
            Locale locale = new Locale("hi", "IN");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss", locale);
            try {
                return new SimpleDateFormat("dd MMM, yyyy | hh:mm a", locale).format(simpleDateFormat.parse(str));
            } catch (ParseException e2) {
                e2.getMessage();
                return "";
            }
        } else {
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
            try {
                return new SimpleDateFormat("dd MMM, yyyy | hh:mm a").format(simpleDateFormat2.parse(str));
            } catch (ParseException e3) {
                e3.getMessage();
                return "";
            }
        }
    }

    public static String e0(String str) {
        if (!(str == null || str.equals("") || str.length() == 0)) {
            int length = str.length();
            int i2 = (40 * length) / 100;
            StringBuilder sb = new StringBuilder(i2);
            for (int i3 = 0; i3 < i2; i3++) {
                sb.append('*');
            }
            int i4 = (length - i2) / 2;
            String str2 = str.substring(0, i4) + sb + str.substring(i2 + i4, length);
            if (length == str2.length()) {
                return str2;
            }
        }
        return "";
    }

    public static int f(Date date) {
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        instance2.setTime(date);
        if (instance2.after(instance)) {
            return -1;
        }
        int i2 = instance.get(1) - instance2.get(1);
        int i3 = instance.get(2);
        int i4 = instance2.get(2);
        if (i4 <= i3 && (i3 != i4 || instance2.get(5) <= instance.get(5))) {
            return i2;
        }
        return i2 - 1;
    }

    public static void f0(KD kd, TextView textView, TextView textView2, Context context) {
        if (!O((ConnectivityManager) context.getSystemService("connectivity"), context)) {
            new Handler().postDelayed(new C0548J5(), 5000);
            return;
        }
        ProgressDialog show = ProgressDialog.show(context, context.getString(R.string.processing_text), context.getString(R.string.please_wait_text));
        String f2 = C0657Qt.f();
        ((Om) C0657Qt.c(C0793b1.a.f3912a)).Z(f2 + "predictCnfChance", kd).c(C1181iv.a()).a(E0.a()).b(new C0560K5(show, kd, textView2, textView, context));
    }

    public static void g(FragmentActivity fragmentActivity, String str, TextView textView) {
        Spannable newSpannable = Spannable.Factory.getInstance().newSpannable(str);
        try {
            newSpannable.setSpan((Object) null, 35, str.length(), 33);
            Object obj = d7.a;
            newSpannable.setSpan(new ForegroundColorSpan(d7.b.a(fragmentActivity, R.color.PrimaryColor)), 35, str.length(), 33);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            newSpannable.setSpan(new NoUnderlineSpan(), 35, str.length(), 33);
        } catch (Exception e2) {
            e2.getMessage();
        }
        textView.setText(newSpannable);
        textView.setSelected(true);
    }

    public static String g0(String str) {
        if (str == null || str == "") {
            return str;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss a");
        try {
            return new SimpleDateFormat("HH:mm").format(simpleDateFormat.parse(str));
        } catch (ParseException unused) {
            C1354qp.R(C0535I5.class);
            return "";
        }
    }

    public static String h(Date date) {
        if (IrctcImaApplication.e.equals("hi")) {
            Locale locale = new Locale("hi", "IN");
            new SimpleDateFormat("yyyy-MM-dd");
            return new SimpleDateFormat("dd MMM yyyy", locale).format(date);
        }
        new SimpleDateFormat("yyyy-MM-dd");
        return new SimpleDateFormat("dd MMM yyyy").format(date);
    }

    public static void h0(TextView textView, String str) {
        if (str.equalsIgnoreCase("Veg") || str.equalsIgnoreCase("V") || str.equalsIgnoreCase("F") || str.equalsIgnoreCase("J")) {
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_veg, 0);
            textView.setCompoundDrawablePadding(5);
        } else if (str.equalsIgnoreCase("Non Veg") || str.equalsIgnoreCase("N") || str.equalsIgnoreCase(RequestConfiguration.MAX_AD_CONTENT_RATING_G) || str.equalsIgnoreCase("Non-Veg") || str.equalsIgnoreCase("Non_Veg")) {
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_non_veg, 0);
            textView.setCompoundDrawablePadding(5);
        } else {
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            textView.setVisibility(0);
        }
    }

    public static String i(Date date) {
        new SimpleDateFormat("yyyy-MM-dd");
        return new SimpleDateFormat("dd MMM yyyy HH:mm:ss").format(date);
    }

    public static void i0(Context context, String str) {
        Locale locale = new Locale(str);
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.locale = locale;
        context.getResources().updateConfiguration(configuration, context.getResources().getDisplayMetrics());
        SharedPreferences.Editor edit = context.getSharedPreferences("Settings", 0).edit();
        edit.putString("My_Lang", str);
        edit.apply();
        IrctcImaApplication.e = str;
    }

    public static String j(Date date) {
        if (!IrctcImaApplication.e.equals("hi")) {
            return new SimpleDateFormat("dd-MMM-yyyy").format(date);
        }
        new Locale("hi", "IN");
        return new SimpleDateFormat("dd-MMM-yyyy").format(date);
    }

    public static int j0(MealItemDetails mealItemDetails) {
        CopyOnWriteArrayList copyOnWriteArrayList = f3624a;
        Iterator it = copyOnWriteArrayList.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            MealItemDetails mealItemDetails2 = (MealItemDetails) it.next();
            if (mealItemDetails2.getMealId() == mealItemDetails.getMealId()) {
                mealItemDetails2.setQuantity(mealItemDetails2.getQuantity() - 1);
                if (mealItemDetails2.getQuantity() == 0) {
                    copyOnWriteArrayList.remove(mealItemDetails2);
                }
                i2 = mealItemDetails2.getQuantity();
            }
        }
        return i2;
    }

    public static String k(Date date) {
        if (IrctcImaApplication.e.equals("hi")) {
            return new SimpleDateFormat("dd MMM, yyyy", new Locale("hi", "IN")).format(date);
        }
        return new SimpleDateFormat("dd MMM, yyyy").format(date);
    }

    public static int k0(MealItemDetails mealItemDetails) {
        CopyOnWriteArrayList copyOnWriteArrayList = f3629b;
        Iterator it = copyOnWriteArrayList.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            MealItemDetails mealItemDetails2 = (MealItemDetails) it.next();
            if (mealItemDetails2.getMealId() == mealItemDetails.getMealId()) {
                mealItemDetails2.setQuantity(mealItemDetails2.getQuantity() - 1);
                if (mealItemDetails2.getQuantity() == 0) {
                    copyOnWriteArrayList.remove(mealItemDetails2);
                }
                i2 = mealItemDetails2.getQuantity();
            }
        }
        return i2;
    }

    public static String l(Date date) {
        if (IrctcImaApplication.e.equals("hi")) {
            return new SimpleDateFormat("EEE, dd MMM, yyyy", new Locale("hi", "IN")).format(date);
        }
        return new SimpleDateFormat("EEE, dd MMM, yyyy").format(date);
    }

    public static int l0(MealItemDetails mealItemDetails) {
        CopyOnWriteArrayList copyOnWriteArrayList = f3624a;
        Iterator it = copyOnWriteArrayList.iterator();
        int i2 = 0;
        boolean z = true;
        while (it.hasNext()) {
            MealItemDetails mealItemDetails2 = (MealItemDetails) it.next();
            if (mealItemDetails2.getMealId() == mealItemDetails.getMealId()) {
                mealItemDetails2.setQuantity(mealItemDetails2.getQuantity() + 1);
                i2 = mealItemDetails2.getQuantity();
                z = false;
            }
        }
        if (z) {
            copyOnWriteArrayList.add(mealItemDetails);
            Iterator it2 = copyOnWriteArrayList.iterator();
            while (it2.hasNext()) {
                MealItemDetails mealItemDetails3 = (MealItemDetails) it2.next();
                if (mealItemDetails3.getMealId() == mealItemDetails.getMealId()) {
                    mealItemDetails3.setQuantity(mealItemDetails3.getQuantity() + 1);
                    i2 = mealItemDetails3.getQuantity();
                }
            }
        }
        return i2;
    }

    public static AlertDialog m(Context context, boolean z, String str, String str2, String str3, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(z);
        builder.setTitle(str2);
        builder.setMessage(str);
        builder.setIcon(17301543);
        builder.setPositiveButton(str3, onClickListener);
        f3619a = builder.create();
        return builder.create();
    }

    public static int m0(MealItemDetails mealItemDetails) {
        CopyOnWriteArrayList copyOnWriteArrayList = f3629b;
        Iterator it = copyOnWriteArrayList.iterator();
        int i2 = 0;
        boolean z = true;
        while (it.hasNext()) {
            MealItemDetails mealItemDetails2 = (MealItemDetails) it.next();
            if (mealItemDetails2.getMealId() == mealItemDetails.getMealId()) {
                mealItemDetails2.setQuantity(mealItemDetails2.getQuantity() + 1);
                i2 = mealItemDetails2.getQuantity();
                z = false;
            }
        }
        if (z) {
            copyOnWriteArrayList.add(mealItemDetails);
            Iterator it2 = copyOnWriteArrayList.iterator();
            while (it2.hasNext()) {
                MealItemDetails mealItemDetails3 = (MealItemDetails) it2.next();
                if (mealItemDetails3.getMealId() == mealItemDetails.getMealId()) {
                    mealItemDetails3.setQuantity(mealItemDetails3.getQuantity() + 1);
                    i2 = mealItemDetails3.getQuantity();
                }
            }
        }
        return i2;
    }

    public static AlertDialog n(Context context, Spanned spanned, String str, String str2, DialogInterface.OnClickListener onClickListener, String str3, DialogInterface.OnClickListener onClickListener2) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(str);
        builder.setMessage(spanned);
        builder.setCancelable(false);
        builder.setPositiveButton(str2, onClickListener);
        if (str3 != null && !str3.equals("")) {
            builder.setNegativeButton(str3, onClickListener2);
        }
        AlertDialog create = builder.create();
        f3619a = create;
        return create;
    }

    public static void n0() {
        f3643f = false;
    }

    public static AlertDialog o(Context context, String str, String str2, DialogInterface.OnClickListener onClickListener) {
        return p(context, false, str, context.getResources().getString(R.string.Info), str2, onClickListener, (String) null, (DialogInterface.OnClickListener) null);
    }

    public static void o0(HashMap<String, ArrayList<String>> hashMap) {
        f3637d = hashMap;
    }

    public static AlertDialog p(Context context, boolean z, String str, String str2, String str3, DialogInterface.OnClickListener onClickListener, String str4, DialogInterface.OnClickListener onClickListener2) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(str2);
        builder.setMessage(str);
        builder.setCancelable(z);
        builder.setPositiveButton(str3, onClickListener);
        if (str4 != null && !str4.equals("")) {
            builder.setNegativeButton(str4, onClickListener2);
        }
        AlertDialog create = builder.create();
        f3619a = create;
        return create;
    }

    public static void p0() {
        f3645g = true;
    }

    public static AlertDialog q(FragmentActivity fragmentActivity, TextView textView, String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(fragmentActivity);
        builder.setTitle(fragmentActivity.getResources().getString(R.string.Info));
        builder.setView(textView);
        builder.setPositiveButton(str, (DialogInterface.OnClickListener) null);
        builder.setCancelable(false);
        AlertDialog create = builder.create();
        f3619a = create;
        create.setCanceledOnTouchOutside(false);
        return f3619a;
    }

    public static void q0(String str) {
        f3631c = str;
    }

    public static AlertDialog r(Activity activity, String str, String str2, String str3, DialogInterface.OnClickListener onClickListener, String str4, MyAccountFragment.c cVar, String str5) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        LinearLayout linearLayout = new LinearLayout(activity);
        builder.setTitle(str2);
        builder.setMessage(str);
        builder.setCancelable(true);
        builder.setPositiveButton(str3, onClickListener);
        AdManagerAdView adManagerAdView = new AdManagerAdView(activity);
        adManagerAdView.setAdUnitId(str5);
        adManagerAdView.setAdSizes(AdSize.MEDIUM_RECTANGLE, AdSize.LARGE_BANNER, AdSize.BANNER);
        adManagerAdView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        adManagerAdView.setPadding(0, 30, 0, 30);
        adManagerAdView.setBackgroundColor(Color.parseColor("#efeff4"));
        Y(activity, adManagerAdView, (GoogleAdParamDTO) null);
        linearLayout.addView(adManagerAdView);
        builder.setView(linearLayout);
        if (str4 != null && !str4.equals("")) {
            builder.setNegativeButton(str4, cVar);
        }
        AlertDialog create = builder.create();
        f3619a = create;
        return create;
    }

    public static String r0(ArrayList<String> arrayList) {
        do {
        } while (arrayList.remove((Object) null));
        return TextUtils.join(", ", arrayList);
    }

    public static AlertDialog s(FragmentActivity fragmentActivity, TextView textView, String str, String str2, C1444vl vlVar) {
        AlertDialog.Builder builder = new AlertDialog.Builder(fragmentActivity);
        builder.setCancelable(false);
        builder.setTitle(str);
        builder.setView(textView);
        builder.setIcon(17301543);
        builder.setPositiveButton(str2, vlVar);
        AlertDialog create = builder.create();
        f3619a = create;
        return create;
    }

    public static String s0(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(str.length());
        for (String str2 : str.split(" ")) {
            if (!str2.isEmpty()) {
                sb.append(Character.toUpperCase(str2.charAt(0)));
                sb.append(str2.substring(1).toLowerCase());
            }
            if (sb.length() != str.length()) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static String t(String str, String str2) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(str2.getBytes("UTF-8"));
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes("UTF-8"), "AES");
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            instance.init(2, secretKeySpec, ivParameterSpec);
            return new String(instance.doFinal(Base64.decode(str, 0)));
        } catch (IllegalBlockSizeException unused) {
            return str;
        } catch (Exception e2) {
            e2.getMessage();
            return str;
        }
    }

    public static void t0(Context context, String str) {
        try {
            Toast.makeText(context, str, 1).show();
        } catch (Exception e2) {
            e2.getMessage();
        }
    }

    public static void u() {
        try {
            AlertDialog alertDialog = f3619a;
            if (alertDialog != null && alertDialog.isShowing()) {
                f3619a.dismiss();
            }
        } catch (Exception e2) {
            e2.getMessage();
        }
    }

    public static void u0(FragmentActivity fragmentActivity) {
        t0(fragmentActivity, fragmentActivity.getString(R.string.txn_cancelled));
    }

    public static void v(FragmentActivity fragmentActivity) {
        if (fragmentActivity != null) {
            f3644g = null;
            f3615a = null;
            Intent intent = new Intent(fragmentActivity, IRCTCConnectActivity.class);
            intent.setFlags(67108864);
            intent.putExtra("logout", true);
            fragmentActivity.startActivity(intent);
            fragmentActivity.finish();
        }
    }

    public static void v0(NestedScrollView nestedScrollView, File file, String str, Boolean bool, Context context) {
        FileOutputStream fileOutputStream;
        Bitmap createBitmap = Bitmap.createBitmap(nestedScrollView.getWidth(), nestedScrollView.getChildAt(0).getHeight(), Bitmap.Config.ARGB_8888);
        nestedScrollView.draw(new Canvas(createBitmap));
        try {
            fileOutputStream = new FileOutputStream(new File(file, str));
            createBitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
            intent.setData(Uri.fromFile(new File(file + File.separator + str)));
            context.sendBroadcast(intent);
            if (!bool.booleanValue()) {
                o(context, context.getString(R.string.as_acc_stmt_has_been_saved) + file, context.getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
            }
            fileOutputStream.close();
        } catch (FileNotFoundException e2) {
            e2.getMessage();
            Toast makeText = Toast.makeText(context, e2.getMessage(), 1);
            makeText.setGravity(1, 0, 0);
            makeText.show();
            if (createBitmap == null) {
                return;
            }
        } catch (IOException e3) {
            e3.getMessage();
            Toast makeText2 = Toast.makeText(context, e3.getMessage(), 1);
            makeText2.setGravity(1, 0, 0);
            makeText2.show();
            if (createBitmap == null) {
                return;
            }
        } catch (Exception e4) {
            try {
                e4.getMessage();
                Toast makeText3 = Toast.makeText(context, e4.getMessage(), 1);
                makeText3.setGravity(1, 0, 0);
                makeText3.show();
                if (createBitmap == null) {
                    return;
                }
            } catch (Throwable th) {
                if (createBitmap != null) {
                    createBitmap.recycle();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        createBitmap.recycle();
        return;
        throw th;
    }

    public static String w(String str, String str2) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(str2.getBytes("UTF-8"));
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes("UTF-8"), "AES");
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            instance.init(1, secretKeySpec, ivParameterSpec);
            return Base64.encodeToString(instance.doFinal(str.getBytes("UTF-8")), 0);
        } catch (Exception e2) {
            e2.toString();
            return null;
        }
    }

    public static String x(Date date) {
        if (date == null) {
            return null;
        }
        return new SimpleDateFormat("ddMMyyyy").format(date);
    }

    public static String y(Date date) {
        if (date == null) {
            return null;
        }
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }

    public static String z(int i2) {
        int i3 = i2 / 1440;
        int i4 = i2 - (i3 * 1440);
        int i5 = i4 / 60;
        int i6 = i4 - (i5 * 60);
        if (i3 >= 1) {
            return i3 + "d :" + i5 + "h :" + i6 + "m";
        } else if (i5 >= 1) {
            return i5 + "h :" + i6 + "m.";
        } else {
            return i6 + "m.";
        }
    }
}
