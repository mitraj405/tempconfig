package defpackage;

import android.view.View;
import com.google.android.material.search.SearchView;

/* renamed from: Hv  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class Hv implements View.OnClickListener {
    public final /* synthetic */ SearchView a;
    public final /* synthetic */ int c;

    public /* synthetic */ Hv(SearchView searchView, int i) {
        this.c = i;
        this.a = searchView;
    }

    public final void onClick(View view) {
        int i = this.c;
        SearchView searchView = this.a;
        switch (i) {
            case 0:
                searchView.lambda$setUpBackButton$1(view);
                return;
            default:
                searchView.lambda$setupWithSearchBar$7(view);
                return;
        }
    }
}
