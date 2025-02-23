package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzep implements zzdt {
    private static final List zza = new ArrayList(50);
    private final Handler zzb;

    public zzep(Handler handler) {
        this.zzb = handler;
    }

    public static /* bridge */ /* synthetic */ void zzl(zzeo zzeo) {
        List list = zza;
        synchronized (list) {
            if (list.size() < 50) {
                list.add(zzeo);
            }
        }
    }

    private static zzeo zzm() {
        zzeo zzeo;
        List list = zza;
        synchronized (list) {
            if (list.isEmpty()) {
                zzeo = new zzeo((zzen) null);
            } else {
                zzeo = (zzeo) list.remove(list.size() - 1);
            }
        }
        return zzeo;
    }

    public final Looper zza() {
        return this.zzb.getLooper();
    }

    public final zzds zzb(int i) {
        Handler handler = this.zzb;
        zzeo zzm = zzm();
        zzm.zzb(handler.obtainMessage(i), this);
        return zzm;
    }

    public final zzds zzc(int i, Object obj) {
        Handler handler = this.zzb;
        zzeo zzm = zzm();
        zzm.zzb(handler.obtainMessage(i, obj), this);
        return zzm;
    }

    public final zzds zzd(int i, int i2, int i3) {
        Handler handler = this.zzb;
        zzeo zzm = zzm();
        zzm.zzb(handler.obtainMessage(1, i2, i3), this);
        return zzm;
    }

    public final void zze(Object obj) {
        this.zzb.removeCallbacksAndMessages((Object) null);
    }

    public final void zzf(int i) {
        this.zzb.removeMessages(i);
    }

    public final boolean zzg(int i) {
        return this.zzb.hasMessages(0);
    }

    public final boolean zzh(Runnable runnable) {
        return this.zzb.post(runnable);
    }

    public final boolean zzi(int i) {
        return this.zzb.sendEmptyMessage(i);
    }

    public final boolean zzj(int i, long j) {
        return this.zzb.sendEmptyMessageAtTime(2, j);
    }

    public final boolean zzk(zzds zzds) {
        return ((zzeo) zzds).zzc(this.zzb);
    }
}
