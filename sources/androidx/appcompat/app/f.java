package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.ComponentDialog;
import androidx.appcompat.app.g;
import androidx.appcompat.view.ActionMode;
import androidx.core.view.KeyEventDispatcher;

/* compiled from: AppCompatDialog */
public class f extends ComponentDialog implements C0199g1 {
    private AppCompatDelegate mDelegate;
    private final KeyEventDispatcher.Component mKeyDispatcher;

    public f(Context context) {
        this(context, 0);
    }

    private static int getThemeResId(Context context, int i) {
        if (i != 0) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C0220hr.dialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        getDelegate().a(view, layoutParams);
    }

    public void dismiss() {
        super.dismiss();
        getDelegate().m();
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return KeyEventDispatcher.b(this.mKeyDispatcher, getWindow().getDecorView(), this, keyEvent);
    }

    public <T extends View> T findViewById(int i) {
        return getDelegate().c(i);
    }

    public AppCompatDelegate getDelegate() {
        if (this.mDelegate == null) {
            g.a aVar = AppCompatDelegate.a;
            this.mDelegate = new AppCompatDelegateImpl(getContext(), getWindow(), this, this);
        }
        return this.mDelegate;
    }

    public ActionBar getSupportActionBar() {
        return getDelegate().g();
    }

    public void invalidateOptionsMenu() {
        getDelegate().i();
    }

    public void onCreate(Bundle bundle) {
        getDelegate().h();
        super.onCreate(bundle);
        getDelegate().l();
    }

    public void onStop() {
        super.onStop();
        getDelegate().p();
    }

    public ActionMode onWindowStartingSupportActionMode(ActionMode.Callback callback) {
        return null;
    }

    public void setContentView(int i) {
        getDelegate().s(i);
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        getDelegate().w(charSequence);
    }

    /* access modifiers changed from: package-private */
    public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean supportRequestWindowFeature(int i) {
        return getDelegate().r(i);
    }

    public f(Context context, int i) {
        super(context, getThemeResId(context, i));
        this.mKeyDispatcher = new e(this);
        AppCompatDelegate delegate = getDelegate();
        delegate.v(getThemeResId(context, i));
        delegate.l();
    }

    public void setContentView(View view) {
        getDelegate().t(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        getDelegate().u(view, layoutParams);
    }

    public void setTitle(int i) {
        super.setTitle(i);
        getDelegate().w(getContext().getString(i));
    }

    public f(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context);
        this.mKeyDispatcher = new e(this);
        setCancelable(z);
        setOnCancelListener(onCancelListener);
    }

    public void onSupportActionModeFinished(ActionMode actionMode) {
    }

    public void onSupportActionModeStarted(ActionMode actionMode) {
    }
}
