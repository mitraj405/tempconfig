package defpackage;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

/* renamed from: l2  reason: default package and case insensitive filesystem */
/* compiled from: BankListCustomSpinnerAdapter */
public final class C1233l2 extends ArrayAdapter<String> {
    public final Activity a;

    /* renamed from: a  reason: collision with other field name */
    public final LayoutInflater f5572a;

    /* renamed from: a  reason: collision with other field name */
    public C1145h2 f5573a = null;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList f5574a;

    public C1233l2(Activity activity, int i, ArrayList arrayList) {
        super(activity, i, arrayList);
        this.a = activity;
        this.f5574a = arrayList;
        this.f5572a = (LayoutInflater) activity.getSystemService("layout_inflater");
    }

    public final View b(int i, ViewGroup viewGroup) {
        View inflate = this.f5572a.inflate(C0697Tr.bank_spinner, viewGroup, false);
        this.f5573a = null;
        this.f5573a = (C1145h2) this.f5574a.get(i);
        ((TextView) inflate.findViewById(C0501Er.txt_bank_name)).setText(this.f5573a.d);
        return inflate;
    }

    public final View getDropDownView(int i, View view, ViewGroup viewGroup) {
        return b(i, viewGroup);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        return b(i, viewGroup);
    }
}
