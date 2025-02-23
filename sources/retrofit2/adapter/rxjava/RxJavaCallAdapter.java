package retrofit2.adapter.rxjava;

import java.lang.reflect.Type;
import retrofit2.CallAdapter;
import rx.Scheduler;

final class RxJavaCallAdapter<R> implements CallAdapter<R, Object> {
    private final boolean isAsync;
    private final boolean isBody;
    private final boolean isCompletable;
    private final boolean isResult;
    private final boolean isSingle;
    private final Type responseType;
    private final Scheduler scheduler;

    public RxJavaCallAdapter(Type type, Scheduler scheduler2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.responseType = type;
        this.scheduler = scheduler2;
        this.isAsync = z;
        this.isResult = z2;
        this.isBody = z3;
        this.isSingle = z4;
        this.isCompletable = z5;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x004a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object adapt(retrofit2.Call<R> r3) {
        /*
            r2 = this;
            boolean r0 = r2.isAsync
            if (r0 == 0) goto L_0x000a
            retrofit2.adapter.rxjava.CallEnqueueOnSubscribe r0 = new retrofit2.adapter.rxjava.CallEnqueueOnSubscribe
            r0.<init>(r3)
            goto L_0x000f
        L_0x000a:
            retrofit2.adapter.rxjava.CallExecuteOnSubscribe r0 = new retrofit2.adapter.rxjava.CallExecuteOnSubscribe
            r0.<init>(r3)
        L_0x000f:
            boolean r3 = r2.isResult
            if (r3 == 0) goto L_0x001a
            retrofit2.adapter.rxjava.ResultOnSubscribe r3 = new retrofit2.adapter.rxjava.ResultOnSubscribe
            r3.<init>(r0)
        L_0x0018:
            r0 = r3
            goto L_0x0024
        L_0x001a:
            boolean r3 = r2.isBody
            if (r3 == 0) goto L_0x0024
            retrofit2.adapter.rxjava.BodyOnSubscribe r3 = new retrofit2.adapter.rxjava.BodyOnSubscribe
            r3.<init>(r0)
            goto L_0x0018
        L_0x0024:
            rx.Observable r3 = new rx.Observable
            tu r1 = defpackage.C1520zu.f7112a
            if (r1 == 0) goto L_0x0030
            java.lang.Object r0 = r1.c(r0)
            rx.Observable$OnSubscribe r0 = (rx.Observable.OnSubscribe) r0
        L_0x0030:
            r3.<init>(r0)
            rx.Scheduler r0 = r2.scheduler
            if (r0 == 0) goto L_0x003b
            rx.Observable r3 = r3.c(r0)
        L_0x003b:
            boolean r0 = r2.isSingle
            if (r0 == 0) goto L_0x004a
            rx.c r0 = new rx.c
            bo r1 = new bo
            r1.<init>(r3)
            r0.<init>(r1)
            return r0
        L_0x004a:
            boolean r0 = r2.isCompletable
            if (r0 == 0) goto L_0x006a
            rx.a r0 = new rx.a
            r0.<init>(r3)
            rx.b r3 = new rx.b     // Catch:{ NullPointerException -> 0x0068, all -> 0x0059 }
            r3.<init>(r0)     // Catch:{ NullPointerException -> 0x0068, all -> 0x0059 }
            return r3
        L_0x0059:
            r3 = move-exception
            defpackage.C1520zu.a(r3)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Actually not, but can't pass out an exception otherwise..."
            r0.<init>(r1)
            r0.initCause(r3)
            throw r0
        L_0x0068:
            r3 = move-exception
            throw r3
        L_0x006a:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: retrofit2.adapter.rxjava.RxJavaCallAdapter.adapt(retrofit2.Call):java.lang.Object");
    }

    public Type responseType() {
        return this.responseType;
    }
}
