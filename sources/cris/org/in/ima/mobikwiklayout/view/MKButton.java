package cris.org.in.ima.mobikwiklayout.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.TextView;
import cris.org.in.prs.ima.R;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MKButton extends Button {
    public final int c;

    public MKButton(Context context) {
        this(context, (AttributeSet) null);
    }

    private void setCustomProperties(Context context) {
        setHeight((int) getResources().getDimension(R.dimen.size56));
        setBackgroundResource(this.c);
        setTextColor(getResources().getColor(R.color.white1));
        setTextSize(0, getResources().getDimension(R.dimen.size14));
        setGravity(17);
    }

    public final boolean isInEditMode() {
        return true;
    }

    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        String charSequence2 = charSequence.toString();
        if (charSequence2.indexOf("Rs.") == -1) {
            super.setText(charSequence, bufferType);
            return;
        }
        Typeface P = C1354qp.P(getContext());
        HashMap hashMap = new HashMap();
        String str = "Rs.";
        while (charSequence2.indexOf("Rs.") >= 0) {
            int indexOf = charSequence2.indexOf("Rs.");
            if (indexOf == charSequence2.indexOf("Rs. ")) {
                str = "Rs. ";
            }
            charSequence2 = charSequence2.replaceFirst(str, "X");
            hashMap.put(Integer.valueOf(indexOf), Integer.valueOf(indexOf + 1));
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence2);
        Iterator it = hashMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            spannableStringBuilder.setSpan(new CustomTypefaceSpan(P), ((Integer) entry.getKey()).intValue(), ((Integer) entry.getValue()).intValue(), 33);
            it.remove();
        }
        super.setText(spannableStringBuilder);
    }

    /* JADX INFO: finally extract failed */
    public MKButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C1118fs.MKButton, 0, 0);
        try {
            String string = obtainStyledAttributes.getString(1);
            this.c = obtainStyledAttributes.getResourceId(0, R.drawable.button_background);
            if (!C0572L5.b(string)) {
                setText(string);
            }
            obtainStyledAttributes.recycle();
            setCustomProperties(context);
            setTransformationMethod((TransformationMethod) null);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }
}
