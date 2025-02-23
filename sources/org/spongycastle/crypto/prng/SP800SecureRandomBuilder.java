package org.spongycastle.crypto.prng;

import java.security.SecureRandom;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.digests.SHA512Digest;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.crypto.prng.drbg.CTRSP800DRBG;
import org.spongycastle.crypto.prng.drbg.HMacSP800DRBG;
import org.spongycastle.crypto.prng.drbg.HashSP800DRBG;
import org.spongycastle.crypto.prng.drbg.SP80090DRBG;

public class SP800SecureRandomBuilder {
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public final SecureRandom f6245a;

    /* renamed from: a  reason: collision with other field name */
    public final EntropySourceProvider f6246a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f6247a;
    public final int b;

    public static class CTRDRBGProvider implements DRBGProvider {
        public final SP80090DRBG a(EntropySource entropySource) {
            new CTRSP800DRBG(entropySource);
            throw null;
        }
    }

    public static class HMacDRBGProvider implements DRBGProvider {
        public final int a;

        /* renamed from: a  reason: collision with other field name */
        public final Mac f6248a;

        /* renamed from: a  reason: collision with other field name */
        public final byte[] f6249a;
        public final byte[] b;

        public HMacDRBGProvider(HMac hMac, byte[] bArr, byte[] bArr2, int i) {
            this.f6248a = hMac;
            this.f6249a = bArr;
            this.b = bArr2;
            this.a = i;
        }

        public final SP80090DRBG a(EntropySource entropySource) {
            return new HMacSP800DRBG(this.f6248a, this.a, entropySource, this.b, this.f6249a);
        }
    }

    public static class HashDRBGProvider implements DRBGProvider {
        public final int a;

        /* renamed from: a  reason: collision with other field name */
        public final Digest f6250a;

        /* renamed from: a  reason: collision with other field name */
        public final byte[] f6251a;
        public final byte[] b;

        public HashDRBGProvider(SHA512Digest sHA512Digest, byte[] bArr, byte[] bArr2, int i) {
            this.f6250a = sHA512Digest;
            this.f6251a = bArr;
            this.b = bArr2;
            this.a = i;
        }

        public final SP80090DRBG a(EntropySource entropySource) {
            return new HashSP800DRBG(this.f6250a, this.a, entropySource, this.b, this.f6251a);
        }
    }

    public SP800SecureRandomBuilder() {
        this(new SecureRandom(), false);
    }

    public final SP800SecureRandom a(HMac hMac, byte[] bArr) {
        return new SP800SecureRandom(this.f6245a, this.f6246a.a(this.b), new HMacDRBGProvider(hMac, bArr, this.f6247a, this.a), false);
    }

    public final SP800SecureRandom b(SHA512Digest sHA512Digest, byte[] bArr, boolean z) {
        return new SP800SecureRandom(this.f6245a, this.f6246a.a(this.b), new HashDRBGProvider(sHA512Digest, bArr, this.f6247a, this.a), z);
    }

    public SP800SecureRandomBuilder(SecureRandom secureRandom, boolean z) {
        this.a = 256;
        this.b = 256;
        this.f6245a = secureRandom;
        this.f6246a = new BasicEntropySourceProvider(secureRandom);
    }

    public SP800SecureRandomBuilder(EntropySourceProvider entropySourceProvider) {
        this.a = 256;
        this.b = 256;
        this.f6245a = null;
        this.f6246a = entropySourceProvider;
    }
}
