package defpackage;

import androidx.activity.OnBackPressedDispatcher;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* renamed from: Jn  reason: default package */
/* compiled from: OnBackPressedDispatcher.kt */
public final /* synthetic */ class Jn extends C1068de implements Function0<Unit> {
    public Jn(Object obj) {
        super(0, obj, OnBackPressedDispatcher.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", 0);
    }

    public final Object invoke() {
        ((OnBackPressedDispatcher) this.receiver).e();
        return Unit.a;
    }
}
