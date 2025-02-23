package org.spongycastle.util;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Vector;

public final class Strings {
    public static final String a;

    static {
        try {
            a = (String) AccessController.doPrivileged(new PrivilegedAction<String>() {
                public final Object run() {
                    return System.getProperty("line.separator");
                }
            });
        } catch (Exception unused) {
            try {
                a = String.format("%n", new Object[0]);
            } catch (Exception unused2) {
                a = "\n";
            }
        }
    }

    public static String a(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[length];
        for (int i = 0; i != length; i++) {
            cArr[i] = (char) (bArr[i] & UnsignedBytes.MAX_VALUE);
        }
        return new String(cArr);
    }

    public static String b(byte[] bArr) {
        char c;
        int i;
        byte b;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < bArr.length) {
            i4++;
            byte b2 = bArr[i3];
            if ((b2 & 240) == 240) {
                i4++;
                i3 += 4;
            } else if ((b2 & 224) == 224) {
                i3 += 3;
            } else if ((b2 & 192) == 192) {
                i3 += 2;
            } else {
                i3++;
            }
        }
        char[] cArr = new char[i4];
        int i5 = 0;
        while (i2 < bArr.length) {
            byte b3 = bArr[i2];
            if ((b3 & 240) == 240) {
                int i6 = (((((b3 & 3) << Ascii.DC2) | ((bArr[i2 + 1] & 63) << Ascii.FF)) | ((bArr[i2 + 2] & 63) << 6)) | (bArr[i2 + 3] & 63)) - Ascii.NUL;
                c = (char) ((i6 & 1023) | 56320);
                cArr[i5] = (char) ((i6 >> 10) | 55296);
                i2 += 4;
                i5++;
            } else if ((b3 & 224) == 224) {
                c = (char) (((b3 & Ascii.SI) << Ascii.FF) | ((bArr[i2 + 1] & 63) << 6) | (bArr[i2 + 2] & 63));
                i2 += 3;
            } else {
                if ((b3 & 208) == 208) {
                    i = (b3 & Ascii.US) << 6;
                    b = bArr[i2 + 1];
                } else if ((b3 & 192) == 192) {
                    i = (b3 & Ascii.US) << 6;
                    b = bArr[i2 + 1];
                } else {
                    c = (char) (b3 & UnsignedBytes.MAX_VALUE);
                    i2++;
                }
                c = (char) (i | (b & 63));
                i2 += 2;
            }
            cArr[i5] = c;
            i5++;
        }
        return new String(cArr);
    }

    public static String[] c(String str) {
        int i;
        Vector vector = new Vector();
        boolean z = true;
        while (true) {
            if (!z) {
                break;
            }
            int indexOf = str.indexOf(46);
            if (indexOf > 0) {
                vector.addElement(str.substring(0, indexOf));
                str = str.substring(indexOf + 1);
            } else {
                vector.addElement(str);
                z = false;
            }
        }
        int size = vector.size();
        String[] strArr = new String[size];
        for (i = 0; i != size; i++) {
            strArr[i] = (String) vector.elementAt(i);
        }
        return strArr;
    }

    public static byte[] d(String str) {
        int length = str.length();
        byte[] bArr = new byte[length];
        for (int i = 0; i != length; i++) {
            bArr[i] = (byte) str.charAt(i);
        }
        return bArr;
    }

    public static String e(String str) {
        char[] charArray = str.toCharArray();
        boolean z = false;
        for (int i = 0; i != charArray.length; i++) {
            char c = charArray[i];
            if ('A' <= c && 'Z' >= c) {
                charArray[i] = (char) ((c - 'A') + 97);
                z = true;
            }
        }
        if (z) {
            return new String(charArray);
        }
        return str;
    }

    public static void f(ByteArrayOutputStream byteArrayOutputStream, char[] cArr) throws IOException {
        int i = 0;
        while (i < cArr.length) {
            char c = cArr[i];
            if (c < 128) {
                byteArrayOutputStream.write(c);
            } else if (c < 2048) {
                byteArrayOutputStream.write((c >> 6) | 192);
                byteArrayOutputStream.write((c & '?') | 128);
            } else if (c < 55296 || c > 57343) {
                byteArrayOutputStream.write((c >> 12) | 224);
                byteArrayOutputStream.write(((c >> 6) & 63) | 128);
                byteArrayOutputStream.write((c & '?') | 128);
            } else {
                i++;
                if (i < cArr.length) {
                    char c2 = cArr[i];
                    if (c <= 56319) {
                        int i2 = (((c & 1023) << 10) | (c2 & 1023)) + Ascii.MIN;
                        byteArrayOutputStream.write((i2 >> 18) | 240);
                        byteArrayOutputStream.write(((i2 >> 12) & 63) | 128);
                        byteArrayOutputStream.write(((i2 >> 6) & 63) | 128);
                        byteArrayOutputStream.write((i2 & 63) | 128);
                    } else {
                        throw new IllegalStateException("invalid UTF-16 codepoint");
                    }
                } else {
                    throw new IllegalStateException("invalid UTF-16 codepoint");
                }
            }
            i++;
        }
    }

    public static String g(String str) {
        char[] charArray = str.toCharArray();
        boolean z = false;
        for (int i = 0; i != charArray.length; i++) {
            char c = charArray[i];
            if ('a' <= c && 'z' >= c) {
                charArray[i] = (char) ((c - 'a') + 65);
                z = true;
            }
        }
        if (z) {
            return new String(charArray);
        }
        return str;
    }

    public static class StringListImpl extends ArrayList<String> implements StringList {
        private StringListImpl() {
        }

        public final void add(int i, Object obj) {
            super.add(i, (String) obj);
        }

        public final Object set(int i, Object obj) {
            return (String) super.set(i, (String) obj);
        }

        public final boolean add(Object obj) {
            return super.add((String) obj);
        }
    }
}
