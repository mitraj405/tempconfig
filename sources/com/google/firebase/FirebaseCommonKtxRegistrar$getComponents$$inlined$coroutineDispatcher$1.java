package com.google.firebase;

import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.Qualified;
import java.util.concurrent.Executor;
import kotlinx.coroutines.CoroutineDispatcher;

/* compiled from: Firebase.kt */
public final class FirebaseCommonKtxRegistrar$getComponents$$inlined$coroutineDispatcher$1<T> implements ComponentFactory {
    public static final FirebaseCommonKtxRegistrar$getComponents$$inlined$coroutineDispatcher$1<T> INSTANCE = new FirebaseCommonKtxRegistrar$getComponents$$inlined$coroutineDispatcher$1<>();

    public final CoroutineDispatcher create(ComponentContainer componentContainer) {
        Object obj = componentContainer.get(Qualified.qualified(Background.class, Executor.class));
        C1177ig.e(obj, "c.get(Qualified.qualifie…a, Executor::class.java))");
        return C1354qp.K((Executor) obj);
    }
}
