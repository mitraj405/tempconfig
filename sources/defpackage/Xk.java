package defpackage;

import androidx.core.view.MenuHostHelper;
import androidx.core.view.MenuProvider;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.f;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: Xk  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class Xk implements f {
    public final /* synthetic */ MenuHostHelper a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ MenuProvider f677a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Lifecycle.State f678a;

    public /* synthetic */ Xk(MenuHostHelper menuHostHelper, Lifecycle.State state, MenuProvider menuProvider) {
        this.a = menuHostHelper;
        this.f678a = state;
        this.f677a = menuProvider;
    }

    public final void b(LifecycleOwner lifecycleOwner, Lifecycle.a aVar) {
        Lifecycle.a aVar2;
        MenuHostHelper menuHostHelper = this.a;
        menuHostHelper.getClass();
        Lifecycle.a.Companion.getClass();
        Lifecycle.State state = this.f678a;
        C1177ig.f(state, RemoteConfigConstants.ResponseFieldKey.STATE);
        int ordinal = state.ordinal();
        if (ordinal == 2) {
            aVar2 = Lifecycle.a.ON_CREATE;
        } else if (ordinal == 3) {
            aVar2 = Lifecycle.a.ON_START;
        } else if (ordinal != 4) {
            aVar2 = null;
        } else {
            aVar2 = Lifecycle.a.ON_RESUME;
        }
        Runnable runnable = menuHostHelper.a;
        CopyOnWriteArrayList<MenuProvider> copyOnWriteArrayList = menuHostHelper.f1797a;
        MenuProvider menuProvider = this.f677a;
        if (aVar == aVar2) {
            copyOnWriteArrayList.add(menuProvider);
            runnable.run();
        } else if (aVar == Lifecycle.a.ON_DESTROY) {
            menuHostHelper.c(menuProvider);
        } else if (aVar == Lifecycle.a.C0020a.a(state)) {
            copyOnWriteArrayList.remove(menuProvider);
            runnable.run();
        }
    }
}
