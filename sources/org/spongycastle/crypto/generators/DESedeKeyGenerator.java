package org.spongycastle.crypto.generators;

import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.crypto.params.DESParameters;
import org.spongycastle.crypto.params.DESedeParameters;

public class DESedeKeyGenerator extends DESKeyGenerator {
    public final byte[] a() {
        boolean z;
        int i = this.a;
        byte[] bArr = new byte[i];
        boolean z2 = false;
        int i2 = 0;
        while (true) {
            this.f5797a.nextBytes(bArr);
            DESParameters.b(bArr);
            i2++;
            if (i2 >= 20) {
                break;
            }
            int i3 = 0;
            while (true) {
                if (i3 >= i) {
                    z = false;
                    break;
                } else if (DESParameters.a(i3, bArr)) {
                    z = true;
                    break;
                } else {
                    i3 += 8;
                }
            }
            if (!z && DESedeParameters.c(bArr)) {
                break;
            }
        }
        int i4 = 0;
        while (true) {
            if (i4 >= i) {
                break;
            } else if (DESParameters.a(i4, bArr)) {
                z2 = true;
                break;
            } else {
                i4 += 8;
            }
        }
        if (!z2 && DESedeParameters.c(bArr)) {
            return bArr;
        }
        throw new IllegalStateException("Unable to generate DES-EDE key");
    }

    public final void b(KeyGenerationParameters keyGenerationParameters) {
        this.f5797a = keyGenerationParameters.a;
        int i = (keyGenerationParameters.c + 7) / 8;
        this.a = i;
        if (i == 0 || i == 21) {
            this.a = 24;
        } else if (i == 14) {
            this.a = 16;
        } else if (i != 24 && i != 16) {
            throw new IllegalArgumentException("DESede key must be 192 or 128 bits long.");
        }
    }
}
