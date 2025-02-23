package cris.org.in.ima.fragment;

import android.app.ProgressDialog;
import android.content.Context;
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
import cris.org.in.ima.dto.oauth2.GoogleAdParamDTO;
import cris.org.in.ima.utils.TicketHistoryUtil;
import cris.org.in.ima.view_holder.RefundItemHolder;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.BookingResponseDTO;
import defpackage.C0613Ns;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import rx.Subscriber;

public class RefundTxnHistoryFragment extends Fragment {
    public static FragmentActivity a;

    /* renamed from: a  reason: collision with other field name */
    public ProgressDialog f5062a = null;

    /* renamed from: a  reason: collision with other field name */
    public Context f5063a;

    /* renamed from: a  reason: collision with other field name */
    public b f5064a;

    /* renamed from: a  reason: collision with other field name */
    public RefundItemHolder f5065a;

    /* renamed from: a  reason: collision with other field name */
    public ArrayList<C0613Ns.a> f5066a;

    /* renamed from: a  reason: collision with other field name */
    public C1223kn f5067a;
    @BindView(2131362060)
    TextView booking;
    @BindView(2131363807)
    RecyclerView bookingItems;
    @BindView(2131362395)
    TextView departure;
    @BindView(2131363607)
    AdManagerAdView refund_add_top;
    @BindView(2131363620)
    AdManagerAdView refund_history_bottom;
    @BindView(2131363975)
    TextView sort_by_spinner_text;
    @BindView(2131363978)
    RelativeLayout sortby_bottom_ll;

    public class a extends ClickableSpan {
        public a() {
        }

        public final void onClick(View view) {
            RefundTxnHistoryFragment refundTxnHistoryFragment = RefundTxnHistoryFragment.this;
            try {
                refundTxnHistoryFragment.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.irctc.co.in")));
            } catch (Exception e) {
                FragmentActivity fragmentActivity = RefundTxnHistoryFragment.a;
                e.getMessage();
                Toast.makeText(refundTxnHistoryFragment.getContext(), refundTxnHistoryFragment.getString(R.string.No_application_handle_request), 1).show();
            }
        }
    }

    static {
        C1354qp.R(RefundTxnHistoryFragment.class);
        new SimpleDateFormat("yyyyMMdd");
    }

    public RefundTxnHistoryFragment() {
        new ArrayList();
        new HashMap();
        new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss' HRS'");
    }

    public static void f(RefundTxnHistoryFragment refundTxnHistoryFragment, C0613Ns.a aVar, BookingResponseDTO bookingResponseDTO) {
        refundTxnHistoryFragment.getClass();
        C0535I5.f = bookingResponseDTO.getRefundStatusEtTkt();
        if (bookingResponseDTO.getPsgnDtlList() != null) {
            aVar.setPsgnDtlList(bookingResponseDTO.getPsgnDtlList());
        } else {
            aVar.setPsgnDtlList(new ArrayList());
        }
    }

    @OnClick({2131362060})
    public void arrival(View view) {
        g(this.booking, R.color.dark);
        g(this.departure, R.color.white);
        this.departure.setTextAppearance(getActivity(), R.style.fontForNormal);
        this.booking.setTextAppearance(getActivity(), R.style.fontForbold);
        h(2);
        this.sort_by_spinner_text.setText(getString(R.string.transaction_date));
        this.sortby_bottom_ll.setVisibility(8);
    }

    @OnClick({2131362395})
    public void departure(View view) {
        g(this.booking, R.color.white);
        g(this.departure, R.color.dark);
        this.departure.setTextAppearance(getActivity(), R.style.fontForbold);
        this.booking.setTextAppearance(getActivity(), R.style.fontForNormal);
        h(1);
        this.sort_by_spinner_text.setText("Departure Date");
        this.sortby_bottom_ll.setVisibility(8);
    }

    public final void g(TextView textView, int i) {
        for (Drawable drawable : textView.getCompoundDrawables()) {
            if (drawable != null) {
                drawable.setColorFilter(new PorterDuffColorFilter(getResources().getColor(i), PorterDuff.Mode.SRC_IN));
            }
        }
    }

