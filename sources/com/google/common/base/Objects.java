package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import java.util.Arrays;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public final class Objects extends ExtraObjectsMethodsForWeb {
    private Objects() {
    }

    public static boolean equal(Object obj, Object obj2) {
        if (obj == obj2 || (obj != null && obj.equals(obj2))) {
            return true;
        }
        return false;
    }

    public static int hashCode(Object... objArr) {
        return Arrays.hashCode(objArr);
    }
}
