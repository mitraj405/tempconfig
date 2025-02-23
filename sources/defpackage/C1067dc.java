package defpackage;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.widget.Toast;
import cris.org.in.ima.fragment.FevouriteJourneyFragment;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.StatusDTO;
import rx.Subscriber;

/* renamed from: dc  reason: default package and case insensitive filesystem */
/* compiled from: FevouriteJourneyFragment */
public final class C1067dc extends Subscriber<StatusDTO> {
    public final /* synthetic */ ProgressDialog a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ FevouriteJourneyFragment f5436a;

    public C1067dc(FevouriteJourneyFragment fevouriteJourneyFragment, ProgressDialog progressDialog) {
        this.f5436a = fevouriteJourneyFragment;
        this.a = progressDialog;
    }

    public final void onCompleted() {
        int i = FevouriteJourneyFragment.c;
        this.a.dismiss();
    }

    public final void onError(Throwable th) {
        int i = FevouriteJourneyFragment.c;
        th.getMessage();
        FevouriteJourneyFragment fevouriteJourneyFragment = this.f5436a;
        Toast.makeText(fevouriteJourneyFragment.getContext(), fevouriteJourneyFragment.getString(R.string.on_error), 1).show();
        this.a.dismiss();
        Lt.a(true, th);
    }

    public final void onNext(Object obj) {
        StatusDTO statusDTO = (StatusDTO) obj;
        ProgressDialog progressDialog = this.a;
        FevouriteJourneyFragment fevouriteJourneyFragment = this.f5436a;
        if (statusDTO != null) {
            C0657Qt.h();
            try {
                if (statusDTO.getError() == null) {
                    C0535I5.p(fevouriteJourneyFragment.getActivity(), false, statusDTO.getStatus(), fevouriteJourneyFragment.getString(R.string.confirmation), fevouriteJourneyFragment.getString(R.string.OK), new C0820cc(this), (String) null, (DialogInterface.OnClickListener) null).show();
                    progressDialog.dismiss();
                    return;
                }
                C0535I5.m(fevouriteJourneyFragment.getContext(), false, statusDTO.getError(), fevouriteJourneyFragment.getString(R.string.error), fevouriteJourneyFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                progressDialog.dismiss();
            } catch (Exception e) {
                int i = FevouriteJourneyFragment.c;
                e.getMessage();
                C0535I5.m(fevouriteJourneyFragment.getContext(), false, fevouriteJourneyFragment.getString(R.string.unable_to_fav_list), fevouriteJourneyFragment.getString(R.string.error), fevouriteJourneyFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                progressDialog.dismiss();
            }
        } else {
            C0535I5.m(fevouriteJourneyFragment.getContext(), false, fevouriteJourneyFragment.getString(R.string.unable_to_fav_list), fevouriteJourneyFragment.getString(R.string.error), fevouriteJourneyFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
            progressDialog.dismiss();
            Toast.makeText(fevouriteJourneyFragment.getContext(), "", 1).show();
        }
    }
}
