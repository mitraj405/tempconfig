package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.Window;
import androidx.appcompat.view.menu.MenuPresenter;

public interface DecorToolbar {
    boolean a();

    boolean b();

    boolean c();

    boolean d();

    boolean e();

    void f();

    void g();

    Context getContext();

    CharSequence getTitle();

    void h();

    void i();

    void j(int i);

    void k(int i);

    GC l(int i, long j);

    void m();

    void n(boolean z);

    boolean o();

    void p();

    void q(Drawable drawable);

    void r();

    int s();

    void setMenu(Menu menu, MenuPresenter.Callback callback);

    void setMenuPrepared();

    void setVisibility(int i);

    void setWindowCallback(Window.Callback callback);

    void setWindowTitle(CharSequence charSequence);

    void t(int i);
}
