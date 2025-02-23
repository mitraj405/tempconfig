package defpackage;

import java.nio.charset.Charset;

/* renamed from: RB  reason: default package and case insensitive filesystem */
/* compiled from: Util */
public final class C0663RB {
    public static final Charset a = Charset.forName("UTF-8");

    public static void a(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException(String.format("size=%s offset=%s byteCount=%s", new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}));
        }
    }
}
