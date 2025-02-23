package defpackage;

import java.util.ArrayList;
import java.util.List;

/* renamed from: Tc  reason: default package and case insensitive filesystem */
/* compiled from: FontCharacter */
public final class C0101Tc {
    public final char a;

    /* renamed from: a  reason: collision with other field name */
    public final double f551a;

    /* renamed from: a  reason: collision with other field name */
    public final String f552a;

    /* renamed from: a  reason: collision with other field name */
    public final List<qw> f553a;
    public final String b;

    public C0101Tc(ArrayList arrayList, char c, double d, String str, String str2) {
        this.f553a = arrayList;
        this.a = c;
        this.f551a = d;
        this.f552a = str;
        this.b = str2;
    }

    public static int a(char c, String str, String str2) {
        return str2.hashCode() + lf.g(str, (c + 0) * 31, 31);
    }

    public final int hashCode() {
        return a(this.a, this.b, this.f552a);
    }
}
