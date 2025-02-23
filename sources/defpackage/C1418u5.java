package defpackage;

import java.util.Collection;

/* renamed from: u5  reason: default package and case insensitive filesystem */
/* compiled from: IteratorsJVM.kt */
public class C1418u5 extends r1 {
    public static final int W(Iterable iterable) {
        C1177ig.f(iterable, "<this>");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).size();
        }
        return 10;
    }
}
