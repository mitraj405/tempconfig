package org.spongycastle.pqc.math.linearalgebra;

import com.google.android.gms.ads.AdRequest;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Shorts;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.perf.util.Constants;
import java.util.Random;

public class GF2Polynomial {
    public static final Random a = new Random();

    /* renamed from: a  reason: collision with other field name */
    public static final short[] f6845a = {0, 1, 4, 5, 16, 17, 20, 21, 64, 65, 68, 69, 80, 81, 84, 85, 256, 257, 260, 261, 272, 273, 276, 277, 320, 321, 324, 325, 336, 337, 340, 341, 1024, 1025, 1028, 1029, 1040, 1041, 1044, 1045, 1088, 1089, 1092, 1093, 1104, 1105, 1108, 1109, 1280, 1281, 1284, 1285, 1296, 1297, 1300, 1301, 1344, 1345, 1348, 1349, 1360, 1361, 1364, 1365, 4096, 4097, 4100, 4101, 4112, 4113, 4116, 4117, 4160, 4161, 4164, 4165, 4176, 4177, 4180, 4181, 4352, 4353, 4356, 4357, 4368, 4369, 4372, 4373, 4416, 4417, 4420, 4421, 4432, 4433, 4436, 4437, 5120, 5121, 5124, 5125, 5136, 5137, 5140, 5141, 5184, 5185, 5188, 5189, 5200, 5201, 5204, 5205, 5376, 5377, 5380, 5381, 5392, 5393, 5396, 5397, 5440, 5441, 5444, 5445, 5456, 5457, 5460, 5461, Shorts.MAX_POWER_OF_TWO, 16385, 16388, 16389, 16400, 16401, 16404, 16405, 16448, 16449, 16452, 16453, 16464, 16465, 16468, 16469, 16640, 16641, 16644, 16645, 16656, 16657, 16660, 16661, 16704, 16705, 16708, 16709, 16720, 16721, 16724, 16725, 17408, 17409, 17412, 17413, 17424, 17425, 17428, 17429, 17472, 17473, 17476, 17477, 17488, 17489, 17492, 17493, 17664, 17665, 17668, 17669, 17680, 17681, 17684, 17685, 17728, 17729, 17732, 17733, 17744, 17745, 17748, 17749, 20480, 20481, 20484, 20485, 20496, 20497, 20500, 20501, 20544, 20545, 20548, 20549, 20560, 20561, 20564, 20565, 20736, 20737, 20740, 20741, 20752, 20753, 20756, 20757, 20800, 20801, 20804, 20805, 20816, 20817, 20820, 20821, 21504, 21505, 21508, 21509, 21520, 21521, 21524, 21525, 21568, 21569, 21572, 21573, 21584, 21585, 21588, 21589, 21760, 21761, 21764, 21765, 21776, 21777, 21780, 21781, 21824, 21825, 21828, 21829, 21840, 21841, 21844, 21845};
    public static final int[] b = {1, 2, 4, 8, 16, 32, 64, 128, 256, AdRequest.MAX_CONTENT_URL_LENGTH, UserMetadata.MAX_ATTRIBUTE_SIZE, 2048, 4096, UserMetadata.MAX_INTERNAL_KEY_SIZE, 16384, 32768, 65536, 131072, 262144, 524288, 1048576, 2097152, 4194304, 8388608, 16777216, 33554432, 67108864, 134217728, 268435456, 536870912, Ints.MAX_POWER_OF_TWO, Integer.MIN_VALUE, 0};
    public static final int[] c = {0, 1, 3, 7, 15, 31, 63, 127, Constants.MAX_HOST_LENGTH, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535, 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};

    /* renamed from: a  reason: collision with other field name */
    public int f6846a;

    /* renamed from: a  reason: collision with other field name */
    public int[] f6847a;

    /* renamed from: b  reason: collision with other field name */
    public int f6848b;

    public GF2Polynomial() {
        this.f6848b = 1;
        this.f6847a = new int[1];
        this.f6846a = 1;
    }

    public final void a(int i) {
        if (this.f6846a < i) {
            this.f6846a = i;
            int i2 = ((i - 1) >>> 5) + 1;
            int i3 = this.f6848b;
            if (i3 < i2) {
                int[] iArr = this.f6847a;
                if (iArr.length >= i2) {
                    while (i3 < i2) {
                        this.f6847a[i3] = 0;
                        i3++;
                    }
                    this.f6848b = i2;
                    return;
                }
                int[] iArr2 = new int[i2];
                System.arraycopy(iArr, 0, iArr2, 0, i3);
                this.f6848b = i2;
                this.f6847a = iArr2;
            }
        }
    }

