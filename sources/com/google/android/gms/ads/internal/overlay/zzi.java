package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.google.android.gms.internal.ads.zzcej;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzi {
    public final int zza;
    public final ViewGroup.LayoutParams zzb;
    public final ViewGroup zzc;
    public final Context zzd;

    public zzi(zzcej zzcej) throws zzg {
        this.zzb = zzcej.getLayoutParams();
        ViewParent parent = zzcej.getParent();
        this.zzd = zzcej.zzE();
        if (parent == null || !(parent instanceof ViewGroup)) {
            throw new zzg("Could not get the parent of the WebView for an overlay.");
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        this.zzc = viewGroup;
        this.zza = viewGroup.indexOfChild(zzcej.zzF());
        viewGroup.removeView(zzcej.zzF());
        zzcej.zzaq(true);
    }
}
