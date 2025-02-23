package org.spongycastle.pqc.crypto.rainbow;

import com.google.firebase.perf.util.Constants;
import java.lang.reflect.Array;
import java.security.SecureRandom;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.pqc.crypto.rainbow.util.ComputeInField;
import org.spongycastle.pqc.crypto.rainbow.util.GF2Field;

public class RainbowKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public SecureRandom f6726a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f6727a = false;

    /* renamed from: a  reason: collision with other field name */
    public int[] f6728a;

    /* renamed from: a  reason: collision with other field name */
    public Layer[] f6729a;

    /* renamed from: a  reason: collision with other field name */
    public short[] f6730a;

    /* renamed from: a  reason: collision with other field name */
    public short[][] f6731a;
    public short[] b;

    /* renamed from: b  reason: collision with other field name */
    public short[][] f6732b;
    public short[] c;

    /* renamed from: c  reason: collision with other field name */
    public short[][] f6733c;
    public short[][] d;
    public short[][] e;
    public short[][] f;

    public final AsymmetricCipherKeyPair a() {
        if (!this.f6727a) {
            b(new RainbowKeyGenerationParameters(new SecureRandom(), new RainbowParameters()));
        }
        int[] iArr = this.f6728a;
        int i = 0;
        int i2 = iArr[iArr.length - 1] - iArr[0];
        int[] iArr2 = new int[2];
        iArr2[1] = i2;
        iArr2[0] = i2;
        this.f6731a = (short[][]) Array.newInstance(Short.TYPE, iArr2);
        this.f6732b = null;
        ComputeInField computeInField = new ComputeInField();
        while (this.f6732b == null) {
            for (int i3 = 0; i3 < i2; i3++) {
                for (int i4 = 0; i4 < i2; i4++) {
                    this.f6731a[i3][i4] = (short) (this.f6726a.nextInt() & Constants.MAX_HOST_LENGTH);
                }
            }
            this.f6732b = computeInField.e(this.f6731a);
        }
        this.f6730a = new short[i2];
        for (int i5 = 0; i5 < i2; i5++) {
            this.f6730a[i5] = (short) (this.f6726a.nextInt() & Constants.MAX_HOST_LENGTH);
        }
        int[] iArr3 = this.f6728a;
        int i6 = iArr3[iArr3.length - 1];
        int[] iArr4 = new int[2];
        iArr4[1] = i6;
        iArr4[0] = i6;
        this.f6733c = (short[][]) Array.newInstance(Short.TYPE, iArr4);
        this.d = null;
        ComputeInField computeInField2 = new ComputeInField();
        while (this.d == null) {
            for (int i7 = 0; i7 < i6; i7++) {
                for (int i8 = 0; i8 < i6; i8++) {
                    this.f6733c[i7][i8] = (short) (this.f6726a.nextInt() & Constants.MAX_HOST_LENGTH);
                }
            }
            this.d = computeInField2.e(this.f6733c);
        }
        this.b = new short[i6];
        for (int i9 = 0; i9 < i6; i9++) {
            this.b[i9] = (short) (this.f6726a.nextInt() & Constants.MAX_HOST_LENGTH);
        }
        this.f6729a = new Layer[this.a];
        int i10 = 0;
        while (i10 < this.a) {
            Layer[] layerArr = this.f6729a;
            int[] iArr5 = this.f6728a;
            int i11 = i10 + 1;
            layerArr[i10] = new Layer(iArr5[i10], iArr5[i11], this.f6726a);
            i10 = i11;
        }
        new ComputeInField();
        int[] iArr6 = this.f6728a;
        int i12 = iArr6[iArr6.length - 1] - iArr6[0];
        int i13 = iArr6[iArr6.length - 1];
        int i14 = 3;
        int[] iArr7 = new int[3];
        iArr7[2] = i13;
        iArr7[1] = i13;
        iArr7[0] = i12;
        short[][][] sArr = (short[][][]) Array.newInstance(Short.TYPE, iArr7);
        int[] iArr8 = new int[2];
        iArr8[1] = i13;
        iArr8[0] = i12;
        this.f = (short[][]) Array.newInstance(Short.TYPE, iArr8);
        this.c = new short[i12];
        short[] sArr2 = new short[i13];
        int i15 = 0;
        int i16 = 0;
        while (true) {
            Layer[] layerArr2 = this.f6729a;
            if (i15 >= layerArr2.length) {
                break;
            }
            Layer layer = layerArr2[i15];
            short[][][] sArr3 = layer.f6724a;
            int length = sArr3[i].length;
            short[][][] sArr4 = layer.f6725b;
            int length2 = sArr4[i].length;
            int i17 = i;
            while (i17 < length) {
                while (i < length) {
                    int i18 = 0;
                    while (i18 < length2) {
                        int i19 = i + length2;
                        short[] f2 = ComputeInField.f(this.f6733c[i19], sArr3[i17][i][i18]);
                        int i20 = i16 + i17;
                        int i21 = i13;
                        sArr[i20] = ComputeInField.a(sArr[i20], ComputeInField.g(f2, this.f6733c[i18]));
                        short[] f3 = ComputeInField.f(f2, this.b[i18]);
                        short[][] sArr5 = this.f;
                        sArr5[i20] = ComputeInField.b(f3, sArr5[i20]);
                        short[] f4 = ComputeInField.f(ComputeInField.f(this.f6733c[i18], sArr3[i17][i][i18]), this.b[i19]);
                        short[][] sArr6 = this.f;
                        sArr6[i20] = ComputeInField.b(f4, sArr6[i20]);
                        short b2 = GF2Field.b(sArr3[i17][i][i18], this.b[i19]);
                        short[] sArr7 = this.c;
                        sArr7[i20] = (short) (GF2Field.b(b2, this.b[i18]) ^ sArr7[i20]);
                        i18++;
                        sArr3 = sArr3;
                        i12 = i12;
                        i13 = i21;
                    }
                    int i22 = i13;
                    int i23 = i12;
                    short[][][] sArr8 = sArr3;
                    i++;
                }
                int i24 = i13;
                int i25 = i12;
                short[][][] sArr9 = sArr3;
                for (int i26 = 0; i26 < length2; i26++) {
                    for (int i27 = 0; i27 < length2; i27++) {
                        short[] f5 = ComputeInField.f(this.f6733c[i26], sArr4[i17][i26][i27]);
                        int i28 = i16 + i17;
                        sArr[i28] = ComputeInField.a(sArr[i28], ComputeInField.g(f5, this.f6733c[i27]));
                        short[] f6 = ComputeInField.f(f5, this.b[i27]);
                        short[][] sArr10 = this.f;
                        sArr10[i28] = ComputeInField.b(f6, sArr10[i28]);
                        short[] f7 = ComputeInField.f(ComputeInField.f(this.f6733c[i27], sArr4[i17][i26][i27]), this.b[i26]);
                        short[][] sArr11 = this.f;
                        sArr11[i28] = ComputeInField.b(f7, sArr11[i28]);
                        short b3 = GF2Field.b(sArr4[i17][i26][i27], this.b[i26]);
                        short[] sArr12 = this.c;
                        sArr12[i28] = (short) (GF2Field.b(b3, this.b[i27]) ^ sArr12[i28]);
                    }
                }
                for (int i29 = 0; i29 < length2 + length; i29++) {
                    short[][] sArr13 = layer.f6723a;
                    short[] f8 = ComputeInField.f(this.f6733c[i29], sArr13[i17][i29]);
                    short[][] sArr14 = this.f;
                    int i30 = i16 + i17;
                    sArr14[i30] = ComputeInField.b(f8, sArr14[i30]);
                    short[] sArr15 = this.c;
                    sArr15[i30] = (short) (GF2Field.b(sArr13[i17][i29], this.b[i29]) ^ sArr15[i30]);
                }
                short[] sArr16 = this.c;
                int i31 = i16 + i17;
                sArr16[i31] = (short) (sArr16[i31] ^ layer.f6722a[i17]);
                i17++;
                sArr3 = sArr9;
                i12 = i25;
                i13 = i24;
                i = 0;
            }
            int i32 = i13;
            int i33 = i12;
            i16 += length;
            i15++;
            i = 0;
            i14 = 3;
        }
        int i34 = i13;
        int i35 = i12;
        int[] iArr9 = new int[i14];
        iArr9[2] = i34;
        iArr9[1] = i34;
        iArr9[0] = i35;
        short[][][] sArr17 = (short[][][]) Array.newInstance(Short.TYPE, iArr9);
        int[] iArr10 = new int[2];
        iArr10[1] = i34;
        iArr10[0] = i35;
        short[][] sArr18 = (short[][]) Array.newInstance(Short.TYPE, iArr10);
        int i36 = i35;
        short[] sArr19 = new short[i36];
        for (int i37 = 0; i37 < i36; i37++) {
            int i38 = 0;
            while (true) {
                short[][] sArr20 = this.f6731a;
                if (i38 >= sArr20.length) {
                    break;
                }
                short[][] sArr21 = sArr17[i37];
                short s = sArr20[i37][i38];
                short[][] sArr22 = sArr[i38];
                int length3 = sArr22.length;
                int i39 = 0;
                int[] iArr11 = new int[2];
                iArr11[1] = sArr22[0].length;
                iArr11[0] = length3;
                short[][] sArr23 = (short[][]) Array.newInstance(Short.TYPE, iArr11);
                int i40 = 0;
                while (i40 < sArr22.length) {
                    int i41 = i39;
                    while (i41 < sArr22[i39].length) {
                        sArr23[i40][i41] = GF2Field.b(s, sArr22[i40][i41]);
                        i41++;
                        i39 = 0;
                    }
                    i40++;
                    i39 = 0;
                }
                sArr17[i37] = ComputeInField.a(sArr21, sArr23);
                sArr18[i37] = ComputeInField.b(sArr18[i37], ComputeInField.f(this.f[i38], this.f6731a[i37][i38]));
                sArr19[i37] = (short) (sArr19[i37] ^ GF2Field.b(this.f6731a[i37][i38], this.c[i38]));
                i38++;
            }
            sArr19[i37] = (short) (sArr19[i37] ^ this.f6730a[i37]);
        }
        this.f = sArr18;
        this.c = sArr19;
        int length4 = sArr17.length;
        int length5 = sArr17[0].length;
        int[] iArr12 = new int[2];
        iArr12[1] = ((length5 + 1) * length5) / 2;
        iArr12[0] = length4;
        this.e = (short[][]) Array.newInstance(Short.TYPE, iArr12);
        for (int i42 = 0; i42 < length4; i42++) {
            int i43 = 0;
            for (int i44 = 0; i44 < length5; i44++) {
                for (int i45 = i44; i45 < length5; i45++) {
                    if (i45 == i44) {
                        this.e[i42][i43] = sArr17[i42][i44][i45];
                    } else {
                        short[] sArr24 = this.e[i42];
                        short[][] sArr25 = sArr17[i42];
                        sArr24[i43] = (short) (sArr25[i45][i44] ^ sArr25[i44][i45]);
                    }
                    i43++;
                }
            }
        }
        RainbowPrivateKeyParameters rainbowPrivateKeyParameters = new RainbowPrivateKeyParameters(this.f6732b, this.f6730a, this.d, this.b, this.f6728a, this.f6729a);
        int[] iArr13 = this.f6728a;
        return new AsymmetricCipherKeyPair(new RainbowPublicKeyParameters(iArr13[iArr13.length - 1] - iArr13[0], this.e, this.f, this.c), rainbowPrivateKeyParameters);
    }

    public final void b(KeyGenerationParameters keyGenerationParameters) {
        RainbowKeyGenerationParameters rainbowKeyGenerationParameters = (RainbowKeyGenerationParameters) keyGenerationParameters;
        this.f6726a = rainbowKeyGenerationParameters.a;
        int[] iArr = rainbowKeyGenerationParameters.a.a;
        this.f6728a = iArr;
        this.a = iArr.length - 1;
        this.f6727a = true;
    }
}
