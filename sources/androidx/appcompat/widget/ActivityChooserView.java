package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import com.google.common.primitives.Ints;
import defpackage.G;

public class ActivityChooserView extends ViewGroup {
    public G a;

    /* renamed from: a  reason: collision with other field name */
    public final View f1145a;

    /* renamed from: a  reason: collision with other field name */
    public final FrameLayout f1146a;

    /* renamed from: a  reason: collision with other field name */
    public final ImageView f1147a;

    /* renamed from: a  reason: collision with other field name */
    public PopupWindow.OnDismissListener f1148a;

    /* renamed from: a  reason: collision with other field name */
    public final b f1149a;

    /* renamed from: a  reason: collision with other field name */
    public final f f1150a;

    /* renamed from: a  reason: collision with other field name */
    public final g f1151a;

    /* renamed from: a  reason: collision with other field name */
    public ListPopupWindow f1152a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f1153a;
    public final FrameLayout b;

    public static class InnerLayout extends LinearLayout {
        public static final int[] a = {16842964};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TintTypedArray tintTypedArray = new TintTypedArray(context, context.obtainStyledAttributes(attributeSet, a));
            setBackgroundDrawable(tintTypedArray.e(0));
            tintTypedArray.n();
        }
    }

    public class a extends DataSetObserver {
        public a() {
        }

        public final void onChanged() {
            super.onChanged();
            ActivityChooserView.this.f1150a.notifyDataSetChanged();
        }

        public final void onInvalidated() {
            super.onInvalidated();
            ActivityChooserView.this.f1150a.notifyDataSetInvalidated();
        }
    }

    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public b() {
        }

        public final void onGlobalLayout() {
            G.a aVar;
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (!activityChooserView.b()) {
                return;
            }
            if (!activityChooserView.isShown()) {
                activityChooserView.getListPopupWindow().dismiss();
                return;
            }
            activityChooserView.getListPopupWindow().show();
            G g = activityChooserView.a;
            if (g != null && (aVar = g.a) != null) {
                ((ActionMenuPresenter) aVar).d(true);
            }
        }
    }

    public class c extends View.AccessibilityDelegate {
        public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            accessibilityNodeInfo.setCanOpenPopup(true);
        }
    }

    public class d extends C0259ld {
        public d(FrameLayout frameLayout) {
            super(frameLayout);
        }

        public final Fw b() {
            return ActivityChooserView.this.getListPopupWindow();
        }

        public final boolean c() {
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (activityChooserView.b() || !activityChooserView.f1153a) {
                return true;
            }
            activityChooserView.f1150a.getClass();
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }

        public final boolean d() {
            ActivityChooserView.this.a();
            return true;
        }
    }

    public class e extends DataSetObserver {
        public e() {
        }

        public final void onChanged() {
            super.onChanged();
            ActivityChooserView.this.f1150a.getClass();
            throw null;
        }
    }

    public class f extends BaseAdapter {
        public f() {
        }

        public final int getCount() {
            throw null;
        }

        public final Object getItem(int i) {
            throw null;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final int getItemViewType(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            getItemViewType(i);
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (view == null || view.getId() != Gr.list_item) {
                view = LayoutInflater.from(activityChooserView.getContext()).inflate(Vr.abc_activity_chooser_view_list_item, viewGroup, false);
            }
            activityChooserView.getContext().getPackageManager();
            ImageView imageView = (ImageView) view.findViewById(Gr.icon);
            getItem(i);
            throw null;
        }

        public final int getViewTypeCount() {
            return 3;
        }
    }

    public class g implements AdapterView.OnItemClickListener, View.OnClickListener, View.OnLongClickListener, PopupWindow.OnDismissListener {
        public g() {
        }

        public final void onClick(View view) {
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            FrameLayout frameLayout = activityChooserView.b;
            f fVar = activityChooserView.f1150a;
            if (view == frameLayout) {
                activityChooserView.a();
                fVar.getClass();
                throw null;
            } else if (view == activityChooserView.f1146a) {
                fVar.getClass();
                throw new IllegalStateException("No data model. Did you call #setDataModel?");
            } else {
                throw new IllegalArgumentException();
            }
        }

        public final void onDismiss() {
            G.a aVar;
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            PopupWindow.OnDismissListener onDismissListener = activityChooserView.f1148a;
            if (onDismissListener != null) {
                onDismissListener.onDismiss();
            }
            G g = activityChooserView.a;
            if (g != null && (aVar = g.a) != null) {
                ((ActionMenuPresenter) aVar).d(false);
            }
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ((f) adapterView.getAdapter()).getClass();
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            activityChooserView.a();
            activityChooserView.f1150a.getClass();
            throw null;
        }

        public final boolean onLongClick(View view) {
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (view == activityChooserView.b) {
                activityChooserView.f1150a.getClass();
                throw null;
            }
            throw new IllegalArgumentException();
        }
    }

    public ActivityChooserView(Context context) {
        this(context, (AttributeSet) null);
    }

    public final void a() {
        if (b()) {
            getListPopupWindow().dismiss();
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeGlobalOnLayoutListener(this.f1149a);
            }
        }
    }

    public final boolean b() {
        return getListPopupWindow().a();
    }

    public I getDataModel() {
        this.f1150a.getClass();
        return null;
    }

    public ListPopupWindow getListPopupWindow() {
        if (this.f1152a == null) {
            ListPopupWindow listPopupWindow = new ListPopupWindow(getContext());
            this.f1152a = listPopupWindow;
            listPopupWindow.i(this.f1150a);
            ListPopupWindow listPopupWindow2 = this.f1152a;
            listPopupWindow2.f1200a = this;
            listPopupWindow2.f1214d = true;
            listPopupWindow2.f1204a.setFocusable(true);
            ListPopupWindow listPopupWindow3 = this.f1152a;
            g gVar = this.f1151a;
            listPopupWindow3.f1201a = gVar;
            listPopupWindow3.f1204a.setOnDismissListener(gVar);
        }
        return this.f1152a;
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f1150a.getClass();
        this.f1153a = true;
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f1150a.getClass();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f1149a);
        }
        if (b()) {
            a();
        }
        this.f1153a = false;
    }

    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f1145a.layout(0, 0, i3 - i, i4 - i2);
        if (!b()) {
            a();
        }
    }

    public final void onMeasure(int i, int i2) {
        if (this.b.getVisibility() != 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), Ints.MAX_POWER_OF_TWO);
        }
        View view = this.f1145a;
        measureChild(view, i, i2);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public void setActivityChooserModel(I i) {
        f fVar = this.f1150a;
        ActivityChooserView.this.f1150a.getClass();
        fVar.notifyDataSetChanged();
        if (b()) {
            a();
            if (!b() && this.f1153a) {
                fVar.getClass();
                throw new IllegalStateException("No data model. Did you call #setDataModel?");
            }
        }
    }

    public void setExpandActivityOverflowButtonContentDescription(int i) {
        this.f1147a.setContentDescription(getContext().getString(i));
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.f1147a.setImageDrawable(drawable);
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.f1148a = onDismissListener;
    }

    public void setProvider(G g2) {
        this.a = g2;
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        new a();
        this.f1149a = new b();
        int[] iArr = ps.ActivityChooserView;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i, 0);
        androidx.core.view.f.n(this, context, iArr, attributeSet, obtainStyledAttributes, i);
        obtainStyledAttributes.getInt(ps.ActivityChooserView_initialActivityCount, 4);
        Drawable drawable = obtainStyledAttributes.getDrawable(ps.ActivityChooserView_expandActivityOverflowButtonDrawable);
        obtainStyledAttributes.recycle();
        LayoutInflater.from(getContext()).inflate(Vr.abc_activity_chooser_view, this, true);
        g gVar = new g();
        this.f1151a = gVar;
        View findViewById = findViewById(Gr.activity_chooser_view_content);
        this.f1145a = findViewById;
        findViewById.getBackground();
        FrameLayout frameLayout = (FrameLayout) findViewById(Gr.default_activity_button);
        this.b = frameLayout;
        frameLayout.setOnClickListener(gVar);
        frameLayout.setOnLongClickListener(gVar);
        int i2 = Gr.image;
        ImageView imageView = (ImageView) frameLayout.findViewById(i2);
        FrameLayout frameLayout2 = (FrameLayout) findViewById(Gr.expand_activities_button);
        frameLayout2.setOnClickListener(gVar);
        frameLayout2.setAccessibilityDelegate(new c());
        frameLayout2.setOnTouchListener(new d(frameLayout2));
        this.f1146a = frameLayout2;
        ImageView imageView2 = (ImageView) frameLayout2.findViewById(i2);
        this.f1147a = imageView2;
        imageView2.setImageDrawable(drawable);
        f fVar = new f();
        this.f1150a = fVar;
        fVar.registerDataSetObserver(new e());
        Resources resources = context.getResources();
        Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(tr.abc_config_prefDialogWidth));
    }

    public void setDefaultActionButtonContentDescription(int i) {
    }

    public void setInitialActivityCount(int i) {
    }
}
