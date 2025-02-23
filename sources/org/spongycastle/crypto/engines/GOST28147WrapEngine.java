package org.spongycastle.crypto.engines;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.Wrapper;
import org.spongycastle.crypto.macs.GOST28147Mac;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.crypto.params.ParametersWithSBox;
import org.spongycastle.crypto.params.ParametersWithUKM;
import org.spongycastle.util.Arrays;

public class GOST28147WrapEngine implements Wrapper {
    public final GOST28147Engine a = new GOST28147Engine();

    /* renamed from: a  reason: collision with other field name */
    public final GOST28147Mac f5961a = new GOST28147Mac();

    public void a(boolean z, CipherParameters cipherParameters) {
        KeyParameter keyParameter;
        if (cipherParameters instanceof ParametersWithRandom) {
            cipherParameters = ((ParametersWithRandom) cipherParameters).f6234a;
        }
        ParametersWithUKM parametersWithUKM = (ParametersWithUKM) cipherParameters;
        this.a.a(z, parametersWithUKM.a);
        CipherParameters cipherParameters2 = parametersWithUKM.a;
        if (cipherParameters2 instanceof ParametersWithSBox) {
            keyParameter = (KeyParameter) ((ParametersWithSBox) cipherParameters2).a;
        } else {
            keyParameter = (KeyParameter) cipherParameters2;
        }
        this.f5961a.a(new ParametersWithIV(keyParameter, parametersWithUKM.f6236a));
    }

    public final String b() {
        return "GOST28147Wrap";
    }

    public final byte[] c(byte[] bArr, int i) throws InvalidCipherTextException {
        GOST28147Mac gOST28147Mac = this.f5961a;
        int i2 = i - gOST28147Mac.b;
        byte[] bArr2 = new byte[i2];
        GOST28147Engine gOST28147Engine = this.a;
        gOST28147Engine.e(0, 0, bArr, bArr2);
        gOST28147Engine.e(8, 8, bArr, bArr2);
        gOST28147Engine.e(16, 16, bArr, bArr2);
        gOST28147Engine.e(24, 24, bArr, bArr2);
        int i3 = gOST28147Mac.b;
        byte[] bArr3 = new byte[i3];
        gOST28147Mac.update(bArr2, 0, i2);
        gOST28147Mac.c(0, bArr3);
        byte[] bArr4 = new byte[i3];
        System.arraycopy(bArr, (i + 0) - 4, bArr4, 0, i3);
        if (Arrays.l(bArr3, bArr4)) {
            return bArr2;
        }
        throw new IllegalStateException("mac mismatch");
    }

    public final byte[] d(byte[] bArr, int i) {
        GOST28147Mac gOST28147Mac = this.f5961a;
        gOST28147Mac.update(bArr, 0, i);
        byte[] bArr2 = new byte[(gOST28147Mac.b + i)];
        GOST28147Engine gOST28147Engine = this.a;
        gOST28147Engine.e(0, 0, bArr, bArr2);
        gOST28147Engine.e(8, 8, bArr, bArr2);
        gOST28147Engine.e(16, 16, bArr, bArr2);
        gOST28147Engine.e(24, 24, bArr, bArr2);
        gOST28147Mac.c(i, bArr2);
        return bArr2;
    }
}
