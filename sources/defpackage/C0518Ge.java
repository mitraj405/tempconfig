package defpackage;

import android.content.res.Resources;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import cris.org.in.prs.ima.R;

/* renamed from: Ge  reason: default package and case insensitive filesystem */
/* compiled from: GridHolder */
public final class C0518Ge implements C0748Xe, AdapterView.OnItemClickListener {
    public Sn a;

    /* renamed from: a  reason: collision with other field name */
    public View.OnKeyListener f3597a;

    /* renamed from: a  reason: collision with other field name */
    public View f3598a;

    /* renamed from: a  reason: collision with other field name */
    public ViewGroup f3599a;

    /* renamed from: a  reason: collision with other field name */
    public GridView f3600a;
    public View b;

    /* renamed from: b  reason: collision with other field name */
    public ViewGroup f3601b;
    public int c;

    /* renamed from: Ge$a */
    /* compiled from: GridHolder */
    public class a implements View.OnKeyListener {
        public a() {
        }

        public final boolean onKey(View view, int i, KeyEvent keyEvent) {
            View.OnKeyListener onKeyListener = C0518Ge.this.f3597a;
            if (onKeyListener != null) {
                return onKeyListener.onKey(view, i, keyEvent);
            }
            throw new NullPointerException("keyListener should not be null");
        }
    }

    public final void a(X8 x8) {
        this.f3597a = x8;
    }

    public final void b(View view) {
        if (view != null) {
            this.f3601b.addView(view);
            this.b = view;
        }
    }

    public final void c(View view) {
        if (view != null) {
            this.f3599a.addView(view);
            this.f3598a = view;
        }
    }

    public final void d(BaseAdapter baseAdapter) {
        this.f3600a.setAdapter(baseAdapter);
    }

    public final View e(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.dialog_grid, viewGroup, false);
        GridView gridView = (GridView) inflate.findViewById(R.id.list);
        this.f3600a = gridView;
        Resources resources = viewGroup.getResources();
        if (this.c == 0) {
            this.c = 17170443;
        }
        gridView.setBackgroundColor(resources.getColor(this.c));
        this.f3600a.setNumColumns(4);
        this.f3600a.setOnItemClickListener(this);
        this.f3600a.setOnKeyListener(new a());
        this.f3599a = (ViewGroup) inflate.findViewById(R.id.header_container);
        this.f3601b = (ViewGroup) inflate.findViewById(R.id.footer_container);
        return inflate;
    }

    public final void f(C0718V8 v8) {
        this.a = v8;
    }

    public final View g() {
        return this.f3600a;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Sn sn = this.a;
        if (sn != null) {
            adapterView.getItemAtPosition(i);
            ((C0718V8) sn).a(view, i);
        }
    }

    public final void setBackgroundColor(int i) {
        this.c = i;
    }
}
