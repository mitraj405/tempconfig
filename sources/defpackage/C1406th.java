package defpackage;

import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

/* renamed from: th  reason: default package and case insensitive filesystem */
/* compiled from: KeyPairUtil */
public abstract class C1406th {
    public final String a;

    /* renamed from: a  reason: collision with other field name */
    public final SecureRandom f6966a;

    public C1406th(String str, SecureRandom secureRandom) {
        this.a = str;
        this.f6966a = secureRandom;
    }

    public abstract String a();

    public final KeyFactory b() throws C0626Og {
        String a2 = a();
        String str = this.a;
        if (str != null) {
            return KeyFactory.getInstance(a2, str);
        }
        try {
            return KeyFactory.getInstance(a2);
        } catch (NoSuchAlgorithmException e) {
            throw new C0626Og("Couldn't find " + a2 + " KeyFactory! " + e, e);
        } catch (NoSuchProviderException e2) {
            throw new C0626Og(C0709Uj.i("Cannot get KeyFactory instance with provider ", str), e2);
        }
    }

    public final KeyPairGenerator c() throws C0626Og {
        String a2 = a();
        String str = this.a;
        if (str != null) {
            return KeyPairGenerator.getInstance(a2, str);
        }
        try {
            return KeyPairGenerator.getInstance(a2);
        } catch (NoSuchAlgorithmException e) {
            throw new C0626Og("Couldn't find " + a2 + " KeyPairGenerator! " + e, e);
        } catch (NoSuchProviderException e2) {
            throw new C0626Og(C0709Uj.i("Cannot get KeyPairGenerator instance with provider ", str), e2);
        }
    }
}
