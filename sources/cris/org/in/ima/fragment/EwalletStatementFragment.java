package cris.org.in.ima.fragment;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import com.google.firebase.sessions.settings.RemoteSettings;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.dto.oauth2.GoogleAdParamDTO;
import cris.org.in.ima.utils.TicketHistoryUtil;
import cris.org.in.ima.view_holder.AccStatementViewHolder;
import cris.org.in.prs.ima.R;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

public class EwalletStatementFragment extends Fragment {
    public static final /* synthetic */ int c = 0;
    public ProgressDialog a = null;

    /* renamed from: a  reason: collision with other field name */
    public Context f4617a;

    /* renamed from: a  reason: collision with other field name */
    public File f4618a;

    /* renamed from: a  reason: collision with other field name */
    public final SimpleDateFormat f4619a = new SimpleDateFormat("dd/MM/yyyy");

    /* renamed from: a  reason: collision with other field name */
    public Date f4620a = null;

    /* renamed from: a  reason: collision with other field name */
    public final C1279nb f4621a = new C1279nb();

    /* renamed from: a  reason: collision with other field name */
    public boolean f4622a = false;
    @BindView(2131361963)
    NestedScrollView as_acc_stmt;
    @BindView(2131361964)
    TextView as_account_status;
    @BindView(2131361965)
    TextView as_amount;
    @BindView(2131361966)
    TextView as_apply_tv;
    @BindView(2131361967)
    TextView as_cgst;
    @BindView(2131361968)
    TextView as_closing_balance;
    @BindView(2131361969)
    TextView as_date_from_calendar;
    @BindView(2131361970)
    TextView as_date_from_tv;
    @BindView(2131361971)
    TextView as_date_upto_calendar;
    @BindView(2131361972)
    TextView as_date_upto_tv;
    @BindView(2131361975)
    TextView as_ewallet_empty_list;
    @BindView(2131361976)
    RelativeLayout as_filter_rl;
    @BindView(2131361977)
    LinearLayout as_filter_rl_ll;
    @BindView(2131361980)
    TextView as_igst;
    @BindView(2131361984)
    TextView as_reg_date;
    @BindView(2131361985)
    TextView as_reset_tv;
    @BindView(2131361986)
    LinearLayout as_save_acc_stmt;
    @BindView(2131361987)
    TextView as_sgst;
    @BindView(2131361989)
    TextView as_total_amount;
    @BindView(2131361990)
    TextView as_total_gst;
    @BindView(2131361991)
    TextView as_transaction_id;
    @BindView(2131361988)
    RecyclerView as_txn_list;
    @BindView(2131361992)
    TextView as_ugst;
    @BindView(2131361993)
    TextView as_user_id_tv;
    @BindView(2131361994)
    TextView as_user_name_tv;
    public Date b = null;

    /* renamed from: b  reason: collision with other field name */
    public final C1279nb f4623b = new C1279nb();

    /* renamed from: c  reason: collision with other field name */
    public String f4624c = "";
    public String d = "";
    public String e;
    @BindView(2131362590)
    AdManagerAdView ewalet_acc_statment_bottom;
    @BindView(2131362591)
    AdManagerAdView ewalet_acc_statment_top;

    public class a implements View.OnClickListener {
        public a() {
        }

        public final void onClick(View view) {
            EwalletStatementFragment ewalletStatementFragment = EwalletStatementFragment.this;
            boolean z = ewalletStatementFragment.f4622a;
            if (!z) {
                ewalletStatementFragment.as_date_from_tv.setText(ewalletStatementFragment.f4624c);
                ewalletStatementFragment.as_date_upto_tv.setText(ewalletStatementFragment.d);
                ewalletStatementFragment.as_filter_rl.setVisibility(0);
                ewalletStatementFragment.as_filter_rl_ll.setBackground(ewalletStatementFragment.getResources().getDrawable(R.drawable.below_popup_white_bg));
                ewalletStatementFragment.f4622a = true;
            } else if (z) {
                ewalletStatementFragment.as_filter_rl.setVisibility(8);
                ewalletStatementFragment.f4622a = false;
            }
        }
    }

    public class b implements DatePickerDialog.OnDateSetListener {
        public b() {
        }

