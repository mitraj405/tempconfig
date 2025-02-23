package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzss implements zztb {
    public final int zza(Object obj) {
        int i = zztc.zza;
        String str = ((zzsf) obj).zza;
        if (str.startsWith("OMX.google") || str.startsWith("c2.android")) {
            return 1;
        }
        if (zzet.zza >= 26) {
            return 0;
        }
        if (str.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
            return -1;
        }
        return 0;
    }
}
