package org.spongycastle.jcajce;

import org.spongycastle.crypto.PBEParametersGenerator;

public class PKCS12Key implements PBKDFKey {
    public final boolean a;

    /* renamed from: a  reason: collision with other field name */
    public final char[] f6310a;

    public PKCS12Key(char[] cArr, boolean z) {
        cArr = cArr == null ? new char[0] : cArr;
        char[] cArr2 = new char[cArr.length];
        this.f6310a = cArr2;
        this.a = z;
        System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
    }

    public final String getAlgorithm() {
        return "PKCS12";
    }

    public final byte[] getEncoded() {
        boolean z = this.a;
        char[] cArr = this.f6310a;
        if (!z || cArr.length != 0) {
            return PBEParametersGenerator.a(cArr);
        }
        return new byte[2];
    }

    public final String getFormat() {
        return "PKCS12";
    }

    public final char[] getPassword() {
        return this.f6310a;
    }
}
