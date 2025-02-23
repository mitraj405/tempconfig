package cris.org.in.ima.fragment;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import cris.org.in.ima.IrctcImaApplication;
import cris.org.in.ima.activities.DmrcStationActivity;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.DmrcstatsionDto;
import defpackage.d7;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import rx.Observable;
import rx.Subscriber;

public class DelhiMetroFragment extends Fragment {
    public static final /* synthetic */ int j = 0;
    public DmrcstatsionDto a;

    /* renamed from: a  reason: collision with other field name */
    public ArrayList<C1322p9> f4529a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    public Date f4530a;

    /* renamed from: a  reason: collision with other field name */
    public final HashMap<String, List> f4531a = new HashMap<>();

    /* renamed from: a  reason: collision with other field name */
    public boolean f4532a = false;
    public DmrcstatsionDto b;

    /* renamed from: b  reason: collision with other field name */
    public Date f4533b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f4534b = false;
    public int c;

    /* renamed from: c  reason: collision with other field name */
    public String f4535c = " ";

    /* renamed from: c  reason: collision with other field name */
    public Date f4536c = null;
    public int d;

    /* renamed from: d  reason: collision with other field name */
    public String f4537d = " ";
    @BindView(2131362423)
    TextView dmrcFromStnLine;
    @BindView(2131362887)
    ImageView dmrcPlusIcon;
    @BindView(2131361817)
    LinearLayout dmrcSelectJourneyDate;
    @BindView(2131362434)
    TextView dmrcToStnLine;
    @BindView(2131362438)
    TextView dmrcTrainTiminglink;
    @BindView(2131362382)
    ImageView dmrccalender;
    @BindView(2131362422)
    TextView dmrcfromStnName;
    @BindView(2131362383)
    TextView dmrcjourneydate;
    @BindView(2131362384)
    TextView dmrcjourneydatelabel;
    @BindView(2131362886)
    ImageView dmrcminIcon;
    @BindView(2131364374)
    TextView dmrcsearch;
    @BindView(2131362433)
    TextView dmrctoStnName;
    @BindView(2131362440)
    TextView dmrctomorrowDate;
    @BindView(2131362435)
    LinearLayout dmrctomorrow_ll;
    @BindView(2131362441)
    TextView dmrctomorrowlabel;
    public int e;

    /* renamed from: e  reason: collision with other field name */
    public String f4538e;
    public int f;

    /* renamed from: f  reason: collision with other field name */
    public String f4539f;
    public int g;

    /* renamed from: g  reason: collision with other field name */
    public String f4540g;
    public int h;

    /* renamed from: h  reason: collision with other field name */
    public String f4541h;
    public int i;

    /* renamed from: i  reason: collision with other field name */
    public String f4542i;

    /* renamed from: j  reason: collision with other field name */
    public String f4543j;
    public String k = null;
    public String l = null;
    @BindView(2131362995)
    TextView linkedPnrNumber;
    public String m = "";
    public String n = "";
    @BindView(2131363332)
    TextView noOfPassenger;
    @BindView(2131362430)
    LinearLayout stnrotation;

    public class a extends TypeToken<ArrayList<C1322p9>> {
    }

    public class b implements Comparator<DmrcstatsionDto> {
        public final int compare(Object obj, Object obj2) {
            return Integer.compare((int) ((DmrcstatsionDto) obj).getDistance(), (int) ((DmrcstatsionDto) obj2).getDistance());
        }
    }

    public class c implements Comparator<DmrcstatsionDto> {
        public final int compare(Object obj, Object obj2) {
            return Integer.compare((int) ((DmrcstatsionDto) obj).getDistance(), (int) ((DmrcstatsionDto) obj2).getDistance());
        }
    }

    public class d implements Runnable {
        public d() {
        }

        public final void run() {
            DelhiMetroFragment.this.f4534b = false;
        }
    }

    public class f extends Subscriber<C0781ac> {
        public final /* synthetic */ ProgressDialog a;

        public f(ProgressDialog progressDialog) {
            this.a = progressDialog;
        }

        public final void onCompleted() {
            int i = DelhiMetroFragment.j;
        }

        public final void onError(Throwable th) {
            int i = DelhiMetroFragment.j;
            th.getClass();
            th.getMessage();
            this.a.dismiss();
            Lt.a(true, th);
        }

