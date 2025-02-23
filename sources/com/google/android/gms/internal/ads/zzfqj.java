package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzfqj {
    final zzfqm zza;
    final boolean zzb;

    private zzfqj(zzfqm zzfqm) {
        boolean z;
        this.zza = zzfqm;
        if (zzfqm != null) {
            z = true;
        } else {
            z = false;
        }
        this.zzb = z;
    }

    public static zzfqj zzb(Context context, String str, String str2) {
        zzfqm zzfqm;
        try {
            IBinder instantiate = DynamiteModule.load(context, DynamiteModule.PREFER_REMOTE, ModuleDescriptor.MODULE_ID).instantiate("com.google.android.gms.gass.internal.clearcut.GassDynamiteClearcutLogger");
            if (instantiate == null) {
                zzfqm = null;
            } else {
                IInterface queryLocalInterface = instantiate.queryLocalInterface("com.google.android.gms.gass.internal.clearcut.IGassClearcut");
                if (queryLocalInterface instanceof zzfqm) {
                    zzfqm = (zzfqm) queryLocalInterface;
                } else {
                    zzfqm = new zzfqk(instantiate);
                }
            }
            try {
                zzfqm.zze(ObjectWrapper.wrap(context), str, (String) null);
                return new zzfqj(zzfqm);
            } catch (RemoteException | zzfpl | NullPointerException | SecurityException unused) {
                return new zzfqj(new zzfqn());
            }
        } catch (Exception e) {
            throw new zzfpl(e);
        } catch (Exception e2) {
            throw new zzfpl(e2);
        }
    }

    public static zzfqj zzc() {
        return new zzfqj(new zzfqn());
    }

    public final zzfqi zza(byte[] bArr) {
        return new zzfqi(this, bArr, (zzfqh) null);
    }
}
