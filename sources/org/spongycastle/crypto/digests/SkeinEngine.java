package org.spongycastle.crypto.digests;

import com.google.android.gms.ads.AdRequest;
import com.google.common.primitives.Longs;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.engines.ThreefishEngine;
import org.spongycastle.crypto.params.SkeinParameters;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Memoable;

public class SkeinEngine implements Memoable {
    public static final Hashtable a = new Hashtable();

    /* renamed from: a  reason: collision with other field name */
    public final int f5859a;

    /* renamed from: a  reason: collision with other field name */
    public final UBI f5860a;

    /* renamed from: a  reason: collision with other field name */
    public final ThreefishEngine f5861a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f5862a;

    /* renamed from: a  reason: collision with other field name */
    public long[] f5863a;

    /* renamed from: a  reason: collision with other field name */
    public Parameter[] f5864a;
    public final byte[] b;

    /* renamed from: b  reason: collision with other field name */
    public long[] f5865b;

    /* renamed from: b  reason: collision with other field name */
    public Parameter[] f5866b;

    public static class Configuration {
        public final byte[] a;

        public Configuration(long j) {
            byte[] bArr = new byte[32];
            this.a = bArr;
            bArr[0] = 83;
            bArr[1] = 72;
            bArr[2] = 65;
            bArr[3] = 51;
            bArr[4] = 1;
            bArr[5] = 0;
            ThreefishEngine.i(j, bArr, 8);
        }
    }

    public static class Parameter {
        public final int a;

        /* renamed from: a  reason: collision with other field name */
        public final byte[] f5867a;

        public Parameter(int i, byte[] bArr) {
            this.a = i;
            this.f5867a = bArr;
        }
    }

    public class UBI {
        public int a;

        /* renamed from: a  reason: collision with other field name */
        public final UbiTweak f5868a = new UbiTweak();

        /* renamed from: a  reason: collision with other field name */
        public byte[] f5870a;

        /* renamed from: a  reason: collision with other field name */
        public long[] f5871a;

        public UBI(int i) {
            byte[] bArr = new byte[i];
            this.f5870a = bArr;
            this.f5871a = new long[(bArr.length / 8)];
        }

        public final void a(long[] jArr) {
            int i = this.a;
            while (true) {
                byte[] bArr = this.f5870a;
                if (i < bArr.length) {
                    bArr[i] = 0;
                    i++;
                } else {
                    long[] jArr2 = this.f5868a.f5872a;
                    jArr2[1] = jArr2[1] | Long.MIN_VALUE;
                    b(jArr);
                    return;
                }
            }
        }

        public final void b(long[] jArr) {
            long[] jArr2;
            SkeinEngine skeinEngine = SkeinEngine.this;
            skeinEngine.f5861a.f(true, skeinEngine.f5863a, this.f5868a.f5872a);
            int i = 0;
            while (true) {
                jArr2 = this.f5871a;
                if (i >= jArr2.length) {
                    break;
                }
                jArr2[i] = ThreefishEngine.d(i * 8, this.f5870a);
                i++;
            }
            skeinEngine.f5861a.g(jArr2, jArr);
            for (int i2 = 0; i2 < jArr.length; i2++) {
                jArr[i2] = jArr[i2] ^ this.f5871a[i2];
            }
        }

        public final void c(byte[] bArr, int i, int i2, long[] jArr) {
            int i3 = i2;
            int i4 = 0;
            while (i3 > i4) {
                int i5 = this.a;
                int length = this.f5870a.length;
                UbiTweak ubiTweak = this.f5868a;
                if (i5 == length) {
                    b(jArr);
                    long[] jArr2 = ubiTweak.f5872a;
                    jArr2[1] = jArr2[1] & -4611686018427387905L;
                    this.a = 0;
                } else {
                    long[] jArr3 = jArr;
                }
                int min = Math.min(i3 - i4, this.f5870a.length - this.a);
                System.arraycopy(bArr, i + i4, this.f5870a, this.a, min);
                i4 += min;
                this.a += min;
                if (ubiTweak.a) {
                    long[] jArr4 = ubiTweak.f5872a;
                    long[] jArr5 = {jArr4[0] & 4294967295L, (jArr4[0] >>> 32) & 4294967295L, jArr4[1] & 4294967295L};
                    long j = (long) min;
                    for (int i6 = 0; i6 < 3; i6++) {
                        long j2 = j + jArr5[i6];
                        jArr5[i6] = j2;
                        j = j2 >>> 32;
                    }
                    long[] jArr6 = ubiTweak.f5872a;
                    jArr6[0] = ((jArr5[1] & 4294967295L) << 32) | (jArr5[0] & 4294967295L);
                    jArr6[1] = (jArr6[1] & -4294967296L) | (jArr5[2] & 4294967295L);
                } else {
                    long[] jArr7 = ubiTweak.f5872a;
                    long j3 = jArr7[0] + ((long) min);
                    jArr7[0] = j3;
                    if (j3 > 9223372034707292160L) {
                        ubiTweak.a = true;
                    }
                }
            }
        }
    }

