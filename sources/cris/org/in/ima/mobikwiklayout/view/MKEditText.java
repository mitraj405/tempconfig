package cris.org.in.ima.mobikwiklayout.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.text.method.DigitsKeyListener;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.ScaleAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputLayout;
import cris.org.in.ima.mobikwiklayout.view.MKSpinner;
import cris.org.in.prs.ima.R;
import java.util.ArrayList;

public class MKEditText extends RelativeLayout {
    public View.OnClickListener a;

    /* renamed from: a  reason: collision with other field name */
    public View.OnFocusChangeListener f5255a;

    /* renamed from: a  reason: collision with other field name */
    public final View f5256a;

    /* renamed from: a  reason: collision with other field name */
    public final AutoCompleteTextView f5257a;

    /* renamed from: a  reason: collision with other field name */
    public final TextView f5258a;

    /* renamed from: a  reason: collision with other field name */
    public final TextInputLayout f5259a;

    /* renamed from: a  reason: collision with other field name */
    public final IconView f5260a;

    /* renamed from: a  reason: collision with other field name */
    public MKSpinner.c f5261a;

    /* renamed from: a  reason: collision with other field name */
    public final RupeeView f5262a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f5263a;
    public final View b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f5264b;
    public int c;

    /* renamed from: c  reason: collision with other field name */
    public String f5265c;

    /* renamed from: c  reason: collision with other field name */
    public boolean f5266c;
    public final int d;

    /* renamed from: d  reason: collision with other field name */
    public String f5267d;

    /* renamed from: d  reason: collision with other field name */
    public final boolean f5268d;
    public final int e;

    /* renamed from: e  reason: collision with other field name */
    public String f5269e;

    /* renamed from: e  reason: collision with other field name */
    public boolean f5270e;
    public int f;

    /* renamed from: f  reason: collision with other field name */
    public boolean f5271f;
    public int g;

    /* renamed from: g  reason: collision with other field name */
    public final boolean f5272g;
    public final boolean h;
    public boolean i;
    public boolean j;

    public class b implements View.OnClickListener {
        public b() {
        }

        public final void onClick(View view) {
            MKEditText mKEditText = MKEditText.this;
            if (mKEditText.f5266c && mKEditText.f5268d) {
                AutoCompleteTextView autoCompleteTextView = mKEditText.f5257a;
                autoCompleteTextView.requestFocus();
                if (!mKEditText.i || !mKEditText.j) {
                    ((InputMethodManager) mKEditText.getContext().getSystemService("input_method")).showSoftInput(autoCompleteTextView, 1);
                }
            }
        }
    }

    public class c implements View.OnFocusChangeListener {
        public c() {
        }

