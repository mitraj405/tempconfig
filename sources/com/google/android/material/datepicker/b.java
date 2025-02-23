package com.google.android.material.datepicker;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ long a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ DateFormatTextWatcher f3509a;

    public /* synthetic */ b(DateFormatTextWatcher dateFormatTextWatcher, long j) {
        this.f3509a = dateFormatTextWatcher;
        this.a = j;
    }

    public final void run() {
        this.f3509a.lambda$createRangeErrorCallback$1(this.a);
    }
}
