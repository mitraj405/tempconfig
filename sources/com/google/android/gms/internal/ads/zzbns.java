package com.google.android.gms.internal.ads;

import com.google.ads.mediation.facebook.FacebookMediationAdapter;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzbns implements zzbne {
    /* access modifiers changed from: private */
    public final zzbng zza;
    private final zzbnh zzb;
    private final zzbna zzc;
    private final String zzd;

    public zzbns(zzbna zzbna, String str, zzbnh zzbnh, zzbng zzbng) {
        this.zzc = zzbna;
        this.zzd = str;
        this.zzb = zzbnh;
        this.zza = zzbng;
    }

    public static /* bridge */ /* synthetic */ void zzd(zzbns zzbns, zzbmu zzbmu, zzbnb zzbnb, Object obj, zzbzt zzbzt) {
        try {
            zzu.zzp();
            String uuid = UUID.randomUUID().toString();
            zzbiw.zzo.zzc(uuid, new zzbnr(zzbns, zzbmu, zzbzt));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(FacebookMediationAdapter.KEY_ID, uuid);
            jSONObject.put("args", zzbns.zzb.zzb(obj));
            zzbnb.zzl(zzbns.zzd, jSONObject);
        } catch (Exception e) {
            zzbzt.zzd(e);
            zzm.zzh("Unable to invokeJavascript", e);
            zzbmu.zzb();
        } catch (Throwable th) {
            zzbmu.zzb();
            throw th;
        }
    }

    public final ListenableFuture zza(Object obj) throws Exception {
        return zzb(obj);
    }

    public final ListenableFuture zzb(Object obj) {
        zzbzt zzbzt = new zzbzt();
        zzbmu zzb2 = this.zzc.zzb((zzauo) null);
        zze.zza("callJs > getEngine: Promise created");
        zzb2.zzj(new zzbnp(this, zzb2, obj, zzbzt), new zzbnq(this, zzbzt, zzb2));
        return zzbzt;
    }
}
