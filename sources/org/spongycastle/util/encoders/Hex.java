package org.spongycastle.util.encoders;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Hex {
    public static final HexEncoder a = new HexEncoder();

    public static byte[] a(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            HexEncoder hexEncoder = a;
            hexEncoder.getClass();
            int length = str.length();
            while (true) {
                if (length <= 0) {
                    break;
                }
                int i = length - 1;
                if (!HexEncoder.a(str.charAt(i))) {
                    break;
                }
                length = i;
            }
            int i2 = 0;
            while (i2 < length) {
                while (i2 < length && HexEncoder.a(str.charAt(i2))) {
                    i2++;
                }
                int i3 = i2 + 1;
                char charAt = str.charAt(i2);
                byte[] bArr = hexEncoder.b;
                byte b = bArr[charAt];
                while (i3 < length && HexEncoder.a(str.charAt(i3))) {
                    i3++;
                }
                int i4 = i3 + 1;
                byte b2 = bArr[str.charAt(i3)];
                if ((b | b2) >= 0) {
                    byteArrayOutputStream.write((b << 4) | b2);
                    i2 = i4;
                } else {
                    throw new IOException("invalid characters encountered in Hex string");
                }
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            throw new DecoderException(C1058d.M(e, new StringBuilder("exception decoding Hex string: ")), e);
        }
    }

    public static byte[] b(int i, byte[] bArr, int i2) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            HexEncoder hexEncoder = a;
            hexEncoder.getClass();
            for (int i3 = i; i3 < i + i2; i3++) {
                byte b = bArr[i3] & UnsignedBytes.MAX_VALUE;
                byte[] bArr2 = hexEncoder.a;
                byteArrayOutputStream.write(bArr2[b >>> 4]);
                byteArrayOutputStream.write(bArr2[b & Ascii.SI]);
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            throw new EncoderException(C1058d.M(e, new StringBuilder("exception encoding Hex string: ")), e);
        }
    }

    public static byte[] c(byte[] bArr) {
        return b(0, bArr, bArr.length);
    }
}
