package com.google.android.gms.internal.measurement;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.0.2 */
class zzlm<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    /* access modifiers changed from: private */
    public List<zzls> zza;
    /* access modifiers changed from: private */
    public Map<K, V> zzb;
    private boolean zzc;
    private volatile zzlx zzd;
    /* access modifiers changed from: private */
    public Map<K, V> zze;
    private volatile zzlq zzf;

    private final SortedMap<K, V> zzf() {
        zzg();
        if (this.zzb.isEmpty() && !(this.zzb instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.zzb = treeMap;
            this.zze = treeMap.descendingMap();
        }
        return (SortedMap) this.zzb;
    }

    /* access modifiers changed from: private */
    public final void zzg() {
        if (this.zzc) {
            throw new UnsupportedOperationException();
        }
    }

    public void clear() {
        zzg();
        if (!this.zza.isEmpty()) {
            this.zza.clear();
        }
        if (!this.zzb.isEmpty()) {
            this.zzb.clear();
        }
    }

    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        if (zza(comparable) >= 0 || this.zzb.containsKey(comparable)) {
            return true;
        }
        return false;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        if (this.zzd == null) {
            this.zzd = new zzlx(this);
        }
        return this.zzd;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzlm)) {
            return super.equals(obj);
        }
        zzlm zzlm = (zzlm) obj;
        int size = size();
        if (size != zzlm.size()) {
            return false;
        }
        int zza2 = zza();
        if (zza2 != zzlm.zza()) {
            return entrySet().equals(zzlm.entrySet());
        }
        for (int i = 0; i < zza2; i++) {
            if (!zza(i).equals(zzlm.zza(i))) {
                return false;
            }
        }
        if (zza2 != size) {
            return this.zzb.equals(zzlm.zzb);
        }
        return true;
    }

    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int zza2 = zza(comparable);
        if (zza2 >= 0) {
            return this.zza.get(zza2).getValue();
        }
        return this.zzb.get(comparable);
    }

    public int hashCode() {
        int zza2 = zza();
        int i = 0;
        for (int i2 = 0; i2 < zza2; i2++) {
            i += this.zza.get(i2).hashCode();
        }
        if (this.zzb.size() > 0) {
            return i + this.zzb.hashCode();
        }
        return i;
    }

    public V remove(Object obj) {
        zzg();
        Comparable comparable = (Comparable) obj;
        int zza2 = zza(comparable);
        if (zza2 >= 0) {
            return zzb(zza2);
        }
        if (this.zzb.isEmpty()) {
            return null;
        }
        return this.zzb.remove(comparable);
    }

    public int size() {
        return this.zzb.size() + this.zza.size();
    }

    public final boolean zze() {
        return this.zzc;
    }

    private zzlm() {
        this.zza = Collections.emptyList();
        this.zzb = Collections.emptyMap();
        this.zze = Collections.emptyMap();
    }

    public final Iterable<Map.Entry<K, V>> zzb() {
        if (this.zzb.isEmpty()) {
            return Collections.emptySet();
        }
        return this.zzb.entrySet();
    }

    public final Set<Map.Entry<K, V>> zzc() {
        if (this.zzf == null) {
            this.zzf = new zzlq(this);
        }
        return this.zzf;
    }

    public void zzd() {
        Map<K, V> map;
        Map<K, V> map2;
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

    private final int zza(K k) {
        int size = this.zza.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo((Comparable) this.zza.get(size).getKey());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        int i = 0;
        while (i <= size) {
            int i2 = (i + size) / 2;
            int compareTo2 = k.compareTo((Comparable) this.zza.get(i2).getKey());
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
    public final V zzb(int i) {
        zzg();
        V value = this.zza.remove(i).getValue();
        if (!this.zzb.isEmpty()) {
            Iterator it = zzf().entrySet().iterator();
            this.zza.add(new zzls(this, (Map.Entry) it.next()));
            it.remove();
        }
        return value;
    }

    public final int zza() {
        return this.zza.size();
    }

    /* renamed from: zza */
    public final V put(K k, V v) {
        zzg();
        int zza2 = zza(k);
        if (zza2 >= 0) {
            return this.zza.get(zza2).setValue(v);
        }
        zzg();
        if (this.zza.isEmpty() && !(this.zza instanceof ArrayList)) {
            this.zza = new ArrayList(16);
        }
        int i = -(zza2 + 1);
        if (i >= 16) {
            return zzf().put(k, v);
        }
        if (this.zza.size() == 16) {
            zzls remove = this.zza.remove(15);
            zzf().put((Comparable) remove.getKey(), remove.getValue());
        }
        this.zza.add(i, new zzls(this, k, v));
        return null;
    }

    public final Map.Entry<K, V> zza(int i) {
        return this.zza.get(i);
    }
}
