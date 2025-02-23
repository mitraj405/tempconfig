package defpackage;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import defpackage.C1156hg;

/* renamed from: a  reason: default package and case insensitive filesystem */
/* compiled from: -FallbackViewCreationInterceptor.kt */
public final class C0773a implements C1156hg {
    public final Ff intercept(C1156hg.a aVar) {
        Ef ef = ((C0791b) aVar).f3907a;
        C0680Sb sb = ef.a;
        View view = ef.f3580a;
        String str = ef.f3581a;
        Context context = ef.f3578a;
        AttributeSet attributeSet = ef.f3579a;
        View onCreateView = sb.onCreateView(view, str, context, attributeSet);
        if (onCreateView != null) {
            str = onCreateView.getClass().getName();
        }
        return new Ff(onCreateView, str, context, attributeSet);
    }
}
