package defpackage;

import android.content.Context;
import com.google.firebase.FirebaseApp;
import com.google.firebase.inject.Provider;

/* renamed from: rc  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0317rc implements Provider {
    public final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ FirebaseApp f3222a;

    public /* synthetic */ C0317rc(FirebaseApp firebaseApp, Context context) {
        this.f3222a = firebaseApp;
        this.a = context;
    }

    public final Object get() {
        return this.f3222a.lambda$new$0(this.a);
    }
}
