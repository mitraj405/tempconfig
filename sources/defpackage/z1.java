package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.os.Trace;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* renamed from: z1  reason: default package */
/* compiled from: AppInitializer */
public final class z1 {
    public static final Object a = new Object();

    /* renamed from: a  reason: collision with other field name */
    public static volatile z1 f3445a;

    /* renamed from: a  reason: collision with other field name */
    public final Context f3446a;

    /* renamed from: a  reason: collision with other field name */
    public final HashMap f3447a = new HashMap();

    /* renamed from: a  reason: collision with other field name */
    public final HashSet f3448a = new HashSet();

    public z1(Context context) {
        this.f3446a = context.getApplicationContext();
    }

    public static z1 c(Context context) {
        if (f3445a == null) {
            synchronized (a) {
                if (f3445a == null) {
                    f3445a = new z1(context);
                }
            }
        }
        return f3445a;
    }

    public final void a(Bundle bundle) {
        HashSet hashSet;
        String string = this.f3446a.getString(Yr.androidx_startup);
        if (bundle != null) {
            try {
                HashSet hashSet2 = new HashSet();
                Iterator<String> it = bundle.keySet().iterator();
                while (true) {
                    boolean hasNext = it.hasNext();
                    hashSet = this.f3448a;
                    if (!hasNext) {
                        break;
                    }
                    String next = it.next();
                    if (string.equals(bundle.getString(next, (String) null))) {
                        Class<?> cls = Class.forName(next);
                        if (Sf.class.isAssignableFrom(cls)) {
                            hashSet.add(cls);
                        }
                    }
                }
                Iterator it2 = hashSet.iterator();
                while (it2.hasNext()) {
                    b((Class) it2.next(), hashSet2);
                }
            } catch (ClassNotFoundException e) {
                throw new Qx((Throwable) e);
            }
        }
    }

    public final Object b(Class cls, HashSet hashSet) {
        Object obj;
        if (C0323sA.a()) {
            try {
                Trace.beginSection(cls.getSimpleName());
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        }
        if (!hashSet.contains(cls)) {
            HashMap hashMap = this.f3447a;
            if (!hashMap.containsKey(cls)) {
                hashSet.add(cls);
                Sf sf = (Sf) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                List<Class<? extends Sf<?>>> b = sf.b();
                if (!b.isEmpty()) {
                    for (Class next : b) {
                        if (!hashMap.containsKey(next)) {
                            b(next, hashSet);
                        }
                    }
                }
                obj = sf.a(this.f3446a);
                hashSet.remove(cls);
                hashMap.put(cls, obj);
            } else {
                obj = hashMap.get(cls);
            }
            Trace.endSection();
            return obj;
        }
        throw new IllegalStateException(String.format("Cannot initialize %s. Cycle detected.", new Object[]{cls.getName()}));
    }
}
