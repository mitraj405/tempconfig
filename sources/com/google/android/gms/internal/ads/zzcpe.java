package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzcpe extends zzcru {
    private final zzcej zzc;
    private final int zzd;
    private final Context zze;
    private final zzcos zzf;
    private final zzdgx zzg;
    private final zzddu zzh;
    private final zzcxd zzi;
    private final boolean zzj;
    private final zzbzi zzk;
    private boolean zzl = false;

    public zzcpe(zzcrt zzcrt, Context context, zzcej zzcej, int i, zzcos zzcos, zzdgx zzdgx, zzddu zzddu, zzcxd zzcxd, zzbzi zzbzi) {
        super(zzcrt);
        this.zzc = zzcej;
        this.zze = context;
        this.zzd = i;
        this.zzf = zzcos;
        this.zzg = zzdgx;
        this.zzh = zzddu;
        this.zzi = zzcxd;
        this.zzj = ((Boolean) zzba.zzc().zza(zzbbw.zzeM)).booleanValue();
        this.zzk = zzbzi;
    }

    public final int zza() {
        return this.zzd;
    }

    public final void zzb() {
        super.zzb();
        zzcej zzcej = this.zzc;
        if (zzcej != null) {
            zzcej.destroy();
        }
    }

    public final void zzc(zzazj zzazj) {
        zzcej zzcej = this.zzc;
        if (zzcej != null) {
            zzcej.zzak(zzazj);
        }
    }

    /* JADX WARNING: type inference failed for: r3v13, types: [android.content.Context] */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzd(android.app.Activity r3, com.google.android.gms.internal.ads.zzazw r4, boolean r5) throws android.os.RemoteException {
        /*
            r2 = this;
            if (r3 != 0) goto L_0x0004
            android.content.Context r3 = r2.zze
        L_0x0004:
            boolean r4 = r2.zzj
            if (r4 == 0) goto L_0x000d
            com.google.android.gms.internal.ads.zzddu r4 = r2.zzh
            r4.zzb()
        L_0x000d:
            com.google.android.gms.internal.ads.zzbbn r4 = com.google.android.gms.internal.ads.zzbbw.zzat
            com.google.android.gms.internal.ads.zzbbu r0 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r4 = r0.zza(r4)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x0061
            com.google.android.gms.ads.internal.zzu.zzp()
            boolean r4 = com.google.android.gms.ads.internal.util.zzt.zzG(r3)
            if (r4 == 0) goto L_0x0061
            java.lang.String r4 = "Interstitials that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit  https://googlemobileadssdk.page.link/admob-interstitial-policies"
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r4)
            com.google.android.gms.internal.ads.zzcxd r4 = r2.zzi
            r4.zzb()
            com.google.android.gms.internal.ads.zzbbn r4 = com.google.android.gms.internal.ads.zzbbw.zzau
            com.google.android.gms.internal.ads.zzbbu r5 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r4 = r5.zza(r4)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x00d2
            com.google.android.gms.internal.ads.zzfos r4 = new com.google.android.gms.internal.ads.zzfos
            android.content.Context r3 = r3.getApplicationContext()
            com.google.android.gms.ads.internal.util.zzbt r5 = com.google.android.gms.ads.internal.zzu.zzt()
            android.os.Looper r5 = r5.zzb()
            r4.<init>(r3, r5)
            com.google.android.gms.internal.ads.zzfex r3 = r2.zza
            com.google.android.gms.internal.ads.zzfew r3 = r3.zzb
            com.google.android.gms.internal.ads.zzfeo r3 = r3.zzb
            java.lang.String r3 = r3.zzb
            r4.zza(r3)
            return
        L_0x0061:
            com.google.android.gms.internal.ads.zzbbn r4 = com.google.android.gms.internal.ads.zzbbw.zzkU
            com.google.android.gms.internal.ads.zzbbu r0 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r4 = r0.zza(r4)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            r0 = 0
            if (r4 == 0) goto L_0x00a0
            com.google.android.gms.internal.ads.zzcej r4 = r2.zzc
            if (r4 == 0) goto L_0x00a0
            com.google.android.gms.internal.ads.zzfel r4 = r4.zzD()
            if (r4 == 0) goto L_0x00a0
            boolean r1 = r4.zzar
            if (r1 == 0) goto L_0x00a0
            int r4 = r4.zzas
            com.google.android.gms.internal.ads.zzbzi r1 = r2.zzk
            int r1 = r1.zzb()
            if (r4 != r1) goto L_0x008d
            goto L_0x00a0
        L_0x008d:
            java.lang.String r3 = "The app open consent form has been shown."
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r3)
            com.google.android.gms.internal.ads.zzcxd r3 = r2.zzi
            r4 = 12
            java.lang.String r5 = "The consent form has already been shown."
            com.google.android.gms.ads.internal.client.zze r4 = com.google.android.gms.internal.ads.zzfgi.zzd(r4, r5, r0)
            r3.zza(r4)
            return
        L_0x00a0:
            boolean r4 = r2.zzl
            if (r4 == 0) goto L_0x00b4
            java.lang.String r4 = "App open interstitial ad is already visible."
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r4)
            com.google.android.gms.internal.ads.zzcxd r4 = r2.zzi
            r1 = 10
            com.google.android.gms.ads.internal.client.zze r0 = com.google.android.gms.internal.ads.zzfgi.zzd(r1, r0, r0)
            r4.zza(r0)
        L_0x00b4:
            boolean r4 = r2.zzl
            if (r4 != 0) goto L_0x00d2
            com.google.android.gms.internal.ads.zzdgx r4 = r2.zzg     // Catch:{ zzdgw -> 0x00cc }
            com.google.android.gms.internal.ads.zzcxd r0 = r2.zzi     // Catch:{ zzdgw -> 0x00cc }
            r4.zza(r5, r3, r0)     // Catch:{ zzdgw -> 0x00cc }
            boolean r3 = r2.zzj     // Catch:{ zzdgw -> 0x00cc }
            if (r3 == 0) goto L_0x00c8
            com.google.android.gms.internal.ads.zzddu r3 = r2.zzh     // Catch:{ zzdgw -> 0x00cc }
            r3.zza()     // Catch:{ zzdgw -> 0x00cc }
        L_0x00c8:
            r3 = 1
            r2.zzl = r3
            return
        L_0x00cc:
            r3 = move-exception
            com.google.android.gms.internal.ads.zzcxd r4 = r2.zzi
            r4.zzc(r3)
        L_0x00d2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcpe.zzd(android.app.Activity, com.google.android.gms.internal.ads.zzazw, boolean):void");
    }

    public final void zze(long j, int i) {
        this.zzf.zza(j, i);
    }
}
