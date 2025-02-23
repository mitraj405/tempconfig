package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.widget.ActionMenuView;
import defpackage.G;
import defpackage.v9;
import java.util.ArrayList;

public final class ActionMenuPresenter extends androidx.appcompat.view.menu.a implements G.a {
    public Drawable a;

    /* renamed from: a  reason: collision with other field name */
    public final SparseBooleanArray f1128a = new SparseBooleanArray();

    /* renamed from: a  reason: collision with other field name */
    public a f1129a;

    /* renamed from: a  reason: collision with other field name */
    public b f1130a;

    /* renamed from: a  reason: collision with other field name */
    public c f1131a;

    /* renamed from: a  reason: collision with other field name */
    public d f1132a;

    /* renamed from: a  reason: collision with other field name */
    public e f1133a;

    /* renamed from: a  reason: collision with other field name */
    public final f f1134a = new f();

    /* renamed from: a  reason: collision with other field name */
    public boolean f1135a;
    public boolean b;
    public boolean c;
    public boolean d;
    public int f;
    public int g;
    public int h;
    public int i;

    @SuppressLint({"BanParcelableUsage"})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public int c;

        public class a implements Parcelable.Creator<SavedState> {
            public final Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public final Object[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public SavedState() {
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.c);
        }

        public SavedState(Parcel parcel) {
            this.c = parcel.readInt();
        }
    }

    public class a extends g {
        public a(Context context, SubMenuBuilder subMenuBuilder, View view) {
            super(context, subMenuBuilder, view, false, C0220hr.actionOverflowMenuStyle);
            boolean z;
            if ((((MenuItemImpl) subMenuBuilder.getItem()).h & 32) == 32) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                View view2 = ActionMenuPresenter.this.f1132a;
                this.f1072a = view2 == null ? (View) ActionMenuPresenter.this.f1040a : view2;
            }
            f fVar = ActionMenuPresenter.this.f1134a;
            this.f1075a = fVar;
            bl blVar = this.f1077a;
            if (blVar != null) {
                blVar.setCallback(fVar);
            }
        }

