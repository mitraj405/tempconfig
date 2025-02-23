package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.appcompat.widget.AppCompatSpinner;

/* compiled from: AppCompatSpinner */
public final class a extends C0259ld {
    public final /* synthetic */ AppCompatSpinner.g a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ AppCompatSpinner f1283a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(AppCompatSpinner appCompatSpinner, View view, AppCompatSpinner.g gVar) {
        super(view);
        this.f1283a = appCompatSpinner;
        this.a = gVar;
    }

    public final Fw b() {
        return this.a;
    }

    @SuppressLint({"SyntheticAccessor"})
    public final boolean c() {
        AppCompatSpinner appCompatSpinner = this.f1283a;
        if (appCompatSpinner.getInternalPopup().a()) {
            return true;
        }
        appCompatSpinner.f1174a.k(AppCompatSpinner.c.b(appCompatSpinner), AppCompatSpinner.c.a(appCompatSpinner));
        return true;
    }
}
