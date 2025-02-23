package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzqy extends zzcu {
    private static final int zzd = Float.floatToIntBits(Float.NaN);

    private static void zzo(int i, ByteBuffer byteBuffer) {
        int floatToIntBits = Float.floatToIntBits((float) (((double) i) * 4.656612875245797E-10d));
        if (floatToIntBits == zzd) {
            floatToIntBits = Float.floatToIntBits(0.0f);
        }
        byteBuffer.putInt(floatToIntBits);
    }

    public final void zze(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i = limit - position;
        int i2 = this.zzb.zzd;
        if (i2 == 21) {
            byteBuffer2 = zzj((i / 3) * 4);
            while (position < limit) {
                zzo(((byteBuffer.get(position) & UnsignedBytes.MAX_VALUE) << 8) | ((byteBuffer.get(position + 1) & UnsignedBytes.MAX_VALUE) << Ascii.DLE) | ((byteBuffer.get(position + 2) & UnsignedBytes.MAX_VALUE) << Ascii.CAN), byteBuffer2);
                position += 3;
            }
        } else if (i2 == 22) {
            byteBuffer2 = zzj(i);
            while (position < limit) {
                zzo((byteBuffer.get(position) & UnsignedBytes.MAX_VALUE) | ((byteBuffer.get(position + 1) & UnsignedBytes.MAX_VALUE) << 8) | ((byteBuffer.get(position + 2) & UnsignedBytes.MAX_VALUE) << Ascii.DLE) | ((byteBuffer.get(position + 3) & UnsignedBytes.MAX_VALUE) << Ascii.CAN), byteBuffer2);
                position += 4;
            }
        } else if (i2 == 1342177280) {
            byteBuffer2 = zzj((i / 3) * 4);
            while (position < limit) {
                zzo(((byteBuffer.get(position + 2) & UnsignedBytes.MAX_VALUE) << 8) | ((byteBuffer.get(position + 1) & UnsignedBytes.MAX_VALUE) << Ascii.DLE) | ((byteBuffer.get(position) & UnsignedBytes.MAX_VALUE) << Ascii.CAN), byteBuffer2);
                position += 3;
            }
        } else if (i2 == 1610612736) {
            byteBuffer2 = zzj(i);
            while (position < limit) {
                zzo((byteBuffer.get(position + 3) & UnsignedBytes.MAX_VALUE) | ((byteBuffer.get(position + 2) & UnsignedBytes.MAX_VALUE) << 8) | ((byteBuffer.get(position + 1) & UnsignedBytes.MAX_VALUE) << Ascii.DLE) | ((byteBuffer.get(position) & UnsignedBytes.MAX_VALUE) << Ascii.CAN), byteBuffer2);
                position += 4;
            }
        } else {
            throw new IllegalStateException();
        }
        byteBuffer.position(byteBuffer.limit());
        byteBuffer2.flip();
    }

    public final zzcr zzi(zzcr zzcr) throws zzcs {
        int i = zzcr.zzd;
        int i2 = zzet.zza;
        if (i == 21 || i == 1342177280 || i == 22 || i == 1610612736) {
            return new zzcr(zzcr.zzb, zzcr.zzc, 4);
        }
        if (i == 4) {
            return zzcr.zza;
        }
        throw new zzcs("Unhandled input format:", zzcr);
    }
}
