package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzbe;
import com.google.android.gms.ads.internal.util.zzbf;
import com.google.android.gms.ads.internal.util.zzbh;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzu;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzcbl {
    private static final boolean zza;
    private final Context zzb;
    private final String zzc;
    private final VersionInfoParcel zzd;
    private final zzbci zze;
    private final zzbcl zzf;
    private final zzbh zzg;
    private final long[] zzh;
    private final String[] zzi;
    private boolean zzj = false;
    private boolean zzk = false;
    private boolean zzl = false;
    private boolean zzm = false;
    private boolean zzn;
    private zzcaq zzo;
    private boolean zzp;
    private boolean zzq;
    private long zzr = -1;

    static {
        boolean z;
        if (zzay.zze().nextInt(100) < ((Integer) zzba.zzc().zza(zzbbw.zzlK)).intValue()) {
            z = true;
        } else {
            z = false;
        }
        zza = z;
    }

    public zzcbl(Context context, VersionInfoParcel versionInfoParcel, String str, zzbcl zzbcl, zzbci zzbci) {
        zzbf zzbf = new zzbf();
        zzbf zzbf2 = zzbf;
        zzbf2.zza("min_1", Double.MIN_VALUE, 1.0d);
        zzbf2.zza("1_5", 1.0d, 5.0d);
        zzbf2.zza("5_10", 5.0d, 10.0d);
        zzbf2.zza("10_20", 10.0d, 20.0d);
        zzbf2.zza("20_30", 20.0d, 30.0d);
        zzbf2.zza("30_max", 30.0d, Double.MAX_VALUE);
        this.zzg = zzbf.zzb();
        this.zzb = context;
        this.zzd = versionInfoParcel;
        this.zzc = str;
        this.zzf = zzbcl;
        this.zze = zzbci;
        String str2 = (String) zzba.zzc().zza(zzbbw.zzu);
        if (str2 == null) {
            this.zzi = new String[0];
            this.zzh = new long[0];
            return;
        }
        String[] split = TextUtils.split(str2, ",");
        int length = split.length;
        this.zzi = new String[length];
        this.zzh = new long[length];
        for (int i = 0; i < split.length; i++) {
            try {
                this.zzh[i] = Long.parseLong(split[i]);
            } catch (NumberFormatException e) {
                zzm.zzk("Unable to parse frame hash target time number.", e);
                this.zzh[i] = -1;
            }
        }
    }

    public final void zza(zzcaq zzcaq) {
        zzbcd.zza(this.zzf, this.zze, "vpc2");
        this.zzj = true;
        this.zzf.zzd("vpn", zzcaq.zzj());
        this.zzo = zzcaq;
    }

    public final void zzb() {
        if (this.zzj && !this.zzk) {
            zzbcd.zza(this.zzf, this.zze, "vfr2");
            this.zzk = true;
        }
    }

    public final void zzc() {
        this.zzn = true;
        if (this.zzk && !this.zzl) {
            zzbcd.zza(this.zzf, this.zze, "vfp2");
            this.zzl = true;
        }
    }

    public final void zzd() {
        if (zza && !this.zzp) {
            Bundle bundle = new Bundle();
            bundle.putString("type", "native-player-metrics");
            bundle.putString("request", this.zzc);
            bundle.putString("player", this.zzo.zzj());
            for (zzbe zzbe : this.zzg.zza()) {
                String valueOf = String.valueOf(zzbe.zza);
                bundle.putString("fps_c_".concat(valueOf), Integer.toString(zzbe.zze));
                String valueOf2 = String.valueOf(zzbe.zza);
                bundle.putString("fps_p_".concat(valueOf2), Double.toString(zzbe.zzd));
            }
            int i = 0;
            while (true) {
                long[] jArr = this.zzh;
                if (i < jArr.length) {
                    String str = this.zzi[i];
                    if (str != null) {
                        bundle.putString("fh_".concat(Long.valueOf(jArr[i]).toString()), str);
                    }
                    i++;
                } else {
                    zzu.zzp().zzh(this.zzb, this.zzd.afmaVersion, "gmob-apps", bundle, true);
                    this.zzp = true;
                    return;
                }
            }
        }
    }

    public final void zze() {
        this.zzn = false;
    }

    public final void zzf(zzcaq zzcaq) {
        long j;
        if (this.zzl && !this.zzm) {
            if (zze.zzc() && !this.zzm) {
                zze.zza("VideoMetricsMixin first frame");
            }
            zzbcd.zza(this.zzf, this.zze, "vff2");
            this.zzm = true;
        }
        long nanoTime = zzu.zzB().nanoTime();
        if (this.zzn && this.zzq && this.zzr != -1) {
            this.zzg.zzb(((double) TimeUnit.SECONDS.toNanos(1)) / ((double) (nanoTime - this.zzr)));
        }
        this.zzq = this.zzn;
        this.zzr = nanoTime;
        long longValue = ((Long) zzba.zzc().zza(zzbbw.zzv)).longValue();
        long zza2 = (long) zzcaq.zza();
        int i = 0;
        while (true) {
            String[] strArr = this.zzi;
            if (i >= strArr.length) {
                return;
            }
            if (strArr[i] == null && longValue > Math.abs(zza2 - this.zzh[i])) {
                String[] strArr2 = this.zzi;
                int i2 = 8;
                Bitmap bitmap = zzcaq.getBitmap(8, 8);
                long j2 = 63;
                int i3 = 0;
                long j3 = 0;
                while (i3 < i2) {
                    int i4 = 0;
                    while (i4 < i2) {
                        int pixel = bitmap.getPixel(i4, i3);
                        if (Color.green(pixel) + Color.red(pixel) + Color.blue(pixel) > 128) {
                            j = 1;
                        } else {
                            j = 0;
                        }
                        j3 |= j << ((int) j2);
                        j2--;
                        i4++;
                        i2 = 8;
                    }
                    i3++;
                    i2 = 8;
                }
                strArr2[i] = String.format("%016X", new Object[]{Long.valueOf(j3)});
                return;
            }
            zzcaq zzcaq2 = zzcaq;
            i++;
        }
    }
}
