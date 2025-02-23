package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzake implements zzadp {
    private final zzadp zza;
    private final zzajy zzb;
    private final zzek zzc = new zzek();
    private int zzd = 0;
    private int zze = 0;
    private byte[] zzf = zzet.zzf;
    private zzaka zzg;
    private zzaf zzh;

    public zzake(zzadp zzadp, zzajy zzajy) {
        this.zza = zzadp;
        this.zzb = zzajy;
    }

    private final void zzc(int i) {
        byte[] bArr;
        int length = this.zzf.length;
        int i2 = this.zze;
        if (length - i2 < i) {
            int i3 = i2 - this.zzd;
            int max = Math.max(i3 + i3, i + i3);
            byte[] bArr2 = this.zzf;
            if (max <= bArr2.length) {
                bArr = bArr2;
            } else {
                bArr = new byte[max];
            }
            System.arraycopy(bArr2, this.zzd, bArr, 0, i3);
            this.zzd = 0;
            this.zze = i3;
            this.zzf = bArr;
        }
    }

    public final /* synthetic */ void zza(long j, int i, zzajs zzajs) {
        boolean z;
        zzdi.zzb(this.zzh);
        zzfxr<zzdb> zzfxr = zzajs.zza;
        long j2 = zzajs.zzc;
        ArrayList arrayList = new ArrayList(zzfxr.size());
        for (zzdb zza2 : zzfxr) {
            arrayList.add(zza2.zza());
        }
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("c", arrayList);
        bundle.putLong("d", j2);
        Parcel obtain = Parcel.obtain();
        obtain.writeBundle(bundle);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        zzek zzek = this.zzc;
        int length = marshall.length;
        zzek.zzI(marshall, length);
        this.zza.zzq(this.zzc, length);
        long j3 = zzajs.zzb;
        if (j3 == -9223372036854775807L) {
            if (this.zzh.zzq == Long.MAX_VALUE) {
                z = true;
            } else {
                z = false;
            }
            zzdi.zzf(z);
        } else {
            long j4 = this.zzh.zzq;
            if (j4 == Long.MAX_VALUE) {
                j += j3;
            } else {
                j = j3 + j4;
            }
        }
        this.zza.zzs(j, i, length, 0, (zzado) null);
    }

    public final void zzb() {
        zzaka zzaka = this.zzg;
        if (zzaka != null) {
            zzaka.zzb();
        }
    }

    public final /* synthetic */ int zzf(zzp zzp, int i, boolean z) {
        return zzadn.zza(this, zzp, i, z);
    }

    public final int zzg(zzp zzp, int i, boolean z, int i2) throws IOException {
        if (this.zzg == null) {
            return this.zza.zzg(zzp, i, z, 0);
        }
        zzc(i);
        int zza2 = zzp.zza(this.zzf, this.zze, i);
        if (zza2 != -1) {
            this.zze += zza2;
            return zza2;
        } else if (z) {
            return -1;
        } else {
            throw new EOFException();
        }
    }

    public final void zzl(zzaf zzaf) {
        boolean z;
        zzaka zzaka;
        String str = zzaf.zzm;
        str.getClass();
        if (zzbn.zzb(str) == 3) {
            z = true;
        } else {
            z = false;
        }
        zzdi.zzd(z);
        if (!zzaf.equals(this.zzh)) {
            this.zzh = zzaf;
            if (this.zzb.zzc(zzaf)) {
                zzaka = this.zzb.zzb(zzaf);
            } else {
                zzaka = null;
            }
            this.zzg = zzaka;
        }
        if (this.zzg == null) {
            this.zza.zzl(zzaf);
            return;
        }
        zzadp zzadp = this.zza;
        zzad zzb2 = zzaf.zzb();
        zzb2.zzX("application/x-media3-cues");
        zzb2.zzz(zzaf.zzm);
        zzb2.zzab(Long.MAX_VALUE);
        zzb2.zzD(this.zzb.zza(zzaf));
        zzadp.zzl(zzb2.zzad());
    }

    public final /* synthetic */ void zzq(zzek zzek, int i) {
        zzadn.zzb(this, zzek, i);
    }

    public final void zzr(zzek zzek, int i, int i2) {
        if (this.zzg == null) {
            this.zza.zzr(zzek, i, i2);
            return;
        }
        zzc(i);
        zzek.zzG(this.zzf, this.zze, i);
        this.zze += i;
    }

    public final void zzs(long j, int i, int i2, int i3, zzado zzado) {
        boolean z;
        if (this.zzg == null) {
            this.zza.zzs(j, i, i2, i3, zzado);
            return;
        }
        if (zzado == null) {
            z = true;
        } else {
            z = false;
        }
        zzdi.zze(z, "DRM on subtitles is not supported");
        int i4 = (this.zze - i3) - i2;
        this.zzg.zza(this.zzf, i4, i2, zzajz.zza(), new zzakd(this, j, i));
        int i5 = i4 + i2;
        this.zzd = i5;
        if (i5 == this.zze) {
            this.zzd = 0;
            this.zze = 0;
        }
    }
}
