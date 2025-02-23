package defpackage;

import java.io.Writer;

/* renamed from: xi  reason: default package and case insensitive filesystem */
/* compiled from: LogWriter */
public final class C0396xi extends Writer {
    public final StringBuilder a = new StringBuilder(128);

    public final void a() {
        StringBuilder sb = this.a;
        if (sb.length() > 0) {
            sb.toString();
            sb.delete(0, sb.length());
        }
    }

    public final void close() {
        a();
    }

    public final void flush() {
        a();
    }

    public final void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i + i3];
            if (c == 10) {
                a();
            } else {
                this.a.append(c);
            }
        }
    }
}
