package cris.org.in.ima.fragment;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.model.TrainBtwnStnsModel;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.PnrEnquiryResponseDTO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import rx.Subscriber;

public class ConnectingJourneyFragment extends Fragment {
    public static C0794b3 a;

    /* renamed from: a  reason: collision with other field name */
    public final C0573L6 f4518a = new C0573L6();

    /* renamed from: a  reason: collision with other field name */
    public Z2 f4519a;

    /* renamed from: a  reason: collision with other field name */
    public Context f4520a;

    /* renamed from: a  reason: collision with other field name */
    public Bundle f4521a = null;

    /* renamed from: a  reason: collision with other field name */
    public FragmentActivity f4522a;

    /* renamed from: a  reason: collision with other field name */
    public C1100f2 f4523a = null;

    /* renamed from: a  reason: collision with other field name */
    public ArrayList<TrainBtwnStnsModel> f4524a = null;
    public int c;

    /* renamed from: c  reason: collision with other field name */
    public String f4525c;
    public String d;
    public String e;
    public String f = "";
    public final String g = "";
    public String h;
    @BindView(2131363005)
    LinearLayout ll_aadhaar_layout;
    @BindView(2131363044)
    LinearLayout ll_otp;
    @BindView(2131363068)
    LinearLayout ll_status;
    @BindView(2131363069)
    LinearLayout ll_submit;
    @BindView(2131363515)
    RelativeLayout pnr_input_bottom_rl;
    @BindView(2131363678)
    TextView resend_opt;
    @BindView(2131364028)
    TextView status;
    @BindView(2131364520)
    EditText tv_otp;
    @BindView(2131364532)
    EditText tv_pnr;
    @BindView(2131364623)
    TextView tv_submit_btn;

    public class b extends Subscriber<PnrEnquiryResponseDTO> {
        public final /* synthetic */ ProgressDialog a;

        public b(ProgressDialog progressDialog) {
            this.a = progressDialog;
        }

        public final void onCompleted() {
            C0794b3 b3Var = ConnectingJourneyFragment.a;
        }

        public final void onError(Throwable th) {
            C0794b3 b3Var = ConnectingJourneyFragment.a;
            th.getClass();
            th.getMessage();
            this.a.dismiss();
            HomeActivity.B(ConnectingJourneyFragment.this.getActivity());
            Lt.a(true, th);
        }

