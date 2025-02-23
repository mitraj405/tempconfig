package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.facebook.ads.AdError;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzfn extends zzfl {
    private Uri zza;
    private byte[] zzb;
    private int zzc;
    private int zzd;
    private boolean zze;
    private final zzfm zzf;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzfn(byte[] bArr) {
        super(false);
        zzfm zzfm = new zzfm(bArr);
        boolean z = false;
        this.zzf = zzfm;
        zzdi.zzd(bArr.length > 0 ? true : z);
    }

    public final int zza(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        int i3 = this.zzd;
        if (i3 == 0) {
            return -1;
        }
        int min = Math.min(i2, i3);
        byte[] bArr2 = this.zzb;
        zzdi.zzb(bArr2);
        System.arraycopy(bArr2, this.zzc, bArr, i, min);
        this.zzc += min;
        this.zzd -= min;
        zzg(min);
        return min;
    }

    public final long zzb(zzfy zzfy) throws IOException {
        zzi(zzfy);
        this.zza = zzfy.zza;
        byte[] bArr = this.zzf.zza;
        this.zzb = bArr;
        long j = zzfy.zze;
        int length = bArr.length;
        if (j <= ((long) length)) {
            int i = (int) j;
            this.zzc = i;
            int i2 = length - i;
            this.zzd = i2;
            long j2 = zzfy.zzf;
            if (j2 != -1) {
                this.zzd = (int) Math.min((long) i2, j2);
            }
            this.zze = true;
            zzj(zzfy);
            long j3 = zzfy.zzf;
            if (j3 != -1) {
                return j3;
            }
            return (long) this.zzd;
        }
        throw new zzft(AdError.REMOTE_ADS_SERVICE_ERROR);
    }

    public final Uri zzc() {
        return this.zza;
    }

    public final void zzd() {
        if (this.zze) {
            this.zze = false;
            zzh();
        }
        this.zza = null;
        this.zzb = null;
    }
}
