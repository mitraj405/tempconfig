package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzawo extends zzaxd {
    private final zzaus zzh;
    private final long zzi;
    private final long zzj;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzawo(zzavp zzavp, String str, String str2, zzaro zzaro, int i, int i2, zzaus zzaus, long j, long j2) {
        super(zzavp, "gAg/p/cQzJRjYz9LhE8cRk72DVV1Cpozf/TbzvACqLcTgM3sRjMEb3DCmwYhMmhP", "avDZD6/xoSbFYvWCy23XLncB75oD5DxKdrTKFY2O0hY=", zzaro, i, 11);
        this.zzh = zzaus;
        this.zzi = j;
        this.zzj = j2;
    }

    public final void zza() throws IllegalAccessException, InvocationTargetException {
        zzaus zzaus = this.zzh;
        if (zzaus != null) {
            zzauq zzauq = new zzauq((String) this.zze.invoke((Object) null, new Object[]{zzaus.zzb(), Long.valueOf(this.zzi), Long.valueOf(this.zzj)}));
            synchronized (this.zzd) {
                this.zzd.zzz(zzauq.zza.longValue());
                if (zzauq.zzb.longValue() >= 0) {
                    this.zzd.zzQ(zzauq.zzb.longValue());
                }
                if (zzauq.zzc.longValue() >= 0) {
                    this.zzd.zzf(zzauq.zzc.longValue());
                }
            }
        }
    }
}
