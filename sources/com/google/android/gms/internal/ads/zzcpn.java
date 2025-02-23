package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzbu;
import com.google.android.gms.ads.internal.client.zzdq;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzcpn extends zzcpk {
    private final Context zzc;
    private final View zzd;
    private final zzcej zze;
    private final zzfem zzf;
    private final zzcrs zzg;
    private final zzdjm zzh;
    private final zzdes zzi;
    private final zzhew zzj;
    private final Executor zzk;
    private zzq zzl;

    public zzcpn(zzcrt zzcrt, Context context, zzfem zzfem, View view, zzcej zzcej, zzcrs zzcrs, zzdjm zzdjm, zzdes zzdes, zzhew zzhew, Executor executor) {
        super(zzcrt);
        this.zzc = context;
        this.zzd = view;
        this.zze = zzcej;
        this.zzf = zzfem;
        this.zzg = zzcrs;
        this.zzh = zzdjm;
        this.zzi = zzdes;
        this.zzj = zzhew;
        this.zzk = executor;
    }

    public static /* synthetic */ void zzj(zzcpn zzcpn) {
        zzdjm zzdjm = zzcpn.zzh;
        if (zzdjm.zze() != null) {
            try {
                zzdjm.zze().zze((zzbu) zzcpn.zzj.zzb(), ObjectWrapper.wrap(zzcpn.zzc));
            } catch (RemoteException e) {
                zzm.zzh("RemoteException when notifyAdLoad is called", e);
            }
        }
    }

    public final int zza() {
        return this.zza.zzb.zzb.zzd;
    }

    public final int zzc() {
        if (((Boolean) zzba.zzc().zza(zzbbw.zzgZ)).booleanValue() && this.zzb.zzag) {
            if (!((Boolean) zzba.zzc().zza(zzbbw.zzha)).booleanValue()) {
                return 0;
            }
        }
        return this.zza.zzb.zzb.zzc;
    }

    public final View zzd() {
        return this.zzd;
    }

    public final zzdq zze() {
        try {
            return this.zzg.zza();
        } catch (zzffn unused) {
            return null;
        }
    }

    public final zzfem zzf() {
        zzq zzq = this.zzl;
        if (zzq != null) {
            return zzffm.zzb(zzq);
        }
        zzfel zzfel = this.zzb;
        if (zzfel.zzac) {
            for (String str : zzfel.zza) {
                if (str == null || !str.contains("FirstParty")) {
                }
            }
            View view = this.zzd;
            return new zzfem(view.getWidth(), view.getHeight(), false);
        }
        return (zzfem) this.zzb.zzr.get(0);
    }

    public final zzfem zzg() {
        return this.zzf;
    }

    public final void zzh() {
        this.zzi.zza();
    }

    public final void zzi(ViewGroup viewGroup, zzq zzq) {
        zzcej zzcej;
        if (viewGroup != null && (zzcej = this.zze) != null) {
            zzcej.zzaj(zzcgd.zzc(zzq));
            viewGroup.setMinimumHeight(zzq.zzc);
            viewGroup.setMinimumWidth(zzq.zzf);
            this.zzl = zzq;
        }
    }

    public final void zzk() {
        this.zzk.execute(new zzcpm(this));
        super.zzk();
    }
}
