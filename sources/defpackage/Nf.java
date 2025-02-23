package defpackage;

import android.widget.CalendarView;
import in.juspay.hypersdk.core.InflateView;

/* renamed from: Nf  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class Nf implements CalendarView.OnDateChangeListener {
    public final /* synthetic */ InflateView a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f3713a;

    public /* synthetic */ Nf(InflateView inflateView, String str) {
        this.a = inflateView;
        this.f3713a = str;
    }

    public final void onSelectedDayChange(CalendarView calendarView, int i, int i2, int i3) {
        this.a.lambda$parseKeys$7(this.f3713a, calendarView, i, i2, i3);
    }
}
