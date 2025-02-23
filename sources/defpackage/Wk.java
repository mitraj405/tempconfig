package defpackage;

import androidx.core.view.MenuHostHelper;
import androidx.core.view.MenuProvider;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.f;

/* renamed from: Wk  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class Wk implements f {
    public final /* synthetic */ MenuHostHelper a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ MenuProvider f637a;

    public /* synthetic */ Wk(MenuHostHelper menuHostHelper, MenuProvider menuProvider) {
        this.a = menuHostHelper;
        this.f637a = menuProvider;
    }

    public final void b(LifecycleOwner lifecycleOwner, Lifecycle.a aVar) {
        Lifecycle.a aVar2 = Lifecycle.a.ON_DESTROY;
        MenuHostHelper menuHostHelper = this.a;
        if (aVar == aVar2) {
            menuHostHelper.c(this.f637a);
        } else {
            menuHostHelper.getClass();
        }
    }
}
