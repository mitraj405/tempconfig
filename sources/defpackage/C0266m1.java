package defpackage;

import android.view.View;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.core.view.f;
import java.util.WeakHashMap;

/* renamed from: m1  reason: default package and case insensitive filesystem */
/* compiled from: AppCompatDelegateImpl */
public final class C0266m1 extends C1488xu {
    public final /* synthetic */ AppCompatDelegateImpl a;

    public C0266m1(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.a = appCompatDelegateImpl;
    }

    public final void a() {
        AppCompatDelegateImpl appCompatDelegateImpl = this.a;
        appCompatDelegateImpl.f921a.setVisibility(0);
        if (appCompatDelegateImpl.f921a.getParent() instanceof View) {
            WeakHashMap<View, GC> weakHashMap = f.f1839a;
            f.c.c((View) appCompatDelegateImpl.f921a.getParent());
        }
    }

    public final void onAnimationEnd() {
        AppCompatDelegateImpl appCompatDelegateImpl = this.a;
        appCompatDelegateImpl.f921a.setAlpha(1.0f);
        appCompatDelegateImpl.f900a.d((IC) null);
        appCompatDelegateImpl.f900a = null;
    }
}
