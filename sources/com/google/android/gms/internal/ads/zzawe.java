package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzawe extends zzaxd {
    public zzawe(zzavp zzavp, String str, String str2, zzaro zzaro, int i, int i2) {
        super(zzavp, "2/TrxXzdli4Us4FPDPyGZmc5MrxtH8QgmFF/OAjS44SLVVLbzYRftaNDX3sVzVmu", "9ObkV+9nuY0gPBNLH25GoxM7YATuF1pi7IORvVFb3+Q=", zzaro, i, 5);
    }

    public final void zza() throws IllegalAccessException, InvocationTargetException {
        this.zzd.zzm(-1);
        this.zzd.zzl(-1);
        int[] iArr = (int[]) this.zze.invoke((Object) null, new Object[]{this.zza.zzb()});
        synchronized (this.zzd) {
            this.zzd.zzm((long) iArr[0]);
            this.zzd.zzl((long) iArr[1]);
            int i = iArr[2];
            if (i != Integer.MIN_VALUE) {
                this.zzd.zzk((long) i);
            }
        }
    }
}
