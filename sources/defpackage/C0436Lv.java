package defpackage;

import com.google.android.material.search.SearchView;

/* renamed from: Lv  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0436Lv implements Runnable {
    public final /* synthetic */ SearchView a;
    public final /* synthetic */ int c;

    public /* synthetic */ C0436Lv(SearchView searchView, int i) {
        this.c = i;
        this.a = searchView;
    }

    public final void run() {
        int i = this.c;
        SearchView searchView = this.a;
        switch (i) {
            case 0:
                searchView.lambda$clearFocusAndHideKeyboard$9();
                return;
            default:
                searchView.requestFocusAndShowKeyboardIfNeeded();
                return;
        }
    }
}
