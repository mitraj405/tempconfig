package cris.org.in.ima.mobikwiklayout.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import cris.org.in.prs.ima.R;

public class MKActionBar extends LinearLayout {
    public ProgressBar a;

    /* renamed from: a  reason: collision with other field name */
    public TextView f5245a;
    public int c;

    /* renamed from: c  reason: collision with other field name */
    public String f5246c;
    public String d;
    public String e;

    public MKActionBar(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    public static boolean a(String str) {
        if (str == null || str.trim().length() == 0) {
            return true;
        }
        return false;
    }

    public int getBackgroundColor() {
        return this.c;
    }

    public String getMenuIcon1() {
        return this.f5246c;
    }

    public String getMenuIcon5() {
        return this.d;
    }

    public String getTitle() {
        return this.e;
    }

    public final boolean isInEditMode() {
        return true;
    }

    public void setActionButton(String str, View.OnClickListener onClickListener) {
        ((TextView) findViewById(R.id.action_text)).setText(str);
        findViewById(R.id.mkab_icon_5).setVisibility(8);
        findViewById(R.id.action_text).setVisibility(0);
        findViewById(R.id.action_text_container).setOnClickListener(onClickListener);
    }

    public void setBackgroundColor(int i) {
        this.c = i;
        findViewById(R.id.mkab_root).setBackgroundColor(i);
        invalidate();
        requestLayout();
    }

    public void setDefaultValuesIfNull() {
        String str;
        String str2;
        String str3 = "";
        if (a(this.f5246c)) {
            str = str3;
        } else {
            str = this.f5246c;
        }
        this.f5246c = str;
        if (a(this.d)) {
            str2 = str3;
        } else {
            str2 = this.d;
        }
        this.d = str2;
        if (!a(this.e)) {
            str3 = this.e;
        }
        this.e = str3;
    }

    public void setIsLoading(boolean z) {
        int i;
        TextView textView = this.f5245a;
        int i2 = 8;
        if (z) {
            i = 8;
        } else {
            i = 0;
        }
        textView.setVisibility(i);
        ProgressBar progressBar = this.a;
        if (z) {
            i2 = 0;
        }
        progressBar.setVisibility(i2);
        invalidate();
        requestLayout();
    }

    public void setMenuIcon1(String str) {
        this.f5246c = str;
        invalidate();
        requestLayout();
    }

    public void setMenuIcon5(String str) {
        this.d = str;
        ((TextView) findViewById(R.id.mkab_icon_5)).setText(str);
    }

    public void setTitle(String str) {
        this.e = str;
        TextView textView = (TextView) findViewById(R.id.mkab_title);
        if (str.equals(".")) {
            str = "";
        }
        textView.setText(str);
        invalidate();
        requestLayout();
    }

    public void setTitleType(boolean z) {
        invalidate();
        requestLayout();
    }

    public void setViewAsTitle(View view) {
        findViewById(R.id.mkab_title).setVisibility(8);
        ((LinearLayout) findViewById(R.id.title_container)).addView(view);
    }

    public MKActionBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: finally extract failed */
    public MKActionBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C1118fs.MKActionBar, 0, 0);
        try {
            this.e = obtainStyledAttributes.getString(10);
            this.c = obtainStyledAttributes.getColor(0, 0);
            this.f5246c = obtainStyledAttributes.getString(3);
            this.d = obtainStyledAttributes.getString(7);
            obtainStyledAttributes.getBoolean(11, true);
            boolean z = obtainStyledAttributes.getBoolean(2, false);
            obtainStyledAttributes.recycle();
            setDefaultValuesIfNull();
            LayoutInflater.from(context).inflate(R.layout.mk_action_bar, this);
            findViewById(R.id.mkab_title).setVisibility(0);
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.size16);
            TextView textView = (TextView) findViewById(R.id.mkab_icon_1);
            textView.setTextSize(0, getResources().getDimension(R.dimen.size18));
            textView.setGravity(19);
            textView.setPadding(dimensionPixelSize, 0, 0, 0);
            TextView textView2 = (TextView) findViewById(R.id.mkab_icon_5);
            textView2.setTextSize(0, getResources().getDimension(R.dimen.size18));
            textView2.setGravity(21);
            textView2.setPadding(0, 0, dimensionPixelSize, 0);
            ((TextView) findViewById(R.id.mkab_title)).setText(this.e.equals(".") ? "" : this.e);
            ((TextView) findViewById(R.id.mkab_icon_1)).setText(this.f5246c);
            TextView textView3 = (TextView) findViewById(R.id.mkab_icon_5);
            this.f5245a = textView3;
            textView3.setText(this.d);
            this.a = (ProgressBar) findViewById(R.id.content_loading_progress_bar);
            findViewById(R.id.mkab_root).setBackgroundColor(this.c);
            if (z) {
                int i2 = IconView.c;
                ((TextView) findViewById(R.id.mkab_title)).setTypeface(C1354qp.P(context));
                ((TextView) findViewById(R.id.mkab_title)).setTextSize(0, getResources().getDimension(R.dimen.size_32));
            }
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }
}
