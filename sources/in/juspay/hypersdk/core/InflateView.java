package in.juspay.hypersdk.core;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.AdapterView;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.PopupMenu;
import androidx.annotation.Keep;
import com.google.ads.mediation.facebook.FacebookMediationAdapter;
import com.google.android.gms.ads.AdError;
import com.google.firebase.messaging.Constants;
import in.juspay.hyper.core.ExecutorManager;
import in.juspay.hyperlottie.LottieAnimation;
import in.juspay.hypersdk.mystique.AccordionLayout;
import in.juspay.hypersdk.mystique.AnimationHolder;
import in.juspay.hypersdk.mystique.BottomSheetLayout;
import in.juspay.hypersdk.mystique.Callback;
import in.juspay.hypersdk.mystique.SwypeLayout;
import in.juspay.hypersdk.mystique.SwypeScroll;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class InflateView {
    private static final String ARG_TYPE_SPLIT = "_";
    private static final Pattern COMMAND_SPLIT = Pattern.compile("(?<!\\\\)" + Pattern.quote(";"));
    private static final String FUNCTION_ARG_SPLIT = ",";
    private static final Pattern FUNCTION_ARG_SPLIT_ESCAPE = Pattern.compile("(?<!\\\\)" + Pattern.quote(FUNCTION_ARG_SPLIT));
    private static final String FUNCTION_ARG_START = ":";
    private static final String KEYWORD_SPLIT = "->";
    private static final String LOG_TAG = "in.juspay.hypersdk.core.InflateView";
    private static final Map<Class<?>, Class<?>> PRIMITIVE_TYPES;
    private static final String SETTER_EQUALS = "=";
    private final AnimationHolder animationHolder;
    private String currView = "";
    private String currViewId = "-1";
    private final DuiCallback duiCallback;
    protected final DynamicUI dynamicUI;
    private String fileOrigin = "";
    private final HashMap<Cmd, Method> functionCache = new HashMap<>();
    private String lastCommand = "";
    private LottieAnimation lottieAnimation = null;
    private PopupMenu popUpMenu;
    protected HashMap<String, Object> state = new HashMap<>();
    /* access modifiers changed from: private */
    public float swipeEndX;
    /* access modifiers changed from: private */
    public float swipeEndY;
    /* access modifiers changed from: private */
    public float swipeStartX;
    /* access modifiers changed from: private */
    public float swipeStartY;
    private boolean useAppContext = false;

    public static class Cmd {
        /* access modifiers changed from: private */
        public final Class<?>[] args;
        /* access modifiers changed from: private */
        public final Class<?> clazz;
        /* access modifiers changed from: private */
        public final String functionName;

        public Cmd(Class<?> cls, String str, Class<?>[] clsArr) {
            this.clazz = cls;
            this.functionName = str;
            this.args = clsArr;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Cmd cmd = (Cmd) obj;
            if (this.clazz.equals(cmd.clazz) && this.functionName.equals(cmd.functionName)) {
                return Arrays.equals(this.args, cmd.args);
            }
            return false;
        }

        public int hashCode() {
            int i;
            int g = lf.g(this.functionName, this.clazz.hashCode() * 31, 31);
            Class<?>[] clsArr = this.args;
            if (clsArr != null) {
                i = Arrays.hashCode(clsArr);
            } else {
                i = 0;
            }
            return g + i;
        }
    }

    static {
        Hashtable hashtable = new Hashtable();
        PRIMITIVE_TYPES = hashtable;
        hashtable.put(Boolean.class, Boolean.TYPE);
        hashtable.put(Character.class, Character.TYPE);
        hashtable.put(Byte.class, Byte.TYPE);
        hashtable.put(Short.class, Short.TYPE);
        hashtable.put(Integer.class, Integer.TYPE);
        hashtable.put(Long.class, Long.TYPE);
        hashtable.put(Float.class, Float.TYPE);
        hashtable.put(Double.class, Double.TYPE);
        hashtable.put(Void.class, Void.TYPE);
    }

    public InflateView(final DynamicUI dynamicUI2) {
        this.dynamicUI = dynamicUI2;
        AnonymousClass1 r0 = new DuiCallback() {
            public void addJsToWebView(String str) {
                dynamicUI2.addJsToWebView(str);
            }

            public InflateView getInflateView() {
                return dynamicUI2.getInflateView();
            }

            public DuiLogger getLogger() {
                return dynamicUI2.getLogger();
            }
        };
        this.duiCallback = r0;
        this.state.put("duiObj", dynamicUI2);
        this.animationHolder = new AnimationHolder(r0, dynamicUI2.getAppContext().getResources().getDisplayMetrics().density);
        if (PaymentUtils.isClassAvailable("in.juspay.hyperlottie.LottieAnimation")) {
            this.lottieAnimation = new LottieAnimation(dynamicUI2.getAppContext(), dynamicUI2, dynamicUI2.getBridgeComponents().getFileProviderInterface());
        }
    }

    private Object findAndSetField(Object obj, String str, String str2, boolean z) {
        Field field;
        try {
            field = obj.getClass().getField(str);
        } catch (NoSuchFieldException unused) {
            Field field2 = null;
            for (Field field3 : obj.getClass().getFields()) {
                if (field3.getName().equals(str)) {
                    field2 = field3;
                }
            }
            field = field2;
        }
        if (field != null) {
            field.set(obj, getValue(str2, z));
        } else {
            this.dynamicUI.getLogger().d(LOG_TAG, "Couldn't set field for " + str);
        }
        return obj;
    }

    private Method findMethodInClass(Class<?> cls, String str) {
        String str2;
        String str3;
        Class[] clsArr = null;
        if (cls == null) {
            return null;
        }
        if (indexOf(str, FUNCTION_ARG_START, 0) != -1) {
            String[] substr = substr(str, FUNCTION_ARG_START);
            str3 = substr[0];
            str2 = substr[1];
        } else {
            str3 = str;
            str2 = null;
        }
        if (str2 != null) {
            clsArr = parseTypeArguments(str2);
        }
        return findMethodWithCmd(new Cmd(cls, str3, clsArr));
    }

    private ObjectAnimator getAnimator(Object obj, PropertyValuesHolder[] propertyValuesHolderArr, JSONObject jSONObject) {
        float f;
        int i;
        String str;
        float f2 = 0.0f;
        if (jSONObject.has("duration")) {
            f = (float) jSONObject.getDouble("duration");
        } else {
            f = 0.0f;
        }
        if (jSONObject.has("delay")) {
            f2 = (float) jSONObject.getDouble("delay");
        }
        boolean z = false;
        if (jSONObject.has("repeatCount")) {
            i = jSONObject.getInt("repeatCount");
        } else {
            i = 0;
        }
        if (jSONObject.has("startImmediate") && jSONObject.getBoolean("startImmediate")) {
            z = true;
        }
        if (jSONObject.has("easing")) {
            str = jSONObject.getString("easing");
        } else {
            str = "linear";
        }
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(obj, propertyValuesHolderArr);
        ofPropertyValuesHolder.setDuration((long) f);
        ofPropertyValuesHolder.setStartDelay((long) f2);
        ofPropertyValuesHolder.setRepeatCount(i);
        ofPropertyValuesHolder.setInterpolator(getEasing(str));
        if (z) {
            ofPropertyValuesHolder.start();
        }
        return ofPropertyValuesHolder;
    }

    private int getArgsLength(String str) {
        return FUNCTION_ARG_SPLIT_ESCAPE.split(str).length;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00b6, code lost:
        if (r4.equals("strget") == false) goto L_0x00b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0108, code lost:
        return java.lang.Float.TYPE;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private <Any> Any getClassType(java.lang.String r10) {
        /*
            r9 = this;
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            java.lang.String r1 = "WARNING"
            if (r10 == 0) goto L_0x0154
            java.lang.String r2 = "_"
            java.lang.String[] r2 = r9.substr(r10, r2)
            r3 = 0
            r4 = r2[r3]
            r4.getClass()
            int r5 = r4.hashCode()
            r6 = 1
            r7 = -1
            switch(r5) {
                case -891988091: goto L_0x00b0;
                case 98: goto L_0x00a5;
                case 102: goto L_0x009a;
                case 105: goto L_0x008f;
                case 108: goto L_0x0084;
                case 115: goto L_0x0079;
                case 3184: goto L_0x006e;
                case 3212: goto L_0x0063;
                case 3677: goto L_0x0055;
                case 98855: goto L_0x0047;
                case 99674: goto L_0x0039;
                case 102230: goto L_0x002b;
                case 3392903: goto L_0x001d;
                default: goto L_0x001b;
            }
        L_0x001b:
            goto L_0x00b8
        L_0x001d:
            java.lang.String r3 = "null"
            boolean r3 = r4.equals(r3)
            if (r3 != 0) goto L_0x0027
            goto L_0x00b8
        L_0x0027:
            r3 = 12
            goto L_0x00b9
        L_0x002b:
            java.lang.String r3 = "get"
            boolean r3 = r4.equals(r3)
            if (r3 != 0) goto L_0x0035
            goto L_0x00b8
        L_0x0035:
            r3 = 11
            goto L_0x00b9
        L_0x0039:
            java.lang.String r3 = "dpf"
            boolean r3 = r4.equals(r3)
            if (r3 != 0) goto L_0x0043
            goto L_0x00b8
        L_0x0043:
            r3 = 10
            goto L_0x00b9
        L_0x0047:
            java.lang.String r3 = "ctx"
            boolean r3 = r4.equals(r3)
            if (r3 != 0) goto L_0x0051
            goto L_0x00b8
        L_0x0051:
            r3 = 9
            goto L_0x00b9
        L_0x0055:
            java.lang.String r3 = "sp"
            boolean r3 = r4.equals(r3)
            if (r3 != 0) goto L_0x005f
            goto L_0x00b8
        L_0x005f:
            r3 = 8
            goto L_0x00b9
        L_0x0063:
            java.lang.String r3 = "dp"
            boolean r3 = r4.equals(r3)
            if (r3 != 0) goto L_0x006c
            goto L_0x00b8
        L_0x006c:
            r3 = 7
            goto L_0x00b9
        L_0x006e:
            java.lang.String r3 = "cs"
            boolean r3 = r4.equals(r3)
            if (r3 != 0) goto L_0x0077
            goto L_0x00b8
        L_0x0077:
            r3 = 6
            goto L_0x00b9
        L_0x0079:
            java.lang.String r3 = "s"
            boolean r3 = r4.equals(r3)
            if (r3 != 0) goto L_0x0082
            goto L_0x00b8
        L_0x0082:
            r3 = 5
            goto L_0x00b9
        L_0x0084:
            java.lang.String r3 = "l"
            boolean r3 = r4.equals(r3)
            if (r3 != 0) goto L_0x008d
            goto L_0x00b8
        L_0x008d:
            r3 = 4
            goto L_0x00b9
        L_0x008f:
            java.lang.String r3 = "i"
            boolean r3 = r4.equals(r3)
            if (r3 != 0) goto L_0x0098
            goto L_0x00b8
        L_0x0098:
            r3 = 3
            goto L_0x00b9
        L_0x009a:
            java.lang.String r3 = "f"
            boolean r3 = r4.equals(r3)
            if (r3 != 0) goto L_0x00a3
            goto L_0x00b8
        L_0x00a3:
            r3 = 2
            goto L_0x00b9
        L_0x00a5:
            java.lang.String r3 = "b"
            boolean r3 = r4.equals(r3)
            if (r3 != 0) goto L_0x00ae
            goto L_0x00b8
        L_0x00ae:
            r3 = r6
            goto L_0x00b9
        L_0x00b0:
            java.lang.String r5 = "strget"
            boolean r5 = r4.equals(r5)
            if (r5 != 0) goto L_0x00b9
        L_0x00b8:
            r3 = r7
        L_0x00b9:
            java.lang.String r5 = " "
            switch(r3) {
                case 0: goto L_0x011c;
                case 1: goto L_0x0119;
                case 2: goto L_0x0116;
                case 3: goto L_0x0113;
                case 4: goto L_0x0110;
                case 5: goto L_0x010f;
                case 6: goto L_0x011c;
                case 7: goto L_0x0113;
                case 8: goto L_0x010c;
                case 9: goto L_0x0109;
                case 10: goto L_0x0106;
                case 11: goto L_0x00c5;
                case 12: goto L_0x00c3;
                default: goto L_0x00be;
            }
        L_0x00be:
            java.lang.Class r10 = r9.getClassName(r4)     // Catch:{ ClassNotFoundException -> 0x011f }
            goto L_0x011e
        L_0x00c3:
            r10 = 0
            return r10
        L_0x00c5:
            java.util.HashMap<java.lang.String, java.lang.Object> r0 = r9.state
            r2 = r2[r6]
            java.lang.Object r0 = r0.get(r2)
            if (r0 == 0) goto L_0x00d4
            java.lang.Class r10 = r0.getClass()
            return r10
        L_0x00d4:
            in.juspay.hypersdk.core.DynamicUI r0 = r9.dynamicUI
            in.juspay.hypersdk.core.DuiLogger r0 = r0.getLogger()
            java.lang.String r2 = " isNull : fn__getClassType - "
            java.lang.StringBuilder r3 = defpackage.xx.K(r2, r10, r5)
            java.lang.String r4 = r9.getErrorDetails()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r0.e(r1, r3)
            in.juspay.hypersdk.core.DynamicUI r0 = r9.dynamicUI
            in.juspay.hypersdk.mystique.Callback r0 = r0.getErrorCallback()
            java.lang.StringBuilder r10 = defpackage.xx.K(r2, r10, r5)
            java.lang.String r2 = r9.getErrorDetails()
            r10.append(r2)
            java.lang.String r10 = r10.toString()
            r0.onError(r1, r10)
        L_0x0106:
            java.lang.Class r10 = java.lang.Float.TYPE
            return r10
        L_0x0109:
            java.lang.Class<android.content.Context> r10 = android.content.Context.class
            return r10
        L_0x010c:
            java.lang.Class<java.lang.Float> r10 = java.lang.Float.class
            return r10
        L_0x010f:
            return r0
        L_0x0110:
            java.lang.Class r10 = java.lang.Long.TYPE
            return r10
        L_0x0113:
            java.lang.Class r10 = java.lang.Integer.TYPE
            return r10
        L_0x0116:
            java.lang.Class r10 = java.lang.Float.TYPE
            return r10
        L_0x0119:
            java.lang.Class r10 = java.lang.Boolean.TYPE
            return r10
        L_0x011c:
            java.lang.Class<java.lang.CharSequence> r10 = java.lang.CharSequence.class
        L_0x011e:
            return r10
        L_0x011f:
            in.juspay.hypersdk.core.DynamicUI r2 = r9.dynamicUI
            in.juspay.hypersdk.core.DuiLogger r2 = r2.getLogger()
            java.lang.String r3 = " no class with name "
            java.lang.String r6 = " : fn__getClassType - "
            java.lang.StringBuilder r7 = defpackage.C0437ME.b(r3, r4, r6, r10, r5)
            java.lang.String r8 = r9.getErrorDetails()
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            r2.e(r1, r7)
            in.juspay.hypersdk.core.DynamicUI r2 = r9.dynamicUI
            in.juspay.hypersdk.mystique.Callback r2 = r2.getErrorCallback()
            java.lang.StringBuilder r10 = defpackage.C0437ME.b(r3, r4, r6, r10, r5)
            java.lang.String r3 = r9.getErrorDetails()
            r10.append(r3)
            java.lang.String r10 = r10.toString()
            r2.onError(r1, r10)
            goto L_0x0188
        L_0x0154:
            in.juspay.hypersdk.core.DynamicUI r10 = r9.dynamicUI
            in.juspay.hypersdk.core.DuiLogger r10 = r10.getLogger()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = " isNull : fn__getClassType -  toConvert "
            r2.<init>(r3)
            java.lang.String r4 = r9.getErrorDetails()
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r10.e(r1, r2)
            in.juspay.hypersdk.core.DynamicUI r10 = r9.dynamicUI
            in.juspay.hypersdk.mystique.Callback r10 = r10.getErrorCallback()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r3)
            java.lang.String r3 = r9.getErrorDetails()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r10.onError(r1, r2)
        L_0x0188:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.core.InflateView.getClassType(java.lang.String):java.lang.Object");
    }

    private Context getContext() {
        if (this.useAppContext) {
            return this.dynamicUI.getAppContext();
        }
        return this.dynamicUI.getActivity();
    }

    private TimeInterpolator getCustomEasing(String str, float[] fArr) {
        str.getClass();
        if (str.equals("bezier")) {
            return new PathInterpolator(fArr[0], fArr[1], fArr[2], fArr[3]);
        }
        if (!str.equals("spring")) {
            return new LinearInterpolator();
        }
        return new C0519Gf(fArr);
    }

    private TimeInterpolator getEasing(String str) {
        str.getClass();
        char c = 65535;
        switch (str.hashCode()) {
            case -1965120668:
                if (str.equals("ease-in")) {
                    c = 0;
                    break;
                }
                break;
            case -1383205240:
                if (str.equals("bounce")) {
                    c = 1;
                    break;
                }
                break;
            case -1102672091:
                if (str.equals("linear")) {
                    c = 2;
                    break;
                }
                break;
            case -789192465:
                if (str.equals("ease-out")) {
                    c = 3;
                    break;
                }
                break;
            case -361990811:
                if (str.equals("ease-in-out")) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return new AccelerateInterpolator();
            case 1:
                return new BounceInterpolator();
            case 2:
                return new LinearInterpolator();
            case 3:
                return new DecelerateInterpolator();
            case 4:
                return new AccelerateDecelerateInterpolator();
            default:
                try {
                    if (str.contains("[")) {
                        String substring = str.substring(0, str.indexOf("["));
                        JSONArray jSONArray = new JSONArray(str.substring(str.indexOf("[")));
                        int length = jSONArray.length();
                        float[] fArr = new float[length];
                        for (int i = 0; i < length; i++) {
                            fArr[i] = (float) jSONArray.getDouble(i);
                        }
                        return getCustomEasing(substring, fArr);
                    }
                } catch (JSONException unused) {
                }
                return new LinearInterpolator();
        }
    }

    private <Any> Any getValue(String str, boolean z) {
        if (str != null) {
            this.dynamicUI.getLogger().d("getValue!", str);
            String[] substr = substr(str, ARG_TYPE_SPLIT);
            String str2 = substr[0];
            String str3 = substr[1];
            if (str3.indexOf(92) != -1 && str3.contains(";")) {
                str3 = str3.replace("\\\\;", ";");
            }
            if (str3.indexOf(92) != -1 && str3.contains(ARG_TYPE_SPLIT)) {
                str3 = str3.replace("\\\\_", ARG_TYPE_SPLIT);
            }
            if (str3.indexOf(92) != -1 && str3.contains(FUNCTION_ARG_START)) {
                str3 = str3.replace("\\\\:", FUNCTION_ARG_START);
            }
            if (str3.indexOf(92) != -1 && str3.contains(FUNCTION_ARG_SPLIT)) {
                str3 = str3.replace("\\\\,", FUNCTION_ARG_SPLIT);
            }
            if (str3.indexOf(92) != -1 && str3.contains(SETTER_EQUALS)) {
                str3 = str3.replace("\\\\=", SETTER_EQUALS);
            }
            return getValueNew(str2, str3);
        }
        DuiLogger logger = this.dynamicUI.getLogger();
        logger.e("WARNING", " isNull : fn__getValue - value " + getErrorDetails());
        Callback errorCallback = this.dynamicUI.getErrorCallback();
        errorCallback.onError("WARNING", " isNull : fn__getValue - value " + getErrorDetails());
        return null;
    }

    private int indexOf(String str, String str2, int i) {
        int indexOf = str.substring(i).indexOf(str2);
        if (!(indexOf == -1 || indexOf == 0 || indexOf >= str.length())) {
            int i2 = indexOf + i;
            if (str.charAt(i2 - 1) == '\\') {
                return indexOf(str, str2, str2.length() + i2);
            }
        }
        if (indexOf == -1) {
            return indexOf;
        }
        return indexOf + i;
    }

    public static boolean isWrappedPrimitiveType(Class<?> cls) {
        return PRIMITIVE_TYPES.containsKey(cls);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$dismissPopUp$11() {
        PopupMenu popupMenu = this.popUpMenu;
        if (popupMenu != null) {
            popupMenu.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ float lambda$getCustomEasing$10(float[] fArr, float f) {
        double pow = Math.pow(2.0d, (double) (-10.0f * f));
        float f2 = fArr[0];
        return ((float) (Math.sin((6.283185307179586d / ((double) f2)) * ((double) (f - (f2 / 4.0f)))) * pow)) + 1.0f;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ CharSequence lambda$parseKeys$0(String str, CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        while (i < i2) {
            if (!Pattern.compile(str).matcher(String.valueOf(charSequence.charAt(i))).matches()) {
                return "";
            }
            i++;
        }
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean lambda$parseKeys$1(String str, View view, int i, KeyEvent keyEvent) {
        DynamicUI dynamicUI2 = this.dynamicUI;
        dynamicUI2.addJsToWebView("window.callUICallback('" + str + "','" + i + "');");
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean lambda$parseKeys$2(String str, View view) {
        this.dynamicUI.addJsToWebView(lf.j("window.callUICallback('", str, "');"));
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$parseKeys$3(String str, View view) {
        this.dynamicUI.addJsToWebView(lf.j("window.callUICallback('", str, "');"));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$parseKeys$4(String str) {
        this.dynamicUI.addJsToWebView(lf.j("window.callUICallback('", str, "');"));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$parseKeys$5(String str, AdapterView adapterView, View view, int i, long j) {
        DynamicUI dynamicUI2 = this.dynamicUI;
        dynamicUI2.addJsToWebView("window.callUICallback('" + str + "'," + i + ");");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$parseKeys$6(String str, View view, boolean z) {
        DynamicUI dynamicUI2 = this.dynamicUI;
        dynamicUI2.addJsToWebView("window.callUICallback('" + str + "','" + z + "');");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$parseKeys$7(String str, CalendarView calendarView, int i, int i2, int i3) {
        this.dynamicUI.addJsToWebView("window.callUICallback('" + str + "','" + i + "','" + i2 + "','" + i3 + "');");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean lambda$parseKeys$8(String str, MenuItem menuItem) {
        DynamicUI dynamicUI2 = this.dynamicUI;
        StringBuilder K = xx.K("window.callUICallback('", str, "', '");
        K.append(menuItem.getItemId());
        K.append("');");
        dynamicUI2.addJsToWebView(K.toString());
        return true;
    }

    private void normalTextChange(JSONObject jSONObject, Object obj) {
        Method method = obj.getClass().getMethod("addTextChangedListener", new Class[]{TextWatcher.class});
        final String string = jSONObject.getString("onChange");
        method.invoke(obj, new Object[]{new TextWatcher() {
            private String previousText;

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.previousText = charSequence.toString();
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!this.previousText.equals(charSequence.toString())) {
                    DynamicUI dynamicUI = InflateView.this.dynamicUI;
                    dynamicUI.addJsToWebView("window.callUICallback('" + string + "', '" + charSequence + "');");
                }
            }

            public void afterTextChanged(Editable editable) {
            }
        }});
    }

    private Object[] parseArguments(String str, boolean z) {
        if (str == null || str.trim().equals("")) {
            return new Object[0];
        }
        ArrayList arrayList = new ArrayList();
        String[] split = str.split(ARG_TYPE_SPLIT);
        if (indexOf(str, FUNCTION_ARG_SPLIT, 0) == -1 || split.length == 2) {
            arrayList.add(getValue(str, z));
        } else {
            for (String value : FUNCTION_ARG_SPLIT_ESCAPE.split(str)) {
                arrayList.add(getValue(value, z));
            }
        }
        return arrayList.toArray();
    }

    private Class<?>[] parseTypeArguments(String str) {
        if (str == null) {
            return null;
        }
        String[] split = str.split(ARG_TYPE_SPLIT);
        if (!(indexOf(str, FUNCTION_ARG_SPLIT, 0) == -1 || split.length == 2)) {
            String[] split2 = FUNCTION_ARG_SPLIT_ESCAPE.split(str);
            if (split2.length > 1) {
                Class<?>[] clsArr = new Class[split2.length];
                for (int i = 0; i < split2.length; i++) {
                    clsArr[i] = (Class) getClassType(split2[i]);
                }
                return clsArr;
            }
        }
        return new Class[]{(Class) getClassType(str)};
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0078, code lost:
        if (r2.equals("ctx") == false) goto L_0x0086;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.Object runCommand(java.lang.Object r12, java.lang.Object r13, java.lang.String r14, boolean r15) {
        /*
            r11 = this;
            r11.lastCommand = r14
            java.lang.String r0 = "->"
            r1 = 0
            int r2 = r11.indexOf(r14, r0, r1)
            java.lang.String r3 = ":"
            r4 = 1
            r5 = -1
            if (r2 == r5) goto L_0x03ec
            java.lang.String[] r2 = r11.substr(r14, r0)
            r2 = r2[r1]
            java.lang.String r6 = "_"
            int r7 = r11.indexOf(r2, r6, r1)
            java.lang.String r8 = "get"
            if (r7 == r5) goto L_0x002e
            boolean r7 = r2.startsWith(r8)
            if (r7 == 0) goto L_0x002e
            java.lang.String[] r2 = r11.substr(r2, r6)
            r7 = r2[r4]
            r2 = r2[r1]
            goto L_0x002f
        L_0x002e:
            r7 = 0
        L_0x002f:
            int r9 = r11.indexOf(r14, r3, r1)
            java.lang.String[] r14 = r11.substr(r14, r0)
            if (r9 == r5) goto L_0x0044
            r14 = r14[r4]
            java.lang.String[] r0 = r11.substr(r14, r3)
            r9 = r0[r1]
            r0 = r0[r4]
            goto L_0x0048
        L_0x0044:
            r14 = r14[r4]
            r0 = 0
            r9 = r14
        L_0x0048:
            r2.getClass()
            int r10 = r2.hashCode()
            switch(r10) {
                case -995424086: goto L_0x007b;
                case 98855: goto L_0x0072;
                case 102230: goto L_0x0069;
                case 3237035: goto L_0x005e;
                case 3559070: goto L_0x0053;
                default: goto L_0x0052;
            }
        L_0x0052:
            goto L_0x0086
        L_0x0053:
            java.lang.String r4 = "this"
            boolean r4 = r2.equals(r4)
            if (r4 != 0) goto L_0x005c
            goto L_0x0086
        L_0x005c:
            r4 = 4
            goto L_0x0087
        L_0x005e:
            java.lang.String r4 = "infl"
            boolean r4 = r2.equals(r4)
            if (r4 != 0) goto L_0x0067
            goto L_0x0086
        L_0x0067:
            r4 = 3
            goto L_0x0087
        L_0x0069:
            boolean r4 = r2.equals(r8)
            if (r4 != 0) goto L_0x0070
            goto L_0x0086
        L_0x0070:
            r4 = 2
            goto L_0x0087
        L_0x0072:
            java.lang.String r8 = "ctx"
            boolean r8 = r2.equals(r8)
            if (r8 != 0) goto L_0x0087
            goto L_0x0086
        L_0x007b:
            java.lang.String r4 = "parent"
            boolean r4 = r2.equals(r4)
            if (r4 != 0) goto L_0x0084
            goto L_0x0086
        L_0x0084:
            r4 = r1
            goto L_0x0087
        L_0x0086:
            r4 = r5
        L_0x0087:
            java.lang.String r8 = " "
            java.lang.String r10 = "WARNING"
            switch(r4) {
                case 0: goto L_0x02cf;
                case 1: goto L_0x0254;
                case 2: goto L_0x0194;
                case 3: goto L_0x0126;
                case 4: goto L_0x00b8;
                default: goto L_0x008e;
            }
        L_0x008e:
            java.lang.String r12 = "var_"
            int r12 = r11.indexOf(r9, r12, r1)
            if (r12 == r5) goto L_0x0355
            java.lang.String[] r12 = r11.substr(r9, r6)
            r0 = 1
            r12 = r12[r0]
            java.lang.Class r1 = r11.getClassName(r9)
            java.lang.reflect.Field r12 = r1.getDeclaredField(r12)
            r12.setAccessible(r0)
            java.lang.String[] r14 = r11.substr(r14, r3)
            r14 = r14[r0]
            java.lang.Object r14 = r11.getValue(r14, r15)
            r15 = 0
            r12.set(r15, r14)
            goto L_0x0447
        L_0x00b8:
            java.lang.Class r2 = r12.getClass()
            java.lang.reflect.Method r2 = r11.findMethodInClass(r2, r14)
            if (r0 == 0) goto L_0x00f5
            if (r2 == 0) goto L_0x00ce
            java.lang.Object[] r13 = r11.parseArguments(r0, r15)
            java.lang.Object r13 = r2.invoke(r12, r13)
            goto L_0x0447
        L_0x00ce:
            in.juspay.hypersdk.core.DynamicUI r12 = r11.dynamicUI
            in.juspay.hypersdk.core.DuiLogger r12 = r12.getLogger()
            java.lang.String r15 = " isNull : fn__runCommand - classMethodDetails  "
            java.lang.StringBuilder r0 = defpackage.xx.K(r15, r14, r8)
            java.lang.String r1 = r11.getErrorDetails()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r12.e(r10, r0)
            in.juspay.hypersdk.core.DynamicUI r12 = r11.dynamicUI
            in.juspay.hypersdk.mystique.Callback r12 = r12.getErrorCallback()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            goto L_0x033b
        L_0x00f5:
            if (r2 == 0) goto L_0x00ff
            java.lang.Object[] r13 = new java.lang.Object[r1]
            java.lang.Object r13 = r2.invoke(r12, r13)
            goto L_0x0447
        L_0x00ff:
            in.juspay.hypersdk.core.DynamicUI r12 = r11.dynamicUI
            in.juspay.hypersdk.core.DuiLogger r12 = r12.getLogger()
            java.lang.String r15 = " isNull : fn__runCommand - this  classMethodDetails "
            java.lang.StringBuilder r0 = defpackage.xx.K(r15, r14, r8)
            java.lang.String r1 = r11.getErrorDetails()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r12.e(r10, r0)
            in.juspay.hypersdk.core.DynamicUI r12 = r11.dynamicUI
            in.juspay.hypersdk.mystique.Callback r12 = r12.getErrorCallback()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            goto L_0x033b
        L_0x0126:
            java.lang.Class r12 = r11.getClass()
            java.lang.reflect.Method r12 = r11.findMethodInClass(r12, r14)
            if (r0 == 0) goto L_0x0163
            if (r12 == 0) goto L_0x013c
            java.lang.Object[] r13 = r11.parseArguments(r0, r15)
            java.lang.Object r13 = r12.invoke(r11, r13)
            goto L_0x0447
        L_0x013c:
            in.juspay.hypersdk.core.DynamicUI r12 = r11.dynamicUI
            in.juspay.hypersdk.core.DuiLogger r12 = r12.getLogger()
            java.lang.String r15 = " isNull : fn__runCommand - infl  classMethodDetails "
            java.lang.StringBuilder r0 = defpackage.xx.K(r15, r14, r8)
            java.lang.String r1 = r11.getErrorDetails()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r12.e(r10, r0)
            in.juspay.hypersdk.core.DynamicUI r12 = r11.dynamicUI
            in.juspay.hypersdk.mystique.Callback r12 = r12.getErrorCallback()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            goto L_0x033b
        L_0x0163:
            if (r12 == 0) goto L_0x016d
            java.lang.Object[] r13 = new java.lang.Object[r1]
            java.lang.Object r13 = r12.invoke(r11, r13)
            goto L_0x0447
        L_0x016d:
            in.juspay.hypersdk.core.DynamicUI r12 = r11.dynamicUI
            in.juspay.hypersdk.core.DuiLogger r12 = r12.getLogger()
            java.lang.String r15 = " isNull : fn__runCommand - infl classMethodDetails  "
            java.lang.StringBuilder r0 = defpackage.xx.K(r15, r14, r8)
            java.lang.String r1 = r11.getErrorDetails()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r12.e(r10, r0)
            in.juspay.hypersdk.core.DynamicUI r12 = r11.dynamicUI
            in.juspay.hypersdk.mystique.Callback r12 = r12.getErrorCallback()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            goto L_0x033b
        L_0x0194:
            if (r7 == 0) goto L_0x0447
            java.util.HashMap<java.lang.String, java.lang.Object> r12 = r11.state
            java.lang.Object r12 = r12.get(r7)
            int r2 = r11.indexOf(r9, r6, r1)
            if (r2 != r5) goto L_0x0212
            if (r12 == 0) goto L_0x0212
            java.lang.Class r2 = r12.getClass()
            java.lang.reflect.Method r2 = r11.findMethodInClass(r2, r14)
            if (r0 == 0) goto L_0x01e1
            if (r2 == 0) goto L_0x01ba
            java.lang.Object[] r13 = r11.parseArguments(r0, r15)
            java.lang.Object r13 = r2.invoke(r12, r13)
            goto L_0x0447
        L_0x01ba:
            in.juspay.hypersdk.core.DynamicUI r12 = r11.dynamicUI
            in.juspay.hypersdk.core.DuiLogger r12 = r12.getLogger()
            java.lang.String r15 = " isNull : fn__runCommand - get classMethodDetails "
            java.lang.StringBuilder r0 = defpackage.xx.K(r15, r14, r8)
            java.lang.String r1 = r11.getErrorDetails()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r12.e(r10, r0)
            in.juspay.hypersdk.core.DynamicUI r12 = r11.dynamicUI
            in.juspay.hypersdk.mystique.Callback r12 = r12.getErrorCallback()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            goto L_0x033b
        L_0x01e1:
            if (r2 == 0) goto L_0x01eb
            java.lang.Object[] r13 = new java.lang.Object[r1]
            java.lang.Object r13 = r2.invoke(r12, r13)
            goto L_0x0447
        L_0x01eb:
            in.juspay.hypersdk.core.DynamicUI r12 = r11.dynamicUI
            in.juspay.hypersdk.core.DuiLogger r12 = r12.getLogger()
            java.lang.String r15 = " isNull : fn__runCommand - get classMethodDetails : "
            java.lang.StringBuilder r0 = defpackage.xx.K(r15, r14, r8)
            java.lang.String r1 = r11.getErrorDetails()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r12.e(r10, r0)
            in.juspay.hypersdk.core.DynamicUI r12 = r11.dynamicUI
            in.juspay.hypersdk.mystique.Callback r12 = r12.getErrorCallback()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            goto L_0x033b
        L_0x0212:
            if (r12 == 0) goto L_0x022c
            java.lang.String[] r12 = r11.substr(r9, r6)
            r13 = 1
            r12 = r12[r13]
            java.util.HashMap<java.lang.String, java.lang.Object> r0 = r11.state
            java.lang.Object r0 = r0.get(r7)
            java.lang.String[] r14 = r11.substr(r14, r3)
            r13 = r14[r13]
            java.lang.Object r12 = r11.findAndSetField(r0, r12, r13, r15)
            return r12
        L_0x022c:
            in.juspay.hypersdk.core.DynamicUI r12 = r11.dynamicUI
            in.juspay.hypersdk.core.DuiLogger r12 = r12.getLogger()
            java.lang.String r14 = " isNull : fn__runCommand - get_"
            java.lang.String r8 = " is null "
            java.lang.StringBuilder r15 = defpackage.xx.K(r14, r7, r8)
            java.lang.String r0 = r11.getErrorDetails()
            r15.append(r0)
            java.lang.String r15 = r15.toString()
            r12.e(r10, r15)
            in.juspay.hypersdk.core.DynamicUI r12 = r11.dynamicUI
            in.juspay.hypersdk.mystique.Callback r12 = r12.getErrorCallback()
            java.lang.StringBuilder r14 = defpackage.lf.n(r14, r7)
            goto L_0x0342
        L_0x0254:
            in.juspay.hypersdk.core.DynamicUI r12 = r11.dynamicUI
            android.app.Activity r12 = r12.getActivity()
            if (r12 != 0) goto L_0x0262
            in.juspay.hypersdk.core.DynamicUI r12 = r11.dynamicUI
            android.content.Context r12 = r12.getAppContext()
        L_0x0262:
            java.lang.Class r2 = r12.getClass()
            java.lang.reflect.Method r2 = r11.findMethodInClass(r2, r14)
            if (r0 == 0) goto L_0x029f
            if (r2 == 0) goto L_0x0278
            java.lang.Object[] r13 = r11.parseArguments(r0, r15)
            java.lang.Object r13 = r2.invoke(r12, r13)
            goto L_0x0447
        L_0x0278:
            in.juspay.hypersdk.core.DynamicUI r12 = r11.dynamicUI
            in.juspay.hypersdk.core.DuiLogger r12 = r12.getLogger()
            java.lang.String r15 = " isNull : fn__runCommand - ctx  classMethodDetails "
            java.lang.StringBuilder r0 = defpackage.xx.K(r15, r14, r8)
            java.lang.String r1 = r11.getErrorDetails()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r12.e(r10, r0)
            in.juspay.hypersdk.core.DynamicUI r12 = r11.dynamicUI
            in.juspay.hypersdk.mystique.Callback r12 = r12.getErrorCallback()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            goto L_0x033b
        L_0x029f:
            if (r2 == 0) goto L_0x02a9
            java.lang.Object[] r13 = new java.lang.Object[r1]
            java.lang.Object r13 = r2.invoke(r12, r13)
            goto L_0x0447
        L_0x02a9:
            in.juspay.hypersdk.core.DynamicUI r12 = r11.dynamicUI
            in.juspay.hypersdk.core.DuiLogger r12 = r12.getLogger()
            java.lang.String r15 = " isNull : fn__runCommand - ctx classMethodDetails  "
            java.lang.StringBuilder r0 = defpackage.xx.K(r15, r14, r8)
            java.lang.String r1 = r11.getErrorDetails()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r12.e(r10, r0)
            in.juspay.hypersdk.core.DynamicUI r12 = r11.dynamicUI
            in.juspay.hypersdk.mystique.Callback r12 = r12.getErrorCallback()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            goto L_0x033b
        L_0x02cf:
            java.lang.Class r2 = r12.getClass()
            java.lang.reflect.Method r2 = r11.findMethodInClass(r2, r14)
            java.lang.String r3 = " isNull : fn__runCommand - parent  classMethodDetails "
            if (r0 == 0) goto L_0x030c
            if (r2 == 0) goto L_0x02e7
            java.lang.Object[] r13 = r11.parseArguments(r0, r15)
            java.lang.Object r13 = r2.invoke(r12, r13)
            goto L_0x0447
        L_0x02e7:
            in.juspay.hypersdk.core.DynamicUI r12 = r11.dynamicUI
            in.juspay.hypersdk.core.DuiLogger r12 = r12.getLogger()
            java.lang.StringBuilder r15 = defpackage.xx.K(r3, r14, r8)
            java.lang.String r0 = r11.getErrorDetails()
            r15.append(r0)
            java.lang.String r15 = r15.toString()
            r12.e(r10, r15)
            in.juspay.hypersdk.core.DynamicUI r12 = r11.dynamicUI
            in.juspay.hypersdk.mystique.Callback r12 = r12.getErrorCallback()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r15 = r3
            goto L_0x033b
        L_0x030c:
            if (r2 == 0) goto L_0x0316
            java.lang.Object[] r13 = new java.lang.Object[r1]
            java.lang.Object r13 = r2.invoke(r12, r13)
            goto L_0x0447
        L_0x0316:
            in.juspay.hypersdk.core.DynamicUI r12 = r11.dynamicUI
            in.juspay.hypersdk.core.DuiLogger r12 = r12.getLogger()
            java.lang.StringBuilder r15 = defpackage.xx.K(r3, r14, r8)
            java.lang.String r0 = r11.getErrorDetails()
            r15.append(r0)
            java.lang.String r15 = r15.toString()
            r12.e(r10, r15)
            in.juspay.hypersdk.core.DynamicUI r12 = r11.dynamicUI
            in.juspay.hypersdk.mystique.Callback r12 = r12.getErrorCallback()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r15 = " isNull : fn__runCommand - parent classMethodDetails  "
        L_0x033b:
            r0.append(r15)
            r0.append(r14)
            r14 = r0
        L_0x0342:
            r14.append(r8)
            java.lang.String r15 = r11.getErrorDetails()
            r14.append(r15)
            java.lang.String r14 = r14.toString()
            r12.onError(r10, r14)
            goto L_0x0447
        L_0x0355:
            java.lang.String r12 = "new"
            boolean r4 = r14.equals(r12)
            if (r4 != 0) goto L_0x03a2
            java.lang.String[] r3 = r11.substr(r14, r3)
            r3 = r3[r1]
            boolean r12 = r3.equals(r12)
            if (r12 == 0) goto L_0x036a
            goto L_0x03a2
        L_0x036a:
            java.lang.Class r12 = r11.getClassName(r2)
            java.lang.reflect.Method r12 = r11.findMethodInClass(r12, r14)
            if (r12 == 0) goto L_0x0447
            java.lang.String r13 = r12.getName()
            java.lang.String r14 = "forName"
            boolean r13 = r13.equals(r14)
            if (r13 == 0) goto L_0x038c
            java.lang.Object r12 = r11.getValue(r0, r15)
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Class r13 = r11.getClassName(r12)
            goto L_0x0447
        L_0x038c:
            if (r0 == 0) goto L_0x0399
            java.lang.Object[] r13 = r11.parseArguments(r0, r15)
            r14 = 0
            java.lang.Object r13 = r12.invoke(r14, r13)
            goto L_0x0447
        L_0x0399:
            r13 = 0
            java.lang.Object[] r14 = new java.lang.Object[r1]
            java.lang.Object r13 = r12.invoke(r13, r14)
            goto L_0x0447
        L_0x03a2:
            if (r0 == 0) goto L_0x03e3
            java.lang.String r12 = "in.juspay.hypersdk.mystique.DuiInvocationHandler"
            boolean r12 = r2.equals(r12)
            if (r12 == 0) goto L_0x03b1
            r11.parseArguments(r0, r15)
            goto L_0x0447
        L_0x03b1:
            java.lang.Class[] r12 = r11.parseTypeArguments(r0)
            java.lang.Class r14 = r11.getClassName(r2)
            java.lang.reflect.Constructor[] r14 = r14.getConstructors()
            int r2 = r14.length
        L_0x03be:
            if (r1 >= r2) goto L_0x0447
            r3 = r14[r1]
            java.lang.Class[] r4 = r3.getParameterTypes()
            int r4 = r4.length
            int r5 = r11.getArgsLength(r0)
            if (r4 != r5) goto L_0x03e0
            java.lang.Class[] r4 = r3.getParameterTypes()
            boolean r4 = r11.matchTypes(r4, r12)
            if (r4 == 0) goto L_0x03e0
            java.lang.Object[] r12 = r11.parseArguments(r0, r15)
            java.lang.Object r13 = r3.newInstance(r12)
            goto L_0x0447
        L_0x03e0:
            int r1 = r1 + 1
            goto L_0x03be
        L_0x03e3:
            java.lang.Class r12 = r11.getClassName(r2)
            java.lang.Object r13 = r12.newInstance()
            goto L_0x0447
        L_0x03ec:
            if (r13 != 0) goto L_0x041b
            int r13 = r11.indexOf(r14, r3, r1)
            if (r13 == r5) goto L_0x040c
            java.lang.String[] r13 = r11.substr(r14, r3)
            r0 = 1
            r13 = r13[r0]
            java.lang.Class r0 = r12.getClass()
            java.lang.reflect.Method r14 = r11.findMethodInClass(r0, r14)
            java.lang.Object[] r13 = r11.parseArguments(r13, r15)
            java.lang.Object r13 = r14.invoke(r12, r13)
            goto L_0x0447
        L_0x040c:
            java.lang.Class r13 = r12.getClass()
            java.lang.reflect.Method r13 = r11.findMethodInClass(r13, r14)
            java.lang.Object[] r14 = new java.lang.Object[r1]
            java.lang.Object r13 = r13.invoke(r12, r14)
            goto L_0x0447
        L_0x041b:
            int r12 = r11.indexOf(r14, r3, r1)
            if (r12 == r5) goto L_0x0439
            java.lang.String[] r12 = r11.substr(r14, r3)
            r0 = 1
            r12 = r12[r0]
            java.lang.Class r0 = r13.getClass()
            java.lang.reflect.Method r14 = r11.findMethodInClass(r0, r14)
            java.lang.Object[] r12 = r11.parseArguments(r12, r15)
            java.lang.Object r13 = r14.invoke(r13, r12)
            goto L_0x0447
        L_0x0439:
            java.lang.Class r12 = r13.getClass()
            java.lang.reflect.Method r12 = r11.findMethodInClass(r12, r14)
            java.lang.Object[] r14 = new java.lang.Object[r1]
            java.lang.Object r13 = r12.invoke(r13, r14)
        L_0x0447:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.core.InflateView.runCommand(java.lang.Object, java.lang.Object, java.lang.String, boolean):java.lang.Object");
    }

    private void separatorTextChange(JSONObject jSONObject, Object obj) {
        obj.getClass().getMethod("addTextChangedListener", new Class[]{TextWatcher.class}).invoke(obj, new Object[]{new TextWatcher(jSONObject, jSONObject.getString("onChange"), (EditText) obj) {
            private static final int TOTAL_DIGITS = 21;
            private static final int TOTAL_SYMBOLS = 26;
            private final char DIVIDER;
            private final int DIVIDER_MODULO;
            private final int DIVIDER_POSITION;
            private boolean executeTextChange = true;
            private String previousText;
            final /* synthetic */ EditText val$cardField;
            final /* synthetic */ String val$js;
            final /* synthetic */ JSONObject val$properties;

            {
                this.val$properties = r2;
                this.val$js = r3;
                this.val$cardField = r4;
                int i = r2.getInt("separatorRepeat");
                this.DIVIDER_POSITION = i;
                this.DIVIDER_MODULO = i + 1;
                this.DIVIDER = r2.getString("separator").charAt(0);
            }

            private String buildCorrectString(char[] cArr, int i) {
                StringBuilder sb = new StringBuilder();
                for (int i2 = 0; i2 < cArr.length; i2++) {
                    char c = cArr[i2];
                    if (c != 0) {
                        sb.append(c);
                        if (i2 > 0 && i2 < i - 1 && (i2 + 1) % this.DIVIDER_POSITION == 0) {
                            sb.append(this.DIVIDER);
                        }
                    }
                }
                return sb.toString();
            }

            private char[] getDigitArray(Editable editable) {
                char[] cArr = new char[21];
                int i = 0;
                for (int i2 = 0; i2 < editable.length() && i < 21; i2++) {
                    char charAt = editable.charAt(i2);
                    if (Character.isDigit(charAt)) {
                        cArr[i] = charAt;
                        i++;
                    }
                }
                return cArr;
            }

            private boolean isInputCorrect(Editable editable) {
                boolean z;
                boolean z2;
                if (editable.length() <= 26) {
                    z = true;
                } else {
                    z = false;
                }
                for (int i = 0; i < editable.length(); i++) {
                    if (i <= 0 || (i + 1) % this.DIVIDER_MODULO != 0) {
                        z2 = Character.isDigit(editable.charAt(i));
                    } else if (this.DIVIDER == editable.charAt(i)) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    z &= z2;
                }
                return z;
            }

            public void afterTextChanged(Editable editable) {
                boolean z;
                if (editable.length() != 0 && this.val$cardField.isFocused() && !this.previousText.equals(editable.toString()) && this.executeTextChange) {
                    if (this.previousText.length() > editable.length()) {
                        z = true;
                    } else {
                        z = false;
                    }
                    InputFilter[] filters = editable.getFilters();
                    editable.setFilters(new InputFilter[0]);
                    int selectionStart = this.val$cardField.getSelectionStart();
                    this.executeTextChange = false;
                    int i = selectionStart + 1;
                    if (i % this.DIVIDER_MODULO == 0 && z) {
                        editable.delete(selectionStart - 1, selectionStart);
                    }
                    if (!isInputCorrect(editable)) {
                        editable.replace(0, editable.length(), buildCorrectString(getDigitArray(editable), editable.length()));
                        if (editable.length() > 0 && this.DIVIDER == editable.charAt(editable.length() - 1) && z) {
                            editable.delete(editable.length() - 1, editable.length());
                        }
                    }
                    if (selectionStart != 0 && selectionStart % this.DIVIDER_MODULO == 0 && editable.length() > selectionStart && !z) {
                        this.val$cardField.setSelection(i);
                    }
                    this.executeTextChange = true;
                    editable.setFilters(filters);
                }
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.previousText = charSequence.toString();
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!this.previousText.equals(charSequence.toString()) && this.executeTextChange) {
                    DynamicUI dynamicUI = InflateView.this.dynamicUI;
                    dynamicUI.addJsToWebView("window.callUICallback('" + this.val$js + "', '" + charSequence + "');");
                }
            }
        }});
    }

    private String[] substr(String str, String str2) {
        int indexOf = indexOf(str, str2, 0);
        if (indexOf == -1) {
            return new String[]{str};
        }
        return new String[]{str.substring(0, indexOf), str.substring(str2.length() + indexOf)};
    }

    private Method tryExactMatch(Class<?> cls, String str, Class<?>[] clsArr) {
        return cls.getMethod(str, clsArr);
    }

    private Method tryMultiAgrumentDeepMatch(Class<?> cls, String str, Class<?>[] clsArr) {
        if (AdError.UNDEFINED_DOMAIN.equals(str)) {
            return null;
        }
        this.dynamicUI.getLogger().d(LOG_TAG, "tryMultiAgrumentDeepMatch reached. Beware slow function.. " + cls.toString() + " : " + str + " : " + clsArr.length);
        for (Method method : cls.getMethods()) {
            if (method.getName().equals(str) && method.getParameterTypes().length == clsArr.length && matchTypes(method.getParameterTypes(), clsArr)) {
                return method;
            }
        }
        return null;
    }

    private Method trySingleArgumentDeepMatch(Class<?> cls, String str, Class<?> cls2) {
        Class<? super Object> superclass;
        if (isWrappedPrimitiveType(cls2)) {
            try {
                return cls.getMethod(str, new Class[]{PRIMITIVE_TYPES.get(cls2)});
            } catch (NoSuchMethodException unused) {
            }
        }
        Class<? super Object> cls3 = cls2;
        do {
            Class[] interfaces = cls3.getInterfaces();
            int i = 0;
            while (i < interfaces.length) {
                try {
                    return cls.getMethod(str, new Class[]{interfaces[i]});
                } catch (NoSuchMethodException unused2) {
                    i++;
                }
            }
            try {
                return cls.getMethod(str, new Class[]{cls3});
            } catch (NoSuchMethodException unused3) {
                superclass = cls3.getSuperclass();
                cls3 = superclass;
                if (superclass == null) {
                    this.dynamicUI.getLogger().e(LOG_TAG, "Never reach here");
                    return null;
                }
            }
        } while (superclass == null);
        this.dynamicUI.getLogger().e(LOG_TAG, "Never reach here");
        return null;
    }

    @Keep
    public Boolean containsInState(String str) {
        return Boolean.valueOf(this.state.containsKey(str));
    }

    @Keep
    public void convertAndStoreArray(ArrayList<?> arrayList, Class<?> cls, String str, boolean z) {
        int size = arrayList.size();
        if (z) {
            cls = PRIMITIVE_TYPES.get(cls);
        }
        if (cls != null) {
            Object newInstance = Array.newInstance(cls, size);
            for (int i = 0; i < size; i++) {
                Array.set(newInstance, i, arrayList.get(i));
            }
            this.state.put(str, newInstance);
        }
    }

    @Keep
    public Class<?> createPrimitiveClass(String str) {
        str.getClass();
        char c = 65535;
        switch (str.hashCode()) {
            case 98:
                if (str.equals("b")) {
                    c = 0;
                    break;
                }
                break;
            case 99:
                if (str.equals("c")) {
                    c = 1;
                    break;
                }
                break;
            case 100:
                if (str.equals("d")) {
                    c = 2;
                    break;
                }
                break;
            case 102:
                if (str.equals("f")) {
                    c = 3;
                    break;
                }
                break;
            case 105:
                if (str.equals("i")) {
                    c = 4;
                    break;
                }
                break;
            case 108:
                if (str.equals("l")) {
                    c = 5;
                    break;
                }
                break;
            case 115:
                if (str.equals("s")) {
                    c = 6;
                    break;
                }
                break;
            case 118:
                if (str.equals("v")) {
                    c = 7;
                    break;
                }
                break;
            case 3159:
                if (str.equals("by")) {
                    c = 8;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return Boolean.TYPE;
            case 1:
                return Character.TYPE;
            case 2:
                return Double.TYPE;
            case 3:
                return Float.TYPE;
            case 4:
                return Integer.TYPE;
            case 5:
                return Long.TYPE;
            case 6:
                return Short.TYPE;
            case 7:
                return Void.TYPE;
            case 8:
                return Byte.TYPE;
            default:
                return null;
        }
    }

    public void dismissPopUp() {
        ExecutorManager.runOnMainThread(new s(this, 2));
    }

    public float dpToPx(float f) {
        if (f > 0.0f) {
            return (float) Math.round(f * this.dynamicUI.getAppContext().getResources().getDisplayMetrics().density);
        }
        return 0.0f;
    }

    public Pair<String, ObjectAnimator> findAnimationById(String str) {
        String i = C0709Uj.i("M_anim_", str);
        if (this.state.containsKey(i)) {
            return (Pair) this.state.get(i);
        }
        return null;
    }

    public Method findMethodWithCmd(Cmd cmd) {
        Method method;
        if (this.functionCache.containsKey(cmd)) {
            return this.functionCache.get(cmd);
        }
        try {
            method = tryExactMatch(cmd.clazz, cmd.functionName, cmd.args);
        } catch (NoSuchMethodException unused) {
            if (cmd.args == null || cmd.args.length != 1) {
                method = tryMultiAgrumentDeepMatch(cmd.clazz, cmd.functionName, cmd.args);
            } else {
                method = trySingleArgumentDeepMatch(cmd.clazz, cmd.functionName, cmd.args[0]);
            }
        }
        this.functionCache.put(cmd, method);
        return method;
    }

    public Class<?> getClassName(String str) {
        str.getClass();
        char c = 65535;
        switch (str.hashCode()) {
            case -1409106502:
                if (str.equals("in.juspay.mystique.BottomSheetLayout")) {
                    c = 0;
                    break;
                }
                break;
            case -833865840:
                if (str.equals("in.juspay.mystique.SwypeLayout")) {
                    c = 1;
                    break;
                }
                break;
            case -631823565:
                if (str.equals("in.juspay.mystique.SwypeScroll")) {
                    c = 2;
                    break;
                }
                break;
            case -407376626:
                if (str.equals("in.juspay.mystique.AccordionLayout")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return BottomSheetLayout.class;
            case 1:
                return SwypeLayout.class;
            case 2:
                return SwypeScroll.class;
            case 3:
                return AccordionLayout.class;
            default:
                return Class.forName(str);
        }
    }

    public DynamicUI getDUI() {
        return this.dynamicUI;
    }

    public String getErrorDetails() {
        return this.currViewId + " - " + this.currView + "-" + this.fileOrigin + " - " + this.lastCommand;
    }

    public HashMap<String, Object> getState() {
        return this.state;
    }

    public <T> T getStateValFromKey(String str) {
        return this.state.get(str);
    }

    public boolean getUseAppContext() {
        return this.useAppContext;
    }

    public <Any> Any getValueNew(String str, String str2) {
        str.getClass();
        char c = 65535;
        switch (str.hashCode()) {
            case -891988091:
                if (str.equals("strget")) {
                    c = 0;
                    break;
                }
                break;
            case 98:
                if (str.equals("b")) {
                    c = 1;
                    break;
                }
                break;
            case 102:
                if (str.equals("f")) {
                    c = 2;
                    break;
                }
                break;
            case 105:
                if (str.equals("i")) {
                    c = 3;
                    break;
                }
                break;
            case 108:
                if (str.equals("l")) {
                    c = 4;
                    break;
                }
                break;
            case 3212:
                if (str.equals("dp")) {
                    c = 5;
                    break;
                }
                break;
            case 3677:
                if (str.equals("sp")) {
                    c = 6;
                    break;
                }
                break;
            case 98855:
                if (str.equals("ctx")) {
                    c = 7;
                    break;
                }
                break;
            case 99674:
                if (str.equals("dpf")) {
                    c = 8;
                    break;
                }
                break;
            case 102230:
                if (str.equals("get")) {
                    c = 9;
                    break;
                }
                break;
            case 3237035:
                if (str.equals("infl")) {
                    c = 10;
                    break;
                }
                break;
            case 3392903:
                if (str.equals("null")) {
                    c = 11;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return this.state.get(str2) + "";
            case 1:
                return Boolean.valueOf(Boolean.parseBoolean(str2));
            case 2:
                return Float.valueOf(Float.parseFloat(str2));
            case 3:
                return Integer.valueOf(Integer.parseInt(str2));
            case 4:
                return Long.valueOf(Long.parseLong(str2));
            case 5:
                return Integer.valueOf(dpToPx(Integer.parseInt(str2)));
            case 6:
                return Float.valueOf(Float.parseFloat(str2) * this.dynamicUI.getAppContext().getResources().getDisplayMetrics().scaledDensity);
            case 7:
                if (this.dynamicUI.getActivity() == null || this.useAppContext) {
                    return this.dynamicUI.getAppContext();
                }
                return this.dynamicUI.getActivity();
            case 8:
                return Float.valueOf(dpToPx(Float.parseFloat(str2)));
            case 9:
                return this.state.get(str2);
            case 10:
                return this;
            case 11:
                return null;
            default:
                return str2;
        }
    }

    public void handleAnimation(Object obj, JSONArray jSONArray) {
        String str;
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            JSONArray jSONArray2 = new JSONArray(jSONObject.getString("props"));
            String str2 = "";
            if (jSONObject.has(FacebookMediationAdapter.KEY_ID)) {
                str = jSONObject.getString(FacebookMediationAdapter.KEY_ID);
            } else {
                str = str2;
            }
            if (jSONObject.has("onEnd")) {
                str2 = jSONObject.getString("onEnd");
            }
            PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[jSONArray2.length()];
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                JSONObject jSONObject2 = jSONArray2.getJSONObject(i2);
                propertyValuesHolderArr[i2] = PropertyValuesHolder.ofFloat(jSONObject2.getString("prop"), new float[]{(float) jSONObject2.getDouble(Constants.MessagePayloadKeys.FROM), (float) jSONObject2.getDouble("to")});
            }
            final ObjectAnimator animator = getAnimator(obj, propertyValuesHolderArr, jSONObject);
            Pair pair = new Pair(Integer.valueOf(((View) obj).getId()), animator);
            this.state.put("M_anim_" + str, pair);
            if (jSONObject.has("onEnd")) {
                final String i3 = C0709Uj.i("M_anim_", str2);
                animator.addListener(new Animator.AnimatorListener() {
                    public void onAnimationEnd(Animator animator) {
                        ObjectAnimator objectAnimator;
                        if (InflateView.this.state.containsKey(i3) && (objectAnimator = (ObjectAnimator) ((Pair) InflateView.this.state.get(i3)).second) != null && objectAnimator != animator) {
                            objectAnimator.start();
                        }
                    }

                    public void onAnimationCancel(Animator animator) {
                    }

                    public void onAnimationRepeat(Animator animator) {
                    }

                    public void onAnimationStart(Animator animator) {
                    }
                });
            }
        }
    }

    public boolean matchTypes(Class<?>[] clsArr, Class<?>[] clsArr2) {
        Class<?> cls;
        for (int i = 0; i < clsArr.length; i++) {
            if (!(clsArr2[i] == null || (cls = clsArr[i]) == null || ((cls.equals(Object.class) && !clsArr2[i].isPrimitive()) || clsArr[i].equals(clsArr2[i])))) {
                if (clsArr[i].isPrimitive() && !clsArr2[i].isArray()) {
                    try {
                        Class cls2 = (Class) clsArr2[i].getField("TYPE").get((Object) null);
                        if (cls2 != null && !cls2.equals(clsArr[i])) {
                            return false;
                        }
                    } catch (NoSuchFieldException unused) {
                        return false;
                    } catch (Exception unused2) {
                        return true;
                    }
                } else if (clsArr[i].equals(ClassLoader.class)) {
                    if (clsArr2[i].getName().equals("dalvik.system.PathClassLoader")) {
                        return true;
                    }
                } else if (!clsArr[i].equals(clsArr2[i]) && !clsArr[i].isAssignableFrom(clsArr2[i])) {
                    return false;
                }
            }
        }
        return true;
    }

    public Object parseAndRunPipe(Object obj, String str, boolean z) {
        Object obj2 = null;
        for (String str2 : COMMAND_SPLIT.split(str)) {
            if (!str2.equals("")) {
                if (indexOf(str2, SETTER_EQUALS, 0) != -1) {
                    String[] substr = substr(str2, SETTER_EQUALS);
                    String str3 = substr(substr[0], ARG_TYPE_SPLIT)[1];
                    Object runCommand = runCommand(obj, obj2, substr[1], z);
                    this.state.put(str3, runCommand);
                    this.dynamicUI.getLogger().d(LOG_TAG, "setting " + str3 + " to " + runCommand);
                } else {
                    obj2 = runCommand(obj, obj2, str2, z);
                }
            }
        }
        return obj;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v10, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v59, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v64, resolved type: boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x05ff A[Catch:{ Exception -> 0x061c }] */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x060d A[Catch:{ Exception -> 0x061c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void parseKeys(java.lang.String r32, org.json.JSONObject r33, java.lang.Object r34, boolean r35) {
        /*
            r31 = this;
            r7 = r31
            r8 = r32
            r9 = r33
            r10 = r34
            java.lang.String r11 = "popupMenu"
            java.lang.String r12 = "onSwipe"
            java.lang.String r13 = "onDateChange"
            java.lang.String r14 = "onTouch"
            java.lang.String r15 = "onFocus"
            java.lang.String r6 = "onItemClick"
            java.lang.String r5 = "onRefresh"
            java.lang.String r4 = "onScrollStateChange"
            java.lang.String r0 = "onScroll"
            java.lang.String r3 = "onClick"
            java.lang.String r1 = "source"
            java.lang.String r2 = "onLongPress"
            r16 = r3
            java.lang.String r3 = "onKeyUp"
            r17 = r4
            java.lang.String r4 = "pattern"
            r18 = r5
            java.lang.String r5 = "listItem"
            r19 = r11
            java.lang.String r11 = "Exception occured  :"
            r20 = r6
            java.lang.String r6 = "android.resource://"
            r21 = r12
            java.lang.String r12 = "Exception occured in onScrollStateChange :"
            r22 = r13
            java.lang.String r13 = "Exception occured in onScroll:"
            r23 = r14
            java.lang.String r14 = "inlineAnimation"
            boolean r14 = r14.equals(r8)     // Catch:{ Exception -> 0x061c }
            if (r14 == 0) goto L_0x0067
            java.lang.Thread r14 = java.lang.Thread.currentThread()     // Catch:{ Exception -> 0x061c }
            java.lang.String r14 = r14.getName()     // Catch:{ Exception -> 0x061c }
            r24 = r15
            java.lang.String r15 = "PreRenderThread"
            boolean r14 = r14.equals(r15)     // Catch:{ Exception -> 0x061c }
            if (r14 != 0) goto L_0x0069
            in.juspay.hypersdk.mystique.AnimationHolder r0 = r7.animationHolder     // Catch:{ Exception -> 0x061c }
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch:{ Exception -> 0x061c }
            java.lang.String r2 = r9.getString(r8)     // Catch:{ Exception -> 0x061c }
            r1.<init>(r2)     // Catch:{ Exception -> 0x061c }
            r0.applyAnimation(r10, r1, r9)     // Catch:{ Exception -> 0x061c }
            return
        L_0x0067:
            r24 = r15
        L_0x0069:
            java.lang.String r14 = "lottieAnimation"
            boolean r14 = r14.equals(r8)     // Catch:{ Exception -> 0x061c }
            if (r14 == 0) goto L_0x0082
            in.juspay.hyperlottie.LottieAnimation r0 = r7.lottieAnimation     // Catch:{ Exception -> 0x061c }
            if (r0 == 0) goto L_0x0081
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch:{ Exception -> 0x061c }
            java.lang.String r2 = r9.getString(r8)     // Catch:{ Exception -> 0x061c }
            r1.<init>(r2)     // Catch:{ Exception -> 0x061c }
            r0.applyAnimation(r10, r1)     // Catch:{ Exception -> 0x061c }
        L_0x0081:
            return
        L_0x0082:
            boolean r14 = r5.equals(r8)     // Catch:{ Exception -> 0x061c }
            java.lang.String r15 = "Missing Activity"
            r25 = r11
            java.lang.String r11 = "listData"
            if (r14 == 0) goto L_0x00f1
            boolean r14 = r9.has(r11)     // Catch:{ Exception -> 0x061c }
            if (r14 == 0) goto L_0x00f1
            in.juspay.hypersdk.core.DynamicUI r0 = r7.dynamicUI     // Catch:{ Exception -> 0x061c }
            android.app.Activity r0 = r0.getActivity()     // Catch:{ Exception -> 0x061c }
            if (r0 != 0) goto L_0x00a8
            in.juspay.hypersdk.core.DynamicUI r0 = r7.dynamicUI     // Catch:{ Exception -> 0x061c }
            in.juspay.hypersdk.core.DuiLogger r0 = r0.getLogger()     // Catch:{ Exception -> 0x061c }
            java.lang.String r1 = "listData, it is not  activity, it is applicationContext"
            r0.e(r15, r1)     // Catch:{ Exception -> 0x061c }
            return
        L_0x00a8:
            boolean r0 = r10 instanceof android.widget.ListView     // Catch:{ Exception -> 0x061c }
            if (r0 == 0) goto L_0x00f0
            r0 = r10
            android.widget.ListView r0 = (android.widget.ListView) r0     // Catch:{ Exception -> 0x061c }
            r1 = 0
            r0.setDivider(r1)     // Catch:{ Exception -> 0x061c }
            in.juspay.hypersdk.core.DynamicUI r1 = r7.dynamicUI     // Catch:{ Exception -> 0x061c }
            in.juspay.hypersdk.core.AndroidInterface r1 = r1.getAndroidInterface()     // Catch:{ Exception -> 0x061c }
            in.juspay.hypersdk.core.Renderer r14 = r1.getRenderer()     // Catch:{ Exception -> 0x061c }
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x061c }
            java.lang.String r2 = r9.getString(r5)     // Catch:{ Exception -> 0x061c }
            r1.<init>(r2)     // Catch:{ Exception -> 0x061c }
            org.json.JSONArray r2 = new org.json.JSONArray     // Catch:{ Exception -> 0x061c }
            java.lang.String r3 = r9.getString(r11)     // Catch:{ Exception -> 0x061c }
            r2.<init>(r3)     // Catch:{ Exception -> 0x061c }
            java.lang.String r3 = "itemView"
            org.json.JSONObject r15 = r1.getJSONObject(r3)     // Catch:{ Exception -> 0x061c }
            java.lang.String r3 = "holderViews"
            org.json.JSONArray r16 = r1.getJSONArray(r3)     // Catch:{ Exception -> 0x061c }
            in.juspay.hypersdk.mystique.ListAdapter r1 = new in.juspay.hypersdk.mystique.ListAdapter     // Catch:{ Exception -> 0x061c }
            in.juspay.hypersdk.core.DynamicUI r3 = r7.dynamicUI     // Catch:{ Exception -> 0x061c }
            android.app.Activity r13 = r3.getActivity()     // Catch:{ Exception -> 0x061c }
            in.juspay.hypersdk.core.DuiCallback r3 = r7.duiCallback     // Catch:{ Exception -> 0x061c }
            r12 = r1
            r17 = r2
            r18 = r3
            r12.<init>(r13, r14, r15, r16, r17, r18)     // Catch:{ Exception -> 0x061c }
            r0.setAdapter(r1)     // Catch:{ Exception -> 0x061c }
        L_0x00f0:
            return
        L_0x00f1:
            boolean r5 = r11.equals(r8)     // Catch:{ Exception -> 0x061c }
            if (r5 == 0) goto L_0x011c
            boolean r0 = r10 instanceof android.widget.ListView     // Catch:{ Exception -> 0x061c }
            if (r0 == 0) goto L_0x011b
            r0 = r10
            android.widget.ListView r0 = (android.widget.ListView) r0     // Catch:{ Exception -> 0x061c }
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch:{ Exception -> 0x061c }
            java.lang.String r2 = r9.getString(r11)     // Catch:{ Exception -> 0x061c }
            r1.<init>(r2)     // Catch:{ Exception -> 0x061c }
            android.widget.ListAdapter r2 = r0.getAdapter()     // Catch:{ Exception -> 0x061c }
            boolean r2 = r2 instanceof in.juspay.hypersdk.mystique.ListAdapter     // Catch:{ Exception -> 0x061c }
            if (r2 == 0) goto L_0x011b
            android.widget.ListAdapter r0 = r0.getAdapter()     // Catch:{ Exception -> 0x061c }
            in.juspay.hypersdk.mystique.ListAdapter r0 = (in.juspay.hypersdk.mystique.ListAdapter) r0     // Catch:{ Exception -> 0x061c }
            r0.updateRowData(r1)     // Catch:{ Exception -> 0x061c }
            r0.notifyDataSetChanged()     // Catch:{ Exception -> 0x061c }
        L_0x011b:
            return
        L_0x011c:
            boolean r5 = r8.equals(r4)     // Catch:{ Exception -> 0x061c }
            java.lang.String r14 = ","
            r11 = 1
            if (r5 == 0) goto L_0x0172
            java.lang.Class r5 = r34.getClass()     // Catch:{ Exception -> 0x061c }
            r27 = r15
            java.lang.String r15 = "setFilters"
            r28 = r12
            java.lang.Class[] r12 = new java.lang.Class[r11]     // Catch:{ Exception -> 0x061c }
            java.lang.Class<android.text.InputFilter[]> r29 = android.text.InputFilter[].class
            r26 = 0
            r12[r26] = r29     // Catch:{ Exception -> 0x061c }
            java.lang.reflect.Method r5 = r5.getMethod(r15, r12)     // Catch:{ Exception -> 0x061c }
            java.lang.String r4 = r9.getString(r4)     // Catch:{ Exception -> 0x061c }
            java.lang.String[] r4 = r4.split(r14)     // Catch:{ Exception -> 0x061c }
            r12 = 0
            r15 = r4[r12]     // Catch:{ Exception -> 0x061c }
            int r12 = r4.length     // Catch:{ Exception -> 0x061c }
            if (r12 != r11) goto L_0x014c
            r4 = 10000(0x2710, float:1.4013E-41)
            goto L_0x0156
        L_0x014c:
            r4 = r4[r11]     // Catch:{ Exception -> 0x061c }
            java.lang.String r4 = r4.trim()     // Catch:{ Exception -> 0x061c }
            int r4 = java.lang.Integer.parseInt(r4)     // Catch:{ Exception -> 0x061c }
        L_0x0156:
            Hf r12 = new Hf     // Catch:{ Exception -> 0x061c }
            r12.<init>(r15)     // Catch:{ Exception -> 0x061c }
            r15 = 2
            android.text.InputFilter[] r11 = new android.text.InputFilter[r15]     // Catch:{ Exception -> 0x061c }
            r15 = 0
            r11[r15] = r12     // Catch:{ Exception -> 0x061c }
            android.text.InputFilter$LengthFilter r12 = new android.text.InputFilter$LengthFilter     // Catch:{ Exception -> 0x061c }
            r12.<init>(r4)     // Catch:{ Exception -> 0x061c }
            r4 = 1
            r11[r4] = r12     // Catch:{ Exception -> 0x061c }
            java.lang.Object[] r12 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x061c }
            r4 = 0
            r12[r4] = r11     // Catch:{ Exception -> 0x061c }
            r5.invoke(r10, r12)     // Catch:{ Exception -> 0x061c }
            goto L_0x0176
        L_0x0172:
            r28 = r12
            r27 = r15
        L_0x0176:
            boolean r4 = r8.equals(r3)     // Catch:{ Exception -> 0x061c }
            if (r4 == 0) goto L_0x019f
            java.lang.String r3 = r9.getString(r3)     // Catch:{ Exception -> 0x061c }
            java.lang.Class r4 = r34.getClass()     // Catch:{ Exception -> 0x061c }
            java.lang.String r5 = "setOnKeyListener"
            r11 = 1
            java.lang.Class[] r12 = new java.lang.Class[r11]     // Catch:{ Exception -> 0x061c }
            java.lang.Class<android.view.View$OnKeyListener> r15 = android.view.View.OnKeyListener.class
            r26 = 0
            r12[r26] = r15     // Catch:{ Exception -> 0x061c }
            java.lang.reflect.Method r4 = r4.getMethod(r5, r12)     // Catch:{ Exception -> 0x061c }
            java.lang.Object[] r5 = new java.lang.Object[r11]     // Catch:{ Exception -> 0x061c }
            If r11 = new If     // Catch:{ Exception -> 0x061c }
            r11.<init>(r7, r3)     // Catch:{ Exception -> 0x061c }
            r5[r26] = r11     // Catch:{ Exception -> 0x061c }
            r4.invoke(r10, r5)     // Catch:{ Exception -> 0x061c }
        L_0x019f:
            boolean r3 = r8.equals(r2)     // Catch:{ Exception -> 0x061c }
            if (r3 == 0) goto L_0x01c7
            java.lang.String r2 = r9.getString(r2)     // Catch:{ Exception -> 0x061c }
            java.lang.Class r3 = r34.getClass()     // Catch:{ Exception -> 0x061c }
            java.lang.String r4 = "setOnLongClickListener"
            r5 = 1
            java.lang.Class[] r11 = new java.lang.Class[r5]     // Catch:{ Exception -> 0x061c }
            java.lang.Class<android.view.View$OnLongClickListener> r12 = android.view.View.OnLongClickListener.class
            r15 = 0
            r11[r15] = r12     // Catch:{ Exception -> 0x061c }
            java.lang.reflect.Method r3 = r3.getMethod(r4, r11)     // Catch:{ Exception -> 0x061c }
            java.lang.Object[] r4 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x061c }
            Jf r5 = new Jf     // Catch:{ Exception -> 0x061c }
            r5.<init>(r7, r2)     // Catch:{ Exception -> 0x061c }
            r4[r15] = r5     // Catch:{ Exception -> 0x061c }
            r3.invoke(r10, r4)     // Catch:{ Exception -> 0x061c }
        L_0x01c7:
            boolean r2 = r8.equals(r1)     // Catch:{ Exception -> 0x061c }
            if (r2 == 0) goto L_0x0222
            boolean r2 = r10 instanceof android.view.TextureView     // Catch:{ Exception -> 0x061c }
            if (r2 == 0) goto L_0x0222
            r11 = r10
            android.view.TextureView r11 = (android.view.TextureView) r11     // Catch:{ Exception -> 0x061c }
            in.juspay.hypersdk.core.DynamicUI r2 = r7.dynamicUI     // Catch:{ Exception -> 0x061c }
            android.content.Context r4 = r2.getAppContext()     // Catch:{ Exception -> 0x061c }
            java.lang.String r2 = r4.getPackageName()     // Catch:{ Exception -> 0x061c }
            java.lang.String r1 = r9.getString(r1)     // Catch:{ Exception -> 0x061c }
            android.content.res.Resources r3 = r4.getResources()     // Catch:{ Exception -> 0x061c }
            java.lang.String r5 = "raw"
            int r1 = r3.getIdentifier(r1, r5, r2)     // Catch:{ Exception -> 0x061c }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x061c }
            r3.<init>(r6)     // Catch:{ Exception -> 0x061c }
            r3.append(r2)     // Catch:{ Exception -> 0x061c }
            java.lang.String r2 = "/raw/"
            r3.append(r2)     // Catch:{ Exception -> 0x061c }
            r3.append(r1)     // Catch:{ Exception -> 0x061c }
            java.lang.String r1 = r3.toString()     // Catch:{ Exception -> 0x061c }
            android.net.Uri r5 = android.net.Uri.parse(r1)     // Catch:{ Exception -> 0x061c }
            android.media.MediaPlayer r3 = new android.media.MediaPlayer     // Catch:{ Exception -> 0x061c }
            r3.<init>()     // Catch:{ Exception -> 0x061c }
            in.juspay.hypersdk.core.InflateView$2 r12 = new in.juspay.hypersdk.core.InflateView$2     // Catch:{ Exception -> 0x061c }
            r1 = r12
            r2 = r31
            r15 = r16
            r6 = r17
            r16 = r14
            r14 = r18
            r30 = r20
            r14 = r6
            r6 = r33
            r1.<init>(r3, r4, r5, r6)     // Catch:{ Exception -> 0x061c }
            r11.setSurfaceTextureListener(r12)     // Catch:{ Exception -> 0x061c }
            goto L_0x022a
        L_0x0222:
            r15 = r16
            r30 = r20
            r16 = r14
            r14 = r17
        L_0x022a:
            boolean r1 = r8.equals(r15)     // Catch:{ Exception -> 0x061c }
            if (r1 == 0) goto L_0x0252
            java.lang.String r1 = r9.getString(r15)     // Catch:{ Exception -> 0x061c }
            java.lang.Class r2 = r34.getClass()     // Catch:{ Exception -> 0x061c }
            java.lang.String r3 = "setOnClickListener"
            r4 = 1
            java.lang.Class[] r5 = new java.lang.Class[r4]     // Catch:{ Exception -> 0x061c }
            java.lang.Class<android.view.View$OnClickListener> r6 = android.view.View.OnClickListener.class
            r11 = 0
            r5[r11] = r6     // Catch:{ Exception -> 0x061c }
            java.lang.reflect.Method r2 = r2.getMethod(r3, r5)     // Catch:{ Exception -> 0x061c }
            java.lang.Object[] r3 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x061c }
            Kf r4 = new Kf     // Catch:{ Exception -> 0x061c }
            r4.<init>(r7, r1)     // Catch:{ Exception -> 0x061c }
            r3[r11] = r4     // Catch:{ Exception -> 0x061c }
            r2.invoke(r10, r3)     // Catch:{ Exception -> 0x061c }
        L_0x0252:
            boolean r1 = r8.equals(r0)     // Catch:{ Exception -> 0x061c }
            if (r1 == 0) goto L_0x029e
            java.lang.String r0 = r9.getString(r0)     // Catch:{ Exception -> 0x028c }
            boolean r1 = r10 instanceof android.widget.ListView     // Catch:{ Exception -> 0x028c }
            if (r1 == 0) goto L_0x029e
            r1 = r10
            android.widget.ListView r1 = (android.widget.ListView) r1     // Catch:{ Exception -> 0x028c }
            java.lang.Object r1 = r1.getTag()     // Catch:{ Exception -> 0x028c }
            boolean r1 = r1 instanceof in.juspay.hypersdk.mystique.OnScroll     // Catch:{ Exception -> 0x028c }
            if (r1 == 0) goto L_0x0275
            r1 = r10
            android.widget.ListView r1 = (android.widget.ListView) r1     // Catch:{ Exception -> 0x028c }
            java.lang.Object r1 = r1.getTag()     // Catch:{ Exception -> 0x028c }
            in.juspay.hypersdk.mystique.OnScroll r1 = (in.juspay.hypersdk.mystique.OnScroll) r1     // Catch:{ Exception -> 0x028c }
            goto L_0x027c
        L_0x0275:
            in.juspay.hypersdk.mystique.OnScroll r1 = new in.juspay.hypersdk.mystique.OnScroll     // Catch:{ Exception -> 0x028c }
            in.juspay.hypersdk.core.DuiCallback r2 = r7.duiCallback     // Catch:{ Exception -> 0x028c }
            r1.<init>(r2)     // Catch:{ Exception -> 0x028c }
        L_0x027c:
            r1.setScrollCallback(r0)     // Catch:{ Exception -> 0x028c }
            r0 = r10
            android.widget.ListView r0 = (android.widget.ListView) r0     // Catch:{ Exception -> 0x028c }
            r0.setOnScrollListener(r1)     // Catch:{ Exception -> 0x028c }
            r0 = r10
            android.widget.ListView r0 = (android.widget.ListView) r0     // Catch:{ Exception -> 0x028c }
            r0.setTag(r1)     // Catch:{ Exception -> 0x028c }
            goto L_0x029e
        L_0x028c:
            r0 = move-exception
            java.io.PrintStream r1 = java.lang.System.out     // Catch:{ Exception -> 0x061c }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x061c }
            r2.<init>(r13)     // Catch:{ Exception -> 0x061c }
            r2.append(r0)     // Catch:{ Exception -> 0x061c }
            java.lang.String r0 = r2.toString()     // Catch:{ Exception -> 0x061c }
            r1.println(r0)     // Catch:{ Exception -> 0x061c }
        L_0x029e:
            boolean r0 = r8.equals(r14)     // Catch:{ Exception -> 0x061c }
            if (r0 == 0) goto L_0x02ec
            java.lang.String r0 = r9.getString(r14)     // Catch:{ Exception -> 0x02d8 }
            boolean r1 = r10 instanceof android.widget.ListView     // Catch:{ Exception -> 0x02d8 }
            if (r1 == 0) goto L_0x02ec
            r1 = r10
            android.widget.ListView r1 = (android.widget.ListView) r1     // Catch:{ Exception -> 0x02d8 }
            java.lang.Object r1 = r1.getTag()     // Catch:{ Exception -> 0x02d8 }
            boolean r1 = r1 instanceof in.juspay.hypersdk.mystique.OnScroll     // Catch:{ Exception -> 0x02d8 }
            if (r1 == 0) goto L_0x02c1
            r1 = r10
            android.widget.ListView r1 = (android.widget.ListView) r1     // Catch:{ Exception -> 0x02d8 }
            java.lang.Object r1 = r1.getTag()     // Catch:{ Exception -> 0x02d8 }
            in.juspay.hypersdk.mystique.OnScroll r1 = (in.juspay.hypersdk.mystique.OnScroll) r1     // Catch:{ Exception -> 0x02d8 }
            goto L_0x02c8
        L_0x02c1:
            in.juspay.hypersdk.mystique.OnScroll r1 = new in.juspay.hypersdk.mystique.OnScroll     // Catch:{ Exception -> 0x02d8 }
            in.juspay.hypersdk.core.DuiCallback r2 = r7.duiCallback     // Catch:{ Exception -> 0x02d8 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x02d8 }
        L_0x02c8:
            r1.setScrollChangeCallback(r0)     // Catch:{ Exception -> 0x02d8 }
            r0 = r10
            android.widget.ListView r0 = (android.widget.ListView) r0     // Catch:{ Exception -> 0x02d8 }
            r0.setOnScrollListener(r1)     // Catch:{ Exception -> 0x02d8 }
            r0 = r10
            android.widget.ListView r0 = (android.widget.ListView) r0     // Catch:{ Exception -> 0x02d8 }
            r0.setTag(r1)     // Catch:{ Exception -> 0x02d8 }
            goto L_0x02ec
        L_0x02d8:
            r0 = move-exception
            java.io.PrintStream r1 = java.lang.System.out     // Catch:{ Exception -> 0x061c }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x061c }
            r3 = r28
            r2.<init>(r3)     // Catch:{ Exception -> 0x061c }
            r2.append(r0)     // Catch:{ Exception -> 0x061c }
            java.lang.String r0 = r2.toString()     // Catch:{ Exception -> 0x061c }
            r1.println(r0)     // Catch:{ Exception -> 0x061c }
        L_0x02ec:
            r1 = r18
            boolean r0 = r8.equals(r1)     // Catch:{ Exception -> 0x061c }
            if (r0 == 0) goto L_0x032b
            java.lang.String r0 = r9.getString(r1)     // Catch:{ Exception -> 0x0317 }
            java.lang.Class r1 = r34.getClass()     // Catch:{ Exception -> 0x0317 }
            java.lang.String r2 = "setOnRefreshListener"
            r3 = 1
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x0317 }
            java.lang.Class<androidx.swiperefreshlayout.widget.SwipeRefreshLayout$f> r5 = androidx.swiperefreshlayout.widget.SwipeRefreshLayout.f.class
            r6 = 0
            r4[r6] = r5     // Catch:{ Exception -> 0x0317 }
            java.lang.reflect.Method r1 = r1.getMethod(r2, r4)     // Catch:{ Exception -> 0x0317 }
            java.lang.Object[] r2 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x0317 }
            zB r3 = new zB     // Catch:{ Exception -> 0x0317 }
            r3.<init>(r7, r0)     // Catch:{ Exception -> 0x0317 }
            r2[r6] = r3     // Catch:{ Exception -> 0x0317 }
            r1.invoke(r10, r2)     // Catch:{ Exception -> 0x0317 }
            goto L_0x032b
        L_0x0317:
            r0 = move-exception
            java.io.PrintStream r1 = java.lang.System.out     // Catch:{ Exception -> 0x061c }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x061c }
            r3 = r25
            r2.<init>(r3)     // Catch:{ Exception -> 0x061c }
            r2.append(r0)     // Catch:{ Exception -> 0x061c }
            java.lang.String r0 = r2.toString()     // Catch:{ Exception -> 0x061c }
            r1.println(r0)     // Catch:{ Exception -> 0x061c }
        L_0x032b:
            r1 = r30
            boolean r0 = r8.equals(r1)     // Catch:{ Exception -> 0x061c }
            if (r0 == 0) goto L_0x0347
            boolean r0 = r10 instanceof android.widget.ListView     // Catch:{ Exception -> 0x061c }
            if (r0 != 0) goto L_0x0338
            return
        L_0x0338:
            r0 = r10
            android.widget.ListView r0 = (android.widget.ListView) r0     // Catch:{ Exception -> 0x061c }
            java.lang.String r1 = r9.getString(r1)     // Catch:{ Exception -> 0x061c }
            Lf r2 = new Lf     // Catch:{ Exception -> 0x061c }
            r2.<init>(r7, r1)     // Catch:{ Exception -> 0x061c }
            r0.setOnItemClickListener(r2)     // Catch:{ Exception -> 0x061c }
        L_0x0347:
            java.lang.String r0 = "onChange"
            boolean r0 = r8.equals(r0)     // Catch:{ Exception -> 0x061c }
            if (r0 == 0) goto L_0x035e
            java.lang.String r0 = "separator"
            boolean r0 = r9.has(r0)     // Catch:{ Exception -> 0x061c }
            if (r0 == 0) goto L_0x035b
            r7.separatorTextChange(r9, r10)     // Catch:{ Exception -> 0x061c }
            goto L_0x035e
        L_0x035b:
            r7.normalTextChange(r9, r10)     // Catch:{ Exception -> 0x061c }
        L_0x035e:
            r1 = r24
            boolean r0 = r8.equals(r1)     // Catch:{ Exception -> 0x061c }
            if (r0 == 0) goto L_0x038a
            java.lang.Class r0 = r34.getClass()     // Catch:{ Exception -> 0x061c }
            java.lang.String r2 = "setOnFocusChangeListener"
            r3 = 1
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x061c }
            java.lang.Class<android.view.View$OnFocusChangeListener> r3 = android.view.View.OnFocusChangeListener.class
            r5 = 0
            r4[r5] = r3     // Catch:{ Exception -> 0x061c }
            java.lang.reflect.Method r0 = r0.getMethod(r2, r4)     // Catch:{ Exception -> 0x061c }
            java.lang.String r1 = r9.getString(r1)     // Catch:{ Exception -> 0x061c }
            r2 = 1
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x061c }
            Mf r2 = new Mf     // Catch:{ Exception -> 0x061c }
            r2.<init>(r7, r1)     // Catch:{ Exception -> 0x061c }
            r1 = 0
            r3[r1] = r2     // Catch:{ Exception -> 0x061c }
            r0.invoke(r10, r3)     // Catch:{ Exception -> 0x061c }
        L_0x038a:
            r1 = r23
            boolean r0 = r8.equals(r1)     // Catch:{ Exception -> 0x061c }
            java.lang.String r2 = "setOnTouchListener"
            if (r0 == 0) goto L_0x03b4
            java.lang.String r0 = r9.getString(r1)     // Catch:{ Exception -> 0x061c }
            java.lang.Class r1 = r34.getClass()     // Catch:{ Exception -> 0x061c }
            r3 = 1
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x061c }
            java.lang.Class<android.view.View$OnTouchListener> r5 = android.view.View.OnTouchListener.class
            r6 = 0
            r4[r6] = r5     // Catch:{ Exception -> 0x061c }
            java.lang.reflect.Method r1 = r1.getMethod(r2, r4)     // Catch:{ Exception -> 0x061c }
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x061c }
            in.juspay.hypersdk.core.InflateView$3 r3 = new in.juspay.hypersdk.core.InflateView$3     // Catch:{ Exception -> 0x061c }
            r3.<init>(r0)     // Catch:{ Exception -> 0x061c }
            r4[r6] = r3     // Catch:{ Exception -> 0x061c }
            r1.invoke(r10, r4)     // Catch:{ Exception -> 0x061c }
        L_0x03b4:
            r1 = r22
            boolean r0 = r8.equals(r1)     // Catch:{ Exception -> 0x061c }
            if (r0 == 0) goto L_0x03de
            java.lang.String r0 = r9.getString(r1)     // Catch:{ Exception -> 0x061c }
            java.lang.Class r1 = r34.getClass()     // Catch:{ Exception -> 0x061c }
            java.lang.String r3 = "setOnDateChangeListener"
            r4 = 1
            java.lang.Class[] r5 = new java.lang.Class[r4]     // Catch:{ Exception -> 0x061c }
            java.lang.Class<android.widget.CalendarView$OnDateChangeListener> r6 = android.widget.CalendarView.OnDateChangeListener.class
            r11 = 0
            r5[r11] = r6     // Catch:{ Exception -> 0x061c }
            java.lang.reflect.Method r1 = r1.getMethod(r3, r5)     // Catch:{ Exception -> 0x061c }
            java.lang.Object[] r3 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x061c }
            Nf r4 = new Nf     // Catch:{ Exception -> 0x061c }
            r4.<init>(r7, r0)     // Catch:{ Exception -> 0x061c }
            r3[r11] = r4     // Catch:{ Exception -> 0x061c }
            r1.invoke(r10, r3)     // Catch:{ Exception -> 0x061c }
        L_0x03de:
            r1 = r21
            boolean r0 = r8.equals(r1)     // Catch:{ Exception -> 0x061c }
            if (r0 == 0) goto L_0x0406
            java.lang.String r0 = r9.getString(r1)     // Catch:{ Exception -> 0x061c }
            java.lang.Class r1 = r34.getClass()     // Catch:{ Exception -> 0x061c }
            r3 = 1
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x061c }
            java.lang.Class<android.view.View$OnTouchListener> r5 = android.view.View.OnTouchListener.class
            r6 = 0
            r4[r6] = r5     // Catch:{ Exception -> 0x061c }
            java.lang.reflect.Method r1 = r1.getMethod(r2, r4)     // Catch:{ Exception -> 0x061c }
            java.lang.Object[] r2 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x061c }
            in.juspay.hypersdk.core.InflateView$4 r3 = new in.juspay.hypersdk.core.InflateView$4     // Catch:{ Exception -> 0x061c }
            r3.<init>(r0)     // Catch:{ Exception -> 0x061c }
            r2[r6] = r3     // Catch:{ Exception -> 0x061c }
            r1.invoke(r10, r2)     // Catch:{ Exception -> 0x061c }
        L_0x0406:
            r1 = r19
            boolean r0 = r8.equals(r1)     // Catch:{ Exception -> 0x061c }
            if (r0 == 0) goto L_0x0495
            in.juspay.hypersdk.core.DynamicUI r0 = r7.dynamicUI     // Catch:{ Exception -> 0x061c }
            android.app.Activity r0 = r0.getActivity()     // Catch:{ Exception -> 0x061c }
            if (r0 != 0) goto L_0x0424
            in.juspay.hypersdk.core.DynamicUI r0 = r7.dynamicUI     // Catch:{ Exception -> 0x061c }
            in.juspay.hypersdk.core.DuiLogger r0 = r0.getLogger()     // Catch:{ Exception -> 0x061c }
            java.lang.String r1 = "popupMenu, it is not  activity, it is applicationContext"
            r2 = r27
            r0.e(r2, r1)     // Catch:{ Exception -> 0x061c }
            return
        L_0x0424:
            java.lang.String r0 = r9.getString(r1)     // Catch:{ Exception -> 0x061c }
            java.util.regex.Pattern r1 = FUNCTION_ARG_SPLIT_ESCAPE     // Catch:{ Exception -> 0x061c }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x061c }
            java.lang.String[] r0 = r0.split(r1)     // Catch:{ Exception -> 0x061c }
            java.lang.String r1 = "onMenuItemClick"
            java.lang.String r1 = r9.getString(r1)     // Catch:{ Exception -> 0x061c }
            android.widget.PopupMenu r2 = new android.widget.PopupMenu     // Catch:{ Exception -> 0x061c }
            in.juspay.hypersdk.core.DynamicUI r3 = r7.dynamicUI     // Catch:{ Exception -> 0x061c }
            android.app.Activity r3 = r3.getActivity()     // Catch:{ Exception -> 0x061c }
            r4 = r10
            android.view.View r4 = (android.view.View) r4     // Catch:{ Exception -> 0x061c }
            r2.<init>(r3, r4)     // Catch:{ Exception -> 0x061c }
            r7.popUpMenu = r2     // Catch:{ Exception -> 0x061c }
            r2 = 0
        L_0x0449:
            int r3 = r0.length     // Catch:{ Exception -> 0x061c }
            if (r2 >= r3) goto L_0x047e
            r3 = r0[r2]     // Catch:{ Exception -> 0x061c }
            java.lang.String r4 = "\\"
            boolean r3 = r3.contains(r4)     // Catch:{ Exception -> 0x061c }
            if (r3 == 0) goto L_0x046b
            r3 = r0[r2]     // Catch:{ Exception -> 0x061c }
            r4 = r16
            boolean r3 = r3.contains(r4)     // Catch:{ Exception -> 0x061c }
            if (r3 == 0) goto L_0x046d
            r3 = r0[r2]     // Catch:{ Exception -> 0x061c }
            java.lang.String r5 = "\\\\,"
            java.lang.String r3 = r3.replace(r5, r4)     // Catch:{ Exception -> 0x061c }
            r0[r2] = r3     // Catch:{ Exception -> 0x061c }
            goto L_0x046d
        L_0x046b:
            r4 = r16
        L_0x046d:
            android.widget.PopupMenu r3 = r7.popUpMenu     // Catch:{ Exception -> 0x061c }
            android.view.Menu r3 = r3.getMenu()     // Catch:{ Exception -> 0x061c }
            r5 = r0[r2]     // Catch:{ Exception -> 0x061c }
            r6 = 0
            r3.add(r6, r2, r6, r5)     // Catch:{ Exception -> 0x061c }
            int r2 = r2 + 1
            r16 = r4
            goto L_0x0449
        L_0x047e:
            android.widget.PopupMenu r0 = r7.popUpMenu     // Catch:{ Exception -> 0x061c }
            Of r2 = new Of     // Catch:{ Exception -> 0x061c }
            r2.<init>(r7, r1)     // Catch:{ Exception -> 0x061c }
            r0.setOnMenuItemClickListener(r2)     // Catch:{ Exception -> 0x061c }
            android.widget.PopupMenu r0 = r7.popUpMenu     // Catch:{ Exception -> 0x061c }
            r1 = r10
            android.view.View r1 = (android.view.View) r1     // Catch:{ Exception -> 0x061c }
            Pf r2 = new Pf     // Catch:{ Exception -> 0x061c }
            r2.<init>(r0)     // Catch:{ Exception -> 0x061c }
            r1.setOnClickListener(r2)     // Catch:{ Exception -> 0x061c }
        L_0x0495:
            java.lang.String r0 = "onSeekBarChanged"
            boolean r0 = r8.equals(r0)     // Catch:{ Exception -> 0x061c }
            if (r0 == 0) goto L_0x04c3
            java.lang.String r0 = "onSeekBarChanged"
            java.lang.String r0 = r9.getString(r0)     // Catch:{ Exception -> 0x061c }
            java.lang.Class r1 = r34.getClass()     // Catch:{ Exception -> 0x061c }
            java.lang.String r2 = "setOnSeekBarChangeListener"
            r3 = 1
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x061c }
            java.lang.Class<android.widget.SeekBar$OnSeekBarChangeListener> r5 = android.widget.SeekBar.OnSeekBarChangeListener.class
            r26 = 0
            r4[r26] = r5     // Catch:{ Exception -> 0x061c }
            java.lang.reflect.Method r1 = r1.getMethod(r2, r4)     // Catch:{ Exception -> 0x061c }
            java.lang.Object[] r2 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x061c }
            in.juspay.hypersdk.core.InflateView$5 r3 = new in.juspay.hypersdk.core.InflateView$5     // Catch:{ Exception -> 0x061c }
            r3.<init>(r0)     // Catch:{ Exception -> 0x061c }
            r2[r26] = r3     // Catch:{ Exception -> 0x061c }
            r1.invoke(r10, r2)     // Catch:{ Exception -> 0x061c }
            goto L_0x04c5
        L_0x04c3:
            r26 = 0
        L_0x04c5:
            java.lang.String r0 = "runInUI"
            boolean r0 = r8.equals(r0)     // Catch:{ Exception -> 0x061c }
            if (r0 == 0) goto L_0x04d8
            java.lang.String r0 = r9.getString(r8)     // Catch:{ Exception -> 0x061c }
            r1 = r35
            java.lang.Object r0 = r7.parseAndRunPipe(r10, r0, r1)     // Catch:{ Exception -> 0x061c }
            goto L_0x04d9
        L_0x04d8:
            r0 = r10
        L_0x04d9:
            java.lang.String r1 = "onStateChanged"
            boolean r1 = r1.equals(r8)     // Catch:{ Exception -> 0x061c }
            if (r1 == 0) goto L_0x04f1
            boolean r1 = r0 instanceof in.juspay.hypersdk.mystique.BottomSheetLayout     // Catch:{ Exception -> 0x061c }
            if (r1 == 0) goto L_0x04f1
            r1 = r0
            in.juspay.hypersdk.mystique.BottomSheetLayout r1 = (in.juspay.hypersdk.mystique.BottomSheetLayout) r1     // Catch:{ Exception -> 0x061c }
            in.juspay.hypersdk.core.DuiCallback r2 = r7.duiCallback     // Catch:{ Exception -> 0x061c }
            java.lang.String r3 = r9.getString(r8)     // Catch:{ Exception -> 0x061c }
            r1.setStateChangeCallback(r2, r3)     // Catch:{ Exception -> 0x061c }
        L_0x04f1:
            java.lang.String r1 = "onSlide"
            boolean r1 = r1.equals(r8)     // Catch:{ Exception -> 0x061c }
            if (r1 == 0) goto L_0x0509
            boolean r1 = r0 instanceof in.juspay.hypersdk.mystique.BottomSheetLayout     // Catch:{ Exception -> 0x061c }
            if (r1 == 0) goto L_0x0509
            r1 = r0
            in.juspay.hypersdk.mystique.BottomSheetLayout r1 = (in.juspay.hypersdk.mystique.BottomSheetLayout) r1     // Catch:{ Exception -> 0x061c }
            in.juspay.hypersdk.core.DuiCallback r2 = r7.duiCallback     // Catch:{ Exception -> 0x061c }
            java.lang.String r3 = r9.getString(r8)     // Catch:{ Exception -> 0x061c }
            r1.setSlideCallback(r2, r3)     // Catch:{ Exception -> 0x061c }
        L_0x0509:
            java.lang.String r1 = "animation"
            boolean r1 = r8.equals(r1)     // Catch:{ Exception -> 0x061c }
            if (r1 == 0) goto L_0x051f
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch:{ Exception -> 0x061c }
            java.lang.String r2 = "animation"
            java.lang.String r2 = r9.getString(r2)     // Catch:{ Exception -> 0x061c }
            r1.<init>(r2)     // Catch:{ Exception -> 0x061c }
            r7.handleAnimation(r0, r1)     // Catch:{ Exception -> 0x061c }
        L_0x051f:
            java.lang.String r1 = "afterRender"
            boolean r1 = r8.equals(r1)     // Catch:{ Exception -> 0x061c }
            if (r1 == 0) goto L_0x0556
            java.lang.String r1 = "id"
            java.lang.String r1 = r9.getString(r1)     // Catch:{ Exception -> 0x061c }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x061c }
            r2.<init>()     // Catch:{ Exception -> 0x061c }
            java.lang.String r3 = "javascript:window.callUICallback('"
            r2.append(r3)     // Catch:{ Exception -> 0x061c }
            java.lang.String r3 = "afterRender"
            java.lang.String r3 = r9.getString(r3)     // Catch:{ Exception -> 0x061c }
            r2.append(r3)     // Catch:{ Exception -> 0x061c }
            java.lang.String r3 = "', '"
            r2.append(r3)     // Catch:{ Exception -> 0x061c }
            r2.append(r1)     // Catch:{ Exception -> 0x061c }
            java.lang.String r1 = "');"
            r2.append(r1)     // Catch:{ Exception -> 0x061c }
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x061c }
            in.juspay.hypersdk.core.DynamicUI r2 = r7.dynamicUI     // Catch:{ Exception -> 0x061c }
            r2.addJsToWebView(r1)     // Catch:{ Exception -> 0x061c }
        L_0x0556:
            java.lang.String r1 = "feedback"
            boolean r1 = r8.equals(r1)     // Catch:{ Exception -> 0x061c }
            if (r1 == 0) goto L_0x058d
            java.lang.String r1 = "id"
            java.lang.String r1 = r9.getString(r1)     // Catch:{ Exception -> 0x061c }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x061c }
            r2.<init>()     // Catch:{ Exception -> 0x061c }
            java.lang.String r3 = "javascript:window.callUICallback('"
            r2.append(r3)     // Catch:{ Exception -> 0x061c }
            java.lang.String r3 = "feedback"
            java.lang.String r3 = r9.getString(r3)     // Catch:{ Exception -> 0x061c }
            r2.append(r3)     // Catch:{ Exception -> 0x061c }
            java.lang.String r3 = "', '"
            r2.append(r3)     // Catch:{ Exception -> 0x061c }
            r2.append(r1)     // Catch:{ Exception -> 0x061c }
            java.lang.String r1 = "', 'feedback');"
            r2.append(r1)     // Catch:{ Exception -> 0x061c }
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x061c }
            in.juspay.hypersdk.core.DynamicUI r2 = r7.dynamicUI     // Catch:{ Exception -> 0x061c }
            r2.addJsToWebView(r1)     // Catch:{ Exception -> 0x061c }
        L_0x058d:
            java.lang.String r1 = "secureEdit"
            boolean r1 = r8.equals(r1)     // Catch:{ Exception -> 0x061c }
            if (r1 == 0) goto L_0x063a
            boolean r1 = r0 instanceof android.widget.EditText     // Catch:{ Exception -> 0x061c }
            if (r1 == 0) goto L_0x063a
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch:{ Exception -> 0x061c }
            java.lang.String r2 = "secureEdit"
            java.lang.String r2 = r9.getString(r2)     // Catch:{ Exception -> 0x061c }
            r1.<init>(r2)     // Catch:{ Exception -> 0x061c }
            r2 = r26
            r3 = r2
            r4 = r3
            r5 = r4
            r6 = r5
        L_0x05aa:
            int r8 = r1.length()     // Catch:{ Exception -> 0x061c }
            if (r2 >= r8) goto L_0x0611
            java.lang.Object r8 = r1.get(r2)     // Catch:{ Exception -> 0x061c }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x061c }
            int r9 = r8.hashCode()     // Catch:{ Exception -> 0x061c }
            r10 = 98882(0x18242, float:1.38563E-40)
            if (r9 == r10) goto L_0x05f0
            r10 = 3059573(0x2eaf75, float:4.287375E-39)
            if (r9 == r10) goto L_0x05e5
            r10 = 106438291(0x6581e93, float:4.0647547E-35)
            if (r9 == r10) goto L_0x05db
            r10 = 109400031(0x6854fdf, float:5.01464E-35)
            if (r9 == r10) goto L_0x05d1
            goto L_0x05fa
        L_0x05d1:
            java.lang.String r9 = "share"
            boolean r8 = r8.equals(r9)     // Catch:{ Exception -> 0x061c }
            if (r8 == 0) goto L_0x05fa
            r8 = 3
            goto L_0x05fb
        L_0x05db:
            java.lang.String r9 = "paste"
            boolean r8 = r8.equals(r9)     // Catch:{ Exception -> 0x061c }
            if (r8 == 0) goto L_0x05fa
            r8 = 1
            goto L_0x05fb
        L_0x05e5:
            java.lang.String r9 = "copy"
            boolean r8 = r8.equals(r9)     // Catch:{ Exception -> 0x061c }
            if (r8 == 0) goto L_0x05fa
            r8 = r26
            goto L_0x05fb
        L_0x05f0:
            java.lang.String r9 = "cut"
            boolean r8 = r8.equals(r9)     // Catch:{ Exception -> 0x061c }
            if (r8 == 0) goto L_0x05fa
            r8 = 2
            goto L_0x05fb
        L_0x05fa:
            r8 = -1
        L_0x05fb:
            r9 = 1
            r10 = 2
            if (r8 == 0) goto L_0x060d
            if (r8 == r9) goto L_0x060b
            if (r8 == r10) goto L_0x0609
            r11 = 3
            if (r8 == r11) goto L_0x0607
            goto L_0x060e
        L_0x0607:
            r5 = r9
            goto L_0x060e
        L_0x0609:
            r4 = r9
            goto L_0x060e
        L_0x060b:
            r6 = r9
            goto L_0x060e
        L_0x060d:
            r3 = r9
        L_0x060e:
            int r2 = r2 + 1
            goto L_0x05aa
        L_0x0611:
            android.widget.EditText r0 = (android.widget.EditText) r0     // Catch:{ Exception -> 0x061c }
            in.juspay.hypersdk.mystique.SecureActionCallback r1 = new in.juspay.hypersdk.mystique.SecureActionCallback     // Catch:{ Exception -> 0x061c }
            r1.<init>(r3, r4, r5, r6)     // Catch:{ Exception -> 0x061c }
            r0.setCustomSelectionActionModeCallback(r1)     // Catch:{ Exception -> 0x061c }
            goto L_0x063a
        L_0x061c:
            r0 = move-exception
            in.juspay.hypersdk.core.DynamicUI r1 = r7.dynamicUI
            in.juspay.hypersdk.mystique.Callback r1 = r1.getErrorCallback()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = " excep: fn__parseKeys  - "
            r2.<init>(r3)
            java.lang.String r3 = r31.getErrorDetails()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "WARNING"
            r1.onException(r3, r2, r0)
        L_0x063a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.core.InflateView.parseKeys(java.lang.String, org.json.JSONObject, java.lang.Object, boolean):void");
    }

    public void putInState(String str, Object obj) {
        this.state.put(str, obj);
    }

    public void resetState() {
        this.state = new HashMap<>();
    }

    public void setCurrView(String str) {
        this.currView = str;
    }

    public void setCurrViewId(String str) {
        this.currViewId = str;
    }

    public void setFileOrigin(String str) {
        this.fileOrigin = str;
    }

    public void setUseAppContext(boolean z) {
        this.useAppContext = z;
    }

    public int dpToPx(int i) {
        if (i > 0) {
            return Math.round(((float) i) * this.dynamicUI.getAppContext().getResources().getDisplayMetrics().density);
        }
        return 0;
    }
}
