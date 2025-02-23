package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzenn implements zzevo {
    private final zzgcu zza;
    private final zzgcu zzb;
    private final Context zzc;
    private final zzffg zzd;
    private final View zze;

    public zzenn(zzgcu zzgcu, zzgcu zzgcu2, Context context, zzffg zzffg, ViewGroup viewGroup) {
        this.zza = zzgcu;
        this.zzb = zzgcu2;
        this.zzc = context;
        this.zzd = zzffg;
        this.zze = viewGroup;
    }

    private final List zze() {
        int i;
        ArrayList arrayList = new ArrayList();
        View view = this.zze;
        while (view != null) {
            ViewParent parent = view.getParent();
            if (parent == null) {
                break;
            }
            if (parent instanceof ViewGroup) {
                i = ((ViewGroup) parent).indexOfChild(view);
            } else {
                i = -1;
            }
            Bundle bundle = new Bundle();
            bundle.putString("type", parent.getClass().getName());
            bundle.putInt("index_of_child", i);
            arrayList.add(bundle);
            if (!(parent instanceof View)) {
                break;
            }
            view = (View) parent;
        }
        return arrayList;
    }

    public final int zza() {
        return 3;
    }

    public final ListenableFuture zzb() {
        zzbbw.zza(this.zzc);
        if (((Boolean) zzba.zzc().zza(zzbbw.zzkf)).booleanValue()) {
            return this.zzb.zzb(new zzenl(this));
        }
        return this.zza.zzb(new zzenm(this));
    }

    public final /* synthetic */ zzeno zzc() throws Exception {
        return new zzeno(this.zzc, this.zzd.zze, zze());
    }

    public final /* synthetic */ zzeno zzd() throws Exception {
        return new zzeno(this.zzc, this.zzd.zze, zze());
    }
}
