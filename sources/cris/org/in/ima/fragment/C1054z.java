package cris.org.in.ima.fragment;

import android.widget.TextView;
import cris.org.in.prs.ima.R;
import java.text.SimpleDateFormat;
import rx.Subscriber;

/* renamed from: cris.org.in.ima.fragment.z  reason: case insensitive filesystem */
/* compiled from: CancelTicketDetailsFragment */
public final class C1054z extends Subscriber<C0675S3> {
    public final /* synthetic */ CancelTicketDetailsFragment a;

    public C1054z(CancelTicketDetailsFragment cancelTicketDetailsFragment) {
        this.a = cancelTicketDetailsFragment;
    }

    public final void onCompleted() {
        this.a.f4478a.dismiss();
    }

    public final void onError(Throwable th) {
        int i = CancelTicketDetailsFragment.f;
        Lt.a(true, th);
    }

    public final void onNext(Object obj) {
        C0675S3 s3 = (C0675S3) obj;
        CancelTicketDetailsFragment cancelTicketDetailsFragment = this.a;
        if (s3 != null) {
            try {
                if (s3.getEnqMessage() == null || s3.getEnqMessage().equals("")) {
                    cancelTicketDetailsFragment.f4478a.dismiss();
                    return;
                }
                cancelTicketDetailsFragment.f4478a.dismiss();
                if (cancelTicketDetailsFragment.refund_enquiry_bottom_ll.getVisibility() == 8) {
                    cancelTicketDetailsFragment.refund_enquiry_bottom_ll.setVisibility(0);
                    TextView textView = cancelTicketDetailsFragment.pnrNumber;
                    textView.setText(cancelTicketDetailsFragment.getString(R.string.pnr_number) + " " + cancelTicketDetailsFragment.b.getPnrNumber());
                    TextView textView2 = cancelTicketDetailsFragment.refundAmt;
                    textView2.setText(cancelTicketDetailsFragment.getString(R.string.Refund_Amount) + " " + s3.getAmtRefunded());
                    TextView textView3 = cancelTicketDetailsFragment.cancellationCharge;
                    textView3.setText(cancelTicketDetailsFragment.getString(R.string.cancellation_charge) + " " + s3.getAmtDeducted());
                    cancelTicketDetailsFragment.a = System.currentTimeMillis() + C1450w1.f7015b;
                    String format = new SimpleDateFormat("HH:mm:ss").format(Long.valueOf(cancelTicketDetailsFragment.a));
                    TextView textView4 = cancelTicketDetailsFragment.refundAmountTime;
                    textView4.setText(cancelTicketDetailsFragment.getString(R.string.refund_enquiry_time) + " " + format);
                    TextView textView5 = cancelTicketDetailsFragment.transactionId;
                    textView5.setText(cancelTicketDetailsFragment.getString(R.string.as_transaction_id) + " " + cancelTicketDetailsFragment.b.getTransactionId());
                    return;
                }
                cancelTicketDetailsFragment.refund_enquiry_bottom_ll.setVisibility(8);
            } catch (Exception e) {
                int i = CancelTicketDetailsFragment.f;
                e.getMessage();
                cancelTicketDetailsFragment.f4478a.dismiss();
            }
        } else {
            cancelTicketDetailsFragment.f4478a.dismiss();
        }
    }
}
