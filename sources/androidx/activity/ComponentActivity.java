package androidx.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.os.Trace;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.view.MenuHostHelper;
import androidx.core.view.MenuProvider;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.SavedStateHandleAttacher;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.j;
import androidx.lifecycle.l;
import androidx.lifecycle.m;
import androidx.lifecycle.o;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;

public class ComponentActivity extends androidx.core.app.ComponentActivity implements AC, androidx.lifecycle.c, Xu, Kn, V {
    private static final String ACTIVITY_RESULT_TAG = "android:support:activity-result";
    private final ActivityResultRegistry mActivityResultRegistry;
    private int mContentLayoutId;
    final c7 mContextAwareHelper;
    private ViewModelProvider.Factory mDefaultFactory;
    private boolean mDispatchingOnMultiWindowModeChanged;
    private boolean mDispatchingOnPictureInPictureModeChanged;
    final C0089Ed mFullyDrawnReporter;
    private final LifecycleRegistry mLifecycleRegistry;
    private final MenuHostHelper mMenuHostHelper;
    private final AtomicInteger mNextLocalRequestCode;
    /* access modifiers changed from: private */
    public OnBackPressedDispatcher mOnBackPressedDispatcher;
    private final CopyOnWriteArrayList<U6<Configuration>> mOnConfigurationChangedListeners;
    private final CopyOnWriteArrayList<U6<C1354qp>> mOnMultiWindowModeChangedListeners;
    private final CopyOnWriteArrayList<U6<Intent>> mOnNewIntentListeners;
    private final CopyOnWriteArrayList<U6<C0412yp>> mOnPictureInPictureModeChangedListeners;
    private final CopyOnWriteArrayList<U6<Integer>> mOnTrimMemoryListeners;
    final e mReportFullyDrawnExecutor;
    final SavedStateRegistryController mSavedStateRegistryController;
    private ViewModelStore mViewModelStore;

    public class a extends ActivityResultRegistry {
        public a() {
        }

