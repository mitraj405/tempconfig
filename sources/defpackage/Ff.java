package defpackage;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import in.juspay.hyper.constants.LogCategory;

/* renamed from: Ff  reason: default package */
/* compiled from: InflateResult.kt */
public final class Ff {
    public final Context a;

    /* renamed from: a  reason: collision with other field name */
    public final AttributeSet f3583a;

    /* renamed from: a  reason: collision with other field name */
    public final View f3584a;

    /* renamed from: a  reason: collision with other field name */
    public final String f3585a;

    public Ff(View view, String str, Context context, AttributeSet attributeSet) {
        C1177ig.g(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
        C1177ig.g(context, LogCategory.CONTEXT);
        this.f3584a = view;
        this.f3585a = str;
        this.a = context;
        this.f3583a = attributeSet;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Ff)) {
            return false;
        }
        Ff ff = (Ff) obj;
        if (!C1177ig.a(this.f3584a, ff.f3584a) || !C1177ig.a(this.f3585a, ff.f3585a) || !C1177ig.a(this.a, ff.a) || !C1177ig.a(this.f3583a, ff.f3583a)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int i;
        int i2;
        int i3;
        int i4 = 0;
        View view = this.f3584a;
        if (view != null) {
            i = view.hashCode();
        } else {
            i = 0;
        }
        int i5 = i * 31;
        String str = this.f3585a;
        if (str != null) {
            i2 = str.hashCode();
        } else {
            i2 = 0;
        }
        int i6 = (i5 + i2) * 31;
        Context context = this.a;
        if (context != null) {
            i3 = context.hashCode();
        } else {
            i3 = 0;
        }
        int i7 = (i6 + i3) * 31;
        AttributeSet attributeSet = this.f3583a;
        if (attributeSet != null) {
            i4 = attributeSet.hashCode();
        }
        return i7 + i4;
    }

    public final String toString() {
        return "InflateResult(view=" + this.f3584a + ", name=" + this.f3585a + ", context=" + this.a + ", attrs=" + this.f3583a + ")";
    }
}
