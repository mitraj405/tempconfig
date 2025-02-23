package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import com.google.android.gms.ads.MobileAds;
import com.google.common.util.concurrent.ListenableFuture;
import defpackage.C0272me;
import defpackage.C0284oA;
import in.juspay.hyper.constants.LogCategory;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzeer {
    private final Context zza;

    public zzeer(Context context) {
        this.zza = context;
    }

    public final ListenableFuture zza(boolean z) {
        int i;
        pA pAVar;
        try {
            new C0272me.a();
            C0272me meVar = new C0272me(MobileAds.ERROR_DOMAIN, z);
            Context context = this.zza;
            C1177ig.f(context, LogCategory.CONTEXT);
            int i2 = Build.VERSION.SDK_INT;
            W w = W.a;
            int i3 = 0;
            if (i2 >= 30) {
                i = w.a();
            } else {
                i = 0;
            }
            C0284oA.a aVar = null;
            if (i >= 5) {
                pAVar = new C0276nA(context);
            } else {
                if (i2 >= 30) {
                    i3 = w.a();
                }
                if (i3 == 4) {
                    pAVar = new C0268mA(context);
                } else {
                    pAVar = null;
                }
            }
            if (pAVar != null) {
                aVar = new C0284oA.a(pAVar);
            }
            if (aVar != null) {
                return aVar.a(meVar);
            }
            return zzgcj.zzg(new IllegalStateException());
        } catch (Exception e) {
            return zzgcj.zzg(e);
        }
    }
}
