package defpackage;

import android.annotation.SuppressLint;

/* renamed from: ho  reason: default package and case insensitive filesystem */
/* compiled from: Operation */
public interface C0218ho {
    @SuppressLint({"SyntheticAccessor"})
    public static final a.b a = new a.b();
    @SuppressLint({"SyntheticAccessor"})

    /* renamed from: a  reason: collision with other field name */
    public static final a.c f3000a = new a.c();

    /* renamed from: ho$a */
    /* compiled from: Operation */
    public static abstract class a {

        /* renamed from: ho$a$a  reason: collision with other inner class name */
        /* compiled from: Operation */
        public static final class C0031a extends a {
            public final Throwable a;

            public C0031a(Throwable th) {
                this.a = th;
            }

            public final String toString() {
                return String.format("FAILURE (%s)", new Object[]{this.a.getMessage()});
            }
        }

        /* renamed from: ho$a$b */
        /* compiled from: Operation */
        public static final class b extends a {
            public final String toString() {
                return "IN_PROGRESS";
            }
        }

        /* renamed from: ho$a$c */
        /* compiled from: Operation */
        public static final class c extends a {
            public final String toString() {
                return "SUCCESS";
            }
        }
    }
}
