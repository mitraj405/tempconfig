package cris.org.in.ima.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cris.org.in.ima.IrctcImaApplication;
import cris.org.in.ima.adaptors.CustomAdapter;
import cris.org.in.ima.adaptors.ItemAnnualTransactionDetails;
import cris.org.in.ima.adaptors.ItemIRCTCTransactionBought;
import cris.org.in.ima.adaptors.ItemIRCTCTransactionDetails;
import cris.org.in.ima.adaptors.ItemRedeemLoyalityPoint;
import cris.org.in.ima.adaptors.ItemSBICoBrandCard;
import cris.org.in.ima.listener.OnSelectionListener;
import cris.org.in.prs.ima.R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import rx.Subscriber;

public class LoyalityTxnHistoryFragment extends Fragment implements View.OnTouchListener {
    public static SimpleDateFormat a;
    @BindView(2131364502)
    LinearLayout NoRecordFoundMsg;

    /* renamed from: a  reason: collision with other field name */
    public ProgressDialog f4754a = null;

    /* renamed from: a  reason: collision with other field name */
    public Context f4755a;

    /* renamed from: a  reason: collision with other field name */
    public CustomDialogFragment f4756a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<String> f4757a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    public C1291nx f4758a;

    /* renamed from: a  reason: collision with other field name */
    public C1311ox f4759a = null;
    @BindView(2131363151)
    RecyclerView annualTransactionView;
    @BindView(2131363153)
    LinearLayout annualTxnScrollView;
    public ArrayList<C1336px> b = new ArrayList<>();
    @BindView(2131363129)
    TextView loyalityAccNumber;
    @BindView(2131363130)
    TextView loyalityAccStatus;
    @BindView(2131363144)
    TextView loyalityMemberOn;
    @BindView(2131363145)
    TextView loyalityMemberValid;
    @BindView(2131363146)
    TextView loyalityParternerPoint;
    @BindView(2131363150)
    TextView loyalityPurchasePoint;
    @BindView(2131363137)
    TextView loyalityTotalPoint;
    @BindView(2131363158)
    TextView loyalityTransactionType;
    @BindView(2131363159)
    TextView loyalityTravelPoint;
    @BindView(2131363138)
    TextView loyalitycardType;
    @BindView(2131363152)
    TextView loyalitypointRedm;
    @BindView(2131364222)
    LinearLayout transaction_type_ll;

    public class b extends Subscriber<C1291nx> {
        public b() {
        }

        public final void onCompleted() {
            SimpleDateFormat simpleDateFormat = LoyalityTxnHistoryFragment.a;
        }

        public final void onError(Throwable th) {
            LoyalityTxnHistoryFragment.this.f4754a.dismiss();
            SimpleDateFormat simpleDateFormat = LoyalityTxnHistoryFragment.a;
            xx.S(th, true, th);
        }

