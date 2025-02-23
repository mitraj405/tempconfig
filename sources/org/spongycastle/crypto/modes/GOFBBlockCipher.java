package org.spongycastle.crypto.modes;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.StreamBlockCipher;
import org.spongycastle.crypto.params.ParametersWithIV;

public class GOFBBlockCipher extends StreamBlockCipher {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f6173a = true;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f6174a;
    public final int b;

    /* renamed from: b  reason: collision with other field name */
    public final BlockCipher f6175b;

    /* renamed from: b  reason: collision with other field name */
    public final byte[] f6176b;
    public int c;

    /* renamed from: c  reason: collision with other field name */
    public final byte[] f6177c;
    public int d;

    public GOFBBlockCipher(BlockCipher blockCipher) {
        super(blockCipher);
        this.f6175b = blockCipher;
        int c2 = blockCipher.c();
        this.b = c2;
        if (c2 == 8) {
            this.f6174a = new byte[blockCipher.c()];
            this.f6176b = new byte[blockCipher.c()];
            this.f6177c = new byte[blockCipher.c()];
            return;
        }
        throw new IllegalArgumentException("GCTR only for 64 bit block ciphers");
    }

    public final void a(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        this.f6173a = true;
        this.c = 0;
        this.d = 0;
        boolean z2 = cipherParameters instanceof ParametersWithIV;
        BlockCipher blockCipher = this.f6175b;
        if (z2) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            byte[] bArr = parametersWithIV.f6233a;
            int length = bArr.length;
            byte[] bArr2 = this.f6174a;
            if (length < bArr2.length) {
                System.arraycopy(bArr, 0, bArr2, bArr2.length - bArr.length, bArr.length);
                for (int i = 0; i < bArr2.length - bArr.length; i++) {
                    bArr2[i] = 0;
                }
            } else {
                System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
            }
            reset();
            CipherParameters cipherParameters2 = parametersWithIV.a;
            if (cipherParameters2 != null) {
                blockCipher.a(true, cipherParameters2);
                return;
            }
            return;
        }
        reset();
        if (cipherParameters != null) {
            blockCipher.a(true, cipherParameters);
        }
    }

    public final String b() {
        return this.f6175b.b() + "/GCTR";
    }

    public final int c() {
        return this.b;
    }

    public final int e(int i, int i2, byte[] bArr, byte[] bArr2) throws DataLengthException, IllegalStateException {
        d(bArr, i, this.b, bArr2, i2);
        return this.b;
    }

    public final byte f(byte b2) {
        int i = this.a;
        byte[] bArr = this.f6176b;
        byte[] bArr2 = this.f6177c;
        if (i == 0) {
            boolean z = this.f6173a;
            BlockCipher blockCipher = this.f6175b;
            if (z) {
                this.f6173a = false;
                blockCipher.e(0, 0, bArr, bArr2);
                this.c = g(0, bArr2);
                this.d = g(4, bArr2);
            }
            int i2 = this.c + 16843009;
            this.c = i2;
            int i3 = this.d + 16843012;
            this.d = i3;
            if (i3 < 16843012 && i3 > 0) {
                this.d = i3 + 1;
            }
            bArr[3] = (byte) (i2 >>> 24);
            bArr[2] = (byte) (i2 >>> 16);
            bArr[1] = (byte) (i2 >>> 8);
            bArr[0] = (byte) i2;
            int i4 = this.d;
            bArr[7] = (byte) (i4 >>> 24);
            bArr[6] = (byte) (i4 >>> 16);
            bArr[5] = (byte) (i4 >>> 8);
            bArr[4] = (byte) i4;
            blockCipher.e(0, 0, bArr, bArr2);
        }
        int i5 = this.a;
        int i6 = i5 + 1;
        this.a = i6;
        byte b3 = (byte) (b2 ^ bArr2[i5]);
        int i7 = this.b;
        if (i6 == i7) {
            this.a = 0;
            System.arraycopy(bArr, i7, bArr, 0, bArr.length - i7);
            System.arraycopy(bArr2, 0, bArr, bArr.length - i7, i7);
        }
        return b3;
    }

    public final int g(int i, byte[] bArr) {
        return ((bArr[i + 3] << Ascii.CAN) & -16777216) + ((bArr[i + 2] << Ascii.DLE) & 16711680) + ((bArr[i + 1] << 8) & 65280) + (bArr[i] & UnsignedBytes.MAX_VALUE);
    }

    public final void reset() {
        this.f6173a = true;
        this.c = 0;
        this.d = 0;
        byte[] bArr = this.f6176b;
        byte[] bArr2 = this.f6174a;
        System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
        this.a = 0;
        this.f6175b.reset();
    }
}
