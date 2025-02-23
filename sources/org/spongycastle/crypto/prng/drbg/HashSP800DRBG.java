package org.spongycastle.crypto.prng.drbg;

import com.google.common.primitives.UnsignedBytes;
import java.util.Hashtable;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.prng.EntropySource;
import org.spongycastle.util.Arrays;

public class HashSP800DRBG implements SP80090DRBG {
    public static final Hashtable a;
    public static final byte[] c = {1};

    /* renamed from: a  reason: collision with other field name */
    public final int f6261a;

    /* renamed from: a  reason: collision with other field name */
    public long f6262a;

    /* renamed from: a  reason: collision with other field name */
    public final Digest f6263a;

    /* renamed from: a  reason: collision with other field name */
    public final EntropySource f6264a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f6265a;
    public final int b;

    /* renamed from: b  reason: collision with other field name */
    public byte[] f6266b;

    static {
        Hashtable hashtable = new Hashtable();
        a = hashtable;
        hashtable.put("SHA-1", 440);
        hashtable.put("SHA-224", 440);
        hashtable.put("SHA-256", 440);
        hashtable.put("SHA-512/256", 440);
        hashtable.put("SHA-512/224", 440);
        hashtable.put("SHA-384", 888);
        hashtable.put("SHA-512", 888);
    }

    public HashSP800DRBG(Digest digest, int i, EntropySource entropySource, byte[] bArr, byte[] bArr2) {
        if (i > ((Integer) Utils.a.get(digest.b())).intValue()) {
            throw new IllegalArgumentException("Requested security strength is not supported by the derivation function");
        } else if (entropySource.b() >= i) {
            this.f6263a = digest;
            this.f6264a = entropySource;
            this.f6261a = i;
            int intValue = ((Integer) a.get(digest.b())).intValue();
            this.b = intValue;
            byte[] a2 = entropySource.a();
            if (a2.length >= (i + 7) / 8) {
                byte[] a3 = Utils.a(intValue, digest, Arrays.j(a2, bArr2, bArr));
                this.f6265a = a3;
                byte[] bArr3 = new byte[(a3.length + 1)];
                System.arraycopy(a3, 0, bArr3, 1, a3.length);
                this.f6266b = Utils.a(intValue, digest, bArr3);
                this.f6262a = 1;
                return;
            }
            throw new IllegalStateException("Insufficient entropy provided by entropy source");
        } else {
            throw new IllegalArgumentException("Not enough entropy for security strength required");
        }
    }

    public static void c(byte[] bArr, byte[] bArr2) {
        byte b2;
        byte b3 = 0;
        for (int i = 1; i <= bArr2.length; i++) {
            int i2 = (bArr[bArr.length - i] & UnsignedBytes.MAX_VALUE) + (bArr2[bArr2.length - i] & UnsignedBytes.MAX_VALUE) + b3;
            if (i2 > 255) {
                b3 = 1;
            } else {
                b3 = 0;
            }
            bArr[bArr.length - i] = (byte) i2;
        }
        for (int length = bArr2.length + 1; length <= bArr.length; length++) {
            int i3 = (bArr[bArr.length - length] & UnsignedBytes.MAX_VALUE) + b3;
            if (i3 > 255) {
                b2 = 1;
            } else {
                b2 = 0;
            }
            bArr[bArr.length - length] = (byte) i3;
        }
    }

    public final void a() {
        byte[] a2 = this.f6264a.a();
        if (a2.length >= (this.f6261a + 7) / 8) {
            byte[] k = Arrays.k(c, this.f6265a, a2, (byte[]) null);
            int i = this.b;
            Digest digest = this.f6263a;
            byte[] a3 = Utils.a(i, digest, k);
            this.f6265a = a3;
            byte[] bArr = new byte[(a3.length + 1)];
            bArr[0] = 0;
            System.arraycopy(a3, 0, bArr, 1, a3.length);
            this.f6266b = Utils.a(i, digest, bArr);
            this.f6262a = 1;
            return;
        }
        throw new IllegalStateException("Insufficient entropy provided by entropy source");
    }

    public final int b(byte[] bArr, boolean z) {
        int length = bArr.length * 8;
        if (length > 262144) {
            throw new IllegalArgumentException("Number of bits per request limited to 262144");
        } else if (this.f6262a > 140737488355328L) {
            return -1;
        } else {
            if (z) {
                a();
            }
            byte[] bArr2 = this.f6265a;
            Digest digest = this.f6263a;
            int i = length / 8;
            int f = i / digest.f();
            int length2 = bArr2.length;
            byte[] bArr3 = new byte[length2];
            System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
            byte[] bArr4 = new byte[i];
            int f2 = digest.f();
            byte[] bArr5 = new byte[f2];
            for (int i2 = 0; i2 <= f; i2++) {
                digest.update(bArr3, 0, length2);
                digest.c(0, bArr5);
                int i3 = i2 * f2;
                int i4 = i - i3;
                if (i4 > f2) {
                    i4 = f2;
                }
                System.arraycopy(bArr5, 0, bArr4, i3, i4);
                c(bArr3, c);
            }
            byte[] bArr6 = this.f6265a;
            int length3 = bArr6.length + 1;
            byte[] bArr7 = new byte[length3];
            System.arraycopy(bArr6, 0, bArr7, 1, bArr6.length);
            bArr7[0] = 3;
            byte[] bArr8 = new byte[digest.f()];
            digest.update(bArr7, 0, length3);
            digest.c(0, bArr8);
            c(this.f6265a, bArr8);
            c(this.f6265a, this.f6266b);
            long j = this.f6262a;
            c(this.f6265a, new byte[]{(byte) ((int) (j >> 24)), (byte) ((int) (j >> 16)), (byte) ((int) (j >> 8)), (byte) ((int) j)});
            this.f6262a++;
            System.arraycopy(bArr4, 0, bArr, 0, bArr.length);
            return length;
        }
    }
}
