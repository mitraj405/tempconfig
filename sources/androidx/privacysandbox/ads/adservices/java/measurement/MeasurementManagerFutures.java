package androidx.privacysandbox.ads.adservices.java.measurement;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.view.InputEvent;
import com.google.common.util.concurrent.ListenableFuture;
import defpackage.Qk;
import in.juspay.hyper.constants.LogCategory;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.d;

/* compiled from: MeasurementManagerFutures.kt */
public abstract class MeasurementManagerFutures {

    /* compiled from: MeasurementManagerFutures.kt */
    public static final class a extends MeasurementManagerFutures {
        public final Qk a;

        @C1128g8(c = "androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures$Api33Ext5JavaImpl$getMeasurementApiStatusAsync$1", f = "MeasurementManagerFutures.kt", l = {169}, m = "invokeSuspend")
        /* renamed from: androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures$a$a  reason: collision with other inner class name */
        /* compiled from: MeasurementManagerFutures.kt */
        public static final class C0022a extends Py implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
            public final /* synthetic */ a a;
            public int c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0022a(a aVar, Continuation<? super C0022a> continuation) {
                super(2, continuation);
                this.a = aVar;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C0022a(this.a, continuation);
            }

            public final Object invoke(Object obj, Object obj2) {
                return ((C0022a) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.a);
            }

            public final Object invokeSuspend(Object obj) {
                C1438v7 v7Var = C1438v7.COROUTINE_SUSPENDED;
                int i = this.c;
                if (i == 0) {
                    r1.R(obj);
                    Qk qk = this.a.a;
                    this.c = 1;
                    obj = qk.a(this);
                    if (obj == v7Var) {
                        return v7Var;
                    }
                } else if (i == 1) {
                    r1.R(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return obj;
            }
        }

        @C1128g8(c = "androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures$Api33Ext5JavaImpl$registerSourceAsync$1", f = "MeasurementManagerFutures.kt", l = {133}, m = "invokeSuspend")
        /* compiled from: MeasurementManagerFutures.kt */
        public static final class b extends Py implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            public final /* synthetic */ Uri a;

            /* renamed from: a  reason: collision with other field name */
            public final /* synthetic */ InputEvent f2257a;

            /* renamed from: a  reason: collision with other field name */
            public final /* synthetic */ a f2258a;
            public int c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(a aVar, Uri uri, InputEvent inputEvent, Continuation<? super b> continuation) {
                super(2, continuation);
                this.f2258a = aVar;
                this.a = uri;
                this.f2257a = inputEvent;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new b(this.f2258a, this.a, this.f2257a, continuation);
            }

            public final Object invoke(Object obj, Object obj2) {
                return ((b) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.a);
            }

            public final Object invokeSuspend(Object obj) {
                C1438v7 v7Var = C1438v7.COROUTINE_SUSPENDED;
                int i = this.c;
                if (i == 0) {
                    r1.R(obj);
                    Qk qk = this.f2258a.a;
                    this.c = 1;
                    if (qk.b(this.a, this.f2257a, this) == v7Var) {
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

        @C1128g8(c = "androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures$Api33Ext5JavaImpl$registerTriggerAsync$1", f = "MeasurementManagerFutures.kt", l = {141}, m = "invokeSuspend")
        /* compiled from: MeasurementManagerFutures.kt */
        public static final class c extends Py implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            public final /* synthetic */ Uri a;

            /* renamed from: a  reason: collision with other field name */
            public final /* synthetic */ a f2259a;
            public int c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public c(a aVar, Uri uri, Continuation<? super c> continuation) {
                super(2, continuation);
                this.f2259a = aVar;
                this.a = uri;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new c(this.f2259a, this.a, continuation);
            }

            public final Object invoke(Object obj, Object obj2) {
                return ((c) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.a);
            }

            public final Object invokeSuspend(Object obj) {
                C1438v7 v7Var = C1438v7.COROUTINE_SUSPENDED;
                int i = this.c;
                if (i == 0) {
                    r1.R(obj);
                    Qk qk = this.f2259a.a;
                    this.c = 1;
                    if (qk.c(this.a, this) == v7Var) {
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

        public a(Qk.a aVar) {
            this.a = aVar;
        }

        public ListenableFuture<Integer> b() {
            return r1.f(C1354qp.i(d.a(C1213k9.f5544a), new C0022a(this, (Continuation<? super C0022a>) null)));
        }

        public ListenableFuture<Unit> c(Uri uri, InputEvent inputEvent) {
            C1177ig.f(uri, "attributionSource");
            return r1.f(C1354qp.i(d.a(C1213k9.f5544a), new b(this, uri, inputEvent, (Continuation<? super b>) null)));
        }

        public ListenableFuture<Unit> d(Uri uri) {
            C1177ig.f(uri, "trigger");
            return r1.f(C1354qp.i(d.a(C1213k9.f5544a), new c(this, uri, (Continuation<? super c>) null)));
        }

        public ListenableFuture<Unit> e(G8 g8) {
            C1177ig.f(g8, "deletionRequest");
            throw null;
        }

        public ListenableFuture<Unit> f(C0339tD tDVar) {
            C1177ig.f(tDVar, "request");
            throw null;
        }

        public ListenableFuture<Unit> g(C0351uD uDVar) {
            C1177ig.f(uDVar, "request");
            throw null;
        }
    }

    public static final a a(Context context) {
        int i;
        Qk.a aVar;
        C1177ig.f(context, LogCategory.CONTEXT);
        int i2 = Build.VERSION.SDK_INT;
        W w = W.a;
        if (i2 >= 30) {
            w.a();
        }
        if (i2 >= 30) {
            i = w.a();
        } else {
            i = 0;
        }
        if (i >= 5) {
            aVar = new Qk.a(context);
        } else {
            aVar = null;
        }
        if (aVar != null) {
            return new a(aVar);
        }
        return null;
    }

    public abstract ListenableFuture<Integer> b();

    public abstract ListenableFuture<Unit> c(Uri uri, InputEvent inputEvent);

    public abstract ListenableFuture<Unit> d(Uri uri);
}
