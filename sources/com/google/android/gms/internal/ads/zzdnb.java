package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import com.google.android.gms.ads.internal.client.zzdq;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdnb extends zzblj implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzbep {
    private View zza;
    private zzdq zzb;
    private zzdiw zzc;
    private boolean zzd = false;
    private boolean zze = false;

    public zzdnb(zzdiw zzdiw, zzdjb zzdjb) {
        this.zza = zzdjb.zzf();
        this.zzb = zzdjb.zzj();
        this.zzc = zzdiw;
        if (zzdjb.zzs() != null) {
            zzdjb.zzs().zzap(this);
        }
    }

    private final void zzg() {
        View view;
        zzdiw zzdiw = this.zzc;
        if (zzdiw != null && (view = this.zza) != null) {
            zzdiw.zzB(view, Collections.emptyMap(), Collections.emptyMap(), zzdiw.zzX(this.zza));
        }
    }

    private final void zzh() {
        View view = this.zza;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.zza);
            }
        }
    }

    private static final void zzi(zzbln zzbln, int i) {
        try {
            zzbln.zze(i);
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void onGlobalLayout() {
        zzg();
    }

    public final void onScrollChanged() {
        zzg();
    }

    public final zzdq zzb() throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (!this.zzd) {
            return this.zzb;
        }
        zzm.zzg("getVideoController: Instream ad should not be used after destroyed");
        return null;
    }

    public final zzbfa zzc() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (this.zzd) {
            zzm.zzg("getVideoController: Instream ad should not be used after destroyed");
            return null;
        }
        zzdiw zzdiw = this.zzc;
        if (zzdiw == null || zzdiw.zzc() == null) {
            return null;
        }
        return zzdiw.zzc().zza();
    }

    public final void zzd() throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzh();
        zzdiw zzdiw = this.zzc;
        if (zzdiw != null) {
            zzdiw.zzb();
        }
        this.zzc = null;
        this.zza = null;
        this.zzb = null;
        this.zzd = true;
    }

    public final void zze(IObjectWrapper iObjectWrapper) throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzf(iObjectWrapper, new zzdna(this));
    }

    public final void zzf(IObjectWrapper iObjectWrapper, zzbln zzbln) throws RemoteException {
        String str;
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (this.zzd) {
            zzm.zzg("Instream ad can not be shown after destroy().");
            zzi(zzbln, 2);
            return;
        }
        View view = this.zza;
        if (view == null || this.zzb == null) {
            if (view == null) {
                str = "can not get video view.";
            } else {
                str = "can not get video controller.";
            }
            zzm.zzg("Instream internal error: ".concat(str));
            zzi(zzbln, 0);
        } else if (this.zze) {
            zzm.zzg("Instream ad should not be used again.");
            zzi(zzbln, 1);
        } else {
            this.zze = true;
            zzh();
            ((ViewGroup) ObjectWrapper.unwrap(iObjectWrapper)).addView(this.zza, new ViewGroup.LayoutParams(-1, -1));
            zzu.zzx();
            zzcab.zza(this.zza, this);
            zzu.zzx();
            zzcab.zzb(this.zza, this);
            zzg();
            try {
                zzbln.zzf();
            } catch (RemoteException e) {
                zzm.zzl("#007 Could not call remote method.", e);
            }
        }
    }
}
