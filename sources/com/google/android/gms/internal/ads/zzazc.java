package com.google.android.gms.internal.ads;

import com.google.firebase.perf.util.Constants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzazc extends zzayx {
    private MessageDigest zzb;

    public final byte[] zzb(String str) {
        byte[] bArr;
        byte[] bArr2;
        String[] split = str.split(" ");
        int length = split.length;
        int i = 4;
        if (length == 1) {
            int zza = zzazb.zza(split[0]);
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            allocate.putInt(zza);
            bArr = allocate.array();
        } else {
            if (length < 5) {
                bArr2 = new byte[(length + length)];
                for (int i2 = 0; i2 < split.length; i2++) {
                    int zza2 = zzazb.zza(split[i2]);
                    char c = (zza2 >> 16) ^ ((char) zza2);
                    int i3 = i2 + i2;
                    bArr2[i3] = (byte) c;
                    bArr2[i3 + 1] = (byte) (c >> 8);
                }
            } else {
                bArr2 = new byte[length];
                for (int i4 = 0; i4 < split.length; i4++) {
                    int zza3 = zzazb.zza(split[i4]);
                    bArr2[i4] = (byte) ((zza3 >> 24) ^ (((zza3 & Constants.MAX_HOST_LENGTH) ^ ((zza3 >> 8) & Constants.MAX_HOST_LENGTH)) ^ ((zza3 >> 16) & Constants.MAX_HOST_LENGTH)));
                }
            }
            bArr = bArr2;
        }
        this.zzb = zza();
        synchronized (this.zza) {
            MessageDigest messageDigest = this.zzb;
            if (messageDigest == null) {
                byte[] bArr3 = new byte[0];
                return bArr3;
            }
            messageDigest.reset();
            this.zzb.update(bArr);
            byte[] digest = this.zzb.digest();
            int length2 = digest.length;
            if (length2 <= 4) {
                i = length2;
            }
            byte[] bArr4 = new byte[i];
            System.arraycopy(digest, 0, bArr4, 0, i);
            return bArr4;
        }
    }
}
