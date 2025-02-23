package defpackage;

/* renamed from: zi  reason: default package */
/* compiled from: Logger */
public abstract class zi {
    public static zi a;

    /* renamed from: zi$a */
    /* compiled from: Logger */
    public static class a extends zi {
        public final int a;

        public a(int i) {
            this.a = i;
        }

        public final void a(Throwable... thArr) {
            if (this.a <= 3 && thArr.length >= 1) {
                Throwable th = thArr[0];
            }
        }

        public final void b(Throwable... thArr) {
            if (this.a <= 6 && thArr.length >= 1) {
                Throwable th = thArr[0];
            }
        }

        public final void d(Throwable... thArr) {
            if (this.a <= 4 && thArr.length >= 1) {
                Throwable th = thArr[0];
            }
        }

        public final void f(Throwable... thArr) {
            if (this.a <= 5 && thArr.length >= 1) {
                Throwable th = thArr[0];
            }
        }
    }

    public static synchronized zi c() {
        zi ziVar;
        synchronized (zi.class) {
            if (a == null) {
                a = new a(3);
            }
            ziVar = a;
        }
        return ziVar;
    }

    public static String e(String str) {
        int length = str.length();
        StringBuilder sb = new StringBuilder(23);
        sb.append("WM-");
        if (length >= 20) {
            sb.append(str.substring(0, 20));
        } else {
            sb.append(str);
        }
        return sb.toString();
    }

    public abstract void a(Throwable... thArr);

    public abstract void b(Throwable... thArr);

    public abstract void d(Throwable... thArr);

    public abstract void f(Throwable... thArr);
}
