package org.spongycastle.pqc.crypto.sphincs;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.security.SecureRandom;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.ExtendedDigest;
import org.spongycastle.pqc.crypto.sphincs.Tree;

public class SPHINCS256KeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    public SecureRandom a;

    /* renamed from: a  reason: collision with other field name */
    public Digest f6746a;

    public final AsymmetricCipherKeyPair a() {
        Tree.leafaddr leafaddr = new Tree.leafaddr();
        byte[] bArr = new byte[1088];
        this.a.nextBytes(bArr);
        byte[] bArr2 = new byte[1056];
        System.arraycopy(bArr, 32, bArr2, 0, UserMetadata.MAX_ATTRIBUTE_SIZE);
        leafaddr.a = 11;
        leafaddr.f6748a = 0;
        leafaddr.b = 0;
        Tree.b(new HashFunctions(this.f6746a, (ExtendedDigest) null), bArr2, UserMetadata.MAX_ATTRIBUTE_SIZE, bArr, leafaddr, bArr2, 0);
        return new AsymmetricCipherKeyPair(new SPHINCSPublicKeyParameters(bArr2), new SPHINCSPrivateKeyParameters(bArr));
    }
}
