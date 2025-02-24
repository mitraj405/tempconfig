package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzft;
import com.google.common.annotations.VisibleForTesting;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@22.0.2 */
public final class zzb {
    @VisibleForTesting
    zzac zza;
    @VisibleForTesting
    private final zzf zzb;
    @VisibleForTesting
    private zzh zzc;
    private final zzaa zzd;

    public zzb() {
        this(new zzf());
    }

    public final zzac zza() {
        return this.zza;
    }

    public final /* synthetic */ zzal zzb() throws Exception {
        return new zzw(this.zzd);
    }

    public final boolean zzc() {
        if (!this.zza.zzc().isEmpty()) {
            return true;
        }
        return false;
    }

    public final boolean zzd() {
        if (!this.zza.zzb().equals(this.zza.zza())) {
            return true;
        }
        return false;
    }

    private zzb(zzf zzf) {
        this.zzb = zzf;
        this.zzc = zzf.zza.zza();
        this.zza = new zzac();
        this.zzd = new zzaa();
        zzf.zza("internal.registerCallback", (Callable<? extends zzal>) new zza(this));
        zzf.zza("internal.eventLogger", (Callable<? extends zzal>) new zzd(this));
    }

    public final void zza(zzft.zzc zzc2) throws zzc {
        zzal zzal;
        try {
            this.zzc = this.zzb.zza.zza();
            if (!(this.zzb.zza(this.zzc, (zzft.zzd[]) zzc2.zzc().toArray(new zzft.zzd[0])) instanceof zzaj)) {
                for (zzft.zzb next : zzc2.zza().zzd()) {
                    List<zzft.zzd> zzc3 = next.zzc();
                    String zzb2 = next.zzb();
                    Iterator<zzft.zzd> it = zzc3.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            zzaq zza2 = this.zzb.zza(this.zzc, it.next());
                            if (zza2 instanceof zzap) {
                                zzh zzh = this.zzc;
                                if (!zzh.zzb(zzb2)) {
                                    zzal = null;
                                } else {
                                    zzaq zza3 = zzh.zza(zzb2);
                                    if (zza3 instanceof zzal) {
                                        zzal = (zzal) zza3;
                                    } else {
                                        throw new IllegalStateException("Invalid function name: " + zzb2);
                                    }
                                }
                                if (zzal != null) {
                                    zzal.zza(this.zzc, (List<zzaq>) Collections.singletonList(zza2));
                                } else {
                                    throw new IllegalStateException("Rule function is undefined: " + zzb2);
                                }
                            } else {
                                throw new IllegalArgumentException("Invalid rule definition");
                            }
                        }
                    }
                }
                return;
            }
            throw new IllegalStateException("Program loading failed");
        } catch (Throwable th) {
            throw new zzc(th);
        }
    }

    public final void zza(String str, Callable<? extends zzal> callable) {
        this.zzb.zza(str, callable);
    }

    public final boolean zza(zzad zzad) throws zzc {
        try {
            this.zza.zza(zzad);
            this.zzb.zzb.zzc("runtime.counter", new zzai(Double.valueOf(0.0d)));
            this.zzd.zza(this.zzc.zza(), this.zza);
            return zzd() || zzc();
        } catch (Throwable th) {
            throw new zzc(th);
        }
    }
}
