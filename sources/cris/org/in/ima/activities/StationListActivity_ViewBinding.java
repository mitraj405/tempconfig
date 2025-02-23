package cris.org.in.ima.activities;

import android.annotation.SuppressLint;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import cris.org.in.prs.ima.R;

public class StationListActivity_ViewBinding implements Unbinder {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public StationListActivity f4362a;

    /* renamed from: a  reason: collision with other field name */
    public a f4363a;
    public View b;

    public class b implements View.OnTouchListener {
        public final /* synthetic */ StationListActivity a;

        public b(StationListActivity stationListActivity) {
            this.a = stationListActivity;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            return this.a.stationSerchClick();
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ StationListActivity a;

        public c(StationListActivity stationListActivity) {
            this.a = stationListActivity;
        }

        public final void doClick(View view) {
            this.a.backClick();
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public StationListActivity_ViewBinding(StationListActivity stationListActivity, View view) {
        this.f4362a = stationListActivity;
        Class cls = RecyclerView.class;
        stationListActivity.stationList = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_station_list, "field 'stationList'", cls);
        View findRequiredView = Utils.findRequiredView(view, R.id.tv_search_text, "field 'stationSearch', method 'stationSearchChange', and method 'stationSerchClick'");
        stationListActivity.stationSearch = (EditText) Utils.castView(findRequiredView, R.id.tv_search_text, "field 'stationSearch'", EditText.class);
        this.a = findRequiredView;
        a aVar = new a(stationListActivity);
        this.f4363a = aVar;
        ((TextView) findRequiredView).addTextChangedListener(aVar);
        findRequiredView.setOnTouchListener(new b(stationListActivity));
        Class cls2 = TextView.class;
        stationListActivity.recentStationSearch = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_recent_search, "field 'recentStationSearch'", cls2);
        Class cls3 = LinearLayout.class;
        stationListActivity.popularLl = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.popular_ll, "field 'popularLl'", cls3);
        stationListActivity.txpopular = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_popular, "field 'txpopular'", cls2);
        stationListActivity.rvPopularstationList = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_popularstation_list, "field 'rvPopularstationList'", cls);
        stationListActivity.favourityLl = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.favourity_ll, "field 'favourityLl'", cls3);
        stationListActivity.txfavourite = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_favourite, "field 'txfavourite'", cls2);
        stationListActivity.rvFavouriteList = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_favourite_list, "field 'rvFavouriteList'", cls);
        stationListActivity.publisherAdView = (AdManagerAdView) Utils.findRequiredViewAsType(view, R.id.publisherAdView, "field 'publisherAdView'", AdManagerAdView.class);
        stationListActivity.view_recentsearch = Utils.findRequiredView(view, R.id.view_recentsearch, "field 'view_recentsearch'");
        View findRequiredView2 = Utils.findRequiredView(view, R.id.back, "method 'backClick'");
        this.b = findRequiredView2;
        findRequiredView2.setOnClickListener(new c(stationListActivity));
    }

    public final void unbind() {
        StationListActivity stationListActivity = this.f4362a;
        if (stationListActivity != null) {
            this.f4362a = null;
            stationListActivity.stationList = null;
            stationListActivity.stationSearch = null;
            stationListActivity.recentStationSearch = null;
            stationListActivity.popularLl = null;
            stationListActivity.txpopular = null;
            stationListActivity.rvPopularstationList = null;
            stationListActivity.favourityLl = null;
            stationListActivity.txfavourite = null;
            stationListActivity.rvFavouriteList = null;
            stationListActivity.publisherAdView = null;
            stationListActivity.view_recentsearch = null;
            ((TextView) this.a).removeTextChangedListener(this.f4363a);
            this.f4363a = null;
            this.a.setOnTouchListener((View.OnTouchListener) null);
            this.a = null;
            this.b.setOnClickListener((View.OnClickListener) null);
            this.b = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }

    public class a implements TextWatcher {
        public final /* synthetic */ StationListActivity a;

        public a(StationListActivity stationListActivity) {
            this.a = stationListActivity;
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.a.stationSearchChange(charSequence);
        }

        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}
