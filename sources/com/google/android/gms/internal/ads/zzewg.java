package com.google.android.gms.internal.ads;

import android.util.Base64;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzewg implements zzgbq {
    public final ListenableFuture zza(Object obj) {
        C0280ne neVar = (C0280ne) obj;
        if (neVar == null) {
            return zzgcj.zzh(new zzewk("", 1, (zzewj) null));
        }
        zzhbn zzc = zzhbo.zzc();
        for (C0254lA next : neVar.a) {
            zzhbl zzc2 = zzhbm.zzc();
            zzc2.zzc(next.a);
            zzc2.zza(next.b);
            zzc2.zzb(next.f3079a);
            zzc.zza((zzhbm) zzc2.zzbr());
        }
        return zzgcj.zzh(new zzewk(Base64.encodeToString(((zzhbo) zzc.zzbr()).zzaV(), 1), 1, (zzewj) null));
    }
}
