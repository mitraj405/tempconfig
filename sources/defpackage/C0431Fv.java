package defpackage;

import android.view.MotionEvent;
import android.view.View;
import com.google.android.material.search.SearchView;

/* renamed from: Fv  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0431Fv implements View.OnTouchListener {
    public final /* synthetic */ SearchView a;

    public /* synthetic */ C0431Fv(SearchView searchView) {
        this.a = searchView;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.a.lambda$setUpContentOnTouchListener$3(view, motionEvent);
    }
}
