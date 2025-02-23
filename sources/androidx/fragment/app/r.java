package androidx.fragment.app;

import android.view.View;
import androidx.collection.ArrayMap;
import androidx.core.app.SharedElementCallback;
import androidx.transition.b;
import java.util.ArrayList;

/* compiled from: FragmentTransition */
public final class r {
    public static final C0342td a = new C0342td();

    /* renamed from: a  reason: collision with other field name */
    public static final C0379wd f2164a;

    static {
        C0379wd wdVar;
        try {
            wdVar = b.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            wdVar = null;
        }
        f2164a = wdVar;
    }

    public static void a(Fragment fragment, Fragment fragment2, boolean z, ArrayMap arrayMap) {
        SharedElementCallback sharedElementCallback;
        int i;
        if (z) {
            sharedElementCallback = fragment2.getEnterTransitionCallback();
        } else {
            sharedElementCallback = fragment.getEnterTransitionCallback();
        }
        if (sharedElementCallback != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (arrayMap == null) {
                i = 0;
            } else {
                i = arrayMap.f1328c;
            }
            for (int i2 = 0; i2 < i; i2++) {
                arrayList2.add(arrayMap.h(i2));
                arrayList.add(arrayMap.j(i2));
            }
        }
    }

    public static String b(ArrayMap<String, String> arrayMap, String str) {
        int i = arrayMap.f1328c;
        for (int i2 = 0; i2 < i; i2++) {
            if (str.equals(arrayMap.j(i2))) {
                return arrayMap.h(i2);
            }
        }
        return null;
    }

    public static void c(int i, ArrayList arrayList) {
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((View) arrayList.get(size)).setVisibility(i);
            }
        }
    }
}
