package androidx.appcompat.view.menu;

import android.view.MenuItem;
import androidx.appcompat.view.menu.b;

/* compiled from: CascadingMenuPopup */
public final class c implements Runnable {
    public final /* synthetic */ MenuItem a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ MenuBuilder f1059a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ b.c f1060a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ b.d f1061a;

    public c(b.c cVar, b.d dVar, MenuItemImpl menuItemImpl, MenuBuilder menuBuilder) {
        this.f1060a = cVar;
        this.f1061a = dVar;
        this.a = menuItemImpl;
        this.f1059a = menuBuilder;
    }

    public final void run() {
        b.d dVar = this.f1061a;
        if (dVar != null) {
            b.c cVar = this.f1060a;
            b.this.f1056f = true;
            dVar.f1057a.close(false);
            b.this.f1056f = false;
        }
        MenuItem menuItem = this.a;
        if (menuItem.isEnabled() && menuItem.hasSubMenu()) {
            this.f1059a.performItemAction(menuItem, 4);
        }
    }
}
