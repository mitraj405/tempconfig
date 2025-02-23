package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.widget.AppCompatTextHelper;

public final class TintTypedArray {
    public final Context a;

    /* renamed from: a  reason: collision with other field name */
    public final TypedArray f1265a;

    /* renamed from: a  reason: collision with other field name */
    public TypedValue f1266a;

    public TintTypedArray(Context context, TypedArray typedArray) {
        this.a = context;
        this.f1265a = typedArray;
    }

    public static TintTypedArray m(Context context, AttributeSet attributeSet, int[] iArr, int i) {
        return new TintTypedArray(context, context.obtainStyledAttributes(attributeSet, iArr, i, 0));
    }

    public final boolean a(int i, boolean z) {
        return this.f1265a.getBoolean(i, z);
    }

    public final ColorStateList b(int i) {
        int resourceId;
        ColorStateList c;
        TypedArray typedArray = this.f1265a;
        if (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (c = d7.c(this.a, resourceId)) == null) {
            return typedArray.getColorStateList(i);
        }
        return c;
    }

    public final int c(int i, int i2) {
        return this.f1265a.getDimensionPixelOffset(i, i2);
    }

    public final int d(int i, int i2) {
        return this.f1265a.getDimensionPixelSize(i, i2);
    }

    public final Drawable e(int i) {
        int resourceId;
        TypedArray typedArray = this.f1265a;
        if (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0) {
            return typedArray.getDrawable(i);
        }
        return r1.w(this.a, resourceId);
    }

    public final Drawable f(int i) {
        int resourceId;
        Drawable f;
        if (!this.f1265a.hasValue(i) || (resourceId = this.f1265a.getResourceId(i, 0)) == 0) {
            return null;
        }
        o1 a2 = o1.a();
        Context context = this.a;
        synchronized (a2) {
            f = a2.f3135a.f(context, resourceId, true);
        }
        return f;
    }

    public final Typeface g(int i, int i2, AppCompatTextHelper.a aVar) {
        int resourceId = this.f1265a.getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f1266a == null) {
            this.f1266a = new TypedValue();
        }
        TypedValue typedValue = this.f1266a;
        ThreadLocal<TypedValue> threadLocal = Et.f161a;
        Context context = this.a;
        if (context.isRestricted()) {
            return null;
        }
        return Et.a(context, resourceId, typedValue, i2, aVar, true, false);
    }

    public final int h(int i, int i2) {
        return this.f1265a.getInt(i, i2);
    }

    public final int i(int i, int i2) {
        return this.f1265a.getResourceId(i, i2);
    }

    public final String j(int i) {
        return this.f1265a.getString(i);
    }

    public final CharSequence k(int i) {
        return this.f1265a.getText(i);
    }

    public final boolean l(int i) {
        return this.f1265a.hasValue(i);
    }

    public final void n() {
        this.f1265a.recycle();
    }
}
