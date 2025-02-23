package com.google.firebase.components;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import com.google.firebase.inject.Provider;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class ComponentDiscovery<T> {
    private static final String COMPONENT_KEY_PREFIX = "com.google.firebase.components:";
    private static final String COMPONENT_SENTINEL_VALUE = "com.google.firebase.components.ComponentRegistrar";
    static final String TAG = "ComponentDiscovery";
    private final T context;
    private final RegistrarNameRetriever<T> retriever;

    public static class MetadataRegistrarNameRetriever implements RegistrarNameRetriever<Context> {
        private final Class<? extends Service> discoveryService;

        private Bundle getMetadata(Context context) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    return null;
                }
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, this.discoveryService), 128);
                if (serviceInfo != null) {
                    return serviceInfo.metaData;
                }
                Objects.toString(this.discoveryService);
                return null;
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }

        private MetadataRegistrarNameRetriever(Class<? extends Service> cls) {
            this.discoveryService = cls;
        }

        public List<String> retrieve(Context context) {
            Bundle metadata = getMetadata(context);
            if (metadata == null) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            for (String next : metadata.keySet()) {
                if (ComponentDiscovery.COMPONENT_SENTINEL_VALUE.equals(metadata.get(next)) && next.startsWith(ComponentDiscovery.COMPONENT_KEY_PREFIX)) {
                    arrayList.add(next.substring(31));
                }
            }
            return arrayList;
        }
    }

    public interface RegistrarNameRetriever<T> {
        List<String> retrieve(T t);
    }

    public ComponentDiscovery(T t, RegistrarNameRetriever<T> registrarNameRetriever) {
        this.context = t;
        this.retriever = registrarNameRetriever;
    }

    public static ComponentDiscovery<Context> forContext(Context context2, Class<? extends Service> cls) {
        return new ComponentDiscovery<>(context2, new MetadataRegistrarNameRetriever(cls));
    }

    /* access modifiers changed from: private */
    public static ComponentRegistrar instantiate(String str) {
        try {
            Class<?> cls = Class.forName(str);
            if (ComponentRegistrar.class.isAssignableFrom(cls)) {
                return (ComponentRegistrar) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            }
            throw new InvalidRegistrarException(String.format("Class %s is not an instance of %s", new Object[]{str, COMPONENT_SENTINEL_VALUE}));
        } catch (ClassNotFoundException unused) {
            String.format("Class %s is not an found.", new Object[]{str});
            return null;
        } catch (IllegalAccessException e) {
            throw new InvalidRegistrarException(String.format("Could not instantiate %s.", new Object[]{str}), e);
        } catch (InstantiationException e2) {
            throw new InvalidRegistrarException(String.format("Could not instantiate %s.", new Object[]{str}), e2);
        } catch (NoSuchMethodException e3) {
            throw new InvalidRegistrarException(String.format("Could not instantiate %s", new Object[]{str}), e3);
        } catch (InvocationTargetException e4) {
            throw new InvalidRegistrarException(String.format("Could not instantiate %s", new Object[]{str}), e4);
        }
    }

    @Deprecated
    public List<ComponentRegistrar> discover() {
        ArrayList arrayList = new ArrayList();
        for (String instantiate : this.retriever.retrieve(this.context)) {
            try {
                ComponentRegistrar instantiate2 = instantiate(instantiate);
                if (instantiate2 != null) {
                    arrayList.add(instantiate2);
                }
            } catch (InvalidRegistrarException unused) {
            }
        }
        return arrayList;
    }

    public List<Provider<ComponentRegistrar>> discoverLazy() {
        ArrayList arrayList = new ArrayList();
        for (String g6Var : this.retriever.retrieve(this.context)) {
            arrayList.add(new C0200g6(g6Var, 0));
        }
        return arrayList;
    }
}