        public final void onFocusChange(View view, boolean z) {
            View.OnClickListener onClickListener;
            boolean z2 = z;
            MKEditText mKEditText = MKEditText.this;
            if (mKEditText.f5266c) {
                View.OnFocusChangeListener onFocusChangeListener = mKEditText.f5255a;
                if (onFocusChangeListener != null) {
                    onFocusChangeListener.onFocusChange(view, z2);
                }
                TextView textView = mKEditText.f5258a;
                boolean z3 = mKEditText.f5272g;
                View view2 = mKEditText.f5256a;
                if (z2) {
                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 1.0f, 1.0f, 1, 0.5f, 1, 1.0f);
                    scaleAnimation.setDuration(200);
                    scaleAnimation.setAnimationListener(new C0669Rj(mKEditText));
                    scaleAnimation.setFillAfter(true);
                    scaleAnimation.setFillBefore(true);
                    scaleAnimation.setFillEnabled(true);
                    view2.startAnimation(scaleAnimation);
                    if (z3) {
                        textView.setTextColor(mKEditText.getResources().getColor(R.color.mobikwik_blue));
                    }
                    if (mKEditText.i) {
                        MKSpinner.this.f5283a.onClick((View) null);
                    }
                    if (mKEditText.j && (onClickListener = mKEditText.a) != null) {
                        onClickListener.onClick((View) null);
                        return;
                    }
                    return;
                }
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(200);
                alphaAnimation.setFillAfter(true);
                alphaAnimation.setFillBefore(true);
                alphaAnimation.setFillEnabled(true);
                view2.startAnimation(alphaAnimation);
                if (z3) {
                    textView.setTextColor(mKEditText.getResources().getColor(R.color.text_color_light_new));
                }
            }
        }
    }

    static {
        C1354qp.R(MKEditText.class);
    }

    public MKEditText(Context context) {
        this(context, (AttributeSet) null);
    }

    private void setExtraHint(String str) {
        this.f5257a.setHint(str);
    }

    public final void a(int i2, boolean z) {
        View view = this.f5256a;
        RupeeView rupeeView = this.f5262a;
        if (z) {
            rupeeView.setVisibility(0);
            view.setBackgroundColor(i2);
            this.b.setBackgroundColor(i2);
            return;
        }
        rupeeView.setVisibility(8);
        view.setBackgroundColor(getResources().getColor(R.color.mobikwik_blue));
    }

    public final void b() {
        AutoCompleteTextView autoCompleteTextView = this.f5257a;
        InputFilter[] filters = autoCompleteTextView.getFilters();
        ArrayList arrayList = new ArrayList();
        int length = filters.length;
        for (int i2 = 0; i2 < length - 1; i2++) {
            InputFilter inputFilter = filters[i2];
            if (!(inputFilter instanceof InputFilter.LengthFilter)) {
                arrayList.add(inputFilter);
            }
        }
        arrayList.add(new InputFilter.LengthFilter(this.f));
        autoCompleteTextView.setFilters((InputFilter[]) arrayList.toArray(new InputFilter[arrayList.size()]));
    }

    public final void c() {
        setDrawingCacheEnabled(true);
        setAnimationCacheEnabled(true);
        boolean z = this.f5266c;
        View view = this.b;
        TextInputLayout textInputLayout = this.f5259a;
        IconView iconView = this.f5260a;
        AutoCompleteTextView autoCompleteTextView = this.f5257a;
        if (z) {
            textInputLayout.setAlpha(1.0f);
            autoCompleteTextView.setAlpha(1.0f);
            iconView.setAlpha(1.0f);
            view.setAlpha(1.0f);
        } else {
            textInputLayout.setAlpha(0.5f);
            autoCompleteTextView.setAlpha(0.5f);
            iconView.setAlpha(0.5f);
            view.setAlpha(0.5f);
        }
        autoCompleteTextView.setEnabled(this.f5266c);
        int i2 = this.e;
        autoCompleteTextView.setTextColor(i2);
        autoCompleteTextView.addTextChangedListener(new a());
        autoCompleteTextView.setTextColor(i2);
        setOnClickListener(new b());
        iconView.setTextColor(i2);
        if (this.f5269e != null) {
            iconView.setVisibility(0);
        } else {
            iconView.setVisibility(4);
        }
        if (this.f > 0) {
            b();
        }
        autoCompleteTextView.setOnFocusChangeListener(new c());
        int i3 = this.c;
        if (i3 != 0) {
            autoCompleteTextView.setImeOptions(i3);
        }
        int i4 = this.d;
        if (i4 != 0) {
            autoCompleteTextView.setInputType(i4);
        }
        if (this.f5270e) {
            autoCompleteTextView.setKeyListener(DigitsKeyListener.getInstance("0123456789 "));
        }
        if (this.f5264b) {
            autoCompleteTextView.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
        this.f5271f = true;
        requestLayout();
    }

    public final void clearFocus() {
        this.f5257a.clearFocus();
    }

    public final void dispatchRestoreInstanceState(SparseArray sparseArray) {
        super.dispatchThawSelfOnly(sparseArray);
    }

    public final void dispatchSaveInstanceState(SparseArray sparseArray) {
        super.dispatchFreezeSelfOnly(sparseArray);
    }

    @Deprecated
    public AutoCompleteTextView getEditableView() {
        return this.f5257a;
    }

    public String getHint() {
        CharSequence charSequence;
        if (this.f5272g) {
            charSequence = this.f5258a.getText();
        } else {
            charSequence = this.f5259a.getHint();
        }
        return charSequence.toString();
    }

    public int getMaxLength() {
        return this.f;
    }

    public Editable getText() {
        return this.f5257a.getText();
    }

    public boolean isInEditMode() {
        return true;
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f5257a.setText(savedState.c);
    }

    public final Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.f5257a.getText().toString());
    }

    public final boolean requestFocus(int i2, Rect rect) {
        return this.f5257a.requestFocus(i2, rect);
    }

    public final void requestLayout() {
        if (this.f5271f) {
            super.requestLayout();
        }
    }

    public void setAdapter(ArrayAdapter arrayAdapter) {
        this.f5257a.setAdapter(arrayAdapter);
    }

    public void setCreditCardField(boolean z) {
        this.f5270e = z;
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f5266c = z;
        c();
    }

    public void setError(String str) {
        boolean a2 = C0572L5.a(str);
        this.f5263a = a2;
        if (a2) {
            C0535I5.t0(getContext(), str);
        }
        setFooterText(str, getResources().getColor(R.color.composite_edit_text_error_color));
    }

    public void setFilters(InputFilter[] inputFilterArr) {
        this.f5257a.setFilters(inputFilterArr);
    }

    public void setFooterText(String str, int i2) {
        this.f5265c = str;
        boolean b2 = C0572L5.b(str);
        RupeeView rupeeView = this.f5262a;
        if (b2 && !C0572L5.b(rupeeView.getText().toString())) {
            rupeeView.setText("");
            a(-1, false);
        } else if (C0572L5.a(this.f5265c)) {
            rupeeView.setText(this.f5265c);
            a(i2, true);
        }
        View view = this.b;
        if (i2 != 0) {
            rupeeView.setTextColor(i2);
            if (i2 != getResources().getColor(R.color.composite_edit_text_error_color)) {
                this.g = i2;
                view.setBackgroundColor(i2);
                return;
            }
            return;
        }
        view.setBackgroundColor(this.g);
    }

    public void setFooterTextColor(int i2) {
        this.g = i2;
        this.b.setBackgroundColor(i2);
        this.f5262a.setTextColor(i2);
    }

    public void setHint(String str) {
        if (this.f5272g) {
            this.f5258a.setHint(str);
        } else {
            this.f5259a.setHint((CharSequence) str);
        }
    }

    public void setIcon(String str) {
        this.f5269e = str;
        if (!this.f5272g) {
            boolean a2 = C0572L5.a(str);
            View view = this.b;
            View view2 = this.f5256a;
            IconView iconView = this.f5260a;
            if (a2) {
                iconView.setText(this.f5269e);
                iconView.setVisibility(0);
                ((RelativeLayout.LayoutParams) view2.getLayoutParams()).leftMargin = getResources().getDimensionPixelSize(R.dimen.size56);
                ((RelativeLayout.LayoutParams) view.getLayoutParams()).leftMargin = getResources().getDimensionPixelSize(R.dimen.size56);
                findViewById(R.id.edit_text_mket).setPadding(getResources().getDimensionPixelSize(R.dimen.size56), 0, 0, 0);
                return;
            }
            iconView.setVisibility(8);
            ((RelativeLayout.LayoutParams) view2.getLayoutParams()).leftMargin = getResources().getDimensionPixelSize(R.dimen.size20);
            ((RelativeLayout.LayoutParams) view.getLayoutParams()).leftMargin = getResources().getDimensionPixelSize(R.dimen.size20);
            findViewById(R.id.edit_text_mket).setPadding(getResources().getDimensionPixelSize(R.dimen.size20), 0, 0, 0);
        }
    }

    public void setImeOptions(int i2) {
        this.c = i2;
        this.f5257a.setImeOptions(i2);
    }

    public void setInputType(int i2) {
        this.f5257a.setInputType(i2);
    }

    public void setIsPassword(boolean z) {
        this.f5264b = z;
        AutoCompleteTextView autoCompleteTextView = this.f5257a;
        if (z) {
            autoCompleteTextView.setTransformationMethod(PasswordTransformationMethod.getInstance());
        } else {
            autoCompleteTextView.setTransformationMethod((TransformationMethod) null);
        }
    }

    public void setLabel(View.OnClickListener onClickListener) {
        this.j = true;
        this.f5257a.setInputType(0);
        this.a = onClickListener;
    }

    public void setMaxLength(int i2) {
        this.f = i2;
        if (i2 > 0) {
            b();
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
    }

    public void setOnCustomFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.f5255a = onFocusChangeListener;
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.f5257a.setOnItemClickListener(onItemClickListener);
    }

    public void setRightActionButton(View view, int i2, int i3) {
        ((LinearLayout) findViewById(R.id.right_button_holder)).removeAllViews();
        ((LinearLayout) findViewById(R.id.right_button_holder)).addView(view);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById(R.id.right_button_holder).getLayoutParams();
        layoutParams.rightMargin = i3;
        layoutParams.leftMargin = i2;
    }

    public void setSelection(int i2) {
        this.f5257a.setSelection(i2);
    }

    public void setSpinner(MKSpinner.c cVar) {
        this.i = true;
        this.f5257a.setInputType(0);
        this.f5261a = cVar;
    }

    public void setText(String str) {
        setText(str, false);
    }

    public void setThreshold(int i2) {
        this.f5257a.setThreshold(i2);
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public final String c;

        public class a implements Parcelable.Creator<SavedState> {
            public final Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public final Object[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public SavedState(Parcelable parcelable, String str) {
            super(parcelable);
            this.c = str;
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

    /* JADX INFO: finally extract failed */
    public MKEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5271f = false;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C1118fs.MKEditText, 0, 0);
        try {
            String string = obtainStyledAttributes.getString(15);
            String string2 = obtainStyledAttributes.getString(13);
            String string3 = obtainStyledAttributes.getString(33);
            String string4 = obtainStyledAttributes.getString(11);
            boolean z = obtainStyledAttributes.getBoolean(5, false);
            this.h = z;
            boolean z2 = obtainStyledAttributes.getBoolean(2, false);
            this.f5272g = z2;
            this.f5266c = obtainStyledAttributes.getBoolean(8, true);
            this.f5268d = obtainStyledAttributes.getBoolean(20, true);
            this.f5264b = obtainStyledAttributes.getBoolean(25, false);
            this.f5270e = obtainStyledAttributes.getBoolean(4, false);
            this.f = obtainStyledAttributes.getInteger(24, 0);
            this.c = obtainStyledAttributes.getInt(18, 0);
            this.d = obtainStyledAttributes.getInt(19, 0);
            obtainStyledAttributes.getBoolean(21, false);
            this.e = obtainStyledAttributes.getColor(34, z ? getResources().getColor(R.color.text_color_inverse) : getResources().getColor(R.color.text_color_new));
            obtainStyledAttributes.getColor(9, getResources().getColor(R.color.composite_edit_text_error_color));
            obtainStyledAttributes.getColor(27, z ? getResources().getColor(R.color.composite_edit_text_separator_color_inverse) : getResources().getColor(R.color.composite_edit_text_separator_color));
            if (z2) {
                if (z) {
                    LayoutInflater.from(context).inflate(R.layout.view_layout_big_inverse_edittext, this, true);
                } else {
                    LayoutInflater.from(context).inflate(R.layout.view_layout_big_edittext, this, true);
                }
            } else if (z) {
                LayoutInflater.from(context).inflate(R.layout.view_layout_dark_edittext, this, true);
            } else {
                LayoutInflater.from(context).inflate(R.layout.view_layout_edittext, this, true);
            }
            this.f5258a = (TextView) findViewById(R.id.additional_hint);
            this.f5260a = (IconView) findViewById(R.id.icon_view_mket);
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.edit_text_mket);
            this.f5257a = autoCompleteTextView;
            this.f5259a = (TextInputLayout) findViewById(R.id.text_input_layout_mket);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.container_mket);
            this.f5262a = (RupeeView) findViewById(R.id.error_text_mket);
            this.f5256a = findViewById(R.id.line_animator);
            this.b = findViewById(R.id.line_base);
            this.g = z ? getResources().getColor(R.color.line_color_inverse) : getResources().getColor(R.color.line_color);
            if (z2 && z) {
                autoCompleteTextView.setHintTextColor(getResources().getColor(R.color.text_color_light_inverse));
            }
            setIcon(string);
            setText(string3);
            setHint(string2);
            setExtraHint(string4);
            obtainStyledAttributes.recycle();
            c();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public void setText(String str, boolean z) {
        TextInputLayout textInputLayout = this.f5259a;
        textInputLayout.setHintAnimationEnabled(z);
        this.f5267d = str;
        boolean b2 = C0572L5.b(str);
        AutoCompleteTextView autoCompleteTextView = this.f5257a;
        if (!b2) {
            autoCompleteTextView.setText(this.f5267d);
            autoCompleteTextView.setSelection(autoCompleteTextView.getText().length());
        } else {
            autoCompleteTextView.setText("");
        }
        textInputLayout.setHintAnimationEnabled(true);
    }

    public void setHint(int i2) {
        setHint(getResources().getString(i2));
    }

    public class a implements TextWatcher {
        public a() {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            MKEditText mKEditText = MKEditText.this;
            if (!C0572L5.b(mKEditText.f5265c) && mKEditText.f5263a) {
                mKEditText.f5265c = null;
                mKEditText.f5263a = false;
                mKEditText.b.setBackgroundColor(mKEditText.getResources().getColor(R.color.line_color));
                mKEditText.a(-1, false);
            }
        }

        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public void setFieldForValidation(C1088ec ecVar) {
    }
}
