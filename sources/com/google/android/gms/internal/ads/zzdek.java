package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.client.zzba;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdek extends zzdch implements zzaxw {
    private final Map zzb = new WeakHashMap(1);
    private final Context zzc;
    private final zzfel zzd;

    public zzdek(Context context, Set set, zzfel zzfel) {
        super(set);
        this.zzc = context;
        this.zzd = zzfel;
    }

    public final synchronized void zza(View view) {
        zzaxx zzaxx = (zzaxx) this.zzb.get(view);
        if (zzaxx == null) {
            zzaxx zzaxx2 = new zzaxx(this.zzc, view);
            zzaxx2.zzc(this);
            this.zzb.put(view, zzaxx2);
            zzaxx = zzaxx2;
        }
        if (this.zzd.zzX) {
            if (((Boolean) zzba.zzc().zza(zzbbw.zzbf)).booleanValue()) {
                zzaxx.zzg(((Long) zzba.zzc().zza(zzbbw.zzbe)).longValue());
                return;
            }
        }
        zzaxx.zzf();
    }

    public final synchronized void zzb(View view) {
        if (this.zzb.containsKey(view)) {
            ((zzaxx) this.zzb.get(view)).zze(this);
            this.zzb.remove(view);
        }
    }

    public final synchronized void zzdp(zzaxv zzaxv) {
        zzq(new zzdej(zzaxv));
    }
}
