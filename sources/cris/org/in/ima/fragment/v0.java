package cris.org.in.ima.fragment;

import android.view.View;
import android.widget.CheckBox;
import cris.org.in.ima.fragment.TDRTicketPassengerAdapter;
import java.util.ArrayList;

/* compiled from: TDRTicketPassengerAdapter */
public final class v0 implements View.OnClickListener {
    public final /* synthetic */ TDRTicketPassengerAdapter.ViewHolder a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ TDRTicketPassengerAdapter f5241a;
    public final /* synthetic */ int c;

    public v0(TDRTicketPassengerAdapter tDRTicketPassengerAdapter, int i, TDRTicketPassengerAdapter.ViewHolder viewHolder) {
        this.f5241a = tDRTicketPassengerAdapter;
        this.c = i;
        this.a = viewHolder;
    }

    public final void onClick(View view) {
        TDRTicketPassengerAdapter tDRTicketPassengerAdapter = this.f5241a;
        ArrayList<Boolean> arrayList = tDRTicketPassengerAdapter.b;
        int i = this.c;
        boolean z = !arrayList.get(i).booleanValue();
        tDRTicketPassengerAdapter.b.set(i, Boolean.valueOf(z));
        this.a.selection.setChecked(z);
        boolean isAllPassengersSelected = tDRTicketPassengerAdapter.isAllPassengersSelected();
        TDRTicketDetailsFragment tDRTicketDetailsFragment = tDRTicketPassengerAdapter.a;
        if (isAllPassengersSelected) {
            CheckBox checkBox = tDRTicketDetailsFragment.selectall;
            if (checkBox != null) {
                checkBox.setChecked(true);
                return;
            }
            return;
        }
        CheckBox checkBox2 = tDRTicketDetailsFragment.selectall;
        if (checkBox2 != null) {
            checkBox2.setChecked(false);
        }
    }
}
