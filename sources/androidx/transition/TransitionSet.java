package androidx.transition;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Transition;
import java.util.ArrayList;
import java.util.Iterator;

public class TransitionSet extends Transition {
    public ArrayList<Transition> a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    public boolean f2515a = true;
    public boolean b = false;
    public int c;
    public int d = 0;

    public class a extends d {
        public final /* synthetic */ Transition a;

        public a(Transition transition) {
            this.a = transition;
        }

        public final void onTransitionEnd(Transition transition) {
            this.a.runAnimators();
            transition.removeListener(this);
        }
    }

    public class b extends d {
        public b() {
        }

        public final void onTransitionCancel(Transition transition) {
            TransitionSet transitionSet = TransitionSet.this;
            transitionSet.a.remove(transition);
            if (!transitionSet.hasAnimators()) {
                transitionSet.notifyListeners(Transition.TransitionNotification.f2506a, false);
                transitionSet.mEnded = true;
                transitionSet.notifyListeners(Transition.TransitionNotification.f2508a, false);
            }
        }
    }

    public static class c extends d {
        public final TransitionSet a;

        public c(TransitionSet transitionSet) {
            this.a = transitionSet;
        }

        public final void onTransitionEnd(Transition transition) {
            TransitionSet transitionSet = this.a;
            int i = transitionSet.c - 1;
            transitionSet.c = i;
            if (i == 0) {
                transitionSet.b = false;
                transitionSet.end();
            }
            transition.removeListener(this);
        }

        public final void onTransitionStart(Transition transition) {
            TransitionSet transitionSet = this.a;
            if (!transitionSet.b) {
                transitionSet.start();
                transitionSet.b = true;
            }
        }
    }

    public TransitionSet() {
    }

    public final void a(Transition transition) {
        this.a.add(transition);
        transition.mParent = this;
        long j = this.mDuration;
        if (j >= 0) {
            transition.setDuration(j);
        }
        if ((this.d & 1) != 0) {
            transition.setInterpolator(getInterpolator());
        }
        if ((this.d & 2) != 0) {
            transition.setPropagation(getPropagation());
        }
        if ((this.d & 4) != 0) {
            transition.setPathMotion(getPathMotion());
        }
        if ((this.d & 8) != 0) {
            transition.setEpicenterCallback(getEpicenterCallback());
        }
    }

    public final Transition addListener(Transition.TransitionListener transitionListener) {
        return (TransitionSet) super.addListener(transitionListener);
    }

    public final Transition addTarget(View view) {
        for (int i = 0; i < this.a.size(); i++) {
            this.a.get(i).addTarget(view);
        }
        return (TransitionSet) super.addTarget(view);
    }

    public final void b(Transition transition) {
        this.a.remove(transition);
        transition.mParent = null;
    }