        public final void onNext(Object obj) {
            C0781ac acVar = (C0781ac) obj;
            ProgressDialog progressDialog = this.a;
            DelhiMetroFragment delhiMetroFragment = DelhiMetroFragment.this;
            if (acVar != null) {
                int i = DelhiMetroFragment.j;
                try {
                    if (acVar.getError() == null) {
                        Bundle bundle = new Bundle();
                        bundle.putString("JourneyDate", delhiMetroFragment.f4541h);
                        bundle.putSerializable("fetchFareResponseDTO", acVar);
                        bundle.putString("FromStationString", delhiMetroFragment.f4535c);
                        bundle.putString("FromStationMetroLine", String.valueOf(delhiMetroFragment.h));
                        bundle.putString("ToStationString", delhiMetroFragment.f4537d);
                        bundle.putString("ToStationMetroLine", String.valueOf(delhiMetroFragment.i));
                        bundle.putInt("noOfPsng", acVar.getPsgnCount());
                        bundle.putString("pnr", delhiMetroFragment.k);
                        bundle.putString("transactionId", delhiMetroFragment.l);
                        bundle.putString("TotalFare", String.valueOf(acVar.getTotalPayableAmount()));
                        bundle.putString("TotalStation", acVar.getStations());
                        bundle.putSerializable("bankDetailsDTO", (Serializable) acVar.getBankDetailDTO());
                        delhiMetroFragment.f4532a = true;
                        progressDialog.dismiss();
                        ReviewMetroJourneyFragment reviewMetroJourneyFragment = new ReviewMetroJourneyFragment();
                        reviewMetroJourneyFragment.setArguments(bundle);
                        HomeActivity.n(delhiMetroFragment.getActivity(), reviewMetroJourneyFragment, C1218kf.Review_Metro_Journey.a(), Boolean.TRUE, Boolean.FALSE);
                        return;
                    }
                    progressDialog.dismiss();
                    C0535I5.m(delhiMetroFragment.getActivity(), false, acVar.getError(), delhiMetroFragment.getString(R.string.error), delhiMetroFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                } catch (Exception e) {
                    int i2 = DelhiMetroFragment.j;
                    e.getMessage();
                    progressDialog.dismiss();
                    C0535I5.t0(delhiMetroFragment.getActivity(), delhiMetroFragment.getString(R.string.please_try_again));
                }
            } else {
                progressDialog.dismiss();
                C0535I5.m(delhiMetroFragment.getActivity(), false, delhiMetroFragment.getResources().getString(R.string.unable_process_message), delhiMetroFragment.getString(R.string.error), delhiMetroFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
            }
        }
    }

    public class g implements DatePickerDialog.OnDateSetListener {
        public g() {
        }

        public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            DelhiMetroFragment delhiMetroFragment = DelhiMetroFragment.this;
            delhiMetroFragment.c = i;
            delhiMetroFragment.d = i2;
            delhiMetroFragment.e = i3;
            delhiMetroFragment.getClass();
            GregorianCalendar gregorianCalendar = new GregorianCalendar(delhiMetroFragment.c, delhiMetroFragment.d, delhiMetroFragment.e);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
            String format = new SimpleDateFormat("EEE dd MMM").format(gregorianCalendar.getTime());
            delhiMetroFragment.dmrcjourneydate.setContentDescription(new SimpleDateFormat("EEEE").format(gregorianCalendar.getTime()));
            delhiMetroFragment.dmrcjourneydate.setText(format);
            delhiMetroFragment.f4540g = simpleDateFormat.format(gregorianCalendar.getTime());
            delhiMetroFragment.f();
        }
    }

    static {
        C1354qp.R(DelhiMetroFragment.class);
    }

    public final void f() {
        ImageView imageView = this.dmrccalender;
        FragmentActivity activity = getActivity();
        Object obj = d7.a;
        imageView.setColorFilter(d7.b.a(activity, R.color.red), PorterDuff.Mode.MULTIPLY);
        this.dmrcjourneydate.setTextColor(getResources().getColor(R.color.dark));
        this.dmrcjourneydatelabel.setTextColor(getResources().getColor(R.color.dark));
        this.dmrctomorrow_ll.setBackground(d7.a.b(getActivity(), R.drawable.round_light_corner));
        this.dmrctomorrowDate.setTextColor(getResources().getColor(R.color.colorAccent));
        this.dmrctomorrowlabel.setTextColor(getResources().getColor(R.color.colorAccent));
        this.dmrcSelectJourneyDate.setBackground(d7.a.b(getActivity(), R.drawable.round_light_corner));
        this.dmrcSelectJourneyDate.setBackground(d7.a.b(getActivity(), R.drawable.round_red_corner));
    }

