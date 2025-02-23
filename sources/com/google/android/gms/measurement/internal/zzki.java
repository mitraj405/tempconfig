package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.2 */
final class zzki implements Application.ActivityLifecycleCallbacks {
    private final /* synthetic */ zziv zza;

    public zzki(zziv zziv) {
        this.zza = zziv;
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a5 A[SYNTHETIC, Splitter:B:38:0x00a5] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0104 A[Catch:{ RuntimeException -> 0x0190 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0105 A[Catch:{ RuntimeException -> 0x0190 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void zza(com.google.android.gms.measurement.internal.zzki r17, boolean r18, android.net.Uri r19, java.lang.String r20, java.lang.String r21) {
        /*
            r1 = r17
            r0 = r20
            r2 = r21
            java.lang.String r3 = "https://google.com/search?"
            com.google.android.gms.measurement.internal.zziv r4 = r1.zza
            r4.zzt()
            com.google.android.gms.measurement.internal.zziv r4 = r1.zza     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.zznp r4 = r4.zzq()     // Catch:{ RuntimeException -> 0x0190 }
            boolean r5 = com.google.android.gms.internal.measurement.zzoj.zza()     // Catch:{ RuntimeException -> 0x0190 }
            r6 = 0
            r7 = 1
            if (r5 == 0) goto L_0x002b
            com.google.android.gms.measurement.internal.zziv r5 = r1.zza     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.zzag r5 = r5.zze()     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean> r8 = com.google.android.gms.measurement.internal.zzbf.zzcl     // Catch:{ RuntimeException -> 0x0190 }
            boolean r5 = r5.zza((com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean>) r8)     // Catch:{ RuntimeException -> 0x0190 }
            if (r5 == 0) goto L_0x002b
            r5 = r7
            goto L_0x002c
        L_0x002b:
            r5 = r6
        L_0x002c:
            boolean r8 = android.text.TextUtils.isEmpty(r21)     // Catch:{ RuntimeException -> 0x0190 }
            java.lang.String r9 = "Activity created with data 'referrer' without required params"
            java.lang.String r10 = "utm_medium"
            java.lang.String r11 = "_cis"
            java.lang.String r12 = "utm_source"
            java.lang.String r13 = "utm_campaign"
            java.lang.String r15 = "gclid"
            if (r8 == 0) goto L_0x0040
        L_0x003e:
            r3 = 0
            goto L_0x00a1
        L_0x0040:
            boolean r8 = r2.contains(r15)     // Catch:{ RuntimeException -> 0x0190 }
            if (r8 != 0) goto L_0x008e
            if (r5 == 0) goto L_0x0050
            java.lang.String r8 = "gbraid"
            boolean r8 = r2.contains(r8)     // Catch:{ RuntimeException -> 0x0190 }
            if (r8 != 0) goto L_0x008e
        L_0x0050:
            boolean r8 = r2.contains(r13)     // Catch:{ RuntimeException -> 0x0190 }
            if (r8 != 0) goto L_0x008e
            boolean r8 = r2.contains(r12)     // Catch:{ RuntimeException -> 0x0190 }
            if (r8 != 0) goto L_0x008e
            boolean r8 = r2.contains(r10)     // Catch:{ RuntimeException -> 0x0190 }
            if (r8 != 0) goto L_0x008e
            java.lang.String r8 = "utm_id"
            boolean r8 = r2.contains(r8)     // Catch:{ RuntimeException -> 0x0190 }
            if (r8 != 0) goto L_0x008e
            java.lang.String r8 = "dclid"
            boolean r8 = r2.contains(r8)     // Catch:{ RuntimeException -> 0x0190 }
            if (r8 != 0) goto L_0x008e
            java.lang.String r8 = "srsltid"
            boolean r8 = r2.contains(r8)     // Catch:{ RuntimeException -> 0x0190 }
            if (r8 != 0) goto L_0x008e
            java.lang.String r8 = "sfmc_id"
            boolean r8 = r2.contains(r8)     // Catch:{ RuntimeException -> 0x0190 }
            if (r8 != 0) goto L_0x008e
            com.google.android.gms.measurement.internal.zzfw r3 = r4.zzj()     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.zzfy r3 = r3.zzc()     // Catch:{ RuntimeException -> 0x0190 }
            r3.zza(r9)     // Catch:{ RuntimeException -> 0x0190 }
            goto L_0x003e
        L_0x008e:
            java.lang.String r3 = r3.concat(r2)     // Catch:{ RuntimeException -> 0x0190 }
            android.net.Uri r3 = android.net.Uri.parse(r3)     // Catch:{ RuntimeException -> 0x0190 }
            android.os.Bundle r3 = r4.zza((android.net.Uri) r3, (boolean) r5)     // Catch:{ RuntimeException -> 0x0190 }
            if (r3 == 0) goto L_0x00a1
            java.lang.String r4 = "referrer"
            r3.putString(r11, r4)     // Catch:{ RuntimeException -> 0x0190 }
        L_0x00a1:
            java.lang.String r4 = "_cmp"
            if (r18 == 0) goto L_0x00fe
            com.google.android.gms.measurement.internal.zziv r5 = r1.zza     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.zznp r5 = r5.zzq()     // Catch:{ RuntimeException -> 0x0190 }
            boolean r8 = com.google.android.gms.internal.measurement.zzoj.zza()     // Catch:{ RuntimeException -> 0x0190 }
            if (r8 == 0) goto L_0x00c3
            com.google.android.gms.measurement.internal.zziv r8 = r1.zza     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.zzag r8 = r8.zze()     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean> r14 = com.google.android.gms.measurement.internal.zzbf.zzcl     // Catch:{ RuntimeException -> 0x0190 }
            boolean r8 = r8.zza((com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean>) r14)     // Catch:{ RuntimeException -> 0x0190 }
            if (r8 == 0) goto L_0x00c3
            r8 = r19
            r14 = r7
            goto L_0x00c6
        L_0x00c3:
            r8 = r19
            r14 = r6
        L_0x00c6:
            android.os.Bundle r5 = r5.zza((android.net.Uri) r8, (boolean) r14)     // Catch:{ RuntimeException -> 0x0190 }
            if (r5 == 0) goto L_0x00fe
            java.lang.String r8 = "intent"
            r5.putString(r11, r8)     // Catch:{ RuntimeException -> 0x0190 }
            boolean r8 = r5.containsKey(r15)     // Catch:{ RuntimeException -> 0x0190 }
            if (r8 != 0) goto L_0x00f2
            if (r3 == 0) goto L_0x00f2
            boolean r8 = r3.containsKey(r15)     // Catch:{ RuntimeException -> 0x0190 }
            if (r8 == 0) goto L_0x00f2
            java.lang.String r8 = "_cer"
            java.lang.String r11 = "gclid=%s"
            java.lang.Object[] r14 = new java.lang.Object[r7]     // Catch:{ RuntimeException -> 0x0190 }
            java.lang.String r16 = r3.getString(r15)     // Catch:{ RuntimeException -> 0x0190 }
            r14[r6] = r16     // Catch:{ RuntimeException -> 0x0190 }
            java.lang.String r11 = java.lang.String.format(r11, r14)     // Catch:{ RuntimeException -> 0x0190 }
            r5.putString(r8, r11)     // Catch:{ RuntimeException -> 0x0190 }
        L_0x00f2:
            com.google.android.gms.measurement.internal.zziv r8 = r1.zza     // Catch:{ RuntimeException -> 0x0190 }
            r8.zzc(r0, r4, r5)     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.zziv r8 = r1.zza     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.zzr r8 = r8.zza     // Catch:{ RuntimeException -> 0x0190 }
            r8.zza(r0, r5)     // Catch:{ RuntimeException -> 0x0190 }
        L_0x00fe:
            boolean r5 = android.text.TextUtils.isEmpty(r21)     // Catch:{ RuntimeException -> 0x0190 }
            if (r5 == 0) goto L_0x0105
            return
        L_0x0105:
            com.google.android.gms.measurement.internal.zziv r5 = r1.zza     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.zzfw r5 = r5.zzj()     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.zzfy r5 = r5.zzc()     // Catch:{ RuntimeException -> 0x0190 }
            java.lang.String r8 = "Activity created with referrer"
            r5.zza(r8, r2)     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.zziv r5 = r1.zza     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.zzag r5 = r5.zze()     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean> r8 = com.google.android.gms.measurement.internal.zzbf.zzbl     // Catch:{ RuntimeException -> 0x0190 }
            boolean r5 = r5.zza((com.google.android.gms.measurement.internal.zzfj<java.lang.Boolean>) r8)     // Catch:{ RuntimeException -> 0x0190 }
            java.lang.String r8 = "_ldl"
            java.lang.String r11 = "auto"
            if (r5 == 0) goto L_0x014b
            if (r3 == 0) goto L_0x0135
            com.google.android.gms.measurement.internal.zziv r2 = r1.zza     // Catch:{ RuntimeException -> 0x0190 }
            r2.zzc(r0, r4, r3)     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.zziv r2 = r1.zza     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.zzr r2 = r2.zza     // Catch:{ RuntimeException -> 0x0190 }
            r2.zza(r0, r3)     // Catch:{ RuntimeException -> 0x0190 }
            goto L_0x0144
        L_0x0135:
            com.google.android.gms.measurement.internal.zziv r0 = r1.zza     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.zzfw r0 = r0.zzj()     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.zzfy r0 = r0.zzc()     // Catch:{ RuntimeException -> 0x0190 }
            java.lang.String r3 = "Referrer does not contain valid parameters"
            r0.zza(r3, r2)     // Catch:{ RuntimeException -> 0x0190 }
        L_0x0144:
            com.google.android.gms.measurement.internal.zziv r0 = r1.zza     // Catch:{ RuntimeException -> 0x0190 }
            r2 = 0
            r0.zza((java.lang.String) r11, (java.lang.String) r8, (java.lang.Object) r2, (boolean) r7)     // Catch:{ RuntimeException -> 0x0190 }
            return
        L_0x014b:
            boolean r0 = r2.contains(r15)     // Catch:{ RuntimeException -> 0x0190 }
            if (r0 == 0) goto L_0x0174
            boolean r0 = r2.contains(r13)     // Catch:{ RuntimeException -> 0x0190 }
            if (r0 != 0) goto L_0x0173
            boolean r0 = r2.contains(r12)     // Catch:{ RuntimeException -> 0x0190 }
            if (r0 != 0) goto L_0x0173
            boolean r0 = r2.contains(r10)     // Catch:{ RuntimeException -> 0x0190 }
            if (r0 != 0) goto L_0x0173
            java.lang.String r0 = "utm_term"
            boolean r0 = r2.contains(r0)     // Catch:{ RuntimeException -> 0x0190 }
            if (r0 != 0) goto L_0x0173
            java.lang.String r0 = "utm_content"
            boolean r0 = r2.contains(r0)     // Catch:{ RuntimeException -> 0x0190 }
            if (r0 == 0) goto L_0x0174
        L_0x0173:
            r6 = r7
        L_0x0174:
            if (r6 != 0) goto L_0x0184
            com.google.android.gms.measurement.internal.zziv r0 = r1.zza     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.zzfw r0 = r0.zzj()     // Catch:{ RuntimeException -> 0x0190 }
            com.google.android.gms.measurement.internal.zzfy r0 = r0.zzc()     // Catch:{ RuntimeException -> 0x0190 }
            r0.zza(r9)     // Catch:{ RuntimeException -> 0x0190 }
            return
        L_0x0184:
            boolean r0 = android.text.TextUtils.isEmpty(r21)     // Catch:{ RuntimeException -> 0x0190 }
            if (r0 != 0) goto L_0x018f
            com.google.android.gms.measurement.internal.zziv r0 = r1.zza     // Catch:{ RuntimeException -> 0x0190 }
            r0.zza((java.lang.String) r11, (java.lang.String) r8, (java.lang.Object) r2, (boolean) r7)     // Catch:{ RuntimeException -> 0x0190 }
        L_0x018f:
            return
        L_0x0190:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zziv r1 = r1.zza
            com.google.android.gms.measurement.internal.zzfw r1 = r1.zzj()
            com.google.android.gms.measurement.internal.zzfy r1 = r1.zzg()
            java.lang.String r2 = "Throwable caught in handleReferrerForOnActivityCreated"
            r1.zza(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzki.zza(com.google.android.gms.measurement.internal.zzki, boolean, android.net.Uri, java.lang.String, java.lang.String):void");
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        String str;
        boolean z;
        try {
            this.zza.zzj().zzp().zza("onActivityCreated");
            Intent intent = activity.getIntent();
            if (intent != null) {
                Uri data = intent.getData();
                if (data == null || !data.isHierarchical()) {
                    Bundle extras = intent.getExtras();
                    if (extras != null) {
                        String string = extras.getString("com.android.vending.referral_url");
                        if (!TextUtils.isEmpty(string)) {
                            data = Uri.parse(string);
                        }
                    }
                    data = null;
                }
                Uri uri = data;
                if (uri != null) {
                    if (uri.isHierarchical()) {
                        this.zza.zzq();
                        if (zznp.zza(intent)) {
                            str = "gs";
                        } else {
                            str = "auto";
                        }
                        String str2 = str;
                        String queryParameter = uri.getQueryParameter("referrer");
                        if (bundle == null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        this.zza.zzl().zzb((Runnable) new zzkh(this, z, uri, str2, queryParameter));
                        this.zza.zzn().zza(activity, bundle);
                        return;
                    }
                }
                this.zza.zzn().zza(activity, bundle);
            }
        } catch (RuntimeException e) {
            this.zza.zzj().zzg().zza("Throwable caught in onActivityCreated", e);
        } finally {
            this.zza.zzn().zza(activity, bundle);
        }
    }

    public final void onActivityDestroyed(Activity activity) {
        this.zza.zzn().zza(activity);
    }

    public final void onActivityPaused(Activity activity) {
        this.zza.zzn().zzb(activity);
        zzmh zzp = this.zza.zzp();
        zzp.zzl().zzb((Runnable) new zzmj(zzp, zzp.zzb().elapsedRealtime()));
    }

    public final void onActivityResumed(Activity activity) {
        zzmh zzp = this.zza.zzp();
        zzp.zzl().zzb((Runnable) new zzmk(zzp, zzp.zzb().elapsedRealtime()));
        this.zza.zzn().zzc(activity);
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.zza.zzn().zzb(activity, bundle);
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }
}
