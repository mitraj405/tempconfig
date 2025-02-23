package org.spongycastle.crypto;

import java.security.SecureRandom;

public class CipherKeyGenerator {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public SecureRandom f5797a;

    public byte[] a() {
        byte[] bArr = new byte[this.a];
        this.f5797a.nextBytes(bArr);
        return bArr;
    }

    public void b(KeyGenerationParameters keyGenerationParameters) {
        this.f5797a = keyGenerationParameters.a;
        this.a = (keyGenerationParameters.c + 7) / 8;
    }
}