        public final void b(int i, ActivityResultContract activityResultContract, Object obj) {
            Bundle bundle;
            ComponentActivity componentActivity = ComponentActivity.this;
            ActivityResultContract.a b = activityResultContract.b(componentActivity, obj);
            if (b != null) {
                new Handler(Looper.getMainLooper()).post(new a(this, i, b));
                return;
            }
            Intent a2 = activityResultContract.a(componentActivity, obj);
            if (a2.getExtras() != null && a2.getExtras().getClassLoader() == null) {
                a2.setExtrasClassLoader(componentActivity.getClassLoader());
            }
            if (a2.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
                Bundle bundleExtra = a2.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                a2.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                bundle = bundleExtra;
            } else {
                bundle = null;
            }
            if ("androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(a2.getAction())) {
                String[] stringArrayExtra = a2.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
                if (stringArrayExtra == null) {
                    stringArrayExtra = new String[0];
                }
                J.e(componentActivity, stringArrayExtra, i);
            } else if ("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(a2.getAction())) {
                IntentSenderRequest intentSenderRequest = (IntentSenderRequest) a2.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
                try {
                    IntentSender intentSender = intentSenderRequest.f830a;
                    Intent intent = intentSenderRequest.a;
                    int i2 = intentSenderRequest.c;
                    int i3 = intentSenderRequest.d;
                    int i4 = J.a;
                    componentActivity.startIntentSenderForResult(intentSender, i, intent, i2, i3, 0, bundle);
                } catch (IntentSender.SendIntentException e) {
                    new Handler(Looper.getMainLooper()).post(new b(this, i, e));
                }
            } else {
                int i5 = J.a;
                componentActivity.startActivityForResult(a2, i, bundle);
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public final void run() {
            try {
                ComponentActivity.super.onBackPressed();
            } catch (IllegalStateException e) {
                if (!TextUtils.equals(e.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                    throw e;
                }
            } catch (NullPointerException e2) {
                if (!TextUtils.equals(e2.getMessage(), "Attempt to invoke virtual method 'android.os.Handler android.app.FragmentHostCallback.getHandler()' on a null object reference")) {
                    throw e2;
                }
            }
        }
    }

    public static class c {
        public static OnBackInvokedDispatcher a(Activity activity) {
            return activity.getOnBackInvokedDispatcher();
        }
    }

    public static final class d {
        public ViewModelStore a;

        /* renamed from: a  reason: collision with other field name */
        public Object f806a;
    }

    public interface e extends Executor {
        void i0(View view);
    }

    public class f implements e, ViewTreeObserver.OnDrawListener, Runnable {
        public final long a = (SystemClock.uptimeMillis() + 10000);

        /* renamed from: a  reason: collision with other field name */
        public Runnable f808a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f809a = false;

        public f() {
        }

        public final void execute(Runnable runnable) {
            this.f808a = runnable;
            View decorView = ComponentActivity.this.getWindow().getDecorView();
            if (!this.f809a) {
                decorView.postOnAnimation(new C0140b6(this, 1));
            } else if (Looper.myLooper() == Looper.getMainLooper()) {
                decorView.invalidate();
            } else {
                decorView.postInvalidate();
            }
        }

        public final void i0(View view) {
            if (!this.f809a) {
                this.f809a = true;
                view.getViewTreeObserver().addOnDrawListener(this);
            }
        }

        public final void onDraw() {
            boolean z;
            Runnable runnable = this.f808a;
            if (runnable != null) {
                runnable.run();
                this.f808a = null;
                C0089Ed ed = ComponentActivity.this.mFullyDrawnReporter;
                synchronized (ed.a) {
                    z = ed.f137a;
                }
                if (z) {
                    this.f809a = false;
                    ComponentActivity.this.getWindow().getDecorView().post(this);
                }
            } else if (SystemClock.uptimeMillis() > this.a) {
                this.f809a = false;
                ComponentActivity.this.getWindow().getDecorView().post(this);
            }
        }

        public final void run() {
            ComponentActivity.this.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
        }
    }

    public ComponentActivity() {
        this.mContextAwareHelper = new c7();
        boolean z = false;
        this.mMenuHostHelper = new MenuHostHelper(new C0140b6(this, 0));
        this.mLifecycleRegistry = new LifecycleRegistry(this);
        SavedStateRegistryController savedStateRegistryController = new SavedStateRegistryController(this);
        this.mSavedStateRegistryController = savedStateRegistryController;
        this.mOnBackPressedDispatcher = null;
        e createFullyDrawnExecutor = createFullyDrawnExecutor();
        this.mReportFullyDrawnExecutor = createFullyDrawnExecutor;
        this.mFullyDrawnReporter = new C0089Ed(createFullyDrawnExecutor, new C0153c6(this));
        this.mNextLocalRequestCode = new AtomicInteger();
        this.mActivityResultRegistry = new a();
        this.mOnConfigurationChangedListeners = new CopyOnWriteArrayList<>();
        this.mOnTrimMemoryListeners = new CopyOnWriteArrayList<>();
        this.mOnNewIntentListeners = new CopyOnWriteArrayList<>();
        this.mOnMultiWindowModeChangedListeners = new CopyOnWriteArrayList<>();
        this.mOnPictureInPictureModeChangedListeners = new CopyOnWriteArrayList<>();
        this.mDispatchingOnMultiWindowModeChanged = false;
        this.mDispatchingOnPictureInPictureModeChanged = false;
        if (getLifecycle() != null) {
            getLifecycle().a(new androidx.lifecycle.f() {
                public final void b(LifecycleOwner lifecycleOwner, Lifecycle.a aVar) {
                    View view;
                    if (aVar == Lifecycle.a.ON_STOP) {
                        Window window = ComponentActivity.this.getWindow();
                        if (window != null) {
                            view = window.peekDecorView();
                        } else {
                            view = null;
                        }
                        if (view != null) {
                            view.cancelPendingInputEvents();
                        }
                    }
                }
            });
            getLifecycle().a(new androidx.lifecycle.f() {
                public final void b(LifecycleOwner lifecycleOwner, Lifecycle.a aVar) {
                    if (aVar == Lifecycle.a.ON_DESTROY) {
                        ComponentActivity.this.mContextAwareHelper.a = null;
                        if (!ComponentActivity.this.isChangingConfigurations()) {
                            ComponentActivity.this.getViewModelStore().a();
                        }
                        f fVar = (f) ComponentActivity.this.mReportFullyDrawnExecutor;
                        ComponentActivity componentActivity = ComponentActivity.this;
                        componentActivity.getWindow().getDecorView().removeCallbacks(fVar);
                        componentActivity.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(fVar);
                    }
                }
            });
            getLifecycle().a(new androidx.lifecycle.f() {
                public final void b(LifecycleOwner lifecycleOwner, Lifecycle.a aVar) {
                    ComponentActivity componentActivity = ComponentActivity.this;
                    componentActivity.ensureViewModelStore();
                    componentActivity.getLifecycle().c(this);
                }
            });
            savedStateRegistryController.a();
            Lifecycle.State b2 = getLifecycle().b();
            if ((b2 == Lifecycle.State.INITIALIZED || b2 == Lifecycle.State.CREATED) ? true : z) {
                if (getSavedStateRegistry().b() == null) {
                    Uu uu = new Uu(getSavedStateRegistry(), this);
                    getSavedStateRegistry().c("androidx.lifecycle.internal.SavedStateHandlesProvider", uu);
                    getLifecycle().a(new SavedStateHandleAttacher(uu));
                }
                getSavedStateRegistry().c(ACTIVITY_RESULT_TAG, new C0164d6(this));
                addOnContextAvailableListener(new C0174e6(this));
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
    }

    private e createFullyDrawnExecutor() {
        return new f();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit lambda$new$0() {
        reportFullyDrawn();
        return null;
    }

    /* access modifiers changed from: private */
    public Bundle lambda$new$1() {
        Bundle bundle = new Bundle();
        ActivityResultRegistry activityResultRegistry = this.mActivityResultRegistry;
        activityResultRegistry.getClass();
        HashMap hashMap = activityResultRegistry.b;
        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList(hashMap.values()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList(hashMap.keySet()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList(activityResultRegistry.f824a));
        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle) activityResultRegistry.a.clone());
        return bundle;
    }

    /* access modifiers changed from: private */
    public void lambda$new$2(Context context) {
        Bundle a2 = getSavedStateRegistry().a(ACTIVITY_RESULT_TAG);
        if (a2 != null) {
            ActivityResultRegistry activityResultRegistry = this.mActivityResultRegistry;
            activityResultRegistry.getClass();
            ArrayList<Integer> integerArrayList = a2.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
            ArrayList<String> stringArrayList = a2.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
            if (stringArrayList != null && integerArrayList != null) {
                activityResultRegistry.f824a = a2.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
                Bundle bundle = a2.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT");
                Bundle bundle2 = activityResultRegistry.a;
                bundle2.putAll(bundle);
                for (int i = 0; i < stringArrayList.size(); i++) {
                    String str = stringArrayList.get(i);
                    HashMap hashMap = activityResultRegistry.b;
                    boolean containsKey = hashMap.containsKey(str);
                    HashMap hashMap2 = activityResultRegistry.f825a;
                    if (containsKey) {
                        Integer num = (Integer) hashMap.remove(str);
                        if (!bundle2.containsKey(str)) {
                            hashMap2.remove(num);
                        }
                    }
                    int intValue = integerArrayList.get(i).intValue();
                    String str2 = stringArrayList.get(i);
                    hashMap2.put(Integer.valueOf(intValue), str2);
                    hashMap.put(str2, Integer.valueOf(intValue));
                }
            }
        }
    }

    public void addContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams layoutParams) {
        initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.i0(getWindow().getDecorView());
        super.addContentView(view, layoutParams);
    }

    public void addMenuProvider(MenuProvider menuProvider) {
        MenuHostHelper menuHostHelper = this.mMenuHostHelper;
        menuHostHelper.f1797a.add(menuProvider);
        menuHostHelper.a.run();
    }

    public final void addOnConfigurationChangedListener(U6<Configuration> u6) {
        this.mOnConfigurationChangedListeners.add(u6);
    }

    public final void addOnContextAvailableListener(On on) {
        c7 c7Var = this.mContextAwareHelper;
        c7Var.getClass();
        C1177ig.f(on, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Context context = c7Var.a;
        if (context != null) {
            on.a(context);
        }
        c7Var.f2752a.add(on);
    }

    public final void addOnMultiWindowModeChangedListener(U6<C1354qp> u6) {
        this.mOnMultiWindowModeChangedListeners.add(u6);
    }

    public final void addOnNewIntentListener(U6<Intent> u6) {
        this.mOnNewIntentListeners.add(u6);
    }

    public final void addOnPictureInPictureModeChangedListener(U6<C0412yp> u6) {
        this.mOnPictureInPictureModeChangedListeners.add(u6);
    }

    public final void addOnTrimMemoryListener(U6<Integer> u6) {
        this.mOnTrimMemoryListeners.add(u6);
    }

    public void ensureViewModelStore() {
        if (this.mViewModelStore == null) {
            d dVar = (d) getLastNonConfigurationInstance();
            if (dVar != null) {
                this.mViewModelStore = dVar.a;
            }
            if (this.mViewModelStore == null) {
                this.mViewModelStore = new ViewModelStore();
            }
        }
    }

    public final ActivityResultRegistry getActivityResultRegistry() {
        return this.mActivityResultRegistry;
    }

    public CreationExtras getDefaultViewModelCreationExtras() {
        androidx.lifecycle.viewmodel.a aVar = new androidx.lifecycle.viewmodel.a();
        Application application = getApplication();
        LinkedHashMap linkedHashMap = aVar.a;
        if (application != null) {
            linkedHashMap.put(o.a, getApplication());
        }
        linkedHashMap.put(l.f2210a, this);
        linkedHashMap.put(l.f2211a, this);
        if (!(getIntent() == null || getIntent().getExtras() == null)) {
            linkedHashMap.put(l.a, getIntent().getExtras());
        }
        return aVar;
    }

    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        Bundle bundle;
        if (this.mDefaultFactory == null) {
            Application application = getApplication();
            if (getIntent() != null) {
                bundle = getIntent().getExtras();
            } else {
                bundle = null;
            }
            this.mDefaultFactory = new m(application, this, bundle);
        }
        return this.mDefaultFactory;
    }

    public C0089Ed getFullyDrawnReporter() {
        return this.mFullyDrawnReporter;
    }

    @Deprecated
    public Object getLastCustomNonConfigurationInstance() {
        d dVar = (d) getLastNonConfigurationInstance();
        if (dVar != null) {
            return dVar.f806a;
        }
        return null;
    }

    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        if (this.mOnBackPressedDispatcher == null) {
            this.mOnBackPressedDispatcher = new OnBackPressedDispatcher(new b());
            getLifecycle().a(new androidx.lifecycle.f() {
                public final void b(LifecycleOwner lifecycleOwner, Lifecycle.a aVar) {
                    if (aVar == Lifecycle.a.ON_CREATE && Build.VERSION.SDK_INT >= 33) {
                        OnBackPressedDispatcher access$100 = ComponentActivity.this.mOnBackPressedDispatcher;
                        OnBackInvokedDispatcher a2 = c.a((ComponentActivity) lifecycleOwner);
                        access$100.getClass();
                        C1177ig.f(a2, "invoker");
                        access$100.f813a = a2;
                        access$100.d(access$100.b);
                    }
                }
            });
        }
        return this.mOnBackPressedDispatcher;
    }

    public final SavedStateRegistry getSavedStateRegistry() {
        return this.mSavedStateRegistryController.f2413a;
    }

    public ViewModelStore getViewModelStore() {
        if (getApplication() != null) {
            ensureViewModelStore();
            return this.mViewModelStore;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    public void initializeViewTreeOwners() {
        r1.N(getWindow().getDecorView(), this);
        View decorView = getWindow().getDecorView();
        C1177ig.f(decorView, "<this>");
        decorView.setTag(Nr.view_tree_view_model_store_owner, this);
        C1354qp.x0(getWindow().getDecorView(), this);
        View decorView2 = getWindow().getDecorView();
        C1177ig.f(decorView2, "<this>");
        decorView2.setTag(Pr.view_tree_on_back_pressed_dispatcher_owner, this);
        View decorView3 = getWindow().getDecorView();
        C1177ig.f(decorView3, "<this>");
        decorView3.setTag(Pr.report_drawn, this);
    }

    public void invalidateMenu() {
        invalidateOptionsMenu();
    }

    @Deprecated
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!this.mActivityResultRegistry.a(i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
        }
    }

    @Deprecated
    public void onBackPressed() {
        getOnBackPressedDispatcher().c();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Iterator<U6<Configuration>> it = this.mOnConfigurationChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(configuration);
        }
    }

    public void onCreate(Bundle bundle) {
        this.mSavedStateRegistryController.b(bundle);
        c7 c7Var = this.mContextAwareHelper;
        c7Var.getClass();
        c7Var.a = this;
        Iterator it = c7Var.f2752a.iterator();
        while (it.hasNext()) {
            ((On) it.next()).a(this);
        }
        super.onCreate(bundle);
        int i = j.c;
        j.b.b(this);
        int i2 = this.mContentLayoutId;
        if (i2 != 0) {
            setContentView(i2);
        }
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i != 0) {
            return true;
        }
        super.onCreatePanelMenu(i, menu);
        MenuHostHelper menuHostHelper = this.mMenuHostHelper;
        getMenuInflater();
        Iterator<MenuProvider> it = menuHostHelper.f1797a.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        return true;
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        if (i != 0) {
            return false;
        }
        Iterator<MenuProvider> it = this.mMenuHostHelper.f1797a.iterator();
        while (it.hasNext()) {
            if (it.next().b()) {
                return true;
            }
        }
        return false;
    }

    public void onMultiWindowModeChanged(boolean z) {
        if (!this.mDispatchingOnMultiWindowModeChanged) {
            Iterator<U6<C1354qp>> it = this.mOnMultiWindowModeChangedListeners.iterator();
            while (it.hasNext()) {
                it.next().accept(new C1354qp());
            }
        }
    }

    public void onNewIntent(@SuppressLint({"UnknownNullness", "MissingNullability"}) Intent intent) {
        super.onNewIntent(intent);
        Iterator<U6<Intent>> it = this.mOnNewIntentListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(intent);
        }
    }

