package androidx.browser.browseractions;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.google.common.primitives.Ints;

@Deprecated
public class BrowserActionsFallbackMenuView extends LinearLayout {
    public final int c = getResources().getDimensionPixelOffset(C0309qr.browser_actions_context_menu_min_padding);
    public final int d = getResources().getDimensionPixelOffset(C0309qr.browser_actions_context_menu_max_width);

    public BrowserActionsFallbackMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(Math.min(getResources().getDisplayMetrics().widthPixels - (this.c * 2), this.d), Ints.MAX_POWER_OF_TWO), i2);
    }
}
