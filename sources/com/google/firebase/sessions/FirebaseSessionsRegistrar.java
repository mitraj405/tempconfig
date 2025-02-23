package com.google.firebase.sessions;

import android.content.Context;
import androidx.annotation.Keep;
import com.google.android.datatransport.TransportFactory;
import com.google.firebase.FirebaseApp;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Qualified;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import com.google.firebase.sessions.settings.SessionsSettings;
import java.util.List;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineDispatcher;

@Keep
/* compiled from: FirebaseSessionsRegistrar.kt */
public final class FirebaseSessionsRegistrar implements ComponentRegistrar {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String LIBRARY_NAME = "fire-sessions";
    private static final Qualified<CoroutineDispatcher> backgroundDispatcher;
    private static final Qualified<CoroutineDispatcher> blockingDispatcher;
    private static final Qualified<FirebaseApp> firebaseApp;
    private static final Qualified<FirebaseInstallationsApi> firebaseInstallationsApi;
    private static final Qualified<SessionLifecycleServiceBinder> sessionLifecycleServiceBinder;
    private static final Qualified<SessionsSettings> sessionsSettings;
    private static final Qualified<TransportFactory> transportFactory;

    /* compiled from: FirebaseSessionsRegistrar.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Qualified<FirebaseApp> unqualified = Qualified.unqualified(FirebaseApp.class);
        C1177ig.e(unqualified, "unqualified(FirebaseApp::class.java)");
        firebaseApp = unqualified;
        Qualified<FirebaseInstallationsApi> unqualified2 = Qualified.unqualified(FirebaseInstallationsApi.class);
        C1177ig.e(unqualified2, "unqualified(FirebaseInstallationsApi::class.java)");
        firebaseInstallationsApi = unqualified2;
        Class<CoroutineDispatcher> cls = CoroutineDispatcher.class;
        Qualified<CoroutineDispatcher> qualified = Qualified.qualified(Background.class, cls);
        C1177ig.e(qualified, "qualified(Background::cl…neDispatcher::class.java)");
        backgroundDispatcher = qualified;
        Qualified<CoroutineDispatcher> qualified2 = Qualified.qualified(Blocking.class, cls);
        C1177ig.e(qualified2, "qualified(Blocking::clas…neDispatcher::class.java)");
        blockingDispatcher = qualified2;
        Qualified<TransportFactory> unqualified3 = Qualified.unqualified(TransportFactory.class);
        C1177ig.e(unqualified3, "unqualified(TransportFactory::class.java)");
        transportFactory = unqualified3;
        Qualified<SessionsSettings> unqualified4 = Qualified.unqualified(SessionsSettings.class);
        C1177ig.e(unqualified4, "unqualified(SessionsSettings::class.java)");
        sessionsSettings = unqualified4;
        Qualified<SessionLifecycleServiceBinder> unqualified5 = Qualified.unqualified(SessionLifecycleServiceBinder.class);
        C1177ig.e(unqualified5, "unqualified(SessionLifec…erviceBinder::class.java)");
        sessionLifecycleServiceBinder = unqualified5;
    }

    /* access modifiers changed from: private */
    public static final FirebaseSessions getComponents$lambda$0(ComponentContainer componentContainer) {
        Object obj = componentContainer.get(firebaseApp);
        C1177ig.e(obj, "container[firebaseApp]");
        Object obj2 = componentContainer.get(sessionsSettings);
        C1177ig.e(obj2, "container[sessionsSettings]");
        Object obj3 = componentContainer.get(backgroundDispatcher);
        C1177ig.e(obj3, "container[backgroundDispatcher]");
        Object obj4 = componentContainer.get(sessionLifecycleServiceBinder);
        C1177ig.e(obj4, "container[sessionLifecycleServiceBinder]");
        return new FirebaseSessions((FirebaseApp) obj, (SessionsSettings) obj2, (CoroutineContext) obj3, (SessionLifecycleServiceBinder) obj4);
    }

