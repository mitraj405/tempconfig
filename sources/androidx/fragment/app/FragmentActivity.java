package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.core.app.SharedElementCallback;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModelStore;
import androidx.loader.app.LoaderManager;
import androidx.savedstate.SavedStateRegistry;
import defpackage.J;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class FragmentActivity extends ComponentActivity implements J.e {
    static final String FRAGMENTS_TAG = "android:support:fragments";
    boolean mCreated;
    final LifecycleRegistry mFragmentLifecycleRegistry = new LifecycleRegistry(this);
    final C0289od mFragments = new C0289od(new c());
    boolean mResumed;
    boolean mStopped = true;

    public class a implements SavedStateRegistry.b {
        public a() {
        }

        public final Bundle a() {
            Bundle bundle = new Bundle();
            FragmentActivity fragmentActivity = FragmentActivity.this;
            fragmentActivity.markFragmentsCreated();
            fragmentActivity.mFragmentLifecycleRegistry.f(Lifecycle.a.ON_STOP);
            Parcelable X = fragmentActivity.mFragments.a.f2068a.X();
            if (X != null) {
                bundle.putParcelable(FragmentActivity.FRAGMENTS_TAG, X);
            }
            return bundle;
        }
    }

    public class b implements On {
        public b() {
        }

        public final void a(Context context) {
            FragmentActivity fragmentActivity = FragmentActivity.this;
            FragmentHostCallback<?> fragmentHostCallback = fragmentActivity.mFragments.a;
            fragmentHostCallback.f2068a.b(fragmentHostCallback, fragmentHostCallback, (Fragment) null);
            Bundle a2 = fragmentActivity.getSavedStateRegistry().a(FragmentActivity.FRAGMENTS_TAG);
            if (a2 != null) {
                Parcelable parcelable = a2.getParcelable(FragmentActivity.FRAGMENTS_TAG);
                FragmentHostCallback<?> fragmentHostCallback2 = fragmentActivity.mFragments.a;
                if (fragmentHostCallback2 instanceof AC) {
                    fragmentHostCallback2.f2068a.W(parcelable);
                    return;
                }
                throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
            }
        }
    }

    public class c extends FragmentHostCallback<FragmentActivity> implements AC, Kn, V, C0305qd {
        public c() {
            super(FragmentActivity.this);
        }

        public final void a(Fragment fragment) {
            FragmentActivity.this.onAttachFragment(fragment);
        }

        public final View b(int i) {
            return FragmentActivity.this.findViewById(i);
        }

        public final boolean c() {
            Window window = FragmentActivity.this.getWindow();
            if (window == null || window.peekDecorView() == null) {
                return false;
            }
            return true;
        }

        public final FragmentActivity e() {
            return FragmentActivity.this;
        }

        public final LayoutInflater f() {
            FragmentActivity fragmentActivity = FragmentActivity.this;
            return fragmentActivity.getLayoutInflater().cloneInContext(fragmentActivity);
        }

        public final boolean g(String str) {
            return J.f(FragmentActivity.this, str);
        }

        public final ActivityResultRegistry getActivityResultRegistry() {
            return FragmentActivity.this.getActivityResultRegistry();
        }

        public final Lifecycle getLifecycle() {
            return FragmentActivity.this.mFragmentLifecycleRegistry;
        }

        public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
            return FragmentActivity.this.getOnBackPressedDispatcher();
        }

        public final ViewModelStore getViewModelStore() {
            return FragmentActivity.this.getViewModelStore();
        }

        public final void h() {
            FragmentActivity.this.supportInvalidateOptionsMenu();
        }
    }

    public FragmentActivity() {
        init();
    }

    private void init() {
        getSavedStateRegistry().c(FRAGMENTS_TAG, new a());
        addOnContextAvailableListener(new b());
    }

    private static boolean markState(FragmentManager fragmentManager, Lifecycle.State state) {
        boolean z = false;
        for (Fragment next : fragmentManager.I()) {
            if (next != null) {
                if (next.getHost() != null) {
                    z |= markState(next.getChildFragmentManager(), state);
                }
                FragmentViewLifecycleOwner fragmentViewLifecycleOwner = next.mViewLifecycleOwner;
                Lifecycle.State state2 = Lifecycle.State.STARTED;
                if (fragmentViewLifecycleOwner != null) {
                    fragmentViewLifecycleOwner.b();
                    if (fragmentViewLifecycleOwner.f2128a.f2181a.a(state2)) {
                        next.mViewLifecycleOwner.f2128a.h(state);
                        z = true;
                    }
                }
                if (next.mLifecycleRegistry.f2181a.a(state2)) {
                    next.mLifecycleRegistry.h(state);
                    z = true;
                }
            }
        }
        return z;
    }

    public final View dispatchFragmentsOnCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.mFragments.a.f2068a.f2078a.onCreateView(view, str, context, attributeSet);
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.mCreated);
        printWriter.print(" mResumed=");
        printWriter.print(this.mResumed);
        printWriter.print(" mStopped=");
        printWriter.print(this.mStopped);
        if (getApplication() != null) {
            LoaderManager.a(this).b(str2, printWriter);
        }
        this.mFragments.a.f2068a.t(str, fileDescriptor, printWriter, strArr);
    }

    public FragmentManager getSupportFragmentManager() {
        return this.mFragments.a.f2068a;
    }

    @Deprecated
    public LoaderManager getSupportLoaderManager() {
        return LoaderManager.a(this);
    }

    public void markFragmentsCreated() {
        do {
        } while (markState(getSupportFragmentManager(), Lifecycle.State.CREATED));
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        this.mFragments.a();
        super.onActivityResult(i, i2, intent);
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.mFragments.a();
        super.onConfigurationChanged(configuration);
        this.mFragments.a.f2068a.h(configuration);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mFragmentLifecycleRegistry.f(Lifecycle.a.ON_CREATE);
        C0297pd pdVar = this.mFragments.a.f2068a;
        pdVar.f2094c = false;
        pdVar.f2095d = false;
        pdVar.f2080a.f2157d = false;
        pdVar.s(1);
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i != 0) {
            return super.onCreatePanelMenu(i, menu);
        }
        boolean onCreatePanelMenu = super.onCreatePanelMenu(i, menu);
        C0289od odVar = this.mFragments;
        return onCreatePanelMenu | odVar.a.f2068a.j(menu, getMenuInflater());
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(view, str, context, attributeSet);
        return dispatchFragmentsOnCreateView == null ? super.onCreateView(view, str, context, attributeSet) : dispatchFragmentsOnCreateView;
    }

    public void onDestroy() {
        super.onDestroy();
        this.mFragments.a.f2068a.k();
        this.mFragmentLifecycleRegistry.f(Lifecycle.a.ON_DESTROY);
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.mFragments.a.f2068a.l();
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        if (i == 0) {
            return this.mFragments.a.f2068a.n(menuItem);
        }
        if (i != 6) {
            return false;
        }
        return this.mFragments.a.f2068a.i(menuItem);
    }

    public void onMultiWindowModeChanged(boolean z) {
        this.mFragments.a.f2068a.m(z);
    }

    public void onNewIntent(@SuppressLint({"UnknownNullness"}) Intent intent) {
        this.mFragments.a();
        super.onNewIntent(intent);
    }

    public void onPanelClosed(int i, Menu menu) {
        if (i == 0) {
            this.mFragments.a.f2068a.o(menu);
        }
        super.onPanelClosed(i, menu);
    }

    public void onPause() {
        super.onPause();
        this.mResumed = false;
        this.mFragments.a.f2068a.s(5);
        this.mFragmentLifecycleRegistry.f(Lifecycle.a.ON_PAUSE);
    }

    public void onPictureInPictureModeChanged(boolean z) {
        this.mFragments.a.f2068a.q(z);
    }

    public void onPostResume() {
        super.onPostResume();
        onResumeFragments();
    }

    @Deprecated
    public boolean onPrepareOptionsPanel(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        if (i == 0) {
            return onPrepareOptionsPanel(view, menu) | this.mFragments.a.f2068a.r(menu);
        }
        return super.onPreparePanel(i, view, menu);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.mFragments.a();
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    public void onResume() {
        this.mFragments.a();
        super.onResume();
        this.mResumed = true;
        this.mFragments.a.f2068a.w(true);
    }

    public void onResumeFragments() {
        this.mFragmentLifecycleRegistry.f(Lifecycle.a.ON_RESUME);
        C0297pd pdVar = this.mFragments.a.f2068a;
        pdVar.f2094c = false;
        pdVar.f2095d = false;
        pdVar.f2080a.f2157d = false;
        pdVar.s(7);
    }

    public void onStart() {
        this.mFragments.a();
        super.onStart();
        this.mStopped = false;
        if (!this.mCreated) {
            this.mCreated = true;
            C0297pd pdVar = this.mFragments.a.f2068a;
            pdVar.f2094c = false;
            pdVar.f2095d = false;
            pdVar.f2080a.f2157d = false;
            pdVar.s(4);
        }
        this.mFragments.a.f2068a.w(true);
        this.mFragmentLifecycleRegistry.f(Lifecycle.a.ON_START);
        C0297pd pdVar2 = this.mFragments.a.f2068a;
        pdVar2.f2094c = false;
        pdVar2.f2095d = false;
        pdVar2.f2080a.f2157d = false;
        pdVar2.s(5);
    }

    public void onStateNotSaved() {
        this.mFragments.a();
    }

    public void onStop() {
        super.onStop();
        this.mStopped = true;
        markFragmentsCreated();
        C0297pd pdVar = this.mFragments.a.f2068a;
        pdVar.f2095d = true;
        pdVar.f2080a.f2157d = true;
        pdVar.s(4);
        this.mFragmentLifecycleRegistry.f(Lifecycle.a.ON_STOP);
    }

    public void setEnterSharedElementCallback(SharedElementCallback sharedElementCallback) {
        J.f fVar;
        int i = J.a;
        if (sharedElementCallback != null) {
            fVar = new J.f(sharedElementCallback);
        } else {
            fVar = null;
        }
        J.a.c(this, fVar);
    }

    public void setExitSharedElementCallback(SharedElementCallback sharedElementCallback) {
        J.f fVar;
        int i = J.a;
        if (sharedElementCallback != null) {
            fVar = new J.f(sharedElementCallback);
        } else {
            fVar = null;
        }
        J.a.d(this, fVar);
    }

    public void startActivityFromFragment(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i) {
        startActivityFromFragment(fragment, intent, i, (Bundle) null);
    }

    @Deprecated
    public void startIntentSenderFromFragment(Fragment fragment, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        if (i == -1) {
            int i5 = J.a;
            startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
            return;
        }
        fragment.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }

    public void supportFinishAfterTransition() {
        int i = J.a;
        J.a.a(this);
    }

    @Deprecated
    public void supportInvalidateOptionsMenu() {
        invalidateOptionsMenu();
    }

    public void supportPostponeEnterTransition() {
        int i = J.a;
        J.a.b(this);
    }

    public void supportStartPostponedEnterTransition() {
        int i = J.a;
        J.a.e(this);
    }

    public void startActivityFromFragment(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i, Bundle bundle) {
        if (i == -1) {
            int i2 = J.a;
            startActivityForResult(intent, -1, bundle);
            return;
        }
        fragment.startActivityForResult(intent, i, bundle);
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView((View) null, str, context, attributeSet);
        return dispatchFragmentsOnCreateView == null ? super.onCreateView(str, context, attributeSet) : dispatchFragmentsOnCreateView;
    }

    public FragmentActivity(int i) {
        super(i);
        init();
    }

    @Deprecated
    public void onAttachFragment(Fragment fragment) {
    }

    @Deprecated
    public final void validateRequestPermissionsRequestCode(int i) {
    }
}
