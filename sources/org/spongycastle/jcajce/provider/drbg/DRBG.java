package org.spongycastle.jcajce.provider.drbg;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.SecureRandomSpi;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.spongycastle.crypto.digests.SHA512Digest;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.crypto.prng.EntropySource;
import org.spongycastle.crypto.prng.EntropySourceProvider;
import org.spongycastle.crypto.prng.SP800SecureRandom;
import org.spongycastle.crypto.prng.SP800SecureRandomBuilder;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.ClassUtil;
import org.spongycastle.jcajce.provider.util.AsymmetricAlgorithmProvider;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Pack;
import org.spongycastle.util.Strings;

public class DRBG {
    public static final Object[] a;

    /* renamed from: a  reason: collision with other field name */
    public static final String[][] f6502a = {new String[]{"sun.security.provider.Sun", "sun.security.provider.SecureRandom"}, new String[]{"org.apache.harmony.security.provider.crypto.CryptoProvider", "org.apache.harmony.security.provider.crypto.SHA1PRNG_SecureRandomImpl"}, new String[]{"com.android.org.conscrypt.OpenSSLProvider", "com.android.org.conscrypt.OpenSSLRandom"}, new String[]{"org.conscrypt.OpenSSLProvider", "org.conscrypt.OpenSSLRandom"}};

