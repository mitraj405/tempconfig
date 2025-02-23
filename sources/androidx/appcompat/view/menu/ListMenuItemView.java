package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.f;
import java.util.WeakHashMap;

public class ListMenuItemView extends LinearLayout implements MenuView.a, AbsListView.SelectionBoundsAdjuster {
    public final Context a;

    /* renamed from: a  reason: collision with other field name */
    public final Drawable f1002a;

    /* renamed from: a  reason: collision with other field name */
    public LayoutInflater f1003a;

    /* renamed from: a  reason: collision with other field name */
    public CheckBox f1004a;

    /* renamed from: a  reason: collision with other field name */
    public ImageView f1005a;

    /* renamed from: a  reason: collision with other field name */
    public LinearLayout f1006a;

    /* renamed from: a  reason: collision with other field name */
    public RadioButton f1007a;

    /* renamed from: a  reason: collision with other field name */
    public TextView f1008a;

    /* renamed from: a  reason: collision with other field name */
    public MenuItemImpl f1009a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f1010a;
    public final Drawable b;

    /* renamed from: b  reason: collision with other field name */
    public ImageView f1011b;

    /* renamed from: b  reason: collision with other field name */
    public TextView f1012b;

    /* renamed from: b  reason: collision with other field name */
    public final boolean f1013b;
    public final int c;

    /* renamed from: c  reason: collision with other field name */
    public ImageView f1014c;

