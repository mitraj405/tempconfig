package defpackage;

import android.os.Bundle;

/* renamed from: W0  reason: default package */
/* compiled from: Api33Impl */
public final class W0 {
    public static <T> T a(Bundle bundle, String str, Class<T> cls) {
        return bundle.getParcelable(str, cls);
    }
}
