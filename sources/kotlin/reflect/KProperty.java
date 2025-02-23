package kotlin.reflect;

/* compiled from: KProperty.kt */
public interface KProperty<V> extends KCallable<V> {

    /* compiled from: KProperty.kt */
    public interface Getter<V> extends KFunction<V> {
    }

    boolean isConst();

    boolean isLateinit();
}
