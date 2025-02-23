package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzwi {
    public static final zzwi zza = new zzwi(new zzcd[0]);
    public final int zzb;
    private final zzfxr zzc;
    private int zzd;

    static {
        Integer.toString(0, 36);
    }

    public zzwi(zzcd... zzcdArr) {
        this.zzc = zzfxr.zzl(zzcdArr);
        this.zzb = zzcdArr.length;
        int i = 0;
        while (i < this.zzc.size()) {
            int i2 = i + 1;
            for (int i3 = i2; i3 < this.zzc.size(); i3++) {
                if (((zzcd) this.zzc.get(i)).equals(this.zzc.get(i3))) {
                    zzea.zzd("TrackGroupArray", "", new IllegalArgumentException("Multiple identical TrackGroups added to one TrackGroupArray."));
                }
            }
            i = i2;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzwi.class == obj.getClass()) {
            zzwi zzwi = (zzwi) obj;
            if (this.zzb != zzwi.zzb || !this.zzc.equals(zzwi.zzc)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzd;
        if (i != 0) {
            return i;
        }
        int hashCode = this.zzc.hashCode();
        this.zzd = hashCode;
        return hashCode;
    }

    public final int zza(zzcd zzcd) {
        int indexOf = this.zzc.indexOf(zzcd);
        if (indexOf >= 0) {
            return indexOf;
        }
        return -1;
    }

    public final zzcd zzb(int i) {
        return (zzcd) this.zzc.get(i);
    }

    public final zzfxr zzc() {
        return zzfxr.zzk(zzfyh.zzb(this.zzc, new zzwh()));
    }
}
