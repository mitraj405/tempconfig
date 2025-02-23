package org.spongycastle.asn1.eac;

import java.util.Hashtable;

public class BidirectionalMap extends Hashtable {
    private static final long serialVersionUID = -7457289971962812909L;
    public final Hashtable a = new Hashtable();

    public final Object put(Object obj, Object obj2) {
        this.a.put(obj2, obj);
        return super.put(obj, obj2);
    }
}
