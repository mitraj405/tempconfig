package org.spongycastle.jcajce;

import org.spongycastle.crypto.CharToByteConverter;
import org.spongycastle.crypto.PasswordConverter;

public class PBKDF2Key implements PBKDFKey {
    public final CharToByteConverter a;

    /* renamed from: a  reason: collision with other field name */
    public final char[] f6309a;

    public PBKDF2Key(char[] cArr, PasswordConverter passwordConverter) {
        char[] cArr2;
        if (cArr == null) {
            cArr2 = null;
        } else {
            char[] cArr3 = new char[cArr.length];
            System.arraycopy(cArr, 0, cArr3, 0, cArr.length);
            cArr2 = cArr3;
        }
        this.f6309a = cArr2;
        this.a = passwordConverter;
    }

    public final String getAlgorithm() {
        return "PBKDF2";
    }

    public final byte[] getEncoded() {
        return this.a.a(this.f6309a);
    }

    public final String getFormat() {
        return this.a.getType();
    }

    public final char[] getPassword() {
        return this.f6309a;
    }
}
