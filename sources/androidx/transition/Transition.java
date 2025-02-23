package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowId;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;
import androidx.core.view.f;
import androidx.dynamicanimation.animation.DynamicAnimation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.WeakHashMap;

public abstract class Transition implements Cloneable {
    static final boolean DBG = false;
    private static final int[] DEFAULT_MATCH_ORDER = {2, 1, 3, 4};
    private static final Animator[] EMPTY_ANIMATOR_ARRAY = new Animator[0];
    private static final String LOG_TAG = "Transition";
    private static final int MATCH_FIRST = 1;
    public static final int MATCH_ID = 3;
    private static final String MATCH_ID_STR = "id";
    public static final int MATCH_INSTANCE = 1;
    private static final String MATCH_INSTANCE_STR = "instance";
    public static final int MATCH_ITEM_ID = 4;
    private static final String MATCH_ITEM_ID_STR = "itemId";
    private static final int MATCH_LAST = 4;
    public static final int MATCH_NAME = 2;
    private static final String MATCH_NAME_STR = "name";
    private static final PathMotion STRAIGHT_PATH_MOTION = new a();
    private static ThreadLocal<ArrayMap<Animator, d>> sRunningAnimators = new ThreadLocal<>();
    private Animator[] mAnimatorCache;
    ArrayList<Animator> mAnimators;
    boolean mCanRemoveViews;
    /* access modifiers changed from: private */
    public Transition mCloneParent;
    ArrayList<Animator> mCurrentAnimators;
    long mDuration;
    private TransitionValuesMaps mEndValues;
    private ArrayList<TransitionValues> mEndValuesList;
    boolean mEnded;
    private EpicenterCallback mEpicenterCallback;
    private TimeInterpolator mInterpolator;
    private ArrayList<TransitionListener> mListeners;
    private TransitionListener[] mListenersCache;
    private int[] mMatchOrder;
    private String mName;
    private ArrayMap<String, String> mNameOverrides;
    int mNumInstances;
    TransitionSet mParent;
    private PathMotion mPathMotion;
    private boolean mPaused;
    TransitionPropagation mPropagation;
    SeekController mSeekController;
    long mSeekOffsetInParent;
    private long mStartDelay;
    private TransitionValuesMaps mStartValues;
    private ArrayList<TransitionValues> mStartValuesList;
    private ArrayList<View> mTargetChildExcludes;
    private ArrayList<View> mTargetExcludes;
    private ArrayList<Integer> mTargetIdChildExcludes;
    private ArrayList<Integer> mTargetIdExcludes;
    ArrayList<Integer> mTargetIds;
    private ArrayList<String> mTargetNameExcludes;
    private ArrayList<String> mTargetNames;
    private ArrayList<Class<?>> mTargetTypeChildExcludes;
    private ArrayList<Class<?>> mTargetTypeExcludes;
    private ArrayList<Class<?>> mTargetTypes;
    ArrayList<View> mTargets;
    long mTotalDuration;

    public static abstract class EpicenterCallback {
        public abstract Rect a();
    }

    public interface TransitionListener {
        void onTransitionCancel(Transition transition);

        void onTransitionEnd(Transition transition);

        void onTransitionEnd(Transition transition, boolean z) {
            onTransitionEnd(transition);
        }

        void onTransitionPause(Transition transition);

        void onTransitionResume(Transition transition);

        void onTransitionStart(Transition transition);

        void onTransitionStart(Transition transition, boolean z) {
            onTransitionStart(transition);
        }
    }

    public interface TransitionNotification {
        public static final JA a = new JA();

        /* renamed from: a  reason: collision with other field name */
        public static final C0709Uj f2506a = new C0709Uj();

        /* renamed from: a  reason: collision with other field name */
        public static final Z8 f2507a = new Z8(1);

        /* renamed from: a  reason: collision with other field name */
        public static final C1058d f2508a = new C1058d();
        public static final Z8 b = new Z8(2);

        void b(TransitionListener transitionListener, Transition transition, boolean z);
    }

    public class a extends PathMotion {
        public final Path getPath(float f, float f2, float f3, float f4) {
            Path path = new Path();
            path.moveTo(f, f2);
            path.lineTo(f3, f4);
            return path;
        }
    }

    public class b extends AnimatorListenerAdapter {
        public final /* synthetic */ ArrayMap a;

        public b(ArrayMap arrayMap) {
            this.a = arrayMap;
        }

        public final void onAnimationEnd(Animator animator) {
            this.a.remove(animator);
            Transition.this.mCurrentAnimators.remove(animator);
        }

        public final void onAnimationStart(Animator animator) {
            Transition.this.mCurrentAnimators.add(animator);
        }
    }

    public class c extends AnimatorListenerAdapter {
        public c() {
        }

        public final void onAnimationEnd(Animator animator) {
            Transition.this.end();
            animator.removeListener(this);
        }
    }

    public static class d {
        public final Animator a;

        /* renamed from: a  reason: collision with other field name */
        public final View f2510a;

        /* renamed from: a  reason: collision with other field name */
        public final WindowId f2511a;

        /* renamed from: a  reason: collision with other field name */
        public final Transition f2512a;

        /* renamed from: a  reason: collision with other field name */
        public final TransitionValues f2513a;

        /* renamed from: a  reason: collision with other field name */
        public final String f2514a;

        public d(View view, String str, Transition transition, WindowId windowId, TransitionValues transitionValues, Animator animator) {
            this.f2510a = view;
            this.f2514a = str;
            this.f2513a = transitionValues;
            this.f2511a = windowId;
            this.f2512a = transition;
            this.a = animator;
        }
    }

    public static class e {
        public static ArrayList a(Object obj, ArrayList arrayList) {
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            if (!arrayList.contains(obj)) {
                arrayList.add(obj);
            }
            return arrayList;
        }

        public static ArrayList b(Object obj, ArrayList arrayList) {
            if (arrayList == null) {
                return arrayList;
            }
            arrayList.remove(obj);
            if (arrayList.isEmpty()) {
                return null;
            }
            return arrayList;
        }
    }

    public static class f {
        public static long a(Animator animator) {
            return animator.getTotalDuration();
        }

        public static void b(Animator animator, long j) {
            ((AnimatorSet) animator).setCurrentPlayTime(j);
        }
    }

