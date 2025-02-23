package defpackage;

import rx.Subscription;
import rx.internal.util.SubscriptionList;

/* renamed from: ix  reason: default package and case insensitive filesystem */
/* compiled from: SingleSubscriber */
public abstract class C1182ix<T> implements Subscription {
    public final SubscriptionList a = new SubscriptionList();

    public abstract void a(Throwable th);

    public abstract void b(T t);

    public final boolean isUnsubscribed() {
        return this.a.f6949a;
    }

    public final void unsubscribe() {
        this.a.unsubscribe();
    }
}
