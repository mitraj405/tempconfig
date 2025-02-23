package cris.org.in.ima.fragment;

import android.content.DialogInterface;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.StatusDTO;

/* renamed from: cris.org.in.ima.fragment.d0  reason: case insensitive filesystem */
/* compiled from: PassengerDetailFragment */
public final class C1018d0 implements DialogInterface.OnClickListener {
    public final /* synthetic */ C0710Uo a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ StatusDTO f5236a;

    public C1018d0(C0710Uo uo, StatusDTO statusDTO) {
        this.a = uo;
        this.f5236a = statusDTO;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        C0535I5.f3640e.clear();
        boolean equals = this.f5236a.getStatus().equals("Journey List Saved Successfully ...");
        C0710Uo uo = this.a;
        if (equals) {
            PassengerDetailFragment passengerDetailFragment = uo.f3808a;
            passengerDetailFragment.addfev_journey.setColorFilter(passengerDetailFragment.f4906a.getResources().getColor(R.color.red));
            return;
        }
        PassengerDetailFragment passengerDetailFragment2 = uo.f3808a;
        passengerDetailFragment2.addfev_journey.setColorFilter(passengerDetailFragment2.f4906a.getResources().getColor(R.color.grey));
    }
}
