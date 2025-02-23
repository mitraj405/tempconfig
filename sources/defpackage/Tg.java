package defpackage;

import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import okio.Buffer;
import okio.ByteString;
import okio.Options;

/* renamed from: Tg  reason: default package */
/* compiled from: JsonReader */
public abstract class Tg implements Closeable {
    public static final String[] b = new String[128];
    public int[] a = new int[32];

    /* renamed from: a  reason: collision with other field name */
    public String[] f554a = new String[32];

    /* renamed from: b  reason: collision with other field name */
    public int[] f555b = new int[32];
    public int c;

    /* renamed from: Tg$a */
    /* compiled from: JsonReader */
    public static final class a {
        public final Options a;

        /* renamed from: a  reason: collision with other field name */
        public final String[] f556a;

        public a(String[] strArr, Options options) {
            this.f556a = strArr;
            this.a = options;
        }

        public static a a(String... strArr) {
            String str;
            try {
                ByteString[] byteStringArr = new ByteString[strArr.length];
                Buffer buffer = new Buffer();
                for (int i = 0; i < strArr.length; i++) {
                    String str2 = strArr[i];
                    String[] strArr2 = Tg.b;
                    buffer.A(34);
                    int length = str2.length();
                    int i2 = 0;
                    for (int i3 = 0; i3 < length; i3++) {
                        char charAt = str2.charAt(i3);
                        if (charAt < 128) {
                            str = strArr2[charAt];
                            if (str == null) {
                            }
                        } else if (charAt == 8232) {
                            str = "\\u2028";
                        } else if (charAt == 8233) {
                            str = "\\u2029";
                        }
                        if (i2 < i3) {
                            buffer.O(i2, i3, str2);
                        }
                        buffer.O(0, str.length(), str);
                        i2 = i3 + 1;
                    }
                    if (i2 < length) {
                        buffer.O(i2, length, str2);
                    }
                    buffer.A(34);
                    buffer.readByte();
                    byteStringArr[i] = buffer.n();
                }
                return new a((String[]) strArr.clone(), Options.b(byteStringArr));
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }
    }

    static {
        for (int i = 0; i <= 31; i++) {
            b[i] = String.format("\\u%04x", new Object[]{Integer.valueOf(i)});
        }
        String[] strArr = b;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
    }

    public abstract void a() throws IOException;

    public abstract void b() throws IOException;

    public abstract void c() throws IOException;

    public abstract void e() throws IOException;

    public final String h() {
        int i = this.c;
        int[] iArr = this.a;
        String[] strArr = this.f554a;
        int[] iArr2 = this.f555b;
        StringBuilder sb = new StringBuilder("$");
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = iArr[i2];
            if (i3 == 1 || i3 == 2) {
                sb.append('[');
                sb.append(iArr2[i2]);
                sb.append(']');
            } else if (i3 == 3 || i3 == 4 || i3 == 5) {
                sb.append('.');
                String str = strArr[i2];
                if (str != null) {
                    sb.append(str);
                }
            }
        }
        return sb.toString();
    }

    public abstract boolean j() throws IOException;

    public abstract boolean l() throws IOException;

    public abstract double m() throws IOException;

    public abstract int n() throws IOException;

    public abstract String q() throws IOException;

    public abstract int r() throws IOException;

    public final void s(int i) {
        int i2 = this.c;
        int[] iArr = this.a;
        if (i2 == iArr.length) {
            if (i2 != 256) {
                this.a = Arrays.copyOf(iArr, iArr.length * 2);
                String[] strArr = this.f554a;
                this.f554a = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                int[] iArr2 = this.f555b;
                this.f555b = Arrays.copyOf(iArr2, iArr2.length * 2);
            } else {
                throw new Qx("Nesting too deep at " + h());
            }
        }
        int[] iArr3 = this.a;
        int i3 = this.c;
        this.c = i3 + 1;
        iArr3[i3] = i;
    }

    public abstract int t(a aVar) throws IOException;

    public abstract void u() throws IOException;

    public abstract void v() throws IOException;

    public final void w(String str) throws Sg {
        StringBuilder n = lf.n(str, " at path ");
        n.append(h());
        throw new Sg(n.toString());
    }
}
