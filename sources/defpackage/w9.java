package defpackage;

import android.graphics.Insets;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: w9  reason: default package */
/* compiled from: DrawableUtils */
public final class w9 {
    public static final Rect a = new Rect();

    /* renamed from: a  reason: collision with other field name */
    public static final int[] f3389a = {16842912};
    public static final int[] b = new int[0];

    /* renamed from: w9$a */
    /* compiled from: DrawableUtils */
    public static class a {
        public static final Field a;

        /* renamed from: a  reason: collision with other field name */
        public static final Method f3390a;

        /* renamed from: a  reason: collision with other field name */
        public static final boolean f3391a;
        public static final Field b;
        public static final Field c;
        public static final Field d;

        /* JADX WARNING: Removed duplicated region for block: B:43:0x004b  */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x0058  */
        static {
            /*
                r0 = 1
                r1 = 0
                r2 = 0
                java.lang.String r3 = "android.graphics.Insets"
                java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ NoSuchMethodException -> 0x0043, ClassNotFoundException -> 0x003f, NoSuchFieldException -> 0x003b }
                java.lang.Class<android.graphics.drawable.Drawable> r4 = android.graphics.drawable.Drawable.class
                java.lang.String r5 = "getOpticalInsets"
                java.lang.Class[] r6 = new java.lang.Class[r2]     // Catch:{ NoSuchMethodException -> 0x0043, ClassNotFoundException -> 0x003f, NoSuchFieldException -> 0x003b }
                java.lang.reflect.Method r4 = r4.getMethod(r5, r6)     // Catch:{ NoSuchMethodException -> 0x0043, ClassNotFoundException -> 0x003f, NoSuchFieldException -> 0x003b }
                java.lang.String r5 = "left"
                java.lang.reflect.Field r5 = r3.getField(r5)     // Catch:{ NoSuchMethodException -> 0x0039, ClassNotFoundException -> 0x0037, NoSuchFieldException -> 0x0035 }
                java.lang.String r6 = "top"
                java.lang.reflect.Field r6 = r3.getField(r6)     // Catch:{ NoSuchMethodException -> 0x0033, ClassNotFoundException -> 0x0031, NoSuchFieldException -> 0x002f }
                java.lang.String r7 = "right"
                java.lang.reflect.Field r7 = r3.getField(r7)     // Catch:{ ClassNotFoundException | NoSuchFieldException | NoSuchMethodException -> 0x002d }
                java.lang.String r8 = "bottom"
                java.lang.reflect.Field r3 = r3.getField(r8)     // Catch:{ ClassNotFoundException | NoSuchFieldException | NoSuchMethodException -> 0x0047 }
                r8 = r0
                goto L_0x0049
            L_0x002d:
                r7 = r1
                goto L_0x0047
            L_0x002f:
                r6 = r1
                goto L_0x0046
            L_0x0031:
                r6 = r1
                goto L_0x0046
            L_0x0033:
                r6 = r1
                goto L_0x0046
            L_0x0035:
                r5 = r1
                goto L_0x003d
            L_0x0037:
                r5 = r1
                goto L_0x0041
            L_0x0039:
                r5 = r1
                goto L_0x0045
            L_0x003b:
                r4 = r1
                r5 = r4
            L_0x003d:
                r6 = r5
                goto L_0x0046
            L_0x003f:
                r4 = r1
                r5 = r4
            L_0x0041:
                r6 = r5
                goto L_0x0046
            L_0x0043:
                r4 = r1
                r5 = r4
            L_0x0045:
                r6 = r5
            L_0x0046:
                r7 = r6
            L_0x0047:
                r3 = r1
                r8 = r2
            L_0x0049:
                if (r8 == 0) goto L_0x0058
                f3390a = r4
                a = r5
                b = r6
                c = r7
                d = r3
                f3391a = r0
                goto L_0x0064
            L_0x0058:
                f3390a = r1
                a = r1
                b = r1
                c = r1
                d = r1
                f3391a = r2
            L_0x0064:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.w9.a.<clinit>():void");
        }
    }

    /* renamed from: w9$b */
    /* compiled from: DrawableUtils */
    public static class b {
        public static Insets a(Drawable drawable) {
            return drawable.getOpticalInsets();
        }
    }

    public static void a(Drawable drawable) {
        String name = drawable.getClass().getName();
        int i = Build.VERSION.SDK_INT;
        if (i >= 29 && i < 31 && "android.graphics.drawable.ColorStateListDrawable".equals(name)) {
            int[] state = drawable.getState();
            if (state == null || state.length == 0) {
                drawable.setState(f3389a);
            } else {
                drawable.setState(b);
            }
            drawable.setState(state);
        }
    }

    public static Rect b(Drawable drawable) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            Insets a2 = b.a(drawable);
            return new Rect(a2.left, a2.top, a2.right, a2.bottom);
        }
        Drawable d = v9.d(drawable);
        if (i >= 29) {
            boolean z = a.f3391a;
        } else if (a.f3391a) {
            try {
                Object invoke = a.f3390a.invoke(d, new Object[0]);
                if (invoke != null) {
                    return new Rect(a.a.getInt(invoke), a.b.getInt(invoke), a.c.getInt(invoke), a.d.getInt(invoke));
                }
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
        return a;
    }

    public static PorterDuff.Mode c(int i, PorterDuff.Mode mode) {
        if (i == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }
}
