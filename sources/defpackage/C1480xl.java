package defpackage;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.adaptors.CustomAlertDialogAdapter;
import cris.org.in.ima.fragment.ERSFragment;
import cris.org.in.ima.fragment.MakePaymentNewFragment;
import cris.org.in.ima.fragment.NewBookingFragment;
import cris.org.in.ima.listener.OnSelectListenerYesNo;
import cris.org.in.ima.utils.TicketHistoryUtil;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.BookingResponseDTO;
import cris.prs.webservices.dto.StatusDTO;
import java.util.ArrayList;
import rx.Subscriber;

/* renamed from: xl  reason: default package and case insensitive filesystem */
/* compiled from: MobilePayment */
public final class C1480xl {
    public static Boolean a = Boolean.FALSE;

    /* renamed from: a  reason: collision with other field name */
    public static final C1480xl f7038a = new C1480xl();
    public static final int b = 1;
    public static final int c = 14;
    public static String d;

    /* renamed from: a  reason: collision with other field name */
    public int f7039a = 0;

    /* renamed from: a  reason: collision with other field name */
    public ProgressDialog f7040a = null;

    /* renamed from: a  reason: collision with other field name */
    public String f7041a;

    /* renamed from: a  reason: collision with other field name */
    public C1225kp f7042a;

    /* renamed from: a  reason: collision with other field name */
    public C1432ux f7043a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f7044a = false;

    /* renamed from: b  reason: collision with other field name */
    public String f7045b;

    /* renamed from: c  reason: collision with other field name */
    public String f7046c = null;

    /* renamed from: xl$a */
    /* compiled from: MobilePayment */
    public class a implements DialogInterface.OnClickListener {
        public final /* synthetic */ Fragment a;

        public a(Fragment fragment) {
            this.a = fragment;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            Fragment fragment = this.a;
            HomeActivity.B(fragment.getActivity());
            FragmentActivity activity = fragment.getActivity();
            NewBookingFragment newBookingFragment = new NewBookingFragment();
            String a2 = C1218kf.NEW_BOOKING.a();
            Boolean bool = Boolean.TRUE;
            HomeActivity.n(activity, newBookingFragment, a2, bool, bool);
        }
    }

    /* renamed from: xl$b */
    /* compiled from: MobilePayment */
    public class b implements DialogInterface.OnClickListener {
        public final /* synthetic */ Fragment a;

        public b(Fragment fragment) {
            this.a = fragment;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            Fragment fragment = this.a;
            HomeActivity.B(fragment.getActivity());
            FragmentActivity activity = fragment.getActivity();
            NewBookingFragment newBookingFragment = new NewBookingFragment();
            String a2 = C1218kf.NEW_BOOKING.a();
            Boolean bool = Boolean.TRUE;
            HomeActivity.n(activity, newBookingFragment, a2, bool, bool);
        }
    }

    /* renamed from: xl$c */
    /* compiled from: MobilePayment */
    public class c implements DialogInterface.OnClickListener {
        public final /* synthetic */ Context a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ MakePaymentNewFragment f7049a;

        public c(MakePaymentNewFragment makePaymentNewFragment, Context context) {
            this.f7049a = makePaymentNewFragment;
            this.a = context;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            this.f7049a.p();
            HomeActivity.D(this.a);
        }
    }

    /* renamed from: xl$d */
    /* compiled from: MobilePayment */
    public class d implements DialogInterface.OnClickListener {
        public final /* synthetic */ Context a;

        public d(Context context) {
            this.a = context;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            HomeActivity.D(this.a);
        }
    }

    /* renamed from: xl$e */
    /* compiled from: MobilePayment */
    public class e extends Subscriber<StatusDTO> {
        public final /* synthetic */ ProgressDialog a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ TextView f7052a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ Fragment f7053a;

        public e(ProgressDialog progressDialog, TextView textView, Fragment fragment) {
            this.a = progressDialog;
            this.f7052a = textView;
            this.f7053a = fragment;
        }

        public final void onCompleted() {
            Boolean bool = C1480xl.a;
            this.a.dismiss();
        }

        public final void onError(Throwable th) {
            this.a.dismiss();
            Boolean bool = C1480xl.a;
            th.getClass();
            th.getMessage();
            this.f7052a.setClickable(true);
            Lt.a(true, th);
        }

