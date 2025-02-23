package org.spongycastle.asn1.util;

import java.io.IOException;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1ApplicationSpecific;
import org.spongycastle.asn1.ASN1Boolean;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Enumerated;
import org.spongycastle.asn1.ASN1GeneralizedTime;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.ASN1UTCTime;
import org.spongycastle.asn1.BERApplicationSpecific;
import org.spongycastle.asn1.BEROctetString;
import org.spongycastle.asn1.BERSequence;
import org.spongycastle.asn1.BERSet;
import org.spongycastle.asn1.BERTaggedObject;
import org.spongycastle.asn1.DERApplicationSpecific;
import org.spongycastle.asn1.DERBMPString;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERExternal;
import org.spongycastle.asn1.DERGraphicString;
import org.spongycastle.asn1.DERIA5String;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.DERPrintableString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERT61String;
import org.spongycastle.asn1.DERUTF8String;
import org.spongycastle.asn1.DERVideotexString;
import org.spongycastle.asn1.DERVisibleString;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Strings;
import org.spongycastle.util.encoders.Hex;

public class ASN1Dump {
    public static void a(String str, ASN1Primitive aSN1Primitive, StringBuffer stringBuffer) {
        String str2 = Strings.a;
        if (aSN1Primitive instanceof ASN1Sequence) {
            Enumeration t = ((ASN1Sequence) aSN1Primitive).t();
            String str3 = str + "    ";
            stringBuffer.append(str);
            if (aSN1Primitive instanceof BERSequence) {
                stringBuffer.append("BER Sequence");
            } else if (aSN1Primitive instanceof DERSequence) {
                stringBuffer.append("DER Sequence");
            } else {
                stringBuffer.append("Sequence");
            }
            stringBuffer.append(str2);
            while (t.hasMoreElements()) {
                Object nextElement = t.nextElement();
                if (nextElement == null || nextElement.equals(DERNull.a)) {
                    stringBuffer.append(str3);
                    stringBuffer.append("NULL");
                    stringBuffer.append(str2);
                } else if (nextElement instanceof ASN1Primitive) {
                    a(str3, (ASN1Primitive) nextElement, stringBuffer);
                } else {
                    a(str3, ((ASN1Encodable) nextElement).b(), stringBuffer);
                }
            }
        } else if (aSN1Primitive instanceof ASN1TaggedObject) {
            String str4 = str + "    ";
            stringBuffer.append(str);
            if (aSN1Primitive instanceof BERTaggedObject) {
                stringBuffer.append("BER Tagged [");
            } else {
                stringBuffer.append("Tagged [");
            }
            ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) aSN1Primitive;
            stringBuffer.append(Integer.toString(aSN1TaggedObject.c));
            stringBuffer.append(']');
            if (!aSN1TaggedObject.f5664a) {
                stringBuffer.append(" IMPLICIT ");
            }
            stringBuffer.append(str2);
            a(str4, aSN1TaggedObject.r(), stringBuffer);
        } else if (aSN1Primitive instanceof ASN1Set) {
            Enumeration t2 = ((ASN1Set) aSN1Primitive).t();
            String str5 = str + "    ";
            stringBuffer.append(str);
            if (aSN1Primitive instanceof BERSet) {
                stringBuffer.append("BER Set");
            } else {
                stringBuffer.append("DER Set");
            }
            stringBuffer.append(str2);
            while (t2.hasMoreElements()) {
                Object nextElement2 = t2.nextElement();
                if (nextElement2 == null) {
                    stringBuffer.append(str5);
                    stringBuffer.append("NULL");
                    stringBuffer.append(str2);
                } else if (nextElement2 instanceof ASN1Primitive) {
                    a(str5, (ASN1Primitive) nextElement2, stringBuffer);
                } else {
                    a(str5, ((ASN1Encodable) nextElement2).b(), stringBuffer);
                }
            }
        } else if (aSN1Primitive instanceof ASN1OctetString) {
            ASN1OctetString aSN1OctetString = (ASN1OctetString) aSN1Primitive;
            if (aSN1Primitive instanceof BEROctetString) {
                StringBuilder n = lf.n(str, "BER Constructed Octet String[");
                n.append(aSN1OctetString.s().length);
                n.append("] ");
                stringBuffer.append(n.toString());
            } else {
                StringBuilder n2 = lf.n(str, "DER Octet String[");
                n2.append(aSN1OctetString.s().length);
                n2.append("] ");
                stringBuffer.append(n2.toString());
            }
            stringBuffer.append(str2);
        } else if (aSN1Primitive instanceof ASN1ObjectIdentifier) {
            StringBuilder n3 = lf.n(str, "ObjectIdentifier(");
            n3.append(((ASN1ObjectIdentifier) aSN1Primitive).c);
            n3.append(")");
            n3.append(str2);
            stringBuffer.append(n3.toString());
        } else if (aSN1Primitive instanceof ASN1Boolean) {
            StringBuilder n4 = lf.n(str, "Boolean(");
            n4.append(((ASN1Boolean) aSN1Primitive).t());
            n4.append(")");
            n4.append(str2);
            stringBuffer.append(n4.toString());
        } else if (aSN1Primitive instanceof ASN1Integer) {
            StringBuilder n5 = lf.n(str, "Integer(");
            n5.append(((ASN1Integer) aSN1Primitive).t());
            n5.append(")");
            n5.append(str2);
            stringBuffer.append(n5.toString());
        } else if (aSN1Primitive instanceof DERBitString) {
            DERBitString dERBitString = (DERBitString) aSN1Primitive;
            StringBuilder n6 = lf.n(str, "DER Bit String[");
            n6.append(dERBitString.r().length);
            n6.append(", ");
            n6.append(dERBitString.c);
            n6.append("] ");
            stringBuffer.append(n6.toString());
            stringBuffer.append(str2);
        } else if (aSN1Primitive instanceof DERIA5String) {
            StringBuilder n7 = lf.n(str, "IA5String(");
            n7.append(((DERIA5String) aSN1Primitive).c());
            n7.append(") ");
            n7.append(str2);
            stringBuffer.append(n7.toString());
        } else if (aSN1Primitive instanceof DERUTF8String) {
            StringBuilder n8 = lf.n(str, "UTF8String(");
            n8.append(((DERUTF8String) aSN1Primitive).c());
            n8.append(") ");
            n8.append(str2);
            stringBuffer.append(n8.toString());
        } else if (aSN1Primitive instanceof DERPrintableString) {
            StringBuilder n9 = lf.n(str, "PrintableString(");
            n9.append(((DERPrintableString) aSN1Primitive).c());
            n9.append(") ");
            n9.append(str2);
            stringBuffer.append(n9.toString());
        } else if (aSN1Primitive instanceof DERVisibleString) {
            StringBuilder n10 = lf.n(str, "VisibleString(");
            n10.append(((DERVisibleString) aSN1Primitive).c());
            n10.append(") ");
            n10.append(str2);
            stringBuffer.append(n10.toString());
        } else if (aSN1Primitive instanceof DERBMPString) {
            StringBuilder n11 = lf.n(str, "BMPString(");
            n11.append(((DERBMPString) aSN1Primitive).c());
            n11.append(") ");
            n11.append(str2);
            stringBuffer.append(n11.toString());
        } else if (aSN1Primitive instanceof DERT61String) {
            StringBuilder n12 = lf.n(str, "T61String(");
            n12.append(((DERT61String) aSN1Primitive).c());
            n12.append(") ");
            n12.append(str2);
            stringBuffer.append(n12.toString());
        } else if (aSN1Primitive instanceof DERGraphicString) {
            StringBuilder n13 = lf.n(str, "GraphicString(");
            n13.append(((DERGraphicString) aSN1Primitive).c());
            n13.append(") ");
            n13.append(str2);
            stringBuffer.append(n13.toString());
        } else if (aSN1Primitive instanceof DERVideotexString) {
            StringBuilder n14 = lf.n(str, "VideotexString(");
            n14.append(((DERVideotexString) aSN1Primitive).c());
            n14.append(") ");
            n14.append(str2);
            stringBuffer.append(n14.toString());
        } else if (aSN1Primitive instanceof ASN1UTCTime) {
            StringBuilder n15 = lf.n(str, "UTCTime(");
            n15.append(((ASN1UTCTime) aSN1Primitive).q());
            n15.append(") ");
            n15.append(str2);
            stringBuffer.append(n15.toString());
        } else if (aSN1Primitive instanceof ASN1GeneralizedTime) {
            StringBuilder n16 = lf.n(str, "GeneralizedTime(");
            n16.append(((ASN1GeneralizedTime) aSN1Primitive).s());
            n16.append(") ");
            n16.append(str2);
            stringBuffer.append(n16.toString());
        } else if (aSN1Primitive instanceof BERApplicationSpecific) {
            stringBuffer.append(c("BER", str, aSN1Primitive, str2));
        } else if (aSN1Primitive instanceof DERApplicationSpecific) {
            stringBuffer.append(c("DER", str, aSN1Primitive, str2));
        } else if (aSN1Primitive instanceof ASN1Enumerated) {
            StringBuilder n17 = lf.n(str, "DER Enumerated(");
            n17.append(((ASN1Enumerated) aSN1Primitive).r());
            n17.append(")");
            n17.append(str2);
            stringBuffer.append(n17.toString());
        } else if (aSN1Primitive instanceof DERExternal) {
            DERExternal dERExternal = (DERExternal) aSN1Primitive;
            stringBuffer.append(str + "External " + str2);
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("    ");
            String sb2 = sb.toString();
            if (dERExternal.Z0 != null) {
                StringBuilder n18 = lf.n(sb2, "Direct Reference: ");
                n18.append(dERExternal.Z0.c);
                n18.append(str2);
                stringBuffer.append(n18.toString());
            }
            ASN1Integer aSN1Integer = dERExternal.a;
            if (aSN1Integer != null) {
                StringBuilder n19 = lf.n(sb2, "Indirect Reference: ");
                n19.append(aSN1Integer.toString());
                n19.append(str2);
                stringBuffer.append(n19.toString());
            }
            ASN1Primitive aSN1Primitive2 = dERExternal.f5669a;
            if (aSN1Primitive2 != null) {
                a(sb2, aSN1Primitive2, stringBuffer);
            }
            StringBuilder n20 = lf.n(sb2, "Encoding: ");
            n20.append(dERExternal.c);
            n20.append(str2);
            stringBuffer.append(n20.toString());
            a(sb2, dERExternal.b, stringBuffer);
        } else {
            StringBuilder J = xx.J(str);
            J.append(aSN1Primitive.toString());
            J.append(str2);
            stringBuffer.append(J.toString());
        }
    }

    public static String b(ASN1Encodable aSN1Encodable) {
        StringBuffer stringBuffer = new StringBuffer();
        if (aSN1Encodable instanceof ASN1Primitive) {
            a("", (ASN1Primitive) aSN1Encodable, stringBuffer);
        } else if (aSN1Encodable instanceof ASN1Encodable) {
            a("", aSN1Encodable.b(), stringBuffer);
        } else {
            return "unknown object type " + aSN1Encodable.toString();
        }
        return stringBuffer.toString();
    }

    public static String c(String str, String str2, ASN1Primitive aSN1Primitive, String str3) {
        ASN1ApplicationSpecific q = ASN1ApplicationSpecific.q(aSN1Primitive);
        StringBuffer stringBuffer = new StringBuffer();
        boolean z = q.a;
        int i = q.c;
        if (z) {
            try {
                ASN1Sequence q2 = ASN1Sequence.q(q.r());
                stringBuffer.append(str2 + str + " ApplicationSpecific[" + i + "]" + str3);
                Enumeration t = q2.t();
                while (t.hasMoreElements()) {
                    a(str2 + "    ", (ASN1Primitive) t.nextElement(), stringBuffer);
                }
            } catch (IOException e) {
                stringBuffer.append(e);
            }
            return stringBuffer.toString();
        }
        return str2 + str + " ApplicationSpecific[" + i + "] (" + Strings.a(Hex.c(Arrays.c(q.f5653a))) + ")" + str3;
    }
}
