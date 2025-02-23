package defpackage;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* renamed from: Jb  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0551Jb implements OnCompleteListener {
    public final /* synthetic */ C1139gq a;

    public /* synthetic */ C0551Jb(C1139gq gqVar) {
        this.a = gqVar;
    }

    public final void onComplete(Task task) {
        if (task.isSuccessful()) {
            C1139gq gqVar = this.a;
            if (gqVar.e("deviceToken") != null && !gqVar.e("deviceToken").isEmpty()) {
                gqVar.h("deviceToken", (String) null);
                C0577Lb.a.delete();
            }
        }
    }
}
