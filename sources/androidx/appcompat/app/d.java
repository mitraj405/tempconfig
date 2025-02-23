package androidx.appcompat.app;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.app.AlertController;

/* compiled from: AlertController */
public final class d implements AdapterView.OnItemClickListener {
    public final /* synthetic */ AlertController.AlertParams a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ AlertController.RecycleListView f953a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ AlertController f954a;

    public d(AlertController.AlertParams alertParams, AlertController.RecycleListView recycleListView, AlertController alertController) {
        this.a = alertParams;
        this.f953a = recycleListView;
        this.f954a = alertController;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AlertController.AlertParams alertParams = this.a;
        boolean[] zArr = alertParams.f877a;
        AlertController.RecycleListView recycleListView = this.f953a;
        if (zArr != null) {
            zArr[i] = recycleListView.isItemChecked(i);
        }
        alertParams.f866a.onClick(this.f954a.f843a, i, recycleListView.isItemChecked(i));
    }
}
