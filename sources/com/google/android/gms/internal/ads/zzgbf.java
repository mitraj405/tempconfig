package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
abstract class zzgbf extends zzgbz implements Runnable {
    public static final /* synthetic */ int zzc = 0;
    ListenableFuture zza;
    Object zzb;

    public zzgbf(ListenableFuture listenableFuture, Object obj) {
        listenableFuture.getClass();
        this.zza = listenableFuture;
        this.zzb = obj;
    }

    public final void run() {
        boolean z;
        ListenableFuture listenableFuture = this.zza;
        Object obj = this.zzb;
        boolean isCancelled = isCancelled();
        boolean z2 = true;
        if (listenableFuture == null) {
            z = true;
        } else {
            z = false;
        }
        boolean z3 = isCancelled | z;
        if (obj != null) {
            z2 = false;
        }
        if (!z3 && !z2) {
            this.zza = null;
            if (listenableFuture.isCancelled()) {
                zzs(listenableFuture);
                return;
            }
            try {
                try {
                    Object zze = zze(obj, zzgcj.zzp(listenableFuture));
                    this.zzb = null;
                    zzf(zze);
                } catch (Throwable th) {
                    this.zzb = null;
                    throw th;
                }
            } catch (CancellationException unused) {
                cancel(false);
            } catch (ExecutionException e) {
                zzd(e.getCause());
            } catch (Exception e2) {
                zzd(e2);
            } catch (Error e3) {
                zzd(e3);
            }
        }
    }

    public final String zza() {
        String str;
        ListenableFuture listenableFuture = this.zza;
        Object obj = this.zzb;
        String zza2 = super.zza();
        if (listenableFuture != null) {
            str = lf.j("inputFuture=[", listenableFuture.toString(), "], ");
        } else {
            str = "";
        }
        if (obj != null) {
            String obj2 = obj.toString();
            return str + "function=[" + obj2 + "]";
        } else if (zza2 != null) {
            return str.concat(zza2);
        } else {
            return null;
        }
    }

    public final void zzb() {
        zzr(this.zza);
        this.zza = null;
        this.zzb = null;
    }

    public abstract Object zze(Object obj, Object obj2) throws Exception;

    public abstract void zzf(Object obj);
}