    public void onPanelClosed(int i, Menu menu) {
        Iterator<MenuProvider> it = this.mMenuHostHelper.f1797a.iterator();
        while (it.hasNext()) {
            it.next().getClass();
        }
        super.onPanelClosed(i, menu);
    }

    public void onPictureInPictureModeChanged(boolean z) {
        if (!this.mDispatchingOnPictureInPictureModeChanged) {
            Iterator<U6<C0412yp>> it = this.mOnPictureInPictureModeChangedListeners.iterator();
            while (it.hasNext()) {
                it.next().accept(new C0412yp());
            }
        }
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        if (i != 0) {
            return true;
        }
        super.onPreparePanel(i, view, menu);
        Iterator<MenuProvider> it = this.mMenuHostHelper.f1797a.iterator();
        while (it.hasNext()) {
            it.next().getClass();
        }
        return true;
    }

    @Deprecated
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (!this.mActivityResultRegistry.a(i, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr))) {
            super.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    @Deprecated
    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    public final Object onRetainNonConfigurationInstance() {
        d dVar;
        Object onRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        ViewModelStore viewModelStore = this.mViewModelStore;
        if (viewModelStore == null && (dVar = (d) getLastNonConfigurationInstance()) != null) {
            viewModelStore = dVar.a;
        }
        if (viewModelStore == null && onRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        d dVar2 = new d();
        dVar2.f806a = onRetainCustomNonConfigurationInstance;
        dVar2.a = viewModelStore;
        return dVar2;
    }

    public void onSaveInstanceState(Bundle bundle) {
        Lifecycle lifecycle = getLifecycle();
        if (lifecycle instanceof LifecycleRegistry) {
            ((LifecycleRegistry) lifecycle).h(Lifecycle.State.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.c(bundle);
    }

    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        Iterator<U6<Integer>> it = this.mOnTrimMemoryListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(Integer.valueOf(i));
        }
    }

    public Context peekAvailableContext() {
        return this.mContextAwareHelper.a;
    }

    public final <I, O> ActivityResultLauncher<I> registerForActivityResult(ActivityResultContract<I, O> activityResultContract, ActivityResultRegistry activityResultRegistry, ActivityResultCallback<O> activityResultCallback) {
        return activityResultRegistry.c("activity_rq#" + this.mNextLocalRequestCode.getAndIncrement(), this, activityResultContract, activityResultCallback);
    }

    public void removeMenuProvider(MenuProvider menuProvider) {
        this.mMenuHostHelper.c(menuProvider);
    }

    public final void removeOnConfigurationChangedListener(U6<Configuration> u6) {
        this.mOnConfigurationChangedListeners.remove(u6);
    }

    public final void removeOnContextAvailableListener(On on) {
        c7 c7Var = this.mContextAwareHelper;
        c7Var.getClass();
        C1177ig.f(on, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        c7Var.f2752a.remove(on);
    }

    public final void removeOnMultiWindowModeChangedListener(U6<C1354qp> u6) {
        this.mOnMultiWindowModeChangedListeners.remove(u6);
    }

    public final void removeOnNewIntentListener(U6<Intent> u6) {
        this.mOnNewIntentListeners.remove(u6);
    }

    public final void removeOnPictureInPictureModeChangedListener(U6<C0412yp> u6) {
        this.mOnPictureInPictureModeChangedListeners.remove(u6);
    }

    public final void removeOnTrimMemoryListener(U6<Integer> u6) {
        this.mOnTrimMemoryListeners.remove(u6);
    }

    public void reportFullyDrawn() {
        try {
            if (C0323sA.a()) {
                Trace.beginSection("reportFullyDrawn() for ComponentActivity");
            }
            super.reportFullyDrawn();
            this.mFullyDrawnReporter.a();
            Trace.endSection();
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    public void setContentView(int i) {
        initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.i0(getWindow().getDecorView());
        super.setContentView(i);
    }

    @Deprecated
    public void startActivityForResult(Intent intent, int i) {
        super.startActivityForResult(intent, i);
    }

    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    @Deprecated
    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        super.startActivityForResult(intent, i, bundle);
    }

    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }

    /* JADX INFO: finally extract failed */
    public void onMultiWindowModeChanged(boolean z, Configuration configuration) {
        this.mDispatchingOnMultiWindowModeChanged = true;
        try {
            super.onMultiWindowModeChanged(z, configuration);
            this.mDispatchingOnMultiWindowModeChanged = false;
            Iterator<U6<C1354qp>> it = this.mOnMultiWindowModeChangedListeners.iterator();
            while (it.hasNext()) {
                it.next().accept(new C1354qp(configuration));
            }
        } catch (Throwable th) {
            this.mDispatchingOnMultiWindowModeChanged = false;
            throw th;
        }
    }

    /* JADX INFO: finally extract failed */
    public void onPictureInPictureModeChanged(boolean z, Configuration configuration) {
        this.mDispatchingOnPictureInPictureModeChanged = true;
        try {
            super.onPictureInPictureModeChanged(z, configuration);
            this.mDispatchingOnPictureInPictureModeChanged = false;
            Iterator<U6<C0412yp>> it = this.mOnPictureInPictureModeChangedListeners.iterator();
            while (it.hasNext()) {
                it.next().accept(new C0412yp(configuration));
            }
        } catch (Throwable th) {
            this.mDispatchingOnPictureInPictureModeChanged = false;
            throw th;
        }
    }

    public final <I, O> ActivityResultLauncher<I> registerForActivityResult(ActivityResultContract<I, O> activityResultContract, ActivityResultCallback<O> activityResultCallback) {
        return registerForActivityResult(activityResultContract, this.mActivityResultRegistry, activityResultCallback);
    }

    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view) {
        initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.i0(getWindow().getDecorView());
        super.setContentView(view);
    }

    public void addMenuProvider(MenuProvider menuProvider, LifecycleOwner lifecycleOwner) {
        this.mMenuHostHelper.a(menuProvider, lifecycleOwner);
    }

    @SuppressLint({"LambdaLast"})
    public void addMenuProvider(MenuProvider menuProvider, LifecycleOwner lifecycleOwner, Lifecycle.State state) {
        this.mMenuHostHelper.b(menuProvider, lifecycleOwner, state);
    }

    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams layoutParams) {
        initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.i0(getWindow().getDecorView());
        super.setContentView(view, layoutParams);
    }

    public ComponentActivity(int i) {
        this();
        this.mContentLayoutId = i;
    }
}
