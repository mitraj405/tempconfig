package defpackage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* renamed from: ND  reason: default package */
/* compiled from: WorkContinuationImpl */
public final class ND extends v3 {
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public final VD f441a;

    /* renamed from: a  reason: collision with other field name */
    public io f442a;

    /* renamed from: a  reason: collision with other field name */
    public final String f443a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList f444a;

    /* renamed from: a  reason: collision with other field name */
    public final List<? extends C0202gE> f445a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f446a;
    public final ArrayList b;

    /* renamed from: b  reason: collision with other field name */
    public final List<ND> f447b;

    static {
        zi.e("WorkContinuationImpl");
    }

    public ND() {
        throw null;
    }

    public ND(VD vd, List<? extends C0202gE> list) {
        this.f441a = vd;
        this.f443a = null;
        this.a = 2;
        this.f445a = list;
        this.f447b = null;
        this.f444a = new ArrayList(list.size());
        this.b = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            String uuid = ((C0202gE) list.get(i)).f2964a.toString();
            this.f444a.add(uuid);
            this.b.add(uuid);
        }
    }

    public static boolean d(ND nd, HashSet hashSet) {
        hashSet.addAll(nd.f444a);
        HashSet e = e(nd);
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            if (e.contains((String) it.next())) {
                return true;
            }
        }
        List<ND> list = nd.f447b;
        if (list != null && !list.isEmpty()) {
            for (ND d : list) {
                if (d(d, hashSet)) {
                    return true;
                }
            }
        }
        hashSet.removeAll(nd.f444a);
        return false;
    }

    public static HashSet e(ND nd) {
        HashSet hashSet = new HashSet();
        List<ND> list = nd.f447b;
        if (list != null && !list.isEmpty()) {
            for (ND nd2 : list) {
                hashSet.addAll(nd2.f444a);
            }
        }
        return hashSet;
    }
}
