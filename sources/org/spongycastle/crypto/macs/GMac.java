package org.spongycastle.crypto.macs;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.modes.GCMBlockCipher;
import org.spongycastle.crypto.modes.gcm.GCMUtil;
import org.spongycastle.crypto.params.AEADParameters;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;

public class GMac implements Mac {
    public final GCMBlockCipher a;

    public GMac(GCMBlockCipher gCMBlockCipher) {
        this.a = gCMBlockCipher;
    }

    public final void a(CipherParameters cipherParameters) throws IllegalArgumentException {
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            this.a.a(true, new AEADParameters((KeyParameter) parametersWithIV.a, 128, parametersWithIV.f6233a, (byte[]) null));
            return;
        }
        throw new IllegalArgumentException("GMAC requires ParametersWithIV");
    }

    public final String b() {
        return this.a.f6162a.b() + "-GMAC";
    }

    public final int c(int i, byte[] bArr) throws DataLengthException, IllegalStateException {
        try {
            return this.a.c(0, bArr);
        } catch (InvalidCipherTextException e) {
            throw new IllegalStateException(e.toString());
        }
    }

    public final void d(byte b) throws IllegalStateException {
        GCMBlockCipher gCMBlockCipher = this.a;
        gCMBlockCipher.b();
        byte[] bArr = gCMBlockCipher.l;
        int i = gCMBlockCipher.d;
        bArr[i] = b;
        int i2 = i + 1;
        gCMBlockCipher.d = i2;
        if (i2 == 16) {
            byte[] bArr2 = gCMBlockCipher.i;
            GCMUtil.e(bArr2, bArr);
            gCMBlockCipher.f6163a.a(bArr2);
            gCMBlockCipher.d = 0;
            gCMBlockCipher.f6167b += 16;
        }
    }

    public final int e() {
        return 16;
    }

    public final void reset() {
        this.a.l(true);
    }

    public final void update(byte[] bArr, int i, int i2) throws DataLengthException, IllegalStateException {
        this.a.i(i, bArr, i2);
    }
}
