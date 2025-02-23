package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzebi extends zzbun {
    private final Context zza;
    private final zzexh zzb;
    private final zzexf zzc;
    private final zzebq zzd;
    private final zzgcu zze;
    private final zzbvj zzf;

    public zzebi(Context context, zzexh zzexh, zzexf zzexf, zzebn zzebn, zzebq zzebq, zzgcu zzgcu, zzbvj zzbvj) {
        this.zza = context;
        this.zzb = zzexh;
        this.zzc = zzexf;
        this.zzd = zzebq;
        this.zze = zzgcu;
        this.zzf = zzbvj;
    }

    private final void zzc(ListenableFuture listenableFuture, zzbur zzbur) {
        zzgcj.zzr(zzgcj.zzn(zzgca.zzu(listenableFuture), new zzebf(this), zzbzo.zza), new zzebh(this, zzbur), zzbzo.zzf);
    }

    public final ListenableFuture zzb(zzbug zzbug, int i) {
        ListenableFuture listenableFuture;
        HashMap hashMap = new HashMap();
        Bundle bundle = zzbug.zzc;
        if (bundle != null) {
            for (String next : bundle.keySet()) {
                String string = bundle.getString(next);
                if (string != null) {
                    hashMap.put(next, string);
                }
            }
        }
        zzebk zzebk = new zzebk(zzbug.zza, zzbug.zzb, hashMap, zzbug.zzd, "", zzbug.zze);
        zzexf zzexf = this.zzc;
        zzexf.zza(new zzeyj(zzbug));
        boolean z = zzebk.zzf;
        zzexg zzb2 = zzexf.zzb();
        if (z) {
            String str = zzbug.zza;
            String str2 = (String) zzbdz.zzb.zze();
            if (!TextUtils.isEmpty(str2)) {
                String host = Uri.parse(str).getHost();
                if (!TextUtils.isEmpty(host)) {
                    Iterator it = zzfvh.zzb(zzfui.zzc(';')).zzc(str2).iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (host.endsWith((String) it.next())) {
                                listenableFuture = zzgcj.zzm(zzb2.zza().zza(new JSONObject(), new Bundle()), new zzeba(zzebk), this.zze);
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        listenableFuture = zzgcj.zzh(zzebk);
        zzfjl zzb3 = zzb2.zzb();
        return zzgcj.zzn(zzb3.zzb(zzfjf.HTTP, listenableFuture).zze(new zzebm(this.zza, "", this.zzf, i)).zza(), new zzebb(), this.zze);
    }

    public final void zze(zzbug zzbug, zzbur zzbur) {
        zzc(zzb(zzbug, Binder.getCallingUid()), zzbur);
    }

    public final void zzf(zzbuc zzbuc, zzbur zzbur) {
        zzeww zzeww = new zzeww(zzbuc, Binder.getCallingUid());
        zzexh zzexh = this.zzb;
        zzexh.zza(zzeww);
        zzexi zzb2 = zzexh.zzb();
        zzfjl zzb3 = zzb2.zzb();
        zzfiq zza2 = zzb3.zzb(zzfjf.GMS_SIGNALS, zzgcj.zzi()).zzf(new zzebe(zzb2)).zze(new zzebd()).zzf(new zzebc()).zza();
        zzc(zza2, zzbur);
        if (((Boolean) zzbds.zzf.zze()).booleanValue()) {
            zzebq zzebq = this.zzd;
            Objects.requireNonNull(zzebq);
            zza2.addListener(new zzebg(zzebq), this.zze);
        }
    }
}
