package defpackage;

import android.animation.Animator;
import defpackage.A4;

/* renamed from: y8  reason: default package */
/* compiled from: DefaultSpecialEffectsController */
public final class y8 implements A4.a {
    public final /* synthetic */ Animator a;

    public y8(Animator animator) {
        this.a = animator;
    }

    public final void onCancel() {
        this.a.end();
    }
}
