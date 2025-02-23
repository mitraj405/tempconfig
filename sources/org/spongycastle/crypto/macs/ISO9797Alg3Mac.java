package org.spongycastle.crypto.macs;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.engines.DESEngine;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.paddings.BlockCipherPadding;
import org.spongycastle.crypto.paddings.ISO7816d4Padding;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;

public class ISO9797Alg3Mac implements Mac {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public final CBCBlockCipher f6114a;

    /* renamed from: a  reason: collision with other field name */
    public final BlockCipherPadding f6115a;

    /* renamed from: a  reason: collision with other field name */
    public KeyParameter f6116a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f6117a;
    public final int b;

    /* renamed from: b  reason: collision with other field name */
    public KeyParameter f6118b;

    /* renamed from: b  reason: collision with other field name */
    public final byte[] f6119b;

    public ISO9797Alg3Mac(DESEngine dESEngine, int i, ISO7816d4Padding iSO7816d4Padding) {
        if (i % 8 == 0) {
            this.f6114a = new CBCBlockCipher(dESEngine);
            this.f6115a = iSO7816d4Padding;
            this.b = i / 8;
            this.f6117a = new byte[8];
            this.f6119b = new byte[8];
            this.a = 0;
            return;
        }
        throw new IllegalArgumentException("MAC size must be multiple of 8");
    }

    public final void a(CipherParameters cipherParameters) {
        KeyParameter keyParameter;
        KeyParameter keyParameter2;
        reset();
        boolean z = cipherParameters instanceof KeyParameter;
        if (z || (cipherParameters instanceof ParametersWithIV)) {
            if (z) {
                keyParameter = (KeyParameter) cipherParameters;
            } else {
                keyParameter = (KeyParameter) ((ParametersWithIV) cipherParameters).a;
            }
            byte[] bArr = keyParameter.a;
            if (bArr.length == 16) {
                keyParameter2 = new KeyParameter(bArr, 0, 8);
                this.f6116a = new KeyParameter(bArr, 8, 8);
                this.f6118b = keyParameter2;
            } else if (bArr.length == 24) {
                keyParameter2 = new KeyParameter(bArr, 0, 8);
                this.f6116a = new KeyParameter(bArr, 8, 8);
                this.f6118b = new KeyParameter(bArr, 16, 8);
            } else {
                throw new IllegalArgumentException("Key must be either 112 or 168 bit long");
            }
            boolean z2 = cipherParameters instanceof ParametersWithIV;
            CBCBlockCipher cBCBlockCipher = this.f6114a;
            if (z2) {
                cBCBlockCipher.a(true, new ParametersWithIV(keyParameter2, ((ParametersWithIV) cipherParameters).f6233a));
            } else {
                cBCBlockCipher.a(true, keyParameter2);
            }
        } else {
            throw new IllegalArgumentException("params must be an instance of KeyParameter or ParametersWithIV");
        }
    }

    public final String b() {
        return "ISO9797Alg3";
    }

    public final int c(int i, byte[] bArr) {
        CBCBlockCipher cBCBlockCipher = this.f6114a;
        int c = cBCBlockCipher.c();
        byte[] bArr2 = this.f6119b;
        byte[] bArr3 = this.f6117a;
        BlockCipherPadding blockCipherPadding = this.f6115a;
        if (blockCipherPadding == null) {
            while (true) {
                int i2 = this.a;
                if (i2 >= c) {
                    break;
                }
                bArr2[i2] = 0;
                this.a = i2 + 1;
            }
        } else {
            if (this.a == c) {
                cBCBlockCipher.e(0, 0, bArr2, bArr3);
                this.a = 0;
            }
            blockCipherPadding.a(this.a, bArr2);
        }
        cBCBlockCipher.e(0, 0, bArr2, bArr3);
        DESEngine dESEngine = new DESEngine();
        dESEngine.a(false, this.f6116a);
        dESEngine.e(0, 0, bArr3, bArr3);
        dESEngine.a(true, this.f6118b);
        dESEngine.e(0, 0, bArr3, bArr3);
        int i3 = this.b;
        System.arraycopy(bArr3, 0, bArr, 0, i3);
        reset();
        return i3;
    }

    public final void d(byte b2) {
        int i = this.a;
        byte[] bArr = this.f6119b;
        if (i == bArr.length) {
            this.f6114a.e(0, 0, bArr, this.f6117a);
            this.a = 0;
        }
        int i2 = this.a;
        this.a = i2 + 1;
        bArr[i2] = b2;
    }

    public final int e() {
        return this.b;
    }

    public final void reset() {
        int i = 0;
        while (true) {
            byte[] bArr = this.f6119b;
            if (i < bArr.length) {
                bArr[i] = 0;
                i++;
            } else {
                this.a = 0;
                this.f6114a.reset();
                return;
            }
        }
    }

    public final void update(byte[] bArr, int i, int i2) {
        if (i2 >= 0) {
            CBCBlockCipher cBCBlockCipher = this.f6114a;
            int c = cBCBlockCipher.c();
            int i3 = this.a;
            int i4 = c - i3;
            byte[] bArr2 = this.f6119b;
            if (i2 > i4) {
                System.arraycopy(bArr, i, bArr2, i3, i4);
                byte[] bArr3 = this.f6117a;
                cBCBlockCipher.e(0, 0, bArr2, bArr3);
                this.a = 0;
                i2 -= i4;
                i += i4;
                while (i2 > c) {
                    cBCBlockCipher.e(i, 0, bArr, bArr3);
                    i2 -= c;
                    i += c;
                }
            }
            System.arraycopy(bArr, i, bArr2, this.a, i2);
            this.a += i2;
            return;
        }
        throw new IllegalArgumentException("Can't have a negative input length!");
    }
}