        public final void c() {
            ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
            actionMenuPresenter.f1129a = null;
            actionMenuPresenter.i = 0;
            super.c();
        }
    }

    public class b extends ActionMenuItemView.b {
        public b() {
        }
    }

    public class c implements Runnable {
        public final e a;

        public c(e eVar) {
            this.a = eVar;
        }

        public final void run() {
            ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
            MenuBuilder menuBuilder = actionMenuPresenter.f1038a;
            if (menuBuilder != null) {
                menuBuilder.changeMenuMode();
            }
            View view = (View) actionMenuPresenter.f1040a;
            if (!(view == null || view.getWindowToken() == null)) {
                e eVar = this.a;
                boolean z = true;
                if (!eVar.b()) {
                    if (eVar.f1072a == null) {
                        z = false;
                    } else {
                        eVar.d(0, 0, false, false);
                    }
                }
                if (z) {
                    actionMenuPresenter.f1133a = eVar;
                }
            }
            actionMenuPresenter.f1131a = null;
        }
    }

    public class d extends AppCompatImageView implements ActionMenuView.a {

        public class a extends C0259ld {
            public a(View view) {
                super(view);
            }

            public final Fw b() {
                e eVar = ActionMenuPresenter.this.f1133a;
                if (eVar == null) {
                    return null;
                }
                return eVar.a();
            }

            public final boolean c() {
                ActionMenuPresenter.this.e();
                return true;
            }

            public final boolean d() {
                ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
                if (actionMenuPresenter.f1131a != null) {
                    return false;
                }
                actionMenuPresenter.b();
                return true;
            }
        }

        public d(Context context) {
            super(context, (AttributeSet) null, C0220hr.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            C0234jA.a(this, getContentDescription());
            setOnTouchListener(new a(this));
        }

        public final boolean a() {
            return false;
        }

        public final boolean b() {
            return false;
        }

        public final boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            ActionMenuPresenter.this.e();
            return true;
        }

        public final boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (!(drawable == null || background == null)) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                v9.a.f(background, paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
            }
            return frame;
        }
    }

    public class e extends g {
        public e(Context context, MenuBuilder menuBuilder, d dVar) {
            super(context, menuBuilder, dVar, true, C0220hr.actionOverflowMenuStyle);
            this.c = 8388613;
            f fVar = ActionMenuPresenter.this.f1134a;
            this.f1075a = fVar;
            bl blVar = this.f1077a;
            if (blVar != null) {
                blVar.setCallback(fVar);
            }
        }

        public final void c() {
            ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
            MenuBuilder menuBuilder = actionMenuPresenter.f1038a;
            if (menuBuilder != null) {
                menuBuilder.close();
            }
            actionMenuPresenter.f1133a = null;
            super.c();
        }
    }

    public class f implements MenuPresenter.Callback {
        public f() {
        }

        public final boolean a(MenuBuilder menuBuilder) {
            ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
            if (menuBuilder == actionMenuPresenter.f1038a) {
                return false;
            }
            actionMenuPresenter.i = ((SubMenuBuilder) menuBuilder).getItem().getItemId();
            MenuPresenter.Callback callback = actionMenuPresenter.f1039a;
            if (callback != null) {
                return callback.a(menuBuilder);
            }
            return false;
        }

        public final void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
            if (menuBuilder instanceof SubMenuBuilder) {
                menuBuilder.getRootMenu().close(false);
            }
            MenuPresenter.Callback callback = ActionMenuPresenter.this.f1039a;
            if (callback != null) {
                callback.onCloseMenu(menuBuilder, z);
            }
        }
    }

    public ActionMenuPresenter(Context context) {
        super(context, Vr.abc_action_menu_layout, Vr.abc_action_menu_item_layout);
    }

    public final View a(MenuItemImpl menuItemImpl, View view, ViewGroup viewGroup) {
        MenuView.a aVar;
        View actionView = menuItemImpl.getActionView();
        int i2 = 0;
        if (actionView == null || menuItemImpl.g()) {
            if (view instanceof MenuView.a) {
                aVar = (MenuView.a) view;
            } else {
                aVar = (MenuView.a) this.f1037a.inflate(this.d, viewGroup, false);
            }
            aVar.initialize(menuItemImpl, 0);
            ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
            actionMenuItemView.setItemInvoker((ActionMenuView) this.f1040a);
            if (this.f1130a == null) {
                this.f1130a = new b();
            }
            actionMenuItemView.setPopupCallback(this.f1130a);
            actionView = (View) aVar;
        }
        if (menuItemImpl.f1036d) {
            i2 = 8;
        }
        actionView.setVisibility(i2);
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!((ActionMenuView) viewGroup).checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(ActionMenuView.b(layoutParams));
        }
        return actionView;
    }

    public final boolean b() {
        MenuView menuView;
        c cVar = this.f1131a;
        if (cVar == null || (menuView = this.f1040a) == null) {
            e eVar = this.f1133a;
            if (eVar == null) {
                return false;
            }
            if (eVar.b()) {
                eVar.f1077a.dismiss();
            }
            return true;
        }
        ((View) menuView).removeCallbacks(cVar);
        this.f1131a = null;
        return true;
    }

    public final boolean c() {
        e eVar = this.f1133a;
        if (eVar == null || !eVar.b()) {
            return false;
        }
        return true;
    }

    public final void d(boolean z) {
        if (z) {
            MenuPresenter.Callback callback = this.f1039a;
            if (callback != null) {
                callback.a(this.f1038a);
                return;
            }
            return;
        }
        MenuBuilder menuBuilder = this.f1038a;
        if (menuBuilder != null) {
            menuBuilder.close(false);
        }
    }

    public final boolean e() {
        MenuBuilder menuBuilder;
        if (!this.b || c() || (menuBuilder = this.f1038a) == null || this.f1040a == null || this.f1131a != null || menuBuilder.getNonActionItems().isEmpty()) {
            return false;
        }
        c cVar = new c(new e(this.b, this.f1038a, this.f1132a));
        this.f1131a = cVar;
        ((View) this.f1040a).post(cVar);
        return true;
    }

    public final boolean flagActionItems() {
        int i2;
        ArrayList<MenuItemImpl> arrayList;
        int i3;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        ActionMenuPresenter actionMenuPresenter = this;
        MenuBuilder menuBuilder = actionMenuPresenter.f1038a;
        if (menuBuilder != null) {
            arrayList = menuBuilder.getVisibleItems();
            i2 = arrayList.size();
        } else {
            i2 = 0;
            arrayList = null;
        }
        int i4 = actionMenuPresenter.h;
        int i5 = actionMenuPresenter.g;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) actionMenuPresenter.f1040a;
        int i6 = 0;
        boolean z9 = false;
        int i7 = 0;
        int i8 = 0;
        while (true) {
            i3 = 2;
            z = true;
            if (i6 >= i2) {
                break;
            }
            MenuItemImpl menuItemImpl = arrayList.get(i6);
            int i9 = menuItemImpl.i;
            if ((i9 & 2) == 2) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                i7++;
            } else {
                if ((i9 & 1) == 1) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                if (z8) {
                    i8++;
                } else {
                    z9 = true;
                }
            }
            if (actionMenuPresenter.d && menuItemImpl.f1036d) {
                i4 = 0;
            }
            i6++;
        }
        if (actionMenuPresenter.b && (z9 || i8 + i7 > i4)) {
            i4--;
        }
        int i10 = i4 - i7;
        SparseBooleanArray sparseBooleanArray = actionMenuPresenter.f1128a;
        sparseBooleanArray.clear();
        int i11 = 0;
        int i12 = 0;
        while (i11 < i2) {
            MenuItemImpl menuItemImpl2 = arrayList.get(i11);
            int i13 = menuItemImpl2.i;
            if ((i13 & 2) == i3) {
                z2 = z;
            } else {
                z2 = false;
            }
            int i14 = menuItemImpl2.f1030b;
            if (z2) {
                View a2 = actionMenuPresenter.a(menuItemImpl2, (View) null, viewGroup);
                a2.measure(makeMeasureSpec, makeMeasureSpec);
                int measuredWidth = a2.getMeasuredWidth();
                i5 -= measuredWidth;
                if (i12 == 0) {
                    i12 = measuredWidth;
                }
                if (i14 != 0) {
                    sparseBooleanArray.put(i14, z);
                }
                menuItemImpl2.i(z);
            } else {
                if ((i13 & true) == z) {
                    z3 = z;
                } else {
                    z3 = false;
                }
                if (z3) {
                    boolean z10 = sparseBooleanArray.get(i14);
                    if ((i10 > 0 || z10) && i5 > 0) {
                        z4 = z;
                    } else {
                        z4 = false;
                    }
                    if (z4) {
                        View a3 = actionMenuPresenter.a(menuItemImpl2, (View) null, viewGroup);
                        a3.measure(makeMeasureSpec, makeMeasureSpec);
                        int measuredWidth2 = a3.getMeasuredWidth();
                        i5 -= measuredWidth2;
                        if (i12 == 0) {
                            i12 = measuredWidth2;
                        }
                        if (i5 + i12 > 0) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        z4 &= z6;
                    }
                    if (z4 && i14 != 0) {
                        sparseBooleanArray.put(i14, true);
                    } else if (z10) {
                        sparseBooleanArray.put(i14, false);
                        int i15 = 0;
                        while (i15 < i11) {
                            MenuItemImpl menuItemImpl3 = arrayList.get(i15);
                            if (menuItemImpl3.f1030b == i14) {
                                if ((menuItemImpl3.h & 32) == 32) {
                                    z5 = true;
                                } else {
                                    z5 = false;
                                }
                                if (z5) {
                                    i10++;
                                }
                                menuItemImpl3.i(false);
                            }
                            i15++;
                        }
                    }
                    if (z4) {
                        i10--;
                    }
                    menuItemImpl2.i(z4);
                } else {
                    menuItemImpl2.i(false);
                    i11++;
                    i3 = 2;
                    actionMenuPresenter = this;
                    z = true;
                }
            }
            i11++;
            i3 = 2;
            actionMenuPresenter = this;
            z = true;
        }
        return z;
    }

    public final void initForMenu(Context context, MenuBuilder menuBuilder) {
        this.b = context;
        LayoutInflater.from(context);
        this.f1038a = menuBuilder;
        Resources resources = context.getResources();
        if (!this.c) {
            this.b = true;
        }
        int i2 = 2;
        this.f = context.getResources().getDisplayMetrics().widthPixels / 2;
        Configuration configuration = context.getResources().getConfiguration();
        int i3 = configuration.screenWidthDp;
        int i4 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i3 > 600 || ((i3 > 960 && i4 > 720) || (i3 > 720 && i4 > 960))) {
            i2 = 5;
        } else if (i3 >= 500 || ((i3 > 640 && i4 > 480) || (i3 > 480 && i4 > 640))) {
            i2 = 4;
        } else if (i3 >= 360) {
            i2 = 3;
        }
        this.h = i2;
        int i5 = this.f;
        if (this.b) {
            if (this.f1132a == null) {
                d dVar = new d(this.a);
                this.f1132a = dVar;
                if (this.f1135a) {
                    dVar.setImageDrawable(this.a);
                    this.a = null;
                    this.f1135a = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f1132a.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i5 -= this.f1132a.getMeasuredWidth();
        } else {
            this.f1132a = null;
        }
        this.g = i5;
        float f2 = resources.getDisplayMetrics().density;
    }

    public final void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        b();
        a aVar = this.f1129a;
        if (aVar != null && aVar.b()) {
            aVar.f1077a.dismiss();
        }
        MenuPresenter.Callback callback = this.f1039a;
        if (callback != null) {
            callback.onCloseMenu(menuBuilder, z);
        }
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
        int i2;
        MenuItem findItem;
        if ((parcelable instanceof SavedState) && (i2 = ((SavedState) parcelable).c) > 0 && (findItem = this.f1038a.findItem(i2)) != null) {
            onSubMenuSelected((SubMenuBuilder) findItem.getSubMenu());
        }
    }

    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState();
        savedState.c = this.i;
        return savedState;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0042 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0099  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onSubMenuSelected(androidx.appcompat.view.menu.SubMenuBuilder r8) {
        /*
            r7 = this;
            boolean r0 = r8.hasVisibleItems()
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            r0 = r8
        L_0x0009:
            android.view.Menu r2 = r0.getParentMenu()
            androidx.appcompat.view.menu.MenuBuilder r3 = r7.f1038a
            if (r2 == r3) goto L_0x0018
            android.view.Menu r0 = r0.getParentMenu()
            androidx.appcompat.view.menu.SubMenuBuilder r0 = (androidx.appcompat.view.menu.SubMenuBuilder) r0
            goto L_0x0009
        L_0x0018:
            android.view.MenuItem r0 = r0.getItem()
            androidx.appcompat.view.menu.MenuView r2 = r7.f1040a
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            if (r2 != 0) goto L_0x0023
            goto L_0x003f
        L_0x0023:
            int r3 = r2.getChildCount()
            r4 = r1
        L_0x0028:
            if (r4 >= r3) goto L_0x003f
            android.view.View r5 = r2.getChildAt(r4)
            boolean r6 = r5 instanceof androidx.appcompat.view.menu.MenuView.a
            if (r6 == 0) goto L_0x003c
            r6 = r5
            androidx.appcompat.view.menu.MenuView$a r6 = (androidx.appcompat.view.menu.MenuView.a) r6
            androidx.appcompat.view.menu.MenuItemImpl r6 = r6.getItemData()
            if (r6 != r0) goto L_0x003c
            goto L_0x0040
        L_0x003c:
            int r4 = r4 + 1
            goto L_0x0028
        L_0x003f:
            r5 = 0
        L_0x0040:
            if (r5 != 0) goto L_0x0043
            return r1
        L_0x0043:
            android.view.MenuItem r0 = r8.getItem()
            int r0 = r0.getItemId()
            r7.i = r0
            int r0 = r8.size()
            r2 = r1
        L_0x0052:
            r3 = 1
            if (r2 >= r0) goto L_0x006a
            android.view.MenuItem r4 = r8.getItem(r2)
            boolean r6 = r4.isVisible()
            if (r6 == 0) goto L_0x0067
            android.graphics.drawable.Drawable r4 = r4.getIcon()
            if (r4 == 0) goto L_0x0067
            r0 = r3
            goto L_0x006b
        L_0x0067:
            int r2 = r2 + 1
            goto L_0x0052
        L_0x006a:
            r0 = r1
        L_0x006b:
            androidx.appcompat.widget.ActionMenuPresenter$a r2 = new androidx.appcompat.widget.ActionMenuPresenter$a
            android.content.Context r4 = r7.b
            r2.<init>(r4, r8, r5)
            r7.f1129a = r2
            r2.f1079b = r0
            bl r2 = r2.f1077a
            if (r2 == 0) goto L_0x007d
            r2.f(r0)
        L_0x007d:
            androidx.appcompat.widget.ActionMenuPresenter$a r0 = r7.f1129a
            boolean r2 = r0.b()
            if (r2 == 0) goto L_0x0086
            goto L_0x008e
        L_0x0086:
            android.view.View r2 = r0.f1072a
            if (r2 != 0) goto L_0x008b
            goto L_0x008f
        L_0x008b:
            r0.d(r1, r1, r1, r1)
        L_0x008e:
            r1 = r3
        L_0x008f:
            if (r1 == 0) goto L_0x0099
            androidx.appcompat.view.menu.MenuPresenter$Callback r0 = r7.f1039a
            if (r0 == 0) goto L_0x0098
            r0.a(r8)
        L_0x0098:
            return r3
        L_0x0099:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "MenuPopupHelper cannot be used without an anchor"
            r8.<init>(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionMenuPresenter.onSubMenuSelected(androidx.appcompat.view.menu.SubMenuBuilder):boolean");
    }

    public final void updateMenuView(boolean z) {
        MenuView menuView;
        int i2;
        boolean z2;
        boolean z3;
        MenuItemImpl menuItemImpl;
        ViewGroup viewGroup = (ViewGroup) this.f1040a;
        ArrayList<MenuItemImpl> arrayList = null;
        boolean z4 = false;
        if (viewGroup != null) {
            MenuBuilder menuBuilder = this.f1038a;
            if (menuBuilder != null) {
                menuBuilder.flagActionItems();
                ArrayList<MenuItemImpl> visibleItems = this.f1038a.getVisibleItems();
                int size = visibleItems.size();
                i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    MenuItemImpl menuItemImpl2 = visibleItems.get(i3);
                    if ((menuItemImpl2.h & 32) == 32) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (z3) {
                        View childAt = viewGroup.getChildAt(i2);
                        if (childAt instanceof MenuView.a) {
                            menuItemImpl = ((MenuView.a) childAt).getItemData();
                        } else {
                            menuItemImpl = null;
                        }
                        View a2 = a(menuItemImpl2, childAt, viewGroup);
                        if (menuItemImpl2 != menuItemImpl) {
                            a2.setPressed(false);
                            a2.jumpDrawablesToCurrentState();
                        }
                        if (a2 != childAt) {
                            ViewGroup viewGroup2 = (ViewGroup) a2.getParent();
                            if (viewGroup2 != null) {
                                viewGroup2.removeView(a2);
                            }
                            ((ViewGroup) this.f1040a).addView(a2, i2);
                        }
                        i2++;
                    }
                }
            } else {
                i2 = 0;
            }
            while (i2 < viewGroup.getChildCount()) {
                if (viewGroup.getChildAt(i2) == this.f1132a) {
                    z2 = false;
                } else {
                    viewGroup.removeViewAt(i2);
                    z2 = true;
                }
                if (!z2) {
                    i2++;
                }
            }
        }
        ((View) this.f1040a).requestLayout();
        MenuBuilder menuBuilder2 = this.f1038a;
        if (menuBuilder2 != null) {
            ArrayList<MenuItemImpl> actionItems = menuBuilder2.getActionItems();
            int size2 = actionItems.size();
            for (int i4 = 0; i4 < size2; i4++) {
                G g2 = actionItems.get(i4).f1017a;
                if (g2 != null) {
                    g2.a = this;
                }
            }
        }
        MenuBuilder menuBuilder3 = this.f1038a;
        if (menuBuilder3 != null) {
            arrayList = menuBuilder3.getNonActionItems();
        }
        if (this.b && arrayList != null) {
            int size3 = arrayList.size();
            if (size3 == 1) {
                z4 = !arrayList.get(0).f1036d;
            } else if (size3 > 0) {
                z4 = true;
            }
        }
        if (z4) {
            if (this.f1132a == null) {
                this.f1132a = new d(this.a);
            }
            ViewGroup viewGroup3 = (ViewGroup) this.f1132a.getParent();
            if (viewGroup3 != this.f1040a) {
                if (viewGroup3 != null) {
                    viewGroup3.removeView(this.f1132a);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f1040a;
                d dVar = this.f1132a;
                actionMenuView.getClass();
                ActionMenuView.LayoutParams layoutParams = new ActionMenuView.LayoutParams();
                layoutParams.gravity = 16;
                layoutParams.f1143a = true;
                actionMenuView.addView(dVar, layoutParams);
            }
        } else {
            d dVar2 = this.f1132a;
            if (dVar2 != null && dVar2.getParent() == (menuView = this.f1040a)) {
                ((ViewGroup) menuView).removeView(this.f1132a);
            }
        }
        ((ActionMenuView) this.f1040a).setOverflowReserved(this.b);
    }
}
