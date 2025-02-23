package in.juspay.hypersdk.mystique;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Keep;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import in.juspay.hypersdk.core.DuiCallback;

@Keep
public class BottomSheetLayout extends FrameLayout {
    /* access modifiers changed from: private */
    public final BottomSheetBehavior bottomSheetBehavior;
    private final BottomSheetCallback bottomSheetCallback;
    /* access modifiers changed from: private */
    public boolean enableShift = true;

    public class BottomSheetCallback extends BottomSheetBehavior.BottomSheetCallback {
        float bottomShift;
        boolean bottomShiftOverridden = false;
        private DuiCallback duiCallback;
        private float lastReceivedScroll;
        private String stateChangeCallback;
        private String stateSlideCallback;
        float topShift;
        boolean topShiftOverridden = false;

        public BottomSheetCallback() {
        }

        public void onSlide(View view, float f) {
            this.lastReceivedScroll = f;
            DuiCallback duiCallback2 = this.duiCallback;
            if (duiCallback2 != null && this.stateSlideCallback != null) {
                duiCallback2.addJsToWebView("window.callUICallback('" + this.stateSlideCallback + "','" + f + "');");
            }
        }

        public void onStateChanged(View view, int i) {
            BottomSheetBehavior access$100;
            int i2;
            if (i == 2 && BottomSheetLayout.this.enableShift) {
                if (!this.topShiftOverridden || !this.bottomShiftOverridden) {
                    float halfExpandedRatio = BottomSheetLayout.this.bottomSheetBehavior.getHalfExpandedRatio();
                    float peekHeight = ((float) BottomSheetLayout.this.bottomSheetBehavior.getPeekHeight()) / ((float) view.getHeight());
                    if (!this.topShiftOverridden) {
                        this.topShift = (halfExpandedRatio / 2.0f) + 0.5f;
                    }
                    if (!this.bottomShiftOverridden) {
                        this.bottomShift = (halfExpandedRatio / 2.0f) - (peekHeight / 2.0f);
                    }
                }
                float f = this.bottomShift;
                float f2 = this.lastReceivedScroll;
                if (f > f2) {
                    access$100 = BottomSheetLayout.this.bottomSheetBehavior;
                    i2 = 4;
                } else if (f2 <= f || f2 >= this.topShift) {
                    access$100 = BottomSheetLayout.this.bottomSheetBehavior;
                    i2 = 3;
                } else {
                    access$100 = BottomSheetLayout.this.bottomSheetBehavior;
                    i2 = 6;
                }
                access$100.setState(i2);
            }
            DuiCallback duiCallback2 = this.duiCallback;
            if (duiCallback2 != null && this.stateChangeCallback != null) {
                duiCallback2.addJsToWebView("window.callUICallback('" + this.stateChangeCallback + "','" + i + "');");
            }
        }

        public void setBottomShift(float f) {
            this.bottomShiftOverridden = true;
            this.bottomShift = f;
        }

        public void setDuiCallback(DuiCallback duiCallback2) {
            this.duiCallback = duiCallback2;
        }

        public void setSlideCallback(String str) {
            this.stateSlideCallback = str;
        }

        public void setStateChangeCallback(String str) {
            this.stateChangeCallback = str;
        }

        public void setTopShift(float f) {
            this.topShiftOverridden = true;
            this.topShift = f;
        }
    }

    public BottomSheetLayout(Context context) {
        super(context);
        BottomSheetBehavior bottomSheetBehavior2 = new BottomSheetBehavior();
        this.bottomSheetBehavior = bottomSheetBehavior2;
        BottomSheetCallback bottomSheetCallback2 = new BottomSheetCallback();
        this.bottomSheetCallback = bottomSheetCallback2;
        bottomSheetBehavior2.addBottomSheetCallback(bottomSheetCallback2);
    }

    @Keep
    public void setBottomShift(float f) {
        this.bottomSheetCallback.setBottomShift(f);
    }

    public void setEnableShift(boolean z) {
        this.enableShift = z;
    }

    @Keep
    public void setHalfExpandedRatio(float f) {
        this.bottomSheetBehavior.setHalfExpandedRatio(f);
    }

    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
            ((CoordinatorLayout.LayoutParams) layoutParams).b(this.bottomSheetBehavior);
        }
        super.setLayoutParams(layoutParams);
    }

    @Keep
    public void setPeakHeight(int i) {
        this.bottomSheetBehavior.setPeekHeight(i);
    }

    public void setSlideCallback(DuiCallback duiCallback, String str) {
        this.bottomSheetCallback.setDuiCallback(duiCallback);
        this.bottomSheetCallback.setSlideCallback(str);
    }

    @Keep
    public void setState(int i) {
        this.bottomSheetBehavior.setState(i);
    }

    public void setStateChangeCallback(DuiCallback duiCallback, String str) {
        this.bottomSheetCallback.setDuiCallback(duiCallback);
        this.bottomSheetCallback.setStateChangeCallback(str);
    }

    @Keep
    public void setTopShift(float f) {
        this.bottomSheetCallback.setTopShift(f);
    }
}
