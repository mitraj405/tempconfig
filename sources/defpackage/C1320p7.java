package defpackage;

import defpackage.C1171i7;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.f;

/* renamed from: p7  reason: default package and case insensitive filesystem */
/* compiled from: CoroutineContext.kt */
public final class C1320p7 {

    /* renamed from: p7$a */
    /* compiled from: CoroutineContext.kt */
    public static final class a extends C0595Mh implements Function2<CoroutineContext, CoroutineContext.b, CoroutineContext> {
        public static final a a = new a();

        public a() {
            super(2);
        }

        public final Object invoke(Object obj, Object obj2) {
            CoroutineContext coroutineContext = (CoroutineContext) obj;
            CoroutineContext.b bVar = (CoroutineContext.b) obj2;
            if (bVar instanceof C1254m7) {
                return coroutineContext.j(((C1254m7) bVar).J());
            }
            return coroutineContext.j(bVar);
        }
    }

    /* renamed from: p7$b */
    /* compiled from: CoroutineContext.kt */
    public static final class b extends C0595Mh implements Function2<CoroutineContext, CoroutineContext.b, CoroutineContext> {
        public final /* synthetic */ C0571Ks<CoroutineContext> a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ boolean f6889a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(C0571Ks<CoroutineContext> ks, boolean z) {
            super(2);
            this.a = ks;
            this.f6889a = z;
        }

        public final Object invoke(Object obj, Object obj2) {
            CoroutineContext coroutineContext = (CoroutineContext) obj;
            CoroutineContext.b bVar = (CoroutineContext.b) obj2;
            if (!(bVar instanceof C1254m7)) {
                return coroutineContext.j(bVar);
            }
            C0571Ks<CoroutineContext> ks = this.a;
            if (((CoroutineContext) ks.a).b(bVar.Z()) == null) {
                C1254m7 m7Var = (C1254m7) bVar;
                if (this.f6889a) {
                    m7Var = m7Var.J();
                }
                return coroutineContext.j(m7Var);
            }
            ks.a = ((CoroutineContext) ks.a).l(bVar.Z());
            return coroutineContext.j(((C1254m7) bVar).E());
        }
    }

    public static final CoroutineContext a(CoroutineContext coroutineContext, CoroutineContext coroutineContext2, boolean z) {
        Boolean bool = Boolean.FALSE;
        C1344q7 q7Var = C1344q7.a;
        boolean booleanValue = ((Boolean) coroutineContext.C(bool, q7Var)).booleanValue();
        boolean booleanValue2 = ((Boolean) coroutineContext2.C(bool, q7Var)).booleanValue();
        if (!booleanValue && !booleanValue2) {
            return coroutineContext.j(coroutineContext2);
        }
        C0571Ks ks = new C0571Ks();
        ks.a = coroutineContext2;
        C1440va vaVar = C1440va.a;
        CoroutineContext coroutineContext3 = (CoroutineContext) coroutineContext.C(vaVar, new b(ks, z));
        if (booleanValue2) {
            ks.a = ((CoroutineContext) ks.a).C(vaVar, a.a);
        }
        return coroutineContext3.j((CoroutineContext) ks.a);
    }

    public static final CoroutineContext b(CoroutineScope coroutineScope, CoroutineContext coroutineContext) {
        CoroutineContext a2 = a(coroutineScope.r(), coroutineContext, true);
        C1474x8 x8Var = C1213k9.f5544a;
        if (a2 == x8Var || a2.b(C1171i7.a.a) != null) {
            return a2;
        }
        return a2.j(x8Var);
    }

    public static final C1129gB<?> c(Continuation<?> continuation, CoroutineContext coroutineContext, Object obj) {
        boolean z;
        C1129gB<?> gBVar = null;
        if (!(continuation instanceof CoroutineStackFrame)) {
            return null;
        }
        if (coroutineContext.b(C1151hB.a) != null) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return null;
        }
        CoroutineStackFrame coroutineStackFrame = (CoroutineStackFrame) continuation;
        while (true) {
            if (!(coroutineStackFrame instanceof f) && (coroutineStackFrame = coroutineStackFrame.getCallerFrame()) != null) {
                if (coroutineStackFrame instanceof C1129gB) {
                    gBVar = (C1129gB) coroutineStackFrame;
                    break;
                }
            } else {
                break;
            }
        }
        if (gBVar != null) {
            gBVar.s0(coroutineContext, obj);
        }
        return gBVar;
    }
}
