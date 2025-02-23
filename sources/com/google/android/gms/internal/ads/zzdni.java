package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.ads.internal.client.zzdq;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.ads.nativead.NativeCustomFormatAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdni extends zzbfw {
    private final Context zza;
    private final zzdjb zzb;
    private zzdkb zzc;
    /* access modifiers changed from: private */
    public zzdiw zzd;

    public zzdni(Context context, zzdjb zzdjb, zzdkb zzdkb, zzdiw zzdiw) {
        this.zza = context;
        this.zzb = zzdjb;
        this.zzc = zzdkb;
        this.zzd = zzdiw;
    }

    private final zzber zzd(String str) {
        return new zzdnh(this, NativeCustomFormatAd.ASSET_NAME_VIDEO);
    }

    public final zzdq zze() {
        return this.zzb.zzj();
    }

    public final zzbfa zzf() throws RemoteException {
        try {
            return this.zzd.zzc().zza();
        } catch (NullPointerException e) {
            zzu.zzo().zzw(e, "InternalNativeCustomTemplateAdShim.getMediaContent");
            return null;
        }
    }

    public final zzbfd zzg(String str) {
        return (zzbfd) this.zzb.zzh().get(str);
    }

    public final IObjectWrapper zzh() {
        return ObjectWrapper.wrap(this.zza);
    }

    public final String zzi() {
        return this.zzb.zzA();
    }

    public final String zzj(String str) {
        return (String) this.zzb.zzi().get(str);
    }

    public final List zzk() {
        try {
            SimpleArrayMap zzh = this.zzb.zzh();
            SimpleArrayMap zzi = this.zzb.zzi();
            String[] strArr = new String[(zzh.size() + zzi.size())];
            int i = 0;
            for (int i2 = 0; i2 < zzh.size(); i2++) {
                strArr[i] = (String) zzh.h(i2);
                i++;
            }
            for (int i3 = 0; i3 < zzi.size(); i3++) {
                strArr[i] = (String) zzi.h(i3);
                i++;
            }
            return Arrays.asList(strArr);
        } catch (NullPointerException e) {
            zzu.zzo().zzw(e, "InternalNativeCustomTemplateAdShim.getAvailableAssetNames");
            return new ArrayList();
        }
    }

    public final void zzl() {
        zzdiw zzdiw = this.zzd;
        if (zzdiw != null) {
            zzdiw.zzb();
        }
        this.zzd = null;
        this.zzc = null;
    }

    public final void zzm() {
        try {
            String zzC = this.zzb.zzC();
            if (Objects.equals(zzC, "Google")) {
                zzm.zzj("Illegal argument specified for omid partner name.");
            } else if (TextUtils.isEmpty(zzC)) {
                zzm.zzj("Not starting OMID session. OM partner name has not been configured.");
            } else {
                zzdiw zzdiw = this.zzd;
                if (zzdiw != null) {
                    zzdiw.zzf(zzC, false);
                }
            }
        } catch (NullPointerException e) {
            zzu.zzo().zzw(e, "InternalNativeCustomTemplateAdShim.initializeDisplayOpenMeasurement");
        }
    }

    public final void zzn(String str) {
        zzdiw zzdiw = this.zzd;
        if (zzdiw != null) {
            zzdiw.zzF(str);
        }
    }

    public final void zzo() {
        zzdiw zzdiw = this.zzd;
        if (zzdiw != null) {
            zzdiw.zzI();
        }
    }

    public final void zzp(IObjectWrapper iObjectWrapper) {
        zzdiw zzdiw;
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if ((unwrap instanceof View) && this.zzb.zzu() != null && (zzdiw = this.zzd) != null) {
            zzdiw.zzJ((View) unwrap);
        }
    }

    public final boolean zzq() {
        zzdiw zzdiw = this.zzd;
        if ((zzdiw == null || zzdiw.zzW()) && this.zzb.zzr() != null && this.zzb.zzs() == null) {
            return true;
        }
        return false;
    }

    public final boolean zzr(IObjectWrapper iObjectWrapper) {
        zzdkb zzdkb;
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (!(unwrap instanceof ViewGroup) || (zzdkb = this.zzc) == null || !zzdkb.zzf((ViewGroup) unwrap)) {
            return false;
        }
        this.zzb.zzq().zzar(zzd(NativeCustomFormatAd.ASSET_NAME_VIDEO));
        return true;
    }

    public final boolean zzs(IObjectWrapper iObjectWrapper) {
        zzdkb zzdkb;
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (!(unwrap instanceof ViewGroup) || (zzdkb = this.zzc) == null || !zzdkb.zzg((ViewGroup) unwrap)) {
            return false;
        }
        this.zzb.zzs().zzar(zzd(NativeCustomFormatAd.ASSET_NAME_VIDEO));
        return true;
    }

    public final boolean zzt() {
        zzeeo zzu = this.zzb.zzu();
        if (zzu != null) {
            zzu.zzA().zzk(zzu.zza());
            if (this.zzb.zzr() == null) {
                return true;
            }
            this.zzb.zzr().zzd("onSdkLoaded", new ArrayMap());
            return true;
        }
        zzm.zzj("Trying to start OMID session before creation.");
        return false;
    }
}
