package org.spongycastle.util;

import com.google.common.base.Ascii;
import org.spongycastle.crypto.digests.SHA512tDigest;

public class Fingerprint {
    public static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f6857a;

    public Fingerprint(byte[] bArr) {
        SHA512tDigest sHA512tDigest = new SHA512tDigest(160);
        sHA512tDigest.update(bArr, 0, bArr.length);
        byte[] bArr2 = new byte[sHA512tDigest.c];
        sHA512tDigest.c(0, bArr2);
        this.f6857a = bArr2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Fingerprint) {
            return Arrays.a(((Fingerprint) obj).f6857a, this.f6857a);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.t(this.f6857a);
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (true) {
            byte[] bArr = this.f6857a;
            if (i == bArr.length) {
                return stringBuffer.toString();
            }
            if (i > 0) {
                stringBuffer.append(":");
            }
            char[] cArr = a;
            stringBuffer.append(cArr[(bArr[i] >>> 4) & 15]);
            stringBuffer.append(cArr[bArr[i] & Ascii.SI]);
            i++;
        }
    }
}
