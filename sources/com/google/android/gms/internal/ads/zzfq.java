package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.util.Base64;
import com.facebook.ads.AdError;
import com.google.firebase.messaging.Constants;
import java.io.IOException;
import java.net.URLDecoder;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzfq extends zzfl {
    private zzfy zza;
    private byte[] zzb;
    private int zzc;
    private int zzd;

    public zzfq() {
        super(false);
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
        int i4 = zzet.zza;
        System.arraycopy(bArr2, this.zzc, bArr, i, min);
        this.zzc += min;
        this.zzd -= min;
        zzg(min);
        return min;
    }

    public final long zzb(zzfy zzfy) throws IOException {
        zzi(zzfy);
        this.zza = zzfy;
        Uri normalizeScheme = zzfy.zza.normalizeScheme();
        String scheme = normalizeScheme.getScheme();
        zzdi.zze(Constants.ScionAnalytics.MessageType.DATA_MESSAGE.equals(scheme), "Unsupported scheme: ".concat(String.valueOf(scheme)));
        String schemeSpecificPart = normalizeScheme.getSchemeSpecificPart();
        int i = zzet.zza;
        String[] split = schemeSpecificPart.split(",", -1);
        if (split.length == 2) {
            String str = split[1];
            if (split[0].contains(";base64")) {
                try {
                    this.zzb = Base64.decode(str, 0);
                } catch (IllegalArgumentException e) {
                    throw zzbo.zzb("Error while parsing Base64 encoded string: ".concat(String.valueOf(str)), e);
                }
            } else {
                this.zzb = URLDecoder.decode(str, zzfuj.zza.name()).getBytes(zzfuj.zzc);
            }
            long j = zzfy.zze;
            int length = this.zzb.length;
            if (j <= ((long) length)) {
                int i2 = (int) j;
                this.zzc = i2;
                int i3 = length - i2;
                this.zzd = i3;
                long j2 = zzfy.zzf;
                if (j2 != -1) {
                    this.zzd = (int) Math.min((long) i3, j2);
                }
                zzj(zzfy);
                long j3 = zzfy.zzf;
                if (j3 != -1) {
                    return j3;
                }
                return (long) this.zzd;
            }
            this.zzb = null;
            throw new zzft(AdError.REMOTE_ADS_SERVICE_ERROR);
        }
        throw zzbo.zzb("Unexpected URI format: ".concat(String.valueOf(normalizeScheme)), (Throwable) null);
    }

    public final Uri zzc() {
        zzfy zzfy = this.zza;
        if (zzfy != null) {
            return zzfy.zza;
        }
        return null;
    }

    public final void zzd() {
        if (this.zzb != null) {
            this.zzb = null;
            zzh();
        }
        this.zza = null;
    }
}
