package androidx.work;

import androidx.work.Data;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class ArrayCreatingInputMerger extends Zf {
    public final Data a(ArrayList arrayList) {
        Object newInstance;
        Object newInstance2;
        Data.a aVar = new Data.a();
        HashMap hashMap = new HashMap();
        Iterator it = arrayList.iterator();
        loop0:
        while (it.hasNext()) {
            Iterator it2 = Collections.unmodifiableMap(((Data) it.next()).f2635a).entrySet().iterator();
            while (true) {
                if (it2.hasNext()) {
                    Map.Entry entry = (Map.Entry) it2.next();
                    String str = (String) entry.getKey();
                    Object value = entry.getValue();
                    Class<?> cls = value.getClass();
                    Object obj = hashMap.get(str);
                    if (obj != null) {
                        Class<?> cls2 = obj.getClass();
                        if (!cls2.equals(cls)) {
                            if (cls2.isArray() && cls2.getComponentType().equals(cls)) {
                                int length = Array.getLength(obj);
                                newInstance = Array.newInstance(value.getClass(), length + 1);
                                System.arraycopy(obj, 0, newInstance, 0, length);
                                Array.set(newInstance, length, value);
                            } else if (cls.isArray() && cls.getComponentType().equals(cls2)) {
                                int length2 = Array.getLength(value);
                                newInstance = Array.newInstance(obj.getClass(), length2 + 1);
                                System.arraycopy(value, 0, newInstance, 0, length2);
                                Array.set(newInstance, length2, obj);
                            }
                            value = newInstance;
                        } else if (cls2.isArray()) {
                            int length3 = Array.getLength(obj);
                            int length4 = Array.getLength(value);
                            Object newInstance3 = Array.newInstance(obj.getClass().getComponentType(), length3 + length4);
                            System.arraycopy(obj, 0, newInstance3, 0, length3);
                            System.arraycopy(value, 0, newInstance3, length3, length4);
                            value = newInstance3;
                        } else {
                            newInstance2 = Array.newInstance(obj.getClass(), 2);
                            Array.set(newInstance2, 0, obj);
                            Array.set(newInstance2, 1, value);
                        }
                        hashMap.put(str, value);
                    } else if (cls.isArray()) {
                        hashMap.put(str, value);
                    } else {
                        newInstance2 = Array.newInstance(value.getClass(), 1);
                        Array.set(newInstance2, 0, value);
                    }
                    value = newInstance2;
                    hashMap.put(str, value);
                }
            }
            throw new IllegalArgumentException();
        }
        aVar.a(hashMap);
        Data data = new Data(aVar.a);
        Data.c(data);
        return data;
    }
}
