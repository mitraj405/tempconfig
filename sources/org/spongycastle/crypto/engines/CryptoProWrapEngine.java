package org.spongycastle.crypto.engines;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.modes.GCFBBlockCipher;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.crypto.params.ParametersWithSBox;
import org.spongycastle.crypto.params.ParametersWithUKM;
import org.spongycastle.util.Pack;

public class CryptoProWrapEngine extends GOST28147WrapEngine {
    public final void a(boolean z, CipherParameters cipherParameters) {
        KeyParameter keyParameter;
        byte[] bArr;
        byte[] bArr2;
        boolean z2 = z;
        CipherParameters cipherParameters2 = cipherParameters;
        if (cipherParameters2 instanceof ParametersWithRandom) {
            cipherParameters2 = ((ParametersWithRandom) cipherParameters2).f6234a;
        }
        ParametersWithUKM parametersWithUKM = (ParametersWithUKM) cipherParameters2;
        CipherParameters cipherParameters3 = parametersWithUKM.a;
        if (cipherParameters3 instanceof ParametersWithSBox) {
            ParametersWithSBox parametersWithSBox = (ParametersWithSBox) cipherParameters3;
            keyParameter = (KeyParameter) parametersWithSBox.a;
            bArr = parametersWithSBox.f6235a;
        } else {
            keyParameter = (KeyParameter) cipherParameters3;
            bArr = null;
        }
        byte[] bArr3 = keyParameter.a;
        int i = 0;
        while (true) {
            bArr2 = parametersWithUKM.f6236a;
            if (i == 8) {
                break;
            }
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            while (true) {
                boolean z3 = true;
                if (i2 == 8) {
                    break;
                }
                int f = Pack.f(i2 * 4, bArr3);
                if ((bArr2[i] & (1 << i2)) == 0) {
                    z3 = false;
                }
                if (z3) {
                    i3 += f;
                } else {
                    i4 += f;
                }
                i2++;
            }
            byte[] bArr4 = new byte[8];
            Pack.e(i3, bArr4, 0);
            Pack.e(i4, bArr4, 4);
            GCFBBlockCipher gCFBBlockCipher = new GCFBBlockCipher(new GOST28147Engine());
            gCFBBlockCipher.a(true, new ParametersWithIV(new ParametersWithSBox(new KeyParameter(bArr3, 0, bArr3.length), bArr), bArr4, 0, 8));
            gCFBBlockCipher.e(0, 0, bArr3, bArr3);
            gCFBBlockCipher.e(8, 8, bArr3, bArr3);
            gCFBBlockCipher.e(16, 16, bArr3, bArr3);
            gCFBBlockCipher.e(24, 24, bArr3, bArr3);
            i++;
        }
        KeyParameter keyParameter2 = new KeyParameter(bArr3);
        if (bArr != null) {
            super.a(z2, new ParametersWithUKM(new ParametersWithSBox(keyParameter2, bArr), bArr2));
        } else {
            super.a(z2, new ParametersWithUKM(keyParameter2, bArr2));
        }
    }
}