        public final void onNext(Object obj) {
            StatusDTO statusDTO = (StatusDTO) obj;
            this.a.dismiss();
            TextView textView = this.f7052a;
            Fragment fragment = this.f7053a;
            if (statusDTO == null) {
                Boolean bool = C1480xl.a;
                C0535I5.m(fragment.getContext(), false, "Unable To Process Your Request.\nPlease Try After Sometime.", fragment.getContext().getString(R.string.error), "OK", (DialogInterface.OnClickListener) null).show();
                textView.setClickable(true);
            } else if (statusDTO.getError() == null) {
                Boolean bool2 = C1480xl.a;
                C0535I5.o(fragment.getContext(), statusDTO.getStatus(), "OK", (DialogInterface.OnClickListener) null).show();
                if (statusDTO.getRegFlag().booleanValue()) {
                    new C1499yl(this).start();
                }
            } else {
                Boolean bool3 = C1480xl.a;
                C0535I5.m(fragment.getContext(), false, statusDTO.getError(), fragment.getContext().getString(R.string.error), "OK", (DialogInterface.OnClickListener) null).show();
                textView.setClickable(true);
            }
        }
    }

    /* renamed from: xl$f */
    /* compiled from: MobilePayment */
    public class f implements Runnable {
        public final /* synthetic */ Context a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ Fragment f7055a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ ArrayList f7056a;

        /* renamed from: xl$f$a */
        /* compiled from: MobilePayment */
        public class a extends Subscriber<C1074dm> {
            public a() {
            }

            public final void onCompleted() {
                Boolean bool = C1480xl.a;
            }

            public final void onError(Throwable th) {
                Boolean bool = C1480xl.a;
                th.getClass();
                th.getMessage();
                C1480xl.this.f7040a.dismiss();
                Lt.a(true, th);
            }

            public final void onNext(Object obj) {
                C1074dm dmVar = (C1074dm) obj;
                f fVar = f.this;
                C1480xl.this.f7040a.dismiss();
                Fragment fragment = fVar.f7055a;
                if (dmVar != null) {
                    C0657Qt.h();
                    try {
                        if (dmVar.getErrorMessage() != null) {
                            C0535I5.m(fragment.getContext(), false, dmVar.getErrorMessage(), fragment.getContext().getString(R.string.error), "OK", new C0543Il(this, dmVar)).show();
                        } else if (dmVar.getRetryAfterMili() != null && dmVar.getRetryAfterMili().intValue() > 0) {
                            new Handler().postDelayed(new C0556Jl(this), (long) dmVar.getRetryAfterMili().intValue());
                        } else if (!C0535I5.f3647h) {
                            C1480xl.this.a(fVar.a, fVar.f7055a, fVar.f7056a, dmVar.getBookingResponseDTO().get(0), dmVar);
                        } else if (dmVar.getBookingResponseDTO().size() > 1) {
                            BookingResponseDTO bookingResponseDTO = dmVar.getBookingResponseDTO().get(0);
                            BookingResponseDTO bookingResponseDTO2 = dmVar.getBookingResponseDTO().get(1);
                            if (bookingResponseDTO.getErrorMessage() == null || bookingResponseDTO2.getErrorMessage() == null) {
                                TicketHistoryUtil.c();
                                if (C1058d.d(C1480xl.this.f7042a.getBankId()) == 3) {
                                    TicketHistoryUtil.f5371a = null;
                                }
                                Bundle bundle = new Bundle();
                                ERSFragment eRSFragment = new ERSFragment();
                                bundle.putSerializable("FinalBookingSummary", dmVar);
                                eRSFragment.setArguments(bundle);
                                HomeActivity.n(fVar.a, eRSFragment, fragment.getActivity().getResources().getString(R.string.booking_detail_title), Boolean.TRUE, Boolean.FALSE);
                                return;
                            }
                            C1480xl.this.a(fVar.a, fVar.f7055a, fVar.f7056a, bookingResponseDTO, dmVar);
                        }
                    } catch (Exception e) {
                        Boolean bool = C1480xl.a;
                        e.getMessage();
                        C0535I5.m(fragment.getContext(), false, fragment.getString(R.string.some_error_occurred_check_bkg), fragment.getContext().getString(R.string.error), "OK", new C0569Kl(this)).show();
                    }
                } else {
                    C0535I5.m(fragment.getContext(), false, fragment.getString(R.string.some_error_occurred_please_try_again), fragment.getContext().getString(R.string.error), "OK", new C0583Ll(this)).show();
                }
            }
        }

