package org.spongycastle.crypto.ec;

import java.math.BigInteger;
import java.util.Hashtable;
import java.util.Vector;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.gm.GMObjectIdentifiers;
import org.spongycastle.asn1.sec.SECObjectIdentifiers;
import org.spongycastle.asn1.x9.X9ECParameters;
import org.spongycastle.asn1.x9.X9ECParametersHolder;
import org.spongycastle.asn1.x9.X9ECPoint;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.custom.djb.Curve25519;
import org.spongycastle.math.ec.custom.gm.SM2P256V1Curve;
import org.spongycastle.math.ec.custom.sec.SecP128R1Curve;
import org.spongycastle.math.ec.custom.sec.SecP160K1Curve;
import org.spongycastle.math.ec.custom.sec.SecP160R1Curve;
import org.spongycastle.math.ec.custom.sec.SecP160R2Curve;
import org.spongycastle.math.ec.custom.sec.SecP192K1Curve;
import org.spongycastle.math.ec.custom.sec.SecP192R1Curve;
import org.spongycastle.math.ec.custom.sec.SecP224K1Curve;
import org.spongycastle.math.ec.custom.sec.SecP224R1Curve;
import org.spongycastle.math.ec.custom.sec.SecP256K1Curve;
import org.spongycastle.math.ec.custom.sec.SecP256R1Curve;
import org.spongycastle.math.ec.custom.sec.SecP384R1Curve;
import org.spongycastle.math.ec.custom.sec.SecP521R1Curve;
import org.spongycastle.math.ec.custom.sec.SecT113R1Curve;
import org.spongycastle.math.ec.custom.sec.SecT113R2Curve;
import org.spongycastle.math.ec.custom.sec.SecT131R1Curve;
import org.spongycastle.math.ec.custom.sec.SecT131R2Curve;
import org.spongycastle.math.ec.custom.sec.SecT163K1Curve;
import org.spongycastle.math.ec.custom.sec.SecT163R1Curve;
import org.spongycastle.math.ec.custom.sec.SecT163R2Curve;
import org.spongycastle.math.ec.custom.sec.SecT193R1Curve;
import org.spongycastle.math.ec.custom.sec.SecT193R2Curve;
import org.spongycastle.math.ec.custom.sec.SecT233K1Curve;
import org.spongycastle.math.ec.custom.sec.SecT233R1Curve;
import org.spongycastle.math.ec.custom.sec.SecT239K1Curve;
import org.spongycastle.math.ec.custom.sec.SecT283K1Curve;
import org.spongycastle.math.ec.custom.sec.SecT283R1Curve;
import org.spongycastle.math.ec.custom.sec.SecT409K1Curve;
import org.spongycastle.math.ec.custom.sec.SecT409R1Curve;
import org.spongycastle.math.ec.custom.sec.SecT571K1Curve;
import org.spongycastle.math.ec.custom.sec.SecT571R1Curve;
import org.spongycastle.math.ec.endo.GLVTypeBEndomorphism;
import org.spongycastle.math.ec.endo.GLVTypeBParameters;
import org.spongycastle.util.Strings;
import org.spongycastle.util.encoders.Hex;

public class CustomNamedCurves {
    public static final Hashtable a;

    /* renamed from: a  reason: collision with other field name */
    public static final Vector f5885a;
    public static final Hashtable b = new Hashtable();
    public static final Hashtable c = new Hashtable();
    public static final Hashtable d = new Hashtable();

