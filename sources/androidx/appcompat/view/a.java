package androidx.appcompat.view;

import android.content.Context;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionMenuPresenter;
import java.lang.ref.WeakReference;

/* compiled from: StandaloneActionMode */
public final class a extends ActionMode implements MenuBuilder.Callback {
    public final Context a;

    /* renamed from: a  reason: collision with other field name */
    public final ActionMode.Callback f987a;

    /* renamed from: a  reason: collision with other field name */
    public final MenuBuilder f988a;

    /* renamed from: a  reason: collision with other field name */
    public final ActionBarContextView f989a;

    /* renamed from: a  reason: collision with other field name */
    public WeakReference<View> f990a;
    public boolean b;

    public a(Context context, ActionBarContextView actionBarContextView, ActionMode.Callback callback) {
        this.a = context;
        this.f989a = actionBarContextView;
        this.f987a = callback;
        MenuBuilder defaultShowAsAction = new MenuBuilder(actionBarContextView.getContext()).setDefaultShowAsAction(1);
        this.f988a = defaultShowAsAction;
        defaultShowAsAction.setCallback(this);
    }

    public final void a() {
        if (!this.b) {
            this.b = true;
            this.f987a.a(this);
        }
    }

    public final View b() {
        WeakReference<View> weakReference = this.f990a;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public final MenuBuilder c() {
        return this.f988a;
    }

    public final MenuInflater d() {
        return new Iy(this.f989a.getContext());
    }

    public final CharSequence e() {
        return this.f989a.getSubtitle();
    }

    public final CharSequence f() {
        return this.f989a.getTitle();
    }

    public final void g() {
        this.f987a.c(this, this.f988a);
    }

    public final boolean h() {
        return this.f989a.f1105c;
    }

    public final void i(View view) {
        WeakReference<View> weakReference;
        this.f989a.setCustomView(view);
        if (view != null) {
            weakReference = new WeakReference<>(view);
        } else {
            weakReference = null;
        }
        this.f990a = weakReference;
    }

    public final void j(int i) {
        k(this.a.getString(i));
    }

    public final void k(CharSequence charSequence) {
        this.f989a.setSubtitle(charSequence);
    }

    public final void l(int i) {
        m(this.a.getString(i));
    }

    public final void m(CharSequence charSequence) {
        this.f989a.setTitle(charSequence);
    }

    public final void n(boolean z) {
        this.f986a = z;
        this.f989a.setTitleOptional(z);
    }

    public final boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        return this.f987a.b(this, menuItem);
    }

    public final void onMenuModeChange(MenuBuilder menuBuilder) {
        g();
        ActionMenuPresenter actionMenuPresenter = this.f989a.f3044a;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.e();
        }
    }
}
