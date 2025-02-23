package cris.org.in.ima.mobikwiklayout.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import cris.org.in.prs.ima.R;

public class MKSpinner extends MKEditText {
    public AdapterView.OnItemSelectedListener a;

    /* renamed from: a  reason: collision with other field name */
    public ArrayAdapter<Object> f5282a;

    /* renamed from: a  reason: collision with other field name */
    public a f5283a;

    /* renamed from: a  reason: collision with other field name */
    public Object f5284a;

    /* renamed from: a  reason: collision with other field name */
    public final String[] f5285a;
    public String f;
    public final boolean k;

    public class a implements View.OnClickListener {
        public final /* synthetic */ Context a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ View f5286a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ boolean f5288a;
        public final /* synthetic */ int c;

        /* renamed from: cris.org.in.ima.mobikwiklayout.view.MKSpinner$a$a  reason: collision with other inner class name */
        public class C0071a implements Tn {
            public C0071a() {
            }
        }

        public a(Context context, boolean z, View view, int i) {
            this.a = context;
            this.f5288a = z;
            this.f5286a = view;
            this.c = i;
        }

        public final void onClick(View view) {
            View view2;
            Context context = this.a;
            C0753Y8 y8 = new C0753Y8(context);
            if (this.f5288a) {
                view2 = this.f5286a;
            } else {
                view2 = null;
            }
            y8.f3852a = view2;
            MKSpinner mKSpinner = MKSpinner.this;
            ArrayAdapter<Object> arrayAdapter = mKSpinner.f5282a;
            if (arrayAdapter != null) {
                y8.f3853a = arrayAdapter;
                y8.f3849a = new C0071a();
                int[] iArr = y8.f3856a;
                boolean z = false;
                iArr[0] = 0;
                iArr[1] = 0;
                iArr[2] = 0;
                iArr[3] = 0;
                y8.f3857b = true;
                y8.g = this.c / 2;
                if (mKSpinner.k) {
                    y8.f3850a = new C0518Ge();
                }
                if (y8.b == -1) {
                    y8.b = 17170443;
                }
                if (y8.f3850a == null) {
                    y8.f3850a = new C1114fi();
                }
                y8.f3850a.setBackgroundColor(y8.b);
                C0704U8 u8 = new C0704U8(y8);
                mKSpinner.getClass();
                ViewGroup viewGroup = u8.c;
                if (viewGroup.findViewById(R.id.outmost_container) != null) {
                    z = true;
                }
                if (!z) {
                    viewGroup.addView(u8.f3802a);
                    ViewGroup viewGroup2 = u8.b;
                    viewGroup2.startAnimation(u8.f3805b);
                    viewGroup2.requestFocus();
                    u8.f3801a.a(new X8(u8));
                }
                Activity activity = (Activity) context;
                int i = C0572L5.a;
                try {
                    View currentFocus = activity.getCurrentFocus();
                    if (currentFocus != null) {
                        ((InputMethodManager) activity.getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 2);
                    }
                } catch (Exception e) {
                    e.getMessage();
                }
            } else {
                throw new NullPointerException("Adapter may not be null");
            }
        }
    }

    public class b implements c {
        public b() {
        }
    }

    public interface c {
    }

    public MKSpinner(Context context) {
        this(context, (AttributeSet) null);
    }

