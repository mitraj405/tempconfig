package defpackage;

import android.content.Context;
import android.database.Cursor;
import android.os.Looper;
import androidx.work.impl.WorkDatabase;
import defpackage.Ly;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* renamed from: Zt  reason: default package */
/* compiled from: RoomDatabase */
public abstract class Zt {
    @Deprecated
    public volatile Ky a;

    /* renamed from: a  reason: collision with other field name */
    public Ly f768a;

    /* renamed from: a  reason: collision with other field name */
    public final ThreadLocal<Integer> f769a = new ThreadLocal<>();
    @Deprecated

    /* renamed from: a  reason: collision with other field name */
    public List<b> f770a;

    /* renamed from: a  reason: collision with other field name */
    public Executor f771a;

    /* renamed from: a  reason: collision with other field name */
    public final ReentrantReadWriteLock f772a = new ReentrantReadWriteLock();

    /* renamed from: a  reason: collision with other field name */
    public final og f773a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f774a;
    public boolean b;

    /* renamed from: Zt$a */
    /* compiled from: RoomDatabase */
    public static class a<T extends Zt> {
        public Ly.c a;

        /* renamed from: a  reason: collision with other field name */
        public final c f775a;

        /* renamed from: a  reason: collision with other field name */
        public final Context f776a;

        /* renamed from: a  reason: collision with other field name */
        public final Class<T> f777a = WorkDatabase.class;

        /* renamed from: a  reason: collision with other field name */
        public final String f778a;

        /* renamed from: a  reason: collision with other field name */
        public ArrayList<b> f779a;

        /* renamed from: a  reason: collision with other field name */
        public HashSet f780a;

        /* renamed from: a  reason: collision with other field name */
        public Executor f781a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f782a;
        public Executor b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f783b;
        public boolean c;

        public a(Context context, String str) {
            this.f776a = context;
            this.f778a = str;
            this.f783b = true;
            this.f775a = new c();
        }

        public final void a(pl... plVarArr) {
            if (this.f780a == null) {
                this.f780a = new HashSet();
            }
            for (pl plVar : plVarArr) {
                this.f780a.add(Integer.valueOf(plVar.a));
                this.f780a.add(Integer.valueOf(plVar.b));
            }
            c cVar = this.f775a;
            cVar.getClass();
            for (pl plVar2 : plVarArr) {
                int i = plVar2.a;
                HashMap<Integer, TreeMap<Integer, pl>> hashMap = cVar.a;
                TreeMap treeMap = hashMap.get(Integer.valueOf(i));
                if (treeMap == null) {
                    treeMap = new TreeMap();
                    hashMap.put(Integer.valueOf(i), treeMap);
                }
                int i2 = plVar2.b;
                pl plVar3 = (pl) treeMap.get(Integer.valueOf(i2));
                if (plVar3 != null) {
                    plVar3.toString();
                    plVar2.toString();
                }
                treeMap.put(Integer.valueOf(i2), plVar2);
            }
        }
    }

    /* renamed from: Zt$c */
    /* compiled from: RoomDatabase */
    public static class c {
        public final HashMap<Integer, TreeMap<Integer, pl>> a = new HashMap<>();
    }

    public Zt() {
        new ConcurrentHashMap();
        this.f773a = d();
    }

    public final void a() {
        boolean z;
        if (!this.f774a) {
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
            }
        }
    }

    public final void b() {
        if (!((C0408yd) this.f768a.f()).f3431a.inTransaction() && this.f769a.get() != null) {
            throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.");
        }
    }

    @Deprecated
    public final void c() {
        a();
        Ky f = this.f768a.f();
        this.f773a.c(f);
        ((C0408yd) f).a();
    }

    public abstract og d();

    public abstract Ly e(b8 b8Var);

    @Deprecated
    public final void f() {
        ((C0408yd) this.f768a.f()).b();
        if (!((C0408yd) this.f768a.f()).f3431a.inTransaction()) {
            og ogVar = this.f773a;
            if (ogVar.f3149a.compareAndSet(false, true)) {
                ogVar.f3146a.f771a.execute(ogVar.f3150a);
            }
        }
    }

    public final Cursor g(My my) {
        a();
        b();
        return ((C0408yd) this.f768a.f()).e(my);
    }

    @Deprecated
    public final void h() {
        ((C0408yd) this.f768a.f()).j();
    }

    /* renamed from: Zt$b */
    /* compiled from: RoomDatabase */
    public static abstract class b {
        public void a(C0408yd ydVar) {
        }
    }
}
