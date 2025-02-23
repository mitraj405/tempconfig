package org.spongycastle.crypto.modes;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Arrays;

public class CBCBlockCipher implements BlockCipher {
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public final BlockCipher f6136a = null;

    /* renamed from: a  reason: collision with other field name */
    public boolean f6137a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f6138a;
    public byte[] b;
    public byte[] c;

    public CBCBlockCipher(BlockCipher blockCipher) {
        this.f6136a = blockCipher;
        int c2 = blockCipher.c();
        this.a = c2;
        this.f6138a = new byte[c2];
        this.b = new byte[c2];
        this.c = new byte[c2];
    }

    public final void a(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        boolean z2 = this.f6137a;
        this.f6137a = z;
        boolean z3 = cipherParameters instanceof ParametersWithIV;
        BlockCipher blockCipher = this.f6136a;
        if (z3) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            byte[] bArr = parametersWithIV.f6233a;
            if (bArr.length == this.a) {
                System.arraycopy(bArr, 0, this.f6138a, 0, bArr.length);
                reset();
                CipherParameters cipherParameters2 = parametersWithIV.a;
                if (cipherParameters2 != null) {
                    blockCipher.a(z, cipherParameters2);
                } else if (z2 != z) {
                    throw new IllegalArgumentException("cannot change encrypting state without providing key.");
                }
            } else {
                throw new IllegalArgumentException("initialisation vector must be the same length as block size");
            }
        } else {
            reset();
            if (cipherParameters != null) {
                blockCipher.a(z, cipherParameters);
            } else if (z2 != z) {
                throw new IllegalArgumentException("cannot change encrypting state without providing key.");
            }
        }
    }

    public final String b() {
        return this.f6136a.b() + "/CBC";
    }

    public final int c() {
        return this.f6136a.c();
    }

    public final int e(int i, int i2, byte[] bArr, byte[] bArr2) throws DataLengthException, IllegalStateException {
        boolean z = this.f6137a;
        BlockCipher blockCipher = this.f6136a;
        int i3 = this.a;
        if (z) {
            if (i + i3 <= bArr.length) {
                for (int i4 = 0; i4 < i3; i4++) {
                    byte[] bArr3 = this.b;
                    bArr3[i4] = (byte) (bArr3[i4] ^ bArr[i + i4]);
                }
                int e = blockCipher.e(0, i2, this.b, bArr2);
                byte[] bArr4 = this.b;
                System.arraycopy(bArr2, i2, bArr4, 0, bArr4.length);
                return e;
            }
            throw new DataLengthException("input buffer too short");
        } else if (i + i3 <= bArr.length) {
            System.arraycopy(bArr, i, this.c, 0, i3);
            int e2 = blockCipher.e(i, i2, bArr, bArr2);
            for (int i5 = 0; i5 < i3; i5++) {
                int i6 = i2 + i5;
                bArr2[i6] = (byte) (bArr2[i6] ^ this.b[i5]);
            }
            byte[] bArr5 = this.b;
            this.b = this.c;
            this.c = bArr5;
            return e2;
        } else {
            throw new DataLengthException("input buffer too short");
        }
    }

    public final void reset() {
        byte[] bArr = this.b;
        byte[] bArr2 = this.f6138a;
        System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
        Arrays.p(this.c, (byte) 0);
        this.f6136a.reset();
    }
}
