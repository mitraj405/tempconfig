package defpackage;

import com.google.firebase.remoteconfig.internal.ConfigStorageClient;
import java.util.concurrent.Callable;

/* renamed from: A6  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class A6 implements Callable {
    public final /* synthetic */ ConfigStorageClient a;

    public /* synthetic */ A6(ConfigStorageClient configStorageClient) {
        this.a = configStorageClient;
    }

    public final Object call() {
        return this.a.read();
    }
}
