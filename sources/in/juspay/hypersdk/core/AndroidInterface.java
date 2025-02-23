package in.juspay.hypersdk.core;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Build;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.webkit.JavascriptInterface;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;
import androidx.core.view.f;
import com.google.ads.mediation.facebook.FacebookMediationAdapter;
import in.juspay.hyper.core.ExecutorManager;
import in.juspay.hypersdk.mystique.Callback;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class AndroidInterface {
    /* access modifiers changed from: private */
    public final DynamicUI dynamicUI;
    private final Set<String> onGoingPrepareScreenSet = new HashSet();
    private final Map<String, PendingAddScreenMapItem> pendingAddScreenMap = new HashMap();
    private String state;

    public static final class PendingAddScreenMapItem {
        String callbackName;
        int index;
        String parentId;
        boolean replaceChild;
        String runInUIprop;
        String screenName;

        public PendingAddScreenMapItem(String str, String str2, int i, String str3, boolean z, String str4) {
            this.parentId = str;
            this.screenName = str2;
            this.index = i;
            this.callbackName = str3;
            this.replaceChild = z;
            this.runInUIprop = str4;
        }
    }

    public static class PreRenderThread extends Thread {
        public PreRenderThread(Runnable runnable) {
            super(runnable);
            setName("PreRenderThread");
        }
    }

    public AndroidInterface(DynamicUI dynamicUI2) {
        this.dynamicUI = dynamicUI2;
    }

    private int findChildIndex(int i, ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (viewGroup.getChildAt(i2).getId() == i) {
                return i2;
            }
        }
        return -1;
    }

    private String getJSONResult(String str) {
        boolean z;
        JSONArray jSONArray = new JSONArray(str);
        InflateJSON inflateJSON = new InflateJSON(this.dynamicUI);
        if (this.dynamicUI.getActivity() == null) {
            z = true;
        } else {
            z = false;
        }
        inflateJSON.setUseAppContext(z);
        Object runJSON = inflateJSON.runJSON((Object) null, jSONArray, inflateJSON.getUseAppContext(), (LinkedList<String>) null);
        if (runJSON != null) {
            return runJSON.toString();
        }
        return "_null_";
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$addStoredViewToParent$3(String str, String str2, int i, String str3, boolean z, String str4, String str5) {
        try {
            if (this.onGoingPrepareScreenSet.contains(str)) {
                this.pendingAddScreenMap.put(str, new PendingAddScreenMapItem(str2, str, i, str3, z, str4));
                return;
            }
            this.dynamicUI.getRenderer().addStoredViewToParent(str2, str, i, z, str5);
            InflateJSON inflateJSON = new InflateJSON(this.dynamicUI);
            inflateJSON.setUseAppContext(true);
            this.dynamicUI.getRenderer().parseAndRunPipe(this.dynamicUI.getAppContext(), str4, "", "", inflateJSON.getUseAppContext());
            if (str3 != null) {
                DynamicUI dynamicUI2 = this.dynamicUI;
                dynamicUI2.addJsToWebView("window.callUICallback('" + str3 + "','success');");
            }
        } catch (Exception e) {
            DuiLogger logger = this.dynamicUI.getLogger();
            logger.e("ERROR", " excep: fn__addStoredViewToParent  - " + this.dynamicUI.getRenderer().getErrorDetails());
            Callback errorCallback = this.dynamicUI.getErrorCallback();
            errorCallback.onException("ERROR", " excep: fn__addStoredViewToParent  - " + this.dynamicUI.getRenderer().getErrorDetails(), e);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$addViewToParent$1(String str, JSONObject jSONObject, int i, boolean z, String str2, String str3) {
        try {
            this.dynamicUI.getRenderer().addViewToParent(str, jSONObject, i, z, str2);
            if (str3 != null) {
                DynamicUI dynamicUI2 = this.dynamicUI;
                dynamicUI2.addJsToWebView("window.callUICallback('" + str3 + "','success');");
            }
        } catch (Exception e) {
            DuiLogger logger = this.dynamicUI.getLogger();
            logger.e("ERROR", " excep: fn__addViewToParent  - " + this.dynamicUI.getRenderer().getErrorDetails());
            Callback errorCallback = this.dynamicUI.getErrorCallback();
            errorCallback.onException("ERROR", " excep: fn__addViewToParent  - " + this.dynamicUI.getRenderer().getErrorDetails(), e);
            if (str3 != null) {
                this.dynamicUI.addJsToWebView(lf.j("window.callUICallback('", str3, "','failure');"));
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$cancelAnim$18(ObjectAnimator objectAnimator, String str, String str2) {
        try {
            objectAnimator.cancel();
            float floatValue = ((Float) objectAnimator.getAnimatedValue()).floatValue();
            DynamicUI dynamicUI2 = this.dynamicUI;
            dynamicUI2.addJsToWebView("window.callUICallback('" + str + "', '" + floatValue + "');");
        } catch (Exception unused) {
            DuiLogger logger = this.dynamicUI.getLogger();
            logger.e("JSONERROR", "Error parsing json for animation with id " + str2);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$generateUIElement$15(String str, String str2, int i, String[] strArr, String str3) {
        ViewGroup container = this.dynamicUI.getContainer(str);
        if (container == null) {
            this.dynamicUI.getLogger().e("missing_container", "render, no container");
        } else if (str2.equals("PopupMenu")) {
            container.findViewById(i).setOnClickListener(new f(this, strArr, str3));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$moveView$5(String str, String str2, String str3) {
        try {
            ViewGroup container = this.dynamicUI.getContainer(str);
            if (container != null) {
                View findViewById = container.findViewById(Integer.parseInt(str2));
                ViewGroup viewGroup = (ViewGroup) findViewById.getParent();
                viewGroup.removeView(findViewById);
                viewGroup.addView(findViewById, Integer.parseInt(str3));
                return;
            }
            this.dynamicUI.getLogger().e("missing_container", "moveView, no container");
        } catch (Exception unused) {
            DuiLogger logger = this.dynamicUI.getLogger();
            logger.e("ERROR", " fn__moveView - " + this.dynamicUI.getRenderer().getErrorDetails());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$prepareAndStoreView$2(String str, JSONObject jSONObject, String str2) {
        try {
            setPrepareScreenTaskStatus(str, true);
            this.dynamicUI.getRenderer().prepareAndStoreView(str, jSONObject);
            if (str2 != null) {
                DynamicUI dynamicUI2 = this.dynamicUI;
                dynamicUI2.addJsToWebView("window.callUICallback('" + str2 + "','success');");
            }
        } catch (Exception e) {
            DuiLogger logger = this.dynamicUI.getLogger();
            logger.e("ERROR", " excep: fn__prepareAndStoreView  - " + this.dynamicUI.getRenderer().getErrorDetails());
            Callback errorCallback = this.dynamicUI.getErrorCallback();
            errorCallback.onException("ERROR", " excep: fn__prepareAndStoreView  - " + this.dynamicUI.getRenderer().getErrorDetails(), e);
            if (str2 != null) {
                this.dynamicUI.addJsToWebView(lf.j("window.callUICallback('", str2, "','failure');"));
            }
        }
        setPrepareScreenTaskStatus(str, false);
        processPendingAddScreen(str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$processPendingAddScreen$21(String str) {
        PendingAddScreenMapItem pendingAddScreenMapItem = this.pendingAddScreenMap.get(str);
        if (pendingAddScreenMapItem != null) {
            this.pendingAddScreenMap.remove(str);
            addStoredViewToParent(pendingAddScreenMapItem.parentId, pendingAddScreenMapItem.screenName, pendingAddScreenMapItem.index, pendingAddScreenMapItem.callbackName, pendingAddScreenMapItem.replaceChild, pendingAddScreenMapItem.runInUIprop, (String) null);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$removeView$6(String str, int i) {
        ViewGroup container = this.dynamicUI.getContainer(str);
        if (container != null) {
            View findViewById = container.findViewById(i);
            if (findViewById != null) {
                ((ViewGroup) findViewById.getParent()).removeView(findViewById);
                return;
            }
            return;
        }
        this.dynamicUI.getLogger().e("missing_container", "removeView, no container");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$render$0(JSONObject jSONObject, String str, String str2, String str3) {
        try {
            this.dynamicUI.getRenderer().renderUI(jSONObject, this.dynamicUI.getContainer(str), Boolean.parseBoolean(str2), str);
            if (str3 != null) {
                DynamicUI dynamicUI2 = this.dynamicUI;
                dynamicUI2.addJsToWebView("window.callUICallback(" + str3 + ",'success');");
            }
        } catch (Exception e) {
            DuiLogger logger = this.dynamicUI.getLogger();
            logger.e("ERROR", " excep: fn__Render  - " + this.dynamicUI.getRenderer().getErrorDetails());
            Callback errorCallback = this.dynamicUI.getErrorCallback();
            errorCallback.onException("ERROR", " excep: fn__Render  - " + this.dynamicUI.getRenderer().getErrorDetails(), e);
            if (str3 != null) {
                this.dynamicUI.addJsToWebView(lf.j("window.callUICallback(", str3, ",'failure');"));
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$replaceView$4(String str, JSONObject jSONObject, int i) {
        try {
            ViewGroup container = this.dynamicUI.getContainer(str);
            if (container != null) {
                View createView = this.dynamicUI.getRenderer().createView(jSONObject);
                View findViewById = container.findViewById(i);
                if (findViewById != null) {
                    if (findViewById instanceof ViewGroup) {
                        int childCount = ((ViewGroup) findViewById).getChildCount();
                        for (int i2 = 0; i2 < childCount; i2++) {
                            View childAt = ((ViewGroup) findViewById).getChildAt(0);
                            if (childAt != null) {
                                ((ViewGroup) findViewById).removeViewAt(0);
                                ((ViewGroup) createView).addView(childAt, i2);
                            }
                        }
                    }
                    if (replaceViewImpl(createView, findViewById)) {
                        createView.requestLayout();
                        return;
                    }
                    return;
                }
                return;
            }
            this.dynamicUI.getLogger().e("missing_container", "replaceView, no container");
        } catch (JSONException unused) {
        } catch (Exception e) {
            this.dynamicUI.getLogger().e(e.getLocalizedMessage(), "excep: fn__replaceView - Error while replaceView " + e);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$runInUI$7(String str, String str2, String str3, String str4) {
        Object obj;
        Renderer renderer;
        try {
            InflateJSON inflateJSON = new InflateJSON(this.dynamicUI);
            if (this.dynamicUI.getActivity() != null) {
                inflateJSON.setUseAppContext(false);
                renderer = this.dynamicUI.getRenderer();
                obj = this.dynamicUI.getActivity();
            } else {
                inflateJSON.setUseAppContext(true);
                renderer = this.dynamicUI.getRenderer();
                obj = this.dynamicUI.getAppContext();
            }
            renderer.parseAndRunPipe(obj, str, str2, str3, inflateJSON.getUseAppContext());
            if (str4 != null) {
                DynamicUI dynamicUI2 = this.dynamicUI;
                dynamicUI2.addJsToWebView("window.callUICallback(" + str4 + ",'success');");
            }
        } catch (Exception e) {
            DuiLogger logger = this.dynamicUI.getLogger();
            logger.e("ERROR", " excep: fn__runInUI  - " + this.dynamicUI.getRenderer().getErrorDetails());
            Callback errorCallback = this.dynamicUI.getErrorCallback();
            errorCallback.onException("ERROR", " excep: fn__runInUI  - " + this.dynamicUI.getRenderer().getErrorDetails(), e);
            if (str4 != null) {
                this.dynamicUI.addJsToWebView(lf.j("window.callUICallback(", str4, ",'failure');"));
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$runInUI$8(String str, String str2) {
        Object obj;
        Renderer renderer;
        try {
            InflateJSON inflateJSON = new InflateJSON(this.dynamicUI);
            if (this.dynamicUI.getActivity() != null) {
                inflateJSON.setUseAppContext(false);
                renderer = this.dynamicUI.getRenderer();
                obj = this.dynamicUI.getActivity();
            } else {
                inflateJSON.setUseAppContext(true);
                renderer = this.dynamicUI.getRenderer();
                obj = this.dynamicUI.getAppContext();
            }
            renderer.parseAndRunPipe(obj, str, "", "", inflateJSON.getUseAppContext());
            if (str2 != null) {
                DynamicUI dynamicUI2 = this.dynamicUI;
                dynamicUI2.addJsToWebView("window.callUICallback(" + str2 + ",'success');");
            }
        } catch (Exception e) {
            String name = e.getClass().getName();
            DuiLogger logger = this.dynamicUI.getLogger();
            StringBuilder K = xx.K(" excep: fn__runInUI  - ", name, " - ");
            K.append(this.dynamicUI.getRenderer().getErrorDetails());
            logger.e("ERROR", K.toString());
            Callback errorCallback = this.dynamicUI.getErrorCallback();
            StringBuilder K2 = xx.K(" excep: fn__runInUI  - ", name, " - ");
            K2.append(this.dynamicUI.getRenderer().getErrorDetails());
            errorCallback.onError("ERROR", K2.toString());
            if (str2 != null) {
                this.dynamicUI.addJsToWebView(lf.j("window.callUICallback(", str2, ",'failure');"));
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setImage$12(String str, int i, String str2) {
        try {
            ViewGroup container = this.dynamicUI.getContainer(str);
            if (container != null) {
                byte[] decode = Base64.decode(str2, 0);
                ((ImageView) container.findViewById(i)).setImageBitmap(BitmapFactory.decodeByteArray(decode, 0, decode.length));
                return;
            }
            this.dynamicUI.getLogger().e("missing_container", "setImage, no container");
        } catch (Exception e) {
            DuiLogger logger = this.dynamicUI.getLogger();
            logger.e("ERROR", " excep: fn__setImage  - " + this.dynamicUI.getRenderer().getErrorDetails());
            Callback errorCallback = this.dynamicUI.getErrorCallback();
            errorCallback.onException("ERROR", " excep: fn__setImage  - " + this.dynamicUI.getRenderer().getErrorDetails(), e);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setPrepareScreenTaskStatus$20(boolean z, String str) {
        if (z) {
            this.onGoingPrepareScreenSet.add(str);
        } else {
            this.onGoingPrepareScreenSet.remove(str);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean lambda$showPopup$16(String str, MenuItem menuItem) {
        DynamicUI dynamicUI2 = this.dynamicUI;
        StringBuilder K = xx.K("window.callUICallback('", str, "', '");
        K.append(menuItem.getItemId());
        K.append("');");
        dynamicUI2.addJsToWebView(K.toString());
        Activity activity = this.dynamicUI.getActivity();
        Toast.makeText(activity, "You Clicked : " + menuItem.getTitle(), 0).show();
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$startAnim$17(Pair pair, final String str, final String str2) {
        if (pair != null) {
            try {
                Object obj = pair.second;
                if (obj != null) {
                    ((ObjectAnimator) obj).start();
                    ((ObjectAnimator) pair.second).addListener(new Animator.AnimatorListener() {
                        public void onAnimationEnd(Animator animator) {
                            String str = str;
                            if (str != null && !str.isEmpty()) {
                                DynamicUI access$000 = AndroidInterface.this.dynamicUI;
                                StringBuilder sb = new StringBuilder("window.callUICallback('");
                                sb.append(str);
                                sb.append("', '");
                                access$000.addJsToWebView(C0709Uj.j(sb, str2, "');"));
                            }
                        }

                        public void onAnimationCancel(Animator animator) {
                        }

                        public void onAnimationRepeat(Animator animator) {
                        }

                        public void onAnimationStart(Animator animator) {
                        }
                    });
                }
            } catch (Exception unused) {
                DuiLogger logger = this.dynamicUI.getLogger();
                logger.e("JSONERROR", "Error parsing json for animation with id " + str2);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$toggleKeyboard$13(String str, int i, String str2) {
        ViewGroup container = this.dynamicUI.getContainer(str);
        if (container != null) {
            View findViewById = container.findViewById(i);
            InputMethodManager inputMethodManager = (InputMethodManager) this.dynamicUI.getActivity().getSystemService("input_method");
            if (str2.equals("show")) {
                inputMethodManager.showSoftInput(findViewById, 1);
            } else {
                inputMethodManager.hideSoftInputFromWindow(findViewById.getWindowToken(), 0);
            }
        } else {
            this.dynamicUI.getLogger().e("missing_container", "removeView, no container");
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$updateAnim$19(String str, int i, JSONArray jSONArray) {
        try {
            ViewGroup container = this.dynamicUI.getContainer(str);
            if (container != null) {
                this.dynamicUI.getRenderer().getInflateView().handleAnimation(container.findViewById(i), jSONArray);
                return;
            }
            this.dynamicUI.getLogger().e("missing_container", "updateAnim, no container");
        } catch (Exception unused) {
            DuiLogger logger = this.dynamicUI.getLogger();
            logger.e("ERROR", "updateAnim: View doesn't exist for id -" + i);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$updateProperties$11(String str, String str2) {
        try {
            ViewGroup container = this.dynamicUI.getContainer(str);
            if (container != null) {
                JSONObject jSONObject = new JSONObject(str2);
                View findViewById = container.findViewById(jSONObject.getInt(FacebookMediationAdapter.KEY_ID));
                jSONObject.remove(FacebookMediationAdapter.KEY_ID);
                InflateJSON inflateJSON = new InflateJSON(this.dynamicUI);
                inflateJSON.setUseAppContext(true);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    this.dynamicUI.getRenderer().getInflateView().parseKeys(keys.next(), jSONObject, findViewById, inflateJSON.getUseAppContext());
                }
                return;
            }
            this.dynamicUI.getLogger().e("missing_container", "updateProperties, no container");
        } catch (Exception e) {
            DuiLogger logger = this.dynamicUI.getLogger();
            String localizedMessage = e.getLocalizedMessage();
            logger.e(localizedMessage, "excep: fn__updateProperties- Error while updateProperties " + e);
        }
    }

    private boolean replaceViewImpl(View view, View view2) {
        ViewGroup viewGroup = (ViewGroup) view2.getParent();
        int findChildIndex = findChildIndex(view2.getId(), viewGroup);
        if (findChildIndex == -1) {
            return false;
        }
        viewGroup.removeViewAt(findChildIndex);
        viewGroup.addView(view, findChildIndex);
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: runJSONWithCallback */
    public void lambda$runCmdsInUI$10(String str, String str2) {
        try {
            String jSONResult = getJSONResult(str);
            if (str2 != null) {
                this.dynamicUI.addJsToWebView(String.format("window.callUICallback('%s',%s);", new Object[]{str2, this.dynamicUI.encodeUtfAndWrapDecode(jSONResult, "ERROR")}));
            }
        } catch (Exception e) {
            DuiLogger logger = this.dynamicUI.getLogger();
            logger.e("ERROR", " excep: fn__runInUIJSON  - " + this.dynamicUI.getRenderer().getErrorDetails());
            Callback errorCallback = this.dynamicUI.getErrorCallback();
            errorCallback.onException("ERROR", " excep: fn__runInUIJSON  - " + this.dynamicUI.getRenderer().getErrorDetails(), e);
            if (str2 != null) {
                this.dynamicUI.addJsToWebView(lf.j("window.callUICallbackJSON(", str2, ",'failure');"));
            }
        }
    }

    @JavascriptInterface
    @Deprecated
    public void Render(String str, String str2) {
        render(str, str2, (String) null);
    }

    @JavascriptInterface
    public void addStoredViewToParent(String str, String str2, int i, String str3, boolean z, String str4) {
        addStoredViewToParent(str, str2, i, str3, z, str4, (String) null);
    }

    @JavascriptInterface
    public String addToContainerList(int i, String str) {
        ViewGroup container = this.dynamicUI.getContainer(str);
        if (container == null || !(container.findViewById(i) instanceof ViewGroup)) {
            return "__failed";
        }
        return this.dynamicUI.addToContainerList((ViewGroup) container.findViewById(i));
    }

    @JavascriptInterface
    public void addViewToParent(String str, String str2, int i, String str3) {
        addViewToParent(str, str2, i, str3, (String) null);
    }

    @JavascriptInterface
    public void cancelAnim(String str, String str2) {
        InflateView inflateView = this.dynamicUI.getRenderer().getInflateView();
        ExecutorManager.runOnMainThread(new i(this, (ObjectAnimator) ((Pair) inflateView.getStateValFromKey("M_anim_" + str)).second, str2, str));
    }

    @JavascriptInterface
    public void dismissPopUp() {
        this.dynamicUI.getRenderer().dismissPopUp();
    }

    @JavascriptInterface
    public int dpToPx(int i) {
        if (i > 0) {
            return Math.round(((float) i) * this.dynamicUI.getAppContext().getResources().getDisplayMetrics().density);
        }
        return 0;
    }

    @JavascriptInterface
    public String fetchData(String str) {
        return this.dynamicUI.getAppContext().getSharedPreferences("DUI", 0).getString(str, "null");
    }

    @JavascriptInterface
    public void generateUIElement(String str, int i, String[] strArr, String str2) {
        generateUIElement(str, i, strArr, str2, (String) null);
    }

    @JavascriptInterface
    public String getInternalStorageBaseFilePath() {
        return this.dynamicUI.getAppContext().getDir("juspay", 0).getAbsolutePath();
    }

    @JavascriptInterface
    public String getNewID() {
        WeakHashMap<View, GC> weakHashMap = f.f1839a;
        return String.valueOf(View.generateViewId());
    }

    public Renderer getRenderer() {
        return this.dynamicUI.getRenderer();
    }

    @JavascriptInterface
    public String getScreenDimensions() {
        int i;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        Rect rect = new Rect();
        try {
            if (this.dynamicUI.getActivity() != null) {
                this.dynamicUI.getActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                this.dynamicUI.getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                if (Build.VERSION.SDK_INT >= 30) {
                    i = this.dynamicUI.getActivity().getWindowManager().getCurrentWindowMetrics().getBounds().height();
                } else {
                    this.dynamicUI.getActivity().getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics2);
                    i = displayMetrics2.heightPixels;
                }
            } else {
                displayMetrics = Resources.getSystem().getDisplayMetrics();
                i = 0;
            }
            jSONObject.put("width", displayMetrics.widthPixels);
            jSONObject.put("height", displayMetrics.heightPixels);
            jSONObject.put("screenHeight", i);
            jSONObject2.put("top", rect.top);
            jSONObject2.put("bottom", rect.bottom);
            jSONObject2.put("left", rect.left);
            jSONObject2.put("right", rect.right);
            jSONObject.put("viewportDimensions", jSONObject2);
        } catch (JSONException e) {
            this.dynamicUI.getLogger().e("JSON_EXCEPTION", e.toString());
        }
        return jSONObject.toString();
    }

    @JavascriptInterface
    public String getState() {
        String str = this.state;
        if (str != null) {
            return str;
        }
        return "{}";
    }

    @JavascriptInterface
    public boolean isFilePresent(String str) {
        return new File(str).exists();
    }

    @JavascriptInterface
    public void moveView(String str, String str2) {
        moveView(str, str2, (String) null);
    }

    @JavascriptInterface
    public void prepareAndStoreView(String str, String str2, String str3) {
        try {
            new PreRenderThread(new p(this, str, new JSONObject(str2), str3)).start();
        } catch (JSONException unused) {
            DuiLogger logger = this.dynamicUI.getLogger();
            logger.e("JSONERROR", "Error while parsing " + str2);
        }
    }

    public void processPendingAddScreen(String str) {
        ExecutorManager.runOnMainThread(new m(0, this, str));
    }

    @JavascriptInterface
    public void removeView(int i) {
        removeView(i, (String) null);
    }

    @JavascriptInterface
    public void render(String str, String str2) {
        render(str, str2, "true", (String) null);
    }

    @JavascriptInterface
    public void replaceView(String str, int i) {
        replaceView(str, i, (String) null);
    }

    @JavascriptInterface
    public void run(String str, String str2) {
        Object obj;
        Renderer renderer;
        try {
            InflateJSON inflateJSON = new InflateJSON(this.dynamicUI);
            if (this.dynamicUI.getActivity() != null) {
                inflateJSON.setUseAppContext(false);
                renderer = this.dynamicUI.getRenderer();
                obj = this.dynamicUI.getActivity();
            } else {
                inflateJSON.setUseAppContext(true);
                renderer = this.dynamicUI.getRenderer();
                obj = this.dynamicUI.getAppContext();
            }
            renderer.parseAndRunPipe(obj, str, "", "", inflateJSON.getUseAppContext());
            if (str2 != null) {
                DynamicUI dynamicUI2 = this.dynamicUI;
                dynamicUI2.addJsToWebView("window.callUICallback(" + str2 + ",'success');");
            }
        } catch (Exception e) {
            String name = e.getClass().getName();
            this.dynamicUI.getLogger().e("runInUI", name);
            Callback errorCallback = this.dynamicUI.getErrorCallback();
            StringBuilder n = lf.n(name, " - ");
            n.append(this.dynamicUI.getRenderer().getErrorDetails());
            errorCallback.onError("runInUI", n.toString());
            if (str2 != null) {
                this.dynamicUI.addJsToWebView(lf.j("window.callUICallback(", str2, ",'failure');"));
            }
        }
    }

    @JavascriptInterface
    public String runCmds(String str) {
        try {
            return getJSONResult(str);
        } catch (Exception e) {
            DuiLogger logger = this.dynamicUI.getLogger();
            logger.e("ERROR", " excep: fn__runInUIJSON  - " + this.dynamicUI.getRenderer().getErrorDetails());
            Callback errorCallback = this.dynamicUI.getErrorCallback();
            errorCallback.onException("ERROR", " excep: fn__runInUIJSON  - " + this.dynamicUI.getRenderer().getErrorDetails(), e);
            return "__failure__";
        }
    }

    @JavascriptInterface
    public void runCmdsInBg(String str, String str2) {
        ExecutorManager.runOnBackgroundThread(new j(0, this, str, str2));
    }

    @JavascriptInterface
    public void runCmdsInUI(String str, String str2) {
        ExecutorManager.runOnMainThread(new b(this, str, str2));
    }

    @JavascriptInterface
    public void runInUI(String str, String str2) {
        ExecutorManager.runOnMainThread(new j(1, this, str, str2));
    }

    @JavascriptInterface
    public void saveData(String str, String str2) {
        this.dynamicUI.getAppContext().getSharedPreferences("DUI", 0).edit().putString(str, str2).apply();
    }

    @JavascriptInterface
    public void saveState(String str) {
        this.state = str;
    }

    @JavascriptInterface
    public String setFragmentContainer(int i, String str) {
        ViewGroup container = this.dynamicUI.getContainer(str);
        if (container == null) {
            return "__failed";
        }
        View findViewById = container.findViewById(i);
        if (findViewById instanceof ViewGroup) {
            return this.dynamicUI.addToContainerList((ViewGroup) findViewById);
        }
        return "__failed";
    }

    @JavascriptInterface
    public void setImage(int i, String str, String str2) {
        ExecutorManager.runOnMainThread(new n(this, str2, i, str, 1));
    }

    public void setPrepareScreenTaskStatus(String str, boolean z) {
        ExecutorManager.runOnMainThread(new g(this, z, str));
    }

    @JavascriptInterface
    public void setState(String str) {
        this.state = str;
    }

    /* renamed from: showPopup */
    public void lambda$generateUIElement$14(View view, String[] strArr, String str) {
        if (this.dynamicUI.getActivity() != null) {
            PopupMenu popupMenu = new PopupMenu(this.dynamicUI.getActivity(), view);
            for (int i = 0; i < strArr.length; i++) {
                popupMenu.getMenu().add(0, i, 0, strArr[i]);
            }
            popupMenu.setOnMenuItemClickListener(new h(this, str));
            popupMenu.show();
            return;
        }
        this.dynamicUI.getLogger().e("Missing Activity", "showPopup, it is not  activity, it is applicationContext");
    }

    @JavascriptInterface
    public void startAnim(String str) {
        startAnim(str, (String) null);
    }

    @JavascriptInterface
    public void throwError(String str) {
        this.dynamicUI.getLogger().e("throwError", str);
    }

    @JavascriptInterface
    public void toggleKeyboard(int i, String str, String str2) {
        if (this.dynamicUI.getActivity() != null) {
            ExecutorManager.runOnMainThread(new c(i, this, str2, str));
        } else {
            this.dynamicUI.getLogger().e("Missing Activity", "toggleKeyboard, it is not  activity, it is applicationContext");
        }
    }

    @JavascriptInterface
    public void updateAnim(int i, String str) {
        updateAnim(i, str, (String) null);
    }

    @JavascriptInterface
    public void updateProperties(String str) {
        updateProperties(str, (String) null);
    }

    @JavascriptInterface
    @Deprecated
    public void Render(String str, String str2, String str3) {
        render(str, str2, str3, (String) null);
    }

    @JavascriptInterface
    public void addStoredViewToParent(String str, String str2, int i, String str3, boolean z, String str4, String str5) {
        ExecutorManager.runOnMainThread(new l(this, str2, str, i, str3, z, str4, str5));
    }

    @JavascriptInterface
    public void addViewToParent(String str, String str2, int i, String str3, String str4) {
        addViewToParent(str, str2, i, str3, false, str4);
    }

    @JavascriptInterface
    public void generateUIElement(String str, int i, String[] strArr, String str2, String str3) {
        ExecutorManager.runOnMainThread(new q(this, str3, str, i, strArr, str2));
    }

    @JavascriptInterface
    public void moveView(String str, String str2, String str3) {
        ExecutorManager.runOnMainThread(new i(this, str3, str, str2));
    }

    @JavascriptInterface
    public void removeView(int i, String str) {
        ExecutorManager.runOnMainThread(new d(this, str, i));
    }

    @JavascriptInterface
    public void render(String str, String str2, String str3) {
        render(str, str2, str3, (String) null);
    }

    @JavascriptInterface
    public void replaceView(String str, int i, String str2) {
        try {
            ExecutorManager.runOnMainThread(new e(this, str2, new JSONObject(str), i));
        } catch (JSONException unused) {
            DuiLogger logger = this.dynamicUI.getLogger();
            logger.e("JSON_ERROR", "fn__replaceView - " + this.dynamicUI.getRenderer().getErrorDetails() + " - " + str);
        }
    }

    @JavascriptInterface
    public void runInUI(String str, String str2, String str3, String str4) {
        ExecutorManager.runOnMainThread(new a(this, str, str3, str4, str2));
    }

    @JavascriptInterface
    public void startAnim(String str, String str2) {
        ExecutorManager.runOnMainThread(new o(this, (Pair) this.dynamicUI.getRenderer().getInflateView().findAnimationById(str), str2, str));
    }

    @JavascriptInterface
    public void updateAnim(int i, String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            ExecutorManager.runOnMainThread(new n(this, str2, i, jSONArray, 0));
        } catch (JSONException unused) {
            DuiLogger logger = this.dynamicUI.getLogger();
            logger.e("JSONERROR", "Error parsing json for animation string " + str);
        }
    }

    @JavascriptInterface
    public void updateProperties(String str, String str2) {
        ExecutorManager.runOnMainThread(new j(2, this, str2, str));
    }

    @JavascriptInterface
    public void addViewToParent(String str, String str2, int i, String str3, boolean z) {
        addViewToParent(str, str2, i, str3, z, (String) null);
    }

    @JavascriptInterface
    public void render(String str, String str2, String str3, String str4) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (this.dynamicUI.getContainer(str4) != null) {
                ExecutorManager.runOnMainThread(new a(this, jSONObject, str4, str3, str2));
                return;
            }
            this.dynamicUI.getLogger().e("missing_container", "render, it is not activity, it is applicationContext/ no container");
            Callback errorCallback = this.dynamicUI.getErrorCallback();
            errorCallback.onError("ERROR", " excep: fn__Render  - missing_container - " + this.dynamicUI.getRenderer().getErrorDetails());
            if (str2 != null) {
                DynamicUI dynamicUI2 = this.dynamicUI;
                dynamicUI2.addJsToWebView("window.callUICallback(" + str2 + ",'failure');");
            }
        } catch (JSONException unused) {
            DuiLogger logger = this.dynamicUI.getLogger();
            logger.e("JSONERROR", "fn__render - " + this.dynamicUI.getRenderer().getErrorDetails() + " - " + str);
        }
    }

    @JavascriptInterface
    public void addViewToParent(String str, String str2, int i, String str3, boolean z, String str4) {
        try {
            ExecutorManager.runOnMainThread(new k(this, str, new JSONObject(str2), i, z, str4, str3));
        } catch (JSONException unused) {
            DuiLogger logger = this.dynamicUI.getLogger();
            logger.e("JSONERROR", "Error while parsing " + str2);
        }
    }

    @JavascriptInterface
    @Deprecated
    public void showLoading() {
    }
}
