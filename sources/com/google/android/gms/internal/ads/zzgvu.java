package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgvu;
import com.google.android.gms.internal.ads.zzgvv;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
public abstract class zzgvu<MessageType extends zzgvv<MessageType, BuilderType>, BuilderType extends zzgvu<MessageType, BuilderType>> implements zzgzi {
    private String zza(String str) {
        return C1058d.A("Reading ", getClass().getName(), " from a ", str, " threw an IOException (should never happen).");
    }

    private static <T> void zzb(Iterable<T> iterable, List<? super T> list) {
        if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
            ((ArrayList) list).ensureCapacity(((Collection) iterable).size() + list.size());
        }
        int size = list.size();
        for (T next : iterable) {
            if (next == null) {
                String y = C1058d.y("Element at index ", list.size() - size, " is null.");
                int size2 = list.size();
                while (true) {
                    size2--;
                    if (size2 >= size) {
                        list.remove(size2);
                    } else {
                        throw new NullPointerException(y);
                    }
                }
            } else {
                list.add(next);
            }
        }
    }

    public static zzhar zzbb(zzgzj zzgzj) {
        return new zzhar(zzgzj);
    }

    @Deprecated
    public static <T> void zzbc(Iterable<T> iterable, Collection<? super T> collection) {
        zzbd(iterable, (List) collection);
    }

    public static <T> void zzbd(Iterable<T> iterable, List<? super T> list) {
        byte[] bArr = zzgyl.zzb;
        iterable.getClass();
        if (iterable instanceof zzgyv) {
            List zza = ((zzgyv) iterable).zza();
            zzgyv zzgyv = (zzgyv) list;
            int size = list.size();
            for (Object next : zza) {
                if (next == null) {
                    String y = C1058d.y("Element at index ", zzgyv.size() - size, " is null.");
                    int size2 = zzgyv.size();
                    while (true) {
                        size2--;
                        if (size2 >= size) {
                            zzgyv.remove(size2);
                        } else {
                            throw new NullPointerException(y);
                        }
                    }
                } else if (next instanceof zzgwm) {
                    zzgwm zzgwm = (zzgwm) next;
                    zzgyv.zzb();
                } else if (next instanceof byte[]) {
                    byte[] bArr2 = (byte[]) next;
                    zzgwm.zzv(bArr2, 0, bArr2.length);
                    zzgyv.zzb();
                } else {
                    zzgyv.add((String) next);
                }
            }
        } else if (iterable instanceof zzgzs) {
            list.addAll((Collection) iterable);
        } else {
            zzb(iterable, list);
        }
    }

    /* renamed from: zzaC */
    public abstract BuilderType zzaP();

    public abstract BuilderType zzaD(MessageType messagetype);

    public BuilderType zzaE(zzgwm zzgwm) throws zzgyn {
        try {
            zzgww zzl = zzgwm.zzl();
            zzaR(zzl);
            zzl.zzy(0);
            return this;
        } catch (zzgyn e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException(zza("ByteString"), e2);
        }
    }

    /* renamed from: zzaF */
    public BuilderType zzaR(zzgww zzgww) throws IOException {
        int i = zzgxi.zzb;
        int i2 = zzgzt.zza;
        return zzaW(zzgww, zzgxi.zza);
    }

    /* renamed from: zzaG */
    public BuilderType zzaS(zzgzj zzgzj) {
        if (zzbt().getClass().isInstance(zzgzj)) {
            return zzaD((zzgvv) zzgzj);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }

    public BuilderType zzaH(InputStream inputStream) throws IOException {
        zzgww zzG = zzgww.zzG(inputStream, 4096);
        zzaR(zzG);
        zzG.zzy(0);
        return this;
    }

    /* renamed from: zzaI */
    public BuilderType zzaU(byte[] bArr) throws zzgyn {
        return zzaZ(bArr, 0, bArr.length);
    }

    public BuilderType zzaJ(zzgwm zzgwm, zzgxi zzgxi) throws zzgyn {
        try {
            zzgww zzl = zzgwm.zzl();
            zzaW(zzl, zzgxi);
            zzl.zzy(0);
            return this;
        } catch (zzgyn e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException(zza("ByteString"), e2);
        }
    }

    /* renamed from: zzaK */
    public abstract BuilderType zzaW(zzgww zzgww, zzgxi zzgxi) throws IOException;

    public BuilderType zzaL(InputStream inputStream, zzgxi zzgxi) throws IOException {
        zzgww zzG = zzgww.zzG(inputStream, 4096);
        zzaW(zzG, zzgxi);
        zzG.zzy(0);
        return this;
    }

    /* renamed from: zzaM */
    public BuilderType zzaY(byte[] bArr, zzgxi zzgxi) throws zzgyn {
        return zzba(bArr, 0, bArr.length, zzgxi);
    }

    /* renamed from: zzaN */
    public BuilderType zzaZ(byte[] bArr, int i, int i2) throws zzgyn {
        try {
            zzgww zzH = zzgww.zzH(bArr, i, i2, false);
            zzaR(zzH);
            zzH.zzy(0);
            return this;
        } catch (zzgyn e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException(zza("byte array"), e2);
        }
    }

    /* renamed from: zzaO */
    public BuilderType zzba(byte[] bArr, int i, int i2, zzgxi zzgxi) throws zzgyn {
        try {
            zzgww zzH = zzgww.zzH(bArr, i, i2, false);
            zzaW(zzH, zzgxi);
            zzH.zzy(0);
            return this;
        } catch (zzgyn e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException(zza("byte array"), e2);
        }
    }

    public /* bridge */ /* synthetic */ zzgzi zzaQ(zzgwm zzgwm) throws zzgyn {
        zzaE(zzgwm);
        return this;
    }

    public /* bridge */ /* synthetic */ zzgzi zzaT(InputStream inputStream) throws IOException {
        zzaH(inputStream);
        return this;
    }

    public /* bridge */ /* synthetic */ zzgzi zzaV(zzgwm zzgwm, zzgxi zzgxi) throws zzgyn {
        zzaJ(zzgwm, zzgxi);
        return this;
    }

    public /* bridge */ /* synthetic */ zzgzi zzaX(InputStream inputStream, zzgxi zzgxi) throws IOException {
        zzaL(inputStream, zzgxi);
        return this;
    }

    public boolean zzbe(InputStream inputStream) throws IOException {
        int i = zzgxi.zzb;
        int i2 = zzgzt.zza;
        return zzbf(inputStream, zzgxi.zza);
    }

    public boolean zzbf(InputStream inputStream, zzgxi zzgxi) throws IOException {
        int read = inputStream.read();
        if (read == -1) {
            return false;
        }
        zzaL(new zzgvt(inputStream, zzgww.zzE(read, inputStream)), zzgxi);
        return true;
    }
}
