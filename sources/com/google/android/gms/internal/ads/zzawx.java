package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzawx extends zzaxd {
    private final zzavw zzh;
    private long zzi;

    public zzawx(zzavp zzavp, String str, String str2, zzaro zzaro, int i, int i2, zzavw zzavw) {
        super(zzavp, "1LUIVO6lhWmBJfHw9DMAIriIU/Yodc7yYpCjENKu6ENqSuhgH3MJrJCpj/jKq6Pa", "V8P78mWO+MxnWR283vMX+BSDXEvrm8XlQCYXMpvUe5w=", zzaro, i, 53);
        this.zzh = zzavw;
        if (zzavw != null) {
            this.zzi = zzavw.zza();
        }
    }

    public final void zza() throws IllegalAccessException, InvocationTargetException {
        if (this.zzh != null) {
            this.zzd.zzP(((Long) this.zze.invoke((Object) null, new Object[]{Long.valueOf(this.zzi)})).longValue());
        }
    }
}
