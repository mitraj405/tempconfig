package rx.internal.util;

import defpackage.C1096ev;
import java.util.Arrays;
import java.util.LinkedList;
import rx.Subscription;

public final class SubscriptionList implements Subscription {
    public LinkedList a;

    /* renamed from: a  reason: collision with other field name */
    public volatile boolean f6949a;

    public SubscriptionList() {
    }

    public final void a(Subscription subscription) {
        if (!subscription.isUnsubscribed()) {
            if (!this.f6949a) {
                synchronized (this) {
                    if (!this.f6949a) {
                        LinkedList linkedList = this.a;
                        if (linkedList == null) {
                            linkedList = new LinkedList();
                            this.a = linkedList;
                        }
                        linkedList.add(subscription);
                        return;
                    }
                }
            }
            subscription.unsubscribe();
        }
    }

    public final boolean isUnsubscribed() {
        return this.f6949a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0014, code lost:
        if (r0 != null) goto L_0x0017;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0017, code lost:
        r0 = r0.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001f, code lost:
        if (r0.hasNext() == false) goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        ((rx.Subscription) r0.next()).unsubscribe();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002b, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002c, code lost:
        if (r1 == null) goto L_0x002e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002e, code lost:
        r1 = new java.util.ArrayList();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0033, code lost:
        r1.add(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0037, code lost:
        defpackage.C1354qp.C0(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void unsubscribe() {
        /*
            r3 = this;
            boolean r0 = r3.f6949a
            if (r0 != 0) goto L_0x003e
            monitor-enter(r3)
            boolean r0 = r3.f6949a     // Catch:{ all -> 0x003b }
            if (r0 == 0) goto L_0x000b
            monitor-exit(r3)     // Catch:{ all -> 0x003b }
            return
        L_0x000b:
            r0 = 1
            r3.f6949a = r0     // Catch:{ all -> 0x003b }
            java.util.LinkedList r0 = r3.a     // Catch:{ all -> 0x003b }
            r1 = 0
            r3.a = r1     // Catch:{ all -> 0x003b }
            monitor-exit(r3)     // Catch:{ all -> 0x003b }
            if (r0 != 0) goto L_0x0017
            goto L_0x003e
        L_0x0017:
            java.util.Iterator r0 = r0.iterator()
        L_0x001b:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0037
            java.lang.Object r2 = r0.next()
            rx.Subscription r2 = (rx.Subscription) r2
            r2.unsubscribe()     // Catch:{ all -> 0x002b }
            goto L_0x001b
        L_0x002b:
            r2 = move-exception
            if (r1 != 0) goto L_0x0033
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
        L_0x0033:
            r1.add(r2)
            goto L_0x001b
        L_0x0037:
            defpackage.C1354qp.C0(r1)
            goto L_0x003e
        L_0x003b:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x003b }
            throw r0
        L_0x003e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.internal.util.SubscriptionList.unsubscribe():void");
    }

    public SubscriptionList(Subscription... subscriptionArr) {
        this.a = new LinkedList(Arrays.asList(subscriptionArr));
    }

    public SubscriptionList(C1096ev.b bVar) {
        LinkedList linkedList = new LinkedList();
        this.a = linkedList;
        linkedList.add(bVar);
    }
}
