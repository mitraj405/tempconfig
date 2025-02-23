package defpackage;

import android.content.Context;
import defpackage.C0169dd;
import java.util.concurrent.Callable;

/* renamed from: bd  reason: default package and case insensitive filesystem */
/* compiled from: FontRequestWorker */
public final class C0147bd implements Callable<C0169dd.a> {
    public final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ C0109Yc f2738a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Context f2739a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f2740a;

    public C0147bd(String str, Context context, C0109Yc yc, int i) {
        this.f2740a = str;
        this.f2739a = context;
        this.f2738a = yc;
        this.a = i;
    }

    public final Object call() throws Exception {
        try {
            return C0169dd.a(this.f2740a, this.f2739a, this.f2738a, this.a);
        } catch (Throwable unused) {
            return new C0169dd.a(-3);
        }
    }
}
