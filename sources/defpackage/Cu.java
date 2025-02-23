package defpackage;

import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: Cu  reason: default package */
/* compiled from: RxJavaPlugins */
public final class Cu {
    public static final a a = new a();

    /* renamed from: a  reason: collision with other field name */
    public static final Cu f3555a = new Cu();

    /* renamed from: a  reason: collision with other field name */
    public final AtomicReference<C1396su> f3556a = new AtomicReference<>();
    public final AtomicReference<C0453Au> b = new AtomicReference<>();
    public final AtomicReference<Eu> c = new AtomicReference<>();
    public final AtomicReference<C1375ru> d = new AtomicReference<>();
    public final AtomicReference<Du> e = new AtomicReference<>();

    /* renamed from: Cu$a */
    /* compiled from: RxJavaPlugins */
    public static class a extends C1396su {
    }

    /* renamed from: Cu$b */
    /* compiled from: RxJavaPlugins */
    public class b extends C1375ru {
    }

    public static Object d(Class<?> cls, Properties properties) {
        Properties properties2 = (Properties) properties.clone();
        String simpleName = cls.getSimpleName();
        String property = properties2.getProperty("rxjava.plugin." + simpleName + ".implementation");
        if (property == null) {
            try {
                Iterator it = properties2.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry entry = (Map.Entry) it.next();
                    String obj = entry.getKey().toString();
                    if (obj.startsWith("rxjava.plugin.") && obj.endsWith(".class") && simpleName.equals(entry.getValue().toString())) {
                        String str = "rxjava.plugin." + obj.substring(0, obj.length() - 6).substring(14) + ".impl";
                        property = properties2.getProperty(str);
                        if (property == null) {
                            throw new IllegalStateException("Implementing class declaration for " + simpleName + " missing: " + str);
                        }
                    }
                }
            } catch (SecurityException e2) {
                e2.printStackTrace();
            }
        }
        if (property == null) {
            return null;
        }
        try {
            return Class.forName(property).asSubclass(cls).newInstance();
        } catch (ClassCastException e3) {
            throw new IllegalStateException(simpleName + " implementation is not an instance of " + simpleName + ": " + property, e3);
        } catch (ClassNotFoundException e4) {
            throw new IllegalStateException(xx.D(simpleName, " implementation class not found: ", property), e4);
        } catch (InstantiationException e5) {
            throw new IllegalStateException(xx.D(simpleName, " implementation not able to be instantiated: ", property), e5);
        } catch (IllegalAccessException e6) {
            throw new IllegalStateException(xx.D(simpleName, " implementation not able to be accessed: ", property), e6);
        }
    }

    public static Properties g() {
        try {
            return System.getProperties();
        } catch (SecurityException unused) {
            return new Properties();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002a A[LOOP:1: B:10:0x002a->B:13:0x0035, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x001a A[LOOP:0: B:5:0x001a->B:8:0x0025, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final defpackage.C1375ru a() {
        /*
            r4 = this;
            java.util.concurrent.atomic.AtomicReference<ru> r0 = r4.d
            java.lang.Object r1 = r0.get()
            if (r1 != 0) goto L_0x0037
            java.lang.Class<ru> r1 = defpackage.C1375ru.class
            java.util.Properties r2 = g()
            java.lang.Object r1 = d(r1, r2)
            r2 = 0
            if (r1 != 0) goto L_0x0028
            Cu$b r3 = new Cu$b
            r3.<init>()
        L_0x001a:
            boolean r1 = r0.compareAndSet(r2, r3)
            if (r1 == 0) goto L_0x0021
            goto L_0x0037
        L_0x0021:
            java.lang.Object r1 = r0.get()
            if (r1 == 0) goto L_0x001a
            goto L_0x0037
        L_0x0028:
            ru r1 = (defpackage.C1375ru) r1
        L_0x002a:
            boolean r3 = r0.compareAndSet(r2, r1)
            if (r3 == 0) goto L_0x0031
            goto L_0x0037
        L_0x0031:
            java.lang.Object r3 = r0.get()
            if (r3 == 0) goto L_0x002a
        L_0x0037:
            java.lang.Object r0 = r0.get()
            ru r0 = (defpackage.C1375ru) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.Cu.a():ru");
    }

    /* JADX WARNING: Removed duplicated region for block: B:4:0x0015 A[LOOP:0: B:4:0x0015->B:7:0x0022, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0027 A[LOOP:1: B:9:0x0027->B:12:0x0032, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final defpackage.C1396su b() {
        /*
            r4 = this;
            java.util.concurrent.atomic.AtomicReference<su> r0 = r4.f3556a
            java.lang.Object r1 = r0.get()
            if (r1 != 0) goto L_0x0034
            java.lang.Class<su> r1 = defpackage.C1396su.class
            java.util.Properties r2 = g()
            java.lang.Object r1 = d(r1, r2)
            r2 = 0
            if (r1 != 0) goto L_0x0025
        L_0x0015:
            Cu$a r1 = a
            boolean r1 = r0.compareAndSet(r2, r1)
            if (r1 == 0) goto L_0x001e
            goto L_0x0034
        L_0x001e:
            java.lang.Object r1 = r0.get()
            if (r1 == 0) goto L_0x0015
            goto L_0x0034
        L_0x0025:
            su r1 = (defpackage.C1396su) r1
        L_0x0027:
            boolean r3 = r0.compareAndSet(r2, r1)
            if (r3 == 0) goto L_0x002e
            goto L_0x0034
        L_0x002e:
            java.lang.Object r3 = r0.get()
            if (r3 == 0) goto L_0x0027
        L_0x0034:
            java.lang.Object r0 = r0.get()
            su r0 = (defpackage.C1396su) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.Cu.b():su");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0027 A[LOOP:1: B:10:0x0027->B:13:0x0032, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x0017 A[LOOP:0: B:5:0x0017->B:8:0x0022, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final defpackage.C0453Au c() {
        /*
            r4 = this;
            java.util.concurrent.atomic.AtomicReference<Au> r0 = r4.b
            java.lang.Object r1 = r0.get()
            if (r1 != 0) goto L_0x0034
            java.lang.Class<Au> r1 = defpackage.C0453Au.class
            java.util.Properties r2 = g()
            java.lang.Object r1 = d(r1, r2)
            r2 = 0
            if (r1 != 0) goto L_0x0025
            Bu r3 = defpackage.C0464Bu.a
        L_0x0017:
            boolean r1 = r0.compareAndSet(r2, r3)
            if (r1 == 0) goto L_0x001e
            goto L_0x0034
        L_0x001e:
            java.lang.Object r1 = r0.get()
            if (r1 == 0) goto L_0x0017
            goto L_0x0034
        L_0x0025:
            Au r1 = (defpackage.C0453Au) r1
        L_0x0027:
            boolean r3 = r0.compareAndSet(r2, r1)
            if (r3 == 0) goto L_0x002e
            goto L_0x0034
        L_0x002e:
            java.lang.Object r3 = r0.get()
            if (r3 == 0) goto L_0x0027
        L_0x0034:
            java.lang.Object r0 = r0.get()
            Au r0 = (defpackage.C0453Au) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.Cu.c():Au");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0027 A[LOOP:1: B:10:0x0027->B:13:0x0032, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x0017 A[LOOP:0: B:5:0x0017->B:8:0x0022, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final defpackage.Du e() {
        /*
            r4 = this;
            java.util.concurrent.atomic.AtomicReference<Du> r0 = r4.e
            java.lang.Object r1 = r0.get()
            if (r1 != 0) goto L_0x0034
            java.lang.Class<Du> r1 = defpackage.Du.class
            java.util.Properties r2 = g()
            java.lang.Object r1 = d(r1, r2)
            r2 = 0
            if (r1 != 0) goto L_0x0025
            Du r3 = defpackage.Du.a
        L_0x0017:
            boolean r1 = r0.compareAndSet(r2, r3)
            if (r1 == 0) goto L_0x001e
            goto L_0x0034
        L_0x001e:
            java.lang.Object r1 = r0.get()
            if (r1 == 0) goto L_0x0017
            goto L_0x0034
        L_0x0025:
            Du r1 = (defpackage.Du) r1
        L_0x0027:
            boolean r3 = r0.compareAndSet(r2, r1)
            if (r3 == 0) goto L_0x002e
            goto L_0x0034
        L_0x002e:
            java.lang.Object r3 = r0.get()
            if (r3 == 0) goto L_0x0027
        L_0x0034:
            java.lang.Object r0 = r0.get()
            Du r0 = (defpackage.Du) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.Cu.e():Du");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0027 A[LOOP:1: B:10:0x0027->B:13:0x0032, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x0017 A[LOOP:0: B:5:0x0017->B:8:0x0022, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final defpackage.Eu f() {
        /*
            r4 = this;
            java.util.concurrent.atomic.AtomicReference<Eu> r0 = r4.c
            java.lang.Object r1 = r0.get()
            if (r1 != 0) goto L_0x0034
            java.lang.Class<Eu> r1 = defpackage.Eu.class
            java.util.Properties r2 = g()
            java.lang.Object r1 = d(r1, r2)
            r2 = 0
            if (r1 != 0) goto L_0x0025
            Fu r3 = defpackage.C0511Fu.a
        L_0x0017:
            boolean r1 = r0.compareAndSet(r2, r3)
            if (r1 == 0) goto L_0x001e
            goto L_0x0034
        L_0x001e:
            java.lang.Object r1 = r0.get()
            if (r1 == 0) goto L_0x0017
            goto L_0x0034
        L_0x0025:
            Eu r1 = (defpackage.Eu) r1
        L_0x0027:
            boolean r3 = r0.compareAndSet(r2, r1)
            if (r3 == 0) goto L_0x002e
            goto L_0x0034
        L_0x002e:
            java.lang.Object r3 = r0.get()
            if (r3 == 0) goto L_0x0027
        L_0x0034:
            java.lang.Object r0 = r0.get()
            Eu r0 = (defpackage.Eu) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.Cu.f():Eu");
    }
}
