package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzcq {
    private final zzfxr zza;
    private final List zzb = new ArrayList();
    private ByteBuffer[] zzc = new ByteBuffer[0];
    private boolean zzd;

    public zzcq(zzfxr zzfxr) {
        this.zza = zzfxr;
        zzcr zzcr = zzcr.zza;
        this.zzd = false;
    }

    private final int zzi() {
        return this.zzc.length - 1;
    }

    private final void zzj(ByteBuffer byteBuffer) {
        boolean z;
        ByteBuffer byteBuffer2;
        do {
            z = false;
            for (int i = 0; i <= zzi(); i++) {
                if (!this.zzc[i].hasRemaining()) {
                    zzct zzct = (zzct) this.zzb.get(i);
                    if (!zzct.zzh()) {
                        if (i > 0) {
                            byteBuffer2 = this.zzc[i - 1];
                        } else if (byteBuffer.hasRemaining()) {
                            byteBuffer2 = byteBuffer;
                        } else {
                            byteBuffer2 = zzct.zza;
                        }
                        zzct.zze(byteBuffer2);
                        this.zzc[i] = zzct.zzb();
                        int i2 = ((((long) byteBuffer2.remaining()) - ((long) byteBuffer2.remaining())) > 0 ? 1 : ((((long) byteBuffer2.remaining()) - ((long) byteBuffer2.remaining())) == 0 ? 0 : -1));
                        boolean z2 = true;
                        if (i2 <= 0 && !this.zzc[i].hasRemaining()) {
                            z2 = false;
                        }
                        z |= z2;
                    } else if (!this.zzc[i].hasRemaining() && i < zzi()) {
                        ((zzct) this.zzb.get(i + 1)).zzd();
                    }
                }
            }
        } while (z);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzcq)) {
            return false;
        }
        zzcq zzcq = (zzcq) obj;
        if (this.zza.size() != zzcq.zza.size()) {
            return false;
        }
        for (int i = 0; i < this.zza.size(); i++) {
            if (this.zza.get(i) != zzcq.zza.get(i)) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final zzcr zza(zzcr zzcr) throws zzcs {
        if (!zzcr.equals(zzcr.zza)) {
            for (int i = 0; i < this.zza.size(); i++) {
                zzct zzct = (zzct) this.zza.get(i);
                zzcr zza2 = zzct.zza(zzcr);
                if (zzct.zzg()) {
                    zzdi.zzf(!zza2.equals(zzcr.zza));
                    zzcr = zza2;
                }
            }
            return zzcr;
        }
        throw new zzcs("Unhandled input format:", zzcr);
    }

    public final ByteBuffer zzb() {
        if (!zzh()) {
            return zzct.zza;
        }
        ByteBuffer byteBuffer = this.zzc[zzi()];
        if (byteBuffer.hasRemaining()) {
            return byteBuffer;
        }
        zzj(zzct.zza);
        return this.zzc[zzi()];
    }

    public final void zzc() {
        this.zzb.clear();
        this.zzd = false;
        for (int i = 0; i < this.zza.size(); i++) {
            zzct zzct = (zzct) this.zza.get(i);
            zzct.zzc();
            if (zzct.zzg()) {
                this.zzb.add(zzct);
            }
        }
        this.zzc = new ByteBuffer[this.zzb.size()];
        for (int i2 = 0; i2 <= zzi(); i2++) {
            this.zzc[i2] = ((zzct) this.zzb.get(i2)).zzb();
        }
    }

    public final void zzd() {
        if (zzh() && !this.zzd) {
            this.zzd = true;
            ((zzct) this.zzb.get(0)).zzd();
        }
    }

    public final void zze(ByteBuffer byteBuffer) {
        if (zzh() && !this.zzd) {
            zzj(byteBuffer);
        }
    }

    public final void zzf() {
        for (int i = 0; i < this.zza.size(); i++) {
            zzct zzct = (zzct) this.zza.get(i);
            zzct.zzc();
            zzct.zzf();
        }
        this.zzc = new ByteBuffer[0];
        zzcr zzcr = zzcr.zza;
        this.zzd = false;
    }

    public final boolean zzg() {
        if (!this.zzd || !((zzct) this.zzb.get(zzi())).zzh() || this.zzc[zzi()].hasRemaining()) {
            return false;
        }
        return true;
    }

    public final boolean zzh() {
        if (!this.zzb.isEmpty()) {
            return true;
        }
        return false;
    }
}
