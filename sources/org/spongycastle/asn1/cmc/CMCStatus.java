package org.spongycastle.asn1.cmc;

import java.util.HashMap;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;

public class CMCStatus extends ASN1Object {
    public final ASN1Integer a;

    static {
        CMCStatus cMCStatus = new CMCStatus(new ASN1Integer(0));
        CMCStatus cMCStatus2 = new CMCStatus(new ASN1Integer(2));
        CMCStatus cMCStatus3 = new CMCStatus(new ASN1Integer(3));
        CMCStatus cMCStatus4 = new CMCStatus(new ASN1Integer(4));
        CMCStatus cMCStatus5 = new CMCStatus(new ASN1Integer(5));
        CMCStatus cMCStatus6 = new CMCStatus(new ASN1Integer(6));
        CMCStatus cMCStatus7 = new CMCStatus(new ASN1Integer(7));
        HashMap hashMap = new HashMap();
        hashMap.put(cMCStatus.a, cMCStatus);
        hashMap.put(cMCStatus2.a, cMCStatus2);
        hashMap.put(cMCStatus3.a, cMCStatus3);
        hashMap.put(cMCStatus4.a, cMCStatus4);
        hashMap.put(cMCStatus5.a, cMCStatus5);
        hashMap.put(cMCStatus6.a, cMCStatus6);
        hashMap.put(cMCStatus7.a, cMCStatus7);
    }

    public CMCStatus(ASN1Integer aSN1Integer) {
        this.a = aSN1Integer;
    }

    public final ASN1Primitive b() {
        return this.a;
    }
}
