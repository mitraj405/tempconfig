package defpackage;

import androidx.activity.OnBackPressedDispatcher;
import java.util.ListIterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* renamed from: Fn  reason: default package */
/* compiled from: OnBackPressedDispatcher.kt */
public final class Fn extends C0595Mh implements Function0<Unit> {
    public final /* synthetic */ OnBackPressedDispatcher a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Fn(OnBackPressedDispatcher onBackPressedDispatcher) {
        super(0);
        this.a = onBackPressedDispatcher;
    }

    public final Object invoke() {
        Bn bn;
        OnBackPressedDispatcher onBackPressedDispatcher = this.a;
        C0534I1<Bn> i1 = onBackPressedDispatcher.f810a;
        ListIterator<Bn> listIterator = i1.listIterator(i1.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                bn = null;
                break;
            }
            bn = listIterator.previous();
            if (bn.isEnabled()) {
                break;
            }
        }
        Bn bn2 = bn;
        onBackPressedDispatcher.a = null;
        if (bn2 != null) {
            bn2.handleOnBackCancelled();
        }
        return Unit.a;
    }
}
