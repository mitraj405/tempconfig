package com.google.android.material.search;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class h implements Runnable {
    public final /* synthetic */ Object a;
    public final /* synthetic */ int c;

    public /* synthetic */ h(Object obj, int i) {
        this.c = i;
        this.a = obj;
    }

    public final void run() {
        int i = this.c;
        Object obj = this.a;
        switch (i) {
            case 0:
                ((SearchViewAnimationHelper) obj).lambda$startShowAnimationTranslate$1();
                return;
            default:
                ((SearchView) obj).show();
                return;
        }
    }
}