    /* access modifiers changed from: private */
    public static final SessionGenerator getComponents$lambda$1(ComponentContainer componentContainer) {
        return new SessionGenerator(WallClock.INSTANCE, (Function0) null, 2, (DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: private */
    public static final SessionFirelogPublisher getComponents$lambda$2(ComponentContainer componentContainer) {
        Object obj = componentContainer.get(firebaseApp);
        C1177ig.e(obj, "container[firebaseApp]");
        Object obj2 = componentContainer.get(firebaseInstallationsApi);
        C1177ig.e(obj2, "container[firebaseInstallationsApi]");
        Object obj3 = componentContainer.get(sessionsSettings);
        C1177ig.e(obj3, "container[sessionsSettings]");
        Provider<TransportFactory> provider = componentContainer.getProvider(transportFactory);
        C1177ig.e(provider, "container.getProvider(transportFactory)");
        EventGDTLogger eventGDTLogger = new EventGDTLogger(provider);
        Object obj4 = componentContainer.get(backgroundDispatcher);
        C1177ig.e(obj4, "container[backgroundDispatcher]");
        return new SessionFirelogPublisherImpl((FirebaseApp) obj, (FirebaseInstallationsApi) obj2, (SessionsSettings) obj3, eventGDTLogger, (CoroutineContext) obj4);
    }

    /* access modifiers changed from: private */
    public static final SessionsSettings getComponents$lambda$3(ComponentContainer componentContainer) {
        Object obj = componentContainer.get(firebaseApp);
        C1177ig.e(obj, "container[firebaseApp]");
        Object obj2 = componentContainer.get(blockingDispatcher);
        C1177ig.e(obj2, "container[blockingDispatcher]");
        Object obj3 = componentContainer.get(backgroundDispatcher);
        C1177ig.e(obj3, "container[backgroundDispatcher]");
        Object obj4 = componentContainer.get(firebaseInstallationsApi);
        C1177ig.e(obj4, "container[firebaseInstallationsApi]");
        return new SessionsSettings((FirebaseApp) obj, (CoroutineContext) obj2, (CoroutineContext) obj3, (FirebaseInstallationsApi) obj4);
    }

    /* access modifiers changed from: private */
    public static final SessionDatastore getComponents$lambda$4(ComponentContainer componentContainer) {
        Context applicationContext = ((FirebaseApp) componentContainer.get(firebaseApp)).getApplicationContext();
        C1177ig.e(applicationContext, "container[firebaseApp].applicationContext");
        Object obj = componentContainer.get(backgroundDispatcher);
        C1177ig.e(obj, "container[backgroundDispatcher]");
        return new SessionDatastoreImpl(applicationContext, (CoroutineContext) obj);
    }

    /* access modifiers changed from: private */
    public static final SessionLifecycleServiceBinder getComponents$lambda$5(ComponentContainer componentContainer) {
        Object obj = componentContainer.get(firebaseApp);
        C1177ig.e(obj, "container[firebaseApp]");
        return new SessionLifecycleServiceBinderImpl((FirebaseApp) obj);
    }

    public List<Component<? extends Object>> getComponents() {
        Component.Builder<FirebaseSessions> name = Component.builder(FirebaseSessions.class).name(LIBRARY_NAME);
        Qualified<FirebaseApp> qualified = firebaseApp;
        Component.Builder<FirebaseSessions> add = name.add(Dependency.required((Qualified<?>) qualified));
        Qualified<SessionsSettings> qualified2 = sessionsSettings;
        Component.Builder<FirebaseSessions> add2 = add.add(Dependency.required((Qualified<?>) qualified2));
        Qualified<CoroutineDispatcher> qualified3 = backgroundDispatcher;
        Component.Builder<SessionFirelogPublisher> add3 = Component.builder(SessionFirelogPublisher.class).name("session-publisher").add(Dependency.required((Qualified<?>) qualified));
        Qualified<FirebaseInstallationsApi> qualified4 = firebaseInstallationsApi;
        return r1.F(add2.add(Dependency.required((Qualified<?>) qualified3)).add(Dependency.required((Qualified<?>) sessionLifecycleServiceBinder)).factory(new C0333t(3)).eagerInDefaultApp().build(), Component.builder(SessionGenerator.class).name("session-generator").factory(new C0363vb(3)).build(), add3.add(Dependency.required((Qualified<?>) qualified4)).add(Dependency.required((Qualified<?>) qualified2)).add(Dependency.requiredProvider((Qualified<?>) transportFactory)).add(Dependency.required((Qualified<?>) qualified3)).factory(new C0377wb(2)).build(), Component.builder(SessionsSettings.class).name("sessions-settings").add(Dependency.required((Qualified<?>) qualified)).add(Dependency.required((Qualified<?>) blockingDispatcher)).add(Dependency.required((Qualified<?>) qualified3)).add(Dependency.required((Qualified<?>) qualified4)).factory(new C0081Ac()).build(), Component.builder(SessionDatastore.class).name("sessions-datastore").add(Dependency.required((Qualified<?>) qualified)).add(Dependency.required((Qualified<?>) qualified3)).factory(new C0333t(4)).build(), Component.builder(SessionLifecycleServiceBinder.class).name("sessions-service-binder").add(Dependency.required((Qualified<?>) qualified)).factory(new C0363vb(4)).build(), LibraryVersionComponent.create(LIBRARY_NAME, BuildConfig.VERSION_NAME));
    }
}
