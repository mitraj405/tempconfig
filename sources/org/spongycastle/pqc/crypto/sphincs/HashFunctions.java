package org.spongycastle.pqc.crypto.sphincs;

import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.ExtendedDigest;
import org.spongycastle.util.Strings;

class HashFunctions {
    public static final byte[] a = Strings.d("expand 32-byte to 64-byte state!");

    /* renamed from: a  reason: collision with other field name */
    public final Digest f6744a;

    /* renamed from: a  reason: collision with other field name */
    public final Permute f6745a = new Permute();
    public final Digest b;

    public HashFunctions(Digest digest, ExtendedDigest extendedDigest) {
        this.f6744a = digest;
        this.b = extendedDigest;
    }

    public final void a(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, int i3) {
        byte[] bArr4 = new byte[64];
        for (int i4 = 0; i4 < 64; i4++) {
            bArr4[i4] = (byte) (bArr2[i2 + i4] ^ bArr3[i3 + i4]);
        }
        byte[] bArr5 = new byte[64];
        for (int i5 = 0; i5 < 32; i5++) {
            bArr5[i5] = bArr4[0 + i5];
            bArr5[i5 + 32] = a[i5];
        }
        this.f6745a.getClass();
        Permute.a(bArr5, bArr5);
        for (int i6 = 0; i6 < 32; i6++) {
            bArr5[i6] = (byte) (bArr5[i6] ^ bArr4[(0 + i6) + 32]);
        }
        Permute.a(bArr5, bArr5);
        for (int i7 = 0; i7 < 32; i7++) {
            bArr[i + i7] = bArr5[i7];
        }
    }

    public final void b(int i, int i2, byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[64];
        for (int i3 = 0; i3 < 32; i3++) {
            bArr3[i3] = bArr2[i2 + i3];
            bArr3[i3 + 32] = a[i3];
        }
        this.f6745a.getClass();
        Permute.a(bArr3, bArr3);
        for (int i4 = 0; i4 < 32; i4++) {
            bArr[i + i4] = bArr3[i4];
        }
    }
}
