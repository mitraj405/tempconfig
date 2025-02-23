package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzcop implements zzaxw {
    private zzcej zza;
    private final Executor zzb;
    private final zzcob zzc;
    private final Clock zzd;
    private boolean zze = false;
    private boolean zzf = false;
    private final zzcoe zzg = new zzcoe();

    public zzcop(Executor executor, zzcob zzcob, Clock clock) {
        this.zzb = executor;
        this.zzc = zzcob;
        this.zzd = clock;
    }

    private final void zzg() {
        try {
            JSONObject zza2 = this.zzc.zzb(this.zzg);
            if (this.zza != null) {
                this.zzb.execute(new zzcoo(this, zza2));
            }
        } catch (JSONException e) {
            zze.zzb("Failed to call video active view js", e);
        }
    }

    public final void zza() {
        this.zze = false;
    }

    public final void zzb() {
        this.zze = true;
        zzg();
    }

    public final /* synthetic */ void zzd(JSONObject jSONObject) {
        this.zza.zzl("AFMA_updateActiveView", jSONObject);
    }

    public final void zzdp(zzaxv zzaxv) {
        boolean z;
        if (this.zzf) {
            z = false;
        } else {
            z = zzaxv.zzj;
        }
        zzcoe zzcoe = this.zzg;
        zzcoe.zza = z;
        zzcoe.zzd = this.zzd.elapsedRealtime();
        this.zzg.zzf = zzaxv;
        if (this.zze) {
            zzg();
        }
    }

    public final void zze(boolean z) {
        this.zzf = z;
    }

    public final void zzf(zzcej zzcej) {
        this.zza = zzcej;
    }
}
