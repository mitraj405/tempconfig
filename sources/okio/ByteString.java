package okio;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class ByteString implements Serializable, Comparable<ByteString> {
    public static final ByteString a = t(new byte[0]);

    /* renamed from: a  reason: collision with other field name */
    public static final char[] f5629a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final long serialVersionUID = 1;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f5630a;
    public transient int c;

    /* renamed from: c  reason: collision with other field name */
    public transient String f5631c;

    public ByteString(byte[] bArr) {
        this.f5630a = bArr;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00a2, code lost:
        r6 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
        r5 = r0 - 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static okio.ByteString f(java.lang.String r15) {
        /*
            if (r15 == 0) goto L_0x00d6
            int r0 = r15.length()
        L_0x0006:
            r1 = 9
            r2 = 32
            r3 = 13
            r4 = 10
            if (r0 <= 0) goto L_0x0025
            int r5 = r0 + -1
            char r6 = r15.charAt(r5)
            r7 = 61
            if (r6 == r7) goto L_0x0023
            if (r6 == r4) goto L_0x0023
            if (r6 == r3) goto L_0x0023
            if (r6 == r2) goto L_0x0023
            if (r6 == r1) goto L_0x0023
            goto L_0x0025
        L_0x0023:
            r0 = r5
            goto L_0x0006
        L_0x0025:
            long r5 = (long) r0
            r7 = 6
            long r5 = r5 * r7
            r7 = 8
            long r5 = r5 / r7
            int r5 = (int) r5
            byte[] r6 = new byte[r5]
            r7 = 0
            r8 = r7
            r9 = r8
            r10 = r9
            r11 = r10
        L_0x0034:
            r12 = 0
            if (r8 >= r0) goto L_0x009d
            char r13 = r15.charAt(r8)
            r14 = 65
            if (r13 < r14) goto L_0x0046
            r14 = 90
            if (r13 > r14) goto L_0x0046
            int r13 = r13 + -65
            goto L_0x007c
        L_0x0046:
            r14 = 97
            if (r13 < r14) goto L_0x0051
            r14 = 122(0x7a, float:1.71E-43)
            if (r13 > r14) goto L_0x0051
            int r13 = r13 + -71
            goto L_0x007c
        L_0x0051:
            r14 = 48
            if (r13 < r14) goto L_0x005c
            r14 = 57
            if (r13 > r14) goto L_0x005c
            int r13 = r13 + 4
            goto L_0x007c
        L_0x005c:
            r14 = 43
            if (r13 == r14) goto L_0x007a
            r14 = 45
            if (r13 != r14) goto L_0x0065
            goto L_0x007a
        L_0x0065:
            r14 = 47
            if (r13 == r14) goto L_0x0077
            r14 = 95
            if (r13 != r14) goto L_0x006e
            goto L_0x0077
        L_0x006e:
            if (r13 == r4) goto L_0x009a
            if (r13 == r3) goto L_0x009a
            if (r13 == r2) goto L_0x009a
            if (r13 != r1) goto L_0x00a2
            goto L_0x009a
        L_0x0077:
            r13 = 63
            goto L_0x007c
        L_0x007a:
            r13 = 62
        L_0x007c:
            int r10 = r10 << 6
            byte r12 = (byte) r13
            r10 = r10 | r12
            int r9 = r9 + 1
            int r12 = r9 % 4
            if (r12 != 0) goto L_0x009a
            int r12 = r11 + 1
            int r13 = r10 >> 16
            byte r13 = (byte) r13
            r6[r11] = r13
            int r11 = r12 + 1
            int r13 = r10 >> 8
            byte r13 = (byte) r13
            r6[r12] = r13
            int r12 = r11 + 1
            byte r13 = (byte) r10
            r6[r11] = r13
            r11 = r12
        L_0x009a:
            int r8 = r8 + 1
            goto L_0x0034
        L_0x009d:
            int r9 = r9 % 4
            r15 = 1
            if (r9 != r15) goto L_0x00a4
        L_0x00a2:
            r6 = r12
            goto L_0x00ce
        L_0x00a4:
            r15 = 2
            if (r9 != r15) goto L_0x00b2
            int r15 = r10 << 12
            int r0 = r11 + 1
            int r15 = r15 >> 16
            byte r15 = (byte) r15
            r6[r11] = r15
            r11 = r0
            goto L_0x00c5
        L_0x00b2:
            r15 = 3
            if (r9 != r15) goto L_0x00c5
            int r15 = r10 << 6
            int r0 = r11 + 1
            int r1 = r15 >> 16
            byte r1 = (byte) r1
            r6[r11] = r1
            int r11 = r0 + 1
            int r15 = r15 >> 8
            byte r15 = (byte) r15
            r6[r0] = r15
        L_0x00c5:
            if (r11 != r5) goto L_0x00c8
            goto L_0x00ce
        L_0x00c8:
            byte[] r15 = new byte[r11]
            java.lang.System.arraycopy(r6, r7, r15, r7, r11)
            r6 = r15
        L_0x00ce:
            if (r6 == 0) goto L_0x00d5
            okio.ByteString r12 = new okio.ByteString
            r12.<init>(r6)
        L_0x00d5:
            return r12
        L_0x00d6:
            java.lang.IllegalArgumentException r15 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "base64 == null"
            r15.<init>(r0)
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.ByteString.f(java.lang.String):okio.ByteString");
    }

    public static ByteString i(String str) {
        if (str.length() % 2 == 0) {
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i = 0; i < length; i++) {
                int i2 = i * 2;
                bArr[i] = (byte) (j(str.charAt(i2 + 1)) + (j(str.charAt(i2)) << 4));
            }
            return t(bArr);
        }
        throw new IllegalArgumentException("Unexpected hex string: ".concat(str));
    }

    public static int j(char c2) {
        if (c2 >= '0' && c2 <= '9') {
            return c2 - '0';
        }
        char c3 = 'a';
        if (c2 < 'a' || c2 > 'f') {
            c3 = 'A';
            if (c2 < 'A' || c2 > 'F') {
                throw new IllegalArgumentException("Unexpected hex digit: " + c2);
            }
        }
        return (c2 - c3) + 10;
    }

    public static ByteString m(String str) {
        if (str != null) {
            ByteString byteString = new ByteString(str.getBytes(C0663RB.a));
            byteString.f5631c = str;
            return byteString;
        }
        throw new IllegalArgumentException("s == null");
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        int readInt = objectInputStream.readInt();
        if (readInt >= 0) {
            byte[] bArr = new byte[readInt];
            int i = 0;
            while (i < readInt) {
                int read = objectInputStream.read(bArr, i, readInt - i);
                if (read != -1) {
                    i += read;
                } else {
                    throw new EOFException();
                }
            }
            ByteString byteString = new ByteString(bArr);
            try {
                Field declaredField = ByteString.class.getDeclaredField("a");
                declaredField.setAccessible(true);
                declaredField.set(this, byteString.f5630a);
            } catch (NoSuchFieldException unused) {
                throw new AssertionError();
            } catch (IllegalAccessException unused2) {
                throw new AssertionError();
            }
        } else {
            throw new IllegalArgumentException(lf.h("byteCount < 0: ", readInt));
        }
    }

    public static ByteString t(byte... bArr) {
        if (bArr != null) {
            return new ByteString((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.f5630a.length);
        objectOutputStream.write(this.f5630a);
    }

    public int A() {
        return this.f5630a.length;
    }

    public ByteString B() {
        byte[] bArr = this.f5630a;
        if (64 > bArr.length) {
            throw new IllegalArgumentException(lf.k(new StringBuilder("endIndex > length("), this.f5630a.length, ")"));
        } else if (64 == bArr.length) {
            return this;
        } else {
            byte[] bArr2 = new byte[64];
            System.arraycopy(bArr, 0, bArr2, 0, 64);
            return new ByteString(bArr2);
        }
    }

    public ByteString C() {
        int i = 0;
        while (true) {
            byte[] bArr = this.f5630a;
            if (i >= bArr.length) {
                return this;
            }
            byte b = bArr[i];
            if (b < 65 || b > 90) {
                i++;
            } else {
                byte[] bArr2 = (byte[]) bArr.clone();
                bArr2[i] = (byte) (b + 32);
                for (int i2 = i + 1; i2 < bArr2.length; i2++) {
                    byte b2 = bArr2[i2];
                    if (b2 >= 65 && b2 <= 90) {
                        bArr2[i2] = (byte) (b2 + 32);
                    }
                }
                return new ByteString(bArr2);
            }
        }
    }

    public byte[] D() {
        return (byte[]) this.f5630a.clone();
    }

    public String E() {
        String str = this.f5631c;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.f5630a, C0663RB.a);
        this.f5631c = str2;
        return str2;
    }

    public void F(Buffer buffer) {
        byte[] bArr = this.f5630a;
        buffer.y(0, bArr, bArr.length);
    }

    public String a() {
        byte[] bArr = this.f5630a;
        byte[] bArr2 = C1354qp.f6917a;
        byte[] bArr3 = new byte[(((bArr.length + 2) / 3) * 4)];
        int length = bArr.length - (bArr.length % 3);
        int i = 0;
        for (int i2 = 0; i2 < length; i2 += 3) {
            int i3 = i + 1;
            bArr3[i] = bArr2[(bArr[i2] & UnsignedBytes.MAX_VALUE) >> 2];
            int i4 = i3 + 1;
            int i5 = i2 + 1;
            bArr3[i3] = bArr2[((bArr[i2] & 3) << 4) | ((bArr[i5] & UnsignedBytes.MAX_VALUE) >> 4)];
            int i6 = i4 + 1;
            int i7 = i2 + 2;
            bArr3[i4] = bArr2[((bArr[i5] & Ascii.SI) << 2) | ((bArr[i7] & UnsignedBytes.MAX_VALUE) >> 6)];
            i = i6 + 1;
            bArr3[i6] = bArr2[bArr[i7] & 63];
        }
        int length2 = bArr.length % 3;
        if (length2 == 1) {
            int i8 = i + 1;
            bArr3[i] = bArr2[(bArr[length] & UnsignedBytes.MAX_VALUE) >> 2];
            int i9 = i8 + 1;
            bArr3[i8] = bArr2[(bArr[length] & 3) << 4];
            bArr3[i9] = 61;
            bArr3[i9 + 1] = 61;
        } else if (length2 == 2) {
            int i10 = i + 1;
            bArr3[i] = bArr2[(bArr[length] & UnsignedBytes.MAX_VALUE) >> 2];
            int i11 = i10 + 1;
            int i12 = length + 1;
            bArr3[i10] = bArr2[((bArr[i12] & UnsignedBytes.MAX_VALUE) >> 4) | ((bArr[length] & 3) << 4)];
            bArr3[i11] = bArr2[(bArr[i12] & Ascii.SI) << 2];
            bArr3[i11 + 1] = 61;
        }
        try {
            return new String(bArr3, "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002e, code lost:
        if (r0 < r1) goto L_0x0027;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        return 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0025, code lost:
        if (r7 < r8) goto L_0x0027;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int compareTo(java.lang.Object r10) {
        /*
            r9 = this;
            okio.ByteString r10 = (okio.ByteString) r10
            int r0 = r9.A()
            int r1 = r10.A()
            int r2 = java.lang.Math.min(r0, r1)
            r3 = 0
            r4 = r3
        L_0x0010:
            r5 = 1
            r6 = -1
            if (r4 >= r2) goto L_0x002b
            byte r7 = r9.n(r4)
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r8 = r10.n(r4)
            r8 = r8 & 255(0xff, float:3.57E-43)
            if (r7 != r8) goto L_0x0025
            int r4 = r4 + 1
            goto L_0x0010
        L_0x0025:
            if (r7 >= r8) goto L_0x0029
        L_0x0027:
            r3 = r6
            goto L_0x0031
        L_0x0029:
            r3 = r5
            goto L_0x0031
        L_0x002b:
            if (r0 != r1) goto L_0x002e
            goto L_0x0031
        L_0x002e:
            if (r0 >= r1) goto L_0x0029
            goto L_0x0027
        L_0x0031:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.ByteString.compareTo(java.lang.Object):int");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            int A = byteString.A();
            byte[] bArr = this.f5630a;
            if (A == bArr.length && byteString.x(0, 0, bArr, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = this.c;
        if (i != 0) {
            return i;
        }
        int hashCode = Arrays.hashCode(this.f5630a);
        this.c = hashCode;
        return hashCode;
    }

    public final ByteString l(String str) {
        try {
            return t(MessageDigest.getInstance(str).digest(this.f5630a));
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    public byte n(int i) {
        return this.f5630a[i];
    }

    public String o() {
        byte[] bArr = this.f5630a;
        char[] cArr = new char[(bArr.length * 2)];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = f5629a;
            cArr[i] = cArr2[(b >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = cArr2[b & Ascii.SI];
        }
        return new String(cArr);
    }

    public byte[] p() {
        return this.f5630a;
    }

    public String toString() {
        if (this.f5630a.length == 0) {
            return "[size=0]";
        }
        String E = E();
        int length = E.length();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= length) {
                i = E.length();
                break;
            } else if (i2 == 64) {
                break;
            } else {
                int codePointAt = E.codePointAt(i);
                if ((!Character.isISOControl(codePointAt) || codePointAt == 10 || codePointAt == 13) && codePointAt != 65533) {
                    i2++;
                    i += Character.charCount(codePointAt);
                }
            }
        }
        i = -1;
        if (i != -1) {
            String replace = E.substring(0, i).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
            if (i >= E.length()) {
                return lf.j("[text=", replace, "]");
            }
            return "[size=" + this.f5630a.length + " text=" + replace + "…]";
        } else if (this.f5630a.length <= 64) {
            return "[hex=" + o() + "]";
        } else {
            return "[size=" + this.f5630a.length + " hex=" + B().o() + "…]";
        }
    }

    public boolean x(int i, int i2, byte[] bArr, int i3) {
        boolean z;
        if (i < 0) {
            return false;
        }
        byte[] bArr2 = this.f5630a;
        if (i > bArr2.length - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        Charset charset = C0663RB.a;
        int i4 = 0;
        while (true) {
            if (i4 >= i3) {
                z = true;
                break;
            } else if (bArr2[i4 + i] != bArr[i4 + i2]) {
                z = false;
                break;
            } else {
                i4++;
            }
        }
        if (z) {
            return true;
        }
        return false;
    }

    public boolean z(ByteString byteString, int i) {
        return byteString.x(0, 0, this.f5630a, i);
    }
}
