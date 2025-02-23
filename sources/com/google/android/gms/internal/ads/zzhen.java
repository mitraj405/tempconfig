package com.google.android.gms.internal.ads;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public class zzhen implements Iterator, Closeable, zzaqv {
    private static final zzaqu zza = new zzhem("eof ");
    protected zzaqr zzb;
    protected zzheo zzc;
    zzaqu zzd = null;
    long zze = 0;
    long zzf = 0;
    private final List zzg = new ArrayList();

    static {
        zzheu.zzb(zzhen.class);
    }

    public final boolean hasNext() {
        zzaqu zzaqu = this.zzd;
        if (zzaqu == zza) {
            return false;
        }
        if (zzaqu != null) {
            return true;
        }
        try {
            this.zzd = next();
            return true;
        } catch (NoSuchElementException unused) {
            this.zzd = zza;
            return false;
        }
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        for (int i = 0; i < this.zzg.size(); i++) {
            if (i > 0) {
                sb.append(";");
            }
            sb.append(((zzaqu) this.zzg.get(i)).toString());
        }
        sb.append("]");
        return sb.toString();
    }

    /* renamed from: zzc */
    public final zzaqu next() {
        zzaqu zzb2;
        zzaqu zzaqu = this.zzd;
        if (zzaqu == null || zzaqu == zza) {
            zzheo zzheo = this.zzc;
            if (zzheo == null || this.zze >= this.zzf) {
                this.zzd = zza;
                throw new NoSuchElementException();
            }
            try {
                synchronized (zzheo) {
                    this.zzc.zze(this.zze);
                    zzb2 = this.zzb.zzb(this.zzc, this);
                    this.zze = this.zzc.zzb();
                }
                return zzb2;
            } catch (EOFException unused) {
                throw new NoSuchElementException();
            } catch (IOException unused2) {
                throw new NoSuchElementException();
            }
        } else {
            this.zzd = null;
            return zzaqu;
        }
    }

    public final List zzd() {
        if (this.zzc == null || this.zzd == zza) {
            return this.zzg;
        }
        return new zzhet(this.zzg, this);
    }

    public final void zze(zzheo zzheo, long j, zzaqr zzaqr) throws IOException {
        this.zzc = zzheo;
        this.zze = zzheo.zzb();
        zzheo.zze(zzheo.zzb() + j);
        this.zzf = zzheo.zzb();
        this.zzb = zzaqr;
    }

    public void close() throws IOException {
    }
}
