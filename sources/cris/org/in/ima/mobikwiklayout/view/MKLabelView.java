package cris.org.in.ima.mobikwiklayout.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cris.org.in.prs.ima.R;
import defpackage.d7;

public class MKLabelView extends RelativeLayout {
    public final View a;

    /* renamed from: a  reason: collision with other field name */
    public final LinearLayout f5273a;

    /* renamed from: a  reason: collision with other field name */
    public final TextView f5274a;

    /* renamed from: a  reason: collision with other field name */
    public final IconView f5275a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f5276a;
    public final TextView b;
    public int c;

    /* renamed from: c  reason: collision with other field name */
    public final TextView f5277c;

    /* renamed from: c  reason: collision with other field name */
    public String f5278c;
    public final int d;

    /* renamed from: d  reason: collision with other field name */
    public String f5279d;
    public int e;

    /* renamed from: e  reason: collision with other field name */
    public String f5280e;
    public final int f;

    /* renamed from: f  reason: collision with other field name */
    public String f5281f;
    public String g;

    public MKLabelView(Context context) {
        this(context, (AttributeSet) null);
    }

    public String getAPIText() {
        return this.g;
    }

    public String getError() {
        return this.f5281f;
    }

    public String getHint() {
        return this.f5280e;
    }

    public CharSequence getText() {
        if (C0572L5.a(this.g)) {
            return this.g;
        }
        if (C0572L5.b(this.f5278c)) {
            return "";
        }
        return this.f5278c;
    }

    public CharSequence getTextForceful() {
        if (C0572L5.b(this.f5278c)) {
            return "";
        }
        return this.f5278c;
    }

    public LinearLayout getmInputLayout() {
        return this.f5273a;
    }

    public final boolean isEnabled() {
        return this.f5276a;
    }

    public void setAPIText(String str) {
        this.g = str;
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f5276a = z;
        View view = this.a;
        IconView iconView = this.f5275a;
        TextView textView = this.b;
        TextView textView2 = this.f5277c;
        if (z) {
            textView.setAlpha(1.0f);
            iconView.setAlpha(1.0f);
            view.setAlpha(1.0f);
            textView2.setAlpha(1.0f);
            return;
        }
        textView2.setAlpha(0.5f);
        textView.setAlpha(0.5f);
        iconView.setAlpha(0.5f);
        view.setAlpha(0.5f);
    }

    public void setError(String str) {
        this.f5281f = str;
        boolean b2 = C0572L5.b(str);
        View view = this.a;
        TextView textView = this.f5274a;
        if (b2) {
            view.setBackgroundColor(getResources().getColor(R.color.line_color));
            textView.setText(str);
            textView.setVisibility(8);
            return;
        }
        view.setBackgroundColor(getResources().getColor(R.color.composite_edit_text_error_color));
        textView.setText(str);
        textView.setVisibility(0);
    }

    public void setHint(String str) {
        this.f5280e = str;
        TextView textView = this.f5277c;
        textView.setText(str);
        boolean b2 = C0572L5.b(this.f5278c);
        TextView textView2 = this.b;
        if (b2) {
            textView2.setText(this.f5280e);
            textView.setVisibility(8);
            textView2.setTextColor(this.c);
            return;
        }
        textView2.setText(this.f5278c);
        textView.setVisibility(0);
        textView2.setTextColor(this.e);
    }

    public void setHintTextColor(int i) {
        this.f5277c.setTextColor(i);
    }

    public void setIcon(String str) {
        this.f5279d = str;
        IconView iconView = this.f5275a;
        if (str != null) {
            iconView.setText(str);
            iconView.setVisibility(0);
            return;
        }
        iconView.setVisibility(8);
    }

    public void setRightActionButton(View view, int i, int i2) {
        ((LinearLayout) findViewById(R.id.right_button_holder)).removeAllViews();
        ((LinearLayout) findViewById(R.id.right_button_holder)).addView(view);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById(R.id.right_button_holder).getLayoutParams();
        layoutParams.rightMargin = i2;
        layoutParams.leftMargin = i;
    }

    public void setSelectedColorState(boolean z) {
        View view = this.a;
        TextView textView = this.b;
        TextView textView2 = this.f5277c;
        IconView iconView = this.f5275a;
        if (z) {
            int color = getResources().getColor(R.color.mobikwik_blue);
            iconView.setTextColor(color);
            textView2.setTextColor(color);
            textView.setTextColor(color);
            view.setBackgroundColor(color);
            this.c = color;
            this.e = color;
            return;
        }
        setText((String) null);
        int i = this.d;
        this.c = i;
        this.e = this.f;
        iconView.setTextColor(i);
        textView2.setTextColor(this.c);
        textView.setTextColor(this.e);
        view.setBackgroundColor(getResources().getColor(R.color.line_color));
    }

    public void setShowIcon(boolean z) {
        IconView iconView = this.f5275a;
        if (z) {
            iconView.setVisibility(0);
        } else {
            iconView.setVisibility(8);
        }
    }

    public void setText(String str) {
        this.f5278c = str;
        setError("");
        boolean b2 = C0572L5.b(this.f5278c);
        TextView textView = this.f5277c;
        TextView textView2 = this.b;
        if (b2) {
            textView2.setText(this.f5280e);
            textView2.setTextColor(this.c);
            textView.setVisibility(8);
        } else {
            textView2.setText(this.f5278c);
            textView.setVisibility(0);
            textView2.setTextColor(this.e);
        }
        setEnabled(this.f5276a);
    }

    public void setTextSize(float f2) {
        this.b.setTextSize(0, f2);
    }

    /* JADX INFO: finally extract failed */
    public MKLabelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(context).inflate(R.layout.view_layout_label, this, true);
        this.c = getResources().getColor(R.color.text_color_light_new);
        int color = getResources().getColor(R.color.text_color);
        this.e = color;
        this.d = this.c;
        this.f = color;
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.container_mket);
        IconView iconView = (IconView) findViewById(R.id.icon_view_mket);
        this.f5275a = iconView;
        this.b = (TextView) findViewById(R.id.edit_text_mket);
        this.f5277c = (TextView) findViewById(R.id.hint_text_mket);
        this.f5273a = (LinearLayout) findViewById(R.id.text_input_layout_mket);
        this.f5274a = (TextView) findViewById(R.id.error_text_mket);
        this.a = findViewById(R.id.line_base);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C1118fs.MKEditText, 0, 0);
        try {
            setIcon(obtainStyledAttributes.getString(15));
            setHint(obtainStyledAttributes.getString(13));
            setText(obtainStyledAttributes.getString(33));
            setTextSize((float) obtainStyledAttributes.getDimensionPixelSize(35, getResources().getDimensionPixelSize(R.dimen.size14)));
            Context context2 = getContext();
            Object obj = d7.a;
            setHintTextColor(obtainStyledAttributes.getColor(14, d7.b.a(context2, R.color.text_color_light_new)));
            obtainStyledAttributes.getBoolean(3, false);
            obtainStyledAttributes.getBoolean(36, false);
            this.f5276a = obtainStyledAttributes.getBoolean(8, true);
            if (this.f5279d != null) {
                setShowIcon(obtainStyledAttributes.getBoolean(29, true));
            } else {
                iconView.setVisibility(4);
            }
            obtainStyledAttributes.recycle();
            setEnabled(this.f5276a);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public void setHint(int i) {
        setHint(getResources().getString(i));
    }
}
