package org.spongycastle.jcajce;

import org.spongycastle.crypto.CharToByteConverter;
import org.spongycastle.crypto.PasswordConverter;

public class PBKDF1Key implements PBKDFKey {
    public final CharToByteConverter a;

    /* renamed from: a  reason: collision with other field name */
    public final char[] f6308a;

    public PBKDF1Key(char[] cArr, PasswordConverter passwordConverter) {
        char[] cArr2 = new char[cArr.length];
        this.f6308a = cArr2;
        this.a = passwordConverter;
        System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
    }

    public final String getAlgorithm() {
        return "PBKDF1";
    }

    public final byte[] getEncoded() {
        return this.a.a(this.f6308a);
    }

    public final String getFormat() {
        return this.a.getType();
    }

    public final char[] getPassword() {
        return this.f6308a;
    }
}
