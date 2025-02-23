package com.google.android.gms.internal.ads;

import com.google.common.primitives.Ints;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzrx extends zzhd {
    private long zzg;
    private int zzh;
    private int zzi = 32;

    public zzrx() {
        super(2, 0);
    }

    public final void zzb() {
        super.zzb();
        this.zzh = 0;
    }

    public final int zzl() {
        return this.zzh;
    }

    public final long zzm() {
        return this.zzg;
    }

    public final void zzn(int i) {
        this.zzi = i;
    }

    public final boolean zzo(zzhd zzhd) {
        ByteBuffer byteBuffer;
        zzdi.zzd(!zzhd.zzd(Ints.MAX_POWER_OF_TWO));
        zzdi.zzd(!zzhd.zzd(268435456));
        zzdi.zzd(!zzhd.zzd(4));
        if (zzp()) {
            if (this.zzh >= this.zzi) {
                return false;
            }
            ByteBuffer byteBuffer2 = zzhd.zzc;
            if (!(byteBuffer2 == null || (byteBuffer = this.zzc) == null)) {
                if (byteBuffer2.remaining() + byteBuffer.position() > 3072000) {
                    return false;
                }
            }
        }
        int i = this.zzh;
        this.zzh = i + 1;
        if (i == 0) {
            this.zze = zzhd.zze;
            if (zzhd.zzd(1)) {
                zzc(1);
            }
        }
        ByteBuffer byteBuffer3 = zzhd.zzc;
        if (byteBuffer3 != null) {
            zzi(byteBuffer3.remaining());
            this.zzc.put(byteBuffer3);
        }
        this.zzg = zzhd.zze;
        return true;
    }

    public final boolean zzp() {
        if (this.zzh > 0) {
            return true;
        }
        return false;
    }
}