    public final void c(long j) {
        ArrayList<Transition> arrayList;
        super.setDuration(j);
        if (this.mDuration >= 0 && (arrayList = this.a) != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.a.get(i).setDuration(j);
            }
        }
    }

    public final void cancel() {
        super.cancel();
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            this.a.get(i).cancel();
        }
    }

    public final void captureEndValues(TransitionValues transitionValues) {
        if (isValidTarget(transitionValues.a)) {
            Iterator<Transition> it = this.a.iterator();
            while (it.hasNext()) {
                Transition next = it.next();
                if (next.isValidTarget(transitionValues.a)) {
                    next.captureEndValues(transitionValues);
                    transitionValues.f2516a.add(next);
                }
            }
        }
    }

    public final void capturePropagationValues(TransitionValues transitionValues) {
        super.capturePropagationValues(transitionValues);
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            this.a.get(i).capturePropagationValues(transitionValues);
        }
    }

    public final void captureStartValues(TransitionValues transitionValues) {
        if (isValidTarget(transitionValues.a)) {
            Iterator<Transition> it = this.a.iterator();
            while (it.hasNext()) {
                Transition next = it.next();
                if (next.isValidTarget(transitionValues.a)) {
                    next.captureStartValues(transitionValues);
                    transitionValues.f2516a.add(next);
                }
            }
        }
    }

    public final void createAnimators(ViewGroup viewGroup, TransitionValuesMaps transitionValuesMaps, TransitionValuesMaps transitionValuesMaps2, ArrayList<TransitionValues> arrayList, ArrayList<TransitionValues> arrayList2) {
        long startDelay = getStartDelay();
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            Transition transition = this.a.get(i);
            if (startDelay > 0 && (this.f2515a || i == 0)) {
                long startDelay2 = transition.getStartDelay();
                if (startDelay2 > 0) {
                    transition.setStartDelay(startDelay2 + startDelay);
                } else {
                    transition.setStartDelay(startDelay);
                }
            }
            transition.createAnimators(viewGroup, transitionValuesMaps, transitionValuesMaps2, arrayList, arrayList2);
        }
    }

    /* renamed from: d */
    public final TransitionSet setInterpolator(TimeInterpolator timeInterpolator) {
        this.d |= 1;
        ArrayList<Transition> arrayList = this.a;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.a.get(i).setInterpolator(timeInterpolator);
            }
        }
        return (TransitionSet) super.setInterpolator(timeInterpolator);
    }

    public final void e(int i) {
        if (i == 0) {
            this.f2515a = true;
        } else if (i == 1) {
            this.f2515a = false;
        } else {
            throw new AndroidRuntimeException(lf.h("Invalid parameter for TransitionSet ordering: ", i));
        }
    }

    public final Transition excludeTarget(View view, boolean z) {
        for (int i = 0; i < this.a.size(); i++) {
            this.a.get(i).excludeTarget(view, z);
        }
        return super.excludeTarget(view, z);
    }

    public final void forceToEnd(ViewGroup viewGroup) {
        super.forceToEnd(viewGroup);
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            this.a.get(i).forceToEnd(viewGroup);
        }
    }

    public final boolean hasAnimators() {
        for (int i = 0; i < this.a.size(); i++) {
            if (this.a.get(i).hasAnimators()) {
                return true;
            }
        }
        return false;
    }

    public final boolean isSeekingSupported() {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            if (!this.a.get(i).isSeekingSupported()) {
                return false;
            }
        }
        return true;
    }

    public final void pause(View view) {
        super.pause(view);
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            this.a.get(i).pause(view);
        }
    }

    public final void prepareAnimatorsForSeeking() {
        this.mTotalDuration = 0;
        b bVar = new b();
        for (int i = 0; i < this.a.size(); i++) {
            Transition transition = this.a.get(i);
            transition.addListener(bVar);
            transition.prepareAnimatorsForSeeking();
            long totalDurationMillis = transition.getTotalDurationMillis();
            if (this.f2515a) {
                this.mTotalDuration = Math.max(this.mTotalDuration, totalDurationMillis);
            } else {
                long j = this.mTotalDuration;
                transition.mSeekOffsetInParent = j;
                this.mTotalDuration = j + totalDurationMillis;
            }
        }
    }

    public final Transition removeListener(Transition.TransitionListener transitionListener) {
        return (TransitionSet) super.removeListener(transitionListener);
    }

    public final Transition removeTarget(int i) {
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            this.a.get(i2).removeTarget(i);
        }
        return (TransitionSet) super.removeTarget(i);
    }

    public final void resume(View view) {
        super.resume(view);
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            this.a.get(i).resume(view);
        }
    }

    public final void runAnimators() {
        if (this.a.isEmpty()) {
            start();
            end();
            return;
        }
        c cVar = new c(this);
        Iterator<Transition> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().addListener(cVar);
        }
        this.c = this.a.size();
        if (!this.f2515a) {
            for (int i = 1; i < this.a.size(); i++) {
                this.a.get(i - 1).addListener(new a(this.a.get(i)));
            }
            Transition transition = this.a.get(0);
            if (transition != null) {
                transition.runAnimators();
                return;
            }
            return;
        }
        Iterator<Transition> it2 = this.a.iterator();
        while (it2.hasNext()) {
            it2.next().runAnimators();
        }
    }

    public final void setCanRemoveViews(boolean z) {
        super.setCanRemoveViews(z);
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            this.a.get(i).setCanRemoveViews(z);
        }
    }

    public final void setCurrentPlayTimeMillis(long j, long j2) {
        boolean z;
        long j3 = j;
        long j4 = j2;
        long totalDurationMillis = getTotalDurationMillis();
        if (this.mParent != null) {
            if (j3 < 0 && j4 < 0) {
                return;
            }
            if (j3 > totalDurationMillis && j4 > totalDurationMillis) {
                return;
            }
        }
        int i = (j3 > j4 ? 1 : (j3 == j4 ? 0 : -1));
        if (i < 0) {
            z = true;
        } else {
            z = false;
        }
        int i2 = (j3 > 0 ? 1 : (j3 == 0 ? 0 : -1));
        if ((i2 >= 0 && j4 < 0) || (j3 <= totalDurationMillis && j4 > totalDurationMillis)) {
            this.mEnded = false;
            notifyListeners(Transition.TransitionNotification.f2507a, z);
        }
        if (this.f2515a) {
            for (int i3 = 0; i3 < this.a.size(); i3++) {
                this.a.get(i3).setCurrentPlayTimeMillis(j3, j4);
            }
        } else {
            int i4 = 1;
            while (true) {
                if (i4 >= this.a.size()) {
                    i4 = this.a.size();
                    break;
                } else if (this.a.get(i4).mSeekOffsetInParent > j4) {
                    break;
                } else {
                    i4++;
                }
            }
            int i5 = i4 - 1;
            if (i >= 0) {
                while (i5 < this.a.size()) {
                    Transition transition = this.a.get(i5);
                    long j5 = transition.mSeekOffsetInParent;
                    int i6 = i5;
                    long j6 = j3 - j5;
                    if (j6 < 0) {
                        break;
                    }
                    transition.setCurrentPlayTimeMillis(j6, j4 - j5);
                    i5 = i6 + 1;
                }
            } else {
                while (i5 >= 0) {
                    Transition transition2 = this.a.get(i5);
                    long j7 = transition2.mSeekOffsetInParent;
                    long j8 = j3 - j7;
                    transition2.setCurrentPlayTimeMillis(j8, j4 - j7);
                    if (j8 >= 0) {
                        break;
                    }
                    i5--;
                }
            }
        }
        if (this.mParent != null) {
            int i7 = (j3 > totalDurationMillis ? 1 : (j3 == totalDurationMillis ? 0 : -1));
            if ((i7 > 0 && j4 <= totalDurationMillis) || (i2 < 0 && j4 >= 0)) {
                if (i7 > 0) {
                    this.mEnded = true;
                }
                notifyListeners(Transition.TransitionNotification.f2508a, z);
            }
        }
    }

    public final /* bridge */ /* synthetic */ Transition setDuration(long j) {
        c(j);
        return this;
    }

    public final void setEpicenterCallback(Transition.EpicenterCallback epicenterCallback) {
        super.setEpicenterCallback(epicenterCallback);
        this.d |= 8;
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            this.a.get(i).setEpicenterCallback(epicenterCallback);
        }
    }

    public final void setPathMotion(PathMotion pathMotion) {
        super.setPathMotion(pathMotion);
        this.d |= 4;
        if (this.a != null) {
            for (int i = 0; i < this.a.size(); i++) {
                this.a.get(i).setPathMotion(pathMotion);
            }
        }
    }

    public final void setPropagation(TransitionPropagation transitionPropagation) {
        super.setPropagation(transitionPropagation);
        this.d |= 2;
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            this.a.get(i).setPropagation(transitionPropagation);
        }
    }

    public final Transition setStartDelay(long j) {
        return (TransitionSet) super.setStartDelay(j);
    }

    public final String toString(String str) {
        String transition = super.toString(str);
        for (int i = 0; i < this.a.size(); i++) {
            StringBuilder n = lf.n(transition, "\n");
            n.append(this.a.get(i).toString(str + "  "));
            transition = n.toString();
        }
        return transition;
    }

    public final Transition clone() {
        TransitionSet transitionSet = (TransitionSet) super.clone();
        transitionSet.a = new ArrayList<>();
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            Transition clone = this.a.get(i).clone();
            transitionSet.a.add(clone);
            clone.mParent = transitionSet;
        }
        return transitionSet;
    }

    public final Transition addTarget(int i) {
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            this.a.get(i2).addTarget(i);
        }
        return (TransitionSet) super.addTarget(i);
    }

    public final Transition excludeTarget(String str, boolean z) {
        for (int i = 0; i < this.a.size(); i++) {
            this.a.get(i).excludeTarget(str, z);
        }
        return super.excludeTarget(str, z);
    }

    public final Transition removeTarget(View view) {
        for (int i = 0; i < this.a.size(); i++) {
            this.a.get(i).removeTarget(view);
        }
        return (TransitionSet) super.removeTarget(view);
    }

    public TransitionSet(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0385wy.g);
        e(SA.c(obtainStyledAttributes, (XmlResourceParser) attributeSet, "transitionOrdering", 0, 0));
        obtainStyledAttributes.recycle();
    }

    public final Transition addTarget(String str) {
        for (int i = 0; i < this.a.size(); i++) {
            this.a.get(i).addTarget(str);
        }
        return (TransitionSet) super.addTarget(str);
    }

    public final Transition excludeTarget(int i, boolean z) {
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            this.a.get(i2).excludeTarget(i, z);
        }
        return super.excludeTarget(i, z);
    }

    public final Transition removeTarget(Class cls) {
        for (int i = 0; i < this.a.size(); i++) {
            this.a.get(i).removeTarget((Class<?>) cls);
        }
        return (TransitionSet) super.removeTarget((Class<?>) cls);
    }

    public final Transition addTarget(Class cls) {
        for (int i = 0; i < this.a.size(); i++) {
            this.a.get(i).addTarget((Class<?>) cls);
        }
        return (TransitionSet) super.addTarget((Class<?>) cls);
    }

    public final Transition excludeTarget(Class<?> cls, boolean z) {
        for (int i = 0; i < this.a.size(); i++) {
            this.a.get(i).excludeTarget(cls, z);
        }
        return super.excludeTarget(cls, z);
    }

    public final Transition removeTarget(String str) {
        for (int i = 0; i < this.a.size(); i++) {
            this.a.get(i).removeTarget(str);
        }
        return (TransitionSet) super.removeTarget(str);
    }
}
