package androidx.dynamicanimation.animation;

import android.util.FloatProperty;

public abstract class FloatPropertyCompat<T> {
    final String mPropertyName;

    public static class a extends FloatPropertyCompat<T> {
        public final /* synthetic */ FloatProperty a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(String str, FloatProperty floatProperty) {
            super(str);
            this.a = floatProperty;
        }

        public final float getValue(T t) {
            return ((Float) this.a.get(t)).floatValue();
        }

        public final void setValue(T t, float f) {
            this.a.setValue(t, f);
        }
    }

    public FloatPropertyCompat(String str) {
        this.mPropertyName = str;
    }

    public static <T> FloatPropertyCompat<T> createFloatPropertyCompat(FloatProperty<T> floatProperty) {
        return new a(floatProperty.getName(), floatProperty);
    }

    public abstract float getValue(T t);

    public abstract void setValue(T t, float f);
}
