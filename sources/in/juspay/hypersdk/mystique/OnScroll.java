package in.juspay.hypersdk.mystique;

import android.widget.AbsListView;
import in.juspay.hypersdk.core.DuiCallback;

public class OnScroll implements AbsListView.OnScrollListener {
    private final DuiCallback duiCallback;
    private String scrollCallback;
    private String scrollChangeCallback;

    public OnScroll(DuiCallback duiCallback2) {
        this.duiCallback = duiCallback2;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        DuiCallback duiCallback2 = this.duiCallback;
        duiCallback2.addJsToWebView("window.callUICallback('" + this.scrollCallback + "','" + i + "," + i2 + "," + i3 + "');");
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        DuiCallback duiCallback2 = this.duiCallback;
        duiCallback2.addJsToWebView("window.callUICallback('" + this.scrollChangeCallback + "'," + i + ");");
    }

    public void setScrollCallback(String str) {
        this.scrollCallback = str;
    }

    public void setScrollChangeCallback(String str) {
        this.scrollChangeCallback = str;
    }
}
