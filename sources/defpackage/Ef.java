package defpackage;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import in.juspay.hyper.constants.LogCategory;

/* renamed from: Ef  reason: default package */
/* compiled from: InflateRequest.kt */
public final class Ef {
    public final C0680Sb a;

    /* renamed from: a  reason: collision with other field name */
    public final Context f3578a;

    /* renamed from: a  reason: collision with other field name */
    public final AttributeSet f3579a;

    /* renamed from: a  reason: collision with other field name */
    public final View f3580a;

    /* renamed from: a  reason: collision with other field name */
    public final String f3581a;

    public Ef(String str, Context context, AttributeSet attributeSet, View view, C0680Sb sb) {
        C1177ig.g(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
        C1177ig.g(context, LogCategory.CONTEXT);
        C1177ig.g(sb, "fallbackViewCreator");
        this.f3581a = str;
        this.f3578a = context;
        this.f3579a = attributeSet;
        this.f3580a = view;
        this.a = sb;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Ef)) {
            return false;
        }
        Ef ef = (Ef) obj;
        if (!C1177ig.a(this.f3581a, ef.f3581a) || !C1177ig.a(this.f3578a, ef.f3578a) || !C1177ig.a(this.f3579a, ef.f3579a) || !C1177ig.a(this.f3580a, ef.f3580a) || !C1177ig.a(this.a, ef.a)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5 = 0;
        String str = this.f3581a;
        if (str != null) {
            i = str.hashCode();
        } else {
            i = 0;
        }
        int i6 = i * 31;
        Context context = this.f3578a;
        if (context != null) {
            i2 = context.hashCode();
        } else {
            i2 = 0;
        }
        int i7 = (i6 + i2) * 31;
        AttributeSet attributeSet = this.f3579a;
        if (attributeSet != null) {
            i3 = attributeSet.hashCode();
        } else {
            i3 = 0;
        }
        int i8 = (i7 + i3) * 31;
        View view = this.f3580a;
        if (view != null) {
            i4 = view.hashCode();
        } else {
            i4 = 0;
        }
        int i9 = (i8 + i4) * 31;
        C0680Sb sb = this.a;
        if (sb != null) {
            i5 = sb.hashCode();
        }
        return i9 + i5;
    }

    public final String toString() {
        return "InflateRequest(name=" + this.f3581a + ", context=" + this.f3578a + ", attrs=" + this.f3579a + ", parent=" + this.f3580a + ", fallbackViewCreator=" + this.a + ")";
    }

    public /* synthetic */ Ef(String str, Context context, AttributeSet attributeSet, C0680Sb sb) {
        this(str, context, attributeSet, (View) null, sb);
    }
}
