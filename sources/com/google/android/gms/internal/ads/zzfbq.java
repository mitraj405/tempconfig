package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzm;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzfbq {
    public static void zza(AtomicReference atomicReference, zzfbp zzfbp) {
        Object obj = atomicReference.get();
        if (obj != null) {
            try {
                zzfbp.zza(obj);
            } catch (RemoteException e) {
                zzm.zzl("#007 Could not call remote method.", e);
            } catch (NullPointerException e2) {
                zzm.zzk("NullPointerException occurs when invoking a method from a delegating listener.", e2);
            }
        }
    }
}
