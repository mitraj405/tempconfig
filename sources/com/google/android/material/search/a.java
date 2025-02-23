package com.google.android.material.search;

import android.view.View;
import com.google.android.material.appbar.AppBarLayout;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ View a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ AppBarLayout f3510a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ SearchBar f3511a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ SearchBarAnimationHelper f3512a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ boolean f3513a;

    public /* synthetic */ a(SearchBarAnimationHelper searchBarAnimationHelper, SearchBar searchBar, View view, AppBarLayout appBarLayout, boolean z) {
        this.f3512a = searchBarAnimationHelper;
        this.f3511a = searchBar;
        this.a = view;
        this.f3510a = appBarLayout;
        this.f3513a = z;
    }

    public final void run() {
        this.f3512a.lambda$startExpandAnimation$0(this.f3511a, this.a, this.f3510a, this.f3513a);
    }
}
