package defpackage;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.g;

/* renamed from: Up  reason: default package */
/* compiled from: PopupMenu */
public final class Up {
    public a a;

    /* renamed from: a  reason: collision with other field name */
    public final Context f577a;

    /* renamed from: a  reason: collision with other field name */
    public final View f578a;

    /* renamed from: a  reason: collision with other field name */
    public final MenuBuilder f579a;

    /* renamed from: a  reason: collision with other field name */
    public final g f580a;

    /* renamed from: Up$a */
    /* compiled from: PopupMenu */
    public interface a {
    }

    public Up(Context context, ImageView imageView) {
        int i = C0220hr.popupMenuStyle;
        this.f577a = context;
        this.f578a = imageView;
        MenuBuilder menuBuilder = new MenuBuilder(context);
        this.f579a = menuBuilder;
        menuBuilder.setCallback(new Sp(this));
        g gVar = new g(i, 0, context, imageView, menuBuilder, false);
        this.f580a = gVar;
        gVar.c = 0;
        gVar.f1073a = new Tp(this);
    }
}
