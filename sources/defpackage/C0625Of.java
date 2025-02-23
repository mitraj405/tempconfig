package defpackage;

import android.view.MenuItem;
import android.widget.PopupMenu;
import in.juspay.hypersdk.core.InflateView;

/* renamed from: Of  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0625Of implements PopupMenu.OnMenuItemClickListener {
    public final /* synthetic */ InflateView a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f3738a;

    public /* synthetic */ C0625Of(InflateView inflateView, String str) {
        this.a = inflateView;
        this.f3738a = str;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        return this.a.lambda$parseKeys$8(this.f3738a, menuItem);
    }
}
