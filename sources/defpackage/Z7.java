package defpackage;

import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@C1128g8(c = "androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2", f = "DataMigrationInitializer.kt", l = {44, 46}, m = "invokeSuspend")
/* renamed from: Z7  reason: default package */
/* compiled from: DataMigrationInitializer.kt */
public final class Z7 extends Py implements Function2<Object, Continuation<Object>, Object> {
    public W7 a;

    /* renamed from: a  reason: collision with other field name */
    public Object f718a;

    /* renamed from: a  reason: collision with other field name */
    public Iterator f719a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ List<W7<Object>> f720a;
    public /* synthetic */ Object b;

    /* renamed from: b  reason: collision with other field name */
    public final /* synthetic */ List<Function1<Continuation<? super Unit>, Object>> f721b;
    public int c;

    @C1128g8(c = "androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2$1$1", f = "DataMigrationInitializer.kt", l = {45}, m = "invokeSuspend")
    /* renamed from: Z7$a */
    /* compiled from: DataMigrationInitializer.kt */
    public static final class a extends Py implements Function1<Continuation<? super Unit>, Object> {
        public final /* synthetic */ W7<Object> a;
        public int c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(W7<Object> w7, Continuation<? super a> continuation) {
            super(1, continuation);
            this.a = w7;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new a(this.a, continuation);
        }

        public final Object invoke(Object obj) {
            return ((a) create((Continuation) obj)).invokeSuspend(Unit.a);
        }

        public final Object invokeSuspend(Object obj) {
            C1438v7 v7Var = C1438v7.COROUTINE_SUSPENDED;
            int i = this.c;
            if (i == 0) {
                r1.R(obj);
                this.c = 1;
                if (this.a.b() == v7Var) {
                    return v7Var;
                }
            } else if (i == 1) {
                r1.R(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.a;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Z7(List<? extends W7<Object>> list, List<Function1<Continuation<? super Unit>, Object>> list2, Continuation<? super Z7> continuation) {
        super(2, continuation);
        this.f720a = list;
        this.f721b = list2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Z7 z7 = new Z7(this.f720a, this.f721b, continuation);
        z7.b = obj;
        return z7;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((Z7) create(obj, (Continuation) obj2)).invokeSuspend(Unit.a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0084  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            v7 r0 = defpackage.C1438v7.COROUTINE_SUSPENDED
            int r1 = r10.c
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x002d
            if (r1 == r3) goto L_0x001e
            if (r1 != r2) goto L_0x0016
            java.util.Iterator r1 = r10.f719a
            java.lang.Object r4 = r10.b
            java.util.List r4 = (java.util.List) r4
            defpackage.r1.R(r11)
            goto L_0x003c
        L_0x0016:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x001e:
            java.lang.Object r1 = r10.f718a
            W7 r4 = r10.a
            java.util.Iterator r5 = r10.f719a
            java.lang.Object r6 = r10.b
            java.util.List r6 = (java.util.List) r6
            defpackage.r1.R(r11)
            r7 = r10
            goto L_0x0062
        L_0x002d:
            defpackage.r1.R(r11)
            java.lang.Object r11 = r10.b
            java.util.List<W7<java.lang.Object>> r1 = r10.f720a
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
            java.util.List<kotlin.jvm.functions.Function1<kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object>> r4 = r10.f721b
        L_0x003c:
            r5 = r10
        L_0x003d:
            boolean r6 = r1.hasNext()
            if (r6 == 0) goto L_0x0089
            java.lang.Object r6 = r1.next()
            W7 r6 = (defpackage.W7) r6
            r5.b = r4
            r5.f719a = r1
            r5.a = r6
            r5.f718a = r11
            r5.c = r3
            java.lang.Object r7 = r6.c()
            if (r7 != r0) goto L_0x005a
            return r0
        L_0x005a:
            r8 = r1
            r1 = r11
            r11 = r7
            r7 = r5
            r5 = r8
            r9 = r6
            r6 = r4
            r4 = r9
        L_0x0062:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto L_0x0084
            Z7$a r11 = new Z7$a
            r1 = 0
            r11.<init>(r4, r1)
            r6.add(r11)
            r7.b = r6
            r7.f719a = r5
            r7.a = r1
            r7.f718a = r1
            r7.c = r2
            java.lang.Object r11 = r4.a()
            if (r11 != r0) goto L_0x0085
            return r0
        L_0x0084:
            r11 = r1
        L_0x0085:
            r1 = r5
            r4 = r6
            r5 = r7
            goto L_0x003d
        L_0x0089:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.Z7.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
