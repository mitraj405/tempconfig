package org.spongycastle.jcajce.provider.symmetric.util;

import java.security.AlgorithmParameterGeneratorSpi;
import java.security.AlgorithmParameters;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import org.spongycastle.jcajce.util.BCJcaJceHelper;

public abstract class BaseAlgorithmParameterGenerator extends AlgorithmParameterGeneratorSpi {
    public SecureRandom a;

    /* renamed from: a  reason: collision with other field name */
    public final BCJcaJceHelper f6541a = new BCJcaJceHelper();

    public final AlgorithmParameters a(String str) throws NoSuchAlgorithmException, NoSuchProviderException {
        return this.f6541a.b(str);
    }

    public final void engineInit(int i, SecureRandom secureRandom) {
        this.a = secureRandom;
    }
}
