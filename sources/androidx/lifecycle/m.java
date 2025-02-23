package androidx.lifecycle;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.a;
import androidx.savedstate.SavedStateRegistry;
import java.lang.reflect.Constructor;
import java.util.LinkedHashMap;

/* compiled from: SavedStateViewModelFactory.kt */
public final class m extends ViewModelProvider.c implements ViewModelProvider.Factory {
    public final Application a;

    /* renamed from: a  reason: collision with other field name */
    public final Bundle f2212a;

    /* renamed from: a  reason: collision with other field name */
    public final Lifecycle f2213a;

    /* renamed from: a  reason: collision with other field name */
    public final ViewModelProvider.a f2214a;

    /* renamed from: a  reason: collision with other field name */
    public final SavedStateRegistry f2215a;

    @SuppressLint({"LambdaLast"})
    public m(Application application, Xu xu, Bundle bundle) {
        ViewModelProvider.a aVar;
        C1177ig.f(xu, "owner");
        this.f2215a = xu.getSavedStateRegistry();
        this.f2213a = xu.getLifecycle();
        this.f2212a = bundle;
        this.a = application;
        if (application != null) {
            if (ViewModelProvider.a.a == null) {
                ViewModelProvider.a.a = new ViewModelProvider.a(application);
            }
            aVar = ViewModelProvider.a.a;
            C1177ig.c(aVar);
        } else {
            aVar = new ViewModelProvider.a((Application) null);
        }
        this.f2214a = aVar;
    }

