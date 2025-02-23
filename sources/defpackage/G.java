package defpackage;

import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.SubMenuBuilder;

/* renamed from: G  reason: default package */
/* compiled from: ActionProvider */
public abstract class G {
    public a a;

    /* renamed from: a  reason: collision with other field name */
    public final Context f224a;

    /* renamed from: G$a */
    /* compiled from: ActionProvider */
    public interface a {
    }

    /* renamed from: G$b */
    /* compiled from: ActionProvider */
    public interface b {
    }

    public G(Context context) {
        this.f224a = context;
    }

    public boolean a() {
        return false;
    }

    public boolean b() {
        return true;
    }

    public abstract View c();

    public View d(MenuItem menuItem) {
        return c();
    }

    public boolean e() {
        return false;
    }

    public boolean g() {
        return false;
    }

    public void f(SubMenuBuilder subMenuBuilder) {
    }

    public void h(MenuItemImpl.a aVar) {
    }
}
