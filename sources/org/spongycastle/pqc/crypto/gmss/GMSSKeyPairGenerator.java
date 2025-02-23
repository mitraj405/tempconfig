package org.spongycastle.pqc.crypto.gmss;

import java.lang.reflect.Array;
import java.security.SecureRandom;
import java.util.Vector;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.spongycastle.util.Arrays;

public class GMSSKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public GMSSKeyGenerationParameters f6660a;

    /* renamed from: a  reason: collision with other field name */
    public GMSSParameters f6661a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f6662a;

    /* renamed from: a  reason: collision with other field name */
    public int[] f6663a;

    /* renamed from: a  reason: collision with other field name */
    public byte[][] f6664a;
    public int[] b;

    /* renamed from: b  reason: collision with other field name */
    public byte[][] f6665b;

    public final AsymmetricCipherKeyPair a() {
        int i;
        int i2;
        if (!this.f6662a) {
            SecureRandom secureRandom = new SecureRandom();
            GMSSParameters gMSSParameters = new GMSSParameters(4, new int[]{10, 10, 10, 10}, new int[]{3, 3, 3, 3}, new int[]{2, 2, 2, 2});
            this.f6660a = new GMSSKeyGenerationParameters(secureRandom, gMSSParameters);
            GMSSParameters gMSSParameters2 = new GMSSParameters(gMSSParameters.a, Arrays.d(gMSSParameters.f6666a), Arrays.d(this.f6660a.a.b), Arrays.d(this.f6660a.a.c));
            this.f6661a = gMSSParameters2;
            this.a = gMSSParameters2.a;
            this.f6663a = Arrays.d(gMSSParameters2.f6666a);
            Arrays.d(this.f6661a.b);
            this.b = Arrays.d(this.f6661a.c);
            int i3 = this.a;
            int[] iArr = new int[2];
            iArr[1] = 0;
            iArr[0] = i3;
            this.f6664a = (byte[][]) Array.newInstance(Byte.TYPE, iArr);
            int[] iArr2 = new int[2];
            iArr2[1] = 0;
            iArr2[0] = this.a - 1;
            this.f6665b = (byte[][]) Array.newInstance(Byte.TYPE, iArr2);
            SecureRandom secureRandom2 = new SecureRandom();
            if (this.a <= 0) {
                this.f6662a = true;
            } else {
                secureRandom2.nextBytes(this.f6664a[0]);
                byte[] bArr = this.f6664a[0];
                throw null;
            }
        }
        int i4 = this.a;
        byte[][][] bArr2 = new byte[i4][][];
        int i5 = i4 - 1;
        byte[][][] bArr3 = new byte[i5][][];
        Treehash[][] treehashArr = new Treehash[i4][];
        Treehash[][] treehashArr2 = new Treehash[i5][];
        Vector[] vectorArr = new Vector[i4];
        Vector[] vectorArr2 = new Vector[i5];
        Vector[][] vectorArr3 = new Vector[i4][];
        Vector[][] vectorArr4 = new Vector[(i4 - 1)][];
        int i6 = 0;
        while (true) {
            i = this.a;
            if (i6 >= i) {
                break;
            }
            int i7 = this.f6663a[i6];
            int[] iArr3 = new int[2];
            iArr3[1] = 0;
            iArr3[0] = i7;
            bArr2[i6] = (byte[][]) Array.newInstance(Byte.TYPE, iArr3);
            int i8 = this.f6663a[i6];
            treehashArr[i6] = new Treehash[(i8 - this.b[i6])];
            if (i6 > 0) {
                int i9 = i6 - 1;
                int[] iArr4 = new int[2];
                iArr4[1] = 0;
                iArr4[0] = i8;
                bArr3[i9] = (byte[][]) Array.newInstance(Byte.TYPE, iArr4);
                treehashArr2[i9] = new Treehash[(this.f6663a[i6] - this.b[i6])];
            }
            vectorArr[i6] = new Vector();
            if (i6 > 0) {
                vectorArr2[i6 - 1] = new Vector();
            }
            i6++;
        }
        int[] iArr5 = new int[2];
        iArr5[1] = 0;
        iArr5[0] = i;
        byte[][] bArr4 = (byte[][]) Array.newInstance(Byte.TYPE, iArr5);
        int[] iArr6 = new int[2];
        iArr6[1] = 0;
        iArr6[0] = this.a - 1;
        byte[][] bArr5 = (byte[][]) Array.newInstance(Byte.TYPE, iArr6);
        int i10 = this.a;
        int[] iArr7 = new int[2];
        iArr7[1] = 0;
        iArr7[0] = i10;
        byte[][] bArr6 = (byte[][]) Array.newInstance(Byte.TYPE, iArr7);
        int i11 = 0;
        while (true) {
            i2 = this.a;
            if (i11 >= i2) {
                break;
            }
            System.arraycopy(this.f6664a[i11], 0, bArr6[i11], 0, 0);
            i11++;
        }
        int[] iArr8 = new int[2];
        iArr8[1] = 0;
        iArr8[0] = i2 - 1;
        byte[][] bArr7 = (byte[][]) Array.newInstance(Byte.TYPE, iArr8);
        int i12 = this.a;
        int i13 = i12 - 1;
        if (i13 < 0) {
            int i14 = i12 - 2;
            if (i14 < 0) {
                byte[] bArr8 = bArr4[0];
                new GMSSPrivateKeyParameters(this.f6664a, this.f6665b, bArr2, bArr3, treehashArr, treehashArr2, vectorArr, vectorArr2, vectorArr3, vectorArr4, bArr5, bArr7, this.f6661a);
                throw null;
            }
            Vector vector = vectorArr2[i14];
            int i15 = i14 + 1;
            byte[] bArr9 = bArr6[i15];
            byte[] bArr10 = new byte[i12];
            new GMSSRootCalc(this.f6663a[i15], this.b[i15], (GMSSDigestProvider) null);
            throw null;
        }
        new GMSSRootCalc(this.f6663a[i13], this.b[i13], (GMSSDigestProvider) null);
        throw null;
    }
}
