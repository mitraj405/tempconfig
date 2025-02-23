package defpackage;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import com.fasterxml.jackson.databind.ObjectMapper;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.fragment.ErsDisplayFragment;
import cris.org.in.ima.fragment.VikalpTrainListFragment;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.BookingResponseDTO;
import cris.prs.webservices.dto.TrainBtwnStnsRespDto;
import java.text.SimpleDateFormat;
import rx.Subscriber;

/* renamed from: Oa  reason: default package and case insensitive filesystem */
/* compiled from: ErsDisplayFragment */
public final class C0620Oa extends Subscriber<TrainBtwnStnsRespDto> {
    public final /* synthetic */ ProgressDialog a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ ErsDisplayFragment f3736a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ BookingResponseDTO f3737a;

    public C0620Oa(ErsDisplayFragment ersDisplayFragment, ProgressDialog progressDialog, BookingResponseDTO bookingResponseDTO) {
        this.f3736a = ersDisplayFragment;
        this.a = progressDialog;
        this.f3737a = bookingResponseDTO;
    }

    public final void onCompleted() {
        SimpleDateFormat simpleDateFormat = ErsDisplayFragment.d;
    }

    public final void onError(Throwable th) {
        this.a.dismiss();
        SimpleDateFormat simpleDateFormat = ErsDisplayFragment.d;
        xx.S(th, true, th);
    }

    public final void onNext(Object obj) {
        String str;
        TrainBtwnStnsRespDto trainBtwnStnsRespDto = (TrainBtwnStnsRespDto) obj;
        BookingResponseDTO bookingResponseDTO = this.f3737a;
        ProgressDialog progressDialog = this.a;
        ErsDisplayFragment ersDisplayFragment = this.f3736a;
        if (trainBtwnStnsRespDto != null) {
            ObjectMapper h = C0657Qt.h();
            try {
                if (trainBtwnStnsRespDto.getErrorMessage() == null) {
                    h.writeValueAsString(trainBtwnStnsRespDto.getTrainBtwnStnsList());
                    SimpleDateFormat simpleDateFormat = ErsDisplayFragment.d;
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("Response", trainBtwnStnsRespDto);
                    bundle.putSerializable("Ticket", bookingResponseDTO);
                    if (trainBtwnStnsRespDto.getTrainBtwnStnsList() != null) {
                        if (trainBtwnStnsRespDto.getTrainBtwnStnsList().size() != 0) {
                            VikalpTrainListFragment vikalpTrainListFragment = new VikalpTrainListFragment();
                            vikalpTrainListFragment.setArguments(bundle);
                            if (bookingResponseDTO.getVikalpDTO() != null) {
                                if (bookingResponseDTO.getVikalpDTO().size() != 0) {
                                    str = xx.d(6);
                                    HomeActivity.n(ersDisplayFragment.getActivity(), vikalpTrainListFragment, str, Boolean.TRUE, Boolean.FALSE);
                                    progressDialog.dismiss();
                                    return;
                                }
                            }
                            str = xx.d(5);
                            HomeActivity.n(ersDisplayFragment.getActivity(), vikalpTrainListFragment, str, Boolean.TRUE, Boolean.FALSE);
                            progressDialog.dismiss();
                            return;
                        }
                    }
                    progressDialog.dismiss();
                    C0535I5.o(ersDisplayFragment.f4569a, ersDisplayFragment.getString(R.string.vikalp_trainlist_msg), ersDisplayFragment.getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
                    return;
                }
                progressDialog.dismiss();
                C0535I5.m(ersDisplayFragment.getActivity(), false, trainBtwnStnsRespDto.getErrorMessage(), ersDisplayFragment.getString(R.string.information), ersDisplayFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
            } catch (Exception e) {
                progressDialog.dismiss();
                SimpleDateFormat simpleDateFormat2 = ErsDisplayFragment.d;
                e.getMessage();
            }
        } else {
            progressDialog.dismiss();
            C0535I5.m(ersDisplayFragment.getActivity(), false, ersDisplayFragment.getResources().getString(R.string.unable_process_message), ersDisplayFragment.getString(R.string.error), ersDisplayFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
        }
    }
}
