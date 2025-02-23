package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import androidx.appcompat.widget.TintTypedArray;

/* renamed from: Oz  reason: default package */
/* compiled from: ThemeUtils */
public final class Oz {
    public static final ThreadLocal<TypedValue> a = new ThreadLocal<>();

    /* renamed from: a  reason: collision with other field name */
    public static final int[] f473a = {-16842910};
    public static final int[] b = {16842908};
    public static final int[] c = {16842919};
    public static final int[] d = {16842912};
    public static final int[] e = new int[0];
    public static final int[] f = new int[1];

    public static void a(Context context, View view) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(ps.AppCompatTheme);
        try {
            if (!obtainStyledAttributes.hasValue(ps.AppCompatTheme_windowActionBar)) {
                view.getClass().toString();
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static int b(Context context, int i) {
        ColorStateList d2 = d(context, i);
        if (d2 != null && d2.isStateful()) {
            return d2.getColorForState(f473a, d2.getDefaultColor());
        }
        ThreadLocal<TypedValue> threadLocal = a;
        TypedValue typedValue = threadLocal.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            threadLocal.set(typedValue);
        }
        context.getTheme().resolveAttribute(16842803, typedValue, true);
        float f2 = typedValue.getFloat();
        int c2 = c(context, i);
        return A5.d(c2, Math.round(((float) Color.alpha(c2)) * f2));
    }

    public static int c(Context context, int i) {
        int[] iArr = f;
        iArr[0] = i;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, iArr);
        TintTypedArray tintTypedArray = new TintTypedArray(context, obtainStyledAttributes);
        try {
            return obtainStyledAttributes.getColor(0, 0);
        } finally {
            tintTypedArray.n();
        }
    }

    public static ColorStateList d(Context context, int i) {
        int[] iArr = f;
        iArr[0] = i;
        TintTypedArray tintTypedArray = new TintTypedArray(context, context.obtainStyledAttributes((AttributeSet) null, iArr));
        try {
            return tintTypedArray.b(0);
        } finally {
            tintTypedArray.n();
        }
    }
}
