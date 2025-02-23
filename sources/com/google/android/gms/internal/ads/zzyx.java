package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.os.SystemClock;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzyx {
    public static final zzyr zza = new zzyr(2, -9223372036854775807L, (zzyq) null);
    public static final zzyr zzb = new zzyr(3, -9223372036854775807L, (zzyq) null);
    /* access modifiers changed from: private */
    public final ExecutorService zzc = zzet.zzE("ExoPlayer:Loader:ProgressiveMediaPeriod");
    /* access modifiers changed from: private */
    public zzys zzd;
    /* access modifiers changed from: private */
    public IOException zze;

    public zzyx(String str) {
    }

    public static zzyr zzb(boolean z, long j) {
        return new zzyr(z ? 1 : 0, j, (zzyq) null);
    }

    public final long zza(zzyt zzyt, zzyp zzyp, int i) {
        Looper myLooper = Looper.myLooper();
        zzdi.zzb(myLooper);
        this.zze = null;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        new zzys(this, myLooper, zzyt, zzyp, i, elapsedRealtime).zzc(0);
        return elapsedRealtime;
    }

    public final void zzg() {
        zzys zzys = this.zzd;
        zzdi.zzb(zzys);
        zzys.zza(false);
    }

    public final void zzh() {
        this.zze = null;
    }

    public final void zzi(int i) throws IOException {
        IOException iOException = this.zze;
        if (iOException == null) {
            zzys zzys = this.zzd;
            if (zzys != null) {
                zzys.zzb(i);
                return;
            }
            return;
        }
        throw iOException;
    }

    public final void zzj(zzyu zzyu) {
        zzys zzys = this.zzd;
        if (zzys != null) {
            zzys.zza(true);
        }
        this.zzc.execute(new zzyv(zzyu));
        this.zzc.shutdown();
    }

    public final boolean zzk() {
        if (this.zze != null) {
            return true;
        }
        return false;
    }

    public final boolean zzl() {
        if (this.zzd != null) {
            return true;
        }
        return false;
    }
}
