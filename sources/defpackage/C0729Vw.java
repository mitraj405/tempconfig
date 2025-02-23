package defpackage;

import android.widget.Filter;
import defpackage.Mv;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: Vw  reason: default package and case insensitive filesystem */
/* compiled from: SimpleSearchFilter */
public final class C0729Vw<T extends Mv> extends C1380s2 {
    public final float a = 0.33f;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<T> f3817a;

    /* renamed from: a  reason: collision with other field name */
    public final C1195jc f3818a;

    /* renamed from: a  reason: collision with other field name */
    public final boolean f3819a = true;

    public C0729Vw(ArrayList arrayList, C1195jc jcVar) {
        this.f3818a = jcVar;
        ArrayList<T> arrayList2 = new ArrayList<>();
        this.f3817a = arrayList2;
        synchronized (this) {
            arrayList2.addAll(arrayList);
        }
    }

    public final Filter.FilterResults performFiltering(CharSequence charSequence) {
        Un un = this.a;
        if (un != null) {
            C0714Uw uw = ((C0685Sw) un).a;
            uw.f3809a.post(new C0699Tw(uw, true));
        }
        String lowerCase = charSequence.toString().toLowerCase();
        Filter.FilterResults filterResults = new Filter.FilterResults();
        if (lowerCase == null || lowerCase.length() <= 0) {
            synchronized (this) {
                ArrayList<T> arrayList = this.f3817a;
                filterResults.values = arrayList;
                filterResults.count = arrayList.size();
            }
        } else {
            ArrayList arrayList2 = new ArrayList();
            Iterator<T> it = this.f3817a.iterator();
            while (it.hasNext()) {
                Mv mv = (Mv) it.next();
                if (mv.getTitle().toLowerCase().contains(lowerCase)) {
                    arrayList2.add(mv);
                } else if (this.f3819a && ((float) C1488xu.j(mv.getTitle(), lowerCase).length()) > ((float) mv.getTitle().length()) * this.a) {
                    arrayList2.add(mv);
                }
            }
            filterResults.values = arrayList2;
            filterResults.count = arrayList2.size();
        }
        return filterResults;
    }

    public final void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        C0714Uw uw = ((C0658Qw) this.f3818a).a;
        C0476Cv cv = (C0476Cv) uw.f7076a;
        cv.f3560a = uw.f3810a.getText().toString();
        cv.f3561a = (ArrayList) filterResults.values;
        cv.notifyDataSetChanged();
        Un un = this.a;
        if (un != null) {
            C0714Uw uw2 = ((C0685Sw) un).a;
            uw2.f3809a.post(new C0699Tw(uw2, false));
        }
    }
}
