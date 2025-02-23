package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbdn;
import com.google.android.gms.internal.ads.zzbeb;
import in.juspay.hyper.constants.LogCategory;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
abstract class zzax {
    private static final zzce zza;

    static {
        zzce zzcc;
        zzce zzce = null;
        try {
            Object newInstance = zzaw.class.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            if (!(newInstance instanceof IBinder)) {
                zzm.zzj("ClientApi class is not an instance of IBinder.");
            } else {
                IBinder iBinder = (IBinder) newInstance;
                if (iBinder != null) {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    if (queryLocalInterface instanceof zzce) {
                        zzcc = (zzce) queryLocalInterface;
                    } else {
                        zzcc = new zzcc(iBinder);
                    }
                    zzce = zzcc;
                }
            }
        } catch (Exception unused) {
            zzm.zzj("Failed to instantiate ClientApi class.");
        }
        zza = zzce;
    }

    private final Object zze() {
        zzce zzce = zza;
        if (zzce != null) {
            try {
                return zzb(zzce);
            } catch (RemoteException e) {
                zzm.zzk("Cannot invoke local loader using ClientApi class.", e);
                return null;
            }
        } else {
            zzm.zzj("ClientApi class cannot be loaded.");
            return null;
        }
    }

    private final Object zzf() {
        try {
            return zzc();
        } catch (RemoteException e) {
            zzm.zzk("Cannot invoke remote loader.", e);
            return null;
        }
    }

    public abstract Object zza();

    public abstract Object zzb(zzce zzce) throws RemoteException;

    public abstract Object zzc() throws RemoteException;

    public final Object zzd(Context context, boolean z) {
        boolean z2;
        boolean z3;
        Object obj;
        if (!z) {
            zzay.zzb();
            if (!zzf.zzt(context, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE)) {
                zzm.zze("Google Play Services is not available.");
                z = true;
            }
        }
        boolean z4 = false;
        if (DynamiteModule.getLocalVersion(context, ModuleDescriptor.MODULE_ID) > DynamiteModule.getRemoteVersion(context, ModuleDescriptor.MODULE_ID)) {
            z2 = false;
        } else {
            z2 = true;
        }
        boolean z5 = !z2;
        zzbbw.zza(context);
        if (((Boolean) zzbdn.zza.zze()).booleanValue()) {
            z3 = false;
        } else if (((Boolean) zzbdn.zzb.zze()).booleanValue()) {
            z3 = true;
            z4 = true;
        } else {
            z4 = z | z5;
            z3 = false;
        }
        if (z4) {
            obj = zze();
            if (obj == null && !z3) {
                obj = zzf();
            }
        } else {
            Object zzf = zzf();
            if (zzf == null) {
                if (zzay.zze().nextInt(((Long) zzbeb.zza.zze()).intValue()) == 0) {
                    Bundle bundle = new Bundle();
                    bundle.putString(LogCategory.ACTION, "dynamite_load");
                    bundle.putInt("is_missing", 1);
                    zzay.zzb().zzo(context, zzay.zzc().afmaVersion, "gmob-apps", bundle, true);
                }
            }
            obj = zzf == null ? zze() : zzf;
        }
        if (obj == null) {
            return zza();
        }
        return obj;
    }
}
