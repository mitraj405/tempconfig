package androidx.fragment.app;

import android.content.Context;
import android.transition.Transition;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import androidx.core.view.f;
import androidx.fragment.app.k;
import androidx.fragment.app.s;
import defpackage.C0282nk;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.WeakHashMap;

/* compiled from: DefaultSpecialEffectsController */
public final class j extends s {

    /* compiled from: DefaultSpecialEffectsController */
    public static class a extends b {
        public k.a a;

        /* renamed from: a  reason: collision with other field name */
        public final boolean f2146a;
        public boolean b = false;

        public a(s.d dVar, A4 a4, boolean z) {
            super(dVar, a4);
            this.f2146a = z;
        }

        public final k.a c(Context context) {
            boolean z;
            if (this.b) {
                return this.a;
            }
            s.d dVar = this.f2147a;
            Fragment fragment = dVar.a;
            if (dVar.f2171a == s.d.c.VISIBLE) {
                z = true;
            } else {
                z = false;
            }
            k.a a2 = k.a(context, fragment, z, this.f2146a);
            this.a = a2;
            this.b = true;
            return a2;
        }
    }

    /* compiled from: DefaultSpecialEffectsController */
    public static class b {
        public final A4 a;

        /* renamed from: a  reason: collision with other field name */
        public final s.d f2147a;

        public b(s.d dVar, A4 a4) {
            this.f2147a = dVar;
            this.a = a4;
        }

        public final void a() {
            s.d dVar = this.f2147a;
            HashSet<A4> hashSet = dVar.f2173a;
            if (hashSet.remove(this.a) && hashSet.isEmpty()) {
                dVar.b();
            }
        }

