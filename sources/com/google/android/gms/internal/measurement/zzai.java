package com.google.android.gms.internal.measurement;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@22.0.2 */
public final class zzai implements zzaq {
    private final Double zza;

    public zzai(Double d) {
        if (d == null) {
            this.zza = Double.valueOf(Double.NaN);
        } else {
            this.zza = d;
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzai)) {
            return false;
        }
        return this.zza.equals(((zzai) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final String toString() {
        return zzf();
    }

    public final zzaq zza(String str, zzh zzh, List<zzaq> list) {
        if ("toString".equals(str)) {
            return new zzas(zzf());
        }
        throw new IllegalArgumentException(String.format("%s.%s is not a function.", new Object[]{zzf(), str}));
    }

    public final zzaq zzc() {
        return new zzai(this.zza);
    }

    public final Boolean zzd() {
        boolean z;
        if (Double.isNaN(this.zza.doubleValue()) || this.zza.doubleValue() == 0.0d) {
            z = false;
        } else {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    public final Double zze() {
        return this.zza;
    }

    public final String zzf() {
        BigDecimal bigDecimal;
        int i;
        if (Double.isNaN(this.zza.doubleValue())) {
            return "NaN";
        }
        if (!Double.isInfinite(this.zza.doubleValue())) {
            BigDecimal valueOf = BigDecimal.valueOf(this.zza.doubleValue());
            if (valueOf.signum() == 0) {
                bigDecimal = new BigDecimal(BigInteger.ZERO, 0);
            } else {
                bigDecimal = valueOf.stripTrailingZeros();
            }
            DecimalFormat decimalFormat = new DecimalFormat("0E0");
            decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
            if (bigDecimal.scale() > 0) {
                i = bigDecimal.precision();
            } else {
                i = bigDecimal.scale();
            }
            decimalFormat.setMinimumFractionDigits(i - 1);
            String format = decimalFormat.format(bigDecimal);
            int indexOf = format.indexOf("E");
            if (indexOf <= 0) {
                return format;
            }
            int z = xx.z(indexOf, 1, format);
            if ((z >= 0 || z <= -7) && (z < 0 || z >= 21)) {
                return format.replace("E-", "e-").replace("E", "e+");
            }
            return bigDecimal.toPlainString();
        } else if (this.zza.doubleValue() > 0.0d) {
            return "Infinity";
        } else {
            return "-Infinity";
        }
    }

    public final Iterator<zzaq> zzh() {
        return null;
    }
}
