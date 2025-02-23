package org.spongycastle.jcajce.provider.asymmetric.util;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.BufferedBlockCipher;
import org.spongycastle.jce.spec.IESParameterSpec;

public class IESUtil {
    public static IESParameterSpec a(BufferedBlockCipher bufferedBlockCipher, byte[] bArr) {
        if (bufferedBlockCipher == null) {
            return new IESParameterSpec((byte[]) null, 128, (byte[]) null);
        }
        BlockCipher blockCipher = bufferedBlockCipher.f5794a;
        if (blockCipher.b().equals("DES") || blockCipher.b().equals("RC2") || blockCipher.b().equals("RC5-32") || blockCipher.b().equals("RC5-64")) {
            return new IESParameterSpec(64, 64, (byte[]) null, (byte[]) null, bArr);
        }
        if (blockCipher.b().equals("SKIPJACK")) {
            return new IESParameterSpec(80, 80, (byte[]) null, (byte[]) null, bArr);
        }
        if (blockCipher.b().equals("GOST28147")) {
            return new IESParameterSpec(256, 256, (byte[]) null, (byte[]) null, bArr);
        }
        return new IESParameterSpec(128, 128, (byte[]) null, (byte[]) null, bArr);
    }
}
