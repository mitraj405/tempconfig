package org.spongycastle.crypto.signers;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.ExtendedDigest;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.BigIntegers;

public class HMacDSAKCalculator implements DSAKCalculator {
    public static final BigInteger b = BigInteger.valueOf(0);
    public BigInteger a;

    /* renamed from: a  reason: collision with other field name */
    public final HMac f6277a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f6278a;

    /* renamed from: b  reason: collision with other field name */
    public final byte[] f6279b;

    public HMacDSAKCalculator(ExtendedDigest extendedDigest) {
        HMac hMac = new HMac(extendedDigest);
        this.f6277a = hMac;
        int i = hMac.f6108a;
        this.f6279b = new byte[i];
        this.f6278a = new byte[i];
    }

    public final boolean a() {
        return true;
    }

    public final BigInteger b() {
        byte[] bArr;
        HMac hMac;
        int bitLength = (this.a.bitLength() + 7) / 8;
        byte[] bArr2 = new byte[bitLength];
        while (true) {
            int i = 0;
            while (true) {
                bArr = this.f6279b;
                hMac = this.f6277a;
                if (i >= bitLength) {
                    break;
                }
                hMac.update(bArr, 0, bArr.length);
                hMac.c(0, bArr);
                int min = Math.min(bitLength - i, bArr.length);
                System.arraycopy(bArr, 0, bArr2, i, min);
                i += min;
            }
            BigInteger e = e(bArr2);
            if (e.compareTo(b) > 0 && e.compareTo(this.a) < 0) {
                return e;
            }
            hMac.update(bArr, 0, bArr.length);
            hMac.d((byte) 0);
            byte[] bArr3 = this.f6278a;
            hMac.c(0, bArr3);
            hMac.a(new KeyParameter(bArr3));
            hMac.update(bArr, 0, bArr.length);
            hMac.c(0, bArr);
        }
    }

    public final void c(BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        this.a = bigInteger;
        byte[] bArr2 = this.f6279b;
        Arrays.p(bArr2, (byte) 1);
        byte[] bArr3 = this.f6278a;
        Arrays.p(bArr3, (byte) 0);
        int bitLength = (bigInteger.bitLength() + 7) / 8;
        byte[] bArr4 = new byte[bitLength];
        byte[] b2 = BigIntegers.b(bigInteger2);
        System.arraycopy(b2, 0, bArr4, bitLength - b2.length, b2.length);
        int bitLength2 = (bigInteger.bitLength() + 7) / 8;
        byte[] bArr5 = new byte[bitLength2];
        BigInteger e = e(bArr);
        if (e.compareTo(bigInteger) >= 0) {
            e = e.subtract(bigInteger);
        }
        byte[] b3 = BigIntegers.b(e);
        System.arraycopy(b3, 0, bArr5, bitLength2 - b3.length, b3.length);
        KeyParameter keyParameter = new KeyParameter(bArr3, 0, bArr3.length);
        HMac hMac = this.f6277a;
        hMac.a(keyParameter);
        hMac.update(bArr2, 0, bArr2.length);
        hMac.d((byte) 0);
        hMac.update(bArr4, 0, bitLength);
        hMac.update(bArr5, 0, bitLength2);
        hMac.c(0, bArr3);
        hMac.a(new KeyParameter(bArr3, 0, bArr3.length));
        hMac.update(bArr2, 0, bArr2.length);
        hMac.c(0, bArr2);
        hMac.update(bArr2, 0, bArr2.length);
        hMac.d((byte) 1);
        hMac.update(bArr4, 0, bitLength);
        hMac.update(bArr5, 0, bitLength2);
        hMac.c(0, bArr3);
        hMac.a(new KeyParameter(bArr3, 0, bArr3.length));
        hMac.update(bArr2, 0, bArr2.length);
        hMac.c(0, bArr2);
    }

    public final void d(BigInteger bigInteger, SecureRandom secureRandom) {
        throw new IllegalStateException("Operation not supported");
    }

    public final BigInteger e(byte[] bArr) {
        BigInteger bigInteger = new BigInteger(1, bArr);
        if (bArr.length * 8 > this.a.bitLength()) {
            return bigInteger.shiftRight((bArr.length * 8) - this.a.bitLength());
        }
        return bigInteger;
    }
}
