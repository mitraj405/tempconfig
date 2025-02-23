package defpackage;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

@C1128g8(c = "androidx.core.view.ViewKt$allViews$1", f = "View.kt", l = {409, 411}, m = "invokeSuspend")
/* renamed from: xC  reason: default package and case insensitive filesystem */
/* compiled from: View.kt */
public final class C0389xC extends C0684St implements Function2<C1078dw<? super View>, Continuation<? super Unit>, Object> {
    public final /* synthetic */ View a;

    /* renamed from: a  reason: collision with other field name */
    public /* synthetic */ Object f3409a;
    public int d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0389xC(View view, Continuation<? super C0389xC> continuation) {
        super(continuation);
        this.a = view;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        C0389xC xCVar = new C0389xC(this.a, continuation);
        xCVar.f3409a = obj;
        return xCVar;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((C0389xC) create((C1078dw) obj, (Continuation) obj2)).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        C1438v7 v7Var = C1438v7.COROUTINE_SUSPENDED;
        int i = this.d;
        View view = this.a;
        if (i != 0) {
            if (i == 1) {
                C1078dw dwVar = (C1078dw) this.f3409a;
                r1.R(obj);
                if (view instanceof ViewGroup) {
                    this.f3409a = null;
                    this.d = 2;
                    dwVar.getClass();
                    Object b = dwVar.b(new LA(new C0324sC((ViewGroup) view), C0313rC.a), this);
                    if (b != v7Var) {
                        b = Unit.a;
                    }
                    if (b == v7Var) {
                        return v7Var;
                    }
                }
            } else if (i == 2) {
                r1.R(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.a;
        }
        r1.R(obj);
        C1078dw dwVar2 = (C1078dw) this.f3409a;
        this.f3409a = dwVar2;
        this.d = 1;
        dwVar2.a(view, this);
        return v7Var;
    }
}
