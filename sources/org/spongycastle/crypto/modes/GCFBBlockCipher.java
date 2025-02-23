package org.spongycastle.crypto.modes;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.common.base.Ascii;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.StreamBlockCipher;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.crypto.params.ParametersWithSBox;
import org.spongycastle.util.Arrays;

public class GCFBBlockCipher extends StreamBlockCipher {
    public static final byte[] a = {105, 0, 114, 34, 100, -55, 4, 35, -115, 58, -37, -106, 70, -23, 42, -60, Ascii.CAN, -2, -84, -108, 0, -19, 7, Ascii.DC2, -64, -122, -36, -62, -17, 76, -87, 43};

    /* renamed from: a  reason: collision with other field name */
    public long f6157a = 0;

    /* renamed from: a  reason: collision with other field name */
    public final CFBBlockCipher f6158a;

    /* renamed from: a  reason: collision with other field name */
    public KeyParameter f6159a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f6160a;

    public GCFBBlockCipher(BlockCipher blockCipher) {
        super(blockCipher);
        this.f6158a = new CFBBlockCipher(blockCipher, blockCipher.c() * 8);
    }

    public final void a(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        this.f6157a = 0;
        this.f6158a.a(z, cipherParameters);
        this.f6160a = z;
        if (cipherParameters instanceof ParametersWithIV) {
            cipherParameters = ((ParametersWithIV) cipherParameters).a;
        }
        if (cipherParameters instanceof ParametersWithRandom) {
            cipherParameters = ((ParametersWithRandom) cipherParameters).f6234a;
        }
        if (cipherParameters instanceof ParametersWithSBox) {
            cipherParameters = ((ParametersWithSBox) cipherParameters).a;
        }
        this.f6159a = (KeyParameter) cipherParameters;
    }

    public final String b() {
        String b = this.f6158a.b();
        return b.substring(0, b.indexOf(47)) + "/G" + b.substring(b.indexOf(47) + 1);
    }

    public final int c() {
        return this.f6158a.a;
    }

    public final int e(int i, int i2, byte[] bArr, byte[] bArr2) throws DataLengthException, IllegalStateException {
        CFBBlockCipher cFBBlockCipher = this.f6158a;
        d(bArr, i, cFBBlockCipher.a, bArr2, i2);
        return cFBBlockCipher.a;
    }

    public final byte f(byte b) {
        long j = this.f6157a;
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        CFBBlockCipher cFBBlockCipher = this.f6158a;
        if (i > 0 && j % PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID == 0) {
            BlockCipher blockCipher = cFBBlockCipher.a;
            blockCipher.a(false, this.f6159a);
            byte[] bArr = new byte[32];
            byte[] bArr2 = a;
            blockCipher.e(0, 0, bArr2, bArr);
            blockCipher.e(8, 8, bArr2, bArr);
            blockCipher.e(16, 16, bArr2, bArr);
            blockCipher.e(24, 24, bArr2, bArr);
            KeyParameter keyParameter = new KeyParameter(bArr, 0, 32);
            this.f6159a = keyParameter;
            blockCipher.a(true, keyParameter);
            byte[] c = Arrays.c(cFBBlockCipher.f6149b);
            blockCipher.e(0, 0, c, c);
            cFBBlockCipher.a(this.f6160a, new ParametersWithIV(this.f6159a, c));
        }
        this.f6157a++;
        return cFBBlockCipher.f(b);
    }

    public final void reset() {
        this.f6157a = 0;
        this.f6158a.reset();
    }
}
