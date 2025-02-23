package defpackage;

import java.util.concurrent.ThreadFactory;
import okhttp3.internal.Util;

/* renamed from: PB  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class PB implements ThreadFactory {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ String c;

    public /* synthetic */ PB(String str, boolean z) {
        this.c = str;
        this.a = z;
    }

    public final Thread newThread(Runnable runnable) {
        return Util.lambda$threadFactory$0(this.c, this.a, runnable);
    }
}
