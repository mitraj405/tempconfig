package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzdlq implements Callable {
    public final /* synthetic */ zzdlr zza;
    public final /* synthetic */ ListenableFuture zzb;
    public final /* synthetic */ ListenableFuture zzc;
    public final /* synthetic */ ListenableFuture zzd;
    public final /* synthetic */ ListenableFuture zze;
    public final /* synthetic */ ListenableFuture zzf;
    public final /* synthetic */ JSONObject zzg;
    public final /* synthetic */ ListenableFuture zzh;
    public final /* synthetic */ ListenableFuture zzi;
    public final /* synthetic */ ListenableFuture zzj;
    public final /* synthetic */ ListenableFuture zzk;

    public /* synthetic */ zzdlq(zzdlr zzdlr, ListenableFuture listenableFuture, ListenableFuture listenableFuture2, ListenableFuture listenableFuture3, ListenableFuture listenableFuture4, ListenableFuture listenableFuture5, JSONObject jSONObject, ListenableFuture listenableFuture6, ListenableFuture listenableFuture7, ListenableFuture listenableFuture8, ListenableFuture listenableFuture9) {
        this.zza = zzdlr;
        this.zzb = listenableFuture;
        this.zzc = listenableFuture2;
        this.zzd = listenableFuture3;
        this.zze = listenableFuture4;
        this.zzf = listenableFuture5;
        this.zzg = jSONObject;
        this.zzh = listenableFuture6;
        this.zzi = listenableFuture7;
        this.zzj = listenableFuture8;
        this.zzk = listenableFuture9;
    }

    public final Object call() {
        zzdjb zzdjb = (zzdjb) this.zzb.get();
        zzdjb.zzP((List) this.zzc.get());
        zzdjb.zzM((zzbfd) this.zzd.get());
        zzdjb.zzQ((zzbfd) this.zze.get());
        zzdjb.zzJ((zzbew) this.zzf.get());
        JSONObject jSONObject = this.zzg;
        zzdjb.zzS(zzdme.zzj(jSONObject));
        zzdjb.zzL(zzdme.zzi(jSONObject));
        zzcej zzcej = (zzcej) this.zzh.get();
        if (zzcej != null) {
            zzdjb.zzad(zzcej);
            zzdjb.zzac(zzcej.zzF());
            zzdjb.zzab(zzcej.zzq());
        }
        zzcej zzcej2 = (zzcej) this.zzi.get();
        if (zzcej2 != null) {
            zzdjb.zzO(zzcej2);
            zzdjb.zzae(zzcej2.zzF());
        }
        ListenableFuture listenableFuture = this.zzj;
        if (((Boolean) zzba.zzc().zza(zzbbw.zzeH)).booleanValue()) {
            zzdjb.zzU(listenableFuture);
            zzdjb.zzX(new zzbzt());
        } else {
            zzcej zzcej3 = (zzcej) listenableFuture.get();
            if (zzcej3 != null) {
                zzdjb.zzT(zzcej3);
            }
        }
        for (zzdmi zzdmi : (List) this.zzk.get()) {
            if (zzdmi.zza != 1) {
                zzdjb.zzN(zzdmi.zzb, zzdmi.zzd);
            } else {
                zzdjb.zzZ(zzdmi.zzb, zzdmi.zzc);
            }
        }
        return zzdjb;
    }
}
