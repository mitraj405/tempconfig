package cris.org.in.ima.fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.gms.ads.admanager.AdManagerAdView;

public class PassengerDetailFragment_ViewBinding implements Unbinder {
    public View A;
    public View A0;
    public View B;
    public View B0;
    public View C;
    public View C0;
    public View D;
    public View D0;
    public View E;
    public View E0;
    public View F;
    public View F0;
    public View G;
    public View G0;
    public View H;
    public View H0;
    public View I;
    public View I0;
    public View J;
    public View J0;
    public View K;
    public View K0;
    public View L;
    public View L0;
    public View M;
    public View N;
    public View O;
    public View P;
    public View Q;
    public View R;
    public View S;
    public View T;
    public View U;
    public View V;
    public View W;
    public View X;
    public View Y;
    public View Z;
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public PassengerDetailFragment f5029a;

    /* renamed from: a  reason: collision with other field name */
    public D f5030a;

    /* renamed from: a  reason: collision with other field name */
    public H f5031a;

    /* renamed from: a  reason: collision with other field name */
    public V f5032a;
    public View a0;
    public View b;
    public View b0;
    public View c;
    public View c0;
    public View d;
    public View d0;
    public View e;
    public View e0;
    public View f;
    public View f0;
    public View g;
    public View g0;
    public View h;
    public View h0;
    public View i;
    public View i0;
    public View j;
    public View j0;
    public View k;
    public View k0;
    public View l;
    public View l0;
    public View m;
    public View m0;
    public View n;
    public View n0;
    public View o;
    public View o0;
    public View p;
    public View p0;
    public View q;
    public View q0;
    public View r;
    public View r0;
    public View s;
    public View s0;
    public View t;
    public View t0;
    public View u;
    public View u0;
    public View v;
    public View v0;
    public View w;
    public View w0;
    public View x;
    public View x0;
    public View y;
    public View y0;
    public View z;
    public View z0;

    public class A implements View.OnFocusChangeListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public A(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void onFocusChange(View view, boolean z) {
            this.a.streetLaneVerify(view);
        }
    }

