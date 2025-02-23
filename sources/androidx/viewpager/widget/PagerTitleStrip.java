package androidx.viewpager.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.method.SingleLineTransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.google.firebase.perf.util.Constants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Locale;

@ViewPager.e
public class PagerTitleStrip extends ViewGroup {
    public static final int[] a = {16842804, 16842901, 16842904, 16842927};
    public static final int[] b = {16843660};

    /* renamed from: a  reason: collision with other field name */
    public float f2553a;

    /* renamed from: a  reason: collision with other field name */
    public final TextView f2554a;

    /* renamed from: a  reason: collision with other field name */
    public final a f2555a;

    /* renamed from: a  reason: collision with other field name */
    public ViewPager f2556a;

    /* renamed from: a  reason: collision with other field name */
    public WeakReference<PagerAdapter> f2557a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f2558a;

    /* renamed from: b  reason: collision with other field name */
    public final TextView f2559b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f2560b;
    public int c;

    /* renamed from: c  reason: collision with other field name */
    public final TextView f2561c;
    public int d;
    public int e;
    public int f;
    public int g;

    public class a extends DataSetObserver implements ViewPager.i, ViewPager.h {
        public int a;

        public a() {
        }

        public final void onAdapterChanged(ViewPager viewPager, PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
            PagerTitleStrip.this.a(pagerAdapter, pagerAdapter2);
        }

        public final void onChanged() {
            PagerTitleStrip pagerTitleStrip = PagerTitleStrip.this;
            pagerTitleStrip.b(pagerTitleStrip.f2556a.getCurrentItem(), pagerTitleStrip.f2556a.getAdapter());
            float f = pagerTitleStrip.f2553a;
            if (f < 0.0f) {
                f = 0.0f;
            }
            pagerTitleStrip.c(f, true, pagerTitleStrip.f2556a.getCurrentItem());
        }

        public final void onPageScrollStateChanged(int i) {
            this.a = i;
        }

        public final void onPageScrolled(int i, float f, int i2) {
            if (f > 0.5f) {
                i++;
            }
            PagerTitleStrip.this.c(f, false, i);
        }

        public final void onPageSelected(int i) {
            if (this.a == 0) {
                PagerTitleStrip pagerTitleStrip = PagerTitleStrip.this;
                pagerTitleStrip.b(pagerTitleStrip.f2556a.getCurrentItem(), pagerTitleStrip.f2556a.getAdapter());
                float f = pagerTitleStrip.f2553a;
                if (f < 0.0f) {
                    f = 0.0f;
                }
                pagerTitleStrip.c(f, true, pagerTitleStrip.f2556a.getCurrentItem());
            }
        }
    }

    public static class b extends SingleLineTransformationMethod {
        public final Locale a;

        public b(Context context) {
            this.a = context.getResources().getConfiguration().locale;
        }

        public final CharSequence getTransformation(CharSequence charSequence, View view) {
            CharSequence transformation = super.getTransformation(charSequence, view);
            if (transformation != null) {
                return transformation.toString().toUpperCase(this.a);
            }
            return null;
        }
    }

    public PagerTitleStrip(Context context) {
        this(context, (AttributeSet) null);
    }

    private static void setSingleLineAllCaps(TextView textView) {
        textView.setTransformationMethod(new b(textView.getContext()));
    }

    public final void a(PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
        a aVar = this.f2555a;
        if (pagerAdapter != null) {
            pagerAdapter.unregisterDataSetObserver(aVar);
            this.f2557a = null;
        }
        if (pagerAdapter2 != null) {
            pagerAdapter2.registerDataSetObserver(aVar);
            this.f2557a = new WeakReference<>(pagerAdapter2);
        }
        ViewPager viewPager = this.f2556a;
        if (viewPager != null) {
            this.c = -1;
            this.f2553a = -1.0f;
            b(viewPager.getCurrentItem(), pagerAdapter2);
            requestLayout();
        }
    }

