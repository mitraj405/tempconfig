package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.util.zzau;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdpo extends FrameLayout {
    private final zzau zza;

    public zzdpo(Context context, View view, zzau zzau) {
        super(context);
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(view);
        this.zza = zzau;
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.zza.zzm(motionEvent);
        return false;
    }

    public final void removeAllViews() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt != null && (childAt instanceof zzcej)) {
                arrayList.add((zzcej) childAt);
            }
        }
        super.removeAllViews();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((zzcej) arrayList.get(i2)).destroy();
        }
    }
}
