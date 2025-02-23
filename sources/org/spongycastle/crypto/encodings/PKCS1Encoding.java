package org.spongycastle.crypto.encodings;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.SecureRandom;
import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.util.Arrays;

public class PKCS1Encoding implements AsymmetricBlockCipher {
    public final int a = -1;

    /* renamed from: a  reason: collision with other field name */
    public SecureRandom f5896a;

    /* renamed from: a  reason: collision with other field name */
    public final AsymmetricBlockCipher f5897a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f5898a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f5899a = null;
    public boolean b;

    /* renamed from: b  reason: collision with other field name */
    public byte[] f5900b;
    public final boolean c;

    public PKCS1Encoding(AsymmetricBlockCipher asymmetricBlockCipher) {
        this.f5897a = asymmetricBlockCipher;
        this.c = e();
    }

    public static boolean e() {
        String str = (String) AccessController.doPrivileged(new PrivilegedAction() {
            public final Object run() {
                return System.getProperty("org.spongycastle.pkcs1.strict");
            }
        });
        String str2 = (String) AccessController.doPrivileged(new PrivilegedAction() {
            public final Object run() {
                return System.getProperty("org.spongycastle.pkcs1.not_strict");
            }
        });
        if (str2 != null) {
            return !str2.equals("true");
        }
        if (str == null || str.equals("true")) {
            return true;
        }
        return false;
    }

    public final void a(boolean z, CipherParameters cipherParameters) {
        AsymmetricKeyParameter asymmetricKeyParameter;
        if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.f5896a = parametersWithRandom.a;
            asymmetricKeyParameter = (AsymmetricKeyParameter) parametersWithRandom.f6234a;
        } else {
            asymmetricKeyParameter = (AsymmetricKeyParameter) cipherParameters;
            if (!asymmetricKeyParameter.a && z) {
                this.f5896a = new SecureRandom();
            }
        }
        AsymmetricBlockCipher asymmetricBlockCipher = this.f5897a;
        asymmetricBlockCipher.a(z, cipherParameters);
        this.b = asymmetricKeyParameter.a;
        this.f5898a = z;
        this.f5900b = new byte[asymmetricBlockCipher.b()];
        if (this.a > 0 && this.f5899a == null && this.f5896a == null) {
            throw new IllegalArgumentException("encoder requires random");
        }
    }

    public final int b() {
        int b2 = this.f5897a.b();
        if (this.f5898a) {
            return b2;
        }
        return b2 - 10;
    }

    public final byte[] c(int i, byte[] bArr, int i2) throws InvalidCipherTextException {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9 = this.f5898a;
        AsymmetricBlockCipher asymmetricBlockCipher = this.f5897a;
        int i3 = -1;
        boolean z10 = true;
        if (!z9) {
            boolean z11 = this.c;
            int i4 = this.a;
            if (i4 == -1) {
                byte[] c2 = asymmetricBlockCipher.c(i, bArr, i2);
                if (c2.length != asymmetricBlockCipher.b()) {
                    z = true;
                } else {
                    z = false;
                }
                boolean z12 = z & z11;
                if (c2.length < b()) {
                    c2 = this.f5900b;
                }
                byte b2 = c2[0];
                if (!this.b ? b2 == 1 : b2 == 2) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                boolean z13 = false;
                int i5 = -1;
                for (int i6 = 1; i6 != c2.length; i6++) {
                    byte b3 = c2[i6];
                    if (b3 == 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (i5 < 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (z3 && z4) {
                        i5 = i6;
                    }
                    if (b2 == 1) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (i5 < 0) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    boolean z14 = z5 & z6;
                    if (b3 != -1) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    z13 |= z7 & z14;
                }
                if (!z13) {
                    i3 = i5;
                }
                int i7 = i3 + 1;
                if (i7 >= 10) {
                    z10 = false;
                }
                if (z2 || z10) {
                    Arrays.p(c2, (byte) 0);
                    throw new InvalidCipherTextException("block incorrect");
                } else if (!z12) {
                    int length = c2.length - i7;
                    byte[] bArr2 = new byte[length];
                    System.arraycopy(c2, i7, bArr2, 0, length);
                    return bArr2;
                } else {
                    Arrays.p(c2, (byte) 0);
                    throw new InvalidCipherTextException("block incorrect size");
                }
            } else if (this.b) {
                byte[] c3 = asymmetricBlockCipher.c(i, bArr, i2);
                byte[] bArr3 = this.f5899a;
                if (bArr3 == null) {
                    bArr3 = new byte[i4];
                    this.f5896a.nextBytes(bArr3);
                }
                if (c3.length != asymmetricBlockCipher.b()) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                if (z8 && z11) {
                    c3 = this.f5900b;
                }
                byte b4 = (c3[0] ^ 2) | 0;
                int i8 = i4 + 1;
                int length2 = c3.length - i8;
                for (int i9 = 1; i9 < length2; i9++) {
                    byte b5 = c3[i9];
                    byte b6 = b5 | (b5 >> 1);
                    byte b7 = b6 | (b6 >> 2);
                    b4 |= ((b7 | (b7 >> 4)) & 1) - 1;
                }
                byte b8 = b4 | c3[c3.length - i8];
                byte b9 = b8 | (b8 >> 1);
                byte b10 = b9 | (b9 >> 2);
                int i10 = ~(((b10 | (b10 >> 4)) & 1) - 1);
                byte[] bArr4 = new byte[i4];
                for (int i11 = 0; i11 < i4; i11++) {
                    bArr4[i11] = (byte) ((c3[(c3.length - i4) + i11] & (~i10)) | (bArr3[i11] & i10));
                }
                Arrays.p(c3, (byte) 0);
                return bArr4;
            } else {
                throw new InvalidCipherTextException("sorry, this method is only for decryption, not for signing");
            }
        } else if (i2 <= d()) {
            int d = asymmetricBlockCipher.d();
            byte[] bArr5 = new byte[d];
            if (this.b) {
                bArr5[0] = 1;
                for (int i12 = 1; i12 != (d - i2) - 1; i12++) {
                    bArr5[i12] = -1;
                }
            } else {
                this.f5896a.nextBytes(bArr5);
                bArr5[0] = 2;
                for (int i13 = 1; i13 != (d - i2) - 1; i13++) {
                    while (bArr5[i13] == 0) {
                        bArr5[i13] = (byte) this.f5896a.nextInt();
                    }
                }
            }
            int i14 = d - i2;
            bArr5[i14 - 1] = 0;
            System.arraycopy(bArr, i, bArr5, i14, i2);
            return asymmetricBlockCipher.c(0, bArr5, d);
        } else {
            throw new IllegalArgumentException("input data too large");
        }
    }

    public final int d() {
        int d = this.f5897a.d();
        if (this.f5898a) {
            return d - 10;
        }
        return d;
    }
}
