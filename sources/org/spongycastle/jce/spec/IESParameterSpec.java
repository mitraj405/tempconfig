package org.spongycastle.jce.spec;

import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.util.Arrays;

public class IESParameterSpec implements AlgorithmParameterSpec {
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public final boolean f6606a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f6607a;
    public final int b;

    /* renamed from: b  reason: collision with other field name */
    public final byte[] f6608b;
    public final byte[] c;

    public IESParameterSpec(byte[] bArr, int i, byte[] bArr2) {
        this(bArr, bArr2, i, -1, (byte[]) null);
    }

    public final byte[] a() {
        return Arrays.c(this.c);
    }

    public IESParameterSpec(int i, int i2, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        this(bArr, bArr2, i, i2, bArr3);
    }

    public IESParameterSpec(byte[] bArr, byte[] bArr2, int i, int i2, byte[] bArr3) {
        if (bArr != null) {
            byte[] bArr4 = new byte[bArr.length];
            this.f6607a = bArr4;
            System.arraycopy(bArr, 0, bArr4, 0, bArr.length);
        } else {
            this.f6607a = null;
        }
        if (bArr2 != null) {
            byte[] bArr5 = new byte[bArr2.length];
            this.f6608b = bArr5;
            System.arraycopy(bArr2, 0, bArr5, 0, bArr2.length);
        } else {
            this.f6608b = null;
        }
        this.a = i;
        this.b = i2;
        this.c = Arrays.c(bArr3);
        this.f6606a = false;
    }
}
