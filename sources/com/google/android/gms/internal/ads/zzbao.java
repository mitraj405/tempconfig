package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzbao extends PushbackInputStream {
    final /* synthetic */ zzbap zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzbao(zzbap zzbap, InputStream inputStream, int i) {
        super(inputStream, 1);
        this.zza = zzbap;
    }

    public final synchronized void close() throws IOException {
        zzbar.zze(this.zza.zzc);
        super.close();
    }
}
