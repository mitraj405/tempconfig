package cris.org.in.ima.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import cris.org.in.prs.ima.R;

public class MetroTicketDetailsFragment_ViewBinding implements Unbinder {
    public MetroTicketDetailsFragment a;

    public MetroTicketDetailsFragment_ViewBinding(MetroTicketDetailsFragment metroTicketDetailsFragment, View view) {
        this.a = metroTicketDetailsFragment;
        Class cls = RecyclerView.class;
        metroTicketDetailsFragment.dmrcQrCodeViewPager = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.dmrc_qr_code_view_pager, "field 'dmrcQrCodeViewPager'", cls);
        Class cls2 = TextView.class;
        metroTicketDetailsFragment.dmrcFromStn = (TextView) Utils.findRequiredViewAsType(view, R.id.dmrc_fromStn, "field 'dmrcFromStn'", cls2);
        metroTicketDetailsFragment.dmrcToStn = (TextView) Utils.findRequiredViewAsType(view, R.id.dmrc_toStn, "field 'dmrcToStn'", cls2);
        metroTicketDetailsFragment.noOfPassenger = (TextView) Utils.findRequiredViewAsType(view, R.id.num_of_passenger, "field 'noOfPassenger'", cls2);
        metroTicketDetailsFragment.no_of_tickets = (TextView) Utils.findRequiredViewAsType(view, R.id.no_of_tickets, "field 'no_of_tickets'", cls2);
        metroTicketDetailsFragment.transactionId = (TextView) Utils.findRequiredViewAsType(view, R.id.transaction_id, "field 'transactionId'", cls2);
        metroTicketDetailsFragment.bookingDate = (TextView) Utils.findRequiredViewAsType(view, R.id.booking_date, "field 'bookingDate'", cls2);
        metroTicketDetailsFragment.qr_no = (TextView) Utils.findRequiredViewAsType(view, R.id.qr_no, "field 'qr_no'", cls2);
        metroTicketDetailsFragment.indicator_rv = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.indicator_rv, "field 'indicator_rv'", cls);
        Class cls3 = ImageView.class;
        metroTicketDetailsFragment.right_arrow = (ImageView) Utils.findRequiredViewAsType(view, R.id.right_arrow, "field 'right_arrow'", cls3);
        metroTicketDetailsFragment.left_arrow = (ImageView) Utils.findRequiredViewAsType(view, R.id.left_arrow, "field 'left_arrow'", cls3);
        Class cls4 = LinearLayout.class;
        metroTicketDetailsFragment.dmrcTicketDetailsRl = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.dmrc_ticketDetails_rl, "field 'dmrcTicketDetailsRl'", cls4);
        metroTicketDetailsFragment.qrImagelayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.qrImage_layout, "field 'qrImagelayout'", cls4);
        metroTicketDetailsFragment.qrImg = (ImageView) Utils.findRequiredViewAsType(view, R.id.qrImg, "field 'qrImg'", cls3);
        metroTicketDetailsFragment.qrImgCross = (ImageView) Utils.findRequiredViewAsType(view, R.id.qrImgCross, "field 'qrImgCross'", cls3);
        metroTicketDetailsFragment.dmrc_congratulation_msg = (TextView) Utils.findRequiredViewAsType(view, R.id.dmrc_congratulation_msg, "field 'dmrc_congratulation_msg'", cls2);
        metroTicketDetailsFragment.tickets_validity_infoMsg_txt = (TextView) Utils.findRequiredViewAsType(view, R.id.tickets_validity_infoMsg_txt, "field 'tickets_validity_infoMsg_txt'", cls2);
        metroTicketDetailsFragment.phone_screen_with_scratches = (TextView) Utils.findRequiredViewAsType(view, R.id.phone_screen_with_scratches, "field 'phone_screen_with_scratches'", cls2);
    }

    public final void unbind() {
        MetroTicketDetailsFragment metroTicketDetailsFragment = this.a;
        if (metroTicketDetailsFragment != null) {
            this.a = null;
            metroTicketDetailsFragment.dmrcQrCodeViewPager = null;
            metroTicketDetailsFragment.dmrcFromStn = null;
            metroTicketDetailsFragment.dmrcToStn = null;
            metroTicketDetailsFragment.noOfPassenger = null;
            metroTicketDetailsFragment.no_of_tickets = null;
            metroTicketDetailsFragment.transactionId = null;
            metroTicketDetailsFragment.bookingDate = null;
            metroTicketDetailsFragment.qr_no = null;
            metroTicketDetailsFragment.indicator_rv = null;
            metroTicketDetailsFragment.right_arrow = null;
            metroTicketDetailsFragment.left_arrow = null;
            metroTicketDetailsFragment.dmrcTicketDetailsRl = null;
            metroTicketDetailsFragment.qrImagelayout = null;
            metroTicketDetailsFragment.qrImg = null;
            metroTicketDetailsFragment.qrImgCross = null;
            metroTicketDetailsFragment.dmrc_congratulation_msg = null;
            metroTicketDetailsFragment.tickets_validity_infoMsg_txt = null;
            metroTicketDetailsFragment.phone_screen_with_scratches = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
