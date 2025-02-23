package defpackage;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import cris.org.in.prs.ima.R;
import in.juspay.hyper.constants.LogSubCategory;

/* renamed from: U8  reason: default package and case insensitive filesystem */
/* compiled from: DialogPlus */
public final class C0704U8 {
    public final Tn a;

    /* renamed from: a  reason: collision with other field name */
    public final b f3800a = new b();

    /* renamed from: a  reason: collision with other field name */
    public final C0737We f3801a;

    /* renamed from: a  reason: collision with other field name */
    public final ViewGroup f3802a;

    /* renamed from: a  reason: collision with other field name */
    public final Animation f3803a;

    /* renamed from: a  reason: collision with other field name */
    public final boolean f3804a;
    public final ViewGroup b;

    /* renamed from: b  reason: collision with other field name */
    public final Animation f3805b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f3806b;
    public final ViewGroup c;

    /* renamed from: U8$b */
    /* compiled from: DialogPlus */
    public class b implements View.OnTouchListener {
        public b() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0) {
                return false;
            }
            C0704U8 u8 = C0704U8.this;
            u8.getClass();
            u8.b();
            return false;
        }
    }

    public C0704U8(C0753Y8 y8) {
        int[] iArr;
        int i;
        int i2;
        C0753Y8 y82 = y8;
        Context context = y82.f3851a;
        LayoutInflater from = LayoutInflater.from(context);
        Activity activity = (Activity) context;
        if (y82.f3850a == null) {
            y82.f3850a = new C1114fi();
        }
        this.f3801a = y82.f3850a;
        this.a = y82.f3849a;
        this.f3804a = y82.f3855a;
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView().findViewById(16908290);
        this.c = viewGroup;
        int i3 = 0;
        ViewGroup viewGroup2 = (ViewGroup) from.inflate(R.layout.base_container, viewGroup, false);
        this.f3802a = viewGroup2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        int[] iArr2 = y82.f3859c;
        layoutParams.setMargins(iArr2[0], iArr2[1], iArr2[2], iArr2[3]);
        viewGroup2.setLayoutParams(layoutParams);
        ViewGroup viewGroup3 = (ViewGroup) viewGroup2.findViewById(R.id.content_container);
        this.b = viewGroup3;
        boolean z = y82.f3857b;
        FrameLayout.LayoutParams layoutParams2 = y82.f3854a;
        if (z) {
            layoutParams2.height = y8.a();
        }
        viewGroup3.setLayoutParams(layoutParams2);
        int i4 = y82.a;
        int i5 = y82.f;
        this.f3803a = AnimationUtils.loadAnimation(context, i5 == -1 ? C0720VB.b(i4, false) : i5);
        int i6 = y82.e;
        this.f3805b = AnimationUtils.loadAnimation(context, i6 == -1 ? C0720VB.b(i4, true) : i6);
        View view = y82.f3852a;
        LayoutInflater from2 = LayoutInflater.from(context);
        View view2 = null;
        if (view == null && (i2 = y82.c) != -1) {
            view = from2.inflate(i2, (ViewGroup) null);
        }
        LayoutInflater from3 = LayoutInflater.from(context);
        int i7 = y82.d;
        view2 = i7 != -1 ? from3.inflate(i7, (ViewGroup) null) : view2;
        BaseAdapter baseAdapter = y82.f3853a;
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.default_center_margin);
        int i8 = 0;
        while (true) {
            iArr = y82.f3856a;
            if (i8 >= iArr.length) {
                break;
            }
            int i9 = iArr[i8];
            if (i4 != 17) {
                if (i9 == -1) {
                    i9 = 0;
                }
            } else if (i9 == -1) {
                i9 = dimensionPixelSize;
            }
            iArr[i8] = i9;
            i8++;
        }
        ViewGroup viewGroup4 = this.f3802a;
        C0737We we = this.f3801a;
        View e = we.e(from, viewGroup4);
        a(view);
        we.c(view);
        a(view2);
        we.b(view2);
        if (baseAdapter != null && (we instanceof C0748Xe)) {
            C0748Xe xe = (C0748Xe) we;
            xe.d(baseAdapter);
            xe.f(new C0718V8(this));
        }
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams3.setMargins(iArr[0], iArr[1], iArr[2], iArr[3]);
        e.setLayoutParams(layoutParams3);
        View g = we.g();
        int[] iArr3 = y82.f3858b;
        g.setPadding(iArr3[0], iArr3[1], iArr3[2], iArr3[3]);
        this.b.addView(e);
        if (this.f3804a) {
            this.f3802a.findViewById(R.id.outmost_container).setOnTouchListener(this.f3800a);
        }
        if (y82.f3857b) {
            int a2 = y8.a();
            if (y82.f3857b) {
                layoutParams2.height = y8.a();
            }
            int i10 = layoutParams2.gravity;
            int height = activity.getWindowManager().getDefaultDisplay().getHeight();
            int identifier = activity.getResources().getIdentifier("status_bar_height", "dimen", LogSubCategory.LifeCycle.ANDROID);
            int dimensionPixelSize2 = height - (identifier > 0 ? activity.getResources().getDimensionPixelSize(identifier) : i3);
            if (a2 == 0) {
                i = (dimensionPixelSize2 * 2) / 5;
            } else {
                i = a2;
            }
            View g2 = this.f3801a.g();
            if (g2 instanceof AbsListView) {
                g2.setOnTouchListener(new C0516Gb(activity, (AbsListView) g2, this.b, i10, dimensionPixelSize2, i));
            }
        }
    }

    public final void a(View view) {
        if (view != null) {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                    a(viewGroup.getChildAt(childCount));
                }
            }
            if (view.getId() != -1 && !(view instanceof AdapterView)) {
                view.setOnClickListener(new C0732W8(this));
            }
        }
    }

    public final void b() {
        if (!this.f3806b) {
            a aVar = new a();
            Animation animation = this.f3803a;
            animation.setAnimationListener(aVar);
            this.b.startAnimation(animation);
            this.f3806b = true;
        }
    }

    /* renamed from: U8$a */
    /* compiled from: DialogPlus */
    public class a implements Animation.AnimationListener {

        /* renamed from: U8$a$a  reason: collision with other inner class name */
        /* compiled from: DialogPlus */
        public class C0048a implements Runnable {
            public C0048a() {
            }

            public final void run() {
                a aVar = a.this;
                C0704U8 u8 = C0704U8.this;
                u8.c.removeView(u8.f3802a);
                C0704U8 u82 = C0704U8.this;
                u82.f3806b = false;
                u82.getClass();
            }
        }

        public a() {
        }

        public final void onAnimationEnd(Animation animation) {
            C0704U8.this.c.post(new C0048a());
        }

        public final void onAnimationRepeat(Animation animation) {
        }

        public final void onAnimationStart(Animation animation) {
        }
    }
}
