package com.google.android.gms.internal.ads;

import com.google.ads.mediation.facebook.FacebookMediationAdapter;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzboa implements zzgbq {
    private final String zza = "google.afma.activeView.handleUpdate";
    private final ListenableFuture zzb;

    public zzboa(ListenableFuture listenableFuture, String str, zzbnh zzbnh, zzbng zzbng) {
        this.zzb = listenableFuture;
    }

    public final ListenableFuture zza(Object obj) throws Exception {
        return zzb(obj);
    }

    public final ListenableFuture zzb(Object obj) {
        return zzgcj.zzn(this.zzb, new zzbny(this, obj), zzbzo.zzf);
    }

    public final /* synthetic */ ListenableFuture zzc(Object obj, zzbnb zzbnb) throws Exception {
        zzbzt zzbzt = new zzbzt();
        zzu.zzp();
        String uuid = UUID.randomUUID().toString();
        zzbiw.zzo.zzc(uuid, new zzbnz(this, zzbzt));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(FacebookMediationAdapter.KEY_ID, uuid);
        jSONObject.put("args", (JSONObject) obj);
        zzbnb.zzl(this.zza, jSONObject);
        return zzbzt;
    }
}
