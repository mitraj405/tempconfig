package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.firebase.remoteconfig.RemoteConfigConstants;

@SuppressLint({"RestrictedApi"})
/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzfti {
    private static final zzfua zzb = new zzfua("OverlayDisplayService");
    private static final Intent zzc = new Intent("com.google.android.play.core.lmd.BIND_OVERLAY_DISPLAY_SERVICE").setPackage("com.android.vending");
    final zzftz zza;
    private final String zzd;

    public zzfti(Context context) {
        if (zzfuc.zza(context)) {
            this.zza = new zzftz(context.getApplicationContext(), zzb, "OverlayDisplayService", zzc, new zzftf());
        } else {
            this.zza = null;
        }
        this.zzd = context.getPackageName();
    }

    public final void zza() {
        if (this.zza != null) {
            zzb.zzc("unbind LMD display overlay service", new Object[0]);
            this.zza.zzn();
        }
    }

    public final void zzb(zzfsz zzfsz, zzftn zzftn) {
        zzftz zzftz = this.zza;
        if (zzftz == null) {
            zzb.zza("error: %s", "Play Store not found.");
            return;
        }
        zzftz.zzi(new zzftg(this, zzfsz, zzftn));
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [android.os.IInterface, com.google.android.gms.internal.ads.zzfsj] */
    public final /* synthetic */ void zzc(zzfsz zzfsz, zzftn zzftn) {
        try {
            zzftz zzftz = this.zza;
            zzftz.getClass();
            ? zzc2 = zzftz.zzc();
            if (zzc2 != 0) {
                String str = this.zzd;
                Bundle bundle = new Bundle();
                bundle.putString("sessionToken", zzfsz.zzb());
                bundle.putString("callerPackage", str);
                bundle.putString(RemoteConfigConstants.RequestFieldKey.APP_ID, zzfsz.zza());
                zzc2.zze(bundle, new zzfth(this, zzftn));
            }
        } catch (RemoteException e) {
            Object obj = this.zzd;
            zzb.zzb(e, "dismiss overlay display from: %s", obj);
        }
    }

    /* JADX WARNING: type inference failed for: r2v2, types: [android.os.IInterface, com.google.android.gms.internal.ads.zzfsj] */
    public final /* synthetic */ void zzd(zzftk zzftk, zzftn zzftn) {
        try {
            zzftz zzftz = this.zza;
            zzftz.getClass();
            ? zzc2 = zzftz.zzc();
            if (zzc2 != 0) {
                String str = this.zzd;
                Bundle bundle = new Bundle();
                bundle.putBinder("windowToken", zzftk.zzf());
                bundle.putString("adFieldEnifd", zzftk.zzg());
                bundle.putInt("layoutGravity", zzftk.zzc());
                bundle.putFloat("layoutVerticalMargin", zzftk.zza());
                bundle.putInt("displayMode", 0);
                bundle.putInt("triggerMode", 0);
                bundle.putInt("windowWidthPx", zzftk.zze());
                bundle.putString("deeplinkUrl", (String) null);
                bundle.putBoolean("stableSessionToken", true);
                bundle.putString("callerPackage", str);
                if (zzftk.zzh() != null) {
                    bundle.putString(RemoteConfigConstants.RequestFieldKey.APP_ID, zzftk.zzh());
                }
                zzc2.zzf(str, bundle, new zzfth(this, zzftn));
            }
        } catch (RemoteException e) {
            zzb.zzb(e, "show overlay display from: %s", this.zzd);
        }
    }

    /* JADX WARNING: type inference failed for: r0v3, types: [android.os.IInterface, com.google.android.gms.internal.ads.zzfsj] */
    public final /* synthetic */ void zze(zzftp zzftp, int i, zzftn zzftn) {
        try {
            zzftz zzftz = this.zza;
            zzftz.getClass();
            ? zzc2 = zzftz.zzc();
            if (zzc2 != 0) {
                String str = this.zzd;
                Bundle bundle = new Bundle();
                bundle.putString("sessionToken", zzftp.zzb());
                bundle.putInt("displayMode", i);
                bundle.putString("callerPackage", str);
                bundle.putString(RemoteConfigConstants.RequestFieldKey.APP_ID, zzftp.zza());
                zzc2.zzg(bundle, new zzfth(this, zzftn));
            }
        } catch (RemoteException e) {
            zzb.zzb(e, "switchDisplayMode overlay display to %d from: %s", Integer.valueOf(i), this.zzd);
        }
    }

    public final void zzf(zzftk zzftk, zzftn zzftn) {
        zzftz zzftz = this.zza;
        if (zzftz == null) {
            zzb.zza("error: %s", "Play Store not found.");
        } else if (zzftk.zzh() == null) {
            zzb.zza("Failed to convert OverlayDisplayShowRequest when to create a new session: appId cannot be null.", new Object[0]);
            zzftl zzc2 = zzftm.zzc();
            zzc2.zzb(8160);
            zzftn.zza(zzc2.zzc());
        } else {
            zzftz.zzi(new zzfte(this, zzftk, zzftn));
        }
    }

    public final void zzg(zzftp zzftp, zzftn zzftn, int i) {
        zzftz zzftz = this.zza;
        if (zzftz == null) {
            zzb.zza("error: %s", "Play Store not found.");
            return;
        }
        zzftz.zzi(new zzftd(this, zzftp, i, zzftn));
    }
}
