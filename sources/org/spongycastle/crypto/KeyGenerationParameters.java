package org.spongycastle.crypto;

import java.security.SecureRandom;

public class KeyGenerationParameters {
    public final SecureRandom a;
    public final int c;

    public KeyGenerationParameters(int i, SecureRandom secureRandom) {
        this.a = secureRandom;
        this.c = i;
    }
}
