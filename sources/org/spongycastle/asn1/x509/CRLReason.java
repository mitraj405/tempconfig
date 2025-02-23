package org.spongycastle.asn1.x509;

import com.google.firebase.ktx.BuildConfig;
import java.util.Hashtable;
import org.spongycastle.asn1.ASN1Enumerated;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;

public class CRLReason extends ASN1Object {
    public static final Hashtable a = new Hashtable();

    /* renamed from: a  reason: collision with other field name */
    public static final String[] f5729a = {BuildConfig.VERSION_NAME, "keyCompromise", "cACompromise", "affiliationChanged", "superseded", "cessationOfOperation", "certificateHold", "unknown", "removeFromCRL", "privilegeWithdrawn", "aACompromise"};

    /* renamed from: a  reason: collision with other field name */
    public final ASN1Enumerated f5730a;

    public CRLReason(int i) {
        this.f5730a = new ASN1Enumerated(i);
    }

    public final ASN1Primitive b() {
        return this.f5730a;
    }

    public final String toString() {
        String str;
        int intValue = this.f5730a.r().intValue();
        if (intValue < 0 || intValue > 10) {
            str = "invalid";
        } else {
            str = f5729a[intValue];
        }
        return C0709Uj.i("CRLReason: ", str);
    }
}
