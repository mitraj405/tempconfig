package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.util.zzbs;
import com.google.android.gms.ads.zzb;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzefy implements zzeez {
    private final Context zza;
    private final zzcql zzb;
    private final Executor zzc;

    public zzefy(Context context, zzcql zzcql, Executor executor) {
        this.zza = context;
        this.zzb = zzcql;
        this.zzc = executor;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v17, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: android.view.View} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* bridge */ /* synthetic */ java.lang.Object zza(com.google.android.gms.internal.ads.zzfex r7, com.google.android.gms.internal.ads.zzfel r8, com.google.android.gms.internal.ads.zzeew r9) throws com.google.android.gms.internal.ads.zzffn, com.google.android.gms.internal.ads.zzeir {
        /*
            r6 = this;
            com.google.android.gms.internal.ads.zzbbn r0 = com.google.android.gms.internal.ads.zzbbw.zzgZ
            com.google.android.gms.internal.ads.zzbbu r1 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r0 = r1.zza(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r1 = 0
            if (r0 == 0) goto L_0x0077
            boolean r0 = r8.zzag
            if (r0 == 0) goto L_0x0077
            java.lang.Object r0 = r9.zzb
            com.google.android.gms.internal.ads.zzfge r0 = (com.google.android.gms.internal.ads.zzfge) r0
            com.google.android.gms.internal.ads.zzbov r0 = r0.zzc()
            if (r0 == 0) goto L_0x0067
            com.google.android.gms.dynamic.IObjectWrapper r2 = r0.zze()     // Catch:{ RemoteException -> 0x0060 }
            java.lang.Object r2 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r2)     // Catch:{ RemoteException -> 0x0060 }
            android.view.View r2 = (android.view.View) r2     // Catch:{ RemoteException -> 0x0060 }
            boolean r0 = r0.zzf()     // Catch:{ RemoteException -> 0x0060 }
            if (r2 == 0) goto L_0x0053
            if (r0 == 0) goto L_0x007f
            com.google.common.util.concurrent.ListenableFuture r0 = com.google.android.gms.internal.ads.zzgcj.zzh(r1)
            com.google.android.gms.internal.ads.zzefw r3 = new com.google.android.gms.internal.ads.zzefw
            r3.<init>(r6, r2, r8)
            com.google.android.gms.internal.ads.zzgcu r2 = com.google.android.gms.internal.ads.zzbzo.zze
            com.google.common.util.concurrent.ListenableFuture r0 = com.google.android.gms.internal.ads.zzgcj.zzn(r0, r3, r2)
            java.lang.Object r0 = r0.get()     // Catch:{ InterruptedException -> 0x004c, ExecutionException -> 0x004a }
            r2 = r0
            android.view.View r2 = (android.view.View) r2     // Catch:{ InterruptedException -> 0x004c, ExecutionException -> 0x004a }
            goto L_0x007f
        L_0x004a:
            r7 = move-exception
            goto L_0x004d
        L_0x004c:
            r7 = move-exception
        L_0x004d:
            com.google.android.gms.internal.ads.zzffn r8 = new com.google.android.gms.internal.ads.zzffn
            r8.<init>(r7)
            throw r8
        L_0x0053:
            com.google.android.gms.internal.ads.zzffn r7 = new com.google.android.gms.internal.ads.zzffn
            java.lang.Exception r8 = new java.lang.Exception
            java.lang.String r9 = "BannerAdapterWrapper interscrollerView should not be null"
            r8.<init>(r9)
            r7.<init>(r8)
            throw r7
        L_0x0060:
            r7 = move-exception
            com.google.android.gms.internal.ads.zzffn r8 = new com.google.android.gms.internal.ads.zzffn
            r8.<init>(r7)
            throw r8
        L_0x0067:
            java.lang.String r7 = "getInterscrollerAd should not be null after loadInterscrollerAd loaded ad."
            com.google.android.gms.ads.internal.util.client.zzm.zzg(r7)
            com.google.android.gms.internal.ads.zzffn r8 = new com.google.android.gms.internal.ads.zzffn
            java.lang.Exception r9 = new java.lang.Exception
            r9.<init>(r7)
            r8.<init>(r9)
            throw r8
        L_0x0077:
            java.lang.Object r0 = r9.zzb
            com.google.android.gms.internal.ads.zzfge r0 = (com.google.android.gms.internal.ads.zzfge) r0
            android.view.View r2 = r0.zza()
        L_0x007f:
            com.google.android.gms.internal.ads.zzcql r0 = r6.zzb
            java.lang.String r3 = r9.zza
            com.google.android.gms.internal.ads.zzcsk r4 = new com.google.android.gms.internal.ads.zzcsk
            r4.<init>(r7, r8, r3)
            java.lang.Object r7 = r9.zzb
            com.google.android.gms.internal.ads.zzcpr r3 = new com.google.android.gms.internal.ads.zzcpr
            com.google.android.gms.internal.ads.zzfge r7 = (com.google.android.gms.internal.ads.zzfge) r7
            java.util.Objects.requireNonNull(r7)
            com.google.android.gms.internal.ads.zzefx r5 = new com.google.android.gms.internal.ads.zzefx
            r5.<init>(r7)
            java.util.List r7 = r8.zzu
            r8 = 0
            java.lang.Object r7 = r7.get(r8)
            com.google.android.gms.internal.ads.zzfem r7 = (com.google.android.gms.internal.ads.zzfem) r7
            r3.<init>(r2, r1, r5, r7)
            com.google.android.gms.internal.ads.zzcpl r7 = r0.zza(r4, r3)
            com.google.android.gms.internal.ads.zzdek r8 = r7.zzg()
            r8.zza(r2)
            com.google.android.gms.internal.ads.zzcxp r8 = r7.zzd()
            java.lang.Object r0 = r9.zzb
            com.google.android.gms.internal.ads.zzcmy r1 = new com.google.android.gms.internal.ads.zzcmy
            com.google.android.gms.internal.ads.zzfge r0 = (com.google.android.gms.internal.ads.zzfge) r0
            r1.<init>(r0)
            java.util.concurrent.Executor r0 = r6.zzc
            r8.zzo(r1, r0)
            com.google.android.gms.internal.ads.zzcya r8 = r9.zzc
            com.google.android.gms.internal.ads.zzegp r8 = (com.google.android.gms.internal.ads.zzegp) r8
            com.google.android.gms.internal.ads.zzekh r9 = r7.zzk()
            r8.zzc(r9)
            com.google.android.gms.internal.ads.zzcpk r7 = r7.zza()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzefy.zza(com.google.android.gms.internal.ads.zzfex, com.google.android.gms.internal.ads.zzfel, com.google.android.gms.internal.ads.zzeew):java.lang.Object");
    }

    public final void zzb(zzfex zzfex, zzfel zzfel, zzeew zzeew) throws zzffn {
        zzq zza2;
        zzq zzq = zzfex.zza.zza.zze;
        if (zzq.zzn) {
            zza2 = new zzq(this.zza, zzb.zzd(zzq.zze, zzq.zzb));
        } else {
            if (!((Boolean) zzba.zzc().zza(zzbbw.zzgZ)).booleanValue() || !zzfel.zzag) {
                zza2 = zzffm.zza(this.zza, zzfel.zzu);
            } else {
                zza2 = new zzq(this.zza, zzb.zze(zzq.zze, zzq.zzb));
            }
        }
        zzq zzq2 = zza2;
        if (!((Boolean) zzba.zzc().zza(zzbbw.zzgZ)).booleanValue() || !zzfel.zzag) {
            Object obj = zzeew.zzb;
            Context context = this.zza;
            zzffg zzffg = zzfex.zza.zza;
            ((zzfge) obj).zzm(context, zzq2, zzffg.zzd, zzfel.zzv.toString(), zzbs.zzm(zzfel.zzs), (zzbos) zzeew.zzc);
            return;
        }
        Object obj2 = zzeew.zzb;
        Context context2 = this.zza;
        zzffg zzffg2 = zzfex.zza.zza;
        ((zzfge) obj2).zzn(context2, zzq2, zzffg2.zzd, zzfel.zzv.toString(), zzbs.zzm(zzfel.zzs), (zzbos) zzeew.zzc);
    }

    public final /* synthetic */ ListenableFuture zzc(View view, zzfel zzfel, Object obj) throws Exception {
        return zzgcj.zzh(zzcrg.zza(this.zza, view, zzfel));
    }
}
