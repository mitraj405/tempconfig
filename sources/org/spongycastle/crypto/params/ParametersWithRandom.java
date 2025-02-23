package org.spongycastle.crypto.params;

import java.security.SecureRandom;
import org.spongycastle.crypto.CipherParameters;

public class ParametersWithRandom implements CipherParameters {
    public final SecureRandom a;

    /* renamed from: a  reason: collision with other field name */
    public final CipherParameters f6234a;

    public ParametersWithRandom(CipherParameters cipherParameters, SecureRandom secureRandom) {
        this.a = secureRandom;
        this.f6234a = cipherParameters;
    }
}