    public static class UbiTweak {
        public boolean a = false;

        /* renamed from: a  reason: collision with other field name */
        public long[] f5872a;

        public UbiTweak() {
            long[] jArr = new long[2];
            this.f5872a = jArr;
            jArr[0] = 0;
            jArr[1] = 0;
            jArr[1] = 4611686018427387904L;
        }

        public final String toString() {
            boolean z;
            StringBuilder sb = new StringBuilder();
            boolean z2 = true;
            sb.append((int) ((this.f5872a[1] >>> 56) & 63));
            sb.append(" first: ");
            if ((this.f5872a[1] & Longs.MAX_POWER_OF_TWO) != 0) {
                z = true;
            } else {
                z = false;
            }
            sb.append(z);
            sb.append(", final: ");
            if ((this.f5872a[1] & Long.MIN_VALUE) == 0) {
                z2 = false;
            }
            sb.append(z2);
            return sb.toString();
        }
    }

    static {
        f(new long[]{-2228972824489528736L, -8629553674646093540L, 1155188648486244218L, -3677226592081559102L}, 256, 128);
        f(new long[]{1450197650740764312L, 3081844928540042640L, -3136097061834271170L, 3301952811952417661L}, 256, 160);
        f(new long[]{-4176654842910610933L, -8688192972455077604L, -7364642305011795836L, 4056579644589979102L}, 256, 224);
        f(new long[]{-243853671043386295L, 3443677322885453875L, -5531612722399640561L, 7662005193972177513L}, 256, 256);
        f(new long[]{-6288014694233956526L, 2204638249859346602L, 3502419045458743507L, -4829063503441264548L, 983504137758028059L, 1880512238245786339L, -6715892782214108542L, 7602827311880509485L}, AdRequest.MAX_CONTENT_URL_LENGTH, 128);
        f(new long[]{2934123928682216849L, -4399710721982728305L, 1684584802963255058L, 5744138295201861711L, 2444857010922934358L, -2807833639722848072L, -5121587834665610502L, 118355523173251694L}, AdRequest.MAX_CONTENT_URL_LENGTH, 160);
        f(new long[]{-3688341020067007964L, -3772225436291745297L, -8300862168937575580L, 4146387520469897396L, 1106145742801415120L, 7455425944880474941L, -7351063101234211863L, -7048981346965512457L}, AdRequest.MAX_CONTENT_URL_LENGTH, 224);
        f(new long[]{-6631894876634615969L, -5692838220127733084L, -7099962856338682626L, -2911352911530754598L, 2000907093792408677L, 9140007292425499655L, 6093301768906360022L, 2769176472213098488L}, AdRequest.MAX_CONTENT_URL_LENGTH, 384);
        f(new long[]{5261240102383538638L, 978932832955457283L, -8083517948103779378L, -7339365279355032399L, 6752626034097301424L, -1531723821829733388L, -7417126464950782685L, -5901786942805128141L}, AdRequest.MAX_CONTENT_URL_LENGTH, AdRequest.MAX_CONTENT_URL_LENGTH);
    }

    public SkeinEngine(SkeinEngine skeinEngine) {
        this(skeinEngine.f5861a.f6057a * 8, skeinEngine.f5859a * 8);
        b(skeinEngine);
    }

    public static void f(long[] jArr, int i, int i2) {
        a.put(new Integer((i / 8) | ((i2 / 8) << 16)), jArr);
    }

    public static void g(Parameter[] parameterArr) {
        if (parameterArr != null) {
            for (int i = 1; i < parameterArr.length; i++) {
                Parameter parameter = parameterArr[i];
                int i2 = i;
                while (i2 > 0) {
                    int i3 = parameter.a;
                    int i4 = i2 - 1;
                    Parameter parameter2 = parameterArr[i4];
                    if (i3 >= parameter2.a) {
                        break;
                    }
                    parameterArr[i2] = parameter2;
                    i2 = i4;
                }
                parameterArr[i2] = parameter;
            }
        }
    }

    public final Memoable a() {
        return new SkeinEngine(this);
    }

