package defpackage;

/* renamed from: F3  reason: default package */
/* compiled from: CallbackToFutureAdapter */
public final class F3<T> {
    public Bt<Void> a = new Bt<>();

    /* renamed from: a  reason: collision with other field name */
    public H3<T> f187a;

    /* renamed from: a  reason: collision with other field name */
    public Object f188a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f189a;

    public final void finalize() {
        Bt<Void> bt;
        H3<T> h3 = this.f187a;
        if (h3 != null && !h3.isDone()) {
            h3.a.setException(new G3("The completer object was garbage collected - this future would otherwise never complete. The tag was: " + this.f188a));
        }
        if (!this.f189a && (bt = this.a) != null) {
            bt.set(null);
        }
    }
}
