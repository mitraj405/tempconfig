package androidx.appcompat.view.menu;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.d;

/* compiled from: MenuDialogHelper */
public final class f implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, MenuPresenter.Callback {
    public AlertDialog a;

    /* renamed from: a  reason: collision with other field name */
    public final MenuBuilder f1069a;

    /* renamed from: a  reason: collision with other field name */
    public d f1070a;

    public f(MenuBuilder menuBuilder) {
        this.f1069a = menuBuilder;
    }

    public final boolean a(MenuBuilder menuBuilder) {
        return false;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        d dVar = this.f1070a;
        if (dVar.f1066a == null) {
            dVar.f1066a = new d.a();
        }
        this.f1069a.performItemAction(dVar.f1066a.getItem(i), 0);
    }

    public final void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        AlertDialog alertDialog;
        if ((z || menuBuilder == this.f1069a) && (alertDialog = this.a) != null) {
            alertDialog.dismiss();
        }
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        this.f1070a.onCloseMenu(this.f1069a, true);
    }

    public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        MenuBuilder menuBuilder = this.f1069a;
        if (i == 82 || i == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.a.getWindow();
                if (!(window2 == null || (decorView2 = window2.getDecorView()) == null || (keyDispatcherState2 = decorView2.getKeyDispatcherState()) == null)) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.a.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                menuBuilder.close(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return menuBuilder.performShortcut(i, keyEvent, 0);
    }
}
