package com.google.android.material.datepicker;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import com.google.android.material.R;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

abstract class DateFormatTextWatcher extends TextWatcherAdapter {
    private final CalendarConstraints constraints;
    private final DateFormat dateFormat;
    private final String formatHint;
    private int lastLength = 0;
    private final String outOfRange;
    private final Runnable setErrorCallback;
    private Runnable setRangeErrorCallback;
    private final TextInputLayout textInputLayout;

    public DateFormatTextWatcher(String str, DateFormat dateFormat2, TextInputLayout textInputLayout2, CalendarConstraints calendarConstraints) {
        this.formatHint = str;
        this.dateFormat = dateFormat2;
        this.textInputLayout = textInputLayout2;
        this.constraints = calendarConstraints;
        this.outOfRange = textInputLayout2.getContext().getString(R.string.mtrl_picker_out_of_range);
        this.setErrorCallback = new a(this, str);
    }

    private Runnable createRangeErrorCallback(long j) {
        return new b(this, j);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$createRangeErrorCallback$1(long j) {
        String dateString = DateStrings.getDateString(j);
        this.textInputLayout.setError(String.format(this.outOfRange, new Object[]{sanitizeDateString(dateString)}));
        onInvalidDate();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(String str) {
        TextInputLayout textInputLayout2 = this.textInputLayout;
        DateFormat dateFormat2 = this.dateFormat;
        Context context = textInputLayout2.getContext();
        String string = context.getString(R.string.mtrl_picker_invalid_format);
        String format = String.format(context.getString(R.string.mtrl_picker_invalid_format_use), new Object[]{sanitizeDateString(str)});
        String format2 = String.format(context.getString(R.string.mtrl_picker_invalid_format_example), new Object[]{sanitizeDateString(dateFormat2.format(new Date(UtcDates.getTodayCalendar().getTimeInMillis())))});
        textInputLayout2.setError(string + "\n" + format + "\n" + format2);
        onInvalidDate();
    }

    private String sanitizeDateString(String str) {
        return str.replace(' ', 160);
    }

    public void afterTextChanged(Editable editable) {
        if (!Locale.getDefault().getLanguage().equals(Locale.KOREAN.getLanguage()) && editable.length() != 0 && editable.length() < this.formatHint.length() && editable.length() >= this.lastLength) {
            char charAt = this.formatHint.charAt(editable.length());
            if (!Character.isLetterOrDigit(charAt)) {
                editable.append(charAt);
            }
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.lastLength = charSequence.length();
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.textInputLayout.removeCallbacks(this.setErrorCallback);
        this.textInputLayout.removeCallbacks(this.setRangeErrorCallback);
        this.textInputLayout.setError((CharSequence) null);
        onValidDate((Long) null);
        if (!TextUtils.isEmpty(charSequence) && charSequence.length() >= this.formatHint.length()) {
            try {
                Date parse = this.dateFormat.parse(charSequence.toString());
                this.textInputLayout.setError((CharSequence) null);
                long time = parse.getTime();
                if (!this.constraints.getDateValidator().isValid(time) || !this.constraints.isWithinBounds(time)) {
                    Runnable createRangeErrorCallback = createRangeErrorCallback(time);
                    this.setRangeErrorCallback = createRangeErrorCallback;
                    runValidation(this.textInputLayout, createRangeErrorCallback);
                    return;
                }
                onValidDate(Long.valueOf(parse.getTime()));
            } catch (ParseException unused) {
                runValidation(this.textInputLayout, this.setErrorCallback);
            }
        }
    }

    public abstract void onValidDate(Long l);

    public void runValidation(View view, Runnable runnable) {
        view.post(runnable);
    }

    public void onInvalidDate() {
    }
}
