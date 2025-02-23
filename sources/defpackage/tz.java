package defpackage;

import com.google.common.primitives.UnsignedBytes;
import java.util.Arrays;
import java.util.Locale;

/* renamed from: tz  reason: default package */
/* compiled from: TagImpl */
public final class tz implements mf {
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public final String f3307a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f3308a;
    public final int b;
    public final int c;

    public tz(String str, int i, String str2) {
        this(r1.t(str), i, str2);
    }

    public final boolean a() {
        if (this.c == 2) {
            return true;
        }
        return false;
    }

    public final byte[] b() {
        return this.f3308a;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof mf)) {
            return false;
        }
        mf mfVar = (mf) obj;
        byte[] bArr = this.f3308a;
        if (bArr.length != mfVar.b().length) {
            return false;
        }
        return Arrays.equals(bArr, mfVar.b());
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f3308a) + 177;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Tag[");
        StringBuffer stringBuffer = new StringBuffer();
        byte[] bArr = this.f3308a;
        if (bArr == null) {
            stringBuffer.append("");
        } else {
            int length = bArr.length;
            for (int i = 0; i < length; i++) {
                stringBuffer.append(String.format("%02x ", new Object[]{Integer.valueOf(bArr[i] & UnsignedBytes.MAX_VALUE)}));
            }
        }
        sb.append(stringBuffer.toString().toUpperCase(Locale.getDefault()).trim());
        sb.append("] Name=");
        sb.append(this.f3307a);
        sb.append(", TagType=");
        sb.append(lf.C(this.c));
        sb.append(", ValueType=");
        sb.append(C0709Uj.x(this.a));
        sb.append(", Class=");
        sb.append(lf.z(this.b));
        return sb.toString();
    }

    public tz(byte[] bArr, int i, String str) {
        if (bArr == null) {
            throw new IllegalArgumentException("Param id cannot be null");
        } else if (bArr.length == 0) {
            throw new IllegalArgumentException("Param id cannot be empty");
        } else if (i != 0) {
            this.f3308a = bArr;
            this.f3307a = str;
            this.a = i;
            if (r1.I(bArr[0], 5)) {
                this.c = 2;
            } else {
                this.c = 1;
            }
            byte b2 = (byte) ((bArr[0] >>> 6) & 3);
            if (b2 == 1) {
                this.b = 2;
            } else if (b2 == 2) {
                this.b = 3;
            } else if (b2 != 3) {
                this.b = 1;
            } else {
                this.b = 4;
            }
        } else {
            throw new IllegalArgumentException("Param tagValueType cannot be null");
        }
    }
}
