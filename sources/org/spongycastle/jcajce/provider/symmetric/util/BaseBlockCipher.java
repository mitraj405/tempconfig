package org.spongycastle.jcajce.provider.symmetric.util;

import com.google.android.gms.stats.CodePackage;
import java.lang.reflect.Constructor;
import java.nio.ByteBuffer;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.RC5ParameterSpec;
import org.spongycastle.asn1.cms.GCMParameters;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.BufferedBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.engines.DSTU7624Engine;
import org.spongycastle.crypto.modes.AEADBlockCipher;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.modes.CCMBlockCipher;
import org.spongycastle.crypto.modes.CFBBlockCipher;
import org.spongycastle.crypto.modes.CTSBlockCipher;
import org.spongycastle.crypto.modes.EAXBlockCipher;
import org.spongycastle.crypto.modes.GCFBBlockCipher;
import org.spongycastle.crypto.modes.GCMBlockCipher;
import org.spongycastle.crypto.modes.GOFBBlockCipher;
import org.spongycastle.crypto.modes.KCCMBlockCipher;
import org.spongycastle.crypto.modes.KCTRBlockCipher;
import org.spongycastle.crypto.modes.KGCMBlockCipher;
import org.spongycastle.crypto.modes.OCBBlockCipher;
import org.spongycastle.crypto.modes.OFBBlockCipher;
import org.spongycastle.crypto.modes.OpenPGPCFBBlockCipher;
import org.spongycastle.crypto.modes.PGPCFBBlockCipher;
import org.spongycastle.crypto.modes.SICBlockCipher;
import org.spongycastle.crypto.paddings.BlockCipherPadding;
import org.spongycastle.crypto.paddings.ISO10126d2Padding;
import org.spongycastle.crypto.paddings.ISO7816d4Padding;
import org.spongycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.spongycastle.crypto.paddings.TBCPadding;
import org.spongycastle.crypto.paddings.X923Padding;
import org.spongycastle.crypto.paddings.ZeroBytePadding;
import org.spongycastle.crypto.params.AEADParameters;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.jcajce.spec.GOST28147ParameterSpec;
import org.spongycastle.jcajce.util.BCJcaJceHelper;
import org.spongycastle.util.Strings;

public class BaseBlockCipher extends BaseWrapCipher {
    public static final Class a = ClassUtil.a(BaseBlockCipher.class, "javax.crypto.spec.GCMParameterSpec");

    /* renamed from: a  reason: collision with other field name */
    public PBEParameterSpec f6542a;

    /* renamed from: a  reason: collision with other field name */
    public final BlockCipher f6543a;

    /* renamed from: a  reason: collision with other field name */
    public AEADParameters f6544a;

    /* renamed from: a  reason: collision with other field name */
    public ParametersWithIV f6545a;

    /* renamed from: a  reason: collision with other field name */
    public GenericBlockCipher f6546a;

    /* renamed from: a  reason: collision with other field name */
    public final BlockCipherProvider f6547a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f6548a;
    public boolean b;

    /* renamed from: b  reason: collision with other field name */
    public final Class[] f6549b;
    public String c;
    public final int d;

    /* renamed from: d  reason: collision with other field name */
    public String f6550d;
    public final int e;
    public final int f;
    public int g;

    public static class AEADGenericBlockCipher implements GenericBlockCipher {
        public static final Constructor a;

        /* renamed from: a  reason: collision with other field name */
        public final AEADBlockCipher f6551a;

        static {
            Class a2 = ClassUtil.a(BaseBlockCipher.class, "javax.crypto.AEADBadTagException");
            Constructor constructor = null;
            if (a2 != null) {
                try {
                    constructor = a2.getConstructor(new Class[]{String.class});
                } catch (Exception unused) {
                }
                a = constructor;
                return;
            }
            a = null;
        }

        public AEADGenericBlockCipher(AEADBlockCipher aEADBlockCipher) {
            this.f6551a = aEADBlockCipher;
        }

        public final void a(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
            this.f6551a.a(z, cipherParameters);
        }

        public final String b() {
            return this.f6551a.g().b();
        }

        public final int c(int i, byte[] bArr) throws IllegalStateException, BadPaddingException {
            BadPaddingException badPaddingException;
            try {
                return this.f6551a.c(i, bArr);
            } catch (InvalidCipherTextException e) {
                Constructor constructor = a;
                if (constructor != null) {
                    try {
                        badPaddingException = (BadPaddingException) constructor.newInstance(new Object[]{e.getMessage()});
                    } catch (Exception unused) {
                        badPaddingException = null;
                    }
                    if (badPaddingException != null) {
                        throw badPaddingException;
                    }
                }
                throw new BadPaddingException(e.getMessage());
            }
        }

        public final int d(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws DataLengthException {
            return this.f6551a.d(bArr, i, i2, bArr2, i3);
        }

        public final int e(int i) {
            return this.f6551a.e(i);
        }

        public final int f(int i) {
            return this.f6551a.f(i);
        }

        public final BlockCipher g() {
            return this.f6551a.g();
        }

        public final void h(int i, byte[] bArr, int i2) {
            this.f6551a.i(i, bArr, i2);
        }

        public final boolean i() {
            return false;
        }
    }

