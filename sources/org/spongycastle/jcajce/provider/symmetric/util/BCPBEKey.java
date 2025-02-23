package org.spongycastle.jcajce.provider.symmetric.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.crypto.interfaces.PBEKey;
import javax.crypto.spec.PBEKeySpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.PBEParametersGenerator;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Strings;

public class BCPBEKey implements PBEKey {
    public final ASN1ObjectIdentifier Z0;
    public final PBEKeySpec a;

    /* renamed from: a  reason: collision with other field name */
    public final CipherParameters f6539a;
    public final int c;

    /* renamed from: c  reason: collision with other field name */
    public final String f6540c;
    public final int d;
    public final int e;
    public final int f;

    public BCPBEKey(String str, ASN1ObjectIdentifier aSN1ObjectIdentifier, int i, int i2, int i3, int i4, PBEKeySpec pBEKeySpec, CipherParameters cipherParameters) {
        this.f6540c = str;
        this.Z0 = aSN1ObjectIdentifier;
        this.c = i;
        this.d = i2;
        this.e = i3;
        this.f = i4;
        this.a = pBEKeySpec;
        this.f6539a = cipherParameters;
    }

    public final String getAlgorithm() {
        return this.f6540c;
    }

    public final byte[] getEncoded() {
        KeyParameter keyParameter;
        CipherParameters cipherParameters = this.f6539a;
        if (cipherParameters != null) {
            if (cipherParameters instanceof ParametersWithIV) {
                keyParameter = (KeyParameter) ((ParametersWithIV) cipherParameters).a;
            } else {
                keyParameter = (KeyParameter) cipherParameters;
            }
            return keyParameter.a;
        }
        PBEKeySpec pBEKeySpec = this.a;
        int i = this.c;
        if (i == 2) {
            return PBEParametersGenerator.a(pBEKeySpec.getPassword());
        }
        if (i != 5) {
            return PBEParametersGenerator.b(pBEKeySpec.getPassword());
        }
        char[] password = pBEKeySpec.getPassword();
        if (password == null) {
            return new byte[0];
        }
        String str = Strings.a;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            Strings.f(byteArrayOutputStream, password);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException unused) {
            throw new IllegalStateException("cannot encode string to byte array!");
        }
    }

    public final String getFormat() {
        return "RAW";
    }

    public final int getIterationCount() {
        return this.a.getIterationCount();
    }

    public final char[] getPassword() {
        return this.a.getPassword();
    }

    public final byte[] getSalt() {
        return this.a.getSalt();
    }
}