    /* renamed from: c  reason: collision with other field name */
    public boolean f1015c;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0220hr.listMenuViewStyle);
    }

    private LayoutInflater getInflater() {
        if (this.f1003a == null) {
            this.f1003a = LayoutInflater.from(getContext());
        }
        return this.f1003a;
    }

    private void setSubMenuArrowVisible(boolean z) {
        int i;
        ImageView imageView = this.f1011b;
        if (imageView != null) {
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            imageView.setVisibility(i);
        }
    }

    public final void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.f1014c;
        if (imageView != null && imageView.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f1014c.getLayoutParams();
            rect.top = this.f1014c.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin + rect.top;
        }
    }

    public MenuItemImpl getItemData() {
        return this.f1009a;
    }

    public final void initialize(MenuItemImpl menuItemImpl, int i) {
        int i2;
        char c2;
        char c3;
        this.f1009a = menuItemImpl;
        boolean z = false;
        if (menuItemImpl.isVisible()) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        setVisibility(i2);
        setTitle(menuItemImpl.f1028a);
        setCheckable(menuItemImpl.isCheckable());
        MenuBuilder menuBuilder = menuItemImpl.f1026a;
        if (menuBuilder.isShortcutsVisible()) {
            if (menuBuilder.isQwertyMode()) {
                c3 = menuItemImpl.b;
            } else {
                c3 = menuItemImpl.a;
            }
            if (c3 != 0) {
                z = true;
            }
        }
        if (menuBuilder.isQwertyMode()) {
            c2 = menuItemImpl.b;
        } else {
            c2 = menuItemImpl.a;
        }
        setShortcut(z, c2);
        setIcon(menuItemImpl.getIcon());
        setEnabled(menuItemImpl.isEnabled());
        setSubMenuArrowVisible(menuItemImpl.hasSubMenu());
        setContentDescription(menuItemImpl.f1033c);
    }

    public final void onFinishInflate() {
        super.onFinishInflate();
        WeakHashMap<View, GC> weakHashMap = f.f1839a;
        setBackground(this.f1002a);
        TextView textView = (TextView) findViewById(Gr.title);
        this.f1008a = textView;
        int i = this.c;
        if (i != -1) {
            textView.setTextAppearance(this.a, i);
        }
        this.f1012b = (TextView) findViewById(Gr.shortcut);
        ImageView imageView = (ImageView) findViewById(Gr.submenuarrow);
        this.f1011b = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.b);
        }
        this.f1014c = (ImageView) findViewById(Gr.group_divider);
        this.f1006a = (LinearLayout) findViewById(Gr.content);
    }

    public final void onMeasure(int i, int i2) {
        if (this.f1005a != null && this.f1010a) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f1005a.getLayoutParams();
            int i3 = layoutParams.height;
            if (i3 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i3;
            }
        }
        super.onMeasure(i, i2);
    }

    public void setCheckable(boolean z) {
        boolean z2;
        View view;
        CompoundButton compoundButton;
        if (z || this.f1007a != null || this.f1004a != null) {
            if ((this.f1009a.h & 4) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                if (this.f1007a == null) {
                    RadioButton radioButton = (RadioButton) getInflater().inflate(Vr.abc_list_menu_item_radio, this, false);
                    this.f1007a = radioButton;
                    LinearLayout linearLayout = this.f1006a;
                    if (linearLayout != null) {
                        linearLayout.addView(radioButton, -1);
                    } else {
                        addView(radioButton, -1);
                    }
                }
                compoundButton = this.f1007a;
                view = this.f1004a;
            } else {
                if (this.f1004a == null) {
                    CheckBox checkBox = (CheckBox) getInflater().inflate(Vr.abc_list_menu_item_checkbox, this, false);
                    this.f1004a = checkBox;
                    LinearLayout linearLayout2 = this.f1006a;
                    if (linearLayout2 != null) {
                        linearLayout2.addView(checkBox, -1);
                    } else {
                        addView(checkBox, -1);
                    }
                }
                compoundButton = this.f1004a;
                view = this.f1007a;
            }
            if (z) {
                compoundButton.setChecked(this.f1009a.isChecked());
                if (compoundButton.getVisibility() != 0) {
                    compoundButton.setVisibility(0);
                }
                if (view != null && view.getVisibility() != 8) {
                    view.setVisibility(8);
                    return;
                }
                return;
            }
            CheckBox checkBox2 = this.f1004a;
            if (checkBox2 != null) {
                checkBox2.setVisibility(8);
            }
            RadioButton radioButton2 = this.f1007a;
            if (radioButton2 != null) {
                radioButton2.setVisibility(8);
            }
        }
    }

    public void setChecked(boolean z) {
        boolean z2;
        CompoundButton compoundButton;
        if ((this.f1009a.h & 4) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            if (this.f1007a == null) {
                RadioButton radioButton = (RadioButton) getInflater().inflate(Vr.abc_list_menu_item_radio, this, false);
                this.f1007a = radioButton;
                LinearLayout linearLayout = this.f1006a;
                if (linearLayout != null) {
                    linearLayout.addView(radioButton, -1);
                } else {
                    addView(radioButton, -1);
                }
            }
            compoundButton = this.f1007a;
        } else {
            if (this.f1004a == null) {
                CheckBox checkBox = (CheckBox) getInflater().inflate(Vr.abc_list_menu_item_checkbox, this, false);
                this.f1004a = checkBox;
                LinearLayout linearLayout2 = this.f1006a;
                if (linearLayout2 != null) {
                    linearLayout2.addView(checkBox, -1);
                } else {
                    addView(checkBox, -1);
                }
            }
            compoundButton = this.f1004a;
        }
        compoundButton.setChecked(z);
    }

    public void setForceShowIcon(boolean z) {
        this.f1015c = z;
        this.f1010a = z;
    }

    public void setGroupDividerEnabled(boolean z) {
        int i;
        ImageView imageView = this.f1014c;
        if (imageView != null) {
            if (this.f1013b || !z) {
                i = 8;
            } else {
                i = 0;
            }
            imageView.setVisibility(i);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z;
        if (this.f1009a.f1026a.getOptionalIconsVisible() || this.f1015c) {
            z = true;
        } else {
            z = false;
        }
        if (z || this.f1010a) {
            ImageView imageView = this.f1005a;
            if (imageView != null || drawable != null || this.f1010a) {
                if (imageView == null) {
                    ImageView imageView2 = (ImageView) getInflater().inflate(Vr.abc_list_menu_item_icon, this, false);
                    this.f1005a = imageView2;
                    LinearLayout linearLayout = this.f1006a;
                    if (linearLayout != null) {
                        linearLayout.addView(imageView2, 0);
                    } else {
                        addView(imageView2, 0);
                    }
                }
                if (drawable != null || this.f1010a) {
                    ImageView imageView3 = this.f1005a;
                    if (!z) {
                        drawable = null;
                    }
                    imageView3.setImageDrawable(drawable);
                    if (this.f1005a.getVisibility() != 0) {
                        this.f1005a.setVisibility(0);
                        return;
                    }
                    return;
                }
                this.f1005a.setVisibility(8);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0020, code lost:
        if (r9 == false) goto L_0x0023;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setShortcut(boolean r9, char r10) {
        /*
            r8 = this;
            r10 = 1
            r0 = 8
            if (r9 == 0) goto L_0x0023
            androidx.appcompat.view.menu.MenuItemImpl r9 = r8.f1009a
            androidx.appcompat.view.menu.MenuBuilder r1 = r9.f1026a
            boolean r2 = r1.isShortcutsVisible()
            r3 = 0
            if (r2 == 0) goto L_0x001f
            boolean r1 = r1.isQwertyMode()
            if (r1 == 0) goto L_0x0019
            char r9 = r9.b
            goto L_0x001b
        L_0x0019:
            char r9 = r9.a
        L_0x001b:
            if (r9 == 0) goto L_0x001f
            r9 = r10
            goto L_0x0020
        L_0x001f:
            r9 = r3
        L_0x0020:
            if (r9 == 0) goto L_0x0023
            goto L_0x0024
        L_0x0023:
            r3 = r0
        L_0x0024:
            if (r3 != 0) goto L_0x00dc
            android.widget.TextView r9 = r8.f1012b
            androidx.appcompat.view.menu.MenuItemImpl r1 = r8.f1009a
            androidx.appcompat.view.menu.MenuBuilder r2 = r1.f1026a
            boolean r2 = r2.isQwertyMode()
            if (r2 == 0) goto L_0x0035
            char r2 = r1.b
            goto L_0x0037
        L_0x0035:
            char r2 = r1.a
        L_0x0037:
            if (r2 != 0) goto L_0x003d
            java.lang.String r10 = ""
            goto L_0x00d9
        L_0x003d:
            androidx.appcompat.view.menu.MenuBuilder r4 = r1.f1026a
            android.content.Context r5 = r4.getContext()
            android.content.res.Resources r5 = r5.getResources()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            android.content.Context r7 = r4.getContext()
            android.view.ViewConfiguration r7 = android.view.ViewConfiguration.get(r7)
            boolean r7 = r7.hasPermanentMenuKey()
            if (r7 == 0) goto L_0x0063
            int r7 = defpackage.bs.abc_prepend_shortcut_label
            java.lang.String r7 = r5.getString(r7)
            r6.append(r7)
        L_0x0063:
            boolean r4 = r4.isQwertyMode()
            if (r4 == 0) goto L_0x006c
            int r1 = r1.f
            goto L_0x006e
        L_0x006c:
            int r1 = r1.e
        L_0x006e:
            int r4 = defpackage.bs.abc_menu_meta_shortcut_label
            java.lang.String r4 = r5.getString(r4)
            r7 = 65536(0x10000, float:9.18355E-41)
            androidx.appcompat.view.menu.MenuItemImpl.e(r4, r1, r7, r6)
            int r4 = defpackage.bs.abc_menu_ctrl_shortcut_label
            java.lang.String r4 = r5.getString(r4)
            r7 = 4096(0x1000, float:5.74E-42)
            androidx.appcompat.view.menu.MenuItemImpl.e(r4, r1, r7, r6)
            int r4 = defpackage.bs.abc_menu_alt_shortcut_label
            java.lang.String r4 = r5.getString(r4)
            r7 = 2
            androidx.appcompat.view.menu.MenuItemImpl.e(r4, r1, r7, r6)
            int r4 = defpackage.bs.abc_menu_shift_shortcut_label
            java.lang.String r4 = r5.getString(r4)
            androidx.appcompat.view.menu.MenuItemImpl.e(r4, r1, r10, r6)
            int r10 = defpackage.bs.abc_menu_sym_shortcut_label
            java.lang.String r10 = r5.getString(r10)
            r4 = 4
            androidx.appcompat.view.menu.MenuItemImpl.e(r10, r1, r4, r6)
            int r10 = defpackage.bs.abc_menu_function_shortcut_label
            java.lang.String r10 = r5.getString(r10)
            androidx.appcompat.view.menu.MenuItemImpl.e(r10, r1, r0, r6)
            if (r2 == r0) goto L_0x00cc
            r10 = 10
            if (r2 == r10) goto L_0x00c2
            r10 = 32
            if (r2 == r10) goto L_0x00b8
            r6.append(r2)
            goto L_0x00d5
        L_0x00b8:
            int r10 = defpackage.bs.abc_menu_space_shortcut_label
            java.lang.String r10 = r5.getString(r10)
            r6.append(r10)
            goto L_0x00d5
        L_0x00c2:
            int r10 = defpackage.bs.abc_menu_enter_shortcut_label
            java.lang.String r10 = r5.getString(r10)
            r6.append(r10)
            goto L_0x00d5
        L_0x00cc:
            int r10 = defpackage.bs.abc_menu_delete_shortcut_label
            java.lang.String r10 = r5.getString(r10)
            r6.append(r10)
        L_0x00d5:
            java.lang.String r10 = r6.toString()
        L_0x00d9:
            r9.setText(r10)
        L_0x00dc:
            android.widget.TextView r9 = r8.f1012b
            int r9 = r9.getVisibility()
            if (r9 == r3) goto L_0x00e9
            android.widget.TextView r9 = r8.f1012b
            r9.setVisibility(r3)
        L_0x00e9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.ListMenuItemView.setShortcut(boolean, char):void");
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.f1008a.setText(charSequence);
            if (this.f1008a.getVisibility() != 0) {
                this.f1008a.setVisibility(0);
            }
        } else if (this.f1008a.getVisibility() != 8) {
            this.f1008a.setVisibility(8);
        }
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        TintTypedArray m = TintTypedArray.m(getContext(), attributeSet, ps.MenuView, i);
        this.f1002a = m.e(ps.MenuView_android_itemBackground);
        this.c = m.i(ps.MenuView_android_itemTextAppearance, -1);
        this.f1010a = m.a(ps.MenuView_preserveIconSpacing, false);
        this.a = context;
        this.b = m.e(ps.MenuView_subMenuArrow);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes((AttributeSet) null, new int[]{16843049}, C0220hr.dropDownListViewStyle, 0);
        this.f1013b = obtainStyledAttributes.hasValue(0);
        m.n();
        obtainStyledAttributes.recycle();
    }
}
