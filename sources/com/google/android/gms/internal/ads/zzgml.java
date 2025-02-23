package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgml {
    public static final zzgvr zza = zzgvr.zzb(new byte[0]);

    public static final zzgvr zza(int i) {
        return zzgvr.zzb(ByteBuffer.allocate(5).put((byte) 0).putInt(i).array());
    }

    public static final zzgvr zzb(int i) {
        return zzgvr.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(i).array());
    }
}
