package defpackage;

import defpackage.Tg;
import java.io.EOFException;
import java.io.IOException;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

/* renamed from: Ug  reason: default package */
/* compiled from: JsonUtf8Reader */
public final class Ug extends Tg {
    public static final ByteString a = ByteString.m("'\\");
    public static final ByteString b = ByteString.m("\"\\");
    public static final ByteString c = ByteString.m("{}[]:, \n\t\r\f/\\;#=");

    /* renamed from: a  reason: collision with other field name */
    public long f572a;

    /* renamed from: a  reason: collision with other field name */
    public final Buffer f573a;

    /* renamed from: a  reason: collision with other field name */
    public final BufferedSource f574a;

    /* renamed from: c  reason: collision with other field name */
    public String f575c;
    public int d = 0;
    public int e;

    static {
        ByteString.m("\n\r");
        ByteString.m("*/");
    }

    public Ug(As as) {
        this.f574a = as;
        this.f573a = as.a;
        s(6);
    }

    public final int A(String str, Tg.a aVar) {
        int length = aVar.f556a.length;
        for (int i = 0; i < length; i++) {
            if (str.equals(aVar.f556a[i])) {
                this.d = 0;
                this.f554a[this.c - 1] = str;
                return i;
            }
        }
        return -1;
    }

    public final boolean C(int i) throws IOException {
        if (i == 9 || i == 10 || i == 12 || i == 13 || i == 32) {
            return false;
        }
        if (i != 35) {
            if (i == 44) {
                return false;
            }
            if (!(i == 47 || i == 61)) {
                if (i == 123 || i == 125 || i == 58) {
                    return false;
                }
                if (i != 59) {
                    switch (i) {
                        case 91:
                        case 93:
                            return false;
                        case 92:
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        y();
        throw null;
    }

    public final String E() throws IOException {
        String str;
        int i = this.d;
        if (i == 0) {
            i = z();
        }
        if (i == 14) {
            str = L();
        } else if (i == 13) {
            str = J(b);
        } else if (i == 12) {
            str = J(a);
        } else if (i == 15) {
            str = this.f575c;
        } else {
            throw new Qx("Expected a name but was " + lf.A(r()) + " at path " + h());
        }
        this.d = 0;
        this.f554a[this.c - 1] = str;
        return str;
    }

    public final int G(boolean z) throws IOException {
        int i = 0;
        while (true) {
            int i2 = i + 1;
            BufferedSource bufferedSource = this.f574a;
            if (bufferedSource.S((long) i2)) {
                long j = (long) i;
                Buffer buffer = this.f573a;
                byte h = buffer.h(j);
                if (h == 10 || h == 32 || h == 13 || h == 9) {
                    i = i2;
                } else {
                    buffer.d0((long) (i2 - 1));
                    if (h == 47) {
                        if (!bufferedSource.S(2)) {
                            return h;
                        }
                        y();
                        throw null;
                    } else if (h != 35) {
                        return h;
                    } else {
                        y();
                        throw null;
                    }
                }
            } else if (!z) {
                return -1;
            } else {
                throw new EOFException("End of input");
            }
        }
    }

    public final String J(ByteString byteString) throws IOException {
        StringBuilder sb = null;
        while (true) {
            long j0 = this.f574a.j0(byteString);
            if (j0 != -1) {
                Buffer buffer = this.f573a;
                if (buffer.h(j0) == 92) {
                    if (sb == null) {
                        sb = new StringBuilder();
                    }
                    sb.append(buffer.s(j0));
                    buffer.readByte();
                    sb.append(N());
                } else if (sb == null) {
                    String s = buffer.s(j0);
                    buffer.readByte();
                    return s;
                } else {
                    sb.append(buffer.s(j0));
                    buffer.readByte();
                    return sb.toString();
                }
            } else {
                w("Unterminated string");
                throw null;
            }
        }
    }

    public final String L() throws IOException {
        long j0 = this.f574a.j0(c);
        int i = (j0 > -1 ? 1 : (j0 == -1 ? 0 : -1));
        Buffer buffer = this.f573a;
        if (i != 0) {
            return buffer.s(j0);
        }
        return buffer.r();
    }

    public final char N() throws IOException {
        int i;
        int i2;
        BufferedSource bufferedSource = this.f574a;
        if (bufferedSource.S(1)) {
            Buffer buffer = this.f573a;
            byte readByte = buffer.readByte();
            if (readByte == 10 || readByte == 34 || readByte == 39 || readByte == 47 || readByte == 92) {
                return (char) readByte;
            }
            if (readByte == 98) {
                return 8;
            }
            if (readByte == 102) {
                return 12;
            }
            if (readByte == 110) {
                return 10;
            }
            if (readByte == 114) {
                return 13;
            }
            if (readByte == 116) {
                return 9;
            }
            if (readByte != 117) {
                w("Invalid escape sequence: \\" + ((char) readByte));
                throw null;
            } else if (bufferedSource.S(4)) {
                char c2 = 0;
                for (int i3 = 0; i3 < 4; i3++) {
                    byte h = buffer.h((long) i3);
                    char c3 = (char) (c2 << 4);
                    if (h < 48 || h > 57) {
                        if (h >= 97 && h <= 102) {
                            i2 = h - 97;
                        } else if (h < 65 || h > 70) {
                            w("\\u".concat(buffer.s(4)));
                            throw null;
                        } else {
                            i2 = h - 65;
                        }
                        i = i2 + 10;
                    } else {
                        i = h - 48;
                    }
                    c2 = (char) (i + c3);
                }
                buffer.d0(4);
                return c2;
            } else {
                throw new EOFException("Unterminated escape sequence at path " + h());
            }
        } else {
            w("Unterminated escape sequence");
            throw null;
        }
    }

    public final void O(ByteString byteString) throws IOException {
        while (true) {
            long j0 = this.f574a.j0(byteString);
            if (j0 != -1) {
                Buffer buffer = this.f573a;
                if (buffer.h(j0) == 92) {
                    buffer.d0(j0 + 1);
                    N();
                } else {
                    buffer.d0(j0 + 1);
                    return;
                }
            } else {
                w("Unterminated string");
                throw null;
            }
        }
    }

    public final void a() throws IOException {
        int i = this.d;
        if (i == 0) {
            i = z();
        }
        if (i == 3) {
            s(1);
            this.f555b[this.c - 1] = 0;
            this.d = 0;
            return;
        }
        throw new Qx("Expected BEGIN_ARRAY but was " + lf.A(r()) + " at path " + h());
    }

    public final void b() throws IOException {
        int i = this.d;
        if (i == 0) {
            i = z();
        }
        if (i == 1) {
            s(3);
            this.d = 0;
            return;
        }
        throw new Qx("Expected BEGIN_OBJECT but was " + lf.A(r()) + " at path " + h());
    }

    public final void c() throws IOException {
        int i = this.d;
        if (i == 0) {
            i = z();
        }
        if (i == 4) {
            int i2 = this.c - 1;
            this.c = i2;
            int[] iArr = this.f555b;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
            this.d = 0;
            return;
        }
        throw new Qx("Expected END_ARRAY but was " + lf.A(r()) + " at path " + h());
    }

    public final void close() throws IOException {
        this.d = 0;
        this.a[0] = 8;
        this.c = 1;
        this.f573a.a();
        this.f574a.close();
    }

    public final void e() throws IOException {
        int i = this.d;
        if (i == 0) {
            i = z();
        }
        if (i == 2) {
            int i2 = this.c - 1;
            this.c = i2;
            this.f554a[i2] = null;
            int[] iArr = this.f555b;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
            this.d = 0;
            return;
        }
        throw new Qx("Expected END_OBJECT but was " + lf.A(r()) + " at path " + h());
    }

    public final boolean j() throws IOException {
        int i = this.d;
        if (i == 0) {
            i = z();
        }
        if (i == 2 || i == 4 || i == 18) {
            return false;
        }
        return true;
    }

    public final boolean l() throws IOException {
        int i = this.d;
        if (i == 0) {
            i = z();
        }
        if (i == 5) {
            this.d = 0;
            int[] iArr = this.f555b;
            int i2 = this.c - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        } else if (i == 6) {
            this.d = 0;
            int[] iArr2 = this.f555b;
            int i3 = this.c - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return false;
        } else {
            throw new Qx("Expected a boolean but was " + lf.A(r()) + " at path " + h());
        }
    }

    public final double m() throws IOException {
        int i = this.d;
        if (i == 0) {
            i = z();
        }
        if (i == 16) {
            this.d = 0;
            int[] iArr = this.f555b;
            int i2 = this.c - 1;
            iArr[i2] = iArr[i2] + 1;
            return (double) this.f572a;
        }
        if (i == 17) {
            this.f575c = this.f573a.s((long) this.e);
        } else if (i == 9) {
            this.f575c = J(b);
        } else if (i == 8) {
            this.f575c = J(a);
        } else if (i == 10) {
            this.f575c = L();
        } else if (i != 11) {
            throw new Qx("Expected a double but was " + lf.A(r()) + " at path " + h());
        }
        this.d = 11;
        try {
            double parseDouble = Double.parseDouble(this.f575c);
            if (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble)) {
                throw new Sg("JSON forbids NaN and infinities: " + parseDouble + " at path " + h());
            }
            this.f575c = null;
            this.d = 0;
            int[] iArr2 = this.f555b;
            int i3 = this.c - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return parseDouble;
        } catch (NumberFormatException unused) {
            throw new Qx("Expected a double but was " + this.f575c + " at path " + h());
        }
    }

    public final int n() throws IOException {
        String str;
        int i = this.d;
        if (i == 0) {
            i = z();
        }
        if (i == 16) {
            long j = this.f572a;
            int i2 = (int) j;
            if (j == ((long) i2)) {
                this.d = 0;
                int[] iArr = this.f555b;
                int i3 = this.c - 1;
                iArr[i3] = iArr[i3] + 1;
                return i2;
            }
            throw new Qx("Expected an int but was " + this.f572a + " at path " + h());
        }
        if (i == 17) {
            this.f575c = this.f573a.s((long) this.e);
        } else if (i == 9 || i == 8) {
            if (i == 9) {
                str = J(b);
            } else {
                str = J(a);
            }
            this.f575c = str;
            try {
                int parseInt = Integer.parseInt(str);
                this.d = 0;
                int[] iArr2 = this.f555b;
                int i4 = this.c - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        } else if (i != 11) {
            throw new Qx("Expected an int but was " + lf.A(r()) + " at path " + h());
        }
        this.d = 11;
        try {
            double parseDouble = Double.parseDouble(this.f575c);
            int i5 = (int) parseDouble;
            if (((double) i5) == parseDouble) {
                this.f575c = null;
                this.d = 0;
                int[] iArr3 = this.f555b;
                int i6 = this.c - 1;
                iArr3[i6] = iArr3[i6] + 1;
                return i5;
            }
            throw new Qx("Expected an int but was " + this.f575c + " at path " + h());
        } catch (NumberFormatException unused2) {
            throw new Qx("Expected an int but was " + this.f575c + " at path " + h());
        }
    }

    public final String q() throws IOException {
        String str;
        int i = this.d;
        if (i == 0) {
            i = z();
        }
        if (i == 10) {
            str = L();
        } else if (i == 9) {
            str = J(b);
        } else if (i == 8) {
            str = J(a);
        } else if (i == 11) {
            str = this.f575c;
            this.f575c = null;
        } else if (i == 16) {
            str = Long.toString(this.f572a);
        } else if (i == 17) {
            str = this.f573a.s((long) this.e);
        } else {
            throw new Qx("Expected a string but was " + lf.A(r()) + " at path " + h());
        }
        this.d = 0;
        int[] iArr = this.f555b;
        int i2 = this.c - 1;
        iArr[i2] = iArr[i2] + 1;
        return str;
    }

    public final int r() throws IOException {
        int i = this.d;
        if (i == 0) {
            i = z();
        }
        switch (i) {
            case 1:
                return 3;
            case 2:
                return 4;
            case 3:
                return 1;
            case 4:
                return 2;
            case 5:
            case 6:
                return 8;
            case 7:
                return 9;
            case 8:
            case 9:
            case 10:
            case 11:
                return 6;
            case 12:
            case 13:
            case 14:
            case 15:
                return 5;
            case 16:
            case 17:
                return 7;
            case 18:
                return 10;
            default:
                throw new AssertionError();
        }
    }

    public final int t(Tg.a aVar) throws IOException {
        int i = this.d;
        if (i == 0) {
            i = z();
        }
        if (i < 12 || i > 15) {
            return -1;
        }
        if (i == 15) {
            return A(this.f575c, aVar);
        }
        int p = this.f574a.p(aVar.a);
        if (p != -1) {
            this.d = 0;
            this.f554a[this.c - 1] = aVar.f556a[p];
            return p;
        }
        String str = this.f554a[this.c - 1];
        String E = E();
        int A = A(E, aVar);
        if (A == -1) {
            this.d = 15;
            this.f575c = E;
            this.f554a[this.c - 1] = str;
        }
        return A;
    }

    public final String toString() {
        return "JsonReader(" + this.f574a + ")";
    }

    public final void u() throws IOException {
        int i = this.d;
        if (i == 0) {
            i = z();
        }
        if (i == 14) {
            long j0 = this.f574a.j0(c);
            int i2 = (j0 > -1 ? 1 : (j0 == -1 ? 0 : -1));
            Buffer buffer = this.f573a;
            if (i2 == 0) {
                j0 = buffer.f5623a;
            }
            buffer.d0(j0);
        } else if (i == 13) {
            O(b);
        } else if (i == 12) {
            O(a);
        } else if (i != 15) {
            throw new Qx("Expected a name but was " + lf.A(r()) + " at path " + h());
        }
        this.d = 0;
        this.f554a[this.c - 1] = "null";
    }

    public final void v() throws IOException {
        int i = 0;
        do {
            int i2 = this.d;
            if (i2 == 0) {
                i2 = z();
            }
            if (i2 == 3) {
                s(1);
            } else if (i2 == 1) {
                s(3);
            } else {
                if (i2 == 4) {
                    i--;
                    if (i >= 0) {
                        this.c--;
                    } else {
                        throw new Qx("Expected a value but was " + lf.A(r()) + " at path " + h());
                    }
                } else if (i2 == 2) {
                    i--;
                    if (i >= 0) {
                        this.c--;
                    } else {
                        throw new Qx("Expected a value but was " + lf.A(r()) + " at path " + h());
                    }
                } else {
                    Buffer buffer = this.f573a;
                    if (i2 == 14 || i2 == 10) {
                        long j0 = this.f574a.j0(c);
                        if (j0 == -1) {
                            j0 = buffer.f5623a;
                        }
                        buffer.d0(j0);
                    } else if (i2 == 9 || i2 == 13) {
                        O(b);
                    } else if (i2 == 8 || i2 == 12) {
                        O(a);
                    } else if (i2 == 17) {
                        buffer.d0((long) this.e);
                    } else if (i2 == 18) {
                        throw new Qx("Expected a value but was " + lf.A(r()) + " at path " + h());
                    }
                }
                this.d = 0;
            }
            i++;
            this.d = 0;
        } while (i != 0);
        int[] iArr = this.f555b;
        int i3 = this.c;
        int i4 = i3 - 1;
        iArr[i4] = iArr[i4] + 1;
        this.f554a[i3 - 1] = "null";
    }

    public final void y() throws IOException {
        w("Use JsonReader.setLenient(true) to accept malformed JSON");
        throw null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0193, code lost:
        if (C(r1) != false) goto L_0x01f5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0195, code lost:
        if (r4 != 2) goto L_0x01b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0197, code lost:
        if (r6 == false) goto L_0x01b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x019d, code lost:
        if (r10 != Long.MIN_VALUE) goto L_0x01a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x019f, code lost:
        if (r7 == false) goto L_0x01b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x01a5, code lost:
        if (r10 != 0) goto L_0x01a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x01a7, code lost:
        if (r7 != false) goto L_0x01b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x01a9, code lost:
        if (r7 == false) goto L_0x01ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x01ac, code lost:
        r10 = -r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x01ad, code lost:
        r0.f572a = r10;
        r5.d0((long) r3);
        r8 = 16;
        r0.d = 16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x01b8, code lost:
        if (r4 == 2) goto L_0x01c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x01bb, code lost:
        if (r4 == 4) goto L_0x01c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x01be, code lost:
        if (r4 != 7) goto L_0x01f5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x01c0, code lost:
        r0.e = r3;
        r8 = 17;
        r0.d = 17;
     */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x0240  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0112 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0113  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int z() throws java.io.IOException {
        /*
            r17 = this;
            r0 = r17
            int[] r1 = r0.a
            int r2 = r0.c
            int r3 = r2 + -1
            r3 = r1[r3]
            r6 = 0
            r7 = 93
            r9 = 59
            r10 = 44
            r11 = 3
            r12 = 6
            r13 = 7
            r14 = 5
            r15 = 2
            r4 = 4
            okio.Buffer r5 = r0.f573a
            r8 = 1
            if (r3 != r8) goto L_0x0021
            int r2 = r2 - r8
            r1[r2] = r15
        L_0x001f:
            r1 = 0
            goto L_0x007f
        L_0x0021:
            if (r3 != r15) goto L_0x003d
            int r1 = r0.G(r8)
            r5.readByte()
            if (r1 == r10) goto L_0x001f
            if (r1 == r9) goto L_0x0039
            if (r1 != r7) goto L_0x0033
            r0.d = r4
            return r4
        L_0x0033:
            java.lang.String r1 = "Unterminated array"
            r0.w(r1)
            throw r6
        L_0x0039:
            r17.y()
            throw r6
        L_0x003d:
            if (r3 == r11) goto L_0x0250
            if (r3 != r14) goto L_0x0043
            goto L_0x0250
        L_0x0043:
            if (r3 != r4) goto L_0x0061
            int r2 = r2 - r8
            r1[r2] = r14
            int r1 = r0.G(r8)
            r5.readByte()
            r2 = 58
            if (r1 == r2) goto L_0x001f
            r2 = 61
            if (r1 == r2) goto L_0x005d
            java.lang.String r1 = "Expected ':'"
            r0.w(r1)
            throw r6
        L_0x005d:
            r17.y()
            throw r6
        L_0x0061:
            if (r3 != r12) goto L_0x0067
            int r2 = r2 - r8
            r1[r2] = r13
            goto L_0x001f
        L_0x0067:
            if (r3 != r13) goto L_0x007a
            r1 = 0
            int r1 = r0.G(r1)
            r2 = -1
            if (r1 != r2) goto L_0x0076
            r1 = 18
            r0.d = r1
            return r1
        L_0x0076:
            r17.y()
            throw r6
        L_0x007a:
            r1 = 0
            r2 = 8
            if (r3 == r2) goto L_0x0248
        L_0x007f:
            int r2 = r0.G(r8)
            r1 = 34
            if (r2 == r1) goto L_0x0240
            r1 = 39
            if (r2 == r1) goto L_0x023b
            if (r2 == r10) goto L_0x0229
            if (r2 == r9) goto L_0x0229
            r1 = 91
            if (r2 == r1) goto L_0x0222
            if (r2 == r7) goto L_0x0218
            r1 = 123(0x7b, float:1.72E-43)
            if (r2 == r1) goto L_0x0211
            r1 = 0
            byte r3 = r5.h(r1)
            r7 = 116(0x74, float:1.63E-43)
            okio.BufferedSource r9 = r0.f574a
            if (r3 == r7) goto L_0x00c7
            r7 = 84
            if (r3 != r7) goto L_0x00aa
            goto L_0x00c7
        L_0x00aa:
            r7 = 102(0x66, float:1.43E-43)
            if (r3 == r7) goto L_0x00c1
            r7 = 70
            if (r3 != r7) goto L_0x00b3
            goto L_0x00c1
        L_0x00b3:
            r7 = 110(0x6e, float:1.54E-43)
            if (r3 == r7) goto L_0x00bb
            r7 = 78
            if (r3 != r7) goto L_0x0108
        L_0x00bb:
            java.lang.String r3 = "null"
            java.lang.String r7 = "NULL"
            r10 = r13
            goto L_0x00cc
        L_0x00c1:
            java.lang.String r3 = "false"
            java.lang.String r7 = "FALSE"
            r10 = r12
            goto L_0x00cc
        L_0x00c7:
            java.lang.String r3 = "true"
            java.lang.String r7 = "TRUE"
            r10 = r14
        L_0x00cc:
            int r6 = r3.length()
            r13 = r8
        L_0x00d1:
            if (r13 >= r6) goto L_0x00f4
            int r4 = r13 + 1
            long r11 = (long) r4
            boolean r11 = r9.S(r11)
            if (r11 != 0) goto L_0x00dd
            goto L_0x0108
        L_0x00dd:
            long r11 = (long) r13
            byte r11 = r5.h(r11)
            char r12 = r3.charAt(r13)
            if (r11 == r12) goto L_0x00ef
            char r12 = r7.charAt(r13)
            if (r11 == r12) goto L_0x00ef
            goto L_0x0108
        L_0x00ef:
            r13 = r4
            r4 = 4
            r11 = 3
            r12 = 6
            goto L_0x00d1
        L_0x00f4:
            int r3 = r6 + 1
            long r3 = (long) r3
            boolean r3 = r9.S(r3)
            if (r3 == 0) goto L_0x010a
            long r3 = (long) r6
            byte r3 = r5.h(r3)
            boolean r3 = r0.C(r3)
            if (r3 == 0) goto L_0x010a
        L_0x0108:
            r10 = 0
            goto L_0x0110
        L_0x010a:
            long r3 = (long) r6
            r5.d0(r3)
            r0.d = r10
        L_0x0110:
            if (r10 == 0) goto L_0x0113
            return r10
        L_0x0113:
            r10 = r1
            r6 = r8
            r3 = 0
            r4 = 0
            r7 = 0
        L_0x0118:
            int r12 = r3 + 1
            long r1 = (long) r12
            boolean r1 = r9.S(r1)
            if (r1 != 0) goto L_0x0123
            goto L_0x0195
        L_0x0123:
            long r1 = (long) r3
            byte r1 = r5.h(r1)
            r2 = 43
            if (r1 == r2) goto L_0x01e6
            r2 = 69
            if (r1 == r2) goto L_0x01db
            r2 = 101(0x65, float:1.42E-43)
            if (r1 == r2) goto L_0x01db
            r2 = 45
            if (r1 == r2) goto L_0x01cf
            r2 = 46
            if (r1 == r2) goto L_0x01c7
            r2 = 48
            if (r1 < r2) goto L_0x018f
            r2 = 57
            if (r1 <= r2) goto L_0x0145
            goto L_0x018f
        L_0x0145:
            if (r4 == r8) goto L_0x0183
            if (r4 != 0) goto L_0x014a
            goto L_0x0183
        L_0x014a:
            if (r4 != r15) goto L_0x0175
            r2 = 0
            int r13 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r13 != 0) goto L_0x0154
            goto L_0x01f5
        L_0x0154:
            r2 = 10
            long r2 = r2 * r10
            int r1 = r1 + -48
            r16 = r9
            long r8 = (long) r1
            long r2 = r2 - r8
            r8 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r1 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r1 > 0) goto L_0x016f
            if (r1 != 0) goto L_0x016d
            int r1 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r1 >= 0) goto L_0x016d
            goto L_0x016f
        L_0x016d:
            r1 = 0
            goto L_0x0170
        L_0x016f:
            r1 = 1
        L_0x0170:
            r1 = r1 & r6
            r6 = r1
            r10 = r2
            r2 = 6
            goto L_0x018c
        L_0x0175:
            r16 = r9
            r1 = 3
            r2 = 6
            if (r4 != r1) goto L_0x017d
            r4 = 4
            goto L_0x018c
        L_0x017d:
            if (r4 == r14) goto L_0x0181
            if (r4 != r2) goto L_0x018c
        L_0x0181:
            r4 = 7
            goto L_0x018c
        L_0x0183:
            r16 = r9
            r2 = 6
            int r1 = r1 + -48
            int r1 = -r1
            long r3 = (long) r1
            r10 = r3
            r4 = r15
        L_0x018c:
            r1 = 7
            goto L_0x01ed
        L_0x018f:
            boolean r1 = r0.C(r1)
            if (r1 != 0) goto L_0x01f5
        L_0x0195:
            if (r4 != r15) goto L_0x01b8
            if (r6 == 0) goto L_0x01b8
            r1 = -9223372036854775808
            int r1 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x01a1
            if (r7 == 0) goto L_0x01b8
        L_0x01a1:
            r1 = 0
            int r6 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r6 != 0) goto L_0x01a9
            if (r7 != 0) goto L_0x01b8
        L_0x01a9:
            if (r7 == 0) goto L_0x01ac
            goto L_0x01ad
        L_0x01ac:
            long r10 = -r10
        L_0x01ad:
            r0.f572a = r10
            long r1 = (long) r3
            r5.d0(r1)
            r8 = 16
            r0.d = r8
            goto L_0x01f6
        L_0x01b8:
            if (r4 == r15) goto L_0x01c0
            r1 = 4
            if (r4 == r1) goto L_0x01c0
            r1 = 7
            if (r4 != r1) goto L_0x01f5
        L_0x01c0:
            r0.e = r3
            r8 = 17
            r0.d = r8
            goto L_0x01f6
        L_0x01c7:
            r16 = r9
            r1 = 7
            r2 = 6
            if (r4 != r15) goto L_0x01f5
            r4 = 3
            goto L_0x01ed
        L_0x01cf:
            r16 = r9
            r1 = 7
            r2 = 6
            if (r4 != 0) goto L_0x01d8
            r4 = 1
            r7 = 1
            goto L_0x01ed
        L_0x01d8:
            if (r4 != r14) goto L_0x01f5
            goto L_0x01ec
        L_0x01db:
            r16 = r9
            r1 = 7
            r2 = 6
            if (r4 == r15) goto L_0x01e4
            r3 = 4
            if (r4 != r3) goto L_0x01f5
        L_0x01e4:
            r4 = r14
            goto L_0x01ed
        L_0x01e6:
            r16 = r9
            r1 = 7
            r2 = 6
            if (r4 != r14) goto L_0x01f5
        L_0x01ec:
            r4 = r2
        L_0x01ed:
            r3 = r12
            r9 = r16
            r1 = 0
            r8 = 1
            goto L_0x0118
        L_0x01f5:
            r8 = 0
        L_0x01f6:
            if (r8 == 0) goto L_0x01f9
            return r8
        L_0x01f9:
            r1 = 0
            byte r1 = r5.h(r1)
            boolean r1 = r0.C(r1)
            if (r1 != 0) goto L_0x020c
            java.lang.String r1 = "Expected value"
            r0.w(r1)
            r1 = 0
            throw r1
        L_0x020c:
            r1 = 0
            r17.y()
            throw r1
        L_0x0211:
            r5.readByte()
            r1 = 1
            r0.d = r1
            return r1
        L_0x0218:
            r1 = r8
            if (r3 != r1) goto L_0x022a
            r5.readByte()
            r1 = 4
            r0.d = r1
            return r1
        L_0x0222:
            r5.readByte()
            r1 = 3
            r0.d = r1
            return r1
        L_0x0229:
            r1 = r8
        L_0x022a:
            if (r3 == r1) goto L_0x0236
            if (r3 != r15) goto L_0x022f
            goto L_0x0236
        L_0x022f:
            java.lang.String r1 = "Unexpected value"
            r0.w(r1)
            r1 = 0
            throw r1
        L_0x0236:
            r1 = 0
            r17.y()
            throw r1
        L_0x023b:
            r1 = r6
            r17.y()
            throw r1
        L_0x0240:
            r5.readByte()
            r1 = 9
            r0.d = r1
            return r1
        L_0x0248:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "JsonReader is closed"
            r1.<init>(r2)
            throw r1
        L_0x0250:
            r4 = r8
            int r2 = r2 - r4
            r6 = 4
            r1[r2] = r6
            r1 = 125(0x7d, float:1.75E-43)
            if (r3 != r14) goto L_0x0277
            int r2 = r0.G(r4)
            r5.readByte()
            if (r2 == r10) goto L_0x0275
            if (r2 == r9) goto L_0x0270
            if (r2 != r1) goto L_0x0269
            r0.d = r15
            return r15
        L_0x0269:
            java.lang.String r1 = "Unterminated object"
            r0.w(r1)
            r1 = 0
            throw r1
        L_0x0270:
            r1 = 0
            r17.y()
            throw r1
        L_0x0275:
            r2 = 1
            goto L_0x0278
        L_0x0277:
            r2 = r4
        L_0x0278:
            int r2 = r0.G(r2)
            r4 = 34
            if (r2 == r4) goto L_0x02a2
            r4 = 39
            if (r2 == r4) goto L_0x029a
            if (r2 != r1) goto L_0x0295
            if (r3 == r14) goto L_0x028e
            r5.readByte()
            r0.d = r15
            return r15
        L_0x028e:
            java.lang.String r1 = "Expected name"
            r0.w(r1)
            r1 = 0
            throw r1
        L_0x0295:
            r1 = 0
            r17.y()
            throw r1
        L_0x029a:
            r1 = 0
            r5.readByte()
            r17.y()
            throw r1
        L_0x02a2:
            r5.readByte()
            r1 = 13
            r0.d = r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.Ug.z():int");
    }
}
