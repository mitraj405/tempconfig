package defpackage;

import java.io.PrintStream;

/* renamed from: QB  reason: default package and case insensitive filesystem */
/* compiled from: Util */
public final class C0649QB {
    public static a a = null;

    /* renamed from: a  reason: collision with other field name */
    public static boolean f3764a = false;

    /* renamed from: QB$a */
    /* compiled from: Util */
    public static final class a extends SecurityManager {
        public final Class<?>[] getClassContext() {
            return super.getClassContext();
        }
    }

    public static final void a(String str) {
        PrintStream printStream = System.err;
        printStream.println("SLF4J: " + str);
    }

    public static final void b(String str, Throwable th) {
        System.err.println(str);
        System.err.println("Reported exception:");
        th.printStackTrace();
    }
}