    public Transition() {
        this.mName = getClass().getName();
        this.mStartDelay = -1;
        this.mDuration = -1;
        this.mInterpolator = null;
        this.mTargetIds = new ArrayList<>();
        this.mTargets = new ArrayList<>();
        this.mTargetNames = null;
        this.mTargetTypes = null;
        this.mTargetIdExcludes = null;
        this.mTargetExcludes = null;
        this.mTargetTypeExcludes = null;
        this.mTargetNameExcludes = null;
        this.mTargetIdChildExcludes = null;
        this.mTargetChildExcludes = null;
        this.mTargetTypeChildExcludes = null;
        this.mStartValues = new TransitionValuesMaps();
        this.mEndValues = new TransitionValuesMaps();
        this.mParent = null;
        this.mMatchOrder = DEFAULT_MATCH_ORDER;
        this.mCanRemoveViews = false;
        this.mCurrentAnimators = new ArrayList<>();
        this.mAnimatorCache = EMPTY_ANIMATOR_ARRAY;
        this.mNumInstances = 0;
        this.mPaused = false;
        this.mEnded = false;
        this.mCloneParent = null;
        this.mListeners = null;
        this.mAnimators = new ArrayList<>();
        this.mPathMotion = STRAIGHT_PATH_MOTION;
    }

    private void addUnmatched(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2) {
        for (int i = 0; i < arrayMap.f1328c; i++) {
            TransitionValues j = arrayMap.j(i);
            if (isValidTarget(j.a)) {
                this.mStartValuesList.add(j);
                this.mEndValuesList.add((Object) null);
            }
        }
        for (int i2 = 0; i2 < arrayMap2.f1328c; i2++) {
            TransitionValues j2 = arrayMap2.j(i2);
            if (isValidTarget(j2.a)) {
                this.mEndValuesList.add(j2);
                this.mStartValuesList.add((Object) null);
            }
        }
    }