    static {
        AnonymousClass1 r0 = new X9ECParametersHolder() {
            public final X9ECParameters a() {
                Curve25519 curve25519 = new Curve25519();
                Hashtable hashtable = CustomNamedCurves.a;
                return new X9ECParameters((ECCurve) curve25519, new X9ECPoint((ECCurve) curve25519, Hex.a("042AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAD245A20AE19A1B8A086B4E01EDD2C7748D14C923D4D7E6D7C61B229E9C5A27ECED3D9")), curve25519.f6609a, curve25519.b, (byte[]) null);
            }
        };
        AnonymousClass2 r1 = new X9ECParametersHolder() {
            public final X9ECParameters a() {
                byte[] a = Hex.a("000E0D4D696E6768756151750CC03A4473D03679");
                SecP128R1Curve secP128R1Curve = new SecP128R1Curve();
                Hashtable hashtable = CustomNamedCurves.a;
                return new X9ECParameters((ECCurve) secP128R1Curve, new X9ECPoint((ECCurve) secP128R1Curve, Hex.a("04161FF7528B899B2D0C28607CA52C5B86CF5AC8395BAFEB13C02DA292DDED7A83")), secP128R1Curve.f6609a, secP128R1Curve.b, a);
            }
        };
        AnonymousClass3 r2 = new X9ECParametersHolder() {
            public final X9ECParameters a() {
                BigInteger bigInteger = new BigInteger("9ba48cba5ebcb9b6bd33b92830b2a2e0e192f10a", 16);
                new BigInteger("c39c6c3b3a36d7701b9c71a1f5804ae5d0003f4", 16);
                ECCurve a = CustomNamedCurves.a(new SecP160K1Curve(), new GLVTypeBParameters(bigInteger, new BigInteger[]{new BigInteger("9162fbe73984472a0a9e", 16), new BigInteger("-96341f1138933bc2f505", 16)}, new BigInteger[]{new BigInteger("127971af8721782ecffa3", 16), new BigInteger("9162fbe73984472a0a9e", 16)}, new BigInteger("9162fbe73984472a0a9d0590", 16), new BigInteger("96341f1138933bc2f503fd44", 16), 176));
                return new X9ECParameters(a, new X9ECPoint(a, Hex.a("043B4C382CE37AA192A4019E763036F4F5DD4D7EBB938CF935318FDCED6BC28286531733C3F03C4FEE")), a.f6609a, a.b, (byte[]) null);
            }
        };
        AnonymousClass4 r3 = new X9ECParametersHolder() {
            public final X9ECParameters a() {
                byte[] a = Hex.a("1053CDE42C14D696E67687561517533BF3F83345");
                SecP160R1Curve secP160R1Curve = new SecP160R1Curve();
                Hashtable hashtable = CustomNamedCurves.a;
                return new X9ECParameters((ECCurve) secP160R1Curve, new X9ECPoint((ECCurve) secP160R1Curve, Hex.a("044A96B5688EF573284664698968C38BB913CBFC8223A628553168947D59DCC912042351377AC5FB32")), secP160R1Curve.f6609a, secP160R1Curve.b, a);
            }
        };
        AnonymousClass5 r4 = new X9ECParametersHolder() {
            public final X9ECParameters a() {
                byte[] a = Hex.a("B99B99B099B323E02709A4D696E6768756151751");
                SecP160R2Curve secP160R2Curve = new SecP160R2Curve();
                Hashtable hashtable = CustomNamedCurves.a;
                return new X9ECParameters((ECCurve) secP160R2Curve, new X9ECPoint((ECCurve) secP160R2Curve, Hex.a("0452DCB034293A117E1F4FF11B30F7199D3144CE6DFEAFFEF2E331F296E071FA0DF9982CFEA7D43F2E")), secP160R2Curve.f6609a, secP160R2Curve.b, a);
            }
        };
        AnonymousClass6 r5 = new X9ECParametersHolder() {
            public final X9ECParameters a() {
                BigInteger bigInteger = new BigInteger("bb85691939b869c1d087f601554b96b80cb4f55b35f433c2", 16);
                new BigInteger("3d84f26c12238d7b4f3d516613c1759033b1a5800175d0b1", 16);
                ECCurve a = CustomNamedCurves.a(new SecP192K1Curve(), new GLVTypeBParameters(bigInteger, new BigInteger[]{new BigInteger("71169be7330b3038edb025f1", 16), new BigInteger("-b3fb3400dec5c4adceb8655c", 16)}, new BigInteger[]{new BigInteger("12511cfe811d0f4e6bc688b4d", 16), new BigInteger("71169be7330b3038edb025f1", 16)}, new BigInteger("71169be7330b3038edb025f1d0f9", 16), new BigInteger("b3fb3400dec5c4adceb8655d4c94", 16), 208));
                return new X9ECParameters(a, new X9ECPoint(a, Hex.a("04DB4FF10EC057E9AE26B07D0280B7F4341DA5D1B1EAE06C7D9B2F2F6D9C5628A7844163D015BE86344082AA88D95E2F9D")), a.f6609a, a.b, (byte[]) null);
            }
        };
        AnonymousClass7 r6 = new X9ECParametersHolder() {
            public final X9ECParameters a() {
                byte[] a = Hex.a("3045AE6FC8422F64ED579528D38120EAE12196D5");
                SecP192R1Curve secP192R1Curve = new SecP192R1Curve();
                Hashtable hashtable = CustomNamedCurves.a;
                return new X9ECParameters((ECCurve) secP192R1Curve, new X9ECPoint((ECCurve) secP192R1Curve, Hex.a("04188DA80EB03090F67CBF20EB43A18800F4FF0AFD82FF101207192B95FFC8DA78631011ED6B24CDD573F977A11E794811")), secP192R1Curve.f6609a, secP192R1Curve.b, a);
            }
        };
        AnonymousClass8 r7 = new X9ECParametersHolder() {
            public final X9ECParameters a() {
                BigInteger bigInteger = new BigInteger("fe0e87005b4e83761908c5131d552a850b3f58b749c37cf5b84d6768", 16);
                new BigInteger("60dcd2104c4cbc0be6eeefc2bdd610739ec34e317f9b33046c9e4788", 16);
                ECCurve a = CustomNamedCurves.a(new SecP224K1Curve(), new GLVTypeBParameters(bigInteger, new BigInteger[]{new BigInteger("6b8cf07d4ca75c88957d9d670591", 16), new BigInteger("-b8adf1378a6eb73409fa6c9c637d", 16)}, new BigInteger[]{new BigInteger("1243ae1b4d71613bc9f780a03690e", 16), new BigInteger("6b8cf07d4ca75c88957d9d670591", 16)}, new BigInteger("6b8cf07d4ca75c88957d9d67059037a4", 16), new BigInteger("b8adf1378a6eb73409fa6c9c637ba7f5", 16), 240));
                return new X9ECParameters(a, new X9ECPoint(a, Hex.a("04A1455B334DF099DF30FC28A169A467E9E47075A90F7E650EB6B7A45C7E089FED7FBA344282CAFBD6F7E319F7C0B0BD59E2CA4BDB556D61A5")), a.f6609a, a.b, (byte[]) null);
            }
        };
        AnonymousClass9 r8 = new X9ECParametersHolder() {
            public final X9ECParameters a() {
                byte[] a = Hex.a("BD71344799D5C7FCDC45B59FA3B9AB8F6A948BC5");
                SecP224R1Curve secP224R1Curve = new SecP224R1Curve();
                Hashtable hashtable = CustomNamedCurves.a;
                return new X9ECParameters((ECCurve) secP224R1Curve, new X9ECPoint((ECCurve) secP224R1Curve, Hex.a("04B70E0CBD6BB4BF7F321390B94A03C1D356C21122343280D6115C1D21BD376388B5F723FB4C22DFE6CD4375A05A07476444D5819985007E34")), secP224R1Curve.f6609a, secP224R1Curve.b, a);
            }
        };
        AnonymousClass10 r9 = new X9ECParametersHolder() {
            public final X9ECParameters a() {
                BigInteger bigInteger = new BigInteger("7ae96a2b657c07106e64479eac3434e99cf0497512f58995c1396c28719501ee", 16);
                new BigInteger("5363ad4cc05c30e0a5261c028812645a122e22ea20816678df02967c1b23bd72", 16);
                ECCurve a = CustomNamedCurves.a(new SecP256K1Curve(), new GLVTypeBParameters(bigInteger, new BigInteger[]{new BigInteger("3086d221a7d46bcde86c90e49284eb15", 16), new BigInteger("-e4437ed6010e88286f547fa90abfe4c3", 16)}, new BigInteger[]{new BigInteger("114ca50f7a8e2f3f657c1108d9d44cfd8", 16), new BigInteger("3086d221a7d46bcde86c90e49284eb15", 16)}, new BigInteger("3086d221a7d46bcde86c90e49284eb153dab", 16), new BigInteger("e4437ed6010e88286f547fa90abfe4c42212", 16), 272));
                return new X9ECParameters(a, new X9ECPoint(a, Hex.a("0479BE667EF9DCBBAC55A06295CE870B07029BFCDB2DCE28D959F2815B16F81798483ADA7726A3C4655DA4FBFC0E1108A8FD17B448A68554199C47D08FFB10D4B8")), a.f6609a, a.b, (byte[]) null);
            }
        };
        AnonymousClass11 r10 = new X9ECParametersHolder() {
            public final X9ECParameters a() {
                byte[] a = Hex.a("C49D360886E704936A6678E1139D26B7819F7E90");
                SecP256R1Curve secP256R1Curve = new SecP256R1Curve();
                Hashtable hashtable = CustomNamedCurves.a;
                return new X9ECParameters((ECCurve) secP256R1Curve, new X9ECPoint((ECCurve) secP256R1Curve, Hex.a("046B17D1F2E12C4247F8BCE6E563A440F277037D812DEB33A0F4A13945D898C2964FE342E2FE1A7F9B8EE7EB4A7C0F9E162BCE33576B315ECECBB6406837BF51F5")), secP256R1Curve.f6609a, secP256R1Curve.b, a);
            }
        };
        AnonymousClass12 r11 = new X9ECParametersHolder() {
            public final X9ECParameters a() {
                byte[] a = Hex.a("A335926AA319A27A1D00896A6773A4827ACDAC73");
                SecP384R1Curve secP384R1Curve = new SecP384R1Curve();
                Hashtable hashtable = CustomNamedCurves.a;
                return new X9ECParameters((ECCurve) secP384R1Curve, new X9ECPoint((ECCurve) secP384R1Curve, Hex.a("04AA87CA22BE8B05378EB1C71EF320AD746E1D3B628BA79B9859F741E082542A385502F25DBF55296C3A545E3872760AB73617DE4A96262C6F5D9E98BF9292DC29F8F41DBD289A147CE9DA3113B5F0B8C00A60B1CE1D7E819D7A431D7C90EA0E5F")), secP384R1Curve.f6609a, secP384R1Curve.b, a);
            }
        };
        AnonymousClass13 r12 = new X9ECParametersHolder() {
            public final X9ECParameters a() {
                byte[] a = Hex.a("D09E8800291CB85396CC6717393284AAA0DA64BA");
                SecP521R1Curve secP521R1Curve = new SecP521R1Curve();
                Hashtable hashtable = CustomNamedCurves.a;
                return new X9ECParameters((ECCurve) secP521R1Curve, new X9ECPoint((ECCurve) secP521R1Curve, Hex.a("0400C6858E06B70404E9CD9E3ECB662395B4429C648139053FB521F828AF606B4D3DBAA14B5E77EFE75928FE1DC127A2FFA8DE3348B3C1856A429BF97E7E31C2E5BD66011839296A789A3BC0045C8A5FB42C7D1BD998F54449579B446817AFBD17273E662C97EE72995EF42640C550B9013FAD0761353C7086A272C24088BE94769FD16650")), secP521R1Curve.f6609a, secP521R1Curve.b, a);
            }
        };
        AnonymousClass14 r13 = new X9ECParametersHolder() {
            public final X9ECParameters a() {
                byte[] a = Hex.a("10E723AB14D696E6768756151756FEBF8FCB49A9");
                SecT113R1Curve secT113R1Curve = new SecT113R1Curve();
                Hashtable hashtable = CustomNamedCurves.a;
                return new X9ECParameters((ECCurve) secT113R1Curve, new X9ECPoint((ECCurve) secT113R1Curve, Hex.a("04009D73616F35F4AB1407D73562C10F00A52830277958EE84D1315ED31886")), secT113R1Curve.f6609a, secT113R1Curve.b, a);
            }
        };
        AnonymousClass15 r14 = new X9ECParametersHolder() {
            public final X9ECParameters a() {
                byte[] a = Hex.a("10C0FB15760860DEF1EEF4D696E676875615175D");
                SecT113R2Curve secT113R2Curve = new SecT113R2Curve();
                Hashtable hashtable = CustomNamedCurves.a;
                return new X9ECParameters((ECCurve) secT113R2Curve, new X9ECPoint((ECCurve) secT113R2Curve, Hex.a("0401A57A6A7B26CA5EF52FCDB816479700B3ADC94ED1FE674C06E695BABA1D")), secT113R2Curve.f6609a, secT113R2Curve.b, a);
            }
        };
        AnonymousClass16 r16 = new X9ECParametersHolder() {
            public final X9ECParameters a() {
                byte[] a = Hex.a("4D696E676875615175985BD3ADBADA21B43A97E2");
                SecT131R1Curve secT131R1Curve = new SecT131R1Curve();
                Hashtable hashtable = CustomNamedCurves.a;
                return new X9ECParameters((ECCurve) secT131R1Curve, new X9ECPoint((ECCurve) secT131R1Curve, Hex.a("040081BAF91FDF9833C40F9C181343638399078C6E7EA38C001F73C8134B1B4EF9E150")), secT131R1Curve.f6609a, secT131R1Curve.b, a);
            }
        };
        AnonymousClass17 r17 = new X9ECParametersHolder() {
            public final X9ECParameters a() {
                byte[] a = Hex.a("985BD3ADBAD4D696E676875615175A21B43A97E3");
                SecT131R2Curve secT131R2Curve = new SecT131R2Curve();
                Hashtable hashtable = CustomNamedCurves.a;
                return new X9ECParameters((ECCurve) secT131R2Curve, new X9ECPoint((ECCurve) secT131R2Curve, Hex.a("040356DCD8F2F95031AD652D23951BB366A80648F06D867940A5366D9E265DE9EB240F")), secT131R2Curve.f6609a, secT131R2Curve.b, a);
            }
        };
        AnonymousClass18 r18 = new X9ECParametersHolder() {
            public final X9ECParameters a() {
                SecT163K1Curve secT163K1Curve = new SecT163K1Curve();
                Hashtable hashtable = CustomNamedCurves.a;
                return new X9ECParameters((ECCurve) secT163K1Curve, new X9ECPoint((ECCurve) secT163K1Curve, Hex.a("0402FE13C0537BBC11ACAA07D793DE4E6D5E5C94EEE80289070FB05D38FF58321F2E800536D538CCDAA3D9")), secT163K1Curve.f6609a, secT163K1Curve.b, (byte[]) null);
            }
        };
        AnonymousClass19 r19 = new X9ECParametersHolder() {
            public final X9ECParameters a() {
                byte[] a = Hex.a("24B7B137C8A14D696E6768756151756FD0DA2E5C");
                SecT163R1Curve secT163R1Curve = new SecT163R1Curve();
                Hashtable hashtable = CustomNamedCurves.a;
                return new X9ECParameters((ECCurve) secT163R1Curve, new X9ECPoint((ECCurve) secT163R1Curve, Hex.a("040369979697AB43897789566789567F787A7876A65400435EDB42EFAFB2989D51FEFCE3C80988F41FF883")), secT163R1Curve.f6609a, secT163R1Curve.b, a);
            }
        };
        AnonymousClass20 r20 = new X9ECParametersHolder() {
            public final X9ECParameters a() {
                byte[] a = Hex.a("85E25BFE5C86226CDB12016F7553F9D0E693A268");
                SecT163R2Curve secT163R2Curve = new SecT163R2Curve();
                Hashtable hashtable = CustomNamedCurves.a;
                return new X9ECParameters((ECCurve) secT163R2Curve, new X9ECPoint((ECCurve) secT163R2Curve, Hex.a("0403F0EBA16286A2D57EA0991168D4994637E8343E3600D51FBC6C71A0094FA2CDD545B11C5C0C797324F1")), secT163R2Curve.f6609a, secT163R2Curve.b, a);
            }
        };
        AnonymousClass21 r21 = new X9ECParametersHolder() {
            public final X9ECParameters a() {
                byte[] a = Hex.a("103FAEC74D696E676875615175777FC5B191EF30");
                SecT193R1Curve secT193R1Curve = new SecT193R1Curve();
                Hashtable hashtable = CustomNamedCurves.a;
                return new X9ECParameters((ECCurve) secT193R1Curve, new X9ECPoint((ECCurve) secT193R1Curve, Hex.a("0401F481BC5F0FF84A74AD6CDF6FDEF4BF6179625372D8C0C5E10025E399F2903712CCF3EA9E3A1AD17FB0B3201B6AF7CE1B05")), secT193R1Curve.f6609a, secT193R1Curve.b, a);
            }
        };
        AnonymousClass22 r22 = new X9ECParametersHolder() {
            public final X9ECParameters a() {
                byte[] a = Hex.a("10B7B4D696E676875615175137C8A16FD0DA2211");
                SecT193R2Curve secT193R2Curve = new SecT193R2Curve();
                Hashtable hashtable = CustomNamedCurves.a;
                return new X9ECParameters((ECCurve) secT193R2Curve, new X9ECPoint((ECCurve) secT193R2Curve, Hex.a("0400D9B67D192E0367C803F39E1A7E82CA14A651350AAE617E8F01CE94335607C304AC29E7DEFBD9CA01F596F927224CDECF6C")), secT193R2Curve.f6609a, secT193R2Curve.b, a);
            }
        };
        AnonymousClass23 r23 = new X9ECParametersHolder() {
            public final X9ECParameters a() {
                SecT233K1Curve secT233K1Curve = new SecT233K1Curve();
                Hashtable hashtable = CustomNamedCurves.a;
                return new X9ECParameters((ECCurve) secT233K1Curve, new X9ECPoint((ECCurve) secT233K1Curve, Hex.a("04017232BA853A7E731AF129F22FF4149563A419C26BF50A4C9D6EEFAD612601DB537DECE819B7F70F555A67C427A8CD9BF18AEB9B56E0C11056FAE6A3")), secT233K1Curve.f6609a, secT233K1Curve.b, (byte[]) null);
            }
        };
        AnonymousClass24 r24 = new X9ECParametersHolder() {
            public final X9ECParameters a() {
                byte[] a = Hex.a("74D59FF07F6B413D0EA14B344B20A2DB049B50C3");
                SecT233R1Curve secT233R1Curve = new SecT233R1Curve();
                Hashtable hashtable = CustomNamedCurves.a;
                return new X9ECParameters((ECCurve) secT233R1Curve, new X9ECPoint((ECCurve) secT233R1Curve, Hex.a("0400FAC9DFCBAC8313BB2139F1BB755FEF65BC391F8B36F8F8EB7371FD558B01006A08A41903350678E58528BEBF8A0BEFF867A7CA36716F7E01F81052")), secT233R1Curve.f6609a, secT233R1Curve.b, a);
            }
        };
        AnonymousClass25 r25 = new X9ECParametersHolder() {
            public final X9ECParameters a() {
                SecT239K1Curve secT239K1Curve = new SecT239K1Curve();
                Hashtable hashtable = CustomNamedCurves.a;
                return new X9ECParameters((ECCurve) secT239K1Curve, new X9ECPoint((ECCurve) secT239K1Curve, Hex.a("0429A0B6A887A983E9730988A68727A8B2D126C44CC2CC7B2A6555193035DC76310804F12E549BDB011C103089E73510ACB275FC312A5DC6B76553F0CA")), secT239K1Curve.f6609a, secT239K1Curve.b, (byte[]) null);
            }
        };
        AnonymousClass26 r26 = new X9ECParametersHolder() {
            public final X9ECParameters a() {
                SecT283K1Curve secT283K1Curve = new SecT283K1Curve();
                Hashtable hashtable = CustomNamedCurves.a;
                return new X9ECParameters((ECCurve) secT283K1Curve, new X9ECPoint((ECCurve) secT283K1Curve, Hex.a("040503213F78CA44883F1A3B8162F188E553CD265F23C1567A16876913B0C2AC245849283601CCDA380F1C9E318D90F95D07E5426FE87E45C0E8184698E45962364E34116177DD2259")), secT283K1Curve.f6609a, secT283K1Curve.b, (byte[]) null);
            }
        };
        AnonymousClass27 r27 = new X9ECParametersHolder() {
            public final X9ECParameters a() {
                byte[] a = Hex.a("77E2B07370EB0F832A6DD5B62DFC88CD06BB84BE");
                SecT283R1Curve secT283R1Curve = new SecT283R1Curve();
                Hashtable hashtable = CustomNamedCurves.a;
                return new X9ECParameters((ECCurve) secT283R1Curve, new X9ECPoint((ECCurve) secT283R1Curve, Hex.a("0405F939258DB7DD90E1934F8C70B0DFEC2EED25B8557EAC9C80E2E198F8CDBECD86B1205303676854FE24141CB98FE6D4B20D02B4516FF702350EDDB0826779C813F0DF45BE8112F4")), secT283R1Curve.f6609a, secT283R1Curve.b, a);
            }
        };
        AnonymousClass28 r28 = new X9ECParametersHolder() {
            public final X9ECParameters a() {
                SecT409K1Curve secT409K1Curve = new SecT409K1Curve();
                Hashtable hashtable = CustomNamedCurves.a;
                return new X9ECParameters((ECCurve) secT409K1Curve, new X9ECPoint((ECCurve) secT409K1Curve, Hex.a("040060F05F658F49C1AD3AB1890F7184210EFD0987E307C84C27ACCFB8F9F67CC2C460189EB5AAAA62EE222EB1B35540CFE902374601E369050B7C4E42ACBA1DACBF04299C3460782F918EA427E6325165E9EA10E3DA5F6C42E9C55215AA9CA27A5863EC48D8E0286B")), secT409K1Curve.f6609a, secT409K1Curve.b, (byte[]) null);
            }
        };
        AnonymousClass29 r29 = new X9ECParametersHolder() {
            public final X9ECParameters a() {
                byte[] a = Hex.a("4099B5A457F9D69F79213D094C4BCD4D4262210B");
                SecT409R1Curve secT409R1Curve = new SecT409R1Curve();
                Hashtable hashtable = CustomNamedCurves.a;
                return new X9ECParameters((ECCurve) secT409R1Curve, new X9ECPoint((ECCurve) secT409R1Curve, Hex.a("04015D4860D088DDB3496B0C6064756260441CDE4AF1771D4DB01FFE5B34E59703DC255A868A1180515603AEAB60794E54BB7996A70061B1CFAB6BE5F32BBFA78324ED106A7636B9C5A7BD198D0158AA4F5488D08F38514F1FDF4B4F40D2181B3681C364BA0273C706")), secT409R1Curve.f6609a, secT409R1Curve.b, a);
            }
        };
        AnonymousClass30 r30 = new X9ECParametersHolder() {
            public final X9ECParameters a() {
                SecT571K1Curve secT571K1Curve = new SecT571K1Curve();
                Hashtable hashtable = CustomNamedCurves.a;
                return new X9ECParameters((ECCurve) secT571K1Curve, new X9ECPoint((ECCurve) secT571K1Curve, Hex.a("04026EB7A859923FBC82189631F8103FE4AC9CA2970012D5D46024804801841CA44370958493B205E647DA304DB4CEB08CBBD1BA39494776FB988B47174DCA88C7E2945283A01C89720349DC807F4FBF374F4AEADE3BCA95314DD58CEC9F307A54FFC61EFC006D8A2C9D4979C0AC44AEA74FBEBBB9F772AEDCB620B01A7BA7AF1B320430C8591984F601CD4C143EF1C7A3")), secT571K1Curve.f6609a, secT571K1Curve.b, (byte[]) null);
            }
        };
        AnonymousClass31 r31 = new X9ECParametersHolder() {
            public final X9ECParameters a() {
                byte[] a = Hex.a("2AA058F73A0E33AB486B0F610410C53A7F132310");
                SecT571R1Curve secT571R1Curve = new SecT571R1Curve();
                Hashtable hashtable = CustomNamedCurves.a;
                return new X9ECParameters((ECCurve) secT571R1Curve, new X9ECPoint((ECCurve) secT571R1Curve, Hex.a("040303001D34B856296C16C0D40D3CD7750A93D1D2955FA80AA5F40FC8DB7B2ABDBDE53950F4C0D293CDD711A35B67FB1499AE60038614F1394ABFA3B4C850D927E1E7769C8EEC2D19037BF27342DA639B6DCCFFFEB73D69D78C6C27A6009CBBCA1980F8533921E8A684423E43BAB08A576291AF8F461BB2A8B3531D2F0485C19B16E2F1516E23DD3C1A4827AF1B8AC15B")), secT571R1Curve.f6609a, secT571R1Curve.b, a);
            }
        };
        AnonymousClass32 r32 = new X9ECParametersHolder() {
            public final X9ECParameters a() {
                SM2P256V1Curve sM2P256V1Curve = new SM2P256V1Curve();
                Hashtable hashtable = CustomNamedCurves.a;
                return new X9ECParameters((ECCurve) sM2P256V1Curve, new X9ECPoint((ECCurve) sM2P256V1Curve, Hex.a("0432C4AE2C1F1981195F9904466A39C9948FE30BBFF2660BE1715A4589334C74C7BC3736A2F4F6779C59BDCEE36B692153D0A9877CC62A474002DF32E52139F0A0")), sM2P256V1Curve.f6609a, sM2P256V1Curve.b, (byte[]) null);
            }
        };
        Hashtable hashtable = new Hashtable();
        a = hashtable;
        AnonymousClass15 r33 = r14;
        Vector vector = new Vector();
        f5885a = vector;
        vector.addElement("curve25519");
        hashtable.put(Strings.e("curve25519"), r0);
        c("secp128r1", SECObjectIdentifiers.t, r1);
        c("secp160k1", SECObjectIdentifiers.i, r2);
        c("secp160r1", SECObjectIdentifiers.h, r3);
        c("secp160r2", SECObjectIdentifiers.v, r4);
        c("secp192k1", SECObjectIdentifiers.w, r5);
        ASN1ObjectIdentifier aSN1ObjectIdentifier = SECObjectIdentifiers.F;
        c("secp192r1", aSN1ObjectIdentifier, r6);
        c("secp224k1", SECObjectIdentifiers.x, r7);
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = SECObjectIdentifiers.y;
        c("secp224r1", aSN1ObjectIdentifier2, r8);
        c("secp256k1", SECObjectIdentifiers.j, r9);
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = SECObjectIdentifiers.G;
        c("secp256r1", aSN1ObjectIdentifier3, r10);
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = SECObjectIdentifiers.z;
        c("secp384r1", aSN1ObjectIdentifier4, r11);
        ASN1ObjectIdentifier aSN1ObjectIdentifier5 = SECObjectIdentifiers.A;
        c("secp521r1", aSN1ObjectIdentifier5, r12);
        c("sect113r1", SECObjectIdentifiers.d, r13);
        c("sect113r2", SECObjectIdentifiers.e, r33);
        c("sect131r1", SECObjectIdentifiers.n, r16);
        c("sect131r2", SECObjectIdentifiers.o, r17);
        ASN1ObjectIdentifier aSN1ObjectIdentifier6 = SECObjectIdentifiers.a;
        c("sect163k1", aSN1ObjectIdentifier6, r18);
        c("sect163r1", SECObjectIdentifiers.b, r19);
        ASN1ObjectIdentifier aSN1ObjectIdentifier7 = SECObjectIdentifiers.k;
        c("sect163r2", aSN1ObjectIdentifier7, r20);
        c("sect193r1", SECObjectIdentifiers.p, r21);
        c("sect193r2", SECObjectIdentifiers.q, r22);
        ASN1ObjectIdentifier aSN1ObjectIdentifier8 = SECObjectIdentifiers.r;
        c("sect233k1", aSN1ObjectIdentifier8, r23);
        ASN1ObjectIdentifier aSN1ObjectIdentifier9 = SECObjectIdentifiers.s;
        c("sect233r1", aSN1ObjectIdentifier9, r24);
        c("sect239k1", SECObjectIdentifiers.c, r25);
        ASN1ObjectIdentifier aSN1ObjectIdentifier10 = SECObjectIdentifiers.l;
        c("sect283k1", aSN1ObjectIdentifier10, r26);
        ASN1ObjectIdentifier aSN1ObjectIdentifier11 = SECObjectIdentifiers.m;
        c("sect283r1", aSN1ObjectIdentifier11, r27);
        ASN1ObjectIdentifier aSN1ObjectIdentifier12 = SECObjectIdentifiers.B;
        c("sect409k1", aSN1ObjectIdentifier12, r28);
        ASN1ObjectIdentifier aSN1ObjectIdentifier13 = SECObjectIdentifiers.C;
        c("sect409r1", aSN1ObjectIdentifier13, r29);
        ASN1ObjectIdentifier aSN1ObjectIdentifier14 = SECObjectIdentifiers.D;
        c("sect571k1", aSN1ObjectIdentifier14, r30);
        ASN1ObjectIdentifier aSN1ObjectIdentifier15 = SECObjectIdentifiers.E;
        c("sect571r1", aSN1ObjectIdentifier15, r31);
        c("sm2p256v1", GMObjectIdentifiers.a, r32);
        b("B-163", aSN1ObjectIdentifier7);
        b("B-233", aSN1ObjectIdentifier9);
        b("B-283", aSN1ObjectIdentifier11);
        b("B-409", aSN1ObjectIdentifier13);
        b("B-571", aSN1ObjectIdentifier15);
        b("K-163", aSN1ObjectIdentifier6);
        b("K-233", aSN1ObjectIdentifier8);
        b("K-283", aSN1ObjectIdentifier10);
        b("K-409", aSN1ObjectIdentifier12);
        b("K-571", aSN1ObjectIdentifier14);
        b("P-192", aSN1ObjectIdentifier);
        b("P-224", aSN1ObjectIdentifier2);
        b("P-256", aSN1ObjectIdentifier3);
        b("P-384", aSN1ObjectIdentifier4);
        b("P-521", aSN1ObjectIdentifier5);
    }

