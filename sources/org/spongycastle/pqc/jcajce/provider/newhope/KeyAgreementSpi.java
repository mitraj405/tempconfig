package org.spongycastle.pqc.jcajce.provider.newhope;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.ShortBufferException;
import org.spongycastle.crypto.DerivationFunction;
import org.spongycastle.jcajce.provider.asymmetric.util.BaseAgreementSpi;
import org.spongycastle.pqc.crypto.ExchangePair;
import org.spongycastle.pqc.crypto.newhope.NHAgreement;
import org.spongycastle.pqc.crypto.newhope.NHExchangePairGenerator;
import org.spongycastle.pqc.crypto.newhope.NHPublicKeyParameters;
import org.spongycastle.util.Arrays;

public class KeyAgreementSpi extends BaseAgreementSpi {
    public NHAgreement a;

    /* renamed from: a  reason: collision with other field name */
    public NHExchangePairGenerator f6813a;
    public byte[] b;

    public KeyAgreementSpi() {
        super("NH", (DerivationFunction) null);
    }

    public final byte[] a() {
        return engineGenerateSecret();
    }

    public final Key engineDoPhase(Key key, boolean z) throws InvalidKeyException, IllegalStateException {
        if (z) {
            BCNHPublicKey bCNHPublicKey = (BCNHPublicKey) key;
            NHExchangePairGenerator nHExchangePairGenerator = this.f6813a;
            if (nHExchangePairGenerator != null) {
                ExchangePair a2 = nHExchangePairGenerator.a(bCNHPublicKey.a);
                this.b = Arrays.c(a2.f6659a);
                return new BCNHPublicKey((NHPublicKeyParameters) a2.a);
            }
            this.b = this.a.a(bCNHPublicKey.a);
            return null;
        }
        throw new IllegalStateException("NewHope can only be between two parties.");
    }

    public final byte[] engineGenerateSecret() throws IllegalStateException {
        byte[] c = Arrays.c(this.b);
        Arrays.p(this.b, (byte) 0);
        return c;
    }

    public final void engineInit(Key key, SecureRandom secureRandom) throws InvalidKeyException {
        if (key != null) {
            NHAgreement nHAgreement = new NHAgreement();
            this.a = nHAgreement;
            nHAgreement.a = ((BCNHPrivateKey) key).a;
            return;
        }
        this.f6813a = new NHExchangePairGenerator(secureRandom);
    }

    public final int engineGenerateSecret(byte[] bArr, int i) throws IllegalStateException, ShortBufferException {
        byte[] bArr2 = this.b;
        System.arraycopy(bArr2, 0, bArr, i, bArr2.length);
        Arrays.p(this.b, (byte) 0);
        return this.b.length;
    }

    public final void engineInit(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        throw new InvalidAlgorithmParameterException("NewHope does not require parameters");
    }
}