        public f(Fragment fragment, FragmentActivity fragmentActivity, ArrayList arrayList) {
            this.f7055a = fragment;
            this.a = fragmentActivity;
            this.f7056a = arrayList;
        }

        public final void run() {
            C1507z0.b();
            Om om = (Om) C0657Qt.c(C0793b1.a.f3912a);
            String f = C0657Qt.f();
            if (C1450w1.f7032f) {
                f = C0657Qt.k();
            }
            C1480xl xlVar = C1480xl.this;
            om.J(xx.D(f, "verifyPayment", String.format("/%s", new Object[]{xlVar.f7041a})), xlVar.f7042a).c(C1181iv.a()).a(E0.a()).b(new a());
        }
    }

    /* renamed from: xl$g */
    /* compiled from: MobilePayment */
    public class g implements DialogInterface.OnClickListener {
        public final /* synthetic */ Context a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ Fragment f7058a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ C1480xl f7059a;

        public g(FragmentActivity fragmentActivity, Fragment fragment, C1480xl xlVar) {
            this.f7059a = xlVar;
            this.f7058a = fragment;
            this.a = fragmentActivity;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            if (this.f7059a.f7046c != null) {
                Fragment fragment = this.f7058a;
                C0535I5.W(fragment.getString(R.string.your_session_is_expired), false, new C0822cf(fragment.getActivity()), (String) null, (String) null);
            }
            HomeActivity.B(this.a);
        }
    }

    /* renamed from: xl$h */
    /* compiled from: MobilePayment */
    public class h implements OnSelectListenerYesNo {
        public final /* synthetic */ I7 a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ Context f7060a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ Fragment f7061a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ ArrayList f7062a;

        public h(I7 i7, Fragment fragment, ArrayList arrayList, Context context) {
            this.a = i7;
            this.f7061a = fragment;
            this.f7062a = arrayList;
            this.f7060a = context;
        }

        public final void a() {
            this.a.dismiss();
            HomeActivity.D(this.f7060a);
        }

        public final void b() {
            this.a.dismiss();
            C1480xl.this.b(this.f7061a, this.f7062a);
        }
    }

    static {
        C1354qp.R(C1480xl.class);
    }

    public static void f(String str) {
        d = str;
    }

