package org.spongycastle.jce.provider;

import java.security.cert.PolicyNode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class PKIXPolicyNode implements PolicyNode {
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public final String f6593a;

    /* renamed from: a  reason: collision with other field name */
    public PolicyNode f6594a;

    /* renamed from: a  reason: collision with other field name */
    public final List f6595a;

    /* renamed from: a  reason: collision with other field name */
    public Set f6596a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f6597a;
    public final Set b;

    public PKIXPolicyNode(ArrayList arrayList, int i, Set set, PKIXPolicyNode pKIXPolicyNode, HashSet hashSet, String str, boolean z) {
        this.f6595a = arrayList;
        this.a = i;
        this.f6596a = set;
        this.f6594a = pKIXPolicyNode;
        this.b = hashSet;
        this.f6593a = str;
        this.f6597a = z;
    }

    public final PKIXPolicyNode a() {
        HashSet hashSet = new HashSet();
        for (String str : this.f6596a) {
            hashSet.add(new String(str));
        }
        HashSet hashSet2 = new HashSet();
        for (String str2 : this.b) {
            hashSet2.add(new String(str2));
        }
        PKIXPolicyNode pKIXPolicyNode = new PKIXPolicyNode(new ArrayList(), this.a, hashSet, (PKIXPolicyNode) null, hashSet2, new String(this.f6593a), this.f6597a);
        for (PKIXPolicyNode a2 : this.f6595a) {
            PKIXPolicyNode a3 = a2.a();
            a3.f6594a = pKIXPolicyNode;
            pKIXPolicyNode.f6595a.add(a3);
            a3.f6594a = pKIXPolicyNode;
        }
        return pKIXPolicyNode;
    }

    public final String b(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(this.f6593a);
        stringBuffer.append(" {\n");
        int i = 0;
        while (true) {
            List list = this.f6595a;
            if (i < list.size()) {
                stringBuffer.append(((PKIXPolicyNode) list.get(i)).b(str + "    "));
                i++;
            } else {
                stringBuffer.append(str);
                stringBuffer.append("}\n");
                return stringBuffer.toString();
            }
        }
    }

    public final Object clone() {
        return a();
    }

    public final Iterator getChildren() {
        return this.f6595a.iterator();
    }

    public final int getDepth() {
        return this.a;
    }

    public final Set getExpectedPolicies() {
        return this.f6596a;
    }

    public final PolicyNode getParent() {
        return this.f6594a;
    }

    public final Set getPolicyQualifiers() {
        return this.b;
    }

    public final String getValidPolicy() {
        return this.f6593a;
    }

    public final boolean isCritical() {
        return this.f6597a;
    }

    public final String toString() {
        return b("");
    }
}
