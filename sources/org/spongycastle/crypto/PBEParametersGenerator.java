package org.spongycastle.crypto;

import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;

public abstract class PBEParametersGenerator {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f5798a;
    public byte[] b;

    public static byte[] a(char[] cArr) {
        if (cArr == null || cArr.length <= 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[((cArr.length + 1) * 2)];
        for (int i = 0; i != cArr.length; i++) {
            int i2 = i * 2;
            char c = cArr[i];
            bArr[i2] = (byte) (c >>> 8);
            bArr[i2 + 1] = (byte) c;
        }
        return bArr;
    }

    public static byte[] b(char[] cArr) {
        if (cArr == null) {
            return new byte[0];
        }
        int length = cArr.length;
        byte[] bArr = new byte[length];
        for (int i = 0; i != length; i++) {
            bArr[i] = (byte) cArr[i];
        }
        return bArr;
    }

    public abstract KeyParameter c(int i);

    public abstract KeyParameter d(int i);

    public abstract ParametersWithIV e(int i, int i2);

    public final void f(byte[] bArr, int i, byte[] bArr2) {
        this.f5798a = bArr;
        this.b = bArr2;
        this.a = i;
    }
}
