package defpackage;

import androidx.activity.BackEventCompat;
import androidx.activity.OnBackPressedDispatcher;
import java.util.ListIterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* renamed from: Cn  reason: default package */
/* compiled from: OnBackPressedDispatcher.kt */
public final class Cn extends C0595Mh implements Function1<BackEventCompat, Unit> {
    public final /* synthetic */ OnBackPressedDispatcher a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Cn(OnBackPressedDispatcher onBackPressedDispatcher) {
        super(1);
        this.a = onBackPressedDispatcher;
    }

    public final Object invoke(Object obj) {
        Bn bn;
        BackEventCompat backEventCompat = (BackEventCompat) obj;
        C1177ig.f(backEventCompat, "backEvent");
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
        onBackPressedDispatcher.a = bn2;
        if (bn2 != null) {
            bn2.handleOnBackStarted(backEventCompat);
        }
        return Unit.a;
    }
}
