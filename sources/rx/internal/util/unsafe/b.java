package rx.internal.util.unsafe;

/* compiled from: SpscArrayQueue */
public abstract class b<E> extends Ix<E> {
    public static final long c = C1255mB.a(b.class, "producerIndex");
    protected long producerIndex;

    public b(int i) {
        super(i);
    }
}
