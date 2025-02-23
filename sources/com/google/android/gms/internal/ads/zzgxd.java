package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
public abstract class zzgxd extends zzgwd {
    private static final Logger zza = Logger.getLogger(zzgxd.class.getName());
    /* access modifiers changed from: private */
    public static final boolean zzb = zzhaz.zzA();
    public static final /* synthetic */ int zzf = 0;
    zzgxe zze;

    private zzgxd() {
        throw null;
    }

    public /* synthetic */ zzgxd(zzgxc zzgxc) {
    }

    public static int zzA(zzgzj zzgzj, zzhae zzhae) {
        int zzaM = ((zzgvv) zzgzj).zzaM(zzhae);
        return zzD(zzaM) + zzaM;
    }

    public static int zzB(int i) {
        if (i > 4096) {
            return 4096;
        }
        return i;
    }

    public static int zzC(String str) {
        int i;
        try {
            i = zzhbe.zze(str);
        } catch (zzhbd unused) {
            i = str.getBytes(zzgyl.zza).length;
        }
        return zzD(i) + i;
    }

    public static int zzD(int i) {
        return (352 - (Integer.numberOfLeadingZeros(i) * 9)) >>> 6;
    }

    public static int zzE(long j) {
        return (640 - (Long.numberOfLeadingZeros(j) * 9)) >>> 6;
    }

    public static zzgxd zzF(byte[] bArr, int i, int i2) {
        return new zzgwz(bArr, 0, i2);
    }

    @Deprecated
    public static int zzy(int i, zzgzj zzgzj, zzhae zzhae) {
        int zzD = zzD(i << 3);
        return ((zzgvv) zzgzj).zzaM(zzhae) + zzD + zzD;
    }

    public static int zzz(zzgzj zzgzj) {
        int zzaY = zzgzj.zzaY();
        return zzD(zzaY) + zzaY;
    }

    public final void zzG() {
        if (zzb() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public final void zzH(String str, zzhbd zzhbd) throws IOException {
        zza.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", zzhbd);
        byte[] bytes = str.getBytes(zzgyl.zza);
        try {
            int length = bytes.length;
            zzu(length);
            zza(bytes, 0, length);
        } catch (IndexOutOfBoundsException e) {
            throw new zzgxa(e);
        }
    }

    public abstract void zzL() throws IOException;

    public abstract void zzM(byte b) throws IOException;

    public abstract void zzN(int i, boolean z) throws IOException;

    public abstract void zzO(int i, zzgwm zzgwm) throws IOException;

    public abstract void zza(byte[] bArr, int i, int i2) throws IOException;

    public abstract int zzb();

    public abstract void zzh(int i, int i2) throws IOException;

    public abstract void zzi(int i) throws IOException;

    public abstract void zzj(int i, long j) throws IOException;

    public abstract void zzk(long j) throws IOException;

    public abstract void zzl(int i, int i2) throws IOException;

    public abstract void zzm(int i) throws IOException;

    public abstract void zzn(int i, zzgzj zzgzj, zzhae zzhae) throws IOException;

    public abstract void zzo(int i, zzgzj zzgzj) throws IOException;

    public abstract void zzp(int i, zzgwm zzgwm) throws IOException;

    public abstract void zzq(int i, String str) throws IOException;

    public abstract void zzs(int i, int i2) throws IOException;

    public abstract void zzt(int i, int i2) throws IOException;

    public abstract void zzu(int i) throws IOException;

    public abstract void zzv(int i, long j) throws IOException;

    public abstract void zzw(long j) throws IOException;
}
