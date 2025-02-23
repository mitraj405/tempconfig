package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import kotlin.random.Random;

public abstract class ActivityResultRegistry {
    public final Bundle a = new Bundle();

    /* renamed from: a  reason: collision with other field name */
    public ArrayList<String> f824a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    public final HashMap f825a = new HashMap();
    public final HashMap b = new HashMap();
    public final HashMap c = new HashMap();
    public final transient HashMap d = new HashMap();
    public final HashMap e = new HashMap();

    public static class a<O> {
        public final ActivityResultCallback<O> a;

        /* renamed from: a  reason: collision with other field name */
        public final ActivityResultContract<?, O> f828a;

        public a(ActivityResultContract activityResultContract, ActivityResultCallback activityResultCallback) {
            this.a = activityResultCallback;
            this.f828a = activityResultContract;
        }
    }

    public static class b {
        public final Lifecycle a;

        /* renamed from: a  reason: collision with other field name */
        public final ArrayList<f> f829a = new ArrayList<>();

        public b(Lifecycle lifecycle) {
            this.a = lifecycle;
        }
    }

    public final boolean a(int i, int i2, Intent intent) {
        ActivityResultCallback<O> activityResultCallback;
        String str = (String) this.f825a.get(Integer.valueOf(i));
        if (str == null) {
            return false;
        }
        a aVar = (a) this.d.get(str);
        if (aVar == null || (activityResultCallback = aVar.a) == null || !this.f824a.contains(str)) {
            this.e.remove(str);
            this.a.putParcelable(str, new ActivityResult(i2, intent));
            return true;
        }
        activityResultCallback.a(aVar.f828a.c(i2, intent));
        this.f824a.remove(str);
        return true;
    }

    public abstract void b(int i, ActivityResultContract activityResultContract, @SuppressLint({"UnknownNullness"}) Object obj);

    public final T c(final String str, LifecycleOwner lifecycleOwner, final ActivityResultContract activityResultContract, final ActivityResultCallback activityResultCallback) {
        boolean z;
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        if (lifecycle.b().compareTo(Lifecycle.State.STARTED) >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            e(str);
            HashMap hashMap = this.c;
            b bVar = (b) hashMap.get(str);
            if (bVar == null) {
                bVar = new b(lifecycle);
            }
            AnonymousClass1 r0 = new f() {
                public final void b(LifecycleOwner lifecycleOwner, Lifecycle.a aVar) {
                    boolean equals = Lifecycle.a.ON_START.equals(aVar);
                    String str = str;
                    ActivityResultRegistry activityResultRegistry = ActivityResultRegistry.this;
                    if (equals) {
                        HashMap hashMap = activityResultRegistry.d;
                        ActivityResultContract activityResultContract = activityResultContract;
                        ActivityResultCallback activityResultCallback = activityResultCallback;
                        hashMap.put(str, new a(activityResultContract, activityResultCallback));
                        HashMap hashMap2 = activityResultRegistry.e;
                        if (hashMap2.containsKey(str)) {
                            Object obj = hashMap2.get(str);
                            hashMap2.remove(str);
                            activityResultCallback.a(obj);
                        }
                        Bundle bundle = activityResultRegistry.a;
                        ActivityResult activityResult = (ActivityResult) bundle.getParcelable(str);
                        if (activityResult != null) {
                            bundle.remove(str);
                            activityResultCallback.a(activityResultContract.c(activityResult.c, activityResult.a));
                        }
                    } else if (Lifecycle.a.ON_STOP.equals(aVar)) {
                        activityResultRegistry.d.remove(str);
                    } else if (Lifecycle.a.ON_DESTROY.equals(aVar)) {
                        activityResultRegistry.f(str);
                    }
                }
            };
            bVar.a.a(r0);
            bVar.f829a.add(r0);
            hashMap.put(str, bVar);
            return new T(this, str, activityResultContract);
        }
        throw new IllegalStateException("LifecycleOwner " + lifecycleOwner + " is attempting to register while current state is " + lifecycle.b() + ". LifecycleOwners must call register before they are STARTED.");
    }

    public final U d(String str, ActivityResultContract activityResultContract, ActivityResultCallback activityResultCallback) {
        e(str);
        this.d.put(str, new a(activityResultContract, activityResultCallback));
        HashMap hashMap = this.e;
        if (hashMap.containsKey(str)) {
            Object obj = hashMap.get(str);
            hashMap.remove(str);
            activityResultCallback.a(obj);
        }
        Bundle bundle = this.a;
        ActivityResult activityResult = (ActivityResult) bundle.getParcelable(str);
        if (activityResult != null) {
            bundle.remove(str);
            activityResultCallback.a(activityResultContract.c(activityResult.c, activityResult.a));
        }
        return new U(this, str, activityResultContract);
    }

    public final void e(String str) {
        HashMap hashMap = this.b;
        if (((Integer) hashMap.get(str)) == null) {
            int c2 = Random.a.c(2147418112);
            while (true) {
                int i = c2 + 65536;
                HashMap hashMap2 = this.f825a;
                if (hashMap2.containsKey(Integer.valueOf(i))) {
                    c2 = Random.a.c(2147418112);
                } else {
                    hashMap2.put(Integer.valueOf(i), str);
                    hashMap.put(str, Integer.valueOf(i));
                    return;
                }
            }
        }
    }

    public final void f(String str) {
        Integer num;
        if (!this.f824a.contains(str) && (num = (Integer) this.b.remove(str)) != null) {
            this.f825a.remove(num);
        }
        this.d.remove(str);
        HashMap hashMap = this.e;
        if (hashMap.containsKey(str)) {
            Objects.toString(hashMap.get(str));
            hashMap.remove(str);
        }
        Bundle bundle = this.a;
        if (bundle.containsKey(str)) {
            Objects.toString(bundle.getParcelable(str));
            bundle.remove(str);
        }
        HashMap hashMap2 = this.c;
        b bVar = (b) hashMap2.get(str);
        if (bVar != null) {
            ArrayList<f> arrayList = bVar.f829a;
            Iterator<f> it = arrayList.iterator();
            while (it.hasNext()) {
                bVar.a.c(it.next());
            }
            arrayList.clear();
            hashMap2.remove(str);
        }
    }
}
