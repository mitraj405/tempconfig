package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;

public abstract class FragmentHostCallback<E> extends FragmentContainer {
    public final Activity a;

    /* renamed from: a  reason: collision with other field name */
    public final Context f2066a;

    /* renamed from: a  reason: collision with other field name */
    public final Handler f2067a;

    /* renamed from: a  reason: collision with other field name */
    public final C0297pd f2068a = new C0297pd();

    public FragmentHostCallback(FragmentActivity fragmentActivity) {
        Handler handler = new Handler();
        this.a = fragmentActivity;
        if (fragmentActivity != null) {
            this.f2066a = fragmentActivity;
            this.f2067a = handler;
            return;
        }
        throw new NullPointerException("context == null");
    }

    public View b(int i) {
        return null;
    }

    public boolean c() {
        return true;
    }

    public abstract FragmentActivity e();

    public LayoutInflater f() {
        return LayoutInflater.from(this.f2066a);
    }

    public boolean g(String str) {
        return false;
    }

    public void h() {
    }
}
