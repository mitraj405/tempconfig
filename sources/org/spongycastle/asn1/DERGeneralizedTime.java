package org.spongycastle.asn1;

import java.util.Date;

public class DERGeneralizedTime extends ASN1GeneralizedTime {
    public DERGeneralizedTime(Date date) {
        super(date);
    }
}
