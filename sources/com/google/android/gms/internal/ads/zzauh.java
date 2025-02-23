package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.internal.client.zzba;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzauh implements zzauk {
    private static zzauh zzb;
    volatile long zza = 0;
    private final Context zzc;
    private final zzfpw zzd;
    private final zzfqd zze;
    private final zzfqf zzf;
    private final zzavj zzg;
    /* access modifiers changed from: private */
    public final zzfoh zzh;
    private final Executor zzi;
    private final zzfqc zzj;
    private final CountDownLatch zzk;
    private final zzavy zzl;
    private final zzavq zzm;
    private final zzavh zzn;
    /* access modifiers changed from: private */
    public final Object zzo = new Object();
    /* access modifiers changed from: private */
    public volatile boolean zzp;
    private volatile boolean zzq = false;
    private final int zzr;

    public zzauh(Context context, zzfoh zzfoh, zzfpw zzfpw, zzfqd zzfqd, zzfqf zzfqf, zzavj zzavj, Executor executor, zzfoc zzfoc, int i, zzavy zzavy, zzavq zzavq, zzavh zzavh) {
        this.zzc = context;
        this.zzh = zzfoh;
        this.zzd = zzfpw;
        this.zze = zzfqd;
        this.zzf = zzfqf;
        this.zzg = zzavj;
        this.zzi = executor;
        this.zzr = i;
        this.zzl = zzavy;
        this.zzm = zzavq;
        this.zzn = zzavh;
        this.zzq = false;
        this.zzk = new CountDownLatch(1);
        this.zzj = new zzauf(this, zzfoc);
    }

    public static synchronized zzauh zza(String str, Context context, boolean z, boolean z2) {
        zzauh zzb2;
        synchronized (zzauh.class) {
            zzb2 = zzb(str, context, Executors.newCachedThreadPool(), z, z2);
        }
        return zzb2;
    }

    @Deprecated
    public static synchronized zzauh zzb(String str, Context context, Executor executor, boolean z, boolean z2) {
        zzauh zzauh;
        zzaus zzaus;
        zzavy zzavy;
        zzavq zzavq;
        zzavh zzavh;
        Context context2 = context;
        Executor executor2 = executor;
        synchronized (zzauh.class) {
            if (zzb == null) {
                zzfoi zza2 = zzfoj.zza();
                zza2.zza(str);
                zza2.zzc(z);
                zzfoj zzd2 = zza2.zzd();
                zzfoh zza3 = zzfoh.zza(context2, executor2, z2);
                if (((Boolean) zzba.zzc().zza(zzbbw.zzcY)).booleanValue()) {
                    zzaus = zzaus.zzc(context);
                } else {
                    zzaus = null;
                }
                if (((Boolean) zzba.zzc().zza(zzbbw.zzcZ)).booleanValue()) {
                    zzavy = zzavy.zzd(context, executor);
                } else {
                    zzavy = null;
                }
                if (((Boolean) zzba.zzc().zza(zzbbw.zzcs)).booleanValue()) {
                    zzavq = new zzavq();
                } else {
                    zzavq = null;
                }
                if (((Boolean) zzba.zzc().zza(zzbbw.zzct)).booleanValue()) {
                    zzavh = new zzavh();
                } else {
                    zzavh = null;
                }
                zzfpa zze2 = zzfpa.zze(context2, executor2, zza3, zzd2);
                zzavi zzavi = new zzavi(context2);
                zzavj zzavj = new zzavj(zzd2, zze2, new zzavw(context2, zzavi), zzavi, zzaus, zzavy, zzavq, zzavh);
                int zzb2 = zzfpj.zzb(context2, zza3);
                zzfoc zzfoc = new zzfoc();
                zzauh zzauh2 = new zzauh(context, zza3, new zzfpw(context2, zzb2), new zzfqd(context2, zzb2, new zzaue(zza3), ((Boolean) zzba.zzc().zza(zzbbw.zzcc)).booleanValue()), new zzfqf(context2, zzavj, zza3, zzfoc), zzavj, executor, zzfoc, zzb2, zzavy, zzavq, zzavh);
                zzb = zzauh2;
                zzauh2.zzm();
                zzb.zzp();
            }
            zzauh = zzb;
        }
        return zzauh;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x009a, code lost:
        if (r4.zzd().zzj().equals(r5.zzj()) != false) goto L_0x00f5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* bridge */ /* synthetic */ void zzj(com.google.android.gms.internal.ads.zzauh r12) {
        /*
            long r0 = java.lang.System.currentTimeMillis()
            r2 = 1
            com.google.android.gms.internal.ads.zzfpv r3 = r12.zzt(r2)
            if (r3 == 0) goto L_0x001e
            com.google.android.gms.internal.ads.zzaxl r4 = r3.zza()
            java.lang.String r4 = r4.zzk()
            com.google.android.gms.internal.ads.zzaxl r3 = r3.zza()
            java.lang.String r3 = r3.zzj()
            r9 = r3
            r8 = r4
            goto L_0x0021
        L_0x001e:
            r4 = 0
            r8 = r4
            r9 = r8
        L_0x0021:
            android.content.Context r5 = r12.zzc     // Catch:{ zzgyn -> 0x011e }
            r6 = 1
            int r7 = r12.zzr     // Catch:{ zzgyn -> 0x011e }
            java.lang.String r10 = "1"
            com.google.android.gms.internal.ads.zzfoh r11 = r12.zzh     // Catch:{ zzgyn -> 0x011e }
            com.google.android.gms.internal.ads.zzfqa r3 = com.google.android.gms.internal.ads.zzfor.zza(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ zzgyn -> 0x011e }
            byte[] r4 = r3.zzb     // Catch:{ zzgyn -> 0x011e }
            if (r4 == 0) goto L_0x010f
            int r5 = r4.length     // Catch:{ zzgyn -> 0x011e }
            if (r5 != 0) goto L_0x0037
            goto L_0x010f
        L_0x0037:
            r6 = 0
            com.google.android.gms.internal.ads.zzgwm r4 = com.google.android.gms.internal.ads.zzgwm.zzv(r4, r6, r5)     // Catch:{ NullPointerException -> 0x0102 }
            com.google.android.gms.internal.ads.zzgxi r5 = com.google.android.gms.internal.ads.zzgxi.zza()     // Catch:{ NullPointerException -> 0x0102 }
            com.google.android.gms.internal.ads.zzaxi r4 = com.google.android.gms.internal.ads.zzaxi.zzc(r4, r5)     // Catch:{ NullPointerException -> 0x0102 }
            com.google.android.gms.internal.ads.zzaxl r5 = r4.zzd()     // Catch:{ zzgyn -> 0x011e }
            java.lang.String r5 = r5.zzk()     // Catch:{ zzgyn -> 0x011e }
            boolean r5 = r5.isEmpty()     // Catch:{ zzgyn -> 0x011e }
            if (r5 != 0) goto L_0x00f5
            com.google.android.gms.internal.ads.zzaxl r5 = r4.zzd()     // Catch:{ zzgyn -> 0x011e }
            java.lang.String r5 = r5.zzj()     // Catch:{ zzgyn -> 0x011e }
            boolean r5 = r5.isEmpty()     // Catch:{ zzgyn -> 0x011e }
            if (r5 != 0) goto L_0x00f5
            com.google.android.gms.internal.ads.zzgwm r5 = r4.zze()     // Catch:{ zzgyn -> 0x011e }
            byte[] r5 = r5.zzA()     // Catch:{ zzgyn -> 0x011e }
            int r5 = r5.length     // Catch:{ zzgyn -> 0x011e }
            if (r5 != 0) goto L_0x006d
            goto L_0x00f5
        L_0x006d:
            com.google.android.gms.internal.ads.zzfpv r5 = r12.zzt(r2)     // Catch:{ zzgyn -> 0x011e }
            if (r5 != 0) goto L_0x0074
            goto L_0x009c
        L_0x0074:
            com.google.android.gms.internal.ads.zzaxl r5 = r5.zza()     // Catch:{ zzgyn -> 0x011e }
            com.google.android.gms.internal.ads.zzaxl r6 = r4.zzd()     // Catch:{ zzgyn -> 0x011e }
            java.lang.String r6 = r6.zzk()     // Catch:{ zzgyn -> 0x011e }
            java.lang.String r7 = r5.zzk()     // Catch:{ zzgyn -> 0x011e }
            boolean r6 = r6.equals(r7)     // Catch:{ zzgyn -> 0x011e }
            if (r6 == 0) goto L_0x009c
            com.google.android.gms.internal.ads.zzaxl r6 = r4.zzd()     // Catch:{ zzgyn -> 0x011e }
            java.lang.String r6 = r6.zzj()     // Catch:{ zzgyn -> 0x011e }
            java.lang.String r5 = r5.zzj()     // Catch:{ zzgyn -> 0x011e }
            boolean r5 = r6.equals(r5)     // Catch:{ zzgyn -> 0x011e }
            if (r5 != 0) goto L_0x00f5
        L_0x009c:
            com.google.android.gms.internal.ads.zzfqc r5 = r12.zzj     // Catch:{ zzgyn -> 0x011e }
            int r3 = r3.zzc     // Catch:{ zzgyn -> 0x011e }
            com.google.android.gms.internal.ads.zzbbn r6 = com.google.android.gms.internal.ads.zzbbw.zzca     // Catch:{ zzgyn -> 0x011e }
            com.google.android.gms.internal.ads.zzbbu r7 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ zzgyn -> 0x011e }
            java.lang.Object r6 = r7.zza(r6)     // Catch:{ zzgyn -> 0x011e }
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ zzgyn -> 0x011e }
            boolean r6 = r6.booleanValue()     // Catch:{ zzgyn -> 0x011e }
            if (r6 == 0) goto L_0x00c6
            r6 = 3
            if (r3 != r6) goto L_0x00bc
            com.google.android.gms.internal.ads.zzfqd r3 = r12.zze     // Catch:{ zzgyn -> 0x011e }
            boolean r3 = r3.zza(r4)     // Catch:{ zzgyn -> 0x011e }
            goto L_0x00cc
        L_0x00bc:
            r6 = 4
            if (r3 != r6) goto L_0x00ce
            com.google.android.gms.internal.ads.zzfqd r3 = r12.zze     // Catch:{ zzgyn -> 0x011e }
            boolean r3 = r3.zzb(r4, r5)     // Catch:{ zzgyn -> 0x011e }
            goto L_0x00cc
        L_0x00c6:
            com.google.android.gms.internal.ads.zzfpw r3 = r12.zzd     // Catch:{ zzgyn -> 0x011e }
            boolean r3 = r3.zza(r4, r5)     // Catch:{ zzgyn -> 0x011e }
        L_0x00cc:
            if (r3 != 0) goto L_0x00db
        L_0x00ce:
            com.google.android.gms.internal.ads.zzfoh r2 = r12.zzh     // Catch:{ zzgyn -> 0x011e }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ zzgyn -> 0x011e }
            long r3 = r3 - r0
            r5 = 4009(0xfa9, float:5.618E-42)
            r2.zzd(r5, r3)     // Catch:{ zzgyn -> 0x011e }
            goto L_0x012b
        L_0x00db:
            com.google.android.gms.internal.ads.zzfpv r3 = r12.zzt(r2)     // Catch:{ zzgyn -> 0x011e }
            if (r3 == 0) goto L_0x012b
            com.google.android.gms.internal.ads.zzfqf r4 = r12.zzf     // Catch:{ zzgyn -> 0x011e }
            boolean r3 = r4.zzc(r3)     // Catch:{ zzgyn -> 0x011e }
            if (r3 == 0) goto L_0x00eb
            r12.zzq = r2     // Catch:{ zzgyn -> 0x011e }
        L_0x00eb:
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ zzgyn -> 0x011e }
            r4 = 1000(0x3e8, double:4.94E-321)
            long r2 = r2 / r4
            r12.zza = r2     // Catch:{ zzgyn -> 0x011e }
            goto L_0x012b
        L_0x00f5:
            com.google.android.gms.internal.ads.zzfoh r2 = r12.zzh     // Catch:{ zzgyn -> 0x011e }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ zzgyn -> 0x011e }
            long r3 = r3 - r0
            r5 = 5010(0x1392, float:7.02E-42)
            r2.zzd(r5, r3)     // Catch:{ zzgyn -> 0x011e }
            goto L_0x012b
        L_0x0102:
            com.google.android.gms.internal.ads.zzfoh r2 = r12.zzh     // Catch:{ zzgyn -> 0x011e }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ zzgyn -> 0x011e }
            long r3 = r3 - r0
            r5 = 2030(0x7ee, float:2.845E-42)
            r2.zzd(r5, r3)     // Catch:{ zzgyn -> 0x011e }
            goto L_0x012b
        L_0x010f:
            com.google.android.gms.internal.ads.zzfoh r2 = r12.zzh     // Catch:{ zzgyn -> 0x011e }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ zzgyn -> 0x011e }
            long r3 = r3 - r0
            r5 = 5009(0x1391, float:7.019E-42)
            r2.zzd(r5, r3)     // Catch:{ zzgyn -> 0x011e }
            goto L_0x012b
        L_0x011c:
            r0 = move-exception
            goto L_0x0131
        L_0x011e:
            r2 = move-exception
            com.google.android.gms.internal.ads.zzfoh r3 = r12.zzh     // Catch:{ all -> 0x011c }
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x011c }
            long r4 = r4 - r0
            r0 = 4002(0xfa2, float:5.608E-42)
            r3.zzc(r0, r4, r2)     // Catch:{ all -> 0x011c }
        L_0x012b:
            java.util.concurrent.CountDownLatch r12 = r12.zzk
            r12.countDown()
            return
        L_0x0131:
            java.util.concurrent.CountDownLatch r12 = r12.zzk
            r12.countDown()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzauh.zzj(com.google.android.gms.internal.ads.zzauh):void");
    }

    private final void zzs() {
        zzavy zzavy = this.zzl;
        if (zzavy != null) {
            zzavy.zzh();
        }
    }

    private final zzfpv zzt(int i) {
        if (!zzfpj.zza(this.zzr)) {
            return null;
        }
        if (((Boolean) zzba.zzc().zza(zzbbw.zzca)).booleanValue()) {
            return this.zze.zzc(1);
        }
        return this.zzd.zzc(1);
    }

    public final String zze(Context context, String str, View view) {
        return zzf(context, str, view, (Activity) null);
    }

    public final String zzf(Context context, String str, View view, Activity activity) {
        zzs();
        if (((Boolean) zzba.zzc().zza(zzbbw.zzcs)).booleanValue()) {
            this.zzm.zzi();
        }
        zzp();
        zzfok zza2 = this.zzf.zza();
        if (zza2 == null) {
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        String zza3 = zza2.zza(context, (String) null, str, view, activity);
        this.zzh.zzf(5000, System.currentTimeMillis() - currentTimeMillis, zza3, (Map) null);
        return zza3;
    }

    public final String zzg(Context context) {
        zzs();
        if (((Boolean) zzba.zzc().zza(zzbbw.zzcs)).booleanValue()) {
            this.zzm.zzj();
        }
        zzp();
        zzfok zza2 = this.zzf.zza();
        if (zza2 == null) {
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        String zzc2 = zza2.zzc(context, (String) null);
        this.zzh.zzf(5001, System.currentTimeMillis() - currentTimeMillis, zzc2, (Map) null);
        return zzc2;
    }

    public final String zzh(Context context, View view, Activity activity) {
        zzs();
        if (((Boolean) zzba.zzc().zza(zzbbw.zzcs)).booleanValue()) {
            this.zzm.zzk(context, view);
        }
        zzp();
        zzfok zza2 = this.zzf.zza();
        if (zza2 == null) {
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        String zzb2 = zza2.zzb(context, (String) null, view, activity);
        this.zzh.zzf(5002, System.currentTimeMillis() - currentTimeMillis, zzb2, (Map) null);
        return zzb2;
    }

    public final void zzk(MotionEvent motionEvent) {
        zzfok zza2 = this.zzf.zza();
        if (zza2 != null) {
            try {
                zza2.zzd((String) null, motionEvent);
            } catch (zzfqe e) {
                this.zzh.zzc(e.zza(), -1, e);
            }
        }
    }

    public final void zzl(int i, int i2, int i3) {
        DisplayMetrics displayMetrics;
        if (((Boolean) zzba.zzc().zza(zzbbw.zzkY)).booleanValue() && (displayMetrics = this.zzc.getResources().getDisplayMetrics()) != null) {
            float f = (float) i;
            float f2 = displayMetrics.density;
            float f3 = (float) i2;
            float f4 = f3;
            MotionEvent obtain = MotionEvent.obtain(0, 0, 0, f * f2, f3 * f2, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
            zzk(obtain);
            obtain.recycle();
            float f5 = displayMetrics.density;
            MotionEvent obtain2 = MotionEvent.obtain(0, 0, 2, f * f5, f4 * f5, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
            zzk(obtain2);
            obtain2.recycle();
            float f6 = displayMetrics.density;
            MotionEvent obtain3 = MotionEvent.obtain(0, (long) i3, 1, f * f6, f4 * f6, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
            zzk(obtain3);
            obtain3.recycle();
        }
    }

    public final synchronized void zzm() {
        long currentTimeMillis = System.currentTimeMillis();
        zzfpv zzt = zzt(1);
        if (zzt == null) {
            this.zzh.zzd(4013, System.currentTimeMillis() - currentTimeMillis);
        } else if (this.zzf.zzc(zzt)) {
            this.zzq = true;
            this.zzk.countDown();
        }
    }

    public final void zzn(StackTraceElement[] stackTraceElementArr) {
        zzavh zzavh = this.zzn;
        if (zzavh != null) {
            zzavh.zzb(Arrays.asList(stackTraceElementArr));
        }
    }

    public final void zzo(View view) {
        this.zzg.zzd(view);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzp() {
        /*
            r5 = this;
            boolean r0 = r5.zzp
            if (r0 != 0) goto L_0x0042
            java.lang.Object r0 = r5.zzo
            monitor-enter(r0)
            boolean r1 = r5.zzp     // Catch:{ all -> 0x003f }
            if (r1 != 0) goto L_0x003d
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x003f }
            r3 = 1000(0x3e8, double:4.94E-321)
            long r1 = r1 / r3
            long r3 = r5.zza     // Catch:{ all -> 0x003f }
            long r1 = r1 - r3
            r3 = 3600(0xe10, double:1.7786E-320)
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 >= 0) goto L_0x001d
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            return
        L_0x001d:
            com.google.android.gms.internal.ads.zzfqf r1 = r5.zzf     // Catch:{ all -> 0x003f }
            com.google.android.gms.internal.ads.zzfpv r1 = r1.zzb()     // Catch:{ all -> 0x003f }
            if (r1 == 0) goto L_0x002b
            boolean r1 = r1.zzd(r3)     // Catch:{ all -> 0x003f }
            if (r1 == 0) goto L_0x003d
        L_0x002b:
            int r1 = r5.zzr     // Catch:{ all -> 0x003f }
            boolean r1 = com.google.android.gms.internal.ads.zzfpj.zza(r1)     // Catch:{ all -> 0x003f }
            if (r1 == 0) goto L_0x003d
            java.util.concurrent.Executor r1 = r5.zzi     // Catch:{ all -> 0x003f }
            com.google.android.gms.internal.ads.zzaug r2 = new com.google.android.gms.internal.ads.zzaug     // Catch:{ all -> 0x003f }
            r2.<init>(r5)     // Catch:{ all -> 0x003f }
            r1.execute(r2)     // Catch:{ all -> 0x003f }
        L_0x003d:
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            return
        L_0x003f:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            throw r1
        L_0x0042:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzauh.zzp():void");
    }

    public final synchronized boolean zzr() {
        return this.zzq;
    }
}
