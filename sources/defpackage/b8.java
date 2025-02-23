package defpackage;

import android.content.Context;
import defpackage.Ly;
import defpackage.Zt;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* renamed from: b8  reason: default package */
/* compiled from: DatabaseConfiguration */
public final class b8 {
    public final Ly.c a;

    /* renamed from: a  reason: collision with other field name */
    public final Zt.c f2731a;

    /* renamed from: a  reason: collision with other field name */
    public final Context f2732a;

    /* renamed from: a  reason: collision with other field name */
    public final String f2733a;

    /* renamed from: a  reason: collision with other field name */
    public final List<Zt.b> f2734a;

    /* renamed from: a  reason: collision with other field name */
    public final Executor f2735a;

    /* renamed from: a  reason: collision with other field name */
    public final boolean f2736a;
    public final Executor b;

    /* renamed from: b  reason: collision with other field name */
    public final boolean f2737b;

    public b8(Context context, String str, Ly.c cVar, Zt.c cVar2, ArrayList arrayList, boolean z, int i, Executor executor, Executor executor2, boolean z2, boolean z3) {
        this.a = cVar;
        this.f2732a = context;
        this.f2733a = str;
        this.f2731a = cVar2;
        this.f2734a = arrayList;
        this.f2735a = executor;
        this.b = executor2;
        this.f2736a = z2;
        this.f2737b = z3;
    }

    public final boolean a(int i, int i2) {
        boolean z;
        if (i > i2) {
            z = true;
        } else {
            z = false;
        }
        if (z && this.f2737b) {
            return false;
        }
        if (this.f2736a) {
            return true;
        }
        return false;
    }
}
