package org.spongycastle.pqc.crypto.gmss;

import java.lang.reflect.Array;
import java.util.Vector;
import org.spongycastle.crypto.Digest;
import org.spongycastle.util.encoders.Hex;

public class GMSSRootCalc {
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public final Digest f6667a;

    /* renamed from: a  reason: collision with other field name */
    public final GMSSDigestProvider f6668a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f6669a;

    /* renamed from: a  reason: collision with other field name */
    public int[] f6670a;

    /* renamed from: a  reason: collision with other field name */
    public Vector[] f6671a;

    /* renamed from: a  reason: collision with other field name */
    public byte[][] f6672a;
    public final int b;
    public final int c;

    public GMSSRootCalc(int i, int i2, GMSSDigestProvider gMSSDigestProvider) {
        this.a = i;
        this.f6668a = gMSSDigestProvider;
        Digest a2 = gMSSDigestProvider.a();
        this.f6667a = a2;
        int f = a2.f();
        this.b = f;
        this.c = i2;
        this.f6670a = new int[i];
        int[] iArr = new int[2];
        iArr[1] = f;
        iArr[0] = i;
        this.f6672a = (byte[][]) Array.newInstance(Byte.TYPE, iArr);
        this.f6669a = new byte[f];
        this.f6671a = new Vector[(i2 - 1)];
        for (int i3 = 0; i3 < i2 - 1; i3++) {
            this.f6671a[i3] = new Vector();
        }
    }

    public final String toString() {
        int i;
        String str = "";
        int i2 = 0;
        while (true) {
            i = this.a;
            if (i2 >= i + 8 + 0) {
                break;
            }
            StringBuilder J = xx.J(str);
            int[] iArr = new int[(i + 8 + 0)];
            iArr[0] = i;
            iArr[1] = this.b;
            iArr[2] = this.c;
            iArr[3] = 0;
            iArr[4] = 0;
            iArr[5] = 0;
            iArr[6] = 0;
            iArr[7] = 0;
            for (int i3 = 0; i3 < i; i3++) {
                iArr[i3 + 8] = this.f6670a[i3];
            }
            str = lf.k(J, iArr[i2], " ");
            i2++;
        }
        for (int i4 = 0; i4 < i + 1 + 0; i4++) {
            StringBuilder J2 = xx.J(str);
            int[] iArr2 = new int[2];
            iArr2[1] = 64;
            iArr2[0] = i + 1 + 0;
            byte[][] bArr = (byte[][]) Array.newInstance(Byte.TYPE, iArr2);
            bArr[0] = this.f6669a;
            int i5 = 0;
            while (i5 < i) {
                int i6 = i5 + 1;
                bArr[i6] = this.f6672a[i5];
                i5 = i6;
            }
            str = C0709Uj.j(J2, new String(Hex.c(bArr[i4])), " ");
        }
        StringBuilder n = lf.n(str, "  ");
        n.append(this.f6668a.a().f());
        return n.toString();
    }
}
