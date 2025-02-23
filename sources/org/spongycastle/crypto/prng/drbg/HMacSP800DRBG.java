package org.spongycastle.crypto.prng.drbg;

import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.Hashtable;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.prng.EntropySource;
import org.spongycastle.util.Arrays;

public class HMacSP800DRBG implements SP80090DRBG {
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public long f6257a;

    /* renamed from: a  reason: collision with other field name */
    public final Mac f6258a;

    /* renamed from: a  reason: collision with other field name */
    public final EntropySource f6259a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f6260a;
    public final byte[] b;

    public HMacSP800DRBG(Mac mac, int i, EntropySource entropySource, byte[] bArr, byte[] bArr2) {
        Hashtable hashtable = Utils.a;
        String b2 = mac.b();
        if (i > ((Integer) Utils.a.get(b2.substring(0, b2.indexOf(RemoteSettings.FORWARD_SLASH_STRING)))).intValue()) {
            throw new IllegalArgumentException("Requested security strength is not supported by the derivation function");
        } else if (entropySource.b() >= i) {
            this.a = i;
            this.f6259a = entropySource;
            this.f6258a = mac;
            byte[] a2 = entropySource.a();
            if (a2.length >= (i + 7) / 8) {
                byte[] j = Arrays.j(a2, bArr2, bArr);
                int e = mac.e();
                this.f6260a = new byte[e];
                byte[] bArr3 = new byte[e];
                this.b = bArr3;
                Arrays.p(bArr3, (byte) 1);
                c(j, (byte) 0);
                if (j != null) {
                    c(j, (byte) 1);
                }
                this.f6257a = 1;
                return;
            }
            throw new IllegalStateException("Insufficient entropy provided by entropy source");
        } else {
            throw new IllegalArgumentException("Not enough entropy for security strength required");
        }
    }

    public final void a() {
        byte[] a2 = this.f6259a.a();
        if (a2.length >= (this.a + 7) / 8) {
            byte[] i = Arrays.i(a2, (byte[]) null);
            c(i, (byte) 0);
            if (i != null) {
                c(i, (byte) 1);
            }
            this.f6257a = 1;
            return;
        }
        throw new IllegalStateException("Insufficient entropy provided by entropy source");
    }

    public final int b(byte[] bArr, boolean z) {
        int length = bArr.length * 8;
        if (length > 262144) {
            throw new IllegalArgumentException("Number of bits per request limited to 262144");
        } else if (this.f6257a > 140737488355328L) {
            return -1;
        } else {
            if (z) {
                a();
            }
            int length2 = bArr.length;
            byte[] bArr2 = new byte[length2];
            int length3 = bArr.length;
            byte[] bArr3 = this.b;
            int length4 = length3 / bArr3.length;
            KeyParameter keyParameter = new KeyParameter(this.f6260a);
            Mac mac = this.f6258a;
            mac.a(keyParameter);
            for (int i = 0; i < length4; i++) {
                mac.update(bArr3, 0, bArr3.length);
                mac.c(0, bArr3);
                System.arraycopy(bArr3, 0, bArr2, bArr3.length * i, bArr3.length);
            }
            if (bArr3.length * length4 < length2) {
                mac.update(bArr3, 0, bArr3.length);
                mac.c(0, bArr3);
                System.arraycopy(bArr3, 0, bArr2, bArr3.length * length4, length2 - (length4 * bArr3.length));
            }
            c((byte[]) null, (byte) 0);
            this.f6257a++;
            System.arraycopy(bArr2, 0, bArr, 0, bArr.length);
            return length;
        }
    }

    public final void c(byte[] bArr, byte b2) {
        byte[] bArr2 = this.f6260a;
        KeyParameter keyParameter = new KeyParameter(bArr2);
        Mac mac = this.f6258a;
        mac.a(keyParameter);
        byte[] bArr3 = this.b;
        mac.update(bArr3, 0, bArr3.length);
        mac.d(b2);
        if (bArr != null) {
            mac.update(bArr, 0, bArr.length);
        }
        mac.c(0, bArr2);
        mac.a(new KeyParameter(bArr2));
        mac.update(bArr3, 0, bArr3.length);
        mac.c(0, bArr3);
    }
}
