package com.google.android.material.color;

import android.content.Context;
import android.content.res.loader.ResourcesLoader;
import java.util.Map;

final class ResourcesLoaderUtils {
    private ResourcesLoaderUtils() {
    }

    public static boolean addResourcesLoaderToContext(Context context, Map<Integer, Integer> map) {
        ResourcesLoader create = ColorResourcesLoaderCreator.create(context, map);
        if (create == null) {
            return false;
        }
        context.getResources().addLoaders(new ResourcesLoader[]{create});
        return true;
    }

    public static boolean isColorResource(int i) {
        if (28 > i || i > 31) {
            return false;
        }
        return true;
    }
}
