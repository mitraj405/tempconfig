package defpackage;

import android.view.View;
import android.view.Window;
import androidx.appcompat.widget.ToolbarWidgetWrapper;

/* renamed from: iA  reason: default package */
/* compiled from: ToolbarWidgetWrapper */
public final class iA implements View.OnClickListener {
    public final F a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ ToolbarWidgetWrapper f3003a;

    public iA(ToolbarWidgetWrapper toolbarWidgetWrapper) {
        this.f3003a = toolbarWidgetWrapper;
        this.a = new F(toolbarWidgetWrapper.f1274a.getContext(), toolbarWidgetWrapper.f1275a);
    }

    public final void onClick(View view) {
        ToolbarWidgetWrapper toolbarWidgetWrapper = this.f3003a;
        Window.Callback callback = toolbarWidgetWrapper.f1271a;
        if (callback != null && toolbarWidgetWrapper.f1279b) {
            callback.onMenuItemSelected(0, this.a);
        }
    }
}
