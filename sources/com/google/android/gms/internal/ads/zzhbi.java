package com.google.android.gms.internal.ads;

import com.facebook.ads.AdError;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzhbi implements zzgye {
    static final zzgye zza = new zzhbi();

    private zzhbi() {
    }

    public final boolean zza(int i) {
        if (!(i == 0 || i == 1 || i == 2 || i == 1999)) {
            switch (i) {
                case 1000:
                case AdError.NO_FILL_ERROR_CODE:
                case AdError.LOAD_TOO_FREQUENTLY_ERROR_CODE:
                case 1003:
                case 1004:
                case 1005:
                case 1006:
                case 1007:
                case 1008:
                case 1009:
                case 1010:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }
}
