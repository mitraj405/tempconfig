package org.spongycastle.crypto.params;

import java.security.SecureRandom;
import org.spongycastle.crypto.KeyGenerationParameters;

public class ECKeyGenerationParameters extends KeyGenerationParameters {
    public final ECDomainParameters a;

    public ECKeyGenerationParameters(SecureRandom secureRandom, ECDomainParameters eCDomainParameters) {
        super(eCDomainParameters.g.bitLength(), secureRandom);
        this.a = eCDomainParameters;
    }
}
