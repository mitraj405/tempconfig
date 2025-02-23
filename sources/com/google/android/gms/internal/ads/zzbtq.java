package com.google.android.gms.internal.ads;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebView;
import com.google.ads.mediation.facebook.FacebookMediationAdapter;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.client.zzr;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.wrappers.Wrappers;
import in.juspay.hyper.constants.LogSubCategory;
import in.juspay.hypersdk.core.PaymentConstants;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
public final class zzbtq implements zzbts {
    public static zzbts zza;
    static zzbts zzb;
    static zzbts zzc;
    static Boolean zzd;
    private static final Object zze = new Object();
    private final Object zzf;
    private final Context zzg;
    private final WeakHashMap zzh;
    private final ExecutorService zzi;
    private final VersionInfoParcel zzj;
    private final PackageInfo zzk;
    private final String zzl;
    private final String zzm;
    private final AtomicBoolean zzn;
    private boolean zzo;

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00b1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzbtq(android.content.Context r3, com.google.android.gms.ads.internal.util.client.VersionInfoParcel r4) {
        /*
            r2 = this;
            r2.<init>()
            java.lang.Object r0 = new java.lang.Object
            r0.<init>()
            r2.zzf = r0
            java.util.WeakHashMap r0 = new java.util.WeakHashMap
            r0.<init>()
            r2.zzh = r0
            com.google.android.gms.internal.ads.zzfrt.zza()
            java.util.concurrent.ExecutorService r0 = java.util.concurrent.Executors.newCachedThreadPool()
            java.util.concurrent.ExecutorService r0 = java.util.concurrent.Executors.unconfigurableExecutorService(r0)
            r2.zzi = r0
            java.util.concurrent.atomic.AtomicBoolean r0 = new java.util.concurrent.atomic.AtomicBoolean
            r0.<init>()
            r2.zzn = r0
            android.content.Context r0 = r3.getApplicationContext()
            if (r0 == 0) goto L_0x002f
            android.content.Context r3 = r3.getApplicationContext()
        L_0x002f:
            r2.zzg = r3
            r2.zzj = r4
            com.google.android.gms.internal.ads.zzbbn r4 = com.google.android.gms.internal.ads.zzbbw.zzgX
            com.google.android.gms.internal.ads.zzbbu r0 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r4 = r0.zza(r4)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            r0 = 0
            if (r4 == 0) goto L_0x0061
            android.os.Handler r4 = com.google.android.gms.ads.internal.util.client.zzf.zza
            if (r3 == 0) goto L_0x0061
            android.content.pm.ApplicationInfo r4 = r3.getApplicationInfo()
            if (r4 != 0) goto L_0x0051
            goto L_0x0061
        L_0x0051:
            com.google.android.gms.common.wrappers.PackageManagerWrapper r4 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r3)     // Catch:{ NameNotFoundException -> 0x0061 }
            android.content.pm.ApplicationInfo r3 = r3.getApplicationInfo()     // Catch:{ NameNotFoundException -> 0x0061 }
            java.lang.String r3 = r3.packageName     // Catch:{ NameNotFoundException -> 0x0061 }
            r1 = 0
            android.content.pm.PackageInfo r3 = r4.getPackageInfo(r3, r1)     // Catch:{ NameNotFoundException -> 0x0061 }
            goto L_0x0062
        L_0x0061:
            r3 = r0
        L_0x0062:
            r2.zzk = r3
            com.google.android.gms.internal.ads.zzbbn r3 = com.google.android.gms.internal.ads.zzbbw.zzgV
            com.google.android.gms.internal.ads.zzbbu r4 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r4 = r4.zza(r3)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            java.lang.String r1 = "unknown"
            if (r4 == 0) goto L_0x0081
            java.util.Locale r4 = java.util.Locale.getDefault()
            java.lang.String r4 = r4.getCountry()
            goto L_0x0082
        L_0x0081:
            r4 = r1
        L_0x0082:
            r2.zzl = r4
            com.google.android.gms.internal.ads.zzbbu r4 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r3 = r4.zza(r3)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L_0x00b1
            android.content.Context r3 = r2.zzg
            android.os.Handler r4 = com.google.android.gms.ads.internal.util.client.zzf.zza
            if (r3 != 0) goto L_0x009b
            goto L_0x00b2
        L_0x009b:
            com.google.android.gms.common.wrappers.PackageManagerWrapper r3 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r3)     // Catch:{ NameNotFoundException -> 0x00b2 }
            java.lang.String r4 = "com.android.vending"
            r1 = 128(0x80, float:1.794E-43)
            android.content.pm.PackageInfo r3 = r3.getPackageInfo(r4, r1)     // Catch:{ NameNotFoundException -> 0x00b2 }
            if (r3 != 0) goto L_0x00aa
            goto L_0x00b2
        L_0x00aa:
            int r3 = r3.versionCode     // Catch:{ NameNotFoundException -> 0x00b2 }
            java.lang.String r0 = java.lang.Integer.toString(r3)     // Catch:{ NameNotFoundException -> 0x00b2 }
            goto L_0x00b2
        L_0x00b1:
            r0 = r1
        L_0x00b2:
            r2.zzm = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbtq.<init>(android.content.Context, com.google.android.gms.ads.internal.util.client.VersionInfoParcel):void");
    }

    public static zzbts zza(Context context) {
        synchronized (zze) {
            if (zza == null) {
                if (zzl()) {
                    zza = new zzbtq(context, VersionInfoParcel.forPackage());
                } else {
                    zza = new zzbtr();
                }
            }
        }
        return zza;
    }

    public static zzbts zzb(Context context, VersionInfoParcel versionInfoParcel) {
        synchronized (zze) {
            if (zzc == null) {
                boolean z = false;
                if (((Boolean) zzbdk.zzc.zze()).booleanValue()) {
                    if (!((Boolean) zzba.zzc().zza(zzbbw.zzgQ)).booleanValue() || ((Boolean) zzbdk.zza.zze()).booleanValue()) {
                        z = true;
                    }
                }
                if (zzl()) {
                    zzbtq zzbtq = new zzbtq(context, versionInfoParcel);
                    zzbtq.zzk();
                    zzbtq.zzj();
                    zzc = zzbtq;
                } else if (z) {
                    zzbtq zzbtq2 = new zzbtq(context, versionInfoParcel, true);
                    zzbtq2.zzk();
                    zzbtq2.zzj();
                    zzc = zzbtq2;
                } else {
                    zzc = new zzbtr();
                }
            }
        }
        return zzc;
    }

    public static zzbts zzc(Context context) {
        synchronized (zze) {
            if (zzb == null) {
                if (((Boolean) zzba.zzc().zza(zzbbw.zzgR)).booleanValue()) {
                    if (!((Boolean) zzba.zzc().zza(zzbbw.zzgQ)).booleanValue()) {
                        zzb = new zzbtq(context, VersionInfoParcel.forPackage());
                    }
                }
                zzb = new zzbtr();
            }
        }
        return zzb;
    }

    public static zzbts zzd(Context context, VersionInfoParcel versionInfoParcel) {
        synchronized (zze) {
            if (zzb == null) {
                if (((Boolean) zzba.zzc().zza(zzbbw.zzgR)).booleanValue()) {
                    if (!((Boolean) zzba.zzc().zza(zzbbw.zzgQ)).booleanValue()) {
                        zzb = new zzbtq(context, versionInfoParcel);
                    }
                }
                zzb = new zzbtr();
            }
        }
        return zzb;
    }

    public static String zze(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static String zzf(Throwable th) {
        return zzfvj.zzc(zzf.zzg(zze(th)));
    }

    private final void zzj() {
        Thread.setDefaultUncaughtExceptionHandler(new zzbto(this, Thread.getDefaultUncaughtExceptionHandler()));
    }

    private final void zzk() {
        Thread thread = Looper.getMainLooper().getThread();
        if (thread != null) {
            synchronized (this.zzf) {
                this.zzh.put(thread, Boolean.TRUE);
            }
            thread.setUncaughtExceptionHandler(new zzbtp(this, thread.getUncaughtExceptionHandler()));
        }
    }

    private static boolean zzl() {
        boolean z;
        if (!((Boolean) zzba.zzc().zza(zzbbw.zzlO)).booleanValue()) {
            if (((Boolean) zzbeb.zze.zze()).booleanValue()) {
                if (!((Boolean) zzba.zzc().zza(zzbbw.zzgQ)).booleanValue()) {
                    return true;
                }
            }
            return false;
        }
        synchronized (zze) {
            if (zzd == null) {
                if (zzay.zze().nextInt(100) < ((Integer) zzba.zzc().zza(zzbbw.zzlL)).intValue()) {
                    z = true;
                } else {
                    z = false;
                }
                zzd = Boolean.valueOf(z);
            }
        }
        if (zzd.booleanValue()) {
            if (!((Boolean) zzba.zzc().zza(zzbbw.zzgQ)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public final void zzg(Thread thread, Throwable th) {
        if (th != null) {
            boolean z = false;
            boolean z2 = false;
            for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
                for (StackTraceElement stackTraceElement : th2.getStackTrace()) {
                    z |= zzf.zzp(stackTraceElement.getClassName());
                    z2 |= zzbtq.class.getName().equals(stackTraceElement.getClassName());
                }
            }
            if (z && !z2) {
                if (!this.zzo) {
                    zzh(th, "");
                }
                if (!this.zzn.getAndSet(true) && ((Boolean) zzbdk.zzc.zze()).booleanValue()) {
                    zzbbg.zzc(this.zzg);
                }
            }
        }
    }

    public final void zzh(Throwable th, String str) {
        if (!this.zzo) {
            zzi(th, str, 1.0f);
        }
    }

    public final void zzi(Throwable th, String str, float f) {
        Throwable th2;
        String str2;
        int i;
        String str3;
        ActivityManager.MemoryInfo zzc2;
        boolean z;
        float f2 = f;
        if (!this.zzo) {
            Handler handler = zzf.zza;
            boolean z2 = false;
            if (((Boolean) zzbeb.zzf.zze()).booleanValue()) {
                th2 = th;
            } else {
                LinkedList linkedList = new LinkedList();
                for (Throwable th3 = th; th3 != null; th3 = th3.getCause()) {
                    linkedList.push(th3);
                }
                th2 = null;
                while (!linkedList.isEmpty()) {
                    Throwable th4 = (Throwable) linkedList.pop();
                    StackTraceElement[] stackTrace = th4.getStackTrace();
                    if (!((Boolean) zzba.zzc().zza(zzbbw.zzbY)).booleanValue() || stackTrace == null || stackTrace.length != 0 || !zzf.zzp(th4.getClass().getName())) {
                        z = false;
                    } else {
                        z = true;
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new StackTraceElement(th4.getClass().getName(), "<filtered>", "<filtered>", 1));
                    for (StackTraceElement stackTraceElement : stackTrace) {
                        if (zzf.zzp(stackTraceElement.getClassName())) {
                            arrayList.add(stackTraceElement);
                            z = true;
                        } else {
                            String className = stackTraceElement.getClassName();
                            if (!TextUtils.isEmpty(className) && (className.startsWith("android.") || className.startsWith("java."))) {
                                arrayList.add(stackTraceElement);
                            } else {
                                arrayList.add(new StackTraceElement("<filtered>", "<filtered>", "<filtered>", 1));
                            }
                        }
                    }
                    if (z) {
                        if (th2 == null) {
                            th2 = new Throwable(th4.getMessage());
                        } else {
                            th2 = new Throwable(th4.getMessage(), th2);
                        }
                        th2.setStackTrace((StackTraceElement[]) arrayList.toArray(new StackTraceElement[0]));
                    }
                }
            }
            if (th2 != null) {
                String name = th.getClass().getName();
                String zze2 = zze(th);
                if (((Boolean) zzba.zzc().zza(zzbbw.zzhV)).booleanValue()) {
                    str2 = zzf(th);
                } else {
                    str2 = "";
                }
                double d = (double) f2;
                int i2 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
                double random = Math.random();
                if (i2 > 0) {
                    i = (int) (1.0f / f2);
                } else {
                    i = 1;
                }
                if (random < d) {
                    ArrayList arrayList2 = new ArrayList();
                    try {
                        z2 = Wrappers.packageManager(this.zzg).isCallerInstantApp();
                    } catch (Throwable th5) {
                        zzm.zzh("Error fetching instant app info", th5);
                    }
                    try {
                        str3 = this.zzg.getPackageName();
                    } catch (Throwable unused) {
                        zzm.zzj("Cannot obtain package name, proceeding.");
                        str3 = "unknown";
                    }
                    Uri.Builder appendQueryParameter = new Uri.Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("is_aia", Boolean.toString(z2)).appendQueryParameter(FacebookMediationAdapter.KEY_ID, "gmob-apps-report-exception").appendQueryParameter("os", Build.VERSION.RELEASE).appendQueryParameter("api", String.valueOf(Build.VERSION.SDK_INT));
                    String str4 = Build.MANUFACTURER;
                    String str5 = Build.MODEL;
                    if (!str5.startsWith(str4)) {
                        str5 = xx.D(str4, " ", str5);
                    }
                    Uri.Builder appendQueryParameter2 = appendQueryParameter.appendQueryParameter(LogSubCategory.Context.DEVICE, str5).appendQueryParameter("js", this.zzj.afmaVersion).appendQueryParameter("appid", str3).appendQueryParameter("exceptiontype", name).appendQueryParameter("stacktrace", zze2).appendQueryParameter("eids", TextUtils.join(",", zzba.zza().zza())).appendQueryParameter("exceptionkey", str).appendQueryParameter("cl", "661295874").appendQueryParameter("rc", PaymentConstants.ENVIRONMENT.DEV).appendQueryParameter("sampling_rate", Integer.toString(i)).appendQueryParameter("pb_tm", String.valueOf(zzbeb.zzc.zze())).appendQueryParameter("gmscv", String.valueOf(GoogleApiAvailabilityLight.getInstance().getApkVersion(this.zzg)));
                    String str6 = "0";
                    Uri.Builder appendQueryParameter3 = appendQueryParameter2.appendQueryParameter("lite", true != this.zzj.isLiteSdk ? str6 : C0515Ga.AVLBLTY_ONLY);
                    if (!TextUtils.isEmpty(str2)) {
                        appendQueryParameter3.appendQueryParameter("hash", str2);
                    }
                    if (((Boolean) zzba.zzc().zza(zzbbw.zzgW)).booleanValue() && (zzc2 = zzf.zzc(this.zzg)) != null) {
                        appendQueryParameter3.appendQueryParameter("available_memory", Long.toString(zzc2.availMem));
                        appendQueryParameter3.appendQueryParameter("total_memory", Long.toString(zzc2.totalMem));
                        if (true == zzc2.lowMemory) {
                            str6 = C0515Ga.AVLBLTY_ONLY;
                        }
                        appendQueryParameter3.appendQueryParameter("is_low_memory", str6);
                    }
                    if (((Boolean) zzba.zzc().zza(zzbbw.zzgV)).booleanValue()) {
                        if (!TextUtils.isEmpty(this.zzl)) {
                            appendQueryParameter3.appendQueryParameter("countrycode", this.zzl);
                        }
                        if (!TextUtils.isEmpty(this.zzm)) {
                            appendQueryParameter3.appendQueryParameter("psv", this.zzm);
                        }
                        PackageInfo currentWebViewPackage = WebView.getCurrentWebViewPackage();
                        if (currentWebViewPackage != null) {
                            appendQueryParameter3.appendQueryParameter("wvvc", Integer.toString(currentWebViewPackage.versionCode));
                            appendQueryParameter3.appendQueryParameter("wvvn", currentWebViewPackage.versionName);
                            appendQueryParameter3.appendQueryParameter("wvpn", currentWebViewPackage.packageName);
                        }
                    }
                    PackageInfo packageInfo = this.zzk;
                    if (packageInfo != null) {
                        appendQueryParameter3.appendQueryParameter("appvc", String.valueOf(packageInfo.versionCode));
                        appendQueryParameter3.appendQueryParameter("appvn", this.zzk.versionName);
                    }
                    arrayList2.add(appendQueryParameter3.toString());
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        this.zzi.execute(new zzbtn(new zzr((String) null), (String) it.next()));
                    }
                }
            }
        }
    }

    public zzbtq(Context context, VersionInfoParcel versionInfoParcel, boolean z) {
        this(context, versionInfoParcel);
        this.zzo = true;
    }
}
