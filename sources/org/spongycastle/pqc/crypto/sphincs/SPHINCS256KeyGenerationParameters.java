package org.spongycastle.pqc.crypto.sphincs;

import java.security.SecureRandom;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.ExtendedDigest;
import org.spongycastle.crypto.KeyGenerationParameters;

public class SPHINCS256KeyGenerationParameters extends KeyGenerationParameters {
    public final Digest a;

    public SPHINCS256KeyGenerationParameters(SecureRandom secureRandom, ExtendedDigest extendedDigest) {
        super(8448, secureRandom);
        this.a = extendedDigest;
    }
}