    public final boolean b() {
        if (this.f6846a == 0) {
            return true;
        }
        for (int i = 0; i < this.f6848b; i++) {
            if (this.f6847a[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public final void c() {
        int i;
        int i2 = this.f6848b;
        while (true) {
            i2--;
            i = this.f6847a[i2];
            if (i != 0 || i2 <= 0) {
                int i3 = 0;
            }
        }
        int i32 = 0;
        while (i != 0) {
            i >>>= 1;
            i32++;
        }
        this.f6846a = (i2 << 5) + i32;
        this.f6848b = i2 + 1;
    }

    public final Object clone() {
        return new GF2Polynomial(this);
    }

    public final GF2Polynomial d(GF2Polynomial gF2Polynomial) throws RuntimeException {
        GF2Polynomial gF2Polynomial2 = new GF2Polynomial(this);
        GF2Polynomial gF2Polynomial3 = new GF2Polynomial(gF2Polynomial);
        if (!gF2Polynomial3.b()) {
            gF2Polynomial2.c();
            gF2Polynomial3.c();
            int i = gF2Polynomial2.f6846a;
            int i2 = gF2Polynomial3.f6846a;
            if (i < i2) {
                return gF2Polynomial2;
            }
            while (true) {
                int i3 = i - i2;
                if (i3 < 0) {
                    return gF2Polynomial2;
                }
                GF2Polynomial gF2Polynomial4 = new GF2Polynomial(gF2Polynomial3.f6846a + i3, gF2Polynomial3.f6847a);
                if (i3 >= 32) {
                    int i4 = i3 >>> 5;
                    int i5 = gF2Polynomial4.f6848b;
                    int[] iArr = gF2Polynomial4.f6847a;
                    if (i5 <= iArr.length) {
                        while (true) {
                            i5--;
                            if (i5 < i4) {
                                break;
                            }
                            int[] iArr2 = gF2Polynomial4.f6847a;
                            iArr2[i5] = iArr2[i5 - i4];
                        }
                        for (int i6 = 0; i6 < i4; i6++) {
                            gF2Polynomial4.f6847a[i6] = 0;
                        }
                    } else {
                        int[] iArr3 = new int[i5];
                        System.arraycopy(iArr, 0, iArr3, i4, i5 - i4);
                        gF2Polynomial4.f6847a = iArr3;
                    }
                }
                int i7 = i3 & 31;
                if (i7 != 0) {
                    int i8 = gF2Polynomial4.f6848b - 1;
                    while (i8 >= 1) {
                        int[] iArr4 = gF2Polynomial4.f6847a;
                        int i9 = iArr4[i8] << i7;
                        iArr4[i8] = i9;
                        int i10 = i8 - 1;
                        iArr4[i8] = i9 | (iArr4[i10] >>> (32 - i7));
                        i8 = i10;
                    }
                    int[] iArr5 = gF2Polynomial4.f6847a;
                    iArr5[0] = iArr5[0] << i7;
                }
                gF2Polynomial2.a(gF2Polynomial4.f6846a);
                gF2Polynomial2.f(gF2Polynomial4);
                gF2Polynomial2.c();
                i = gF2Polynomial2.f6846a;
                i2 = gF2Polynomial3.f6846a;
            }
        } else {
            throw new RuntimeException();
        }
    }

    public final void e() throws RuntimeException {
        if (this.f6846a - 1 >= 0) {
            int[] iArr = this.f6847a;
            iArr[0] = iArr[0] | b[0];
            return;
        }
        throw new RuntimeException();
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof GF2Polynomial)) {
            return false;
        }
        GF2Polynomial gF2Polynomial = (GF2Polynomial) obj;
        if (this.f6846a != gF2Polynomial.f6846a) {
            return false;
        }
        for (int i = 0; i < this.f6848b; i++) {
            if (this.f6847a[i] != gF2Polynomial.f6847a[i]) {
                return false;
            }
        }
        return true;
    }

    public final void f(GF2Polynomial gF2Polynomial) {
        for (int i = 0; i < Math.min(this.f6848b, gF2Polynomial.f6848b); i++) {
            int[] iArr = this.f6847a;
            iArr[i] = iArr[i] ^ gF2Polynomial.f6847a[i];
        }
        g();
    }

    public final void g() {
        int i = this.f6846a;
        if ((i & 31) != 0) {
            int[] iArr = this.f6847a;
            int i2 = this.f6848b - 1;
            iArr[i2] = c[i & 31] & iArr[i2];
        }
    }

    public final int hashCode() {
        return this.f6847a.hashCode() + this.f6846a;
    }

    public GF2Polynomial(int i) {
        i = i < 1 ? 1 : i;
        int i2 = ((i - 1) >> 5) + 1;
        this.f6848b = i2;
        this.f6847a = new int[i2];
        this.f6846a = i;
        for (int i3 = 1; i3 < this.f6848b; i3++) {
            this.f6847a[i3] = 0;
        }
        this.f6847a[0] = 2;
    }

    public GF2Polynomial(int i, int[] iArr) {
        i = i < 1 ? 1 : i;
        int i2 = ((i - 1) >> 5) + 1;
        this.f6848b = i2;
        this.f6847a = new int[i2];
        this.f6846a = i;
        System.arraycopy(iArr, 0, this.f6847a, 0, Math.min(i2, iArr.length));
        g();
    }

    public GF2Polynomial(GF2Polynomial gF2Polynomial) {
        this.f6846a = gF2Polynomial.f6846a;
        this.f6848b = gF2Polynomial.f6848b;
        this.f6847a = IntUtils.a(gF2Polynomial.f6847a);
    }
}
