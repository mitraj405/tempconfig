package defpackage;

import android.view.View;
import android.widget.AdapterView;
import cris.org.in.ima.mobikwiklayout.view.MKSpinner;

/* renamed from: V8  reason: default package and case insensitive filesystem */
/* compiled from: DialogPlus */
public final class C0718V8 implements Sn {
    public final /* synthetic */ C0704U8 a;

    public C0718V8(C0704U8 u8) {
        this.a = u8;
    }

    public final void a(View view, int i) {
        C0704U8 u8 = this.a;
        Tn tn = u8.a;
        if (tn != null) {
            MKSpinner.a aVar = MKSpinner.a.this;
            MKSpinner mKSpinner = MKSpinner.this;
            if (!mKSpinner.k) {
                if (aVar.f5288a) {
                    i--;
                }
                int i2 = i;
                mKSpinner.setSelection(i2);
                AdapterView.OnItemSelectedListener onItemSelectedListener = MKSpinner.this.a;
                if (onItemSelectedListener != null) {
                    onItemSelectedListener.onItemSelected((AdapterView) null, view, i2, 0);
                }
                u8.b();
            }
        }
    }
}
