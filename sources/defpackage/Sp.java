package defpackage;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.menu.MenuBuilder;
import cris.org.in.ima.IrctcImaApplication;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.fragment.CancelTicketDetailsFragment;
import cris.org.in.ima.fragment.ErsDisplayFragment;
import cris.org.in.ima.fragment.J;
import cris.org.in.ima.fragment.NewBookingFragment;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.BookingResponseDTO;
import defpackage.Up;
import defpackage.d7;
import java.text.SimpleDateFormat;

/* renamed from: Sp  reason: default package */
/* compiled from: PopupMenu */
public final class Sp implements MenuBuilder.Callback {
    public final /* synthetic */ Up a;

    public Sp(Up up) {
        this.a = up;
    }

    public final boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        Up.a aVar = this.a.a;
        if (aVar == null) {
            return false;
        }
        String charSequence = menuItem.getTitle().toString();
        ErsDisplayFragment.o oVar = ErsDisplayFragment.o.this;
        boolean equals = charSequence.equals(ErsDisplayFragment.this.getString(R.string.opt_vikalp));
        ErsDisplayFragment ersDisplayFragment = ErsDisplayFragment.this;
        if (equals) {
            ersDisplayFragment.f4594c = false;
            BookingResponseDTO bookingResponseDTO = ersDisplayFragment.f4577a;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(ersDisplayFragment.getResources().getString(R.string.vikalpMessage));
            Context context = ersDisplayFragment.f4569a;
            Object obj = d7.a;
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(d7.b.a(context, R.color.light_yellow));
            StyleSpan styleSpan = new StyleSpan(1);
            C0550Ja ja = new C0550Ja(ersDisplayFragment);
            try {
                if (IrctcImaApplication.e.equalsIgnoreCase("hi")) {
                    spannableStringBuilder.setSpan(styleSpan, 66, 81, 18);
                    spannableStringBuilder.setSpan(ja, 66, 81, 33);
                    spannableStringBuilder.setSpan(foregroundColorSpan, 66, 81, 18);
                } else {
                    spannableStringBuilder.setSpan(styleSpan, 40, 50, 18);
                    spannableStringBuilder.setSpan(ja, 40, 50, 33);
                    spannableStringBuilder.setSpan(foregroundColorSpan, 40, 50, 18);
                }
            } catch (Exception e) {
                e.getMessage();
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(ersDisplayFragment.f4569a);
            TextView textView = new TextView(ersDisplayFragment.f4569a);
            builder.setTitle((CharSequence) ersDisplayFragment.getResources().getString(R.string.terms_tnc_vikalp));
            textView.setPadding(40, 30, 40, 0);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(40, 30, 50, 0);
            textView.setLayoutParams(layoutParams);
            builder.setView((View) textView);
            textView.setText(spannableStringBuilder);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            builder.setPositiveButton((CharSequence) ersDisplayFragment.getString(R.string.accept), (DialogInterface.OnClickListener) new C0563Ka(ersDisplayFragment, bookingResponseDTO));
            builder.setNegativeButton((CharSequence) ersDisplayFragment.getString(R.string.decline), (DialogInterface.OnClickListener) new C0576La());
            builder.show();
        }
        if (menuItem.getTitle().toString().equals(ersDisplayFragment.getString(R.string.cncel_Ticket))) {
            C0707Ue ue = ersDisplayFragment.a;
            if (!(ue == null || ue.getBookingResponseList() == null || ersDisplayFragment.a.getBookingResponseList().isEmpty() || ersDisplayFragment.a.getBookingResponseList().get(0).getMetroServiceDetail() == null)) {
                if (Integer.valueOf(ersDisplayFragment.a.getBookingResponseList().get(0).getMetroServiceDetail().getNumberOfCancelPsgn().shortValue()).intValue() - Integer.valueOf(ersDisplayFragment.a.getBookingResponseList().get(0).getMetroServiceDetail().getNumberOfPassengerOpted().shortValue()).intValue() == 0) {
                    ersDisplayFragment.f4590b = true;
                }
            }
            if (ersDisplayFragment.f4577a.getReservationStatus() == null || ((!ersDisplayFragment.f4577a.getReservationStatus().equalsIgnoreCase("WL Cancellation") && !ersDisplayFragment.f4577a.getReservationStatus().equalsIgnoreCase(ersDisplayFragment.getString(R.string.cancelled))) || !ersDisplayFragment.f4590b)) {
                Bundle bundle = new Bundle();
                ersDisplayFragment.f4594c = false;
                bundle.putSerializable("tkt", ersDisplayFragment.f4577a);
                CancelTicketDetailsFragment cancelTicketDetailsFragment = new CancelTicketDetailsFragment();
                cancelTicketDetailsFragment.setArguments(bundle);
                HomeActivity.n(ersDisplayFragment.getActivity(), cancelTicketDetailsFragment, xx.d(2), Boolean.TRUE, Boolean.FALSE);
            } else {
                C0535I5.t0(ersDisplayFragment.f4569a, ersDisplayFragment.getString(R.string.Ticket_Already_Cancelled));
            }
        }
        if (menuItem.getTitle().toString().equals(ersDisplayFragment.getString(R.string.book_Meal))) {
            ersDisplayFragment.k(ersDisplayFragment.f4577a.getPnrNumber(), "M");
        }
        if (menuItem.getTitle().toString().equals(ersDisplayFragment.getString(R.string.Current_Status))) {
            BookingResponseDTO bookingResponseDTO2 = ersDisplayFragment.f4577a;
            if (!C0535I5.O((ConnectivityManager) ersDisplayFragment.getActivity().getSystemService("connectivity"), ersDisplayFragment.f4569a)) {
                new Handler().postDelayed(new C0539Ia(), 5000);
            } else if (bookingResponseDTO2.getPsgnDtlList() == null || bookingResponseDTO2.getPsgnDtlList().size() == 0) {
                C0535I5.m(ersDisplayFragment.f4569a, false, ersDisplayFragment.getString(R.string.unable_fetch_ticket_status), ersDisplayFragment.getString(R.string.error), ersDisplayFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
            } else {
                ersDisplayFragment.f4585a = C0793b1.a.f3912a;
                ProgressDialog show = ProgressDialog.show(ersDisplayFragment.getContext(), ersDisplayFragment.getString(R.string.Fetching_Current_Status), ersDisplayFragment.getString(R.string.please_wait_text));
                ersDisplayFragment.f4568a = show;
                if (ersDisplayFragment.f4585a != null) {
                    show.show();
                    String f = C0657Qt.f();
                    String format = String.format("/%s", new Object[]{bookingResponseDTO2.getPnrNumber()});
                    ((Om) C0657Qt.c(ersDisplayFragment.f4585a)).W(f + "pnrenq" + format, (String) null).c(C1181iv.a()).a(E0.a()).b(new J(ersDisplayFragment, bookingResponseDTO2));
                }
            }
        }
        if (menuItem.getTitle().toString().equals(ersDisplayFragment.getString(R.string.changeBoardingPoint))) {
            ersDisplayFragment.f4594c = false;
            ersDisplayFragment.k(ersDisplayFragment.f4577a.getPnrNumber(), "B");
        }
        if (menuItem.getTitle().toString().equals(ersDisplayFragment.getString(R.string.rebook_ticket))) {
            HomeActivity.B(ersDisplayFragment.getActivity());
            Bundle bundle2 = new Bundle();
            bundle2.putString("fromStn", ersDisplayFragment.f4577a.getFromStn());
            bundle2.putString("toStn", ersDisplayFragment.f4577a.getDestStn());
            bundle2.putString("rebookDate", new SimpleDateFormat("yyyyMMdd").format(ersDisplayFragment.f4577a.getBoardingDate()));
            bundle2.putString("rebookClass", ersDisplayFragment.f4577a.getJourneyClass());
            bundle2.putString("rebookTrainNo", ersDisplayFragment.f4577a.getTrainNumber());
            bundle2.putBoolean("rebookFlag", true);
            bundle2.putSerializable("reebookPsgnList", ersDisplayFragment.f4593c);
            NewBookingFragment newBookingFragment = new NewBookingFragment();
            newBookingFragment.setArguments(bundle2);
            HomeActivity.n(ersDisplayFragment.getActivity(), newBookingFragment, C1218kf.NEW_BOOKING.a(), Boolean.TRUE, Boolean.FALSE);
        }
        return true;
    }

    public final void onMenuModeChange(MenuBuilder menuBuilder) {
    }
}
