package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.app.AlertDialog;
import java.util.Objects;
import java.util.WeakHashMap;

public class AppCompatSpinner extends Spinner {
    @SuppressLint({"ResourceType"})
    public static final int[] a = {16843505};

    /* renamed from: a  reason: collision with other field name */
    public final Context f1170a;

    /* renamed from: a  reason: collision with other field name */
    public final Rect f1171a;

    /* renamed from: a  reason: collision with other field name */
    public SpinnerAdapter f1172a;

    /* renamed from: a  reason: collision with other field name */
    public final AppCompatBackgroundHelper f1173a;

    /* renamed from: a  reason: collision with other field name */
    public final h f1174a;

    /* renamed from: a  reason: collision with other field name */
    public final a f1175a;

    /* renamed from: a  reason: collision with other field name */
    public final boolean f1176a;
    public int c;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public boolean a;

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

        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.a ? (byte) 1 : 0);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.a = parcel.readByte() != 0;
        }
    }

    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        public final void onGlobalLayout() {
            AppCompatSpinner appCompatSpinner = AppCompatSpinner.this;
            if (!appCompatSpinner.getInternalPopup().a()) {
                appCompatSpinner.f1174a.k(c.b(appCompatSpinner), c.a(appCompatSpinner));
            }
            ViewTreeObserver viewTreeObserver = appCompatSpinner.getViewTreeObserver();
            if (viewTreeObserver != null) {
                b.a(viewTreeObserver, this);
            }
        }
    }

    public static final class b {
        public static void a(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
            viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }
    }

    public static final class c {
        public static int a(View view) {
            return view.getTextAlignment();
        }

        public static int b(View view) {
            return view.getTextDirection();
        }

        public static void c(View view, int i) {
            view.setTextAlignment(i);
        }

        public static void d(View view, int i) {
            view.setTextDirection(i);
        }
    }

    public static final class d {
        public static void a(ThemedSpinnerAdapter themedSpinnerAdapter, Resources.Theme theme) {
            if (!Objects.equals(themedSpinnerAdapter.getDropDownViewTheme(), theme)) {
                themedSpinnerAdapter.setDropDownViewTheme(theme);
            }
        }
    }

    public static class f implements ListAdapter, SpinnerAdapter {
        public final ListAdapter a;

        /* renamed from: a  reason: collision with other field name */
        public final SpinnerAdapter f1180a;

        public f(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            this.f1180a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.a = (ListAdapter) spinnerAdapter;
            }
            if (theme == null) {
                return;
            }
            if (spinnerAdapter instanceof ThemedSpinnerAdapter) {
                d.a((ThemedSpinnerAdapter) spinnerAdapter, theme);
            } else if (spinnerAdapter instanceof Pz) {
                Pz pz = (Pz) spinnerAdapter;
                if (pz.getDropDownViewTheme() == null) {
                    pz.a();
                }
            }
        }

        public final boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.a;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        public final int getCount() {
            SpinnerAdapter spinnerAdapter = this.f1180a;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        public final View getDropDownView(int i, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.f1180a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i, view, viewGroup);
        }

        public final Object getItem(int i) {
            SpinnerAdapter spinnerAdapter = this.f1180a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i);
        }

        public final long getItemId(int i) {
            SpinnerAdapter spinnerAdapter = this.f1180a;
            if (spinnerAdapter == null) {
                return -1;
            }
            return spinnerAdapter.getItemId(i);
        }

        public final int getItemViewType(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            return getDropDownView(i, view, viewGroup);
        }

        public final int getViewTypeCount() {
            return 1;
        }

        public final boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.f1180a;
            if (spinnerAdapter == null || !spinnerAdapter.hasStableIds()) {
                return false;
            }
            return true;
        }

        public final boolean isEmpty() {
            if (getCount() == 0) {
                return true;
            }
            return false;
        }

        public final boolean isEnabled(int i) {
            ListAdapter listAdapter = this.a;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i);
            }
            return true;
        }

        public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f1180a;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f1180a;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    public class g extends ListPopupWindow implements h {

        /* renamed from: a  reason: collision with other field name */
        public CharSequence f1181a;
        public ListAdapter b;
        public final Rect c = new Rect();
        public int j;

        public class a implements AdapterView.OnItemClickListener {
            public a() {
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                g gVar = g.this;
                AppCompatSpinner.this.setSelection(i);
                if (AppCompatSpinner.this.getOnItemClickListener() != null) {
                    AppCompatSpinner.this.performItemClick(view, i, gVar.b.getItemId(i));
                }
                gVar.dismiss();
            }
        }

        public class b implements ViewTreeObserver.OnGlobalLayoutListener {
            public b() {
            }

            public final void onGlobalLayout() {
                boolean z;
                g gVar = g.this;
                AppCompatSpinner appCompatSpinner = AppCompatSpinner.this;
                gVar.getClass();
                WeakHashMap<View, GC> weakHashMap = androidx.core.view.f.f1839a;
                if (!appCompatSpinner.isAttachedToWindow() || !appCompatSpinner.getGlobalVisibleRect(gVar.c)) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    gVar.dismiss();
                    return;
                }
                gVar.q();
                gVar.show();
            }
        }

        public class c implements PopupWindow.OnDismissListener {
            public final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener a;

            public c(b bVar) {
                this.a = bVar;
            }

            public final void onDismiss() {
                ViewTreeObserver viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this.a);
                }
            }
        }

        public g(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.f1200a = AppCompatSpinner.this;
            this.f1214d = true;
            this.f1204a.setFocusable(true);
            this.f1201a = new a();
        }

        public final void e(int i) {
            this.j = i;
        }

        public final void i(ListAdapter listAdapter) {
            super.i(listAdapter);
            this.b = listAdapter;
        }

        public final CharSequence j() {
            return this.f1181a;
        }

        public final void k(int i, int i2) {
            ViewTreeObserver viewTreeObserver;
            boolean a2 = a();
            q();
            PopupWindow popupWindow = this.f1204a;
            popupWindow.setInputMethodMode(2);
            show();
            A9 a9 = this.f1196a;
            a9.setChoiceMode(1);
            c.d(a9, i);
            c.c(a9, i2);
            AppCompatSpinner appCompatSpinner = AppCompatSpinner.this;
            int selectedItemPosition = appCompatSpinner.getSelectedItemPosition();
            A9 a92 = this.f1196a;
            if (a() && a92 != null) {
                a92.setListSelectionHidden(false);
                a92.setSelection(selectedItemPosition);
                if (a92.getChoiceMode() != 0) {
                    a92.setItemChecked(selectedItemPosition, true);
                }
            }
            if (!a2 && (viewTreeObserver = appCompatSpinner.getViewTreeObserver()) != null) {
                b bVar = new b();
                viewTreeObserver.addOnGlobalLayoutListener(bVar);
                popupWindow.setOnDismissListener(new c(bVar));
            }
        }

        public final void l(CharSequence charSequence) {
            this.f1181a = charSequence;
        }

        public final void q() {
            int i;
            int i2;
            Drawable d = d();
            AppCompatSpinner appCompatSpinner = AppCompatSpinner.this;
            if (d != null) {
                d.getPadding(appCompatSpinner.f1171a);
                if (UC.a(appCompatSpinner)) {
                    i = appCompatSpinner.f1171a.right;
                } else {
                    i = -appCompatSpinner.f1171a.left;
                }
            } else {
                Rect rect = appCompatSpinner.f1171a;
                rect.right = 0;
                rect.left = 0;
                i = 0;
            }
            int paddingLeft = appCompatSpinner.getPaddingLeft();
            int paddingRight = appCompatSpinner.getPaddingRight();
            int width = appCompatSpinner.getWidth();
            int i3 = appCompatSpinner.c;
            if (i3 == -2) {
                int a2 = appCompatSpinner.a((SpinnerAdapter) this.b, d());
                int i4 = appCompatSpinner.getContext().getResources().getDisplayMetrics().widthPixels;
                Rect rect2 = appCompatSpinner.f1171a;
                int i5 = (i4 - rect2.left) - rect2.right;
                if (a2 > i5) {
                    a2 = i5;
                }
                p(Math.max(a2, (width - paddingLeft) - paddingRight));
            } else if (i3 == -1) {
                p((width - paddingLeft) - paddingRight);
            } else {
                p(i3);
            }
            if (UC.a(appCompatSpinner)) {
                i2 = (((width - paddingRight) - this.d) - this.j) + i;
            } else {
                i2 = paddingLeft + this.j + i;
            }
            this.e = i2;
        }
    }

    public interface h {
        boolean a();

        int c();

        Drawable d();

        void dismiss();

        void e(int i);

        void f(int i);

        int g();

        void h(int i);

        void i(ListAdapter listAdapter);

        CharSequence j();

        void k(int i, int i2);

        void l(CharSequence charSequence);

        void setBackgroundDrawable(Drawable drawable);
    }

    public AppCompatSpinner(Context context) {
        this(context, (AttributeSet) null);
    }

    public final int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        View view = null;
        int i2 = 0;
        for (int max2 = Math.max(0, max - (15 - (min - max))); max2 < min; max2++) {
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != i) {
                view = null;
                i = itemViewType;
            }
            view = spinnerAdapter.getView(max2, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i2 = Math.max(i2, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return i2;
        }
        Rect rect = this.f1171a;
        drawable.getPadding(rect);
        return i2 + rect.left + rect.right;
    }

    public final void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1173a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.a();
        }
    }

    public int getDropDownHorizontalOffset() {
        h hVar = this.f1174a;
        if (hVar != null) {
            return hVar.c();
        }
        return super.getDropDownHorizontalOffset();
    }

    public int getDropDownVerticalOffset() {
        h hVar = this.f1174a;
        if (hVar != null) {
            return hVar.g();
        }
        return super.getDropDownVerticalOffset();
    }

    public int getDropDownWidth() {
        if (this.f1174a != null) {
            return this.c;
        }
        return super.getDropDownWidth();
    }

    public final h getInternalPopup() {
        return this.f1174a;
    }

    public Drawable getPopupBackground() {
        h hVar = this.f1174a;
        if (hVar != null) {
            return hVar.d();
        }
        return super.getPopupBackground();
    }

    public Context getPopupContext() {
        return this.f1170a;
    }

    public CharSequence getPrompt() {
        h hVar = this.f1174a;
        if (hVar != null) {
            return hVar.j();
        }
        return super.getPrompt();
    }

    public ColorStateList getSupportBackgroundTintList() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1173a;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1173a;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.c();
        }
        return null;
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h hVar = this.f1174a;
        if (hVar != null && hVar.a()) {
            hVar.dismiss();
        }
    }

    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f1174a != null && View.MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i)), getMeasuredHeight());
        }
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.a && (viewTreeObserver = getViewTreeObserver()) != null) {
            viewTreeObserver.addOnGlobalLayoutListener(new a());
        }
    }

    public final Parcelable onSaveInstanceState() {
        boolean z;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        h hVar = this.f1174a;
        if (hVar == null || !hVar.a()) {
            z = false;
        } else {
            z = true;
        }
        savedState.a = z;
        return savedState;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        a aVar = this.f1175a;
        if (aVar == null || !aVar.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public final boolean performClick() {
        h hVar = this.f1174a;
        if (hVar == null) {
            return super.performClick();
        }
        if (hVar.a()) {
            return true;
        }
        hVar.k(c.b(this), c.a(this));
        return true;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1173a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.e();
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1173a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.f(i);
        }
    }

    public void setDropDownHorizontalOffset(int i) {
        h hVar = this.f1174a;
        if (hVar != null) {
            hVar.e(i);
            hVar.f(i);
            return;
        }
        super.setDropDownHorizontalOffset(i);
    }

    public void setDropDownVerticalOffset(int i) {
        h hVar = this.f1174a;
        if (hVar != null) {
            hVar.h(i);
        } else {
            super.setDropDownVerticalOffset(i);
        }
    }

    public void setDropDownWidth(int i) {
        if (this.f1174a != null) {
            this.c = i;
        } else {
            super.setDropDownWidth(i);
        }
    }

    public void setPopupBackgroundDrawable(Drawable drawable) {
        h hVar = this.f1174a;
        if (hVar != null) {
            hVar.setBackgroundDrawable(drawable);
        } else {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    public void setPopupBackgroundResource(int i) {
        setPopupBackgroundDrawable(r1.w(getPopupContext(), i));
    }

    public void setPrompt(CharSequence charSequence) {
        h hVar = this.f1174a;
        if (hVar != null) {
            hVar.l(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1173a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.h(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1173a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.i(mode);
        }
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0220hr.spinnerStyle);
    }

    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f1176a) {
            this.f1172a = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        h hVar = this.f1174a;
        if (hVar != null) {
            Context context = this.f1170a;
            if (context == null) {
                context = getContext();
            }
            hVar.i(new f(spinnerAdapter, context.getTheme()));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0054, code lost:
        if (r4 != null) goto L_0x0056;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AppCompatSpinner(android.content.Context r9, android.util.AttributeSet r10, int r11) {
        /*
            r8 = this;
            r8.<init>(r9, r10, r11)
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            r8.f1171a = r0
            android.content.Context r0 = r8.getContext()
            defpackage.Oz.a(r0, r8)
            int[] r0 = defpackage.ps.Spinner
            androidx.appcompat.widget.TintTypedArray r1 = new androidx.appcompat.widget.TintTypedArray
            r2 = 0
            android.content.res.TypedArray r0 = r9.obtainStyledAttributes(r10, r0, r11, r2)
            r1.<init>(r9, r0)
            androidx.appcompat.widget.AppCompatBackgroundHelper r0 = new androidx.appcompat.widget.AppCompatBackgroundHelper
            r0.<init>(r8)
            r8.f1173a = r0
            int r0 = defpackage.ps.Spinner_popupTheme
            int r0 = r1.i(r0, r2)
            if (r0 == 0) goto L_0x0034
            f7 r3 = new f7
            r3.<init>(r9, r0)
            r8.f1170a = r3
            goto L_0x0036
        L_0x0034:
            r8.f1170a = r9
        L_0x0036:
            r0 = -1
            r3 = 0
            int[] r4 = a     // Catch:{ Exception -> 0x0053, all -> 0x004c }
            android.content.res.TypedArray r4 = r9.obtainStyledAttributes(r10, r4, r11, r2)     // Catch:{ Exception -> 0x0053, all -> 0x004c }
            boolean r5 = r4.hasValue(r2)     // Catch:{ Exception -> 0x0054, all -> 0x0049 }
            if (r5 == 0) goto L_0x0056
            int r0 = r4.getInt(r2, r2)     // Catch:{ Exception -> 0x0054, all -> 0x0049 }
            goto L_0x0056
        L_0x0049:
            r9 = move-exception
            r3 = r4
            goto L_0x004d
        L_0x004c:
            r9 = move-exception
        L_0x004d:
            if (r3 == 0) goto L_0x0052
            r3.recycle()
        L_0x0052:
            throw r9
        L_0x0053:
            r4 = r3
        L_0x0054:
            if (r4 == 0) goto L_0x0059
        L_0x0056:
            r4.recycle()
        L_0x0059:
            r2 = 1
            if (r0 == 0) goto L_0x0097
            if (r0 == r2) goto L_0x005f
            goto L_0x00a6
        L_0x005f:
            androidx.appcompat.widget.AppCompatSpinner$g r0 = new androidx.appcompat.widget.AppCompatSpinner$g
            android.content.Context r4 = r8.f1170a
            r0.<init>(r4, r10, r11)
            android.content.Context r4 = r8.f1170a
            int[] r5 = defpackage.ps.Spinner
            androidx.appcompat.widget.TintTypedArray r4 = androidx.appcompat.widget.TintTypedArray.m(r4, r10, r5, r11)
            int r5 = defpackage.ps.Spinner_android_dropDownWidth
            android.content.res.TypedArray r6 = r4.f1265a
            r7 = -2
            int r5 = r6.getLayoutDimension(r5, r7)
            r8.c = r5
            int r5 = defpackage.ps.Spinner_android_popupBackground
            android.graphics.drawable.Drawable r5 = r4.e(r5)
            r0.setBackgroundDrawable(r5)
            int r5 = defpackage.ps.Spinner_android_prompt
            java.lang.String r5 = r1.j(r5)
            r0.f1181a = r5
            r4.n()
            r8.f1174a = r0
            androidx.appcompat.widget.a r4 = new androidx.appcompat.widget.a
            r4.<init>(r8, r8, r0)
            r8.f1175a = r4
            goto L_0x00a6
        L_0x0097:
            androidx.appcompat.widget.AppCompatSpinner$e r0 = new androidx.appcompat.widget.AppCompatSpinner$e
            r0.<init>()
            r8.f1174a = r0
            int r4 = defpackage.ps.Spinner_android_prompt
            java.lang.String r4 = r1.j(r4)
            r0.f1179a = r4
        L_0x00a6:
            int r0 = defpackage.ps.Spinner_android_entries
            android.content.res.TypedArray r4 = r1.f1265a
            java.lang.CharSequence[] r0 = r4.getTextArray(r0)
            if (r0 == 0) goto L_0x00c0
            android.widget.ArrayAdapter r4 = new android.widget.ArrayAdapter
            r5 = 17367048(0x1090008, float:2.5162948E-38)
            r4.<init>(r9, r5, r0)
            int r9 = defpackage.Vr.support_simple_spinner_dropdown_item
            r4.setDropDownViewResource(r9)
            r8.setAdapter((android.widget.SpinnerAdapter) r4)
        L_0x00c0:
            r1.n()
            r8.f1176a = r2
            android.widget.SpinnerAdapter r9 = r8.f1172a
            if (r9 == 0) goto L_0x00ce
            r8.setAdapter((android.widget.SpinnerAdapter) r9)
            r8.f1172a = r3
        L_0x00ce:
            androidx.appcompat.widget.AppCompatBackgroundHelper r9 = r8.f1173a
            r9.d(r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatSpinner.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public class e implements h, DialogInterface.OnClickListener {
        public ListAdapter a;

        /* renamed from: a  reason: collision with other field name */
        public AlertDialog f1177a;

        /* renamed from: a  reason: collision with other field name */
        public CharSequence f1179a;

        public e() {
        }

        public final boolean a() {
            AlertDialog alertDialog = this.f1177a;
            if (alertDialog != null) {
                return alertDialog.isShowing();
            }
            return false;
        }

        public final int c() {
            return 0;
        }

        public final Drawable d() {
            return null;
        }

        public final void dismiss() {
            AlertDialog alertDialog = this.f1177a;
            if (alertDialog != null) {
                alertDialog.dismiss();
                this.f1177a = null;
            }
        }

        public final int g() {
            return 0;
        }

        public final void i(ListAdapter listAdapter) {
            this.a = listAdapter;
        }

        public final CharSequence j() {
            return this.f1179a;
        }

        public final void k(int i, int i2) {
            if (this.a != null) {
                AppCompatSpinner appCompatSpinner = AppCompatSpinner.this;
                AlertDialog.Builder builder = new AlertDialog.Builder(appCompatSpinner.getPopupContext());
                CharSequence charSequence = this.f1179a;
                if (charSequence != null) {
                    builder.setTitle(charSequence);
                }
                AlertDialog create = builder.setSingleChoiceItems(this.a, appCompatSpinner.getSelectedItemPosition(), (DialogInterface.OnClickListener) this).create();
                this.f1177a = create;
                AlertController.RecycleListView recycleListView = create.a.f840a;
                c.d(recycleListView, i);
                c.c(recycleListView, i2);
                this.f1177a.show();
            }
        }

        public final void l(CharSequence charSequence) {
            this.f1179a = charSequence;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppCompatSpinner appCompatSpinner = AppCompatSpinner.this;
            appCompatSpinner.setSelection(i);
            if (appCompatSpinner.getOnItemClickListener() != null) {
                appCompatSpinner.performItemClick((View) null, i, this.a.getItemId(i));
            }
            dismiss();
        }

        public final void e(int i) {
        }

        public final void f(int i) {
        }

        public final void h(int i) {
        }

        public final void setBackgroundDrawable(Drawable drawable) {
        }
    }
}
