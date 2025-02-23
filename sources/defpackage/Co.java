package defpackage;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.dto.oauth2.GoogleAdParamDTO;
import cris.org.in.ima.fragment.PanRegistrationFragment;
import cris.org.in.ima.fragment.TransactionPasswordFragment;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.EwalletProfileDTO;
import java.io.Serializable;
import rx.Subscriber;

/* renamed from: Co  reason: default package */
/* compiled from: PanRegistrationFragment */
public final class Co extends Subscriber<EwalletProfileDTO> {
    public final /* synthetic */ ProgressDialog a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ PanRegistrationFragment f3554a;

    public Co(PanRegistrationFragment panRegistrationFragment, ProgressDialog progressDialog) {
        this.f3554a = panRegistrationFragment;
        this.a = progressDialog;
    }

    public final void onCompleted() {
        int i = PanRegistrationFragment.c;
        this.a.dismiss();
    }

    public final void onError(Throwable th) {
        this.a.dismiss();
        int i = PanRegistrationFragment.c;
        xx.S(th, false, th);
    }

    public final void onNext(Object obj) {
        EwalletProfileDTO ewalletProfileDTO = (EwalletProfileDTO) obj;
        int i = PanRegistrationFragment.c;
        this.a.dismiss();
        PanRegistrationFragment panRegistrationFragment = this.f3554a;
        C0535I5.o(panRegistrationFragment.a, ewalletProfileDTO.getErrorMessage(), "OK", (DialogInterface.OnClickListener) null).show();
        if (ewalletProfileDTO.getReDirectPage() != null && ewalletProfileDTO.getReDirectPage().equals("pacardVerifySuccess") && ewalletProfileDTO.getEwalletRegistrationFee().intValue() > 0) {
            TransactionPasswordFragment transactionPasswordFragment = new TransactionPasswordFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("TotalFare", ewalletProfileDTO.getEwalletRegistrationFee().intValue());
            bundle.putSerializable("BankDetailDto", ewalletProfileDTO.getBankDetailDTO());
            bundle.putSerializable("eWalletDto", (Serializable) null);
            bundle.putString("ClientTxnId", (String) null);
            bundle.putSerializable("googleAd", new GoogleAdParamDTO());
            transactionPasswordFragment.setArguments(bundle);
            Context context = panRegistrationFragment.a;
            HomeActivity.n(context, transactionPasswordFragment, context.getResources().getString(R.string.transaction_pass_title), Boolean.TRUE, Boolean.FALSE);
        } else if (ewalletProfileDTO.getReDirectPage() != null && ewalletProfileDTO.getReDirectPage().equals("pacardVerifySuccess") && ewalletProfileDTO.getEwalletRegistrationFee().intValue() == 0) {
        } else {
            if (ewalletProfileDTO.getErrorMessage() == null || !ewalletProfileDTO.getErrorMessage().equals("") || !ewalletProfileDTO.getReDirectPage().equals("ewalletPanApiInput")) {
                C0535I5.m(panRegistrationFragment.a, false, ewalletProfileDTO.getErrorMessage(), panRegistrationFragment.getString(R.string.error), panRegistrationFragment.a.getString(R.string.OK), new Bo());
            }
        }
    }
}
