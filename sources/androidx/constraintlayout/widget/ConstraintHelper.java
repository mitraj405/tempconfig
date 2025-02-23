package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.Constraints;
import com.google.ads.mediation.facebook.FacebookMediationAdapter;
import java.util.Arrays;
import java.util.HashMap;

public abstract class ConstraintHelper extends View {
    public Te a;

    /* renamed from: a  reason: collision with other field name */
    public final Context f1621a;

    /* renamed from: a  reason: collision with other field name */
    public final HashMap<Integer, String> f1622a = new HashMap<>();

    /* renamed from: a  reason: collision with other field name */
    public int[] f1623a = new int[32];

    /* renamed from: a  reason: collision with other field name */
    public View[] f1624a = null;
    public int c;

    /* renamed from: c  reason: collision with other field name */
    public String f1625c;
    public String d;

    public ConstraintHelper(Context context) {
        super(context);
        this.f1621a = context;
        n((AttributeSet) null);
    }

    public final void e(String str) {
        if (str != null && str.length() != 0 && this.f1621a != null) {
            String trim = str.trim();
            if (getParent() instanceof ConstraintLayout) {
                ConstraintLayout constraintLayout = (ConstraintLayout) getParent();
            }
            int l = l(trim);
            if (l != 0) {
                this.f1622a.put(Integer.valueOf(l), trim);
                f(l);
            }
        }
    }

    public final void f(int i) {
        if (i != getId()) {
            int i2 = this.c + 1;
            int[] iArr = this.f1623a;
            if (i2 > iArr.length) {
                this.f1623a = Arrays.copyOf(iArr, iArr.length * 2);
            }
            int[] iArr2 = this.f1623a;
            int i3 = this.c;
            iArr2[i3] = i;
            this.c = i3 + 1;
        }
    }

