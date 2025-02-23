package defpackage;

import android.content.DialogInterface;
import cris.org.in.ima.activities.MasterPassengerNewActivity;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.StatusDTO;
import rx.Subscriber;

/* renamed from: xk  reason: default package and case insensitive filesystem */
/* compiled from: MasterPassengerNewActivity */
public final class C1479xk extends Subscriber<StatusDTO> {
    public final /* synthetic */ MasterPassengerNewActivity a;

    public C1479xk(MasterPassengerNewActivity masterPassengerNewActivity) {
        this.a = masterPassengerNewActivity;
    }

    public final void onCompleted() {
        int i = MasterPassengerNewActivity.d;
        this.a.f4233a.dismiss();
    }

    public final void onError(Throwable th) {
        int i = MasterPassengerNewActivity.d;
        th.getClass();
        th.getMessage();
        this.a.f4233a.dismiss();
        Lt.a(true, th);
    }

    public final void onNext(Object obj) {
        StatusDTO statusDTO = (StatusDTO) obj;
        MasterPassengerNewActivity masterPassengerNewActivity = this.a;
        if (statusDTO != null) {
            C0657Qt.h();
            try {
                if (statusDTO.getError() == null) {
                    C0535I5.f3632c.clear();
                    C0535I5.p(this.a, false, statusDTO.getStatus(), masterPassengerNewActivity.getString(R.string.confirmation_master), masterPassengerNewActivity.getString(R.string.OK), new C1461wk(this), (String) null, (DialogInterface.OnClickListener) null).show();
                    masterPassengerNewActivity.f4233a.dismiss();
                    return;
                }
                C0535I5.m(this.a, false, statusDTO.getError(), masterPassengerNewActivity.getString(R.string.error), masterPassengerNewActivity.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                masterPassengerNewActivity.f4233a.dismiss();
            } catch (Exception e) {
                int i = MasterPassengerNewActivity.d;
                e.getMessage();
                C0535I5.m(masterPassengerNewActivity, false, masterPassengerNewActivity.getString(R.string.unable_passenger_master_passenger_list), masterPassengerNewActivity.getString(R.string.error), masterPassengerNewActivity.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                masterPassengerNewActivity.f4233a.dismiss();
            }
        } else {
            C0535I5.m(masterPassengerNewActivity, false, masterPassengerNewActivity.getString(R.string.unable_passenger_master_passenger_list), masterPassengerNewActivity.getString(R.string.error), masterPassengerNewActivity.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
            masterPassengerNewActivity.f4233a.dismiss();
        }
    }
}
