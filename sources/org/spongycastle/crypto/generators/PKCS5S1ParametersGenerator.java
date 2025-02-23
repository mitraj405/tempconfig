package org.spongycastle.crypto.generators;

import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.PBEParametersGenerator;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;

public class PKCS5S1ParametersGenerator extends PBEParametersGenerator {
    public final Digest a;

    public PKCS5S1ParametersGenerator(Digest digest) {
        this.a = digest;
    }

    public final KeyParameter c(int i) {
        return d(i);
    }

    public final KeyParameter d(int i) {
        int i2 = i / 8;
        if (i2 <= this.a.f()) {
            return new KeyParameter(g(), 0, i2);
        }
        throw new IllegalArgumentException(C1058d.y("Can't generate a derived key ", i2, " bytes long."));
    }

    public final ParametersWithIV e(int i, int i2) {
        int i3 = i / 8;
        int i4 = i2 / 8;
        int i5 = i3 + i4;
        if (i5 <= this.a.f()) {
            byte[] g = g();
            return new ParametersWithIV(new KeyParameter(g, 0, i3), g, i3, i4);
        }
        throw new IllegalArgumentException(C1058d.y("Can't generate a derived key ", i5, " bytes long."));
    }

    public final byte[] g() {
        Digest digest = this.a;
        int f = digest.f();
        byte[] bArr = new byte[f];
        byte[] bArr2 = this.f5798a;
        digest.update(bArr2, 0, bArr2.length);
        byte[] bArr3 = this.b;
        digest.update(bArr3, 0, bArr3.length);
        digest.c(0, bArr);
        for (int i = 1; i < this.a; i++) {
            digest.update(bArr, 0, f);
            digest.c(0, bArr);
        }
        return bArr;
    }
}
