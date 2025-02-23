package org.spongycastle.pqc.crypto.newhope;

import com.google.common.primitives.UnsignedBytes;
import org.spongycastle.crypto.digests.SHAKEDigest;

class NewHope {
    public static void a(byte[] bArr, short[] sArr) {
        SHAKEDigest sHAKEDigest = new SHAKEDigest(128);
        sHAKEDigest.i(0, bArr, bArr.length);
        int i = 0;
        while (true) {
            byte[] bArr2 = new byte[256];
            if (!sHAKEDigest.f5845a) {
                sHAKEDigest.j(15, 4);
            }
            sHAKEDigest.m(((long) 256) * 8, bArr2, 0);
            int i2 = 0;
            while (true) {
                if (i2 < 256) {
                    byte b = ((bArr2[i2] & UnsignedBytes.MAX_VALUE) | ((bArr2[i2 + 1] & UnsignedBytes.MAX_VALUE) << 8)) & UnsignedBytes.MAX_VALUE;
                    if (b < 12289) {
                        int i3 = i + 1;
                        sArr[i] = (short) b;
                        if (i3 != 1024) {
                            i = i3;
                        } else {
                            return;
                        }
                    }
                    i2 += 2;
                }
            }
        }
    }
}
