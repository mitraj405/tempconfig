package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzekf implements zzeet {
    private final zzeev zza;
    private final zzeez zzb;
    private final zzfjl zzc;
    private final zzgcu zzd;

    public zzekf(zzfjl zzfjl, zzgcu zzgcu, zzeev zzeev, zzeez zzeez) {
        this.zzc = zzfjl;
        this.zzd = zzgcu;
        this.zzb = zzeez;
        this.zza = zzeev;
    }

    public static final String zze(String str, int i) {
        return "Error from: " + str + ", code: " + i;
    }

    public final ListenableFuture zza(zzfex zzfex, zzfel zzfel) {
        zzeew zzeew;
        Iterator it = zzfel.zzt.iterator();
        while (true) {
            if (!it.hasNext()) {
                zzeew = null;
                break;
            }
            try {
                zzeew = this.zza.zza((String) it.next(), zzfel.zzv);
                break;
            } catch (zzffn unused) {
            }
        }
        if (zzeew == null) {
            return zzgcj.zzg(new zzehv("Unable to instantiate mediation adapter class."));
        }
        zzbzt zzbzt = new zzbzt();
        zzeew.zzc.zza(new zzeke(this, zzeew, zzbzt));
        if (zzfel.zzM) {
            Bundle bundle = zzfex.zza.zza.zzd.zzm;
            Class<AdMobAdapter> cls = AdMobAdapter.class;
            Bundle bundle2 = bundle.getBundle(cls.getName());
            if (bundle2 == null) {
                bundle2 = new Bundle();
                bundle.putBundle(cls.getName(), bundle2);
            }
            bundle2.putBoolean("render_test_ad_label", true);
        }
        zzfjl zzfjl = this.zzc;
        return zzfiv.zzd(new zzekc(this, zzfex, zzfel, zzeew), this.zzd, zzfjf.ADAPTER_LOAD_AD_SYN, zzfjl).zzb(zzfjf.ADAPTER_LOAD_AD_ACK).zzd(zzbzt).zzb(zzfjf.ADAPTER_WRAP_ADAPTER).zze(new zzekd(this, zzfex, zzfel, zzeew)).zza();
    }

    public final boolean zzb(zzfex zzfex, zzfel zzfel) {
        if (!zzfel.zzt.isEmpty()) {
            return true;
        }
        return false;
    }

    public final /* synthetic */ Object zzc(zzfex zzfex, zzfel zzfel, zzeew zzeew, Void voidR) throws Exception {
        return this.zzb.zza(zzfex, zzfel, zzeew);
    }

    public final /* synthetic */ void zzd(zzfex zzfex, zzfel zzfel, zzeew zzeew) throws Exception {
        this.zzb.zzb(zzfex, zzfel, zzeew);
    }
}
