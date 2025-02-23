package defpackage;

import android.content.Context;
import android.content.DialogInterface;
import com.fasterxml.jackson.core.JsonProcessingException;
import cris.org.in.ima.fragment.LoyalityTxnHistoryFragment;
import cris.org.in.prs.ima.R;
import java.text.SimpleDateFormat;
import rx.Subscriber;

/* renamed from: Pj  reason: default package and case insensitive filesystem */
/* compiled from: LoyalityTxnHistoryFragment */
public final class C0641Pj extends Subscriber<C1358qx> {
    public final /* synthetic */ LoyalityTxnHistoryFragment a;

    public C0641Pj(LoyalityTxnHistoryFragment loyalityTxnHistoryFragment) {
        this.a = loyalityTxnHistoryFragment;
    }

    public final void onCompleted() {
        SimpleDateFormat simpleDateFormat = LoyalityTxnHistoryFragment.a;
        this.a.f();
    }

    public final void onError(Throwable th) {
        this.a.f4754a.dismiss();
        SimpleDateFormat simpleDateFormat = LoyalityTxnHistoryFragment.a;
        xx.S(th, true, th);
    }

    public final void onNext(Object obj) {
        C1358qx qxVar = (C1358qx) obj;
        LoyalityTxnHistoryFragment loyalityTxnHistoryFragment = this.a;
        loyalityTxnHistoryFragment.f4754a.dismiss();
        if (qxVar.getSoftAccountSummaryDTO() != null) {
            for (C1311ox next : qxVar.getSoftAccountSummaryDTO()) {
                if (next.getBankName().contains("SBI Bank")) {
                    if (next.getError() == null) {
                        try {
                            C0657Qt.h().writeValueAsString(qxVar.getSoftAccountSummaryDTO());
                            SimpleDateFormat simpleDateFormat = LoyalityTxnHistoryFragment.a;
                        } catch (JsonProcessingException e) {
                            SimpleDateFormat simpleDateFormat2 = LoyalityTxnHistoryFragment.a;
                            e.getMessage();
                        }
                        loyalityTxnHistoryFragment.g(next);
                    } else {
                        C0535I5.m(loyalityTxnHistoryFragment.f4755a, false, next.getError(), loyalityTxnHistoryFragment.getString(R.string.error), loyalityTxnHistoryFragment.f4755a.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                    }
                }
            }
            return;
        }
        Context context = loyalityTxnHistoryFragment.f4755a;
        C0535I5.m(context, false, context.getResources().getString(R.string.unable_process_message), loyalityTxnHistoryFragment.getString(R.string.error), loyalityTxnHistoryFragment.f4755a.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
    }
}
