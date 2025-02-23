package defpackage;

import androidx.appcompat.app.AppCompatDelegateImpl;

/* renamed from: l1  reason: default package and case insensitive filesystem */
/* compiled from: AppCompatDelegateImpl */
public final class C0252l1 implements Runnable {
    public final /* synthetic */ AppCompatDelegateImpl a;

    /* renamed from: l1$a */
    /* compiled from: AppCompatDelegateImpl */
    public class a extends C1488xu {
        public a() {
        }

        public final void a() {
            C0252l1.this.a.f921a.setVisibility(0);
        }

        public final void onAnimationEnd() {
            C0252l1 l1Var = C0252l1.this;
            l1Var.a.f921a.setAlpha(1.0f);
            AppCompatDelegateImpl appCompatDelegateImpl = l1Var.a;
            appCompatDelegateImpl.f900a.d((IC) null);
            appCompatDelegateImpl.f900a = null;
        }
    }

    public C0252l1(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.a = appCompatDelegateImpl;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0044  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r5 = this;
            androidx.appcompat.app.AppCompatDelegateImpl r0 = r5.a
            android.widget.PopupWindow r1 = r0.f908a
            androidx.appcompat.widget.ActionBarContextView r2 = r0.f921a
            r3 = 55
            r4 = 0
            r1.showAtLocation(r2, r3, r4, r4)
            GC r1 = r0.f900a
            if (r1 == 0) goto L_0x0013
            r1.b()
        L_0x0013:
            boolean r1 = r0.f929c
            if (r1 == 0) goto L_0x0025
            android.view.ViewGroup r1 = r0.f906a
            if (r1 == 0) goto L_0x0025
            java.util.WeakHashMap<android.view.View, GC> r2 = androidx.core.view.f.f1839a
            boolean r1 = r1.isLaidOut()
            if (r1 == 0) goto L_0x0025
            r1 = 1
            goto L_0x0026
        L_0x0025:
            r1 = r4
        L_0x0026:
            r2 = 1065353216(0x3f800000, float:1.0)
            if (r1 == 0) goto L_0x0044
            androidx.appcompat.widget.ActionBarContextView r1 = r0.f921a
            r3 = 0
            r1.setAlpha(r3)
            androidx.appcompat.widget.ActionBarContextView r1 = r0.f921a
            GC r1 = androidx.core.view.f.a(r1)
            r1.a(r2)
            r0.f900a = r1
            l1$a r0 = new l1$a
            r0.<init>()
            r1.d(r0)
            goto L_0x004e
        L_0x0044:
            androidx.appcompat.widget.ActionBarContextView r1 = r0.f921a
            r1.setAlpha(r2)
            androidx.appcompat.widget.ActionBarContextView r0 = r0.f921a
            r0.setVisibility(r4)
        L_0x004e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0252l1.run():void");
    }
}
