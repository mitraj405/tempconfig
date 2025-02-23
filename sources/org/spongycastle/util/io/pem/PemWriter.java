package org.spongycastle.util.io.pem;

import com.google.common.primitives.UnsignedBytes;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;
import org.spongycastle.util.Strings;
import org.spongycastle.util.encoders.Base64;
import org.spongycastle.util.encoders.Base64Encoder;
import org.spongycastle.util.encoders.EncoderException;

public class PemWriter extends BufferedWriter {
    public final char[] a = new char[64];

    public PemWriter(OutputStreamWriter outputStreamWriter) {
        super(outputStreamWriter);
        String str = Strings.a;
    }

    public final void a(PemObject pemObject) throws IOException {
        int i;
        byte[] bArr;
        char[] cArr;
        int i2;
        StringBuilder sb = new StringBuilder("-----BEGIN ");
        String str = pemObject.a;
        sb.append(str);
        sb.append("-----");
        write(sb.toString());
        newLine();
        List<PemHeader> list = pemObject.f6859a;
        if (!list.isEmpty()) {
            for (PemHeader pemHeader : list) {
                pemHeader.getClass();
                write((String) null);
                write(": ");
                write((String) null);
                newLine();
            }
            newLine();
        }
        Base64Encoder base64Encoder = Base64.a;
        byte[] bArr2 = pemObject.f6860a;
        int length = bArr2.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(((length + 2) / 3) * 4);
        try {
            Base64Encoder base64Encoder2 = Base64.a;
            base64Encoder2.getClass();
            int i3 = length % 3;
            int i4 = length - i3;
            int i5 = 0;
            while (true) {
                i = 0 + i4;
                bArr = base64Encoder2.f6858a;
                if (i5 >= i) {
                    break;
                }
                byte b = bArr2[i5] & UnsignedBytes.MAX_VALUE;
                byte b2 = bArr2[i5 + 1] & UnsignedBytes.MAX_VALUE;
                byte b3 = bArr2[i5 + 2] & UnsignedBytes.MAX_VALUE;
                byteArrayOutputStream.write(bArr[(b >>> 2) & 63]);
                byteArrayOutputStream.write(bArr[((b << 4) | (b2 >>> 4)) & 63]);
                byteArrayOutputStream.write(bArr[((b2 << 2) | (b3 >>> 6)) & 63]);
                byteArrayOutputStream.write(bArr[b3 & 63]);
                i5 += 3;
            }
            if (i3 == 1) {
                byte b4 = bArr2[i] & UnsignedBytes.MAX_VALUE;
                byteArrayOutputStream.write(bArr[(b4 >>> 2) & 63]);
                byteArrayOutputStream.write(bArr[(b4 << 4) & 63]);
                byteArrayOutputStream.write(base64Encoder2.a);
                byteArrayOutputStream.write(base64Encoder2.a);
            } else if (i3 == 2) {
                byte b5 = bArr2[i] & UnsignedBytes.MAX_VALUE;
                byte b6 = bArr2[i + 1] & UnsignedBytes.MAX_VALUE;
                byteArrayOutputStream.write(bArr[(b5 >>> 2) & 63]);
                byteArrayOutputStream.write(bArr[((b5 << 4) | (b6 >>> 4)) & 63]);
                byteArrayOutputStream.write(bArr[(b6 << 2) & 63]);
                byteArrayOutputStream.write(base64Encoder2.a);
            }
            int i6 = i4 / 3;
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            int i7 = 0;
            while (i7 < byteArray.length) {
                int i8 = 0;
                while (true) {
                    cArr = this.a;
                    if (i8 == cArr.length || (i2 = i7 + i8) >= byteArray.length) {
                        write(cArr, 0, i8);
                        newLine();
                        i7 += cArr.length;
                    } else {
                        cArr[i8] = (char) byteArray[i2];
                        i8++;
                    }
                }
                write(cArr, 0, i8);
                newLine();
                i7 += cArr.length;
            }
            write("-----END " + str + "-----");
            newLine();
        } catch (Exception e) {
            throw new EncoderException(C1058d.M(e, new StringBuilder("exception encoding base64 string: ")), e);
        }
    }
}
