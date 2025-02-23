package defpackage;

import android.content.Context;
import defpackage.C0169dd;
import java.util.concurrent.Callable;

/* renamed from: Zc  reason: default package and case insensitive filesystem */
/* compiled from: FontRequestWorker */
public final class C0110Zc implements Callable<C0169dd.a> {
    public final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ C0109Yc f762a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Context f763a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f764a;

    public C0110Zc(String str, Context context, C0109Yc yc, int i) {
        this.f764a = str;
        this.f763a = context;
        this.f762a = yc;
        this.a = i;
    }

    public final Object call() throws Exception {
        return C0169dd.a(this.f764a, this.f763a, this.f762a, this.a);
    }
}