    public final void a(Context context, Fragment fragment, ArrayList<Do> arrayList, BookingResponseDTO bookingResponseDTO, C1074dm dmVar) {
        String str;
        Context context2 = context;
        Fragment fragment2 = fragment;
        if (bookingResponseDTO.getErrorMessage() != null && !C0535I5.f3647h && bookingResponseDTO.getRetryBooking() != null && bookingResponseDTO.getRetryBooking().booleanValue()) {
            if (bookingResponseDTO.getErrorMessage().contains("-")) {
                str = bookingResponseDTO.getErrorMessage().split("-")[0];
            } else {
                str = bookingResponseDTO.getErrorMessage();
            }
            I7 i7 = new I7();
            i7.setShowsDialog(true);
            i7.show(fragment.getActivity().getSupportFragmentManager(), "");
            i7.setCancelable(false);
            fragment.getActivity().getSupportFragmentManager().z();
            FragmentActivity activity = fragment.getActivity();
            StringBuilder n = lf.n(str, "\n");
            n.append(fragment.getActivity().getResources().getString(R.string.booking_without_choice));
            CustomAlertDialogAdapter customAlertDialogAdapter = new CustomAlertDialogAdapter(activity, n.toString(), fragment.getContext().getString(R.string.yes_allsmall), fragment.getContext().getString(R.string.no_allsmall), new h(i7, fragment, arrayList, context));
            ((TextView) i7.a.findViewById(R.id.title)).setText("Retry Booking Confirmation");
            ((RecyclerView) i7.a.findViewById(R.id.list)).setAdapter(customAlertDialogAdapter);
        } else if (bookingResponseDTO.getErrorMessage() != null && bookingResponseDTO.getReservationId() != null) {
            TicketHistoryUtil.c();
            Context context3 = fragment.getContext();
            C0535I5.o(context3, bookingResponseDTO.getErrorMessage() + "\n" + fragment2.getString(R.string.check_bookings_failed_PNR_generated), "OK", new a(fragment2)).show();
        } else if (C0535I5.f3647h || bookingResponseDTO.getErrorMessage() != null || bookingResponseDTO.getReservationId() == null) {
            String errorMessage = bookingResponseDTO.getErrorMessage();
            if (errorMessage.contains("55002") || errorMessage.contains("55001")) {
                C0535I5.m(fragment.getContext(), false, errorMessage.split(" - ")[0], fragment.getContext().getString(R.string.error), "OK", new b(fragment2)).show();
            } else if (errorMessage.contains("SAME COACH") || errorMessage.contains("not met")) {
                C0535I5.m(fragment.getContext(), false, errorMessage, fragment.getContext().getString(R.string.error), "OK", new c((MakePaymentNewFragment) fragment2, context2)).show();
            } else {
                C0535I5.m(fragment.getContext(), false, errorMessage, fragment.getContext().getString(R.string.error), "OK", new d(context2)).show();
            }
        } else {
            TicketHistoryUtil.c();
            if (C1058d.d(this.f7042a.getBankId()) == 3) {
                TicketHistoryUtil.f5371a = null;
            }
            Bundle bundle = new Bundle();
            ERSFragment eRSFragment = new ERSFragment();
            bundle.putSerializable("FinalBookingSummary", dmVar);
            eRSFragment.setArguments(bundle);
            HomeActivity.n(context2, eRSFragment, fragment.getActivity().getResources().getString(R.string.booking_detail_title), Boolean.TRUE, Boolean.FALSE);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x007d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(androidx.fragment.app.Fragment r10, java.util.ArrayList<defpackage.Do> r11) {
        /*
            r9 = this;
            androidx.fragment.app.FragmentActivity r0 = r10.getActivity()
            java.lang.String r1 = "connectivity"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0
            android.content.Context r1 = r10.getContext()
            boolean r0 = defpackage.C0535I5.O(r0, r1)
            r1 = 0
            if (r0 != 0) goto L_0x002b
            java.lang.String r11 = r9.f7046c
            if (r11 == 0) goto L_0x002a
            cf r11 = new cf
            androidx.fragment.app.FragmentActivity r10 = r10.getActivity()
            r11.<init>(r10)
            java.lang.String r10 = "NETWORK_ISSUE"
            r0 = 0
            defpackage.C0535I5.W(r10, r1, r11, r0, r0)
        L_0x002a:
            return
        L_0x002b:
            androidx.fragment.app.FragmentActivity r0 = r10.getActivity()
            b1 r2 = defpackage.C0793b1.a
            kn r2 = r2.f3912a
            if (r2 == 0) goto L_0x008c
            kp r2 = r9.f7042a
            int r3 = b
            r2.setTxnStatus(r3)
            kp r2 = r9.f7042a
            r2.setParamList(r11)
            androidx.fragment.app.FragmentActivity r2 = r10.getActivity()
            r3 = 2131953533(0x7f13077d, float:1.954354E38)
            java.lang.String r3 = r10.getString(r3)
            r4 = 2131953495(0x7f130757, float:1.9543463E38)
            java.lang.String r4 = r10.getString(r4)
            android.app.ProgressDialog r2 = android.app.ProgressDialog.show(r2, r3, r4)
            r9.f7040a = r2
            tl r2 = defpackage.C1450w1.f7012a
            if (r2 == 0) goto L_0x007a
            java.lang.Integer r3 = r2.getMinmPaymentTime()
            int r3 = r3.intValue()
            java.lang.Integer r2 = r2.getPaymentCompletCheckEnable()
            int r2 = r2.intValue()
            r4 = 1
            if (r2 != r4) goto L_0x007a
            long r4 = java.lang.System.currentTimeMillis()
            long r6 = defpackage.C1450w1.e
            long r4 = r4 - r6
            int r2 = (int) r4
            int r3 = r3 - r2
            goto L_0x007b
        L_0x007a:
            r3 = r1
        L_0x007b:
            if (r3 <= 0) goto L_0x007e
            r1 = r3
        L_0x007e:
            xl$f r2 = new xl$f
            r2.<init>(r10, r0, r11)
            cB r10 = new cB
            r10.<init>(r2, r1)
            r10.a()
            goto L_0x00b5
        L_0x008c:
            android.content.Context r3 = r10.getContext()
            r4 = 0
            android.content.res.Resources r11 = r10.getResources()
            r1 = 2131954019(0x7f130963, float:1.9544525E38)
            java.lang.String r5 = r11.getString(r1)
            android.content.Context r11 = r10.getContext()
            r1 = 2131952699(0x7f13043b, float:1.9541848E38)
            java.lang.String r6 = r11.getString(r1)
            java.lang.String r7 = "OK"
            xl$g r8 = new xl$g
            r8.<init>(r0, r10, r9)
            android.app.AlertDialog r10 = defpackage.C0535I5.m(r3, r4, r5, r6, r7, r8)
            r10.show()
        L_0x00b5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C1480xl.b(androidx.fragment.app.Fragment, java.util.ArrayList):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0136 A[Catch:{ Exception -> 0x0146 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x01c6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(androidx.fragment.app.Fragment r12, java.util.ArrayList<defpackage.Do> r13) {
        /*
            r11 = this;
            boolean r0 = r11.f7044a
            b1 r1 = defpackage.C0793b1.a
            r2 = 2131953495(0x7f130757, float:1.9543463E38)
            r3 = 2131953533(0x7f13077d, float:1.954354E38)
            if (r0 == 0) goto L_0x00bf
            xl r0 = f7038a
            kp r0 = r0.f7042a
            int r0 = r0.getBankId()
            r4 = 1000(0x3e8, float:1.401E-42)
            if (r4 != r0) goto L_0x0071
            androidx.fragment.app.FragmentActivity r0 = r12.getActivity()
            Do r4 = new Do
            java.lang.String r5 = "TXN_TYPE"
            java.lang.String r6 = "SOFT_POINT_PURCHASE"
            r4.<init>(r5, r6)
            r13.add(r4)
            kp r4 = r11.f7042a
            r4.setParamList(r13)
            androidx.fragment.app.FragmentActivity r13 = r12.getActivity()
            java.lang.String r3 = r12.getString(r3)
            java.lang.String r2 = r12.getString(r2)
            android.app.ProgressDialog r13 = android.app.ProgressDialog.show(r13, r3, r2)
            r11.f7040a = r13
            kn r13 = r1.f3912a
            java.lang.Object r13 = defpackage.C0657Qt.c(r13)
            Om r13 = (defpackage.Om) r13
            java.lang.String r1 = defpackage.C0657Qt.i()
            java.lang.String r2 = "verifyEwalletPurchagePayment"
            java.lang.String r1 = defpackage.C1058d.z(r1, r2)
            kp r2 = r11.f7042a
            rx.Observable r13 = r13.H0(r1, r2)
            Lm r1 = defpackage.C1181iv.a()
            rx.Observable r13 = r13.c(r1)
            Yi r1 = defpackage.E0.a()
            rx.Observable r13 = r13.a(r1)
            Al r1 = new Al
            r1.<init>(r0, r12, r11)
            r13.b(r1)
            goto L_0x01f9
        L_0x0071:
            androidx.fragment.app.FragmentActivity r0 = r12.getActivity()
            kp r4 = r11.f7042a
            r4.setParamList(r13)
            androidx.fragment.app.FragmentActivity r13 = r12.getActivity()
            java.lang.String r3 = r12.getString(r3)
            java.lang.String r2 = r12.getString(r2)
            android.app.ProgressDialog r13 = android.app.ProgressDialog.show(r13, r3, r2)
            r11.f7040a = r13
            kn r13 = r1.f3912a
            java.lang.Object r13 = defpackage.C0657Qt.c(r13)
            Om r13 = (defpackage.Om) r13
            kp r1 = r11.f7042a
            long r1 = r1.getTransationId()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r2 = 4
            kp r3 = r11.f7042a
            rx.Observable r13 = r13.j1(r1, r2, r3)
            Lm r1 = defpackage.C1181iv.a()
            rx.Observable r13 = r13.c(r1)
            Yi r1 = defpackage.E0.a()
            rx.Observable r13 = r13.a(r1)
            Bl r1 = new Bl
            r1.<init>(r0, r12, r11)
            r13.b(r1)
            goto L_0x01f9
        L_0x00bf:
            java.lang.String r0 = r11.f7041a
            java.lang.String r4 = "POST_BOOKING"
            boolean r0 = r0.equalsIgnoreCase(r4)
            if (r0 == 0) goto L_0x01f6
            java.lang.Boolean r0 = a
            boolean r0 = r0.booleanValue()
            r4 = 0
            r5 = 1
            int r6 = b
            r7 = 2131952699(0x7f13043b, float:1.9541848E38)
            r8 = 2131952536(0x7f130398, float:1.9541518E38)
            java.lang.String r9 = "connectivity"
            if (r0 == 0) goto L_0x016d
            androidx.fragment.app.FragmentActivity r0 = r12.getActivity()
            java.lang.Object r0 = r0.getSystemService(r9)
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0
            android.content.Context r9 = r12.getContext()
            boolean r0 = defpackage.C0535I5.O(r0, r9)
            if (r0 != 0) goto L_0x00f3
            goto L_0x01f9
        L_0x00f3:
            androidx.fragment.app.FragmentActivity r0 = r12.getActivity()
            kn r1 = r1.f3912a
            if (r1 == 0) goto L_0x014c
            kp r1 = r11.f7042a     // Catch:{ Exception -> 0x0146 }
            r1.setTxnStatus(r6)     // Catch:{ Exception -> 0x0146 }
            kp r1 = r11.f7042a     // Catch:{ Exception -> 0x0146 }
            r1.setParamList(r13)     // Catch:{ Exception -> 0x0146 }
            java.lang.String r13 = r12.getString(r3)     // Catch:{ Exception -> 0x0146 }
            java.lang.String r1 = r12.getString(r2)     // Catch:{ Exception -> 0x0146 }
            android.app.ProgressDialog r13 = android.app.ProgressDialog.show(r0, r13, r1)     // Catch:{ Exception -> 0x0146 }
            r11.f7040a = r13     // Catch:{ Exception -> 0x0146 }
            tl r13 = defpackage.C1450w1.f7012a     // Catch:{ Exception -> 0x0146 }
            if (r13 == 0) goto L_0x0133
            java.lang.Integer r1 = r13.getMinmPaymentTime()     // Catch:{ Exception -> 0x0146 }
            int r1 = r1.intValue()     // Catch:{ Exception -> 0x0146 }
            java.lang.Integer r13 = r13.getPaymentCompletCheckEnable()     // Catch:{ Exception -> 0x0146 }
            int r13 = r13.intValue()     // Catch:{ Exception -> 0x0146 }
            if (r13 != r5) goto L_0x0133
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0146 }
            long r5 = defpackage.C1450w1.e     // Catch:{ Exception -> 0x0146 }
            long r2 = r2 - r5
            int r13 = (int) r2     // Catch:{ Exception -> 0x0146 }
            int r1 = r1 - r13
            goto L_0x0134
        L_0x0133:
            r1 = r4
        L_0x0134:
            if (r1 <= 0) goto L_0x0137
            r4 = r1
        L_0x0137:
            Hl r13 = new Hl     // Catch:{ Exception -> 0x0146 }
            r13.<init>(r0, r12, r11)     // Catch:{ Exception -> 0x0146 }
            cB r12 = new cB     // Catch:{ Exception -> 0x0146 }
            r12.<init>(r13, r4)     // Catch:{ Exception -> 0x0146 }
            r12.a()     // Catch:{ Exception -> 0x0146 }
            goto L_0x01f9
        L_0x0146:
            r12 = move-exception
            r12.getMessage()
            goto L_0x01f9
        L_0x014c:
            android.content.Context r0 = r12.getContext()
            r1 = 0
            android.content.res.Resources r13 = r12.getResources()
            java.lang.String r2 = r13.getString(r8)
            android.content.Context r12 = r12.getContext()
            java.lang.String r3 = r12.getString(r7)
            java.lang.String r4 = "OK"
            r5 = 0
            android.app.AlertDialog r12 = defpackage.C0535I5.m(r0, r1, r2, r3, r4, r5)
            r12.show()
            goto L_0x01f9
        L_0x016d:
            androidx.fragment.app.FragmentActivity r0 = r12.getActivity()
            java.lang.Object r0 = r0.getSystemService(r9)
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0
            android.content.Context r9 = r12.getContext()
            boolean r0 = defpackage.C0535I5.O(r0, r9)
            if (r0 != 0) goto L_0x0183
            goto L_0x01f9
        L_0x0183:
            androidx.fragment.app.FragmentActivity r0 = r12.getActivity()
            kn r1 = r1.f3912a
            if (r1 == 0) goto L_0x01d5
            kp r1 = r11.f7042a
            r1.setTxnStatus(r6)
            kp r1 = r11.f7042a
            r1.setParamList(r13)
            java.lang.String r13 = r12.getString(r3)
            java.lang.String r1 = r12.getString(r2)
            android.app.ProgressDialog r13 = android.app.ProgressDialog.show(r0, r13, r1)
            r11.f7040a = r13
            tl r13 = defpackage.C1450w1.f7012a
            if (r13 == 0) goto L_0x01c3
            java.lang.Integer r0 = r13.getMinmPaymentTime()
            int r0 = r0.intValue()
            java.lang.Integer r13 = r13.getPaymentCompletCheckEnable()
            int r13 = r13.intValue()
            if (r13 != r5) goto L_0x01c3
            long r1 = java.lang.System.currentTimeMillis()
            long r5 = defpackage.C1450w1.e
            long r1 = r1 - r5
            int r13 = (int) r1
            int r0 = r0 - r13
            goto L_0x01c4
        L_0x01c3:
            r0 = r4
        L_0x01c4:
            if (r0 <= 0) goto L_0x01c7
            r4 = r0
        L_0x01c7:
            Nl r13 = new Nl
            r13.<init>(r11, r12)
            cB r12 = new cB
            r12.<init>(r13, r4)
            r12.a()
            goto L_0x01f9
        L_0x01d5:
            android.content.Context r5 = r12.getContext()
            r6 = 0
            android.content.res.Resources r13 = r12.getResources()
            java.lang.String r13 = r13.getString(r8)
            android.content.Context r12 = r12.getContext()
            java.lang.String r8 = r12.getString(r7)
            java.lang.String r9 = "OK"
            r10 = 0
            r7 = r13
            android.app.AlertDialog r12 = defpackage.C0535I5.m(r5, r6, r7, r8, r9, r10)
            r12.show()
            goto L_0x01f9
        L_0x01f6:
            r11.b(r12, r13)
        L_0x01f9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C1480xl.c(androidx.fragment.app.Fragment, java.util.ArrayList):void");
    }

    public final void d(C1245lp lpVar, ArrayList arrayList, TextView textView, EditText editText, EditText editText2, TextView textView2) {
        if (C0535I5.O((ConnectivityManager) lpVar.a().getActivity().getSystemService("connectivity"), lpVar.a().getContext())) {
            String str = this.f7041a;
            C0793b1 b1Var = C0793b1.a;
            int i = b;
            if (str == null || str.equals("0")) {
                if (C0535I5.O((ConnectivityManager) lpVar.a().getActivity().getSystemService("connectivity"), lpVar.a().getContext())) {
                    if (b1Var.f3912a != null) {
                        this.f7040a = ProgressDialog.show(lpVar.a().getActivity(), lpVar.a().getString(R.string.processing_payment), lpVar.a().getString(R.string.please_wait_text));
                        this.f7042a.setTxnStatus(i);
                        this.f7042a.setParamList(new ArrayList());
                        ((Om) C0657Qt.c(b1Var.f3912a)).n1(C1058d.z(C0657Qt.g(), "initDepositPayment"), this.f7042a).c(C1181iv.a()).a(E0.a()).b(new C0506Fl(this, lpVar));
                        return;
                    }
                    C0535I5.m(lpVar.a().getContext(), false, lpVar.a().getResources().getString(R.string.data_connection_error_message), lpVar.a().getContext().getString(R.string.error), "OK", (DialogInterface.OnClickListener) null).show();
                }
            } else if (MakePaymentNewFragment.d) {
                f7038a.f7043a.setParamList(arrayList);
                this.f7040a = ProgressDialog.show(lpVar.a().getContext(), "Fetching data...", lpVar.a().getString(R.string.please_wait_text));
                ((Om) C0657Qt.c(b1Var.f3912a)).u0(C1058d.z(C0657Qt.i(), "initLoyaltyPurchasePayment"), this.f7043a).c(C1181iv.a()).a(E0.a()).b(new C1516zl(this, editText, textView, lpVar, editText2));
            } else if (b1Var.f3912a != null) {
                this.f7040a = ProgressDialog.show(lpVar.a().getActivity(), lpVar.a().getString(R.string.processing_payment), lpVar.a().getString(R.string.please_wait_text));
                this.f7042a.setTxnStatus(i);
                this.f7042a.setParamList(arrayList);
                ((Om) C0657Qt.c(b1Var.f3912a)).s(xx.D(C0657Qt.f(), "bookingInitPayment", String.format("/%s", new Object[]{this.f7041a})), d, this.f7042a).c(C1181iv.a()).a(E0.a()).b(new C0474Cl(this, editText, textView, lpVar, editText2, textView2));
            } else {
                C0535I5.m(lpVar.a().getContext(), false, lpVar.a().getResources().getString(R.string.your_session_is_expired), lpVar.a().getContext().getString(R.string.error), "OK", new Dl(this, lpVar)).show();
            }
        } else if (this.f7046c != null) {
            C0535I5.W("NETWORK_ISSUE", true, new C0822cf(lpVar.a().getActivity()), (String) null, (String) null);
        }
    }

    public final void e(Fragment fragment, TextView textView) {
        if (C0535I5.O((ConnectivityManager) fragment.getActivity().getSystemService("connectivity"), fragment.getContext())) {
            textView.setClickable(false);
            ProgressDialog progressDialog = new ProgressDialog(fragment.getContext());
            progressDialog.setMessage(fragment.getString(R.string.please_wait_text));
            progressDialog.setTitle(fragment.getString(R.string.sending_otp));
            progressDialog.setProgressStyle(0);
            progressDialog.show();
            C1223kn knVar = C0793b1.a.f3912a;
            if (knVar != null) {
                Om om = (Om) C0657Qt.c(knVar);
                String f2 = C0657Qt.f();
                String format = String.format("/%s", new Object[]{this.f7041a});
                if (this.f7044a) {
                    format = String.format("/%s", new Object[]{Long.valueOf(this.f7042a.getTransationId())});
                }
                om.v0(f2 + "resendPaymentOtp" + format).c(C1181iv.a()).a(E0.a()).b(new e(progressDialog, textView, fragment));
            }
        }
    }

    public final void finalize() throws Throwable {
        super.finalize();
        ProgressDialog progressDialog = this.f7040a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f7040a.dismiss();
        }
        C0535I5.u();
    }

    public final void g(C1245lp lpVar, ArrayList arrayList) {
        if (C0535I5.O((ConnectivityManager) lpVar.a().getActivity().getSystemService("connectivity"), lpVar.a().getContext())) {
            C0793b1 b1Var = C0793b1.a;
            if (b1Var.f3912a != null) {
                this.f7040a = ProgressDialog.show(lpVar.a().getActivity(), lpVar.a().getString(R.string.processing_payment), lpVar.a().getString(R.string.please_wait_text));
                this.f7042a.setTxnStatus(b);
                this.f7042a.setParamList(arrayList);
                this.f7042a.setApiName("TRANSACT");
                ((Om) C0657Qt.c(b1Var.f3912a)).A0(xx.D(C0657Qt.f(), "paymentProcessService", String.format("/%s", new Object[]{this.f7041a})), this.f7042a).c(C1181iv.a()).a(E0.a()).b(new C0522Gl(this, lpVar));
                return;
            }
            C0535I5.m(lpVar.a().getContext(), false, lpVar.a().getResources().getString(R.string.data_connection_error_message), lpVar.a().getContext().getString(R.string.error), "OK", (DialogInterface.OnClickListener) null).show();
        }
    }
}
