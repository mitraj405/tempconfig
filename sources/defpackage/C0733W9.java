package defpackage;

import defpackage.Oq;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.ECParameterSpec;

/* renamed from: W9  reason: default package and case insensitive filesystem */
/* compiled from: EcJwkGenerator */
public final class C0733W9 {
    public static C1131ga a(ECParameterSpec eCParameterSpec, String str, SecureRandom secureRandom) throws C0626Og {
        KeyPairGenerator c = new C0745X9(str, secureRandom).c();
        if (secureRandom == null) {
            try {
                c.initialize(eCParameterSpec);
            } catch (InvalidAlgorithmParameterException e) {
                throw new C0626Og("Unable to create EC key pair. " + e.getMessage(), e);
            }
        } else {
            c.initialize(eCParameterSpec, secureRandom);
        }
        KeyPair generateKeyPair = c.generateKeyPair();
        C1131ga gaVar = (C1131ga) Oq.a.b(generateKeyPair.getPublic());
        gaVar.a = generateKeyPair.getPrivate();
        return gaVar;
    }
}
