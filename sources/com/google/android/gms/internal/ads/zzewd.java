package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzewd implements zzevo {
    private final zzgcu zza;
    private final Context zzb;

    public zzewd(zzgcu zzgcu, Context context) {
        this.zza = zzgcu;
        this.zzb = context;
    }

    public final int zza() {
        return 39;
    }

    public final ListenableFuture zzb() {
        return this.zza.zzb(new zzewc(this));
    }

    public final /* synthetic */ zzewb zzc() throws Exception {
        int i;
        boolean z;
        TelephonyManager telephonyManager = (TelephonyManager) this.zzb.getSystemService("phone");
        String networkOperator = telephonyManager.getNetworkOperator();
        int phoneType = telephonyManager.getPhoneType();
        zzu.zzp();
        int i2 = -1;
        if (zzt.zzA(this.zzb, "android.permission.ACCESS_NETWORK_STATE")) {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.zzb.getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                int type = activeNetworkInfo.getType();
                int ordinal = activeNetworkInfo.getDetailedState().ordinal();
                i = type;
                i2 = ordinal;
            } else {
                i = -1;
            }
            z = connectivityManager.isActiveNetworkMetered();
        } else {
            z = false;
            i = -2;
        }
        return new zzewb(networkOperator, i, zzu.zzq().zzm(this.zzb), phoneType, z, i2);
    }
}
