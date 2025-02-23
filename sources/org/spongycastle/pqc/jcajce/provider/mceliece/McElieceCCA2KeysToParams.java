package org.spongycastle.pqc.jcajce.provider.mceliece;

import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import org.spongycastle.pqc.crypto.mceliece.McElieceCCA2PrivateKeyParameters;
import org.spongycastle.pqc.crypto.mceliece.McElieceCCA2PublicKeyParameters;

public class McElieceCCA2KeysToParams {
    public static McElieceCCA2PrivateKeyParameters a(PrivateKey privateKey) throws InvalidKeyException {
        if (privateKey instanceof BCMcElieceCCA2PrivateKey) {
            return ((BCMcElieceCCA2PrivateKey) privateKey).a;
        }
        throw new InvalidKeyException("can't identify McElieceCCA2 private key.");
    }

    public static McElieceCCA2PublicKeyParameters b(PublicKey publicKey) throws InvalidKeyException {
        if (publicKey instanceof BCMcElieceCCA2PublicKey) {
            return ((BCMcElieceCCA2PublicKey) publicKey).a;
        }
        throw new InvalidKeyException("can't identify McElieceCCA2 public key: ".concat(publicKey.getClass().getName()));
    }
}
