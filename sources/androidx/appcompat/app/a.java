package androidx.appcompat.app;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import androidx.appcompat.app.AlertController;

/* compiled from: AlertController */
public final class a extends ArrayAdapter<CharSequence> {
    public final /* synthetic */ AlertController.AlertParams a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ AlertController.RecycleListView f949a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(AlertController.AlertParams alertParams, Context context, int i, CharSequence[] charSequenceArr, AlertController.RecycleListView recycleListView) {
        super(context, i, 16908308, charSequenceArr);
        this.a = alertParams;
        this.f949a = recycleListView;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        boolean[] zArr = this.a.f877a;
        if (zArr != null && zArr[i]) {
            this.f949a.setItemChecked(i, true);
        }
        return view2;
    }
}
