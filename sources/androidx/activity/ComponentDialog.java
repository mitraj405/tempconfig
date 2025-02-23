package androidx.activity;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import in.juspay.hyper.constants.LogCategory;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ComponentDialog.kt */
public class ComponentDialog extends Dialog implements LifecycleOwner, Kn, Xu {
    private LifecycleRegistry _lifecycleRegistry;
    private final OnBackPressedDispatcher onBackPressedDispatcher;
    private final SavedStateRegistryController savedStateRegistryController;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ComponentDialog(Context context) {
        this(context, 0, 2, (DefaultConstructorMarker) null);
        C1177ig.f(context, LogCategory.CONTEXT);
    }

    private final LifecycleRegistry getLifecycleRegistry() {
        LifecycleRegistry lifecycleRegistry = this._lifecycleRegistry;
        if (lifecycleRegistry != null) {
            return lifecycleRegistry;
        }
        LifecycleRegistry lifecycleRegistry2 = new LifecycleRegistry(this);
        this._lifecycleRegistry = lifecycleRegistry2;
        return lifecycleRegistry2;
    }

    /* access modifiers changed from: private */
    public static final void onBackPressedDispatcher$lambda$1(ComponentDialog componentDialog) {
        C1177ig.f(componentDialog, "this$0");
        super.onBackPressed();
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        C1177ig.f(view, "view");
        initializeViewTreeOwners();
        super.addContentView(view, layoutParams);
    }

    public Lifecycle getLifecycle() {
        return getLifecycleRegistry();
    }

    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.onBackPressedDispatcher;
    }

    public SavedStateRegistry getSavedStateRegistry() {
        return this.savedStateRegistryController.f2413a;
    }

    public void initializeViewTreeOwners() {
        Window window = getWindow();
        C1177ig.c(window);
        View decorView = window.getDecorView();
        C1177ig.e(decorView, "window!!.decorView");
        r1.N(decorView, this);
        Window window2 = getWindow();
        C1177ig.c(window2);
        View decorView2 = window2.getDecorView();
        C1177ig.e(decorView2, "window!!.decorView");
        decorView2.setTag(Pr.view_tree_on_back_pressed_dispatcher_owner, this);
        Window window3 = getWindow();
        C1177ig.c(window3);
        View decorView3 = window3.getDecorView();
        C1177ig.e(decorView3, "window!!.decorView");
        C1354qp.x0(decorView3, this);
    }

    public void onBackPressed() {
        this.onBackPressedDispatcher.c();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackPressedDispatcher onBackPressedDispatcher2 = this.onBackPressedDispatcher;
            OnBackInvokedDispatcher onBackInvokedDispatcher = getOnBackInvokedDispatcher();
            C1177ig.e(onBackInvokedDispatcher, "onBackInvokedDispatcher");
            onBackPressedDispatcher2.getClass();
            onBackPressedDispatcher2.f813a = onBackInvokedDispatcher;
            onBackPressedDispatcher2.d(onBackPressedDispatcher2.b);
        }
        this.savedStateRegistryController.b(bundle);
        getLifecycleRegistry().f(Lifecycle.a.ON_CREATE);
    }

    public Bundle onSaveInstanceState() {
        Bundle onSaveInstanceState = super.onSaveInstanceState();
        C1177ig.e(onSaveInstanceState, "super.onSaveInstanceState()");
        this.savedStateRegistryController.c(onSaveInstanceState);
        return onSaveInstanceState;
    }

    public void onStart() {
        super.onStart();
        getLifecycleRegistry().f(Lifecycle.a.ON_RESUME);
    }

    public void onStop() {
        getLifecycleRegistry().f(Lifecycle.a.ON_DESTROY);
        this._lifecycleRegistry = null;
        super.onStop();
    }

    public void setContentView(int i) {
        initializeViewTreeOwners();
        super.setContentView(i);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ComponentDialog(Context context, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ComponentDialog(Context context, int i) {
        super(context, i);
        C1177ig.f(context, LogCategory.CONTEXT);
        this.savedStateRegistryController = new SavedStateRegistryController(this);
        this.onBackPressedDispatcher = new OnBackPressedDispatcher(new C0189f6(this, 0));
    }

    public void setContentView(View view) {
        C1177ig.f(view, "view");
        initializeViewTreeOwners();
        super.setContentView(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        C1177ig.f(view, "view");
        initializeViewTreeOwners();
        super.setContentView(view, layoutParams);
    }

    public static /* synthetic */ void getOnBackPressedDispatcher$annotations() {
    }
}
