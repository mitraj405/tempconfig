package cris.org.in.ima.fragment;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.TextView;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.PnrEnquiryResponseDTO;
import java.io.Serializable;
import rx.Subscriber;

/* renamed from: cris.org.in.ima.fragment.v  reason: case insensitive filesystem */
/* compiled from: AllTrainListFragment */
public final class C1050v extends Subscriber<PnrEnquiryResponseDTO> {
    public final /* synthetic */ ProgressDialog a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ AllTrainListFragment f5240a;

    public C1050v(AllTrainListFragment allTrainListFragment, ProgressDialog progressDialog) {
        this.f5240a = allTrainListFragment;
        this.a = progressDialog;
    }

    public final void onCompleted() {
        TextView textView = AllTrainListFragment.f4408a;
    }

    public final void onError(Throwable th) {
        TextView textView = AllTrainListFragment.f4408a;
        th.getClass();
        th.getMessage();
        this.a.dismiss();
        HomeActivity.B(this.f5240a.getActivity());
        Lt.a(true, th);
    }

    public final void onNext(Object obj) {
        PnrEnquiryResponseDTO pnrEnquiryResponseDTO = (PnrEnquiryResponseDTO) obj;
        this.a.dismiss();
        if (pnrEnquiryResponseDTO != null) {
            C0657Qt.h();
            try {
                String errorMessage = pnrEnquiryResponseDTO.getErrorMessage();
                AllTrainListFragment allTrainListFragment = this.f5240a;
                if (errorMessage != null) {
                    C0535I5.m(allTrainListFragment.getActivity(), true, pnrEnquiryResponseDTO.getErrorMessage().split("-")[0], allTrainListFragment.getString(R.string.error), allTrainListFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                } else if (pnrEnquiryResponseDTO.getStatus() != null) {
                    allTrainListFragment.status.setVisibility(0);
                    allTrainListFragment.status.setText(pnrEnquiryResponseDTO.getStatus());
                    allTrainListFragment.otpLayout.setVisibility(0);
                    allTrainListFragment.c = 2;
                    allTrainListFragment.inputPnr.setClickable(false);
                } else {
                    Bundle bundle = new Bundle();
                    TextView textView = AllTrainListFragment.f4408a;
                    allTrainListFragment.getClass();
                    bundle.putSerializable("TrainBtwnStnsDTO", (Serializable) null);
                    bundle.putSerializable("AvlFareResponseDTO", AllTrainListFragment.f4414b.a);
                    bundle.putSerializable("AvailablityDTO", (Serializable) null);
                    bundle.putString("selectedQuotaString", AllTrainListFragment.n);
                    bundle.putSerializable("googleAdParamDTO", (Serializable) null);
                    bundle.putString("spConcession", AllTrainListFragment.m);
                    bundle.putString("selectedQuota", AllTrainListFragment.l);
                    bundle.putBoolean("isLinkedJoureny", true);
                    bundle.putSerializable("boardingStnListDTO", (Serializable) null);
                    bundle.putString("mainPnr", pnrEnquiryResponseDTO.getPnrNumber());
                    bundle.putString("JourneyDate", AllTrainListFragment.k);
                    bundle.putSerializable("psgnSetails", pnrEnquiryResponseDTO.getPassengerList());
                    bundle.putSerializable("highestClass", (Serializable) null);
                    PassengerDetailFragment passengerDetailFragment = new PassengerDetailFragment();
                    passengerDetailFragment.setArguments(bundle);
                    HomeActivity.n(allTrainListFragment.f4421a, passengerDetailFragment, C1218kf.ADD_PASSENGER.a(), Boolean.TRUE, Boolean.FALSE);
                }
            } catch (Exception e) {
                TextView textView2 = AllTrainListFragment.f4408a;
                e.getMessage();
            }
        }
    }
}
