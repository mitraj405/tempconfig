package androidx.appcompat.app;

import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.app.AlertController;

/* compiled from: AlertController */
public final class c implements AdapterView.OnItemClickListener {
    public final /* synthetic */ AlertController.AlertParams a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ AlertController f952a;

    public c(AlertController.AlertParams alertParams, AlertController alertController) {
        this.a = alertParams;
        this.f952a = alertController;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AlertController.AlertParams alertParams = this.a;
        DialogInterface.OnClickListener onClickListener = alertParams.f888d;
        AlertController alertController = this.f952a;
        onClickListener.onClick(alertController.f843a, i);
        if (!alertParams.f891d) {
            alertController.f843a.dismiss();
        }
    }
}
