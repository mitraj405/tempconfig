package defpackage;

import androidx.activity.BackEventCompat;
import androidx.activity.OnBackPressedDispatcher;
import java.util.ListIterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* renamed from: Dn  reason: default package */
/* compiled from: OnBackPressedDispatcher.kt */
public final class Dn extends C0595Mh implements Function1<BackEventCompat, Unit> {
    public final /* synthetic */ OnBackPressedDispatcher a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Dn(OnBackPressedDispatcher onBackPressedDispatcher) {
        super(1);
        this.a = onBackPressedDispatcher;
    }

    public final Object invoke(Object obj) {
        Bn bn;
        BackEventCompat backEventCompat = (BackEventCompat) obj;
        C1177ig.f(backEventCompat, "backEvent");
        C0534I1<Bn> i1 = this.a.f810a;
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
        if (bn2 != null) {
            bn2.handleOnBackProgressed(backEventCompat);
        }
        return Unit.a;
    }
}
