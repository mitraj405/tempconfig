package com.google.android.gms.internal.ads;

import android.content.Context;
import android.util.Base64;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.nio.ByteBuffer;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzfpa {
    private final Context zza;
    private final Executor zzb;
    private final zzfoh zzc;
    private final zzfoj zzd;
    private final zzfoz zze;
    private final zzfoz zzf;
    private Task zzg;
    private Task zzh;

    public zzfpa(Context context, Executor executor, zzfoh zzfoh, zzfoj zzfoj, zzfox zzfox, zzfoy zzfoy) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzfoh;
        this.zzd = zzfoj;
        this.zze = zzfox;
        this.zzf = zzfoy;
    }

    public static zzfpa zze(Context context, Executor executor, zzfoh zzfoh, zzfoj zzfoj) {
        zzfpa zzfpa = new zzfpa(context, executor, zzfoh, zzfoj, new zzfox(), new zzfoy());
        if (zzfpa.zzd.zzd()) {
            zzfpa.zzg = zzfpa.zzh(new zzfou(zzfpa));
        } else {
            zzfpa.zzg = Tasks.forResult(zzfpa.zze.zza());
        }
        zzfpa.zzh = zzfpa.zzh(new zzfov(zzfpa));
        return zzfpa;
    }

    private static zzasj zzg(Task task, zzasj zzasj) {
        if (!task.isSuccessful()) {
            return zzasj;
        }
        return (zzasj) task.getResult();
    }

    private final Task zzh(Callable callable) {
        return Tasks.call(this.zzb, callable).addOnFailureListener(this.zzb, (OnFailureListener) new zzfow(this));
    }

    public final zzasj zza() {
        return zzg(this.zzg, this.zze.zza());
    }

    public final zzasj zzb() {
        return zzg(this.zzh, this.zzf.zza());
    }

    public final /* synthetic */ zzasj zzc() throws Exception {
        zzaro zza2 = zzasj.zza();
        AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.zza);
        String id = advertisingIdInfo.getId();
        if (id != null && id.matches("^[a-fA-F0-9]{8}-([a-fA-F0-9]{4}-){3}[a-fA-F0-9]{12}$")) {
            UUID fromString = UUID.fromString(id);
            byte[] bArr = new byte[16];
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.putLong(fromString.getMostSignificantBits());
            wrap.putLong(fromString.getLeastSignificantBits());
            id = Base64.encodeToString(bArr, 11);
        }
        if (id != null) {
            zza2.zzs(id);
            zza2.zzr(advertisingIdInfo.isLimitAdTrackingEnabled());
            zza2.zzab(6);
        }
        return (zzasj) zza2.zzbr();
    }

    public final /* synthetic */ zzasj zzd() throws Exception {
        Context context = this.zza;
        return zzfop.zza(context, context.getPackageName(), Integer.toString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode));
    }

    public final /* synthetic */ void zzf(Exception exc) {
        if (exc instanceof InterruptedException) {
            Thread.currentThread().interrupt();
        }
        this.zzc.zzc(2025, -1, exc);
    }
}
