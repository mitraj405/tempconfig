package defpackage;

import androidx.datastore.core.DataStore;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.k;
import kotlinx.coroutines.sync.Mutex;

/* renamed from: Ww  reason: default package */
/* compiled from: SingleProcessDataStore.kt */
public final class Ww<T> implements DataStore<T> {
    public static final Object a = new Object();

    /* renamed from: a  reason: collision with other field name */
    public static final LinkedHashSet f638a = new LinkedHashSet();

    /* renamed from: a  reason: collision with other field name */
    public final Lw<a<T>> f639a;

    /* renamed from: a  reason: collision with other field name */
    public final Mu f640a = new Mu(new ax(this, (Continuation<? super ax>) null));

    /* renamed from: a  reason: collision with other field name */
    public final Sx f641a;

    /* renamed from: a  reason: collision with other field name */
    public final C0715Uy f642a = C1354qp.d0(new C0163cx(this));

    /* renamed from: a  reason: collision with other field name */
    public final hw<T> f643a;

    /* renamed from: a  reason: collision with other field name */
    public final String f644a = ".tmp";

    /* renamed from: a  reason: collision with other field name */
    public List<? extends Function2<? super Tf<T>, ? super Continuation<? super Unit>, ? extends Object>> f645a;

    /* renamed from: a  reason: collision with other field name */
    public final Function0<File> f646a;

    /* renamed from: a  reason: collision with other field name */
    public final CoroutineScope f647a;

    /* renamed from: a  reason: collision with other field name */
    public final C0387x7<T> f648a;

    /* renamed from: Ww$a */
    /* compiled from: SingleProcessDataStore.kt */
    public static abstract class a<T> {

        /* renamed from: Ww$a$a  reason: collision with other inner class name */
        /* compiled from: SingleProcessDataStore.kt */
        public static final class C0000a<T> extends a<T> {
            public final Rx<T> a;

            public C0000a(Rx<T> rx2) {
                this.a = rx2;
            }
        }

        /* renamed from: Ww$a$b */
        /* compiled from: SingleProcessDataStore.kt */
        public static final class b<T> extends a<T> {
            public final N5<T> a;

            /* renamed from: a  reason: collision with other field name */
            public final Rx<T> f649a;

            /* renamed from: a  reason: collision with other field name */
            public final CoroutineContext f650a;

            /* renamed from: a  reason: collision with other field name */
            public final Function2<T, Continuation<? super T>, Object> f651a;

            public b(Function2 function2, C0617O5 o5, Rx rx2, CoroutineContext coroutineContext) {
                C1177ig.f(coroutineContext, "callerContext");
                this.f651a = function2;
                this.a = o5;
                this.f649a = rx2;
                this.f650a = coroutineContext;
            }
        }
    }

    /* renamed from: Ww$b */
    /* compiled from: SingleProcessDataStore.kt */
    public static final class b extends OutputStream {
        public final FileOutputStream a;

        public b(FileOutputStream fileOutputStream) {
            this.a = fileOutputStream;
        }

        public final void flush() {
            this.a.flush();
        }

        public final void write(int i) {
            this.a.write(i);
        }

        public final void write(byte[] bArr) {
            C1177ig.f(bArr, "b");
            this.a.write(bArr);
        }

        public final void write(byte[] bArr, int i, int i2) {
            C1177ig.f(bArr, "bytes");
            this.a.write(bArr, i, i2);
        }

        public final void close() {
        }
    }

    @C1128g8(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {322, 348, 505}, m = "readAndInit")
    /* renamed from: Ww$c */
    /* compiled from: SingleProcessDataStore.kt */
    public static final class c extends C1148h7 {
        public d a;

        /* renamed from: a  reason: collision with other field name */
        public Ww f652a;

        /* renamed from: a  reason: collision with other field name */
        public Serializable f653a;

        /* renamed from: a  reason: collision with other field name */
        public Object f654a;

        /* renamed from: a  reason: collision with other field name */
        public Iterator f655a;
        public final /* synthetic */ Ww<T> b;

        /* renamed from: b  reason: collision with other field name */
        public Object f656b;
        public int c;

        /* renamed from: c  reason: collision with other field name */
        public /* synthetic */ Object f657c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(Ww<T> ww, Continuation<? super c> continuation) {
            super(continuation);
            this.b = ww;
        }

        public final Object invokeSuspend(Object obj) {
            this.f657c = obj;
            this.c |= Integer.MIN_VALUE;
            LinkedHashSet linkedHashSet = Ww.f638a;
            return this.b.e(this);
        }
    }

    /* renamed from: Ww$d */
    /* compiled from: SingleProcessDataStore.kt */
    public static final class d implements Tf<T> {
        public final /* synthetic */ C0546Is a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ C0571Ks<T> f658a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ Ww<T> f659a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ Mutex f660a;

        public d(Mutex mutex, C0546Is is, C0571Ks<T> ks, Ww<T> ww) {
            this.f660a = mutex;
            this.a = is;
            this.f658a = ks;
            this.f659a = ww;
        }

