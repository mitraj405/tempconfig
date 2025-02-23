package defpackage;

import androidx.activity.BackEventCompat;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* renamed from: Bn  reason: default package */
/* compiled from: OnBackPressedCallback.kt */
public abstract class Bn {
    private final CopyOnWriteArrayList<u4> cancellables = new CopyOnWriteArrayList<>();
    private Function0<Unit> enabledChangedCallback;
    private boolean isEnabled;

    public Bn(boolean z) {
        this.isEnabled = z;
    }

    public final void addCancellable(u4 u4Var) {
        C1177ig.f(u4Var, "cancellable");
        this.cancellables.add(u4Var);
    }

    public final Function0<Unit> getEnabledChangedCallback$activity_release() {
        return this.enabledChangedCallback;
    }

    public abstract void handleOnBackPressed();

    public void handleOnBackProgressed(BackEventCompat backEventCompat) {
        C1177ig.f(backEventCompat, "backEvent");
    }

    public void handleOnBackStarted(BackEventCompat backEventCompat) {
        C1177ig.f(backEventCompat, "backEvent");
    }

    public final boolean isEnabled() {
        return this.isEnabled;
    }

    public final void remove() {
        for (u4 cancel : this.cancellables) {
            cancel.cancel();
        }
    }

    public final void removeCancellable(u4 u4Var) {
        C1177ig.f(u4Var, "cancellable");
        this.cancellables.remove(u4Var);
    }

    public final void setEnabled(boolean z) {
        this.isEnabled = z;
        Function0<Unit> function0 = this.enabledChangedCallback;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void setEnabledChangedCallback$activity_release(Function0<Unit> function0) {
        this.enabledChangedCallback = function0;
    }

    public void handleOnBackCancelled() {
    }
}
