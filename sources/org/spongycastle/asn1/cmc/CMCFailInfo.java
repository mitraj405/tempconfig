package org.spongycastle.asn1.cmc;

import java.util.HashMap;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;

public class CMCFailInfo extends ASN1Object {
    public final ASN1Integer a;

    static {
        CMCFailInfo cMCFailInfo = new CMCFailInfo(new ASN1Integer(0));
        CMCFailInfo cMCFailInfo2 = new CMCFailInfo(new ASN1Integer(1));
        CMCFailInfo cMCFailInfo3 = new CMCFailInfo(new ASN1Integer(2));
        CMCFailInfo cMCFailInfo4 = new CMCFailInfo(new ASN1Integer(3));
        CMCFailInfo cMCFailInfo5 = new CMCFailInfo(new ASN1Integer(4));
        CMCFailInfo cMCFailInfo6 = new CMCFailInfo(new ASN1Integer(5));
        CMCFailInfo cMCFailInfo7 = new CMCFailInfo(new ASN1Integer(6));
        CMCFailInfo cMCFailInfo8 = new CMCFailInfo(new ASN1Integer(7));
        CMCFailInfo cMCFailInfo9 = new CMCFailInfo(new ASN1Integer(8));
        CMCFailInfo cMCFailInfo10 = new CMCFailInfo(new ASN1Integer(9));
        CMCFailInfo cMCFailInfo11 = new CMCFailInfo(new ASN1Integer(10));
        CMCFailInfo cMCFailInfo12 = new CMCFailInfo(new ASN1Integer(11));
        CMCFailInfo cMCFailInfo13 = new CMCFailInfo(new ASN1Integer(12));
        CMCFailInfo cMCFailInfo14 = new CMCFailInfo(new ASN1Integer(13));
        HashMap hashMap = new HashMap();
        hashMap.put(cMCFailInfo.a, cMCFailInfo);
        hashMap.put(cMCFailInfo2.a, cMCFailInfo2);
        hashMap.put(cMCFailInfo3.a, cMCFailInfo3);
        hashMap.put(cMCFailInfo4.a, cMCFailInfo4);
        ASN1Integer aSN1Integer = cMCFailInfo5.a;
        hashMap.put(aSN1Integer, cMCFailInfo5);
        ASN1Integer aSN1Integer2 = cMCFailInfo9.a;
        hashMap.put(aSN1Integer2, cMCFailInfo9);
        hashMap.put(cMCFailInfo6.a, cMCFailInfo6);
        hashMap.put(cMCFailInfo7.a, cMCFailInfo7);
        hashMap.put(cMCFailInfo8.a, cMCFailInfo8);
        hashMap.put(aSN1Integer2, cMCFailInfo9);
        hashMap.put(cMCFailInfo10.a, cMCFailInfo10);
        hashMap.put(aSN1Integer, cMCFailInfo5);
        hashMap.put(aSN1Integer2, cMCFailInfo9);
        hashMap.put(cMCFailInfo11.a, cMCFailInfo11);
        hashMap.put(cMCFailInfo12.a, cMCFailInfo12);
        CMCFailInfo cMCFailInfo15 = cMCFailInfo13;
        hashMap.put(cMCFailInfo15.a, cMCFailInfo15);
        hashMap.put(cMCFailInfo14.a, cMCFailInfo14);
    }

    public CMCFailInfo(ASN1Integer aSN1Integer) {
        this.a = aSN1Integer;
    }

    public final ASN1Primitive b() {
        return this.a;
    }
}
