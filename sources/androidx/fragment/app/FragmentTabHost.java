package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import java.util.ArrayList;

@Deprecated
public class FragmentTabHost extends TabHost implements TabHost.OnTabChangeListener {
    public Context a;

    /* renamed from: a  reason: collision with other field name */
    public FrameLayout f2111a;

    /* renamed from: a  reason: collision with other field name */
    public TabHost.OnTabChangeListener f2112a;

    /* renamed from: a  reason: collision with other field name */
    public FragmentManager f2113a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<a> f2114a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    public boolean f2115a;
    public int c;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public String c;

        public class a implements Parcelable.Creator<SavedState> {
            public final Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public final Object[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("FragmentTabHost.SavedState{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" curTab=");
            return C0709Uj.j(sb, this.c, "}");
        }

        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.c);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.c = parcel.readString();
        }
    }

    public static final class a {
    }

    @Deprecated
    public FragmentTabHost(Context context) {
        super(context, (AttributeSet) null);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, new int[]{16842995}, 0, 0);
        this.c = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        super.setOnTabChangedListener(this);
    }

    public final FragmentTransaction a() {
        ArrayList<a> arrayList = this.f2114a;
        if (arrayList.size() <= 0) {
            return null;
        }
        arrayList.get(0).getClass();
        throw null;
    }

    public final void b() {
        if (this.f2111a == null) {
            FrameLayout frameLayout = (FrameLayout) findViewById(this.c);
            this.f2111a = frameLayout;
            if (frameLayout == null) {
                throw new IllegalStateException("No tab content FrameLayout found for id " + this.c);
            }
        }
    }

    public final void c(Context context) {
        if (findViewById(16908307) == null) {
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
            TabWidget tabWidget = new TabWidget(context);
            tabWidget.setId(16908307);
            tabWidget.setOrientation(0);
            linearLayout.addView(tabWidget, new LinearLayout.LayoutParams(-1, -2, 0.0f));
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.setId(16908305);
            linearLayout.addView(frameLayout, new LinearLayout.LayoutParams(0, 0, 0.0f));
            FrameLayout frameLayout2 = new FrameLayout(context);
            this.f2111a = frameLayout2;
            frameLayout2.setId(this.c);
            linearLayout.addView(frameLayout2, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        }
    }

    @Deprecated
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        getCurrentTabTag();
        ArrayList<a> arrayList = this.f2114a;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            a aVar = arrayList.get(i);
            FragmentManager fragmentManager = this.f2113a;
            aVar.getClass();
            Fragment C = fragmentManager.C((String) null);
            aVar.getClass();
            if (C == null || C.isDetached()) {
                i++;
            } else {
                throw null;
            }
        }
        this.f2115a = true;
        a();
    }

    @Deprecated
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f2115a = false;
    }

    @Deprecated
    public final void onRestoreInstanceState(@SuppressLint({"UnknownNullness"}) Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCurrentTabByTag(savedState.c);
    }

    @Deprecated
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.c = getCurrentTabTag();
        return savedState;
    }

    @Deprecated
    public final void onTabChanged(String str) {
        if (this.f2115a) {
            a();
        }
        TabHost.OnTabChangeListener onTabChangeListener = this.f2112a;
        if (onTabChangeListener != null) {
            onTabChangeListener.onTabChanged(str);
        }
    }

    @Deprecated
    public void setOnTabChangedListener(TabHost.OnTabChangeListener onTabChangeListener) {
        this.f2112a = onTabChangeListener;
    }

    @Deprecated
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    @Deprecated
    public void setup(Context context, FragmentManager fragmentManager) {
        c(context);
        super.setup();
        this.a = context;
        this.f2113a = fragmentManager;
        b();
    }

    @Deprecated
    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842995}, 0, 0);
        this.c = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        super.setOnTabChangedListener(this);
    }

    @Deprecated
    public void setup(Context context, FragmentManager fragmentManager, int i) {
        c(context);
        super.setup();
        this.a = context;
        this.f2113a = fragmentManager;
        this.c = i;
        b();
        this.f2111a.setId(i);
        if (getId() == -1) {
            setId(16908306);
        }
    }
}
