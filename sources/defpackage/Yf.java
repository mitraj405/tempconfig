package defpackage;

import android.view.inputmethod.InputContentInfo;

/* renamed from: Yf  reason: default package */
/* compiled from: InputContentInfoCompat */
public final class Yf {
    public final b a;

    /* renamed from: Yf$a */
    /* compiled from: InputContentInfoCompat */
    public static final class a implements b {
        public final InputContentInfo a;

        public a(Object obj) {
            this.a = (InputContentInfo) obj;
        }

        public final Object a() {
            return this.a;
        }

        public final void b() {
            this.a.requestPermission();
        }
    }

    /* renamed from: Yf$b */
    /* compiled from: InputContentInfoCompat */
    public interface b {
    }

    public Yf(a aVar) {
        this.a = aVar;
    }
}