        /* JADX WARNING: Removed duplicated region for block: B:22:0x006c  */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x0093 A[Catch:{ all -> 0x00d4 }] */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x00b3 A[Catch:{ all -> 0x0054 }] */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x00c9 A[Catch:{ all -> 0x0039 }] */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x00d6 A[SYNTHETIC, Splitter:B:49:0x00d6] */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object a(defpackage.Z7 r11, kotlin.coroutines.Continuation r12) {
            /*
                r10 = this;
                boolean r0 = r12 instanceof defpackage.C0186ex
                if (r0 == 0) goto L_0x0013
                r0 = r12
                ex r0 = (defpackage.C0186ex) r0
                int r1 = r0.c
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L_0x0013
                int r1 = r1 - r2
                r0.c = r1
                goto L_0x0018
            L_0x0013:
                ex r0 = new ex
                r0.<init>(r10, r12)
            L_0x0018:
                java.lang.Object r12 = r0.d
                v7 r1 = defpackage.C1438v7.COROUTINE_SUSPENDED
                int r2 = r0.c
                r3 = 3
                r4 = 2
                r5 = 1
                r6 = 0
                if (r2 == 0) goto L_0x006c
                if (r2 == r5) goto L_0x0057
                if (r2 == r4) goto L_0x0044
                if (r2 != r3) goto L_0x003c
                java.lang.Object r11 = r0.f2918c
                java.lang.Object r1 = r0.b
                Ks r1 = (defpackage.C0571Ks) r1
                java.lang.Object r0 = r0.f2917a
                kotlinx.coroutines.sync.Mutex r0 = (kotlinx.coroutines.sync.Mutex) r0
                defpackage.r1.R(r12)     // Catch:{ all -> 0x0039 }
                goto L_0x00c5
            L_0x0039:
                r11 = move-exception
                goto L_0x00d0
            L_0x003c:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r12)
                throw r11
            L_0x0044:
                java.lang.Object r11 = r0.f2918c
                Ww r11 = (defpackage.Ww) r11
                java.lang.Object r2 = r0.b
                Ks r2 = (defpackage.C0571Ks) r2
                java.lang.Object r4 = r0.f2917a
                kotlinx.coroutines.sync.Mutex r4 = (kotlinx.coroutines.sync.Mutex) r4
                defpackage.r1.R(r12)     // Catch:{ all -> 0x0054 }
                goto L_0x00ab
            L_0x0054:
                r11 = move-exception
                goto L_0x00d2
            L_0x0057:
                Ww r11 = r0.f2916a
                Ks r2 = r0.a
                java.lang.Object r5 = r0.f2918c
                Is r5 = (defpackage.C0546Is) r5
                java.lang.Object r7 = r0.b
                kotlinx.coroutines.sync.Mutex r7 = (kotlinx.coroutines.sync.Mutex) r7
                java.lang.Object r8 = r0.f2917a
                kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
                defpackage.r1.R(r12)
                r12 = r7
                goto L_0x008f
            L_0x006c:
                defpackage.r1.R(r12)
                r0.f2917a = r11
                kotlinx.coroutines.sync.Mutex r12 = r10.f660a
                r0.b = r12
                Is r2 = r10.a
                r0.f2918c = r2
                Ks<T> r7 = r10.f658a
                r0.a = r7
                Ww<T> r8 = r10.f659a
                r0.f2916a = r8
                r0.c = r5
                java.lang.Object r5 = r12.c(r0)
                if (r5 != r1) goto L_0x008a
                return r1
            L_0x008a:
                r5 = r2
                r2 = r7
                r9 = r8
                r8 = r11
                r11 = r9
            L_0x008f:
                boolean r5 = r5.a     // Catch:{ all -> 0x00d4 }
                if (r5 != 0) goto L_0x00d6
                T r5 = r2.a     // Catch:{ all -> 0x00d4 }
                r0.f2917a = r12     // Catch:{ all -> 0x00d4 }
                r0.b = r2     // Catch:{ all -> 0x00d4 }
                r0.f2918c = r11     // Catch:{ all -> 0x00d4 }
                r0.a = r6     // Catch:{ all -> 0x00d4 }
                r0.f2916a = r6     // Catch:{ all -> 0x00d4 }
                r0.c = r4     // Catch:{ all -> 0x00d4 }
                java.lang.Object r4 = r8.invoke(r5, r0)     // Catch:{ all -> 0x00d4 }
                if (r4 != r1) goto L_0x00a8
                return r1
            L_0x00a8:
                r9 = r4
                r4 = r12
                r12 = r9
            L_0x00ab:
                T r5 = r2.a     // Catch:{ all -> 0x0054 }
                boolean r5 = defpackage.C1177ig.a(r12, r5)     // Catch:{ all -> 0x0054 }
                if (r5 != 0) goto L_0x00c9
                r0.f2917a = r4     // Catch:{ all -> 0x0054 }
                r0.b = r2     // Catch:{ all -> 0x0054 }
                r0.f2918c = r12     // Catch:{ all -> 0x0054 }
                r0.c = r3     // Catch:{ all -> 0x0054 }
                java.lang.Object r11 = r11.k(r12, r0)     // Catch:{ all -> 0x0054 }
                if (r11 != r1) goto L_0x00c2
                return r1
            L_0x00c2:
                r11 = r12
                r1 = r2
                r0 = r4
            L_0x00c5:
                r1.a = r11     // Catch:{ all -> 0x0039 }
                r2 = r1
                goto L_0x00ca
            L_0x00c9:
                r0 = r4
            L_0x00ca:
                T r11 = r2.a     // Catch:{ all -> 0x0039 }
                r0.b(r6)
                return r11
            L_0x00d0:
                r12 = r0
                goto L_0x00de
            L_0x00d2:
                r12 = r4
                goto L_0x00de
            L_0x00d4:
                r11 = move-exception
                goto L_0x00de
            L_0x00d6:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00d4 }
                java.lang.String r0 = "InitializerApi.updateData should not be called after initialization is complete."
                r11.<init>(r0)     // Catch:{ all -> 0x00d4 }
                throw r11     // Catch:{ all -> 0x00d4 }
            L_0x00de:
                r12.b(r6)
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.Ww.d.a(Z7, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    @C1128g8(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {302}, m = "readAndInitOrPropagateAndThrowFailure")
    /* renamed from: Ww$e */
    /* compiled from: SingleProcessDataStore.kt */
    public static final class e extends C1148h7 {
        public Ww a;

        /* renamed from: a  reason: collision with other field name */
        public /* synthetic */ Object f661a;
        public final /* synthetic */ Ww<T> b;
        public int c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(Ww<T> ww, Continuation<? super e> continuation) {
            super(continuation);
            this.b = ww;
        }

        public final Object invokeSuspend(Object obj) {
            this.f661a = obj;
            this.c |= Integer.MIN_VALUE;
            LinkedHashSet linkedHashSet = Ww.f638a;
            return this.b.f(this);
        }
    }

    @C1128g8(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {311}, m = "readAndInitOrPropagateFailure")
    /* renamed from: Ww$f */
    /* compiled from: SingleProcessDataStore.kt */
    public static final class f extends C1148h7 {
        public Ww a;

        /* renamed from: a  reason: collision with other field name */
        public /* synthetic */ Object f662a;
        public final /* synthetic */ Ww<T> b;
        public int c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(Ww<T> ww, Continuation<? super f> continuation) {
            super(continuation);
            this.b = ww;
        }

        public final Object invokeSuspend(Object obj) {
            this.f662a = obj;
            this.c |= Integer.MIN_VALUE;
            LinkedHashSet linkedHashSet = Ww.f638a;
            return this.b.g(this);
        }
    }

    @C1128g8(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {381}, m = "readData")
    /* renamed from: Ww$g */
    /* compiled from: SingleProcessDataStore.kt */
    public static final class g extends C1148h7 {
        public Ww a;

        /* renamed from: a  reason: collision with other field name */
        public FileInputStream f663a;

        /* renamed from: a  reason: collision with other field name */
        public /* synthetic */ Object f664a;
        public final /* synthetic */ Ww<T> b;
        public int c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(Ww<T> ww, Continuation<? super g> continuation) {
            super(continuation);
            this.b = ww;
        }

        public final Object invokeSuspend(Object obj) {
            this.f664a = obj;
            this.c |= Integer.MIN_VALUE;
            LinkedHashSet linkedHashSet = Ww.f638a;
            return this.b.h(this);
        }
    }

    @C1128g8(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {359, 362, 365}, m = "readDataOrHandleCorruption")
    /* renamed from: Ww$h */
    /* compiled from: SingleProcessDataStore.kt */
    public static final class h extends C1148h7 {
        public final /* synthetic */ Ww<T> a;

        /* renamed from: a  reason: collision with other field name */
        public Object f665a;
        public Object b;
        public int c;

        /* renamed from: c  reason: collision with other field name */
        public /* synthetic */ Object f666c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(Ww<T> ww, Continuation<? super h> continuation) {
            super(continuation);
            this.a = ww;
        }

        public final Object invokeSuspend(Object obj) {
            this.f666c = obj;
            this.c |= Integer.MIN_VALUE;
            LinkedHashSet linkedHashSet = Ww.f638a;
            return this.a.i(this);
        }
    }

    @C1128g8(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {426}, m = "writeData$datastore_core")
    /* renamed from: Ww$i */
    /* compiled from: SingleProcessDataStore.kt */
    public static final class i extends C1148h7 {
        public Ww a;

        /* renamed from: a  reason: collision with other field name */
        public File f667a;

        /* renamed from: a  reason: collision with other field name */
        public FileOutputStream f668a;

        /* renamed from: a  reason: collision with other field name */
        public /* synthetic */ Object f669a;
        public final /* synthetic */ Ww<T> b;

        /* renamed from: b  reason: collision with other field name */
        public FileOutputStream f670b;
        public int c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(Ww<T> ww, Continuation<? super i> continuation) {
            super(continuation);
            this.b = ww;
        }

        public final Object invokeSuspend(Object obj) {
            this.f669a = obj;
            this.c |= Integer.MIN_VALUE;
            return this.b.k(null, this);
        }
    }

    public Ww(C0171dq dqVar, List list, C0387x7 x7Var, CoroutineScope coroutineScope) {
        C0274mq mqVar = C0274mq.a;
        this.f646a = dqVar;
        this.f643a = mqVar;
        this.f648a = x7Var;
        this.f647a = coroutineScope;
        Object obj = eB.a;
        this.f641a = new Sx(obj == null ? r1.h : obj);
        this.f645a = C1472x5.b0(list);
        this.f639a = new Lw<>(coroutineScope, new Xw(this), Yw.a, new Zw(this, (Continuation<? super Zw>) null));
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object c(defpackage.Ww r8, defpackage.Ww.a.b r9, kotlin.coroutines.Continuation r10) {
        /*
            r8.getClass()
            boolean r0 = r10 instanceof defpackage.C0172dx
            if (r0 == 0) goto L_0x0016
            r0 = r10
            dx r0 = (defpackage.C0172dx) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0016
            int r1 = r1 - r2
            r0.c = r1
            goto L_0x001b
        L_0x0016:
            dx r0 = new dx
            r0.<init>(r8, r10)
        L_0x001b:
            java.lang.Object r10 = r0.f2876b
            v7 r1 = defpackage.C1438v7.COROUTINE_SUSPENDED
            int r2 = r0.c
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x004d
            if (r2 == r5) goto L_0x0041
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            goto L_0x0041
        L_0x002d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0035:
            N5 r8 = r0.a
            Ww r9 = r0.f2874a
            java.lang.Object r2 = r0.f2875a
            Ww$a$b r2 = (defpackage.Ww.a.b) r2
            defpackage.r1.R(r10)     // Catch:{ all -> 0x004a }
            goto L_0x0091
        L_0x0041:
            java.lang.Object r8 = r0.f2875a
            N5 r8 = (defpackage.N5) r8
            defpackage.r1.R(r10)     // Catch:{ all -> 0x004a }
            goto L_0x00c3
        L_0x004a:
            r9 = move-exception
            goto L_0x00bf
        L_0x004d:
            defpackage.r1.R(r10)
            N5<T> r10 = r9.a
            Sx r2 = r8.f641a     // Catch:{ all -> 0x00bc }
            java.lang.Object r2 = r2.b()     // Catch:{ all -> 0x00bc }
            Rx r2 = (defpackage.Rx) r2     // Catch:{ all -> 0x00bc }
            boolean r6 = r2 instanceof defpackage.V7     // Catch:{ all -> 0x00bc }
            if (r6 == 0) goto L_0x0072
            kotlin.jvm.functions.Function2<T, kotlin.coroutines.Continuation<? super T>, java.lang.Object> r2 = r9.f651a     // Catch:{ all -> 0x00bc }
            kotlin.coroutines.CoroutineContext r9 = r9.f650a     // Catch:{ all -> 0x00bc }
            r0.f2875a = r10     // Catch:{ all -> 0x00bc }
            r0.c = r5     // Catch:{ all -> 0x00bc }
            java.lang.Object r8 = r8.j(r0, r9, r2)     // Catch:{ all -> 0x00bc }
            if (r8 != r1) goto L_0x006e
            goto L_0x00d2
        L_0x006e:
            r7 = r10
            r10 = r8
            r8 = r7
            goto L_0x00c3
        L_0x0072:
            boolean r6 = r2 instanceof defpackage.ys     // Catch:{ all -> 0x00bc }
            if (r6 == 0) goto L_0x0077
            goto L_0x0079
        L_0x0077:
            boolean r5 = r2 instanceof defpackage.eB     // Catch:{ all -> 0x00bc }
        L_0x0079:
            if (r5 == 0) goto L_0x00ad
            Rx<T> r5 = r9.f649a     // Catch:{ all -> 0x00bc }
            if (r2 != r5) goto L_0x00a8
            r0.f2875a = r9     // Catch:{ all -> 0x00bc }
            r0.f2874a = r8     // Catch:{ all -> 0x00bc }
            r0.a = r10     // Catch:{ all -> 0x00bc }
            r0.c = r4     // Catch:{ all -> 0x00bc }
            java.lang.Object r2 = r8.f(r0)     // Catch:{ all -> 0x00bc }
            if (r2 != r1) goto L_0x008e
            goto L_0x00d2
        L_0x008e:
            r2 = r9
            r9 = r8
            r8 = r10
        L_0x0091:
            kotlin.jvm.functions.Function2<T, kotlin.coroutines.Continuation<? super T>, java.lang.Object> r10 = r2.f651a     // Catch:{ all -> 0x00a5 }
            kotlin.coroutines.CoroutineContext r2 = r2.f650a     // Catch:{ all -> 0x00a5 }
            r0.f2875a = r8     // Catch:{ all -> 0x00a5 }
            r4 = 0
            r0.f2874a = r4     // Catch:{ all -> 0x00a5 }
            r0.a = r4     // Catch:{ all -> 0x00a5 }
            r0.c = r3     // Catch:{ all -> 0x00a5 }
            java.lang.Object r10 = r9.j(r0, r2, r10)     // Catch:{ all -> 0x00a5 }
            if (r10 != r1) goto L_0x00c3
            goto L_0x00d2
        L_0x00a5:
            r9 = move-exception
            r10 = r8
            goto L_0x00be
        L_0x00a8:
            ys r2 = (defpackage.ys) r2     // Catch:{ all -> 0x00bc }
            java.lang.Throwable r8 = r2.a     // Catch:{ all -> 0x00bc }
            throw r8     // Catch:{ all -> 0x00bc }
        L_0x00ad:
            boolean r8 = r2 instanceof defpackage.C0248kc     // Catch:{ all -> 0x00bc }
            if (r8 == 0) goto L_0x00b6
            kc r2 = (defpackage.C0248kc) r2     // Catch:{ all -> 0x00bc }
            java.lang.Throwable r8 = r2.a     // Catch:{ all -> 0x00bc }
            throw r8     // Catch:{ all -> 0x00bc }
        L_0x00b6:
            V5 r8 = new V5     // Catch:{ all -> 0x00bc }
            r8.<init>()     // Catch:{ all -> 0x00bc }
            throw r8     // Catch:{ all -> 0x00bc }
        L_0x00bc:
            r8 = move-exception
            r9 = r8
        L_0x00be:
            r8 = r10
        L_0x00bf:
            Tt$a r10 = defpackage.r1.n(r9)
        L_0x00c3:
            java.lang.Throwable r9 = defpackage.C0698Tt.a(r10)
            if (r9 != 0) goto L_0x00cd
            r8.X(r10)
            goto L_0x00d0
        L_0x00cd:
            r8.f0(r9)
        L_0x00d0:
            kotlin.Unit r1 = kotlin.Unit.a
        L_0x00d2:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.Ww.c(Ww, Ww$a$b, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object a(Function2<? super T, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        Object S;
        C0617O5 o5 = new C0617O5((Job) null);
        this.f639a.a(new a.b(function2, o5, (Rx) this.f641a.b(), continuation.getContext()));
        do {
            S = o5.S();
            if (!(S instanceof C0449Af)) {
                if (!(S instanceof C0677S5)) {
                    return C1354qp.L0(S);
                }
                throw ((C0677S5) S).f3789a;
            }
        } while (o5.i0(S) < 0);
        k.a aVar = new k.a(r1.B(continuation), o5);
        aVar.s();
        aVar.i(new C1300o9(o5.W(new C0713Ut(aVar))));
        return aVar.r();
    }

    public final Flow<T> b() {
        return this.f640a;
    }

    public final File d() {
        return (File) this.f642a.getValue();
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ff A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object e(kotlin.coroutines.Continuation<? super kotlin.Unit> r14) {
        /*
            r13 = this;
            boolean r0 = r14 instanceof defpackage.Ww.c
            if (r0 == 0) goto L_0x0013
            r0 = r14
            Ww$c r0 = (defpackage.Ww.c) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.c = r1
            goto L_0x0018
        L_0x0013:
            Ww$c r0 = new Ww$c
            r0.<init>(r13, r14)
        L_0x0018:
            java.lang.Object r14 = r0.f657c
            v7 r1 = defpackage.C1438v7.COROUTINE_SUSPENDED
            int r2 = r0.c
            r3 = 0
            r4 = 3
            r5 = 2
            r6 = 1
            r7 = 0
            if (r2 == 0) goto L_0x0072
            if (r2 == r6) goto L_0x005d
            if (r2 == r5) goto L_0x0046
            if (r2 != r4) goto L_0x003e
            java.lang.Object r1 = r0.f656b
            kotlinx.coroutines.sync.Mutex r1 = (kotlinx.coroutines.sync.Mutex) r1
            java.io.Serializable r2 = r0.f653a
            Is r2 = (defpackage.C0546Is) r2
            java.lang.Object r4 = r0.f654a
            Ks r4 = (defpackage.C0571Ks) r4
            Ww r0 = r0.f652a
            defpackage.r1.R(r14)
            goto L_0x0103
        L_0x003e:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L_0x0046:
            java.util.Iterator r2 = r0.f655a
            Ww$d r8 = r0.a
            java.lang.Object r9 = r0.f656b
            Is r9 = (defpackage.C0546Is) r9
            java.io.Serializable r10 = r0.f653a
            Ks r10 = (defpackage.C0571Ks) r10
            java.lang.Object r11 = r0.f654a
            kotlinx.coroutines.sync.Mutex r11 = (kotlinx.coroutines.sync.Mutex) r11
            Ww r12 = r0.f652a
            defpackage.r1.R(r14)
            goto L_0x00c8
        L_0x005d:
            java.lang.Object r2 = r0.f656b
            Ks r2 = (defpackage.C0571Ks) r2
            java.io.Serializable r8 = r0.f653a
            Ks r8 = (defpackage.C0571Ks) r8
            java.lang.Object r9 = r0.f654a
            kotlinx.coroutines.sync.Mutex r9 = (kotlinx.coroutines.sync.Mutex) r9
            Ww r10 = r0.f652a
            defpackage.r1.R(r14)
            r11 = r9
            r12 = r10
            r10 = r8
            goto L_0x00b0
        L_0x0072:
            defpackage.r1.R(r14)
            Sx r14 = r13.f641a
            java.lang.Object r2 = r14.b()
            eB r8 = defpackage.eB.a
            boolean r2 = defpackage.C1177ig.a(r2, r8)
            if (r2 != 0) goto L_0x008e
            java.lang.Object r14 = r14.b()
            boolean r14 = r14 instanceof defpackage.ys
            if (r14 == 0) goto L_0x008c
            goto L_0x008e
        L_0x008c:
            r14 = r3
            goto L_0x008f
        L_0x008e:
            r14 = r6
        L_0x008f:
            if (r14 == 0) goto L_0x0124
            im r14 = new im
            r14.<init>(r3)
            Ks r2 = new Ks
            r2.<init>()
            r0.f652a = r13
            r0.f654a = r14
            r0.f653a = r2
            r0.f656b = r2
            r0.c = r6
            java.lang.Object r8 = r13.i(r0)
            if (r8 != r1) goto L_0x00ac
            return r1
        L_0x00ac:
            r12 = r13
            r11 = r14
            r10 = r2
            r14 = r8
        L_0x00b0:
            r2.a = r14
            Is r9 = new Is
            r9.<init>()
            Ww$d r8 = new Ww$d
            r8.<init>(r11, r9, r10, r12)
            java.util.List<? extends kotlin.jvm.functions.Function2<? super Tf<T>, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>> r14 = r12.f645a
            if (r14 != 0) goto L_0x00c2
        L_0x00c0:
            r2 = r9
            goto L_0x00e9
        L_0x00c2:
            java.lang.Iterable r14 = (java.lang.Iterable) r14
            java.util.Iterator r2 = r14.iterator()
        L_0x00c8:
            boolean r14 = r2.hasNext()
            if (r14 == 0) goto L_0x00c0
            java.lang.Object r14 = r2.next()
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            r0.f652a = r12
            r0.f654a = r11
            r0.f653a = r10
            r0.f656b = r9
            r0.a = r8
            r0.f655a = r2
            r0.c = r5
            java.lang.Object r14 = r14.invoke(r8, r0)
            if (r14 != r1) goto L_0x00c8
            return r1
        L_0x00e9:
            r12.f645a = r7
            r0.f652a = r12
            r0.f654a = r10
            r0.f653a = r2
            r0.f656b = r11
            r0.a = r7
            r0.f655a = r7
            r0.c = r4
            java.lang.Object r14 = r11.c(r0)
            if (r14 != r1) goto L_0x0100
            return r1
        L_0x0100:
            r4 = r10
            r1 = r11
            r0 = r12
        L_0x0103:
            r2.a = r6     // Catch:{ all -> 0x011f }
            kotlin.Unit r14 = kotlin.Unit.a     // Catch:{ all -> 0x011f }
            r1.b(r7)
            Sx r14 = r0.f641a
            V7 r0 = new V7
            T r1 = r4.a
            if (r1 == 0) goto L_0x0116
            int r3 = r1.hashCode()
        L_0x0116:
            r0.<init>(r1, r3)
            r14.a(r0)
            kotlin.Unit r14 = kotlin.Unit.a
            return r14
        L_0x011f:
            r14 = move-exception
            r1.b(r7)
            throw r14
        L_0x0124:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "Check failed."
            java.lang.String r0 = r0.toString()
            r14.<init>(r0)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.Ww.e(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object f(kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof defpackage.Ww.e
            if (r0 == 0) goto L_0x0013
            r0 = r5
            Ww$e r0 = (defpackage.Ww.e) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.c = r1
            goto L_0x0018
        L_0x0013:
            Ww$e r0 = new Ww$e
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.f661a
            v7 r1 = defpackage.C1438v7.COROUTINE_SUSPENDED
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L_0x0033
            if (r2 != r3) goto L_0x002b
            Ww r0 = r0.a
            defpackage.r1.R(r5)     // Catch:{ all -> 0x0029 }
            goto L_0x0041
        L_0x0029:
            r5 = move-exception
            goto L_0x0046
        L_0x002b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0033:
            defpackage.r1.R(r5)
            r0.a = r4     // Catch:{ all -> 0x0044 }
            r0.c = r3     // Catch:{ all -> 0x0044 }
            java.lang.Object r5 = r4.e(r0)     // Catch:{ all -> 0x0044 }
            if (r5 != r1) goto L_0x0041
            return r1
        L_0x0041:
            kotlin.Unit r5 = kotlin.Unit.a
            return r5
        L_0x0044:
            r5 = move-exception
            r0 = r4
        L_0x0046:
            Sx r0 = r0.f641a
            ys r1 = new ys
            r1.<init>(r5)
            r0.a(r1)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.Ww.f(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object g(kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof defpackage.Ww.f
            if (r0 == 0) goto L_0x0013
            r0 = r5
            Ww$f r0 = (defpackage.Ww.f) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.c = r1
            goto L_0x0018
        L_0x0013:
            Ww$f r0 = new Ww$f
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.f662a
            v7 r1 = defpackage.C1438v7.COROUTINE_SUSPENDED
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L_0x0033
            if (r2 != r3) goto L_0x002b
            Ww r0 = r0.a
            defpackage.r1.R(r5)     // Catch:{ all -> 0x0029 }
            goto L_0x004d
        L_0x0029:
            r5 = move-exception
            goto L_0x0043
        L_0x002b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0033:
            defpackage.r1.R(r5)
            r0.a = r4     // Catch:{ all -> 0x0041 }
            r0.c = r3     // Catch:{ all -> 0x0041 }
            java.lang.Object r5 = r4.e(r0)     // Catch:{ all -> 0x0041 }
            if (r5 != r1) goto L_0x004d
            return r1
        L_0x0041:
            r5 = move-exception
            r0 = r4
        L_0x0043:
            Sx r0 = r0.f641a
            ys r1 = new ys
            r1.<init>(r5)
            r0.a(r1)
        L_0x004d:
            kotlin.Unit r5 = kotlin.Unit.a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.Ww.g(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0058, code lost:
        r5 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x005f, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        defpackage.C1354qp.y(r1, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0063, code lost:
        throw r2;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:24:0x0054, B:30:0x005e] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object h(kotlin.coroutines.Continuation<? super T> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof defpackage.Ww.g
            if (r0 == 0) goto L_0x0013
            r0 = r5
            Ww$g r0 = (defpackage.Ww.g) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.c = r1
            goto L_0x0018
        L_0x0013:
            Ww$g r0 = new Ww$g
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.f664a
            v7 r1 = defpackage.C1438v7.COROUTINE_SUSPENDED
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.io.FileInputStream r1 = r0.f663a
            Ww r0 = r0.a
            defpackage.r1.R(r5)     // Catch:{ all -> 0x002b }
            goto L_0x0053
        L_0x002b:
            r5 = move-exception
            goto L_0x005e
        L_0x002d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0035:
            defpackage.r1.R(r5)
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0064 }
            java.io.File r2 = r4.d()     // Catch:{ FileNotFoundException -> 0x0064 }
            r5.<init>(r2)     // Catch:{ FileNotFoundException -> 0x0064 }
            hw<T> r2 = r4.f643a     // Catch:{ all -> 0x005a }
            r0.a = r4     // Catch:{ all -> 0x005a }
            r0.f663a = r5     // Catch:{ all -> 0x005a }
            r0.c = r3     // Catch:{ all -> 0x005a }
            androidx.datastore.preferences.core.MutablePreferences r0 = r2.a(r5)     // Catch:{ all -> 0x005a }
            if (r0 != r1) goto L_0x0050
            return r1
        L_0x0050:
            r1 = r5
            r5 = r0
            r0 = r4
        L_0x0053:
            r2 = 0
            defpackage.C1354qp.y(r1, r2)     // Catch:{ FileNotFoundException -> 0x0058 }
            return r5
        L_0x0058:
            r5 = move-exception
            goto L_0x0066
        L_0x005a:
            r0 = move-exception
            r1 = r5
            r5 = r0
            r0 = r4
        L_0x005e:
            throw r5     // Catch:{ all -> 0x005f }
        L_0x005f:
            r2 = move-exception
            defpackage.C1354qp.y(r1, r5)     // Catch:{ FileNotFoundException -> 0x0058 }
            throw r2     // Catch:{ FileNotFoundException -> 0x0058 }
        L_0x0064:
            r5 = move-exception
            r0 = r4
        L_0x0066:
            java.io.File r1 = r0.d()
            boolean r1 = r1.exists()
            if (r1 != 0) goto L_0x0077
            hw<T> r5 = r0.f643a
            androidx.datastore.preferences.core.MutablePreferences r5 = r5.c()
            return r5
        L_0x0077:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.Ww.h(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0083 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object i(kotlin.coroutines.Continuation<? super T> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof defpackage.Ww.h
            if (r0 == 0) goto L_0x0013
            r0 = r8
            Ww$h r0 = (defpackage.Ww.h) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.c = r1
            goto L_0x0018
        L_0x0013:
            Ww$h r0 = new Ww$h
            r0.<init>(r7, r8)
        L_0x0018:
            java.lang.Object r8 = r0.f666c
            v7 r1 = defpackage.C1438v7.COROUTINE_SUSPENDED
            int r2 = r0.c
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0053
            if (r2 == r5) goto L_0x0049
            if (r2 == r4) goto L_0x003d
            if (r2 != r3) goto L_0x0035
            java.lang.Object r1 = r0.b
            java.lang.Object r0 = r0.f665a
            androidx.datastore.core.CorruptionException r0 = (androidx.datastore.core.CorruptionException) r0
            defpackage.r1.R(r8)     // Catch:{ IOException -> 0x0033 }
            goto L_0x0085
        L_0x0033:
            r8 = move-exception
            goto L_0x0088
        L_0x0035:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x003d:
            java.lang.Object r2 = r0.b
            androidx.datastore.core.CorruptionException r2 = (androidx.datastore.core.CorruptionException) r2
            java.lang.Object r4 = r0.f665a
            Ww r4 = (defpackage.Ww) r4
            defpackage.r1.R(r8)
            goto L_0x0077
        L_0x0049:
            java.lang.Object r2 = r0.f665a
            Ww r2 = (defpackage.Ww) r2
            defpackage.r1.R(r8)     // Catch:{ CorruptionException -> 0x0051 }
            goto L_0x0061
        L_0x0051:
            r8 = move-exception
            goto L_0x0064
        L_0x0053:
            defpackage.r1.R(r8)
            r0.f665a = r7     // Catch:{ CorruptionException -> 0x0062 }
            r0.c = r5     // Catch:{ CorruptionException -> 0x0062 }
            java.lang.Object r8 = r7.h(r0)     // Catch:{ CorruptionException -> 0x0062 }
            if (r8 != r1) goto L_0x0061
            return r1
        L_0x0061:
            return r8
        L_0x0062:
            r8 = move-exception
            r2 = r7
        L_0x0064:
            x7<T> r5 = r2.f648a
            r0.f665a = r2
            r0.b = r8
            r0.c = r4
            java.lang.Object r4 = r5.b(r8)
            if (r4 != r1) goto L_0x0073
            return r1
        L_0x0073:
            r6 = r2
            r2 = r8
            r8 = r4
            r4 = r6
        L_0x0077:
            r0.f665a = r2     // Catch:{ IOException -> 0x0086 }
            r0.b = r8     // Catch:{ IOException -> 0x0086 }
            r0.c = r3     // Catch:{ IOException -> 0x0086 }
            java.lang.Object r0 = r4.k(r8, r0)     // Catch:{ IOException -> 0x0086 }
            if (r0 != r1) goto L_0x0084
            return r1
        L_0x0084:
            r1 = r8
        L_0x0085:
            return r1
        L_0x0086:
            r8 = move-exception
            r0 = r2
        L_0x0088:
            defpackage.C1354qp.g(r0, r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.Ww.i(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object j(kotlin.coroutines.Continuation r8, kotlin.coroutines.CoroutineContext r9, kotlin.jvm.functions.Function2 r10) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof defpackage.C0197fx
            if (r0 == 0) goto L_0x0013
            r0 = r8
            fx r0 = (defpackage.C0197fx) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.c = r1
            goto L_0x0018
        L_0x0013:
            fx r0 = new fx
            r0.<init>(r7, r8)
        L_0x0018:
            java.lang.Object r8 = r0.f2960c
            v7 r1 = defpackage.C1438v7.COROUTINE_SUSPENDED
            int r2 = r0.c
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0043
            if (r2 == r5) goto L_0x0037
            if (r2 != r4) goto L_0x002f
            java.lang.Object r9 = r0.f2958a
            Ww r10 = r0.a
            defpackage.r1.R(r8)
            goto L_0x0086
        L_0x002f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0037:
            java.lang.Object r9 = r0.f2959b
            java.lang.Object r10 = r0.f2958a
            V7 r10 = (defpackage.V7) r10
            Ww r2 = r0.a
            defpackage.r1.R(r8)
            goto L_0x006b
        L_0x0043:
            defpackage.r1.R(r8)
            Sx r8 = r7.f641a
            java.lang.Object r8 = r8.b()
            V7 r8 = (defpackage.V7) r8
            r8.a()
            gx r2 = new gx
            T r6 = r8.f587a
            r2.<init>(r6, r3, r10)
            r0.a = r7
            r0.f2958a = r8
            r0.f2959b = r6
            r0.c = r5
            java.lang.Object r9 = defpackage.C1354qp.N0(r0, r9, r2)
            if (r9 != r1) goto L_0x0067
            return r1
        L_0x0067:
            r2 = r7
            r10 = r8
            r8 = r9
            r9 = r6
        L_0x006b:
            r10.a()
            boolean r10 = defpackage.C1177ig.a(r9, r8)
            if (r10 == 0) goto L_0x0075
            goto L_0x0098
        L_0x0075:
            r0.a = r2
            r0.f2958a = r8
            r0.f2959b = r3
            r0.c = r4
            java.lang.Object r9 = r2.k(r8, r0)
            if (r9 != r1) goto L_0x0084
            return r1
        L_0x0084:
            r9 = r8
            r10 = r2
        L_0x0086:
            Sx r8 = r10.f641a
            V7 r10 = new V7
            if (r9 == 0) goto L_0x0091
            int r0 = r9.hashCode()
            goto L_0x0092
        L_0x0091:
            r0 = 0
        L_0x0092:
            r10.<init>(r9, r0)
            r8.a(r10)
        L_0x0098:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.Ww.j(kotlin.coroutines.Continuation, kotlin.coroutines.CoroutineContext, kotlin.jvm.functions.Function2):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a4 A[SYNTHETIC, Splitter:B:35:0x00a4] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object k(T r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r7 = this;
            java.lang.String r0 = "Unable to rename "
            boolean r1 = r9 instanceof defpackage.Ww.i
            if (r1 == 0) goto L_0x0015
            r1 = r9
            Ww$i r1 = (defpackage.Ww.i) r1
            int r2 = r1.c
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0015
            int r2 = r2 - r3
            r1.c = r2
            goto L_0x001a
        L_0x0015:
            Ww$i r1 = new Ww$i
            r1.<init>(r7, r9)
        L_0x001a:
            java.lang.Object r9 = r1.f669a
            v7 r2 = defpackage.C1438v7.COROUTINE_SUSPENDED
            int r3 = r1.c
            r4 = 1
            if (r3 == 0) goto L_0x003c
            if (r3 != r4) goto L_0x0034
            java.io.FileOutputStream r8 = r1.f670b
            java.io.FileOutputStream r2 = r1.f668a
            java.io.File r3 = r1.f667a
            Ww r1 = r1.a
            defpackage.r1.R(r9)     // Catch:{ all -> 0x0031 }
            goto L_0x008a
        L_0x0031:
            r8 = move-exception
            goto L_0x00bd
        L_0x0034:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x003c:
            defpackage.r1.R(r9)
            java.io.File r9 = r7.d()
            java.io.File r3 = r9.getCanonicalFile()
            java.io.File r3 = r3.getParentFile()
            if (r3 != 0) goto L_0x004e
            goto L_0x0057
        L_0x004e:
            r3.mkdirs()
            boolean r3 = r3.isDirectory()
            if (r3 == 0) goto L_0x00d0
        L_0x0057:
            java.io.File r3 = new java.io.File
            java.io.File r9 = r7.d()
            java.lang.String r9 = r9.getAbsolutePath()
            java.lang.String r5 = r7.f644a
            java.lang.String r9 = defpackage.C1177ig.j(r5, r9)
            r3.<init>(r9)
            java.io.FileOutputStream r9 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x00bb }
            r9.<init>(r3)     // Catch:{ IOException -> 0x00bb }
            hw<T> r5 = r7.f643a     // Catch:{ all -> 0x00bf }
            Ww$b r6 = new Ww$b     // Catch:{ all -> 0x00bf }
            r6.<init>(r9)     // Catch:{ all -> 0x00bf }
            r1.a = r7     // Catch:{ all -> 0x00bf }
            r1.f667a = r3     // Catch:{ all -> 0x00bf }
            r1.f668a = r9     // Catch:{ all -> 0x00bf }
            r1.f670b = r9     // Catch:{ all -> 0x00bf }
            r1.c = r4     // Catch:{ all -> 0x00bf }
            kotlin.Unit r8 = r5.b(r8, r6)     // Catch:{ all -> 0x00bf }
            if (r8 != r2) goto L_0x0087
            return r2
        L_0x0087:
            r1 = r7
            r8 = r9
            r2 = r8
        L_0x008a:
            java.io.FileDescriptor r8 = r8.getFD()     // Catch:{ all -> 0x0031 }
            r8.sync()     // Catch:{ all -> 0x0031 }
            kotlin.Unit r8 = kotlin.Unit.a     // Catch:{ all -> 0x0031 }
            r8 = 0
            defpackage.C1354qp.y(r2, r8)     // Catch:{ IOException -> 0x00bb }
            java.io.File r8 = r1.d()     // Catch:{ IOException -> 0x00bb }
            boolean r8 = r3.renameTo(r8)     // Catch:{ IOException -> 0x00bb }
            if (r8 == 0) goto L_0x00a4
            kotlin.Unit r8 = kotlin.Unit.a
            return r8
        L_0x00a4:
            java.io.IOException r8 = new java.io.IOException     // Catch:{ IOException -> 0x00bb }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00bb }
            r9.<init>(r0)     // Catch:{ IOException -> 0x00bb }
            r9.append(r3)     // Catch:{ IOException -> 0x00bb }
            java.lang.String r0 = ".This likely means that there are multiple instances of DataStore for this file. Ensure that you are only creating a single instance of datastore for this file."
            r9.append(r0)     // Catch:{ IOException -> 0x00bb }
            java.lang.String r9 = r9.toString()     // Catch:{ IOException -> 0x00bb }
            r8.<init>(r9)     // Catch:{ IOException -> 0x00bb }
            throw r8     // Catch:{ IOException -> 0x00bb }
        L_0x00bb:
            r8 = move-exception
            goto L_0x00c6
        L_0x00bd:
            r9 = r2
            goto L_0x00c0
        L_0x00bf:
            r8 = move-exception
        L_0x00c0:
            throw r8     // Catch:{ all -> 0x00c1 }
        L_0x00c1:
            r0 = move-exception
            defpackage.C1354qp.y(r9, r8)     // Catch:{ IOException -> 0x00bb }
            throw r0     // Catch:{ IOException -> 0x00bb }
        L_0x00c6:
            boolean r9 = r3.exists()
            if (r9 == 0) goto L_0x00cf
            r3.delete()
        L_0x00cf:
            throw r8
        L_0x00d0:
            java.io.IOException r8 = new java.io.IOException
            java.lang.String r0 = "Unable to create parent directories of "
            java.lang.String r9 = defpackage.C1177ig.j(r9, r0)
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.Ww.k(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
