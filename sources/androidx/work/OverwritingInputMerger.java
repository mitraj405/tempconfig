package androidx.work;

import androidx.work.Data;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public final class OverwritingInputMerger extends Zf {
    public final Data a(ArrayList arrayList) {
        Data.a aVar = new Data.a();
        HashMap hashMap = new HashMap();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            hashMap.putAll(Collections.unmodifiableMap(((Data) it.next()).f2635a));
        }
        aVar.a(hashMap);
        Data data = new Data(aVar.a);
        Data.c(data);
        return data;
    }
}
