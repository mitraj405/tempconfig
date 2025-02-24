package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzeud implements zzevo {
    private final Context zza;
    private final zzgcu zzb;
    private final zzffg zzc;
    private final VersionInfoParcel zzd;

    public zzeud(Context context, zzgcu zzgcu, zzffg zzffg, VersionInfoParcel versionInfoParcel) {
        this.zza = context;
        this.zzb = zzgcu;
        this.zzc = zzffg;
        this.zzd = versionInfoParcel;
    }

    public final int zza() {
        return 53;
    }

    public final ListenableFuture zzb() {
        return this.zzb.zzb(new zzeuc(this));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0054, code lost:
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(com.google.android.gms.internal.ads.zzbbw.zzcG)).booleanValue() != false) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0056, code lost:
        r1 = com.google.android.gms.internal.ads.zzfsb.zzj(r0).zzh(((java.lang.Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(com.google.android.gms.internal.ads.zzbbw.zzcR)).longValue(), com.google.android.gms.ads.internal.zzu.zzo().zzi().zzS());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00bb, code lost:
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(com.google.android.gms.internal.ads.zzbbw.zzcF)).booleanValue() == false) goto L_0x00bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00cf, code lost:
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(com.google.android.gms.internal.ads.zzbbw.zzcH)).booleanValue() != false) goto L_0x00d1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00d1, code lost:
        r0 = com.google.android.gms.internal.ads.zzfsc.zzi(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00e9, code lost:
        if (r8.zzd.clientJarVersion < ((java.lang.Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(com.google.android.gms.internal.ads.zzbbw.zzcN)).intValue()) goto L_0x010f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00eb, code lost:
        r2 = r0.zzh(((java.lang.Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(com.google.android.gms.internal.ads.zzbbw.zzcS)).longValue(), com.google.android.gms.ads.internal.zzu.zzo().zzi().zzS());
        r3 = r0.zzo();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x010f, code lost:
        r6 = r0.zzp();
        r4 = r2;
        r5 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0040, code lost:
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(com.google.android.gms.internal.ads.zzbbw.zzcE)).booleanValue() == false) goto L_0x0042;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ com.google.android.gms.internal.ads.zzeue zzc() throws java.lang.Exception {
        /*
            r8 = this;
            android.content.Context r0 = r8.zza     // Catch:{ IOException -> 0x0122 }
            com.google.android.gms.internal.ads.zzffg r1 = r8.zzc     // Catch:{ IOException -> 0x0122 }
            boolean r7 = r1.zzb()     // Catch:{ IOException -> 0x0122 }
            com.google.android.gms.internal.ads.zzfry r1 = new com.google.android.gms.internal.ads.zzfry     // Catch:{ IOException -> 0x0122 }
            r1.<init>()     // Catch:{ IOException -> 0x0122 }
            com.google.android.gms.internal.ads.zzfry r2 = new com.google.android.gms.internal.ads.zzfry     // Catch:{ IOException -> 0x0122 }
            r2.<init>()     // Catch:{ IOException -> 0x0122 }
            r3 = 1
            if (r7 == 0) goto L_0x002e
            com.google.android.gms.internal.ads.zzbbn r4 = com.google.android.gms.internal.ads.zzbbw.zzcI     // Catch:{ IOException -> 0x0122 }
            com.google.android.gms.internal.ads.zzbbu r5 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ IOException -> 0x0122 }
            java.lang.Object r4 = r5.zza(r4)     // Catch:{ IOException -> 0x0122 }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ IOException -> 0x0122 }
            boolean r4 = r4.booleanValue()     // Catch:{ IOException -> 0x0122 }
            if (r4 != 0) goto L_0x002e
            com.google.android.gms.internal.ads.zzeue r0 = new com.google.android.gms.internal.ads.zzeue     // Catch:{ IOException -> 0x0122 }
            r0.<init>(r3)     // Catch:{ IOException -> 0x0122 }
            goto L_0x0121
        L_0x002e:
            if (r7 != 0) goto L_0x0042
            com.google.android.gms.internal.ads.zzbbn r4 = com.google.android.gms.internal.ads.zzbbw.zzcE     // Catch:{ IOException -> 0x0122 }
            com.google.android.gms.internal.ads.zzbbu r5 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ IOException -> 0x0122 }
            java.lang.Object r4 = r5.zza(r4)     // Catch:{ IOException -> 0x0122 }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ IOException -> 0x0122 }
            boolean r4 = r4.booleanValue()     // Catch:{ IOException -> 0x0122 }
            if (r4 != 0) goto L_0x0056
        L_0x0042:
            if (r7 == 0) goto L_0x007a
            com.google.android.gms.internal.ads.zzbbn r4 = com.google.android.gms.internal.ads.zzbbw.zzcG     // Catch:{ IOException -> 0x0122 }
            com.google.android.gms.internal.ads.zzbbu r5 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ IOException -> 0x0122 }
            java.lang.Object r4 = r5.zza(r4)     // Catch:{ IOException -> 0x0122 }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ IOException -> 0x0122 }
            boolean r4 = r4.booleanValue()     // Catch:{ IOException -> 0x0122 }
            if (r4 == 0) goto L_0x007a
        L_0x0056:
            com.google.android.gms.internal.ads.zzfsb r1 = com.google.android.gms.internal.ads.zzfsb.zzj(r0)     // Catch:{ IOException -> 0x0122 }
            com.google.android.gms.internal.ads.zzbbn r4 = com.google.android.gms.internal.ads.zzbbw.zzcR     // Catch:{ IOException -> 0x0122 }
            com.google.android.gms.internal.ads.zzbbu r5 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ IOException -> 0x0122 }
            java.lang.Object r4 = r5.zza(r4)     // Catch:{ IOException -> 0x0122 }
            java.lang.Long r4 = (java.lang.Long) r4     // Catch:{ IOException -> 0x0122 }
            long r4 = r4.longValue()     // Catch:{ IOException -> 0x0122 }
            com.google.android.gms.internal.ads.zzbze r6 = com.google.android.gms.ads.internal.zzu.zzo()     // Catch:{ IOException -> 0x0122 }
            com.google.android.gms.ads.internal.util.zzg r6 = r6.zzi()     // Catch:{ IOException -> 0x0122 }
            boolean r6 = r6.zzS()     // Catch:{ IOException -> 0x0122 }
            com.google.android.gms.internal.ads.zzfry r1 = r1.zzh(r4, r6)     // Catch:{ IOException -> 0x0122 }
        L_0x007a:
            com.google.android.gms.internal.ads.zzbbn r4 = com.google.android.gms.internal.ads.zzbbw.zzcO     // Catch:{ IOException -> 0x0122 }
            com.google.android.gms.internal.ads.zzbbu r5 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ IOException -> 0x0122 }
            java.lang.Object r4 = r5.zza(r4)     // Catch:{ IOException -> 0x0122 }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ IOException -> 0x0122 }
            boolean r4 = r4.booleanValue()     // Catch:{ IOException -> 0x0122 }
            if (r4 == 0) goto L_0x00a9
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r4 = r8.zzd     // Catch:{ IOException -> 0x0122 }
            int r4 = r4.clientJarVersion     // Catch:{ IOException -> 0x0122 }
            com.google.android.gms.internal.ads.zzbbn r5 = com.google.android.gms.internal.ads.zzbbw.zzcN     // Catch:{ IOException -> 0x0122 }
            com.google.android.gms.internal.ads.zzbbu r6 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ IOException -> 0x0122 }
            java.lang.Object r5 = r6.zza(r5)     // Catch:{ IOException -> 0x0122 }
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch:{ IOException -> 0x0122 }
            int r5 = r5.intValue()     // Catch:{ IOException -> 0x0122 }
            if (r4 >= r5) goto L_0x00a9
            com.google.android.gms.internal.ads.zzfsc r4 = com.google.android.gms.internal.ads.zzfsc.zzi(r0)     // Catch:{ IOException -> 0x0122 }
            r4.zzj()     // Catch:{ IOException -> 0x0122 }
        L_0x00a9:
            if (r7 != 0) goto L_0x00bd
            com.google.android.gms.internal.ads.zzbbn r4 = com.google.android.gms.internal.ads.zzbbw.zzcF     // Catch:{ IOException -> 0x0122 }
            com.google.android.gms.internal.ads.zzbbu r5 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ IOException -> 0x0122 }
            java.lang.Object r4 = r5.zza(r4)     // Catch:{ IOException -> 0x0122 }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ IOException -> 0x0122 }
            boolean r4 = r4.booleanValue()     // Catch:{ IOException -> 0x0122 }
            if (r4 != 0) goto L_0x00d1
        L_0x00bd:
            if (r7 == 0) goto L_0x0117
            com.google.android.gms.internal.ads.zzbbn r4 = com.google.android.gms.internal.ads.zzbbw.zzcH     // Catch:{ IOException -> 0x0122 }
            com.google.android.gms.internal.ads.zzbbu r5 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ IOException -> 0x0122 }
            java.lang.Object r4 = r5.zza(r4)     // Catch:{ IOException -> 0x0122 }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ IOException -> 0x0122 }
            boolean r4 = r4.booleanValue()     // Catch:{ IOException -> 0x0122 }
            if (r4 == 0) goto L_0x0117
        L_0x00d1:
            com.google.android.gms.internal.ads.zzfsc r0 = com.google.android.gms.internal.ads.zzfsc.zzi(r0)     // Catch:{ IOException -> 0x0122 }
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r4 = r8.zzd     // Catch:{ IOException -> 0x0122 }
            int r4 = r4.clientJarVersion     // Catch:{ IOException -> 0x0122 }
            com.google.android.gms.internal.ads.zzbbn r5 = com.google.android.gms.internal.ads.zzbbw.zzcN     // Catch:{ IOException -> 0x0122 }
            com.google.android.gms.internal.ads.zzbbu r6 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ IOException -> 0x0122 }
            java.lang.Object r5 = r6.zza(r5)     // Catch:{ IOException -> 0x0122 }
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch:{ IOException -> 0x0122 }
            int r5 = r5.intValue()     // Catch:{ IOException -> 0x0122 }
            if (r4 < r5) goto L_0x010f
            com.google.android.gms.internal.ads.zzbbn r2 = com.google.android.gms.internal.ads.zzbbw.zzcS     // Catch:{ IOException -> 0x0122 }
            com.google.android.gms.internal.ads.zzbbu r3 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ IOException -> 0x0122 }
            java.lang.Object r2 = r3.zza(r2)     // Catch:{ IOException -> 0x0122 }
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ IOException -> 0x0122 }
            long r2 = r2.longValue()     // Catch:{ IOException -> 0x0122 }
            com.google.android.gms.internal.ads.zzbze r4 = com.google.android.gms.ads.internal.zzu.zzo()     // Catch:{ IOException -> 0x0122 }
            com.google.android.gms.ads.internal.util.zzg r4 = r4.zzi()     // Catch:{ IOException -> 0x0122 }
            boolean r4 = r4.zzS()     // Catch:{ IOException -> 0x0122 }
            com.google.android.gms.internal.ads.zzfry r2 = r0.zzh(r2, r4)     // Catch:{ IOException -> 0x0122 }
            boolean r3 = r0.zzo()     // Catch:{ IOException -> 0x0122 }
        L_0x010f:
            boolean r0 = r0.zzp()     // Catch:{ IOException -> 0x0122 }
            r6 = r0
            r4 = r2
            r5 = r3
            goto L_0x011a
        L_0x0117:
            r4 = r2
            r5 = r3
            r6 = r5
        L_0x011a:
            com.google.android.gms.internal.ads.zzeue r0 = new com.google.android.gms.internal.ads.zzeue     // Catch:{ IOException -> 0x0122 }
            r2 = r0
            r3 = r1
            r2.<init>(r3, r4, r5, r6, r7)     // Catch:{ IOException -> 0x0122 }
        L_0x0121:
            return r0
        L_0x0122:
            r0 = move-exception
            java.lang.String r1 = "PerAppIdSignal"
            com.google.android.gms.internal.ads.zzbze r2 = com.google.android.gms.ads.internal.zzu.zzo()
            r2.zzw(r0, r1)
            com.google.android.gms.internal.ads.zzffg r0 = r8.zzc
            com.google.android.gms.internal.ads.zzeue r1 = new com.google.android.gms.internal.ads.zzeue
            boolean r0 = r0.zzb()
            r1.<init>(r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeud.zzc():com.google.android.gms.internal.ads.zzeue");
    }
}
