package org.spongycastle.asn1;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.ConcurrentHashMap;
import org.spongycastle.util.Arrays;

public class ASN1ObjectIdentifier extends ASN1Primitive {
    public static final ConcurrentHashMap a = new ConcurrentHashMap();

    /* renamed from: a  reason: collision with other field name */
    public byte[] f5659a;
    public final String c;

    public static class OidHandle {
        public final int a;

        /* renamed from: a  reason: collision with other field name */
        public final byte[] f5660a;

        public OidHandle(byte[] bArr) {
            this.a = Arrays.t(bArr);
            this.f5660a = bArr;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof OidHandle)) {
                return false;
            }
            return Arrays.a(this.f5660a, ((OidHandle) obj).f5660a);
        }

        public final int hashCode() {
            return this.a;
        }
    }

    public ASN1ObjectIdentifier(byte[] bArr) {
        int i;
        byte[] bArr2 = bArr;
        StringBuffer stringBuffer = new StringBuffer();
        boolean z = true;
        BigInteger bigInteger = null;
        int i2 = 0;
        long j = 0;
        while (i2 != bArr2.length) {
            byte b = bArr2[i2] & UnsignedBytes.MAX_VALUE;
            if (j <= 72057594037927808L) {
                i = i2;
                long j2 = j + ((long) (b & Ascii.DEL));
                if ((b & UnsignedBytes.MAX_POWER_OF_TWO) == 0) {
                    if (z) {
                        if (j2 < 40) {
                            stringBuffer.append('0');
                        } else if (j2 < 80) {
                            stringBuffer.append('1');
                            j2 -= 40;
                        } else {
                            stringBuffer.append('2');
                            j2 -= 80;
                        }
                        z = false;
                    }
                    stringBuffer.append('.');
                    stringBuffer.append(j2);
                } else {
                    j = j2 << 7;
                    i2 = i + 1;
                }
            } else {
                i = i2;
                BigInteger or = (bigInteger == null ? BigInteger.valueOf(j) : bigInteger).or(BigInteger.valueOf((long) (b & Ascii.DEL)));
                if ((b & UnsignedBytes.MAX_POWER_OF_TWO) == 0) {
                    if (z) {
                        stringBuffer.append('2');
                        or = or.subtract(BigInteger.valueOf(80));
                        z = false;
                    }
                    stringBuffer.append('.');
                    stringBuffer.append(or);
                    bigInteger = null;
                } else {
                    bigInteger = or.shiftLeft(7);
                    i2 = i + 1;
                }
            }
            j = 0;
            i2 = i + 1;
        }
        this.c = stringBuffer.toString();
        this.f5659a = Arrays.c(bArr);
    }

    public static ASN1ObjectIdentifier s(byte[] bArr) {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) a.get(new OidHandle(bArr));
        if (aSN1ObjectIdentifier == null) {
            return new ASN1ObjectIdentifier(bArr);
        }
        return aSN1ObjectIdentifier;
    }

    public static ASN1ObjectIdentifier u(ASN1Encodable aSN1Encodable) {
        if (aSN1Encodable == null || (aSN1Encodable instanceof ASN1ObjectIdentifier)) {
            return (ASN1ObjectIdentifier) aSN1Encodable;
        }
        if (aSN1Encodable.b() instanceof ASN1ObjectIdentifier) {
            return (ASN1ObjectIdentifier) aSN1Encodable.b();
        }
        if (aSN1Encodable instanceof byte[]) {
            try {
                return (ASN1ObjectIdentifier) ASN1Primitive.k((byte[]) aSN1Encodable);
            } catch (IOException e) {
                throw new IllegalArgumentException(C0709Uj.g(e, new StringBuilder("failed to construct object identifier from byte[]: ")));
            }
        } else {
            throw new IllegalArgumentException("illegal object in getInstance: ".concat(aSN1Encodable.getClass().getName()));
        }
    }

    public static boolean w(int i, String str) {
        boolean z;
        char charAt;
        int length = str.length();
        do {
            z = false;
            while (true) {
                length--;
                if (length < i) {
                    return z;
                }
                charAt = str.charAt(length);
                if ('0' <= charAt && charAt <= '9') {
                    z = true;
                }
            }
            if (charAt != '.') {
                break;
            }
        } while (z);
        return false;
    }

    public static void y(ByteArrayOutputStream byteArrayOutputStream, long j) {
        byte[] bArr = new byte[9];
        int i = 8;
        bArr[8] = (byte) (((int) j) & 127);
        while (j >= 128) {
            j >>= 7;
            i--;
            bArr[i] = (byte) ((((int) j) & 127) | 128);
        }
        byteArrayOutputStream.write(bArr, i, 9 - i);
    }

    public static void z(ByteArrayOutputStream byteArrayOutputStream, BigInteger bigInteger) {
        int bitLength = (bigInteger.bitLength() + 6) / 7;
        if (bitLength == 0) {
            byteArrayOutputStream.write(0);
            return;
        }
        byte[] bArr = new byte[bitLength];
        int i = bitLength - 1;
        for (int i2 = i; i2 >= 0; i2--) {
            bArr[i2] = (byte) ((bigInteger.intValue() & 127) | 128);
            bigInteger = bigInteger.shiftRight(7);
        }
        bArr[i] = (byte) (bArr[i] & Ascii.DEL);
        byteArrayOutputStream.write(bArr, 0, bitLength);
    }

    public final boolean g(ASN1Primitive aSN1Primitive) {
        if (aSN1Primitive == this) {
            return true;
        }
        if (!(aSN1Primitive instanceof ASN1ObjectIdentifier)) {
            return false;
        }
        return this.c.equals(((ASN1ObjectIdentifier) aSN1Primitive).c);
    }

    public final void h(ASN1OutputStream aSN1OutputStream) throws IOException {
        byte[] t = t();
        aSN1OutputStream.c(6);
        aSN1OutputStream.f(t.length);
        aSN1OutputStream.a.write(t);
    }

    public final int hashCode() {
        return this.c.hashCode();
    }

    public final int i() throws IOException {
        int length = t().length;
        return StreamUtil.a(length) + 1 + length;
    }

    public final boolean n() {
        return false;
    }

    public final void q(String str) {
        new ASN1ObjectIdentifier(str, this);
    }

    public final void r(ByteArrayOutputStream byteArrayOutputStream) {
        boolean z;
        OIDTokenizer oIDTokenizer = new OIDTokenizer(this.c);
        int parseInt = Integer.parseInt(oIDTokenizer.a()) * 40;
        String a2 = oIDTokenizer.a();
        if (a2.length() <= 18) {
            y(byteArrayOutputStream, Long.parseLong(a2) + ((long) parseInt));
        } else {
            z(byteArrayOutputStream, new BigInteger(a2).add(BigInteger.valueOf((long) parseInt)));
        }
        while (true) {
            if (oIDTokenizer.a != -1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                String a3 = oIDTokenizer.a();
                if (a3.length() <= 18) {
                    y(byteArrayOutputStream, Long.parseLong(a3));
                } else {
                    z(byteArrayOutputStream, new BigInteger(a3));
                }
            } else {
                return;
            }
        }
    }

    public final synchronized byte[] t() {
        if (this.f5659a == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            r(byteArrayOutputStream);
            this.f5659a = byteArrayOutputStream.toByteArray();
        }
        return this.f5659a;
    }

    public final String toString() {
        return this.c;
    }

    public final ASN1ObjectIdentifier v() {
        OidHandle oidHandle = new OidHandle(t());
        ConcurrentHashMap concurrentHashMap = a;
        ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) concurrentHashMap.get(oidHandle);
        if (aSN1ObjectIdentifier != null) {
            return aSN1ObjectIdentifier;
        }
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = (ASN1ObjectIdentifier) concurrentHashMap.putIfAbsent(oidHandle, this);
        if (aSN1ObjectIdentifier2 == null) {
            return this;
        }
        return aSN1ObjectIdentifier2;
    }

    public final boolean x(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        String str = aSN1ObjectIdentifier.c;
        String str2 = this.c;
        if (str2.length() <= str.length() || str2.charAt(str.length()) != '.' || !str2.startsWith(str)) {
            return false;
        }
        return true;
    }

    public ASN1ObjectIdentifier(String str) {
        char charAt;
        if (str != null) {
            boolean z = false;
            if (str.length() >= 3 && str.charAt(1) == '.' && (charAt = str.charAt(0)) >= '0' && charAt <= '2') {
                z = w(2, str);
            }
            if (z) {
                this.c = str;
                return;
            }
            throw new IllegalArgumentException(lf.j("string ", str, " not an OID"));
        }
        throw new IllegalArgumentException("'identifier' cannot be null");
    }

    public ASN1ObjectIdentifier(String str, ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        if (w(0, str)) {
            this.c = C1058d.B(new StringBuilder(), aSN1ObjectIdentifier.c, ".", str);
            return;
        }
        throw new IllegalArgumentException(lf.j("string ", str, " not a valid OID branch"));
    }
}
