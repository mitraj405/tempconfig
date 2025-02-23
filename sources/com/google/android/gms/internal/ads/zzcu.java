package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public abstract class zzcu implements zzct {
    protected zzcr zzb;
    protected zzcr zzc;
    private zzcr zzd;
    private zzcr zze;
    private ByteBuffer zzf;
    private ByteBuffer zzg;
    private boolean zzh;

    public zzcu() {
        ByteBuffer byteBuffer = zzct.zza;
        this.zzf = byteBuffer;
        this.zzg = byteBuffer;
        zzcr zzcr = zzcr.zza;
        this.zzd = zzcr;
        this.zze = zzcr;
        this.zzb = zzcr;
        this.zzc = zzcr;
    }

    public final zzcr zza(zzcr zzcr) throws zzcs {
        this.zzd = zzcr;
        this.zze = zzi(zzcr);
        if (zzg()) {
            return this.zze;
        }
        return zzcr.zza;
    }

    public ByteBuffer zzb() {
        ByteBuffer byteBuffer = this.zzg;
        this.zzg = zzct.zza;
        return byteBuffer;
    }

    public final void zzc() {
        this.zzg = zzct.zza;
        this.zzh = false;
        this.zzb = this.zzd;
        this.zzc = this.zze;
        zzk();
    }

    public final void zzd() {
        this.zzh = true;
        zzl();
    }

    public final void zzf() {
        zzc();
        this.zzf = zzct.zza;
        zzcr zzcr = zzcr.zza;
        this.zzd = zzcr;
        this.zze = zzcr;
        this.zzb = zzcr;
        this.zzc = zzcr;
        zzm();
    }

    public boolean zzg() {
        if (this.zze != zzcr.zza) {
            return true;
        }
        return false;
    }

    public boolean zzh() {
        if (!this.zzh || this.zzg != zzct.zza) {
            return false;
        }
        return true;
    }

    public zzcr zzi(zzcr zzcr) throws zzcs {
        throw null;
    }

    public final ByteBuffer zzj(int i) {
        if (this.zzf.capacity() < i) {
            this.zzf = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
        } else {
            this.zzf.clear();
        }
        ByteBuffer byteBuffer = this.zzf;
        this.zzg = byteBuffer;
        return byteBuffer;
    }

    public final boolean zzn() {
        return this.zzg.hasRemaining();
    }

    public void zzk() {
    }

    public void zzl() {
    }

    public void zzm() {
    }
}