    public final void h(int i) {
        ArrayList<C0613Ns.a> arrayList = this.f5066a;
        if (arrayList == null || arrayList.size() == 0) {
            arrayList = null;
        } else if (i == 1) {
            Collections.sort(arrayList, new C0643Ps());
        } else if (i == 2) {
            Collections.sort(arrayList, new Qs());
        }
        this.f5066a = arrayList;
        this.f5065a.notifyDataSetChanged();
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_refund_history, (ViewGroup) null);
        ButterKnife.bind((Object) this, inflate);
        this.f5063a = getContext();
        a = getActivity();
        new a();
        GoogleAdParamDTO googleAdParamDTO = new GoogleAdParamDTO();
        googleAdParamDTO.setAge(C1450w1.f7009a);
        googleAdParamDTO.setGender(C1450w1.f7021c);
        C0535I5.Y(getActivity(), this.refund_history_bottom, googleAdParamDTO);
        C0535I5.Y(getActivity(), this.refund_add_top, googleAdParamDTO);
        this.f5064a = new b();
        if (!C0535I5.O((ConnectivityManager) getActivity().getSystemService("connectivity"), this.f5063a)) {
            new Handler().postDelayed(new Rs(), 5000);
        } else {
            this.f5062a = ProgressDialog.show(getActivity(), getString(R.string.fetching_ticket_List), getString(R.string.please_wait_text), true, false);
            C1223kn knVar = C0793b1.a.f3912a;
            this.f5067a = knVar;
            if (knVar == null) {
                TicketHistoryUtil.c();
            }
            try {
                if (this.f5066a != null) {
                    RefundItemHolder refundItemHolder = new RefundItemHolder(this.f5066a, this.f5064a);
                    this.f5065a = refundItemHolder;
                    this.bookingItems.setAdapter(refundItemHolder);
                    this.bookingItems.setLayoutManager(new LinearLayoutManager(getContext()));
                } else {
                    String f = C0657Qt.f();
                    ((Om) C0657Qt.c(this.f5067a)).i0(f + "refundTktHistorySearch").c(C1181iv.a()).a(E0.a()).b(new C1024g0(this));
                }
            } catch (Exception e) {
                this.f5062a.dismiss();
                e.getMessage();
                C0535I5.t0(getActivity(), getString(R.string.please_try_again));
            }
        }
        HomeActivity.J();
        return inflate;
    }

    public final void onDestroy() {
        super.onDestroy();
        ProgressDialog progressDialog = this.f5062a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f5062a.dismiss();
        }
        C0535I5.u();
    }

    public final void onPause() {
        super.onPause();
        ProgressDialog progressDialog = this.f5062a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f5062a.dismiss();
        }
        C0535I5.u();
    }

    public final void onStop() {
        super.onStop();
        ProgressDialog progressDialog = this.f5062a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f5062a.dismiss();
        }
        C0535I5.u();
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

    public class b implements RefundItemHolder.a {

        /* renamed from: cris.org.in.ima.fragment.RefundTxnHistoryFragment$b$b  reason: collision with other inner class name */
        public class C0068b extends Subscriber<C0707Ue> {
            public final /* synthetic */ C0613Ns.a a;

            /* renamed from: a  reason: collision with other field name */
            public final /* synthetic */ View f5068a;

            public C0068b(C0613Ns.a aVar, View view) {
                this.a = aVar;
                this.f5068a = view;
            }

            public final void onCompleted() {
                FragmentActivity fragmentActivity = RefundTxnHistoryFragment.a;
                RefundTxnHistoryFragment.this.f5062a.dismiss();
            }

            public final void onError(Throwable th) {
                RefundTxnHistoryFragment.this.f5062a.dismiss();
                FragmentActivity fragmentActivity = RefundTxnHistoryFragment.a;
                xx.S(th, true, th);
            }

            public final void onNext(Object obj) {
                RefundTxnHistoryFragment refundTxnHistoryFragment;
                C0707Ue ue = (C0707Ue) obj;
                b bVar = b.this;
                if (ue != null) {
                    C0657Qt.h();
                    try {
                        if (ue.getErrorMsg() != null) {
                            RefundTxnHistoryFragment refundTxnHistoryFragment2 = RefundTxnHistoryFragment.this;
                            RefundTxnHistoryFragment refundTxnHistoryFragment3 = RefundTxnHistoryFragment.this;
                            C0535I5.m(refundTxnHistoryFragment2.getActivity(), false, ue.getErrorMsg().split("-")[0], refundTxnHistoryFragment3.getString(R.string.error), refundTxnHistoryFragment3.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                        } else {
                            FragmentActivity fragmentActivity = RefundTxnHistoryFragment.a;
                            ue.getTimeStamp().toString();
                            RefundTxnHistoryFragment refundTxnHistoryFragment4 = RefundTxnHistoryFragment.this;
                            RefundTxnHistoryFragment refundTxnHistoryFragment5 = RefundTxnHistoryFragment.this;
                            RefundTxnHistoryFragment.f(refundTxnHistoryFragment4, this.a, ue.getBookingResponseList().get(0));
                            refundTxnHistoryFragment5.bookingItems.getAdapter().notifyItemChanged(refundTxnHistoryFragment5.bookingItems.getChildAdapterPosition(this.f5068a));
                        }
                        refundTxnHistoryFragment = RefundTxnHistoryFragment.this;
                    } catch (Exception e) {
                        FragmentActivity fragmentActivity2 = RefundTxnHistoryFragment.a;
                        e.getMessage();
                        RefundTxnHistoryFragment refundTxnHistoryFragment6 = RefundTxnHistoryFragment.this;
                        RefundTxnHistoryFragment refundTxnHistoryFragment7 = RefundTxnHistoryFragment.this;
                        C0535I5.t0(refundTxnHistoryFragment6.getActivity(), refundTxnHistoryFragment7.getResources().getString(R.string.unable_process_message));
                        refundTxnHistoryFragment = refundTxnHistoryFragment7;
                    } catch (Throwable th) {
                        RefundTxnHistoryFragment.this.f5062a.dismiss();
                        throw th;
                    }
                    refundTxnHistoryFragment.f5062a.dismiss();
                    return;
                }
                RefundTxnHistoryFragment.this.f5062a.dismiss();
                RefundTxnHistoryFragment refundTxnHistoryFragment8 = RefundTxnHistoryFragment.this;
                C0535I5.t0(refundTxnHistoryFragment8.getActivity(), refundTxnHistoryFragment8.getResources().getString(R.string.unable_process_message));
            }
        }

        public b() {
        }

        public final void a(C0613Ns.a aVar, View view) {
            String str;
            RefundTxnHistoryFragment refundTxnHistoryFragment = RefundTxnHistoryFragment.this;
            if (!C0535I5.O((ConnectivityManager) refundTxnHistoryFragment.getActivity().getSystemService("connectivity"), refundTxnHistoryFragment.f5063a)) {
                new Handler().postDelayed(new a(), 5000);
            } else if (aVar.getPsgnDtlList() != null) {
                refundTxnHistoryFragment.bookingItems.getAdapter().notifyItemChanged(refundTxnHistoryFragment.bookingItems.getChildAdapterPosition(view));
            } else {
                refundTxnHistoryFragment.f5062a = ProgressDialog.show(refundTxnHistoryFragment.getActivity(), refundTxnHistoryFragment.getString(R.string.fetching_transaction_Details), refundTxnHistoryFragment.getString(R.string.please_wait_text));
                C1223kn knVar = C0793b1.a.f3912a;
                refundTxnHistoryFragment.f5067a = knVar;
                if (knVar != null) {
                    if (!aVar.isMetroServiceOpted()) {
                        if (aVar.isPostMealOpted()) {
                            if (aVar.getEtRefundType() != "FAILED") {
                                str = "CP";
                            }
                        } else if (aVar.getEtRefundType() != "FAILED") {
                            str = "C";
                        }
                        str = "F";
                    } else if (aVar.getEtRefundType() == "FAILED") {
                        str = "FM";
                    } else {
                        str = "CM";
                    }
                    try {
                        refundTxnHistoryFragment.f5062a.show();
                        String f = C0657Qt.f();
                        String format = String.format("/%s/%s", new Object[]{aVar.getTransactionId(), str});
                        ((Om) C0657Qt.c(refundTxnHistoryFragment.f5067a)).y1(f + "refundDetailsSearch" + format).c(C1181iv.a()).a(E0.a()).b(new C0068b(aVar, view));
                    } catch (Exception e) {
                        refundTxnHistoryFragment.f5062a.dismiss();
                        FragmentActivity fragmentActivity = RefundTxnHistoryFragment.a;
                        e.getMessage();
                        C0535I5.t0(refundTxnHistoryFragment.getActivity(), refundTxnHistoryFragment.getString(R.string.please_try_again));
                    }
                } else {
                    C0535I5.m(refundTxnHistoryFragment.getActivity(), false, refundTxnHistoryFragment.getResources().getString(R.string.unable_process_message), refundTxnHistoryFragment.getString(R.string.error), refundTxnHistoryFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                }
            }
        }

        public class a implements Runnable {
            public final void run() {
            }
        }
    }
}
