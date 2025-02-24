package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzhp;
import com.google.android.gms.internal.measurement.zzhq;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.0.2 */
public abstract class zzhq<MessageType extends zzhq<MessageType, BuilderType>, BuilderType extends zzhp<MessageType, BuilderType>> implements zzkt {
    protected int zza = 0;

    public int zza(zzll zzll) {
        int zzbx = zzbx();
        if (zzbx != -1) {
            return zzbx;
        }
        int zza2 = zzll.zza(this);
        zzc(zza2);
        return zza2;
    }

    public int zzbx() {
        throw new UnsupportedOperationException();
    }

    public final zzia zzby() {
        try {
            zzif zzc = zzia.zzc(zzca());
            zza(zzc.zzb());
            return zzc.zza();
        } catch (IOException e) {
            throw new RuntimeException(lf.j("Serializing ", getClass().getName(), " to a ByteString threw an IOException (should never happen)."), e);
        }
    }

    public final byte[] zzbz() {
        try {
            byte[] bArr = new byte[zzca()];
            zzit zzb = zzit.zzb(bArr);
            zza(zzb);
            zzb.zzb();
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException(lf.j("Serializing ", getClass().getName(), " to a byte array threw an IOException (should never happen)."), e);
        }
    }

    public void zzc(int i) {
        throw new UnsupportedOperationException();
    }

    public static <T> void zza(Iterable<T> iterable, List<? super T> list) {
        zzjm.zza(iterable);
        if (iterable instanceof zzka) {
            List<?> zza2 = ((zzka) iterable).zza();
            zzka zzka = (zzka) list;
            int size = list.size();
            for (Object next : zza2) {
                if (next == null) {
                    String y = C1058d.y("Element at index ", zzka.size() - size, " is null.");
                    int size2 = zzka.size();
                    while (true) {
                        size2--;
                        if (size2 >= size) {
                            zzka.remove(size2);
                        } else {
                            throw new NullPointerException(y);
                        }
                    }
                } else if (next instanceof zzia) {
                    zzka.zza((zzia) next);
                } else if (next instanceof byte[]) {
                    zzka.zza(zzia.zza((byte[]) next));
                } else {
                    zzka.add((String) next);
                }
            }
        } else if (iterable instanceof zzlf) {
            list.addAll((Collection) iterable);
        } else {
            if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
                ((ArrayList) list).ensureCapacity(((Collection) iterable).size() + list.size());
            }
            int size3 = list.size();
            for (T next2 : iterable) {
                if (next2 == null) {
                    String y2 = C1058d.y("Element at index ", list.size() - size3, " is null.");
                    int size4 = list.size();
                    while (true) {
                        size4--;
                        if (size4 >= size3) {
                            list.remove(size4);
                        } else {
                            throw new NullPointerException(y2);
                        }
                    }
                } else {
                    list.add(next2);
                }
            }
        }
    }
}