    public class A0 extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public A0(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onOneLowerBerthLpap2Click(view);
        }
    }

    public class B implements View.OnFocusChangeListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public B(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void onFocusChange(View view, boolean z) {
            this.a.areaLocalityVerify(view);
        }
    }

    public class B0 extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public B0(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onTwoLowerBerthLap2Click(view);
        }
    }

    public class C implements View.OnFocusChangeListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public C(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void onFocusChange(View view, boolean z) {
            this.a.pinCodeValidate(view);
        }
    }

    public class C0 extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public C0(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onconfirmberthchoiceClick(view);
        }
    }

    public class D0 extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public D0(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onYesInsurancelayoutClick(view);
        }
    }

    public class E extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public E(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onCityClick(view);
        }
    }

    public class E0 extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public E0(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onNoInsurancelayoutClick(view);
        }
    }

    public class F implements View.OnFocusChangeListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public F(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void onFocusChange(View view, boolean z) {
            this.a.gstinValidate(view);
        }
    }

    public class F0 extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public F0(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onLap2YesInsurancelayoutClick(view);
        }
    }

    public class G extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public G(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onAddMasterPsgnClick(view);
        }
    }

    public class G0 extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public G0(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onLap2NoInsurancelayoutClick(view);
        }
    }

    public class H0 extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public H0(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onPassbookingconcessionClick(view);
        }
    }

    public class I extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public I(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onMasterPassCancelClick(view);
        }
    }

    public class I0 extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public I0(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onBookNowClick(view);
        }
    }

    public class J extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public J(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onClickgst(view);
        }
    }

    public class J0 extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public J0(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onSaveBtnClick(view);
        }
    }

    public class K extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public K(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.ongoneaddmeallay();
        }
    }

    public class K0 extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public K0(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onAddInfantWithBerthDetailClick(view);
        }
    }

    public class L extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public L(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onDoneAddMealClick(view);
        }
    }

    public class L0 extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public L0(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onMasterPassAddNewClick(view);
        }
    }

    public class M extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public M(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onAddBrackfastClick(view);
        }
    }

    public class M0 extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public M0(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onNoneBerthClick(view);
        }
    }

    public class N extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public N(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onAddLunchClick(view);
        }
    }

    public class N0 extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public N0(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onClickMasterpsgnList();
        }
    }

    public class O extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public O(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onAddSnacksClick(view);
        }
    }

    public class O0 extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public O0(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onReservationChoiceClick(view);
        }
    }

    public class P extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public P(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onAddDinnerClick(view);
        }
    }

    public class Q extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public Q(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.passengerAddressHeadingClick();
        }
    }

    public class R extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public R(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onAddInfantClick(view);
        }
    }

    public class S implements View.OnFocusChangeListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public S(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void onFocusChange(View view, boolean z) {
            this.a.et_address(view);
        }
    }

    public class T extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public T(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onCittownyClick(view);
        }
    }

    public class U implements View.OnFocusChangeListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public U(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void onFocusChange(View view, boolean z) {
            this.a.psgnPinCodeValidate(view);
        }
    }

    public class W extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public W(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onPostOfficeClick(view);
        }
    }

    public class X extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public X(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onAddFevJourneyClocl(view);
        }
    }

    public class Y extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public Y(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onllClick(view);
        }
    }

    public class Z extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public Z(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onOtherPreferenceClick(view);
        }
    }

    /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment_ViewBinding$a  reason: case insensitive filesystem */
    public class C0970a extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public C0970a(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onRegervationClick(view);
        }
    }

    /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment_ViewBinding$a0  reason: case insensitive filesystem */
    public class C0971a0 extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public C0971a0(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onNonselectbookClick(view);
        }
    }

    /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment_ViewBinding$b  reason: case insensitive filesystem */
    public class C0972b extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public C0972b(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onTAllBerthClick(view);
        }
    }

    /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment_ViewBinding$b0  reason: case insensitive filesystem */
    public class C0973b0 extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public C0973b0(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onAllLapselectbookClick(view);
        }
    }

    /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment_ViewBinding$c  reason: case insensitive filesystem */
    public class C0974c extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public C0974c(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onOneLowerBerthClick(view);
        }
    }

    /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment_ViewBinding$c0  reason: case insensitive filesystem */
    public class C0975c0 extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public C0975c0(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onStationClick(view);
        }
    }

    /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment_ViewBinding$d  reason: case insensitive filesystem */
    public class C0976d extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public C0976d(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onTwoLowerBerthClick(view);
        }
    }

    /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment_ViewBinding$d0  reason: case insensitive filesystem */
    public class C0977d0 extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public C0977d0(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onLap1selectbookClick(view);
        }
    }

    /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment_ViewBinding$e  reason: case insensitive filesystem */
    public class C0978e implements View.OnFocusChangeListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public C0978e(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void onFocusChange(View view, boolean z) {
            this.a.passengerNameVerify(view);
        }
    }

    /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment_ViewBinding$e0  reason: case insensitive filesystem */
    public class C0979e0 extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public C0979e0(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onLap2selectbookClick(view);
        }
    }

    /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment_ViewBinding$f  reason: case insensitive filesystem */
    public class C0980f extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public C0980f(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onPassangerAgeClick(view);
        }
    }

    /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment_ViewBinding$f0  reason: case insensitive filesystem */
    public class C0981f0 extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public C0981f0(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onAnyLapselectbookClick(view);
        }
    }

    /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment_ViewBinding$g  reason: case insensitive filesystem */
    public class C0982g extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public C0982g(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onMaleBtnClick(view);
        }
    }

    /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment_ViewBinding$g0  reason: case insensitive filesystem */
    public class C0983g0 extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public C0983g0(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onselectbookGoneClick(view);
        }
    }

    /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment_ViewBinding$h  reason: case insensitive filesystem */
    public class C0984h extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public C0984h(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onFemaleBtnClick(view);
        }
    }

    /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment_ViewBinding$h0  reason: case insensitive filesystem */
    public class C0985h0 extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public C0985h0(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onselectbookClick(view);
        }
    }

    /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment_ViewBinding$i  reason: case insensitive filesystem */
    public class C0986i extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public C0986i(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onTransgenderBtnClick(view);
        }
    }

    /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment_ViewBinding$i0  reason: case insensitive filesystem */
    public class C0987i0 extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public C0987i0(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onLap1AddBrackfastClick(view);
        }
    }

    /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment_ViewBinding$j  reason: case insensitive filesystem */
    public class C0988j extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public C0988j(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onNationalityClick(view);
        }
    }

    /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment_ViewBinding$j0  reason: case insensitive filesystem */
    public class C0989j0 extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public C0989j0(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onLap1AddLunchClick(view);
        }
    }

    /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment_ViewBinding$k  reason: case insensitive filesystem */
    public class C0990k extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public C0990k(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onBoardingStationClick(view);
        }
    }

    /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment_ViewBinding$k0  reason: case insensitive filesystem */
    public class C0991k0 extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public C0991k0(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onLapAddSnacksClick(view);
        }
    }

    /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment_ViewBinding$l  reason: case insensitive filesystem */
    public class C0992l extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public C0992l(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onBerthPreferenceClick(view);
        }
    }

    /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment_ViewBinding$l0  reason: case insensitive filesystem */
    public class C0993l0 extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public C0993l0(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onLapAddDinnerClick(view);
        }
    }

    /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment_ViewBinding$m  reason: case insensitive filesystem */
    public class C0994m extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public C0994m(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onIdCardClick(view);
        }
    }

    /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment_ViewBinding$m0  reason: case insensitive filesystem */
    public class C0995m0 extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public C0995m0(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onLapDoneAddMealClick(view);
        }
    }

    /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment_ViewBinding$n  reason: case insensitive filesystem */
    public class C0996n extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public C0996n(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onSpecialConcession(view);
        }
    }

    /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment_ViewBinding$n0  reason: case insensitive filesystem */
    public class C0997n0 extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public C0997n0(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onYesInsuranceClick(view);
        }
    }

    /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment_ViewBinding$o  reason: case insensitive filesystem */
    public class C0998o extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public C0998o(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onSeniorCtznConcessionClick(view);
        }
    }

    /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment_ViewBinding$o0  reason: case insensitive filesystem */
    public class C0999o0 extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public C0999o0(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onLap2YesInsuranceClick(view);
        }
    }

    /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment_ViewBinding$p  reason: case insensitive filesystem */
    public class C1000p extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public C1000p(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onFoodChoiceClick(view);
        }
    }

    public class p0 extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public p0(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onLap2NoInsuranceClick(view);
        }
    }

    /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment_ViewBinding$q  reason: case insensitive filesystem */
    public class C1001q extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public C1001q(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onAddpsgndetailgone(view);
        }
    }

    public class q0 extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public q0(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onLap2BerthPreferenceClick(view);
        }
    }

    /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment_ViewBinding$r  reason: case insensitive filesystem */
    public class C1002r extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public C1002r(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onAddMasterPsgnGone(view);
        }
    }

    public class r0 extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public r0(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onLap2FoodChoiceClick(view);
        }
    }

    /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment_ViewBinding$s  reason: case insensitive filesystem */
    public class C1003s extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public C1003s(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onAddPsgnInfantGone(view);
        }
    }

    public class s0 extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public s0(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onLap2SpecialConcession(view);
        }
    }

    /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment_ViewBinding$t  reason: case insensitive filesystem */
    public class C1004t extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public C1004t(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onChildAgeClick(view);
        }
    }

    public class t0 extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public t0(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onLap2IdCardClick(view);
        }
    }

    /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment_ViewBinding$u  reason: case insensitive filesystem */
    public class C1005u extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public C1005u(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onChildMaleBtnClick(view);
        }
    }

    public class u0 extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public u0(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onLap2SeniorCtznConcessionClick(view);
        }
    }

    /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment_ViewBinding$v  reason: case insensitive filesystem */
    public class C1006v extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public C1006v(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onAddPsgnDetailClick(view);
        }
    }

    public class v0 extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public v0(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onReservationChoiceLap2Click(view);
        }
    }

    /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment_ViewBinding$w  reason: case insensitive filesystem */
    public class C1007w extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public C1007w(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onChildFemaleBtnClick(view);
        }
    }

    public class w0 extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public w0(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onReservationChoicelayoutLap2Click(view);
        }
    }

    /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment_ViewBinding$x  reason: case insensitive filesystem */
    public class C1008x extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public C1008x(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onChildTransgenderBtnClick(view);
        }
    }

    public class x0 extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public x0(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onNoneBerthLap2Click(view);
        }
    }

    /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment_ViewBinding$y  reason: case insensitive filesystem */
    public class C1009y extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public C1009y(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onSaveChildClick(view);
        }
    }

    public class y0 extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public y0(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onNoInsuranceClick(view);
        }
    }

    /* renamed from: cris.org.in.ima.fragment.PassengerDetailFragment_ViewBinding$z  reason: case insensitive filesystem */
    public class C1010z implements View.OnFocusChangeListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public C1010z(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void onFocusChange(View view, boolean z) {
            this.a.flaDoorBlockVerify(view);
        }
    }

    public class z0 extends DebouncingOnClickListener {
        public final /* synthetic */ PassengerDetailFragment a;

        public z0(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void doClick(View view) {
            this.a.onTAllBerthLap2Click(view);
        }
    }

    public PassengerDetailFragment_ViewBinding(PassengerDetailFragment passengerDetailFragment, View view) {
        this.f5029a = passengerDetailFragment;
        Class cls = TextView.class;
        passengerDetailFragment.trainName = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.tv_train_name, "field 'trainName'", cls);
        passengerDetailFragment.quota = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.tv_quota, "field 'quota'", cls);
        passengerDetailFragment.trainNumber = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.tv_train_number, "field 'trainNumber'", cls);
        passengerDetailFragment.avlClass = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.tv_avl_class, "field 'avlClass'", cls);
        passengerDetailFragment.depTime = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.tv_departure_time, "field 'depTime'", cls);
        passengerDetailFragment.travelTime = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.tv_travel_time, "field 'travelTime'", cls);
        passengerDetailFragment.arrTime = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.tv_arrival_time, "field 'arrTime'", cls);
        passengerDetailFragment.fromStation = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.tv_from_stationname, "field 'fromStation'", cls);
        passengerDetailFragment.fromStationCode = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.tv_from_stationcode, "field 'fromStationCode'", cls);
        passengerDetailFragment.toStation = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.tv_to_stationname, "field 'toStation'", cls);
        passengerDetailFragment.toStatinCode = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.tv_to_stationcode, "field 'toStatinCode'", cls);
        View findRequiredView = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.tv_boarding_station_select, "field 'tvBoardingStation' and method 'onBoardingStationClick'");
        passengerDetailFragment.tvBoardingStation = (TextView) Utils.castView(findRequiredView, cris.org.in.prs.ima.R.id.tv_boarding_station_select, "field 'tvBoardingStation'", cls);
        this.a = findRequiredView;
        findRequiredView.setOnClickListener(new C0990k(passengerDetailFragment));
        View findRequiredView2 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.tv_add_psgn_detail, "field 'addPsgnDetails' and method 'onAddPsgnDetailClick'");
        passengerDetailFragment.addPsgnDetails = (TextView) Utils.castView(findRequiredView2, cris.org.in.prs.ima.R.id.tv_add_psgn_detail, "field 'addPsgnDetails'", cls);
        this.b = findRequiredView2;
        findRequiredView2.setOnClickListener(new C1006v(passengerDetailFragment));
        View findRequiredView3 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.tv_master_psgn_add, "field 'addMasterPsgnList' and method 'onAddMasterPsgnClick'");
        passengerDetailFragment.addMasterPsgnList = (TextView) Utils.castView(findRequiredView3, cris.org.in.prs.ima.R.id.tv_master_psgn_add, "field 'addMasterPsgnList'", cls);
        this.c = findRequiredView3;
        findRequiredView3.setOnClickListener(new G(passengerDetailFragment));
        View findRequiredView4 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.tv_infant_psgn_add, "field 'addInfantPsgnList' and method 'onAddInfantClick'");
        passengerDetailFragment.addInfantPsgnList = (TextView) Utils.castView(findRequiredView4, cris.org.in.prs.ima.R.id.tv_infant_psgn_add, "field 'addInfantPsgnList'", cls);
        this.d = findRequiredView4;
        findRequiredView4.setOnClickListener(new R(passengerDetailFragment));
        Class cls2 = EditText.class;
        passengerDetailFragment.mobileNumber = (EditText) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.et_mobile_number, "field 'mobileNumber'", cls2);
        passengerDetailFragment.isdCode = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.tv_isdCode, "field 'isdCode'", cls);
        Class cls3 = RecyclerView.class;
        passengerDetailFragment.boardingStnView = (RecyclerView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.boarding_stn, "field 'boardingStnView'", cls3);
        passengerDetailFragment.boardingStnName = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.boarding_stn_name, "field 'boardingStnName'", cls);
        View findRequiredView5 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.select_station_ll, "field 'selectstation_ll' and method 'onStationClick'");
        Class cls4 = RelativeLayout.class;
        passengerDetailFragment.selectstation_ll = (RelativeLayout) Utils.castView(findRequiredView5, cris.org.in.prs.ima.R.id.select_station_ll, "field 'selectstation_ll'", cls4);
        this.e = findRequiredView5;
        findRequiredView5.setOnClickListener(new C0975c0(passengerDetailFragment));
        Class cls5 = RadioGroup.class;
        passengerDetailFragment.radioInsurance = (RadioGroup) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.radio_insurance, "field 'radioInsurance'", cls5);
        View findRequiredView6 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.insurance_opt, "field 'insuranceOpt' and method 'onYesInsuranceClick'");
        Class cls6 = RadioButton.class;
        passengerDetailFragment.insuranceOpt = (RadioButton) Utils.castView(findRequiredView6, cris.org.in.prs.ima.R.id.insurance_opt, "field 'insuranceOpt'", cls6);
        this.f = findRequiredView6;
        findRequiredView6.setOnClickListener(new C0997n0(passengerDetailFragment));
        View findRequiredView7 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.no_insurance_opt, "field 'noInsuranceOpt' and method 'onNoInsuranceClick'");
        passengerDetailFragment.noInsuranceOpt = (RadioButton) Utils.castView(findRequiredView7, cris.org.in.prs.ima.R.id.no_insurance_opt, "field 'noInsuranceOpt'", cls6);
        this.g = findRequiredView7;
        findRequiredView7.setOnClickListener(new y0(passengerDetailFragment));
        passengerDetailFragment.addPsgnLayout = (RelativeLayout) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.add_psgn_layout, "field 'addPsgnLayout'", cls4);
        Class cls7 = LinearLayout.class;
        passengerDetailFragment.insuranceLayout = (LinearLayout) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.insuranceLayout, "field 'insuranceLayout'", cls7);
        passengerDetailFragment.insuranceTexts = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.insurance_text, "field 'insuranceTexts'", cls);
        passengerDetailFragment.farePerPerson = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.tv_fare, "field 'farePerPerson'", cls);
        passengerDetailFragment.ll_fare_per_person = (LinearLayout) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.ll_fare_per_person, "field 'll_fare_per_person'", cls7);
        View findRequiredView8 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.tv_done_psgn_detail, "field 'donePsgnDetail' and method 'onSaveBtnClick'");
        passengerDetailFragment.donePsgnDetail = (TextView) Utils.castView(findRequiredView8, cris.org.in.prs.ima.R.id.tv_done_psgn_detail, "field 'donePsgnDetail'", cls);
        this.h = findRequiredView8;
        findRequiredView8.setOnClickListener(new J0(passengerDetailFragment));
        passengerDetailFragment.termcondition = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.termcondition, "field 'termcondition'", cls);
        passengerDetailFragment.termcondition_ll = (LinearLayout) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.termcondition_ll, "field 'termcondition_ll'", cls7);
        passengerDetailFragment.errorMessage = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.tv_error_msg, "field 'errorMessage'", cls);
        Class cls8 = CheckBox.class;
        passengerDetailFragment.isAutoUpgradation = (CheckBox) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.auto_upgradation, "field 'isAutoUpgradation'", cls8);
        passengerDetailFragment.auto_upgra_layout = (LinearLayout) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.auto_upgra_layout, "field 'auto_upgra_layout'", cls7);
        passengerDetailFragment.isIgnoreChoiceIfWl = (CheckBox) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.book_on_cnf_only, "field 'isIgnoreChoiceIfWl'", cls8);
        passengerDetailFragment.preferredCoach = (EditText) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.preferred_coach, "field 'preferredCoach'", cls2);
        View findRequiredView9 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.tv_reservation_choice, "field 'reservationChoiceClick' and method 'onReservationChoiceClick'");
        passengerDetailFragment.reservationChoiceClick = (TextView) Utils.castView(findRequiredView9, cris.org.in.prs.ima.R.id.tv_reservation_choice, "field 'reservationChoiceClick'", cls);
        this.i = findRequiredView9;
        findRequiredView9.setOnClickListener(new O0(passengerDetailFragment));
        View findRequiredView10 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.regervation_choice_ll, "field 'regervationchoice_ll' and method 'onRegervationClick'");
        passengerDetailFragment.regervationchoice_ll = (RelativeLayout) Utils.castView(findRequiredView10, cris.org.in.prs.ima.R.id.regervation_choice_ll, "field 'regervationchoice_ll'", cls4);
        this.j = findRequiredView10;
        findRequiredView10.setOnClickListener(new C0970a(passengerDetailFragment));
        View findRequiredView11 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.tv_all_berth_confirm, "field 'allBerthConfirm' and method 'onTAllBerthClick'");
        passengerDetailFragment.allBerthConfirm = (TextView) Utils.castView(findRequiredView11, cris.org.in.prs.ima.R.id.tv_all_berth_confirm, "field 'allBerthConfirm'", cls);
        this.k = findRequiredView11;
        findRequiredView11.setOnClickListener(new C0972b(passengerDetailFragment));
        View findRequiredView12 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.tv_one_lower_berth, "field 'oneLowerBerth' and method 'onOneLowerBerthClick'");
        passengerDetailFragment.oneLowerBerth = (TextView) Utils.castView(findRequiredView12, cris.org.in.prs.ima.R.id.tv_one_lower_berth, "field 'oneLowerBerth'", cls);
        this.l = findRequiredView12;
        findRequiredView12.setOnClickListener(new C0974c(passengerDetailFragment));
        View findRequiredView13 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.tv_two_lower_berth, "field 'twoLowerBerth' and method 'onTwoLowerBerthClick'");
        passengerDetailFragment.twoLowerBerth = (TextView) Utils.castView(findRequiredView13, cris.org.in.prs.ima.R.id.tv_two_lower_berth, "field 'twoLowerBerth'", cls);
        this.m = findRequiredView13;
        findRequiredView13.setOnClickListener(new C0976d(passengerDetailFragment));
        passengerDetailFragment.tvnone = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.tv_none, "field 'tvnone'", cls);
        passengerDetailFragment.bookOnlyCnfLayout = (LinearLayout) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.book_on_cnf_only_layout, "field 'bookOnlyCnfLayout'", cls7);
        passengerDetailFragment.reservationChoiceLayout = (RelativeLayout) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.reservation_choice_rl, "field 'reservationChoiceLayout'", cls4);
        Class cls9 = AdManagerAdView.class;
        passengerDetailFragment.passengerCenter = (AdManagerAdView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.passenger_center, "field 'passengerCenter'", cls9);
        passengerDetailFragment.addPassengerBottom = (AdManagerAdView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.add_passenger_bottom, "field 'addPassengerBottom'", cls9);
        View findRequiredView14 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.passenger_name, "field 'passengerName' and method 'passengerNameVerify'");
        passengerDetailFragment.passengerName = (EditText) Utils.castView(findRequiredView14, cris.org.in.prs.ima.R.id.passenger_name, "field 'passengerName'", cls2);
        this.n = findRequiredView14;
        findRequiredView14.setOnFocusChangeListener(new C0978e(passengerDetailFragment));
        View findRequiredView15 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.passenger_age, "field 'passengerAge' and method 'onPassangerAgeClick'");
        passengerDetailFragment.passengerAge = (EditText) Utils.castView(findRequiredView15, cris.org.in.prs.ima.R.id.passenger_age, "field 'passengerAge'", cls2);
        this.o = findRequiredView15;
        findRequiredView15.setOnClickListener(new C0980f(passengerDetailFragment));
        passengerDetailFragment.isChildBerthReq = (CheckBox) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.is_childBerth_req, "field 'isChildBerthReq'", cls8);
        passengerDetailFragment.genderGroup = (RadioGroup) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.gender, "field 'genderGroup'", cls5);
        passengerDetailFragment.genderChildGroup = (RadioGroup) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.gender_child, "field 'genderChildGroup'", cls5);
        View findRequiredView16 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.tv_male, "field 'male' and method 'onMaleBtnClick'");
        passengerDetailFragment.male = (TextView) Utils.castView(findRequiredView16, cris.org.in.prs.ima.R.id.tv_male, "field 'male'", cls);
        this.p = findRequiredView16;
        findRequiredView16.setOnClickListener(new C0982g(passengerDetailFragment));
        View findRequiredView17 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.tv_female, "field 'feMale' and method 'onFemaleBtnClick'");
        passengerDetailFragment.feMale = (TextView) Utils.castView(findRequiredView17, cris.org.in.prs.ima.R.id.tv_female, "field 'feMale'", cls);
        this.q = findRequiredView17;
        findRequiredView17.setOnClickListener(new C0984h(passengerDetailFragment));
        View findRequiredView18 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.tv_transgender, "field 'transGender' and method 'onTransgenderBtnClick'");
        passengerDetailFragment.transGender = (TextView) Utils.castView(findRequiredView18, cris.org.in.prs.ima.R.id.tv_transgender, "field 'transGender'", cls);
        this.r = findRequiredView18;
        findRequiredView18.setOnClickListener(new C0986i(passengerDetailFragment));
        passengerDetailFragment.berthPreference = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.berth_preference, "field 'berthPreference'", cls);
        passengerDetailFragment.nationalityLayout = (LinearLayout) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.nationality_ll, "field 'nationalityLayout'", cls7);
        View findRequiredView19 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.nationality_rl, "field 'nationalityRl' and method 'onNationalityClick'");
        passengerDetailFragment.nationalityRl = (RelativeLayout) Utils.castView(findRequiredView19, cris.org.in.prs.ima.R.id.nationality_rl, "field 'nationalityRl'", cls4);
        this.s = findRequiredView19;
        findRequiredView19.setOnClickListener(new C0988j(passengerDetailFragment));
        passengerDetailFragment.nationality = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.nationality, "field 'nationality'", cls);
        passengerDetailFragment.berthPreferenceLayout = (LinearLayout) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.berth_choice_ll, "field 'berthPreferenceLayout'", cls7);
        View findRequiredView20 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.berth_preference_rl, "field 'berthPreferenceClick' and method 'onBerthPreferenceClick'");
        passengerDetailFragment.berthPreferenceClick = (RelativeLayout) Utils.castView(findRequiredView20, cris.org.in.prs.ima.R.id.berth_preference_rl, "field 'berthPreferenceClick'", cls4);
        this.t = findRequiredView20;
        findRequiredView20.setOnClickListener(new C0992l(passengerDetailFragment));
        passengerDetailFragment.foodChoice = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.food_choice, "field 'foodChoice'", cls);
        passengerDetailFragment.idCardType = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.id_card_types, "field 'idCardType'", cls);
        passengerDetailFragment.idCardNumber = (EditText) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.id_card_number, "field 'idCardNumber'", cls2);
        passengerDetailFragment.spcCardnumber = (EditText) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.spc_card_number, "field 'spcCardnumber'", cls2);
        passengerDetailFragment.splDOB = (EditText) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.tv_conc_dob, "field 'splDOB'", cls2);
        passengerDetailFragment.splCardValidity = (EditText) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.tv_conc_cardvalidity, "field 'splCardValidity'", cls2);
        passengerDetailFragment.isChildBerthll = (LinearLayout) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.is_childBerth_ll, "field 'isChildBerthll'", cls7);
        passengerDetailFragment.bedRoll = (CheckBox) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.is_bad_berth, "field 'bedRoll'", cls8);
        passengerDetailFragment.bedRollLayout = (LinearLayout) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.is_bedroll_ll, "field 'bedRollLayout'", cls7);
        passengerDetailFragment.cardIDLayout = (LinearLayout) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.ll_passport, "field 'cardIDLayout'", cls7);
        View findRequiredView21 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.id_card_types_rl, "field 'idCardLayoutClick' and method 'onIdCardClick'");
        passengerDetailFragment.idCardLayoutClick = (RelativeLayout) Utils.castView(findRequiredView21, cris.org.in.prs.ima.R.id.id_card_types_rl, "field 'idCardLayoutClick'", cls4);
        this.u = findRequiredView21;
        findRequiredView21.setOnClickListener(new C0994m(passengerDetailFragment));
        passengerDetailFragment.spConcessionLayout = (LinearLayout) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.spc_concession_layout, "field 'spConcessionLayout'", cls7);
        View findRequiredView22 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.special_concession_rl, "field 'specialConcessionRl' and method 'onSpecialConcession'");
        passengerDetailFragment.specialConcessionRl = (RelativeLayout) Utils.castView(findRequiredView22, cris.org.in.prs.ima.R.id.special_concession_rl, "field 'specialConcessionRl'", cls4);
        this.v = findRequiredView22;
        findRequiredView22.setOnClickListener(new C0996n(passengerDetailFragment));
        passengerDetailFragment.srctznConcLayout = (LinearLayout) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.ll_srctzn_concession, "field 'srctznConcLayout'", cls7);
        View findRequiredView23 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.srctzn_concession_rl, "field 'srctznConcClick' and method 'onSeniorCtznConcessionClick'");
        passengerDetailFragment.srctznConcClick = (RelativeLayout) Utils.castView(findRequiredView23, cris.org.in.prs.ima.R.id.srctzn_concession_rl, "field 'srctznConcClick'", cls4);
        this.w = findRequiredView23;
        findRequiredView23.setOnClickListener(new C0998o(passengerDetailFragment));
        passengerDetailFragment.srctznConcession = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.srctzn_concession, "field 'srctznConcession'", cls);
        passengerDetailFragment.specialConcesionType = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.special_concession_list, "field 'specialConcesionType'", cls);
        passengerDetailFragment.mealPreferenceLayout = (LinearLayout) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.ll_meal_preference, "field 'mealPreferenceLayout'", cls7);
        View findRequiredView24 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.food_choice_rl, "field 'foodChoiceclick' and method 'onFoodChoiceClick'");
        passengerDetailFragment.foodChoiceclick = (RelativeLayout) Utils.castView(findRequiredView24, cris.org.in.prs.ima.R.id.food_choice_rl, "field 'foodChoiceclick'", cls4);
        this.x = findRequiredView24;
        findRequiredView24.setOnClickListener(new C1000p(passengerDetailFragment));
        View findRequiredView25 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.add_passenger_ll, "field 'addpassenger_rl' and method 'onAddpsgndetailgone'");
        passengerDetailFragment.addpassenger_rl = (RelativeLayout) Utils.castView(findRequiredView25, cris.org.in.prs.ima.R.id.add_passenger_ll, "field 'addpassenger_rl'", cls4);
        this.y = findRequiredView25;
        findRequiredView25.setOnClickListener(new C1001q(passengerDetailFragment));
        passengerDetailFragment.ticketSentLevelView = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.ticket_sent_level, "field 'ticketSentLevelView'", cls);
        passengerDetailFragment.infantInfo = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.tv_infant_info, "field 'infantInfo'", cls);
        View findRequiredView26 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.existing_passenger_ll, "field 'existingpassenger_ll' and method 'onAddMasterPsgnGone'");
        passengerDetailFragment.existingpassenger_ll = (RelativeLayout) Utils.castView(findRequiredView26, cris.org.in.prs.ima.R.id.existing_passenger_ll, "field 'existingpassenger_ll'", cls4);
        this.z = findRequiredView26;
        findRequiredView26.setOnClickListener(new C1002r(passengerDetailFragment));
        passengerDetailFragment.passengerList = (RecyclerView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.rv_passenger_list, "field 'passengerList'", cls3);
        passengerDetailFragment.masterpassengetList = (RecyclerView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.master_passenger_list, "field 'masterpassengetList'", cls3);
        View findRequiredView27 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.add_passenger_child_ll, "field 'infantLayout' and method 'onAddPsgnInfantGone'");
        passengerDetailFragment.infantLayout = (RelativeLayout) Utils.castView(findRequiredView27, cris.org.in.prs.ima.R.id.add_passenger_child_ll, "field 'infantLayout'", cls4);
        this.A = findRequiredView27;
        findRequiredView27.setOnClickListener(new C1003s(passengerDetailFragment));
        passengerDetailFragment.childPassengerName = (EditText) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.passenger_name_child, "field 'childPassengerName'", cls2);
        View findRequiredView28 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.passenger_age_child, "field 'childAge' and method 'onChildAgeClick'");
        passengerDetailFragment.childAge = (TextView) Utils.castView(findRequiredView28, cris.org.in.prs.ima.R.id.passenger_age_child, "field 'childAge'", cls);
        this.B = findRequiredView28;
        findRequiredView28.setOnClickListener(new C1004t(passengerDetailFragment));
        View findRequiredView29 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.male_child, "field 'childMale' and method 'onChildMaleBtnClick'");
        passengerDetailFragment.childMale = (TextView) Utils.castView(findRequiredView29, cris.org.in.prs.ima.R.id.male_child, "field 'childMale'", cls);
        this.C = findRequiredView29;
        findRequiredView29.setOnClickListener(new C1005u(passengerDetailFragment));
        View findRequiredView30 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.female_child, "field 'childfeMale' and method 'onChildFemaleBtnClick'");
        passengerDetailFragment.childfeMale = (TextView) Utils.castView(findRequiredView30, cris.org.in.prs.ima.R.id.female_child, "field 'childfeMale'", cls);
        this.D = findRequiredView30;
        findRequiredView30.setOnClickListener(new C1007w(passengerDetailFragment));
        View findRequiredView31 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.transgender_child, "field 'childTrangender' and method 'onChildTransgenderBtnClick'");
        passengerDetailFragment.childTrangender = (TextView) Utils.castView(findRequiredView31, cris.org.in.prs.ima.R.id.transgender_child, "field 'childTrangender'", cls);
        this.E = findRequiredView31;
        findRequiredView31.setOnClickListener(new C1008x(passengerDetailFragment));
        View findRequiredView32 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.rl_save_child, "field 'onSave' and method 'onSaveChildClick'");
        passengerDetailFragment.onSave = (TextView) Utils.castView(findRequiredView32, cris.org.in.prs.ima.R.id.rl_save_child, "field 'onSave'", cls);
        this.F = findRequiredView32;
        findRequiredView32.setOnClickListener(new C1009y(passengerDetailFragment));
        passengerDetailFragment.infantTitle = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.tv_add_psgn_head, "field 'infantTitle'", cls);
        passengerDetailFragment.gstpassengerName = (EditText) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.gst_passenger_name, "field 'gstpassengerName'", cls2);
        View findRequiredView33 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.flat_door_block, "field 'flatDoorBlock' and method 'flaDoorBlockVerify'");
        passengerDetailFragment.flatDoorBlock = (EditText) Utils.castView(findRequiredView33, cris.org.in.prs.ima.R.id.flat_door_block, "field 'flatDoorBlock'", cls2);
        this.G = findRequiredView33;
        findRequiredView33.setOnFocusChangeListener(new C1010z(passengerDetailFragment));
        View findRequiredView34 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.street_lane, "field 'streetLane' and method 'streetLaneVerify'");
        passengerDetailFragment.streetLane = (EditText) Utils.castView(findRequiredView34, cris.org.in.prs.ima.R.id.street_lane, "field 'streetLane'", cls2);
        this.H = findRequiredView34;
        findRequiredView34.setOnFocusChangeListener(new A(passengerDetailFragment));
        View findRequiredView35 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.area_locality, "field 'areaLocality' and method 'areaLocalityVerify'");
        passengerDetailFragment.areaLocality = (EditText) Utils.castView(findRequiredView35, cris.org.in.prs.ima.R.id.area_locality, "field 'areaLocality'", cls2);
        this.I = findRequiredView35;
        findRequiredView35.setOnFocusChangeListener(new B(passengerDetailFragment));
        View findRequiredView36 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.et_pincode, "field 'pinCode', method 'pinCodeValidate', and method 'onPinCodeTextChanged'");
        passengerDetailFragment.pinCode = (EditText) Utils.castView(findRequiredView36, cris.org.in.prs.ima.R.id.et_pincode, "field 'pinCode'", cls2);
        this.J = findRequiredView36;
        findRequiredView36.setOnFocusChangeListener(new C(passengerDetailFragment));
        D d2 = new D(passengerDetailFragment);
        this.f5030a = d2;
        ((TextView) findRequiredView36).addTextChangedListener(d2);
        passengerDetailFragment.state = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.et_state_reg, "field 'state'", cls);
        View findRequiredView37 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.city_reg, "field 'city' and method 'onCityClick'");
        passengerDetailFragment.city = (TextView) Utils.castView(findRequiredView37, cris.org.in.prs.ima.R.id.city_reg, "field 'city'", cls);
        this.K = findRequiredView37;
        findRequiredView37.setOnClickListener(new E(passengerDetailFragment));
        passengerDetailFragment.titleName = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.add_psgn_heading, "field 'titleName'", cls);
        View findRequiredView38 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.gstin_number, "field 'gstinNumber', method 'gstinValidate', and method 'onGstinNumberTextChanged'");
        passengerDetailFragment.gstinNumber = (EditText) Utils.castView(findRequiredView38, cris.org.in.prs.ima.R.id.gstin_number, "field 'gstinNumber'", cls2);
        this.L = findRequiredView38;
        findRequiredView38.setOnFocusChangeListener(new F(passengerDetailFragment));
        H h2 = new H(passengerDetailFragment);
        this.f5031a = h2;
        ((TextView) findRequiredView38).addTextChangedListener(h2);
        passengerDetailFragment.gst_rl = (LinearLayout) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.gst_detail_ll, "field 'gst_rl'", cls7);
        View findRequiredView39 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.tv_masterpass_cancel, "field 'tv_masterpasscancel' and method 'onMasterPassCancelClick'");
        passengerDetailFragment.tv_masterpasscancel = (TextView) Utils.castView(findRequiredView39, cris.org.in.prs.ima.R.id.tv_masterpass_cancel, "field 'tv_masterpasscancel'", cls);
        this.M = findRequiredView39;
        findRequiredView39.setOnClickListener(new I(passengerDetailFragment));
        View findRequiredView40 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.gst_rl, "field 'gstcolumnShow' and method 'onClickgst'");
        passengerDetailFragment.gstcolumnShow = (RelativeLayout) Utils.castView(findRequiredView40, cris.org.in.prs.ima.R.id.gst_rl, "field 'gstcolumnShow'", cls4);
        this.N = findRequiredView40;
        findRequiredView40.setOnClickListener(new J(passengerDetailFragment));
        passengerDetailFragment.boarding_station_top = (AdManagerAdView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.boarding_station_top, "field 'boarding_station_top'", cls9);
        passengerDetailFragment.passenger_detail_existing = (AdManagerAdView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.passenger_detail_existing, "field 'passenger_detail_existing'", cls9);
        passengerDetailFragment.paymentoptionView = (RecyclerView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.payment_option_list, "field 'paymentoptionView'", cls3);
        passengerDetailFragment.header = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.header, "field 'header'", cls);
        passengerDetailFragment.paymentOptionll = (LinearLayout) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.payment_option_ll, "field 'paymentOptionll'", cls7);
        passengerDetailFragment.tv_available_lastupdate = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.tv_available_lastupdate, "field 'tv_available_lastupdate'", cls);
        passengerDetailFragment.traindetail_ll = (LinearLayout) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.traindetail_ll, "field 'traindetail_ll'", cls7);
        passengerDetailFragment.tv_lap1heading = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.tv_lap1heading, "field 'tv_lap1heading'", cls);
        passengerDetailFragment.lap2_heading_ll = (LinearLayout) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.lap2_heading_ll, "field 'lap2_heading_ll'", cls7);
        passengerDetailFragment.berth_choice_ll_lap2 = (LinearLayout) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.berth_choice_ll_lap2, "field 'berth_choice_ll_lap2'", cls7);
        passengerDetailFragment.lvaddmeal = (RecyclerView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.lv_addmeal, "field 'lvaddmeal'", cls3);
        View findRequiredView41 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.add_meal_rl, "field 'add_meal_rl' and method 'ongoneaddmeallay'");
        passengerDetailFragment.add_meal_rl = (RelativeLayout) Utils.castView(findRequiredView41, cris.org.in.prs.ima.R.id.add_meal_rl, "field 'add_meal_rl'", cls4);
        this.O = findRequiredView41;
        findRequiredView41.setOnClickListener(new K(passengerDetailFragment));
        View findRequiredView42 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.tv_done_meal, "field 'tv_done_meal' and method 'onDoneAddMealClick'");
        passengerDetailFragment.tv_done_meal = (TextView) Utils.castView(findRequiredView42, cris.org.in.prs.ima.R.id.tv_done_meal, "field 'tv_done_meal'", cls);
        this.P = findRequiredView42;
        findRequiredView42.setOnClickListener(new L(passengerDetailFragment));
        passengerDetailFragment.rv_addmeal_list = (RecyclerView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.rv_addmeal_list, "field 'rv_addmeal_list'", cls3);
        passengerDetailFragment.add_meal_ll = (LinearLayout) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.add_meal_ll, "field 'add_meal_ll'", cls7);
        View findRequiredView43 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.tv_add_brackfast, "field 'add_brackfast' and method 'onAddBrackfastClick'");
        passengerDetailFragment.add_brackfast = (TextView) Utils.castView(findRequiredView43, cris.org.in.prs.ima.R.id.tv_add_brackfast, "field 'add_brackfast'", cls);
        this.Q = findRequiredView43;
        findRequiredView43.setOnClickListener(new M(passengerDetailFragment));
        View findRequiredView44 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.tv_add_lunch, "field 'add_lunch' and method 'onAddLunchClick'");
        passengerDetailFragment.add_lunch = (TextView) Utils.castView(findRequiredView44, cris.org.in.prs.ima.R.id.tv_add_lunch, "field 'add_lunch'", cls);
        this.R = findRequiredView44;
        findRequiredView44.setOnClickListener(new N(passengerDetailFragment));
        View findRequiredView45 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.tv_add_snack, "field 'add_snack' and method 'onAddSnacksClick'");
        passengerDetailFragment.add_snack = (TextView) Utils.castView(findRequiredView45, cris.org.in.prs.ima.R.id.tv_add_snack, "field 'add_snack'", cls);
        this.S = findRequiredView45;
        findRequiredView45.setOnClickListener(new O(passengerDetailFragment));
        View findRequiredView46 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.tv_add_dinner, "field 'add_dinner' and method 'onAddDinnerClick'");
        passengerDetailFragment.add_dinner = (TextView) Utils.castView(findRequiredView46, cris.org.in.prs.ima.R.id.tv_add_dinner, "field 'add_dinner'", cls);
        this.T = findRequiredView46;
        findRequiredView46.setOnClickListener(new P(passengerDetailFragment));
        View findRequiredView47 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.passenger_address_heading_ll, "field 'passengerAddressHeadingLl' and method 'passengerAddressHeadingClick'");
        passengerDetailFragment.passengerAddressHeadingLl = (LinearLayout) Utils.castView(findRequiredView47, cris.org.in.prs.ima.R.id.passenger_address_heading_ll, "field 'passengerAddressHeadingLl'", cls7);
        this.U = findRequiredView47;
        findRequiredView47.setOnClickListener(new Q(passengerDetailFragment));
        passengerDetailFragment.passengerAddressInputLl = (LinearLayout) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.passenger_address_input_ll, "field 'passengerAddressInputLl'", cls7);
        View findRequiredView48 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.et_address1, "field 'et_address1' and method 'et_address'");
        passengerDetailFragment.et_address1 = (EditText) Utils.castView(findRequiredView48, cris.org.in.prs.ima.R.id.et_address1, "field 'et_address1'", cls2);
        this.V = findRequiredView48;
        findRequiredView48.setOnFocusChangeListener(new S(passengerDetailFragment));
        passengerDetailFragment.et_address2 = (EditText) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.et_address2, "field 'et_address2'", cls2);
        passengerDetailFragment.et_address3 = (EditText) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.et_address3, "field 'et_address3'", cls2);
        View findRequiredView49 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.et_city_town, "field 'et_city_town' and method 'onCittownyClick'");
        passengerDetailFragment.et_city_town = (TextView) Utils.castView(findRequiredView49, cris.org.in.prs.ima.R.id.et_city_town, "field 'et_city_town'", cls);
        this.W = findRequiredView49;
        findRequiredView49.setOnClickListener(new T(passengerDetailFragment));
        passengerDetailFragment.et_state = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.et_state, "field 'et_state'", cls);
        View findRequiredView50 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.et_psgn_pincode, "field 'et_psgn_pincode', method 'psgnPinCodeValidate', and method 'onPsgnPinCodeTextChanged'");
        passengerDetailFragment.et_psgn_pincode = (EditText) Utils.castView(findRequiredView50, cris.org.in.prs.ima.R.id.et_psgn_pincode, "field 'et_psgn_pincode'", cls2);
        this.X = findRequiredView50;
        findRequiredView50.setOnFocusChangeListener(new U(passengerDetailFragment));
        V v2 = new V(passengerDetailFragment);
        this.f5032a = v2;
        ((TextView) findRequiredView50).addTextChangedListener(v2);
        View findRequiredView51 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.et_post_office, "field 'et_post_office' and method 'onPostOfficeClick'");
        passengerDetailFragment.et_post_office = (TextView) Utils.castView(findRequiredView51, cris.org.in.prs.ima.R.id.et_post_office, "field 'et_post_office'", cls);
        this.Y = findRequiredView51;
        findRequiredView51.setOnClickListener(new W(passengerDetailFragment));
        passengerDetailFragment.psgndetail = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.psgnCount_Class_Quota, "field 'psgndetail'", cls);
        passengerDetailFragment.departureDateView = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.tv_dep_date, "field 'departureDateView'", cls);
        passengerDetailFragment.arrivalDateView = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.tv_arv_date, "field 'arrivalDateView'", cls);
        View findRequiredView52 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.addfev_journey, "field 'addfev_journey' and method 'onAddFevJourneyClocl'");
        Class cls10 = ImageView.class;
        passengerDetailFragment.addfev_journey = (ImageView) Utils.castView(findRequiredView52, cris.org.in.prs.ima.R.id.addfev_journey, "field 'addfev_journey'", cls10);
        this.Z = findRequiredView52;
        findRequiredView52.setOnClickListener(new X(passengerDetailFragment));
        passengerDetailFragment.train_type = (ImageView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.train_type, "field 'train_type'", cls10);
        passengerDetailFragment.redemption_msg_ll = (LinearLayout) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.redemption_msg_ll, "field 'redemption_msg_ll'", cls7);
        passengerDetailFragment.tv_redemption_msg = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.tv_redemption_msg, "field 'tv_redemption_msg'", cls);
        passengerDetailFragment.et_pass_upn = (EditText) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.et_pass_upn, "field 'et_pass_upn'", cls2);
        passengerDetailFragment.et_pass_booking_code = (EditText) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.et_pass_booking_code, "field 'et_pass_booking_code'", cls2);
        passengerDetailFragment.pass_booking_opt_msg = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.pass_booking_opt_msg, "field 'pass_booking_opt_msg'", cls);
        passengerDetailFragment.idadd_passenger_ll = (LinearLayout) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.idadd_passenger_ll, "field 'idadd_passenger_ll'", cls7);
        passengerDetailFragment.boadring_change_rl = (RelativeLayout) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.boadring_change_rl, "field 'boadring_change_rl'", cls4);
        passengerDetailFragment.preference_ll = (LinearLayout) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.preference_ll, "field 'preference_ll'", cls7);
        passengerDetailFragment.passportnumber_ft = (EditText) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.id_passportnumber_ft, "field 'passportnumber_ft'", cls2);
        passengerDetailFragment.tv_dob_ft = (EditText) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.tv_dob_ft, "field 'tv_dob_ft'", cls2);
        passengerDetailFragment.tv_lap = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.tv_lap, "field 'tv_lap'", cls);
        passengerDetailFragment.other_preference = (RecyclerView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.other_preference, "field 'other_preference'", cls3);
        View findRequiredView53 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.other_preference_bottom_rl, "field 'other_preference_bottom_rl' and method 'onllClick'");
        passengerDetailFragment.other_preference_bottom_rl = (RelativeLayout) Utils.castView(findRequiredView53, cris.org.in.prs.ima.R.id.other_preference_bottom_rl, "field 'other_preference_bottom_rl'", cls4);
        this.a0 = findRequiredView53;
        findRequiredView53.setOnClickListener(new Y(passengerDetailFragment));
        View findRequiredView54 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.booking_choice, "field 'booking_choice' and method 'onOtherPreferenceClick'");
        passengerDetailFragment.booking_choice = (RelativeLayout) Utils.castView(findRequiredView54, cris.org.in.prs.ima.R.id.booking_choice, "field 'booking_choice'", cls4);
        this.b0 = findRequiredView54;
        findRequiredView54.setOnClickListener(new Z(passengerDetailFragment));
        View findRequiredView55 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.none_ll, "field 'none_ll' and method 'onNonselectbookClick'");
        passengerDetailFragment.none_ll = (TextView) Utils.castView(findRequiredView55, cris.org.in.prs.ima.R.id.none_ll, "field 'none_ll'", cls);
        this.c0 = findRequiredView55;
        findRequiredView55.setOnClickListener(new C0971a0(passengerDetailFragment));
        View findRequiredView56 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.all_laps_ll, "field 'all_laps_ll' and method 'onAllLapselectbookClick'");
        passengerDetailFragment.all_laps_ll = (TextView) Utils.castView(findRequiredView56, cris.org.in.prs.ima.R.id.all_laps_ll, "field 'all_laps_ll'", cls);
        this.d0 = findRequiredView56;
        findRequiredView56.setOnClickListener(new C0973b0(passengerDetailFragment));
        View findRequiredView57 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.lap1_ll, "field 'lap1_ll' and method 'onLap1selectbookClick'");
        passengerDetailFragment.lap1_ll = (TextView) Utils.castView(findRequiredView57, cris.org.in.prs.ima.R.id.lap1_ll, "field 'lap1_ll'", cls);
        this.e0 = findRequiredView57;
        findRequiredView57.setOnClickListener(new C0977d0(passengerDetailFragment));
        View findRequiredView58 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.lap2_rb, "field 'lap2_rb' and method 'onLap2selectbookClick'");
        passengerDetailFragment.lap2_rb = (TextView) Utils.castView(findRequiredView58, cris.org.in.prs.ima.R.id.lap2_rb, "field 'lap2_rb'", cls);
        this.f0 = findRequiredView58;
        findRequiredView58.setOnClickListener(new C0979e0(passengerDetailFragment));
        View findRequiredView59 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.any_lap, "field 'any_lap' and method 'onAnyLapselectbookClick'");
        passengerDetailFragment.any_lap = (TextView) Utils.castView(findRequiredView59, cris.org.in.prs.ima.R.id.any_lap, "field 'any_lap'", cls);
        this.g0 = findRequiredView59;
        findRequiredView59.setOnClickListener(new C0981f0(passengerDetailFragment));
        View findRequiredView60 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.select_berth_choice, "field 'select_berth_choice' and method 'onselectbookGoneClick'");
        passengerDetailFragment.select_berth_choice = (RelativeLayout) Utils.castView(findRequiredView60, cris.org.in.prs.ima.R.id.select_berth_choice, "field 'select_berth_choice'", cls4);
        this.h0 = findRequiredView60;
        findRequiredView60.setOnClickListener(new C0983g0(passengerDetailFragment));
        View findRequiredView61 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.select_booking_ll, "field 'select_booking_ll' and method 'onselectbookClick'");
        passengerDetailFragment.select_booking_ll = (RelativeLayout) Utils.castView(findRequiredView61, cris.org.in.prs.ima.R.id.select_booking_ll, "field 'select_booking_ll'", cls4);
        this.i0 = findRequiredView61;
        findRequiredView61.setOnClickListener(new C0985h0(passengerDetailFragment));
        passengerDetailFragment.add_meal_ll_lap = (LinearLayout) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.add_meal_ll_lap, "field 'add_meal_ll_lap'", cls7);
        passengerDetailFragment.rv_selectmeal_lap1 = (RecyclerView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.rv_selectmeal_lap1, "field 'rv_selectmeal_lap1'", cls3);
        View findRequiredView62 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.tv_add_brackfast_lap, "field 'tv_add_brackfast_lap' and method 'onLap1AddBrackfastClick'");
        passengerDetailFragment.tv_add_brackfast_lap = (TextView) Utils.castView(findRequiredView62, cris.org.in.prs.ima.R.id.tv_add_brackfast_lap, "field 'tv_add_brackfast_lap'", cls);
        this.j0 = findRequiredView62;
        findRequiredView62.setOnClickListener(new C0987i0(passengerDetailFragment));
        passengerDetailFragment.select_meal_lap1 = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.select_meal_lap1, "field 'select_meal_lap1'", cls);
        passengerDetailFragment.select_meal_lap2 = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.select_meal_lap2, "field 'select_meal_lap2'", cls);
        View findRequiredView63 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.tv_add_lunch_lap, "field 'tv_add_lunch_lap' and method 'onLap1AddLunchClick'");
        passengerDetailFragment.tv_add_lunch_lap = (TextView) Utils.castView(findRequiredView63, cris.org.in.prs.ima.R.id.tv_add_lunch_lap, "field 'tv_add_lunch_lap'", cls);
        this.k0 = findRequiredView63;
        findRequiredView63.setOnClickListener(new C0989j0(passengerDetailFragment));
        View findRequiredView64 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.tv_add_snack_lap, "field 'tv_add_snack_lap' and method 'onLapAddSnacksClick'");
        passengerDetailFragment.tv_add_snack_lap = (TextView) Utils.castView(findRequiredView64, cris.org.in.prs.ima.R.id.tv_add_snack_lap, "field 'tv_add_snack_lap'", cls);
        this.l0 = findRequiredView64;
        findRequiredView64.setOnClickListener(new C0991k0(passengerDetailFragment));
        View findRequiredView65 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.tv_add_dinner_lap, "field 'tv_add_dinner_lap' and method 'onLapAddDinnerClick'");
        passengerDetailFragment.tv_add_dinner_lap = (TextView) Utils.castView(findRequiredView65, cris.org.in.prs.ima.R.id.tv_add_dinner_lap, "field 'tv_add_dinner_lap'", cls);
        this.m0 = findRequiredView65;
        findRequiredView65.setOnClickListener(new C0993l0(passengerDetailFragment));
        passengerDetailFragment.booking_choise_txt = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.booking_choise_txt, "field 'booking_choise_txt'", cls);
        passengerDetailFragment.add_meal_rl_lap = (RelativeLayout) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.add_meal_rl_lap, "field 'add_meal_rl_lap'", cls4);
        passengerDetailFragment.add_meal_popupll_lap = (LinearLayout) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.add_meal_popupll_lap, "field 'add_meal_popupll_lap'", cls7);
        passengerDetailFragment.lv_addmeal_lap = (RecyclerView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.lv_addmeal_lap, "field 'lv_addmeal_lap'", cls3);
        View findRequiredView66 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.tv_done_meal_lap, "field 'tv_done_meal_lap' and method 'onLapDoneAddMealClick'");
        passengerDetailFragment.tv_done_meal_lap = (TextView) Utils.castView(findRequiredView66, cris.org.in.prs.ima.R.id.tv_done_meal_lap, "field 'tv_done_meal_lap'", cls);
        this.n0 = findRequiredView66;
        findRequiredView66.setOnClickListener(new C0995m0(passengerDetailFragment));
        passengerDetailFragment.train_detail_lap2 = (LinearLayout) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.train_detail_lap2, "field 'train_detail_lap2'", cls7);
        passengerDetailFragment.train_type_lap2 = (ImageView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.train_type_lap2, "field 'train_type_lap2'", cls10);
        passengerDetailFragment.tv_lap2 = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.tv_lap2, "field 'tv_lap2'", cls);
        passengerDetailFragment.tv_train_name_lap2 = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.tv_train_name_lap2, "field 'tv_train_name_lap2'", cls);
        passengerDetailFragment.tv_train_number_lap2 = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.tv_train_number_lap2, "field 'tv_train_number_lap2'", cls);
        passengerDetailFragment.addfev_journey_lap2 = (ImageView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.addfev_journey_lap2, "field 'addfev_journey_lap2'", cls10);
        passengerDetailFragment.tv_departure_time_lap2 = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.tv_departure_time_lap2, "field 'tv_departure_time_lap2'", cls);
        passengerDetailFragment.tv_travel_time_lap2 = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.tv_travel_time_lap2, "field 'tv_travel_time_lap2'", cls);
        passengerDetailFragment.tv_arrival_time_lap2 = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.tv_arrival_time_lap2, "field 'tv_arrival_time_lap2'", cls);
        passengerDetailFragment.tv_from_stationname_lap2 = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.tv_from_stationname_lap2, "field 'tv_from_stationname_lap2'", cls);
        passengerDetailFragment.tv_from_stationcode_lap2 = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.tv_from_stationcode_lap2, "field 'tv_from_stationcode_lap2'", cls);
        passengerDetailFragment.tv_to_stationname_lap2 = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.tv_to_stationname_lap2, "field 'tv_to_stationname_lap2'", cls);
        passengerDetailFragment.tv_to_stationcode_lap2 = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.tv_to_stationcode_lap2, "field 'tv_to_stationcode_lap2'", cls);
        passengerDetailFragment.tv_dep_date_lap2 = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.tv_dep_date_lap2, "field 'tv_dep_date_lap2'", cls);
        passengerDetailFragment.tv_arv_date_lap2 = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.tv_arv_date_lap2, "field 'tv_arv_date_lap2'", cls);
        passengerDetailFragment.tv_available_lastupdate_lap2 = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.tv_available_lastupdate_lap2, "field 'tv_available_lastupdate_lap2'", cls);
        passengerDetailFragment.tv_avl_class_lap = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.tv_avl_class_lap, "field 'tv_avl_class_lap'", cls);
        passengerDetailFragment.tv_quota_lap2 = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.tv_quota_lap2, "field 'tv_quota_lap2'", cls);
        passengerDetailFragment.psgnCount_Class_Quota_lap2 = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.psgnCount_Class_Quota_lap2, "field 'psgnCount_Class_Quota_lap2'", cls);
        passengerDetailFragment.reservation_choice_rl_lap2 = (RelativeLayout) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.reservation_choice_rl_lap2, "field 'reservation_choice_rl_lap2'", cls4);
        passengerDetailFragment.reservation_txt_lap2 = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.reservation_txt_lap2, "field 'reservation_txt_lap2'", cls);
        passengerDetailFragment.reservation_view_lap2 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.reservation_view_lap2, "field 'reservation_view_lap2'");
        passengerDetailFragment.insuranceLayout_lap2 = (LinearLayout) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.insuranceLayout_lap2, "field 'insuranceLayout_lap2'", cls7);
        passengerDetailFragment.insurance_text_lap2 = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.insurance_text_lap2, "field 'insurance_text_lap2'", cls);
        View findRequiredView67 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.insurance_opt_lap2, "field 'insurance_opt_lap2' and method 'onLap2YesInsuranceClick'");
        passengerDetailFragment.insurance_opt_lap2 = (RadioButton) Utils.castView(findRequiredView67, cris.org.in.prs.ima.R.id.insurance_opt_lap2, "field 'insurance_opt_lap2'", cls6);
        this.o0 = findRequiredView67;
        findRequiredView67.setOnClickListener(new C0999o0(passengerDetailFragment));
        passengerDetailFragment.termcondition_lap2 = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.termcondition_lap2, "field 'termcondition_lap2'", cls);
        View findRequiredView68 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.no_insurance_opt_lap2, "field 'no_insurance_opt_lap2' and method 'onLap2NoInsuranceClick'");
        passengerDetailFragment.no_insurance_opt_lap2 = (RadioButton) Utils.castView(findRequiredView68, cris.org.in.prs.ima.R.id.no_insurance_opt_lap2, "field 'no_insurance_opt_lap2'", cls6);
        this.p0 = findRequiredView68;
        findRequiredView68.setOnClickListener(new p0(passengerDetailFragment));
        passengerDetailFragment.rv_selectmeal_lap2 = (RecyclerView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.rv_selectmeal_lap2, "field 'rv_selectmeal_lap2'", cls3);
        passengerDetailFragment.lv_addmeal_lap2 = (RecyclerView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.lv_addmeal_lap2, "field 'lv_addmeal_lap2'", cls3);
        passengerDetailFragment.radio_insurance_lap2 = (RadioGroup) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.radio_insurance_lap2, "field 'radio_insurance_lap2'", cls5);
        View findRequiredView69 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.berth_preference_rl_lap2, "field 'berth_preference_rl_lap2' and method 'onLap2BerthPreferenceClick'");
        passengerDetailFragment.berth_preference_rl_lap2 = (RelativeLayout) Utils.castView(findRequiredView69, cris.org.in.prs.ima.R.id.berth_preference_rl_lap2, "field 'berth_preference_rl_lap2'", cls4);
        this.q0 = findRequiredView69;
        findRequiredView69.setOnClickListener(new q0(passengerDetailFragment));
        passengerDetailFragment.berth_preference_lap2 = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.berth_preference_lap2, "field 'berth_preference_lap2'", cls);
        passengerDetailFragment.ll_meal_preference_lap2 = (LinearLayout) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.ll_meal_preference_lap2, "field 'll_meal_preference_lap2'", cls7);
        View findRequiredView70 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.food_choice_rl_lap2, "field 'food_choice_rl_lap2' and method 'onLap2FoodChoiceClick'");
        passengerDetailFragment.food_choice_rl_lap2 = (RelativeLayout) Utils.castView(findRequiredView70, cris.org.in.prs.ima.R.id.food_choice_rl_lap2, "field 'food_choice_rl_lap2'", cls4);
        this.r0 = findRequiredView70;
        findRequiredView70.setOnClickListener(new r0(passengerDetailFragment));
        passengerDetailFragment.food_choice_lap2 = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.food_choice_lap2, "field 'food_choice_lap2'", cls);
        passengerDetailFragment.et_pass_upn_lap2 = (EditText) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.et_pass_upn_lap2, "field 'et_pass_upn_lap2'", cls2);
        passengerDetailFragment.et_pass_booking_code_lap2 = (EditText) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.et_pass_booking_code_lap2, "field 'et_pass_booking_code_lap2'", cls2);
        passengerDetailFragment.spc_concession_layout_lap2 = (LinearLayout) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.spc_concession_layout_lap2, "field 'spc_concession_layout_lap2'", cls7);
        View findRequiredView71 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.special_concession_rl_lap2, "field 'special_concession_rl_lap2' and method 'onLap2SpecialConcession'");
        passengerDetailFragment.special_concession_rl_lap2 = (RelativeLayout) Utils.castView(findRequiredView71, cris.org.in.prs.ima.R.id.special_concession_rl_lap2, "field 'special_concession_rl_lap2'", cls4);
        this.s0 = findRequiredView71;
        findRequiredView71.setOnClickListener(new s0(passengerDetailFragment));
        passengerDetailFragment.special_concession_list_lap2 = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.special_concession_list_lap2, "field 'special_concession_list_lap2'", cls);
        passengerDetailFragment.spc_card_number_lap2 = (EditText) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.spc_card_number_lap2, "field 'spc_card_number_lap2'", cls2);
        passengerDetailFragment.tv_conc_dob_lap2 = (EditText) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.tv_conc_dob_lap2, "field 'tv_conc_dob_lap2'", cls2);
        passengerDetailFragment.tv_conc_cardvalidity_lap2 = (EditText) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.tv_conc_cardvalidity_lap2, "field 'tv_conc_cardvalidity_lap2'", cls2);
        passengerDetailFragment.ll_passport_lap2 = (LinearLayout) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.ll_passport_lap2, "field 'll_passport_lap2'", cls7);
        View findRequiredView72 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.id_card_types_rl_lap2, "field 'id_card_types_rl_lap2' and method 'onLap2IdCardClick'");
        passengerDetailFragment.id_card_types_rl_lap2 = (RelativeLayout) Utils.castView(findRequiredView72, cris.org.in.prs.ima.R.id.id_card_types_rl_lap2, "field 'id_card_types_rl_lap2'", cls4);
        this.t0 = findRequiredView72;
        findRequiredView72.setOnClickListener(new t0(passengerDetailFragment));
        passengerDetailFragment.id_card_types_lap2 = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.id_card_types_lap2, "field 'id_card_types_lap2'", cls);
        passengerDetailFragment.id_card_number_lap2 = (EditText) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.id_card_number_lap2, "field 'id_card_number_lap2'", cls2);
        passengerDetailFragment.select_passenger_lap2 = (LinearLayout) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.select_passenger_lap2, "field 'select_passenger_lap2'", cls7);
        passengerDetailFragment.rv_passenger_list_lap2 = (RecyclerView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.rv_passenger_list_lap2, "field 'rv_passenger_list_lap2'", cls3);
        passengerDetailFragment.is_childBerth_ll_lap2 = (LinearLayout) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.is_childBerth_ll_lap2, "field 'is_childBerth_ll_lap2'", cls7);
        passengerDetailFragment.is_childBerth_req_lap2 = (CheckBox) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.is_childBerth_req_lap2, "field 'is_childBerth_req_lap2'", cls8);
        passengerDetailFragment.is_bedroll_ll_lap2 = (LinearLayout) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.is_bedroll_ll_lap2, "field 'is_bedroll_ll_lap2'", cls7);
        passengerDetailFragment.is_bad_berth_lap2 = (CheckBox) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.is_bad_berth_lap2, "field 'is_bad_berth_lap2'", cls8);
        View findRequiredView73 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.ll_srctzn_concession_lap2, "field 'll_srctzn_concession_lap2' and method 'onLap2SeniorCtznConcessionClick'");
        passengerDetailFragment.ll_srctzn_concession_lap2 = (LinearLayout) Utils.castView(findRequiredView73, cris.org.in.prs.ima.R.id.ll_srctzn_concession_lap2, "field 'll_srctzn_concession_lap2'", cls7);
        this.u0 = findRequiredView73;
        findRequiredView73.setOnClickListener(new u0(passengerDetailFragment));
        passengerDetailFragment.srctzn_concession_rl_lap2 = (RelativeLayout) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.srctzn_concession_rl_lap2, "field 'srctzn_concession_rl_lap2'", cls4);
        passengerDetailFragment.srctzn_concession_lap2 = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.srctzn_concession_lap2, "field 'srctzn_concession_lap2'", cls);
        View findRequiredView74 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.tv_reservation_choice_lap2, "field 'tv_reservation_choice_lap2' and method 'onReservationChoiceLap2Click'");
        passengerDetailFragment.tv_reservation_choice_lap2 = (TextView) Utils.castView(findRequiredView74, cris.org.in.prs.ima.R.id.tv_reservation_choice_lap2, "field 'tv_reservation_choice_lap2'", cls);
        this.v0 = findRequiredView74;
        findRequiredView74.setOnClickListener(new v0(passengerDetailFragment));
        passengerDetailFragment.ll_wait_duration_lap1 = (LinearLayout) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.ll_wait_duration_lap1, "field 'll_wait_duration_lap1'", cls7);
        passengerDetailFragment.preferred_coach_lap2 = (EditText) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.preferred_coach_lap2, "field 'preferred_coach_lap2'", cls2);
        passengerDetailFragment.headind_travelinsurance_lap1 = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.headind_travelinsurance_lap1, "field 'headind_travelinsurance_lap1'", cls);
        passengerDetailFragment.heading_travelInsurance = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.heading_travelInsurance, "field 'heading_travelInsurance'", cls);
        passengerDetailFragment.nonText = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.non_text, "field 'nonText'", cls);
        passengerDetailFragment.travel_waitingtime = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.travel_waitingtime, "field 'travel_waitingtime'", cls);
        passengerDetailFragment.select_psgn_lap1 = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.select_psgn_lap1, "field 'select_psgn_lap1'", cls);
        passengerDetailFragment.tv_select_psgn = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.tv_select_psgn, "field 'tv_select_psgn'", cls);
        passengerDetailFragment.tv_select_booking_choise = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.tv_select_booking_choise, "field 'tv_select_booking_choise'", cls);
        View findRequiredView75 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.regervation_choice_ll_lap2, "field 'regervation_choice_ll_lap2' and method 'onReservationChoicelayoutLap2Click'");
        passengerDetailFragment.regervation_choice_ll_lap2 = (RelativeLayout) Utils.castView(findRequiredView75, cris.org.in.prs.ima.R.id.regervation_choice_ll_lap2, "field 'regervation_choice_ll_lap2'", cls4);
        this.w0 = findRequiredView75;
        findRequiredView75.setOnClickListener(new w0(passengerDetailFragment));
        passengerDetailFragment.tv_none_lap2 = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.tv_none_lap2, "field 'tv_none_lap2'", cls);
        View findRequiredView76 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.tv_none_selected_lap2, "field 'tv_none_selected_lap2' and method 'onNoneBerthLap2Click'");
        passengerDetailFragment.tv_none_selected_lap2 = (TextView) Utils.castView(findRequiredView76, cris.org.in.prs.ima.R.id.tv_none_selected_lap2, "field 'tv_none_selected_lap2'", cls);
        this.x0 = findRequiredView76;
        findRequiredView76.setOnClickListener(new x0(passengerDetailFragment));
        View findRequiredView77 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.tv_all_berth_confirm_lap2, "field 'tv_all_berth_confirm_lap2' and method 'onTAllBerthLap2Click'");
        passengerDetailFragment.tv_all_berth_confirm_lap2 = (TextView) Utils.castView(findRequiredView77, cris.org.in.prs.ima.R.id.tv_all_berth_confirm_lap2, "field 'tv_all_berth_confirm_lap2'", cls);
        this.y0 = findRequiredView77;
        findRequiredView77.setOnClickListener(new z0(passengerDetailFragment));
        View findRequiredView78 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.tv_one_lower_berth_lap2, "field 'tv_one_lower_berth_lap2' and method 'onOneLowerBerthLpap2Click'");
        passengerDetailFragment.tv_one_lower_berth_lap2 = (TextView) Utils.castView(findRequiredView78, cris.org.in.prs.ima.R.id.tv_one_lower_berth_lap2, "field 'tv_one_lower_berth_lap2'", cls);
        this.z0 = findRequiredView78;
        findRequiredView78.setOnClickListener(new A0(passengerDetailFragment));
        View findRequiredView79 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.tv_two_lower_berth_lap2, "field 'tv_two_lower_berth_lap2' and method 'onTwoLowerBerthLap2Click'");
        passengerDetailFragment.tv_two_lower_berth_lap2 = (TextView) Utils.castView(findRequiredView79, cris.org.in.prs.ima.R.id.tv_two_lower_berth_lap2, "field 'tv_two_lower_berth_lap2'", cls);
        this.A0 = findRequiredView79;
        findRequiredView79.setOnClickListener(new B0(passengerDetailFragment));
        passengerDetailFragment.view_confirm_berth_choice = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.view_confirm_berth_choice, "field 'view_confirm_berth_choice'");
        View findRequiredView80 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.confirm_berth_choice_rl, "field 'confirm_berth_choice_rl' and method 'onconfirmberthchoiceClick'");
        passengerDetailFragment.confirm_berth_choice_rl = (RelativeLayout) Utils.castView(findRequiredView80, cris.org.in.prs.ima.R.id.confirm_berth_choice_rl, "field 'confirm_berth_choice_rl'", cls4);
        this.B0 = findRequiredView80;
        findRequiredView80.setOnClickListener(new C0(passengerDetailFragment));
        passengerDetailFragment.tv_select_confirm_berth_Choice = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.tv_select_confirm_berth_Choice, "field 'tv_select_confirm_berth_Choice'", cls);
        passengerDetailFragment.select_psgn_lap2 = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.select_psgn_lap2, "field 'select_psgn_lap2'", cls);
        View findRequiredView81 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.travel_insurance_yes_ll, "field 'travel_insurance_yes_ll' and method 'onYesInsurancelayoutClick'");
        passengerDetailFragment.travel_insurance_yes_ll = (LinearLayout) Utils.castView(findRequiredView81, cris.org.in.prs.ima.R.id.travel_insurance_yes_ll, "field 'travel_insurance_yes_ll'", cls7);
        this.C0 = findRequiredView81;
        findRequiredView81.setOnClickListener(new D0(passengerDetailFragment));
        View findRequiredView82 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.travel_insurance_no_ll, "field 'travel_insurance_no_ll' and method 'onNoInsurancelayoutClick'");
        passengerDetailFragment.travel_insurance_no_ll = (LinearLayout) Utils.castView(findRequiredView82, cris.org.in.prs.ima.R.id.travel_insurance_no_ll, "field 'travel_insurance_no_ll'", cls7);
        this.D0 = findRequiredView82;
        findRequiredView82.setOnClickListener(new E0(passengerDetailFragment));
        View findRequiredView83 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.travel_insurance_yes_ll_lap2, "field 'travel_insurance_yes_ll_lap2' and method 'onLap2YesInsurancelayoutClick'");
        passengerDetailFragment.travel_insurance_yes_ll_lap2 = (LinearLayout) Utils.castView(findRequiredView83, cris.org.in.prs.ima.R.id.travel_insurance_yes_ll_lap2, "field 'travel_insurance_yes_ll_lap2'", cls7);
        this.E0 = findRequiredView83;
        findRequiredView83.setOnClickListener(new F0(passengerDetailFragment));
        View findRequiredView84 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.travel_insurance_no_ll_lap2, "field 'travel_insurance_no_ll_lap2' and method 'onLap2NoInsurancelayoutClick'");
        passengerDetailFragment.travel_insurance_no_ll_lap2 = (LinearLayout) Utils.castView(findRequiredView84, cris.org.in.prs.ima.R.id.travel_insurance_no_ll_lap2, "field 'travel_insurance_no_ll_lap2'", cls7);
        this.F0 = findRequiredView84;
        findRequiredView84.setOnClickListener(new G0(passengerDetailFragment));
        passengerDetailFragment.passbooking_concession_ll = (LinearLayout) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.passbooking_concession_ll, "field 'passbooking_concession_ll'", cls7);
        View findRequiredView85 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.passbooking_concession_rl, "field 'passbooking_concession_rl' and method 'onPassbookingconcessionClick'");
        passengerDetailFragment.passbooking_concession_rl = (RelativeLayout) Utils.castView(findRequiredView85, cris.org.in.prs.ima.R.id.passbooking_concession_rl, "field 'passbooking_concession_rl'", cls4);
        this.G0 = findRequiredView85;
        findRequiredView85.setOnClickListener(new H0(passengerDetailFragment));
        passengerDetailFragment.passbooking_concession_list = (TextView) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.passbooking_concession_list, "field 'passbooking_concession_list'", cls);
        passengerDetailFragment.journey_detail_ll = (LinearLayout) Utils.findRequiredViewAsType(view, cris.org.in.prs.ima.R.id.journey_detail_ll, "field 'journey_detail_ll'", cls7);
        View findRequiredView86 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.journey_detail, "field 'journey_detail' and method 'onBookNowClick'");
        passengerDetailFragment.journey_detail = (TextView) Utils.castView(findRequiredView86, cris.org.in.prs.ima.R.id.journey_detail, "field 'journey_detail'", cls);
        this.H0 = findRequiredView86;
        findRequiredView86.setOnClickListener(new I0(passengerDetailFragment));
        View findRequiredView87 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.tv_add_infant_with_berth, "field 'add_infant_with_berth' and method 'onAddInfantWithBerthDetailClick'");
        passengerDetailFragment.add_infant_with_berth = (TextView) Utils.castView(findRequiredView87, cris.org.in.prs.ima.R.id.tv_add_infant_with_berth, "field 'add_infant_with_berth'", cls);
        this.I0 = findRequiredView87;
        findRequiredView87.setOnClickListener(new K0(passengerDetailFragment));
        View findRequiredView88 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.tv_masterpass_addnew, "method 'onMasterPassAddNewClick'");
        this.J0 = findRequiredView88;
        findRequiredView88.setOnClickListener(new L0(passengerDetailFragment));
        View findRequiredView89 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.tv_none_selected, "method 'onNoneBerthClick'");
        this.K0 = findRequiredView89;
        findRequiredView89.setOnClickListener(new M0(passengerDetailFragment));
        View findRequiredView90 = Utils.findRequiredView(view, cris.org.in.prs.ima.R.id.tv_done_master_psgn_detail, "method 'onClickMasterpsgnList'");
        this.L0 = findRequiredView90;
        findRequiredView90.setOnClickListener(new N0(passengerDetailFragment));
    }

    public final void unbind() {
        PassengerDetailFragment passengerDetailFragment = this.f5029a;
        if (passengerDetailFragment != null) {
            this.f5029a = null;
            passengerDetailFragment.trainName = null;
            passengerDetailFragment.quota = null;
            passengerDetailFragment.trainNumber = null;
            passengerDetailFragment.avlClass = null;
            passengerDetailFragment.depTime = null;
            passengerDetailFragment.travelTime = null;
            passengerDetailFragment.arrTime = null;
            passengerDetailFragment.fromStation = null;
            passengerDetailFragment.fromStationCode = null;
            passengerDetailFragment.toStation = null;
            passengerDetailFragment.toStatinCode = null;
            passengerDetailFragment.tvBoardingStation = null;
            passengerDetailFragment.addPsgnDetails = null;
            passengerDetailFragment.addMasterPsgnList = null;
            passengerDetailFragment.addInfantPsgnList = null;
            passengerDetailFragment.mobileNumber = null;
            passengerDetailFragment.isdCode = null;
            passengerDetailFragment.boardingStnView = null;
            passengerDetailFragment.boardingStnName = null;
            passengerDetailFragment.selectstation_ll = null;
            passengerDetailFragment.radioInsurance = null;
            passengerDetailFragment.insuranceOpt = null;
            passengerDetailFragment.noInsuranceOpt = null;
            passengerDetailFragment.addPsgnLayout = null;
            passengerDetailFragment.insuranceLayout = null;
            passengerDetailFragment.insuranceTexts = null;
            passengerDetailFragment.farePerPerson = null;
            passengerDetailFragment.ll_fare_per_person = null;
            passengerDetailFragment.donePsgnDetail = null;
            passengerDetailFragment.termcondition = null;
            passengerDetailFragment.termcondition_ll = null;
            passengerDetailFragment.errorMessage = null;
            passengerDetailFragment.isAutoUpgradation = null;
            passengerDetailFragment.auto_upgra_layout = null;
            passengerDetailFragment.isIgnoreChoiceIfWl = null;
            passengerDetailFragment.preferredCoach = null;
            passengerDetailFragment.reservationChoiceClick = null;
            passengerDetailFragment.regervationchoice_ll = null;
            passengerDetailFragment.allBerthConfirm = null;
            passengerDetailFragment.oneLowerBerth = null;
            passengerDetailFragment.twoLowerBerth = null;
            passengerDetailFragment.tvnone = null;
            passengerDetailFragment.bookOnlyCnfLayout = null;
            passengerDetailFragment.reservationChoiceLayout = null;
            passengerDetailFragment.passengerCenter = null;
            passengerDetailFragment.addPassengerBottom = null;
            passengerDetailFragment.passengerName = null;
            passengerDetailFragment.passengerAge = null;
            passengerDetailFragment.isChildBerthReq = null;
            passengerDetailFragment.genderGroup = null;
            passengerDetailFragment.genderChildGroup = null;
            passengerDetailFragment.male = null;
            passengerDetailFragment.feMale = null;
            passengerDetailFragment.transGender = null;
            passengerDetailFragment.berthPreference = null;
            passengerDetailFragment.nationalityLayout = null;
            passengerDetailFragment.nationalityRl = null;
            passengerDetailFragment.nationality = null;
            passengerDetailFragment.berthPreferenceLayout = null;
            passengerDetailFragment.berthPreferenceClick = null;
            passengerDetailFragment.foodChoice = null;
            passengerDetailFragment.idCardType = null;
            passengerDetailFragment.idCardNumber = null;
            passengerDetailFragment.spcCardnumber = null;
            passengerDetailFragment.splDOB = null;
            passengerDetailFragment.splCardValidity = null;
            passengerDetailFragment.isChildBerthll = null;
            passengerDetailFragment.bedRoll = null;
            passengerDetailFragment.bedRollLayout = null;
            passengerDetailFragment.cardIDLayout = null;
            passengerDetailFragment.idCardLayoutClick = null;
            passengerDetailFragment.spConcessionLayout = null;
            passengerDetailFragment.specialConcessionRl = null;
            passengerDetailFragment.srctznConcLayout = null;
            passengerDetailFragment.srctznConcClick = null;
            passengerDetailFragment.srctznConcession = null;
            passengerDetailFragment.specialConcesionType = null;
            passengerDetailFragment.mealPreferenceLayout = null;
            passengerDetailFragment.foodChoiceclick = null;
            passengerDetailFragment.addpassenger_rl = null;
            passengerDetailFragment.ticketSentLevelView = null;
            passengerDetailFragment.infantInfo = null;
            passengerDetailFragment.existingpassenger_ll = null;
            passengerDetailFragment.passengerList = null;
            passengerDetailFragment.masterpassengetList = null;
            passengerDetailFragment.infantLayout = null;
            passengerDetailFragment.childPassengerName = null;
            passengerDetailFragment.childAge = null;
            passengerDetailFragment.childMale = null;
            passengerDetailFragment.childfeMale = null;
            passengerDetailFragment.childTrangender = null;
            passengerDetailFragment.onSave = null;
            passengerDetailFragment.infantTitle = null;
            passengerDetailFragment.gstpassengerName = null;
            passengerDetailFragment.flatDoorBlock = null;
            passengerDetailFragment.streetLane = null;
            passengerDetailFragment.areaLocality = null;
            passengerDetailFragment.pinCode = null;
            passengerDetailFragment.state = null;
            passengerDetailFragment.city = null;
            passengerDetailFragment.titleName = null;
            passengerDetailFragment.gstinNumber = null;
            passengerDetailFragment.gst_rl = null;
            passengerDetailFragment.tv_masterpasscancel = null;
            passengerDetailFragment.gstcolumnShow = null;
            passengerDetailFragment.boarding_station_top = null;
            passengerDetailFragment.passenger_detail_existing = null;
            passengerDetailFragment.paymentoptionView = null;
            passengerDetailFragment.header = null;
            passengerDetailFragment.paymentOptionll = null;
            passengerDetailFragment.tv_available_lastupdate = null;
            passengerDetailFragment.traindetail_ll = null;
            passengerDetailFragment.tv_lap1heading = null;
            passengerDetailFragment.lap2_heading_ll = null;
            passengerDetailFragment.berth_choice_ll_lap2 = null;
            passengerDetailFragment.lvaddmeal = null;
            passengerDetailFragment.add_meal_rl = null;
            passengerDetailFragment.tv_done_meal = null;
            passengerDetailFragment.rv_addmeal_list = null;
            passengerDetailFragment.add_meal_ll = null;
            passengerDetailFragment.add_brackfast = null;
            passengerDetailFragment.add_lunch = null;
            passengerDetailFragment.add_snack = null;
            passengerDetailFragment.add_dinner = null;
            passengerDetailFragment.passengerAddressHeadingLl = null;
            passengerDetailFragment.passengerAddressInputLl = null;
            passengerDetailFragment.et_address1 = null;
            passengerDetailFragment.et_address2 = null;
            passengerDetailFragment.et_address3 = null;
            passengerDetailFragment.et_city_town = null;
            passengerDetailFragment.et_state = null;
            passengerDetailFragment.et_psgn_pincode = null;
            passengerDetailFragment.et_post_office = null;
            passengerDetailFragment.psgndetail = null;
            passengerDetailFragment.departureDateView = null;
            passengerDetailFragment.arrivalDateView = null;
            passengerDetailFragment.addfev_journey = null;
            passengerDetailFragment.train_type = null;
            passengerDetailFragment.redemption_msg_ll = null;
            passengerDetailFragment.tv_redemption_msg = null;
            passengerDetailFragment.et_pass_upn = null;
            passengerDetailFragment.et_pass_booking_code = null;
            passengerDetailFragment.pass_booking_opt_msg = null;
            passengerDetailFragment.idadd_passenger_ll = null;
            passengerDetailFragment.boadring_change_rl = null;
            passengerDetailFragment.preference_ll = null;
            passengerDetailFragment.passportnumber_ft = null;
            passengerDetailFragment.tv_dob_ft = null;
            passengerDetailFragment.tv_lap = null;
            passengerDetailFragment.other_preference = null;
            passengerDetailFragment.other_preference_bottom_rl = null;
            passengerDetailFragment.booking_choice = null;
            passengerDetailFragment.none_ll = null;
            passengerDetailFragment.all_laps_ll = null;
            passengerDetailFragment.lap1_ll = null;
            passengerDetailFragment.lap2_rb = null;
            passengerDetailFragment.any_lap = null;
            passengerDetailFragment.select_berth_choice = null;
            passengerDetailFragment.select_booking_ll = null;
            passengerDetailFragment.add_meal_ll_lap = null;
            passengerDetailFragment.rv_selectmeal_lap1 = null;
            passengerDetailFragment.tv_add_brackfast_lap = null;
            passengerDetailFragment.select_meal_lap1 = null;
            passengerDetailFragment.select_meal_lap2 = null;
            passengerDetailFragment.tv_add_lunch_lap = null;
            passengerDetailFragment.tv_add_snack_lap = null;
            passengerDetailFragment.tv_add_dinner_lap = null;
            passengerDetailFragment.booking_choise_txt = null;
            passengerDetailFragment.add_meal_rl_lap = null;
            passengerDetailFragment.add_meal_popupll_lap = null;
            passengerDetailFragment.lv_addmeal_lap = null;
            passengerDetailFragment.tv_done_meal_lap = null;
            passengerDetailFragment.train_detail_lap2 = null;
            passengerDetailFragment.train_type_lap2 = null;
            passengerDetailFragment.tv_lap2 = null;
            passengerDetailFragment.tv_train_name_lap2 = null;
            passengerDetailFragment.tv_train_number_lap2 = null;
            passengerDetailFragment.addfev_journey_lap2 = null;
            passengerDetailFragment.tv_departure_time_lap2 = null;
            passengerDetailFragment.tv_travel_time_lap2 = null;
            passengerDetailFragment.tv_arrival_time_lap2 = null;
            passengerDetailFragment.tv_from_stationname_lap2 = null;
            passengerDetailFragment.tv_from_stationcode_lap2 = null;
            passengerDetailFragment.tv_to_stationname_lap2 = null;
            passengerDetailFragment.tv_to_stationcode_lap2 = null;
            passengerDetailFragment.tv_dep_date_lap2 = null;
            passengerDetailFragment.tv_arv_date_lap2 = null;
            passengerDetailFragment.tv_available_lastupdate_lap2 = null;
            passengerDetailFragment.tv_avl_class_lap = null;
            passengerDetailFragment.tv_quota_lap2 = null;
            passengerDetailFragment.psgnCount_Class_Quota_lap2 = null;
            passengerDetailFragment.reservation_choice_rl_lap2 = null;
            passengerDetailFragment.reservation_txt_lap2 = null;
            passengerDetailFragment.reservation_view_lap2 = null;
            passengerDetailFragment.insuranceLayout_lap2 = null;
            passengerDetailFragment.insurance_text_lap2 = null;
            passengerDetailFragment.insurance_opt_lap2 = null;
            passengerDetailFragment.termcondition_lap2 = null;
            passengerDetailFragment.no_insurance_opt_lap2 = null;
            passengerDetailFragment.rv_selectmeal_lap2 = null;
            passengerDetailFragment.lv_addmeal_lap2 = null;
            passengerDetailFragment.radio_insurance_lap2 = null;
            passengerDetailFragment.berth_preference_rl_lap2 = null;
            passengerDetailFragment.berth_preference_lap2 = null;
            passengerDetailFragment.ll_meal_preference_lap2 = null;
            passengerDetailFragment.food_choice_rl_lap2 = null;
            passengerDetailFragment.food_choice_lap2 = null;
            passengerDetailFragment.et_pass_upn_lap2 = null;
            passengerDetailFragment.et_pass_booking_code_lap2 = null;
            passengerDetailFragment.spc_concession_layout_lap2 = null;
            passengerDetailFragment.special_concession_rl_lap2 = null;
            passengerDetailFragment.special_concession_list_lap2 = null;
            passengerDetailFragment.spc_card_number_lap2 = null;
            passengerDetailFragment.tv_conc_dob_lap2 = null;
            passengerDetailFragment.tv_conc_cardvalidity_lap2 = null;
            passengerDetailFragment.ll_passport_lap2 = null;
            passengerDetailFragment.id_card_types_rl_lap2 = null;
            passengerDetailFragment.id_card_types_lap2 = null;
            passengerDetailFragment.id_card_number_lap2 = null;
            passengerDetailFragment.select_passenger_lap2 = null;
            passengerDetailFragment.rv_passenger_list_lap2 = null;
            passengerDetailFragment.is_childBerth_ll_lap2 = null;
            passengerDetailFragment.is_childBerth_req_lap2 = null;
            passengerDetailFragment.is_bedroll_ll_lap2 = null;
            passengerDetailFragment.is_bad_berth_lap2 = null;
            passengerDetailFragment.ll_srctzn_concession_lap2 = null;
            passengerDetailFragment.srctzn_concession_rl_lap2 = null;
            passengerDetailFragment.srctzn_concession_lap2 = null;
            passengerDetailFragment.tv_reservation_choice_lap2 = null;
            passengerDetailFragment.ll_wait_duration_lap1 = null;
            passengerDetailFragment.preferred_coach_lap2 = null;
            passengerDetailFragment.headind_travelinsurance_lap1 = null;
            passengerDetailFragment.heading_travelInsurance = null;
            passengerDetailFragment.nonText = null;
            passengerDetailFragment.travel_waitingtime = null;
            passengerDetailFragment.select_psgn_lap1 = null;
            passengerDetailFragment.tv_select_psgn = null;
            passengerDetailFragment.tv_select_booking_choise = null;
            passengerDetailFragment.regervation_choice_ll_lap2 = null;
            passengerDetailFragment.tv_none_lap2 = null;
            passengerDetailFragment.tv_none_selected_lap2 = null;
            passengerDetailFragment.tv_all_berth_confirm_lap2 = null;
            passengerDetailFragment.tv_one_lower_berth_lap2 = null;
            passengerDetailFragment.tv_two_lower_berth_lap2 = null;
            passengerDetailFragment.view_confirm_berth_choice = null;
            passengerDetailFragment.confirm_berth_choice_rl = null;
            passengerDetailFragment.tv_select_confirm_berth_Choice = null;
            passengerDetailFragment.select_psgn_lap2 = null;
            passengerDetailFragment.travel_insurance_yes_ll = null;
            passengerDetailFragment.travel_insurance_no_ll = null;
            passengerDetailFragment.travel_insurance_yes_ll_lap2 = null;
            passengerDetailFragment.travel_insurance_no_ll_lap2 = null;
            passengerDetailFragment.passbooking_concession_ll = null;
            passengerDetailFragment.passbooking_concession_rl = null;
            passengerDetailFragment.passbooking_concession_list = null;
            passengerDetailFragment.journey_detail_ll = null;
            passengerDetailFragment.journey_detail = null;
            passengerDetailFragment.add_infant_with_berth = null;
            this.a.setOnClickListener((View.OnClickListener) null);
            this.a = null;
            this.b.setOnClickListener((View.OnClickListener) null);
            this.b = null;
            this.c.setOnClickListener((View.OnClickListener) null);
            this.c = null;
            this.d.setOnClickListener((View.OnClickListener) null);
            this.d = null;
            this.e.setOnClickListener((View.OnClickListener) null);
            this.e = null;
            this.f.setOnClickListener((View.OnClickListener) null);
            this.f = null;
            this.g.setOnClickListener((View.OnClickListener) null);
            this.g = null;
            this.h.setOnClickListener((View.OnClickListener) null);
            this.h = null;
            this.i.setOnClickListener((View.OnClickListener) null);
            this.i = null;
            this.j.setOnClickListener((View.OnClickListener) null);
            this.j = null;
            this.k.setOnClickListener((View.OnClickListener) null);
            this.k = null;
            this.l.setOnClickListener((View.OnClickListener) null);
            this.l = null;
            this.m.setOnClickListener((View.OnClickListener) null);
            this.m = null;
            this.n.setOnFocusChangeListener((View.OnFocusChangeListener) null);
            this.n = null;
            this.o.setOnClickListener((View.OnClickListener) null);
            this.o = null;
            this.p.setOnClickListener((View.OnClickListener) null);
            this.p = null;
            this.q.setOnClickListener((View.OnClickListener) null);
            this.q = null;
            this.r.setOnClickListener((View.OnClickListener) null);
            this.r = null;
            this.s.setOnClickListener((View.OnClickListener) null);
            this.s = null;
            this.t.setOnClickListener((View.OnClickListener) null);
            this.t = null;
            this.u.setOnClickListener((View.OnClickListener) null);
            this.u = null;
            this.v.setOnClickListener((View.OnClickListener) null);
            this.v = null;
            this.w.setOnClickListener((View.OnClickListener) null);
            this.w = null;
            this.x.setOnClickListener((View.OnClickListener) null);
            this.x = null;
            this.y.setOnClickListener((View.OnClickListener) null);
            this.y = null;
            this.z.setOnClickListener((View.OnClickListener) null);
            this.z = null;
            this.A.setOnClickListener((View.OnClickListener) null);
            this.A = null;
            this.B.setOnClickListener((View.OnClickListener) null);
            this.B = null;
            this.C.setOnClickListener((View.OnClickListener) null);
            this.C = null;
            this.D.setOnClickListener((View.OnClickListener) null);
            this.D = null;
            this.E.setOnClickListener((View.OnClickListener) null);
            this.E = null;
            this.F.setOnClickListener((View.OnClickListener) null);
            this.F = null;
            this.G.setOnFocusChangeListener((View.OnFocusChangeListener) null);
            this.G = null;
            this.H.setOnFocusChangeListener((View.OnFocusChangeListener) null);
            this.H = null;
            this.I.setOnFocusChangeListener((View.OnFocusChangeListener) null);
            this.I = null;
            this.J.setOnFocusChangeListener((View.OnFocusChangeListener) null);
            ((TextView) this.J).removeTextChangedListener(this.f5030a);
            this.f5030a = null;
            this.J = null;
            this.K.setOnClickListener((View.OnClickListener) null);
            this.K = null;
            this.L.setOnFocusChangeListener((View.OnFocusChangeListener) null);
            ((TextView) this.L).removeTextChangedListener(this.f5031a);
            this.f5031a = null;
            this.L = null;
            this.M.setOnClickListener((View.OnClickListener) null);
            this.M = null;
            this.N.setOnClickListener((View.OnClickListener) null);
            this.N = null;
            this.O.setOnClickListener((View.OnClickListener) null);
            this.O = null;
            this.P.setOnClickListener((View.OnClickListener) null);
            this.P = null;
            this.Q.setOnClickListener((View.OnClickListener) null);
            this.Q = null;
            this.R.setOnClickListener((View.OnClickListener) null);
            this.R = null;
            this.S.setOnClickListener((View.OnClickListener) null);
            this.S = null;
            this.T.setOnClickListener((View.OnClickListener) null);
            this.T = null;
            this.U.setOnClickListener((View.OnClickListener) null);
            this.U = null;
            this.V.setOnFocusChangeListener((View.OnFocusChangeListener) null);
            this.V = null;
            this.W.setOnClickListener((View.OnClickListener) null);
            this.W = null;
            this.X.setOnFocusChangeListener((View.OnFocusChangeListener) null);
            ((TextView) this.X).removeTextChangedListener(this.f5032a);
            this.f5032a = null;
            this.X = null;
            this.Y.setOnClickListener((View.OnClickListener) null);
            this.Y = null;
            this.Z.setOnClickListener((View.OnClickListener) null);
            this.Z = null;
            this.a0.setOnClickListener((View.OnClickListener) null);
            this.a0 = null;
            this.b0.setOnClickListener((View.OnClickListener) null);
            this.b0 = null;
            this.c0.setOnClickListener((View.OnClickListener) null);
            this.c0 = null;
            this.d0.setOnClickListener((View.OnClickListener) null);
            this.d0 = null;
            this.e0.setOnClickListener((View.OnClickListener) null);
            this.e0 = null;
            this.f0.setOnClickListener((View.OnClickListener) null);
            this.f0 = null;
            this.g0.setOnClickListener((View.OnClickListener) null);
            this.g0 = null;
            this.h0.setOnClickListener((View.OnClickListener) null);
            this.h0 = null;
            this.i0.setOnClickListener((View.OnClickListener) null);
            this.i0 = null;
            this.j0.setOnClickListener((View.OnClickListener) null);
            this.j0 = null;
            this.k0.setOnClickListener((View.OnClickListener) null);
            this.k0 = null;
            this.l0.setOnClickListener((View.OnClickListener) null);
            this.l0 = null;
            this.m0.setOnClickListener((View.OnClickListener) null);
            this.m0 = null;
            this.n0.setOnClickListener((View.OnClickListener) null);
            this.n0 = null;
            this.o0.setOnClickListener((View.OnClickListener) null);
            this.o0 = null;
            this.p0.setOnClickListener((View.OnClickListener) null);
            this.p0 = null;
            this.q0.setOnClickListener((View.OnClickListener) null);
            this.q0 = null;
            this.r0.setOnClickListener((View.OnClickListener) null);
            this.r0 = null;
            this.s0.setOnClickListener((View.OnClickListener) null);
            this.s0 = null;
            this.t0.setOnClickListener((View.OnClickListener) null);
            this.t0 = null;
            this.u0.setOnClickListener((View.OnClickListener) null);
            this.u0 = null;
            this.v0.setOnClickListener((View.OnClickListener) null);
            this.v0 = null;
            this.w0.setOnClickListener((View.OnClickListener) null);
            this.w0 = null;
            this.x0.setOnClickListener((View.OnClickListener) null);
            this.x0 = null;
            this.y0.setOnClickListener((View.OnClickListener) null);
            this.y0 = null;
            this.z0.setOnClickListener((View.OnClickListener) null);
            this.z0 = null;
            this.A0.setOnClickListener((View.OnClickListener) null);
            this.A0 = null;
            this.B0.setOnClickListener((View.OnClickListener) null);
            this.B0 = null;
            this.C0.setOnClickListener((View.OnClickListener) null);
            this.C0 = null;
            this.D0.setOnClickListener((View.OnClickListener) null);
            this.D0 = null;
            this.E0.setOnClickListener((View.OnClickListener) null);
            this.E0 = null;
            this.F0.setOnClickListener((View.OnClickListener) null);
            this.F0 = null;
            this.G0.setOnClickListener((View.OnClickListener) null);
            this.G0 = null;
            this.H0.setOnClickListener((View.OnClickListener) null);
            this.H0 = null;
            this.I0.setOnClickListener((View.OnClickListener) null);
            this.I0 = null;
            this.J0.setOnClickListener((View.OnClickListener) null);
            this.J0 = null;
            this.K0.setOnClickListener((View.OnClickListener) null);
            this.K0 = null;
            this.L0.setOnClickListener((View.OnClickListener) null);
            this.L0 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }

    public class D implements TextWatcher {
        public final /* synthetic */ PassengerDetailFragment a;

        public D(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.a.onPinCodeTextChanged(charSequence, i, i2, i3);
        }

        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public class H implements TextWatcher {
        public final /* synthetic */ PassengerDetailFragment a;

        public H(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.a.onGstinNumberTextChanged(charSequence, i, i2, i3);
        }

        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public class V implements TextWatcher {
        public final /* synthetic */ PassengerDetailFragment a;

        public V(PassengerDetailFragment passengerDetailFragment) {
            this.a = passengerDetailFragment;
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.a.onPsgnPinCodeTextChanged(charSequence, i, i2, i3);
        }

        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}
