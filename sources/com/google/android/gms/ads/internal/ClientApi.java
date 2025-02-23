package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzbq;
import com.google.android.gms.ads.internal.client.zzbu;
import com.google.android.gms.ads.internal.client.zzcd;
import com.google.android.gms.ads.internal.client.zzco;
import com.google.android.gms.ads.internal.client.zzdj;
import com.google.android.gms.ads.internal.client.zzew;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzad;
import com.google.android.gms.ads.internal.overlay.zzaf;
import com.google.android.gms.ads.internal.overlay.zzag;
import com.google.android.gms.ads.internal.overlay.zzt;
import com.google.android.gms.ads.internal.overlay.zzu;
import com.google.android.gms.ads.internal.overlay.zzz;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbfh;
import com.google.android.gms.internal.ads.zzbfn;
import com.google.android.gms.internal.ads.zzbjw;
import com.google.android.gms.internal.ads.zzbjz;
import com.google.android.gms.internal.ads.zzbom;
import com.google.android.gms.internal.ads.zzbsg;
import com.google.android.gms.internal.ads.zzbsn;
import com.google.android.gms.internal.ads.zzbvq;
import com.google.android.gms.internal.ads.zzbwg;
import com.google.android.gms.internal.ads.zzbym;
import com.google.android.gms.internal.ads.zzcgj;
import com.google.android.gms.internal.ads.zzdjv;
import com.google.android.gms.internal.ads.zzdjx;
import com.google.android.gms.internal.ads.zzdtt;
import com.google.android.gms.internal.ads.zzeln;
import com.google.android.gms.internal.ads.zzezl;
import com.google.android.gms.internal.ads.zzezm;
import com.google.android.gms.internal.ads.zzfaz;
import com.google.android.gms.internal.ads.zzfcq;
import com.google.android.gms.internal.ads.zzfee;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public class ClientApi extends zzcd {
    public final zzbq zzb(IObjectWrapper iObjectWrapper, String str, zzbom zzbom, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        return new zzeln(zzcgj.zzb(context, zzbom, i), context, str);
    }

    public final zzbu zzc(IObjectWrapper iObjectWrapper, zzq zzq, String str, zzbom zzbom, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzezl zzt = zzcgj.zzb(context, zzbom, i).zzt();
        zzt.zza(str);
        zzt.zzb(context);
        zzezm zzc = zzt.zzc();
        if (i >= ((Integer) zzba.zzc().zza(zzbbw.zzeK)).intValue()) {
            return zzc.zza();
        }
        return new zzew();
    }

    public final zzbu zzd(IObjectWrapper iObjectWrapper, zzq zzq, String str, zzbom zzbom, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzfaz zzu = zzcgj.zzb(context, zzbom, i).zzu();
        zzu.zzc(context);
        zzu.zza(zzq);
        zzu.zzb(str);
        return zzu.zzd().zza();
    }

    public final zzbu zze(IObjectWrapper iObjectWrapper, zzq zzq, String str, zzbom zzbom, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzfcq zzv = zzcgj.zzb(context, zzbom, i).zzv();
        zzv.zzc(context);
        zzv.zza(zzq);
        zzv.zzb(str);
        return zzv.zzd().zza();
    }

    public final zzbu zzf(IObjectWrapper iObjectWrapper, zzq zzq, String str, int i) {
        return new zzt((Context) ObjectWrapper.unwrap(iObjectWrapper), zzq, str, new VersionInfoParcel(242402000, i, true, false));
    }

    public final zzco zzg(IObjectWrapper iObjectWrapper, int i) {
        return zzcgj.zzb((Context) ObjectWrapper.unwrap(iObjectWrapper), (zzbom) null, i).zzc();
    }

    public final zzdj zzh(IObjectWrapper iObjectWrapper, zzbom zzbom, int i) {
        return zzcgj.zzb((Context) ObjectWrapper.unwrap(iObjectWrapper), zzbom, i).zzm();
    }

    public final zzbfh zzi(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        return new zzdjx((FrameLayout) ObjectWrapper.unwrap(iObjectWrapper), (FrameLayout) ObjectWrapper.unwrap(iObjectWrapper2), 242402000);
    }

    public final zzbfn zzj(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        return new zzdjv((View) ObjectWrapper.unwrap(iObjectWrapper), (HashMap) ObjectWrapper.unwrap(iObjectWrapper2), (HashMap) ObjectWrapper.unwrap(iObjectWrapper3));
    }

    public final zzbjz zzk(IObjectWrapper iObjectWrapper, zzbom zzbom, int i, zzbjw zzbjw) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzdtt zzk = zzcgj.zzb(context, zzbom, i).zzk();
        zzk.zzb(context);
        zzk.zza(zzbjw);
        return zzk.zzc().zzd();
    }

    public final zzbsg zzl(IObjectWrapper iObjectWrapper, zzbom zzbom, int i) {
        return zzcgj.zzb((Context) ObjectWrapper.unwrap(iObjectWrapper), zzbom, i).zzn();
    }

    public final zzbsn zzm(IObjectWrapper iObjectWrapper) {
        Activity activity = (Activity) ObjectWrapper.unwrap(iObjectWrapper);
        AdOverlayInfoParcel zza = AdOverlayInfoParcel.zza(activity.getIntent());
        if (zza == null) {
            return new zzu(activity);
        }
        int i = zza.zzk;
        if (i == 1) {
            return new zzt(activity);
        }
        if (i == 2) {
            return new zzaf(activity);
        }
        if (i == 3) {
            return new zzag(activity);
        }
        if (i == 4) {
            return new zzz(activity, zza);
        }
        if (i != 5) {
            return new zzu(activity);
        }
        return new zzad(activity);
    }

    public final zzbvq zzn(IObjectWrapper iObjectWrapper, zzbom zzbom, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzfee zzw = zzcgj.zzb(context, zzbom, i).zzw();
        zzw.zzb(context);
        return zzw.zzc().zzb();
    }

    public final zzbwg zzo(IObjectWrapper iObjectWrapper, String str, zzbom zzbom, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzfee zzw = zzcgj.zzb(context, zzbom, i).zzw();
        zzw.zzb(context);
        zzw.zza(str);
        return zzw.zzc().zza();
    }

    public final zzbym zzp(IObjectWrapper iObjectWrapper, zzbom zzbom, int i) {
        return zzcgj.zzb((Context) ObjectWrapper.unwrap(iObjectWrapper), zzbom, i).zzq();
    }
}
