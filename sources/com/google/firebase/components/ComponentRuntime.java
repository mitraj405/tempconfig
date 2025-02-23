package com.google.firebase.components;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.firebase.dynamicloading.ComponentLoader;
import com.google.firebase.events.Publisher;
import com.google.firebase.events.Subscriber;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

public class ComponentRuntime implements ComponentContainer, ComponentLoader {
    private static final Provider<Set<Object>> EMPTY_PROVIDER = new d(1);
    private final ComponentRegistrarProcessor componentRegistrarProcessor;
    private final Map<Component<?>, Provider<?>> components;
    private final AtomicReference<Boolean> eagerComponentsInitializedWith;
    private final EventBus eventBus;
    private final Map<Qualified<?>, Provider<?>> lazyInstanceMap;
    private final Map<Qualified<?>, LazySet<?>> lazySetMap;
    private Set<String> processedCoroutineDispatcherInterfaces;
    private final List<Provider<ComponentRegistrar>> unprocessedRegistrarProviders;

    public static Builder builder(Executor executor) {
        return new Builder(executor);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:11|12|49) */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r1.remove();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void discoverComponents(java.util.List<com.google.firebase.components.Component<?>> r9) {
        /*
            r8 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            monitor-enter(r8)
            java.util.List<com.google.firebase.inject.Provider<com.google.firebase.components.ComponentRegistrar>> r1 = r8.unprocessedRegistrarProviders     // Catch:{ all -> 0x00de }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x00de }
        L_0x000c:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x00de }
            if (r2 == 0) goto L_0x0031
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x00de }
            com.google.firebase.inject.Provider r2 = (com.google.firebase.inject.Provider) r2     // Catch:{ all -> 0x00de }
            java.lang.Object r2 = r2.get()     // Catch:{ InvalidRegistrarException -> 0x002d }
            com.google.firebase.components.ComponentRegistrar r2 = (com.google.firebase.components.ComponentRegistrar) r2     // Catch:{ InvalidRegistrarException -> 0x002d }
            if (r2 == 0) goto L_0x000c
            com.google.firebase.components.ComponentRegistrarProcessor r3 = r8.componentRegistrarProcessor     // Catch:{ InvalidRegistrarException -> 0x002d }
            java.util.List r2 = r3.processRegistrar(r2)     // Catch:{ InvalidRegistrarException -> 0x002d }
            r9.addAll(r2)     // Catch:{ InvalidRegistrarException -> 0x002d }
            r1.remove()     // Catch:{ InvalidRegistrarException -> 0x002d }
            goto L_0x000c
        L_0x002d:
            r1.remove()     // Catch:{ all -> 0x00de }
            goto L_0x000c
        L_0x0031:
            java.util.Iterator r1 = r9.iterator()     // Catch:{ all -> 0x00de }
        L_0x0035:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x00de }
            if (r2 == 0) goto L_0x0077
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x00de }
            com.google.firebase.components.Component r2 = (com.google.firebase.components.Component) r2     // Catch:{ all -> 0x00de }
            java.util.Set r2 = r2.getProvidedInterfaces()     // Catch:{ all -> 0x00de }
            java.lang.Object[] r2 = r2.toArray()     // Catch:{ all -> 0x00de }
            int r3 = r2.length     // Catch:{ all -> 0x00de }
            r4 = 0
        L_0x004b:
            if (r4 >= r3) goto L_0x0035
            r5 = r2[r4]     // Catch:{ all -> 0x00de }
            java.lang.String r6 = r5.toString()     // Catch:{ all -> 0x00de }
            java.lang.String r7 = "kotlinx.coroutines.CoroutineDispatcher"
            boolean r6 = r6.contains(r7)     // Catch:{ all -> 0x00de }
            if (r6 == 0) goto L_0x0074
            java.util.Set<java.lang.String> r6 = r8.processedCoroutineDispatcherInterfaces     // Catch:{ all -> 0x00de }
            java.lang.String r7 = r5.toString()     // Catch:{ all -> 0x00de }
            boolean r6 = r6.contains(r7)     // Catch:{ all -> 0x00de }
            if (r6 == 0) goto L_0x006b
            r1.remove()     // Catch:{ all -> 0x00de }
            goto L_0x0035
        L_0x006b:
            java.util.Set<java.lang.String> r6 = r8.processedCoroutineDispatcherInterfaces     // Catch:{ all -> 0x00de }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x00de }
            r6.add(r5)     // Catch:{ all -> 0x00de }
        L_0x0074:
            int r4 = r4 + 1
            goto L_0x004b
        L_0x0077:
            java.util.Map<com.google.firebase.components.Component<?>, com.google.firebase.inject.Provider<?>> r1 = r8.components     // Catch:{ all -> 0x00de }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x00de }
            if (r1 == 0) goto L_0x0083
            com.google.firebase.components.CycleDetector.detect(r9)     // Catch:{ all -> 0x00de }
            goto L_0x0094
        L_0x0083:
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x00de }
            java.util.Map<com.google.firebase.components.Component<?>, com.google.firebase.inject.Provider<?>> r2 = r8.components     // Catch:{ all -> 0x00de }
            java.util.Set r2 = r2.keySet()     // Catch:{ all -> 0x00de }
            r1.<init>(r2)     // Catch:{ all -> 0x00de }
            r1.addAll(r9)     // Catch:{ all -> 0x00de }
            com.google.firebase.components.CycleDetector.detect(r1)     // Catch:{ all -> 0x00de }
        L_0x0094:
            java.util.Iterator r1 = r9.iterator()     // Catch:{ all -> 0x00de }
        L_0x0098:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x00de }
            if (r2 == 0) goto L_0x00b4
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x00de }
            com.google.firebase.components.Component r2 = (com.google.firebase.components.Component) r2     // Catch:{ all -> 0x00de }
            com.google.firebase.components.Lazy r3 = new com.google.firebase.components.Lazy     // Catch:{ all -> 0x00de }
            h6 r4 = new h6     // Catch:{ all -> 0x00de }
            r4.<init>(r8, r2)     // Catch:{ all -> 0x00de }
            r3.<init>(r4)     // Catch:{ all -> 0x00de }
            java.util.Map<com.google.firebase.components.Component<?>, com.google.firebase.inject.Provider<?>> r4 = r8.components     // Catch:{ all -> 0x00de }
            r4.put(r2, r3)     // Catch:{ all -> 0x00de }
            goto L_0x0098
        L_0x00b4:
            java.util.List r9 = r8.processInstanceComponents(r9)     // Catch:{ all -> 0x00de }
            r0.addAll(r9)     // Catch:{ all -> 0x00de }
            java.util.List r9 = r8.processSetComponents()     // Catch:{ all -> 0x00de }
            r0.addAll(r9)     // Catch:{ all -> 0x00de }
            r8.processDependencies()     // Catch:{ all -> 0x00de }
            monitor-exit(r8)     // Catch:{ all -> 0x00de }
            java.util.Iterator r9 = r0.iterator()
        L_0x00ca:
            boolean r0 = r9.hasNext()
            if (r0 == 0) goto L_0x00da
            java.lang.Object r0 = r9.next()
            java.lang.Runnable r0 = (java.lang.Runnable) r0
            r0.run()
            goto L_0x00ca
        L_0x00da:
            r8.maybeInitializeEagerComponents()
            return
        L_0x00de:
            r9 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x00de }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.components.ComponentRuntime.discoverComponents(java.util.List):void");
    }

    private void doInitializeEagerComponents(Map<Component<?>, Provider<?>> map, boolean z) {
        for (Map.Entry next : map.entrySet()) {
            Component component = (Component) next.getKey();
            Provider provider = (Provider) next.getValue();
            if (component.isAlwaysEager() || (component.isEagerInDefaultApp() && z)) {
                provider.get();
            }
        }
        this.eventBus.enablePublishingAndFlushPending();
    }

    private static <T> List<T> iterableToList(Iterable<T> iterable) {
        ArrayList arrayList = new ArrayList();
        for (T add : iterable) {
            arrayList.add(add);
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$discoverComponents$0(Component component) {
        return component.getFactory().create(new RestrictedComponentContainer(component, this));
    }

    private void maybeInitializeEagerComponents() {
        Boolean bool = this.eagerComponentsInitializedWith.get();
        if (bool != null) {
            doInitializeEagerComponents(this.components, bool.booleanValue());
        }
    }

    private void processDependencies() {
        for (Component next : this.components.keySet()) {
            Iterator<Dependency> it = next.getDependencies().iterator();
            while (true) {
                if (it.hasNext()) {
                    Dependency next2 = it.next();
                    if (next2.isSet() && !this.lazySetMap.containsKey(next2.getInterface())) {
                        this.lazySetMap.put(next2.getInterface(), LazySet.fromCollection(Collections.emptySet()));
                    } else if (this.lazyInstanceMap.containsKey(next2.getInterface())) {
                        continue;
                    } else if (next2.isRequired()) {
                        throw new MissingDependencyException(String.format("Unsatisfied dependency for component %s: %s", new Object[]{next, next2.getInterface()}));
                    } else if (!next2.isSet()) {
                        this.lazyInstanceMap.put(next2.getInterface(), OptionalProvider.empty());
                    }
                }
            }
        }
    }

    private List<Runnable> processInstanceComponents(List<Component<?>> list) {
        ArrayList arrayList = new ArrayList();
        for (Component next : list) {
            if (next.isValue()) {
                Provider provider = this.components.get(next);
                for (Qualified qualified : next.getProvidedInterfaces()) {
                    if (!this.lazyInstanceMap.containsKey(qualified)) {
                        this.lazyInstanceMap.put(qualified, provider);
                    } else {
                        arrayList.add(new a((OptionalProvider) this.lazyInstanceMap.get(qualified), provider));
                    }
                }
            }
        }
        return arrayList;
    }

    private List<Runnable> processSetComponents() {
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        for (Map.Entry next : this.components.entrySet()) {
            Component component = (Component) next.getKey();
            if (!component.isValue()) {
                Provider provider = (Provider) next.getValue();
                for (Qualified qualified : component.getProvidedInterfaces()) {
                    if (!hashMap.containsKey(qualified)) {
                        hashMap.put(qualified, new HashSet());
                    }
                    ((Set) hashMap.get(qualified)).add(provider);
                }
            }
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            if (!this.lazySetMap.containsKey(entry.getKey())) {
                this.lazySetMap.put((Qualified) entry.getKey(), LazySet.fromCollection((Collection) entry.getValue()));
            } else {
                LazySet lazySet = this.lazySetMap.get(entry.getKey());
                for (Provider bVar : (Set) entry.getValue()) {
                    arrayList.add(new b(0, lazySet, bVar));
                }
            }
        }
        return arrayList;
    }

    private static Iterable<Provider<ComponentRegistrar>> toProviders(Iterable<ComponentRegistrar> iterable) {
        ArrayList arrayList = new ArrayList();
        for (ComponentRegistrar i6Var : iterable) {
            arrayList.add(new i6(i6Var, 0));
        }
        return arrayList;
    }

    public Collection<Component<?>> getAllComponentsForTest() {
        return this.components.keySet();
    }

    public <T> Deferred<T> getDeferred(Qualified<T> qualified) {
        Provider<T> provider = getProvider(qualified);
        if (provider == null) {
            return OptionalProvider.empty();
        }
        if (provider instanceof OptionalProvider) {
            return (OptionalProvider) provider;
        }
        return OptionalProvider.of(provider);
    }

    public synchronized <T> Provider<T> getProvider(Qualified<T> qualified) {
        Preconditions.checkNotNull(qualified, "Null interface requested.");
        return this.lazyInstanceMap.get(qualified);
    }

    public void initializeAllComponentsForTests() {
        for (Provider<?> provider : this.components.values()) {
            provider.get();
        }
    }

    public void initializeEagerComponents(boolean z) {
        boolean z2;
        HashMap hashMap;
        AtomicReference<Boolean> atomicReference = this.eagerComponentsInitializedWith;
        Boolean valueOf = Boolean.valueOf(z);
        while (true) {
            if (!atomicReference.compareAndSet((Object) null, valueOf)) {
                if (atomicReference.get() != null) {
                    z2 = false;
                    break;
                }
            } else {
                z2 = true;
                break;
            }
        }
        if (z2) {
            synchronized (this) {
                hashMap = new HashMap(this.components);
            }
            doInitializeEagerComponents(hashMap, z);
        }
    }

    public synchronized <T> Provider<Set<T>> setOfProvider(Qualified<T> qualified) {
        LazySet lazySet = this.lazySetMap.get(qualified);
        if (lazySet != null) {
            return lazySet;
        }
        return EMPTY_PROVIDER;
    }

    @Deprecated
    public ComponentRuntime(Executor executor, Iterable<ComponentRegistrar> iterable, Component<?>... componentArr) {
        this(executor, toProviders(iterable), Arrays.asList(componentArr), ComponentRegistrarProcessor.NOOP);
    }

    private ComponentRuntime(Executor executor, Iterable<Provider<ComponentRegistrar>> iterable, Collection<Component<?>> collection, ComponentRegistrarProcessor componentRegistrarProcessor2) {
        this.components = new HashMap();
        this.lazyInstanceMap = new HashMap();
        this.lazySetMap = new HashMap();
        this.processedCoroutineDispatcherInterfaces = new HashSet();
        this.eagerComponentsInitializedWith = new AtomicReference<>();
        EventBus eventBus2 = new EventBus(executor);
        this.eventBus = eventBus2;
        this.componentRegistrarProcessor = componentRegistrarProcessor2;
        ArrayList arrayList = new ArrayList();
        arrayList.add(Component.of(eventBus2, EventBus.class, (Class<? super T>[]) new Class[]{Subscriber.class, Publisher.class}));
        arrayList.add(Component.of(this, ComponentLoader.class, (Class<? super T>[]) new Class[0]));
        for (Component next : collection) {
            if (next != null) {
                arrayList.add(next);
            }
        }
        this.unprocessedRegistrarProviders = iterableToList(iterable);
        discoverComponents(arrayList);
    }

    public static final class Builder {
        private final List<Component<?>> additionalComponents = new ArrayList();
        private ComponentRegistrarProcessor componentRegistrarProcessor = ComponentRegistrarProcessor.NOOP;
        private final Executor defaultExecutor;
        private final List<Provider<ComponentRegistrar>> lazyRegistrars = new ArrayList();

        public Builder(Executor executor) {
            this.defaultExecutor = executor;
        }

        @CanIgnoreReturnValue
        public Builder addComponent(Component<?> component) {
            this.additionalComponents.add(component);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder addComponentRegistrar(ComponentRegistrar componentRegistrar) {
            this.lazyRegistrars.add(new C0200g6(componentRegistrar, 1));
            return this;
        }

        @CanIgnoreReturnValue
        public Builder addLazyComponentRegistrars(Collection<Provider<ComponentRegistrar>> collection) {
            this.lazyRegistrars.addAll(collection);
            return this;
        }

        public ComponentRuntime build() {
            return new ComponentRuntime(this.defaultExecutor, this.lazyRegistrars, this.additionalComponents, this.componentRegistrarProcessor);
        }

        @CanIgnoreReturnValue
        public Builder setProcessor(ComponentRegistrarProcessor componentRegistrarProcessor2) {
            this.componentRegistrarProcessor = componentRegistrarProcessor2;
            return this;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ ComponentRegistrar lambda$addComponentRegistrar$0(ComponentRegistrar componentRegistrar) {
            return componentRegistrar;
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ ComponentRegistrar lambda$toProviders$1(ComponentRegistrar componentRegistrar) {
        return componentRegistrar;
    }

    public void discoverComponents() {
        synchronized (this) {
            if (!this.unprocessedRegistrarProviders.isEmpty()) {
                discoverComponents(new ArrayList());
            }
        }
    }
}
