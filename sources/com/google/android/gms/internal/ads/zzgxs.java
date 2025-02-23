package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgxs;
import com.google.android.gms.internal.ads.zzgxy;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
public class zzgxs<MessageType extends zzgxy<MessageType, BuilderType>, BuilderType extends zzgxs<MessageType, BuilderType>> extends zzgvu<MessageType, BuilderType> {
    protected MessageType zza;
    private final MessageType zzb;

    public zzgxs(MessageType messagetype) {
        this.zzb = messagetype;
        if (!messagetype.zzcf()) {
            this.zza = zza();
            return;
        }
        throw new IllegalArgumentException("Default instance must be immutable.");
    }

    private MessageType zza() {
        return this.zzb.zzbj();
    }

    private static <MessageType> void zzb(MessageType messagetype, MessageType messagetype2) {
        zzgzt.zza().zzb(messagetype.getClass()).zzg(messagetype, messagetype2);
    }

    public /* bridge */ /* synthetic */ zzgvu zzaD(zzgvv zzgvv) {
        zzbi((zzgxy) zzgvv);
        return this;
    }

    public /* bridge */ /* synthetic */ zzgvu zzaK(zzgww zzgww, zzgxi zzgxi) throws IOException {
        zzbk(zzgww, zzgxi);
        return this;
    }

    public /* bridge */ /* synthetic */ zzgvu zzaN(byte[] bArr, int i, int i2) throws zzgyn {
        zzbl(bArr, i, i2);
        return this;
    }

    public /* bridge */ /* synthetic */ zzgvu zzaO(byte[] bArr, int i, int i2, zzgxi zzgxi) throws zzgyn {
        zzbm(bArr, i, i2, zzgxi);
        return this;
    }

    public /* bridge */ /* synthetic */ zzgzi zzaW(zzgww zzgww, zzgxi zzgxi) throws IOException {
        zzbk(zzgww, zzgxi);
        return this;
    }

    public /* bridge */ /* synthetic */ zzgzi zzaZ(byte[] bArr, int i, int i2) throws zzgyn {
        zzbl(bArr, i, i2);
        return this;
    }

    public /* bridge */ /* synthetic */ zzgzi zzba(byte[] bArr, int i, int i2, zzgxi zzgxi) throws zzgyn {
        zzbm(bArr, i, i2, zzgxi);
        return this;
    }

    public final BuilderType zzbg() {
        if (!this.zzb.zzcf()) {
            this.zza = zza();
            return this;
        }
        throw new IllegalArgumentException("Default instance must be immutable.");
    }

    /* renamed from: zzbh */
    public BuilderType zzaP() {
        BuilderType zzbb = zzbt().zzcZ();
        zzbb.zza = zzbs();
        return zzbb;
    }

    public BuilderType zzbi(MessageType messagetype) {
        zzbj(messagetype);
        return this;
    }

    public BuilderType zzbj(MessageType messagetype) {
        if (zzbt().equals(messagetype)) {
            return this;
        }
        zzbu();
        zzb(this.zza, messagetype);
        return this;
    }

    public BuilderType zzbk(zzgww zzgww, zzgxi zzgxi) throws IOException {
        zzbu();
        try {
            zzgzt.zza().zzb(this.zza.getClass()).zzh(this.zza, zzgwx.zzq(zzgww), zzgxi);
            return this;
        } catch (RuntimeException e) {
            if (e.getCause() instanceof IOException) {
                throw ((IOException) e.getCause());
            }
            throw e;
        }
    }

    public BuilderType zzbl(byte[] bArr, int i, int i2) throws zzgyn {
        int i3 = zzgxi.zzb;
        int i4 = zzgzt.zza;
        zzbm(bArr, i, i2, zzgxi.zza);
        return this;
    }

    public BuilderType zzbm(byte[] bArr, int i, int i2, zzgxi zzgxi) throws zzgyn {
        zzbu();
        try {
            zzgzt.zza().zzb(this.zza.getClass()).zzi(this.zza, bArr, i, i + i2, new zzgwa(zzgxi));
            return this;
        } catch (zzgyn e) {
            throw e;
        } catch (IndexOutOfBoundsException unused) {
            throw zzgyn.zzi();
        } catch (IOException e2) {
            throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
        }
    }

    /* renamed from: zzbn */
    public final MessageType zzbr() {
        MessageType zzbo = zzbs();
        if (zzbo.zzbw()) {
            return zzbo;
        }
        throw zzgvu.zzbb(zzbo);
    }

    /* renamed from: zzbo */
    public MessageType zzbs() {
        if (!this.zza.zzcf()) {
            return this.zza;
        }
        this.zza.zzbW();
        return this.zza;
    }

    /* renamed from: zzbp */
    public MessageType zzbt() {
        return this.zzb;
    }

    public /* bridge */ /* synthetic */ zzgzi zzbq() {
        zzbg();
        return this;
    }

    public final void zzbu() {
        if (!this.zza.zzcf()) {
            zzbv();
        }
    }

    public void zzbv() {
        MessageType zza2 = zza();
        zzb(zza2, this.zza);
        this.zza = zza2;
    }

    public final boolean zzbw() {
        return zzgxy.zzce(this.zza, false);
    }
}
