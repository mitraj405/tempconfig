package defpackage;

import android.app.DialogFragment;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import com.paytm.pgsdk.sdknative.PaytmPaymentActivity;
import com.paytm.pgsdk.sdknative.PaytmSavedCardActivity;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: k2  reason: default package and case insensitive filesystem */
/* compiled from: BankDialogFragment */
public final class C1208k2 extends DialogFragment {
    public static ArrayList<C1145h2> a;

    /* renamed from: a  reason: collision with other field name */
    public ListView f5539a;

    /* renamed from: a  reason: collision with other field name */
    public SearchView f5540a;

    /* renamed from: k2$a */
    /* compiled from: BankDialogFragment */
    public class a implements SearchView.OnQueryTextListener {
        public a() {
        }

        public final boolean onQueryTextChange(String str) {
            C1208k2 k2Var = C1208k2.this;
            b bVar = (b) k2Var.f5539a.getAdapter();
            if (TextUtils.isEmpty(str)) {
                k2Var.f5539a.clearTextFilter();
                bVar.getClass();
                new b.C0072b().filter("");
                return true;
            }
            bVar.getClass();
            new b.C0072b().filter(str);
            return true;
        }

        public final boolean onQueryTextSubmit(String str) {
            return false;
        }
    }

    /* renamed from: k2$b */
    /* compiled from: BankDialogFragment */
    public class b extends BaseAdapter implements Filterable {
        public final LayoutInflater a = null;

        /* renamed from: a  reason: collision with other field name */
        public ArrayList<C1145h2> f5541a = new ArrayList<>();

        /* renamed from: k2$b$a */
        /* compiled from: BankDialogFragment */
        public class a implements View.OnClickListener {
            public final /* synthetic */ int c;

            public a(int i) {
                this.c = i;
            }

            public final void onClick(View view) {
                b bVar = b.this;
                boolean z = C1208k2.this.getActivity() instanceof PaytmPaymentActivity;
                int i = this.c;
                if (z) {
                    ((PaytmPaymentActivity) C1208k2.this.getActivity()).setSelectedBank(bVar.f5541a.get(i));
                } else if (C1208k2.this.getActivity() instanceof PaytmSavedCardActivity) {
                    ((PaytmSavedCardActivity) C1208k2.this.getActivity()).setSelectedBank(bVar.f5541a.get(i));
                }
                C1208k2.this.getDialog().dismiss();
            }
        }

        /* renamed from: k2$b$b  reason: collision with other inner class name */
        /* compiled from: BankDialogFragment */
        public class C0072b extends Filter {
            public C0072b() {
            }

            public final Filter.FilterResults performFiltering(CharSequence charSequence) {
                Filter.FilterResults filterResults = new Filter.FilterResults();
                ArrayList arrayList = new ArrayList();
                b bVar = b.this;
                bVar.f5541a.clear();
                Iterator<C1145h2> it = C1208k2.a.iterator();
                while (it.hasNext()) {
                    bVar.f5541a.add(it.next());
                }
                if (charSequence != null) {
                    ArrayList<C1145h2> arrayList2 = bVar.f5541a;
                    if (arrayList2 != null && arrayList2.size() > 0) {
                        Iterator<C1145h2> it2 = bVar.f5541a.iterator();
                        while (it2.hasNext()) {
                            C1145h2 next = it2.next();
                            if (next.d.toLowerCase().contains(charSequence.toString())) {
                                arrayList.add(next);
                            }
                        }
                    }
                    filterResults.values = arrayList;
                } else {
                    ArrayList<C1145h2> arrayList3 = bVar.f5541a;
                    if (arrayList3 != null && arrayList3.size() > 0) {
                        Iterator<C1145h2> it3 = bVar.f5541a.iterator();
                        while (it3.hasNext()) {
                            arrayList.add(it3.next());
                        }
                    }
                    filterResults.values = arrayList;
                }
                return filterResults;
            }

            public final void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
                b bVar = b.this;
                bVar.f5541a = (ArrayList) filterResults.values;
                bVar.notifyDataSetChanged();
            }
        }

        /* renamed from: k2$b$c */
        /* compiled from: BankDialogFragment */
        public class c {
            public TextView a;
        }

        public b() {
            Iterator<C1145h2> it = C1208k2.a.iterator();
            while (it.hasNext()) {
                this.f5541a.add(it.next());
            }
            this.a = (LayoutInflater) C1208k2.this.getActivity().getSystemService("layout_inflater");
        }

        public final int getCount() {
            return this.f5541a.size();
        }

        public final Filter getFilter() {
            return new C0072b();
        }

        public final Object getItem(int i) {
            return this.f5541a.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            c cVar;
            if (view == null) {
                view = this.a.inflate(C0697Tr.bank_item, (ViewGroup) null);
                cVar = new c();
                cVar.a = (TextView) view.findViewById(C0501Er.txt_bank_name);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            cVar.a.setText(this.f5541a.get(i).d);
            view.setOnClickListener(new a(i));
            return view;
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C0697Tr.bank_dialog_search_fragment, viewGroup, false);
        getDialog().getWindow().requestFeature(1);
        this.f5539a = (ListView) inflate.findViewById(C0501Er.list_bank_search);
        SearchView searchView = (SearchView) inflate.findViewById(C0501Er.bank_search_view);
        this.f5540a = searchView;
        searchView.setQueryHint("Search..");
        this.f5539a.setAdapter(new b());
        this.f5539a.setTextFilterEnabled(true);
        this.f5540a.setIconifiedByDefault(false);
        this.f5539a.requestFocus();
        this.f5540a.setOnQueryTextListener(new a());
        return inflate;
    }
}
