package defpackage;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* renamed from: zy  reason: default package and case insensitive filesystem */
/* compiled from: Share.kt */
public final class C1523zy<T> implements FlowCollector<T> {
    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x001f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.Unit b(kotlin.coroutines.Continuation r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof defpackage.C1505yy
            if (r0 == 0) goto L_0x0013
            r0 = r5
            yy r0 = (defpackage.C1505yy) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.c = r1
            goto L_0x0018
        L_0x0013:
            yy r0 = new yy
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.f7074a
            int r1 = r0.c
            r2 = 1
            if (r1 == 0) goto L_0x0040
            if (r1 == r2) goto L_0x0032
            r0 = 2
            if (r1 != r0) goto L_0x002a
            defpackage.r1.R(r5)
        L_0x0027:
            kotlin.Unit r5 = kotlin.Unit.a
            return r5
        L_0x002a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0032:
            Ju r1 = r0.a
            zy r0 = r0.f7075a
            defpackage.r1.R(r5)     // Catch:{ all -> 0x0054 }
            r1.releaseIntercepted()
            r0.getClass()
            goto L_0x0027
        L_0x0040:
            defpackage.r1.R(r5)
            Ju r1 = new Ju
            kotlin.coroutines.CoroutineContext r5 = r0.getContext()
            r3 = 0
            r1.<init>(r3, r5)
            r0.f7075a = r4     // Catch:{ all -> 0x0054 }
            r0.a = r1     // Catch:{ all -> 0x0054 }
            r0.c = r2     // Catch:{ all -> 0x0054 }
            throw r3     // Catch:{ all -> 0x0054 }
        L_0x0054:
            r5 = move-exception
            r1.releaseIntercepted()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C1523zy.b(kotlin.coroutines.Continuation):kotlin.Unit");
    }

    public final Object emit(T t, Continuation<? super Unit> continuation) {
        throw null;
    }
}
