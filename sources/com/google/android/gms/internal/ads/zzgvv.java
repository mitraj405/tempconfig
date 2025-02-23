package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgvu;
import com.google.android.gms.internal.ads.zzgvv;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
public abstract class zzgvv<MessageType extends zzgvv<MessageType, BuilderType>, BuilderType extends zzgvu<MessageType, BuilderType>> implements zzgzj {
    protected int zzq = 0;

    public static <T> void zzaQ(Iterable<T> iterable, List<? super T> list) {
        zzgvu.zzbd(iterable, list);
    }

    public static void zzaR(zzgwm zzgwm) throws IllegalArgumentException {
        if (!zzgwm.zzp()) {
            throw new IllegalArgumentException("Byte string is not UTF-8.");
        }
    }

    private String zzdI(String str) {
        return C1058d.A("Serializing ", getClass().getName(), " to a ", str, " threw an IOException (should never happen).");
    }

    public int zzaL() {
        throw new UnsupportedOperationException();
    }

    public int zzaM(zzhae zzhae) {
        return zzaL();
    }

    public zzgwm zzaN() {
        try {
            int zzaY = zzaY();
            zzgwm zzgwm = zzgwm.zzb;
            byte[] bArr = new byte[zzaY];
            zzgxd zzF = zzgxd.zzF(bArr, 0, zzaY);
            zzda(zzF);
            zzF.zzG();
            return new zzgwk(bArr);
        } catch (IOException e) {
            throw new RuntimeException(zzdI("ByteString"), e);
        }
    }

    public zzgzo zzaO() {
        throw new UnsupportedOperationException("mutableCopy() is not implemented.");
    }

    public zzhar zzaP() {
        return new zzhar(this);
    }

    public void zzaS(int i) {
        throw new UnsupportedOperationException();
    }

    public void zzaT(OutputStream outputStream) throws IOException {
        int zzaY = zzaY();
        zzgxb zzgxb = new zzgxb(outputStream, zzgxd.zzB(zzgxd.zzD(zzaY) + zzaY));
        zzgxb.zzu(zzaY);
        zzda(zzgxb);
        zzgxb.zzL();
    }

    public void zzaU(OutputStream outputStream) throws IOException {
        zzgxb zzgxb = new zzgxb(outputStream, zzgxd.zzB(zzaY()));
        zzda(zzgxb);
        zzgxb.zzL();
    }

    public byte[] zzaV() {
        try {
            int zzaY = zzaY();
            byte[] bArr = new byte[zzaY];
            zzgxd zzF = zzgxd.zzF(bArr, 0, zzaY);
            zzda(zzF);
            zzF.zzG();
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException(zzdI("byte array"), e);
        }
    }
}
