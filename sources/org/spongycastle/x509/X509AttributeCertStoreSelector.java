package org.spongycastle.x509;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import org.spongycastle.util.Selector;

public class X509AttributeCertStoreSelector implements Selector {
    public BigInteger a;

    /* renamed from: a  reason: collision with other field name */
    public Collection f6867a = new HashSet();

    /* renamed from: a  reason: collision with other field name */
    public Date f6868a;

    /* renamed from: a  reason: collision with other field name */
    public AttributeCertificateHolder f6869a;

    /* renamed from: a  reason: collision with other field name */
    public AttributeCertificateIssuer f6870a;

    /* renamed from: a  reason: collision with other field name */
    public X509AttributeCertificate f6871a;
    public Collection b = new HashSet();

    public final Object clone() {
        Date date;
        X509AttributeCertStoreSelector x509AttributeCertStoreSelector = new X509AttributeCertStoreSelector();
        x509AttributeCertStoreSelector.f6871a = this.f6871a;
        if (this.f6868a != null) {
            date = new Date(this.f6868a.getTime());
        } else {
            date = null;
        }
        x509AttributeCertStoreSelector.f6868a = date;
        x509AttributeCertStoreSelector.f6869a = this.f6869a;
        x509AttributeCertStoreSelector.f6870a = this.f6870a;
        x509AttributeCertStoreSelector.a = this.a;
        x509AttributeCertStoreSelector.b = Collections.unmodifiableCollection(this.b);
        x509AttributeCertStoreSelector.f6867a = Collections.unmodifiableCollection(this.f6867a);
        return x509AttributeCertStoreSelector;
    }
}
