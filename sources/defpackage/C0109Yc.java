package defpackage;

import android.util.Base64;
import java.util.List;

/* renamed from: Yc  reason: default package and case insensitive filesystem */
/* compiled from: FontRequest */
public final class C0109Yc {
    public final String a;

    /* renamed from: a  reason: collision with other field name */
    public final List<List<byte[]>> f712a;
    public final String b;
    public final String c;
    public final String d;

    public C0109Yc(String str, String str2, String str3, List<List<byte[]>> list) {
        str.getClass();
        this.a = str;
        str2.getClass();
        this.b = str2;
        this.c = str3;
        list.getClass();
        this.f712a = list;
        this.d = str + "-" + str2 + "-" + str3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.a + ", mProviderPackage: " + this.b + ", mQuery: " + this.c + ", mCertificates:");
        int i = 0;
        while (true) {
            List<List<byte[]>> list = this.f712a;
            if (i < list.size()) {
                sb.append(" [");
                List list2 = list.get(i);
                for (int i2 = 0; i2 < list2.size(); i2++) {
                    sb.append(" \"");
                    sb.append(Base64.encodeToString((byte[]) list2.get(i2), 0));
                    sb.append("\"");
                }
                sb.append(" ]");
                i++;
            } else {
                sb.append("}mCertificatesArray: 0");
                return sb.toString();
            }
        }
    }
}
