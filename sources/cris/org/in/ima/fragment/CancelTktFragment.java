package cris.org.in.ima.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.adaptors.CancelTicketItemAdapter;
import cris.org.in.ima.dto.oauth2.GoogleAdParamDTO;
import cris.org.in.ima.utils.TicketHistoryUtil;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.BookingResponseDTO;
import java.util.ArrayList;
import java.util.Collections;

public class CancelTktFragment extends Fragment {
    public static final /* synthetic */ int c = 0;
    public ProgressDialog a = null;

    /* renamed from: a  reason: collision with other field name */
    public Context f4498a;

    /* renamed from: a  reason: collision with other field name */
    public FragmentActivity f4499a;

    /* renamed from: a  reason: collision with other field name */
    public CancelTicketItemAdapter f4500a;

    /* renamed from: a  reason: collision with other field name */
    public ArrayList<BookingResponseDTO> f4501a;

    /* renamed from: a  reason: collision with other field name */
    public C1223kn f4502a;
    @BindView(2131362060)
    TextView booking;
    @BindView(2131363807)
    RecyclerView bookingItems;
    @BindView(2131362158)
    AdManagerAdView cancelTicketBottom;
    @BindView(2131362118)
    AdManagerAdView cancel_tkt_top;
    @BindView(2131362395)
    TextView departure;
    @BindView(2131363975)
    TextView sort_by_spinner_text;
    @BindView(2131363978)
    RelativeLayout sortby_bottom_ll;

    static {
        C1354qp.R(CancelTktFragment.class);
    }

    @OnClick({2131362060})
    public void arrival(View view) {
        f(this.booking, R.color.dark);
        f(this.departure, R.color.white);
        this.departure.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.booking.setTextAppearance(getActivity(), R.style.fontForbold);
        g(2);
        this.sort_by_spinner_text.setText("Booking Date");
        this.sortby_bottom_ll.setVisibility(8);
    }

    @OnClick({2131362395})
    public void departure(View view) {
        f(this.booking, R.color.white);
        f(this.departure, R.color.dark);
        this.departure.setTextAppearance(getActivity(), R.style.fontForbold);
        this.booking.setTextAppearance(getActivity(), R.style.fontForNormal);
        g(1);
        this.sort_by_spinner_text.setText("Departure Date");
        this.sortby_bottom_ll.setVisibility(8);
    }

    public final void f(TextView textView, int i) {
        for (Drawable drawable : textView.getCompoundDrawables()) {
            if (drawable != null) {
                drawable.setColorFilter(new PorterDuffColorFilter(getResources().getColor(i), PorterDuff.Mode.SRC_IN));
            }
        }
    }

    public final void g(int i) {
        ArrayList<BookingResponseDTO> arrayList = this.f4501a;
        if (arrayList == null || arrayList.size() == 0) {
            arrayList = null;
        } else if (i == 1) {
            Collections.sort(arrayList, new C1297o4());
        } else if (i == 2) {
            Collections.sort(arrayList, new C1317p4());
        }
        this.f4501a = arrayList;
        this.f4500a.notifyDataSetChanged();
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_cancel_ticket, (ViewGroup) null);
        ButterKnife.bind((Object) this, inflate);
        this.f4498a = getContext();
        this.f4499a = getActivity();
        if (!C0535I5.O((ConnectivityManager) this.f4498a.getSystemService("connectivity"), this.f4498a)) {
            new Handler().postDelayed(new C1209k4(), 5000);
        } else {
            this.a = ProgressDialog.show(getActivity(), getString(R.string.fetching_ticket_List), getString(R.string.please_wait_text));
            C1223kn knVar = C0793b1.a.f3912a;
            this.f4502a = knVar;
            if (knVar == null) {
                TicketHistoryUtil.c();
            }
            try {
                ArrayList<BookingResponseDTO> arrayList = this.f4501a;
                if (arrayList == null || arrayList.size() <= 0) {
                    String f = C0657Qt.f();
                    ((Om) C0657Qt.c(this.f4502a)).K0(f + "tktEligibleForCancellation").c(C1181iv.a()).a(E0.a()).b(new C(this));
                } else {
                    this.f4500a = new CancelTicketItemAdapter(this.f4498a, new C1235l4(this), this.f4501a);
                    this.bookingItems.setLayoutManager(new LinearLayoutManager(this.f4499a));
                    this.bookingItems.setAdapter(this.f4500a);
                    this.a.dismiss();
                }
            } catch (Exception e) {
                e.getMessage();
                this.a.dismiss();
                C0535I5.t0(getActivity(), getString(R.string.please_try_again));
            }
        }
        GoogleAdParamDTO googleAdParamDTO = new GoogleAdParamDTO();
        googleAdParamDTO.setAge(C1450w1.f7009a);
        googleAdParamDTO.setGender(C1450w1.f7021c);
        C0535I5.Y(getActivity(), this.cancelTicketBottom, googleAdParamDTO);
        C0535I5.Y(getActivity(), this.cancel_tkt_top, googleAdParamDTO);
        HomeActivity.J();
        return inflate;
    }

    @OnClick({2131363979})
    public void sortByClick() {
        this.sortby_bottom_ll.setVisibility(8);
        if (this.sortby_bottom_ll.getVisibility() == 8) {
            this.sortby_bottom_ll.setVisibility(0);
        } else {
            this.sortby_bottom_ll.setVisibility(8);
        }
    }

    @OnClick({2131363978})
    public void sortSelectClick() {
        if (this.sortby_bottom_ll.getVisibility() == 8) {
            this.sortby_bottom_ll.setVisibility(0);
        } else {
            this.sortby_bottom_ll.setVisibility(8);
        }
    }
}
