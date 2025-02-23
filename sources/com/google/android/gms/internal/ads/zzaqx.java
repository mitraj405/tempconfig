package com.google.android.gms.internal.ads;

import com.google.common.primitives.UnsignedBytes;
import java.nio.ByteBuffer;
import java.util.Date;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzaqx extends zzhel {
    private Date zzg;
    private Date zzh;
    private long zzi;
    private long zzj;
    private double zzk = 1.0d;
    private float zzl = 1.0f;
    private zzhev zzm = zzhev.zza;
    private long zzn;

    public zzaqx() {
        super("mvhd");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("MovieHeaderBox[creationTime=");
        sb.append(this.zzg);
        sb.append(";modificationTime=");
        sb.append(this.zzh);
        sb.append(";timescale=");
        sb.append(this.zzi);
        sb.append(";duration=");
        sb.append(this.zzj);
        sb.append(";rate=");
        sb.append(this.zzk);
        sb.append(";volume=");
        sb.append(this.zzl);
        sb.append(";matrix=");
        sb.append(this.zzm);
        sb.append(";nextTrackId=");
        return lf.l(sb, this.zzn, "]");
    }

    public final long zzc() {
        return this.zzj;
    }

    public final long zzd() {
        return this.zzi;
    }

    public final void zze(ByteBuffer byteBuffer) {
        zzh(byteBuffer);
        if (zzg() == 1) {
            this.zzg = zzheq.zza(zzaqt.zzf(byteBuffer));
            this.zzh = zzheq.zza(zzaqt.zzf(byteBuffer));
            this.zzi = zzaqt.zze(byteBuffer);
            this.zzj = zzaqt.zzf(byteBuffer);
        } else {
            this.zzg = zzheq.zza(zzaqt.zze(byteBuffer));
            this.zzh = zzheq.zza(zzaqt.zze(byteBuffer));
            this.zzi = zzaqt.zze(byteBuffer);
            this.zzj = zzaqt.zze(byteBuffer);
        }
        this.zzk = zzaqt.zzb(byteBuffer);
        byte[] bArr = new byte[2];
        byteBuffer.get(bArr);
        this.zzl = ((float) ((short) ((bArr[1] & UnsignedBytes.MAX_VALUE) | ((short) (65280 & (bArr[0] << 8)))))) / 256.0f;
        zzaqt.zzd(byteBuffer);
        zzaqt.zze(byteBuffer);
        zzaqt.zze(byteBuffer);
        double zzb = zzaqt.zzb(byteBuffer);
        double zzb2 = zzaqt.zzb(byteBuffer);
        double zza = zzaqt.zza(byteBuffer);
        this.zzm = new zzhev(zzb, zzb2, zzaqt.zzb(byteBuffer), zzaqt.zzb(byteBuffer), zza, zzaqt.zza(byteBuffer), zzaqt.zza(byteBuffer), zzaqt.zzb(byteBuffer), zzaqt.zzb(byteBuffer));
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        this.zzn = zzaqt.zze(byteBuffer);
    }
}