    public final void d(Context context) {
        if (this.f5282a == null) {
            String[] strArr = this.f5285a;
            if (strArr == null) {
                strArr = new String[0];
            }
            this.f5282a = new ArrayAdapter<>(context, R.layout.mk_spinner, strArr);
        }
        Object obj = this.f5284a;
        boolean z = true;
        if (obj != null) {
            setText(obj.toString(), true);
        }
        if (!(this.a == null || getSelectedItemPosition() == -1)) {
            this.a.onItemSelected((AdapterView) null, (View) null, getSelectedItemPosition(), 0);
        }
        boolean z2 = !C0572L5.b(this.f);
        String str = this.f;
        View inflate = LayoutInflater.from(context).inflate(R.layout.mk_spinner_heading, (ViewGroup) null);
        inflate.setBackgroundColor(context.getResources().getColor(R.color.actionbar_color));
        TextView textView = (TextView) inflate;
        textView.setText(str);
        textView.setTextColor(context.getResources().getColor(R.color.white1));
        textView.setGravity(17);
        this.f5283a = new a(context, z2, inflate, context.getResources().getDisplayMetrics().heightPixels);
        setSpinner(new b());
        if (((LinearLayout) findViewById(R.id.right_button_holder)).getChildCount() <= 0) {
            z = false;
        }
        if (!z) {
            IconView iconView = new IconView(context);
            iconView.setText(getResources().getString(R.string.icon_chevron));
            iconView.setTextSize(0, (float) getResources().getDimensionPixelSize(R.dimen.size14));
            iconView.setRotation(90.0f);
            if (this.h) {
                iconView.setTextColor(getResources().getColor(R.color.text_color_light_inverse));
            } else {
                iconView.setTextColor(getResources().getColor(R.color.text_color_new));
            }
            setRightActionButton(iconView, getResources().getDimensionPixelSize(R.dimen.size20), getResources().getDimensionPixelSize(R.dimen.size20));
        }
    }

    public ArrayAdapter getAdapter() {
        return this.f5282a;
    }

    public int getCount() {
        ArrayAdapter<Object> arrayAdapter = this.f5282a;
        if (arrayAdapter != null) {
            return arrayAdapter.getCount();
        }
        String[] strArr = this.f5285a;
        if (strArr != null) {
            return strArr.length;
        }
        return 0;
    }

    public AdapterView.OnItemSelectedListener getOnItemSelectedListener() {
        return this.a;
    }

    public Object getSelectedItem() {
        return this.f5284a;
    }

    public int getSelectedItemPosition() {
        int i;
        if (this.f5284a == null) {
            return -1;
        }
        int i2 = 0;
        while (true) {
            if (getAdapter() != null) {
                i = getAdapter().getCount();
            } else {
                i = 0;
            }
            if (i2 >= i) {
                return -1;
            }
            if (this.f5284a.equals(getAdapter().getItem(i2))) {
                return i2;
            }
            i2++;
        }
    }

    public String getSelectionFromString() {
        return null;
    }

    public void setAdapter(ArrayAdapter arrayAdapter) {
        this.f5282a = arrayAdapter;
        this.f5284a = null;
        d(getContext());
    }

    public void setHint(String str) {
        this.f = str;
        super.setHint(str);
    }

    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.a = onItemSelectedListener;
        d(getContext());
    }

    public void setSelection(int i) {
        setSelection(i, true);
    }

    public void setSelectionFromString(String str) {
        if (!C0572L5.b(str) && this.f5282a != null) {
            int i = 0;
            while (i < this.f5282a.getCount() && this.f5282a.getItem(i) != null) {
                if (str.equalsIgnoreCase(this.f5282a.getItem(i).toString())) {
                    setSelection(i, false);
                    return;
                }
                i++;
            }
        }
    }

    public final String toString() {
        if (getSelectedItem() != null) {
            return getSelectedItem().toString();
        }
        return "";
    }

    /* JADX INFO: finally extract failed */
    public MKSpinner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C1118fs.MKSpinner, 0, 0);
        try {
            CharSequence[] textArray = obtainStyledAttributes.getTextArray(0);
            if (textArray != null) {
                this.f5285a = new String[textArray.length];
                for (int i = 0; i < textArray.length; i++) {
                    this.f5285a[i] = (String) textArray[i];
                }
            }
            this.f = obtainStyledAttributes.getString(2);
            this.k = obtainStyledAttributes.getBoolean(1, false);
            if (!C0572L5.b(this.f)) {
                setHint(this.f);
            }
            obtainStyledAttributes.recycle();
            d(context);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public void setSelection(int i, boolean z) {
        ArrayAdapter<Object> arrayAdapter = this.f5282a;
        if (arrayAdapter != null && i >= 0 && i < arrayAdapter.getCount()) {
            Object item = this.f5282a.getItem(i);
            this.f5284a = item;
            setText(item.toString(), z);
        } else if ((i < 0 || this.f5282a.getCount() >= i) && this.f5282a.getCount() > 0) {
            this.f5284a = null;
            setText((String) null, z);
        }
        d(getContext());
    }
}