    public final void b(int i, PagerAdapter pagerAdapter) {
        int i2;
        CharSequence charSequence;
        CharSequence charSequence2;
        if (pagerAdapter != null) {
            i2 = pagerAdapter.getCount();
        } else {
            i2 = 0;
        }
        this.f2558a = true;
        CharSequence charSequence3 = null;
        if (i < 1 || pagerAdapter == null) {
            charSequence = null;
        } else {
            charSequence = pagerAdapter.getPageTitle(i - 1);
        }
        TextView textView = this.f2554a;
        textView.setText(charSequence);
        TextView textView2 = this.f2559b;
        if (pagerAdapter == null || i >= i2) {
            charSequence2 = null;
        } else {
            charSequence2 = pagerAdapter.getPageTitle(i);
        }
        textView2.setText(charSequence2);
        int i3 = i + 1;
        if (i3 < i2 && pagerAdapter != null) {
            charSequence3 = pagerAdapter.getPageTitle(i3);
        }
        TextView textView3 = this.f2561c;
        textView3.setText(charSequence3);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(0, (int) (((float) ((getWidth() - getPaddingLeft()) - getPaddingRight())) * 0.8f)), Integer.MIN_VALUE);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (getHeight() - getPaddingTop()) - getPaddingBottom()), Integer.MIN_VALUE);
        textView.measure(makeMeasureSpec, makeMeasureSpec2);
        textView2.measure(makeMeasureSpec, makeMeasureSpec2);
        textView3.measure(makeMeasureSpec, makeMeasureSpec2);
        this.c = i;
        if (!this.f2560b) {
            c(this.f2553a, false, i);
        }
        this.f2558a = false;
    }

    public void c(float f2, boolean z, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        float f3 = f2;
        int i6 = i;
        if (i6 != this.c) {
            b(i6, this.f2556a.getAdapter());
        } else if (!z && f3 == this.f2553a) {
            return;
        }
        this.f2560b = true;
        TextView textView = this.f2554a;
        int measuredWidth = textView.getMeasuredWidth();
        TextView textView2 = this.f2559b;
        int measuredWidth2 = textView2.getMeasuredWidth();
        TextView textView3 = this.f2561c;
        int measuredWidth3 = textView3.getMeasuredWidth();
        int i7 = measuredWidth2 / 2;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i8 = paddingRight + i7;
        int i9 = (width - (paddingLeft + i7)) - i8;
        float f4 = f3 + 0.5f;
        if (f4 > 1.0f) {
            f4 -= 1.0f;
        }
        int i10 = ((width - i8) - ((int) (((float) i9) * f4))) - i7;
        int i11 = measuredWidth2 + i10;
        int baseline = textView.getBaseline();
        int baseline2 = textView2.getBaseline();
        int i12 = measuredWidth3;
        int baseline3 = textView3.getBaseline();
        int i13 = width;
        int max = Math.max(Math.max(baseline, baseline2), baseline3);
        int i14 = max - baseline;
        int i15 = max - baseline2;
        int i16 = max - baseline3;
        int i17 = paddingRight;
        TextView textView4 = textView3;
        int max2 = Math.max(Math.max(textView.getMeasuredHeight() + i14, textView2.getMeasuredHeight() + i15), textView3.getMeasuredHeight() + i16);
        int i18 = this.e & 112;
        if (i18 == 16) {
            i5 = (((height - paddingTop) - paddingBottom) - max2) / 2;
        } else if (i18 != 80) {
            i2 = i14 + paddingTop;
            i4 = i15 + paddingTop;
            i3 = paddingTop + i16;
            textView2.layout(i10, i4, i11, textView2.getMeasuredHeight() + i4);
            int min = Math.min(paddingLeft, (i10 - this.d) - measuredWidth);
            textView.layout(min, i2, measuredWidth + min, textView.getMeasuredHeight() + i2);
            int max3 = Math.max((i13 - i17) - i12, i11 + this.d);
            textView4.layout(max3, i3, max3 + i12, textView4.getMeasuredHeight() + i3);
            this.f2553a = f2;
            this.f2560b = false;
        } else {
            i5 = (height - paddingBottom) - max2;
        }
        i2 = i14 + i5;
        i4 = i15 + i5;
        i3 = i5 + i16;
        textView2.layout(i10, i4, i11, textView2.getMeasuredHeight() + i4);
        int min2 = Math.min(paddingLeft, (i10 - this.d) - measuredWidth);
        textView.layout(min2, i2, measuredWidth + min2, textView.getMeasuredHeight() + i2);
        int max32 = Math.max((i13 - i17) - i12, i11 + this.d);
        textView4.layout(max32, i3, max32 + i12, textView4.getMeasuredHeight() + i3);
        this.f2553a = f2;
        this.f2560b = false;
    }

    public int getMinHeight() {
        Drawable background = getBackground();
        if (background != null) {
            return background.getIntrinsicHeight();
        }
        return 0;
    }

    public int getTextSpacing() {
        return this.d;
    }

    public final void onAttachedToWindow() {
        PagerAdapter pagerAdapter;
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof ViewPager) {
            ViewPager viewPager = (ViewPager) parent;
            PagerAdapter adapter = viewPager.getAdapter();
            a aVar = this.f2555a;
            viewPager.f2583b = aVar;
            if (viewPager.f2587c == null) {
                viewPager.f2587c = new ArrayList();
            }
            viewPager.f2587c.add(aVar);
            this.f2556a = viewPager;
            WeakReference<PagerAdapter> weakReference = this.f2557a;
            if (weakReference != null) {
                pagerAdapter = weakReference.get();
            } else {
                pagerAdapter = null;
            }
            a(pagerAdapter, adapter);
            return;
        }
        throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewPager viewPager = this.f2556a;
        if (viewPager != null) {
            a(viewPager.getAdapter(), (PagerAdapter) null);
            ViewPager viewPager2 = this.f2556a;
            ViewPager.i iVar = viewPager2.f2583b;
            viewPager2.f2583b = null;
            ArrayList arrayList = viewPager2.f2587c;
            if (arrayList != null) {
                arrayList.remove(this.f2555a);
            }
            this.f2556a = null;
        }
    }

    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f2556a != null) {
            float f2 = this.f2553a;
            if (f2 < 0.0f) {
                f2 = 0.0f;
            }
            c(f2, true, this.c);
        }
    }

    public final void onMeasure(int i, int i2) {
        int i3;
        if (View.MeasureSpec.getMode(i) == 1073741824) {
            int paddingBottom = getPaddingBottom() + getPaddingTop();
            int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, paddingBottom, -2);
            int size = View.MeasureSpec.getSize(i);
            int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i, (int) (((float) size) * 0.2f), -2);
            this.f2554a.measure(childMeasureSpec2, childMeasureSpec);
            TextView textView = this.f2559b;
            textView.measure(childMeasureSpec2, childMeasureSpec);
            this.f2561c.measure(childMeasureSpec2, childMeasureSpec);
            if (View.MeasureSpec.getMode(i2) == 1073741824) {
                i3 = View.MeasureSpec.getSize(i2);
            } else {
                i3 = Math.max(getMinHeight(), textView.getMeasuredHeight() + paddingBottom);
            }
            setMeasuredDimension(size, View.resolveSizeAndState(i3, i2, textView.getMeasuredState() << 16));
            return;
        }
        throw new IllegalStateException("Must measure with an exact width");
    }

    public final void requestLayout() {
        if (!this.f2558a) {
            super.requestLayout();
        }
    }

    public void setGravity(int i) {
        this.e = i;
        requestLayout();
    }

    public void setNonPrimaryAlpha(float f2) {
        int i = ((int) (f2 * 255.0f)) & Constants.MAX_HOST_LENGTH;
        this.f = i;
        int i2 = (i << 24) | (this.g & 16777215);
        this.f2554a.setTextColor(i2);
        this.f2561c.setTextColor(i2);
    }

    public void setTextColor(int i) {
        this.g = i;
        this.f2559b.setTextColor(i);
        int i2 = (this.f << 24) | (this.g & 16777215);
        this.f2554a.setTextColor(i2);
        this.f2561c.setTextColor(i2);
    }

    public void setTextSize(int i, float f2) {
        this.f2554a.setTextSize(i, f2);
        this.f2559b.setTextSize(i, f2);
        this.f2561c.setTextSize(i, f2);
    }

    public void setTextSpacing(int i) {
        this.d = i;
        requestLayout();
    }

    public PagerTitleStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = -1;
        this.f2553a = -1.0f;
        this.f2555a = new a();
        TextView textView = new TextView(context);
        this.f2554a = textView;
        addView(textView);
        TextView textView2 = new TextView(context);
        this.f2559b = textView2;
        addView(textView2);
        TextView textView3 = new TextView(context);
        this.f2561c = textView3;
        addView(textView3);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a);
        boolean z = false;
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            textView.setTextAppearance(resourceId);
            textView2.setTextAppearance(resourceId);
            textView3.setTextAppearance(resourceId);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        if (dimensionPixelSize != 0) {
            setTextSize(0, (float) dimensionPixelSize);
        }
        if (obtainStyledAttributes.hasValue(2)) {
            int color = obtainStyledAttributes.getColor(2, 0);
            textView.setTextColor(color);
            textView2.setTextColor(color);
            textView3.setTextColor(color);
        }
        this.e = obtainStyledAttributes.getInteger(3, 80);
        obtainStyledAttributes.recycle();
        this.g = textView2.getTextColors().getDefaultColor();
        setNonPrimaryAlpha(0.6f);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView3.setEllipsize(TextUtils.TruncateAt.END);
        if (resourceId != 0) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, b);
            z = obtainStyledAttributes2.getBoolean(0, false);
            obtainStyledAttributes2.recycle();
        }
        if (z) {
            setSingleLineAllCaps(textView);
            setSingleLineAllCaps(textView2);
            setSingleLineAllCaps(textView3);
        } else {
            textView.setSingleLine();
            textView2.setSingleLine();
            textView3.setSingleLine();
        }
        this.d = (int) (context.getResources().getDisplayMetrics().density * 16.0f);
    }
}