    public final void g() {
        if (!C0535I5.O((ConnectivityManager) getActivity().getSystemService("connectivity"), getContext())) {
            new Handler().postDelayed(new e(), 5000);
            return;
        }
        String str = this.f4535c;
        if (str == null || this.f4537d == null || str.equals("") || this.f4537d.equals("")) {
            C0535I5.m(getActivity(), false, getResources().getString(R.string.station_selection_error_message), getString(R.string.error), getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
            return;
        }
        this.f4541h = this.dmrcjourneydate.getText().toString().trim();
        this.g = Integer.parseInt(this.noOfPassenger.getText().toString().trim());
        try {
            ProgressDialog show = ProgressDialog.show(getActivity(), getString(R.string.dmrc_Search), getString(R.string.please_wait_text));
            show.show();
            C0766Zb zb = new C0766Zb();
            Xp xp = new Xp();
            xp.setServiceId(2);
            xp.setPassengerList(new ArrayList());
            xp.setNoOfPsgnOptedService(this.g);
            zb.setDestStnCode(Integer.valueOf(this.f4543j));
            zb.setFromStnCode(Integer.valueOf(this.f4542i));
            zb.setjDate(this.f4540g);
            zb.setPsgnCount(Integer.valueOf(this.g));
            zb.setPnrNumber(this.k);
            zb.setTxnId(this.l);
            zb.setPostBookingService(xp);
            String j2 = C0657Qt.j();
            Observable<C0781ac> B1 = ((Om) C0657Qt.c(C0793b1.a.f3912a)).B1(j2 + "fetchDmrcFare", zb);
            String.valueOf(zb);
            B1.c(C1181iv.a()).a(E0.a()).b(new f(show));
        } catch (Exception e2) {
            e2.getMessage();
        }
    }

    public final void h(int i2) {
        if (IrctcImaApplication.e.equalsIgnoreCase("hi")) {
            if (String.valueOf(i2) == null || String.valueOf(i2).isEmpty()) {
                this.dmrcFromStnLine.setText("");
                return;
            }
            if (i2 == 1) {
                xx.Q(this, R.string.red_line, this.dmrcFromStnLine);
                TextView textView = this.dmrcFromStnLine;
                FragmentActivity activity = getActivity();
                Object obj = d7.a;
                textView.setTextColor(d7.b.a(activity, R.color.red));
            }
            if (i2 == 2) {
                xx.Q(this, R.string.yellow_line, this.dmrcFromStnLine);
                TextView textView2 = this.dmrcFromStnLine;
                FragmentActivity activity2 = getActivity();
                Object obj2 = d7.a;
                textView2.setTextColor(d7.b.a(activity2, R.color.yellow_color1));
            }
            if (i2 == 3) {
                xx.Q(this, R.string.blue_line, this.dmrcFromStnLine);
                TextView textView3 = this.dmrcFromStnLine;
                FragmentActivity activity3 = getActivity();
                Object obj3 = d7.a;
                textView3.setTextColor(d7.b.a(activity3, R.color.app_theme_blue));
            }
            if (i2 == 4) {
                xx.Q(this, R.string.blue_line, this.dmrcFromStnLine);
                TextView textView4 = this.dmrcFromStnLine;
                FragmentActivity activity4 = getActivity();
                Object obj4 = d7.a;
                textView4.setTextColor(d7.b.a(activity4, R.color.app_theme_blue));
            }
            if (i2 == 5) {
                xx.Q(this, R.string.green_line, this.dmrcFromStnLine);
                TextView textView5 = this.dmrcFromStnLine;
                FragmentActivity activity5 = getActivity();
                Object obj5 = d7.a;
                textView5.setTextColor(d7.b.a(activity5, R.color.green));
            }
            if (i2 == 6) {
                xx.Q(this, R.string.violet_line, this.dmrcFromStnLine);
                TextView textView6 = this.dmrcFromStnLine;
                FragmentActivity activity6 = getActivity();
                Object obj6 = d7.a;
                textView6.setTextColor(d7.b.a(activity6, R.color.violet));
            }
            if (i2 == 7) {
                xx.Q(this, R.string.pink_line, this.dmrcFromStnLine);
                TextView textView7 = this.dmrcFromStnLine;
                FragmentActivity activity7 = getActivity();
                Object obj7 = d7.a;
                textView7.setTextColor(d7.b.a(activity7, R.color.light_pink));
            }
            if (i2 == 8) {
                xx.Q(this, R.string.magenta_line, this.dmrcFromStnLine);
                TextView textView8 = this.dmrcFromStnLine;
                FragmentActivity activity8 = getActivity();
                Object obj8 = d7.a;
                textView8.setTextColor(d7.b.a(activity8, R.color.magenta));
            }
            if (i2 == 9) {
                xx.Q(this, R.string.grey_line, this.dmrcFromStnLine);
                TextView textView9 = this.dmrcFromStnLine;
                FragmentActivity activity9 = getActivity();
                Object obj9 = d7.a;
                textView9.setTextColor(d7.b.a(activity9, R.color.lightdark));
            }
            if (i2 == 29) {
                xx.Q(this, R.string.rmgl_line, this.dmrcFromStnLine);
                TextView textView10 = this.dmrcFromStnLine;
                FragmentActivity activity10 = getActivity();
                Object obj10 = d7.a;
                textView10.setTextColor(d7.b.a(activity10, R.color.dark));
            }
        } else if (String.valueOf(i2) == null || String.valueOf(i2).isEmpty()) {
            this.dmrcFromStnLine.setText("");
        } else {
            if (i2 == 1) {
                xx.Q(this, R.string.red_line, this.dmrcFromStnLine);
                TextView textView11 = this.dmrcFromStnLine;
                FragmentActivity activity11 = getActivity();
                Object obj11 = d7.a;
                textView11.setTextColor(d7.b.a(activity11, R.color.red));
            }
            if (i2 == 2) {
                xx.Q(this, R.string.yellow_line, this.dmrcFromStnLine);
                TextView textView12 = this.dmrcFromStnLine;
                FragmentActivity activity12 = getActivity();
                Object obj12 = d7.a;
                textView12.setTextColor(d7.b.a(activity12, R.color.yellow_color1));
            }
            if (i2 == 3) {
                xx.Q(this, R.string.blue_line, this.dmrcFromStnLine);
                TextView textView13 = this.dmrcFromStnLine;
                FragmentActivity activity13 = getActivity();
                Object obj13 = d7.a;
                textView13.setTextColor(d7.b.a(activity13, R.color.app_theme_blue));
            }
            if (i2 == 4) {
                xx.Q(this, R.string.blue_line, this.dmrcFromStnLine);
                TextView textView14 = this.dmrcFromStnLine;
                FragmentActivity activity14 = getActivity();
                Object obj14 = d7.a;
                textView14.setTextColor(d7.b.a(activity14, R.color.app_theme_blue));
            }
            if (i2 == 5) {
                xx.Q(this, R.string.green_line, this.dmrcFromStnLine);
                TextView textView15 = this.dmrcFromStnLine;
                FragmentActivity activity15 = getActivity();
                Object obj15 = d7.a;
                textView15.setTextColor(d7.b.a(activity15, R.color.green));
            }
            if (i2 == 6) {
                xx.Q(this, R.string.violet_line, this.dmrcFromStnLine);
                TextView textView16 = this.dmrcFromStnLine;
                FragmentActivity activity16 = getActivity();
                Object obj16 = d7.a;
                textView16.setTextColor(d7.b.a(activity16, R.color.violet));
            }
            if (i2 == 7) {
                xx.Q(this, R.string.pink_line, this.dmrcFromStnLine);
                TextView textView17 = this.dmrcFromStnLine;
                FragmentActivity activity17 = getActivity();
                Object obj17 = d7.a;
                textView17.setTextColor(d7.b.a(activity17, R.color.light_pink));
            }
            if (i2 == 8) {
                xx.Q(this, R.string.magenta_line, this.dmrcFromStnLine);
                TextView textView18 = this.dmrcFromStnLine;
                FragmentActivity activity18 = getActivity();
                Object obj18 = d7.a;
                textView18.setTextColor(d7.b.a(activity18, R.color.magenta));
            }
            if (i2 == 9) {
                xx.Q(this, R.string.grey_line, this.dmrcFromStnLine);
                TextView textView19 = this.dmrcFromStnLine;
                FragmentActivity activity19 = getActivity();
                Object obj19 = d7.a;
                textView19.setTextColor(d7.b.a(activity19, R.color.lightdark));
            }
            if (i2 == 29) {
                xx.Q(this, R.string.rmgl_line, this.dmrcFromStnLine);
                TextView textView20 = this.dmrcFromStnLine;
                FragmentActivity activity20 = getActivity();
                Object obj20 = d7.a;
                textView20.setTextColor(d7.b.a(activity20, R.color.dark));
            }
        }
    }

    public final void i(int i2) {
        if (IrctcImaApplication.e.equalsIgnoreCase("hi")) {
            if (String.valueOf(i2) == null || String.valueOf(i2).isEmpty()) {
                this.dmrcToStnLine.setText("");
                return;
            }
            if (i2 == 1) {
                xx.Q(this, R.string.red_line, this.dmrcToStnLine);
                TextView textView = this.dmrcToStnLine;
                FragmentActivity activity = getActivity();
                Object obj = d7.a;
                textView.setTextColor(d7.b.a(activity, R.color.red));
            }
            if (i2 == 2) {
                xx.Q(this, R.string.yellow_line, this.dmrcToStnLine);
                TextView textView2 = this.dmrcToStnLine;
                FragmentActivity activity2 = getActivity();
                Object obj2 = d7.a;
                textView2.setTextColor(d7.b.a(activity2, R.color.yellow_color1));
            }
            if (i2 == 3) {
                xx.Q(this, R.string.blue_line, this.dmrcToStnLine);
                TextView textView3 = this.dmrcToStnLine;
                FragmentActivity activity3 = getActivity();
                Object obj3 = d7.a;
                textView3.setTextColor(d7.b.a(activity3, R.color.app_theme_blue));
            }
            if (i2 == 4) {
                xx.Q(this, R.string.blue_line, this.dmrcToStnLine);
                TextView textView4 = this.dmrcToStnLine;
                FragmentActivity activity4 = getActivity();
                Object obj4 = d7.a;
                textView4.setTextColor(d7.b.a(activity4, R.color.app_theme_blue));
            }
            if (i2 == 5) {
                xx.Q(this, R.string.green_line, this.dmrcToStnLine);
                TextView textView5 = this.dmrcToStnLine;
                FragmentActivity activity5 = getActivity();
                Object obj5 = d7.a;
                textView5.setTextColor(d7.b.a(activity5, R.color.green));
            }
            if (i2 == 6) {
                xx.Q(this, R.string.violet_line, this.dmrcToStnLine);
                TextView textView6 = this.dmrcToStnLine;
                FragmentActivity activity6 = getActivity();
                Object obj6 = d7.a;
                textView6.setTextColor(d7.b.a(activity6, R.color.violet));
            }
            if (i2 == 7) {
                xx.Q(this, R.string.pink_line, this.dmrcToStnLine);
                TextView textView7 = this.dmrcToStnLine;
                FragmentActivity activity7 = getActivity();
                Object obj7 = d7.a;
                textView7.setTextColor(d7.b.a(activity7, R.color.light_pink));
            }
            if (i2 == 8) {
                xx.Q(this, R.string.magenta_line, this.dmrcToStnLine);
                TextView textView8 = this.dmrcToStnLine;
                FragmentActivity activity8 = getActivity();
                Object obj8 = d7.a;
                textView8.setTextColor(d7.b.a(activity8, R.color.magenta));
            }
            if (i2 == 9) {
                xx.Q(this, R.string.grey_line, this.dmrcToStnLine);
                TextView textView9 = this.dmrcToStnLine;
                FragmentActivity activity9 = getActivity();
                Object obj9 = d7.a;
                textView9.setTextColor(d7.b.a(activity9, R.color.lightdark));
            }
            if (i2 == 29) {
                xx.Q(this, R.string.rmgl_line, this.dmrcToStnLine);
                TextView textView10 = this.dmrcToStnLine;
                FragmentActivity activity10 = getActivity();
                Object obj10 = d7.a;
                textView10.setTextColor(d7.b.a(activity10, R.color.dark));
            }
        } else if (String.valueOf(i2) == null || String.valueOf(i2).isEmpty()) {
            this.dmrcToStnLine.setText("");
        } else {
            if (i2 == 1) {
                xx.Q(this, R.string.red_line, this.dmrcToStnLine);
                TextView textView11 = this.dmrcToStnLine;
                FragmentActivity activity11 = getActivity();
                Object obj11 = d7.a;
                textView11.setTextColor(d7.b.a(activity11, R.color.red));
            }
            if (i2 == 2) {
                xx.Q(this, R.string.yellow_line, this.dmrcToStnLine);
                TextView textView12 = this.dmrcToStnLine;
                FragmentActivity activity12 = getActivity();
                Object obj12 = d7.a;
                textView12.setTextColor(d7.b.a(activity12, R.color.yellow_color1));
            }
            if (i2 == 3) {
                xx.Q(this, R.string.blue_line, this.dmrcToStnLine);
                TextView textView13 = this.dmrcToStnLine;
                FragmentActivity activity13 = getActivity();
                Object obj13 = d7.a;
                textView13.setTextColor(d7.b.a(activity13, R.color.app_theme_blue));
            }
            if (i2 == 4) {
                xx.Q(this, R.string.blue_line, this.dmrcToStnLine);
                TextView textView14 = this.dmrcToStnLine;
                FragmentActivity activity14 = getActivity();
                Object obj14 = d7.a;
                textView14.setTextColor(d7.b.a(activity14, R.color.app_theme_blue));
            }
            if (i2 == 5) {
                xx.Q(this, R.string.green_line, this.dmrcToStnLine);
                TextView textView15 = this.dmrcToStnLine;
                FragmentActivity activity15 = getActivity();
                Object obj15 = d7.a;
                textView15.setTextColor(d7.b.a(activity15, R.color.green));
            }
            if (i2 == 6) {
                xx.Q(this, R.string.violet_line, this.dmrcToStnLine);
                TextView textView16 = this.dmrcToStnLine;
                FragmentActivity activity16 = getActivity();
                Object obj16 = d7.a;
                textView16.setTextColor(d7.b.a(activity16, R.color.violet));
            }
            if (i2 == 7) {
                xx.Q(this, R.string.pink_line, this.dmrcToStnLine);
                TextView textView17 = this.dmrcToStnLine;
                FragmentActivity activity17 = getActivity();
                Object obj17 = d7.a;
                textView17.setTextColor(d7.b.a(activity17, R.color.light_pink));
            }
            if (i2 == 8) {
                xx.Q(this, R.string.magenta_line, this.dmrcToStnLine);
                TextView textView18 = this.dmrcToStnLine;
                FragmentActivity activity18 = getActivity();
                Object obj18 = d7.a;
                textView18.setTextColor(d7.b.a(activity18, R.color.magenta));
            }
            if (i2 == 9) {
                xx.Q(this, R.string.grey_line, this.dmrcToStnLine);
                TextView textView19 = this.dmrcToStnLine;
                FragmentActivity activity19 = getActivity();
                Object obj19 = d7.a;
                textView19.setTextColor(d7.b.a(activity19, R.color.lightdark));
            }
            if (i2 == 29) {
                xx.Q(this, R.string.rmgl_line, this.dmrcToStnLine);
                TextView textView20 = this.dmrcToStnLine;
                FragmentActivity activity20 = getActivity();
                Object obj20 = d7.a;
                textView20.setTextColor(d7.b.a(activity20, R.color.dark));
            }
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (intent == null) {
            return;
        }
        if (i3 == 0 || i3 == 2) {
            if (intent.getSerializableExtra("fromDmrcStationName") != null) {
                this.a = (DmrcstatsionDto) intent.getSerializableExtra("dmrcstatsionDto");
                String stringExtra = intent.getStringExtra("fromDmrcStationName");
                this.f4535c = stringExtra;
                this.dmrcfromStnName.setText(stringExtra);
                int dmrclinecolorcode = this.a.getDmrclinecolorcode();
                this.h = dmrclinecolorcode;
                h(dmrclinecolorcode);
                this.f4542i = String.valueOf(this.a.getDmrcstationindex());
            }
            if (intent.getSerializableExtra("toDmrcStationName") != null) {
                this.b = (DmrcstatsionDto) intent.getSerializableExtra("dmrcstatsionDto");
                String stringExtra2 = intent.getStringExtra("toDmrcStationName");
                this.f4537d = stringExtra2;
                this.dmrctoStnName.setText(stringExtra2);
                int dmrclinecolorcode2 = this.b.getDmrclinecolorcode();
                this.i = dmrclinecolorcode2;
                i(dmrclinecolorcode2);
                this.f4543j = String.valueOf(this.b.getDmrcstationindex());
            }
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        String str2;
        HashMap<String, List> hashMap;
        String str3;
        View inflate = layoutInflater.inflate(R.layout.fragment_delhi_metro_booking, (ViewGroup) null);
        ButterKnife.bind((Object) this, inflate);
        HomeActivity.K();
        Bundle arguments = getArguments();
        if (arguments != null && !arguments.isEmpty()) {
            this.k = arguments.getString("pnr");
            this.f4530a = (Date) arguments.getSerializable("deptDate");
            this.f4533b = (Date) arguments.getSerializable("arvDate");
            this.f4538e = arguments.getString("noOfBkdPsgn");
            this.f4539f = arguments.getString("noOfBkdChild");
            this.l = arguments.getString("transactionId");
            arguments.getString("insuranceOpted");
            arguments.getInt("colorcode");
            this.m = arguments.getString("fromStnCode");
            this.n = arguments.getString("toStnCode");
            arguments.getString("metroDeffTime");
            this.linkedPnrNumber.setText(this.k);
            TextView textView = this.noOfPassenger;
            if (this.f4539f == "0") {
                str3 = this.f4538e + this.f4539f;
            } else {
                str3 = this.f4538e;
            }
            textView.setText(str3);
        }
        if (!this.f4532a) {
            try {
                this.f4529a = (ArrayList) new Gson().fromJson(Bw.e(getActivity()).a(), new a().getType());
                int i2 = 0;
                while (true) {
                    int size = this.f4529a.size();
                    hashMap = this.f4531a;
                    if (i2 >= size) {
                        break;
                    }
                    hashMap.put(this.f4529a.get(i2).getKey(), this.f4529a.get(i2).getValue());
                    i2++;
                }
                if (hashMap.keySet().contains(this.n)) {
                    List list = hashMap.get(this.n);
                    Collections.sort(list, new b());
                    this.f4542i = String.valueOf(((DmrcstatsionDto) list.get(0)).getDmrcstationindex());
                    String dmrcstationname = ((DmrcstatsionDto) list.get(0)).getDmrcstationname();
                    this.f4535c = dmrcstationname;
                    this.dmrcfromStnName.setText(dmrcstationname);
                    int dmrclinecolorcode = ((DmrcstatsionDto) list.get(0)).getDmrclinecolorcode();
                    this.h = dmrclinecolorcode;
                    h(dmrclinecolorcode);
                    this.f4536c = this.f4533b;
                } else if (hashMap.keySet().contains(this.m)) {
                    List list2 = hashMap.get(this.m);
                    Collections.sort(list2, new c());
                    this.f4543j = String.valueOf(((DmrcstatsionDto) list2.get(0)).getDmrcstationindex());
                    String dmrcstationname2 = ((DmrcstatsionDto) list2.get(0)).getDmrcstationname();
                    this.f4537d = dmrcstationname2;
                    this.dmrctoStnName.setText(dmrcstationname2);
                    int dmrclinecolorcode2 = ((DmrcstatsionDto) list2.get(0)).getDmrclinecolorcode();
                    this.i = dmrclinecolorcode2;
                    i(dmrclinecolorcode2);
                    this.f4536c = this.f4530a;
                }
            } catch (Exception e2) {
                e2.getMessage();
            }
        }
        Calendar instance = Calendar.getInstance();
        instance.setTime(this.f4536c);
        instance.add(5, 1);
        Date time = instance.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("EEEE");
        String format = simpleDateFormat.format(time);
        String format2 = simpleDateFormat2.format(time);
        this.dmrctomorrowDate.setText(format);
        this.dmrctomorrowlabel.setText(" " + format2);
        f();
        if (this.f4532a) {
            try {
                String str4 = this.k;
                if (str4 != null) {
                    this.linkedPnrNumber.setText(str4);
                }
                this.dmrcjourneydate.setText(this.f4541h);
                this.g = Integer.parseInt(this.noOfPassenger.getText().toString().trim());
                int i3 = this.f;
                if (i3 == 8) {
                    this.noOfPassenger.setText(String.valueOf(i3));
                } else {
                    this.noOfPassenger.setText(String.valueOf(i3 + 1));
                }
                if (!this.f4535c.equals("") && (str2 = this.f4535c) != null) {
                    this.dmrcfromStnName.setText(str2);
                    h(this.h);
                }
                if (!this.f4537d.equals("") && (str = this.f4537d) != null) {
                    this.dmrctoStnName.setText(str);
                    i(this.i);
                }
            } catch (NumberFormatException e3) {
                e3.printStackTrace();
            }
        } else {
            Date date = this.f4536c;
            Calendar.getInstance();
            SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("EEE dd MMM");
            SimpleDateFormat simpleDateFormat4 = new SimpleDateFormat("yyyyMMdd");
            String format3 = simpleDateFormat3.format(date);
            this.dmrcjourneydate.setContentDescription(new SimpleDateFormat("EEEE").format(date));
            this.dmrcjourneydate.setText(format3);
            this.f4540g = simpleDateFormat4.format(date);
        }
        return inflate;
    }

    @OnClick({2131362886})
    public void onDmrcDecrementClick() {
        if (this.noOfPassenger.getText().toString().equalsIgnoreCase("")) {
            this.f = 0;
        } else {
            this.f = Integer.parseInt(String.valueOf(this.noOfPassenger.getText()));
        }
        int i2 = this.f;
        int i3 = i2 - 1;
        if (i2 <= 1) {
            this.noOfPassenger.setHint("No. of Passenger");
        } else {
            this.noOfPassenger.setText(String.valueOf(i3));
        }
    }

    @OnClick({2131362887})
    public void onDmrcIncrementtClick() {
        if (this.noOfPassenger.getText().toString().equalsIgnoreCase("")) {
            this.f = 0;
        } else {
            this.f = Integer.parseInt(String.valueOf(this.noOfPassenger.getText()));
        }
        int i2 = this.f;
        int i3 = i2 + 1;
        if (i2 >= 8) {
            this.noOfPassenger.setText(String.valueOf(i2));
        } else {
            this.noOfPassenger.setText(String.valueOf(i3));
        }
    }

    @OnClick({2131364374})
    public void onDmrcSearchClick() {
        if (this.dmrcfromStnName.getText().toString().equals("") || this.dmrctoStnName.getText().toString().equals("")) {
            C0535I5.m(getActivity(), false, getResources().getString(R.string.station_selection_error_message), getString(R.string.error), getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
            return;
        }
        try {
            if (!this.f4534b) {
                this.f4534b = true;
                g();
                new C0816cB(new d(), 3000).a();
            }
        } catch (Exception e2) {
            e2.getMessage();
        }
    }

    @OnClick({2131362437})
    public void onDrmcTrainRouteMapClickLink() {
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.delhimetrorail.com/network_map")));
        } catch (Exception e2) {
            e2.getMessage();
        }
    }

    @OnClick({2131362438})
    public void onDrmcTrainTimingClickLink() {
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.delhimetrorail.com")));
        } catch (Exception e2) {
            e2.getMessage();
        }
    }

    @OnClick({2131363028})
    public void onFromStationClick() {
        Intent intent = new Intent(getActivity(), DmrcStationActivity.class);
        intent.putExtra("dmrcStationView ", 0);
        intent.putExtra("FromDmrcStationHint", this.f4535c);
        intent.putExtra("ToDmrcStationHint", this.f4537d);
        intent.putExtra("fromStnCode", this.m);
        intent.putExtra("toStnCode", this.n);
        startActivityForResult(intent, 0);
    }

    @OnClick({2131361817})
    public void onJourneyDateClick() {
        Calendar instance = Calendar.getInstance();
        instance.setTime(this.f4536c);
        this.c = instance.get(1);
        this.d = instance.get(2);
        this.e = instance.get(5);
        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new g(), this.c, this.d, this.e);
        instance.add(5, -1);
        long timeInMillis = instance.getTimeInMillis();
        instance.add(5, 3);
        long timeInMillis2 = instance.getTimeInMillis();
        datePickerDialog.getDatePicker().setMinDate(timeInMillis);
        datePickerDialog.getDatePicker().setMaxDate(timeInMillis2);
        datePickerDialog.show();
    }

    @OnClick({2131363090})
    public void onToStationClick() {
        Intent intent = new Intent(getActivity(), DmrcStationActivity.class);
        intent.putExtra("dmrcStationView", 1);
        intent.putExtra("FromDmrcStationHint", this.f4535c);
        intent.putExtra("ToDmrcStationHint", this.f4537d);
        intent.putExtra("toStnCode", this.n);
        intent.putExtra("fromStnCode", this.m);
        startActivityForResult(intent, 1);
    }

    @OnClick({2131362435})
    public void onTomorrowClick() {
        Calendar instance = Calendar.getInstance();
        instance.add(5, 1);
        this.f4540g = new SimpleDateFormat("yyyyMMdd").format(instance.getTime());
        ImageView imageView = this.dmrccalender;
        FragmentActivity activity = getActivity();
        Object obj = d7.a;
        imageView.setColorFilter(d7.b.a(activity, R.color.colorAccent), PorterDuff.Mode.MULTIPLY);
        this.dmrcjourneydate.setTextColor(getResources().getColor(R.color.colorAccent));
        this.dmrcjourneydatelabel.setTextColor(getResources().getColor(R.color.colorAccent));
        this.dmrctomorrow_ll.setBackground(d7.a.b(getActivity(), R.drawable.round_red_corner));
        this.dmrctomorrowDate.setTextColor(getResources().getColor(R.color.dark));
        this.dmrctomorrowlabel.setTextColor(getResources().getColor(R.color.dark));
        this.dmrcSelectJourneyDate.setBackground(d7.a.b(getActivity(), R.drawable.round_light_corner));
    }

    public class e implements Runnable {
        public final void run() {
        }
    }
}
