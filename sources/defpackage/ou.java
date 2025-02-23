package defpackage;

import java.util.ArrayList;

/* renamed from: ou  reason: default package */
/* compiled from: RunGroup */
public final class ou {
    public final CD a = null;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<CD> f3162a = new ArrayList<>();

    public ou(CD cd) {
        this.a = cd;
    }

    public static long a(N8 n8, long j) {
        CD cd = n8.f433b;
        if (cd instanceof Se) {
            return j;
        }
        ArrayList arrayList = n8.f431a;
        int size = arrayList.size();
        long j2 = j;
        for (int i = 0; i < size; i++) {
            J8 j8 = (J8) arrayList.get(i);
            if (j8 instanceof N8) {
                N8 n82 = (N8) j8;
                if (n82.f433b != cd) {
                    j2 = Math.min(j2, a(n82, ((long) n82.b) + j));
                }
            }
        }
        if (n8 != cd.f85b) {
            return j2;
        }
        long j3 = cd.j();
        N8 n83 = cd.f79a;
        long j4 = j - j3;
        return Math.min(Math.min(j2, a(n83, j4)), j4 - ((long) n83.b));
    }

    public static long b(N8 n8, long j) {
        CD cd = n8.f433b;
        if (cd instanceof Se) {
            return j;
        }
        ArrayList arrayList = n8.f431a;
        int size = arrayList.size();
        long j2 = j;
        for (int i = 0; i < size; i++) {
            J8 j8 = (J8) arrayList.get(i);
            if (j8 instanceof N8) {
                N8 n82 = (N8) j8;
                if (n82.f433b != cd) {
                    j2 = Math.max(j2, b(n82, ((long) n82.b) + j));
                }
            }
        }
        if (n8 != cd.f79a) {
            return j2;
        }
        long j3 = cd.j();
        N8 n83 = cd.f85b;
        long j4 = j + j3;
        return Math.max(Math.max(j2, b(n83, j4)), j4 - ((long) n83.b));
    }
}