    public final C0404yC a(Class cls, a aVar) {
        Constructor<T> constructor;
        p pVar = p.a;
        LinkedHashMap linkedHashMap = aVar.a;
        String str = (String) linkedHashMap.get(pVar);
        if (str == null) {
            throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
        } else if (linkedHashMap.get(l.f2210a) != null && linkedHashMap.get(l.f2211a) != null) {
            Application application = (Application) linkedHashMap.get(o.a);
            boolean isAssignableFrom = F0.class.isAssignableFrom(cls);
            if (!isAssignableFrom || application == null) {
                constructor = Yu.a(cls, Yu.b);
            } else {
                constructor = Yu.a(cls, Yu.a);
            }
            if (constructor == null) {
                return this.f2214a.a(cls, aVar);
            }
            if (!isAssignableFrom || application == null) {
                return Yu.b(cls, constructor, l.a(aVar));
            }
            return Yu.b(cls, constructor, application, l.a(aVar));
        } else if (this.f2213a != null) {
            return d(cls, str);
        } else {
            throw new IllegalStateException("SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
        }
    }

    public final <T extends C0404yC> T b(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return d(cls, canonicalName);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public final void c(C0404yC yCVar) {
        Lifecycle lifecycle = this.f2213a;
        if (lifecycle != null) {
            SavedStateRegistry savedStateRegistry = this.f2215a;
            C1177ig.c(savedStateRegistry);
            d.a(yCVar, savedStateRegistry, lifecycle);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: androidx.lifecycle.SavedStateHandleController} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: androidx.lifecycle.SavedStateHandleController} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: androidx.lifecycle.SavedStateHandleController} */
    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x008e  */
    public final defpackage.C0404yC d(java.lang.Class r10, java.lang.String r11) {
        /*
            r9 = this;
            androidx.lifecycle.Lifecycle r0 = r9.f2213a
            if (r0 == 0) goto L_0x00b8
            java.lang.Class<F0> r1 = defpackage.F0.class
            boolean r1 = r1.isAssignableFrom(r10)
            if (r1 == 0) goto L_0x0017
            android.app.Application r2 = r9.a
            if (r2 == 0) goto L_0x0017
            java.util.List<java.lang.Class<?>> r2 = defpackage.Yu.a
            java.lang.reflect.Constructor r2 = defpackage.Yu.a(r10, r2)
            goto L_0x001d
        L_0x0017:
            java.util.List<java.lang.Class<?>> r2 = defpackage.Yu.b
            java.lang.reflect.Constructor r2 = defpackage.Yu.a(r10, r2)
        L_0x001d:
            if (r2 != 0) goto L_0x003f
            android.app.Application r11 = r9.a
            if (r11 == 0) goto L_0x002a
            androidx.lifecycle.ViewModelProvider$a r11 = r9.f2214a
            yC r10 = r11.b(r10)
            goto L_0x003e
        L_0x002a:
            androidx.lifecycle.ViewModelProvider$b r11 = androidx.lifecycle.ViewModelProvider.b.a
            if (r11 != 0) goto L_0x0035
            androidx.lifecycle.ViewModelProvider$b r11 = new androidx.lifecycle.ViewModelProvider$b
            r11.<init>()
            androidx.lifecycle.ViewModelProvider.b.a = r11
        L_0x0035:
            androidx.lifecycle.ViewModelProvider$b r11 = androidx.lifecycle.ViewModelProvider.b.a
            defpackage.C1177ig.c(r11)
            yC r10 = r11.b(r10)
        L_0x003e:
            return r10
        L_0x003f:
            androidx.savedstate.SavedStateRegistry r3 = r9.f2215a
            defpackage.C1177ig.c(r3)
            android.os.Bundle r4 = r9.f2212a
            android.os.Bundle r5 = r3.a(r11)
            java.lang.Class<? extends java.lang.Object>[] r6 = androidx.lifecycle.k.a
            androidx.lifecycle.k r4 = androidx.lifecycle.k.a.a(r5, r4)
            androidx.lifecycle.SavedStateHandleController r5 = new androidx.lifecycle.SavedStateHandleController
            r5.<init>(r11, r4)
            r5.c(r0, r3)
            androidx.lifecycle.Lifecycle$State r11 = r0.b()
            androidx.lifecycle.Lifecycle$State r6 = androidx.lifecycle.Lifecycle.State.INITIALIZED
            r7 = 1
            r8 = 0
            if (r11 == r6) goto L_0x0079
            androidx.lifecycle.Lifecycle$State r6 = androidx.lifecycle.Lifecycle.State.STARTED
            int r11 = r11.compareTo(r6)
            if (r11 < 0) goto L_0x006c
            r11 = r7
            goto L_0x006d
        L_0x006c:
            r11 = r8
        L_0x006d:
            if (r11 == 0) goto L_0x0070
            goto L_0x0079
        L_0x0070:
            androidx.lifecycle.LegacySavedStateHandleController$tryToAddRecreator$1 r11 = new androidx.lifecycle.LegacySavedStateHandleController$tryToAddRecreator$1
            r11.<init>(r0, r3)
            r0.a(r11)
            goto L_0x007c
        L_0x0079:
            r3.d()
        L_0x007c:
            if (r1 == 0) goto L_0x008e
            android.app.Application r11 = r9.a
            if (r11 == 0) goto L_0x008e
            r0 = 2
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r8] = r11
            r0[r7] = r4
            yC r10 = defpackage.Yu.b(r10, r2, r0)
            goto L_0x0096
        L_0x008e:
            java.lang.Object[] r11 = new java.lang.Object[r7]
            r11[r8] = r4
            yC r10 = defpackage.Yu.b(r10, r2, r11)
        L_0x0096:
            java.lang.String r11 = "androidx.lifecycle.savedstate.vm.tag"
            java.util.HashMap r0 = r10.a
            monitor-enter(r0)
            java.util.HashMap r1 = r10.a     // Catch:{ all -> 0x00b5 }
            java.lang.Object r1 = r1.get(r11)     // Catch:{ all -> 0x00b5 }
            if (r1 != 0) goto L_0x00a8
            java.util.HashMap r2 = r10.a     // Catch:{ all -> 0x00b5 }
            r2.put(r11, r5)     // Catch:{ all -> 0x00b5 }
        L_0x00a8:
            monitor-exit(r0)     // Catch:{ all -> 0x00b5 }
            if (r1 != 0) goto L_0x00ac
            goto L_0x00ad
        L_0x00ac:
            r5 = r1
        L_0x00ad:
            boolean r11 = r10.f3429a
            if (r11 == 0) goto L_0x00b4
            defpackage.C0404yC.a(r5)
        L_0x00b4:
            return r10
        L_0x00b5:
            r10 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00b5 }
            throw r10
        L_0x00b8:
            java.lang.UnsupportedOperationException r10 = new java.lang.UnsupportedOperationException
            java.lang.String r11 = "SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras)."
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.m.d(java.lang.Class, java.lang.String):yC");
    }
}
