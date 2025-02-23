package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzu;
import java.io.IOException;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzbij implements zzbix {
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcej zzcej = (zzcej) obj;
        try {
            zzfsb.zzj(zzcej.getContext()).zzk();
            zzfsc.zzi(zzcej.getContext()).zzj();
        } catch (IOException e) {
            zzu.zzo().zzw(e, "DefaultGmsgHandlers.ResetPaid");
        }
    }
}
