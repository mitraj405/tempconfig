package in.juspay.hypersdk.core;

import android.content.Context;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.ads.mediation.facebook.FacebookMediationAdapter;
import in.juspay.hyper.core.ExecutorManager;
import in.juspay.hypersdk.analytics.LogConstants;
import in.juspay.hypersdk.mystique.Callback;
import in.juspay.hypersdk.services.SdkConfigService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class Renderer {
    private final HashMap<String, ViewGroup> container;
    private final DynamicUI dynamicUI;
    private final HashMap<String, View> prevView;
    ConcurrentHashMap<String, List<View>> viewCache = new ConcurrentHashMap<>();
    private int viewCacheCapacity;

    public static class RenderTreeNode {
        View itself;
        ViewGroup parent;

        public RenderTreeNode(ViewGroup viewGroup, View view) {
            this.parent = viewGroup;
            this.itself = view;
        }
    }

    public Renderer(DynamicUI dynamicUI2) {
        this.dynamicUI = dynamicUI2;
        this.container = new HashMap<>();
        this.prevView = new HashMap<>();
        try {
            this.viewCacheCapacity = SdkConfigService.getCachedSdkConfig().getJSONObject("uiFeatures").getJSONObject("nbListItemCaching").getInt("bgCacheCapacity");
        } catch (Exception unused) {
            this.viewCacheCapacity = 4;
        }
        try {
            initCache();
        } catch (Exception e) {
            dynamicUI2.getLogger().e("Error while initializing cache", e.toString());
        }
    }

    private void addViewFromRenderTreeNodeQueue(Queue<RenderTreeNode> queue) {
        while (!queue.isEmpty()) {
            RenderTreeNode poll = queue.poll();
            if (poll != null) {
                poll.parent.addView(poll.itself);
            }
        }
    }

    private View createAllNodesAndReturnRoot(JSONObject jSONObject, Queue<RenderTreeNode> queue, boolean z) {
        String string = jSONObject.getString("type");
        JSONObject jSONObject2 = jSONObject.getJSONObject("props");
        if (jSONObject.has("props")) {
            setCurrentNodeDetails(string, jSONObject2);
        }
        Object newInstanceFromClassName = getNewInstanceFromClassName(string);
        Iterator<String> keys = jSONObject2.keys();
        while (keys.hasNext()) {
            this.dynamicUI.getInflateView().parseKeys(keys.next(), jSONObject2, newInstanceFromClassName, z);
        }
        JSONArray jSONArray = jSONObject.getJSONArray("children");
        if (jSONArray.length() != 0) {
            for (int i = 0; i < jSONArray.length(); i++) {
                queue.add(new RenderTreeNode((ViewGroup) newInstanceFromClassName, createAllNodesAndReturnRoot(jSONArray.getJSONObject(i), queue, z)));
            }
        }
        return (View) newInstanceFromClassName;
    }

    private View createNodesAndReturnRoot(JSONObject jSONObject, InflateView inflateView) {
        String string = jSONObject.getString("type");
        JSONObject jSONObject2 = jSONObject.getJSONObject("props");
        if (jSONObject.has("props")) {
            setCurrentNodeDetails(string, jSONObject2);
        }
        Object newInstanceFromClassName = getNewInstanceFromClassName(string);
        Iterator<String> keys = jSONObject2.keys();
        while (keys.hasNext()) {
            inflateView.parseKeys(keys.next(), jSONObject2, newInstanceFromClassName, inflateView.getUseAppContext());
        }
        JSONArray jSONArray = jSONObject.getJSONArray("children");
        if (jSONArray.length() != 0) {
            for (int i = 0; i < jSONArray.length(); i++) {
                ((ViewGroup) newInstanceFromClassName).addView(createNodesAndReturnRoot(jSONArray.getJSONObject(i), inflateView));
            }
        }
        return (View) newInstanceFromClassName;
    }

    private Object getNewInstanceFromClassName(String str) {
        Context appContext = this.dynamicUI.getAppContext();
        View cachedViewFor = getCachedViewFor(str);
        if (cachedViewFor != null) {
            return cachedViewFor;
        }
        str.getClass();
        char c = 65535;
        switch (str.hashCode()) {
            case -2096886772:
                if (str.equals("android.widget.FrameLayout")) {
                    c = 0;
                    break;
                }
                break;
            case -1973910559:
                if (str.equals("android.widget.RelativeLayout")) {
                    c = 1;
                    break;
                }
                break;
            case -1929723370:
                if (str.equals("android.view.TextureView")) {
                    c = 2;
                    break;
                }
                break;
            case -1430722502:
                if (str.equals("android.widget.LinearLayout")) {
                    c = 3;
                    break;
                }
                break;
            case -1238256809:
                if (str.equals("androidx.swiperefreshlayout.widget.SwipeRefreshLayout")) {
                    c = 4;
                    break;
                }
                break;
            case -214285650:
                if (str.equals("android.widget.CheckBox")) {
                    c = 5;
                    break;
                }
                break;
            case -149114526:
                if (str.equals("android.widget.EditText")) {
                    c = 6;
                    break;
                }
                break;
            case -50131582:
                if (str.equals("android.widget.ImageButton")) {
                    c = 7;
                    break;
                }
                break;
            case 670921973:
                if (str.equals("android.widget.ImageView")) {
                    c = 8;
                    break;
                }
                break;
            case 841510749:
                if (str.equals("android.widget.ScrollView")) {
                    c = 9;
                    break;
                }
                break;
            case 1540240509:
                if (str.equals("android.widget.TextView")) {
                    c = 10;
                    break;
                }
                break;
            case 1583615229:
                if (str.equals("android.widget.Button")) {
                    c = 11;
                    break;
                }
                break;
            case 1663696930:
                if (str.equals("android.widget.RadioButton")) {
                    c = 12;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return new FrameLayout(appContext);
            case 1:
                return new RelativeLayout(appContext);
            case 2:
                return new TextureView(appContext);
            case 3:
                return new LinearLayout(appContext);
            case 4:
                return new SwipeRefreshLayout(appContext);
            case 5:
                return new CheckBox(appContext);
            case 6:
                return new EditText(appContext);
            case 7:
                return new ImageButton(appContext);
            case 8:
                return new ImageView(appContext);
            case 9:
                return new ScrollView(appContext);
            case 10:
                return new TextView(appContext);
            case 11:
                return new Button(appContext);
            case 12:
                return new RadioButton(appContext);
            default:
                return getInflateView().getClassName(str).getConstructor(new Class[]{Context.class}).newInstance(new Object[]{appContext});
        }
    }

    private void initCache() {
        ExecutorManager.runOnBackgroundThread(new Ft(7, this, new String[]{"android.widget.RelativeLayout", "android.widget.LinearLayout", "android.widget.ImageView", "android.widget.ScrollView", "android.widget.TextView", "android.widget.EditText", "android.widget.FrameLayout"}));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$initCache$0(String[] strArr) {
        List synchronizedList = Collections.synchronizedList(new ArrayList());
        for (String str : strArr) {
            int i = 0;
            while (i < this.viewCacheCapacity) {
                try {
                    synchronizedList.add((View) Class.forName(str).getConstructor(new Class[]{Context.class}).newInstance(new Object[]{this.dynamicUI.getAppContext()}));
                    i++;
                } catch (Exception e) {
                    this.dynamicUI.getLogger().e("Error while initializing cache in function", e.toString());
                }
            }
            this.viewCache.put(str, synchronizedList);
            synchronizedList = Collections.synchronizedList(new ArrayList());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$replenishCache$1(String str) {
        List list = this.viewCache.get(str);
        if (list == null) {
            list = Collections.synchronizedList(new ArrayList());
            this.viewCache.put(str, list);
        }
        if (list.size() < this.viewCacheCapacity) {
            try {
                list.add((View) Class.forName(str).getConstructor(new Class[]{Context.class}).newInstance(new Object[]{this.dynamicUI.getAppContext()}));
            } catch (Exception unused) {
            }
        }
    }

    private void removeViewFromContainer(View view, String str) {
        ViewGroup viewGroup = this.container.get(str);
        if (viewGroup != null) {
            viewGroup.removeViewAt(viewGroup.indexOfChild(view));
        }
    }

    private void render(View view, String str) {
        ViewGroup viewGroup = this.container.get(str);
        if (view == null || viewGroup == null) {
            Callback errorCallback = this.dynamicUI.getErrorCallback();
            errorCallback.onError("ERROR", " isNull : fn__Render -  instance null " + getErrorDetails());
            return;
        }
        viewGroup.addView(view);
    }

    public void addStoredViewToParent(String str, String str2, int i, boolean z, String str3) {
        StringBuilder sb;
        Callback callback;
        int identifier = this.dynamicUI.getAppContext().getResources().getIdentifier(str, FacebookMediationAdapter.KEY_ID, this.dynamicUI.getAppContext().getPackageName());
        if (i >= 0) {
            ViewGroup container2 = this.dynamicUI.getContainer(str3);
            if (container2 == null) {
                Callback errorCallback = this.dynamicUI.getErrorCallback();
                errorCallback.onError("ERROR", " isNull : fn__addViewToParent - container null " + getErrorDetails());
                return;
            }
            ViewGroup viewGroup = (ViewGroup) container2.findViewById(identifier);
            if (z) {
                viewGroup.removeAllViews();
            }
            View view = (View) this.dynamicUI.getViewFromScreenName(str2);
            if (view != null) {
                if (view.getParent() != null) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
                viewGroup.addView(view, i);
                return;
            }
            callback = this.dynamicUI.getErrorCallback();
            sb = new StringBuilder(" isNull : fn__addViewToParent - child null ");
        } else {
            callback = this.dynamicUI.getErrorCallback();
            sb = new StringBuilder(" isNull : fn__addViewToParent - negative index ");
        }
        sb.append(getErrorDetails());
        callback.onError("ERROR", sb.toString());
    }

    public void addViewToParent(String str, JSONObject jSONObject, int i, boolean z, String str2) {
        int identifier = this.dynamicUI.getAppContext().getResources().getIdentifier(str, FacebookMediationAdapter.KEY_ID, this.dynamicUI.getAppContext().getPackageName());
        ViewGroup container2 = this.dynamicUI.getContainer(str2);
        if (i < 0 || container2 == null) {
            if (container2 == null) {
                this.dynamicUI.getLogger().e("Missing Container", "addViewToParent, InflateView, it is not  activity, it is applicationContext");
            }
            if (jSONObject.has("props")) {
                setCurrentNodeDetails(jSONObject.getString("type"), jSONObject.getJSONObject("props"));
            }
            Callback errorCallback = this.dynamicUI.getErrorCallback();
            errorCallback.onError("ERROR", " isNull : fn__addViewToParent - negative index " + getErrorDetails());
            return;
        }
        ViewGroup viewGroup = (ViewGroup) container2.findViewById(identifier);
        if (z) {
            viewGroup.removeAllViews();
        }
        LinkedList linkedList = new LinkedList();
        InflateJSON inflateJSON = new InflateJSON(this.dynamicUI);
        inflateJSON.setUseAppContext(true);
        View createAllNodesAndReturnRoot = createAllNodesAndReturnRoot(jSONObject, linkedList, inflateJSON.getUseAppContext());
        addViewFromRenderTreeNodeQueue(linkedList);
        viewGroup.addView(createAllNodesAndReturnRoot, i);
    }

    public View createView(JSONObject jSONObject) {
        String string = jSONObject.getString("type");
        JSONObject jSONObject2 = jSONObject.getJSONObject("props");
        if (jSONObject.has("props")) {
            setCurrentNodeDetails(string, jSONObject2);
        }
        Object newInstanceFromClassName = getNewInstanceFromClassName(string);
        Iterator<String> keys = jSONObject2.keys();
        InflateJSON inflateJSON = new InflateJSON(this.dynamicUI);
        inflateJSON.setUseAppContext(true);
        while (keys.hasNext()) {
            this.dynamicUI.getInflateView().parseKeys(keys.next(), jSONObject2, newInstanceFromClassName, inflateJSON.getUseAppContext());
        }
        JSONArray jSONArray = jSONObject.getJSONArray("children");
        if (jSONArray.length() != 0) {
            for (int i = 0; i < jSONArray.length(); i++) {
                View createView = createView(jSONArray.getJSONObject(i));
                if (createView != null) {
                    ((ViewGroup) newInstanceFromClassName).addView(createView);
                }
            }
        }
        return (View) newInstanceFromClassName;
    }

    public void dismissPopUp() {
        this.dynamicUI.getInflateView().dismissPopUp();
    }

    public View getCachedViewFor(String str) {
        List list = this.viewCache.get(str);
        if (list == null) {
            return null;
        }
        int size = list.size();
        if (size == 0) {
            replenishCache(str);
            return null;
        }
        View view = (View) list.remove(0);
        if (size < this.viewCacheCapacity) {
            replenishCache(str);
        }
        return view;
    }

    public String getErrorDetails() {
        return this.dynamicUI.getInflateView().getErrorDetails();
    }

    public InflateView getInflateView() {
        return this.dynamicUI.getInflateView();
    }

    public void parseAndRunPipe(Object obj, String str, String str2, String str3, boolean z) {
        this.dynamicUI.getInflateView().setCurrView("modifyDom");
        this.dynamicUI.getInflateView().setCurrViewId("");
        InflateView inflateView = this.dynamicUI.getInflateView();
        inflateView.setFileOrigin("ln: " + str2 + " " + str3);
        this.dynamicUI.getInflateView().parseAndRunPipe(obj, str, z);
    }

    public void prepareAndStoreView(String str, JSONObject jSONObject) {
        InflateJSON inflateJSON = new InflateJSON(this.dynamicUI);
        inflateJSON.setUseAppContext(true);
        this.dynamicUI.addToScreenMap(str, createNodesAndReturnRoot(jSONObject, inflateJSON));
    }

    public void renderUI(JSONObject jSONObject, ViewGroup viewGroup, String str) {
        renderUI(jSONObject, viewGroup, true, str);
    }

    public void replenishCache(String str) {
        ExecutorManager.runOnBackgroundThread(new m(5, this, str));
    }

    public void setCurrentNodeDetails(String str, JSONObject jSONObject) {
        this.dynamicUI.getInflateView().setCurrView(str);
        if (jSONObject.has("node_id")) {
            this.dynamicUI.getInflateView().setCurrViewId(jSONObject.getString("node_id"));
        }
        if (jSONObject.has("__filename")) {
            this.dynamicUI.getInflateView().setFileOrigin(jSONObject.getString("__filename"));
        }
    }

    public void renderUI(JSONObject jSONObject, ViewGroup viewGroup, boolean z, String str) {
        if (str == null) {
            str = LogConstants.DEFAULT_CHANNEL;
        }
        this.container.put(str, viewGroup);
        LinkedList linkedList = new LinkedList();
        InflateJSON inflateJSON = new InflateJSON(this.dynamicUI);
        inflateJSON.setUseAppContext(true);
        View createAllNodesAndReturnRoot = createAllNodesAndReturnRoot(jSONObject, linkedList, inflateJSON.getUseAppContext());
        if (z && this.prevView.get(str) != createAllNodesAndReturnRoot) {
            removeViewFromContainer(this.prevView.get(str), str);
        }
        addViewFromRenderTreeNodeQueue(linkedList);
        render(createAllNodesAndReturnRoot, str);
        this.prevView.put(str, createAllNodesAndReturnRoot);
    }
}
