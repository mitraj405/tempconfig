package org.spongycastle.pqc.asn1;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.pqc.crypto.rainbow.Layer;
import org.spongycastle.pqc.crypto.rainbow.util.RainbowUtil;

public class RainbowPrivateKey extends ASN1Object {
    public final ASN1ObjectIdentifier Z0;
    public final ASN1Integer a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f6647a;

    /* renamed from: a  reason: collision with other field name */
    public final Layer[] f6648a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[][] f6649a;
    public final byte[] b;

    /* renamed from: b  reason: collision with other field name */
    public final byte[][] f6650b;
    public final byte[] c;

    public RainbowPrivateKey(ASN1Sequence aSN1Sequence) {
        ASN1Sequence aSN1Sequence2 = aSN1Sequence;
        int i = 0;
        if (aSN1Sequence2.s(0) instanceof ASN1Integer) {
            this.a = ASN1Integer.q(aSN1Sequence2.s(0));
        } else {
            this.Z0 = ASN1ObjectIdentifier.u(aSN1Sequence2.s(0));
        }
        ASN1Sequence aSN1Sequence3 = (ASN1Sequence) aSN1Sequence2.s(1);
        this.f6649a = new byte[aSN1Sequence3.size()][];
        for (int i2 = 0; i2 < aSN1Sequence3.size(); i2++) {
            this.f6649a[i2] = ((ASN1OctetString) aSN1Sequence3.s(i2)).s();
        }
        this.f6647a = ((ASN1OctetString) ((ASN1Sequence) aSN1Sequence2.s(2)).s(0)).s();
        ASN1Sequence aSN1Sequence4 = (ASN1Sequence) aSN1Sequence2.s(3);
        this.f6650b = new byte[aSN1Sequence4.size()][];
        for (int i3 = 0; i3 < aSN1Sequence4.size(); i3++) {
            this.f6650b[i3] = ((ASN1OctetString) aSN1Sequence4.s(i3)).s();
        }
        this.b = ((ASN1OctetString) ((ASN1Sequence) aSN1Sequence2.s(4)).s(0)).s();
        this.c = ((ASN1OctetString) ((ASN1Sequence) aSN1Sequence2.s(5)).s(0)).s();
        ASN1Sequence aSN1Sequence5 = (ASN1Sequence) aSN1Sequence2.s(6);
        byte[][][][] bArr = new byte[aSN1Sequence5.size()][][][];
        byte[][][][] bArr2 = new byte[aSN1Sequence5.size()][][][];
        byte[][][] bArr3 = new byte[aSN1Sequence5.size()][][];
        byte[][] bArr4 = new byte[aSN1Sequence5.size()][];
        int i4 = 0;
        while (i4 < aSN1Sequence5.size()) {
            ASN1Sequence aSN1Sequence6 = (ASN1Sequence) aSN1Sequence5.s(i4);
            ASN1Sequence aSN1Sequence7 = (ASN1Sequence) aSN1Sequence6.s(i);
            bArr[i4] = new byte[aSN1Sequence7.size()][][];
            for (int i5 = i; i5 < aSN1Sequence7.size(); i5++) {
                ASN1Sequence aSN1Sequence8 = (ASN1Sequence) aSN1Sequence7.s(i5);
                bArr[i4][i5] = new byte[aSN1Sequence8.size()][];
                for (int i6 = 0; i6 < aSN1Sequence8.size(); i6++) {
                    bArr[i4][i5][i6] = ((ASN1OctetString) aSN1Sequence8.s(i6)).s();
                }
            }
            ASN1Sequence aSN1Sequence9 = (ASN1Sequence) aSN1Sequence6.s(1);
            bArr2[i4] = new byte[aSN1Sequence9.size()][][];
            for (int i7 = 0; i7 < aSN1Sequence9.size(); i7++) {
                ASN1Sequence aSN1Sequence10 = (ASN1Sequence) aSN1Sequence9.s(i7);
                bArr2[i4][i7] = new byte[aSN1Sequence10.size()][];
                for (int i8 = 0; i8 < aSN1Sequence10.size(); i8++) {
                    bArr2[i4][i7][i8] = ((ASN1OctetString) aSN1Sequence10.s(i8)).s();
                }
            }
            ASN1Sequence aSN1Sequence11 = (ASN1Sequence) aSN1Sequence6.s(2);
            bArr3[i4] = new byte[aSN1Sequence11.size()][];
            for (int i9 = 0; i9 < aSN1Sequence11.size(); i9++) {
                bArr3[i4][i9] = ((ASN1OctetString) aSN1Sequence11.s(i9)).s();
            }
            bArr4[i4] = ((ASN1OctetString) aSN1Sequence6.s(3)).s();
            i4++;
            i = 0;
        }
        int length = this.c.length - 1;
        this.f6648a = new Layer[length];
        int i10 = 0;
        while (i10 < length) {
            byte[] bArr5 = this.c;
            int i11 = i10 + 1;
            this.f6648a[i10] = new Layer(bArr5[i10], bArr5[i11], RainbowUtil.f(bArr[i10]), RainbowUtil.f(bArr2[i10]), RainbowUtil.d(bArr3[i10]), RainbowUtil.b(bArr4[i10]));
            i10 = i11;
        }
    }

    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        ASN1Integer aSN1Integer = this.a;
        if (aSN1Integer != null) {
            aSN1EncodableVector.a(aSN1Integer);
        } else {
            aSN1EncodableVector.a(this.Z0);
        }
        ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
        int i = 0;
        while (true) {
            byte[][] bArr = this.f6649a;
            if (i >= bArr.length) {
                break;
            }
            aSN1EncodableVector2.a(new DEROctetString(bArr[i]));
            i++;
        }
        aSN1EncodableVector.a(new DERSequence(aSN1EncodableVector2));
        ASN1EncodableVector aSN1EncodableVector3 = new ASN1EncodableVector();
        aSN1EncodableVector3.a(new DEROctetString(this.f6647a));
        aSN1EncodableVector.a(new DERSequence(aSN1EncodableVector3));
        ASN1EncodableVector aSN1EncodableVector4 = new ASN1EncodableVector();
        int i2 = 0;
        while (true) {
            byte[][] bArr2 = this.f6650b;
            if (i2 >= bArr2.length) {
                break;
            }
            aSN1EncodableVector4.a(new DEROctetString(bArr2[i2]));
            i2++;
        }
        aSN1EncodableVector.a(new DERSequence(aSN1EncodableVector4));
        ASN1EncodableVector aSN1EncodableVector5 = new ASN1EncodableVector();
        aSN1EncodableVector5.a(new DEROctetString(this.b));
        aSN1EncodableVector.a(new DERSequence(aSN1EncodableVector5));
        ASN1EncodableVector aSN1EncodableVector6 = new ASN1EncodableVector();
        aSN1EncodableVector6.a(new DEROctetString(this.c));
        aSN1EncodableVector.a(new DERSequence(aSN1EncodableVector6));
        ASN1EncodableVector aSN1EncodableVector7 = new ASN1EncodableVector();
        int i3 = 0;
        while (true) {
            Layer[] layerArr = this.f6648a;
            if (i3 < layerArr.length) {
                ASN1EncodableVector aSN1EncodableVector8 = new ASN1EncodableVector();
                byte[][][] e = RainbowUtil.e(layerArr[i3].f6724a);
                ASN1EncodableVector aSN1EncodableVector9 = new ASN1EncodableVector();
                for (byte[][] bArr3 : e) {
                    ASN1EncodableVector aSN1EncodableVector10 = new ASN1EncodableVector();
                    int i4 = 0;
                    while (true) {
                        if (i4 >= bArr3.length) {
                            break;
                        }
                        aSN1EncodableVector10.a(new DEROctetString(bArr3[i4]));
                        i4++;
                    }
                    aSN1EncodableVector9.a(new DERSequence(aSN1EncodableVector10));
                }
                aSN1EncodableVector8.a(new DERSequence(aSN1EncodableVector9));
                byte[][][] e2 = RainbowUtil.e(layerArr[i3].f6725b);
                ASN1EncodableVector aSN1EncodableVector11 = new ASN1EncodableVector();
                for (byte[][] bArr4 : e2) {
                    ASN1EncodableVector aSN1EncodableVector12 = new ASN1EncodableVector();
                    int i5 = 0;
                    while (true) {
                        if (i5 >= bArr4.length) {
                            break;
                        }
                        aSN1EncodableVector12.a(new DEROctetString(bArr4[i5]));
                        i5++;
                    }
                    aSN1EncodableVector11.a(new DERSequence(aSN1EncodableVector12));
                }
                aSN1EncodableVector8.a(new DERSequence(aSN1EncodableVector11));
                byte[][] c2 = RainbowUtil.c(layerArr[i3].f6723a);
                ASN1EncodableVector aSN1EncodableVector13 = new ASN1EncodableVector();
                for (byte[] dEROctetString : c2) {
                    aSN1EncodableVector13.a(new DEROctetString(dEROctetString));
                }
                aSN1EncodableVector8.a(new DERSequence(aSN1EncodableVector13));
                aSN1EncodableVector8.a(new DEROctetString(RainbowUtil.a(layerArr[i3].f6722a)));
                aSN1EncodableVector7.a(new DERSequence(aSN1EncodableVector8));
                i3++;
            } else {
                aSN1EncodableVector.a(new DERSequence(aSN1EncodableVector7));
                return new DERSequence(aSN1EncodableVector);
            }
        }
    }

    public RainbowPrivateKey(short[][] sArr, short[] sArr2, short[][] sArr3, short[] sArr4, int[] iArr, Layer[] layerArr) {
        this.a = new ASN1Integer(1);
        this.f6649a = RainbowUtil.c(sArr);
        this.f6647a = RainbowUtil.a(sArr2);
        this.f6650b = RainbowUtil.c(sArr3);
        this.b = RainbowUtil.a(sArr4);
        byte[] bArr = new byte[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            bArr[i] = (byte) iArr[i];
        }
        this.c = bArr;
        this.f6648a = layerArr;
    }
}
