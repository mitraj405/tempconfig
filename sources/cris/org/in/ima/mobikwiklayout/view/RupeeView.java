package cris.org.in.ima.mobikwiklayout.view;

import android.content.Context;
import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.widget.TextView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class RupeeView extends MKTextView {
    public RupeeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        String str;
        if (charSequence != null) {
            str = charSequence.toString();
        } else {
            str = "";
        }
        if (str.indexOf("Rs.") == -1) {
            super.setText(charSequence, bufferType);
            return;
        }
        Typeface P = C1354qp.P(getContext());
        HashMap hashMap = new HashMap();
        String str2 = "Rs.";
        while (str.indexOf("Rs.") >= 0) {
            int indexOf = str.indexOf("Rs.");
            if (indexOf == str.indexOf("Rs. ")) {
                str2 = "Rs. ";
            }
            str = str.replaceFirst(str2, "X");
            hashMap.put(Integer.valueOf(indexOf), Integer.valueOf(indexOf + 1));
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        Iterator it = hashMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            spannableStringBuilder.setSpan(new CustomTypefaceSpan(P), ((Integer) entry.getKey()).intValue(), ((Integer) entry.getValue()).intValue(), 33);
            it.remove();
        }
        super.setText(spannableStringBuilder);
    }

    public RupeeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RupeeView(Context context) {
        super(context);
    }
}
