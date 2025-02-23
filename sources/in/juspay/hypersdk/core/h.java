package in.juspay.hypersdk.core;

import android.view.MenuItem;
import android.widget.PopupMenu;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class h implements PopupMenu.OnMenuItemClickListener {
    public final /* synthetic */ AndroidInterface a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f5498a;

    public /* synthetic */ h(AndroidInterface androidInterface, String str) {
        this.a = androidInterface;
        this.f5498a = str;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        return this.a.lambda$showPopup$16(this.f5498a, menuItem);
    }
}
