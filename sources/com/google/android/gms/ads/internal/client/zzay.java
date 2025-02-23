package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.internal.ads.zzbhc;
import com.google.android.gms.internal.ads.zzbhd;
import com.google.android.gms.internal.ads.zzbsk;
import com.google.android.gms.internal.ads.zzbws;
import java.util.Random;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
public final class zzay {
    public static final /* synthetic */ int zza = 0;
    private static final zzay zzb = new zzay();
    private final zzf zzc;
    private final zzaw zzd;
    private final String zze;
    private final VersionInfoParcel zzf;
    private final Random zzg;

    public zzay() {
        zzf zzf2 = new zzf();
        zzaw zzaw = new zzaw(new zzk(), new zzi(), new zzeq(), new zzbhc(), new zzbws(), new zzbsk(), new zzbhd());
        String zze2 = zzf.zze();
        VersionInfoParcel versionInfoParcel = new VersionInfoParcel(0, 242402000, true);
        Random random = new Random();
        this.zzc = zzf2;
        this.zzd = zzaw;
        this.zze = zze2;
        this.zzf = versionInfoParcel;
        this.zzg = random;
    }

    public static zzaw zza() {
        return zzb.zzd;
    }

    public static zzf zzb() {
        return zzb.zzc;
    }

    public static VersionInfoParcel zzc() {
        return zzb.zzf;
    }

    public static String zzd() {
        return zzb.zze;
    }

    public static Random zze() {
        return zzb.zzg;
    }
}
