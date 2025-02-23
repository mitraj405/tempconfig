package defpackage;

import android.view.View;
import android.view.ViewTreeObserver;
import com.google.firebase.perf.util.FirstDrawDoneListener;

/* renamed from: Bc  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0083Bc implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ View a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ FirstDrawDoneListener f49a;

    public /* synthetic */ C0083Bc(FirstDrawDoneListener firstDrawDoneListener, View view) {
        this.f49a = firstDrawDoneListener;
        this.a = view;
    }

    public final void onGlobalLayout() {
        this.f49a.lambda$onDraw$0(this.a);
    }
}