        public final boolean b() {
            s.d.c cVar;
            s.d dVar = this.f2147a;
            s.d.c i = s.d.c.i(dVar.a.mView);
            s.d.c cVar2 = dVar.f2171a;
            if (i == cVar2 || (i != (cVar = s.d.c.VISIBLE) && cVar2 != cVar)) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: DefaultSpecialEffectsController */
    public static class c extends b {
        public final Object a;

        /* renamed from: a  reason: collision with other field name */
        public final boolean f2148a;
        public final Object b;

        public c(s.d dVar, A4 a4, boolean z, boolean z2) {
            super(dVar, a4);
            Object obj;
            Object obj2;
            boolean z3;
            s.d.c cVar = dVar.f2171a;
            s.d.c cVar2 = s.d.c.VISIBLE;
            Fragment fragment = dVar.a;
            if (cVar == cVar2) {
                if (z) {
                    obj2 = fragment.getReenterTransition();
                } else {
                    obj2 = fragment.getEnterTransition();
                }
                this.a = obj2;
                if (z) {
                    z3 = fragment.getAllowReturnTransitionOverlap();
                } else {
                    z3 = fragment.getAllowEnterTransitionOverlap();
                }
                this.f2148a = z3;
            } else {
                if (z) {
                    obj = fragment.getReturnTransition();
                } else {
                    obj = fragment.getExitTransition();
                }
                this.a = obj;
                this.f2148a = true;
            }
            if (!z2) {
                this.b = null;
            } else if (z) {
                this.b = fragment.getSharedElementReturnTransition();
            } else {
                this.b = fragment.getSharedElementEnterTransition();
            }
        }

        public final C0379wd c(Object obj) {
            if (obj == null) {
                return null;
            }
            C0342td tdVar = r.a;
            if (tdVar != null && (obj instanceof Transition)) {
                return tdVar;
            }
            C0379wd wdVar = r.f2164a;
            if (wdVar != null && wdVar.e(obj)) {
                return wdVar;
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + this.f2147a.a + " is not a valid framework Transition or AndroidX Transition");
        }
    }

    public j(ViewGroup viewGroup) {
        super(viewGroup);
    }

    public static void j(View view, ArrayList arrayList) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (!C0303qC.b(viewGroup)) {
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = viewGroup.getChildAt(i);
                    if (childAt.getVisibility() == 0) {
                        j(childAt, arrayList);
                    }
                }
            } else if (!arrayList.contains(view)) {
                arrayList.add(viewGroup);
            }
        } else if (!arrayList.contains(view)) {
            arrayList.add(view);
        }
    }

    public static void k(View view, ArrayMap arrayMap) {
        WeakHashMap<View, GC> weakHashMap = f.f1839a;
        String k = f.d.k(view);
        if (k != null) {
            arrayMap.put(k, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    k(childAt, arrayMap);
                }
            }
        }
    }

    public static void l(ArrayMap arrayMap, Collection collection) {
        Iterator it = ((C0282nk.b) arrayMap.entrySet()).iterator();
        while (true) {
            C0282nk.d dVar = (C0282nk.d) it;
            if (dVar.hasNext()) {
                dVar.next();
                WeakHashMap<View, GC> weakHashMap = f.f1839a;
                if (!collection.contains(f.d.k((View) dVar.getValue()))) {
                    dVar.remove();
                }
            } else {
                return;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:194:0x0569  */
    /* JADX WARNING: Removed duplicated region for block: B:220:0x05f5  */
    /* JADX WARNING: Removed duplicated region for block: B:240:0x0662 A[LOOP:14: B:238:0x065c->B:240:0x0662, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(java.util.ArrayList r36, boolean r37) {
        /*
            r35 = this;
            r0 = r35
            r1 = r37
            java.util.Iterator r2 = r36.iterator()
            r4 = 0
            r5 = 0
        L_0x000a:
            boolean r6 = r2.hasNext()
            androidx.fragment.app.s$d$c r7 = androidx.fragment.app.s.d.c.VISIBLE
            r8 = 2
            r9 = 1
            if (r6 == 0) goto L_0x003c
            java.lang.Object r6 = r2.next()
            androidx.fragment.app.s$d r6 = (androidx.fragment.app.s.d) r6
            androidx.fragment.app.Fragment r10 = r6.a
            android.view.View r10 = r10.mView
            androidx.fragment.app.s$d$c r10 = androidx.fragment.app.s.d.c.i(r10)
            androidx.fragment.app.s$d$c r11 = r6.f2171a
            int r11 = r11.ordinal()
            if (r11 == 0) goto L_0x0036
            if (r11 == r9) goto L_0x0032
            if (r11 == r8) goto L_0x0036
            r8 = 3
            if (r11 == r8) goto L_0x0036
            goto L_0x000a
        L_0x0032:
            if (r10 == r7) goto L_0x000a
            r5 = r6
            goto L_0x000a
        L_0x0036:
            if (r10 != r7) goto L_0x000a
            if (r4 != 0) goto L_0x000a
            r4 = r6
            goto L_0x000a
        L_0x003c:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.ArrayList r10 = new java.util.ArrayList
            r11 = r36
            r10.<init>(r11)
            java.util.Iterator r11 = r36.iterator()
        L_0x0051:
            boolean r12 = r11.hasNext()
            if (r12 == 0) goto L_0x009c
            java.lang.Object r12 = r11.next()
            androidx.fragment.app.s$d r12 = (androidx.fragment.app.s.d) r12
            A4 r14 = new A4
            r14.<init>()
            r12.d()
            java.util.HashSet<A4> r15 = r12.f2173a
            r15.add(r14)
            androidx.fragment.app.j$a r15 = new androidx.fragment.app.j$a
            r15.<init>(r12, r14, r1)
            r2.add(r15)
            A4 r14 = new A4
            r14.<init>()
            r12.d()
            java.util.HashSet<A4> r15 = r12.f2173a
            r15.add(r14)
            androidx.fragment.app.j$c r15 = new androidx.fragment.app.j$c
            if (r1 == 0) goto L_0x0086
            if (r12 != r4) goto L_0x008a
            goto L_0x0088
        L_0x0086:
            if (r12 != r5) goto L_0x008a
        L_0x0088:
            r13 = r9
            goto L_0x008b
        L_0x008a:
            r13 = 0
        L_0x008b:
            r15.<init>(r12, r14, r1, r13)
            r6.add(r15)
            androidx.fragment.app.b r13 = new androidx.fragment.app.b
            r13.<init>(r0, r10, r12)
            java.util.ArrayList r12 = r12.f2172a
            r12.add(r13)
            goto L_0x0051
        L_0x009c:
            java.util.HashMap r11 = new java.util.HashMap
            r11.<init>()
            java.util.Iterator r12 = r6.iterator()
            r15 = 0
        L_0x00a6:
            boolean r14 = r12.hasNext()
            if (r14 == 0) goto L_0x0131
            java.lang.Object r14 = r12.next()
            androidx.fragment.app.j$c r14 = (androidx.fragment.app.j.c) r14
            boolean r16 = r14.b()
            if (r16 == 0) goto L_0x00be
            r22 = r2
            r16 = r12
            goto L_0x0129
        L_0x00be:
            java.lang.Object r8 = r14.a
            wd r13 = r14.c(r8)
            java.lang.Object r3 = r14.b
            wd r9 = r14.c(r3)
            r16 = r12
            java.lang.String r12 = " returned Transition "
            r22 = r2
            java.lang.String r2 = "Mixing framework transitions and AndroidX transitions is not allowed. Fragment "
            androidx.fragment.app.s$d r14 = r14.f2147a
            if (r13 == 0) goto L_0x00fd
            if (r9 == 0) goto L_0x00fd
            if (r13 != r9) goto L_0x00db
            goto L_0x00fd
        L_0x00db:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r2)
            androidx.fragment.app.Fragment r2 = r14.a
            r4.append(r2)
            r4.append(r12)
            r4.append(r8)
            java.lang.String r2 = " which uses a different Transition  type than its shared element transition "
            r4.append(r2)
            r4.append(r3)
            java.lang.String r2 = r4.toString()
            r1.<init>(r2)
            throw r1
        L_0x00fd:
            if (r13 == 0) goto L_0x0100
            goto L_0x0101
        L_0x0100:
            r13 = r9
        L_0x0101:
            if (r15 != 0) goto L_0x0105
            r15 = r13
            goto L_0x0129
        L_0x0105:
            if (r13 == 0) goto L_0x0129
            if (r15 != r13) goto L_0x010a
            goto L_0x0129
        L_0x010a:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            androidx.fragment.app.Fragment r2 = r14.a
            r3.append(r2)
            r3.append(r12)
            r3.append(r8)
            java.lang.String r2 = " which uses a different Transition  type than other Fragments."
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            r1.<init>(r2)
            throw r1
        L_0x0129:
            r12 = r16
            r2 = r22
            r8 = 2
            r9 = 1
            goto L_0x00a6
        L_0x0131:
            r22 = r2
            androidx.fragment.app.s$d$c r2 = androidx.fragment.app.s.d.c.GONE
            android.view.ViewGroup r3 = r0.a
            if (r15 != 0) goto L_0x015b
            java.util.Iterator r1 = r6.iterator()
        L_0x013d:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x0154
            java.lang.Object r4 = r1.next()
            androidx.fragment.app.j$c r4 = (androidx.fragment.app.j.c) r4
            androidx.fragment.app.s$d r5 = r4.f2147a
            java.lang.Boolean r6 = java.lang.Boolean.FALSE
            r11.put(r5, r6)
            r4.a()
            goto L_0x013d
        L_0x0154:
            r28 = r2
            r25 = r10
            r2 = r11
            goto L_0x0534
        L_0x015b:
            android.view.View r8 = new android.view.View
            android.content.Context r9 = r3.getContext()
            r8.<init>(r9)
            android.graphics.Rect r9 = new android.graphics.Rect
            r9.<init>()
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            androidx.collection.ArrayMap r14 = new androidx.collection.ArrayMap
            r14.<init>()
            java.util.Iterator r23 = r6.iterator()
            r0 = r4
            r24 = r7
            r25 = r10
            r10 = 0
            r26 = 0
            r27 = 0
            r7 = r5
        L_0x0187:
            boolean r16 = r23.hasNext()
            if (r16 == 0) goto L_0x03a5
            java.lang.Object r16 = r23.next()
            r28 = r2
            r2 = r16
            androidx.fragment.app.j$c r2 = (androidx.fragment.app.j.c) r2
            java.lang.Object r2 = r2.b
            if (r2 == 0) goto L_0x019e
            r16 = 1
            goto L_0x01a0
        L_0x019e:
            r16 = 0
        L_0x01a0:
            if (r16 == 0) goto L_0x038d
            if (r0 == 0) goto L_0x038d
            if (r7 == 0) goto L_0x038d
            java.lang.Object r2 = r15.f(r2)
            java.lang.Object r10 = r15.t(r2)
            androidx.fragment.app.Fragment r2 = r7.a
            java.util.ArrayList r7 = r2.getSharedElementSourceNames()
            androidx.fragment.app.Fragment r0 = r0.a
            r29 = r6
            java.util.ArrayList r6 = r0.getSharedElementSourceNames()
            r30 = r11
            java.util.ArrayList r11 = r0.getSharedElementTargetNames()
            r31 = r8
            r32 = r9
            r8 = 0
        L_0x01c7:
            int r9 = r11.size()
            r33 = r10
            r10 = -1
            if (r8 >= r9) goto L_0x01e6
            java.lang.Object r9 = r11.get(r8)
            int r9 = r7.indexOf(r9)
            if (r9 == r10) goto L_0x01e1
            java.lang.Object r10 = r6.get(r8)
            r7.set(r9, r10)
        L_0x01e1:
            int r8 = r8 + 1
            r10 = r33
            goto L_0x01c7
        L_0x01e6:
            java.util.ArrayList r6 = r2.getSharedElementTargetNames()
            if (r1 != 0) goto L_0x01f5
            androidx.core.app.SharedElementCallback r8 = r0.getExitTransitionCallback()
            androidx.core.app.SharedElementCallback r9 = r2.getEnterTransitionCallback()
            goto L_0x01fd
        L_0x01f5:
            androidx.core.app.SharedElementCallback r8 = r0.getEnterTransitionCallback()
            androidx.core.app.SharedElementCallback r9 = r2.getExitTransitionCallback()
        L_0x01fd:
            int r11 = r7.size()
            r10 = 0
        L_0x0202:
            if (r10 >= r11) goto L_0x0222
            java.lang.Object r17 = r7.get(r10)
            r18 = r11
            r11 = r17
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r17 = r6.get(r10)
            r19 = r15
            r15 = r17
            java.lang.String r15 = (java.lang.String) r15
            r14.put(r11, r15)
            int r10 = r10 + 1
            r11 = r18
            r15 = r19
            goto L_0x0202
        L_0x0222:
            r19 = r15
            androidx.collection.ArrayMap r10 = new androidx.collection.ArrayMap
            r10.<init>()
            android.view.View r11 = r0.mView
            k(r11, r10)
            defpackage.C0282nk.k(r10, r7)
            if (r8 == 0) goto L_0x026a
            int r8 = r7.size()
            r11 = 1
            int r8 = r8 - r11
        L_0x0239:
            if (r8 < 0) goto L_0x0271
            java.lang.Object r11 = r7.get(r8)
            java.lang.String r11 = (java.lang.String) r11
            r15 = 0
            java.lang.Object r17 = r10.getOrDefault(r11, r15)
            android.view.View r17 = (android.view.View) r17
            if (r17 != 0) goto L_0x024e
            r14.remove(r11)
            goto L_0x0267
        L_0x024e:
            java.util.WeakHashMap<android.view.View, GC> r15 = androidx.core.view.f.f1839a
            java.lang.String r15 = androidx.core.view.f.d.k(r17)
            boolean r15 = r11.equals(r15)
            if (r15 != 0) goto L_0x0267
            java.lang.Object r11 = r14.remove(r11)
            java.lang.String r11 = (java.lang.String) r11
            java.lang.String r15 = androidx.core.view.f.d.k(r17)
            r14.put(r15, r11)
        L_0x0267:
            int r8 = r8 + -1
            goto L_0x0239
        L_0x026a:
            java.util.Set r8 = r10.keySet()
            defpackage.C0282nk.k(r14, r8)
        L_0x0271:
            androidx.collection.ArrayMap r8 = new androidx.collection.ArrayMap
            r8.<init>()
            android.view.View r11 = r2.mView
            k(r11, r8)
            defpackage.C0282nk.k(r8, r6)
            java.util.Collection r11 = r14.values()
            defpackage.C0282nk.k(r8, r11)
            if (r9 == 0) goto L_0x02c5
            int r9 = r6.size()
            r11 = 1
            int r9 = r9 - r11
        L_0x028d:
            if (r9 < 0) goto L_0x02dd
            java.lang.Object r15 = r6.get(r9)
            java.lang.String r15 = (java.lang.String) r15
            r11 = 0
            java.lang.Object r16 = r8.getOrDefault(r15, r11)
            android.view.View r16 = (android.view.View) r16
            if (r16 != 0) goto L_0x02a8
            java.lang.String r11 = androidx.fragment.app.r.b(r14, r15)
            if (r11 == 0) goto L_0x02c1
            r14.remove(r11)
            goto L_0x02c1
        L_0x02a8:
            java.util.WeakHashMap<android.view.View, GC> r11 = androidx.core.view.f.f1839a
            java.lang.String r11 = androidx.core.view.f.d.k(r16)
            boolean r11 = r15.equals(r11)
            if (r11 != 0) goto L_0x02c1
            java.lang.String r11 = androidx.fragment.app.r.b(r14, r15)
            if (r11 == 0) goto L_0x02c1
            java.lang.String r15 = androidx.core.view.f.d.k(r16)
            r14.put(r11, r15)
        L_0x02c1:
            int r9 = r9 + -1
            r11 = 1
            goto L_0x028d
        L_0x02c5:
            td r9 = androidx.fragment.app.r.a
            int r9 = r14.f1328c
            r11 = -1
        L_0x02ca:
            int r9 = r9 + r11
            if (r9 < 0) goto L_0x02dd
            java.lang.Object r15 = r14.j(r9)
            java.lang.String r15 = (java.lang.String) r15
            boolean r15 = r8.containsKey(r15)
            if (r15 != 0) goto L_0x02ca
            r14.i(r9)
            goto L_0x02ca
        L_0x02dd:
            java.util.Set r9 = r14.keySet()
            l(r10, r9)
            java.util.Collection r9 = r14.values()
            l(r8, r9)
            boolean r9 = r14.isEmpty()
            if (r9 == 0) goto L_0x0305
            r12.clear()
            r13.clear()
            r0 = r4
            r7 = r5
            r8 = r14
            r11 = r19
            r15 = r30
            r2 = r31
            r6 = r32
            r10 = 0
            goto L_0x0397
        L_0x0305:
            androidx.fragment.app.r.a(r2, r0, r1, r10)
            androidx.fragment.app.f r0 = new androidx.fragment.app.f
            r0.<init>(r5, r4, r1, r8)
            defpackage.C0184eo.a(r3, r0)
            java.util.Collection r0 = r10.values()
            r12.addAll(r0)
            boolean r0 = r7.isEmpty()
            if (r0 != 0) goto L_0x0335
            r0 = 0
            java.lang.Object r2 = r7.get(r0)
            java.lang.String r2 = (java.lang.String) r2
            r7 = 0
            java.lang.Object r2 = r10.getOrDefault(r2, r7)
            android.view.View r2 = (android.view.View) r2
            r15 = r19
            r9 = r33
            r15.n(r2, r9)
            r26 = r2
            goto L_0x033b
        L_0x0335:
            r15 = r19
            r9 = r33
            r0 = 0
            r7 = 0
        L_0x033b:
            java.util.Collection r2 = r8.values()
            r13.addAll(r2)
            boolean r2 = r6.isEmpty()
            if (r2 != 0) goto L_0x0365
            java.lang.Object r2 = r6.get(r0)
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r0 = r8.getOrDefault(r2, r7)
            android.view.View r0 = (android.view.View) r0
            if (r0 == 0) goto L_0x0365
            androidx.fragment.app.g r2 = new androidx.fragment.app.g
            r6 = r32
            r2.<init>(r15, r0, r6)
            defpackage.C0184eo.a(r3, r2)
            r2 = r31
            r27 = 1
            goto L_0x0369
        L_0x0365:
            r6 = r32
            r2 = r31
        L_0x0369:
            r15.r(r9, r2, r12)
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r8 = r14
            r14 = r15
            r11 = r15
            r15 = r9
            r20 = r9
            r21 = r13
            r14.m(r15, r16, r17, r18, r19, r20, r21)
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            r15 = r30
            r15.put(r4, r0)
            r15.put(r5, r0)
            r0 = r4
            r7 = r5
            r10 = r9
            goto L_0x0397
        L_0x038d:
            r29 = r6
            r2 = r8
            r6 = r9
            r8 = r14
            r34 = r15
            r15 = r11
            r11 = r34
        L_0x0397:
            r9 = r6
            r14 = r8
            r6 = r29
            r8 = r2
            r2 = r28
            r34 = r15
            r15 = r11
            r11 = r34
            goto L_0x0187
        L_0x03a5:
            r28 = r2
            r29 = r6
            r2 = r8
            r6 = r9
            r8 = r14
            r34 = r15
            r15 = r11
            r11 = r34
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r4 = r29.iterator()
            r9 = 0
            r14 = 0
        L_0x03bc:
            boolean r16 = r4.hasNext()
            if (r16 == 0) goto L_0x04ce
            java.lang.Object r16 = r4.next()
            r37 = r4
            r4 = r16
            androidx.fragment.app.j$c r4 = (androidx.fragment.app.j.c) r4
            boolean r16 = r4.b()
            r23 = r8
            androidx.fragment.app.s$d r8 = r4.f2147a
            if (r16 == 0) goto L_0x03e7
            r16 = r14
            java.lang.Boolean r14 = java.lang.Boolean.FALSE
            r15.put(r8, r14)
            r4.a()
            r4 = r37
            r14 = r16
            r8 = r23
            goto L_0x03bc
        L_0x03e7:
            r16 = r14
            java.lang.Object r14 = r4.a
            java.lang.Object r14 = r11.f(r14)
            if (r10 == 0) goto L_0x03f7
            if (r8 == r0) goto L_0x03f5
            if (r8 != r7) goto L_0x03f7
        L_0x03f5:
            r7 = 1
            goto L_0x03f8
        L_0x03f7:
            r7 = 0
        L_0x03f8:
            if (r14 != 0) goto L_0x0414
            if (r7 != 0) goto L_0x0404
            java.lang.Boolean r7 = java.lang.Boolean.FALSE
            r15.put(r8, r7)
            r4.a()
        L_0x0404:
            r32 = r2
            r30 = r5
            r2 = r15
            r7 = r16
            r14 = r24
            r5 = r26
            r4 = 0
            r16 = r12
            goto L_0x04bb
        L_0x0414:
            r30 = r5
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r17 = r15
            androidx.fragment.app.Fragment r15 = r8.a
            android.view.View r15 = r15.mView
            j(r15, r5)
            if (r7 == 0) goto L_0x042f
            if (r8 != r0) goto L_0x042c
            r5.removeAll(r12)
            goto L_0x042f
        L_0x042c:
            r5.removeAll(r13)
        L_0x042f:
            boolean r7 = r5.isEmpty()
            if (r7 == 0) goto L_0x0442
            r11.a(r2, r14)
            r32 = r2
            r15 = r14
            r7 = r16
            r2 = r17
            r16 = r12
            goto L_0x0490
        L_0x0442:
            r11.b(r14, r5)
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r31 = r14
            r7 = r16
            r14 = r11
            r32 = r2
            r2 = r17
            r15 = r31
            r16 = r31
            r17 = r5
            r14.m(r15, r16, r17, r18, r19, r20, r21)
            androidx.fragment.app.s$d$c r14 = r8.f2171a
            r15 = r28
            if (r14 != r15) goto L_0x048a
            r14 = r25
            r14.remove(r8)
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>(r5)
            r28 = r15
            androidx.fragment.app.Fragment r15 = r8.a
            r16 = r12
            android.view.View r12 = r15.mView
            r14.remove(r12)
            android.view.View r12 = r15.mView
            r15 = r31
            r11.l(r15, r12, r14)
            androidx.fragment.app.h r12 = new androidx.fragment.app.h
            r12.<init>(r5)
            defpackage.C0184eo.a(r3, r12)
            goto L_0x0490
        L_0x048a:
            r16 = r12
            r28 = r15
            r15 = r31
        L_0x0490:
            androidx.fragment.app.s$d$c r12 = r8.f2171a
            r14 = r24
            if (r12 != r14) goto L_0x04a1
            r1.addAll(r5)
            if (r27 == 0) goto L_0x049e
            r11.o(r15, r6)
        L_0x049e:
            r5 = r26
            goto L_0x04a6
        L_0x04a1:
            r5 = r26
            r11.n(r5, r15)
        L_0x04a6:
            java.lang.Boolean r12 = java.lang.Boolean.TRUE
            r2.put(r8, r12)
            boolean r4 = r4.f2148a
            if (r4 == 0) goto L_0x04b5
            r4 = 0
            java.lang.Object r7 = r11.j(r7, r15, r4)
            goto L_0x04bb
        L_0x04b5:
            r4 = 0
            java.lang.Object r8 = r11.j(r9, r15, r4)
            r9 = r8
        L_0x04bb:
            r4 = r37
            r15 = r2
            r26 = r5
            r24 = r14
            r12 = r16
            r8 = r23
            r5 = r30
            r2 = r32
            r14 = r7
            r7 = r5
            goto L_0x03bc
        L_0x04ce:
            r30 = r5
            r23 = r8
            r16 = r12
            r7 = r14
            r2 = r15
            java.lang.Object r4 = r11.i(r7, r9, r10)
            java.util.Iterator r5 = r29.iterator()
        L_0x04de:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x052c
            java.lang.Object r6 = r5.next()
            androidx.fragment.app.j$c r6 = (androidx.fragment.app.j.c) r6
            boolean r7 = r6.b()
            if (r7 == 0) goto L_0x04f1
            goto L_0x04de
        L_0x04f1:
            androidx.fragment.app.s$d r7 = r6.f2147a
            r8 = r30
            if (r10 == 0) goto L_0x04fd
            if (r7 == r0) goto L_0x04fb
            if (r7 != r8) goto L_0x04fd
        L_0x04fb:
            r9 = 1
            goto L_0x04fe
        L_0x04fd:
            r9 = 0
        L_0x04fe:
            java.lang.Object r12 = r6.a
            if (r12 != 0) goto L_0x0504
            if (r9 == 0) goto L_0x0529
        L_0x0504:
            java.util.WeakHashMap<android.view.View, GC> r9 = androidx.core.view.f.f1839a
            boolean r9 = r3.isLaidOut()
            if (r9 != 0) goto L_0x051d
            r9 = 2
            boolean r12 = androidx.fragment.app.FragmentManager.K(r9)
            if (r12 == 0) goto L_0x0519
            java.util.Objects.toString(r3)
            java.util.Objects.toString(r7)
        L_0x0519:
            r6.a()
            goto L_0x0529
        L_0x051d:
            androidx.fragment.app.Fragment r7 = r7.a
            androidx.fragment.app.i r7 = new androidx.fragment.app.i
            r7.<init>(r6)
            A4 r6 = r6.a
            r11.p(r4, r6, r7)
        L_0x0529:
            r30 = r8
            goto L_0x04de
        L_0x052c:
            java.util.WeakHashMap<android.view.View, GC> r0 = androidx.core.view.f.f1839a
            boolean r0 = r3.isLaidOut()
            if (r0 != 0) goto L_0x0536
        L_0x0534:
            r0 = 0
            goto L_0x054f
        L_0x0536:
            r0 = 4
            androidx.fragment.app.r.c(r0, r1)
            java.util.ArrayList r0 = defpackage.C0379wd.k(r13)
            r11.c(r3, r4)
            r4 = r16
            r5 = r23
            defpackage.C0379wd.q(r3, r4, r13, r0, r5)
            r0 = 0
            androidx.fragment.app.r.c(r0, r1)
            r11.s(r10, r4, r13)
        L_0x054f:
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            boolean r1 = r2.containsValue(r1)
            android.content.Context r4 = r3.getContext()
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.Iterator r6 = r22.iterator()
            r11 = r0
        L_0x0563:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x05e9
            java.lang.Object r7 = r6.next()
            androidx.fragment.app.j$a r7 = (androidx.fragment.app.j.a) r7
            boolean r8 = r7.b()
            if (r8 == 0) goto L_0x0579
            r7.a()
            goto L_0x0563
        L_0x0579:
            androidx.fragment.app.k$a r8 = r7.c(r4)
            if (r8 != 0) goto L_0x0583
            r7.a()
            goto L_0x0563
        L_0x0583:
            android.animation.Animator r8 = r8.a
            if (r8 != 0) goto L_0x058b
            r5.add(r7)
            goto L_0x0563
        L_0x058b:
            androidx.fragment.app.s$d r9 = r7.f2147a
            androidx.fragment.app.Fragment r10 = r9.a
            java.lang.Boolean r12 = java.lang.Boolean.TRUE
            java.lang.Object r13 = r2.get(r9)
            boolean r12 = r12.equals(r13)
            if (r12 == 0) goto L_0x05a9
            r12 = 2
            boolean r8 = androidx.fragment.app.FragmentManager.K(r12)
            if (r8 == 0) goto L_0x05a5
            java.util.Objects.toString(r10)
        L_0x05a5:
            r7.a()
            goto L_0x0563
        L_0x05a9:
            androidx.fragment.app.s$d$c r11 = r9.f2171a
            r12 = r28
            if (r11 != r12) goto L_0x05b2
            r19 = 1
            goto L_0x05b4
        L_0x05b2:
            r19 = r0
        L_0x05b4:
            r13 = r25
            if (r19 == 0) goto L_0x05bb
            r13.remove(r9)
        L_0x05bb:
            android.view.View r10 = r10.mView
            r3.startViewTransition(r10)
            androidx.fragment.app.c r11 = new androidx.fragment.app.c
            r16 = r11
            r17 = r3
            r18 = r10
            r20 = r9
            r21 = r7
            r16.<init>(r17, r18, r19, r20, r21)
            r8.addListener(r11)
            r8.setTarget(r10)
            r8.start()
            y8 r9 = new y8
            r9.<init>(r8)
            A4 r7 = r7.a
            r7.b(r9)
            r28 = r12
            r25 = r13
            r11 = 1
            goto L_0x0563
        L_0x05e9:
            r13 = r25
            java.util.Iterator r0 = r5.iterator()
        L_0x05ef:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0658
            java.lang.Object r2 = r0.next()
            androidx.fragment.app.j$a r2 = (androidx.fragment.app.j.a) r2
            androidx.fragment.app.s$d r5 = r2.f2147a
            androidx.fragment.app.Fragment r6 = r5.a
            if (r1 == 0) goto L_0x060f
            r7 = 2
            boolean r5 = androidx.fragment.app.FragmentManager.K(r7)
            if (r5 == 0) goto L_0x060b
            java.util.Objects.toString(r6)
        L_0x060b:
            r2.a()
            goto L_0x05ef
        L_0x060f:
            r7 = 2
            if (r11 == 0) goto L_0x061f
            boolean r5 = androidx.fragment.app.FragmentManager.K(r7)
            if (r5 == 0) goto L_0x061b
            java.util.Objects.toString(r6)
        L_0x061b:
            r2.a()
            goto L_0x05ef
        L_0x061f:
            android.view.View r6 = r6.mView
            androidx.fragment.app.k$a r8 = r2.c(r4)
            r8.getClass()
            android.view.animation.Animation r8 = r8.f2149a
            r8.getClass()
            androidx.fragment.app.s$d$c r5 = r5.f2171a
            androidx.fragment.app.s$d$c r9 = androidx.fragment.app.s.d.c.REMOVED
            if (r5 == r9) goto L_0x063a
            r6.startAnimation(r8)
            r2.a()
            goto L_0x064d
        L_0x063a:
            r3.startViewTransition(r6)
            androidx.fragment.app.k$b r5 = new androidx.fragment.app.k$b
            r5.<init>(r8, r3, r6)
            androidx.fragment.app.d r8 = new androidx.fragment.app.d
            r8.<init>(r6, r3, r2)
            r5.setAnimationListener(r8)
            r6.startAnimation(r5)
        L_0x064d:
            androidx.fragment.app.e r5 = new androidx.fragment.app.e
            r5.<init>(r6, r3, r2)
            A4 r2 = r2.a
            r2.b(r5)
            goto L_0x05ef
        L_0x0658:
            java.util.Iterator r0 = r13.iterator()
        L_0x065c:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0672
            java.lang.Object r1 = r0.next()
            androidx.fragment.app.s$d r1 = (androidx.fragment.app.s.d) r1
            androidx.fragment.app.Fragment r2 = r1.a
            android.view.View r2 = r2.mView
            androidx.fragment.app.s$d$c r1 = r1.f2171a
            r1.a(r2)
            goto L_0x065c
        L_0x0672:
            r13.clear()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.j.b(java.util.ArrayList, boolean):void");
    }
}
