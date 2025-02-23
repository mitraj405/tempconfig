package defpackage;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import com.fasterxml.jackson.databind.ObjectMapper;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.fragment.ERSFragment;
import cris.org.in.ima.fragment.VikalpTrainListFragment;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.BookingResponseDTO;
import cris.prs.webservices.dto.TrainBtwnStnsRespDto;
import rx.Subscriber;

/* renamed from: P9  reason: default package */
/* compiled from: ERSFragment */
public final class P9 extends Subscriber<TrainBtwnStnsRespDto> {
    public final /* synthetic */ ProgressDialog a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ ERSFragment f3750a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ BookingResponseDTO f3751a;

    public P9(ERSFragment eRSFragment, ProgressDialog progressDialog, BookingResponseDTO bookingResponseDTO) {
        this.f3750a = eRSFragment;
        this.a = progressDialog;
        this.f3751a = bookingResponseDTO;
    }

    public final void onCompleted() {
        int i = ERSFragment.c;
    }

    public final void onError(Throwable th) {
        this.a.dismiss();
        int i = ERSFragment.c;
        xx.S(th, true, th);
    }

    public final void onNext(Object obj) {
        TrainBtwnStnsRespDto trainBtwnStnsRespDto = (TrainBtwnStnsRespDto) obj;
        ProgressDialog progressDialog = this.a;
        ERSFragment eRSFragment = this.f3750a;
        if (trainBtwnStnsRespDto != null) {
            ObjectMapper h = C0657Qt.h();
            try {
                if (trainBtwnStnsRespDto.getErrorMessage() == null) {
                    h.writeValueAsString(trainBtwnStnsRespDto.getTrainBtwnStnsList());
                    int i = ERSFragment.c;
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("Response", trainBtwnStnsRespDto);
                    bundle.putSerializable("Ticket", this.f3751a);
                    if (trainBtwnStnsRespDto.getTrainBtwnStnsList() != null) {
                        if (trainBtwnStnsRespDto.getTrainBtwnStnsList().size() != 0) {
                            VikalpTrainListFragment vikalpTrainListFragment = new VikalpTrainListFragment();
                            vikalpTrainListFragment.setArguments(bundle);
                            HomeActivity.B(eRSFragment.getActivity());
                            HomeActivity.n(eRSFragment.getActivity(), vikalpTrainListFragment, xx.d(5), Boolean.TRUE, Boolean.FALSE);
                            progressDialog.dismiss();
                            return;
                        }
                    }
                    progressDialog.dismiss();
                    C0535I5.o(eRSFragment.a, eRSFragment.getString(R.string.vikalp_trainlist_msg), eRSFragment.getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
                    return;
                }
                progressDialog.dismiss();
                C0535I5.m(eRSFragment.getActivity(), false, trainBtwnStnsRespDto.getErrorMessage(), eRSFragment.getString(R.string.information), eRSFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
            } catch (Exception e) {
                progressDialog.dismiss();
                int i2 = ERSFragment.c;
                e.getMessage();
            }
        } else {
            progressDialog.dismiss();
            C0535I5.m(eRSFragment.getActivity(), false, eRSFragment.getResources().getString(R.string.unable_process_message), eRSFragment.getString(R.string.error), eRSFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
        }
    }
}
