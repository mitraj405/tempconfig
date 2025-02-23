package org.spongycastle.pqc.crypto.xmss;

import java.util.ArrayList;
import org.spongycastle.crypto.Digest;
import org.spongycastle.pqc.crypto.xmss.OTSHashAddress;

final class WOTSPlus {
    public final KeyedHashFunctions a;

    /* renamed from: a  reason: collision with other field name */
    public final WOTSPlusParameters f6760a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f6761a;
    public byte[] b;

    public WOTSPlus(WOTSPlusParameters wOTSPlusParameters) {
        this.f6760a = wOTSPlusParameters;
        Digest digest = wOTSPlusParameters.f6763a;
        int i = wOTSPlusParameters.a;
        this.a = new KeyedHashFunctions(i, digest);
        this.f6761a = new byte[i];
        this.b = new byte[i];
    }

    public static ArrayList b(int i, byte[] bArr, int i2) {
        if (i == 4 || i == 16) {
            int i3 = XMSSUtil.i(i);
            if (i2 <= (bArr.length * 8) / i3) {
                ArrayList arrayList = new ArrayList();
                for (int i4 = 0; i4 < bArr.length; i4++) {
                    for (int i5 = 8 - i3; i5 >= 0; i5 -= i3) {
                        arrayList.add(Integer.valueOf((bArr[i4] >> i5) & (i - 1)));
                        if (arrayList.size() == i2) {
                            return arrayList;
                        }
                    }
                }
                return arrayList;
            }
            throw new IllegalArgumentException("outLength too big");
        }
        throw new IllegalArgumentException("w needs to be 4 or 16");
    }

    public final byte[] a(byte[] bArr, int i, int i2, OTSHashAddress oTSHashAddress) {
        WOTSPlusParameters wOTSPlusParameters = this.f6760a;
        int i3 = wOTSPlusParameters.a;
        if (bArr == null) {
            throw new NullPointerException("startHash == null");
        } else if (bArr.length == i3) {
            oTSHashAddress.a();
            int i4 = i + i2;
            if (i4 > wOTSPlusParameters.b - 1) {
                throw new IllegalArgumentException("max chain length must not be greater than w");
            } else if (i2 == 0) {
                return bArr;
            } else {
                byte[] a2 = a(bArr, i, i2 - 1, oTSHashAddress);
                OTSHashAddress.Builder builder = (OTSHashAddress.Builder) ((OTSHashAddress.Builder) new OTSHashAddress.Builder().c(oTSHashAddress.a)).d(oTSHashAddress.f6765a);
                builder.d = oTSHashAddress.d;
                builder.e = oTSHashAddress.e;
                builder.f = i4 - 1;
                OTSHashAddress.Builder builder2 = (OTSHashAddress.Builder) builder.b(0);
                builder2.getClass();
                OTSHashAddress oTSHashAddress2 = new OTSHashAddress(builder2);
                byte[] bArr2 = this.b;
                byte[] a3 = oTSHashAddress2.a();
                KeyedHashFunctions keyedHashFunctions = this.a;
                byte[] b2 = keyedHashFunctions.b(bArr2, a3);
                OTSHashAddress.Builder builder3 = (OTSHashAddress.Builder) ((OTSHashAddress.Builder) new OTSHashAddress.Builder().c(oTSHashAddress2.a)).d(oTSHashAddress2.f6765a);
                builder3.d = oTSHashAddress2.d;
                builder3.e = oTSHashAddress2.e;
                builder3.f = oTSHashAddress2.f;
                OTSHashAddress.Builder builder4 = (OTSHashAddress.Builder) builder3.b(1);
                builder4.getClass();
                byte[] b3 = keyedHashFunctions.b(this.b, new OTSHashAddress(builder4).a());
                byte[] bArr3 = new byte[i3];
                for (int i5 = 0; i5 < i3; i5++) {
                    bArr3[i5] = (byte) (a2[i5] ^ b3[i5]);
                }
                int length = b2.length;
                int i6 = keyedHashFunctions.a;
                if (length != i6) {
                    throw new IllegalArgumentException("wrong key length");
                } else if (i3 == i6) {
                    return keyedHashFunctions.c(b2, 0, bArr3);
                } else {
                    throw new IllegalArgumentException("wrong in length");
                }
            }
        } else {
            throw new IllegalArgumentException(C1058d.y("startHash needs to be ", i3, "bytes"));
        }
    }

