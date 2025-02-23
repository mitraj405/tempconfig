package defpackage;

import android.widget.ProgressBar;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: Tw  reason: default package and case insensitive filesystem */
/* compiled from: SimpleSearchDialogCompat */
public final class C0699Tw implements Runnable {
    public final /* synthetic */ C0714Uw a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ boolean f3798a;

    public C0699Tw(C0714Uw uw, boolean z) {
        this.a = uw;
        this.f3798a = z;
    }

    public final void run() {
        int i;
        C0714Uw uw = this.a;
        ProgressBar progressBar = uw.f3811a;
        int i2 = 0;
        boolean z = this.f3798a;
        if (progressBar != null) {
            RecyclerView recyclerView = uw.f3813a;
            if (!z) {
                i = 0;
            } else {
                i = 8;
            }
            recyclerView.setVisibility(i);
        }
        if (uw.f3813a != null) {
            ProgressBar progressBar2 = uw.f3811a;
            if (!z) {
                i2 = 8;
            }
            progressBar2.setVisibility(i2);
        }
    }
}
