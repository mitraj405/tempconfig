package defpackage;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.collection.SimpleArrayMap;

/* renamed from: x2  reason: default package and case insensitive filesystem */
/* compiled from: BaseMenuWrapper */
public abstract class C0386x2 {
    public final Context a;

    /* renamed from: a  reason: collision with other field name */
    public SimpleArrayMap<Jy, MenuItem> f3406a;
    public SimpleArrayMap<Ny, SubMenu> b;

    public C0386x2(Context context) {
        this.a = context;
    }

    public final MenuItem e(MenuItem menuItem) {
        if (!(menuItem instanceof Jy)) {
            return menuItem;
        }
        Jy jy = (Jy) menuItem;
        if (this.f3406a == null) {
            this.f3406a = new SimpleArrayMap<>();
        }
        MenuItem menuItem2 = this.f3406a.get(jy);
        if (menuItem2 != null) {
            return menuItem2;
        }
        al alVar = new al(this.a, jy);
        this.f3406a.put(jy, alVar);
        return alVar;
    }

    public final SubMenu f(SubMenu subMenu) {
        if (!(subMenu instanceof Ny)) {
            return subMenu;
        }
        Ny ny = (Ny) subMenu;
        if (this.b == null) {
            this.b = new SimpleArrayMap<>();
        }
        SubMenu subMenu2 = this.b.get(ny);
        if (subMenu2 != null) {
            return subMenu2;
        }
        C0399xy xyVar = new C0399xy(this.a, ny);
        this.b.put(ny, xyVar);
        return xyVar;
    }
}
