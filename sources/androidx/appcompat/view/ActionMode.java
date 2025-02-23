package androidx.appcompat.view;

import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.MenuBuilder;

public abstract class ActionMode {
    public Object a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f986a;

    public interface Callback {
        void a(ActionMode actionMode);

        boolean b(ActionMode actionMode, MenuItem menuItem);

        boolean c(ActionMode actionMode, MenuBuilder menuBuilder);

        boolean d(ActionMode actionMode, MenuBuilder menuBuilder);
    }

    public abstract void a();

    public abstract View b();

    public abstract MenuBuilder c();

    public abstract MenuInflater d();

    public abstract CharSequence e();

    public abstract CharSequence f();

    public abstract void g();

    public boolean h() {
        return false;
    }

    public abstract void i(View view);

    public abstract void j(int i);

    public abstract void k(CharSequence charSequence);

    public abstract void l(int i);

    public abstract void m(CharSequence charSequence);

    public void n(boolean z) {
        this.f986a = z;
    }
}
