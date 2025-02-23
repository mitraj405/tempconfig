package org.spongycastle.asn1.x509;

import com.google.common.primitives.UnsignedBytes;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.HashSet;
import java.util.Iterator;
import org.spongycastle.util.Arrays;

public class PKIXNameConstraintValidator implements NameConstraintValidator {
    public final HashSet a = new HashSet();
    public final HashSet b = new HashSet();
    public final HashSet c = new HashSet();
    public final HashSet d = new HashSet();
    public final HashSet e = new HashSet();

    public static boolean a(HashSet hashSet, HashSet hashSet2) {
        boolean z;
        boolean z2;
        if (hashSet == hashSet2) {
            return true;
        }
        if (hashSet == null || hashSet2 == null || hashSet.size() != hashSet2.size()) {
            return false;
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            Iterator it2 = hashSet2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z = false;
                    continue;
                    break;
                }
                Object next2 = it2.next();
                if (next == next2) {
                    z2 = true;
                    continue;
                } else if (next == null || next2 == null) {
                    z2 = false;
                    continue;
                } else if (!(next instanceof byte[]) || !(next2 instanceof byte[])) {
                    z2 = next.equals(next2);
                    continue;
                } else {
                    z2 = Arrays.a((byte[]) next, (byte[]) next2);
                    continue;
                }
                if (z2) {
                    z = true;
                    continue;
                    break;
                }
            }
            if (!z) {
                return false;
            }
        }
        return true;
    }

    public static int b(HashSet hashSet) {
        int i;
        int i2 = 0;
        if (hashSet == null) {
            return 0;
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next instanceof byte[]) {
                i = Arrays.t((byte[]) next);
            } else {
                i = next.hashCode();
            }
            i2 += i;
        }
        return i2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof PKIXNameConstraintValidator)) {
            return false;
        }
        PKIXNameConstraintValidator pKIXNameConstraintValidator = (PKIXNameConstraintValidator) obj;
        if (!a(pKIXNameConstraintValidator.a, this.a) || !a(pKIXNameConstraintValidator.b, this.b) || !a(pKIXNameConstraintValidator.c, this.c) || !a(pKIXNameConstraintValidator.e, this.e) || !a(pKIXNameConstraintValidator.d, this.d) || !a((HashSet) null, (HashSet) null) || !a((HashSet) null, (HashSet) null) || !a((HashSet) null, (HashSet) null) || !a((HashSet) null, (HashSet) null) || !a((HashSet) null, (HashSet) null)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int b2 = b(this.e) + b(this.c) + b(this.b) + b(this.a);
        int b3 = b((HashSet) null) + b((HashSet) null) + b((HashSet) null) + b(this.d) + b2;
        return b((HashSet) null) + b((HashSet) null) + b3;
    }

    public final String toString() {
        String str;
        HashSet hashSet = this.a;
        if (!hashSet.isEmpty()) {
            str = "permitted:\nexcluded:\nDN:\n" + hashSet.toString() + "\n";
        } else {
            str = "permitted:\nexcluded:\n";
        }
        HashSet hashSet2 = this.b;
        if (!hashSet2.isEmpty()) {
            StringBuilder J = xx.J(C1058d.z(str, "DNS:\n"));
            J.append(hashSet2.toString());
            J.append("\n");
            str = J.toString();
        }
        HashSet hashSet3 = this.c;
        if (!hashSet3.isEmpty()) {
            StringBuilder J2 = xx.J(C1058d.z(str, "Email:\n"));
            J2.append(hashSet3.toString());
            J2.append("\n");
            str = J2.toString();
        }
        HashSet hashSet4 = this.d;
        if (!hashSet4.isEmpty()) {
            StringBuilder J3 = xx.J(C1058d.z(str, "URI:\n"));
            J3.append(hashSet4.toString());
            J3.append("\n");
            str = J3.toString();
        }
        HashSet hashSet5 = this.e;
        if (hashSet5.isEmpty()) {
            return str;
        }
        StringBuilder J4 = xx.J(C1058d.z(str, "IP:\n"));
        Iterator it = hashSet5.iterator();
        String str2 = "[";
        while (it.hasNext()) {
            StringBuilder J5 = xx.J(str2);
            byte[] bArr = (byte[]) it.next();
            String str3 = "";
            for (int i = 0; i < bArr.length / 2; i++) {
                StringBuilder J6 = xx.J(str3);
                J6.append(Integer.toString(bArr[i] & UnsignedBytes.MAX_VALUE));
                J6.append(".");
                str3 = J6.toString();
            }
            String z = C1058d.z(str3.substring(0, str3.length() - 1), RemoteSettings.FORWARD_SLASH_STRING);
            for (int length = bArr.length / 2; length < bArr.length; length++) {
                StringBuilder J7 = xx.J(z);
                J7.append(Integer.toString(bArr[length] & UnsignedBytes.MAX_VALUE));
                J7.append(".");
                z = J7.toString();
            }
            J5.append(z.substring(0, z.length() - 1));
            J5.append(",");
            str2 = J5.toString();
        }
        if (str2.length() > 1) {
            str2 = str2.substring(0, str2.length() - 1);
        }
        J4.append(str2 + "]");
        J4.append("\n");
        return J4.toString();
    }
}
