package defpackage;

import android.adservices.measurement.DeletionRequest;
import android.adservices.measurement.MeasurementManager;
import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.view.InputEvent;
import in.juspay.hyper.constants.LogCategory;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.c;

/* renamed from: Qk  reason: default package */
/* compiled from: MeasurementManager.kt */
public abstract class Qk {

    @SuppressLint({"NewApi", "ClassVerificationFailure"})
    /* renamed from: Qk$a */
    /* compiled from: MeasurementManager.kt */
    public static final class a extends Qk {
        public final MeasurementManager a;

        public a(Context context) {
            C1177ig.f(context, LogCategory.CONTEXT);
            Object systemService = context.getSystemService(MeasurementManager.class);
            C1177ig.e(systemService, "context.getSystemService…:class.java\n            )");
            this.a = (MeasurementManager) systemService;
        }

        public Object a(Continuation<? super Integer> continuation) {
            c cVar = new c(1, r1.B(continuation));
            cVar.s();
            this.a.getMeasurementApiStatus(new Ok(0), C1354qp.h(cVar));
            Object r = cVar.r();
            if (r == C1438v7.COROUTINE_SUSPENDED) {
                C1354qp.j0(continuation);
            }
            return r;
        }

        public Object b(Uri uri, InputEvent inputEvent, Continuation<? super Unit> continuation) {
            c cVar = new c(1, r1.B(continuation));
            cVar.s();
            this.a.registerSource(uri, inputEvent, new Ok(1), C1354qp.h(cVar));
            Object r = cVar.r();
            C1438v7 v7Var = C1438v7.COROUTINE_SUSPENDED;
            if (r == v7Var) {
                C1354qp.j0(continuation);
            }
            if (r == v7Var) {
                return r;
            }
            return Unit.a;
        }

        public Object c(Uri uri, Continuation<? super Unit> continuation) {
            c cVar = new c(1, r1.B(continuation));
            cVar.s();
            this.a.registerTrigger(uri, new E1(1), C1354qp.h(cVar));
            Object r = cVar.r();
            C1438v7 v7Var = C1438v7.COROUTINE_SUSPENDED;
            if (r == v7Var) {
                C1354qp.j0(continuation);
            }
            if (r == v7Var) {
                return r;
            }
            return Unit.a;
        }

        public Object d(G8 g8, Continuation<? super Unit> continuation) {
            new c(1, r1.B(continuation)).s();
            new DeletionRequest.Builder();
            throw null;
        }

        public Object e(C0339tD tDVar, Continuation<? super Unit> continuation) {
            new c(1, r1.B(continuation)).s();
            throw null;
        }

        public Object f(C0351uD uDVar, Continuation<? super Unit> continuation) {
            new c(1, r1.B(continuation)).s();
            throw null;
        }
    }

    public abstract Object a(Continuation<? super Integer> continuation);

    public abstract Object b(Uri uri, InputEvent inputEvent, Continuation<? super Unit> continuation);

    public abstract Object c(Uri uri, Continuation<? super Unit> continuation);
}
