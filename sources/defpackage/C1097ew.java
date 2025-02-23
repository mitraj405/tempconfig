package defpackage;

import java.util.ArrayList;
import java.util.List;

/* renamed from: ew  reason: default package and case insensitive filesystem */
public final class C1097ew extends C1328pk {
    public static final List Y(C0810bw bwVar) {
        ArrayList arrayList = new ArrayList();
        for (Object add : bwVar) {
            arrayList.add(add);
        }
        int size = arrayList.size();
        if (size == 0) {
            return C1477xa.a;
        }
        if (size != 1) {
            return arrayList;
        }
        return r1.E(arrayList.get(0));
    }
}