        public final void onNext(Object obj) {
            PnrEnquiryResponseDTO pnrEnquiryResponseDTO = (PnrEnquiryResponseDTO) obj;
            this.a.dismiss();
            if (pnrEnquiryResponseDTO != null) {
                C0657Qt.h();
                try {
                    String errorMessage = pnrEnquiryResponseDTO.getErrorMessage();
                    ConnectingJourneyFragment connectingJourneyFragment = ConnectingJourneyFragment.this;
                    if (errorMessage != null) {
                        C0535I5.m(connectingJourneyFragment.getActivity(), true, pnrEnquiryResponseDTO.getErrorMessage().split("-")[0], connectingJourneyFragment.getString(R.string.error), connectingJourneyFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                    } else if (pnrEnquiryResponseDTO.getStatus() != null) {
                        C0535I5.o(connectingJourneyFragment.getActivity(), pnrEnquiryResponseDTO.getStatus(), connectingJourneyFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                        connectingJourneyFragment.status.setVisibility(0);
                        connectingJourneyFragment.status.setText(pnrEnquiryResponseDTO.getStatus());
                    } else {
                        connectingJourneyFragment.status.setVisibility(8);
                    }
                } catch (Exception e) {
                    C0794b3 b3Var = ConnectingJourneyFragment.a;
                    e.getMessage();
                }
            }
        }
    }

    public class d extends Subscriber<PnrEnquiryResponseDTO> {
        public final /* synthetic */ ProgressDialog a;

        public d(ProgressDialog progressDialog) {
            this.a = progressDialog;
        }

        public final void onCompleted() {
            C0794b3 b3Var = ConnectingJourneyFragment.a;
        }

        public final void onError(Throwable th) {
            C0794b3 b3Var = ConnectingJourneyFragment.a;
            th.getClass();
            th.getMessage();
            this.a.dismiss();
            HomeActivity.B(ConnectingJourneyFragment.this.getActivity());
            Lt.a(true, th);
        }

        public final void onNext(Object obj) {
            PnrEnquiryResponseDTO pnrEnquiryResponseDTO = (PnrEnquiryResponseDTO) obj;
            this.a.dismiss();
            if (pnrEnquiryResponseDTO != null) {
                C0657Qt.h();
                try {
                    String errorMessage = pnrEnquiryResponseDTO.getErrorMessage();
                    ConnectingJourneyFragment connectingJourneyFragment = ConnectingJourneyFragment.this;
                    if (errorMessage != null) {
                        C0535I5.m(connectingJourneyFragment.getActivity(), true, pnrEnquiryResponseDTO.getErrorMessage().split("-")[0], connectingJourneyFragment.getString(R.string.error), connectingJourneyFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                    } else if (pnrEnquiryResponseDTO.getStatus() != null) {
                        connectingJourneyFragment.status.setVisibility(0);
                        connectingJourneyFragment.status.setText(pnrEnquiryResponseDTO.getStatus());
                        connectingJourneyFragment.ll_otp.setVisibility(0);
                        connectingJourneyFragment.c = 2;
                        connectingJourneyFragment.tv_pnr.setClickable(false);
                    } else {
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("spConcession", connectingJourneyFragment.h);
                        bundle.putString("selectedQuotaString", connectingJourneyFragment.f4525c);
                        bundle.putString("selectedQuota", LapAllTrainListFragment.j);
                        bundle.putBoolean("isLinkedJoureny", true);
                        bundle.putSerializable("boardingStnListDTO", connectingJourneyFragment.f4519a);
                        bundle.putSerializable("avlResponseDTO", connectingJourneyFragment.f4523a);
                        bundle.putSerializable("TrainBtwnStnsDTOList", connectingJourneyFragment.f4524a);
                        bundle.putSerializable("TrainBtwnStnsDTO", connectingJourneyFragment.f4524a.get(0).f5342a);
                        bundle.putSerializable("ssConcForgoText", connectingJourneyFragment.g);
                        bundle.putSerializable("psgnSetails", pnrEnquiryResponseDTO.getPassengerList());
                        bundle.putSerializable("highestClass", connectingJourneyFragment.e);
                        bundle.putString("JourneyDate", connectingJourneyFragment.d);
                        bundle.putSerializable("BookingConfig", ConnectingJourneyFragment.a);
                        bundle.putString("AvailLastUpdate", connectingJourneyFragment.f);
                        bundle.putSerializable("AvailablityDTO", connectingJourneyFragment.f4524a.get(0).f5343a);
                        bundle.putString("mainPnr", pnrEnquiryResponseDTO.getPnrNumber());
                        PassengerDetailFragment passengerDetailFragment = new PassengerDetailFragment();
                        passengerDetailFragment.setArguments(bundle);
                        HomeActivity.n(connectingJourneyFragment.f4520a, passengerDetailFragment, C1218kf.ADD_PASSENGER.a(), Boolean.TRUE, Boolean.FALSE);
                    }
                } catch (Exception e) {
                    C0794b3 b3Var = ConnectingJourneyFragment.a;
                    e.getMessage();
                }
            }
        }
    }

    static {
        C1354qp.R(ConnectingJourneyFragment.class);
    }

    public ConnectingJourneyFragment() {
        new ArrayList();
    }

    public final void f() {
        if (!C0535I5.O((ConnectivityManager) getActivity().getSystemService("connectivity"), getContext())) {
            new Handler().postDelayed(new c(), 5000);
            return;
        }
        ((Om) C0657Qt.c(C0793b1.a.f3912a)).f1(C1058d.z(C0657Qt.f(), "linkpnrenq"), this.f4518a).c(C1181iv.a()).a(E0.a()).b(new d(ProgressDialog.show(getActivity(), this.f4520a.getResources().getString(R.string.fetching_ticket_List), this.f4520a.getResources().getString(R.string.please_wait_text))));
    }

    public final void g() {
        if (!C0535I5.O((ConnectivityManager) getActivity().getSystemService("connectivity"), getContext())) {
            new Handler().postDelayed(new a(), 5000);
            return;
        }
        C0573L6 l6 = new C0573L6();
        l6.setPnrNumber(this.tv_pnr.getText().toString());
        l6.setOtpResend(1);
        ProgressDialog show = ProgressDialog.show(getActivity(), this.f4520a.getResources().getString(R.string.fetching_ticket_List), this.f4520a.getResources().getString(R.string.please_wait_text));
        String f2 = C0657Qt.f();
        ((Om) C0657Qt.c(C0793b1.a.f3912a)).f1(f2 + "linkpnrenq", l6).c(C1181iv.a()).a(E0.a()).b(new b(show));
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_connecting_journey, (ViewGroup) null);
        ButterKnife.bind((Object) this, inflate);
        this.f4520a = getContext();
        this.f4522a = getActivity();
        Bundle arguments = getArguments();
        this.f4521a = arguments;
        if (arguments != null) {
            this.f4524a = (ArrayList) arguments.getSerializable("TrainBtwnStnsDTOList");
            this.f4523a = (C1100f2) this.f4521a.getSerializable("avlResponseDTO");
            this.f4525c = this.f4521a.getString("selectedQuotaString");
            this.f4521a.getString("selectedQuota");
            this.f4519a = (Z2) this.f4521a.getSerializable("boardingStnListDTO");
            this.h = this.f4521a.getString("spConcession");
            this.d = this.f4521a.getString("JourneyDate");
            this.e = this.f4521a.getString("highestClass");
            a = (C0794b3) this.f4521a.getSerializable("BookingConfig");
            this.f = this.f4521a.getString("AvailLastUpdate");
            ArrayList arrayList = (ArrayList) this.f4521a.getSerializable("reebookPsgnList");
            this.f4521a.getBoolean("rebookFlag");
        }
        this.ll_otp.setVisibility(8);
        this.c = 1;
        this.status.setVisibility(8);
        return inflate;
    }

    public final void onDestroy() {
        super.onDestroy();
        C0535I5.u();
    }

    @OnClick({2131363678})
    public void onOtpResendClick() {
        try {
            g();
        } catch (Exception e2) {
            e2.getMessage();
        }
    }

    public final void onPause() {
        super.onPause();
        C0535I5.u();
    }

    @OnClick({2131364623})
    public void onSearchClick() {
        try {
            int i = this.c;
            String str = "";
            C0573L6 l6 = this.f4518a;
            if (i == 1) {
                if (this.tv_pnr.getText().toString().compareToIgnoreCase(str) == 0) {
                    C0535I5.o(getActivity(), this.f4520a.getResources().getString(R.string.Please_Enter_PNR), this.f4520a.getResources().getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
                } else if (this.tv_pnr.getText().toString().length() != 10) {
                    C0535I5.o(getActivity(), this.f4520a.getResources().getString(R.string.PNR_10_digits), this.f4520a.getResources().getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
                } else {
                    l6.setPnrNumber(this.tv_pnr.getText().toString());
                    l6.setTrainNo(this.f4524a.get(0).f5342a.getTrainNumber());
                    l6.setFromStation(this.f4524a.get(0).f5342a.getFromStnCode());
                    l6.setToStation(this.f4524a.get(0).f5342a.getToStnCode());
                    String availablityDate = this.f4524a.get(0).f5343a.getAvailablityDate();
                    AlertDialog alertDialog = C0535I5.f3619a;
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-M-yyyy");
                    try {
                        str = new SimpleDateFormat("yyyyMMdd").format(simpleDateFormat.parse(availablityDate));
                    } catch (ParseException unused) {
                        C1354qp.R(C0535I5.class);
                    }
                    l6.setJourneyDate(str);
                    l6.setJourneyClass(this.f4524a.get(0).f5348c);
                    l6.setJourneyQuota(this.f4524a.get(0).d);
                    l6.setConnectedJounreny(Boolean.TRUE);
                    f();
                }
            } else if (this.tv_otp.getText().toString().compareToIgnoreCase(str) == 0) {
                C0535I5.o(getActivity(), this.f4520a.getResources().getString(R.string.Please_Enter_OTP), this.f4520a.getResources().getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
            } else {
                l6.setOtpCode(this.tv_otp.getText().toString());
                f();
            }
        } catch (Exception e2) {
            e2.getMessage();
        }
    }

    public final void onStop() {
        super.onStop();
        C0535I5.u();
    }

    public class a implements Runnable {
        public final void run() {
        }
    }

    public class c implements Runnable {
        public final void run() {
        }
    }
}
