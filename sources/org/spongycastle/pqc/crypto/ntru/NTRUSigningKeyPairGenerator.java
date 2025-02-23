package org.spongycastle.pqc.crypto.ntru;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.spongycastle.pqc.crypto.ntru.NTRUSigningPrivateKeyParameters;

public class NTRUSigningKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {

    public class BasisGenerationTask implements Callable<NTRUSigningPrivateKeyParameters.Basis> {
        public BasisGenerationTask() {
            throw null;
        }

        public final Object call() throws Exception {
            throw null;
        }
    }

    public class FGBasis extends NTRUSigningPrivateKeyParameters.Basis {
        public FGBasis() {
            throw null;
        }
    }

    public final AsymmetricCipherKeyPair a() {
        Executors.newCachedThreadPool();
        new ArrayList();
        throw null;
    }
}
