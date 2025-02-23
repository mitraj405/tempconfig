package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.io.IOException;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public abstract class zztq extends zzth {
    private final HashMap zza = new HashMap();
    private Handler zzb;
    private zzgu zzc;

    public abstract void zzA(Object obj, zzuk zzuk, zzcc zzcc);

    public final void zzB(Object obj, zzuk zzuk) {
        zzdi.zzd(!this.zza.containsKey(obj));
        zztn zztn = new zztn(this, obj);
        zzto zzto = new zzto(this, obj);
        this.zza.put(obj, new zztp(zzuk, zztn, zzto));
        Handler handler = this.zzb;
        handler.getClass();
        zzuk.zzh(handler, zzto);
        Handler handler2 = this.zzb;
        handler2.getClass();
        zzuk.zzg(handler2, zzto);
        zzuk.zzm(zztn, this.zzc, zzb());
        if (!zzu()) {
            zzuk.zzi(zztn);
        }
    }

    public final void zzj() {
        for (zztp zztp : this.zza.values()) {
            zztp.zza.zzi(zztp.zzb);
        }
    }

    public final void zzl() {
        for (zztp zztp : this.zza.values()) {
            zztp.zza.zzk(zztp.zzb);
        }
    }

    public void zzn(zzgu zzgu) {
        this.zzc = zzgu;
        this.zzb = zzet.zzx((Handler.Callback) null);
    }

    public void zzq() {
        for (zztp zztp : this.zza.values()) {
            zztp.zza.zzp(zztp.zzb);
            zztp.zza.zzs(zztp.zzc);
            zztp.zza.zzr(zztp.zzc);
        }
        this.zza.clear();
    }

    public int zzw(Object obj, int i) {
        return 0;
    }

    public zzui zzy(Object obj, zzui zzui) {
        throw null;
    }

    public void zzz() throws IOException {
        for (zztp zztp : this.zza.values()) {
            zztp.zza.zzz();
        }
    }

    public long zzx(Object obj, long j, zzui zzui) {
        return j;
    }
}
