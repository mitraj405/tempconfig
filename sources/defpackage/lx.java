package defpackage;

import android.view.View;
import com.google.android.material.snackbar.Snackbar;

/* renamed from: lx  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class lx implements View.OnClickListener {
    public final /* synthetic */ View.OnClickListener a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Snackbar f3520a;

    public /* synthetic */ lx(Snackbar snackbar, View.OnClickListener onClickListener) {
        this.f3520a = snackbar;
        this.a = onClickListener;
    }

    public final void onClick(View view) {
        this.f3520a.lambda$setAction$0(this.a, view);
    }
}
