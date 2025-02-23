package com.google.android.gms.internal.ads;

import android.content.Context;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.facebook.ads.AdError;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzxi extends zzci {
    public final boolean zzC;
    public final boolean zzD;
    public final boolean zzE;
    public final boolean zzF;
    public final boolean zzG;
    public final boolean zzH;
    public final boolean zzI;
    public final boolean zzJ;
    public final boolean zzK;
    public final boolean zzL;
    public final boolean zzM;
    public final boolean zzN;
    public final boolean zzO;
    public final boolean zzP;
    public final boolean zzQ;
    /* access modifiers changed from: private */
    public final SparseArray zzR;
    /* access modifiers changed from: private */
    public final SparseBooleanArray zzS;

    static {
        new zzxi(new zzxg());
        Integer.toString(1000, 36);
        Integer.toString(AdError.NO_FILL_ERROR_CODE, 36);
        Integer.toString(AdError.LOAD_TOO_FREQUENTLY_ERROR_CODE, 36);
        Integer.toString(1003, 36);
        Integer.toString(1004, 36);
        Integer.toString(1005, 36);
        Integer.toString(1006, 36);
        Integer.toString(1007, 36);
        Integer.toString(1008, 36);
        Integer.toString(1009, 36);
        Integer.toString(1010, 36);
        Integer.toString(1011, 36);
        Integer.toString(1012, 36);
        Integer.toString(1013, 36);
        Integer.toString(1014, 36);
        Integer.toString(1015, 36);
        Integer.toString(1016, 36);
        Integer.toString(1017, 36);
        Integer.toString(1018, 36);
    }

    public static zzxi zzd(Context context) {
        return new zzxi(new zzxg(context));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzxi.class == obj.getClass()) {
            zzxi zzxi = (zzxi) obj;
            if (super.equals(zzxi) && this.zzC == zzxi.zzC && this.zzE == zzxi.zzE && this.zzG == zzxi.zzG && this.zzL == zzxi.zzL && this.zzM == zzxi.zzM && this.zzN == zzxi.zzN && this.zzP == zzxi.zzP) {
                SparseBooleanArray sparseBooleanArray = this.zzS;
                SparseBooleanArray sparseBooleanArray2 = zzxi.zzS;
                int size = sparseBooleanArray.size();
                if (sparseBooleanArray2.size() == size) {
                    int i = 0;
                    while (true) {
                        if (i >= size) {
                            SparseArray sparseArray = this.zzR;
                            SparseArray sparseArray2 = zzxi.zzR;
                            int size2 = sparseArray.size();
                            if (sparseArray2.size() == size2) {
                                int i2 = 0;
                                while (i2 < size2) {
                                    int indexOfKey = sparseArray2.indexOfKey(sparseArray.keyAt(i2));
                                    if (indexOfKey >= 0) {
                                        Map map = (Map) sparseArray.valueAt(i2);
                                        Map map2 = (Map) sparseArray2.valueAt(indexOfKey);
                                        if (map2.size() == map.size()) {
                                            for (Map.Entry entry : map.entrySet()) {
                                                zzwi zzwi = (zzwi) entry.getKey();
                                                if (map2.containsKey(zzwi)) {
                                                    if (!zzet.zzG(entry.getValue(), map2.get(zzwi))) {
                                                    }
                                                }
                                            }
                                            i2++;
                                        }
                                    }
                                }
                                return true;
                            }
                        } else if (sparseBooleanArray2.indexOfKey(sparseBooleanArray.keyAt(i)) < 0) {
                            break;
                        } else {
                            i++;
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((((((((((((((super.hashCode() + 31) * 31) + (this.zzC ? 1 : 0)) * 961) + (this.zzE ? 1 : 0)) * 961) + (this.zzG ? 1 : 0)) * 28629151) + (this.zzL ? 1 : 0)) * 31) + (this.zzM ? 1 : 0)) * 31) + (this.zzN ? 1 : 0)) * 961) + (this.zzP ? 1 : 0)) * 31;
    }

    public final zzxg zzc() {
        return new zzxg(this, (zzxf) null);
    }

    @Deprecated
    public final zzxj zze(int i, zzwi zzwi) {
        Map map = (Map) this.zzR.get(i);
        if (map != null) {
            return (zzxj) map.get(zzwi);
        }
        return null;
    }

    public final boolean zzf(int i) {
        return this.zzS.get(i);
    }

    @Deprecated
    public final boolean zzg(int i, zzwi zzwi) {
        Map map = (Map) this.zzR.get(i);
        if (map == null || !map.containsKey(zzwi)) {
            return false;
        }
        return true;
    }

    private zzxi(zzxg zzxg) {
        super(zzxg);
        this.zzC = zzxg.zza;
        this.zzD = false;
        this.zzE = zzxg.zzb;
        this.zzF = false;
        this.zzG = zzxg.zzc;
        this.zzH = false;
        this.zzI = false;
        this.zzJ = false;
        this.zzK = false;
        this.zzL = zzxg.zzd;
        this.zzM = zzxg.zze;
        this.zzN = zzxg.zzf;
        this.zzO = false;
        this.zzP = zzxg.zzg;
        this.zzQ = false;
        this.zzR = zzxg.zzh;
        this.zzS = zzxg.zzi;
    }
}
