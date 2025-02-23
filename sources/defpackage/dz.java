package defpackage;

import android.content.ComponentName;
import android.content.Context;
import androidx.work.impl.background.systemjob.SystemJobService;

/* renamed from: dz  reason: default package */
/* compiled from: SystemJobInfoConverter */
public final class dz {
    public static final /* synthetic */ int a = 0;

    /* renamed from: a  reason: collision with other field name */
    public final ComponentName f2879a;

    static {
        zi.e("SystemJobInfoConverter");
    }

    public dz(Context context) {
        this.f2879a = new ComponentName(context.getApplicationContext(), SystemJobService.class);
    }
}
