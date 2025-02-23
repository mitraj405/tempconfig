package defpackage;

import java.io.ByteArrayOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

/* renamed from: p6  reason: default package and case insensitive filesystem */
/* compiled from: ConcatKeyDerivationFunction */
public final class C1319p6 implements C1363r6 {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public final MessageDigest f6888a;

    static {
        C0473Ci.d(C1319p6.class);
    }

    public C1319p6() {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            this.f6888a = instance;
            this.a = C1354qp.l(instance.getDigestLength());
        } catch (NoSuchAlgorithmException unused) {
            throw new V5("Unable to get MessageDigest instance with SHA-256");
        } catch (NoSuchProviderException e) {
            throw new V5("Unable to get a MessageDigest implementation of algorithm name: SHA-256 using provider null", e);
        }
    }

    public final byte[] a(byte[] bArr, int i, byte[] bArr2) {
        long ceil = (long) ((int) Math.ceil((double) (((float) i) / ((float) this.a))));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i2 = 1; ((long) i2) <= ceil; i2++) {
            byte[] L = C1354qp.L(i2);
            MessageDigest messageDigest = this.f6888a;
            messageDigest.update(L);
            messageDigest.update(bArr);
            messageDigest.update(bArr2);
            byte[] digest = messageDigest.digest();
            byteArrayOutputStream.write(digest, 0, digest.length);
        }
        int i3 = i / 8;
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (byteArray.length != i3) {
            return C1354qp.z0(byteArray, 0, i3);
        }
        return byteArray;
    }
}
