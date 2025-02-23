package defpackage;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;

/* renamed from: mx  reason: default package and case insensitive filesystem */
/* compiled from: SntpClient */
public final class C1267mx {
    public static long a(int i, byte[] bArr) {
        byte b = bArr[i];
        byte b2 = bArr[i + 1];
        byte b3 = bArr[i + 2];
        byte b4 = bArr[i + 3];
        byte b5 = b & true;
        int i2 = b;
        if (b5 == true) {
            i2 = (b & Ascii.DEL) + UnsignedBytes.MAX_POWER_OF_TWO;
        }
        byte b6 = b2 & true;
        int i3 = b2;
        if (b6 == true) {
            i3 = (b2 & Ascii.DEL) + UnsignedBytes.MAX_POWER_OF_TWO;
        }
        byte b7 = b3 & true;
        int i4 = b3;
        if (b7 == true) {
            i4 = (b3 & Ascii.DEL) + UnsignedBytes.MAX_POWER_OF_TWO;
        }
        byte b8 = b4 & true;
        int i5 = b4;
        if (b8 == true) {
            i5 = (b4 & Ascii.DEL) + UnsignedBytes.MAX_POWER_OF_TWO;
        }
        return (((long) i2) << 24) + (((long) i3) << 16) + (((long) i4) << 8) + ((long) i5);
    }

    public static long b(int i, byte[] bArr) {
        long a = a(i, bArr);
        return ((a(i + 4, bArr) * 1000) / 4294967296L) + ((a - 2208988800L) * 1000);
    }
}
