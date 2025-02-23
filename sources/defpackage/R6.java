package defpackage;

import android.content.Context;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

/* renamed from: R6  reason: default package */
/* compiled from: ConstraintTracker */
public abstract class R6<T> {
    public static final /* synthetic */ int a = 0;

    /* renamed from: a  reason: collision with other field name */
    public final Context f492a;

    /* renamed from: a  reason: collision with other field name */
    public final TaskExecutor f493a;

    /* renamed from: a  reason: collision with other field name */
    public final Object f494a = new Object();

    /* renamed from: a  reason: collision with other field name */
    public final LinkedHashSet f495a = new LinkedHashSet();
    public T b;

    /* renamed from: R6$a */
    /* compiled from: ConstraintTracker */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ List f496a;

        public a(ArrayList arrayList) {
            this.f496a = arrayList;
        }

        public final void run() {
            for (Q6 a2 : this.f496a) {
                a2.a(R6.this.b);
            }
        }
    }

    static {
        zi.e("ConstraintTracker");
    }

    public R6(Context context, TaskExecutor taskExecutor) {
        this.f492a = context.getApplicationContext();
        this.f493a = taskExecutor;
    }

    public abstract T a();

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(T r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f494a
            monitor-enter(r0)
            T r1 = r3.b     // Catch:{ all -> 0x002b }
            if (r1 == r4) goto L_0x0029
            if (r1 == 0) goto L_0x0010
            boolean r1 = r1.equals(r4)     // Catch:{ all -> 0x002b }
            if (r1 == 0) goto L_0x0010
            goto L_0x0029
        L_0x0010:
            r3.b = r4     // Catch:{ all -> 0x002b }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x002b }
            java.util.LinkedHashSet r1 = r3.f495a     // Catch:{ all -> 0x002b }
            r4.<init>(r1)     // Catch:{ all -> 0x002b }
            androidx.work.impl.utils.taskexecutor.TaskExecutor r1 = r3.f493a     // Catch:{ all -> 0x002b }
            WD$a r1 = r1.a()     // Catch:{ all -> 0x002b }
            R6$a r2 = new R6$a     // Catch:{ all -> 0x002b }
            r2.<init>(r4)     // Catch:{ all -> 0x002b }
            r1.execute(r2)     // Catch:{ all -> 0x002b }
            monitor-exit(r0)     // Catch:{ all -> 0x002b }
            return
        L_0x0029:
            monitor-exit(r0)     // Catch:{ all -> 0x002b }
            return
        L_0x002b:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002b }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.R6.b(java.lang.Object):void");
    }

    public abstract void c();

    public abstract void d();
}