    public final byte[] c(int i) {
        if (i < 0 || i >= this.f6760a.c) {
            throw new IllegalArgumentException("index out of bounds");
        }
        return this.a.b(this.f6761a, XMSSUtil.j(32, (long) i));
    }

    public final WOTSPlusPublicKeyParameters d(OTSHashAddress oTSHashAddress) {
        WOTSPlusParameters wOTSPlusParameters = this.f6760a;
        byte[][] bArr = new byte[wOTSPlusParameters.c][];
        int i = 0;
        while (i < wOTSPlusParameters.c) {
            OTSHashAddress.Builder builder = (OTSHashAddress.Builder) ((OTSHashAddress.Builder) new OTSHashAddress.Builder().c(oTSHashAddress.a)).d(oTSHashAddress.f6765a);
            builder.d = oTSHashAddress.d;
            builder.e = i;
            builder.f = oTSHashAddress.f;
            OTSHashAddress.Builder builder2 = (OTSHashAddress.Builder) builder.b(oTSHashAddress.c);
            builder2.getClass();
            OTSHashAddress oTSHashAddress2 = new OTSHashAddress(builder2);
            bArr[i] = a(c(i), 0, wOTSPlusParameters.b - 1, oTSHashAddress2);
            i++;
            oTSHashAddress = oTSHashAddress2;
        }
        return new WOTSPlusPublicKeyParameters(wOTSPlusParameters, bArr);
    }

    public final byte[] e(byte[] bArr, OTSHashAddress oTSHashAddress) {
        OTSHashAddress.Builder builder = (OTSHashAddress.Builder) ((OTSHashAddress.Builder) new OTSHashAddress.Builder().c(oTSHashAddress.a)).d(oTSHashAddress.f6765a);
        builder.d = oTSHashAddress.d;
        return this.a.b(bArr, new OTSHashAddress(builder).a());
    }

    public final void f(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        int i = this.f6760a.a;
        if (length != i) {
            throw new IllegalArgumentException("size of secretKeySeed needs to be equal to size of digest");
        } else if (bArr2 == null) {
            throw new NullPointerException("publicSeed == null");
        } else if (bArr2.length == i) {
            this.f6761a = bArr;
            this.b = bArr2;
        } else {
            throw new IllegalArgumentException("size of publicSeed needs to be equal to size of digest");
        }
    }

    public final WOTSPlusSignature g(byte[] bArr, OTSHashAddress oTSHashAddress) {
        int length = bArr.length;
        WOTSPlusParameters wOTSPlusParameters = this.f6760a;
        if (length == wOTSPlusParameters.a) {
            int i = wOTSPlusParameters.b;
            int i2 = wOTSPlusParameters.d;
            ArrayList b2 = b(i, bArr, i2);
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                i3 += (i - 1) - ((Integer) b2.get(i4)).intValue();
            }
            int i5 = XMSSUtil.i(i);
            int i6 = wOTSPlusParameters.e;
            b2.addAll(b(i, XMSSUtil.j((int) Math.ceil(((double) (XMSSUtil.i(i) * i6)) / 8.0d), (long) (i3 << (8 - ((i5 * i6) % 8)))), i6));
            int i7 = wOTSPlusParameters.c;
            byte[][] bArr2 = new byte[i7][];
            int i8 = 0;
            while (i8 < i7) {
                OTSHashAddress.Builder builder = (OTSHashAddress.Builder) ((OTSHashAddress.Builder) new OTSHashAddress.Builder().c(oTSHashAddress.a)).d(oTSHashAddress.f6765a);
                builder.d = oTSHashAddress.d;
                builder.e = i8;
                builder.f = oTSHashAddress.f;
                OTSHashAddress.Builder builder2 = (OTSHashAddress.Builder) builder.b(oTSHashAddress.c);
                builder2.getClass();
                OTSHashAddress oTSHashAddress2 = new OTSHashAddress(builder2);
                bArr2[i8] = a(c(i8), 0, ((Integer) b2.get(i8)).intValue(), oTSHashAddress2);
                i8++;
                oTSHashAddress = oTSHashAddress2;
            }
            return new WOTSPlusSignature(wOTSPlusParameters, bArr2);
        }
        throw new IllegalArgumentException("size of messageDigest needs to be equal to size of digest");
    }
}
