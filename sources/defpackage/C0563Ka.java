package defpackage;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import cris.org.in.ima.fragment.ErsDisplayFragment;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.BookingResponseDTO;
import java.text.SimpleDateFormat;

/* renamed from: Ka  reason: default package and case insensitive filesystem */
/* compiled from: ErsDisplayFragment */
public final class C0563Ka implements DialogInterface.OnClickListener {
    public final /* synthetic */ ErsDisplayFragment a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ BookingResponseDTO f3683a;

    public C0563Ka(ErsDisplayFragment ersDisplayFragment, BookingResponseDTO bookingResponseDTO) {
        this.a = ersDisplayFragment;
        this.f3683a = bookingResponseDTO;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        String str;
        SimpleDateFormat simpleDateFormat = ErsDisplayFragment.d;
        ErsDisplayFragment ersDisplayFragment = this.a;
        if (C0535I5.O((ConnectivityManager) ersDisplayFragment.getActivity().getSystemService("connectivity"), ersDisplayFragment.getContext())) {
            C0793b1 b1Var = C0793b1.a;
            if (b1Var.f3912a != null) {
                ProgressDialog progressDialog = new ProgressDialog(ersDisplayFragment.getActivity());
                progressDialog.requestWindowFeature(1);
                progressDialog.setMessage(ersDisplayFragment.getString(R.string.please_wait_text));
                progressDialog.setCanceledOnTouchOutside(false);
                progressDialog.show();
                Om om = (Om) C0657Qt.c(b1Var.f3912a);
                String f = C0657Qt.f();
                Object[] objArr = new Object[1];
                BookingResponseDTO bookingResponseDTO = this.f3683a;
                if (bookingResponseDTO.getReservationId() != null) {
                    str = bookingResponseDTO.getReservationId();
                } else {
                    str = ersDisplayFragment.f4577a.getResvDetails().get(0).getReservationId();
                }
                objArr[0] = Long.valueOf(str);
                String format = String.format("/%s", objArr);
                om.x1(f + "vikalpTrainList" + format).c(C1181iv.a()).a(E0.a()).b(new C0620Oa(ersDisplayFragment, progressDialog, bookingResponseDTO));
                return;
            }
            C0535I5.m(ersDisplayFragment.getActivity(), false, ersDisplayFragment.getResources().getString(R.string.data_connection_error_message), ersDisplayFragment.getString(R.string.error), ersDisplayFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
        }
    }
}
