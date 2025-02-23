package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public abstract class zzhej implements zzaqu {
    private static final zzheu zzg = zzheu.zzb(zzhej.class);
    protected final String zza;
    boolean zzb;
    boolean zzc;
    long zzd;
    long zze = -1;
    zzheo zzf;
    private ByteBuffer zzh;

    public zzhej(String str) {
        this.zza = str;
        this.zzc = true;
        this.zzb = true;
    }

    private final synchronized void zzc() {
        String str;
        if (!this.zzc) {
            try {
                zzheu zzheu = zzg;
                String str2 = this.zza;
                if (str2.length() != 0) {
                    str = "mem mapping ".concat(str2);
                } else {
                    str = new String("mem mapping ");
                }
                zzheu.zza(str);
                this.zzh = this.zzf.zzd(this.zzd, this.zze);
                this.zzc = true;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public final String zza() {
        return this.zza;
    }

    public final void zzb(zzheo zzheo, ByteBuffer byteBuffer, long j, zzaqr zzaqr) throws IOException {
        this.zzd = zzheo.zzb();
        byteBuffer.remaining();
        this.zze = j;
        this.zzf = zzheo;
        zzheo.zze(zzheo.zzb() + j);
        this.zzc = false;
        this.zzb = false;
        zzf();
    }

    public abstract void zze(ByteBuffer byteBuffer);

    public final synchronized void zzf() {
        String str;
        zzc();
        zzheu zzheu = zzg;
        String str2 = this.zza;
        if (str2.length() != 0) {
            str = "parsing details of ".concat(str2);
        } else {
            str = new String("parsing details of ");
        }
        zzheu.zza(str);
        ByteBuffer byteBuffer = this.zzh;
        if (byteBuffer != null) {
            this.zzb = true;
            byteBuffer.rewind();
            zze(byteBuffer);
            if (byteBuffer.remaining() > 0) {
                byteBuffer.slice();
            }
            this.zzh = null;
        }
    }
}
