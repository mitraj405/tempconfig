package defpackage;

import androidx.activity.OnBackPressedDispatcher;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* renamed from: En  reason: default package */
/* compiled from: OnBackPressedDispatcher.kt */
public final class En extends C0595Mh implements Function0<Unit> {
    public final /* synthetic */ OnBackPressedDispatcher a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public En(OnBackPressedDispatcher onBackPressedDispatcher) {
        super(0);
        this.a = onBackPressedDispatcher;
    }

    public final Object invoke() {
        this.a.c();
        return Unit.a;
    }
}
