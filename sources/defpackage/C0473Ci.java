package defpackage;

import defpackage.C0649QB;
import in.juspay.hyper.constants.LogSubCategory;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.concurrent.LinkedBlockingQueue;
import org.slf4j.impl.StaticLoggerBinder;

/* renamed from: Ci  reason: default package and case insensitive filesystem */
/* compiled from: LoggerFactory */
public final class C0473Ci {
    public static volatile int a;

    /* renamed from: a  reason: collision with other field name */
    public static final C0477Cy f3545a = new C0477Cy();

    /* renamed from: a  reason: collision with other field name */
    public static final String f3546a = "org/slf4j/impl/StaticLoggerBinder.class";

    /* renamed from: a  reason: collision with other field name */
    public static final C1488xu f3547a = new C1488xu();

    /* renamed from: a  reason: collision with other field name */
    public static final boolean f3548a;

    /* renamed from: a  reason: collision with other field name */
    public static final String[] f3549a = {"1.6", "1.7"};

    static {
        String str;
        boolean z;
        try {
            str = System.getProperty("slf4j.detectLoggerNameMismatch");
        } catch (SecurityException unused) {
            str = null;
        }
        if (str == null) {
            z = false;
        } else {
            z = str.equalsIgnoreCase("true");
        }
        f3548a = z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0066, code lost:
        if (r3.contains("org.slf4j.impl.StaticLoggerBinder") != false) goto L_0x0068;
     */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x006d A[Catch:{ NoClassDefFoundError -> 0x004f, NoSuchMethodError -> 0x002e, Exception -> 0x0014, all -> 0x0011 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0083 A[SYNTHETIC, Splitter:B:36:0x0083] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void a() {
        /*
            java.lang.String r0 = "Failed to instantiate SLF4J LoggerFactory"
            r1 = 2
            boolean r2 = f()     // Catch:{ NoClassDefFoundError -> 0x004f, NoSuchMethodError -> 0x002e, Exception -> 0x0014 }
            if (r2 != 0) goto L_0x0016
            java.util.LinkedHashSet r2 = b()     // Catch:{ NoClassDefFoundError -> 0x004f, NoSuchMethodError -> 0x002e, Exception -> 0x0014 }
            i(r2)     // Catch:{ NoClassDefFoundError -> 0x004f, NoSuchMethodError -> 0x002e, Exception -> 0x0014 }
            goto L_0x0017
        L_0x0011:
            r0 = move-exception
            goto L_0x0089
        L_0x0014:
            r2 = move-exception
            goto L_0x0021
        L_0x0016:
            r2 = 0
        L_0x0017:
            org.slf4j.impl.StaticLoggerBinder.getSingleton()     // Catch:{ NoClassDefFoundError -> 0x004f, NoSuchMethodError -> 0x002e, Exception -> 0x0014 }
            r3 = 3
            a = r3     // Catch:{ NoClassDefFoundError -> 0x004f, NoSuchMethodError -> 0x002e, Exception -> 0x0014 }
            h(r2)     // Catch:{ NoClassDefFoundError -> 0x004f, NoSuchMethodError -> 0x002e, Exception -> 0x0014 }
            goto L_0x007f
        L_0x0021:
            a = r1     // Catch:{ all -> 0x0011 }
            defpackage.C0649QB.b(r0, r2)     // Catch:{ all -> 0x0011 }
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0011 }
            java.lang.String r1 = "Unexpected initialization failure"
            r0.<init>(r1, r2)     // Catch:{ all -> 0x0011 }
            throw r0     // Catch:{ all -> 0x0011 }
        L_0x002e:
            r0 = move-exception
            java.lang.String r2 = r0.getMessage()     // Catch:{ all -> 0x0011 }
            if (r2 == 0) goto L_0x004e
            java.lang.String r3 = "org.slf4j.impl.StaticLoggerBinder.getSingleton()"
            boolean r2 = r2.contains(r3)     // Catch:{ all -> 0x0011 }
            if (r2 == 0) goto L_0x004e
            a = r1     // Catch:{ all -> 0x0011 }
            java.lang.String r1 = "slf4j-api 1.6.x (or later) is incompatible with this binding."
            defpackage.C0649QB.a(r1)     // Catch:{ all -> 0x0011 }
            java.lang.String r1 = "Your binding is version 1.5.5 or earlier."
            defpackage.C0649QB.a(r1)     // Catch:{ all -> 0x0011 }
            java.lang.String r1 = "Upgrade your binding to version 1.6.x."
            defpackage.C0649QB.a(r1)     // Catch:{ all -> 0x0011 }
        L_0x004e:
            throw r0     // Catch:{ all -> 0x0011 }
        L_0x004f:
            r2 = move-exception
            java.lang.String r3 = r2.getMessage()     // Catch:{ all -> 0x0011 }
            if (r3 != 0) goto L_0x0057
            goto L_0x006a
        L_0x0057:
            java.lang.String r4 = "org/slf4j/impl/StaticLoggerBinder"
            boolean r4 = r3.contains(r4)     // Catch:{ all -> 0x0011 }
            if (r4 == 0) goto L_0x0060
            goto L_0x0068
        L_0x0060:
            java.lang.String r4 = "org.slf4j.impl.StaticLoggerBinder"
            boolean r3 = r3.contains(r4)     // Catch:{ all -> 0x0011 }
            if (r3 == 0) goto L_0x006a
        L_0x0068:
            r3 = 1
            goto L_0x006b
        L_0x006a:
            r3 = 0
        L_0x006b:
            if (r3 == 0) goto L_0x0083
            r0 = 4
            a = r0     // Catch:{ all -> 0x0011 }
            java.lang.String r0 = "Failed to load class \"org.slf4j.impl.StaticLoggerBinder\"."
            defpackage.C0649QB.a(r0)     // Catch:{ all -> 0x0011 }
            java.lang.String r0 = "Defaulting to no-operation (NOP) logger implementation"
            defpackage.C0649QB.a(r0)     // Catch:{ all -> 0x0011 }
            java.lang.String r0 = "See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details."
            defpackage.C0649QB.a(r0)     // Catch:{ all -> 0x0011 }
        L_0x007f:
            g()
            return
        L_0x0083:
            a = r1     // Catch:{ all -> 0x0011 }
            defpackage.C0649QB.b(r0, r2)     // Catch:{ all -> 0x0011 }
            throw r2     // Catch:{ all -> 0x0011 }
        L_0x0089:
            g()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0473Ci.a():void");
    }

    public static LinkedHashSet b() {
        Enumeration<URL> enumeration;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        try {
            ClassLoader classLoader = C0473Ci.class.getClassLoader();
            String str = f3546a;
            if (classLoader == null) {
                enumeration = ClassLoader.getSystemResources(str);
            } else {
                enumeration = classLoader.getResources(str);
            }
            while (enumeration.hasMoreElements()) {
                linkedHashSet.add(enumeration.nextElement());
            }
        } catch (IOException e) {
            C0649QB.b("Error getting resources from path", e);
        }
        return linkedHashSet;
    }

    public static ILoggerFactory c() {
        if (a == 0) {
            synchronized (C0473Ci.class) {
                if (a == 0) {
                    a = 1;
                    a();
                    if (a == 3) {
                        j();
                    }
                }
            }
        }
        int i = a;
        if (i == 1) {
            return f3545a;
        }
        if (i == 2) {
            throw new IllegalStateException("org.slf4j.LoggerFactory in failed state. Original exception was thrown EARLIER. See also http://www.slf4j.org/codes.html#unsuccessfulInit");
        } else if (i == 3) {
            return StaticLoggerBinder.getSingleton().getLoggerFactory();
        } else {
            if (i == 4) {
                return f3547a;
            }
            throw new IllegalStateException("Unreachable code");
        }
    }

    public static Bi d(Class<?> cls) {
        int i;
        Bi e = e(cls.getName());
        if (f3548a) {
            C0649QB.a aVar = C0649QB.a;
            Class cls2 = null;
            if (aVar == null) {
                if (C0649QB.f3764a) {
                    aVar = null;
                } else {
                    try {
                        aVar = new C0649QB.a();
                    } catch (SecurityException unused) {
                        aVar = null;
                    }
                    C0649QB.a = aVar;
                    C0649QB.f3764a = true;
                }
            }
            if (aVar != null) {
                Class[] classContext = aVar.getClassContext();
                String name = C0649QB.class.getName();
                int i2 = 0;
                while (i2 < classContext.length && !name.equals(classContext[i2].getName())) {
                    i2++;
                }
                if (i2 >= classContext.length || (i = i2 + 2) >= classContext.length) {
                    throw new IllegalStateException("Failed to find org.slf4j.helpers.Util or its caller in the stack; this should not happen");
                }
                cls2 = classContext[i];
            }
            if (cls2 != null && (!cls2.isAssignableFrom(cls))) {
                C0649QB.a(String.format("Detected logger name mismatch. Given name: \"%s\"; computed name: \"%s\".", new Object[]{e.getName(), cls2.getName()}));
                C0649QB.a("See http://www.slf4j.org/codes.html#loggerNameMismatch for an explanation");
            }
        }
        return e;
    }

    public static Bi e(String str) {
        return c().b(str);
    }

    public static boolean f() {
        String str;
        try {
            str = System.getProperty("java.vendor.url");
        } catch (SecurityException unused) {
            str = null;
        }
        if (str == null) {
            return false;
        }
        return str.toLowerCase().contains(LogSubCategory.LifeCycle.ANDROID);
    }

    public static void g() {
        boolean z;
        C0477Cy cy = f3545a;
        synchronized (cy) {
            cy.f3565a = true;
            Iterator it = new ArrayList(cy.a.values()).iterator();
            while (it.hasNext()) {
                By by = (By) it.next();
                by.a = e(by.c);
            }
        }
        LinkedBlockingQueue<C0490Dy> linkedBlockingQueue = f3545a.f3564a;
        int size = linkedBlockingQueue.size();
        ArrayList arrayList = new ArrayList(128);
        int i = 0;
        while (linkedBlockingQueue.drainTo(arrayList, 128) != 0) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                C0490Dy dy = (C0490Dy) it2.next();
                if (dy != null) {
                    By by2 = dy.a;
                    String str = by2.c;
                    if (by2.a == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        throw new IllegalStateException("Delegate logger cannot be null at this state.");
                    } else if (!(by2.a instanceof C1351qm)) {
                        if (!by2.h()) {
                            C0649QB.a(str);
                        } else if (by2.h()) {
                            try {
                                by2.f3541a.invoke(by2.a, new Object[]{dy});
                            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
                            }
                        }
                    }
                }
                int i2 = i + 1;
                if (i == 0) {
                    if (dy.a.h()) {
                        C0649QB.a("A number (" + size + ") of logging calls during the initialization phase have been intercepted and are");
                        C0649QB.a("now being replayed. These are subject to the filtering rules of the underlying logging system.");
                        C0649QB.a("See also http://www.slf4j.org/codes.html#replay");
                    } else if (!(dy.a.a instanceof C1351qm)) {
                        C0649QB.a("The following set of substitute loggers may have been accessed");
                        C0649QB.a("during the initialization phase. Logging calls during this");
                        C0649QB.a("phase were not honored. However, subsequent logging calls to these");
                        C0649QB.a("loggers will work as normally expected.");
                        C0649QB.a("See also http://www.slf4j.org/codes.html#substituteLogger");
                    }
                }
                i = i2;
            }
            arrayList.clear();
        }
        C0477Cy cy2 = f3545a;
        cy2.a.clear();
        cy2.f3564a.clear();
    }

    public static void h(LinkedHashSet linkedHashSet) {
        if (linkedHashSet != null) {
            boolean z = true;
            if (linkedHashSet.size() <= 1) {
                z = false;
            }
            if (z) {
                C0649QB.a("Actual binding is of type [" + StaticLoggerBinder.getSingleton().getLoggerFactoryClassStr() + "]");
            }
        }
    }

    public static void i(LinkedHashSet linkedHashSet) {
        boolean z = true;
        if (linkedHashSet.size() <= 1) {
            z = false;
        }
        if (z) {
            C0649QB.a("Class path contains multiple SLF4J bindings.");
            Iterator it = linkedHashSet.iterator();
            while (it.hasNext()) {
                C0649QB.a("Found binding in [" + ((URL) it.next()) + "]");
            }
            C0649QB.a("See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.");
        }
    }

    public static final void j() {
        try {
            String str = StaticLoggerBinder.REQUESTED_API_VERSION;
            boolean z = false;
            for (String startsWith : f3549a) {
                if (str.startsWith(startsWith)) {
                    z = true;
                }
            }
            if (!z) {
                C0649QB.a("The requested version " + str + " by your slf4j binding is not compatible with " + Arrays.asList(f3549a).toString());
                C0649QB.a("See http://www.slf4j.org/codes.html#version_mismatch for further details.");
            }
        } catch (NoSuchFieldError unused) {
        } catch (Throwable th) {
            C0649QB.b("Unexpected problem occured during version sanity check", th);
        }
    }
}
