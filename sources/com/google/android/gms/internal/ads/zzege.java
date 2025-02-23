package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzege implements zzeez {
    private final Context zza;
    private final zzcql zzb;
    /* access modifiers changed from: private */
    public View zzc;
    /* access modifiers changed from: private */
    public zzbov zzd;

    public zzege(Context context, zzcql zzcql) {
        this.zza = context;
        this.zzb = zzcql;
    }

    public final /* bridge */ /* synthetic */ Object zza(zzfex zzfex, zzfel zzfel, zzeew zzeew) throws zzffn, zzeir {
        View view;
        if (!((Boolean) zzba.zzc().zza(zzbbw.zzgZ)).booleanValue() || !zzfel.zzag) {
            view = this.zzc;
        } else {
            try {
                view = (View) ObjectWrapper.unwrap(this.zzd.zze());
                boolean zzf = this.zzd.zzf();
                if (view == null) {
                    throw new zzffn(new Exception("BannerRtbAdapterWrapper interscrollerView should not be null"));
                } else if (zzf) {
                    try {
                        view = (View) zzgcj.zzn(zzgcj.zzh((Object) null), new zzegb(this, view, zzfel), zzbzo.zze).get();
                    } catch (InterruptedException | ExecutionException e) {
                        throw new zzffn(e);
                    }
                }
            } catch (RemoteException e2) {
                throw new zzffn(e2);
            }
        }
        zzcpl zza2 = this.zzb.zza(new zzcsk(zzfex, zzfel, zzeew.zza), new zzcpr(view, (zzcej) null, new zzega(zzeew), (zzfem) zzfel.zzu.get(0)));
        zza2.zzg().zza(view);
        ((zzegp) zzeew.zzc).zzc(zza2.zzj());
        return zza2.zza();
    }

    public final void zzb(zzfex zzfex, zzfel zzfel, zzeew zzeew) throws zzffn {
        try {
            ((zzbql) zzeew.zzb).zzq(zzfel.zzZ);
            if (!((Boolean) zzba.zzc().zza(zzbbw.zzgZ)).booleanValue() || !zzfel.zzag) {
                ((zzbql) zzeew.zzb).zzj(zzfel.zzU, zzfel.zzv.toString(), zzfex.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzegd(this, zzeew, (zzegc) null), (zzbos) zzeew.zzc, zzfex.zza.zza.zze);
            } else {
                ((zzbql) zzeew.zzb).zzk(zzfel.zzU, zzfel.zzv.toString(), zzfex.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzegd(this, zzeew, (zzegc) null), (zzbos) zzeew.zzc, zzfex.zza.zza.zze);
            }
        } catch (RemoteException e) {
            throw new zzffn(e);
        }
    }

    public final /* synthetic */ ListenableFuture zzc(View view, zzfel zzfel, Object obj) throws Exception {
        return zzgcj.zzh(zzcrg.zza(this.zza, view, zzfel));
    }
}
