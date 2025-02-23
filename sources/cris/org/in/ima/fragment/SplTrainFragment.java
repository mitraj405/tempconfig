package cris.org.in.ima.fragment;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.adaptors.CustomAdapter;
import cris.org.in.ima.listener.OnSelectionListener;
import cris.org.in.prs.ima.R;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import rx.Subscriber;

public class SplTrainFragment extends Fragment {
    public static final /* synthetic */ int d = 0;
    public CustomDialogFragment a;

    /* renamed from: a  reason: collision with other field name */
    public final SimpleDateFormat f5110a = new SimpleDateFormat("dd-MMM-yyyy");

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<String> f5111a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    public Date f5112a;
    public final SimpleDateFormat b = new SimpleDateFormat("yyyyMMdd");
    public int c;

    /* renamed from: c  reason: collision with other field name */
    public String f5113c;

    /* renamed from: d  reason: collision with other field name */
    public String f5114d;
    @BindView(2131363396)
    EditText otp;
    @BindView(2131363044)
    LinearLayout otpLayout;
    @BindView(2131363519)
    TextView pnrNumber;
    @BindView(2131364689)
    EditText trainNumber;
    @BindView(2131364738)
    TextView tvTxnId;
    @BindView(2131363095)
    LinearLayout txnIdLayout;
    @BindView(2131364844)
    TextView vikalpTrainDate;
    @BindView(2131363098)
    LinearLayout vikalpTrainDateLayout;

    public class a implements OnSelectionListener {
        public a() {
        }

        public final void onClick(String str) {
            SplTrainFragment splTrainFragment = SplTrainFragment.this;
            splTrainFragment.vikalpTrainDate.setText(str);
            splTrainFragment.a.dismiss();
        }
    }

    public class c extends Subscriber<C0687T1> {
        public final /* synthetic */ ProgressDialog a;

        public c(ProgressDialog progressDialog) {
            this.a = progressDialog;
        }

        public final void onCompleted() {
            int i = SplTrainFragment.d;
            this.a.dismiss();
        }

        public final void onError(Throwable th) {
            int i = SplTrainFragment.d;
            th.getClass();
            th.getMessage();
            this.a.dismiss();
            HomeActivity.B(SplTrainFragment.this.getActivity());
            Lt.a(true, th);
        }

        public final void onNext(Object obj) {
            C0687T1 t1 = (C0687T1) obj;
            if (t1 != null) {
                C0657Qt.h();
                try {
                    boolean isErrorFlag = t1.isErrorFlag();
                    SplTrainFragment splTrainFragment = SplTrainFragment.this;
                    if (isErrorFlag) {
                        if (t1.getErrorMessage() != null) {
                            C0535I5.m(splTrainFragment.getActivity(), true, t1.getErrorMessage().split("-")[0], splTrainFragment.getString(R.string.error), splTrainFragment.getString(R.string.OK), new C1032k0()).show();
                            return;
                        }
                    }
                    if (t1.isErrorFlag()) {
                        C0535I5.m(splTrainFragment.getActivity(), true, splTrainFragment.getString(R.string.unable_process_message), splTrainFragment.getString(R.string.error), splTrainFragment.getString(R.string.OK), new C1034l0()).show();
                        return;
                    }
                    FragmentActivity activity = splTrainFragment.getActivity();
                    C0535I5.o(activity, splTrainFragment.getString(R.string.successfully_booked_special_train) + " " + t1.getTrainNumber() + ". Your New PNR : " + t1.getPnrNumber() + " Boarding Date :" + t1.getJourneyDate(), splTrainFragment.getString(R.string.OK), new C1036m0(this)).show();
                } catch (Exception e) {
                    int i = SplTrainFragment.d;
                    e.getMessage();
                }
            }
        }
    }

    public class d extends Subscriber<C0701U1> {
        public final /* synthetic */ ProgressDialog a;

        public d(ProgressDialog progressDialog) {
            this.a = progressDialog;
        }

        public final void onCompleted() {
            int i = SplTrainFragment.d;
            this.a.dismiss();
        }

        public final void onError(Throwable th) {
            int i = SplTrainFragment.d;
            th.getClass();
            th.getMessage();
            this.a.dismiss();
            HomeActivity.B(SplTrainFragment.this.getActivity());
            Lt.a(true, th);
        }

        public final void onNext(Object obj) {
            C0701U1 u1 = (C0701U1) obj;
            if (u1 != null) {
                C0657Qt.h();
                try {
                    boolean isErrorFlag = u1.isErrorFlag();
                    SplTrainFragment splTrainFragment = SplTrainFragment.this;
                    if (isErrorFlag) {
                        if (u1.getErrorMsg() != null) {
                            C0535I5.m(splTrainFragment.getActivity(), true, u1.getErrorMsg().split("-")[0], splTrainFragment.getString(R.string.error), splTrainFragment.getString(R.string.OK), new C1038n0()).show();
                            return;
                        }
                    }
                    if (u1.isErrorFlag()) {
                        C0535I5.m(splTrainFragment.getActivity(), true, splTrainFragment.getString(R.string.unable_process_message), splTrainFragment.getString(R.string.error), splTrainFragment.getString(R.string.OK), new C1040o0()).show();
                        return;
                    }
                    FragmentActivity activity = splTrainFragment.getActivity();
                    C0535I5.o(activity, splTrainFragment.getString(R.string.successfully_booked_special_train) + " " + u1.getTrainNumber() + ". Your New PNR : " + u1.getPnrNumber() + " Boarding Date :" + u1.getJourneyDate(), splTrainFragment.getString(R.string.OK), new C1042p0(this)).show();
                } catch (Exception e) {
                    int i = SplTrainFragment.d;
                    e.getMessage();
                }
            }
        }
    }