    public static ECCurve a(ECCurve.AbstractFp abstractFp, GLVTypeBParameters gLVTypeBParameters) {
        ECCurve.Config b2 = abstractFp.b();
        b2.f6617a = new GLVTypeBEndomorphism(abstractFp, gLVTypeBParameters);
        return b2.a();
    }

    public static void b(String str, ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        Object obj = c.get(aSN1ObjectIdentifier);
        if (obj != null) {
            String e = Strings.e(str);
            b.put(e, aSN1ObjectIdentifier);
            a.put(e, obj);
            return;
        }
        throw new IllegalStateException();
    }

    public static void c(String str, ASN1ObjectIdentifier aSN1ObjectIdentifier, X9ECParametersHolder x9ECParametersHolder) {
        f5885a.addElement(str);
        d.put(aSN1ObjectIdentifier, str);
        c.put(aSN1ObjectIdentifier, x9ECParametersHolder);
        String e = Strings.e(str);
        b.put(e, aSN1ObjectIdentifier);
        a.put(e, x9ECParametersHolder);
    }

    public static X9ECParameters d(String str) {
        X9ECParametersHolder x9ECParametersHolder = (X9ECParametersHolder) a.get(Strings.e(str));
        if (x9ECParametersHolder == null) {
            return null;
        }
        return x9ECParametersHolder.b();
    }
}
