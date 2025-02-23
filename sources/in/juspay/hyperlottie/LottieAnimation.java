package in.juspay.hyperlottie;

import android.content.Context;
import android.view.View;
import in.juspay.hyper.core.FileProviderInterface;
import in.juspay.hyper.core.JsCallback;
import java.util.WeakHashMap;

public class LottieAnimation {
    private static final String ALPHA = "lottieAlpha";
    private static final String LottieURL = "lottieUrl";
    private static final String MAX_FRAME = "maxFrame";
    private static final String MAX_PROGRESS = "maxProgress";
    private static final String MIN_FRAME = "minFrame";
    private static final String MIN_PROGRESS = "minProgress";
    private static final String REPEAT_COUNT = "repeatCount";
    private static final String REPEAT_MODE = "repeatMode";
    private static final String SAFE_MODE = "safeMode";
    private static final String SPEED = "speed";
    private static final String StartLottie = "startLottie";
    private final Context context;
    private final JsCallback dynamicUI;
    private final FileProviderInterface fileProviderservice;
    private final WeakHashMap<String, String> jsonStringCache = new WeakHashMap<>();

    public LottieAnimation(Context context2, JsCallback jsCallback, FileProviderInterface fileProviderInterface) {
        this.context = context2;
        this.fileProviderservice = fileProviderInterface;
        this.dynamicUI = jsCallback;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$applyAnimation$0(Ej ej, View view, boolean z, C0181ej ejVar) {
        ej.l(ejVar);
        view.setBackground(ej);
        if (z) {
            ej.start();
        } else {
            ej.stop();
        }
    }

    /* JADX WARNING: type inference failed for: r0v26, types: [android.graphics.drawable.Drawable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void applyAnimation(java.lang.Object r17, org.json.JSONArray r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            java.lang.String r2 = "lottieAlpha"
            java.lang.String r3 = "safeMode"
            java.lang.String r4 = "maxProgress"
            java.lang.String r5 = "minProgress"
            java.lang.String r6 = "maxFrame"
            java.lang.String r7 = "minFrame"
            java.lang.String r8 = "speed"
            java.lang.String r9 = "repeatCount"
            java.lang.String r10 = "repeatMode"
            java.lang.String r11 = "lottieUrl"
            boolean r12 = r1 instanceof android.view.View     // Catch:{ Exception -> 0x0169 }
            if (r12 != 0) goto L_0x001d
            return
        L_0x001d:
            android.view.View r1 = (android.view.View) r1     // Catch:{ Exception -> 0x0169 }
            int r12 = r18.length()     // Catch:{ Exception -> 0x0169 }
            if (r12 != 0) goto L_0x0032
            android.graphics.drawable.Drawable r2 = r1.getBackground()     // Catch:{ Exception -> 0x0169 }
            boolean r2 = r2 instanceof defpackage.Ej     // Catch:{ Exception -> 0x0169 }
            if (r2 == 0) goto L_0x0031
            r2 = 0
            r1.setBackground(r2)     // Catch:{ Exception -> 0x0169 }
        L_0x0031:
            return
        L_0x0032:
            int r12 = r18.length()     // Catch:{ Exception -> 0x0169 }
            r13 = 1
            if (r12 <= r13) goto L_0x0040
            in.juspay.hyper.core.JsCallback r12 = r0.dynamicUI     // Catch:{ Exception -> 0x0169 }
            java.lang.String r14 = "console.log(\"LottieAnimations Array is > 1\");"
            r12.addJsToWebView(r14)     // Catch:{ Exception -> 0x0169 }
        L_0x0040:
            int r12 = r18.length()     // Catch:{ Exception -> 0x0169 }
            int r12 = r12 - r13
            r14 = r18
            org.json.JSONObject r12 = r14.getJSONObject(r12)     // Catch:{ Exception -> 0x0169 }
            if (r12 != 0) goto L_0x004e
            return
        L_0x004e:
            java.lang.String r14 = "startLottie"
            boolean r14 = r12.optBoolean(r14, r13)     // Catch:{ Exception -> 0x0169 }
            boolean r15 = r12.has(r11)     // Catch:{ Exception -> 0x0169 }
            if (r15 == 0) goto L_0x009d
            java.lang.String r11 = r12.getString(r11)     // Catch:{ Exception -> 0x0169 }
            java.util.WeakHashMap<java.lang.String, java.lang.String> r15 = r0.jsonStringCache     // Catch:{ Exception -> 0x0169 }
            boolean r15 = r15.containsKey(r11)     // Catch:{ Exception -> 0x0169 }
            if (r15 == 0) goto L_0x006f
            java.util.WeakHashMap<java.lang.String, java.lang.String> r15 = r0.jsonStringCache     // Catch:{ Exception -> 0x0169 }
            java.lang.Object r15 = r15.get(r11)     // Catch:{ Exception -> 0x0169 }
            java.lang.String r15 = (java.lang.String) r15     // Catch:{ Exception -> 0x0169 }
            goto L_0x0085
        L_0x006f:
            in.juspay.hyper.core.FileProviderInterface r15 = r0.fileProviderservice     // Catch:{ Exception -> 0x0169 }
            android.content.Context r13 = r0.context     // Catch:{ Exception -> 0x0169 }
            java.lang.String r15 = r15.readFromFile(r13, r11)     // Catch:{ Exception -> 0x0169 }
            if (r15 == 0) goto L_0x009c
            int r13 = r15.length()     // Catch:{ Exception -> 0x0169 }
            if (r13 != 0) goto L_0x0080
            goto L_0x009c
        L_0x0080:
            java.util.WeakHashMap<java.lang.String, java.lang.String> r13 = r0.jsonStringCache     // Catch:{ Exception -> 0x0169 }
            r13.put(r11, r15)     // Catch:{ Exception -> 0x0169 }
        L_0x0085:
            Ej r13 = new Ej     // Catch:{ Exception -> 0x0169 }
            r13.<init>()     // Catch:{ Exception -> 0x0169 }
            hj r0 = new hj     // Catch:{ Exception -> 0x0169 }
            r0.<init>(r15, r11)     // Catch:{ Exception -> 0x0169 }
            Mj r0 = defpackage.C0281nj.a(r11, r0)     // Catch:{ Exception -> 0x0169 }
            Zi r11 = new Zi     // Catch:{ Exception -> 0x0169 }
            r11.<init>(r13, r1, r14)     // Catch:{ Exception -> 0x0169 }
            r0.a(r11)     // Catch:{ Exception -> 0x0169 }
            goto L_0x00ac
        L_0x009c:
            return
        L_0x009d:
            android.graphics.drawable.Drawable r0 = r1.getBackground()     // Catch:{ Exception -> 0x0169 }
            boolean r0 = r0 instanceof defpackage.Ej     // Catch:{ Exception -> 0x0169 }
            if (r0 == 0) goto L_0x0169
            android.graphics.drawable.Drawable r0 = r1.getBackground()     // Catch:{ Exception -> 0x0169 }
            r13 = r0
            Ej r13 = (defpackage.Ej) r13     // Catch:{ Exception -> 0x0169 }
        L_0x00ac:
            boolean r0 = r12.has(r10)     // Catch:{ Exception -> 0x0169 }
            if (r0 == 0) goto L_0x00c8
            java.lang.String r0 = "reverse"
            java.lang.String r1 = ""
            java.lang.String r1 = r12.optString(r10, r1)     // Catch:{ Exception -> 0x0169 }
            boolean r0 = r0.equals(r1)     // Catch:{ Exception -> 0x0169 }
            if (r0 == 0) goto L_0x00c2
            r0 = 2
            goto L_0x00c3
        L_0x00c2:
            r0 = 1
        L_0x00c3:
            Nj r1 = r13.f138a     // Catch:{ Exception -> 0x0169 }
            r1.setRepeatMode(r0)     // Catch:{ Exception -> 0x0169 }
        L_0x00c8:
            boolean r0 = r12.has(r9)     // Catch:{ Exception -> 0x0169 }
            r1 = 0
            if (r0 == 0) goto L_0x00e1
            int r0 = r12.optInt(r9, r1)     // Catch:{ Exception -> 0x0169 }
            if (r0 >= 0) goto L_0x00dc
            Nj r0 = r13.f138a     // Catch:{ Exception -> 0x0169 }
            r9 = -1
            r0.setRepeatCount(r9)     // Catch:{ Exception -> 0x0169 }
            goto L_0x00e1
        L_0x00dc:
            Nj r9 = r13.f138a     // Catch:{ Exception -> 0x0169 }
            r9.setRepeatCount(r0)     // Catch:{ Exception -> 0x0169 }
        L_0x00e1:
            boolean r0 = r12.has(r8)     // Catch:{ Exception -> 0x0169 }
            if (r0 == 0) goto L_0x00f2
            r9 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r8 = r12.optDouble(r8, r9)     // Catch:{ Exception -> 0x0169 }
            float r0 = (float) r8     // Catch:{ Exception -> 0x0169 }
            Nj r8 = r13.f138a     // Catch:{ Exception -> 0x0169 }
            r8.a = r0     // Catch:{ Exception -> 0x0169 }
        L_0x00f2:
            boolean r0 = r12.has(r7)     // Catch:{ Exception -> 0x0169 }
            if (r0 == 0) goto L_0x0101
            int r0 = r12.optInt(r7, r1)     // Catch:{ Exception -> 0x0169 }
            if (r0 < 0) goto L_0x0101
            r13.u(r0)     // Catch:{ Exception -> 0x0169 }
        L_0x0101:
            boolean r0 = r12.has(r6)     // Catch:{ Exception -> 0x0169 }
            if (r0 == 0) goto L_0x0110
            int r0 = r12.optInt(r6, r1)     // Catch:{ Exception -> 0x0169 }
            if (r0 < 0) goto L_0x0110
            r13.n(r0)     // Catch:{ Exception -> 0x0169 }
        L_0x0110:
            boolean r0 = r12.has(r5)     // Catch:{ Exception -> 0x0169 }
            r6 = 1065353216(0x3f800000, float:1.0)
            r7 = 0
            r8 = 0
            if (r0 == 0) goto L_0x012b
            double r10 = r12.optDouble(r5, r8)     // Catch:{ Exception -> 0x0169 }
            float r0 = (float) r10     // Catch:{ Exception -> 0x0169 }
            int r5 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r5 > 0) goto L_0x012b
            int r5 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r5 > 0) goto L_0x012b
            r13.w(r0)     // Catch:{ Exception -> 0x0169 }
        L_0x012b:
            boolean r0 = r12.has(r4)     // Catch:{ Exception -> 0x0169 }
            if (r0 == 0) goto L_0x0141
            double r4 = r12.optDouble(r4, r8)     // Catch:{ Exception -> 0x0169 }
            float r0 = (float) r4     // Catch:{ Exception -> 0x0169 }
            int r4 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r4 > 0) goto L_0x0141
            int r4 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r4 > 0) goto L_0x0141
            r13.p(r0)     // Catch:{ Exception -> 0x0169 }
        L_0x0141:
            boolean r0 = r12.has(r3)     // Catch:{ Exception -> 0x0169 }
            if (r0 == 0) goto L_0x014d
            boolean r0 = r12.optBoolean(r3, r1)     // Catch:{ Exception -> 0x0169 }
            r13.f158c = r0     // Catch:{ Exception -> 0x0169 }
        L_0x014d:
            boolean r0 = r12.has(r2)     // Catch:{ Exception -> 0x0169 }
            if (r0 == 0) goto L_0x0160
            r0 = 255(0xff, float:3.57E-43)
            int r1 = r12.optInt(r2, r0)     // Catch:{ Exception -> 0x0169 }
            if (r1 < 0) goto L_0x0160
            if (r1 > r0) goto L_0x0160
            r13.setAlpha(r1)     // Catch:{ Exception -> 0x0169 }
        L_0x0160:
            if (r14 == 0) goto L_0x0166
            r13.start()     // Catch:{ Exception -> 0x0169 }
            goto L_0x0169
        L_0x0166:
            r13.stop()     // Catch:{ Exception -> 0x0169 }
        L_0x0169:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hyperlottie.LottieAnimation.applyAnimation(java.lang.Object, org.json.JSONArray):void");
    }
}
