package in.juspay.hypersdk.security;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.util.Arrays;

public class Base64Codec {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    public static int computeEncodedLength(int i, boolean z) {
        if (i == 0) {
            return 0;
        }
        if (!z) {
            return (((i - 1) / 3) + 1) << 2;
        }
        int i2 = (i / 3) << 2;
        int i3 = i % 3;
        if (i3 == 0) {
            return i2;
        }
        return i2 + i3 + 1;
    }

    public static byte[] decode(String str) {
        if (str == null || str.isEmpty()) {
            return new byte[0];
        }
        byte[] bytes = str.getBytes("UTF-8");
        int length = bytes.length;
        byte[] bArr = new byte[((length * 6) >> 3)];
        int i = 0;
        int i2 = 0;
        while (i < bytes.length) {
            int i3 = 0;
            int i4 = 0;
            while (i3 < 4 && i < length) {
                int i5 = i + 1;
                int decodeDigit = decodeDigit(bytes[i]);
                if (decodeDigit >= 0) {
                    i4 |= decodeDigit << (18 - (i3 * 6));
                    i3++;
                }
                i = i5;
            }
            if (i3 >= 2) {
                int i6 = i2 + 1;
                bArr[i2] = (byte) (i4 >> 16);
                if (i3 >= 3) {
                    i2 = i6 + 1;
                    bArr[i6] = (byte) (i4 >> 8);
                    if (i3 >= 4) {
                        bArr[i2] = (byte) i4;
                        i2++;
                    }
                } else {
                    i2 = i6;
                }
            }
        }
        return Arrays.copyOf(bArr, i2);
    }

    public static int decodeDigit(byte b) {
        int tpGT = tpGT(b, 64) & tpLT(b, 91);
        int tpGT2 = tpGT(b, 96) & tpLT(b, 123);
        int tpGT3 = tpGT(b, 47) & tpLT(b, 58);
        int tpEq = tpEq(b, 45) | tpEq(b, 43);
        int tpEq2 = tpEq(b, 47) | tpEq(b, 95);
        return tpSelect(tpGT3, (b - 48) + 52, 0) | tpSelect(tpGT, (b - 65) + 0, 0) | tpSelect(tpGT2, (b - 97) + 26, 0) | tpSelect(tpEq, 62, 0) | tpSelect(tpEq2, 63, 0) | tpSelect(tpGT | tpGT2 | tpGT3 | tpEq | tpEq2, 0, -1);
    }

    public static byte encodeDigitBase64(int i) {
        int tpLT = tpLT(i, 26);
        int tpGT = tpGT(i, 25) & tpLT(i, 52);
        int tpGT2 = tpGT(i, 51) & tpLT(i, 62);
        int tpEq = tpEq(i, 62);
        int tpEq2 = tpEq(i, 63);
        return (byte) (tpSelect(tpGT2, (i - 52) + 48, 0) | tpSelect(tpLT, i + 0 + 65, 0) | tpSelect(tpGT, (i - 26) + 97, 0) | tpSelect(tpEq, 43, 0) | tpSelect(tpEq2, 47, 0));
    }

    public static byte encodeDigitBase64URL(int i) {
        int tpLT = tpLT(i, 26);
        int tpGT = tpGT(i, 25) & tpLT(i, 52);
        int tpGT2 = tpGT(i, 51) & tpLT(i, 62);
        int tpEq = tpEq(i, 62);
        int tpEq2 = tpEq(i, 63);
        return (byte) (tpSelect(tpGT2, (i - 52) + 48, 0) | tpSelect(tpLT, i + 0 + 65, 0) | tpSelect(tpGT, (i - 26) + 97, 0) | tpSelect(tpEq, 45, 0) | tpSelect(tpEq2, 95, 0));
    }

    public static String encodeToString(byte[] bArr, boolean z) {
        int i;
        byte b;
        int i2 = 0;
        if (bArr != null) {
            i = bArr.length;
        } else {
            i = 0;
        }
        if (i == 0) {
            return "";
        }
        int i3 = (i / 3) * 3;
        int computeEncodedLength = computeEncodedLength(i, z);
        byte[] bArr2 = new byte[computeEncodedLength];
        int i4 = 0;
        int i5 = 0;
        while (i4 < i3) {
            int i6 = i4 + 1;
            int i7 = i6 + 1;
            byte b2 = ((bArr[i4] & UnsignedBytes.MAX_VALUE) << Ascii.DLE) | ((bArr[i6] & UnsignedBytes.MAX_VALUE) << 8);
            int i8 = i7 + 1;
            byte b3 = b2 | (bArr[i7] & UnsignedBytes.MAX_VALUE);
            int i9 = i5 + 1;
            int i10 = (b3 >>> Ascii.DC2) & 63;
            if (z) {
                bArr2[i5] = encodeDigitBase64URL(i10);
                int i11 = i9 + 1;
                bArr2[i9] = encodeDigitBase64URL((b3 >>> Ascii.FF) & 63);
                int i12 = i11 + 1;
                bArr2[i11] = encodeDigitBase64URL((b3 >>> 6) & 63);
                i5 = i12 + 1;
                bArr2[i12] = encodeDigitBase64URL(b3 & 63);
            } else {
                bArr2[i5] = encodeDigitBase64(i10);
                int i13 = i9 + 1;
                bArr2[i9] = encodeDigitBase64((b3 >>> Ascii.FF) & 63);
                int i14 = i13 + 1;
                bArr2[i13] = encodeDigitBase64((b3 >>> 6) & 63);
                i5 = i14 + 1;
                bArr2[i14] = encodeDigitBase64(b3 & 63);
            }
            i4 = i8;
        }
        int i15 = i - i3;
        if (i15 > 0) {
            int i16 = (bArr[i3] & UnsignedBytes.MAX_VALUE) << 10;
            if (i15 == 2) {
                i2 = (bArr[i - 1] & UnsignedBytes.MAX_VALUE) << 2;
            }
            int i17 = i16 | i2;
            if (!z) {
                bArr2[computeEncodedLength - 4] = encodeDigitBase64(i17 >> 12);
                bArr2[computeEncodedLength - 3] = encodeDigitBase64((i17 >>> 6) & 63);
                int i18 = computeEncodedLength - 2;
                if (i15 == 2) {
                    b = encodeDigitBase64(i17 & 63);
                } else {
                    b = 61;
                }
                bArr2[i18] = b;
                bArr2[computeEncodedLength - 1] = 61;
            } else if (i15 == 2) {
                bArr2[computeEncodedLength - 3] = encodeDigitBase64URL(i17 >> 12);
                bArr2[computeEncodedLength - 2] = encodeDigitBase64URL((i17 >>> 6) & 63);
                bArr2[computeEncodedLength - 1] = encodeDigitBase64URL(i17 & 63);
            } else {
                bArr2[computeEncodedLength - 2] = encodeDigitBase64URL(i17 >> 12);
                bArr2[computeEncodedLength - 1] = encodeDigitBase64URL((i17 >>> 6) & 63);
            }
        }
        return new String(bArr2, "UTF-8");
    }

    public static int tpEq(int i, int i2) {
        int i3 = i ^ i2;
        return ((~i3) & (i3 - 1)) >>> 63;
    }

    public static int tpGT(int i, int i2) {
        return (int) ((((long) i2) - ((long) i)) >>> 63);
    }

    public static int tpLT(int i, int i2) {
        return (int) ((((long) i) - ((long) i2)) >>> 63);
    }

    public static int tpSelect(int i, int i2, int i3) {
        return ((i - 1) & (i3 ^ i2)) ^ i2;
    }
}
