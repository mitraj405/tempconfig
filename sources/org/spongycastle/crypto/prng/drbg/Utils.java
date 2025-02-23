package org.spongycastle.crypto.prng.drbg;

import com.google.common.primitives.UnsignedBytes;
import java.util.Hashtable;
import org.spongycastle.crypto.Digest;

class Utils {
    public static final Hashtable a;

    static {
        Hashtable hashtable = new Hashtable();
        a = hashtable;
        hashtable.put("SHA-1", 128);
        hashtable.put("SHA-224", 192);
        hashtable.put("SHA-256", 256);
        hashtable.put("SHA-384", 256);
        hashtable.put("SHA-512", 256);
        hashtable.put("SHA-512/224", 192);
        hashtable.put("SHA-512/256", 256);
    }

    public static byte[] a(int i, Digest digest, byte[] bArr) {
        int i2 = (i + 7) / 8;
        byte[] bArr2 = new byte[i2];
        int f = i2 / digest.f();
        int f2 = digest.f();
        byte[] bArr3 = new byte[f2];
        int i3 = 1;
        int i4 = 0;
        for (int i5 = 0; i5 <= f; i5++) {
            digest.d((byte) i3);
            digest.d((byte) (i >> 24));
            digest.d((byte) (i >> 16));
            digest.d((byte) (i >> 8));
            digest.d((byte) i);
            digest.update(bArr, 0, bArr.length);
            digest.c(0, bArr3);
            int i6 = i5 * f2;
            int i7 = i2 - i6;
            if (i7 > f2) {
                i7 = f2;
            }
            System.arraycopy(bArr3, 0, bArr2, i6, i7);
            i3++;
        }
        int i8 = i % 8;
        if (i8 != 0) {
            int i9 = 8 - i8;
            byte b = 0;
            while (i4 != i2) {
                byte b2 = bArr2[i4] & UnsignedBytes.MAX_VALUE;
                bArr2[i4] = (byte) ((b << (8 - i9)) | (b2 >>> i9));
                i4++;
                b = b2;
            }
        }
        return bArr2;
    }
}
