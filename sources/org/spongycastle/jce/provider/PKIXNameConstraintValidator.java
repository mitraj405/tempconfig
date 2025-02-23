package org.spongycastle.jce.provider;

import com.google.common.primitives.UnsignedBytes;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERIA5String;
import org.spongycastle.asn1.x509.GeneralName;
import org.spongycastle.asn1.x509.GeneralSubtree;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Strings;

public class PKIXNameConstraintValidator {
    public HashSet a;

    /* renamed from: a  reason: collision with other field name */
    public Set f6588a = new HashSet();
    public HashSet b;

    /* renamed from: b  reason: collision with other field name */
    public Set f6589b = new HashSet();
    public HashSet c;

    /* renamed from: c  reason: collision with other field name */
    public Set f6590c = new HashSet();
    public HashSet d;

    /* renamed from: d  reason: collision with other field name */
    public Set f6591d = new HashSet();
    public HashSet e;

    /* renamed from: e  reason: collision with other field name */
    public Set f6592e = new HashSet();

    public static boolean f(Set set, Set set2) {
        boolean z;
        boolean z2;
        if (set == set2) {
            return true;
        }
        if (set == null || set2 == null || set.size() != set2.size()) {
            return false;
        }
        for (Object next : set) {
            Iterator it = set2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    continue;
                    break;
                }
                Object next2 = it.next();
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

    public static boolean g(String str, String str2) {
        String substring = str.substring(str.indexOf(64) + 1);
        if (str2.indexOf(64) != -1) {
            if (!str.equalsIgnoreCase(str2) && !substring.equalsIgnoreCase(str2.substring(1))) {
                return false;
            }
            return true;
        } else if (str2.charAt(0) != '.') {
            if (substring.equalsIgnoreCase(str2)) {
                return true;
            }
        } else if (o(substring, str2)) {
            return true;
        }
        return false;
    }

    public static String h(GeneralName generalName) {
        return DERIA5String.q(generalName.a).c();
    }

    public static int i(Set set) {
        int i;
        int i2 = 0;
        if (set == null) {
            return 0;
        }
        for (Object next : set) {
            if (next instanceof byte[]) {
                i = Arrays.t((byte[]) next);
            } else {
                i = next.hashCode();
            }
            i2 += i;
        }
        return i2;
    }

    public static boolean k(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        if (length != bArr2.length / 2) {
            return false;
        }
        byte[] bArr3 = new byte[length];
        System.arraycopy(bArr2, length, bArr3, 0, length);
        byte[] bArr4 = new byte[length];
        byte[] bArr5 = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr4[i] = (byte) (bArr2[i] & bArr3[i]);
            bArr5[i] = (byte) (bArr[i] & bArr3[i]);
        }
        return Arrays.a(bArr4, bArr5);
    }

    public static boolean l(String str, String str2) {
        String substring = str.substring(str.indexOf(58) + 1);
        if (substring.indexOf("//") != -1) {
            substring = substring.substring(substring.indexOf("//") + 2);
        }
        if (substring.lastIndexOf(58) != -1) {
            substring = substring.substring(0, substring.lastIndexOf(58));
        }
        String substring2 = substring.substring(substring.indexOf(58) + 1);
        String substring3 = substring2.substring(substring2.indexOf(64) + 1);
        if (substring3.indexOf(47) != -1) {
            substring3 = substring3.substring(0, substring3.indexOf(47));
        }
        if (!str2.startsWith(".")) {
            if (substring3.equalsIgnoreCase(str2)) {
                return true;
            }
        } else if (o(substring3, str2)) {
            return true;
        }
        return false;
    }

    public static String m(Set set) {
        Iterator it = set.iterator();
        String str = "[";
        while (it.hasNext()) {
            StringBuilder J = xx.J(str);
            byte[] bArr = (byte[]) it.next();
            String str2 = "";
            for (int i = 0; i < bArr.length / 2; i++) {
                StringBuilder J2 = xx.J(str2);
                J2.append(Integer.toString(bArr[i] & UnsignedBytes.MAX_VALUE));
                J2.append(".");
                str2 = J2.toString();
            }
            String z = C1058d.z(str2.substring(0, str2.length() - 1), RemoteSettings.FORWARD_SLASH_STRING);
            for (int length = bArr.length / 2; length < bArr.length; length++) {
                StringBuilder J3 = xx.J(z);
                J3.append(Integer.toString(bArr[length] & UnsignedBytes.MAX_VALUE));
                J3.append(".");
                z = J3.toString();
            }
            J.append(z.substring(0, z.length() - 1));
            J.append(",");
            str = J.toString();
        }
        if (str.length() > 1) {
            str = str.substring(0, str.length() - 1);
        }
        return C1058d.z(str, "]");
    }

    public static boolean n(ASN1Sequence aSN1Sequence, ASN1Sequence aSN1Sequence2) {
        if (aSN1Sequence2.size() < 1 || aSN1Sequence2.size() > aSN1Sequence.size()) {
            return false;
        }
        for (int size = aSN1Sequence2.size() - 1; size >= 0; size--) {
            if (!aSN1Sequence2.s(size).equals(aSN1Sequence.s(size))) {
                return false;
            }
        }
        return true;
    }

