package defpackage;

/* renamed from: Ix  reason: default package */
/* compiled from: SpscArrayQueue */
public abstract class Ix<E> extends C1419u6<Object> {
    public static final Integer a = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);

    public Ix(int i) {
        super(i);
        Math.min(i / 4, a.intValue());
    }
}
