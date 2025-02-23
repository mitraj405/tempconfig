package defpackage;

import android.view.View;
import java.util.ArrayList;
import kotlin.coroutines.Continuation;

/* renamed from: Mp  reason: default package */
/* compiled from: PoolingContainer.kt */
public final class Mp {
    public static final int a = Kr.pooling_container_listener_holder_tag;
    public static final int b = Kr.is_pooling_container_tag;

    public static final void a(View view) {
        C1177ig.f(view, "<this>");
        C0389xC xCVar = new C0389xC(view, (Continuation<? super C0389xC>) null);
        C1057cw cwVar = new C1057cw();
        cwVar.f5431a = r1.m(cwVar, cwVar, xCVar);
        while (cwVar.hasNext()) {
            View view2 = (View) cwVar.next();
            int i = a;
            Op op = (Op) view2.getTag(i);
            if (op == null) {
                op = new Op();
                view2.setTag(i, op);
            }
            ArrayList<Np> arrayList = op.a;
            for (int y = r1.y(arrayList); -1 < y; y--) {
                arrayList.get(y).a();
            }
        }
    }
}
