package cris.org.in.ima.fragment;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import cris.org.in.prs.ima.R;

public class ReviewMetroJourneyFragment_ViewBinding implements Unbinder {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public ReviewMetroJourneyFragment f5109a;
    public View b;
    public View c;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ ReviewMetroJourneyFragment a;

        public a(ReviewMetroJourneyFragment reviewMetroJourneyFragment) {
            this.a = reviewMetroJourneyFragment;
        }

        public final void doClick(View view) {
            this.a.onDmrcMakePayment();
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ ReviewMetroJourneyFragment a;

        public b(ReviewMetroJourneyFragment reviewMetroJourneyFragment) {
            this.a = reviewMetroJourneyFragment;
        }

        public final void doClick(View view) {
            this.a.onFare(view);
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ ReviewMetroJourneyFragment a;

        public c(ReviewMetroJourneyFragment reviewMetroJourneyFragment) {
            this.a = reviewMetroJourneyFragment;
        }

        public final void doClick(View view) {
            this.a.onFareBrakeUp(view);
        }
    }

    public ReviewMetroJourneyFragment_ViewBinding(ReviewMetroJourneyFragment reviewMetroJourneyFragment, View view) {
        this.f5109a = reviewMetroJourneyFragment;
        Class cls = TextView.class;
        reviewMetroJourneyFragment.termcondition = (TextView) Utils.findRequiredViewAsType(view, R.id.termcondition, "field 'termcondition'", cls);
        reviewMetroJourneyFragment.fromStnDmrc = (TextView) Utils.findRequiredViewAsType(view, R.id.fromStnDmrc, "field 'fromStnDmrc'", cls);
        reviewMetroJourneyFragment.dmrcFromStnLine = (TextView) Utils.findRequiredViewAsType(view, R.id.metroLine_txt, "field 'dmrcFromStnLine'", cls);
        reviewMetroJourneyFragment.dmrcToStnLine = (TextView) Utils.findRequiredViewAsType(view, R.id.toMetroLine_txt, "field 'dmrcToStnLine'", cls);
        reviewMetroJourneyFragment.dmrcJdate = (TextView) Utils.findRequiredViewAsType(view, R.id.dmrc_Jdate, "field 'dmrcJdate'", cls);
        reviewMetroJourneyFragment.toStnDmrc = (TextView) Utils.findRequiredViewAsType(view, R.id.toStnDmrc, "field 'toStnDmrc'", cls);
        View findRequiredView = Utils.findRequiredView(view, R.id.dmrc_make_payment, "field 'dmrcmakepayment' and method 'onDmrcMakePayment'");
        reviewMetroJourneyFragment.dmrcmakepayment = (TextView) Utils.castView(findRequiredView, R.id.dmrc_make_payment, "field 'dmrcmakepayment'", cls);
        this.a = findRequiredView;
        findRequiredView.setOnClickListener(new a(reviewMetroJourneyFragment));
        reviewMetroJourneyFragment.totalpsng = (TextView) Utils.findRequiredViewAsType(view, R.id.no_of_psgn, "field 'totalpsng'", cls);
        reviewMetroJourneyFragment.pnrNumber = (TextView) Utils.findRequiredViewAsType(view, R.id.pnr_number, "field 'pnrNumber'", cls);
        reviewMetroJourneyFragment.dmrcTicketSentLevelView = (TextView) Utils.findRequiredViewAsType(view, R.id.dmrc_ticket_sent_level, "field 'dmrcTicketSentLevelView'", cls);
        reviewMetroJourneyFragment.dmrcFare = (TextView) Utils.findRequiredViewAsType(view, R.id.dmrc_fare, "field 'dmrcFare'", cls);
        reviewMetroJourneyFragment.tkt_fare = (TextView) Utils.findRequiredViewAsType(view, R.id.tkt_fare, "field 'tkt_fare'", cls);
        reviewMetroJourneyFragment.cnvnce_fare = (TextView) Utils.findRequiredViewAsType(view, R.id.cnvnce_fare, "field 'cnvnce_fare'", cls);
        reviewMetroJourneyFragment.total_amount = (TextView) Utils.findRequiredViewAsType(view, R.id.total_amount, "field 'total_amount'", cls);
        reviewMetroJourneyFragment.psgn_with_tkt = (TextView) Utils.findRequiredViewAsType(view, R.id.psgn_with_tkt, "field 'psgn_with_tkt'", cls);
        View findRequiredView2 = Utils.findRequiredView(view, R.id.fare_enquiry_bottom_ll, "field 'fare_enquiry_bottom_ll' and method 'onFare'");
        reviewMetroJourneyFragment.fare_enquiry_bottom_ll = (RelativeLayout) Utils.castView(findRequiredView2, R.id.fare_enquiry_bottom_ll, "field 'fare_enquiry_bottom_ll'", RelativeLayout.class);
        this.b = findRequiredView2;
        findRequiredView2.setOnClickListener(new b(reviewMetroJourneyFragment));
        View findRequiredView3 = Utils.findRequiredView(view, R.id.fare_brakeup_ll, "method 'onFareBrakeUp'");
        this.c = findRequiredView3;
        findRequiredView3.setOnClickListener(new c(reviewMetroJourneyFragment));
    }

    public final void unbind() {
        ReviewMetroJourneyFragment reviewMetroJourneyFragment = this.f5109a;
        if (reviewMetroJourneyFragment != null) {
            this.f5109a = null;
            reviewMetroJourneyFragment.termcondition = null;
            reviewMetroJourneyFragment.fromStnDmrc = null;
            reviewMetroJourneyFragment.dmrcFromStnLine = null;
            reviewMetroJourneyFragment.dmrcToStnLine = null;
            reviewMetroJourneyFragment.dmrcJdate = null;
            reviewMetroJourneyFragment.toStnDmrc = null;
            reviewMetroJourneyFragment.dmrcmakepayment = null;
            reviewMetroJourneyFragment.totalpsng = null;
            reviewMetroJourneyFragment.pnrNumber = null;
            reviewMetroJourneyFragment.dmrcTicketSentLevelView = null;
            reviewMetroJourneyFragment.dmrcFare = null;
            reviewMetroJourneyFragment.tkt_fare = null;
            reviewMetroJourneyFragment.cnvnce_fare = null;
            reviewMetroJourneyFragment.total_amount = null;
            reviewMetroJourneyFragment.psgn_with_tkt = null;
            reviewMetroJourneyFragment.fare_enquiry_bottom_ll = null;
            this.a.setOnClickListener((View.OnClickListener) null);
            this.a = null;
            this.b.setOnClickListener((View.OnClickListener) null);
            this.b = null;
            this.c.setOnClickListener((View.OnClickListener) null);
            this.c = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
