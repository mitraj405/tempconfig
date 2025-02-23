package org.spongycastle.crypto.params;

import java.security.SecureRandom;

public class DSAParameterGenerationParameters {
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public final SecureRandom f6229a;
    public final int b;
    public final int c = -1;
    public final int d;

    public DSAParameterGenerationParameters(int i, int i2, int i3, SecureRandom secureRandom) {
        this.a = i;
        this.b = i2;
        this.d = i3;
        this.f6229a = secureRandom;
    }
}
