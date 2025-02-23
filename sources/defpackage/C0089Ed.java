package defpackage;

import androidx.activity.ComponentActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* renamed from: Ed  reason: default package and case insensitive filesystem */
/* compiled from: FullyDrawnReporter.kt */
public final class C0089Ed {
    public final Object a = new Object();

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList f134a = new ArrayList();

    /* renamed from: a  reason: collision with other field name */
    public final Executor f135a;

    /* renamed from: a  reason: collision with other field name */
    public final Function0<Unit> f136a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f137a;

    public C0089Ed(ComponentActivity.e eVar, C0153c6 c6Var) {
        C1177ig.f(eVar, "executor");
        this.f135a = eVar;
        this.f136a = c6Var;
    }

    public final void a() {
        synchronized (this.a) {
            this.f137a = true;
            Iterator it = this.f134a.iterator();
            while (it.hasNext()) {
                ((Function0) it.next()).invoke();
            }
            this.f134a.clear();
            Unit unit = Unit.a;
        }
    }
}
