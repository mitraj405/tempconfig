package org.spongycastle.crypto.engines;

import java.util.ArrayList;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.Wrapper;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.util.Arrays;

public class DSTU7624WrapEngine implements Wrapper {
    public final ArrayList<byte[]> a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    public final DSTU7624Engine f5951a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f5952a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f5953a;
    public final byte[] b = new byte[4];
    public final byte[] c;
    public final byte[] d;

    public DSTU7624WrapEngine(int i) {
        DSTU7624Engine dSTU7624Engine = new DSTU7624Engine(i);
        this.f5951a = dSTU7624Engine;
        this.f5953a = new byte[(dSTU7624Engine.c() / 2)];
        this.c = new byte[dSTU7624Engine.c()];
        this.d = new byte[dSTU7624Engine.c()];
    }

    public final void a(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithRandom) {
            cipherParameters = ((ParametersWithRandom) cipherParameters).f6234a;
        }
        this.f5952a = z;
        if (cipherParameters instanceof KeyParameter) {
            this.f5951a.a(z, cipherParameters);
            return;
        }
        throw new IllegalArgumentException("invalid parameters passed to DSTU7624WrapEngine");
    }

    public final String b() {
        return "DSTU7624WrapEngine";
    }

    public final byte[] c(byte[] bArr, int i) throws InvalidCipherTextException {
        int i2 = i;
        if (!this.f5952a) {
            DSTU7624Engine dSTU7624Engine = this.f5951a;
            if (i2 % dSTU7624Engine.c() == 0) {
                int c2 = (i2 * 2) / dSTU7624Engine.c();
                int i3 = c2 - 1;
                int i4 = i3 * 6;
                byte[] bArr2 = new byte[i2];
                System.arraycopy(bArr, 0, bArr2, 0, i2);
                byte[] bArr3 = new byte[(dSTU7624Engine.c() / 2)];
                System.arraycopy(bArr2, 0, bArr3, 0, dSTU7624Engine.c() / 2);
                ArrayList<byte[]> arrayList = this.a;
                arrayList.clear();
                int c3 = i2 - (dSTU7624Engine.c() / 2);
                int c4 = dSTU7624Engine.c() / 2;
                while (c3 != 0) {
                    byte[] bArr4 = new byte[(dSTU7624Engine.c() / 2)];
                    System.arraycopy(bArr2, c4, bArr4, 0, dSTU7624Engine.c() / 2);
                    arrayList.add(bArr4);
                    c3 -= dSTU7624Engine.c() / 2;
                    c4 += dSTU7624Engine.c() / 2;
                }
                for (int i5 = 0; i5 < i4; i5++) {
                    System.arraycopy(arrayList.get(c2 - 2), 0, bArr2, 0, dSTU7624Engine.c() / 2);
                    System.arraycopy(bArr3, 0, bArr2, dSTU7624Engine.c() / 2, dSTU7624Engine.c() / 2);
                    int i6 = i4 - i5;
                    byte[] bArr5 = this.b;
                    bArr5[3] = (byte) (i6 >> 24);
                    bArr5[2] = (byte) (i6 >> 16);
                    bArr5[1] = (byte) (i6 >> 8);
                    bArr5[0] = (byte) i6;
                    for (int i7 = 0; i7 < 4; i7++) {
                        int c5 = (dSTU7624Engine.c() / 2) + i7;
                        bArr2[c5] = (byte) (bArr2[c5] ^ bArr5[i7]);
                    }
                    dSTU7624Engine.e(0, 0, bArr2, bArr2);
                    System.arraycopy(bArr2, 0, bArr3, 0, dSTU7624Engine.c() / 2);
                    for (int i8 = 2; i8 < c2; i8++) {
                        int i9 = c2 - i8;
                        System.arraycopy(arrayList.get(i9 - 1), 0, arrayList.get(i9), 0, dSTU7624Engine.c() / 2);
                    }
                    System.arraycopy(bArr2, dSTU7624Engine.c() / 2, arrayList.get(0), 0, dSTU7624Engine.c() / 2);
                }
                System.arraycopy(bArr3, 0, bArr2, 0, dSTU7624Engine.c() / 2);
                int c6 = dSTU7624Engine.c() / 2;
                for (int i10 = 0; i10 < i3; i10++) {
                    System.arraycopy(arrayList.get(i10), 0, bArr2, c6, dSTU7624Engine.c() / 2);
                    c6 += dSTU7624Engine.c() / 2;
                }
                int c7 = dSTU7624Engine.c();
                byte[] bArr6 = this.c;
                System.arraycopy(bArr2, i2 - dSTU7624Engine.c(), bArr6, 0, c7);
                byte[] bArr7 = new byte[(i2 - dSTU7624Engine.c())];
                if (Arrays.a(bArr6, this.d)) {
                    System.arraycopy(bArr2, 0, bArr7, 0, i2 - dSTU7624Engine.c());
                    return bArr7;
                }
                throw new InvalidCipherTextException("checksum failed");
            }
            throw new DataLengthException("unwrap data must be a multiple of " + dSTU7624Engine.c() + " bytes");
        }
        throw new IllegalStateException("not set for unwrapping");
    }

    public final byte[] d(byte[] bArr, int i) {
        byte[] bArr2 = bArr;
        int i2 = i;
        if (this.f5952a) {
            DSTU7624Engine dSTU7624Engine = this.f5951a;
            if (i2 % dSTU7624Engine.c() != 0) {
                throw new DataLengthException("wrap data must be a multiple of " + dSTU7624Engine.c() + " bytes");
            } else if (0 + i2 <= bArr2.length) {
                int c2 = ((i2 / dSTU7624Engine.c()) + 1) * 2;
                int i3 = c2 - 1;
                int i4 = i3 * 6;
                int c3 = dSTU7624Engine.c() + i2;
                byte[] bArr3 = new byte[c3];
                System.arraycopy(bArr2, 0, bArr3, 0, i2);
                byte[] bArr4 = this.f5953a;
                System.arraycopy(bArr3, 0, bArr4, 0, dSTU7624Engine.c() / 2);
                ArrayList<byte[]> arrayList = this.a;
                arrayList.clear();
                int c4 = c3 - (dSTU7624Engine.c() / 2);
                int c5 = dSTU7624Engine.c() / 2;
                while (c4 != 0) {
                    byte[] bArr5 = new byte[(dSTU7624Engine.c() / 2)];
                    System.arraycopy(bArr3, c5, bArr5, 0, dSTU7624Engine.c() / 2);
                    arrayList.add(bArr5);
                    c4 -= dSTU7624Engine.c() / 2;
                    c5 += dSTU7624Engine.c() / 2;
                }
                int i5 = 0;
                while (i5 < i4) {
                    System.arraycopy(bArr4, 0, bArr3, 0, dSTU7624Engine.c() / 2);
                    System.arraycopy(arrayList.get(0), 0, bArr3, dSTU7624Engine.c() / 2, dSTU7624Engine.c() / 2);
                    dSTU7624Engine.e(0, 0, bArr3, bArr3);
                    i5++;
                    byte[] bArr6 = this.b;
                    bArr6[3] = (byte) (i5 >> 24);
                    bArr6[2] = (byte) (i5 >> 16);
                    bArr6[1] = (byte) (i5 >> 8);
                    bArr6[0] = (byte) i5;
                    for (int i6 = 0; i6 < 4; i6++) {
                        int c6 = (dSTU7624Engine.c() / 2) + i6;
                        bArr3[c6] = (byte) (bArr3[c6] ^ bArr6[i6]);
                    }
                    System.arraycopy(bArr3, dSTU7624Engine.c() / 2, bArr4, 0, dSTU7624Engine.c() / 2);
                    for (int i7 = 2; i7 < c2; i7++) {
                        System.arraycopy(arrayList.get(i7 - 1), 0, arrayList.get(i7 - 2), 0, dSTU7624Engine.c() / 2);
                    }
                    System.arraycopy(bArr3, 0, arrayList.get(c2 - 2), 0, dSTU7624Engine.c() / 2);
                }
                System.arraycopy(bArr4, 0, bArr3, 0, dSTU7624Engine.c() / 2);
                int c7 = dSTU7624Engine.c() / 2;
                for (int i8 = 0; i8 < i3; i8++) {
                    System.arraycopy(arrayList.get(i8), 0, bArr3, c7, dSTU7624Engine.c() / 2);
                    c7 += dSTU7624Engine.c() / 2;
                }
                return bArr3;
            } else {
                throw new DataLengthException("input buffer too short");
            }
        } else {
            throw new IllegalStateException("not set for wrapping");
        }
    }
}
