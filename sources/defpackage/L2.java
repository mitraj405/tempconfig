package defpackage;

import java.util.Arrays;

/* renamed from: L2  reason: default package */
/* compiled from: BiometricErrorData */
public final class L2 {
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public final CharSequence f381a;

    public L2(int i, CharSequence charSequence) {
        this.a = i;
        this.f381a = charSequence;
    }

    public final boolean equals(Object obj) {
        L2 l2;
        String str;
        boolean z;
        if (!(obj instanceof L2) || this.a != (l2 = (L2) obj).a) {
            return false;
        }
        String str2 = null;
        CharSequence charSequence = this.f381a;
        if (charSequence != null) {
            str = charSequence.toString();
        } else {
            str = null;
        }
        CharSequence charSequence2 = l2.f381a;
        if (charSequence2 != null) {
            str2 = charSequence2.toString();
        }
        if (!(str == null && str2 == null) && (str == null || !str.equals(str2))) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        String str;
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(this.a);
        CharSequence charSequence = this.f381a;
        if (charSequence != null) {
            str = charSequence.toString();
        } else {
            str = null;
        }
        objArr[1] = str;
        return Arrays.hashCode(objArr);
    }
}
