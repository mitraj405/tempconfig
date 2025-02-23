package defpackage;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import in.juspay.hyper.constants.LogSubCategory;
import java.util.Arrays;

/* renamed from: Y8  reason: default package and case insensitive filesystem */
/* compiled from: DialogPlusBuilder */
public final class C0753Y8 {
    public final int a = 80;

    /* renamed from: a  reason: collision with other field name */
    public Tn f3849a;

    /* renamed from: a  reason: collision with other field name */
    public C0737We f3850a;

    /* renamed from: a  reason: collision with other field name */
    public final Context f3851a;

    /* renamed from: a  reason: collision with other field name */
    public View f3852a;

    /* renamed from: a  reason: collision with other field name */
    public BaseAdapter f3853a;

    /* renamed from: a  reason: collision with other field name */
    public final FrameLayout.LayoutParams f3854a = new FrameLayout.LayoutParams(-1, -2, 80);

    /* renamed from: a  reason: collision with other field name */
    public final boolean f3855a = true;

    /* renamed from: a  reason: collision with other field name */
    public final int[] f3856a;
    public int b = -1;

    /* renamed from: b  reason: collision with other field name */
    public boolean f3857b;

    /* renamed from: b  reason: collision with other field name */
    public final int[] f3858b = new int[4];
    public final int c = -1;

    /* renamed from: c  reason: collision with other field name */
    public final int[] f3859c = new int[4];
    public final int d = -1;
    public final int e = -1;
    public final int f = -1;
    public int g;

    public C0753Y8(Context context) {
        int[] iArr = new int[4];
        this.f3856a = iArr;
        if (context != null) {
            this.f3851a = context;
            Arrays.fill(iArr, -1);
            return;
        }
        throw new NullPointerException("Context may not be null");
    }

    public final int a() {
        int i;
        Activity activity = (Activity) this.f3851a;
        int height = activity.getWindowManager().getDefaultDisplay().getHeight();
        int identifier = activity.getResources().getIdentifier("status_bar_height", "dimen", LogSubCategory.LifeCycle.ANDROID);
        if (identifier > 0) {
            i = activity.getResources().getDimensionPixelSize(identifier);
        } else {
            i = 0;
        }
        int i2 = height - i;
        if (this.g == 0) {
            this.g = (i2 * 2) / 5;
        }
        return this.g;
    }
}
