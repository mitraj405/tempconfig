package defpackage;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import cris.org.in.prs.ima.R;

/* renamed from: fi  reason: default package and case insensitive filesystem */
/* compiled from: ListHolder */
public final class C1114fi implements C0748Xe, AdapterView.OnItemClickListener {
    public Sn a;

    /* renamed from: a  reason: collision with other field name */
    public View.OnKeyListener f5464a;

    /* renamed from: a  reason: collision with other field name */
    public View f5465a;

    /* renamed from: a  reason: collision with other field name */
    public ListView f5466a;
    public View b;
    public int c;

    /* renamed from: fi$a */
    /* compiled from: ListHolder */
    public class a implements View.OnKeyListener {
        public a() {
        }

        public final boolean onKey(View view, int i, KeyEvent keyEvent) {
            View.OnKeyListener onKeyListener = C1114fi.this.f5464a;
            if (onKeyListener != null) {
                return onKeyListener.onKey(view, i, keyEvent);
            }
            throw new NullPointerException("keyListener should not be null");
        }
    }

    public final void a(X8 x8) {
        this.f5464a = x8;
    }

    public final void b(View view) {
        if (view != null) {
            this.f5466a.addFooterView(view);
            this.b = view;
        }
    }

    public final void c(View view) {
        if (view != null) {
            this.f5466a.addHeaderView(view);
            this.f5465a = view;
        }
    }

    public final void d(BaseAdapter baseAdapter) {
        this.f5466a.setAdapter(baseAdapter);
    }

    public final View e(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.dialog_list, viewGroup, false);
        ListView listView = (ListView) inflate.findViewById(R.id.list);
        this.f5466a = listView;
        if (this.c == 0) {
            this.c = 17170443;
        }
        listView.setBackgroundColor(viewGroup.getResources().getColor(this.c));
        this.f5466a.setOnItemClickListener(this);
        this.f5466a.setOnKeyListener(new a());
        return inflate;
    }

    public final void f(C0718V8 v8) {
        this.a = v8;
    }

    public final View g() {
        return this.f5466a;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Sn sn = this.a;
        if (sn != null) {
            try {
                adapterView.getItemAtPosition(i);
                ((C0718V8) sn).a(view, i);
            } catch (IndexOutOfBoundsException e) {
                e.getMessage();
            }
        }
    }

    public final void setBackgroundColor(int i) {
        this.c = i;
    }
}
