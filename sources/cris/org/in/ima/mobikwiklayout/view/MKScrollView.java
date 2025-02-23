package cris.org.in.ima.mobikwiklayout.view;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import cris.org.in.prs.ima.R;

public class MKScrollView extends ScrollView {

    public class a implements Runnable {
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ int e;
        public final /* synthetic */ int f;

        public a(int i, int i2, int i3, int i4) {
            this.c = i;
            this.d = i2;
            this.e = i3;
            this.f = i4;
        }

        public final void run() {
            int i = this.c - (this.d - this.e);
            if (this.f > 0 && i > 0) {
                MKScrollView.this.smoothScrollBy(0, i);
            }
        }
    }

    public MKScrollView(Context context) {
        super(context);
    }

    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        int i5 = 0;
        View focusedChild = ((ViewGroup) getChildAt(0)).getFocusedChild();
        if (focusedChild != null) {
            if (focusedChild.getId() != R.id.container_mket && (focusedChild instanceof ViewGroup)) {
                View focusedChild2 = ((ViewGroup) focusedChild).getFocusedChild();
                if (focusedChild2 != null) {
                    i5 = focusedChild2.getTop() + focusedChild.getTop();
                }
            } else if (focusedChild.getId() == R.id.container_mket) {
                i5 = focusedChild.getTop();
            }
            int i6 = i5;
            new Handler().postDelayed(new a(getResources().getDimensionPixelSize(R.dimen.size72), i2, i6, i6), 300);
        }
    }

    public MKScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MKScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