    public static boolean o(String str, String str2) {
        if (str2.startsWith(".")) {
            str2 = str2.substring(1);
        }
        String[] c2 = Strings.c(str2);
        String[] c3 = Strings.c(str);
        if (c3.length <= c2.length) {
            return false;
        }
        int length = c3.length - c2.length;
        for (int i = -1; i < c2.length; i++) {
            if (i == -1) {
                if (c3[i + length].equals("")) {
                    return false;
                }
            } else if (!c2[i].equalsIgnoreCase(c3[i + length])) {
                return false;
            }
        }
        return true;
    }

    public final void a(GeneralSubtree generalSubtree) {
        GeneralName generalName = generalSubtree.f5743a;
        int i = generalName.c;
        if (i == 1) {
            Set<String> set = this.f6590c;
            String h = h(generalName);
            if (set.isEmpty()) {
                set.add(h);
            } else {
                HashSet hashSet = new HashSet();
                for (String str : set) {
                    if (str.indexOf(64) != -1) {
                        String substring = str.substring(str.indexOf(64) + 1);
                        if (h.indexOf(64) != -1) {
                            if (str.equalsIgnoreCase(h)) {
                                hashSet.add(str);
                            } else {
                                hashSet.add(str);
                                hashSet.add(h);
                            }
                        } else if (h.startsWith(".")) {
                            if (o(substring, h)) {
                                hashSet.add(h);
                            } else {
                                hashSet.add(str);
                                hashSet.add(h);
                            }
                        } else if (substring.equalsIgnoreCase(h)) {
                            hashSet.add(h);
                        } else {
                            hashSet.add(str);
                            hashSet.add(h);
                        }
                    } else if (str.startsWith(".")) {
                        if (h.indexOf(64) != -1) {
                            if (o(h.substring(str.indexOf(64) + 1), str)) {
                                hashSet.add(str);
                            } else {
                                hashSet.add(str);
                                hashSet.add(h);
                            }
                        } else if (h.startsWith(".")) {
                            if (o(str, h) || str.equalsIgnoreCase(h)) {
                                hashSet.add(h);
                            } else if (o(h, str)) {
                                hashSet.add(str);
                            } else {
                                hashSet.add(str);
                                hashSet.add(h);
                            }
                        } else if (o(h, str)) {
                            hashSet.add(str);
                        } else {
                            hashSet.add(str);
                            hashSet.add(h);
                        }
                    } else if (h.indexOf(64) != -1) {
                        if (h.substring(str.indexOf(64) + 1).equalsIgnoreCase(str)) {
                            hashSet.add(str);
                        } else {
                            hashSet.add(str);
                            hashSet.add(h);
                        }
                    } else if (h.startsWith(".")) {
                        if (o(str, h)) {
                            hashSet.add(h);
                        } else {
                            hashSet.add(str);
                            hashSet.add(h);
                        }
                    } else if (str.equalsIgnoreCase(h)) {
                        hashSet.add(str);
                    } else {
                        hashSet.add(str);
                        hashSet.add(h);
                    }
                }
                set = hashSet;
            }
            this.f6590c = set;
        } else if (i != 2) {
            ASN1Encodable aSN1Encodable = generalName.a;
            if (i == 4) {
                Set<ASN1Sequence> set2 = this.f6588a;
                ASN1Sequence aSN1Sequence = (ASN1Sequence) aSN1Encodable.b();
                if (!set2.isEmpty()) {
                    HashSet hashSet2 = new HashSet();
                    for (ASN1Sequence aSN1Sequence2 : set2) {
                        if (n(aSN1Sequence, aSN1Sequence2)) {
                            hashSet2.add(aSN1Sequence2);
                        } else if (n(aSN1Sequence2, aSN1Sequence)) {
                            hashSet2.add(aSN1Sequence);
                        } else {
                            hashSet2.add(aSN1Sequence2);
                            hashSet2.add(aSN1Sequence);
                        }
                    }
                    set2 = hashSet2;
                } else if (aSN1Sequence != null) {
                    set2.add(aSN1Sequence);
                }
                this.f6588a = set2;
            } else if (i == 6) {
                Set<String> set3 = this.f6591d;
                String h2 = h(generalName);
                if (set3.isEmpty()) {
                    set3.add(h2);
                } else {
                    HashSet hashSet3 = new HashSet();
                    for (String str2 : set3) {
                        if (str2.indexOf(64) != -1) {
                            String substring2 = str2.substring(str2.indexOf(64) + 1);
                            if (h2.indexOf(64) != -1) {
                                if (str2.equalsIgnoreCase(h2)) {
                                    hashSet3.add(str2);
                                } else {
                                    hashSet3.add(str2);
                                    hashSet3.add(h2);
                                }
                            } else if (h2.startsWith(".")) {
                                if (o(substring2, h2)) {
                                    hashSet3.add(h2);
                                } else {
                                    hashSet3.add(str2);
                                    hashSet3.add(h2);
                                }
                            } else if (substring2.equalsIgnoreCase(h2)) {
                                hashSet3.add(h2);
                            } else {
                                hashSet3.add(str2);
                                hashSet3.add(h2);
                            }
                        } else if (str2.startsWith(".")) {
                            if (h2.indexOf(64) != -1) {
                                if (o(h2.substring(str2.indexOf(64) + 1), str2)) {
                                    hashSet3.add(str2);
                                } else {
                                    hashSet3.add(str2);
                                    hashSet3.add(h2);
                                }
                            } else if (h2.startsWith(".")) {
                                if (o(str2, h2) || str2.equalsIgnoreCase(h2)) {
                                    hashSet3.add(h2);
                                } else if (o(h2, str2)) {
                                    hashSet3.add(str2);
                                } else {
                                    hashSet3.add(str2);
                                    hashSet3.add(h2);
                                }
                            } else if (o(h2, str2)) {
                                hashSet3.add(str2);
                            } else {
                                hashSet3.add(str2);
                                hashSet3.add(h2);
                            }
                        } else if (h2.indexOf(64) != -1) {
                            if (h2.substring(str2.indexOf(64) + 1).equalsIgnoreCase(str2)) {
                                hashSet3.add(str2);
                            } else {
                                hashSet3.add(str2);
                                hashSet3.add(h2);
                            }
                        } else if (h2.startsWith(".")) {
                            if (o(str2, h2)) {
                                hashSet3.add(h2);
                            } else {
                                hashSet3.add(str2);
                                hashSet3.add(h2);
                            }
                        } else if (str2.equalsIgnoreCase(h2)) {
                            hashSet3.add(str2);
                        } else {
                            hashSet3.add(str2);
                            hashSet3.add(h2);
                        }
                    }
                    set3 = hashSet3;
                }
                this.f6591d = set3;
            } else if (i == 7) {
                Set<byte[]> set4 = this.f6592e;
                byte[] s = ASN1OctetString.q(aSN1Encodable).s();
                if (!set4.isEmpty()) {
                    HashSet hashSet4 = new HashSet();
                    for (byte[] bArr : set4) {
                        HashSet hashSet5 = new HashSet();
                        if (Arrays.a(bArr, s)) {
                            hashSet5.add(bArr);
                        } else {
                            hashSet5.add(bArr);
                            hashSet5.add(s);
                        }
                        hashSet4.addAll(hashSet5);
                    }
                    set4 = hashSet4;
                } else if (s != null) {
                    set4.add(s);
                }
                this.f6592e = set4;
            }
        } else {
            Set<String> set5 = this.f6589b;
            String h3 = h(generalName);
            if (set5.isEmpty()) {
                set5.add(h3);
            } else {
                HashSet hashSet6 = new HashSet();
                for (String str3 : set5) {
                    if (o(str3, h3)) {
                        hashSet6.add(h3);
                    } else if (o(h3, str3)) {
                        hashSet6.add(str3);
                    } else {
                        hashSet6.add(str3);
                        hashSet6.add(h3);
                    }
                }
                set5 = hashSet6;
            }
            this.f6589b = set5;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x009e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(org.spongycastle.asn1.x509.GeneralName r4) throws org.spongycastle.jce.provider.PKIXNameConstraintValidatorException {
        /*
            r3 = this;
            int r0 = r4.c
            r1 = 1
            if (r0 == r1) goto L_0x00b9
            r1 = 2
            org.spongycastle.asn1.ASN1Encodable r4 = r4.a
            if (r0 == r1) goto L_0x0083
            r1 = 4
            if (r0 == r1) goto L_0x0077
            r1 = 6
            if (r0 == r1) goto L_0x0046
            r1 = 7
            if (r0 == r1) goto L_0x0015
            goto L_0x00e5
        L_0x0015:
            org.spongycastle.asn1.ASN1OctetString r4 = org.spongycastle.asn1.ASN1OctetString.q(r4)
            byte[] r4 = r4.s()
            java.util.Set r0 = r3.f6592e
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L_0x0027
            goto L_0x00e5
        L_0x0027:
            java.util.Iterator r0 = r0.iterator()
        L_0x002b:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x00e5
            java.lang.Object r1 = r0.next()
            byte[] r1 = (byte[]) r1
            boolean r1 = k(r4, r1)
            if (r1 != 0) goto L_0x003e
            goto L_0x002b
        L_0x003e:
            org.spongycastle.jce.provider.PKIXNameConstraintValidatorException r4 = new org.spongycastle.jce.provider.PKIXNameConstraintValidatorException
            java.lang.String r0 = "IP is from an excluded subtree."
            r4.<init>(r0)
            throw r4
        L_0x0046:
            java.util.Set r0 = r3.f6591d
            org.spongycastle.asn1.DERIA5String r4 = org.spongycastle.asn1.DERIA5String.q(r4)
            java.lang.String r4 = r4.c()
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L_0x0058
            goto L_0x00e5
        L_0x0058:
            java.util.Iterator r0 = r0.iterator()
        L_0x005c:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x00e5
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            boolean r1 = l(r4, r1)
            if (r1 != 0) goto L_0x006f
            goto L_0x005c
        L_0x006f:
            org.spongycastle.jce.provider.PKIXNameConstraintValidatorException r4 = new org.spongycastle.jce.provider.PKIXNameConstraintValidatorException
            java.lang.String r0 = "URI is from an excluded subtree."
            r4.<init>(r0)
            throw r4
        L_0x0077:
            org.spongycastle.asn1.ASN1Primitive r4 = r4.b()
            org.spongycastle.asn1.ASN1Sequence r4 = org.spongycastle.asn1.ASN1Sequence.q(r4)
            r3.c(r4)
            goto L_0x00e5
        L_0x0083:
            java.util.Set r0 = r3.f6589b
            org.spongycastle.asn1.DERIA5String r4 = org.spongycastle.asn1.DERIA5String.q(r4)
            java.lang.String r4 = r4.c()
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L_0x0094
            goto L_0x00e5
        L_0x0094:
            java.util.Iterator r0 = r0.iterator()
        L_0x0098:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x00e5
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            boolean r2 = o(r4, r1)
            if (r2 != 0) goto L_0x00b1
            boolean r1 = r4.equalsIgnoreCase(r1)
            if (r1 != 0) goto L_0x00b1
            goto L_0x0098
        L_0x00b1:
            org.spongycastle.jce.provider.PKIXNameConstraintValidatorException r4 = new org.spongycastle.jce.provider.PKIXNameConstraintValidatorException
            java.lang.String r0 = "DNS is from an excluded subtree."
            r4.<init>(r0)
            throw r4
        L_0x00b9:
            java.util.Set r0 = r3.f6590c
            java.lang.String r4 = h(r4)
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L_0x00c6
            goto L_0x00e5
        L_0x00c6:
            java.util.Iterator r0 = r0.iterator()
        L_0x00ca:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x00e5
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            boolean r1 = g(r4, r1)
            if (r1 != 0) goto L_0x00dd
            goto L_0x00ca
        L_0x00dd:
            org.spongycastle.jce.provider.PKIXNameConstraintValidatorException r4 = new org.spongycastle.jce.provider.PKIXNameConstraintValidatorException
            java.lang.String r0 = "Email address is from an excluded subtree."
            r4.<init>(r0)
            throw r4
        L_0x00e5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jce.provider.PKIXNameConstraintValidator.b(org.spongycastle.asn1.x509.GeneralName):void");
    }

    public final void c(ASN1Sequence aSN1Sequence) throws PKIXNameConstraintValidatorException {
        Set<ASN1Sequence> set = this.f6588a;
        if (!set.isEmpty()) {
            for (ASN1Sequence n : set) {
                if (n(aSN1Sequence, n)) {
                    throw new PKIXNameConstraintValidatorException("Subject distinguished name is from an excluded subtree");
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x00ae  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d(org.spongycastle.asn1.x509.GeneralName r5) throws org.spongycastle.jce.provider.PKIXNameConstraintValidatorException {
        /*
            r4 = this;
            int r0 = r5.c
            r1 = 1
            if (r0 == r1) goto L_0x00d6
            r1 = 2
            org.spongycastle.asn1.ASN1Encodable r5 = r5.a
            if (r0 == r1) goto L_0x0097
            r1 = 4
            if (r0 == r1) goto L_0x008a
            r1 = 6
            if (r0 == r1) goto L_0x004e
            r1 = 7
            if (r0 == r1) goto L_0x0015
            goto L_0x0102
        L_0x0015:
            org.spongycastle.asn1.ASN1OctetString r5 = org.spongycastle.asn1.ASN1OctetString.q(r5)
            byte[] r5 = r5.s()
            java.util.HashSet r0 = r4.e
            if (r0 != 0) goto L_0x0023
            goto L_0x0102
        L_0x0023:
            java.util.Iterator r1 = r0.iterator()
        L_0x0027:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x003b
            java.lang.Object r2 = r1.next()
            byte[] r2 = (byte[]) r2
            boolean r2 = k(r5, r2)
            if (r2 == 0) goto L_0x0027
            goto L_0x0102
        L_0x003b:
            int r5 = r5.length
            if (r5 != 0) goto L_0x0046
            int r5 = r0.size()
            if (r5 != 0) goto L_0x0046
            goto L_0x0102
        L_0x0046:
            org.spongycastle.jce.provider.PKIXNameConstraintValidatorException r5 = new org.spongycastle.jce.provider.PKIXNameConstraintValidatorException
            java.lang.String r0 = "IP is not from a permitted subtree."
            r5.<init>(r0)
            throw r5
        L_0x004e:
            java.util.HashSet r0 = r4.d
            org.spongycastle.asn1.DERIA5String r5 = org.spongycastle.asn1.DERIA5String.q(r5)
            java.lang.String r5 = r5.c()
            if (r0 != 0) goto L_0x005c
            goto L_0x0102
        L_0x005c:
            java.util.Iterator r1 = r0.iterator()
        L_0x0060:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0074
            java.lang.Object r2 = r1.next()
            java.lang.String r2 = (java.lang.String) r2
            boolean r2 = l(r5, r2)
            if (r2 == 0) goto L_0x0060
            goto L_0x0102
        L_0x0074:
            int r5 = r5.length()
            if (r5 != 0) goto L_0x0082
            int r5 = r0.size()
            if (r5 != 0) goto L_0x0082
            goto L_0x0102
        L_0x0082:
            org.spongycastle.jce.provider.PKIXNameConstraintValidatorException r5 = new org.spongycastle.jce.provider.PKIXNameConstraintValidatorException
            java.lang.String r0 = "URI is not from a permitted subtree."
            r5.<init>(r0)
            throw r5
        L_0x008a:
            org.spongycastle.asn1.ASN1Primitive r5 = r5.b()
            org.spongycastle.asn1.ASN1Sequence r5 = org.spongycastle.asn1.ASN1Sequence.q(r5)
            r4.e(r5)
            goto L_0x0102
        L_0x0097:
            java.util.HashSet r0 = r4.b
            org.spongycastle.asn1.DERIA5String r5 = org.spongycastle.asn1.DERIA5String.q(r5)
            java.lang.String r5 = r5.c()
            if (r0 != 0) goto L_0x00a4
            goto L_0x0102
        L_0x00a4:
            java.util.Iterator r1 = r0.iterator()
        L_0x00a8:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x00c1
            java.lang.Object r2 = r1.next()
            java.lang.String r2 = (java.lang.String) r2
            boolean r3 = o(r5, r2)
            if (r3 != 0) goto L_0x0102
            boolean r2 = r5.equalsIgnoreCase(r2)
            if (r2 == 0) goto L_0x00a8
            goto L_0x0102
        L_0x00c1:
            int r5 = r5.length()
            if (r5 != 0) goto L_0x00ce
            int r5 = r0.size()
            if (r5 != 0) goto L_0x00ce
            goto L_0x0102
        L_0x00ce:
            org.spongycastle.jce.provider.PKIXNameConstraintValidatorException r5 = new org.spongycastle.jce.provider.PKIXNameConstraintValidatorException
            java.lang.String r0 = "DNS is not from a permitted subtree."
            r5.<init>(r0)
            throw r5
        L_0x00d6:
            java.util.HashSet r0 = r4.c
            java.lang.String r5 = h(r5)
            if (r0 != 0) goto L_0x00df
            goto L_0x0102
        L_0x00df:
            java.util.Iterator r1 = r0.iterator()
        L_0x00e3:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x00f6
            java.lang.Object r2 = r1.next()
            java.lang.String r2 = (java.lang.String) r2
            boolean r2 = g(r5, r2)
            if (r2 == 0) goto L_0x00e3
            goto L_0x0102
        L_0x00f6:
            int r5 = r5.length()
            if (r5 != 0) goto L_0x0103
            int r5 = r0.size()
            if (r5 != 0) goto L_0x0103
        L_0x0102:
            return
        L_0x0103:
            org.spongycastle.jce.provider.PKIXNameConstraintValidatorException r5 = new org.spongycastle.jce.provider.PKIXNameConstraintValidatorException
            java.lang.String r0 = "Subject email address is not from a permitted subtree."
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jce.provider.PKIXNameConstraintValidator.d(org.spongycastle.asn1.x509.GeneralName):void");
    }

    public final void e(ASN1Sequence aSN1Sequence) throws PKIXNameConstraintValidatorException {
        HashSet hashSet = this.a;
        if (hashSet != null) {
            if (!hashSet.isEmpty() || aSN1Sequence.size() != 0) {
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    if (n(aSN1Sequence, (ASN1Sequence) it.next())) {
                        return;
                    }
                }
                throw new PKIXNameConstraintValidatorException("Subject distinguished name is not from a permitted subtree");
            }
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof PKIXNameConstraintValidator)) {
            return false;
        }
        PKIXNameConstraintValidator pKIXNameConstraintValidator = (PKIXNameConstraintValidator) obj;
        if (!f(pKIXNameConstraintValidator.f6588a, this.f6588a)) {
            return false;
        }
        if (!f(pKIXNameConstraintValidator.f6589b, this.f6589b)) {
            return false;
        }
        if (!f(pKIXNameConstraintValidator.f6590c, this.f6590c)) {
            return false;
        }
        if (!f(pKIXNameConstraintValidator.f6592e, this.f6592e)) {
            return false;
        }
        if (!f(pKIXNameConstraintValidator.f6591d, this.f6591d) || !f(pKIXNameConstraintValidator.a, this.a) || !f(pKIXNameConstraintValidator.b, this.b) || !f(pKIXNameConstraintValidator.c, this.c) || !f(pKIXNameConstraintValidator.e, this.e) || !f(pKIXNameConstraintValidator.d, this.d)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return i(this.d) + i(this.e) + i(this.c) + i(this.b) + i(this.a) + i(this.f6591d) + i(this.f6592e) + i(this.f6590c) + i(this.f6589b) + i(this.f6588a);
    }

    public final void j(GeneralSubtree[] generalSubtreeArr) {
        Iterator it;
        int i;
        Iterator it2;
        HashSet hashSet;
        Iterator it3;
        Set set;
        int i2;
        int i3;
        char c2;
        char c3;
        GeneralSubtree[] generalSubtreeArr2 = generalSubtreeArr;
        HashMap hashMap = new HashMap();
        int i4 = 0;
        for (int i5 = 0; i5 != generalSubtreeArr2.length; i5++) {
            GeneralSubtree generalSubtree = generalSubtreeArr2[i5];
            Integer valueOf = Integer.valueOf(generalSubtree.f5743a.c);
            if (hashMap.get(valueOf) == null) {
                hashMap.put(valueOf, new HashSet());
            }
            ((Set) hashMap.get(valueOf)).add(generalSubtree);
        }
        Iterator it4 = hashMap.entrySet().iterator();
        while (it4.hasNext()) {
            Map.Entry entry = (Map.Entry) it4.next();
            int intValue = ((Integer) entry.getKey()).intValue();
            if (intValue != 1) {
                int i6 = 2;
                if (intValue != 2) {
                    char c4 = 4;
                    if (intValue == 4) {
                        it = it4;
                        i = i4;
                        HashSet hashSet2 = this.a;
                        HashSet hashSet3 = new HashSet();
                        for (GeneralSubtree generalSubtree2 : (Set) entry.getValue()) {
                            ASN1Sequence q = ASN1Sequence.q(generalSubtree2.f5743a.a.b());
                            if (hashSet2 != null) {
                                Iterator it5 = hashSet2.iterator();
                                while (it5.hasNext()) {
                                    ASN1Sequence aSN1Sequence = (ASN1Sequence) it5.next();
                                    if (n(q, aSN1Sequence)) {
                                        hashSet3.add(q);
                                    } else if (n(aSN1Sequence, q)) {
                                        hashSet3.add(aSN1Sequence);
                                    }
                                }
                            } else if (q != null) {
                                hashSet3.add(q);
                            }
                        }
                        this.a = hashSet3;
                    } else if (intValue == 6) {
                        it = it4;
                        i = i4;
                        HashSet hashSet4 = this.d;
                        HashSet hashSet5 = new HashSet();
                        for (GeneralSubtree generalSubtree3 : (Set) entry.getValue()) {
                            String h = h(generalSubtree3.f5743a);
                            if (hashSet4 == null) {
                                hashSet5.add(h);
                            } else {
                                Iterator it6 = hashSet4.iterator();
                                while (it6.hasNext()) {
                                    String str = (String) it6.next();
                                    if (str.indexOf(64) != -1) {
                                        String substring = str.substring(str.indexOf(64) + 1);
                                        if (h.indexOf(64) != -1) {
                                            if (str.equalsIgnoreCase(h)) {
                                                hashSet5.add(str);
                                            }
                                        } else if (h.startsWith(".")) {
                                            if (o(substring, h)) {
                                                hashSet5.add(str);
                                            }
                                        } else if (substring.equalsIgnoreCase(h)) {
                                            hashSet5.add(str);
                                        }
                                    } else if (str.startsWith(".")) {
                                        if (h.indexOf(64) != -1) {
                                            if (o(h.substring(str.indexOf(64) + 1), str)) {
                                                hashSet5.add(h);
                                            }
                                        } else if (h.startsWith(".")) {
                                            if (o(str, h) || str.equalsIgnoreCase(h)) {
                                                hashSet5.add(str);
                                            } else if (o(h, str)) {
                                                hashSet5.add(h);
                                            }
                                        } else if (o(h, str)) {
                                            hashSet5.add(h);
                                        }
                                    } else if (h.indexOf(64) != -1) {
                                        if (h.substring(h.indexOf(64) + 1).equalsIgnoreCase(str)) {
                                            hashSet5.add(h);
                                        }
                                    } else if (h.startsWith(".")) {
                                        if (o(str, h)) {
                                            hashSet5.add(str);
                                        }
                                    } else if (str.equalsIgnoreCase(h)) {
                                        hashSet5.add(str);
                                    }
                                }
                            }
                        }
                        this.d = hashSet5;
                    } else if (intValue != 7) {
                        it = it4;
                        i = i4;
                    } else {
                        HashSet hashSet6 = this.e;
                        HashSet hashSet7 = new HashSet();
                        Iterator it7 = ((Set) entry.getValue()).iterator();
                        while (it7.hasNext()) {
                            byte[] s = ASN1OctetString.q(((GeneralSubtree) it7.next()).f5743a.a).s();
                            if (hashSet6 != null) {
                                Iterator it8 = hashSet6.iterator();
                                while (it8.hasNext()) {
                                    byte[] bArr = (byte[]) it8.next();
                                    if (bArr.length != s.length) {
                                        set = Collections.EMPTY_SET;
                                        it3 = it4;
                                        it2 = it7;
                                        i2 = i4;
                                        hashSet = hashSet6;
                                        i3 = i6;
                                        c2 = c4;
                                    } else {
                                        int length = bArr.length / i6;
                                        byte[] bArr2 = new byte[length];
                                        byte[] bArr3 = new byte[length];
                                        System.arraycopy(bArr, i4, bArr2, i4, length);
                                        System.arraycopy(bArr, length, bArr3, i4, length);
                                        byte[] bArr4 = new byte[length];
                                        byte[] bArr5 = new byte[length];
                                        System.arraycopy(s, i4, bArr4, i4, length);
                                        System.arraycopy(s, length, bArr5, i4, length);
                                        byte[] bArr6 = new byte[length];
                                        byte[] bArr7 = new byte[length];
                                        byte[] bArr8 = new byte[length];
                                        byte[] bArr9 = new byte[length];
                                        it3 = it4;
                                        int i7 = 0;
                                        while (i7 < length) {
                                            Iterator it9 = it7;
                                            bArr6[i7] = (byte) (bArr2[i7] & bArr3[i7]);
                                            byte b2 = bArr2[i7];
                                            HashSet hashSet8 = hashSet6;
                                            byte b3 = bArr3[i7];
                                            bArr7[i7] = (byte) ((b2 & b3) | (~b3));
                                            bArr8[i7] = (byte) (bArr4[i7] & bArr5[i7]);
                                            byte b4 = bArr4[i7];
                                            byte b5 = bArr5[i7];
                                            bArr9[i7] = (byte) ((b4 & b5) | (~b5));
                                            i7++;
                                            hashSet6 = hashSet8;
                                            it7 = it9;
                                        }
                                        it2 = it7;
                                        hashSet = hashSet6;
                                        c2 = 4;
                                        byte[][] bArr10 = {bArr6, bArr7, bArr8, bArr9};
                                        int i8 = 0;
                                        while (true) {
                                            if (i8 >= length) {
                                                bArr7 = bArr9;
                                                break;
                                            } else if ((bArr7[i8] & UnsignedBytes.MAX_VALUE) < (bArr9[i8] & UnsignedBytes.MAX_VALUE)) {
                                                break;
                                            } else {
                                                i8++;
                                            }
                                        }
                                        byte[] bArr11 = bArr10[0];
                                        byte[] bArr12 = bArr10[2];
                                        int i9 = 0;
                                        while (true) {
                                            if (i9 >= bArr11.length) {
                                                bArr11 = bArr12;
                                                break;
                                            } else if ((bArr11[i9] & UnsignedBytes.MAX_VALUE) > (bArr12[i9] & UnsignedBytes.MAX_VALUE)) {
                                                break;
                                            } else {
                                                i9++;
                                            }
                                        }
                                        if (Arrays.a(bArr11, bArr7)) {
                                            c3 = 0;
                                        } else {
                                            int i10 = 0;
                                            while (true) {
                                                if (i10 >= bArr11.length) {
                                                    break;
                                                } else if ((bArr11[i10] & UnsignedBytes.MAX_VALUE) > (bArr7[i10] & UnsignedBytes.MAX_VALUE)) {
                                                    bArr7 = bArr11;
                                                    break;
                                                } else {
                                                    i10++;
                                                }
                                            }
                                            if (Arrays.a(bArr7, bArr11)) {
                                                c3 = 1;
                                            } else {
                                                c3 = 65535;
                                            }
                                        }
                                        if (c3 == 1) {
                                            set = Collections.EMPTY_SET;
                                            i3 = 2;
                                            i2 = 0;
                                        } else {
                                            byte[] bArr13 = bArr10[0];
                                            i3 = 2;
                                            byte[] bArr14 = bArr10[2];
                                            int length2 = bArr13.length;
                                            byte[] bArr15 = new byte[length2];
                                            for (int i11 = 0; i11 < bArr13.length; i11++) {
                                                bArr15[i11] = (byte) (bArr13[i11] | bArr14[i11]);
                                            }
                                            byte[] bArr16 = new byte[length];
                                            for (int i12 = 0; i12 < length; i12++) {
                                                bArr16[i12] = (byte) (bArr3[i12] | bArr5[i12]);
                                            }
                                            byte[] bArr17 = new byte[(length2 * 2)];
                                            i2 = 0;
                                            System.arraycopy(bArr15, 0, bArr17, 0, length2);
                                            System.arraycopy(bArr16, 0, bArr17, length2, length2);
                                            set = Collections.singleton(bArr17);
                                        }
                                    }
                                    hashSet7.addAll(set);
                                    c4 = c2;
                                    i6 = i3;
                                    i4 = i2;
                                    it4 = it3;
                                    hashSet6 = hashSet;
                                    it7 = it2;
                                }
                                Iterator it10 = it4;
                                int i13 = i4;
                            } else if (s != null) {
                                hashSet7.add(s);
                            }
                        }
                        it = it4;
                        i = i4;
                        this.e = hashSet7;
                    }
                } else {
                    it = it4;
                    i = i4;
                    HashSet hashSet9 = this.b;
                    HashSet hashSet10 = new HashSet();
                    for (GeneralSubtree generalSubtree4 : (Set) entry.getValue()) {
                        String h2 = h(generalSubtree4.f5743a);
                        if (hashSet9 == null) {
                            hashSet10.add(h2);
                        } else {
                            Iterator it11 = hashSet9.iterator();
                            while (it11.hasNext()) {
                                String str2 = (String) it11.next();
                                if (o(str2, h2)) {
                                    hashSet10.add(str2);
                                } else if (o(h2, str2)) {
                                    hashSet10.add(h2);
                                }
                            }
                        }
                    }
                    this.b = hashSet10;
                }
            } else {
                it = it4;
                i = i4;
                HashSet hashSet11 = this.c;
                HashSet hashSet12 = new HashSet();
                for (GeneralSubtree generalSubtree5 : (Set) entry.getValue()) {
                    String h3 = h(generalSubtree5.f5743a);
                    if (hashSet11 == null) {
                        hashSet12.add(h3);
                    } else {
                        Iterator it12 = hashSet11.iterator();
                        while (it12.hasNext()) {
                            String str3 = (String) it12.next();
                            if (h3.indexOf(64) != -1) {
                                String substring2 = h3.substring(h3.indexOf(64) + 1);
                                if (str3.indexOf(64) != -1) {
                                    if (h3.equalsIgnoreCase(str3)) {
                                        hashSet12.add(h3);
                                    }
                                } else if (str3.startsWith(".")) {
                                    if (o(substring2, str3)) {
                                        hashSet12.add(h3);
                                    }
                                } else if (substring2.equalsIgnoreCase(str3)) {
                                    hashSet12.add(h3);
                                }
                            } else if (h3.startsWith(".")) {
                                if (str3.indexOf(64) != -1) {
                                    if (o(str3.substring(h3.indexOf(64) + 1), h3)) {
                                        hashSet12.add(str3);
                                    }
                                } else if (str3.startsWith(".")) {
                                    if (o(h3, str3) || h3.equalsIgnoreCase(str3)) {
                                        hashSet12.add(h3);
                                    } else if (o(str3, h3)) {
                                        hashSet12.add(str3);
                                    }
                                } else if (o(str3, h3)) {
                                    hashSet12.add(str3);
                                }
                            } else if (str3.indexOf(64) != -1) {
                                if (str3.substring(str3.indexOf(64) + 1).equalsIgnoreCase(h3)) {
                                    hashSet12.add(str3);
                                }
                            } else if (str3.startsWith(".")) {
                                if (o(h3, str3)) {
                                    hashSet12.add(h3);
                                }
                            } else if (h3.equalsIgnoreCase(str3)) {
                                hashSet12.add(h3);
                            }
                        }
                    }
                }
                this.c = hashSet12;
            }
            i4 = i;
            it4 = it;
        }
    }

    public final String toString() {
        String str;
        if (this.a != null) {
            str = "permitted:\nDN:\n" + this.a.toString() + "\n";
        } else {
            str = "permitted:\n";
        }
        if (this.b != null) {
            StringBuilder J = xx.J(C1058d.z(str, "DNS:\n"));
            J.append(this.b.toString());
            J.append("\n");
            str = J.toString();
        }
        if (this.c != null) {
            StringBuilder J2 = xx.J(C1058d.z(str, "Email:\n"));
            J2.append(this.c.toString());
            J2.append("\n");
            str = J2.toString();
        }
        if (this.d != null) {
            StringBuilder J3 = xx.J(C1058d.z(str, "URI:\n"));
            J3.append(this.d.toString());
            J3.append("\n");
            str = J3.toString();
        }
        if (this.e != null) {
            StringBuilder J4 = xx.J(C1058d.z(str, "IP:\n"));
            J4.append(m(this.e));
            J4.append("\n");
            str = J4.toString();
        }
        String z = C1058d.z(str, "excluded:\n");
        if (!this.f6588a.isEmpty()) {
            StringBuilder J5 = xx.J(C1058d.z(z, "DN:\n"));
            J5.append(this.f6588a.toString());
            J5.append("\n");
            z = J5.toString();
        }
        if (!this.f6589b.isEmpty()) {
            StringBuilder J6 = xx.J(C1058d.z(z, "DNS:\n"));
            J6.append(this.f6589b.toString());
            J6.append("\n");
            z = J6.toString();
        }
        if (!this.f6590c.isEmpty()) {
            StringBuilder J7 = xx.J(C1058d.z(z, "Email:\n"));
            J7.append(this.f6590c.toString());
            J7.append("\n");
            z = J7.toString();
        }
        if (!this.f6591d.isEmpty()) {
            StringBuilder J8 = xx.J(C1058d.z(z, "URI:\n"));
            J8.append(this.f6591d.toString());
            J8.append("\n");
            z = J8.toString();
        }
        if (this.f6592e.isEmpty()) {
            return z;
        }
        StringBuilder J9 = xx.J(C1058d.z(z, "IP:\n"));
        J9.append(m(this.f6592e));
        J9.append("\n");
        return J9.toString();
    }
}
