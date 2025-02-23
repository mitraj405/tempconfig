package defpackage;

import android.text.InputFilter;
import android.text.Spanned;
import in.juspay.hypersdk.core.InflateView;

/* renamed from: Hf  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0529Hf implements InputFilter {
    public final /* synthetic */ String a;

    public /* synthetic */ C0529Hf(String str) {
        this.a = str;
    }

    public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        return InflateView.lambda$parseKeys$0(this.a, charSequence, i, i2, spanned, i3, i4);
    }
}
