package cris.org.in.ima.fragment;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.firebase.sessions.settings.RemoteSettings;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.view_holder.EwalletRefundStatusViewHolder;
import cris.org.in.prs.ima.R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

public class EwalletRefundStatusFragment extends Fragment {
    public static final /* synthetic */ int c = 0;
    public final S9 a = new S9();

    /* renamed from: a  reason: collision with other field name */
    public ProgressDialog f4607a = null;

    /* renamed from: a  reason: collision with other field name */
    public Context f4608a;

    /* renamed from: a  reason: collision with other field name */
    public final SimpleDateFormat f4609a = new SimpleDateFormat("dd/MM/yyyy");

    /* renamed from: a  reason: collision with other field name */
    public Date f4610a = null;

    /* renamed from: a  reason: collision with other field name */
    public boolean f4611a = false;
    public final S9 b = new S9();

    /* renamed from: b  reason: collision with other field name */
    public Date f4612b = null;

    /* renamed from: c  reason: collision with other field name */
    public String f4613c = "";
    public String d = "";
    @BindView(2131363779)
    TextView rs_apply_tv;
    @BindView(2131363780)
    TextView rs_date_from_calendar;
    @BindView(2131363781)
    TextView rs_date_from_tv;
    @BindView(2131363782)
    TextView rs_date_upto_calendar;
    @BindView(2131363783)
    TextView rs_date_upto_tv;
    @BindView(2131363785)
    TextView rs_empty_list;
    @BindView(2131363786)
    RelativeLayout rs_filter_rl;
    @BindView(2131363787)
    LinearLayout rs_filter_rl_ll;
    @BindView(2131363796)
    TextView rs_reset_tv;
    @BindView(2131363798)
    RecyclerView rs_txn_list;

    public class a implements View.OnClickListener {
        public a() {
        }

        public final void onClick(View view) {
            EwalletRefundStatusFragment ewalletRefundStatusFragment = EwalletRefundStatusFragment.this;
            boolean z = ewalletRefundStatusFragment.f4611a;
            if (!z) {
                ewalletRefundStatusFragment.rs_date_from_tv.setText(ewalletRefundStatusFragment.f4613c);
                ewalletRefundStatusFragment.rs_date_upto_tv.setText(ewalletRefundStatusFragment.d);
                ewalletRefundStatusFragment.rs_filter_rl.setVisibility(0);
                ewalletRefundStatusFragment.rs_filter_rl_ll.setBackground(ewalletRefundStatusFragment.getResources().getDrawable(R.drawable.below_popup_white_bg));
                ewalletRefundStatusFragment.f4611a = true;
            } else if (z) {
                ewalletRefundStatusFragment.rs_filter_rl.setVisibility(8);
                ewalletRefundStatusFragment.f4611a = false;
            }
        }
    }

    public class b implements DatePickerDialog.OnDateSetListener {
        public b() {
        }

