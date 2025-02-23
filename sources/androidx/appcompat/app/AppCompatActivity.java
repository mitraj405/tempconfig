package androidx.appcompat.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.app.g;
import androidx.appcompat.view.ActionMode;
import androidx.fragment.app.FragmentActivity;
import java.util.ArrayList;

public class AppCompatActivity extends FragmentActivity implements C0199g1 {
    public AppCompatDelegateImpl a;

    public AppCompatActivity() {
        getSavedStateRegistry().c("androidx:appcompat", new C0173e1(this));
        addOnContextAvailableListener(new C0188f1(this));
    }

    public final void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        k();
        j().a(view, layoutParams);
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(j().b(context));
    }

    public final void closeOptionsMenu() {
        ((AppCompatDelegateImpl) j()).L();
        if (getWindow().hasFeature(0)) {
            super.closeOptionsMenu();
        }
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        keyEvent.getKeyCode();
        ((AppCompatDelegateImpl) j()).L();
        return super.dispatchKeyEvent(keyEvent);
    }

    public final <T extends View> T findViewById(int i) {
        return j().c(i);
    }

    public final MenuInflater getMenuInflater() {
        return j().f();
    }

    public final Resources getResources() {
        int i = C0117aC.a;
        return super.getResources();
    }

    public final void invalidateOptionsMenu() {
        j().i();
    }

    public final AppCompatDelegate j() {
        if (this.a == null) {
            g.a aVar = AppCompatDelegate.a;
            this.a = new AppCompatDelegateImpl(this, (Window) null, this, this);
        }
        return this.a;
    }

    public final void k() {
        r1.N(getWindow().getDecorView(), this);
        View decorView = getWindow().getDecorView();
        C1177ig.f(decorView, "<this>");
        decorView.setTag(Nr.view_tree_view_model_store_owner, this);
        C1354qp.x0(getWindow().getDecorView(), this);
        View decorView2 = getWindow().getDecorView();
        C1177ig.f(decorView2, "<this>");
        decorView2.setTag(Pr.view_tree_on_back_pressed_dispatcher_owner, this);
    }

    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        j().k();
    }

    public void onDestroy() {
        super.onDestroy();
        j().m();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        AppCompatDelegateImpl appCompatDelegateImpl = (AppCompatDelegateImpl) j();
        appCompatDelegateImpl.L();
        h hVar = appCompatDelegateImpl.f919a;
        if (menuItem.getItemId() != 16908332 || hVar == null || (hVar.c() & 4) == 0) {
            return false;
        }
        Intent a2 = tm.a(this);
        if (a2 == null) {
            return false;
        }
        if (shouldUpRecreateTask(a2)) {
            ArrayList arrayList = new ArrayList();
            Intent a3 = tm.a(this);
            if (a3 == null) {
                a3 = tm.a(this);
            }
            if (a3 != null) {
                ComponentName component = a3.getComponent();
                if (component == null) {
                    component = a3.resolveActivity(getPackageManager());
                }
                int size = arrayList.size();
                try {
                    Intent b = tm.b(this, component);
                    while (b != null) {
                        arrayList.add(size, b);
                        b = tm.b(this, b.getComponent());
                    }
                    arrayList.add(a3);
                } catch (PackageManager.NameNotFoundException e) {
                    throw new IllegalArgumentException(e);
                }
            }
            if (!arrayList.isEmpty()) {
                Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[0]);
                intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
                Object obj = d7.a;
                startActivities(intentArr, (Bundle) null);
                try {
                    int i2 = J.a;
                    finishAffinity();
                    return true;
                } catch (IllegalStateException unused) {
                    finish();
                    return true;
                }
            } else {
                throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
            }
        } else {
            navigateUpTo(a2);
            return true;
        }
    }

    public final boolean onMenuOpened(int i, Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    public final void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
    }

    public final void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        ((AppCompatDelegateImpl) j()).G();
    }

    public final void onPostResume() {
        super.onPostResume();
        j().n();
    }

    public void onStart() {
        super.onStart();
        j().o();
    }

    public void onStop() {
        super.onStop();
        j().p();
    }

    public final void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        j().w(charSequence);
    }

    public final ActionMode onWindowStartingSupportActionMode(ActionMode.Callback callback) {
        return null;
    }

    public final void openOptionsMenu() {
        ((AppCompatDelegateImpl) j()).L();
        if (getWindow().hasFeature(0)) {
            super.openOptionsMenu();
        }
    }

    public final void setContentView(int i) {
        k();
        j().s(i);
    }

    public final void setTheme(int i) {
        super.setTheme(i);
        j().v(i);
    }

    public final void supportInvalidateOptionsMenu() {
        j().i();
    }

    public void setContentView(View view) {
        k();
        j().t(view);
    }

    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        k();
        j().u(view, layoutParams);
    }

    public final void onContentChanged() {
    }

    public final void onSupportActionModeFinished(ActionMode actionMode) {
    }

    public final void onSupportActionModeStarted(ActionMode actionMode) {
    }
}
