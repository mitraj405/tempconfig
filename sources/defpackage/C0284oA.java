package defpackage;

import com.google.common.util.concurrent.ListenableFuture;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.d;

/* renamed from: oA  reason: default package and case insensitive filesystem */
/* compiled from: TopicsManagerFutures.kt */
public abstract class C0284oA {

    /* renamed from: oA$a */
    /* compiled from: TopicsManagerFutures.kt */
    public static final class a extends C0284oA {
        public final v3 a;

        @C1128g8(c = "androidx.privacysandbox.ads.adservices.java.topics.TopicsManagerFutures$Api33Ext4JavaImpl$getTopicsAsync$1", f = "TopicsManagerFutures.kt", l = {56}, m = "invokeSuspend")
        /* renamed from: oA$a$a  reason: collision with other inner class name */
        /* compiled from: TopicsManagerFutures.kt */
        public static final class C0032a extends Py implements Function2<CoroutineScope, Continuation<? super C0280ne>, Object> {
            public final /* synthetic */ C0272me a;

            /* renamed from: a  reason: collision with other field name */
            public final /* synthetic */ a f3137a;
            public int c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0032a(a aVar, C0272me meVar, Continuation<? super C0032a> continuation) {
                super(2, continuation);
                this.f3137a = aVar;
                this.a = meVar;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C0032a(this.f3137a, this.a, continuation);
            }

            public final Object invoke(Object obj, Object obj2) {
                return ((C0032a) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.a);
            }

            public final Object invokeSuspend(Object obj) {
                C1438v7 v7Var = C1438v7.COROUTINE_SUSPENDED;
                int i = this.c;
                if (i == 0) {
                    r1.R(obj);
                    v3 v3Var = this.f3137a.a;
                    this.c = 1;
                    obj = v3Var.b(this.a, this);
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

        public a(pA pAVar) {
            this.a = pAVar;
        }

        public ListenableFuture<C0280ne> a(C0272me meVar) {
            C1177ig.f(meVar, "request");
            C1474x8 x8Var = C1213k9.f5544a;
            return r1.f(C1354qp.i(d.a(C0724Vj.a), new C0032a(this, meVar, (Continuation<? super C0032a>) null)));
        }
    }
}
