package org.spongycastle.util.test;

import java.security.Provider;
import java.security.SecureRandom;
import java.security.SecureRandomSpi;
import org.spongycastle.util.encoders.Hex;

public class FixedSecureRandom extends SecureRandom {
    public int c;

    public static class BigInteger extends Source {
    }

    public static class Data extends Source {
    }

    public static class DummyProvider extends Provider {
        public DummyProvider() {
            super("BCFIPS_FIXED_RNG", 1.0d, "BCFIPS Fixed Secure Random Provider");
        }
    }

    public static class RandomChecker extends SecureRandom {
        public final byte[] a = Hex.a("01020304ffffffff0506070811111111");
        public int c = 0;

        public RandomChecker() {
            super((SecureRandomSpi) null, new DummyProvider());
        }

        public final void nextBytes(byte[] bArr) {
            System.arraycopy(this.a, this.c, bArr, 0, bArr.length);
            this.c += bArr.length;
        }
    }

    public static class Source {
    }

    static {
        java.math.BigInteger bigInteger = new java.math.BigInteger("01020304ffffffff0506070811111111", 16);
        java.math.BigInteger bigInteger2 = new java.math.BigInteger("1111111105060708ffffffff01020304", 16);
        java.math.BigInteger bigInteger3 = new java.math.BigInteger("3020104ffffffff05060708111111", 16);
        java.math.BigInteger bigInteger4 = new java.math.BigInteger(128, new RandomChecker());
        java.math.BigInteger bigInteger5 = new java.math.BigInteger(120, new RandomChecker());
        bigInteger4.equals(bigInteger2);
        bigInteger4.equals(bigInteger);
        bigInteger5.equals(bigInteger3);
    }

    public final byte[] generateSeed(int i) {
        byte[] bArr = new byte[i];
        nextBytes(bArr);
        return bArr;
    }

    public final void nextBytes(byte[] bArr) {
        System.arraycopy((Object) null, this.c, bArr, 0, bArr.length);
        this.c += bArr.length;
    }

    public final int nextInt() {
        this.c++;
        throw null;
    }

    public final long nextLong() {
        this.c++;
        throw null;
    }
}
