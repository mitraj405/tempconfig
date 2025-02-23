package defpackage;

import android.adservices.topics.GetTopicsRequest;
import android.annotation.SuppressLint;

@SuppressLint({"NewApi", "ClassVerificationFailure"})
/* renamed from: nA  reason: default package and case insensitive filesystem */
/* compiled from: TopicsManagerApi33Ext5Impl.kt */
public final class C0276nA extends pA {
    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C0276nA(android.content.Context r2) {
        /*
            r1 = this;
            java.lang.Class<android.adservices.topics.TopicsManager> r0 = android.adservices.topics.TopicsManager.class
            java.lang.Object r2 = r2.getSystemService(r0)
            java.lang.String r0 = "context.getSystemService…opicsManager::class.java)"
            defpackage.C1177ig.e(r2, r0)
            android.adservices.topics.TopicsManager r2 = (android.adservices.topics.TopicsManager) r2
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0276nA.<init>(android.content.Context):void");
    }

    public final GetTopicsRequest d(C0272me meVar) {
        C1177ig.f(meVar, "request");
        GetTopicsRequest build = new GetTopicsRequest.Builder().setAdsSdkName(meVar.a()).setShouldRecordObservation(meVar.b()).build();
        C1177ig.e(build, "Builder()\n            .s…ion)\n            .build()");
        return build;
    }
}
