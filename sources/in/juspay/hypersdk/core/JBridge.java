package in.juspay.hypersdk.core;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.renderscript.RenderScript;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.webkit.JavascriptInterface;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.facebook.ads.AdError;
import com.google.ads.mediation.facebook.FacebookMediationAdapter;
import com.google.android.gms.ads.AdRequest;
import com.google.common.primitives.UnsignedBytes;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.paytm.pgsdk.sdknative.LoginActivity;
import defpackage.ji;
import in.juspay.hyper.bridge.ThreeDS2Bridge;
import in.juspay.hyper.constants.Labels;
import in.juspay.hyper.constants.LogCategory;
import in.juspay.hyper.constants.LogLevel;
import in.juspay.hyper.constants.LogSubCategory;
import in.juspay.hyper.core.EncHelper;
import in.juspay.hyper.core.ExecutorManager;
import in.juspay.hyper.core.JuspayLogger;
import in.juspay.hyper.core.ReceiverInterface;
import in.juspay.hypersdk.R;
import in.juspay.hypersdk.mystique.SwypeLayout;
import in.juspay.hypersdk.security.JOSEUtils;
import in.juspay.hypersdk.utils.Utils;
import in.juspay.hypersdk.utils.network.NetUtils;
import in.juspay.hypersdk.utils.network.SessionizedNetUtils;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JBridge extends DuiInterface implements ReceiverInterface {
    private static final String LOG_TAG = "JBridge";
    private final int JUSPAY_LOADER_ID = 898989;
    private final Set<String> acceptedCerts = new HashSet();
    private BroadcastReceiver broadcastReceiver = null;
    private NetUtils netUtils;
    private NetUtils netUtilsSsl;

    public JBridge(JuspayServices juspayServices) {
        super(juspayServices);
        try {
            this.netUtils = new SessionizedNetUtils(this.sessionInfo, 0, 0, false);
            this.netUtilsSsl = new SessionizedNetUtils(this.sessionInfo, 0, 0, true);
        } catch (Exception e) {
            juspayServices.getSdkTracker().trackAndLogException(LOG_TAG, LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.JBRIDGE, "Error while instantiating NetUtils", e);
        }
    }

    public static float dpToPx(float f, Context context) {
        return (((float) context.getResources().getDisplayMetrics().densityDpi) / 160.0f) * f;
    }

    private void drawIcon(Drawable drawable, int i) {
        ExecutorManager.runOnMainThread(new e(this, i, drawable, this.juspayServices.getSdkTracker()));
    }

    private Map<String, String> getDecodedQueryParameters(String str) {
        if (str == null || str.trim().length() < 1) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String str2 : str.split("&")) {
            int indexOf = str2.indexOf("=");
            hashMap.put(URLDecoder.decode(str2.substring(0, indexOf), "UTF-8").trim(), URLDecoder.decode(str2.substring(indexOf + 1), "UTF-8").trim());
        }
        return hashMap;
    }

    @JavascriptInterface
    public static String hmacDigest(String str, String str2, String str3) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(StandardCharsets.UTF_8), str3);
            Mac instance = Mac.getInstance(str3);
            instance.init(secretKeySpec);
            byte[] doFinal = instance.doFinal(str.getBytes(StandardCharsets.US_ASCII));
            StringBuilder sb = new StringBuilder();
            for (byte b : doFinal) {
                String hexString = Integer.toHexString(b & UnsignedBytes.MAX_VALUE);
                if (hexString.length() == 1) {
                    sb.append('0');
                }
                sb.append(hexString);
            }
            return sb.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$blurBackground$8(RenderScript renderScript, int i, View view, View view2) {
        new BlurProcessor(renderScript, i, this.activity).blurView(view, view2);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$drawIcon$2(int i, Drawable drawable, SdkTracker sdkTracker) {
        Activity activity = this.activity;
        if (activity != null) {
            View findViewById = activity.findViewById(i);
            ImageView imageView = new ImageView(this.activity);
            imageView.setImageDrawable(drawable);
            if (findViewById != null) {
                ((ViewGroup) findViewById).addView(imageView);
                return;
            }
            sdkTracker.trackAction(LogSubCategory.Action.SYSTEM, "error", Labels.System.JBRIDGE, "draw_icon", C1058d.y("No view at ", i, " found to attach the image."));
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void lambda$hideJuspayLoader$1(java.lang.String r6) {
        /*
            r5 = this;
            android.app.Activity r0 = r5.activity
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            r1 = 898989(0xdb7ad, float:1.259752E-39)
            android.view.View r0 = r0.findViewById(r1)
            if (r0 != 0) goto L_0x000f
            return
        L_0x000f:
            r1 = 1065353216(0x3f800000, float:1.0)
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x003b }
            r2.<init>(r6)     // Catch:{ Exception -> 0x003b }
            java.lang.String r6 = "animationDuration"
            java.lang.String r3 = "1000"
            java.lang.String r6 = r2.optString(r6, r3)     // Catch:{ Exception -> 0x003b }
            int r6 = java.lang.Integer.parseInt(r6)     // Catch:{ Exception -> 0x003b }
            java.lang.String r3 = "startAlpha"
            java.lang.String r4 = "1.0"
            java.lang.String r3 = r2.optString(r3, r4)     // Catch:{ Exception -> 0x003d }
            float r1 = java.lang.Float.parseFloat(r3)     // Catch:{ Exception -> 0x003d }
            java.lang.String r3 = "endAlpha"
            java.lang.String r4 = "0.0"
            java.lang.String r2 = r2.optString(r3, r4)     // Catch:{ Exception -> 0x003d }
            float r2 = java.lang.Float.parseFloat(r2)     // Catch:{ Exception -> 0x003d }
            goto L_0x003e
        L_0x003b:
            r6 = 1000(0x3e8, float:1.401E-42)
        L_0x003d:
            r2 = 0
        L_0x003e:
            android.view.animation.AlphaAnimation r3 = new android.view.animation.AlphaAnimation
            r3.<init>(r1, r2)
            android.view.animation.AccelerateInterpolator r1 = new android.view.animation.AccelerateInterpolator
            r1.<init>()
            r3.setInterpolator(r1)
            long r1 = (long) r6
            r3.setDuration(r1)
            r0.setAnimation(r3)
            in.juspay.hypersdk.core.JuspayServices r6 = r5.juspayServices
            android.widget.FrameLayout r6 = r6.getContainer()
            if (r6 == 0) goto L_0x005d
            r6.removeView(r0)
        L_0x005d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.core.JBridge.lambda$hideJuspayLoader$1(java.lang.String):void");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$newDialogWithoutDateField$3(String str, DatePicker datePicker, int i, int i2, int i3) {
        invokeCallbackInDUIWebview(str, i + RemoteSettings.FORWARD_SLASH_STRING + (i2 + 1) + RemoteSettings.FORWARD_SLASH_STRING + i3);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$newDialogWithoutDateField$4(String str, DialogInterface dialogInterface) {
        invokeCallbackInDUIWebview(str, "NaN-NaN");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$newDialogWithoutDateField$5(String str, DialogInterface dialogInterface) {
        invokeCallbackInDUIWebview(str, "NaN-NaN");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$showJuspayLoader$0(String str) {
        int i;
        String str2 = "Processing your payment";
        Activity activity = this.activity;
        if (activity != null && activity.findViewById(898989) == null) {
            int i2 = 1000;
            float f = 0.0f;
            float f2 = 1.0f;
            try {
                JSONObject jSONObject = new JSONObject(str);
                i = Integer.parseInt(jSONObject.optString("rotationDuration", "2100"));
                try {
                    i2 = Integer.parseInt(jSONObject.optString("animationDuration", "1000"));
                    f = Float.parseFloat(jSONObject.optString("startAlpha", IdManager.DEFAULT_VERSION_NAME));
                    f2 = Float.parseFloat(jSONObject.optString("endAlpha", "1.0"));
                    str2 = jSONObject.optString("message", str2);
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                i = AdError.BROKEN_MEDIA_ERROR_CODE;
            }
            LinearLayout linearLayout = new LinearLayout(this.activity);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            linearLayout.setBackgroundColor(Color.parseColor("#ffffff"));
            linearLayout.setGravity(17);
            linearLayout.setId(898989);
            linearLayout.setClickable(true);
            LinearLayout linearLayout2 = new LinearLayout(this.activity);
            linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            linearLayout2.setOrientation(1);
            linearLayout2.setGravity(1);
            ImageView imageView = new ImageView(this.activity);
            imageView.setBackgroundResource(R.drawable.juspay_icon);
            imageView.setLayoutParams(new LinearLayout.LayoutParams((int) dpToPx(48.0f, this.activity), (int) dpToPx(48.0f, this.activity)));
            RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 350.0f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setInterpolator(new LinearInterpolator());
            rotateAnimation.setRepeatCount(-1);
            rotateAnimation.setDuration((long) i);
            imageView.startAnimation(rotateAnimation);
            TextView textView = new TextView(this.activity);
            textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            textView.setPadding(0, (int) dpToPx(10.0f, this.activity), 0, (int) dpToPx(20.0f, this.activity));
            textView.setTextSize(16.0f);
            textView.setTextColor(Color.parseColor("#000000"));
            textView.setText(str2);
            ImageView imageView2 = new ImageView(this.activity);
            imageView2.setBackgroundResource(R.drawable.juspay_safe);
            imageView2.setLayoutParams(new LinearLayout.LayoutParams((int) dpToPx(90.0f, this.activity), (int) dpToPx(12.0f, this.activity)));
            ((LinearLayout.LayoutParams) imageView2.getLayoutParams()).setMargins(0, (int) dpToPx(24.0f, this.activity), 0, 0);
            linearLayout2.addView(imageView);
            linearLayout2.addView(imageView2);
            linearLayout2.addView(textView);
            linearLayout.addView(linearLayout2);
            AlphaAnimation alphaAnimation = new AlphaAnimation(f, f2);
            alphaAnimation.setInterpolator(new DecelerateInterpolator());
            alphaAnimation.setDuration((long) i2);
            linearLayout.setAnimation(alphaAnimation);
            FrameLayout container = this.juspayServices.getContainer();
            if (container != null) {
                container.addView(linearLayout);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$startDatePicker$6(String str, String str2, String str3) {
        DatePickerDialog newDialogWithoutDateField = newDialogWithoutDateField(str);
        if (newDialogWithoutDateField != null) {
            if (str2 != null && !str2.isEmpty() && !str2.equals(com.google.android.gms.ads.AdError.UNDEFINED_DOMAIN)) {
                newDialogWithoutDateField.getDatePicker().setMinDate(dateToMillisecond(str2));
            }
            if (str3 != null && !str3.isEmpty() && !str3.equals(com.google.android.gms.ads.AdError.UNDEFINED_DOMAIN)) {
                newDialogWithoutDateField.getDatePicker().setMaxDate(dateToMillisecond(str3));
            }
            View findViewById = newDialogWithoutDateField.getDatePicker().findViewById(Resources.getSystem().getIdentifier("day", FacebookMediationAdapter.KEY_ID, LogSubCategory.LifeCycle.ANDROID));
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
            newDialogWithoutDateField.show();
        }
    }

    /* access modifiers changed from: private */
    public void lambda$startLottieAnimation$7(int i, String str, boolean z, float f, float f2, SdkTracker sdkTracker) {
        int i2;
        try {
            Activity activity = this.activity;
            if (activity != null) {
                LottieAnimationView lottieAnimationView = (LottieAnimationView) activity.findViewById(i);
                Ej ej = lottieAnimationView.f2761a;
                if (!ej.f159d) {
                    ej.f159d = true;
                    if (ej.f145a != null) {
                        ej.c();
                    }
                }
                lottieAnimationView.setAnimation(str);
                if (z) {
                    i2 = -1;
                } else {
                    i2 = 0;
                }
                lottieAnimationView.setRepeatCount(i2);
                lottieAnimationView.setMinAndMaxProgress(f, f2);
                lottieAnimationView.f2766a.add(LottieAnimationView.b.PLAY_OPTION);
                lottieAnimationView.f2761a.i();
            }
        } catch (Exception e) {
            sdkTracker.trackAndLogException(LOG_TAG, LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.JBRIDGE, "Exception while playing Lottie animation", e);
        }
    }

    private DatePickerDialog newDialogWithoutDateField(String str) {
        Calendar instance = Calendar.getInstance();
        C1459wg wgVar = new C1459wg(this, str);
        C1478xg xgVar = new C1478xg(this, str);
        C1498yg ygVar = new C1498yg(this, str);
        if (this.activity == null) {
            return null;
        }
        DatePickerDialog datePickerDialog = new DatePickerDialog(this.activity, 2, wgVar, instance.get(1), instance.get(2), instance.get(5));
        datePickerDialog.setOnCancelListener(xgVar);
        datePickerDialog.setOnDismissListener(ygVar);
        return datePickerDialog;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0044 A[Catch:{ Exception -> 0x009f }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005e A[Catch:{ Exception -> 0x009f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void receiverCallback(android.content.Intent r19) {
        /*
            r18 = this;
            r1 = r18
            r0 = r19
            java.lang.String r2 = "description"
            java.lang.String r3 = "transactionId"
            java.lang.String r4 = "status"
            java.lang.String r5 = "signature"
            in.juspay.hypersdk.core.JuspayServices r6 = r1.juspayServices
            in.juspay.hypersdk.core.SdkTracker r6 = r6.getSdkTracker()
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ Exception -> 0x009f }
            r7.<init>()     // Catch:{ Exception -> 0x009f }
            java.lang.String r8 = r19.getAction()     // Catch:{ Exception -> 0x009f }
            if (r8 == 0) goto L_0x0097
            int r9 = r8.hashCode()     // Catch:{ Exception -> 0x009f }
            r10 = -2034547226(0xffffffff86bb45e6, float:-7.044429E-35)
            r11 = 1
            if (r9 == r10) goto L_0x0037
            r10 = 1246126982(0x4a466386, float:3250401.5)
            if (r9 == r10) goto L_0x002d
            goto L_0x0041
        L_0x002d:
            java.lang.String r9 = "customtab-result"
            boolean r8 = r8.equals(r9)     // Catch:{ Exception -> 0x009f }
            if (r8 == 0) goto L_0x0041
            r8 = r11
            goto L_0x0042
        L_0x0037:
            java.lang.String r9 = "amazonpay-result"
            boolean r8 = r8.equals(r9)     // Catch:{ Exception -> 0x009f }
            if (r8 == 0) goto L_0x0041
            r8 = 0
            goto L_0x0042
        L_0x0041:
            r8 = -1
        L_0x0042:
            if (r8 == 0) goto L_0x005e
            if (r8 == r11) goto L_0x0047
            goto L_0x004a
        L_0x0047:
            r18.handleCustomTabResult(r19)     // Catch:{ Exception -> 0x009f }
        L_0x004a:
            java.lang.String r8 = "external_sdk"
            java.lang.String r9 = "error"
            java.lang.String r10 = "receiver_callback"
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            java.lang.String r16 = "unknown_intent"
            r17 = 0
            r7 = r6
            r7.trackApiCalls(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)     // Catch:{ Exception -> 0x009f }
            goto L_0x00af
        L_0x005e:
            java.lang.String r8 = r0.getStringExtra(r5)     // Catch:{ Exception -> 0x009f }
            r7.put(r5, r8)     // Catch:{ Exception -> 0x009f }
            java.lang.String r5 = r0.getStringExtra(r4)     // Catch:{ Exception -> 0x009f }
            r7.put(r4, r5)     // Catch:{ Exception -> 0x009f }
            java.lang.String r4 = r0.getStringExtra(r3)     // Catch:{ Exception -> 0x009f }
            r7.put(r3, r4)     // Catch:{ Exception -> 0x009f }
            java.lang.String r3 = r0.getStringExtra(r2)     // Catch:{ Exception -> 0x009f }
            r7.put(r2, r3)     // Catch:{ Exception -> 0x009f }
            java.lang.String r2 = "orderCurrency"
            java.lang.String r3 = "orderTotalAmount"
            java.lang.String r0 = r0.getStringExtra(r3)     // Catch:{ Exception -> 0x009f }
            r7.put(r2, r0)     // Catch:{ Exception -> 0x009f }
            java.util.Map<java.lang.String, java.lang.Object> r0 = r1.listenerMap     // Catch:{ Exception -> 0x009f }
            java.lang.String r2 = "amazonpay-result-cb"
            java.lang.Object r0 = r0.get(r2)     // Catch:{ Exception -> 0x009f }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x009f }
            java.lang.String r2 = r7.toString()     // Catch:{ Exception -> 0x009f }
            r1.invokeCallbackInDUIWebview(r0, r2)     // Catch:{ Exception -> 0x009f }
            goto L_0x00af
        L_0x0097:
            java.lang.Exception r0 = new java.lang.Exception     // Catch:{ Exception -> 0x009f }
            java.lang.String r2 = "action is null"
            r0.<init>(r2)     // Catch:{ Exception -> 0x009f }
            throw r0     // Catch:{ Exception -> 0x009f }
        L_0x009f:
            r0 = move-exception
            r13 = r0
            java.lang.String r8 = "JBridge"
            java.lang.String r9 = "api_call"
            java.lang.String r10 = "external_sdk"
            java.lang.String r11 = "receiver_callback"
            java.lang.String r12 = "JSON Exception"
            r7 = r6
            r7.trackAndLogException(r8, r9, r10, r11, r12, r13)
        L_0x00af:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.core.JBridge.receiverCallback(android.content.Intent):void");
    }

    private int versionCompare(String str, String str2) {
        int length;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return 1;
        }
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int i = 0;
        while (i < split.length && i < split2.length && split[i].equalsIgnoreCase(split2[i])) {
            i++;
        }
        if (i >= split.length || i >= split2.length) {
            length = split.length - split2.length;
        } else {
            length = Integer.valueOf(split[i]).compareTo(Integer.valueOf(split2[i]));
        }
        return Integer.signum(length);
    }

    @JavascriptInterface
    public void addCertificates(String str) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                this.acceptedCerts.add(jSONArray.getString(i));
            }
        } catch (Exception e) {
            sdkTracker.trackAndLogException(LOG_TAG, LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.JBRIDGE, "Exception while manipulating JSON", e);
        }
    }

    public void addToListenerMap(String str, String str2) {
        this.listenerMap.put(str, str2);
    }

    @JavascriptInterface
    @Deprecated
    public void amazonNonTokenPay(String str, String str2) {
        launchCustomTab(str, str2);
    }

    @JavascriptInterface
    public void attachBase64ImageToId(String str, String str2) {
        try {
            byte[] decode = Base64.decode(str, 0);
            ((ImageView) this.activity.findViewById(Integer.parseInt(str2))).setImageBitmap(BitmapFactory.decodeByteArray(decode, 0, decode.length));
        } catch (Exception unused) {
        }
    }

    @JavascriptInterface
    public void blurBackground(String str, String str2, int i) {
        if (Utils.isUiFeatureEnabled(this.juspayServices, "blurBackground")) {
            RenderScript create = RenderScript.create(this.activity);
            Activity activity = this.activity;
            if (activity != null) {
                try {
                    ExecutorManager.runOnMainThread(new C1515zg(this, create, i, activity.findViewById(Integer.parseInt(str)), this.activity.findViewById(Integer.parseInt(str2))));
                } catch (Exception unused) {
                }
            }
        }
    }

    @JavascriptInterface
    public void callAPI(String str, String str2, String str3, String str4, boolean z, boolean z2, String str5) {
        callAPIWithOptions(str, str2, str3, str4, z, z2, new JSONObject().toString(), str5);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00f8  */
    @android.webkit.JavascriptInterface
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void callAPIWithOptions(java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, boolean r27, boolean r28, java.lang.String r29, java.lang.String r30) {
        /*
            r22 = this;
            r14 = r22
            in.juspay.hypersdk.core.JuspayServices r0 = r14.juspayServices
            in.juspay.hypersdk.core.SdkTracker r15 = r0.getSdkTracker()
            in.juspay.hypersdk.core.JuspayServices r0 = r14.juspayServices
            in.juspay.hypersdk.core.DynamicUI r13 = r0.getDynamicUI()
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x0016 }
            r1 = r29
            r0.<init>(r1)     // Catch:{ Exception -> 0x0016 }
            goto L_0x001b
        L_0x0016:
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
        L_0x001b:
            r12 = r0
            long r0 = java.lang.System.currentTimeMillis()
            java.lang.Long r16 = java.lang.Long.valueOf(r0)
            java.lang.Object r9 = org.json.JSONObject.NULL
            java.lang.String r11 = "channels"
            org.json.JSONArray r0 = r12.optJSONArray(r11)
            java.lang.String r10 = "rootLogFields"
            org.json.JSONObject r17 = r12.optJSONObject(r10)
            java.lang.String r2 = "network"
            java.lang.String r3 = "info"
            java.lang.String r4 = "before_request"
            r5 = 0
            r8 = 0
            r18 = 0
            r1 = r15
            r6 = r24
            r7 = r16
            r19 = r10
            r10 = r18
            r20 = r11
            r11 = r23
            r21 = r12
            r12 = r0
            r18 = r15
            r15 = r13
            r13 = r17
            r1.trackApiCalls(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            if (r28 == 0) goto L_0x0059
            in.juspay.hypersdk.utils.network.NetUtils r0 = r14.netUtilsSsl
            goto L_0x005b
        L_0x0059:
            in.juspay.hypersdk.utils.network.NetUtils r0 = r14.netUtils
        L_0x005b:
            r1 = r0
            r2 = 1
            r13 = 0
            if (r1 != 0) goto L_0x008c
            if (r28 == 0) goto L_0x006c
            in.juspay.hypersdk.utils.network.SessionizedNetUtils r0 = new in.juspay.hypersdk.utils.network.SessionizedNetUtils     // Catch:{ Exception -> 0x0077 }
            in.juspay.hypersdk.data.SessionInfo r3 = r14.sessionInfo     // Catch:{ Exception -> 0x0077 }
            r0.<init>(r3, r13, r13, r2)     // Catch:{ Exception -> 0x0077 }
            r14.netUtilsSsl = r0     // Catch:{ Exception -> 0x0077 }
            goto L_0x0075
        L_0x006c:
            in.juspay.hypersdk.utils.network.SessionizedNetUtils r0 = new in.juspay.hypersdk.utils.network.SessionizedNetUtils     // Catch:{ Exception -> 0x0077 }
            in.juspay.hypersdk.data.SessionInfo r3 = r14.sessionInfo     // Catch:{ Exception -> 0x0077 }
            r0.<init>(r3, r13, r13, r13)     // Catch:{ Exception -> 0x0077 }
            r14.netUtils = r0     // Catch:{ Exception -> 0x0077 }
        L_0x0075:
            r12 = r0
            goto L_0x008d
        L_0x0077:
            r0 = move-exception
            r9 = r0
            in.juspay.hypersdk.core.JuspayServices r0 = r14.juspayServices
            in.juspay.hypersdk.core.SdkTracker r3 = r0.getSdkTracker()
            java.lang.String r4 = "JBridge"
            java.lang.String r5 = "action"
            java.lang.String r6 = "system"
            java.lang.String r7 = "jbridge"
            java.lang.String r8 = "Error while instantiating NetUtils in callAPI"
            r3.trackAndLogException(r4, r5, r6, r7, r8, r9)
        L_0x008c:
            r12 = r1
        L_0x008d:
            if (r12 != 0) goto L_0x00f8
            r0 = -1
            if (r30 == 0) goto L_0x00c8
            java.lang.String r1 = "{}"
            byte[] r1 = r1.getBytes()
            r3 = 2
            java.lang.String r1 = android.util.Base64.encodeToString(r1, r3)
            r4 = 6
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r4[r13] = r30
            java.lang.String r5 = "failure"
            r4[r2] = r5
            r4[r3] = r1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
            r2 = 3
            r4[r2] = r1
            byte[] r1 = r24.getBytes()
            java.lang.String r1 = android.util.Base64.encodeToString(r1, r3)
            r2 = 4
            r4[r2] = r1
            r1 = 5
            java.lang.String r2 = "%7B%7D"
            r4[r1] = r2
            java.lang.String r1 = "window.callUICallback('%s','%s','%s','%s','%s','%s');"
            java.lang.String r1 = java.lang.String.format(r1, r4)
            r15.addJsToWebView(r1)
        L_0x00c8:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r0)
            long r0 = java.lang.System.currentTimeMillis()
            java.lang.Long r8 = java.lang.Long.valueOf(r0)
            r1 = r20
            r9 = r21
            org.json.JSONArray r12 = r9.optJSONArray(r1)
            r1 = r19
            org.json.JSONObject r13 = r9.optJSONObject(r1)
            java.lang.String r2 = "network"
            java.lang.String r3 = "error"
            java.lang.String r4 = "network_call"
            java.lang.String r10 = "Unable to create netUtils object"
            r1 = r18
            r6 = r24
            r7 = r16
            r9 = r25
            r11 = r23
            r1.trackApiCalls(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        L_0x00f8:
            r9 = r21
            if (r28 == 0) goto L_0x0113
            in.juspay.hypersdk.security.HyperSSLSocketFactory r0 = new in.juspay.hypersdk.security.HyperSSLSocketFactory     // Catch:{ Exception -> 0x010b }
            java.util.Set<java.lang.String> r1 = r14.acceptedCerts     // Catch:{ Exception -> 0x010b }
            r0.<init>(r1)     // Catch:{ Exception -> 0x010b }
            javax.net.ssl.SSLSocketFactory r0 = r0.getSslSocketFactory()     // Catch:{ Exception -> 0x010b }
            r12.setSslSocketFactory(r0)     // Catch:{ Exception -> 0x010b }
            goto L_0x0113
        L_0x010b:
            r0 = move-exception
            java.lang.String r1 = "JBridge"
            java.lang.String r2 = "Exception: "
            in.juspay.hyper.core.JuspayLogger.e(r1, r2, r0)
        L_0x0113:
            in.juspay.hypersdk.core.JBridge$2 r0 = new in.juspay.hypersdk.core.JBridge$2
            r1 = r0
            r2 = r22
            r3 = r18
            r4 = r24
            r5 = r16
            r6 = r25
            r7 = r23
            r8 = r9
            r9 = r30
            r10 = r15
            r11 = r26
            r15 = r12
            r12 = r27
            r14 = r13
            r13 = r15
            r1.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            java.util.concurrent.Executor r1 = android.os.AsyncTask.THREAD_POOL_EXECUTOR
            java.lang.Object[] r2 = new java.lang.Object[r14]
            r0.executeOnExecutor(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.core.JBridge.callAPIWithOptions(java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, boolean, java.lang.String, java.lang.String):void");
    }

    @JavascriptInterface
    public void checkAmazonNonTokenSdk(String str) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            invokeCallbackInDUIWebview(str, "true");
        } catch (ClassNotFoundException e) {
            sdkTracker.trackAndLogException(LOG_TAG, LogCategory.API_CALL, LogSubCategory.ApiCall.SDK, Labels.SDK.AMAZON_UTILS, "Amazon Sdk Not found Exception", e);
            invokeCallbackInDUIWebview(str, "false");
        }
    }

    @JavascriptInterface
    public boolean checkCustomTabs() {
        return true;
    }

    @JavascriptInterface
    @Deprecated
    public void checkPhonePeSdk(String str) {
        invokeCallbackInDUIWebview(str, String.valueOf(checkPhonePeSdk()));
    }

    @JavascriptInterface
    public void copyLink(String str, String str2, String str3) {
        ((ClipboardManager) this.juspayServices.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(str2, str));
        invokeCallbackInDUIWebview(str3, "true");
    }

    @JavascriptInterface
    public int cursorPosition(int i) {
        EditText editText;
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            Activity activity = this.activity;
            if (activity == null || (editText = (EditText) activity.findViewById(i)) == null) {
                return 0;
            }
            return editText.getSelectionStart();
        } catch (Exception e) {
            sdkTracker.trackAndLogException(LOG_TAG, LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.JBRIDGE, "Cursor Position Exception", e);
            return 0;
        }
    }

    public long dateToMillisecond(String str) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            Date parse = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(str);
            if (parse != null) {
                return parse.getTime();
            }
            return 0;
        } catch (ParseException e) {
            sdkTracker.trackAndLogException(LOG_TAG, LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.JBRIDGE, "Error in date to millis", e);
            return 0;
        }
    }

    @JavascriptInterface
    public boolean doesPhonePeAppExist(String str) {
        long j;
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        PackageInfo packageInfo = null;
        try {
            packageInfo = this.juspayServices.getContext().getPackageManager().getPackageInfo(str, 1);
            j = (long) packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            sdkTracker.trackAction(LogSubCategory.Action.SYSTEM, LogLevel.DEBUG, Labels.System.JBRIDGE, "Failed to get phonepe package name", e);
            j = -1;
            packageInfo = packageInfo;
        }
        if (packageInfo == null) {
            return false;
        }
        if (j > 94033) {
            return true;
        }
        return false;
    }

    @JavascriptInterface
    public void drawAppIcon(String str) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                PackageManager packageManager = this.juspayServices.getContext().getPackageManager();
                drawIcon(packageManager.getApplicationInfo(jSONObject.getString(RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME), 0).loadIcon(packageManager), Integer.parseInt(jSONObject.getString(FacebookMediationAdapter.KEY_ID)));
            }
        } catch (Exception e) {
            sdkTracker.trackAndLogException(LOG_TAG, LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.JBRIDGE, "Error happened while parsing json", e);
        }
    }

    @JavascriptInterface
    public String encryptRSA(String str, String str2) {
        byte[] encryptRSAHelper = encryptRSAHelper(str, str2);
        if (encryptRSAHelper == null) {
            return "";
        }
        return Base64.encodeToString(encryptRSAHelper, 2);
    }

    public byte[] encryptRSAHelper(String str, String str2) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str.replace("-----BEGIN PUBLIC KEY-----\n", "").replace("-----END PUBLIC KEY-----", ""), 0)));
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(1, generatePublic);
            return instance.doFinal(str2.getBytes());
        } catch (Exception e) {
            sdkTracker.trackAndLogException(LOG_TAG, LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.JBRIDGE, "Exception when encrypting using RSA", e);
            return null;
        }
    }

    @JavascriptInterface
    public void exitApp(int i, String str) {
        SwypeLayout.clear();
        super.exitApp(i, str);
    }

    @JavascriptInterface
    public String findApps(String str) {
        PackageManager.NameNotFoundException nameNotFoundException;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        PackageManager packageManager = this.juspayServices.getContext().getPackageManager();
        Intent intent = new Intent();
        intent.setData(Uri.parse(str));
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
        Collections.sort(queryIntentActivities, new ResolveInfo.DisplayNameComparator(packageManager));
        JSONArray jSONArray = new JSONArray();
        for (ResolveInfo next : queryIntentActivities) {
            JSONObject jSONObject = new JSONObject();
            try {
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(next.activityInfo.packageName, 0);
                jSONObject.put(RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, applicationInfo.packageName);
                jSONObject.put("appName", packageManager.getApplicationLabel(applicationInfo));
                jSONArray.put(jSONObject);
            } catch (JSONException e) {
                nameNotFoundException = e;
                str6 = LOG_TAG;
                str5 = LogCategory.ACTION;
                str4 = LogSubCategory.Action.SYSTEM;
                str3 = Labels.System.JBRIDGE;
                str2 = "Error While add to json";
            } catch (PackageManager.NameNotFoundException e2) {
                nameNotFoundException = e2;
                str6 = LOG_TAG;
                str5 = LogCategory.ACTION;
                str4 = LogSubCategory.Action.SYSTEM;
                str3 = Labels.System.JBRIDGE;
                str2 = "Error while searching for the app";
            }
        }
        return jSONArray.toString();
        sdkTracker.trackAndLogException(str6, str5, str4, str3, str2, nameNotFoundException);
    }

    @JavascriptInterface
    public String get3DS2SdkList() {
        JSONArray jSONArray = new JSONArray();
        for (Map.Entry next : this.juspayServices.getJBridgeList().entrySet()) {
            if (next.getValue() instanceof ThreeDS2Bridge) {
                jSONArray.put(((ThreeDS2Bridge) next.getValue()).get3DS2SdkName());
            }
        }
        return jSONArray.toString();
    }

    @JavascriptInterface
    public String getBuildInfo() {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("BOARD", Build.BOARD);
            jSONObject.put("BRAND", Build.BRAND);
            jSONObject.put("CPU_ABI", Build.CPU_ABI);
            jSONObject.put("CPU_ABI2", Build.CPU_ABI2);
            jSONObject.put("DEVICE", Build.DEVICE);
            jSONObject.put("DISPLAY", Build.DISPLAY);
            jSONObject.put("FINGERPRINT", Build.FINGERPRINT);
            jSONObject.put("HARDWARE", Build.HARDWARE);
            jSONObject.put("HOST", Build.HOST);
            jSONObject.put("ID", Build.ID);
            jSONObject.put("MANUFACTURER", Build.MANUFACTURER);
            jSONObject.put("MODEL", Build.MODEL);
            jSONObject.put("PRODUCT", Build.PRODUCT);
            jSONObject.put("RADIO", Build.getRadioVersion());
            jSONObject.put("TAGS", Build.TAGS);
            jSONObject.put("TIME", Build.TIME);
            jSONObject.put("USER", Build.USER);
            jSONObject.put("SUPPORTED_32_BIT_ABIS", new JSONArray(Build.SUPPORTED_32_BIT_ABIS));
            jSONObject.put("SUPPORTED_64_BIT_ABIS", new JSONArray(Build.SUPPORTED_64_BIT_ABIS));
            jSONObject.put("SUPPORTED_ABIS", new JSONArray(Build.SUPPORTED_ABIS));
            JSONObject jSONObject2 = new JSONObject();
            int i = Build.VERSION.SDK_INT;
            jSONObject2.put("BASE_OS", Build.VERSION.BASE_OS);
            jSONObject2.put("INCREMENTAL", Build.VERSION.INCREMENTAL);
            jSONObject2.put("PREVIEW_SDK_INT", Build.VERSION.PREVIEW_SDK_INT);
            jSONObject2.put("SECURITY_PATCH", Build.VERSION.SECURITY_PATCH);
            jSONObject2.put("RELEASE", Build.VERSION.RELEASE);
            jSONObject2.put("SDK_INT", i);
            jSONObject.put("VERSION", jSONObject2);
            return jSONObject.toString();
        } catch (Exception e) {
            sdkTracker.trackAndLogException(LOG_TAG, LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.JBRIDGE, "Exception fetching build info", e);
            return "";
        }
    }

    @JavascriptInterface
    public float getDensity() {
        return ((float) this.juspayServices.getContext().getResources().getDisplayMetrics().densityDpi) / 160.0f;
    }

    @JavascriptInterface
    public String getDeviceInfo() {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        JSONObject sessionData = this.juspayServices.getSessionInfo().getSessionData();
        try {
            sessionData.put("android_id_raw", this.juspayServices.getSessionInfo().getAndroidId());
            return sessionData.toString();
        } catch (Exception e) {
            sdkTracker.trackAndLogException(LOG_TAG, LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.JBRIDGE, "Exception while extracting android id", e);
            return getSessionInfo();
        }
    }

    @JavascriptInterface
    @Deprecated
    public void getPackageName(String str) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            invokeCallbackInDUIWebview(str, this.juspayServices.getContext().getPackageName());
        } catch (Exception e) {
            sdkTracker.trackAndLogException(LOG_TAG, LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.JBRIDGE, "NULL Pointer Exception while getting package name", e);
            invokeCallbackInDUIWebview(str, "ERROR");
        }
    }

    @JavascriptInterface
    public long getPhonePeVersionCode(String str) {
        PackageManager packageManager = this.juspayServices.getContext().getPackageManager();
        if (!doesPhonePeAppExist(str)) {
            return -1;
        }
        try {
            return (long) packageManager.getPackageInfo(str, 1).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            return -1;
        }
    }

    @JavascriptInterface
    public String getResourceByName(String str, String str2, String str3) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            int identifier = this.juspayServices.getContext().getResources().getIdentifier(str, str2, str3);
            if (identifier > 0) {
                return super.getResourceById(identifier);
            }
        } catch (Exception e) {
            sdkTracker.trackAndLogException(LOG_TAG, LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.JBRIDGE, "Get Resource Exception", e);
        }
        return "0";
    }

    @JavascriptInterface
    public String getSHA256Hash(String str) {
        if (str == null) {
            return null;
        }
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            instance.update(str.getBytes());
            String bytesToHexString = EncHelper.bytesToHexString(instance.digest());
            JuspayLogger.d(LOG_TAG, "result is " + bytesToHexString);
            return bytesToHexString;
        } catch (NoSuchAlgorithmException e) {
            sdkTracker.trackAndLogException(LOG_TAG, LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.JBRIDGE, "Exception caught trying to SHA-256 hash", e);
            return null;
        }
    }

    @JavascriptInterface
    public String getStatusBarHeight(String str, String str2, String str3) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            int identifier = this.juspayServices.getContext().getResources().getIdentifier(str, str2, str3);
            if (identifier > 0) {
                return "" + this.juspayServices.getContext().getResources().getDimensionPixelSize(identifier);
            }
        } catch (Exception e) {
            sdkTracker.trackAndLogException(LOG_TAG, LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.JBRIDGE, "Get Resource Exception", e);
        }
        return "0";
    }

    public void handleCustomTabResult(Intent intent) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        if (intent != null) {
            try {
                invokeCallbackInDUIWebview((String) this.listenerMap.get("customtab-result-cb"), Utils.toJSON(intent.getExtras()).toString());
            } catch (Exception e) {
                sdkTracker.trackAndLogException(LOG_TAG, LogCategory.API_CALL, LogSubCategory.ApiCall.SDK, Labels.SDK.CUSTOM_TAB, "JSON Exception", e);
                invokeCallbackInDUIWebview((String) this.listenerMap.get("customtab-result-cb"), "{}");
            }
        } else {
            invokeCallbackInDUIWebview((String) this.listenerMap.get("customtab-result-cb"), "{}");
        }
    }

    @JavascriptInterface
    public void handlePhonepayActivityResult(String str) {
        invokeCallbackInDUIWebview("", str);
    }

    @JavascriptInterface
    public void hideJuspayLoader(String str) {
        ExecutorManager.runOnMainThread(new C0428zq(12, this, str));
    }

    @JavascriptInterface
    public void hideSoftInput() {
        InputMethodManager inputMethodManager;
        Activity activity = this.activity;
        if (activity != null && activity.getCurrentFocus() != null && (inputMethodManager = (InputMethodManager) this.activity.getSystemService("input_method")) != null) {
            inputMethodManager.hideSoftInputFromWindow(this.activity.getCurrentFocus().getWindowToken(), 0);
        }
    }

    @JavascriptInterface
    public boolean isCCTSupportedChromeAvailable(String str) {
        try {
            return CustomtabActivity.isChromeInstalled(CustomtabActivity.getCustomTabsPackages(this.juspayServices.getContext(), str));
        } catch (Exception unused) {
            return false;
        }
    }

    @JavascriptInterface
    public boolean isNoLimitsActivity() {
        Activity activity = this.activity;
        if (activity != null && (activity.getWindow().getAttributes().flags & AdRequest.MAX_CONTENT_URL_LENGTH) == 512) {
            return true;
        }
        return false;
    }

    @JavascriptInterface
    public boolean isShimmerPossible() {
        try {
            Class.forName("com.facebook.shimmer.ShimmerFrameLayout");
            Class.forName("com.facebook.shimmer.Shimmer");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @JavascriptInterface
    public String jweDecrypt(String str, String str2) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            KeyPair keyPair = EncHelper.getKeyPair(str2);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(PaymentConstants.PAYLOAD, JOSEUtils.jweDecrypt(str, keyPair.getPrivate()));
            jSONObject.put("error", false);
            return jSONObject.toString();
        } catch (Exception e) {
            sdkTracker.trackAndLogException(LOG_TAG, LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.JBRIDGE, "Exception while trying to decrypt JSON Web Token", e);
            return String.format("{\"error\":true,\"payload\":\"%s\"}", new Object[]{e});
        }
    }

    @JavascriptInterface
    public String jweEncrypt(String str, String str2, String str3) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            return String.format("{\"error\":false,\"payload\":\"%s\"}", new Object[]{JOSEUtils.jweEncrypt(str, str2, Base64.decode(str3, 2))});
        } catch (Exception e) {
            sdkTracker.trackAndLogException(LOG_TAG, LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.JBRIDGE, "Exception while trying to encrypt JSON Web Token", e);
            return String.format("{\"error\":true,\"payload\":\"%s\"}", new Object[]{e});
        }
    }

    @JavascriptInterface
    public String jwsSign(String str, String str2, String str3) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            return String.format("{\"error\":false,\"payload\":\"%s\"}", new Object[]{JOSEUtils.jwsSign(str, str2, EncHelper.getKeyPair(str3).getPrivate())});
        } catch (Exception e) {
            sdkTracker.trackAndLogException(LOG_TAG, LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.JBRIDGE, "Exception while trying to sign JSON Web Token", e);
            return String.format("{\"error\":true,\"payload\":\"%s\"}", new Object[]{e});
        }
    }

    @JavascriptInterface
    public boolean jwsVerify(String str, String str2) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            return JOSEUtils.jwsVerify(str, Base64.decode(str2, 2));
        } catch (Exception e) {
            sdkTracker.trackAndLogException(LOG_TAG, LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.JBRIDGE, "Exception while trying to verify JSON Web Token", e);
            return false;
        }
    }

    @JavascriptInterface
    public void launchCustomTab(String str, String str2) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        this.listenerMap.put("customtab-result-cb", str2);
        try {
            if (this.juspayServices.isPaused()) {
                sdkTracker.trackAction(LOG_TAG, LogCategory.API_CALL, LogSubCategory.ApiCall.SDK, Labels.SDK.CUSTOM_TAB, "onPause called before launch customtab");
                unRegisterReceiver();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("status", "onPause");
                invokeCallbackInDUIWebview(str2, jSONObject.toString());
                return;
            }
            Intent intent = new Intent(this.juspayServices.getContext(), CustomtabActivity.class);
            intent.putExtra("url", str);
            registerReceiver("customtab-result");
            this.juspayServices.startActivityForResult(intent, -1, (Bundle) null);
        } catch (Exception e) {
            sdkTracker.trackAndLogException(LOG_TAG, LogCategory.API_CALL, LogSubCategory.ApiCall.SDK, Labels.SDK.CUSTOM_TAB, "Exception at launch customtab", e);
            unRegisterReceiver();
            invokeCallbackInDUIWebview(str2, e.toString());
        }
    }

    @JavascriptInterface
    public void openApp(String str, String str2, String str3, int i, int i2) {
        Intent intent = new Intent();
        intent.setPackage(str);
        intent.setAction(str3);
        intent.setData(Uri.parse(str2));
        intent.setFlags(i);
        this.juspayServices.startActivityForResult(intent, i2, (Bundle) null);
    }

    @JavascriptInterface
    public void registerReceiver(String str) {
        if (this.broadcastReceiver == null) {
            this.broadcastReceiver = new BroadcastReceiver() {
                public void onReceive(Context context, Intent intent) {
                    JBridge.this.receiverCallback(intent);
                }
            };
            ji a = ji.a(this.juspayServices.getContext());
            BroadcastReceiver broadcastReceiver2 = this.broadcastReceiver;
            IntentFilter intentFilter = new IntentFilter(str);
            synchronized (a.f3037a) {
                ji.c cVar = new ji.c(broadcastReceiver2, intentFilter);
                ArrayList arrayList = a.f3037a.get(broadcastReceiver2);
                if (arrayList == null) {
                    arrayList = new ArrayList(1);
                    a.f3037a.put(broadcastReceiver2, arrayList);
                }
                arrayList.add(cVar);
                for (int i = 0; i < intentFilter.countActions(); i++) {
                    String action = intentFilter.getAction(i);
                    ArrayList arrayList2 = a.b.get(action);
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList(1);
                        a.b.put(action, arrayList2);
                    }
                    arrayList2.add(cVar);
                }
            }
        }
    }

    public void reset() {
        super.reset();
        unRegisterReceiver();
    }

    @JavascriptInterface
    @Deprecated
    public String rsaEncryption(String str, String str2, String str3) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            Cipher instance = Cipher.getInstance(str2);
            instance.init(1, (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str3, 2))));
            return String.format("{\"error\":false,\"payload\":\"%s\"}", new Object[]{Base64.encodeToString(instance.doFinal(str.getBytes()), 2)});
        } catch (Exception e) {
            sdkTracker.trackAndLogException(LOG_TAG, LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.JBRIDGE, "Exception while trying to encrypt using RSA", e);
            return String.format("{\"error\":true,\"payload\":\"%s\"}", new Object[]{e});
        }
    }

    @JavascriptInterface
    public void shareLink(String str, String str2, String str3) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", str);
        this.juspayServices.startActivityForResult(Intent.createChooser(intent, str2), -1, (Bundle) null);
        invokeCallbackInDUIWebview(str3, "true");
    }

    @JavascriptInterface
    public void showJuspayLoader(String str) {
        ExecutorManager.runOnMainThread(new Ft(6, this, str));
    }

    @JavascriptInterface
    public void startDatePicker(String str, String str2, String str3) {
        ExecutorManager.runOnMainThread(new o(this, str, str2, str3));
    }

    @JavascriptInterface
    public void startLottieAnimation(int i, String str, boolean z, float f, float f2) {
        ExecutorManager.runOnMainThread(new C1441vg(this, i, str, z, f, f2, this.juspayServices.getSdkTracker()));
    }

    @JavascriptInterface
    public void startPaytmRequest(String str, String str2, String str3) {
        String str4;
        JuspayServices juspayServices;
        String str5;
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (versionCompare(str2, "8.6.0") < 0) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("nativeSdkForMerchantAmount", jSONObject.optString("nativeSdkForMerchantAmount"));
                bundle.putString("orderid", jSONObject.optString("orderid"));
                bundle.putString(LoginActivity.PASSED_MID, jSONObject.optString(LoginActivity.PASSED_MID));
                bundle.putString("txnToken", jSONObject.optString("txnToken"));
                intent.setComponent(new ComponentName("net.one97.paytm", jSONObject.optString("net.one97.paytm")));
                intent.putExtra("paymentmode", jSONObject.optInt("paymentmode"));
                intent.putExtra("bill", bundle);
                this.juspayServices.startActivityForResult(intent, 116, (Bundle) null);
                juspayServices = this.juspayServices;
                str4 = "paytmSDkParams1";
                str5 = intent.toString();
            } else {
                Intent intent2 = new Intent();
                intent2.setComponent(new ComponentName("net.one97.paytm", jSONObject.optString("net.one97.paytm")));
                intent2.putExtra("paymentmode", jSONObject.optInt("paymentmode"));
                intent2.putExtra("enable_paytm_invoke", jSONObject.optBoolean("enable_paytm_invoke"));
                intent2.putExtra("paytm_invoke", jSONObject.optBoolean("paytm_invoke"));
                intent2.putExtra(FirebaseAnalytics.Param.PRICE, jSONObject.optString(FirebaseAnalytics.Param.PRICE));
                intent2.putExtra("nativeSdkEnabled", jSONObject.optBoolean("nativeSdkEnabled"));
                intent2.putExtra("orderid", jSONObject.optString("orderid"));
                intent2.putExtra("txnToken", jSONObject.optString("txnToken"));
                intent2.putExtra(LoginActivity.PASSED_MID, jSONObject.optString(LoginActivity.PASSED_MID));
                this.juspayServices.startActivityForResult(intent2, 116, (Bundle) null);
                juspayServices = this.juspayServices;
                str4 = "paytmSDkParams2";
                str5 = intent2.toString();
            }
            juspayServices.sdkDebug(str4, str5);
        } catch (JSONException e) {
            sdkTracker.trackAndLogException(LOG_TAG, LogCategory.API_CALL, LogSubCategory.ApiCall.SDK, Labels.SDK.PAYTM_UTILS, "Paytm Init Exception", e);
            invokeCallbackInDUIWebview(str3, e.toString());
        }
    }

    @JavascriptInterface
    public void startPhonepeRequest(String str, String str2) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        intent.setPackage(str2);
        this.juspayServices.startActivityForResult(intent, 113, (Bundle) null);
    }

    @JavascriptInterface
    public void unRegisterReceiver() {
        if (this.broadcastReceiver != null) {
            ji a = ji.a(this.juspayServices.getContext());
            BroadcastReceiver broadcastReceiver2 = this.broadcastReceiver;
            synchronized (a.f3037a) {
                ArrayList remove = a.f3037a.remove(broadcastReceiver2);
                if (remove != null) {
                    for (int size = remove.size() - 1; size >= 0; size--) {
                        ji.c cVar = (ji.c) remove.get(size);
                        cVar.b = true;
                        for (int i = 0; i < cVar.f3040a.countActions(); i++) {
                            String action = cVar.f3040a.getAction(i);
                            ArrayList arrayList = a.b.get(action);
                            if (arrayList != null) {
                                for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                                    ji.c cVar2 = (ji.c) arrayList.get(size2);
                                    if (cVar2.a == broadcastReceiver2) {
                                        cVar2.b = true;
                                        arrayList.remove(size2);
                                    }
                                }
                                if (arrayList.size() <= 0) {
                                    a.b.remove(action);
                                }
                            }
                        }
                    }
                }
            }
            this.broadcastReceiver = null;
        }
    }

    @JavascriptInterface
    public void writeFileToDisk(String str, String str2, String str3) {
        invokeCallbackInDUIWebview(str3, this.juspayServices.getFileProviderService().writeFileToDisk(this.juspayServices.getContext(), str, str2));
    }

    @JavascriptInterface
    public boolean checkPhonePeSdk() {
        try {
            Class.forName("com.phonepe.android.sdk.api.PhonePe");
            Class.forName("com.phonepe.android.sdk.api.PhonePeInitException");
            Class.forName("com.phonepe.android.sdk.api.builders.TransactionRequestBuilder");
            Class.forName("com.phonepe.android.sdk.base.model.TransactionRequest");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @JavascriptInterface
    @Deprecated
    public void startPhonepeRequest(String str, String str2, String str3, String str4) {
        invokeCallbackInDUIWebview(str4, "Function deprecated");
    }
}
