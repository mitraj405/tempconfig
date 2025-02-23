package org.spongycastle.pqc.crypto.rainbow;

import java.security.SecureRandom;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.pqc.crypto.MessageSigner;
import org.spongycastle.pqc.crypto.rainbow.util.ComputeInField;

public class RainbowSigner implements MessageSigner {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public SecureRandom f6739a;

    /* renamed from: a  reason: collision with other field name */
    public RainbowKeyParameters f6740a;

    /* renamed from: a  reason: collision with other field name */
    public final ComputeInField f6741a = new ComputeInField();

    /* renamed from: a  reason: collision with other field name */
    public short[] f6742a;

    public final void a(boolean z, CipherParameters cipherParameters) {
        if (!z) {
            this.f6740a = (RainbowPublicKeyParameters) cipherParameters;
        } else if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.f6739a = parametersWithRandom.a;
            this.f6740a = (RainbowPrivateKeyParameters) parametersWithRandom.f6234a;
        } else {
            this.f6739a = new SecureRandom();
            this.f6740a = (RainbowPrivateKeyParameters) cipherParameters;
        }
        this.a = this.f6740a.c;
    }

    public final short[] b(Layer[] layerArr, short[] sArr) {
        short[] sArr2 = new short[sArr.length];
        short[] sArr3 = ((RainbowPrivateKeyParameters) this.f6740a).f6735a;
        this.f6741a.getClass();
        short[] h = ComputeInField.h(((RainbowPrivateKeyParameters) this.f6740a).f6736a, ComputeInField.b(sArr3, sArr));
        for (int i = 0; i < layerArr[0].a; i++) {
            this.f6742a[i] = (short) this.f6739a.nextInt();
            short[] sArr4 = this.f6742a;
            sArr4[i] = (short) (sArr4[i] & 255);
        }
        return h;
    }
}
