package cris.org.in.ima.fragment;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.adaptors.TDRTicketAdapter;
import cris.org.in.ima.dto.oauth2.GoogleAdParamDTO;
import cris.org.in.ima.utils.TicketHistoryUtil;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.BookingResponseDTO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class TDRTicketFragment extends Fragment {
    public static FragmentActivity a;

    /* renamed from: a  reason: collision with other field name */
    public ProgressDialog f5139a = null;

    /* renamed from: a  reason: collision with other field name */
    public TDRTicketAdapter f5140a;

    /* renamed from: a  reason: collision with other field name */
    public final b f5141a = new b();

    /* renamed from: a  reason: collision with other field name */
    public ArrayList<BookingResponseDTO> f5142a;

    /* renamed from: a  reason: collision with other field name */
    public C1223kn f5143a;
    @BindView(2131362060)
    TextView booking;
    @BindView(2131362395)
    TextView departure;
    @BindView(2131362651)
    AdManagerAdView filetdr;
    @BindView(2131363975)
    TextView sort_by_spinner_text;
    @BindView(2131363978)
    RelativeLayout sortby_bottom_ll;
    @BindView(2131363838)
    RecyclerView tdrTicketList;
    @BindView(2131364080)
    AdManagerAdView tdrhistory_add_top;

    public class a extends ClickableSpan {
        public a() {
        }

        public final void onClick(View view) {
            TDRTicketFragment tDRTicketFragment = TDRTicketFragment.this;
            try {
                tDRTicketFragment.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.irctc.co.in")));
            } catch (Exception e) {
                FragmentActivity fragmentActivity = TDRTicketFragment.a;
                e.getMessage();
                Toast.makeText(tDRTicketFragment.getContext(), tDRTicketFragment.getString(R.string.No_application_handle_request), 1).show();
            }
        }
    }

    public class b implements TDRTicketAdapter.FileTdrListener {
        public b() {
        }

        public final void onLayoutClick(BookingResponseDTO bookingResponseDTO) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("tkt", bookingResponseDTO);
            TDRTicketDetailsFragment tDRTicketDetailsFragment = new TDRTicketDetailsFragment();
            tDRTicketDetailsFragment.setArguments(bundle);
            TDRTicketFragment tDRTicketFragment = TDRTicketFragment.this;
            HomeActivity.n(tDRTicketFragment.getActivity(), tDRTicketDetailsFragment, tDRTicketFragment.getString(R.string.FILE_TDR_CONFIRMATION), Boolean.TRUE, Boolean.FALSE);
        }
    }

    static {
        C1354qp.R(TDRTicketFragment.class);
    }

    @OnClick({2131362060})
    public void arrival(View view) {
        g(this.booking, R.color.dark);
        g(this.departure, R.color.white);
        this.departure.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.booking.setTextAppearance(getActivity(), R.style.fontForbold);
        h(2);
        this.sort_by_spinner_text.setText(getString(R.string.booking_date));
        this.sortby_bottom_ll.setVisibility(8);
    }

    @OnClick({2131362395})
    public void departure(View view) {
        g(this.booking, R.color.white);
        g(this.departure, R.color.dark);
        this.departure.setTextAppearance(getActivity(), R.style.fontForbold);
        this.booking.setTextAppearance(getActivity(), R.style.fontForNormal);
        h(1);
        this.sort_by_spinner_text.setText(getString(R.string.departure_date));
        this.sortby_bottom_ll.setVisibility(8);
    }

    public final void f(C0707Ue ue) {
        this.f5142a = ue.getBookingResponseList();
        this.f5140a = new TDRTicketAdapter(getActivity(), this.f5141a, ue.getBookingResponseList());
        this.tdrTicketList.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.tdrTicketList.setAdapter(this.f5140a);
        if (this.f5142a != null) {
            ArrayList<C0502Ez> tdrReasonList = ue.getTdrReasonList();
            HashMap<String, Integer> hashMap = new HashMap<>();
            ArrayList arrayList = new ArrayList();
            Iterator<C0502Ez> it = tdrReasonList.iterator();
            while (it.hasNext()) {
                C0502Ez next = it.next();
                hashMap.put(next.getTdrReason(), Integer.valueOf(next.getReasonIndex()));
                arrayList.add(next.getTdrReason());
            }
            HashMap<String, Integer> hashMap2 = C1450w1.f7011a;
            if (hashMap2 != null) {
                hashMap2.clear();
            }
            C1450w1.f7011a = hashMap;
            this.f5139a.dismiss();
            return;
        }
        this.f5139a.dismiss();
        C0535I5.p(a, false, getString(R.string.file_tdr_txt), getString(R.string.No_ticket_booked), getString(R.string.OK), (DialogInterface.OnClickListener) null, (String) null, (DialogInterface.OnClickListener) null).show();
    }

    public final void g(TextView textView, int i) {
        for (Drawable drawable : textView.getCompoundDrawables()) {
            if (drawable != null) {
                drawable.setColorFilter(new PorterDuffColorFilter(getResources().getColor(i), PorterDuff.Mode.SRC_IN));
            }
        }
    }

    public final void h(int i) {
        ArrayList<BookingResponseDTO> arrayList = this.f5142a;
        if (arrayList != null && arrayList.size() != 0) {
            ArrayList<BookingResponseDTO> arrayList2 = this.f5142a;
            if (arrayList2 == null) {
                arrayList2 = null;
            } else if (i == 1) {
                Collections.sort(arrayList2, new C1207jz());
            } else if (i == 2) {
                Collections.sort(arrayList2, new C1231kz());
            }
            this.f5142a = arrayList2;
            this.f5140a.notifyDataSetChanged();
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_file_tdr, (ViewGroup) null);
        ButterKnife.bind((Object) this, inflate);
        new a();
        FragmentActivity activity = getActivity();
        a = activity;
        if (!C0535I5.O((ConnectivityManager) activity.getSystemService("connectivity"), a)) {
            new Handler().postDelayed(new C1249lz(), 5000);
        } else {
            this.f5139a = ProgressDialog.show(getActivity(), getString(R.string.fetching_ticket_List), getString(R.string.please_wait_text));
            C1223kn knVar = C0793b1.a.f3912a;
            this.f5143a = knVar;
            if (knVar == null) {
                TicketHistoryUtil.c();
            }
            try {
                C0707Ue ue = TicketHistoryUtil.f5368a;
                if (ue != null) {
                    f(ue);
                } else {
                    String f = C0657Qt.f();
                    ((Om) C0657Qt.c(this.f5143a)).N(f + "tktEligibleForTDR").c(C1181iv.a()).a(E0.a()).b(new C1269mz(this));
                }
            } catch (Exception e) {
                this.f5139a.dismiss();
                e.getMessage();
                C0535I5.t0(getActivity(), getString(R.string.please_try_again));
            }
        }
        GoogleAdParamDTO googleAdParamDTO = new GoogleAdParamDTO();
        googleAdParamDTO.setAge(C1450w1.f7009a);
        googleAdParamDTO.setGender(C1450w1.f7021c);
        C0535I5.Y(getActivity(), this.filetdr, googleAdParamDTO);
        C0535I5.Y(getActivity(), this.tdrhistory_add_top, googleAdParamDTO);
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