        public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Object obj;
            Object obj2;
            int i4 = EwalletRefundStatusFragment.c;
            EwalletRefundStatusFragment ewalletRefundStatusFragment = EwalletRefundStatusFragment.this;
            TextView textView = ewalletRefundStatusFragment.rs_date_from_tv;
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
            ewalletRefundStatusFragment.rs_date_from_tv.getText().toString();
        }
    }

    public class c implements DatePickerDialog.OnDateSetListener {
        public c() {
        }

        public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            Object obj;
            Object obj2;
            int i4 = EwalletRefundStatusFragment.c;
            EwalletRefundStatusFragment ewalletRefundStatusFragment = EwalletRefundStatusFragment.this;
            TextView textView = ewalletRefundStatusFragment.rs_date_upto_tv;
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
            ewalletRefundStatusFragment.rs_date_upto_tv.getText().toString();
        }
    }

    static {
        C1354qp.R(EwalletRefundStatusFragment.class);
    }

    public final void f(S9 s9) {
        if (s9.getRefundList() != null) {
            this.rs_txn_list.setVisibility(0);
            this.rs_empty_list.setVisibility(8);
            this.rs_txn_list.setAdapter(new EwalletRefundStatusViewHolder(this.f4608a, s9.getRefundList()));
            this.rs_txn_list.setLayoutManager(new LinearLayoutManager(this.f4608a));
            if (s9.getRefundList().isEmpty()) {
                this.rs_empty_list.setVisibility(0);
                C0535I5.g(getActivity(), getString(R.string.ew_empty_ref_list), this.rs_empty_list);
            }
        } else {
            this.rs_txn_list.setVisibility(8);
            this.rs_empty_list.setVisibility(0);
            C0535I5.g(getActivity(), getString(R.string.ew_empty_ref_list), this.rs_empty_list);
        }
        this.f4607a.dismiss();
    }

    @OnClick({2131363779})
    public void onApplyClick() {
        Date date;
        this.f4613c = this.rs_date_from_tv.getText().toString();
        String charSequence = this.rs_date_upto_tv.getText().toString();
        this.d = charSequence;
        String str = this.f4613c;
        SimpleDateFormat simpleDateFormat = this.f4609a;
        if (str != null && !str.isEmpty()) {
            try {
                this.f4610a = null;
                this.f4610a = simpleDateFormat.parse(str);
            } catch (Exception e) {
                e.getMessage();
            }
        }
        if (charSequence != null && !charSequence.isEmpty()) {
            try {
                this.f4612b = null;
                this.f4612b = simpleDateFormat.parse(charSequence);
                Calendar instance = Calendar.getInstance();
                instance.setTime(this.f4612b);
                instance.add(11, 23);
                instance.add(12, 59);
                instance.add(13, 59);
                this.f4612b = instance.getTime();
            } catch (Exception e2) {
                e2.getMessage();
            }
        }
        S9 s9 = this.a;
        if (s9 == null || s9.getRefundList() == null || s9.getRefundList().isEmpty()) {
            C0535I5.t0(this.f4608a, getString(R.string.ew_empty_ref_list));
        } else {
            S9 s92 = this.b;
            s92.setRefundList((ArrayList) s9.getRefundList().clone());
            Date date2 = this.f4610a;
            if (date2 == null || (date = this.f4612b) == null) {
                if (date2 != null && this.f4612b == null) {
                    this.f4607a = ProgressDialog.show(getActivity(), getString(R.string.rs_applying_filter_dialog_title), getString(R.string.rs_applying_filter_dialog_msg), true, false);
                    Iterator<C1194jb> it = s92.getRefundList().iterator();
                    while (it.hasNext()) {
                        if (it.next().getRefundDate().before(this.f4610a)) {
                            it.remove();
                        }
                    }
                    f(s92);
                    this.f4607a.dismiss();
                    C0535I5.t0(this.f4608a, getString(R.string.as_filter_applied_toaster));
                } else if (date2 != null || this.f4612b == null) {
                    C0535I5.t0(this.f4608a, getString(R.string.as_filter_no_input));
                } else {
                    this.f4607a = ProgressDialog.show(getActivity(), getString(R.string.rs_applying_filter_dialog_title), getString(R.string.rs_applying_filter_dialog_msg), true, false);
                    Iterator<C1194jb> it2 = s92.getRefundList().iterator();
                    while (it2.hasNext()) {
                        if (it2.next().getRefundDate().after(this.f4612b)) {
                            it2.remove();
                        }
                    }
                    f(s92);
                    this.f4607a.dismiss();
                    C0535I5.t0(this.f4608a, getString(R.string.as_filter_applied_toaster));
                }
            } else if (date.after(date2)) {
                this.f4607a = ProgressDialog.show(getActivity(), getString(R.string.rs_applying_filter_dialog_title), getString(R.string.rs_applying_filter_dialog_msg), true, false);
                Iterator<C1194jb> it3 = s92.getRefundList().iterator();
                while (it3.hasNext()) {
                    C1194jb next = it3.next();
                    if (next.getRefundDate().before(this.f4610a) || next.getRefundDate().after(this.f4612b)) {
                        it3.remove();
                    }
                }
                f(s92);
                this.f4607a.dismiss();
                C0535I5.t0(this.f4608a, getString(R.string.as_filter_applied_toaster));
            } else {
                s92.setRefundList((ArrayList<C1194jb>) null);
                f(s92);
                C0535I5.t0(this.f4608a, getString(R.string.date_should_be_same));
            }
            s92.setRefundList((ArrayList) s9.getRefundList().clone());
        }
        this.rs_filter_rl.setVisibility(8);
        this.f4611a = false;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_ewallet_refund_status, (ViewGroup) null);
        ButterKnife.bind((Object) this, inflate);
        this.f4608a = getContext();
        this.f4607a = ProgressDialog.show(getActivity(), getString(R.string.rs_fetching_details), getString(R.string.please_wait_text), true, false);
        String g = C0657Qt.g();
        ((Om) C0657Qt.c(C0793b1.a.f3912a)).S(g + "refundList").c(C1181iv.a()).a(E0.a()).b(new C1175ib(this));
        HomeActivity.d.setVisibility(0);
        HomeActivity.d.setOnClickListener(new a());
        return inflate;
    }

    @OnClick({2131363780})
    public void onDateFromClick() {
        Calendar instance = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(this.f4608a, new b(), instance.get(1), instance.get(2), instance.get(5));
        datePickerDialog.getDatePicker().setMaxDate(Calendar.getInstance().getTime().getTime());
        datePickerDialog.setTitle(getString(R.string.select_from));
        datePickerDialog.show();
        C0535I5.I(getActivity());
    }

    @OnClick({2131363782})
    public void onDateUptoClick() {
        Calendar instance = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(this.f4608a, new c(), instance.get(1), instance.get(2), instance.get(5));
        datePickerDialog.getDatePicker().setMaxDate(Calendar.getInstance().getTime().getTime());
        datePickerDialog.setTitle(getString(R.string.select_to));
        datePickerDialog.show();
        C0535I5.I(getActivity());
    }

    @OnClick({2131363786})
    public void onFilterClick() {
        this.rs_filter_rl.setVisibility(8);
        this.f4611a = false;
    }

    @OnClick({2131363796})
    public void onResetClick() {
        this.rs_date_from_tv.setText("");
        this.rs_date_upto_tv.setText("");
        this.f4610a = null;
        this.f4612b = null;
        this.f4613c = "";
        this.d = "";
        f(this.a);
        this.rs_filter_rl.setVisibility(8);
        this.f4611a = false;
    }

    public final void onStart() {
        super.onStart();
    }
}
