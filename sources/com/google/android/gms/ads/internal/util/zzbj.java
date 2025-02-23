package com.google.android.gms.ads.internal.util;

import com.google.android.gms.ads.internal.util.client.zzl;
import com.google.android.gms.internal.ads.zzaop;
import com.google.android.gms.internal.ads.zzapl;
import com.google.android.gms.internal.ads.zzapm;
import com.google.android.gms.internal.ads.zzaqm;
import java.util.Collections;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzbj extends zzaqm {
    final /* synthetic */ byte[] zza;
    final /* synthetic */ Map zzb;
    final /* synthetic */ zzl zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzbj(zzbo zzbo, int i, String str, zzapm zzapm, zzapl zzapl, byte[] bArr, Map map, zzl zzl) {
        super(i, str, zzapm, zzapl);
        this.zza = bArr;
        this.zzb = map;
        this.zzc = zzl;
    }

    public final Map zzl() throws zzaop {
        Map map = this.zzb;
        if (map == null) {
            return Collections.emptyMap();
        }
        return map;
    }

    public final byte[] zzx() throws zzaop {
        byte[] bArr = this.zza;
        if (bArr == null) {
            return null;
        }
        return bArr;
    }

    /* renamed from: zzz */
    public final void zzo(String str) {
        this.zzc.zzg(str);
        super.zzo(str);
    }
}
