package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzu;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzcck implements zzbix {
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        float f;
        zzcbk zzcbk = (zzcbk) obj;
        zzcfl zzq = zzcbk.zzq();
        if (zzq == null) {
            try {
                zzcfl zzcfl = new zzcfl(zzcbk, Float.parseFloat((String) map.get("duration")), C0515Ga.AVLBLTY_ONLY.equals(map.get("customControlsAllowed")), C0515Ga.AVLBLTY_ONLY.equals(map.get("clickToExpandAllowed")));
                zzcbk.zzC(zzcfl);
                zzq = zzcfl;
            } catch (NullPointerException e) {
                e = e;
                zzm.zzh("Unable to parse videoMeta message.", e);
                zzu.zzo().zzw(e, "VideoMetaGmsgHandler.onGmsg");
                return;
            } catch (NumberFormatException e2) {
                e = e2;
                zzm.zzh("Unable to parse videoMeta message.", e);
                zzu.zzo().zzw(e, "VideoMetaGmsgHandler.onGmsg");
                return;
            }
        }
        float parseFloat = Float.parseFloat((String) map.get("duration"));
        boolean equals = C0515Ga.AVLBLTY_ONLY.equals(map.get("muted"));
        float parseFloat2 = Float.parseFloat((String) map.get("currentTime"));
        int parseInt = Integer.parseInt((String) map.get("playbackState"));
        if (parseInt < 0 || parseInt > 3) {
            parseInt = 0;
        }
        String str = (String) map.get("aspectRatio");
        if (TextUtils.isEmpty(str)) {
            f = 0.0f;
        } else {
            f = Float.parseFloat(str);
        }
        if (zzm.zzm(3)) {
            zzm.zze("Video Meta GMSG: currentTime : " + parseFloat2 + " , duration : " + parseFloat + " , isMuted : " + equals + " , playbackState : " + parseInt + " , aspectRatio : " + str);
        }
        zzq.zzc(parseFloat2, parseFloat, parseInt, equals, f);
    }
}
