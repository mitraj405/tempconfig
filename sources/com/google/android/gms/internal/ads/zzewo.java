package com.google.android.gms.internal.ads;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzewo implements zzevo {
    private final Context zza;
    private final ScheduledExecutorService zzb;
    private final Executor zzc;
    private final int zzd;
    private final boolean zze;
    private final boolean zzf;
    private final zzbyv zzg;

    public zzewo(zzbyv zzbyv, Context context, ScheduledExecutorService scheduledExecutorService, Executor executor, int i, boolean z, boolean z2) {
        this.zzg = zzbyv;
        this.zza = context;
        this.zzb = scheduledExecutorService;
        this.zzc = executor;
        this.zzd = i;
        this.zze = z;
        this.zzf = z2;
    }

    public final int zza() {
        return 40;
    }

    public final ListenableFuture zzb() {
        if (!((Boolean) zzba.zzc().zza(zzbbw.zzaL)).booleanValue()) {
            return zzgcj.zzg(new Exception("Did not ad Ad ID into query param."));
        }
        return zzgcj.zze((zzgca) zzgcj.zzo(zzgcj.zzm(zzgca.zzu(this.zzg.zza(this.zza, this.zzd)), new zzewm(this), this.zzc), ((Long) zzba.zzc().zza(zzbbw.zzaM)).longValue(), TimeUnit.MILLISECONDS, this.zzb), Throwable.class, new zzewn(this), this.zzc);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x005e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0061, code lost:
        com.google.android.gms.ads.internal.zzu.zzo().zzw(r0, "AdIdInfoSignalSource.getPaidV1");
        r0 = new com.google.android.gms.internal.ads.zzfry();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0019, code lost:
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(com.google.android.gms.internal.ads.zzbbw.zzcL)).booleanValue() == false) goto L_0x001b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x002f, code lost:
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(com.google.android.gms.internal.ads.zzbbw.zzcM)).booleanValue() != false) goto L_0x0031;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        r1 = com.google.android.gms.internal.ads.zzfsb.zzj(r7.zza);
        java.util.Objects.requireNonNull(r8);
        r2 = r8.getId();
        java.util.Objects.requireNonNull(r2);
        r0 = r1.zzi(r2, r7.zza.getPackageName(), ((java.lang.Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(com.google.android.gms.internal.ads.zzbbw.zzcR)).longValue(), r7.zzf);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ com.google.android.gms.internal.ads.zzewp zzc(com.google.android.gms.ads.identifier.AdvertisingIdClient.Info r8) {
        /*
            r7 = this;
            com.google.android.gms.internal.ads.zzfry r0 = new com.google.android.gms.internal.ads.zzfry
            r0.<init>()
            boolean r1 = r7.zze
            if (r1 != 0) goto L_0x001b
            com.google.android.gms.internal.ads.zzbbn r1 = com.google.android.gms.internal.ads.zzbbw.zzcL
            com.google.android.gms.internal.ads.zzbbu r2 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r1 = r2.zza(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L_0x0031
        L_0x001b:
            boolean r1 = r7.zze
            if (r1 == 0) goto L_0x006f
            com.google.android.gms.internal.ads.zzbbn r1 = com.google.android.gms.internal.ads.zzbbw.zzcM
            com.google.android.gms.internal.ads.zzbbu r2 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r1 = r2.zza(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x006f
        L_0x0031:
            android.content.Context r0 = r7.zza     // Catch:{ IOException -> 0x0060, IllegalArgumentException -> 0x005e }
            com.google.android.gms.internal.ads.zzfsb r1 = com.google.android.gms.internal.ads.zzfsb.zzj(r0)     // Catch:{ IOException -> 0x0060, IllegalArgumentException -> 0x005e }
            java.util.Objects.requireNonNull(r8)     // Catch:{ IOException -> 0x0060, IllegalArgumentException -> 0x005e }
            java.lang.String r2 = r8.getId()     // Catch:{ IOException -> 0x0060, IllegalArgumentException -> 0x005e }
            java.util.Objects.requireNonNull(r2)     // Catch:{ IOException -> 0x0060, IllegalArgumentException -> 0x005e }
            android.content.Context r0 = r7.zza     // Catch:{ IOException -> 0x0060, IllegalArgumentException -> 0x005e }
            java.lang.String r3 = r0.getPackageName()     // Catch:{ IOException -> 0x0060, IllegalArgumentException -> 0x005e }
            com.google.android.gms.internal.ads.zzbbn r0 = com.google.android.gms.internal.ads.zzbbw.zzcR     // Catch:{ IOException -> 0x0060, IllegalArgumentException -> 0x005e }
            com.google.android.gms.internal.ads.zzbbu r4 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ IOException -> 0x0060, IllegalArgumentException -> 0x005e }
            java.lang.Object r0 = r4.zza(r0)     // Catch:{ IOException -> 0x0060, IllegalArgumentException -> 0x005e }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ IOException -> 0x0060, IllegalArgumentException -> 0x005e }
            long r4 = r0.longValue()     // Catch:{ IOException -> 0x0060, IllegalArgumentException -> 0x005e }
            boolean r6 = r7.zzf     // Catch:{ IOException -> 0x0060, IllegalArgumentException -> 0x005e }
            com.google.android.gms.internal.ads.zzfry r0 = r1.zzi(r2, r3, r4, r6)     // Catch:{ IOException -> 0x0060, IllegalArgumentException -> 0x005e }
            goto L_0x006f
        L_0x005e:
            r0 = move-exception
            goto L_0x0061
        L_0x0060:
            r0 = move-exception
        L_0x0061:
            java.lang.String r1 = "AdIdInfoSignalSource.getPaidV1"
            com.google.android.gms.internal.ads.zzbze r2 = com.google.android.gms.ads.internal.zzu.zzo()
            r2.zzw(r0, r1)
            com.google.android.gms.internal.ads.zzfry r0 = new com.google.android.gms.internal.ads.zzfry
            r0.<init>()
        L_0x006f:
            com.google.android.gms.internal.ads.zzewp r1 = new com.google.android.gms.internal.ads.zzewp
            r2 = 0
            r1.<init>(r8, r2, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzewo.zzc(com.google.android.gms.ads.identifier.AdvertisingIdClient$Info):com.google.android.gms.internal.ads.zzewp");
    }

    public final /* synthetic */ zzewp zzd(Throwable th) {
        String str;
        zzay.zzb();
        ContentResolver contentResolver = this.zza.getContentResolver();
        if (contentResolver == null) {
            str = null;
        } else {
            str = Settings.Secure.getString(contentResolver, "android_id");
        }
        return new zzewp((AdvertisingIdClient.Info) null, str, new zzfry());
    }
}
