package defpackage;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import cris.org.in.ima.fragment.AddLoyaltyFragment;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.StatusDTO;
import rx.Subscriber;

/* renamed from: a0  reason: default package and case insensitive filesystem */
/* compiled from: AddLoyaltyFragment */
public final class C0774a0 extends Subscriber<StatusDTO> {
    public final /* synthetic */ ProgressDialog a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Context f3891a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ AddLoyaltyFragment f3892a;

    public C0774a0(AddLoyaltyFragment addLoyaltyFragment, ProgressDialog progressDialog, Context context) {
        this.f3892a = addLoyaltyFragment;
        this.a = progressDialog;
        this.f3891a = context;
    }

    public final void onCompleted() {
        int i = AddLoyaltyFragment.c;
        this.a.dismiss();
    }

    public final void onError(Throwable th) {
        this.a.dismiss();
        int i = AddLoyaltyFragment.c;
        th.getClass();
        th.getMessage();
        Mt.a(th);
    }

    public final void onNext(Object obj) {
        StatusDTO statusDTO = (StatusDTO) obj;
        this.a.dismiss();
        AddLoyaltyFragment addLoyaltyFragment = this.f3892a;
        if (statusDTO == null) {
            int i = AddLoyaltyFragment.c;
            C0535I5.m(this.f3891a, false, addLoyaltyFragment.getString(R.string.unble_to_request_try_sometime), addLoyaltyFragment.getString(R.string.error), addLoyaltyFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
        } else if (statusDTO.getError() == null) {
            int i2 = AddLoyaltyFragment.c;
            C0535I5.p(addLoyaltyFragment.getActivity(), false, addLoyaltyFragment.getResources().getString(R.string.addloyalty_success_message), addLoyaltyFragment.getString(R.string.confirmation_title), addLoyaltyFragment.getString(R.string.OK), new C0751Y(this), "", new C0762Z()).show();
        } else {
            C0535I5.m(this.f3891a, false, statusDTO.getError(), addLoyaltyFragment.getString(R.string.error), addLoyaltyFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
        }
    }
}
