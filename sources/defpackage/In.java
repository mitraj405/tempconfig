package defpackage;

import androidx.activity.OnBackPressedDispatcher;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* renamed from: In  reason: default package */
/* compiled from: OnBackPressedDispatcher.kt */
public final /* synthetic */ class In extends C1068de implements Function0<Unit> {
    public In(OnBackPressedDispatcher onBackPressedDispatcher) {
        super(0, onBackPressedDispatcher, OnBackPressedDispatcher.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", 0);
    }

    public final Object invoke() {
        ((OnBackPressedDispatcher) this.receiver).e();
        return Unit.a;
    }
}
