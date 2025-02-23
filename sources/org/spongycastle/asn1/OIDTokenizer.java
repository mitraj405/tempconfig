package org.spongycastle.asn1;

public class OIDTokenizer {
    public int a = 0;

    /* renamed from: a  reason: collision with other field name */
    public final String f5674a;

    public OIDTokenizer(String str) {
        this.f5674a = str;
    }

    public final String a() {
        int i = this.a;
        if (i == -1) {
            return null;
        }
        String str = this.f5674a;
        int indexOf = str.indexOf(46, i);
        if (indexOf == -1) {
            String substring = str.substring(this.a);
            this.a = -1;
            return substring;
        }
        String substring2 = str.substring(this.a, indexOf);
        this.a = indexOf + 1;
        return substring2;
    }
}
