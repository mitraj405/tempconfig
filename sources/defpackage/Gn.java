package defpackage;

import androidx.activity.OnBackPressedDispatcher;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* renamed from: Gn  reason: default package */
/* compiled from: OnBackPressedDispatcher.kt */
public final class Gn extends C0595Mh implements Function0<Unit> {
    public final /* synthetic */ OnBackPressedDispatcher a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Gn(OnBackPressedDispatcher onBackPressedDispatcher) {
        super(0);
        this.a = onBackPressedDispatcher;
    }

    public final Object invoke() {
        this.a.c();
        return Unit.a;
    }
}
