package defpackage;

import android.animation.PropertyValuesHolder;
import android.animation.TypeConverter;
import android.graphics.Path;
import android.util.Property;

/* renamed from: Lq  reason: default package */
/* compiled from: PropertyValuesHolderUtils */
public final class Lq {
    public static <V> PropertyValuesHolder a(Property<?, V> property, Path path) {
        return PropertyValuesHolder.ofObject(property, (TypeConverter) null, path);
    }
}
