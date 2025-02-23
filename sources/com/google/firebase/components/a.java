package com.google.firebase.components;

import com.google.firebase.inject.Provider;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ OptionalProvider a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Provider f2819a;

    public /* synthetic */ a(OptionalProvider optionalProvider, Provider provider) {
        this.a = optionalProvider;
        this.f2819a = provider;
    }

    public final void run() {
        this.a.set(this.f2819a);
    }
}