        public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Object obj;
            Object obj2;
            int i4 = EwalletStatementFragment.c;
            EwalletStatementFragment ewalletStatementFragment = EwalletStatementFragment.this;
            TextView textView = ewalletStatementFragment.as_date_from_tv;
            StringBuilder sb = new StringBuilder();
            if (i3 > 9) {
                obj = Integer.valueOf(i3);
            } else {
                obj = lf.h("0", i3);
            }
            sb.append(obj);
            sb.append(RemoteSettings.FORWARD_SLASH_STRING);
            int i5 = i2 + 1;
            if (i5 > 9) {
                obj2 = Integer.valueOf(i5);
            } else {
                obj2 = lf.h("0", i5);
            }
            sb.append(obj2);
            sb.append(RemoteSettings.FORWARD_SLASH_STRING);
            sb.append(i);
            textView.setText(sb);
            ewalletStatementFragment.as_date_from_tv.getText().toString();
        }
    }

    public class c implements DatePickerDialog.OnDateSetListener {
        public c() {
        }

        public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Object obj;
            Object obj2;
            int i4 = EwalletStatementFragment.c;
            EwalletStatementFragment ewalletStatementFragment = EwalletStatementFragment.this;
            TextView textView = ewalletStatementFragment.as_date_upto_tv;
            StringBuilder sb = new StringBuilder();
            if (i3 > 9) {
                obj = Integer.valueOf(i3);
            } else {
                obj = lf.h("0", i3);
            }
            sb.append(obj);
            sb.append(RemoteSettings.FORWARD_SLASH_STRING);
            int i5 = i2 + 1;
            if (i5 > 9) {
                obj2 = Integer.valueOf(i5);
            } else {
                obj2 = lf.h("0", i5);
            }
            sb.append(obj2);
            sb.append(RemoteSettings.FORWARD_SLASH_STRING);
            sb.append(i);
            textView.setText(sb);
            ewalletStatementFragment.as_date_upto_tv.getText().toString();
        }
    }

    static {
        C1354qp.R(EwalletStatementFragment.class);
    }

    public final void f(C1279nb nbVar) {
        C1066db accountDetail = nbVar.getAccountDetail();
        this.as_user_id_tv.setText(accountDetail.getUserId());
        this.as_account_status.setText(String.format(getActivity().getResources().getString(R.string.format_brackets), new Object[]{accountDetail.getActiveStatus()}));
        this.as_closing_balance.setText(String.format(getActivity().getResources().getString(R.string.format_rupees), new Object[]{accountDetail.geteWalletClosingBalance()}));
        this.as_reg_date.setText(C0535I5.j(accountDetail.geteWalletRegdDate()));
        this.as_transaction_id.setText(String.valueOf(accountDetail.geteWalletRegdTxnId()));
        this.as_total_amount.setText(String.format(getActivity().getResources().getString(R.string.format_rupees), new Object[]{Double.valueOf(accountDetail.getTotal_gst().doubleValue() + accountDetail.getAmount().doubleValue())}));
        this.as_user_name_tv.setText(accountDetail.getUserFullName());
        this.as_amount.setText(String.format(getActivity().getResources().getString(R.string.format_rupees), new Object[]{accountDetail.getAmount()}));
        this.as_total_gst.setText(String.format(getActivity().getResources().getString(R.string.format_rupees), new Object[]{accountDetail.getTotal_gst()}));
        this.as_cgst.setText(String.format(getActivity().getResources().getString(R.string.format_rupees), new Object[]{accountDetail.getCgst_charge()}));
        this.as_ugst.setText(String.format(getActivity().getResources().getString(R.string.format_rupees), new Object[]{accountDetail.getUgst_charge()}));
        this.as_igst.setText(String.format(getActivity().getResources().getString(R.string.format_rupees), new Object[]{accountDetail.getIgst_charge()}));
        this.as_sgst.setText(String.format(getActivity().getResources().getString(R.string.format_rupees), new Object[]{accountDetail.getSgst_charge()}));
        if (nbVar.getTransactionList() != null) {
            this.as_txn_list.setVisibility(0);
            this.as_ewallet_empty_list.setVisibility(8);
            this.as_txn_list.setAdapter(new AccStatementViewHolder(this.f4617a, nbVar.getTransactionList()));
            this.as_txn_list.setLayoutManager(new LinearLayoutManager(this.f4617a));
            if (nbVar.getTransactionList().isEmpty()) {
                this.as_ewallet_empty_list.setVisibility(0);
                C0535I5.g(getActivity(), getString(R.string.ew_empty_acc_stmt_list), this.as_ewallet_empty_list);
            }
        } else {
            this.as_txn_list.setVisibility(8);
            this.as_ewallet_empty_list.setVisibility(0);
            C0535I5.g(getActivity(), getString(R.string.ew_empty_acc_stmt_list), this.as_ewallet_empty_list);
        }
        this.a.dismiss();
    }

    @OnClick({2131361966})
    public void onApplyClick() {
        Date date;
        this.f4624c = this.as_date_from_tv.getText().toString();
        String charSequence = this.as_date_upto_tv.getText().toString();
        this.d = charSequence;
        String str = this.f4624c;
        SimpleDateFormat simpleDateFormat = this.f4619a;
        if (str != null && !str.isEmpty()) {
            try {
                this.f4620a = null;
                this.f4620a = simpleDateFormat.parse(str);
            } catch (Exception e2) {
                e2.getMessage();
            }
        }
        if (charSequence != null && !charSequence.isEmpty()) {
            try {
                this.b = null;
                this.b = simpleDateFormat.parse(charSequence);
                Calendar instance = Calendar.getInstance();
                instance.setTime(this.b);
                instance.add(11, 23);
                instance.add(12, 59);
                instance.add(13, 59);
                this.b = instance.getTime();
            } catch (Exception e3) {
                e3.getMessage();
            }
        }
        C1279nb nbVar = this.f4621a;
        if (nbVar == null || nbVar.getTransactionList() == null || nbVar.getTransactionList().isEmpty()) {
            C0535I5.t0(this.f4617a, getString(R.string.ew_empty_acc_stmt_list));
        } else {
            C1279nb nbVar2 = this.f4623b;
            nbVar2.setTransactionList((ArrayList) nbVar.getTransactionList().clone());
            Date date2 = this.f4620a;
            if (date2 == null || (date = this.b) == null) {
                if (date2 != null && this.b == null) {
                    this.a = ProgressDialog.show(getActivity(), getString(R.string.as_applying_filter_dialog_title), getString(R.string.as_applying_filter_dialog_msg), true, false);
                    Iterator<C1486xs> it = nbVar2.getTransactionList().iterator();
                    while (it.hasNext()) {
                        if (it.next().getTxnDate().before(this.f4620a)) {
                            it.remove();
                        }
                    }
                    f(nbVar2);
                    this.a.dismiss();
                    C0535I5.t0(this.f4617a, getString(R.string.as_filter_applied_toaster));
                } else if (date2 != null || this.b == null) {
                    C0535I5.t0(this.f4617a, getString(R.string.as_filter_no_input));
                } else {
                    this.a = ProgressDialog.show(getActivity(), getString(R.string.as_applying_filter_dialog_title), getString(R.string.as_applying_filter_dialog_msg), true, false);
                    Iterator<C1486xs> it2 = nbVar2.getTransactionList().iterator();
                    while (it2.hasNext()) {
                        if (it2.next().getTxnDate().after(this.b)) {
                            it2.remove();
                        }
                    }
                    f(nbVar2);
                    this.a.dismiss();
                    C0535I5.t0(this.f4617a, getString(R.string.as_filter_applied_toaster));
                }
            } else if (date.after(date2)) {
                this.a = ProgressDialog.show(getActivity(), getString(R.string.as_applying_filter_dialog_title), getString(R.string.as_applying_filter_dialog_msg), true, false);
                Iterator<C1486xs> it3 = nbVar2.getTransactionList().iterator();
                while (it3.hasNext()) {
                    C1486xs next = it3.next();
                    if (next.getTxnDate().before(this.f4620a) || next.getTxnDate().after(this.b)) {
                        it3.remove();
                    }
                }
                f(nbVar2);
                this.a.dismiss();
                C0535I5.t0(this.f4617a, getString(R.string.as_filter_applied_toaster));
            } else {
                nbVar2.setTransactionList((ArrayList<C1486xs>) null);
                f(nbVar2);
                C0535I5.t0(this.f4617a, getString(R.string.date_should_be_same));
            }
            nbVar2.setTransactionList((ArrayList) nbVar.getTransactionList().clone());
        }
        this.as_filter_rl.setVisibility(8);
        this.f4622a = false;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_account_statement, (ViewGroup) null);
        ButterKnife.bind((Object) this, inflate);
        this.f4617a = getContext();
        HomeActivity.d.setVisibility(0);
        HomeActivity.d.setOnClickListener(new a());
        if (!C0535I5.O((ConnectivityManager) getActivity().getSystemService("connectivity"), this.f4617a)) {
            new Handler().postDelayed(new C1301ob(), 5000);
        } else {
            this.a = ProgressDialog.show(getActivity(), getString(R.string.as_fetching_details), getString(R.string.please_wait_text), true, false);
            C1223kn knVar = C0793b1.a.f3912a;
            C1279nb nbVar = TicketHistoryUtil.f5371a;
            if (nbVar != null) {
                f(nbVar);
            } else {
                String g = C0657Qt.g();
                ((Om) C0657Qt.c(knVar)).y0(g + "ewalletStatement").c(C1181iv.a()).a(E0.a()).b(new C1347qb(this));
            }
        }
        GoogleAdParamDTO googleAdParamDTO = new GoogleAdParamDTO();
        googleAdParamDTO.setAge(C1450w1.f7009a);
        googleAdParamDTO.setGender(C1450w1.f7021c);
        C0535I5.Y(getActivity(), this.ewalet_acc_statment_top, googleAdParamDTO);
        C0535I5.Y(getActivity(), this.ewalet_acc_statment_bottom, googleAdParamDTO);
        return inflate;
    }

    @OnClick({2131361969})
    public void onDateFromClick() {
        Calendar instance = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(this.f4617a, new b(), instance.get(1), instance.get(2), instance.get(5));
        datePickerDialog.getDatePicker().setMaxDate(Calendar.getInstance().getTime().getTime());
        datePickerDialog.setTitle(getString(R.string.select_from));
        datePickerDialog.show();
        C0535I5.I(getActivity());
    }

    @OnClick({2131361971})
    public void onDateUptoClick() {
        Calendar instance = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(this.f4617a, new c(), instance.get(1), instance.get(2), instance.get(5));
        datePickerDialog.getDatePicker().setMaxDate(Calendar.getInstance().getTime().getTime());
        datePickerDialog.setTitle(getString(R.string.select_to));
        datePickerDialog.show();
        C0535I5.I(getActivity());
    }

    @OnClick({2131361976})
    public void onFilterClick() {
        this.as_filter_rl.setVisibility(8);
        this.f4622a = false;
    }

    @OnClick({2131361985})
    public void onResetClick() {
        this.as_date_from_tv.setText("");
        this.as_date_upto_tv.setText("");
        this.f4620a = null;
        this.b = null;
        this.f4624c = "";
        this.d = "";
        f(this.f4621a);
        this.as_filter_rl.setVisibility(8);
        this.f4622a = false;
    }

    @OnClick({2131361986})
    public void onSaveAccStmtClick() {
        try {
            this.as_acc_stmt.setDrawingCacheEnabled(true);
            this.as_acc_stmt.buildDrawingCache();
            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/IRCTC eWallet");
            this.f4618a = file;
            if (!file.exists()) {
                this.f4618a.mkdirs();
            }
            this.e = "IRCTC eWallet Account Statement (" + this.as_user_id_tv.getText() + ").png";
            int a2 = d7.a(getContext(), "android.permission.WRITE_EXTERNAL_STORAGE");
            int a3 = d7.a(getContext(), "android.permission.READ_EXTERNAL_STORAGE");
            if (a2 == 0) {
                if (a3 == 0) {
                    C0535I5.v0(this.as_acc_stmt, this.f4618a, this.e, Boolean.FALSE, getContext());
                    return;
                }
            }
            requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, 12);
        } catch (OutOfMemoryError e2) {
            e2.getMessage();
            C0535I5.t0(getActivity(), getString(R.string.as_unable_save_acc_stmt));
        }
    }

    public final void onStart() {
        super.onStart();
    }
}
