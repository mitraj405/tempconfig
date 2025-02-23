package defpackage;

import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbHandler;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;

/* renamed from: y7  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0402y7 implements BreadcrumbHandler {
    public final /* synthetic */ CrashlyticsCore a;

    public /* synthetic */ C0402y7(CrashlyticsCore crashlyticsCore) {
        this.a = crashlyticsCore;
    }

    public final void handleBreadcrumb(String str) {
        this.a.log(str);
    }
}