    public interface GenericBlockCipher {
        void a(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException;

        String b();

        int c(int i, byte[] bArr) throws IllegalStateException, BadPaddingException;

        int d(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws DataLengthException;

        int e(int i);

        int f(int i);

        BlockCipher g();

        void h(int i, byte[] bArr, int i2);

        boolean i();
    }

    public static class InvalidKeyOrParametersException extends InvalidKeyException {
        public final Throwable a;

        public InvalidKeyOrParametersException(String str, Exception exc) {
            super(str);
            this.a = exc;
        }

        public final Throwable getCause() {
            return this.a;
        }
    }

    public BaseBlockCipher(BlockCipher blockCipher) {
        this.f6549b = new Class[]{RC2ParameterSpec.class, RC5ParameterSpec.class, a, GOST28147ParameterSpec.class, IvParameterSpec.class, PBEParameterSpec.class};
        this.e = -1;
        this.g = 0;
        this.b = true;
        this.f6542a = null;
        this.c = null;
        this.f6550d = null;
        this.f6543a = blockCipher;
        this.f6546a = new BufferedGenericBlockCipher(blockCipher);
    }

    public static boolean a(String str) {
        if ("CCM".equals(str) || "EAX".equals(str) || CodePackage.GCM.equals(str) || "OCB".equals(str)) {
            return true;
        }
        return false;
    }

    public final byte[] engineDoFinal(byte[] bArr, int i, int i2) throws IllegalBlockSizeException, BadPaddingException {
        int engineGetOutputSize = engineGetOutputSize(i2);
        byte[] bArr2 = new byte[engineGetOutputSize];
        int d2 = i2 != 0 ? this.f6546a.d(bArr, i, i2, bArr2, 0) : 0;
        try {
            int c2 = d2 + this.f6546a.c(d2, bArr2);
            if (c2 == engineGetOutputSize) {
                return bArr2;
            }
            byte[] bArr3 = new byte[c2];
            System.arraycopy(bArr2, 0, bArr3, 0, c2);
            return bArr3;
        } catch (DataLengthException e2) {
            throw new IllegalBlockSizeException(e2.getMessage());
        }
    }

    public final int engineGetBlockSize() {
        return this.f6543a.c();
    }

    public final byte[] engineGetIV() {
        AEADParameters aEADParameters = this.f6544a;
        if (aEADParameters != null) {
            return aEADParameters.b;
        }
        ParametersWithIV parametersWithIV = this.f6545a;
        if (parametersWithIV != null) {
            return parametersWithIV.f6233a;
        }
        return null;
    }

    public final int engineGetKeySize(Key key) {
        return key.getEncoded().length * 8;
    }

    public final int engineGetOutputSize(int i) {
        return this.f6546a.e(i);
    }

    public final AlgorithmParameters engineGetParameters() {
        if (this.a == null) {
            PBEParameterSpec pBEParameterSpec = this.f6542a;
            BCJcaJceHelper bCJcaJceHelper = this.f6559a;
            if (pBEParameterSpec != null) {
                try {
                    AlgorithmParameters b2 = bCJcaJceHelper.b(this.c);
                    this.a = b2;
                    b2.init(this.f6542a);
                } catch (Exception unused) {
                    return null;
                }
            } else if (this.f6544a != null) {
                try {
                    AlgorithmParameters b3 = bCJcaJceHelper.b(CodePackage.GCM);
                    this.a = b3;
                    AEADParameters aEADParameters = this.f6544a;
                    b3.init(new GCMParameters(aEADParameters.b, aEADParameters.c / 8).e());
                } catch (Exception e2) {
                    throw new RuntimeException(e2.toString());
                }
            } else if (this.f6545a != null) {
                String b4 = this.f6546a.g().b();
                if (b4.indexOf(47) >= 0) {
                    b4 = b4.substring(0, b4.indexOf(47));
                }
                try {
                    AlgorithmParameters b5 = bCJcaJceHelper.b(b4);
                    this.a = b5;
                    b5.init(new IvParameterSpec(this.f6545a.f6233a));
                } catch (Exception e3) {
                    throw new RuntimeException(e3.toString());
                }
            }
        }
        return this.a;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v1, resolved type: org.spongycastle.crypto.params.ParametersWithIV} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: org.spongycastle.crypto.params.KeyParameter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: org.spongycastle.crypto.params.ParametersWithIV} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v4, resolved type: org.spongycastle.crypto.params.ParametersWithIV} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: org.spongycastle.crypto.params.ParametersWithRandom} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: org.spongycastle.crypto.params.ParametersWithIV} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: org.spongycastle.crypto.params.ParametersWithRandom} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v12, resolved type: org.spongycastle.crypto.params.ParametersWithIV} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v30, resolved type: org.spongycastle.crypto.params.ParametersWithRandom} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v47, resolved type: org.spongycastle.crypto.params.ParametersWithSBox} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v42, resolved type: org.spongycastle.crypto.params.ParametersWithSBox} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v11, resolved type: org.spongycastle.crypto.params.ParametersWithSBox} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v51, resolved type: org.spongycastle.crypto.params.ParametersWithSBox} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v53, resolved type: org.spongycastle.crypto.params.ParametersWithSBox} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v60, resolved type: org.spongycastle.crypto.params.ParametersWithRandom} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v61, resolved type: org.spongycastle.crypto.params.ParametersWithRandom} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v62, resolved type: org.spongycastle.crypto.params.ParametersWithRandom} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v63, resolved type: org.spongycastle.crypto.params.KeyParameter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v64, resolved type: org.spongycastle.crypto.params.AEADParameters} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v65, resolved type: org.spongycastle.crypto.params.RC5Parameters} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v66, resolved type: org.spongycastle.crypto.params.RC5Parameters} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v67, resolved type: org.spongycastle.crypto.params.ParametersWithIV} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v68, resolved type: org.spongycastle.crypto.params.AEADParameters} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v73, resolved type: org.spongycastle.crypto.params.KeyParameter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v23, resolved type: org.spongycastle.crypto.params.ParametersWithSBox} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v24, resolved type: org.spongycastle.crypto.params.ParametersWithSBox} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v73, resolved type: org.spongycastle.crypto.params.ParametersWithIV} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v25, resolved type: org.spongycastle.crypto.params.ParametersWithSBox} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v74, resolved type: org.spongycastle.crypto.params.ParametersWithIV} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v26, resolved type: org.spongycastle.crypto.params.ParametersWithSBox} */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:271:0x0557 A[Catch:{ Exception -> 0x0574 }] */
    /* JADX WARNING: Removed duplicated region for block: B:280:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void engineInit(int r22, java.security.Key r23, java.security.spec.AlgorithmParameterSpec r24, java.security.SecureRandom r25) throws java.security.InvalidKeyException, java.security.InvalidAlgorithmParameterException {
        /*
            r21 = this;
            r1 = r21
            r0 = r22
            r2 = r23
            r3 = r24
            r4 = r25
            java.lang.String r5 = "unknown opmode "
            r6 = 0
            r1.f6542a = r6
            r1.c = r6
            r1.a = r6
            r1.f6544a = r6
            boolean r7 = r2 instanceof javax.crypto.SecretKey
            if (r7 != 0) goto L_0x0032
            java.security.InvalidKeyException r0 = new java.security.InvalidKeyException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Key for algorithm "
            r3.<init>(r4)
            if (r2 == 0) goto L_0x0028
            java.lang.String r6 = r23.getAlgorithm()
        L_0x0028:
            java.lang.String r2 = " not suitable for symmetric enryption."
            java.lang.String r2 = defpackage.C0709Uj.j(r3, r6, r2)
            r0.<init>(r2)
            throw r0
        L_0x0032:
            java.lang.String r7 = "RC5-64"
            org.spongycastle.crypto.BlockCipher r8 = r1.f6543a
            if (r3 != 0) goto L_0x004b
            java.lang.String r9 = r8.b()
            boolean r9 = r9.startsWith(r7)
            if (r9 != 0) goto L_0x0043
            goto L_0x004b
        L_0x0043:
            java.security.InvalidAlgorithmParameterException r0 = new java.security.InvalidAlgorithmParameterException
            java.lang.String r2 = "RC5 requires an RC5ParametersSpec to be passed in."
            r0.<init>(r2)
            throw r0
        L_0x004b:
            r9 = 2
            r10 = 4
            java.lang.String r11 = "Algorithm requires a PBE key"
            r12 = 1
            int r13 = r1.e
            if (r13 == r9) goto L_0x01e0
            boolean r9 = r2 instanceof org.spongycastle.jcajce.PKCS12Key
            if (r9 == 0) goto L_0x005a
            goto L_0x01e0
        L_0x005a:
            boolean r9 = r2 instanceof org.spongycastle.jcajce.PBKDF1Key
            if (r9 == 0) goto L_0x00ae
            r9 = r2
            org.spongycastle.jcajce.PBKDF1Key r9 = (org.spongycastle.jcajce.PBKDF1Key) r9
            boolean r10 = r3 instanceof javax.crypto.spec.PBEParameterSpec
            if (r10 == 0) goto L_0x006a
            r10 = r3
            javax.crypto.spec.PBEParameterSpec r10 = (javax.crypto.spec.PBEParameterSpec) r10
            r1.f6542a = r10
        L_0x006a:
            boolean r10 = r9 instanceof org.spongycastle.jcajce.PBKDF1KeyWithParameters
            if (r10 == 0) goto L_0x0084
            javax.crypto.spec.PBEParameterSpec r10 = r1.f6542a
            if (r10 != 0) goto L_0x0084
            javax.crypto.spec.PBEParameterSpec r10 = new javax.crypto.spec.PBEParameterSpec
            r11 = r9
            org.spongycastle.jcajce.PBKDF1KeyWithParameters r11 = (org.spongycastle.jcajce.PBKDF1KeyWithParameters) r11
            byte[] r13 = r11.getSalt()
            int r11 = r11.getIterationCount()
            r10.<init>(r13, r11)
            r1.f6542a = r10
        L_0x0084:
            byte[] r14 = r9.getEncoded()
            r15 = 0
            int r9 = r1.f
            int r10 = r1.d
            int r11 = r1.g
            int r18 = r11 * 8
            javax.crypto.spec.PBEParameterSpec r11 = r1.f6542a
            org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher$GenericBlockCipher r13 = r1.f6546a
            java.lang.String r20 = r13.b()
            r16 = r9
            r17 = r10
            r19 = r11
            org.spongycastle.crypto.CipherParameters r9 = org.spongycastle.jcajce.provider.symmetric.util.PBE.Util.f(r14, r15, r16, r17, r18, r19, r20)
            boolean r10 = r9 instanceof org.spongycastle.crypto.params.ParametersWithIV
            if (r10 == 0) goto L_0x027f
            r10 = r9
            org.spongycastle.crypto.params.ParametersWithIV r10 = (org.spongycastle.crypto.params.ParametersWithIV) r10
            r1.f6545a = r10
            goto L_0x027f
        L_0x00ae:
            boolean r9 = r2 instanceof org.spongycastle.jcajce.provider.symmetric.util.BCPBEKey
            if (r9 == 0) goto L_0x0173
            r9 = r2
            org.spongycastle.jcajce.provider.symmetric.util.BCPBEKey r9 = (org.spongycastle.jcajce.provider.symmetric.util.BCPBEKey) r9
            org.spongycastle.asn1.ASN1ObjectIdentifier r10 = r9.Z0
            if (r10 == 0) goto L_0x00be
            java.lang.String r10 = r10.c
            r1.c = r10
            goto L_0x00c4
        L_0x00be:
            java.lang.String r10 = r9.getAlgorithm()
            r1.c = r10
        L_0x00c4:
            org.spongycastle.crypto.CipherParameters r10 = r9.f6539a
            if (r10 == 0) goto L_0x0149
            boolean r9 = r10 instanceof org.spongycastle.crypto.params.ParametersWithIV
            if (r9 == 0) goto L_0x010f
            r9 = r10
            org.spongycastle.crypto.params.ParametersWithIV r9 = (org.spongycastle.crypto.params.ParametersWithIV) r9
            boolean r11 = r3 instanceof javax.crypto.spec.IvParameterSpec
            org.spongycastle.crypto.CipherParameters r9 = r9.a
            if (r11 == 0) goto L_0x00e5
            r10 = r3
            javax.crypto.spec.IvParameterSpec r10 = (javax.crypto.spec.IvParameterSpec) r10
            org.spongycastle.crypto.params.ParametersWithIV r11 = new org.spongycastle.crypto.params.ParametersWithIV
            byte[] r10 = r10.getIV()
            r11.<init>(r9, r10)
            r1.f6545a = r11
        L_0x00e3:
            r10 = r11
            goto L_0x0147
        L_0x00e5:
            boolean r11 = r3 instanceof org.spongycastle.jcajce.spec.GOST28147ParameterSpec
            if (r11 == 0) goto L_0x0147
            r11 = r3
            org.spongycastle.jcajce.spec.GOST28147ParameterSpec r11 = (org.spongycastle.jcajce.spec.GOST28147ParameterSpec) r11
            org.spongycastle.crypto.params.ParametersWithSBox r13 = new org.spongycastle.crypto.params.ParametersWithSBox
            byte[] r14 = r11.b
            byte[] r14 = org.spongycastle.util.Arrays.c(r14)
            r13.<init>(r10, r14)
            byte[] r10 = r11.a()
            if (r10 == 0) goto L_0x010d
            int r10 = r1.g
            if (r10 == 0) goto L_0x010d
            org.spongycastle.crypto.params.ParametersWithIV r10 = new org.spongycastle.crypto.params.ParametersWithIV
            byte[] r11 = r11.a()
            r10.<init>(r9, r11)
            r1.f6545a = r10
            goto L_0x0147
        L_0x010d:
            r10 = r13
            goto L_0x0147
        L_0x010f:
            boolean r9 = r3 instanceof javax.crypto.spec.IvParameterSpec
            if (r9 == 0) goto L_0x0122
            r9 = r3
            javax.crypto.spec.IvParameterSpec r9 = (javax.crypto.spec.IvParameterSpec) r9
            org.spongycastle.crypto.params.ParametersWithIV r11 = new org.spongycastle.crypto.params.ParametersWithIV
            byte[] r9 = r9.getIV()
            r11.<init>(r10, r9)
            r1.f6545a = r11
            goto L_0x00e3
        L_0x0122:
            boolean r9 = r3 instanceof org.spongycastle.jcajce.spec.GOST28147ParameterSpec
            if (r9 == 0) goto L_0x0147
            r9 = r3
            org.spongycastle.jcajce.spec.GOST28147ParameterSpec r9 = (org.spongycastle.jcajce.spec.GOST28147ParameterSpec) r9
            org.spongycastle.crypto.params.ParametersWithSBox r11 = new org.spongycastle.crypto.params.ParametersWithSBox
            byte[] r13 = r9.b
            byte[] r13 = org.spongycastle.util.Arrays.c(r13)
            r11.<init>(r10, r13)
            byte[] r10 = r9.a()
            if (r10 == 0) goto L_0x00e3
            int r10 = r1.g
            if (r10 == 0) goto L_0x00e3
            org.spongycastle.crypto.params.ParametersWithIV r10 = new org.spongycastle.crypto.params.ParametersWithIV
            byte[] r9 = r9.a()
            r10.<init>(r11, r9)
        L_0x0147:
            r9 = r10
            goto L_0x0160
        L_0x0149:
            boolean r10 = r3 instanceof javax.crypto.spec.PBEParameterSpec
            if (r10 == 0) goto L_0x016b
            r10 = r3
            javax.crypto.spec.PBEParameterSpec r10 = (javax.crypto.spec.PBEParameterSpec) r10
            r1.f6542a = r10
            org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher$GenericBlockCipher r10 = r1.f6546a
            org.spongycastle.crypto.BlockCipher r10 = r10.g()
            java.lang.String r10 = r10.b()
            org.spongycastle.crypto.CipherParameters r9 = org.spongycastle.jcajce.provider.symmetric.util.PBE.Util.e(r9, r3, r10)
        L_0x0160:
            boolean r10 = r9 instanceof org.spongycastle.crypto.params.ParametersWithIV
            if (r10 == 0) goto L_0x027f
            r10 = r9
            org.spongycastle.crypto.params.ParametersWithIV r10 = (org.spongycastle.crypto.params.ParametersWithIV) r10
            r1.f6545a = r10
            goto L_0x027f
        L_0x016b:
            java.security.InvalidAlgorithmParameterException r0 = new java.security.InvalidAlgorithmParameterException
            java.lang.String r2 = "PBE requires PBE parameters to be set."
            r0.<init>(r2)
            throw r0
        L_0x0173:
            boolean r9 = r2 instanceof javax.crypto.interfaces.PBEKey
            if (r9 == 0) goto L_0x01bf
            r9 = r2
            javax.crypto.interfaces.PBEKey r9 = (javax.crypto.interfaces.PBEKey) r9
            r10 = r3
            javax.crypto.spec.PBEParameterSpec r10 = (javax.crypto.spec.PBEParameterSpec) r10
            r1.f6542a = r10
            boolean r11 = r9 instanceof org.spongycastle.jcajce.PKCS12KeyWithParameters
            if (r11 == 0) goto L_0x0194
            if (r10 != 0) goto L_0x0194
            javax.crypto.spec.PBEParameterSpec r10 = new javax.crypto.spec.PBEParameterSpec
            byte[] r11 = r9.getSalt()
            int r13 = r9.getIterationCount()
            r10.<init>(r11, r13)
            r1.f6542a = r10
        L_0x0194:
            byte[] r14 = r9.getEncoded()
            int r15 = r1.e
            int r9 = r1.f
            int r10 = r1.d
            int r11 = r1.g
            int r18 = r11 * 8
            javax.crypto.spec.PBEParameterSpec r11 = r1.f6542a
            org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher$GenericBlockCipher r13 = r1.f6546a
            java.lang.String r20 = r13.b()
            r16 = r9
            r17 = r10
            r19 = r11
            org.spongycastle.crypto.CipherParameters r9 = org.spongycastle.jcajce.provider.symmetric.util.PBE.Util.f(r14, r15, r16, r17, r18, r19, r20)
            boolean r10 = r9 instanceof org.spongycastle.crypto.params.ParametersWithIV
            if (r10 == 0) goto L_0x027f
            r10 = r9
            org.spongycastle.crypto.params.ParametersWithIV r10 = (org.spongycastle.crypto.params.ParametersWithIV) r10
            r1.f6545a = r10
            goto L_0x027f
        L_0x01bf:
            boolean r9 = r2 instanceof org.spongycastle.jcajce.spec.RepeatedSecretKeySpec
            if (r9 != 0) goto L_0x01dd
            if (r13 == 0) goto L_0x01d7
            if (r13 == r10) goto L_0x01d7
            if (r13 == r12) goto L_0x01d7
            r9 = 5
            if (r13 == r9) goto L_0x01d7
            org.spongycastle.crypto.params.KeyParameter r9 = new org.spongycastle.crypto.params.KeyParameter
            byte[] r10 = r23.getEncoded()
            r9.<init>(r10)
            goto L_0x027f
        L_0x01d7:
            java.security.InvalidKeyException r0 = new java.security.InvalidKeyException
            r0.<init>(r11)
            throw r0
        L_0x01dd:
            r9 = r6
            goto L_0x027f
        L_0x01e0:
            r9 = r2
            javax.crypto.SecretKey r9 = (javax.crypto.SecretKey) r9     // Catch:{ Exception -> 0x057f }
            boolean r10 = r3 instanceof javax.crypto.spec.PBEParameterSpec
            if (r10 == 0) goto L_0x01ec
            r10 = r3
            javax.crypto.spec.PBEParameterSpec r10 = (javax.crypto.spec.PBEParameterSpec) r10
            r1.f6542a = r10
        L_0x01ec:
            boolean r10 = r9 instanceof javax.crypto.interfaces.PBEKey
            if (r10 == 0) goto L_0x0215
            javax.crypto.spec.PBEParameterSpec r13 = r1.f6542a
            if (r13 != 0) goto L_0x0215
            r13 = r9
            javax.crypto.interfaces.PBEKey r13 = (javax.crypto.interfaces.PBEKey) r13
            byte[] r14 = r13.getSalt()
            if (r14 == 0) goto L_0x020d
            javax.crypto.spec.PBEParameterSpec r14 = new javax.crypto.spec.PBEParameterSpec
            byte[] r15 = r13.getSalt()
            int r13 = r13.getIterationCount()
            r14.<init>(r15, r13)
            r1.f6542a = r14
            goto L_0x0215
        L_0x020d:
            java.security.InvalidAlgorithmParameterException r0 = new java.security.InvalidAlgorithmParameterException
            java.lang.String r2 = "PBEKey requires parameters to specify salt"
            r0.<init>(r2)
            throw r0
        L_0x0215:
            javax.crypto.spec.PBEParameterSpec r13 = r1.f6542a
            if (r13 != 0) goto L_0x0222
            if (r10 == 0) goto L_0x021c
            goto L_0x0222
        L_0x021c:
            java.security.InvalidKeyException r0 = new java.security.InvalidKeyException
            r0.<init>(r11)
            throw r0
        L_0x0222:
            boolean r10 = r2 instanceof org.spongycastle.jcajce.provider.symmetric.util.BCPBEKey
            if (r10 == 0) goto L_0x0259
            r10 = r2
            org.spongycastle.jcajce.provider.symmetric.util.BCPBEKey r10 = (org.spongycastle.jcajce.provider.symmetric.util.BCPBEKey) r10
            org.spongycastle.crypto.CipherParameters r10 = r10.f6539a
            boolean r11 = r10 instanceof org.spongycastle.crypto.params.ParametersWithIV
            if (r11 == 0) goto L_0x0231
            r9 = r10
            goto L_0x0276
        L_0x0231:
            if (r10 != 0) goto L_0x0251
            byte[] r13 = r9.getEncoded()
            r14 = 2
            int r15 = r1.f
            int r9 = r1.d
            int r10 = r1.g
            int r17 = r10 * 8
            javax.crypto.spec.PBEParameterSpec r10 = r1.f6542a
            org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher$GenericBlockCipher r11 = r1.f6546a
            java.lang.String r19 = r11.b()
            r16 = r9
            r18 = r10
            org.spongycastle.crypto.CipherParameters r9 = org.spongycastle.jcajce.provider.symmetric.util.PBE.Util.f(r13, r14, r15, r16, r17, r18, r19)
            goto L_0x0276
        L_0x0251:
            java.security.InvalidKeyException r0 = new java.security.InvalidKeyException
            java.lang.String r2 = "Algorithm requires a PBE key suitable for PKCS12"
            r0.<init>(r2)
            throw r0
        L_0x0259:
            byte[] r13 = r9.getEncoded()
            r14 = 2
            int r15 = r1.f
            int r9 = r1.d
            int r10 = r1.g
            int r17 = r10 * 8
            javax.crypto.spec.PBEParameterSpec r10 = r1.f6542a
            org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher$GenericBlockCipher r11 = r1.f6546a
            java.lang.String r19 = r11.b()
            r16 = r9
            r18 = r10
            org.spongycastle.crypto.CipherParameters r9 = org.spongycastle.jcajce.provider.symmetric.util.PBE.Util.f(r13, r14, r15, r16, r17, r18, r19)
        L_0x0276:
            boolean r10 = r9 instanceof org.spongycastle.crypto.params.ParametersWithIV
            if (r10 == 0) goto L_0x027f
            r10 = r9
            org.spongycastle.crypto.params.ParametersWithIV r10 = (org.spongycastle.crypto.params.ParametersWithIV) r10
            r1.f6545a = r10
        L_0x027f:
            boolean r10 = r3 instanceof org.spongycastle.jcajce.spec.AEADParameterSpec
            r11 = 0
            if (r10 == 0) goto L_0x02c1
            java.lang.String r2 = r1.f6550d
            boolean r2 = a(r2)
            if (r2 != 0) goto L_0x029b
            org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher$GenericBlockCipher r2 = r1.f6546a
            boolean r2 = r2 instanceof org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher.AEADGenericBlockCipher
            if (r2 == 0) goto L_0x0293
            goto L_0x029b
        L_0x0293:
            java.security.InvalidAlgorithmParameterException r0 = new java.security.InvalidAlgorithmParameterException
            java.lang.String r2 = "AEADParameterSpec can only be used with AEAD modes."
            r0.<init>(r2)
            throw r0
        L_0x029b:
            r2 = r3
            org.spongycastle.jcajce.spec.AEADParameterSpec r2 = (org.spongycastle.jcajce.spec.AEADParameterSpec) r2
            boolean r3 = r9 instanceof org.spongycastle.crypto.params.ParametersWithIV
            if (r3 == 0) goto L_0x02a9
            org.spongycastle.crypto.params.ParametersWithIV r9 = (org.spongycastle.crypto.params.ParametersWithIV) r9
            org.spongycastle.crypto.CipherParameters r3 = r9.a
            org.spongycastle.crypto.params.KeyParameter r3 = (org.spongycastle.crypto.params.KeyParameter) r3
            goto L_0x02ac
        L_0x02a9:
            r3 = r9
            org.spongycastle.crypto.params.KeyParameter r3 = (org.spongycastle.crypto.params.KeyParameter) r3
        L_0x02ac:
            org.spongycastle.crypto.params.AEADParameters r9 = new org.spongycastle.crypto.params.AEADParameters
            int r7 = r2.a
            byte[] r8 = r2.getIV()
            byte[] r2 = r2.f6563a
            byte[] r2 = org.spongycastle.util.Arrays.c(r2)
            r9.<init>(r3, r7, r8, r2)
            r1.f6544a = r9
            goto L_0x04cf
        L_0x02c1:
            boolean r10 = r3 instanceof javax.crypto.spec.IvParameterSpec
            if (r10 == 0) goto L_0x032b
            int r2 = r1.g
            if (r2 == 0) goto L_0x0315
            r2 = r3
            javax.crypto.spec.IvParameterSpec r2 = (javax.crypto.spec.IvParameterSpec) r2
            byte[] r3 = r2.getIV()
            int r3 = r3.length
            int r7 = r1.g
            if (r3 == r7) goto L_0x02f5
            org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher$GenericBlockCipher r3 = r1.f6546a
            boolean r3 = r3 instanceof org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher.AEADGenericBlockCipher
            if (r3 != 0) goto L_0x02f5
            boolean r3 = r1.b
            if (r3 != 0) goto L_0x02e0
            goto L_0x02f5
        L_0x02e0:
            java.security.InvalidAlgorithmParameterException r0 = new java.security.InvalidAlgorithmParameterException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "IV must be "
            r2.<init>(r3)
            int r3 = r1.g
            java.lang.String r4 = " bytes long."
            java.lang.String r2 = defpackage.lf.k(r2, r3, r4)
            r0.<init>(r2)
            throw r0
        L_0x02f5:
            boolean r3 = r9 instanceof org.spongycastle.crypto.params.ParametersWithIV
            if (r3 == 0) goto L_0x0307
            org.spongycastle.crypto.params.ParametersWithIV r3 = new org.spongycastle.crypto.params.ParametersWithIV
            org.spongycastle.crypto.params.ParametersWithIV r9 = (org.spongycastle.crypto.params.ParametersWithIV) r9
            org.spongycastle.crypto.CipherParameters r7 = r9.a
            byte[] r2 = r2.getIV()
            r3.<init>(r7, r2)
            goto L_0x0310
        L_0x0307:
            org.spongycastle.crypto.params.ParametersWithIV r3 = new org.spongycastle.crypto.params.ParametersWithIV
            byte[] r2 = r2.getIV()
            r3.<init>(r9, r2)
        L_0x0310:
            r9 = r3
            r1.f6545a = r9
            goto L_0x04cf
        L_0x0315:
            java.lang.String r2 = r1.f6550d
            if (r2 == 0) goto L_0x04cf
            java.lang.String r3 = "ECB"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0323
            goto L_0x04cf
        L_0x0323:
            java.security.InvalidAlgorithmParameterException r0 = new java.security.InvalidAlgorithmParameterException
            java.lang.String r2 = "ECB mode does not use an IV"
            r0.<init>(r2)
            throw r0
        L_0x032b:
            boolean r10 = r3 instanceof org.spongycastle.jcajce.spec.GOST28147ParameterSpec
            if (r10 == 0) goto L_0x0372
            org.spongycastle.jcajce.spec.GOST28147ParameterSpec r3 = (org.spongycastle.jcajce.spec.GOST28147ParameterSpec) r3
            org.spongycastle.crypto.params.ParametersWithSBox r7 = new org.spongycastle.crypto.params.ParametersWithSBox
            org.spongycastle.crypto.params.KeyParameter r8 = new org.spongycastle.crypto.params.KeyParameter
            byte[] r2 = r23.getEncoded()
            r8.<init>(r2)
            byte[] r2 = r3.b
            byte[] r2 = org.spongycastle.util.Arrays.c(r2)
            r7.<init>(r8, r2)
            byte[] r2 = r3.a()
            if (r2 == 0) goto L_0x036f
            int r2 = r1.g
            if (r2 == 0) goto L_0x036f
            boolean r2 = r7 instanceof org.spongycastle.crypto.params.ParametersWithIV
            if (r2 == 0) goto L_0x0361
            org.spongycastle.crypto.params.ParametersWithIV r2 = new org.spongycastle.crypto.params.ParametersWithIV
            org.spongycastle.crypto.params.ParametersWithIV r7 = (org.spongycastle.crypto.params.ParametersWithIV) r7
            byte[] r3 = r3.a()
            org.spongycastle.crypto.CipherParameters r7 = r7.a
            r2.<init>(r7, r3)
            goto L_0x036a
        L_0x0361:
            org.spongycastle.crypto.params.ParametersWithIV r2 = new org.spongycastle.crypto.params.ParametersWithIV
            byte[] r3 = r3.a()
            r2.<init>(r7, r3)
        L_0x036a:
            r1.f6545a = r2
        L_0x036c:
            r9 = r2
            goto L_0x04cf
        L_0x036f:
            r9 = r7
            goto L_0x04cf
        L_0x0372:
            boolean r10 = r3 instanceof javax.crypto.spec.RC2ParameterSpec
            if (r10 == 0) goto L_0x03ad
            javax.crypto.spec.RC2ParameterSpec r3 = (javax.crypto.spec.RC2ParameterSpec) r3
            org.spongycastle.crypto.params.RC2Parameters r7 = new org.spongycastle.crypto.params.RC2Parameters
            byte[] r2 = r23.getEncoded()
            int r8 = r3.getEffectiveKeyBits()
            r7.<init>(r2, r8)
            byte[] r2 = r3.getIV()
            if (r2 == 0) goto L_0x036f
            int r2 = r1.g
            if (r2 == 0) goto L_0x036f
            boolean r2 = r7 instanceof org.spongycastle.crypto.params.ParametersWithIV
            if (r2 == 0) goto L_0x03a1
            org.spongycastle.crypto.params.ParametersWithIV r2 = new org.spongycastle.crypto.params.ParametersWithIV
            org.spongycastle.crypto.params.ParametersWithIV r7 = (org.spongycastle.crypto.params.ParametersWithIV) r7
            byte[] r3 = r3.getIV()
            org.spongycastle.crypto.CipherParameters r7 = r7.a
            r2.<init>(r7, r3)
            goto L_0x03aa
        L_0x03a1:
            org.spongycastle.crypto.params.ParametersWithIV r2 = new org.spongycastle.crypto.params.ParametersWithIV
            byte[] r3 = r3.getIV()
            r2.<init>(r7, r3)
        L_0x03aa:
            r1.f6545a = r2
            goto L_0x036c
        L_0x03ad:
            boolean r10 = r3 instanceof javax.crypto.spec.RC5ParameterSpec
            if (r10 == 0) goto L_0x045d
            javax.crypto.spec.RC5ParameterSpec r3 = (javax.crypto.spec.RC5ParameterSpec) r3
            org.spongycastle.crypto.params.RC5Parameters r9 = new org.spongycastle.crypto.params.RC5Parameters
            byte[] r2 = r23.getEncoded()
            int r10 = r3.getRounds()
            r9.<init>(r2, r10)
            java.lang.String r2 = r8.b()
            java.lang.String r10 = "RC5"
            boolean r2 = r2.startsWith(r10)
            if (r2 == 0) goto L_0x0455
            java.lang.String r2 = r8.b()
            java.lang.String r10 = "RC5-32"
            boolean r2 = r2.equals(r10)
            java.lang.String r10 = "."
            if (r2 == 0) goto L_0x03fe
            int r2 = r3.getWordSize()
            r7 = 32
            if (r2 != r7) goto L_0x03e3
            goto L_0x042c
        L_0x03e3:
            java.security.InvalidAlgorithmParameterException r0 = new java.security.InvalidAlgorithmParameterException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "RC5 already set up for a word size of 32 not "
            r2.<init>(r4)
            int r3 = r3.getWordSize()
            r2.append(r3)
            r2.append(r10)
            java.lang.String r2 = r2.toString()
            r0.<init>(r2)
            throw r0
        L_0x03fe:
            java.lang.String r2 = r8.b()
            boolean r2 = r2.equals(r7)
            if (r2 == 0) goto L_0x042c
            int r2 = r3.getWordSize()
            r7 = 64
            if (r2 != r7) goto L_0x0411
            goto L_0x042c
        L_0x0411:
            java.security.InvalidAlgorithmParameterException r0 = new java.security.InvalidAlgorithmParameterException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "RC5 already set up for a word size of 64 not "
            r2.<init>(r4)
            int r3 = r3.getWordSize()
            r2.append(r3)
            r2.append(r10)
            java.lang.String r2 = r2.toString()
            r0.<init>(r2)
            throw r0
        L_0x042c:
            byte[] r2 = r3.getIV()
            if (r2 == 0) goto L_0x04cf
            int r2 = r1.g
            if (r2 == 0) goto L_0x04cf
            boolean r2 = r9 instanceof org.spongycastle.crypto.params.ParametersWithIV
            if (r2 == 0) goto L_0x0448
            org.spongycastle.crypto.params.ParametersWithIV r2 = new org.spongycastle.crypto.params.ParametersWithIV
            org.spongycastle.crypto.params.ParametersWithIV r9 = (org.spongycastle.crypto.params.ParametersWithIV) r9
            byte[] r3 = r3.getIV()
            org.spongycastle.crypto.CipherParameters r7 = r9.a
            r2.<init>(r7, r3)
            goto L_0x0451
        L_0x0448:
            org.spongycastle.crypto.params.ParametersWithIV r2 = new org.spongycastle.crypto.params.ParametersWithIV
            byte[] r3 = r3.getIV()
            r2.<init>(r9, r3)
        L_0x0451:
            r1.f6545a = r2
            goto L_0x036c
        L_0x0455:
            java.security.InvalidAlgorithmParameterException r0 = new java.security.InvalidAlgorithmParameterException
            java.lang.String r2 = "RC5 parameters passed to a cipher that is not RC5."
            r0.<init>(r2)
            throw r0
        L_0x045d:
            java.lang.Class r2 = a
            if (r2 == 0) goto L_0x04c0
            boolean r7 = r2.isInstance(r3)
            if (r7 == 0) goto L_0x04c0
            java.lang.String r7 = r1.f6550d
            boolean r7 = a(r7)
            if (r7 != 0) goto L_0x047e
            org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher$GenericBlockCipher r7 = r1.f6546a
            boolean r7 = r7 instanceof org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher.AEADGenericBlockCipher
            if (r7 == 0) goto L_0x0476
            goto L_0x047e
        L_0x0476:
            java.security.InvalidAlgorithmParameterException r0 = new java.security.InvalidAlgorithmParameterException
            java.lang.String r2 = "GCMParameterSpec can only be used with AEAD modes."
            r0.<init>(r2)
            throw r0
        L_0x047e:
            java.lang.String r7 = "getTLen"
            java.lang.Class[] r8 = new java.lang.Class[r11]     // Catch:{ Exception -> 0x04b8 }
            java.lang.reflect.Method r7 = r2.getDeclaredMethod(r7, r8)     // Catch:{ Exception -> 0x04b8 }
            java.lang.String r8 = "getIV"
            java.lang.Class[] r10 = new java.lang.Class[r11]     // Catch:{ Exception -> 0x04b8 }
            java.lang.reflect.Method r2 = r2.getDeclaredMethod(r8, r10)     // Catch:{ Exception -> 0x04b8 }
            boolean r8 = r9 instanceof org.spongycastle.crypto.params.ParametersWithIV     // Catch:{ Exception -> 0x04b8 }
            if (r8 == 0) goto L_0x0499
            org.spongycastle.crypto.params.ParametersWithIV r9 = (org.spongycastle.crypto.params.ParametersWithIV) r9     // Catch:{ Exception -> 0x04b8 }
            org.spongycastle.crypto.CipherParameters r8 = r9.a     // Catch:{ Exception -> 0x04b8 }
            org.spongycastle.crypto.params.KeyParameter r8 = (org.spongycastle.crypto.params.KeyParameter) r8     // Catch:{ Exception -> 0x04b8 }
            goto L_0x049c
        L_0x0499:
            r8 = r9
            org.spongycastle.crypto.params.KeyParameter r8 = (org.spongycastle.crypto.params.KeyParameter) r8     // Catch:{ Exception -> 0x04b8 }
        L_0x049c:
            org.spongycastle.crypto.params.AEADParameters r9 = new org.spongycastle.crypto.params.AEADParameters     // Catch:{ Exception -> 0x04b8 }
            java.lang.Object[] r10 = new java.lang.Object[r11]     // Catch:{ Exception -> 0x04b8 }
            java.lang.Object r7 = r7.invoke(r3, r10)     // Catch:{ Exception -> 0x04b8 }
            java.lang.Integer r7 = (java.lang.Integer) r7     // Catch:{ Exception -> 0x04b8 }
            int r7 = r7.intValue()     // Catch:{ Exception -> 0x04b8 }
            java.lang.Object[] r10 = new java.lang.Object[r11]     // Catch:{ Exception -> 0x04b8 }
            java.lang.Object r2 = r2.invoke(r3, r10)     // Catch:{ Exception -> 0x04b8 }
            byte[] r2 = (byte[]) r2     // Catch:{ Exception -> 0x04b8 }
            r9.<init>(r8, r7, r2, r6)     // Catch:{ Exception -> 0x04b8 }
            r1.f6544a = r9     // Catch:{ Exception -> 0x04b8 }
            goto L_0x04cf
        L_0x04b8:
            java.security.InvalidAlgorithmParameterException r0 = new java.security.InvalidAlgorithmParameterException
            java.lang.String r2 = "Cannot process GCMParameterSpec."
            r0.<init>(r2)
            throw r0
        L_0x04c0:
            if (r3 == 0) goto L_0x04cf
            boolean r2 = r3 instanceof javax.crypto.spec.PBEParameterSpec
            if (r2 == 0) goto L_0x04c7
            goto L_0x04cf
        L_0x04c7:
            java.security.InvalidAlgorithmParameterException r0 = new java.security.InvalidAlgorithmParameterException
            java.lang.String r2 = "unknown parameter type."
            r0.<init>(r2)
            throw r0
        L_0x04cf:
            int r2 = r1.g
            r3 = 3
            if (r2 == 0) goto L_0x0514
            boolean r2 = r9 instanceof org.spongycastle.crypto.params.ParametersWithIV
            if (r2 != 0) goto L_0x0514
            boolean r2 = r9 instanceof org.spongycastle.crypto.params.AEADParameters
            if (r2 != 0) goto L_0x0514
            if (r4 != 0) goto L_0x04e4
            java.security.SecureRandom r2 = new java.security.SecureRandom
            r2.<init>()
            goto L_0x04e5
        L_0x04e4:
            r2 = r4
        L_0x04e5:
            if (r0 == r12) goto L_0x0505
            if (r0 != r3) goto L_0x04ea
            goto L_0x0505
        L_0x04ea:
            org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher$GenericBlockCipher r2 = r1.f6546a
            org.spongycastle.crypto.BlockCipher r2 = r2.g()
            java.lang.String r2 = r2.b()
            java.lang.String r7 = "PGPCFB"
            int r2 = r2.indexOf(r7)
            if (r2 < 0) goto L_0x04fd
            goto L_0x0514
        L_0x04fd:
            java.security.InvalidAlgorithmParameterException r0 = new java.security.InvalidAlgorithmParameterException
            java.lang.String r2 = "no IV set when one expected"
            r0.<init>(r2)
            throw r0
        L_0x0505:
            int r7 = r1.g
            byte[] r8 = new byte[r7]
            r2.nextBytes(r8)
            org.spongycastle.crypto.params.ParametersWithIV r2 = new org.spongycastle.crypto.params.ParametersWithIV
            r2.<init>(r9, r8, r11, r7)
            r1.f6545a = r2
            r9 = r2
        L_0x0514:
            if (r4 == 0) goto L_0x0520
            boolean r2 = r1.f6548a
            if (r2 == 0) goto L_0x0520
            org.spongycastle.crypto.params.ParametersWithRandom r2 = new org.spongycastle.crypto.params.ParametersWithRandom
            r2.<init>(r9, r4)
            r9 = r2
        L_0x0520:
            if (r0 == r12) goto L_0x0548
            r2 = 2
            if (r0 == r2) goto L_0x0542
            if (r0 == r3) goto L_0x0548
            r2 = 4
            if (r0 != r2) goto L_0x052b
            goto L_0x0542
        L_0x052b:
            java.security.InvalidParameterException r2 = new java.security.InvalidParameterException     // Catch:{ Exception -> 0x0574 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0574 }
            r3.<init>(r5)     // Catch:{ Exception -> 0x0574 }
            r3.append(r0)     // Catch:{ Exception -> 0x0574 }
            java.lang.String r0 = " passed"
            r3.append(r0)     // Catch:{ Exception -> 0x0574 }
            java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x0574 }
            r2.<init>(r0)     // Catch:{ Exception -> 0x0574 }
            throw r2     // Catch:{ Exception -> 0x0574 }
        L_0x0542:
            org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher$GenericBlockCipher r0 = r1.f6546a     // Catch:{ Exception -> 0x0574 }
            r0.a(r11, r9)     // Catch:{ Exception -> 0x0574 }
            goto L_0x054d
        L_0x0548:
            org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher$GenericBlockCipher r0 = r1.f6546a     // Catch:{ Exception -> 0x0574 }
            r0.a(r12, r9)     // Catch:{ Exception -> 0x0574 }
        L_0x054d:
            org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher$GenericBlockCipher r0 = r1.f6546a     // Catch:{ Exception -> 0x0574 }
            boolean r2 = r0 instanceof org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher.AEADGenericBlockCipher     // Catch:{ Exception -> 0x0574 }
            if (r2 == 0) goto L_0x0573
            org.spongycastle.crypto.params.AEADParameters r2 = r1.f6544a     // Catch:{ Exception -> 0x0574 }
            if (r2 != 0) goto L_0x0573
            org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher$AEADGenericBlockCipher r0 = (org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher.AEADGenericBlockCipher) r0     // Catch:{ Exception -> 0x0574 }
            org.spongycastle.crypto.modes.AEADBlockCipher r0 = r0.f6551a     // Catch:{ Exception -> 0x0574 }
            org.spongycastle.crypto.params.AEADParameters r2 = new org.spongycastle.crypto.params.AEADParameters     // Catch:{ Exception -> 0x0574 }
            org.spongycastle.crypto.params.ParametersWithIV r3 = r1.f6545a     // Catch:{ Exception -> 0x0574 }
            org.spongycastle.crypto.CipherParameters r3 = r3.a     // Catch:{ Exception -> 0x0574 }
            org.spongycastle.crypto.params.KeyParameter r3 = (org.spongycastle.crypto.params.KeyParameter) r3     // Catch:{ Exception -> 0x0574 }
            byte[] r0 = r0.h()     // Catch:{ Exception -> 0x0574 }
            int r0 = r0.length     // Catch:{ Exception -> 0x0574 }
            int r0 = r0 * 8
            org.spongycastle.crypto.params.ParametersWithIV r4 = r1.f6545a     // Catch:{ Exception -> 0x0574 }
            byte[] r4 = r4.f6233a     // Catch:{ Exception -> 0x0574 }
            r2.<init>(r3, r0, r4, r6)     // Catch:{ Exception -> 0x0574 }
            r1.f6544a = r2     // Catch:{ Exception -> 0x0574 }
        L_0x0573:
            return
        L_0x0574:
            r0 = move-exception
            org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher$InvalidKeyOrParametersException r2 = new org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher$InvalidKeyOrParametersException
            java.lang.String r3 = r0.getMessage()
            r2.<init>(r3, r0)
            throw r2
        L_0x057f:
            java.security.InvalidKeyException r0 = new java.security.InvalidKeyException
            java.lang.String r2 = "PKCS12 requires a SecretKey/PBEKey"
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher.engineInit(int, java.security.Key, java.security.spec.AlgorithmParameterSpec, java.security.SecureRandom):void");
    }

    public final void engineSetMode(String str) throws NoSuchAlgorithmException {
        String g2 = Strings.g(str);
        this.f6550d = g2;
        boolean equals = g2.equals("ECB");
        BlockCipher blockCipher = this.f6543a;
        if (equals) {
            this.g = 0;
            this.f6546a = new BufferedGenericBlockCipher(blockCipher);
        } else if (this.f6550d.equals("CBC")) {
            this.g = blockCipher.c();
            this.f6546a = new BufferedGenericBlockCipher((BlockCipher) new CBCBlockCipher(blockCipher));
        } else if (this.f6550d.startsWith("OFB")) {
            this.g = blockCipher.c();
            if (this.f6550d.length() != 3) {
                this.f6546a = new BufferedGenericBlockCipher((BlockCipher) new OFBBlockCipher(blockCipher, Integer.parseInt(this.f6550d.substring(3))));
            } else {
                this.f6546a = new BufferedGenericBlockCipher((BlockCipher) new OFBBlockCipher(blockCipher, blockCipher.c() * 8));
            }
        } else if (this.f6550d.startsWith("CFB")) {
            this.g = blockCipher.c();
            if (this.f6550d.length() != 3) {
                this.f6546a = new BufferedGenericBlockCipher((BlockCipher) new CFBBlockCipher(blockCipher, Integer.parseInt(this.f6550d.substring(3))));
            } else {
                this.f6546a = new BufferedGenericBlockCipher((BlockCipher) new CFBBlockCipher(blockCipher, blockCipher.c() * 8));
            }
        } else if (this.f6550d.startsWith("PGP")) {
            boolean equalsIgnoreCase = this.f6550d.equalsIgnoreCase("PGPCFBwithIV");
            this.g = blockCipher.c();
            this.f6546a = new BufferedGenericBlockCipher((BlockCipher) new PGPCFBBlockCipher(blockCipher, equalsIgnoreCase));
        } else if (this.f6550d.equalsIgnoreCase("OpenPGPCFB")) {
            this.g = 0;
            this.f6546a = new BufferedGenericBlockCipher((BlockCipher) new OpenPGPCFBBlockCipher(blockCipher));
        } else if (this.f6550d.startsWith("SIC")) {
            int c2 = blockCipher.c();
            this.g = c2;
            if (c2 >= 16) {
                this.b = false;
                this.f6546a = new BufferedGenericBlockCipher(new BufferedBlockCipher(new SICBlockCipher(blockCipher)));
                return;
            }
            throw new IllegalArgumentException("Warning: SIC-Mode can become a twotime-pad if the blocksize of the cipher is too small. Use a cipher with a block size of at least 128 bits (e.g. AES)");
        } else if (this.f6550d.startsWith("CTR")) {
            this.g = blockCipher.c();
            this.b = false;
            if (blockCipher instanceof DSTU7624Engine) {
                this.f6546a = new BufferedGenericBlockCipher(new BufferedBlockCipher(new KCTRBlockCipher(blockCipher)));
            } else {
                this.f6546a = new BufferedGenericBlockCipher(new BufferedBlockCipher(new SICBlockCipher(blockCipher)));
            }
        } else if (this.f6550d.startsWith("GOFB")) {
            this.g = blockCipher.c();
            this.f6546a = new BufferedGenericBlockCipher(new BufferedBlockCipher(new GOFBBlockCipher(blockCipher)));
        } else if (this.f6550d.startsWith("GCFB")) {
            this.g = blockCipher.c();
            this.f6546a = new BufferedGenericBlockCipher(new BufferedBlockCipher(new GCFBBlockCipher(blockCipher)));
        } else if (this.f6550d.startsWith("CTS")) {
            this.g = blockCipher.c();
            this.f6546a = new BufferedGenericBlockCipher((BufferedBlockCipher) new CTSBlockCipher(new CBCBlockCipher(blockCipher)));
        } else if (this.f6550d.startsWith("CCM")) {
            this.g = 13;
            if (blockCipher instanceof DSTU7624Engine) {
                this.f6546a = new AEADGenericBlockCipher(new KCCMBlockCipher(blockCipher));
            } else {
                this.f6546a = new AEADGenericBlockCipher(new CCMBlockCipher(blockCipher));
            }
        } else if (this.f6550d.startsWith("OCB")) {
            BlockCipherProvider blockCipherProvider = this.f6547a;
            if (blockCipherProvider != null) {
                this.g = 15;
                this.f6546a = new AEADGenericBlockCipher(new OCBBlockCipher(blockCipher, blockCipherProvider.a()));
                return;
            }
            throw new NoSuchAlgorithmException("can't support mode ".concat(str));
        } else if (this.f6550d.startsWith("EAX")) {
            this.g = blockCipher.c();
            this.f6546a = new AEADGenericBlockCipher(new EAXBlockCipher(blockCipher));
        } else if (this.f6550d.startsWith(CodePackage.GCM)) {
            this.g = blockCipher.c();
            if (blockCipher instanceof DSTU7624Engine) {
                this.f6546a = new AEADGenericBlockCipher(new KGCMBlockCipher(blockCipher));
            } else {
                this.f6546a = new AEADGenericBlockCipher(new GCMBlockCipher(blockCipher));
            }
        } else {
            throw new NoSuchAlgorithmException("can't support mode ".concat(str));
        }
    }

    public final void engineSetPadding(String str) throws NoSuchPaddingException {
        String g2 = Strings.g(str);
        if (g2.equals("NOPADDING")) {
            if (this.f6546a.i()) {
                this.f6546a = new BufferedGenericBlockCipher(new BufferedBlockCipher(this.f6546a.g()));
            }
        } else if (g2.equals("WITHCTS")) {
            this.f6546a = new BufferedGenericBlockCipher((BufferedBlockCipher) new CTSBlockCipher(this.f6546a.g()));
        } else {
            this.f6548a = true;
            if (a(this.f6550d)) {
                throw new NoSuchPaddingException("Only NoPadding can be used with AEAD modes.");
            } else if (g2.equals("PKCS5PADDING") || g2.equals("PKCS7PADDING")) {
                this.f6546a = new BufferedGenericBlockCipher(this.f6546a.g());
            } else if (g2.equals("ZEROBYTEPADDING")) {
                this.f6546a = new BufferedGenericBlockCipher(this.f6546a.g(), new ZeroBytePadding());
            } else if (g2.equals("ISO10126PADDING") || g2.equals("ISO10126-2PADDING")) {
                this.f6546a = new BufferedGenericBlockCipher(this.f6546a.g(), new ISO10126d2Padding());
            } else if (g2.equals("X9.23PADDING") || g2.equals("X923PADDING")) {
                this.f6546a = new BufferedGenericBlockCipher(this.f6546a.g(), new X923Padding());
            } else if (g2.equals("ISO7816-4PADDING") || g2.equals("ISO9797-1PADDING")) {
                this.f6546a = new BufferedGenericBlockCipher(this.f6546a.g(), new ISO7816d4Padding());
            } else if (g2.equals("TBCPADDING")) {
                this.f6546a = new BufferedGenericBlockCipher(this.f6546a.g(), new TBCPadding());
            } else {
                throw new NoSuchPaddingException(lf.j("Padding ", str, " unknown."));
            }
        }
    }

    public final byte[] engineUpdate(byte[] bArr, int i, int i2) {
        int f2 = this.f6546a.f(i2);
        if (f2 > 0) {
            byte[] bArr2 = new byte[f2];
            int d2 = this.f6546a.d(bArr, i, i2, bArr2, 0);
            if (d2 == 0) {
                return null;
            }
            if (d2 == f2) {
                return bArr2;
            }
            byte[] bArr3 = new byte[d2];
            System.arraycopy(bArr2, 0, bArr3, 0, d2);
            return bArr3;
        }
        this.f6546a.d(bArr, i, i2, (byte[]) null, 0);
        return null;
    }

    public final void engineUpdateAAD(byte[] bArr, int i, int i2) {
        this.f6546a.h(i, bArr, i2);
    }

    public static class BufferedGenericBlockCipher implements GenericBlockCipher {
        public final BufferedBlockCipher a;

        public BufferedGenericBlockCipher(BufferedBlockCipher bufferedBlockCipher) {
            this.a = bufferedBlockCipher;
        }

        public final void a(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
            this.a.e(z, cipherParameters);
        }

        public final String b() {
            return this.a.f5794a.b();
        }

        public final int c(int i, byte[] bArr) throws IllegalStateException, BadPaddingException {
            try {
                return this.a.a(i, bArr);
            } catch (InvalidCipherTextException e) {
                throw new BadPaddingException(e.getMessage());
            }
        }

        public final int d(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws DataLengthException {
            return this.a.f(bArr, i, i2, bArr2, i3);
        }

        public final int e(int i) {
            return this.a.c(i);
        }

        public final int f(int i) {
            return this.a.d(i);
        }

        public final BlockCipher g() {
            return this.a.f5794a;
        }

        public final void h(int i, byte[] bArr, int i2) {
            throw new UnsupportedOperationException("AAD is not supported in the current mode.");
        }

        public final boolean i() {
            return !(this.a instanceof CTSBlockCipher);
        }

        public BufferedGenericBlockCipher(BlockCipher blockCipher) {
            this.a = new PaddedBufferedBlockCipher(blockCipher);
        }

        public BufferedGenericBlockCipher(BlockCipher blockCipher, BlockCipherPadding blockCipherPadding) {
            this.a = new PaddedBufferedBlockCipher(blockCipher, blockCipherPadding);
        }
    }

    public final void engineUpdateAAD(ByteBuffer byteBuffer) {
        int arrayOffset = byteBuffer.arrayOffset();
        engineUpdateAAD(byteBuffer.array(), byteBuffer.position() + arrayOffset, byteBuffer.limit() - byteBuffer.position());
    }

    public final int engineDoFinal(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws IllegalBlockSizeException, BadPaddingException, ShortBufferException {
        int i4;
        if (engineGetOutputSize(i2) + i3 <= bArr2.length) {
            if (i2 != 0) {
                try {
                    i4 = this.f6546a.d(bArr, i, i2, bArr2, i3);
                } catch (OutputLengthException e2) {
                    throw new IllegalBlockSizeException(e2.getMessage());
                } catch (DataLengthException e3) {
                    throw new IllegalBlockSizeException(e3.getMessage());
                }
            } else {
                i4 = 0;
            }
            return i4 + this.f6546a.c(i3 + i4, bArr2);
        }
        throw new ShortBufferException("output buffer too short for input.");
    }

    public final int engineUpdate(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws ShortBufferException {
        if (this.f6546a.f(i2) + i3 <= bArr2.length) {
            try {
                return this.f6546a.d(bArr, i, i2, bArr2, i3);
            } catch (DataLengthException e2) {
                throw new IllegalStateException(e2.toString());
            }
        } else {
            throw new ShortBufferException("output buffer too short for input.");
        }
    }

    public BaseBlockCipher(CBCBlockCipher cBCBlockCipher, int i, int i2, int i3, int i4) {
        this.f6549b = new Class[]{RC2ParameterSpec.class, RC5ParameterSpec.class, a, GOST28147ParameterSpec.class, IvParameterSpec.class, PBEParameterSpec.class};
        this.e = -1;
        this.b = true;
        this.f6542a = null;
        this.c = null;
        this.f6550d = null;
        this.f6543a = cBCBlockCipher;
        this.e = i;
        this.f = i2;
        this.d = i3;
        this.g = i4;
        this.f6546a = new BufferedGenericBlockCipher((BlockCipher) cBCBlockCipher);
    }

    public BaseBlockCipher(BlockCipherProvider blockCipherProvider) {
        this.f6549b = new Class[]{RC2ParameterSpec.class, RC5ParameterSpec.class, a, GOST28147ParameterSpec.class, IvParameterSpec.class, PBEParameterSpec.class};
        this.e = -1;
        this.g = 0;
        this.b = true;
        this.f6542a = null;
        this.c = null;
        this.f6550d = null;
        this.f6543a = blockCipherProvider.a();
        this.f6547a = blockCipherProvider;
        this.f6546a = new BufferedGenericBlockCipher(blockCipherProvider.a());
    }

    public BaseBlockCipher(AEADBlockCipher aEADBlockCipher) {
        this.f6549b = new Class[]{RC2ParameterSpec.class, RC5ParameterSpec.class, a, GOST28147ParameterSpec.class, IvParameterSpec.class, PBEParameterSpec.class};
        this.e = -1;
        this.g = 0;
        this.b = true;
        this.f6542a = null;
        this.c = null;
        this.f6550d = null;
        BlockCipher g2 = aEADBlockCipher.g();
        this.f6543a = g2;
        this.g = g2.c();
        this.f6546a = new AEADGenericBlockCipher(aEADBlockCipher);
    }

    public BaseBlockCipher(CCMBlockCipher cCMBlockCipher) {
        this.f6549b = new Class[]{RC2ParameterSpec.class, RC5ParameterSpec.class, a, GOST28147ParameterSpec.class, IvParameterSpec.class, PBEParameterSpec.class};
        this.e = -1;
        this.f6542a = null;
        this.c = null;
        this.f6550d = null;
        this.f6543a = cCMBlockCipher.f6139a;
        this.b = false;
        this.g = 16;
        this.f6546a = new AEADGenericBlockCipher(cCMBlockCipher);
    }

    public BaseBlockCipher(CBCBlockCipher cBCBlockCipher, int i) {
        this.f6549b = new Class[]{RC2ParameterSpec.class, RC5ParameterSpec.class, a, GOST28147ParameterSpec.class, IvParameterSpec.class, PBEParameterSpec.class};
        this.e = -1;
        this.g = 0;
        this.b = true;
        this.f6542a = null;
        this.c = null;
        this.f6550d = null;
        this.f6543a = cBCBlockCipher;
        this.f6546a = new BufferedGenericBlockCipher((BlockCipher) cBCBlockCipher);
        this.g = i / 8;
    }

    public BaseBlockCipher(BufferedBlockCipher bufferedBlockCipher, int i) {
        this.f6549b = new Class[]{RC2ParameterSpec.class, RC5ParameterSpec.class, a, GOST28147ParameterSpec.class, IvParameterSpec.class, PBEParameterSpec.class};
        this.e = -1;
        this.g = 0;
        this.b = true;
        this.f6542a = null;
        this.c = null;
        this.f6550d = null;
        this.f6543a = bufferedBlockCipher.f5794a;
        this.f6546a = new BufferedGenericBlockCipher(bufferedBlockCipher);
        this.g = i / 8;
    }

    public final void engineInit(int i, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        AlgorithmParameterSpec algorithmParameterSpec = null;
        if (algorithmParameters != null) {
            int i2 = 0;
            while (true) {
                Class[] clsArr = this.f6549b;
                if (i2 == clsArr.length) {
                    break;
                }
                Class cls = clsArr[i2];
                if (cls != null) {
                    try {
                        algorithmParameterSpec = algorithmParameters.getParameterSpec(cls);
                        break;
                    } catch (Exception unused) {
                    }
                }
                i2++;
            }
            if (algorithmParameterSpec == null) {
                throw new InvalidAlgorithmParameterException("can't handle parameter " + algorithmParameters.toString());
            }
        }
        engineInit(i, key, algorithmParameterSpec, secureRandom);
        this.a = algorithmParameters;
    }

    public final void engineInit(int i, Key key, SecureRandom secureRandom) throws InvalidKeyException {
        try {
            engineInit(i, key, (AlgorithmParameterSpec) null, secureRandom);
        } catch (InvalidAlgorithmParameterException e2) {
            throw new InvalidKeyException(e2.getMessage());
        }
    }
}
