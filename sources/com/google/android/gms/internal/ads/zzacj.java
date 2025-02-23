package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzacj implements zzadp {
    private final byte[] zza = new byte[4096];

    public final /* synthetic */ int zzf(zzp zzp, int i, boolean z) {
        return zzadn.zza(this, zzp, i, z);
    }

    public final int zzg(zzp zzp, int i, boolean z, int i2) throws IOException {
        int zza2 = zzp.zza(this.zza, 0, Math.min(4096, i));
        if (zza2 != -1) {
            return zza2;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }

    public final /* synthetic */ void zzq(zzek zzek, int i) {
        zzadn.zzb(this, zzek, i);
    }

    public final void zzr(zzek zzek, int i, int i2) {
        zzek.zzL(i);
    }

    public final void zzl(zzaf zzaf) {
    }

    public final void zzs(long j, int i, int i2, int i3, zzado zzado) {
    }
}
