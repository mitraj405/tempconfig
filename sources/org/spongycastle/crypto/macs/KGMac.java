package org.spongycastle.crypto.macs;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.modes.KGCMBlockCipher;
import org.spongycastle.crypto.params.AEADParameters;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;

public class KGMac implements Mac {
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public final KGCMBlockCipher f6120a;

    public KGMac(KGCMBlockCipher kGCMBlockCipher, int i) {
        this.f6120a = kGCMBlockCipher;
        this.a = i;
    }

    public final void a(CipherParameters cipherParameters) throws IllegalArgumentException {
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            this.f6120a.a(true, new AEADParameters((KeyParameter) parametersWithIV.a, this.a, parametersWithIV.f6233a, (byte[]) null));
            return;
        }
        throw new IllegalArgumentException("KGMAC requires ParametersWithIV");
    }

    public final String b() {
        return this.f6120a.f6188a.b() + "-KGMAC";
    }

    public final int c(int i, byte[] bArr) throws DataLengthException, IllegalStateException {
        try {
            return this.f6120a.c(0, bArr);
        } catch (InvalidCipherTextException e) {
            throw new IllegalStateException(e.toString());
        }
    }

    public final void d(byte b) throws IllegalStateException {
        this.f6120a.f6190a.write(b);
    }

    public final int e() {
        return this.a / 8;
    }

    public final void reset() {
        this.f6120a.k();
    }

    public final void update(byte[] bArr, int i, int i2) throws DataLengthException, IllegalStateException {
        this.f6120a.i(i, bArr, i2);
    }
}
