package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.ActionMenuPresenter;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.common.primitives.Ints;

public class ActionMenuItemView extends AppCompatTextView implements MenuView.a, View.OnClickListener, ActionMenuView.a {
    public Drawable a;

    /* renamed from: a  reason: collision with other field name */
    public a f995a;

    /* renamed from: a  reason: collision with other field name */
    public b f996a;

    /* renamed from: a  reason: collision with other field name */
    public MenuBuilder.a f997a;

    /* renamed from: a  reason: collision with other field name */
    public MenuItemImpl f998a;

    /* renamed from: a  reason: collision with other field name */
    public CharSequence f999a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f1000a;
    public boolean b;
    public final int d;
    public int e;
    public final int f;

    public class a extends C0259ld {
        public a() {
            super(ActionMenuItemView.this);
        }

        public final Fw b() {
            ActionMenuPresenter.a aVar;
            b bVar = ActionMenuItemView.this.f996a;
            if (bVar == null || (aVar = ActionMenuPresenter.this.f1129a) == null) {
                return null;
            }
            return aVar.a();
        }

        public final boolean c() {
            Fw b;
            ActionMenuItemView actionMenuItemView = ActionMenuItemView.this;
            MenuBuilder.a aVar = actionMenuItemView.f997a;
            if (aVar == null || !aVar.a(actionMenuItemView.f998a) || (b = b()) == null || !b.a()) {
                return false;
            }
            return true;
        }
    }

    public static abstract class b {
    }

    public ActionMenuItemView(Context context) {
        this(context, (AttributeSet) null);
    }

    public final boolean a() {
        return c();
    }

    public final boolean b() {
        if (!c() || this.f998a.getIcon() != null) {
            return false;
        }
        return true;
    }

    public final boolean c() {
        return !TextUtils.isEmpty(getText());
    }

    public final boolean d() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        int i2 = configuration.screenHeightDp;
        if (i >= 480 || ((i >= 640 && i2 >= 480) || configuration.orientation == 2)) {
            return true;
        }
        return false;
    }

    public final void e() {
        CharSequence charSequence;
        CharSequence charSequence2;
        boolean z;
        boolean z2 = true;
        boolean z3 = !TextUtils.isEmpty(this.f999a);
        if (this.a != null) {
            if ((this.f998a.i & 4) == 4) {
                z = true;
            } else {
                z = false;
            }
            if (!z || (!this.f1000a && !this.b)) {
                z2 = false;
            }
        }
        boolean z4 = z3 & z2;
        CharSequence charSequence3 = null;
        if (z4) {
            charSequence = this.f999a;
        } else {
            charSequence = null;
        }
        setText(charSequence);
        CharSequence charSequence4 = this.f998a.f1033c;
        if (TextUtils.isEmpty(charSequence4)) {
            if (z4) {
                charSequence2 = null;
            } else {
                charSequence2 = this.f998a.f1028a;
            }
            setContentDescription(charSequence2);
        } else {
            setContentDescription(charSequence4);
        }
        CharSequence charSequence5 = this.f998a.f1035d;
        if (TextUtils.isEmpty(charSequence5)) {
            if (!z4) {
                charSequence3 = this.f998a.f1028a;
            }
            C0234jA.a(this, charSequence3);
            return;
        }
        C0234jA.a(this, charSequence5);
    }

    public CharSequence getAccessibilityClassName() {
        return Button.class.getName();
    }

    public MenuItemImpl getItemData() {
        return this.f998a;
    }

    public final void initialize(MenuItemImpl menuItemImpl, int i) {
        int i2;
        this.f998a = menuItemImpl;
        setIcon(menuItemImpl.getIcon());
        setTitle(menuItemImpl.getTitleCondensed());
        setId(menuItemImpl.f1016a);
        if (menuItemImpl.isVisible()) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        setVisibility(i2);
        setEnabled(menuItemImpl.isEnabled());
        if (menuItemImpl.hasSubMenu() && this.f995a == null) {
            this.f995a = new a();
        }
    }

    public final void onClick(View view) {
        MenuBuilder.a aVar = this.f997a;
        if (aVar != null) {
            aVar.a(this.f998a);
        }
    }

    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f1000a = d();
        e();
    }

    public final void onMeasure(int i, int i2) {
        int i3;
        int i4;
        boolean c = c();
        if (c && (i4 = this.e) >= 0) {
            super.setPadding(i4, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        int i5 = this.d;
        if (mode == Integer.MIN_VALUE) {
            i3 = Math.min(size, i5);
        } else {
            i3 = i5;
        }
        if (mode != 1073741824 && i5 > 0 && measuredWidth < i3) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(i3, Ints.MAX_POWER_OF_TWO), i2);
        }
        if (!c && this.a != null) {
            super.setPadding((getMeasuredWidth() - this.a.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState((Parcelable) null);
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        a aVar;
        if (!this.f998a.hasSubMenu() || (aVar = this.f995a) == null || !aVar.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public void setExpandedFormat(boolean z) {
        if (this.b != z) {
            this.b = z;
            MenuItemImpl menuItemImpl = this.f998a;
            if (menuItemImpl != null) {
                menuItemImpl.f1026a.onItemActionRequestChanged(menuItemImpl);
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.a = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i = this.f;
            if (intrinsicWidth > i) {
                intrinsicHeight = (int) (((float) intrinsicHeight) * (((float) i) / ((float) intrinsicWidth)));
                intrinsicWidth = i;
            }
            if (intrinsicHeight > i) {
                intrinsicWidth = (int) (((float) intrinsicWidth) * (((float) i) / ((float) intrinsicHeight)));
            } else {
                i = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i);
        }
        setCompoundDrawables(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        e();
    }

    public void setItemInvoker(MenuBuilder.a aVar) {
        this.f997a = aVar;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.e = i;
        super.setPadding(i, i2, i3, i4);
    }

    public void setPopupCallback(b bVar) {
        this.f996a = bVar;
    }

    public void setTitle(CharSequence charSequence) {
        this.f999a = charSequence;
        e();
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Resources resources = context.getResources();
        this.f1000a = d();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ps.ActionMenuItemView, i, 0);
        this.d = obtainStyledAttributes.getDimensionPixelSize(ps.ActionMenuItemView_android_minWidth, 0);
        obtainStyledAttributes.recycle();
        this.f = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.e = -1;
        setSaveEnabled(false);
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public void setShortcut(boolean z, char c) {
    }
}
