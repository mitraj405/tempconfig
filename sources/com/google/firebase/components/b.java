package com.google.firebase.components;

import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import com.google.firebase.inject.Provider;
import java.util.Map;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ Object a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ int c;

    public /* synthetic */ b(int i, Object obj, Object obj2) {
        this.c = i;
        this.a = obj;
        this.b = obj2;
    }

    public final void run() {
        int i = this.c;
        Object obj = this.b;
        Object obj2 = this.a;
        switch (i) {
            case 0:
                ((LazySet) obj2).add((Provider) obj);
                return;
            default:
                ((EventHandler) ((Map.Entry) obj2).getKey()).handle((Event) obj);
                return;
        }
    }
}