    public final void b(SkeinEngine skeinEngine) {
        UBI ubi = skeinEngine.f5860a;
        UBI ubi2 = this.f5860a;
        ubi2.getClass();
        byte[] bArr = ubi.f5870a;
        byte[] bArr2 = ubi2.f5870a;
        Parameter[] parameterArr = null;
        if (bArr == null) {
            bArr2 = null;
        } else if (bArr2 == null || bArr2.length != bArr.length) {
            bArr2 = Arrays.c(bArr);
        } else {
            System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
        }
        ubi2.f5870a = bArr2;
        ubi2.a = ubi.a;
        ubi2.f5871a = Arrays.f(ubi.f5871a, ubi2.f5871a);
        UbiTweak ubiTweak = ubi2.f5868a;
        ubiTweak.getClass();
        UbiTweak ubiTweak2 = ubi.f5868a;
        ubiTweak.f5872a = Arrays.f(ubiTweak2.f5872a, ubiTweak.f5872a);
        ubiTweak.a = ubiTweak2.a;
        this.f5863a = Arrays.f(skeinEngine.f5863a, this.f5863a);
        this.f5865b = Arrays.f(skeinEngine.f5865b, this.f5865b);
        byte[] bArr3 = skeinEngine.f5862a;
        byte[] bArr4 = this.f5862a;
        if (bArr3 == null) {
            bArr4 = null;
        } else if (bArr4 == null || bArr4.length != bArr3.length) {
            bArr4 = Arrays.c(bArr3);
        } else {
            System.arraycopy(bArr3, 0, bArr4, 0, bArr4.length);
        }
        this.f5862a = bArr4;
        Parameter[] parameterArr2 = skeinEngine.f5864a;
        Parameter[] parameterArr3 = this.f5864a;
        if (parameterArr2 == null) {
            parameterArr3 = null;
        } else {
            if (parameterArr3 == null || parameterArr3.length != parameterArr2.length) {
                parameterArr3 = new Parameter[parameterArr2.length];
            }
            System.arraycopy(parameterArr2, 0, parameterArr3, 0, parameterArr3.length);
        }
        this.f5864a = parameterArr3;
        Parameter[] parameterArr4 = skeinEngine.f5866b;
        Parameter[] parameterArr5 = this.f5866b;
        if (parameterArr4 != null) {
            if (parameterArr5 == null || parameterArr5.length != parameterArr4.length) {
                parameterArr5 = new Parameter[parameterArr4.length];
            }
            parameterArr = parameterArr5;
            System.arraycopy(parameterArr4, 0, parameterArr, 0, parameterArr.length);
        }
        this.f5866b = parameterArr;
    }

    public final int c(int i, byte[] bArr) {
        UBI ubi;
        int i2;
        byte[] bArr2;
        byte[] bArr3 = bArr;
        UBI ubi2 = this.f5860a;
        if (ubi2 != null) {
            int length = bArr3.length;
            int i3 = this.f5859a;
            if (length >= i + i3) {
                ubi2.a(this.f5863a);
                int i4 = 0;
                if (this.f5866b != null) {
                    int i5 = 0;
                    while (true) {
                        Parameter[] parameterArr = this.f5866b;
                        if (i5 >= parameterArr.length) {
                            break;
                        }
                        Parameter parameter = parameterArr[i5];
                        h(parameter.a, parameter.f5867a);
                        i5++;
                    }
                }
                int i6 = this.f5861a.f6057a;
                int i7 = ((i3 + i6) - 1) / i6;
                int i8 = 0;
                while (i8 < i7) {
                    int i9 = i8 * i6;
                    int min = Math.min(i6, i3 - i9);
                    int i10 = i + i9;
                    int i11 = 8;
                    byte[] bArr4 = new byte[8];
                    ThreefishEngine.i((long) i8, bArr4, i4);
                    long[] jArr = new long[this.f5863a.length];
                    i(63);
                    ubi2.c(bArr4, i4, 8, jArr);
                    ubi2.a(jArr);
                    int i12 = ((min + 8) - 1) / 8;
                    int i13 = i4;
                    while (i13 < i12) {
                        int i14 = i13 * 8;
                        int min2 = Math.min(i11, min - i14);
                        if (min2 == i11) {
                            ThreefishEngine.i(jArr[i13], bArr3, i14 + i10);
                            ubi = ubi2;
                            bArr2 = bArr4;
                            i2 = i6;
                        } else {
                            ubi = ubi2;
                            bArr2 = bArr4;
                            i2 = i6;
                            ThreefishEngine.i(jArr[i13], bArr2, 0);
                            System.arraycopy(bArr2, 0, bArr3, i14 + i10, min2);
                        }
                        i13++;
                        bArr4 = bArr2;
                        i6 = i2;
                        ubi2 = ubi;
                        i11 = 8;
                    }
                    UBI ubi3 = ubi2;
                    int i15 = i6;
                    i8++;
                    i4 = 0;
                }
                long[] jArr2 = this.f5865b;
                long[] jArr3 = this.f5863a;
                System.arraycopy(jArr2, 0, jArr3, 0, jArr3.length);
                i(48);
                return i3;
            }
            throw new OutputLengthException("Output buffer is too short to hold output");
        }
        throw new IllegalArgumentException("Skein engine is not initialised.");
    }

