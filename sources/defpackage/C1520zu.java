package defpackage;

import java.io.PrintStream;

/* renamed from: zu  reason: default package and case insensitive filesystem */
/* compiled from: RxJavaHooks */
public final class C1520zu {
    public static volatile C0230ip a = new C0230ip();

    /* renamed from: a  reason: collision with other field name */
    public static volatile r1 f7111a = new r1();

    /* renamed from: a  reason: collision with other field name */
    public static volatile C1414tu f7112a = new C1414tu();

    /* renamed from: a  reason: collision with other field name */
    public static volatile C1430uu f7113a = new C1430uu();

    /* renamed from: a  reason: collision with other field name */
    public static volatile C1446vu f7114a = new C1446vu();

    /* renamed from: a  reason: collision with other field name */
    public static volatile C1466wu f7115a = new C1466wu();

    /* renamed from: a  reason: collision with other field name */
    public static volatile C1488xu f7116a = new C1488xu();

    /* renamed from: a  reason: collision with other field name */
    public static volatile C1503yu f7117a = new C1503yu();
    public static volatile r1 b = new r1();

    public static void a(Throwable th) {
        r1 r1Var = f7111a;
        if (r1Var != null) {
            try {
                r1Var.call(th);
                return;
            } catch (Throwable th2) {
                PrintStream printStream = System.err;
                printStream.println("The onError handler threw an Exception. It shouldn't. => " + th2.getMessage());
                th2.printStackTrace();
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th2);
            }
        }
        Thread currentThread2 = Thread.currentThread();
        currentThread2.getUncaughtExceptionHandler().uncaughtException(currentThread2, th);
    }

    public static Throwable b(Throwable th) {
        C0230ip ipVar = a;
        if (ipVar != null) {
            return (Throwable) ipVar.c(th);
        }
        return th;
    }

    public static C c(C c) {
        r1 r1Var = b;
        if (r1Var != null) {
            return (C) r1Var.c(c);
        }
        return c;
    }
}
