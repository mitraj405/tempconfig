package androidx.lifecycle;

import android.app.Application;
import androidx.lifecycle.viewmodel.CreationExtras;
import java.lang.reflect.InvocationTargetException;

/* compiled from: ViewModelProvider.kt */
public final class ViewModelProvider {
    public final Factory a;

    /* renamed from: a  reason: collision with other field name */
    public final ViewModelStore f2197a;

    /* renamed from: a  reason: collision with other field name */
    public final CreationExtras f2198a;

    /* compiled from: ViewModelProvider.kt */
    public interface Factory {
        C0404yC a(Class cls, androidx.lifecycle.viewmodel.a aVar) {
            return b(cls);
        }

        <T extends C0404yC> T b(Class<T> cls) {
            throw new UnsupportedOperationException("Factory.create(String) is unsupported.  This Factory requires `CreationExtras` to be passed into `create` method.");
        }
    }

    /* compiled from: ViewModelProvider.kt */
    public static class a extends b {
        public static a a;

        /* renamed from: a  reason: collision with other field name */
        public final Application f2199a;

        public a(Application application) {
            this.f2199a = application;
        }

        public final C0404yC a(Class cls, androidx.lifecycle.viewmodel.a aVar) {
            if (this.f2199a != null) {
                return b(cls);
            }
            Application application = (Application) aVar.a.get(o.a);
            if (application != null) {
                return c(cls, application);
            }
            if (!F0.class.isAssignableFrom(cls)) {
                return super.b(cls);
            }
            throw new IllegalArgumentException("CreationExtras must have an application by `APPLICATION_KEY`");
        }

        public final <T extends C0404yC> T b(Class<T> cls) {
            Application application = this.f2199a;
            if (application != null) {
                return c(cls, application);
            }
            throw new UnsupportedOperationException("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
        }

        public final <T extends C0404yC> T c(Class<T> cls, Application application) {
            if (!F0.class.isAssignableFrom(cls)) {
                return super.b(cls);
            }
            try {
                T t = (C0404yC) cls.getConstructor(new Class[]{Application.class}).newInstance(new Object[]{application});
                C1177ig.e(t, "{\n                try {\n…          }\n            }");
                return t;
            } catch (NoSuchMethodException e) {
                throw new RuntimeException("Cannot create an instance of " + cls, e);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("Cannot create an instance of " + cls, e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException("Cannot create an instance of " + cls, e3);
            } catch (InvocationTargetException e4) {
                throw new RuntimeException("Cannot create an instance of " + cls, e4);
            }
        }
    }

    /* compiled from: ViewModelProvider.kt */
    public static class b implements Factory {
        public static b a;

        public <T extends C0404yC> T b(Class<T> cls) {
            try {
                T newInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                C1177ig.e(newInstance, "{\n                modelC…wInstance()\n            }");
                return (C0404yC) newInstance;
            } catch (NoSuchMethodException e) {
                throw new RuntimeException("Cannot create an instance of " + cls, e);
            } catch (InstantiationException e2) {
                throw new RuntimeException("Cannot create an instance of " + cls, e2);
            } catch (IllegalAccessException e3) {
                throw new RuntimeException("Cannot create an instance of " + cls, e3);
            }
        }
    }

    public ViewModelProvider(ViewModelStore viewModelStore, Factory factory, CreationExtras creationExtras) {
        C1177ig.f(viewModelStore, "store");
        C1177ig.f(factory, "factory");
        C1177ig.f(creationExtras, "defaultCreationExtras");
        this.f2197a = viewModelStore;
        this.a = factory;
        this.f2198a = creationExtras;
    }

    public final <T extends C0404yC> T a(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return b(cls, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(canonicalName));
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public final C0404yC b(Class cls, String str) {
        C0404yC yCVar;
        c cVar;
        C1177ig.f(str, "key");
        ViewModelStore viewModelStore = this.f2197a;
        viewModelStore.getClass();
        C0404yC yCVar2 = (C0404yC) viewModelStore.a.get(str);
        boolean isInstance = cls.isInstance(yCVar2);
        Factory factory = this.a;
        if (isInstance) {
            if (factory instanceof c) {
                cVar = (c) factory;
            } else {
                cVar = null;
            }
            if (cVar != null) {
                C1177ig.c(yCVar2);
                cVar.c(yCVar2);
            }
            C1177ig.d(yCVar2, "null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get");
            return yCVar2;
        }
        androidx.lifecycle.viewmodel.a aVar = new androidx.lifecycle.viewmodel.a(this.f2198a);
        aVar.a.put(p.a, str);
        try {
            yCVar = factory.a(cls, aVar);
        } catch (AbstractMethodError unused) {
            yCVar = factory.b(cls);
        }
        C1177ig.f(yCVar, "viewModel");
        C0404yC yCVar3 = (C0404yC) viewModelStore.a.put(str, yCVar);
        if (yCVar3 != null) {
            yCVar3.b();
        }
        return yCVar;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ViewModelProvider(ViewModelStore viewModelStore, Factory factory) {
        this(viewModelStore, factory, CreationExtras.a.a);
        C1177ig.f(viewModelStore, "store");
        C1177ig.f(factory, "factory");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ViewModelProvider(defpackage.AC r4) {
        /*
            r3 = this;
            java.lang.String r0 = "owner"
            defpackage.C1177ig.f(r4, r0)
            androidx.lifecycle.ViewModelStore r0 = r4.getViewModelStore()
            boolean r1 = r4 instanceof androidx.lifecycle.c
            if (r1 == 0) goto L_0x0015
            r2 = r4
            androidx.lifecycle.c r2 = (androidx.lifecycle.c) r2
            androidx.lifecycle.ViewModelProvider$Factory r2 = r2.getDefaultViewModelProviderFactory()
            goto L_0x0025
        L_0x0015:
            androidx.lifecycle.ViewModelProvider$b r2 = androidx.lifecycle.ViewModelProvider.b.a
            if (r2 != 0) goto L_0x0020
            androidx.lifecycle.ViewModelProvider$b r2 = new androidx.lifecycle.ViewModelProvider$b
            r2.<init>()
            androidx.lifecycle.ViewModelProvider.b.a = r2
        L_0x0020:
            androidx.lifecycle.ViewModelProvider$b r2 = androidx.lifecycle.ViewModelProvider.b.a
            defpackage.C1177ig.c(r2)
        L_0x0025:
            if (r1 == 0) goto L_0x002e
            androidx.lifecycle.c r4 = (androidx.lifecycle.c) r4
            androidx.lifecycle.viewmodel.CreationExtras r4 = r4.getDefaultViewModelCreationExtras()
            goto L_0x0030
        L_0x002e:
            androidx.lifecycle.viewmodel.CreationExtras$a r4 = androidx.lifecycle.viewmodel.CreationExtras.a.a
        L_0x0030:
            r3.<init>(r0, r2, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.ViewModelProvider.<init>(AC):void");
    }

    /* compiled from: ViewModelProvider.kt */
    public static class c {
        public void c(C0404yC yCVar) {
        }
    }
}