    static {
        C1354qp.R(SplTrainFragment.class);
    }

    public final void f() {
        if (!C0535I5.O((ConnectivityManager) getActivity().getSystemService("connectivity"), getContext())) {
            new Handler().postDelayed(new b(), 5000);
            return;
        }
        ProgressDialog show = ProgressDialog.show(getActivity(), getString(R.string.booking_ticket), getString(R.string.please_wait_text));
        try {
            String format = this.b.format(this.f5110a.parse(this.vikalpTrainDate.getText().toString()));
            if (this.c == 1) {
                String f = C0657Qt.f();
                String format2 = String.format("/%s/%s/%s", new Object[]{this.f5113c, xx.B(this.trainNumber), format});
                ((Om) C0657Qt.c(C0793b1.a.f3912a)).e0(f + "optSpecialTrain" + format2).c(C1181iv.a()).a(E0.a()).b(new c(show));
                return;
            }
            String m = C0657Qt.m();
            String format3 = String.format("/%s/%s/%s/%s", new Object[]{this.f5114d, xx.B(this.trainNumber), format, this.otp.getText().toString()});
            ((Om) C0657Qt.e()).Z0(m + "optSpecialTrain" + format3).c(C1181iv.a()).a(E0.a()).b(new d(show));
        } catch (ParseException e) {
            e.getMessage();
            show.dismiss();
            C0535I5.o(getActivity(), getString(R.string.date_format_exception), getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_spl_train_bkg, (ViewGroup) null);
        ButterKnife.bind((Object) this, inflate);
        Bundle arguments = getArguments();
        SimpleDateFormat simpleDateFormat = this.f5110a;
        ArrayList<String> arrayList = this.f5111a;
        if (arguments == null || !arguments.containsKey("txnId")) {
            this.c = 2;
            this.f5112a = (Date) arguments.getSerializable("JDate");
            for (int i = 0; i <= 3; i++) {
                Date date = this.f5112a;
                Date date2 = new Date();
                date2.setTime(date.getTime() + ((long) (i * 1000 * 60 * 60 * 24)));
                arrayList.add(simpleDateFormat.format(date2));
            }
            this.txnIdLayout.setVisibility(8);
            this.f5114d = arguments.getString("pnr");
            this.pnrNumber.setText(arguments.getString("pnr"));
            this.otpLayout.setVisibility(0);
        } else {
            this.c = 1;
            this.f5113c = arguments.getString("txnId");
            this.f5112a = (Date) arguments.getSerializable("JDate");
            for (int i2 = 0; i2 <= 3; i2++) {
                Date date3 = this.f5112a;
                Date date4 = new Date();
                date4.setTime(date3.getTime() + ((long) (i2 * 1000 * 60 * 60 * 24)));
                arrayList.add(simpleDateFormat.format(date4));
            }
            this.tvTxnId.setText(this.f5113c);
            this.txnIdLayout.setVisibility(0);
            this.f5114d = arguments.getString("pnr");
            this.pnrNumber.setText(arguments.getString("pnr"));
            this.otpLayout.setVisibility(8);
        }
        return inflate;
    }

    @OnClick({2131364844})
    public void onDateClick() {
        CustomDialogFragment customDialogFragment = new CustomDialogFragment();
        this.a = customDialogFragment;
        customDialogFragment.setShowsDialog(true);
        this.a.show(getFragmentManager(), "");
        this.a.setCancelable(true);
        getFragmentManager().z();
        CustomAdapter customAdapter = new CustomAdapter(getContext(), this.f5111a, new a());
        this.a.g().setText(getString(R.string.train_date));
        this.a.f().setAdapter(customAdapter);
    }

    @OnClick({2131364622})
    public void onSubmitClick() {
        try {
            if (this.vikalpTrainDate.getText().toString().compareToIgnoreCase("Select Journey Date") == 0) {
                C0535I5.o(getActivity(), getString(R.string.please_select_date), getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
            } else if (this.trainNumber.getText().toString().compareToIgnoreCase("") == 0) {
                C0535I5.o(getActivity(), getString(R.string.please_enter_train_number), getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
            } else if (this.trainNumber.getText().toString().length() < 5) {
                C0535I5.o(getActivity(), getString(R.string.please_enter_valid_train_number), getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
            } else if (this.c != 2 || !this.otp.getText().toString().isEmpty()) {
                f();
            } else {
                C0535I5.o(getActivity(), getString(R.string.Please_Enter_OTP), getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public class b implements Runnable {
        public final void run() {
        }
    }
}
