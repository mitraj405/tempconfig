package defpackage;

import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;

/* renamed from: TC  reason: default package */
/* compiled from: ViewUtils */
public final class TC {
    public static final a a = new a();

    /* renamed from: a  reason: collision with other field name */
    public static final b f547a = new b();

    /* renamed from: a  reason: collision with other field name */
    public static final YC f548a;

    /* renamed from: TC$a */
    /* compiled from: ViewUtils */
    public class a extends Property<View, Float> {
        public a() {
            super(Float.class, "translationAlpha");
        }

        public final Object get(Object obj) {
            return Float.valueOf(TC.f548a.a((View) obj));
        }

        public final void set(Object obj, Object obj2) {
            TC.b((View) obj, ((Float) obj2).floatValue());
        }
    }

    /* renamed from: TC$b */
    /* compiled from: ViewUtils */
    public class b extends Property<View, Rect> {
        public b() {
            super(Rect.class, "clipBounds");
        }

        public final Object get(Object obj) {
            return ((View) obj).getClipBounds();
        }

        public final void set(Object obj, Object obj2) {
            ((View) obj).setClipBounds((Rect) obj2);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 29) {
            f548a = new ZC();
        } else {
            f548a = new YC();
        }
    }

    public static void a(View view, int i, int i2, int i3, int i4) {
        f548a.g(view, i, i2, i3, i4);
    }

    public static void b(View view, float f) {
        f548a.b(view, f);
    }

    public static void c(View view, int i) {
        f548a.c(view, i);
    }
}
