package in.juspay.hypersdk.mystique;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.util.Property;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import in.juspay.hypersdk.core.DuiCallback;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.WeakHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AnimationHolder {
    private static final String NAME = "name";
    private final WeakHashMap<View, HashMap<String, InlineAnimation>> animatorHashMap = new WeakHashMap<>();
    /* access modifiers changed from: private */
    public final WeakHashMap<View, CallbackHolder> callbackHashMap = new WeakHashMap<>();
    /* access modifiers changed from: private */
    public final float density;
    /* access modifiers changed from: private */
    public final DuiCallback duiCallback;

    public class CallbackHolder {
        private static final String ON_ANIMATION_END = "onAnimationEnd";
        private static final String ON_ANIMATION_START = "onAnimationStart";
        private static final String ON_ANIMATION_UPDATE = "onAnimationUpdate";
        private String onEnd;
        private String onStart;
        private String onUpdate;

        public CallbackHolder() {
        }

        public String getOnEnd() {
            return this.onEnd;
        }

        public String getOnStart() {
            return this.onStart;
        }

        public String getOnUpdate() {
            return this.onUpdate;
        }

        public void updateCallbacks(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.onEnd = AnimationHolder.this.getString(jSONObject, ON_ANIMATION_END, this.onEnd);
                this.onStart = AnimationHolder.this.getString(jSONObject, ON_ANIMATION_START, this.onStart);
                this.onUpdate = AnimationHolder.this.getString(jSONObject, ON_ANIMATION_UPDATE, this.onUpdate);
            }
        }
    }

    public class InlineAnimation {
        private static final String DELAY = "delay";
        private static final String DURATION = "duration";
        private static final String FROM_ALPHA = "fromAlpha";
        private static final String FROM_ROTATION = "fromRotation";
        private static final String FROM_ROTATION_X = "fromRotationX";
        private static final String FROM_ROTATION_Y = "fromRotationY";
        private static final String FROM_SCALE_X = "fromScaleX";
        private static final String FROM_SCALE_Y = "fromScaleY";
        private static final String FROM_X = "fromX";
        private static final String FROM_Y = "fromY";
        private static final String INTERPOLATOR = "interpolator";
        private static final String REPEAT_COUNT = "repeatCount";
        private static final String REPEAT_MODE = "repeatMode";
        private static final String TAG = "tag";
        private static final String TO_ALPHA = "toAlpha";
        private static final String TO_ROTATION = "toRotation";
        private static final String TO_ROTATION_X = "toRotationX";
        private static final String TO_ROTATION_Y = "toRotationY";
        private static final String TO_SCALE_X = "toScaleX";
        private static final String TO_SCALE_Y = "toScaleY";
        private static final String TO_X = "toX";
        private static final String TO_Y = "toY";
        private ObjectAnimator animator;
        private ArrayList<PropertyValuesHolder> holders = new ArrayList<>();
        private JSONObject newProperties;
        private JSONObject properties;
        private final WeakReference<View> viewRef;

        public InlineAnimation(JSONObject jSONObject, View view) {
            this.viewRef = new WeakReference<>(view);
            this.properties = jSONObject;
        }

        private void createAnimator() {
            int i;
            if (this.viewRef.get() != null) {
                View view = this.viewRef.get();
                this.holders = new ArrayList<>();
                ObjectAnimator objectAnimator = new ObjectAnimator();
                this.animator = objectAnimator;
                objectAnimator.setTarget(view);
                this.animator.setInterpolator(getInterpolator());
                this.animator.setDuration((long) ((int) AnimationHolder.this.getFloat(this.properties, DURATION, 0.0f, 1.0f)));
                this.animator.setStartDelay((long) ((int) AnimationHolder.this.getFloat(this.properties, DELAY, 0.0f, 1.0f)));
                this.animator.setRepeatCount((int) AnimationHolder.this.getFloat(this.properties, REPEAT_COUNT, 0.0f, 1.0f));
                if (this.properties.has(REPEAT_MODE)) {
                    boolean equals = "reverse".equals(AnimationHolder.this.getString(this.properties, REPEAT_MODE, (String) null));
                    ObjectAnimator objectAnimator2 = this.animator;
                    if (equals) {
                        i = 2;
                    } else {
                        i = 1;
                    }
                    objectAnimator2.setRepeatMode(i);
                }
                createPropertyHolder(View.ALPHA, view.getAlpha(), FROM_ALPHA, TO_ALPHA);
                createPropertyHolder(View.ROTATION, view.getRotation(), FROM_ROTATION, TO_ROTATION);
                createPropertyHolder(View.ROTATION_X, view.getRotationX(), FROM_ROTATION_X, TO_ROTATION_X);
                createPropertyHolder(View.ROTATION_Y, view.getRotationY(), FROM_ROTATION_Y, TO_ROTATION_Y);
                createPropertyHolder(View.SCALE_X, view.getScaleX(), FROM_SCALE_X, TO_SCALE_X);
                createPropertyHolder(View.SCALE_Y, view.getScaleY(), FROM_SCALE_Y, TO_SCALE_Y);
                createPropertyHolder(View.TRANSLATION_X, view.getTranslationX(), FROM_X, TO_X);
                createPropertyHolder(View.TRANSLATION_Y, view.getTranslationY(), FROM_Y, TO_Y);
                PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[this.holders.size()];
                for (int i2 = 0; i2 < this.holders.size(); i2++) {
                    propertyValuesHolderArr[i2] = this.holders.get(i2);
                }
                this.animator.setValues(propertyValuesHolderArr);
            }
        }

        private void createPropertyHolder(Property<View, Float> property, float f, String... strArr) {
            float f2;
            if (AnimationHolder.this.hasOneKeyAtleast(this.properties, strArr)) {
                if (property == View.TRANSLATION_Y || property == View.TRANSLATION_X) {
                    f2 = AnimationHolder.this.density;
                } else {
                    f2 = 1.0f;
                }
                float[] fArr = new float[strArr.length];
                for (int i = 0; i < strArr.length; i++) {
                    fArr[i] = AnimationHolder.this.getFloat(this.properties, strArr[i], f, f2);
                }
                this.holders.add(PropertyValuesHolder.ofFloat(property, fArr));
            }
        }

        private Interpolator getInterpolator() {
            String access$000 = AnimationHolder.this.getString(this.properties, INTERPOLATOR, "linear");
            access$000.getClass();
            char c = 65535;
            switch (access$000.hashCode()) {
                case -1965056864:
                    if (access$000.equals("easeout")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1383205240:
                    if (access$000.equals("bounce")) {
                        c = 1;
                        break;
                    }
                    break;
                case -1310315117:
                    if (access$000.equals("easein")) {
                        c = 2;
                        break;
                    }
                    break;
                case 1360213211:
                    if (access$000.equals("easeinout")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    return new DecelerateInterpolator();
                case 1:
                    return new BounceInterpolator();
                case 2:
                    return new AccelerateInterpolator();
                case 3:
                    return new AccelerateDecelerateInterpolator();
                default:
                    if (!access$000.contains(",")) {
                        return new LinearInterpolator();
                    }
                    String[] split = access$000.split(",");
                    float[] fArr = {0.0f, 0.0f, 0.0f, 0.0f};
                    for (int i = 0; i < split.length; i++) {
                        fArr[i] = Float.parseFloat(split[i]);
                    }
                    return new PathInterpolator(fArr[0], fArr[1], fArr[2], fArr[3]);
            }
        }

        private boolean isSame(JSONObject jSONObject) {
            ArrayList access$100 = AnimationHolder.this.getJSONKeys(this.properties);
            for (String str : AnimationHolder.this.getJSONKeys(jSONObject)) {
                if (!access$100.contains(str) || !AnimationHolder.this.getString(this.properties, str, "").equals(AnimationHolder.this.getString(jSONObject, str, (String) null))) {
                    return false;
                }
                access$100.remove(str);
            }
            if (access$100.size() == 0) {
                return true;
            }
            return false;
        }

        private void resetAnimation() {
            resetProperty(View.ALPHA, 1.0f, FROM_ALPHA, TO_ALPHA);
            resetProperty(View.ROTATION, 0.0f, FROM_ROTATION, TO_ROTATION);
            resetProperty(View.ROTATION_X, 0.0f, FROM_ROTATION_X, TO_ROTATION_X);
            resetProperty(View.ROTATION_Y, 0.0f, FROM_ROTATION_Y, TO_ROTATION_Y);
            resetProperty(View.SCALE_X, 1.0f, FROM_SCALE_X, TO_SCALE_X);
            resetProperty(View.SCALE_Y, 1.0f, FROM_SCALE_Y, TO_SCALE_Y);
            resetProperty(View.TRANSLATION_X, 0.0f, FROM_X, TO_X);
            resetProperty(View.TRANSLATION_Y, 0.0f, FROM_Y, TO_Y);
        }

        private void resetProperty(Property<View, Float> property, float f, String... strArr) {
            if (AnimationHolder.this.hasOneKeyAtleast(this.properties, strArr)) {
                JSONObject jSONObject = this.newProperties;
                if (jSONObject == null || !AnimationHolder.this.hasOneKeyAtleast(jSONObject, strArr)) {
                    property.set(this.viewRef.get(), Float.valueOf(f));
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:3:0x0009, code lost:
            r0 = (in.juspay.hypersdk.mystique.AnimationHolder.CallbackHolder) in.juspay.hypersdk.mystique.AnimationHolder.access$300(r3.this$0).get(r3.viewRef.get());
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void setEventListeners() {
            /*
                r3 = this;
                in.juspay.hypersdk.mystique.AnimationHolder r0 = in.juspay.hypersdk.mystique.AnimationHolder.this
                in.juspay.hypersdk.core.DuiCallback r0 = r0.duiCallback
                if (r0 != 0) goto L_0x0009
                return
            L_0x0009:
                in.juspay.hypersdk.mystique.AnimationHolder r0 = in.juspay.hypersdk.mystique.AnimationHolder.this
                java.util.WeakHashMap r0 = r0.callbackHashMap
                java.lang.ref.WeakReference<android.view.View> r1 = r3.viewRef
                java.lang.Object r1 = r1.get()
                java.lang.Object r0 = r0.get(r1)
                in.juspay.hypersdk.mystique.AnimationHolder$CallbackHolder r0 = (in.juspay.hypersdk.mystique.AnimationHolder.CallbackHolder) r0
                if (r0 == 0) goto L_0x0033
                java.lang.String r1 = r0.getOnEnd()
                if (r1 != 0) goto L_0x0029
                java.lang.String r1 = r0.getOnStart()
                if (r1 == 0) goto L_0x0033
            L_0x0029:
                android.animation.ObjectAnimator r1 = r3.animator
                in.juspay.hypersdk.mystique.AnimationHolder$InlineAnimation$1 r2 = new in.juspay.hypersdk.mystique.AnimationHolder$InlineAnimation$1
                r2.<init>(r0)
                r1.addListener(r2)
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.mystique.AnimationHolder.InlineAnimation.setEventListeners():void");
        }

        public String getName() {
            return AnimationHolder.this.getString(this.properties, "name", "");
        }

        public String getTag() {
            return AnimationHolder.this.getString(this.properties, TAG, "untagged");
        }

        public void remove() {
            stop();
            resetAnimation();
        }

        public void start() {
            createAnimator();
            setEventListeners();
            this.animator.start();
        }

        public void stop() {
            if (this.animator.isRunning()) {
                this.animator.cancel();
            }
        }

        public void update(JSONObject jSONObject, Boolean bool) {
            if (bool.booleanValue() || !isSame(jSONObject)) {
                stop();
                this.newProperties = jSONObject;
                resetAnimation();
                this.newProperties = null;
                this.properties = jSONObject;
                start();
            }
        }
    }

    public AnimationHolder(DuiCallback duiCallback2, float f) {
        this.density = f;
        this.duiCallback = duiCallback2;
    }

    private void assertView(Object obj) {
        if (!(obj instanceof View)) {
            throw new Error("Instance object is not a view");
        }
    }

    /* access modifiers changed from: private */
    public float getFloat(JSONObject jSONObject, String str, float f, float f2) {
        try {
            return (float) (((double) f2) * jSONObject.getDouble(str));
        } catch (JSONException unused) {
            return f;
        }
    }

    /* access modifiers changed from: private */
    public ArrayList<String> getJSONKeys(JSONObject jSONObject) {
        Iterator<String> keys = jSONObject.keys();
        ArrayList<String> arrayList = new ArrayList<>();
        while (keys.hasNext()) {
            arrayList.add(keys.next());
        }
        return arrayList;
    }

    private JSONObject getJSONObject(JSONArray jSONArray, int i) {
        try {
            return jSONArray.getJSONObject(i);
        } catch (JSONException unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public String getString(JSONObject jSONObject, String str, String str2) {
        try {
            return jSONObject.getString(str);
        } catch (JSONException unused) {
            return str2;
        }
    }

    /* access modifiers changed from: private */
    public boolean hasOneKeyAtleast(JSONObject jSONObject, String... strArr) {
        for (String has : strArr) {
            if (jSONObject.has(has)) {
                return true;
            }
        }
        return false;
    }

    private void setupAnimation(View view, JSONArray jSONArray, Boolean bool) {
        InlineAnimation inlineAnimation;
        HashMap hashMap = this.animatorHashMap.get(view);
        if (hashMap == null) {
            hashMap = new HashMap();
            this.animatorHashMap.put(view, hashMap);
        }
        HashMap hashMap2 = new HashMap();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = getJSONObject(jSONArray, i);
            if (jSONObject != null) {
                String string = getString(jSONObject, "name", "");
                if (!hashMap.containsKey(string) || (inlineAnimation = (InlineAnimation) hashMap.get(string)) == null) {
                    startNewAnimation(view, jSONObject, hashMap, string);
                } else {
                    inlineAnimation.update(jSONObject, bool);
                }
                hashMap2.put(string, Boolean.TRUE);
            }
        }
        Iterator it = new ArrayList(hashMap.keySet()).iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!hashMap2.containsKey(str)) {
                InlineAnimation inlineAnimation2 = (InlineAnimation) hashMap.get(str);
                if (inlineAnimation2 != null) {
                    inlineAnimation2.remove();
                }
                hashMap.remove(str);
            }
        }
    }

    private void startNewAnimation(View view, JSONObject jSONObject, HashMap<String, InlineAnimation> hashMap, String str) {
        InlineAnimation inlineAnimation = new InlineAnimation(jSONObject, view);
        inlineAnimation.start();
        hashMap.put(str, inlineAnimation);
    }

    private Boolean toResetAnimation(JSONObject jSONObject) {
        if (!jSONObject.has("resetAnimation")) {
            return Boolean.FALSE;
        }
        try {
            return Boolean.valueOf(jSONObject.getBoolean("resetAnimation"));
        } catch (JSONException unused) {
            return Boolean.FALSE;
        }
    }

    private void updateViewCallbacks(View view, JSONObject jSONObject) {
        CallbackHolder callbackHolder = this.callbackHashMap.get(view);
        if (callbackHolder == null) {
            callbackHolder = new CallbackHolder();
        }
        callbackHolder.updateCallbacks(jSONObject);
        this.callbackHashMap.put(view, callbackHolder);
    }

    public void applyAnimation(Object obj, JSONArray jSONArray, JSONObject jSONObject) {
        if (obj instanceof View) {
            assertView(obj);
            View view = (View) obj;
            updateViewCallbacks(view, jSONObject);
            setupAnimation(view, jSONArray, toResetAnimation(jSONObject));
        }
    }
}
