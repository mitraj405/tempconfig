package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import com.google.firebase.perf.util.Constants;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzqx extends zzcu {
    private int zzd;
    private boolean zze;
    private int zzf;
    private long zzg;
    private int zzh = 0;
    private byte[] zzi;
    private int zzj = 0;
    private int zzk = 0;
    private byte[] zzl;

    public zzqx() {
        byte[] bArr = zzet.zzf;
        this.zzi = bArr;
        this.zzl = bArr;
    }

    private final int zzq(int i) {
        boolean z = true;
        int zzr = ((zzr(2000000) - this.zzh) * this.zzd) - (this.zzi.length >> 1);
        if (zzr < 0) {
            z = false;
        }
        zzdi.zzf(z);
        int i2 = this.zzd;
        return (((int) Math.min((((float) i) * 0.2f) + 0.5f, (float) zzr)) / i2) * i2;
    }

    private final int zzr(long j) {
        return (int) ((j * ((long) this.zzb.zzb)) / 1000000);
    }

    private static int zzs(byte b, byte b2) {
        return (b << 8) | (b2 & UnsignedBytes.MAX_VALUE);
    }

    private final void zzt(boolean z) {
        int i;
        int i2;
        boolean z2;
        boolean z3;
        int i3 = this.zzk;
        int length = this.zzi.length;
        boolean z4 = true;
        if (i3 != length) {
            if (z) {
                z = true;
            } else {
                return;
            }
        }
        if (this.zzh == 0) {
            if (z) {
                zzu(i3, 3);
                i = i3;
            } else {
                if (i3 >= (length >> 1)) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                zzdi.zzf(z3);
                i = this.zzi.length >> 1;
                zzu(i, 0);
            }
            i2 = i;
        } else {
            int i4 = length >> 1;
            int i5 = i3 - i4;
            if (z) {
                int zzq = zzq(i5) + (this.zzi.length >> 1);
                zzu(zzq, 2);
                int i6 = i4 + i5;
                i2 = zzq;
                i = i6;
            } else {
                int zzq2 = zzq(i5);
                zzu(zzq2, 1);
                i2 = zzq2;
                i = i5;
            }
        }
        if (i % this.zzd == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        zzdi.zzg(z2, "bytesConsumed is not aligned to frame size: %s" + i);
        if (i3 < i2) {
            z4 = false;
        }
        zzdi.zzf(z4);
        this.zzk -= i;
        int i7 = this.zzj + i;
        this.zzj = i7;
        this.zzj = i7 % this.zzi.length;
        int i8 = this.zzh;
        int i9 = this.zzd;
        this.zzh = (i2 / i9) + i8;
        this.zzg += (long) ((i - i2) / i9);
    }

    private final void zzu(int i, int i2) {
        boolean z;
        boolean z2;
        boolean z3;
        int i3;
        if (i != 0) {
            boolean z4 = true;
            if (this.zzk >= i) {
                z = true;
            } else {
                z = false;
            }
            zzdi.zzd(z);
            if (i2 == 2) {
                int i4 = this.zzj;
                int i5 = this.zzk;
                int i6 = i4 + i5;
                byte[] bArr = this.zzi;
                int length = bArr.length;
                if (i6 <= length) {
                    System.arraycopy(bArr, i6 - i, this.zzl, 0, i);
                } else {
                    int i7 = i5 - (length - i4);
                    if (i7 >= i) {
                        System.arraycopy(bArr, i7 - i, this.zzl, 0, i);
                    } else {
                        int i8 = i - i7;
                        System.arraycopy(bArr, length - i8, this.zzl, 0, i8);
                        System.arraycopy(this.zzi, 0, this.zzl, i8, i7);
                    }
                }
            } else {
                int i9 = this.zzj;
                int i10 = i9 + i;
                byte[] bArr2 = this.zzi;
                int length2 = bArr2.length;
                if (i10 <= length2) {
                    System.arraycopy(bArr2, i9, this.zzl, 0, i);
                } else {
                    int i11 = length2 - i9;
                    System.arraycopy(bArr2, i9, this.zzl, 0, i11);
                    System.arraycopy(this.zzi, 0, this.zzl, i11, i - i11);
                }
            }
            if (i % this.zzd == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            zzdi.zze(z2, "sizeToOutput is not aligned to frame size: " + i);
            if (this.zzj < this.zzi.length) {
                z3 = true;
            } else {
                z3 = false;
            }
            zzdi.zzf(z3);
            byte[] bArr3 = this.zzl;
            int i12 = i % this.zzd;
            String h = lf.h("byteOutput size is not aligned to frame size ", i);
            if (i12 != 0) {
                z4 = false;
            }
            zzdi.zze(z4, h);
            if (i2 != 3) {
                for (int i13 = 0; i13 < i; i13 += 2) {
                    int i14 = i13 + 1;
                    int zzs = zzs(bArr3[i14], bArr3[i13]);
                    if (i2 == 0) {
                        i3 = ((((i13 * 1000) / (i - 1)) * -90) / 1000) + 100;
                    } else {
                        i3 = 10;
                        if (i2 == 2) {
                            i3 = 10 + (((90000 * i13) / (i - 1)) / 1000);
                        }
                    }
                    int i15 = (zzs * i3) / 100;
                    if (i15 >= 32767) {
                        bArr3[i13] = -1;
                        bArr3[i14] = Ascii.DEL;
                    } else if (i15 <= -32768) {
                        bArr3[i13] = 0;
                        bArr3[i14] = UnsignedBytes.MAX_POWER_OF_TWO;
                    } else {
                        bArr3[i13] = (byte) (i15 & Constants.MAX_HOST_LENGTH);
                        bArr3[i14] = (byte) (i15 >> 8);
                    }
                }
            }
            zzj(i).put(bArr3, 0, i).flip();
        }
    }

    private static final boolean zzv(byte b, byte b2) {
        if (Math.abs(zzs(b, b2)) > 1024) {
            return true;
        }
        return false;
    }

    public final void zze(ByteBuffer byteBuffer) {
        int position;
        boolean z;
        int limit;
        int i;
        boolean z2;
        while (byteBuffer.hasRemaining() && !zzn()) {
            boolean z3 = true;
            if (this.zzf != 0) {
                if (this.zzj < this.zzi.length) {
                    z = true;
                } else {
                    z = false;
                }
                zzdi.zzf(z);
                int limit2 = byteBuffer.limit();
                int position2 = byteBuffer.position() + 1;
                while (true) {
                    if (position2 >= byteBuffer.limit()) {
                        limit = byteBuffer.limit();
                        break;
                    } else if (zzv(byteBuffer.get(position2), byteBuffer.get(position2 - 1))) {
                        int i2 = this.zzd;
                        limit = (position2 / i2) * i2;
                        break;
                    } else {
                        position2 += 2;
                    }
                }
                int position3 = limit - byteBuffer.position();
                int i3 = this.zzj;
                int i4 = this.zzk;
                int i5 = i3 + i4;
                int length = this.zzi.length;
                if (i5 < length) {
                    i = length - i5;
                } else {
                    i5 = i4 - (length - i3);
                    i = i3 - i5;
                }
                int min = Math.min(position3, i);
                byteBuffer.limit(byteBuffer.position() + min);
                byteBuffer.get(this.zzi, i5, min);
                int i6 = this.zzk + min;
                this.zzk = i6;
                if (i6 <= this.zzi.length) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                zzdi.zzf(z2);
                if (limit >= limit2 || position3 >= i) {
                    z3 = false;
                }
                zzt(z3);
                if (z3) {
                    this.zzf = 0;
                    this.zzh = 0;
                }
                byteBuffer.limit(limit2);
            } else {
                int limit3 = byteBuffer.limit();
                byteBuffer.limit(Math.min(limit3, byteBuffer.position() + this.zzi.length));
                int limit4 = byteBuffer.limit() - 1;
                while (true) {
                    if (limit4 < byteBuffer.position()) {
                        position = byteBuffer.position();
                        break;
                    } else if (zzv(byteBuffer.get(limit4), byteBuffer.get(limit4 - 1))) {
                        int i7 = this.zzd;
                        position = ((limit4 / i7) * i7) + i7;
                        break;
                    } else {
                        limit4 -= 2;
                    }
                }
                if (position == byteBuffer.position()) {
                    this.zzf = 1;
                } else {
                    byteBuffer.limit(Math.min(position, byteBuffer.capacity()));
                    zzj(byteBuffer.remaining()).put(byteBuffer).flip();
                }
                byteBuffer.limit(limit3);
            }
        }
    }

    public final boolean zzg() {
        if (!super.zzg() || !this.zze) {
            return false;
        }
        return true;
    }

    public final zzcr zzi(zzcr zzcr) throws zzcs {
        if (zzcr.zzd != 2) {
            throw new zzcs("Unhandled input format:", zzcr);
        } else if (zzcr.zzb == -1) {
            return zzcr.zza;
        } else {
            return zzcr;
        }
    }

    public final void zzk() {
        if (zzg()) {
            int i = this.zzb.zzc;
            this.zzd = i + i;
            int i2 = this.zzd;
            int zzr = ((zzr(100000) / 2) / i2) * i2;
            int i3 = zzr + zzr;
            if (this.zzi.length != i3) {
                this.zzi = new byte[i3];
                this.zzl = new byte[i3];
            }
        }
        this.zzf = 0;
        this.zzg = 0;
        this.zzh = 0;
        this.zzj = 0;
        this.zzk = 0;
    }

    public final void zzl() {
        if (this.zzk > 0) {
            zzt(true);
            this.zzh = 0;
        }
    }

    public final void zzm() {
        this.zze = false;
        byte[] bArr = zzet.zzf;
        this.zzi = bArr;
        this.zzl = bArr;
    }

    public final long zzo() {
        return this.zzg;
    }

    public final void zzp(boolean z) {
        this.zze = z;
    }
}
