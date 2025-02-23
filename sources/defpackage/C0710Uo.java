package defpackage;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.TextView;
import cris.org.in.ima.fragment.C1018d0;
import cris.org.in.ima.fragment.PassengerDetailFragment;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.StatusDTO;
import java.util.Iterator;
import java.util.Objects;
import rx.Subscriber;

/* renamed from: Uo  reason: default package and case insensitive filesystem */
/* compiled from: PassengerDetailFragment */
public final class C0710Uo extends Subscriber<StatusDTO> {
    public final /* synthetic */ ProgressDialog a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ PassengerDetailFragment f3808a;

    public C0710Uo(PassengerDetailFragment passengerDetailFragment, ProgressDialog progressDialog) {
        this.f3808a = passengerDetailFragment;
        this.a = progressDialog;
    }

    public final void onCompleted() {
        TextView textView = PassengerDetailFragment.a;
        this.a.dismiss();
    }

    public final void onError(Throwable th) {
        TextView textView = PassengerDetailFragment.a;
        th.getMessage();
        this.a.dismiss();
        Lt.a(true, th);
    }

    public final void onNext(Object obj) {
        String next;
        String str;
        String str2;
        StatusDTO statusDTO = (StatusDTO) obj;
        TextView textView = PassengerDetailFragment.a;
        Objects.toString(statusDTO);
        ProgressDialog progressDialog = this.a;
        PassengerDetailFragment passengerDetailFragment = this.f3808a;
        if (statusDTO != null) {
            C0657Qt.h();
            try {
                if (statusDTO.getErrorList() != null) {
                    Iterator<String> it = statusDTO.getErrorList().iterator();
                    String str3 = "";
                    while (true) {
                        if (!it.hasNext() || (next = it.next()) == null) {
                            break;
                        } else if (next.trim().equals("")) {
                            break;
                        } else {
                            StringBuilder sb = new StringBuilder();
                            if (str3.length() <= 1 || str3.charAt(0) == '*') {
                                str = "";
                            } else {
                                str = "* ";
                            }
                            sb.append(str);
                            sb.append(str3);
                            if (str3.length() > 1) {
                                str2 = "\n* ";
                            } else {
                                str2 = "";
                            }
                            sb.append(str2);
                            sb.append(next);
                            str3 = sb.toString();
                        }
                    }
                    progressDialog.dismiss();
                    C0535I5.p(passengerDetailFragment.f4904a, false, str3, passengerDetailFragment.getString(R.string.error), passengerDetailFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null, (String) null, (DialogInterface.OnClickListener) null).show();
                } else if (statusDTO.getError() == null || statusDTO.getError().equals("")) {
                    progressDialog.dismiss();
                    C0535I5.p(passengerDetailFragment.f4904a, false, statusDTO.getStatus(), passengerDetailFragment.getString(R.string.confirmation), passengerDetailFragment.getString(R.string.OK), new C1018d0(this, statusDTO), (String) null, (DialogInterface.OnClickListener) null).show();
                } else {
                    progressDialog.dismiss();
                    C0535I5.m(passengerDetailFragment.f4904a, false, statusDTO.getError(), passengerDetailFragment.getString(R.string.error), passengerDetailFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                }
            } catch (Exception e) {
                TextView textView2 = PassengerDetailFragment.a;
                e.getMessage();
                progressDialog.dismiss();
                C0535I5.m(passengerDetailFragment.f4904a, false, passengerDetailFragment.getString(R.string.Unable_process_request), passengerDetailFragment.getString(R.string.error), passengerDetailFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
            }
        } else {
            progressDialog.dismiss();
            Context context = passengerDetailFragment.f4904a;
            String string = passengerDetailFragment.getString(R.string.Unable_process_request);
            C0535I5.m(context, false, string, passengerDetailFragment.getString(R.string.error), passengerDetailFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
        }
    }
}
