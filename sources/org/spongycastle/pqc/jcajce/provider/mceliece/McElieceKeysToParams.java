package org.spongycastle.pqc.jcajce.provider.mceliece;

import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import org.spongycastle.pqc.crypto.mceliece.McEliecePrivateKeyParameters;
import org.spongycastle.pqc.crypto.mceliece.McEliecePublicKeyParameters;

public class McElieceKeysToParams {
    public static McEliecePrivateKeyParameters a(PrivateKey privateKey) throws InvalidKeyException {
        if (privateKey instanceof BCMcEliecePrivateKey) {
            McEliecePrivateKeyParameters mcEliecePrivateKeyParameters = ((BCMcEliecePrivateKey) privateKey).a;
            return new McEliecePrivateKeyParameters(mcEliecePrivateKeyParameters.c, mcEliecePrivateKeyParameters.d, mcEliecePrivateKeyParameters.f6699a, mcEliecePrivateKeyParameters.f6701a, mcEliecePrivateKeyParameters.f6700a, mcEliecePrivateKeyParameters.f6703b, mcEliecePrivateKeyParameters.a);
        }
        throw new InvalidKeyException("can't identify McEliece private key.");
    }

    public static McEliecePublicKeyParameters b(PublicKey publicKey) throws InvalidKeyException {
        if (publicKey instanceof BCMcEliecePublicKey) {
            return ((BCMcEliecePublicKey) publicKey).a;
        }
        throw new InvalidKeyException("can't identify McEliece public key: ".concat(publicKey.getClass().getName()));
    }
}
