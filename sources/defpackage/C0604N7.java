package defpackage;

import com.momagic.C0835h;
import java.util.HashMap;

/* renamed from: N7  reason: default package and case insensitive filesystem */
/* compiled from: DATB */
public final class C0604N7 implements Runnable {
    public final /* synthetic */ HashMap a;
    public final /* synthetic */ String c;

    public C0604N7(HashMap hashMap, String str) {
        this.c = str;
        this.a = hashMap;
    }

    public final void run() {
        C0835h.a(this.a, this.c);
    }
}
