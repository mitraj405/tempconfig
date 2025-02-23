package defpackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: uh  reason: default package */
/* compiled from: KeyPath */
public final class uh {
    public static final uh a = new uh("COMPOSITION");

    /* renamed from: a  reason: collision with other field name */
    public final List<String> f3321a;

    /* renamed from: a  reason: collision with other field name */
    public C0368vh f3322a;

    public uh(String... strArr) {
        this.f3321a = Arrays.asList(strArr);
    }

    public final boolean a(int i, String str) {
        boolean z;
        boolean z2;
        boolean z3;
        List<String> list = this.f3321a;
        if (i >= list.size()) {
            return false;
        }
        if (i == list.size() - 1) {
            z = true;
        } else {
            z = false;
        }
        String str2 = list.get(i);
        if (!str2.equals("**")) {
            if (str2.equals(str) || str2.equals("*")) {
                z3 = true;
            } else {
                z3 = false;
            }
            if ((z || (i == list.size() - 2 && list.get(list.size() - 1).equals("**"))) && z3) {
                return true;
            }
            return false;
        }
        if (z || !list.get(i + 1).equals(str)) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            if (i == list.size() - 2 || (i == list.size() - 3 && list.get(list.size() - 1).equals("**"))) {
                return true;
            }
            return false;
        } else if (z) {
            return true;
        } else {
            int i2 = i + 1;
            if (i2 < list.size() - 1) {
                return false;
            }
            return list.get(i2).equals(str);
        }
    }

    public final int b(int i, String str) {
        if ("__container".equals(str)) {
            return 0;
        }
        List<String> list = this.f3321a;
        if (!list.get(i).equals("**")) {
            return 1;
        }
        if (i != list.size() - 1 && list.get(i + 1).equals(str)) {
            return 2;
        }
        return 0;
    }

    public final boolean c(int i, String str) {
        if ("__container".equals(str)) {
            return true;
        }
        List<String> list = this.f3321a;
        if (i >= list.size()) {
            return false;
        }
        if (list.get(i).equals(str) || list.get(i).equals("**") || list.get(i).equals("*")) {
            return true;
        }
        return false;
    }

    public final boolean d(int i, String str) {
        if ("__container".equals(str)) {
            return true;
        }
        List<String> list = this.f3321a;
        if (i < list.size() - 1 || list.get(i).equals("**")) {
            return true;
        }
        return false;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || uh.class != obj.getClass()) {
            return false;
        }
        uh uhVar = (uh) obj;
        if (!this.f3321a.equals(uhVar.f3321a)) {
            return false;
        }
        C0368vh vhVar = this.f3322a;
        C0368vh vhVar2 = uhVar.f3322a;
        if (vhVar != null) {
            return vhVar.equals(vhVar2);
        }
        if (vhVar2 == null) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i;
        int hashCode = this.f3321a.hashCode() * 31;
        C0368vh vhVar = this.f3322a;
        if (vhVar != null) {
            i = vhVar.hashCode();
        } else {
            i = 0;
        }
        return hashCode + i;
    }

    public final String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("KeyPath{keys=");
        sb.append(this.f3321a);
        sb.append(",resolved=");
        if (this.f3322a != null) {
            z = true;
        } else {
            z = false;
        }
        sb.append(z);
        sb.append('}');
        return sb.toString();
    }

    public uh(uh uhVar) {
        this.f3321a = new ArrayList(uhVar.f3321a);
        this.f3322a = uhVar.f3322a;
    }
}
