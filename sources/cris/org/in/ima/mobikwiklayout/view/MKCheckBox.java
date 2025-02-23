package cris.org.in.ima.mobikwiklayout.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import cris.org.in.prs.ima.R;

public class MKCheckBox extends RelativeLayout implements Checkable {
    public final float a;

    /* renamed from: a  reason: collision with other field name */
    public View.OnClickListener f5247a;

    /* renamed from: a  reason: collision with other field name */
    public CompoundButton.OnCheckedChangeListener f5248a;

    /* renamed from: a  reason: collision with other field name */
    public final IconView f5249a;

    /* renamed from: a  reason: collision with other field name */
    public final MKTextView f5250a = ((MKTextView) findViewById(R.id.checkbox_label));

    /* renamed from: a  reason: collision with other field name */
    public boolean f5251a;
    public final float b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f5252b;
    public final int c;

    /* renamed from: c  reason: collision with other field name */
    public String f5253c;

    /* renamed from: c  reason: collision with other field name */
    public boolean f5254c;
    public final int d;
    public final int e;
    public final int f;

    public class a implements View.OnClickListener {
        public a() {
        }

        public final void onClick(View view) {
            MKCheckBox mKCheckBox = MKCheckBox.this;
            if (mKCheckBox.f5254c) {
                mKCheckBox.toggle();
            }
            View.OnClickListener onClickListener = mKCheckBox.f5247a;
            if (onClickListener != null) {
                onClickListener.onClick(mKCheckBox);
            }
        }
    }

    public MKCheckBox(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.layout_mk_checkbox, this);
        IconView iconView = (IconView) findViewById(R.id.iconview_checkbox);
        this.f5249a = iconView;
        iconView.setTextColor(this.c);
        iconView.setTextSize(0, this.a);
        a();
        this.f5252b = true;
    }

    public final void a() {
        boolean b2 = C0572L5.b(this.f5253c);
        MKTextView mKTextView = this.f5250a;
        if (!b2) {
            mKTextView.setVisibility(0);
            if (this.f5253c.equalsIgnoreCase(".")) {
                mKTextView.setText("");
            } else {
                mKTextView.setText(this.f5253c);
            }
            mKTextView.setTextColor(this.f);
            mKTextView.setTextSize(0, this.b);
            return;
        }
        mKTextView.setVisibility(8);
    }

    public String getLabelString() {
        return this.f5253c;
    }

    public final boolean isChecked() {
        return this.f5251a;
    }

    public final boolean isClickable() {
        return this.f5254c;
    }

    public final boolean isEnabled() {
        return this.f5252b;
    }

    public void setChecked(boolean z) {
        if (this.f5252b) {
            this.f5251a = z;
            IconView iconView = this.f5249a;
            if (!z) {
                iconView.setText(getResources().getString(R.string.icon_checkbox_blank));
            } else {
                iconView.setText(getResources().getString(R.string.icon_checkbox_fill));
            }
            CompoundButton.OnCheckedChangeListener onCheckedChangeListener = this.f5248a;
            if (onCheckedChangeListener != null) {
                onCheckedChangeListener.onCheckedChanged((CompoundButton) null, this.f5251a);
            }
        }
    }

    public void setClickable(boolean z) {
        super.setClickable(z);
        this.f5254c = z;
    }

    public void setEnabled(boolean z) {
        this.f5252b = z;
        if (z) {
            setBackgroundColor(this.d);
            findViewById(R.id.checkbox_label).setAlpha(1.0f);
            findViewById(R.id.iconview_checkbox).setAlpha(1.0f);
            return;
        }
        findViewById(R.id.checkbox_label).setAlpha(0.3f);
        findViewById(R.id.iconview_checkbox).setAlpha(0.3f);
        setBackgroundColor(this.e);
    }

    public void setIsClickable(boolean z) {
        this.f5254c = z;
    }

    public void setLabelString(String str) {
        this.f5253c = str;
        a();
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f5248a = onCheckedChangeListener;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f5247a = onClickListener;
    }

    public final void toggle() {
        setChecked(!this.f5251a);
    }

    /* JADX INFO: finally extract failed */
    public MKCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(context).inflate(R.layout.layout_mk_checkbox, this);
        IconView iconView = (IconView) findViewById(R.id.iconview_checkbox);
        this.f5249a = iconView;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C1118fs.MKCheckBox, 0, 0);
        try {
            this.f5254c = obtainStyledAttributes.getBoolean(5, true);
            boolean z = obtainStyledAttributes.getBoolean(6, false);
            boolean z2 = obtainStyledAttributes.getBoolean(4, false);
            boolean z3 = obtainStyledAttributes.getBoolean(1, true);
            int color = obtainStyledAttributes.getColor(8, z ? getResources().getColor(R.color.white1) : getResources().getColor(R.color.mobikwik_blue));
            this.c = color;
            int color2 = obtainStyledAttributes.getColor(0, getResources().getColor(R.color.transparent1));
            this.d = color2;
            float dimension = obtainStyledAttributes.getDimension(3, getResources().getDimension(R.dimen.size20));
            this.a = dimension;
            this.b = obtainStyledAttributes.getDimension(2, getResources().getDimension(R.dimen.size18));
            int color3 = obtainStyledAttributes.getColor(7, getResources().getColor(R.color.composite_edit_text_disabled_color));
            this.e = color3;
            this.f = obtainStyledAttributes.getColor(12, z ? getResources().getColor(R.color.text_color_inverse) : getResources().getColor(R.color.text_color));
            this.f5253c = obtainStyledAttributes.getString(10);
            obtainStyledAttributes.recycle();
            iconView.setTextColor(color);
            iconView.setTextSize(0, dimension);
            a();
            this.f5252b = true;
            setChecked(z2);
            this.f5252b = z3;
            if (z3) {
                setBackgroundColor(color2);
                findViewById(R.id.checkbox_label).setAlpha(1.0f);
                findViewById(R.id.iconview_checkbox).setAlpha(1.0f);
            } else {
                findViewById(R.id.checkbox_label).setAlpha(0.5f);
                findViewById(R.id.iconview_checkbox).setAlpha(0.5f);
                setBackgroundColor(color3);
            }
            findViewById(R.id.mk_checkbox_container).setOnClickListener(new a());
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }
}