    public final void g(String str) {
        ConstraintLayout constraintLayout;
        if (str != null && str.length() != 0 && this.f1621a != null) {
            String trim = str.trim();
            if (getParent() instanceof ConstraintLayout) {
                constraintLayout = (ConstraintLayout) getParent();
            } else {
                constraintLayout = null;
            }
            if (constraintLayout != null) {
                int childCount = constraintLayout.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = constraintLayout.getChildAt(i);
                    ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                    if ((layoutParams instanceof ConstraintLayout.LayoutParams) && trim.equals(((ConstraintLayout.LayoutParams) layoutParams).f1631b) && childAt.getId() != -1) {
                        f(childAt.getId());
                    }
                }
            }
        }
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f1623a, this.c);
    }

    public final void h() {
        ViewParent parent = getParent();
        if (parent != null && (parent instanceof ConstraintLayout)) {
            i((ConstraintLayout) parent);
        }
    }

    public final void i(ConstraintLayout constraintLayout) {
        int visibility = getVisibility();
        float elevation = getElevation();
        for (int i = 0; i < this.c; i++) {
            View viewById = constraintLayout.getViewById(this.f1623a[i]);
            if (viewById != null) {
                viewById.setVisibility(visibility);
                if (elevation > 0.0f) {
                    viewById.setTranslationZ(viewById.getTranslationZ() + elevation);
                }
            }
        }
    }

    public final int k(ConstraintLayout constraintLayout, String str) {
        Resources resources;
        String str2;
        if (str == null || constraintLayout == null || (resources = this.f1621a.getResources()) == null) {
            return 0;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            if (childAt.getId() != -1) {
                try {
                    str2 = resources.getResourceEntryName(childAt.getId());
                } catch (Resources.NotFoundException unused) {
                    str2 = null;
                }
                if (str.equals(str2)) {
                    return childAt.getId();
                }
            }
        }
        return 0;
    }

    public final int l(String str) {
        ConstraintLayout constraintLayout;
        if (getParent() instanceof ConstraintLayout) {
            constraintLayout = (ConstraintLayout) getParent();
        } else {
            constraintLayout = null;
        }
        int i = 0;
        if (isInEditMode() && constraintLayout != null) {
            Object designInformation = constraintLayout.getDesignInformation(0, str);
            if (designInformation instanceof Integer) {
                i = ((Integer) designInformation).intValue();
            }
        }
        if (i == 0 && constraintLayout != null) {
            i = k(constraintLayout, str);
        }
        if (i == 0) {
            try {
                i = Ir.class.getField(str).getInt((Object) null);
            } catch (Exception unused) {
            }
        }
        if (i != 0) {
            return i;
        }
        Context context = this.f1621a;
        return context.getResources().getIdentifier(str, FacebookMediationAdapter.KEY_ID, context.getPackageName());
    }

    public final View[] m(ConstraintLayout constraintLayout) {
        View[] viewArr = this.f1624a;
        if (viewArr == null || viewArr.length != this.c) {
            this.f1624a = new View[this.c];
        }
        for (int i = 0; i < this.c; i++) {
            this.f1624a[i] = constraintLayout.getViewById(this.f1623a[i]);
        }
        return this.f1624a;
    }

    public void n(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C0221hs.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == C0221hs.ConstraintLayout_Layout_constraint_referenced_ids) {
                    String string = obtainStyledAttributes.getString(index);
                    this.f1625c = string;
                    setIds(string);
                } else if (index == C0221hs.ConstraintLayout_Layout_constraint_referenced_tags) {
                    String string2 = obtainStyledAttributes.getString(index);
                    this.d = string2;
                    setReferenceTags(string2);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void o(ConstraintSet.a aVar, Te te, Constraints.LayoutParams layoutParams, SparseArray sparseArray) {
        ConstraintSet.b bVar = aVar.f1665a;
        int[] iArr = bVar.f1682a;
        int i = 0;
        if (iArr != null) {
            setReferencedIds(iArr);
        } else {
            String str = bVar.f1684b;
            if (str != null) {
                if (str.length() > 0) {
                    String[] split = bVar.f1684b.split(",");
                    getContext();
                    int[] iArr2 = new int[split.length];
                    int i2 = 0;
                    for (String trim : split) {
                        int l = l(trim.trim());
                        if (l != 0) {
                            iArr2[i2] = l;
                            i2++;
                        }
                    }
                    if (i2 != split.length) {
                        iArr2 = Arrays.copyOf(iArr2, i2);
                    }
                    bVar.f1682a = iArr2;
                } else {
                    bVar.f1682a = null;
                }
            }
        }
        te.a();
        if (bVar.f1682a != null) {
            while (true) {
                int[] iArr3 = bVar.f1682a;
                if (i < iArr3.length) {
                    ConstraintWidget constraintWidget = (ConstraintWidget) sparseArray.get(iArr3[i]);
                    if (constraintWidget != null) {
                        te.c(constraintWidget);
                    }
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.f1625c;
        if (str != null) {
            setIds(str);
        }
        String str2 = this.d;
        if (str2 != null) {
            setReferenceTags(str2);
        }
    }

    public void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    public void s(Re re, SparseArray sparseArray) {
        re.a();
        for (int i = 0; i < this.c; i++) {
            re.c((ConstraintWidget) sparseArray.get(this.f1623a[i]));
        }
    }

    public void setIds(String str) {
        this.f1625c = str;
        if (str != null) {
            int i = 0;
            this.c = 0;
            while (true) {
                int indexOf = str.indexOf(44, i);
                if (indexOf == -1) {
                    e(str.substring(i));
                    return;
                } else {
                    e(str.substring(i, indexOf));
                    i = indexOf + 1;
                }
            }
        }
    }

    public void setReferenceTags(String str) {
        this.d = str;
        if (str != null) {
            int i = 0;
            this.c = 0;
            while (true) {
                int indexOf = str.indexOf(44, i);
                if (indexOf == -1) {
                    g(str.substring(i));
                    return;
                } else {
                    g(str.substring(i, indexOf));
                    i = indexOf + 1;
                }
            }
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.f1625c = null;
        this.c = 0;
        for (int f : iArr) {
            f(f);
        }
    }

    public void setTag(int i, Object obj) {
        super.setTag(i, obj);
        if (obj == null && this.f1625c == null) {
            f(i);
        }
    }

    public final void t() {
        if (this.a != null) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams instanceof ConstraintLayout.LayoutParams) {
                ((ConstraintLayout.LayoutParams) layoutParams).f1627a = this.a;
            }
        }
    }

    public ConstraintHelper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1621a = context;
        n(attributeSet);
    }

    public ConstraintHelper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1621a = context;
        n(attributeSet);
    }

    public void q() {
    }

    public void j(ConstraintLayout constraintLayout) {
    }

    public final void onDraw(Canvas canvas) {
    }

    public void r(ConstraintLayout constraintLayout) {
    }

    public void p(ConstraintWidget constraintWidget, boolean z) {
    }
}
