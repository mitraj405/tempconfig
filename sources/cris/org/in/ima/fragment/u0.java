package cris.org.in.ima.fragment;

import android.widget.CheckBox;
import android.widget.CompoundButton;

/* compiled from: TDRTicketPassengerAdapter */
public final class u0 implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ TDRTicketPassengerAdapter f5239a;

    public u0(TDRTicketPassengerAdapter tDRTicketPassengerAdapter, int i) {
        this.f5239a = tDRTicketPassengerAdapter;
        this.a = i;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        TDRTicketPassengerAdapter tDRTicketPassengerAdapter = this.f5239a;
        tDRTicketPassengerAdapter.b.set(this.a, Boolean.valueOf(z));
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