    public static class CoreSecureRandom extends SecureRandom {
        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public CoreSecureRandom() {
            /*
                r3 = this;
                java.lang.Object[] r0 = org.spongycastle.jcajce.provider.drbg.DRBG.a
                r1 = 1
                r1 = r0[r1]
                java.security.SecureRandomSpi r1 = (java.security.SecureRandomSpi) r1
                r2 = 0
                r0 = r0[r2]
                java.security.Provider r0 = (java.security.Provider) r0
                r3.<init>(r1, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.drbg.DRBG.CoreSecureRandom.<init>():void");
        }
    }

    public static class Default extends SecureRandomSpi {
        public static final SP800SecureRandom a = DRBG.a(true);

        public final byte[] engineGenerateSeed(int i) {
            return a.generateSeed(i);
        }

        public final void engineNextBytes(byte[] bArr) {
            a.nextBytes(bArr);
        }

        public final void engineSetSeed(byte[] bArr) {
            a.setSeed(bArr);
        }
    }

    public static class Mappings extends AsymmetricAlgorithmProvider {
        public final void a(ConfigurableProvider configurableProvider) {
            String[][] strArr = DRBG.f6502a;
            configurableProvider.b("SecureRandom.DEFAULT", "org.spongycastle.jcajce.provider.drbg.DRBG$Default");
            configurableProvider.b("SecureRandom.NONCEANDIV", "org.spongycastle.jcajce.provider.drbg.DRBG$NonceAndIV");
        }
    }

    public static class NonceAndIV extends SecureRandomSpi {
        public static final SP800SecureRandom a = DRBG.a(false);

        public final byte[] engineGenerateSeed(int i) {
            return a.generateSeed(i);
        }

        public final void engineNextBytes(byte[] bArr) {
            a.nextBytes(bArr);
        }

        public final void engineSetSeed(byte[] bArr) {
            a.setSeed(bArr);
        }
    }

    static {
        Object[] objArr;
        int i = 0;
        while (true) {
            String[][] strArr = f6502a;
            if (i >= strArr.length) {
                objArr = null;
                break;
            }
            String[] strArr2 = strArr[i];
            try {
                objArr = new Object[]{Class.forName(strArr2[0]).newInstance(), Class.forName(strArr2[1]).newInstance()};
                break;
            } catch (Throwable unused) {
                i++;
            }
        }
        a = objArr;
    }

    public static SP800SecureRandom a(boolean z) {
        byte[] bArr;
        byte[] bArr2;
        if (System.getProperty("org.spongycastle.drbg.entropysource") != null) {
            final String property = System.getProperty("org.spongycastle.drbg.entropysource");
            EntropySourceProvider entropySourceProvider = (EntropySourceProvider) AccessController.doPrivileged(new PrivilegedAction<EntropySourceProvider>() {
                public final Object run() {
                    String str = property;
                    try {
                        return (EntropySourceProvider) ClassUtil.a(DRBG.class, str).newInstance();
                    } catch (Exception e) {
                        throw new IllegalStateException(C1058d.M(e, xx.K("entropy source ", str, " not created: ")), e);
                    }
                }
            });
            EntropySource a2 = entropySourceProvider.a(128);
            if (z) {
                bArr2 = b(a2.a());
            } else {
                bArr2 = c(a2.a());
            }
            SP800SecureRandomBuilder sP800SecureRandomBuilder = new SP800SecureRandomBuilder(entropySourceProvider);
            sP800SecureRandomBuilder.f6247a = bArr2;
            return sP800SecureRandomBuilder.b(new SHA512Digest(), Arrays.i(a2.a(), a2.a()), z);
        }
        HybridSecureRandom hybridSecureRandom = new HybridSecureRandom();
        if (z) {
            bArr = b(hybridSecureRandom.generateSeed(16));
        } else {
            bArr = c(hybridSecureRandom.generateSeed(16));
        }
        SP800SecureRandomBuilder sP800SecureRandomBuilder2 = new SP800SecureRandomBuilder(hybridSecureRandom, true);
        sP800SecureRandomBuilder2.f6247a = bArr;
        return sP800SecureRandomBuilder2.b(new SHA512Digest(), hybridSecureRandom.generateSeed(32), z);
    }

    public static byte[] b(byte[] bArr) {
        byte[] d = Strings.d("Default");
        byte[] bArr2 = new byte[8];
        Pack.j(Thread.currentThread().getId(), bArr2, 0);
        byte[] bArr3 = new byte[8];
        Pack.j(System.currentTimeMillis(), bArr3, 0);
        return Arrays.k(d, bArr, bArr2, bArr3);
    }

    public static byte[] c(byte[] bArr) {
        byte[] d = Strings.d("Nonce");
        byte[] bArr2 = new byte[8];
        Pack.l(Thread.currentThread().getId(), bArr2, 0);
        byte[] bArr3 = new byte[8];
        Pack.l(System.currentTimeMillis(), bArr3, 0);
        return Arrays.k(d, bArr, bArr2, bArr3);
    }

    public static class HybridSecureRandom extends SecureRandom {
        public final SecureRandom a;

        /* renamed from: a  reason: collision with other field name */
        public final AtomicBoolean f6503a = new AtomicBoolean(false);

        /* renamed from: a  reason: collision with other field name */
        public final AtomicInteger f6504a = new AtomicInteger(0);

        /* renamed from: a  reason: collision with other field name */
        public final SP800SecureRandom f6505a;

        public class SignallingEntropySource implements EntropySource {
            public final int a;

            /* renamed from: a  reason: collision with other field name */
            public final AtomicBoolean f6506a = new AtomicBoolean(false);

            /* renamed from: a  reason: collision with other field name */
            public final AtomicReference f6507a = new AtomicReference();

            public class EntropyGatherer implements Runnable {
                public final int c;

                public EntropyGatherer(int i) {
                    this.c = i;
                }

                public final void run() {
                    SignallingEntropySource signallingEntropySource = SignallingEntropySource.this;
                    signallingEntropySource.f6507a.set(HybridSecureRandom.this.a.generateSeed(this.c));
                    HybridSecureRandom.this.f6503a.set(true);
                }
            }

            public SignallingEntropySource(int i) {
                this.a = (i + 7) / 8;
            }

            public final byte[] a() {
                byte[] bArr = (byte[]) this.f6507a.getAndSet((Object) null);
                AtomicBoolean atomicBoolean = this.f6506a;
                int i = this.a;
                if (bArr == null || bArr.length != i) {
                    bArr = HybridSecureRandom.this.a.generateSeed(i);
                } else {
                    atomicBoolean.set(false);
                }
                if (!atomicBoolean.getAndSet(true)) {
                    new Thread(new EntropyGatherer(i)).start();
                }
                return bArr;
            }

            public final int b() {
                return this.a * 8;
            }
        }

        public HybridSecureRandom() {
            super((SecureRandomSpi) null, (Provider) null);
            SecureRandom secureRandom;
            if (DRBG.a != null) {
                secureRandom = new CoreSecureRandom();
            } else {
                secureRandom = new SecureRandom();
            }
            this.a = secureRandom;
            SP800SecureRandomBuilder sP800SecureRandomBuilder = new SP800SecureRandomBuilder(new EntropySourceProvider() {
                public final EntropySource a(int i) {
                    return new SignallingEntropySource(i);
                }
            });
            sP800SecureRandomBuilder.f6247a = Strings.d("Bouncy Castle Hybrid Entropy Source");
            this.f6505a = sP800SecureRandomBuilder.a(new HMac(new SHA512Digest()), secureRandom.generateSeed(32));
        }

        public final byte[] generateSeed(int i) {
            byte[] bArr = new byte[i];
            AtomicInteger atomicInteger = this.f6504a;
            int andIncrement = atomicInteger.getAndIncrement();
            SP800SecureRandom sP800SecureRandom = this.f6505a;
            if (andIncrement > 20 && this.f6503a.getAndSet(false)) {
                atomicInteger.set(0);
                sP800SecureRandom.a();
            }
            sP800SecureRandom.nextBytes(bArr);
            return bArr;
        }

        public final void setSeed(byte[] bArr) {
            SP800SecureRandom sP800SecureRandom = this.f6505a;
            if (sP800SecureRandom != null) {
                sP800SecureRandom.setSeed(bArr);
            }
        }

        public final void setSeed(long j) {
            SP800SecureRandom sP800SecureRandom = this.f6505a;
            if (sP800SecureRandom != null) {
                sP800SecureRandom.setSeed(j);
            }
        }
    }
}
