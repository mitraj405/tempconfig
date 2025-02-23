package org.spongycastle.jcajce.provider.symmetric.util;

import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKey;
import javax.crypto.spec.PBEKeySpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.jcajce.provider.symmetric.util.PBE;

public class PBESecretKeyFactory extends BaseSecretKeyFactory {
    public final boolean a;
    public final int c;
    public final int d;
    public final int e;
    public final int f;

    public PBESecretKeyFactory(String str, ASN1ObjectIdentifier aSN1ObjectIdentifier, boolean z, int i, int i2, int i3, int i4) {
        super(str, aSN1ObjectIdentifier);
        this.a = z;
        this.c = i;
        this.d = i2;
        this.e = i3;
        this.f = i4;
    }

    public final SecretKey engineGenerateSecret(KeySpec keySpec) throws InvalidKeySpecException {
        CipherParameters cipherParameters;
        if (keySpec instanceof PBEKeySpec) {
            PBEKeySpec pBEKeySpec = (PBEKeySpec) keySpec;
            if (pBEKeySpec.getSalt() == null) {
                return new BCPBEKey(this.c, this.Z0, this.c, this.d, this.e, this.f, pBEKeySpec, (CipherParameters) null);
            }
            boolean z = this.a;
            int i = this.e;
            int i2 = this.d;
            int i3 = this.c;
            if (z) {
                cipherParameters = PBE.Util.d(pBEKeySpec, i3, i2, i, this.f);
            } else {
                cipherParameters = PBE.Util.c(pBEKeySpec, i3, i2, i);
            }
            return new BCPBEKey(this.c, this.Z0, this.c, this.d, this.e, this.f, pBEKeySpec, cipherParameters);
        }
        throw new InvalidKeySpecException("Invalid KeySpec");
    }
}
