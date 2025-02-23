package defpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;

/* renamed from: pk  reason: default package and case insensitive filesystem */
/* compiled from: _MapsJvm.kt */
public class C1328pk extends r1 {
    public static final Map W(ArrayList arrayList) {
        C1497ya yaVar = C1497ya.a;
        int size = arrayList.size();
        if (size == 0) {
            return yaVar;
        }
        if (size != 1) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(r1.H(arrayList.size()));
            X(arrayList, linkedHashMap);
            return linkedHashMap;
        }
        Pair pair = (Pair) arrayList.get(0);
        C1177ig.f(pair, "pair");
        Map singletonMap = Collections.singletonMap(pair.a, pair.b);
        C1177ig.e(singletonMap, "singletonMap(pair.first, pair.second)");
        return singletonMap;
    }

    public static final void X(ArrayList arrayList, LinkedHashMap linkedHashMap) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            linkedHashMap.put(pair.a, pair.b);
        }
    }
}