    private static void addViewValues(TransitionValuesMaps transitionValuesMaps, View view, TransitionValues transitionValues) {
        transitionValuesMaps.f2518a.put(view, transitionValues);
        int id = view.getId();
        if (id >= 0) {
            SparseArray<View> sparseArray = transitionValuesMaps.a;
            if (sparseArray.indexOfKey(id) >= 0) {
                sparseArray.put(id, (Object) null);
            } else {
                sparseArray.put(id, view);
            }
        }
        WeakHashMap<View, GC> weakHashMap = androidx.core.view.f.f1839a;
        String k = f.d.k(view);
        if (k != null) {
            ArrayMap<String, View> arrayMap = transitionValuesMaps.b;
            if (arrayMap.containsKey(k)) {
                arrayMap.put(k, null);
            } else {
                arrayMap.put(k, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                LongSparseArray<View> longSparseArray = transitionValuesMaps.f2519a;
                if (longSparseArray.f1324a) {
                    longSparseArray.c();
                }
                if (C1354qp.k(longSparseArray.c, itemIdAtPosition, longSparseArray.f1325a) >= 0) {
                    View view2 = (View) longSparseArray.d(itemIdAtPosition, (Long) null);
                    if (view2 != null) {
                        view2.setHasTransientState(false);
                        longSparseArray.e(itemIdAtPosition, null);
                        return;
                    }
                    return;
                }
                view.setHasTransientState(true);
                longSparseArray.e(itemIdAtPosition, view);
            }
        }
    }

    private static boolean alreadyContains(int[] iArr, int i) {
        int i2 = iArr[i];
        for (int i3 = 0; i3 < i; i3++) {
            if (iArr[i3] == i2) {
                return true;
            }
        }
        return false;
    }

    private void captureHierarchy(View view, boolean z) {
        if (view != null) {
            int id = view.getId();
            ArrayList<Integer> arrayList = this.mTargetIdExcludes;
            if (arrayList == null || !arrayList.contains(Integer.valueOf(id))) {
                ArrayList<View> arrayList2 = this.mTargetExcludes;
                if (arrayList2 == null || !arrayList2.contains(view)) {
                    ArrayList<Class<?>> arrayList3 = this.mTargetTypeExcludes;
                    if (arrayList3 != null) {
                        int size = arrayList3.size();
                        int i = 0;
                        while (i < size) {
                            if (!this.mTargetTypeExcludes.get(i).isInstance(view)) {
                                i++;
                            } else {
                                return;
                            }
                        }
                    }
                    if (view.getParent() instanceof ViewGroup) {
                        TransitionValues transitionValues = new TransitionValues(view);
                        if (z) {
                            captureStartValues(transitionValues);
                        } else {
                            captureEndValues(transitionValues);
                        }
                        transitionValues.f2516a.add(this);
                        capturePropagationValues(transitionValues);
                        if (z) {
                            addViewValues(this.mStartValues, view, transitionValues);
                        } else {
                            addViewValues(this.mEndValues, view, transitionValues);
                        }
                    }
                    if (view instanceof ViewGroup) {
                        ArrayList<Integer> arrayList4 = this.mTargetIdChildExcludes;
                        if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id))) {
                            ArrayList<View> arrayList5 = this.mTargetChildExcludes;
                            if (arrayList5 == null || !arrayList5.contains(view)) {
                                ArrayList<Class<?>> arrayList6 = this.mTargetTypeChildExcludes;
                                if (arrayList6 != null) {
                                    int size2 = arrayList6.size();
                                    int i2 = 0;
                                    while (i2 < size2) {
                                        if (!this.mTargetTypeChildExcludes.get(i2).isInstance(view)) {
                                            i2++;
                                        } else {
                                            return;
                                        }
                                    }
                                }
                                ViewGroup viewGroup = (ViewGroup) view;
                                for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                                    captureHierarchy(viewGroup.getChildAt(i3), z);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private ArrayList<Integer> excludeId(ArrayList<Integer> arrayList, int i, boolean z) {
        if (i <= 0) {
            return arrayList;
        }
        if (z) {
            return e.a(Integer.valueOf(i), arrayList);
        }
        return e.b(Integer.valueOf(i), arrayList);
    }

    private static <T> ArrayList<T> excludeObject(ArrayList<T> arrayList, T t, boolean z) {
        if (t == null) {
            return arrayList;
        }
        if (z) {
            return e.a(t, arrayList);
        }
        return e.b(t, arrayList);
    }

    private ArrayList<Class<?>> excludeType(ArrayList<Class<?>> arrayList, Class<?> cls, boolean z) {
        if (cls == null) {
            return arrayList;
        }
        if (z) {
            return e.a(cls, arrayList);
        }
        return e.b(cls, arrayList);
    }

    private ArrayList<View> excludeView(ArrayList<View> arrayList, View view, boolean z) {
        if (view == null) {
            return arrayList;
        }
        if (z) {
            return e.a(view, arrayList);
        }
        return e.b(view, arrayList);
    }

    private static ArrayMap<Animator, d> getRunningAnimators() {
        ArrayMap<Animator, d> arrayMap = sRunningAnimators.get();
        if (arrayMap != null) {
            return arrayMap;
        }
        ArrayMap<Animator, d> arrayMap2 = new ArrayMap<>();
        sRunningAnimators.set(arrayMap2);
        return arrayMap2;
    }

    private static boolean isValidMatch(int i) {
        if (i < 1 || i > 4) {
            return false;
        }
        return true;
    }

    private static boolean isValueChanged(TransitionValues transitionValues, TransitionValues transitionValues2, String str) {
        Object obj = transitionValues.f2517a.get(str);
        Object obj2 = transitionValues2.f2517a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return !obj.equals(obj2);
    }

    private void matchIds(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2, SparseArray<View> sparseArray, SparseArray<View> sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            View valueAt = sparseArray.valueAt(i);
            if (valueAt != null && isValidTarget(valueAt) && (view = sparseArray2.get(sparseArray.keyAt(i))) != null && isValidTarget(view)) {
                TransitionValues orDefault = arrayMap.getOrDefault(valueAt, null);
                TransitionValues orDefault2 = arrayMap2.getOrDefault(view, null);
                if (!(orDefault == null || orDefault2 == null)) {
                    this.mStartValuesList.add(orDefault);
                    this.mEndValuesList.add(orDefault2);
                    arrayMap.remove(valueAt);
                    arrayMap2.remove(view);
                }
            }
        }
    }

    private void matchInstances(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2) {
        TransitionValues remove;
        for (int i = arrayMap.f1328c - 1; i >= 0; i--) {
            View h = arrayMap.h(i);
            if (h != null && isValidTarget(h) && (remove = arrayMap2.remove(h)) != null && isValidTarget(remove.a)) {
                this.mStartValuesList.add(arrayMap.i(i));
                this.mEndValuesList.add(remove);
            }
        }
    }

    private void matchItemIds(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2, LongSparseArray<View> longSparseArray, LongSparseArray<View> longSparseArray2) {
        int f2 = longSparseArray.f();
        for (int i = 0; i < f2; i++) {
            View g = longSparseArray.g(i);
            if (g != null && isValidTarget(g)) {
                if (longSparseArray.f1324a) {
                    longSparseArray.c();
                }
                View view = (View) longSparseArray2.d(longSparseArray.f1325a[i], (Long) null);
                if (view != null && isValidTarget(view)) {
                    TransitionValues orDefault = arrayMap.getOrDefault(g, null);
                    TransitionValues orDefault2 = arrayMap2.getOrDefault(view, null);
                    if (!(orDefault == null || orDefault2 == null)) {
                        this.mStartValuesList.add(orDefault);
                        this.mEndValuesList.add(orDefault2);
                        arrayMap.remove(g);
                        arrayMap2.remove(view);
                    }
                }
            }
        }
    }

    private void matchNames(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2, ArrayMap<String, View> arrayMap3, ArrayMap<String, View> arrayMap4) {
        View orDefault;
        int i = arrayMap3.f1328c;
        for (int i2 = 0; i2 < i; i2++) {
            View j = arrayMap3.j(i2);
            if (j != null && isValidTarget(j) && (orDefault = arrayMap4.getOrDefault(arrayMap3.h(i2), null)) != null && isValidTarget(orDefault)) {
                TransitionValues orDefault2 = arrayMap.getOrDefault(j, null);
                TransitionValues orDefault3 = arrayMap2.getOrDefault(orDefault, null);
                if (!(orDefault2 == null || orDefault3 == null)) {
                    this.mStartValuesList.add(orDefault2);
                    this.mEndValuesList.add(orDefault3);
                    arrayMap.remove(j);
                    arrayMap2.remove(orDefault);
                }
            }
        }
    }

    private void matchStartAndEnd(TransitionValuesMaps transitionValuesMaps, TransitionValuesMaps transitionValuesMaps2) {
        ArrayMap arrayMap = new ArrayMap((ArrayMap) transitionValuesMaps.f2518a);
        ArrayMap arrayMap2 = new ArrayMap((ArrayMap) transitionValuesMaps2.f2518a);
        int i = 0;
        while (true) {
            int[] iArr = this.mMatchOrder;
            if (i < iArr.length) {
                int i2 = iArr[i];
                if (i2 == 1) {
                    matchInstances(arrayMap, arrayMap2);
                } else if (i2 == 2) {
                    matchNames(arrayMap, arrayMap2, transitionValuesMaps.b, transitionValuesMaps2.b);
                } else if (i2 == 3) {
                    matchIds(arrayMap, arrayMap2, transitionValuesMaps.a, transitionValuesMaps2.a);
                } else if (i2 == 4) {
                    matchItemIds(arrayMap, arrayMap2, transitionValuesMaps.f2519a, transitionValuesMaps2.f2519a);
                }
                i++;
            } else {
                addUnmatched(arrayMap, arrayMap2);
                return;
            }
        }
    }

    private void notifyFromTransition(Transition transition, TransitionNotification transitionNotification, boolean z) {
        Transition transition2 = this.mCloneParent;
        if (transition2 != null) {
            transition2.notifyFromTransition(transition, transitionNotification, z);
        }
        ArrayList<TransitionListener> arrayList = this.mListeners;
        if (arrayList != null && !arrayList.isEmpty()) {
            int size = this.mListeners.size();
            TransitionListener[] transitionListenerArr = this.mListenersCache;
            if (transitionListenerArr == null) {
                transitionListenerArr = new TransitionListener[size];
            }
            this.mListenersCache = null;
            TransitionListener[] transitionListenerArr2 = (TransitionListener[]) this.mListeners.toArray(transitionListenerArr);
            for (int i = 0; i < size; i++) {
                transitionNotification.b(transitionListenerArr2[i], transition, z);
                transitionListenerArr2[i] = null;
            }
            this.mListenersCache = transitionListenerArr2;
        }
    }

    private static int[] parseMatchOrder(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        int[] iArr = new int[stringTokenizer.countTokens()];
        int i = 0;
        while (stringTokenizer.hasMoreTokens()) {
            String trim = stringTokenizer.nextToken().trim();
            if ("id".equalsIgnoreCase(trim)) {
                iArr[i] = 3;
            } else if (MATCH_INSTANCE_STR.equalsIgnoreCase(trim)) {
                iArr[i] = 1;
            } else if ("name".equalsIgnoreCase(trim)) {
                iArr[i] = 2;
            } else if (MATCH_ITEM_ID_STR.equalsIgnoreCase(trim)) {
                iArr[i] = 4;
            } else if (trim.isEmpty()) {
                int[] iArr2 = new int[(iArr.length - 1)];
                System.arraycopy(iArr, 0, iArr2, 0, i);
                i--;
                iArr = iArr2;
            } else {
                throw new InflateException(lf.j("Unknown match type in matchOrder: '", trim, "'"));
            }
            i++;
        }
        return iArr;
    }

    private void runAnimator(Animator animator, ArrayMap<Animator, d> arrayMap) {
        if (animator != null) {
            animator.addListener(new b(arrayMap));
            animate(animator);
        }
    }

    public Transition addListener(TransitionListener transitionListener) {
        if (this.mListeners == null) {
            this.mListeners = new ArrayList<>();
        }
        this.mListeners.add(transitionListener);
        return this;
    }

    public Transition addTarget(View view) {
        this.mTargets.add(view);
        return this;
    }

    public void animate(Animator animator) {
        if (animator == null) {
            end();
            return;
        }
        if (getDuration() >= 0) {
            animator.setDuration(getDuration());
        }
        if (getStartDelay() >= 0) {
            animator.setStartDelay(animator.getStartDelay() + getStartDelay());
        }
        if (getInterpolator() != null) {
            animator.setInterpolator(getInterpolator());
        }
        animator.addListener(new c());
        animator.start();
    }

    public void cancel() {
        int size = this.mCurrentAnimators.size();
        Animator[] animatorArr = (Animator[]) this.mCurrentAnimators.toArray(this.mAnimatorCache);
        this.mAnimatorCache = EMPTY_ANIMATOR_ARRAY;
        while (true) {
            size--;
            if (size >= 0) {
                Animator animator = animatorArr[size];
                animatorArr[size] = null;
                animator.cancel();
            } else {
                this.mAnimatorCache = animatorArr;
                notifyListeners(TransitionNotification.f2506a, false);
                return;
            }
        }
    }

    public abstract void captureEndValues(TransitionValues transitionValues);

    public void capturePropagationValues(TransitionValues transitionValues) {
        if (this.mPropagation != null && !transitionValues.f2517a.isEmpty()) {
            this.mPropagation.b();
            String[] strArr = jD.a;
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= 2) {
                    z = true;
                    break;
                } else if (!transitionValues.f2517a.containsKey(strArr[i])) {
                    break;
                } else {
                    i++;
                }
            }
            if (!z) {
                this.mPropagation.a(transitionValues);
            }
        }
    }

    public abstract void captureStartValues(TransitionValues transitionValues);

    public void captureValues(ViewGroup viewGroup, boolean z) {
        ArrayMap<String, String> arrayMap;
        ArrayList<String> arrayList;
        ArrayList<Class<?>> arrayList2;
        clearValues(z);
        if ((this.mTargetIds.size() > 0 || this.mTargets.size() > 0) && (((arrayList = this.mTargetNames) == null || arrayList.isEmpty()) && ((arrayList2 = this.mTargetTypes) == null || arrayList2.isEmpty()))) {
            for (int i = 0; i < this.mTargetIds.size(); i++) {
                View findViewById = viewGroup.findViewById(this.mTargetIds.get(i).intValue());
                if (findViewById != null) {
                    TransitionValues transitionValues = new TransitionValues(findViewById);
                    if (z) {
                        captureStartValues(transitionValues);
                    } else {
                        captureEndValues(transitionValues);
                    }
                    transitionValues.f2516a.add(this);
                    capturePropagationValues(transitionValues);
                    if (z) {
                        addViewValues(this.mStartValues, findViewById, transitionValues);
                    } else {
                        addViewValues(this.mEndValues, findViewById, transitionValues);
                    }
                }
            }
            for (int i2 = 0; i2 < this.mTargets.size(); i2++) {
                View view = this.mTargets.get(i2);
                TransitionValues transitionValues2 = new TransitionValues(view);
                if (z) {
                    captureStartValues(transitionValues2);
                } else {
                    captureEndValues(transitionValues2);
                }
                transitionValues2.f2516a.add(this);
                capturePropagationValues(transitionValues2);
                if (z) {
                    addViewValues(this.mStartValues, view, transitionValues2);
                } else {
                    addViewValues(this.mEndValues, view, transitionValues2);
                }
            }
        } else {
            captureHierarchy(viewGroup, z);
        }
        if (!z && (arrayMap = this.mNameOverrides) != null) {
            int i3 = arrayMap.f1328c;
            ArrayList arrayList3 = new ArrayList(i3);
            for (int i4 = 0; i4 < i3; i4++) {
                arrayList3.add(this.mStartValues.b.remove(this.mNameOverrides.h(i4)));
            }
            for (int i5 = 0; i5 < i3; i5++) {
                View view2 = (View) arrayList3.get(i5);
                if (view2 != null) {
                    this.mStartValues.b.put(this.mNameOverrides.j(i5), view2);
                }
            }
        }
    }

    public void clearValues(boolean z) {
        if (z) {
            this.mStartValues.f2518a.clear();
            this.mStartValues.a.clear();
            this.mStartValues.f2519a.a();
            return;
        }
        this.mEndValues.f2518a.clear();
        this.mEndValues.a.clear();
        this.mEndValues.f2519a.a();
    }

    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return null;
    }

    public void createAnimators(ViewGroup viewGroup, TransitionValuesMaps transitionValuesMaps, TransitionValuesMaps transitionValuesMaps2, ArrayList<TransitionValues> arrayList, ArrayList<TransitionValues> arrayList2) {
        boolean z;
        int i;
        int i2;
        boolean z2;
        AnimatorSet createAnimator;
        View view;
        TransitionValues transitionValues;
        Animator animator;
        ViewGroup viewGroup2 = viewGroup;
        ArrayMap<Animator, d> runningAnimators = getRunningAnimators();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        if (getRootTransition().mSeekController != null) {
            z = true;
        } else {
            z = false;
        }
        long j = Long.MAX_VALUE;
        int i3 = 0;
        while (i3 < size) {
            TransitionValues transitionValues2 = arrayList.get(i3);
            TransitionValues transitionValues3 = arrayList2.get(i3);
            if (transitionValues2 != null && !transitionValues2.f2516a.contains(this)) {
                transitionValues2 = null;
            }
            if (transitionValues3 != null && !transitionValues3.f2516a.contains(this)) {
                transitionValues3 = null;
            }
            if (!(transitionValues2 == null && transitionValues3 == null)) {
                if (transitionValues2 == null || transitionValues3 == null || isTransitionRequired(transitionValues2, transitionValues3)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2 && (createAnimator = createAnimator(viewGroup2, transitionValues2, transitionValues3)) != null) {
                    if (transitionValues3 != null) {
                        view = transitionValues3.a;
                        String[] transitionProperties = getTransitionProperties();
                        if (transitionProperties != null && transitionProperties.length > 0) {
                            transitionValues = new TransitionValues(view);
                            i2 = size;
                            TransitionValues orDefault = transitionValuesMaps2.f2518a.getOrDefault(view, null);
                            Animator animator2 = createAnimator;
                            if (orDefault != null) {
                                int i4 = 0;
                                while (i4 < transitionProperties.length) {
                                    HashMap hashMap = transitionValues.f2517a;
                                    int i5 = i3;
                                    String str = transitionProperties[i4];
                                    hashMap.put(str, orDefault.f2517a.get(str));
                                    i4++;
                                    i3 = i5;
                                    transitionProperties = transitionProperties;
                                }
                            }
                            i = i3;
                            int i6 = runningAnimators.f1328c;
                            int i7 = 0;
                            while (true) {
                                if (i7 >= i6) {
                                    animator = animator2;
                                    break;
                                }
                                d orDefault2 = runningAnimators.getOrDefault(runningAnimators.h(i7), null);
                                if (orDefault2.f2513a != null && orDefault2.f2510a == view && orDefault2.f2514a.equals(getName()) && orDefault2.f2513a.equals(transitionValues)) {
                                    animator = null;
                                    break;
                                }
                                i7++;
                            }
                        } else {
                            i2 = size;
                            i = i3;
                            animator = createAnimator;
                            transitionValues = null;
                        }
                        createAnimator = animator;
                    } else {
                        i2 = size;
                        Animator animator3 = createAnimator;
                        i = i3;
                        view = transitionValues2.a;
                        transitionValues = null;
                    }
                    if (createAnimator != null) {
                        TransitionPropagation transitionPropagation = this.mPropagation;
                        if (transitionPropagation != null) {
                            long c2 = transitionPropagation.c(viewGroup2, this, transitionValues2, transitionValues3);
                            sparseIntArray.put(this.mAnimators.size(), (int) c2);
                            j = Math.min(c2, j);
                        }
                        long j2 = j;
                        d dVar = new d(view, getName(), this, viewGroup.getWindowId(), transitionValues, createAnimator);
                        if (z) {
                            AnimatorSet animatorSet = new AnimatorSet();
                            animatorSet.play(createAnimator);
                            createAnimator = animatorSet;
                        }
                        runningAnimators.put(createAnimator, dVar);
                        this.mAnimators.add(createAnimator);
                        j = j2;
                    }
                    i3 = i + 1;
                    size = i2;
                }
            }
            i2 = size;
            i = i3;
            i3 = i + 1;
            size = i2;
        }
        if (sparseIntArray.size() != 0) {
            for (int i8 = 0; i8 < sparseIntArray.size(); i8++) {
                d orDefault3 = runningAnimators.getOrDefault(this.mAnimators.get(sparseIntArray.keyAt(i8)), null);
                long startDelay = orDefault3.a.getStartDelay();
                orDefault3.a.setStartDelay(startDelay + (((long) sparseIntArray.valueAt(i8)) - j));
            }
        }
    }

    public TransitionSeekController createSeekController() {
        SeekController seekController = new SeekController();
        this.mSeekController = seekController;
        addListener(seekController);
        return this.mSeekController;
    }

    public void end() {
        int i = this.mNumInstances - 1;
        this.mNumInstances = i;
        if (i == 0) {
            notifyListeners(TransitionNotification.f2508a, false);
            for (int i2 = 0; i2 < this.mStartValues.f2519a.f(); i2++) {
                View g = this.mStartValues.f2519a.g(i2);
                if (g != null) {
                    g.setHasTransientState(false);
                }
            }
            for (int i3 = 0; i3 < this.mEndValues.f2519a.f(); i3++) {
                View g2 = this.mEndValues.f2519a.g(i3);
                if (g2 != null) {
                    g2.setHasTransientState(false);
                }
            }
            this.mEnded = true;
        }
    }

    public Transition excludeChildren(View view, boolean z) {
        this.mTargetChildExcludes = excludeView(this.mTargetChildExcludes, view, z);
        return this;
    }

    public Transition excludeTarget(View view, boolean z) {
        this.mTargetExcludes = excludeView(this.mTargetExcludes, view, z);
        return this;
    }

    public void forceToEnd(ViewGroup viewGroup) {
        ArrayMap<Animator, d> runningAnimators = getRunningAnimators();
        int i = runningAnimators.f1328c;
        if (viewGroup != null && i != 0) {
            WindowId windowId = viewGroup.getWindowId();
            ArrayMap arrayMap = new ArrayMap((ArrayMap) runningAnimators);
            runningAnimators.clear();
            while (true) {
                i--;
                if (i >= 0) {
                    d dVar = (d) arrayMap.j(i);
                    if (dVar.f2510a != null && windowId.equals(dVar.f2511a)) {
                        ((Animator) arrayMap.h(i)).end();
                    }
                } else {
                    return;
                }
            }
        }
    }

    public long getDuration() {
        return this.mDuration;
    }

    public Rect getEpicenter() {
        EpicenterCallback epicenterCallback = this.mEpicenterCallback;
        if (epicenterCallback == null) {
            return null;
        }
        return epicenterCallback.a();
    }

    public EpicenterCallback getEpicenterCallback() {
        return this.mEpicenterCallback;
    }

    public TimeInterpolator getInterpolator() {
        return this.mInterpolator;
    }

    public TransitionValues getMatchedTransitionValues(View view, boolean z) {
        ArrayList<TransitionValues> arrayList;
        ArrayList<TransitionValues> arrayList2;
        TransitionSet transitionSet = this.mParent;
        if (transitionSet != null) {
            return transitionSet.getMatchedTransitionValues(view, z);
        }
        if (z) {
            arrayList = this.mStartValuesList;
        } else {
            arrayList = this.mEndValuesList;
        }
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            }
            TransitionValues transitionValues = arrayList.get(i);
            if (transitionValues == null) {
                return null;
            }
            if (transitionValues.a == view) {
                break;
            }
            i++;
        }
        if (i < 0) {
            return null;
        }
        if (z) {
            arrayList2 = this.mEndValuesList;
        } else {
            arrayList2 = this.mStartValuesList;
        }
        return arrayList2.get(i);
    }

    public String getName() {
        return this.mName;
    }

    public PathMotion getPathMotion() {
        return this.mPathMotion;
    }

    public TransitionPropagation getPropagation() {
        return this.mPropagation;
    }

    public final Transition getRootTransition() {
        TransitionSet transitionSet = this.mParent;
        if (transitionSet != null) {
            return transitionSet.getRootTransition();
        }
        return this;
    }

    public long getStartDelay() {
        return this.mStartDelay;
    }

    public List<Integer> getTargetIds() {
        return this.mTargetIds;
    }

    public List<String> getTargetNames() {
        return this.mTargetNames;
    }

    public List<Class<?>> getTargetTypes() {
        return this.mTargetTypes;
    }

    public List<View> getTargets() {
        return this.mTargets;
    }

    public final long getTotalDurationMillis() {
        return this.mTotalDuration;
    }

    public String[] getTransitionProperties() {
        return null;
    }

    public TransitionValues getTransitionValues(View view, boolean z) {
        TransitionValuesMaps transitionValuesMaps;
        TransitionSet transitionSet = this.mParent;
        if (transitionSet != null) {
            return transitionSet.getTransitionValues(view, z);
        }
        if (z) {
            transitionValuesMaps = this.mStartValues;
        } else {
            transitionValuesMaps = this.mEndValues;
        }
        return transitionValuesMaps.f2518a.getOrDefault(view, null);
    }

    public boolean hasAnimators() {
        return !this.mCurrentAnimators.isEmpty();
    }

    public boolean isSeekingSupported() {
        return false;
    }

    public boolean isTransitionRequired(TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null || transitionValues2 == null) {
            return false;
        }
        String[] transitionProperties = getTransitionProperties();
        if (transitionProperties != null) {
            int length = transitionProperties.length;
            int i = 0;
            while (i < length) {
                if (!isValueChanged(transitionValues, transitionValues2, transitionProperties[i])) {
                    i++;
                }
            }
            return false;
        }
        for (String isValueChanged : transitionValues.f2517a.keySet()) {
            if (isValueChanged(transitionValues, transitionValues2, isValueChanged)) {
            }
        }
        return false;
        return true;
    }

    public boolean isValidTarget(View view) {
        ArrayList<Class<?>> arrayList;
        ArrayList<String> arrayList2;
        int id = view.getId();
        ArrayList<Integer> arrayList3 = this.mTargetIdExcludes;
        if (arrayList3 != null && arrayList3.contains(Integer.valueOf(id))) {
            return false;
        }
        ArrayList<View> arrayList4 = this.mTargetExcludes;
        if (arrayList4 != null && arrayList4.contains(view)) {
            return false;
        }
        ArrayList<Class<?>> arrayList5 = this.mTargetTypeExcludes;
        if (arrayList5 != null) {
            int size = arrayList5.size();
            for (int i = 0; i < size; i++) {
                if (this.mTargetTypeExcludes.get(i).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.mTargetNameExcludes != null) {
            WeakHashMap<View, GC> weakHashMap = androidx.core.view.f.f1839a;
            if (f.d.k(view) != null && this.mTargetNameExcludes.contains(f.d.k(view))) {
                return false;
            }
        }
        if ((this.mTargetIds.size() == 0 && this.mTargets.size() == 0 && (((arrayList = this.mTargetTypes) == null || arrayList.isEmpty()) && ((arrayList2 = this.mTargetNames) == null || arrayList2.isEmpty()))) || this.mTargetIds.contains(Integer.valueOf(id)) || this.mTargets.contains(view)) {
            return true;
        }
        ArrayList<String> arrayList6 = this.mTargetNames;
        if (arrayList6 != null) {
            WeakHashMap<View, GC> weakHashMap2 = androidx.core.view.f.f1839a;
            if (arrayList6.contains(f.d.k(view))) {
                return true;
            }
        }
        if (this.mTargetTypes != null) {
            for (int i2 = 0; i2 < this.mTargetTypes.size(); i2++) {
                if (this.mTargetTypes.get(i2).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void notifyListeners(TransitionNotification transitionNotification, boolean z) {
        notifyFromTransition(this, transitionNotification, z);
    }

    public void pause(View view) {
        if (!this.mEnded) {
            int size = this.mCurrentAnimators.size();
            Animator[] animatorArr = (Animator[]) this.mCurrentAnimators.toArray(this.mAnimatorCache);
            this.mAnimatorCache = EMPTY_ANIMATOR_ARRAY;
            for (int i = size - 1; i >= 0; i--) {
                Animator animator = animatorArr[i];
                animatorArr[i] = null;
                animator.pause();
            }
            this.mAnimatorCache = animatorArr;
            notifyListeners(TransitionNotification.a, false);
            this.mPaused = true;
        }
    }

    public void playTransition(ViewGroup viewGroup) {
        d orDefault;
        View view;
        boolean z;
        this.mStartValuesList = new ArrayList<>();
        this.mEndValuesList = new ArrayList<>();
        matchStartAndEnd(this.mStartValues, this.mEndValues);
        ArrayMap<Animator, d> runningAnimators = getRunningAnimators();
        int i = runningAnimators.f1328c;
        WindowId windowId = viewGroup.getWindowId();
        for (int i2 = i - 1; i2 >= 0; i2--) {
            Animator h = runningAnimators.h(i2);
            if (!(h == null || (orDefault = runningAnimators.getOrDefault(h, null)) == null || (view = orDefault.f2510a) == null || !windowId.equals(orDefault.f2511a))) {
                TransitionValues transitionValues = getTransitionValues(view, true);
                TransitionValues matchedTransitionValues = getMatchedTransitionValues(view, true);
                if (transitionValues == null && matchedTransitionValues == null) {
                    matchedTransitionValues = this.mEndValues.f2518a.getOrDefault(view, null);
                }
                Transition transition = orDefault.f2512a;
                if (!(transitionValues == null && matchedTransitionValues == null) && transition.isTransitionRequired(orDefault.f2513a, matchedTransitionValues)) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    if (transition.getRootTransition().mSeekController != null) {
                        h.cancel();
                        transition.mCurrentAnimators.remove(h);
                        runningAnimators.remove(h);
                        if (transition.mCurrentAnimators.size() == 0) {
                            transition.notifyListeners(TransitionNotification.f2506a, false);
                            if (!transition.mEnded) {
                                transition.mEnded = true;
                                transition.notifyListeners(TransitionNotification.f2508a, false);
                            }
                        }
                    } else if (h.isRunning() || h.isStarted()) {
                        h.cancel();
                    } else {
                        runningAnimators.remove(h);
                    }
                }
            }
        }
        createAnimators(viewGroup, this.mStartValues, this.mEndValues, this.mStartValuesList, this.mEndValuesList);
        if (this.mSeekController == null) {
            runAnimators();
        } else if (Build.VERSION.SDK_INT >= 34) {
            prepareAnimatorsForSeeking();
            SeekController seekController = this.mSeekController;
            long j = 0;
            if (Transition.this.getTotalDurationMillis() == 0) {
                j = 1;
            }
            Transition.this.setCurrentPlayTimeMillis(j, seekController.a);
            seekController.a = j;
            this.mSeekController.getClass();
        }
    }

    public void prepareAnimatorsForSeeking() {
        ArrayMap<Animator, d> runningAnimators = getRunningAnimators();
        this.mTotalDuration = 0;
        for (int i = 0; i < this.mAnimators.size(); i++) {
            Animator animator = this.mAnimators.get(i);
            d orDefault = runningAnimators.getOrDefault(animator, null);
            if (!(animator == null || orDefault == null)) {
                int i2 = (getDuration() > 0 ? 1 : (getDuration() == 0 ? 0 : -1));
                Animator animator2 = orDefault.a;
                if (i2 >= 0) {
                    animator2.setDuration(getDuration());
                }
                if (getStartDelay() >= 0) {
                    animator2.setStartDelay(animator2.getStartDelay() + getStartDelay());
                }
                if (getInterpolator() != null) {
                    animator2.setInterpolator(getInterpolator());
                }
                this.mCurrentAnimators.add(animator);
                this.mTotalDuration = Math.max(this.mTotalDuration, f.a(animator));
            }
        }
        this.mAnimators.clear();
    }

    public Transition removeListener(TransitionListener transitionListener) {
        Transition transition;
        ArrayList<TransitionListener> arrayList = this.mListeners;
        if (arrayList == null) {
            return this;
        }
        if (!arrayList.remove(transitionListener) && (transition = this.mCloneParent) != null) {
            transition.removeListener(transitionListener);
        }
        if (this.mListeners.size() == 0) {
            this.mListeners = null;
        }
        return this;
    }

    public Transition removeTarget(View view) {
        this.mTargets.remove(view);
        return this;
    }

    public void resume(View view) {
        if (this.mPaused) {
            if (!this.mEnded) {
                int size = this.mCurrentAnimators.size();
                Animator[] animatorArr = (Animator[]) this.mCurrentAnimators.toArray(this.mAnimatorCache);
                this.mAnimatorCache = EMPTY_ANIMATOR_ARRAY;
                while (true) {
                    size--;
                    if (size < 0) {
                        break;
                    }
                    Animator animator = animatorArr[size];
                    animatorArr[size] = null;
                    animator.resume();
                }
                this.mAnimatorCache = animatorArr;
                notifyListeners(TransitionNotification.b, false);
            }
            this.mPaused = false;
        }
    }

    public void runAnimators() {
        start();
        ArrayMap<Animator, d> runningAnimators = getRunningAnimators();
        Iterator<Animator> it = this.mAnimators.iterator();
        while (it.hasNext()) {
            Animator next = it.next();
            if (runningAnimators.containsKey(next)) {
                start();
                runAnimator(next, runningAnimators);
            }
        }
        this.mAnimators.clear();
        end();
    }

    public void setCanRemoveViews(boolean z) {
        this.mCanRemoveViews = z;
    }

    public void setCurrentPlayTimeMillis(long j, long j2) {
        boolean z;
        long j3 = j;
        long totalDurationMillis = getTotalDurationMillis();
        if (j3 < j2) {
            z = true;
        } else {
            z = false;
        }
        int i = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        if ((i < 0 && j3 >= 0) || (j2 > totalDurationMillis && j3 <= totalDurationMillis)) {
            this.mEnded = false;
            notifyListeners(TransitionNotification.f2507a, z);
        }
        int size = this.mCurrentAnimators.size();
        Animator[] animatorArr = (Animator[]) this.mCurrentAnimators.toArray(this.mAnimatorCache);
        this.mAnimatorCache = EMPTY_ANIMATOR_ARRAY;
        for (int i2 = 0; i2 < size; i2++) {
            Animator animator = animatorArr[i2];
            animatorArr[i2] = null;
            f.b(animator, Math.min(Math.max(0, j3), f.a(animator)));
        }
        this.mAnimatorCache = animatorArr;
        int i3 = (j3 > totalDurationMillis ? 1 : (j3 == totalDurationMillis ? 0 : -1));
        if ((i3 > 0 && j2 <= totalDurationMillis) || (j3 < 0 && i >= 0)) {
            if (i3 > 0) {
                this.mEnded = true;
            }
            notifyListeners(TransitionNotification.f2508a, z);
        }
    }

    public Transition setDuration(long j) {
        this.mDuration = j;
        return this;
    }

    public void setEpicenterCallback(EpicenterCallback epicenterCallback) {
        this.mEpicenterCallback = epicenterCallback;
    }

    public Transition setInterpolator(TimeInterpolator timeInterpolator) {
        this.mInterpolator = timeInterpolator;
        return this;
    }

    public void setMatchOrder(int... iArr) {
        if (iArr == null || iArr.length == 0) {
            this.mMatchOrder = DEFAULT_MATCH_ORDER;
            return;
        }
        int i = 0;
        while (i < iArr.length) {
            if (!isValidMatch(iArr[i])) {
                throw new IllegalArgumentException("matches contains invalid value");
            } else if (!alreadyContains(iArr, i)) {
                i++;
            } else {
                throw new IllegalArgumentException("matches contains a duplicate value");
            }
        }
        this.mMatchOrder = (int[]) iArr.clone();
    }

    public void setPathMotion(PathMotion pathMotion) {
        if (pathMotion == null) {
            this.mPathMotion = STRAIGHT_PATH_MOTION;
        } else {
            this.mPathMotion = pathMotion;
        }
    }

    public void setPropagation(TransitionPropagation transitionPropagation) {
        this.mPropagation = transitionPropagation;
    }

    public Transition setStartDelay(long j) {
        this.mStartDelay = j;
        return this;
    }

    public void start() {
        if (this.mNumInstances == 0) {
            notifyListeners(TransitionNotification.f2507a, false);
            this.mEnded = false;
        }
        this.mNumInstances++;
    }

    public String toString() {
        return toString("");
    }

    public Transition addTarget(int i) {
        if (i != 0) {
            this.mTargetIds.add(Integer.valueOf(i));
        }
        return this;
    }

    public Transition clone() {
        try {
            Transition transition = (Transition) super.clone();
            transition.mAnimators = new ArrayList<>();
            transition.mStartValues = new TransitionValuesMaps();
            transition.mEndValues = new TransitionValuesMaps();
            transition.mStartValuesList = null;
            transition.mEndValuesList = null;
            transition.mSeekController = null;
            transition.mCloneParent = this;
            transition.mListeners = null;
            return transition;
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    public Transition excludeChildren(int i, boolean z) {
        this.mTargetIdChildExcludes = excludeId(this.mTargetIdChildExcludes, i, z);
        return this;
    }

    public Transition excludeTarget(int i, boolean z) {
        this.mTargetIdExcludes = excludeId(this.mTargetIdExcludes, i, z);
        return this;
    }

    public Transition removeTarget(int i) {
        if (i != 0) {
            this.mTargetIds.remove(Integer.valueOf(i));
        }
        return this;
    }

    public String toString(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(getClass().getSimpleName());
        sb.append("@");
        sb.append(Integer.toHexString(hashCode()));
        sb.append(": ");
        if (this.mDuration != -1) {
            sb.append("dur(");
            sb.append(this.mDuration);
            sb.append(") ");
        }
        if (this.mStartDelay != -1) {
            sb.append("dly(");
            sb.append(this.mStartDelay);
            sb.append(") ");
        }
        if (this.mInterpolator != null) {
            sb.append("interp(");
            sb.append(this.mInterpolator);
            sb.append(") ");
        }
        if (this.mTargetIds.size() > 0 || this.mTargets.size() > 0) {
            sb.append("tgts(");
            if (this.mTargetIds.size() > 0) {
                for (int i = 0; i < this.mTargetIds.size(); i++) {
                    if (i > 0) {
                        sb.append(", ");
                    }
                    sb.append(this.mTargetIds.get(i));
                }
            }
            if (this.mTargets.size() > 0) {
                for (int i2 = 0; i2 < this.mTargets.size(); i2++) {
                    if (i2 > 0) {
                        sb.append(", ");
                    }
                    sb.append(this.mTargets.get(i2));
                }
            }
            sb.append(")");
        }
        return sb.toString();
    }

    public Transition addTarget(String str) {
        if (this.mTargetNames == null) {
            this.mTargetNames = new ArrayList<>();
        }
        this.mTargetNames.add(str);
        return this;
    }

    public Transition excludeChildren(Class<?> cls, boolean z) {
        this.mTargetTypeChildExcludes = excludeType(this.mTargetTypeChildExcludes, cls, z);
        return this;
    }

    public Transition excludeTarget(String str, boolean z) {
        this.mTargetNameExcludes = excludeObject(this.mTargetNameExcludes, str, z);
        return this;
    }

    public Transition removeTarget(String str) {
        ArrayList<String> arrayList = this.mTargetNames;
        if (arrayList != null) {
            arrayList.remove(str);
        }
        return this;
    }

    public Transition excludeTarget(Class<?> cls, boolean z) {
        this.mTargetTypeExcludes = excludeType(this.mTargetTypeExcludes, cls, z);
        return this;
    }

    public Transition removeTarget(Class<?> cls) {
        ArrayList<Class<?>> arrayList = this.mTargetTypes;
        if (arrayList != null) {
            arrayList.remove(cls);
        }
        return this;
    }

    public Transition addTarget(Class<?> cls) {
        if (this.mTargetTypes == null) {
            this.mTargetTypes = new ArrayList<>();
        }
        this.mTargetTypes.add(cls);
        return this;
    }

    public class SeekController extends d implements TransitionSeekController, DynamicAnimation.p {
        public long a = -1;

        public SeekController() {
            Arrays.fill(new long[20], Long.MIN_VALUE);
        }

        public final void a(float f) {
            Transition transition = Transition.this;
            long max = Math.max(-1, Math.min(transition.getTotalDurationMillis() + 1, Math.round((double) f)));
            transition.setCurrentPlayTimeMillis(max, this.a);
            this.a = max;
        }

        public final void onTransitionCancel(Transition transition) {
        }
    }

    public Transition(Context context, AttributeSet attributeSet) {
        this.mName = getClass().getName();
        this.mStartDelay = -1;
        this.mDuration = -1;
        this.mInterpolator = null;
        this.mTargetIds = new ArrayList<>();
        this.mTargets = new ArrayList<>();
        this.mTargetNames = null;
        this.mTargetTypes = null;
        this.mTargetIdExcludes = null;
        this.mTargetExcludes = null;
        this.mTargetTypeExcludes = null;
        this.mTargetNameExcludes = null;
        this.mTargetIdChildExcludes = null;
        this.mTargetChildExcludes = null;
        this.mTargetTypeChildExcludes = null;
        this.mStartValues = new TransitionValuesMaps();
        this.mEndValues = new TransitionValuesMaps();
        this.mParent = null;
        this.mMatchOrder = DEFAULT_MATCH_ORDER;
        int i = 0;
        this.mCanRemoveViews = false;
        this.mCurrentAnimators = new ArrayList<>();
        this.mAnimatorCache = EMPTY_ANIMATOR_ARRAY;
        this.mNumInstances = 0;
        this.mPaused = false;
        this.mEnded = false;
        this.mCloneParent = null;
        this.mListeners = null;
        this.mAnimators = new ArrayList<>();
        this.mPathMotion = STRAIGHT_PATH_MOTION;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0385wy.a);
        XmlResourceParser xmlResourceParser = (XmlResourceParser) attributeSet;
        long c2 = (long) SA.c(obtainStyledAttributes, xmlResourceParser, "duration", 1, -1);
        if (c2 >= 0) {
            setDuration(c2);
        }
        long c3 = (long) SA.c(obtainStyledAttributes, xmlResourceParser, "startDelay", 2, -1);
        if (c3 > 0) {
            setStartDelay(c3);
        }
        i = SA.e(xmlResourceParser, "interpolator") ? obtainStyledAttributes.getResourceId(0, 0) : i;
        if (i > 0) {
            setInterpolator(AnimationUtils.loadInterpolator(context, i));
        }
        String d2 = SA.d(obtainStyledAttributes, xmlResourceParser, "matchOrder", 3);
        if (d2 != null) {
            setMatchOrder(parseMatchOrder(d2));
        }
        obtainStyledAttributes.recycle();
    }
}
