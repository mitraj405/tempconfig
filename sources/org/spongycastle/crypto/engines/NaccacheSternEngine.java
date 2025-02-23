package org.spongycastle.crypto.engines;

import java.math.BigInteger;
import java.util.Vector;
import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.params.NaccacheSternKeyParameters;
import org.spongycastle.crypto.params.NaccacheSternPrivateKeyParameters;
import org.spongycastle.crypto.params.ParametersWithRandom;

public class NaccacheSternEngine implements AsymmetricBlockCipher {
    public NaccacheSternKeyParameters a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f5997a;

    static {
        BigInteger.valueOf(0);
        BigInteger.valueOf(1);
    }

    public final void a(boolean z, CipherParameters cipherParameters) {
        this.f5997a = z;
        if (cipherParameters instanceof ParametersWithRandom) {
            cipherParameters = ((ParametersWithRandom) cipherParameters).f6234a;
        }
        NaccacheSternKeyParameters naccacheSternKeyParameters = (NaccacheSternKeyParameters) cipherParameters;
        this.a = naccacheSternKeyParameters;
        if (!z) {
            ((NaccacheSternPrivateKeyParameters) naccacheSternKeyParameters).getClass();
            throw null;
        }
    }

    public final int b() {
        if (!this.f5997a) {
            this.a.getClass();
            return -1;
        }
        this.a.getClass();
        throw null;
    }

    public final byte[] c(int i, byte[] bArr, int i2) throws InvalidCipherTextException {
        if (this.a != null) {
            d();
            if (i2 <= 0) {
                if (!this.f5997a) {
                    d();
                    if (i2 < -1) {
                        throw new InvalidCipherTextException("BlockLength does not match modulus for Naccache-Stern cipher.\n");
                    }
                }
                if (!(i == 0 && i2 == bArr.length)) {
                    byte[] bArr2 = new byte[i2];
                    System.arraycopy(bArr, i, bArr2, 0, i2);
                    bArr = bArr2;
                }
                new BigInteger(1, bArr);
                if (this.f5997a) {
                    this.a.getClass();
                    throw null;
                }
                new Vector();
                ((NaccacheSternPrivateKeyParameters) this.a).getClass();
                throw null;
            }
            throw new DataLengthException("input too large for Naccache-Stern cipher.\n");
        }
        throw new IllegalStateException("NaccacheStern engine not initialised");
    }

    public final int d() {
        if (this.f5997a) {
            this.a.getClass();
            return -1;
        }
        this.a.getClass();
        throw null;
    }
}
