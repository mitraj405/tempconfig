package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.f;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import defpackage.Mv;
import java.util.ArrayList;

/* renamed from: z2  reason: default package and case insensitive filesystem */
/* compiled from: BaseSearchDialogCompat */
public abstract class C1508z2<T extends Mv> extends f implements Filterable {
    public Filter a = null;

    /* renamed from: a  reason: collision with other field name */
    public RecyclerView.Adapter f7076a = null;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<T> f7077a;

    /* renamed from: a  reason: collision with other field name */
    public C1195jc<T> f7078a = null;

    public C1508z2(Context context, ArrayList arrayList) {
        super(context);
        this.f7077a = arrayList;
    }

    public final Filter getFilter() {
        if (this.a == null) {
            this.a = new C0729Vw(this.f7077a, this.f7078a);
        }
        return this.a;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View inflate = LayoutInflater.from(getContext()).inflate(C0712Ur.search_dialog_compat, (ViewGroup) null);
        C0714Uw uw = (C0714Uw) this;
        uw.setContentView(inflate);
        uw.getWindow().setBackgroundDrawableResource(17170445);
        uw.setCancelable(true);
        uw.f3812a = (TextView) inflate.findViewById(C0510Fr.txt_title);
        int i = C0510Fr.txt_search;
        uw.f3810a = (EditText) inflate.findViewById(i);
        int i2 = C0510Fr.rv_items;
        uw.f3813a = (RecyclerView) inflate.findViewById(i2);
        uw.f3811a = (ProgressBar) inflate.findViewById(C0510Fr.progress);
        uw.f3812a.setText(uw.c);
        uw.f3810a.setHint(uw.d);
        uw.f3811a.setIndeterminate(true);
        uw.f3811a.setVisibility(8);
        inflate.findViewById(C0510Fr.dummy_background).setOnClickListener(new C0672Rw(uw));
        C0476Cv cv = new C0476Cv(uw.getContext(), uw.f7077a);
        cv.f3557a = uw.a;
        cv.f3562a = uw;
        uw.f7078a = uw.f7078a;
        uw.f7076a = cv;
        uw.f3810a.requestFocus();
        ((C1380s2) uw.getFilter()).a = new C0685Sw(uw);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(i2);
        ((EditText) inflate.findViewById(i)).addTextChangedListener(new a());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        recyclerView.setAdapter(this.f7076a);
    }

    /* renamed from: z2$a */
    /* compiled from: BaseSearchDialogCompat */
    public class a implements TextWatcher {
        public a() {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            C1508z2.this.getFilter().filter(charSequence);
        }

        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}
