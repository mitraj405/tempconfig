package org.spongycastle.jcajce.provider.asymmetric.util;

import java.security.AlgorithmParameterGeneratorSpi;
import org.spongycastle.jcajce.util.BCJcaJceHelper;

public abstract class BaseAlgorithmParameterGeneratorSpi extends AlgorithmParameterGeneratorSpi {
    public final BCJcaJceHelper a = new BCJcaJceHelper();
}
