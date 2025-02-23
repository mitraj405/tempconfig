package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.view.ViewGroup;
import android.view.Window;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzesq implements zzevo {
    private final zzgcu zza;
    private final ViewGroup zzb;
    private final Context zzc;
    private final Set zzd;

    public zzesq(zzgcu zzgcu, ViewGroup viewGroup, Context context, Set set) {
        this.zza = zzgcu;
        this.zzd = set;
        this.zzb = viewGroup;
        this.zzc = context;
    }

    public final int zza() {
        return 22;
    }

    public final ListenableFuture zzb() {
        return this.zza.zzb(new zzesp(this));
    }

    public final /* synthetic */ zzesr zzc() throws Exception {
        if (((Boolean) zzba.zzc().zza(zzbbw.zzfl)).booleanValue() && this.zzb != null && this.zzd.contains("banner")) {
            return new zzesr(Boolean.valueOf(this.zzb.isHardwareAccelerated()));
        }
        Boolean bool = null;
        if (((Boolean) zzba.zzc().zza(zzbbw.zzfm)).booleanValue() && this.zzd.contains("native")) {
            Context context = this.zzc;
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                Window window = activity.getWindow();
                if (window == null || (window.getAttributes().flags & 16777216) == 0) {
                    try {
                        boolean z = false;
                        if ((activity.getPackageManager().getActivityInfo(activity.getComponentName(), 0).flags & AdRequest.MAX_CONTENT_URL_LENGTH) != 0) {
                            z = true;
                        }
                        bool = Boolean.valueOf(z);
                    } catch (PackageManager.NameNotFoundException unused) {
                    }
                } else {
                    bool = Boolean.TRUE;
                }
                return new zzesr(bool);
            }
        }
        return new zzesr((Boolean) null);
    }
}
