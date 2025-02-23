package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.SparseArray;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.ads.zzbbc;
import in.juspay.hyper.constants.LogSubCategory;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzecl extends zzecm {
    private static final SparseArray zzb;
    private final Context zzc;
    private final zzcvu zzd;
    private final TelephonyManager zze;
    /* access modifiers changed from: private */
    public final zzecd zzf;
    private zzbbc.zzq zzg;

    static {
        SparseArray sparseArray = new SparseArray();
        zzb = sparseArray;
        sparseArray.put(NetworkInfo.DetailedState.CONNECTED.ordinal(), zzbbc.zzaf.zzd.CONNECTED);
        int ordinal = NetworkInfo.DetailedState.AUTHENTICATING.ordinal();
        zzbbc.zzaf.zzd zzd2 = zzbbc.zzaf.zzd.CONNECTING;
        sparseArray.put(ordinal, zzd2);
        sparseArray.put(NetworkInfo.DetailedState.CONNECTING.ordinal(), zzd2);
        sparseArray.put(NetworkInfo.DetailedState.OBTAINING_IPADDR.ordinal(), zzd2);
        sparseArray.put(NetworkInfo.DetailedState.DISCONNECTING.ordinal(), zzbbc.zzaf.zzd.DISCONNECTING);
        int ordinal2 = NetworkInfo.DetailedState.BLOCKED.ordinal();
        zzbbc.zzaf.zzd zzd3 = zzbbc.zzaf.zzd.DISCONNECTED;
        sparseArray.put(ordinal2, zzd3);
        sparseArray.put(NetworkInfo.DetailedState.DISCONNECTED.ordinal(), zzd3);
        sparseArray.put(NetworkInfo.DetailedState.FAILED.ordinal(), zzd3);
        sparseArray.put(NetworkInfo.DetailedState.IDLE.ordinal(), zzd3);
        sparseArray.put(NetworkInfo.DetailedState.SCANNING.ordinal(), zzd3);
        sparseArray.put(NetworkInfo.DetailedState.SUSPENDED.ordinal(), zzbbc.zzaf.zzd.SUSPENDED);
        sparseArray.put(NetworkInfo.DetailedState.CAPTIVE_PORTAL_CHECK.ordinal(), zzd2);
        sparseArray.put(NetworkInfo.DetailedState.VERIFYING_POOR_LINK.ordinal(), zzd2);
    }

    public zzecl(Context context, zzcvu zzcvu, zzecd zzecd, zzebz zzebz, zzg zzg2) {
        super(zzebz, zzg2);
        this.zzc = context;
        this.zzd = zzcvu;
        this.zzf = zzecd;
        this.zze = (TelephonyManager) context.getSystemService("phone");
    }

    public static /* bridge */ /* synthetic */ zzbbc.zzab zza(zzecl zzecl, Bundle bundle) {
        zzbbc.zzab.zzb zzb2;
        zzbbc.zzab.zza zza = zzbbc.zzab.zza();
        int i = bundle.getInt("cnt", -2);
        int i2 = bundle.getInt("gnt", 0);
        if (i == -1) {
            zzecl.zzg = zzbbc.zzq.ENUM_TRUE;
        } else {
            zzecl.zzg = zzbbc.zzq.ENUM_FALSE;
            if (i == 0) {
                zza.zzd(zzbbc.zzab.zzc.CELL);
            } else if (i != 1) {
                zza.zzd(zzbbc.zzab.zzc.NETWORKTYPE_UNSPECIFIED);
            } else {
                zza.zzd(zzbbc.zzab.zzc.WIFI);
            }
            switch (i2) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                case 16:
                    zzb2 = zzbbc.zzab.zzb.TWO_G;
                    break;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                    zzb2 = zzbbc.zzab.zzb.THREE_G;
                    break;
                case 13:
                    zzb2 = zzbbc.zzab.zzb.LTE;
                    break;
                default:
                    zzb2 = zzbbc.zzab.zzb.CELLULAR_NETWORK_TYPE_UNSPECIFIED;
                    break;
            }
            zza.zzc(zzb2);
        }
        return (zzbbc.zzab) zza.zzbr();
    }

    public static /* bridge */ /* synthetic */ zzbbc.zzaf.zzd zzb(zzecl zzecl, Bundle bundle) {
        return (zzbbc.zzaf.zzd) zzb.get(zzffu.zza(zzffu.zza(bundle, LogSubCategory.Context.DEVICE), LogSubCategory.ApiCall.NETWORK).getInt("active_network_state", -1), zzbbc.zzaf.zzd.UNSPECIFIED);
    }

    public static /* bridge */ /* synthetic */ byte[] zze(zzecl zzecl, boolean z, ArrayList arrayList, zzbbc.zzab zzab, zzbbc.zzaf.zzd zzd2) {
        boolean z2;
        zzbbc.zzaf.zza.C0036zza zzn = zzbbc.zzaf.zza.zzn();
        zzn.zzn(arrayList);
        boolean z3 = false;
        if (Settings.Global.getInt(zzecl.zzc.getContentResolver(), "airplane_mode_on", 0) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        zzn.zzD(zzg(z2));
        zzn.zzE(zzu.zzq().zzg(zzecl.zzc, zzecl.zze));
        zzn.zzM(zzecl.zzf.zze());
        zzn.zzL(zzecl.zzf.zzb());
        zzn.zzG(zzecl.zzf.zza());
        zzn.zzH(zzd2);
        zzn.zzJ(zzab);
        zzn.zzK(zzecl.zzg);
        zzn.zzN(zzg(z));
        zzn.zzP(zzecl.zzf.zzd());
        zzn.zzO(zzu.zzB().currentTimeMillis());
        if (Settings.Global.getInt(zzecl.zzc.getContentResolver(), "wifi_on", 0) != 0) {
            z3 = true;
        }
        zzn.zzQ(zzg(z3));
        return ((zzbbc.zzaf.zza) zzn.zzbr()).zzaV();
    }

    private static final zzbbc.zzq zzg(boolean z) {
        if (z) {
            return zzbbc.zzq.ENUM_TRUE;
        }
        return zzbbc.zzq.ENUM_FALSE;
    }

    public final void zzd(boolean z) {
        zzgcj.zzr(this.zzd.zzb(new Bundle()), new zzeck(this, z), zzbzo.zzf);
    }
}
