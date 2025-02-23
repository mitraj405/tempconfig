package com.google.android.material.search;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class g implements Runnable {
    public final /* synthetic */ Object a;
    public final /* synthetic */ int c;

    public /* synthetic */ g(Object obj, int i) {
        this.c = i;
        this.a = obj;
    }

    public final void run() {
        int i = this.c;
        Object obj = this.a;
        switch (i) {
            case 0:
                ((SearchViewAnimationHelper) obj).lambda$startShowAnimationExpand$0();
                return;
            case 1:
                ((SearchBar) obj).lambda$startOnLoadAnimation$1();
                return;
            default:
                ((SearchView) obj).lambda$requestFocusAndShowKeyboard$8();
                return;
        }
    }
}