        public final void onNext(Object obj) {
            C1291nx nxVar = (C1291nx) obj;
            LoyalityTxnHistoryFragment loyalityTxnHistoryFragment = LoyalityTxnHistoryFragment.this;
            loyalityTxnHistoryFragment.f4754a.dismiss();
            if (nxVar == null) {
                Context context = loyalityTxnHistoryFragment.f4755a;
                C0535I5.m(context, false, context.getResources().getString(R.string.unable_process_message), loyalityTxnHistoryFragment.getString(R.string.error), loyalityTxnHistoryFragment.f4755a.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
            } else if (nxVar.getError() == null) {
                loyalityTxnHistoryFragment.f4758a = nxVar;
                loyalityTxnHistoryFragment.b = nxVar.getSoftAnnualSummaries();
            } else {
                C0535I5.m(loyalityTxnHistoryFragment.f4755a, false, nxVar.getError(), loyalityTxnHistoryFragment.getString(R.string.error), loyalityTxnHistoryFragment.f4755a.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
            }
        }
    }

    public class c implements OnSelectionListener {
        public c() {
        }

        public final void onClick(String str) {
            LoyalityTxnHistoryFragment loyalityTxnHistoryFragment = LoyalityTxnHistoryFragment.this;
            loyalityTxnHistoryFragment.loyalityTransactionType.setText(str);
            loyalityTxnHistoryFragment.f4756a.dismiss();
            int w = xx.w(xx.h(str));
            if (w == 1) {
                loyalityTxnHistoryFragment.annualTxnScrollView.setVisibility(0);
                loyalityTxnHistoryFragment.NoRecordFoundMsg.setVisibility(8);
                loyalityTxnHistoryFragment.annualTransactionView.setLayoutManager(new LinearLayoutManager(loyalityTxnHistoryFragment.getContext()));
                ArrayList<C1336px> arrayList = loyalityTxnHistoryFragment.b;
                if (arrayList == null || arrayList.size() <= 0) {
                    loyalityTxnHistoryFragment.annualTxnScrollView.setVisibility(8);
                    loyalityTxnHistoryFragment.NoRecordFoundMsg.setVisibility(0);
                    return;
                }
                loyalityTxnHistoryFragment.annualTransactionView.setAdapter(new ItemAnnualTransactionDetails(loyalityTxnHistoryFragment.getContext(), loyalityTxnHistoryFragment.b));
            } else if (w == 2) {
                loyalityTxnHistoryFragment.annualTxnScrollView.setVisibility(0);
                loyalityTxnHistoryFragment.NoRecordFoundMsg.setVisibility(8);
                loyalityTxnHistoryFragment.annualTransactionView.setLayoutManager(new LinearLayoutManager(loyalityTxnHistoryFragment.getContext()));
                C1291nx nxVar = loyalityTxnHistoryFragment.f4758a;
                if (nxVar == null || nxVar.getLoyaltyTxnDetails() == null || loyalityTxnHistoryFragment.f4758a.getLoyaltyTxnDetails().getAccrualBookings() == null) {
                    loyalityTxnHistoryFragment.annualTxnScrollView.setVisibility(8);
                    loyalityTxnHistoryFragment.NoRecordFoundMsg.setVisibility(0);
                    return;
                }
                loyalityTxnHistoryFragment.annualTransactionView.setAdapter(new ItemIRCTCTransactionDetails(loyalityTxnHistoryFragment.f4755a, loyalityTxnHistoryFragment.f4758a.getLoyaltyTxnDetails().getAccrualBookings()));
            } else if (w == 3) {
                loyalityTxnHistoryFragment.annualTxnScrollView.setVisibility(0);
                loyalityTxnHistoryFragment.NoRecordFoundMsg.setVisibility(8);
                loyalityTxnHistoryFragment.annualTransactionView.setLayoutManager(new LinearLayoutManager(loyalityTxnHistoryFragment.getContext()));
                C1291nx nxVar2 = loyalityTxnHistoryFragment.f4758a;
                if (nxVar2 == null || nxVar2.getLoyaltyTxnDetails() == null) {
                    loyalityTxnHistoryFragment.annualTxnScrollView.setVisibility(8);
                    loyalityTxnHistoryFragment.NoRecordFoundMsg.setVisibility(0);
                    return;
                }
                loyalityTxnHistoryFragment.annualTransactionView.setAdapter(new ItemIRCTCTransactionBought(loyalityTxnHistoryFragment.f4755a, loyalityTxnHistoryFragment.f4758a.getLoyaltyTxnDetails().getPurchasePoints()));
            } else if (w == 4) {
                loyalityTxnHistoryFragment.annualTxnScrollView.setVisibility(0);
                loyalityTxnHistoryFragment.NoRecordFoundMsg.setVisibility(8);
                loyalityTxnHistoryFragment.annualTransactionView.setLayoutManager(new LinearLayoutManager(loyalityTxnHistoryFragment.getContext()));
                C1291nx nxVar3 = loyalityTxnHistoryFragment.f4758a;
                if (nxVar3 == null || nxVar3.getLoyaltyTxnDetails() == null || loyalityTxnHistoryFragment.f4758a.getLoyaltyTxnDetails().getPartnerTxns() == null) {
                    loyalityTxnHistoryFragment.annualTxnScrollView.setVisibility(8);
                    loyalityTxnHistoryFragment.NoRecordFoundMsg.setVisibility(0);
                    return;
                }
                loyalityTxnHistoryFragment.annualTransactionView.setAdapter(new ItemSBICoBrandCard(loyalityTxnHistoryFragment.f4755a, loyalityTxnHistoryFragment.f4758a.getLoyaltyTxnDetails().getPartnerTxns()));
            } else if (w == 5) {
                loyalityTxnHistoryFragment.annualTxnScrollView.setVisibility(0);
                loyalityTxnHistoryFragment.NoRecordFoundMsg.setVisibility(8);
                loyalityTxnHistoryFragment.annualTransactionView.setLayoutManager(new LinearLayoutManager(loyalityTxnHistoryFragment.getContext()));
                C1291nx nxVar4 = loyalityTxnHistoryFragment.f4758a;
                if (nxVar4 == null || nxVar4.getLoyaltyTxnDetails() == null || loyalityTxnHistoryFragment.f4758a.getLoyaltyTxnDetails().getRedemptionBookings() == null) {
                    loyalityTxnHistoryFragment.annualTxnScrollView.setVisibility(8);
                    loyalityTxnHistoryFragment.NoRecordFoundMsg.setVisibility(0);
                    return;
                }
                loyalityTxnHistoryFragment.annualTransactionView.setAdapter(new ItemRedeemLoyalityPoint(loyalityTxnHistoryFragment.f4755a, loyalityTxnHistoryFragment.f4758a.getLoyaltyTxnDetails().getRedemptionBookings()));
            }
        }
    }

    static {
        C1354qp.R(LoyalityTxnHistoryFragment.class);
    }

    public final void f() {
        if (!C0535I5.O((ConnectivityManager) getContext().getSystemService("connectivity"), getContext())) {
            new Handler().postDelayed(new a(), 5000);
            return;
        }
        C0793b1 b1Var = C0793b1.a;
        if (b1Var.f3912a != null) {
            ProgressDialog progressDialog = this.f4754a;
            if (progressDialog != null && progressDialog.isShowing()) {
                this.f4754a.dismiss();
            }
            this.f4754a = ProgressDialog.show(getActivity(), getString(R.string.Loyalty_Account_Details_loading), getString(R.string.please_wait));
            String i = C0657Qt.i();
            ((Om) C0657Qt.c(b1Var.f3912a)).b0(i + "softAccountDetails").c(C1181iv.a()).b(new b());
        }
    }

    public final void g(C1311ox oxVar) {
        this.loyalityAccNumber.setText(String.valueOf(oxVar.getLoyaltyNumber().toString()));
        this.loyalityAccStatus.setText(oxVar.getSoftAccountStatus());
        this.loyalityMemberOn.setText(a.format(Long.valueOf(oxVar.getAccountCreationDate().getTime())));
        TextView textView = this.loyalityMemberValid;
        textView.setText(String.valueOf(getString(R.string.To) + " " + a.format(Long.valueOf(oxVar.getAccountExpirationDate().getTime()))));
        this.loyalityTotalPoint.setText(String.valueOf(oxVar.getTotalPointsAvailable().toString()));
        this.loyalitypointRedm.setText(String.valueOf(oxVar.getTotalPointsRedeemed().toString()));
        this.loyalityTravelPoint.setText(String.valueOf(oxVar.getTotalTravelPoints().toString()));
        this.loyalityParternerPoint.setText(String.valueOf(oxVar.getTotalPartnerPoints().toString()));
        this.loyalityPurchasePoint.setText(String.valueOf(oxVar.getTotalPurchasePoints().toString()));
        this.loyalitycardType.setText(oxVar.getCardType().toString());
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        View inflate = layoutInflater.inflate(R.layout.fragment_loyality_txn_history, (ViewGroup) null);
        ButterKnife.bind((Object) this, inflate);
        this.f4755a = getContext();
        if (IrctcImaApplication.e.equalsIgnoreCase("hi")) {
            a = new SimpleDateFormat("dd MMM yyyy", new Locale("hi", "IN"));
        } else {
            a = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);
        }
        this.loyalityTransactionType.setText(getText(R.string.view_Loyalty_txn));
        String[] stringArray = getResources().getStringArray(R.array.loyality_array);
        int length = stringArray.length;
        int i = 0;
        while (i < length) {
            int h = xx.h(stringArray[i]);
            ArrayList<String> arrayList = this.f4757a;
            if (h != 0) {
                if (IrctcImaApplication.e.equalsIgnoreCase("hi")) {
                    str = xx.r(h);
                } else {
                    str = xx.n(h);
                }
                arrayList.add(str);
                i++;
            } else {
                throw null;
            }
        }
        C1311ox oxVar = (C1311ox) getArguments().getSerializable("softAccountSummary");
        this.f4759a = oxVar;
        if (oxVar.getBankName().contains("BOB")) {
            this.transaction_type_ll.setVisibility(8);
        }
        C1311ox oxVar2 = this.f4759a;
        if (oxVar2 != null) {
            g(oxVar2);
            f();
        } else if (!C0535I5.O((ConnectivityManager) getActivity().getSystemService("connectivity"), getContext())) {
            new Handler().postDelayed(new C0628Oj(), 5000);
        } else {
            C0793b1 b1Var = C0793b1.a;
            if (b1Var.f3912a != null) {
                ProgressDialog progressDialog = this.f4754a;
                if (progressDialog != null && progressDialog.isShowing()) {
                    this.f4754a.dismiss();
                }
                this.f4754a = ProgressDialog.show(getActivity(), getString(R.string.Getting_User_Profile), getString(R.string.please_wait));
                String i2 = C0657Qt.i();
                ((Om) C0657Qt.c(b1Var.f3912a)).h1(i2 + "accountDetails").c(C1181iv.a()).a(E0.a()).b(new C0641Pj(this));
            }
        }
        return inflate;
    }

    public final void onDestroy() {
        super.onDestroy();
        ProgressDialog progressDialog = this.f4754a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f4754a.dismiss();
        }
    }

    @OnClick({2131364222})
    public void onLoyalityTransationtypeClick(View view) {
        ArrayList<String> arrayList = this.f4757a;
        arrayList.toString();
        this.b.toString();
        CustomDialogFragment customDialogFragment = new CustomDialogFragment();
        this.f4756a = customDialogFragment;
        customDialogFragment.setShowsDialog(true);
        this.f4756a.show(getFragmentManager(), "");
        this.f4756a.setCancelable(true);
        getFragmentManager().z();
        CustomAdapter customAdapter = new CustomAdapter(getContext(), arrayList, new c());
        this.f4756a.g().setText(getString(R.string.loyalty_txn));
        this.f4756a.f().setAdapter(customAdapter);
    }

    public final void onPause() {
        super.onPause();
        ProgressDialog progressDialog = this.f4754a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f4754a.dismiss();
        }
    }

    public final void onResume() {
        super.onResume();
    }

    public final void onStop() {
        super.onStop();
        ProgressDialog progressDialog = this.f4754a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f4754a.dismiss();
        }
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }

    public class a implements Runnable {
        public final void run() {
        }
    }
}
