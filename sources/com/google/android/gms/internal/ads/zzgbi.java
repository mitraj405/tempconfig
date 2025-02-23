package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
abstract class zzgbi extends zzgbo {
    private static final zzgct zza = new zzgct(zzgbi.class);
    private zzfxm zzb;
    private final boolean zzc;
    private final boolean zzf;

    public zzgbi(zzfxm zzfxm, boolean z, boolean z2) {
        super(zzfxm.size());
        this.zzb = zzfxm;
        this.zzc = z;
        this.zzf = z2;
    }

    private final void zzG(int i, Future future) {
        try {
            zzf(i, zzgcj.zzp(future));
        } catch (ExecutionException e) {
            zzI(e.getCause());
        } catch (Throwable th) {
            zzI(th);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: zzH */
    public final void zzx(zzfxm zzfxm) {
        boolean z;
        int zzA = zzA();
        int i = 0;
        if (zzA >= 0) {
            z = true;
        } else {
            z = false;
        }
        zzfuu.zzk(z, "Less than 0 remaining futures");
        if (zzA == 0) {
            if (zzfxm != null) {
                zzfzx zze = zzfxm.iterator();
                while (zze.hasNext()) {
                    Future future = (Future) zze.next();
                    if (!future.isCancelled()) {
                        zzG(i, future);
                    }
                    i++;
                }
            }
            zzF();
            zzu();
            zzy(2);
        }
    }

    private final void zzI(Throwable th) {
        th.getClass();
        if (this.zzc && !zzd(th) && zzK(zzC(), th)) {
            zzJ(th);
        } else if (th instanceof Error) {
            zzJ(th);
        }
    }

    private static void zzJ(Throwable th) {
        String str;
        if (true != (th instanceof Error)) {
            str = "Got more than one input Future failure. Logging failures after the first";
        } else {
            str = "Input Future failed with Error";
        }
        zza.zza().logp(Level.SEVERE, "com.google.common.util.concurrent.AggregateFuture", "log", str, th);
    }

    private static boolean zzK(Set set, Throwable th) {
        while (th != null) {
            if (!set.add(th)) {
                return false;
            }
            th = th.getCause();
        }
        return true;
    }

    public final String zza() {
        zzfxm zzfxm = this.zzb;
        if (zzfxm != null) {
            return "futures=".concat(zzfxm.toString());
        }
        return super.zza();
    }

    public final void zzb() {
        zzfxm zzfxm = this.zzb;
        boolean z = true;
        zzy(1);
        boolean isCancelled = isCancelled();
        if (zzfxm == null) {
            z = false;
        }
        if (z && isCancelled) {
            boolean zzt = zzt();
            zzfzx zze = zzfxm.iterator();
            while (zze.hasNext()) {
                ((Future) zze.next()).cancel(zzt);
            }
        }
    }

    public final void zze(Set set) {
        set.getClass();
        if (!isCancelled()) {
            Throwable zzl = zzl();
            Objects.requireNonNull(zzl);
            zzK(set, zzl);
        }
    }

    public abstract void zzf(int i, Object obj);

    public abstract void zzu();

    public final void zzv() {
        zzfxm zzfxm;
        Objects.requireNonNull(this.zzb);
        if (this.zzb.isEmpty()) {
            zzu();
        } else if (this.zzc) {
            zzfzx zze = this.zzb.iterator();
            int i = 0;
            while (zze.hasNext()) {
                ListenableFuture listenableFuture = (ListenableFuture) zze.next();
                listenableFuture.addListener(new zzgbg(this, listenableFuture, i), zzgbx.INSTANCE);
                i++;
            }
        } else {
            if (this.zzf) {
                zzfxm = this.zzb;
            } else {
                zzfxm = null;
            }
            zzgbh zzgbh = new zzgbh(this, zzfxm);
            zzfzx zze2 = this.zzb.iterator();
            while (zze2.hasNext()) {
                ((ListenableFuture) zze2.next()).addListener(zzgbh, zzgbx.INSTANCE);
            }
        }
    }

    public final /* synthetic */ void zzw(ListenableFuture listenableFuture, int i) {
        try {
            if (listenableFuture.isCancelled()) {
                this.zzb = null;
                cancel(false);
            } else {
                zzG(i, listenableFuture);
            }
        } finally {
            zzx((zzfxm) null);
        }
    }

    public void zzy(int i) {
        this.zzb = null;
    }
}
