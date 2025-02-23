package com.google.firebase.ktx;

import androidx.annotation.Keep;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.annotations.concurrent.Lightweight;
import com.google.firebase.annotations.concurrent.UiThread;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Qualified;
import java.util.List;
import java.util.concurrent.Executor;
import kotlinx.coroutines.CoroutineDispatcher;

@Keep
/* compiled from: Firebase.kt */
public final class FirebaseCommonKtxRegistrar implements ComponentRegistrar {
    public List<Component<?>> getComponents() {
        Class<Background> cls = Background.class;
        Class<CoroutineDispatcher> cls2 = CoroutineDispatcher.class;
        Class<Executor> cls3 = Executor.class;
        Component<CoroutineDispatcher> build = Component.builder(Qualified.qualified(cls, cls2)).add(Dependency.required((Qualified<?>) Qualified.qualified(cls, cls3))).factory(FirebaseCommonKtxRegistrar$getComponents$$inlined$coroutineDispatcher$1.INSTANCE).build();
        C1177ig.e(build, "builder(Qualified.qualif…cher()\n    }\n    .build()");
        Class<Lightweight> cls4 = Lightweight.class;
        Component<Lightweight> build2 = Component.builder(Qualified.qualified(cls4, cls2)).add(Dependency.required((Qualified<?>) Qualified.qualified(cls4, cls3))).factory(FirebaseCommonKtxRegistrar$getComponents$$inlined$coroutineDispatcher$2.INSTANCE).build();
        C1177ig.e(build2, "builder(Qualified.qualif…cher()\n    }\n    .build()");
        Class<Blocking> cls5 = Blocking.class;
        Component<Blocking> build3 = Component.builder(Qualified.qualified(cls5, cls2)).add(Dependency.required((Qualified<?>) Qualified.qualified(cls5, cls3))).factory(FirebaseCommonKtxRegistrar$getComponents$$inlined$coroutineDispatcher$3.INSTANCE).build();
        C1177ig.e(build3, "builder(Qualified.qualif…cher()\n    }\n    .build()");
        Class<UiThread> cls6 = UiThread.class;
        Component<UiThread> build4 = Component.builder(Qualified.qualified(cls6, cls2)).add(Dependency.required((Qualified<?>) Qualified.qualified(cls6, cls3))).factory(FirebaseCommonKtxRegistrar$getComponents$$inlined$coroutineDispatcher$4.INSTANCE).build();
        C1177ig.e(build4, "builder(Qualified.qualif…cher()\n    }\n    .build()");
        return r1.F(build, build2, build3, build4);
    }
}
