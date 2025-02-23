package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzanc extends zzabu {
    public zzanc(zzer zzer, long j, long j2) {
        super(new zzabp(), new zzanb(zzer, (zzana) null), j, 0, j + 1, 0, j2, 188, 1000);
    }

    public static /* bridge */ /* synthetic */ int zzh(byte[] bArr, int i) {
        return (bArr[i + 3] & UnsignedBytes.MAX_VALUE) | ((bArr[i] & UnsignedBytes.MAX_VALUE) << Ascii.CAN) | ((bArr[i + 1] & UnsignedBytes.MAX_VALUE) << Ascii.DLE) | ((bArr[i + 2] & UnsignedBytes.MAX_VALUE) << 8);
    }
}
