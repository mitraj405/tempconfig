package com.google.android.gms.common.api.internal;

import com.google.android.gms.signin.internal.zac;
import com.google.android.gms.signin.internal.zak;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
final class zaar extends zac {
    private final WeakReference<zaaw> zaa;

    public zaar(zaaw zaaw) {
        this.zaa = new WeakReference<>(zaaw);
    }

    public final void zab(zak zak) {
        zaaw zaaw = this.zaa.get();
        if (zaaw != null) {
            zaaw.zaa.zal(new zaaq(this, zaaw, zaaw, zak));
        }
    }
}
