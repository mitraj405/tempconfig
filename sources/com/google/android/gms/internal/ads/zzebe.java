package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzebe implements zzgbq {
    public final /* synthetic */ zzexi zza;

    public /* synthetic */ zzebe(zzexi zzexi) {
        this.zza = zzexi;
    }

    public final ListenableFuture zza(Object obj) {
        Void voidR = (Void) obj;
        return this.zza.zza().zza(new JSONObject(), new Bundle());
    }
}
