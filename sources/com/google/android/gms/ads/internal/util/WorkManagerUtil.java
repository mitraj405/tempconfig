package com.google.android.gms.ads.internal.util;

import android.content.Context;
import androidx.work.Data;
import androidx.work.a;
import com.google.android.gms.ads.internal.offline.buffering.OfflineNotificationPoster;
import com.google.android.gms.ads.internal.offline.buffering.OfflinePingSender;
import com.google.android.gms.ads.internal.offline.buffering.zza;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import defpackage.T6;
import defpackage.fo;
import java.util.Collections;
import java.util.HashMap;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
public class WorkManagerUtil extends zzbq {
    private static void zzb(Context context) {
        try {
            VD.f(context.getApplicationContext(), new a(new a.C0027a()));
        } catch (IllegalStateException unused) {
        }
    }

    public final void zze(IObjectWrapper iObjectWrapper) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzb(context);
        try {
            VD e = VD.e(context);
            e.getClass();
            e.f595a.c(new r4(e));
            T6.a aVar = new T6.a();
            aVar.a = Em.CONNECTED;
            T6 t6 = new T6(aVar);
            fo.a aVar2 = new fo.a(OfflinePingSender.class);
            aVar2.a.f2988a = t6;
            aVar2.f2965a.add("offline_ping_sender_work");
            e.d(Collections.singletonList(aVar2.a()));
        } catch (IllegalStateException e2) {
            zzm.zzk("Failed to instantiate WorkManager.", e2);
        }
    }

    public final boolean zzf(IObjectWrapper iObjectWrapper, String str, String str2) {
        return zzg(iObjectWrapper, new zza(str, str2, ""));
    }

    public final boolean zzg(IObjectWrapper iObjectWrapper, zza zza) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzb(context);
        T6.a aVar = new T6.a();
        aVar.a = Em.CONNECTED;
        T6 t6 = new T6(aVar);
        HashMap hashMap = new HashMap();
        hashMap.put("uri", zza.zza);
        hashMap.put("gws_query_id", zza.zzb);
        hashMap.put("image_url", zza.zzc);
        Data data = new Data(hashMap);
        Data.c(data);
        fo.a aVar2 = new fo.a(OfflineNotificationPoster.class);
        C0214hE hEVar = aVar2.a;
        hEVar.f2988a = t6;
        hEVar.f2990a = data;
        aVar2.f2965a.add("offline_notification_work");
        fo a = aVar2.a();
        try {
            VD e = VD.e(context);
            e.getClass();
            e.d(Collections.singletonList(a));
            return true;
        } catch (IllegalStateException e2) {
            zzm.zzk("Failed to instantiate WorkManager.", e2);
            return false;
        }
    }
}