    public final void d(SkeinParameters skeinParameters) {
        this.f5863a = null;
        this.f5862a = null;
        this.f5864a = null;
        this.f5866b = null;
        int i = 0;
        if (skeinParameters != null) {
            Hashtable hashtable = skeinParameters.a;
            if (((byte[]) hashtable.get(0)).length >= 16) {
                Enumeration keys = hashtable.keys();
                Vector vector = new Vector();
                Vector vector2 = new Vector();
                while (keys.hasMoreElements()) {
                    Integer num = (Integer) keys.nextElement();
                    byte[] bArr = (byte[]) hashtable.get(num);
                    if (num.intValue() == 0) {
                        this.f5862a = bArr;
                    } else if (num.intValue() < 48) {
                        vector.addElement(new Parameter(num.intValue(), bArr));
                    } else {
                        vector2.addElement(new Parameter(num.intValue(), bArr));
                    }
                }
                Parameter[] parameterArr = new Parameter[vector.size()];
                this.f5864a = parameterArr;
                vector.copyInto(parameterArr);
                g(this.f5864a);
                Parameter[] parameterArr2 = new Parameter[vector2.size()];
                this.f5866b = parameterArr2;
                vector2.copyInto(parameterArr2);
                g(this.f5866b);
            } else {
                throw new IllegalArgumentException("Skein key must be at least 128 bits.");
            }
        }
        Hashtable hashtable2 = a;
        ThreefishEngine threefishEngine = this.f5861a;
        int i2 = threefishEngine.f6057a;
        int i3 = this.f5859a;
        long[] jArr = (long[]) hashtable2.get(new Integer(i2 | (i3 << 16)));
        byte[] bArr2 = this.f5862a;
        if (bArr2 != null || jArr == null) {
            this.f5863a = new long[(threefishEngine.f6057a / 8)];
            if (bArr2 != null) {
                h(0, bArr2);
            }
            h(4, new Configuration((long) (i3 * 8)).a);
        } else {
            this.f5863a = Arrays.e(jArr);
        }
        if (this.f5864a != null) {
            while (true) {
                Parameter[] parameterArr3 = this.f5864a;
                if (i >= parameterArr3.length) {
                    break;
                }
                Parameter parameter = parameterArr3[i];
                h(parameter.a, parameter.f5867a);
                i++;
            }
        }
        this.f5865b = Arrays.e(this.f5863a);
        i(48);
    }

    public final void e(Memoable memoable) {
        SkeinEngine skeinEngine = (SkeinEngine) memoable;
        if (this.f5861a.f6057a == skeinEngine.f5861a.f6057a && this.f5859a == skeinEngine.f5859a) {
            b(skeinEngine);
            return;
        }
        throw new IllegalArgumentException("Incompatible parameters in provided SkeinEngine.");
    }

    public final void h(int i, byte[] bArr) {
        i(i);
        int length = bArr.length;
        long[] jArr = this.f5863a;
        UBI ubi = this.f5860a;
        ubi.c(bArr, 0, length, jArr);
        ubi.a(this.f5863a);
    }

    public final void i(int i) {
        UBI ubi = this.f5860a;
        UbiTweak ubiTweak = ubi.f5868a;
        long[] jArr = ubiTweak.f5872a;
        jArr[0] = 0;
        jArr[1] = 0;
        ubiTweak.a = false;
        jArr[1] = 4611686018427387904L;
        jArr[1] = (Longs.MAX_POWER_OF_TWO & -274877906944L) | ((((long) i) & 63) << 56);
        ubi.a = 0;
    }

    public final void j(byte[] bArr, int i, int i2) {
        UBI ubi = this.f5860a;
        if (ubi != null) {
            ubi.c(bArr, i, i2, this.f5863a);
            return;
        }
        throw new IllegalArgumentException("Skein engine is not initialised.");
    }

    public SkeinEngine(int i, int i2) {
        this.b = new byte[1];
        if (i2 % 8 == 0) {
            this.f5859a = i2 / 8;
            ThreefishEngine threefishEngine = new ThreefishEngine(i);
            this.f5861a = threefishEngine;
            this.f5860a = new UBI(threefishEngine.f6057a);
            return;
        }
        throw new IllegalArgumentException(lf.h("Output size must be a multiple of 8 bits. :", i2));
    }
}
