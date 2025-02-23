package cris.org.in.ima.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import cris.org.in.prs.ima.R;

public class BookMealFragment_ViewBinding implements Unbinder {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public BookMealFragment f4468a;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ BookMealFragment a;

        public a(BookMealFragment bookMealFragment) {
            this.a = bookMealFragment;
        }

        public final void doClick(View view) {
            this.a.hj();
        }
    }

    public BookMealFragment_ViewBinding(BookMealFragment bookMealFragment, View view) {
        this.f4468a = bookMealFragment;
        bookMealFragment.passengerList = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_passenger_list, "field 'passengerList'", RecyclerView.class);
        Class cls = TextView.class;
        bookMealFragment.pnr = (TextView) Utils.findRequiredViewAsType(view, R.id.pnr, "field 'pnr'", cls);
        bookMealFragment.trainno = (TextView) Utils.findRequiredViewAsType(view, R.id.train_no, "field 'trainno'", cls);
        bookMealFragment.trainName = (TextView) Utils.findRequiredViewAsType(view, R.id.train_name, "field 'trainName'", cls);
        bookMealFragment.tvFavpnricon = (ImageView) Utils.findRequiredViewAsType(view, R.id.tv_favpnricon, "field 'tvFavpnricon'", ImageView.class);
        bookMealFragment.journeyDate = (TextView) Utils.findRequiredViewAsType(view, R.id.journey_date, "field 'journeyDate'", cls);
        bookMealFragment.journeyTime = (TextView) Utils.findRequiredViewAsType(view, R.id.journey_time, "field 'journeyTime'", cls);
        bookMealFragment.destArrDate = (TextView) Utils.findRequiredViewAsType(view, R.id.dest_arr_date, "field 'destArrDate'", cls);
        bookMealFragment.destArrTime = (TextView) Utils.findRequiredViewAsType(view, R.id.dest_arr_time, "field 'destArrTime'", cls);
        bookMealFragment.tktDetails = (TextView) Utils.findRequiredViewAsType(view, R.id.tkt_details, "field 'tktDetails'", cls);
        bookMealFragment.tocitycode = (TextView) Utils.findRequiredViewAsType(view, R.id.tocitycode, "field 'tocitycode'", cls);
        bookMealFragment.fromcitycode = (TextView) Utils.findRequiredViewAsType(view, R.id.fromcidtycode, "field 'fromcitycode'", cls);
        bookMealFragment.travel_time = (TextView) Utils.findRequiredViewAsType(view, R.id.travel_time, "field 'travel_time'", cls);
        bookMealFragment.traveltime2 = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.travel_time2, "field 'traveltime2'", LinearLayout.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.optMeal, "method 'hj'");
        this.a = findRequiredView;
        findRequiredView.setOnClickListener(new a(bookMealFragment));
    }

    public final void unbind() {
        BookMealFragment bookMealFragment = this.f4468a;
        if (bookMealFragment != null) {
            this.f4468a = null;
            bookMealFragment.passengerList = null;
            bookMealFragment.pnr = null;
            bookMealFragment.trainno = null;
            bookMealFragment.trainName = null;
            bookMealFragment.tvFavpnricon = null;
            bookMealFragment.journeyDate = null;
            bookMealFragment.journeyTime = null;
            bookMealFragment.destArrDate = null;
            bookMealFragment.destArrTime = null;
            bookMealFragment.tktDetails = null;
            bookMealFragment.tocitycode = null;
            bookMealFragment.fromcitycode = null;
            bookMealFragment.travel_time = null;
            bookMealFragment.traveltime2 = null;
            this.a.setOnClickListener((View.OnClickListener) null);
            this.a = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
