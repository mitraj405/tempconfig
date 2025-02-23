package defpackage;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/* renamed from: y2  reason: default package and case insensitive filesystem */
/* compiled from: BaseNCodec */
public abstract class C1493y2 {
    public final int a;

    /* renamed from: y2$a */
    /* compiled from: BaseNCodec */
    public static class a {
        public int a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f7070a;

        /* renamed from: a  reason: collision with other field name */
        public byte[] f7071a;
        public int b;
        public int c;
        public int d;
        public int e;

        public final String toString() {
            return String.format("%s[buffer=%s, currentLinePos=%s, eof=%s, ibitWorkArea=%s, lbitWorkArea=%s, modulus=%s, pos=%s, readPos=%s]", new Object[]{a.class.getSimpleName(), Arrays.toString(this.f7071a), Integer.valueOf(this.d), Boolean.valueOf(this.f7070a), Integer.valueOf(this.a), 0L, Integer.valueOf(this.e), Integer.valueOf(this.b), Integer.valueOf(this.c)});
        }
    }

    public C1493y2(int i, int i2) {
        boolean z;
        int i3 = 0;
        if (i <= 0 || i2 <= 0) {
            z = false;
        } else {
            z = true;
        }
        this.a = z ? (i / 4) * 4 : i3;
    }

    public static byte[] e(int i, a aVar) {
        byte[] bArr = aVar.f7071a;
        if (bArr != null && bArr.length >= aVar.b + i) {
            return bArr;
        }
        if (bArr == null) {
            aVar.f7071a = new byte[UserMetadata.MAX_INTERNAL_KEY_SIZE];
            aVar.b = 0;
            aVar.c = 0;
        } else {
            byte[] bArr2 = new byte[(bArr.length * 2)];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            aVar.f7071a = bArr2;
        }
        return aVar.f7071a;
    }

    public static void f(byte[] bArr, int i, a aVar) {
        if (aVar.f7071a != null) {
            int min = Math.min(aVar.b - aVar.c, i);
            System.arraycopy(aVar.f7071a, aVar.c, bArr, 0, min);
            int i2 = aVar.c + min;
            aVar.c = i2;
            if (i2 >= aVar.b) {
                aVar.f7071a = null;
            }
        }
    }

    public abstract void a(byte[] bArr, int i, a aVar);

    public final byte[] b(String str) {
        byte[] v = r1.v(str);
        if (v == null || v.length == 0) {
            return v;
        }
        a aVar = new a();
        a(v, v.length, aVar);
        a(v, -1, aVar);
        int i = aVar.b;
        byte[] bArr = new byte[i];
        f(bArr, i, aVar);
        return bArr;
    }

    public abstract void c(byte[] bArr, int i, a aVar);

    public final String d(byte[] bArr) {
        if (!(bArr == null || bArr.length == 0)) {
            a aVar = new a();
            c(bArr, bArr.length, aVar);
            c(bArr, -1, aVar);
            int i = aVar.b - aVar.c;
            byte[] bArr2 = new byte[i];
            f(bArr2, i, aVar);
            bArr = bArr2;
        }
        if (bArr == null) {
            return null;
        }
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            throw new IllegalStateException("Unknown or unsupported character set name: UTF-8");
        }
    }
}
