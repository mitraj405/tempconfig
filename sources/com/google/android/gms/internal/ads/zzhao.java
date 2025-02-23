package com.google.android.gms.internal.ads;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
class zzhao extends AbstractMap {
    /* access modifiers changed from: private */
    public List zza = Collections.emptyList();
    /* access modifiers changed from: private */
    public Map zzb = Collections.emptyMap();
    private boolean zzc;
    private volatile zzham zzd;
    private Map zze = Collections.emptyMap();

    private zzhao() {
    }

    private final int zzk(Comparable comparable) {
        int size = this.zza.size() - 1;
        int i = 0;
        if (size >= 0) {
            int compareTo = comparable.compareTo(((zzhai) this.zza.get(size)).zza());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        while (i <= size) {
            int i2 = (i + size) / 2;
            int compareTo2 = comparable.compareTo(((zzhai) this.zza.get(i2)).zza());
            if (compareTo2 < 0) {
                size = i2 - 1;
            } else if (compareTo2 <= 0) {
                return i2;
            } else {
                i = i2 + 1;
            }
        }
        return -(i + 1);
    }

    /* access modifiers changed from: private */
    public final Object zzl(int i) {
        zzn();
        Object value = ((zzhai) this.zza.remove(i)).getValue();
        if (!this.zzb.isEmpty()) {
            Iterator it = zzm().entrySet().iterator();
            List list = this.zza;
            Map.Entry entry = (Map.Entry) it.next();
            list.add(new zzhai(this, (Comparable) entry.getKey(), entry.getValue()));
            it.remove();
        }
        return value;
    }

    private final SortedMap zzm() {
        zzn();
        if (this.zzb.isEmpty() && !(this.zzb instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.zzb = treeMap;
            this.zze = treeMap.descendingMap();
        }
        return (SortedMap) this.zzb;
    }

    /* access modifiers changed from: private */
    public final void zzn() {
        if (this.zzc) {
            throw new UnsupportedOperationException();
        }
    }

    public final void clear() {
        zzn();
        if (!this.zza.isEmpty()) {
            this.zza.clear();
        }
        if (!this.zzb.isEmpty()) {
            this.zzb.clear();
        }
    }

    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        if (zzk(comparable) >= 0 || this.zzb.containsKey(comparable)) {
            return true;
        }
        return false;
    }

    public final Set entrySet() {
        if (this.zzd == null) {
            this.zzd = new zzham(this, (zzhal) null);
        }
        return this.zzd;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzhao)) {
            return super.equals(obj);
        }
        zzhao zzhao = (zzhao) obj;
        int size = size();
        if (size != zzhao.size()) {
            return false;
        }
        int zzb2 = zzb();
        if (zzb2 != zzhao.zzb()) {
            return entrySet().equals(zzhao.entrySet());
        }
        for (int i = 0; i < zzb2; i++) {
            if (!zzg(i).equals(zzhao.zzg(i))) {
                return false;
            }
        }
        if (zzb2 != size) {
            return this.zzb.equals(zzhao.zzb);
        }
        return true;
    }

    public final Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int zzk = zzk(comparable);
        if (zzk >= 0) {
            return ((zzhai) this.zza.get(zzk)).getValue();
        }
        return this.zzb.get(comparable);
    }

    public final int hashCode() {
        int zzb2 = zzb();
        int i = 0;
        for (int i2 = 0; i2 < zzb2; i2++) {
            i += ((zzhai) this.zza.get(i2)).hashCode();
        }
        if (this.zzb.size() > 0) {
            return this.zzb.hashCode() + i;
        }
        return i;
    }

    public final Object remove(Object obj) {
        zzn();
        Comparable comparable = (Comparable) obj;
        int zzk = zzk(comparable);
        if (zzk >= 0) {
            return zzl(zzk);
        }
        if (this.zzb.isEmpty()) {
            return null;
        }
        return this.zzb.remove(comparable);
    }

    public final int size() {
        return this.zzb.size() + this.zza.size();
    }

    public void zza() {
        Map map;
        Map map2;
        if (!this.zzc) {
            if (this.zzb.isEmpty()) {
                map = Collections.emptyMap();
            } else {
                map = Collections.unmodifiableMap(this.zzb);
            }
            this.zzb = map;
            if (this.zze.isEmpty()) {
                map2 = Collections.emptyMap();
            } else {
                map2 = Collections.unmodifiableMap(this.zze);
            }
            this.zze = map2;
            this.zzc = true;
        }
    }

    public final int zzb() {
        return this.zza.size();
    }

    public final Iterable zzc() {
        if (this.zzb.isEmpty()) {
            return Collections.emptySet();
        }
        return this.zzb.entrySet();
    }

    /* renamed from: zze */
    public final Object put(Comparable comparable, Object obj) {
        zzn();
        int zzk = zzk(comparable);
        if (zzk >= 0) {
            return ((zzhai) this.zza.get(zzk)).setValue(obj);
        }
        zzn();
        if (this.zza.isEmpty() && !(this.zza instanceof ArrayList)) {
            this.zza = new ArrayList(16);
        }
        int i = -(zzk + 1);
        if (i >= 16) {
            return zzm().put(comparable, obj);
        }
        if (this.zza.size() == 16) {
            zzhai zzhai = (zzhai) this.zza.remove(15);
            zzm().put(zzhai.zza(), zzhai.getValue());
        }
        this.zza.add(i, new zzhai(this, comparable, obj));
        return null;
    }

    public final Map.Entry zzg(int i) {
        return (Map.Entry) this.zza.get(i);
    }

    public final boolean zzj() {
        return this.zzc;
    }

    public /* synthetic */ zzhao(zzhan zzhan) {
    }
}
