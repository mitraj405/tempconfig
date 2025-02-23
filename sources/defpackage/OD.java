package defpackage;

import android.content.Context;
import android.text.TextUtils;
import defpackage.Ly;

/* renamed from: OD  reason: default package */
/* compiled from: WorkDatabase */
public final class OD implements Ly.c {
    public final /* synthetic */ Context a;

    public OD(Context context) {
        this.a = context;
    }

    public final Ly a(Ly.b bVar) {
        Ly.a aVar = bVar.a;
        if (aVar != null) {
            Context context = this.a;
            if (context != null) {
                String str = bVar.f392a;
                if (!TextUtils.isEmpty(str)) {
                    return new C0425zd(context, str, aVar, true);
                }
                throw new IllegalArgumentException("Must set a non-null database name to a configuration that uses the no backup directory.");
            }
            throw new IllegalArgumentException("Must set a non-null context to create the configuration.");
        }
        throw new IllegalArgumentException("Must set a callback to create the configuration.");
    }
}
