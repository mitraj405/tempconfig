package cris.org.in.ima.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.adaptors.CustomAdapter;
import cris.org.in.ima.adaptors.VikalpTrainListAdapter;
import cris.org.in.ima.db.StationDb;
import cris.org.in.ima.dto.oauth2.GoogleAdParamDTO;
import cris.org.in.ima.listener.OnSelectionListener;
import cris.org.in.ima.model.VikalpTrainListModel;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.BookingResponseDTO;
import cris.prs.webservices.dto.StatusDTO;
import cris.prs.webservices.dto.TrainBtwnStnsDTO;
import cris.prs.webservices.dto.TrainBtwnStnsRespDto;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeMap;
import rx.Subscriber;

public class VikalpTrainListFragment extends Fragment {
    public static final SimpleDateFormat a = new SimpleDateFormat("HH:mm");
    public static String d;

    /* renamed from: a  reason: collision with other field name */
    public Context f5206a;

    /* renamed from: a  reason: collision with other field name */
    public CustomDialogFragment f5207a;

    /* renamed from: a  reason: collision with other field name */
    public final c f5208a = new c();

    /* renamed from: a  reason: collision with other field name */
    public VikalpTrainListModel f5209a;

    /* renamed from: a  reason: collision with other field name */
    public BookingResponseDTO f5210a;

    /* renamed from: a  reason: collision with other field name */
    public TrainBtwnStnsRespDto f5211a;

    /* renamed from: a  reason: collision with other field name */
    public ArrayList<VikalpTrainListModel> f5212a;

    /* renamed from: a  reason: collision with other field name */
    public TreeMap<String, ArrayList<TrainBtwnStnsDTO>> f5213a;

    /* renamed from: a  reason: collision with other field name */
    public String[] f5214a;

    /* renamed from: a  reason: collision with other field name */
    public boolean[] f5215a;
    @BindView(2131364293)
    TextView arrDeptTime;
    public boolean[] b;
    @BindView(2131363009)
    LinearLayout btn;
    public String c = null;

    /* renamed from: c  reason: collision with other field name */
    public boolean[] f5216c;
    @BindView(2131362715)
    TextView fromStation;
    @BindView(2131362920)
    TextView jrnyDate;
    @BindView(2131363092)
    LinearLayout ll_train_list;
    @BindView(2131363506)
    TextView pnrNumber;
    @BindView(2131364595)
    TextView selectTrnTxt;
    @BindView(2131363063)
    LinearLayout select_vikalp_trn;
    @BindView(2131363931)
    AdManagerAdView selectvikalptrain_bottom;
    @BindView(2131363926)
    CheckBox splTrain;
    @BindView(2131363062)
    LinearLayout splTrainLayout;
    @BindView(2131364623)
    TextView submitBtn;
    @BindView(2131364169)
    TextView toStation;
    @BindView(2131363841)
    RecyclerView trainList;
    @BindView(2131364202)
    TextView trainNumber;
    @BindView(2131364844)
    TextView vikalpTrainDate;

    public class a implements Comparator<String> {
        public final SimpleDateFormat a = new SimpleDateFormat("dd-MMM-yyyy");

        public final int compare(Object obj, Object obj2) {
            String str = (String) obj;
            String str2 = (String) obj2;
            SimpleDateFormat simpleDateFormat = this.a;
            try {
                return simpleDateFormat.parse(str).compareTo(simpleDateFormat.parse(str2));
            } catch (ParseException e) {
                throw new IllegalArgumentException(e);
            }
        }
    }

    public class b implements OnSelectionListener {
        public b() {
        }

        public final void onClick(String str) {
            VikalpTrainListFragment vikalpTrainListFragment = VikalpTrainListFragment.this;
            vikalpTrainListFragment.vikalpTrainDate.setText(str);
            VikalpTrainListFragment.d = str;
            vikalpTrainListFragment.f5207a.dismiss();
            int indexOf = Arrays.asList(vikalpTrainListFragment.f5214a).indexOf(VikalpTrainListFragment.d);
            boolean[] zArr = vikalpTrainListFragment.b;
            if (!zArr[indexOf]) {
                zArr[indexOf] = true;
                vikalpTrainListFragment.g();
                return;
            }
            vikalpTrainListFragment.f5212a = new ArrayList<>();
            for (int i = 0; i < vikalpTrainListFragment.f5213a.get(VikalpTrainListFragment.d).size(); i++) {
                VikalpTrainListModel vikalpTrainListModel = new VikalpTrainListModel();
                vikalpTrainListFragment.f5209a = vikalpTrainListModel;
                vikalpTrainListModel.a = (TrainBtwnStnsDTO) vikalpTrainListFragment.f5213a.get(VikalpTrainListFragment.d).get(i);
                if (vikalpTrainListFragment.f5215a[vikalpTrainListFragment.f5209a.a.getsNo().intValue()]) {
                    vikalpTrainListFragment.f5209a.f5350a = true;
                }
                vikalpTrainListFragment.f5212a.add(i, vikalpTrainListFragment.f5209a);
            }
            vikalpTrainListFragment.trainList.setAdapter(new U9(vikalpTrainListFragment.getContext(), vikalpTrainListFragment.f5212a, vikalpTrainListFragment.f5208a));
            vikalpTrainListFragment.trainList.setLayoutManager(new LinearLayoutManager(vikalpTrainListFragment.getContext()));
        }
    }

    public class c implements VikalpTrainListAdapter.VikalpTrainListListener {
        public c() {
        }

        public final void onSelectMaxTrain() {
            VikalpTrainListFragment vikalpTrainListFragment = VikalpTrainListFragment.this;
            Toast.makeText(vikalpTrainListFragment.getContext(), vikalpTrainListFragment.getString(R.string.vikalp_train_validation), 1).show();
        }

        public final void onSelectVikalpTrain(Integer num, boolean z) {
            num.getClass();
            VikalpTrainListFragment vikalpTrainListFragment = VikalpTrainListFragment.this;
            Iterator<VikalpTrainListModel> it = vikalpTrainListFragment.f5212a.iterator();
            while (it.hasNext()) {
                VikalpTrainListModel next = it.next();
                if (next.a.getsNo() == num) {
                    next.f5350a = z;
                    vikalpTrainListFragment.f5215a[num.intValue()] = z;
                }
            }
            vikalpTrainListFragment.f();
        }
    }

    public class d implements DialogInterface.OnClickListener {
        public final void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class e implements DialogInterface.OnClickListener {
        public e() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            VikalpTrainListFragment vikalpTrainListFragment = VikalpTrainListFragment.this;
            vikalpTrainListFragment.h(vikalpTrainListFragment.c);
        }
    }

    public class f implements DialogInterface.OnClickListener {
        public f() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            VikalpTrainListFragment vikalpTrainListFragment = VikalpTrainListFragment.this;
            vikalpTrainListFragment.h(vikalpTrainListFragment.c);
        }
    }

    public class g implements DialogInterface.OnClickListener {
        public final void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class i extends Subscriber<StatusDTO> {
        public final /* synthetic */ ProgressDialog a;

        public i(ProgressDialog progressDialog) {
            this.a = progressDialog;
        }

        public final void onCompleted() {
            SimpleDateFormat simpleDateFormat = VikalpTrainListFragment.a;
        }

        public final void onError(Throwable th) {
            this.a.dismiss();
            SimpleDateFormat simpleDateFormat = VikalpTrainListFragment.a;
            xx.S(th, true, th);
        }

        public final void onNext(Object obj) {
            StatusDTO statusDTO = (StatusDTO) obj;
            ProgressDialog progressDialog = this.a;
            VikalpTrainListFragment vikalpTrainListFragment = VikalpTrainListFragment.this;
            if (statusDTO != null) {
                ObjectMapper h = C0657Qt.h();
                try {
                    if (statusDTO.getError() == null) {
                        h.writeValueAsString(statusDTO);
                        SimpleDateFormat simpleDateFormat = VikalpTrainListFragment.a;
                        progressDialog.dismiss();
                        C0535I5.p(vikalpTrainListFragment.getActivity(), false, statusDTO.getStatus(), xx.d(5), vikalpTrainListFragment.getString(R.string.OK), new R0(this), (String) null, (DialogInterface.OnClickListener) null).show();
                        return;
                    }
                    progressDialog.dismiss();
                    C0535I5.m(vikalpTrainListFragment.getActivity(), false, statusDTO.getError(), vikalpTrainListFragment.getString(R.string.error), vikalpTrainListFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                } catch (Exception e) {
                    progressDialog.dismiss();
                    SimpleDateFormat simpleDateFormat2 = VikalpTrainListFragment.a;
                    e.getMessage();
                }
            } else {
                progressDialog.dismiss();
                C0535I5.m(vikalpTrainListFragment.getActivity(), false, vikalpTrainListFragment.getResources().getString(R.string.unable_process_message), vikalpTrainListFragment.getString(R.string.error), vikalpTrainListFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
            }
        }
    }

    static {
        C1354qp.R(VikalpTrainListFragment.class);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001c, code lost:
        if (r6 == 0) goto L_0x001e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void f() {
        /*
            r8 = this;
            boolean[] r0 = r8.f5216c
            boolean[] r1 = r8.f5215a
            boolean r0 = java.util.Arrays.equals(r0, r1)
            r1 = 2131100644(0x7f0603e4, float:1.7813675E38)
            r2 = 0
            r3 = 1
            if (r0 != 0) goto L_0x001e
            boolean[] r0 = r8.f5215a
            int r4 = r0.length
            r5 = r2
            r6 = r5
        L_0x0014:
            if (r5 >= r4) goto L_0x001c
            boolean r7 = r0[r5]
            int r6 = r6 + r7
            int r5 = r5 + 1
            goto L_0x0014
        L_0x001c:
            if (r6 != 0) goto L_0x0048
        L_0x001e:
            cris.prs.webservices.dto.TrainBtwnStnsRespDto r0 = r8.f5211a
            boolean r0 = r0.getVikalpInSpecialTrainsAccomFlag()
            android.widget.CheckBox r4 = r8.splTrain
            boolean r4 = r4.isChecked()
            if (r0 != r4) goto L_0x002e
            r0 = r2
            goto L_0x002f
        L_0x002e:
            r0 = r3
        L_0x002f:
            if (r0 != 0) goto L_0x0048
            android.widget.TextView r0 = r8.submitBtn
            r0.setEnabled(r2)
            android.widget.TextView r0 = r8.submitBtn
            android.content.Context r2 = r8.getContext()
            android.content.res.Resources r2 = r2.getResources()
            int r1 = r2.getColor(r1)
            r0.setTextColor(r1)
            goto L_0x005e
        L_0x0048:
            android.widget.TextView r0 = r8.submitBtn
            r0.setEnabled(r3)
            android.widget.TextView r0 = r8.submitBtn
            android.content.Context r2 = r8.getContext()
            android.content.res.Resources r2 = r2.getResources()
            int r1 = r2.getColor(r1)
            r0.setTextColor(r1)
        L_0x005e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cris.org.in.ima.fragment.VikalpTrainListFragment.f():void");
    }

    public final void g() {
        this.f5212a = new ArrayList<>();
        for (int i2 = 0; i2 < this.f5213a.get(d).size(); i2++) {
            VikalpTrainListModel vikalpTrainListModel = new VikalpTrainListModel();
            this.f5209a = vikalpTrainListModel;
            vikalpTrainListModel.a = (TrainBtwnStnsDTO) this.f5213a.get(d).get(i2);
            this.f5209a.f5350a = false;
            if (this.f5210a.getVikalpDTO() != null) {
                Iterator<cris.prs.webservices.dto.c> it = this.f5210a.getVikalpDTO().iterator();
                while (it.hasNext()) {
                    cris.prs.webservices.dto.c next = it.next();
                    if (next.getTrainNo().equalsIgnoreCase(this.f5209a.a.getTrainNumber()) && next.getJourneyDate().equalsIgnoreCase(this.f5209a.a.getDepartureDate())) {
                        VikalpTrainListModel vikalpTrainListModel2 = this.f5209a;
                        vikalpTrainListModel2.f5350a = true;
                        this.f5215a[vikalpTrainListModel2.a.getsNo().intValue()] = true;
                        this.f5216c[this.f5209a.a.getsNo().intValue()] = true;
                    }
                }
            }
            this.f5212a.add(i2, this.f5209a);
        }
        this.trainList.setAdapter(new U9(getContext(), this.f5212a, this.f5208a));
        this.trainList.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    public final void h(String str) {
        short s;
        if (this.splTrain.isChecked()) {
            s = (short) 1;
        } else {
            s = (short) 0;
        }
        if (!C0535I5.O((ConnectivityManager) getActivity().getSystemService("connectivity"), getContext())) {
            new Handler().postDelayed(new h(), 5000);
            return;
        }
        C0793b1 b1Var = C0793b1.a;
        if (b1Var.f3912a != null) {
            ProgressDialog progressDialog = new ProgressDialog(getActivity());
            progressDialog.requestWindowFeature(1);
            progressDialog.setMessage(getString(R.string.please_wait_text));
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();
            String f2 = C0657Qt.f();
            String format = String.format("/%s/%s/%s", new Object[]{Long.valueOf(Long.parseLong(this.f5210a.getReservationId())), str, s});
            ((Om) C0657Qt.c(b1Var.f3912a)).O0(f2 + "optVikalp" + format).c(C1181iv.a()).a(E0.a()).b(new i(progressDialog));
            return;
        }
        C0535I5.m(getActivity(), false, getResources().getString(R.string.data_connection_error_message), getString(R.string.error), getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i2;
        View inflate = layoutInflater.inflate(R.layout.fragment_vikalp_deatails, (ViewGroup) null);
        ButterKnife.bind((Object) this, inflate);
        this.f5206a = getContext();
        StationDb stationDb = C0793b1.a.f3911a;
        C0535I5.a = 0;
        Bundle arguments = getArguments();
        if (arguments != null) {
            TrainBtwnStnsRespDto trainBtwnStnsRespDto = (TrainBtwnStnsRespDto) arguments.getSerializable("Response");
            this.f5211a = trainBtwnStnsRespDto;
            if (!(trainBtwnStnsRespDto == null || trainBtwnStnsRespDto.getTrainBtwnStnsList() == null)) {
                TrainBtwnStnsRespDto trainBtwnStnsRespDto2 = this.f5211a;
                TreeMap<String, ArrayList<TrainBtwnStnsDTO>> treeMap = new TreeMap<>();
                for (TrainBtwnStnsDTO next : trainBtwnStnsRespDto2.getTrainBtwnStnsList()) {
                    ArrayList arrayList = new ArrayList();
                    if (!treeMap.containsKey(next.getDepartureDate())) {
                        arrayList.add(next);
                        treeMap.put(next.getDepartureDate(), arrayList);
                    } else {
                        ArrayList arrayList2 = treeMap.get(next.getDepartureDate());
                        arrayList2.add(next);
                        treeMap.put(next.getDepartureDate(), arrayList2);
                    }
                }
                this.f5213a = treeMap;
            }
            this.f5210a = (BookingResponseDTO) arguments.getSerializable("Ticket");
        }
        this.btn.setVisibility(0);
        if (this.f5213a == null) {
            this.f5213a = new TreeMap<>();
        }
        this.b = new boolean[this.f5213a.size()];
        d = this.f5213a.firstKey();
        this.vikalpTrainDate.setText(this.f5213a.firstKey());
        this.pnrNumber.setText(this.f5210a.getPnrNumber());
        if (!(this.f5210a.getTrainNumber() == null || this.f5210a.getTrainName() == null)) {
            this.trainNumber.setText(this.f5210a.getTrainName() + " (" + this.f5210a.getTrainNumber() + ")");
        }
        this.fromStation.setText(stationDb.m(this.f5210a.getFromStn()) + "(" + this.f5210a.getFromStn() + ")");
        this.toStation.setText(stationDb.m(this.f5210a.getDestStn()) + "(" + this.f5210a.getDestStn() + ")");
        if (this.f5210a.getBoardingDate() == null || this.f5210a.getDestArrvDate() == null) {
            this.arrDeptTime.setText("*N.A. - *N.A.");
        } else {
            boolean booleanValue = this.f5210a.getScheduleArrivalFlag().booleanValue();
            SimpleDateFormat simpleDateFormat = a;
            if (booleanValue && this.f5210a.getScheduleDepartureFlag().booleanValue()) {
                this.arrDeptTime.setText(simpleDateFormat.format(this.f5210a.getBoardingDate()) + " - " + simpleDateFormat.format(this.f5210a.getDestArrvDate()));
            } else if (this.f5210a.getScheduleArrivalFlag().booleanValue()) {
                this.arrDeptTime.setText(simpleDateFormat.format(this.f5210a.getBoardingDate()) + " - *N.A.");
            } else if (this.f5210a.getScheduleDepartureFlag().booleanValue()) {
                this.arrDeptTime.setText("*N.A. - " + simpleDateFormat.format(this.f5210a.getDestArrvDate()));
            } else {
                this.arrDeptTime.setText("*N.A. - *N.A.");
            }
        }
        this.jrnyDate.setText(C0535I5.d(this.f5210a.getJourneyDate()));
        if (this.f5211a.getVikalpInSpecialTrains().booleanValue()) {
            this.splTrainLayout.setVisibility(0);
            this.splTrain.setText(this.f5211a.getVikalpSpecialTrainsMsg().replace(C0515Ga.AVLBLTY_ONLY, "30"));
        } else {
            this.splTrainLayout.setVisibility(8);
        }
        HomeActivity.x();
        C0535I5.b = this.f5211a.getMaxNoOfVikalpTrains().intValue();
        this.selectTrnTxt.setText("Maximum of " + C0535I5.b + " trains can be selected");
        String[] strArr = (String[]) this.f5213a.keySet().toArray(new String[this.f5213a.size()]);
        this.f5214a = strArr;
        this.b[Arrays.asList(strArr).indexOf(d)] = true;
        this.f5215a = new boolean[this.f5211a.getTrainBtwnStnsList().size()];
        this.f5216c = new boolean[this.f5211a.getTrainBtwnStnsList().size()];
        if (this.f5210a.getVikalpDTO() == null) {
            i2 = 0;
        } else {
            i2 = this.f5210a.getVikalpDTO().size();
        }
        C0535I5.a = i2;
        if (this.f5211a.getVikalpInSpecialTrainsAccomFlag()) {
            this.splTrain.setChecked(false);
        } else {
            this.splTrain.setChecked(true);
        }
        g();
        GoogleAdParamDTO googleAdParamDTO = new GoogleAdParamDTO();
        googleAdParamDTO.setAge(C1450w1.f7009a);
        googleAdParamDTO.setGender(C1450w1.f7021c);
        C0535I5.Y(getActivity(), this.selectvikalptrain_bottom, googleAdParamDTO);
        f();
        return inflate;
    }

    public final void onDestroy() {
        super.onDestroy();
        C0535I5.u();
    }

    @OnClick({2131363926})
    public void onSplBkgClick(View view) {
        f();
    }

    public final void onStop() {
        super.onStop();
        C0535I5.u();
    }

    @OnClick({2131364623})
    public void onSubmitClick() {
        boolean z;
        this.c = null;
        int i2 = 0;
        while (true) {
            boolean[] zArr = this.f5215a;
            if (i2 >= zArr.length) {
                break;
            }
            if (zArr[i2]) {
                String str = this.c;
                if (str == null || str.equals("")) {
                    this.c = i2 + "#";
                } else {
                    this.c += i2 + "#";
                }
            }
            i2++;
        }
        String str2 = this.c;
        if (str2 == null || str2.equals("")) {
            C0535I5.m(getActivity(), false, getResources().getString(R.string.vikalp_selection_error_message), getString(R.string.error), getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
            return;
        }
        if (Arrays.equals(this.f5216c, this.f5215a)) {
            if (this.f5211a.getVikalpInSpecialTrainsAccomFlag() == this.splTrain.isChecked()) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                C0535I5.m(getActivity(), false, getResources().getString(R.string.vikalp_not_edited), getString(R.string.info), getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                return;
            }
        }
        if (C0535I5.a < C0535I5.b) {
            String str3 = this.c;
            this.c = str3.substring(0, str3.length() - 1);
            C0535I5.p(getActivity(), true, getResources().getString(R.string.vikalp_want_mor_trains), getString(R.string.cnf_viklp), getString(R.string.yes_allcaps), new d(), getString(R.string.no_allcaps), new e()).show();
        } else if (C0535I5.a == C0535I5.b) {
            String str4 = this.c;
            this.c = str4.substring(0, str4.length() - 1);
            C0535I5.p(getActivity(), false, getString(R.string.do_you_want_to_proceed), getString(R.string.cnf), getString(R.string.confirm), new f(), getString(R.string.cancel), new g()).show();
        }
    }

    @OnClick({2131363097})
    public void onVikalpDateClick(View view) {
        CustomDialogFragment customDialogFragment = new CustomDialogFragment();
        this.f5207a = customDialogFragment;
        customDialogFragment.setShowsDialog(true);
        this.f5207a.show(getFragmentManager(), "");
        this.f5207a.setCancelable(true);
        getFragmentManager().z();
        ArrayList arrayList = new ArrayList(this.f5213a.keySet());
        Collections.sort(arrayList, new a());
        CustomAdapter customAdapter = new CustomAdapter(getContext(), arrayList, new b());
        this.f5207a.g().setText("Select Date for Vikalp Trains");
        this.f5207a.f().setAdapter(customAdapter);
    }

    public class h implements Runnable {
        public final void run() {
        }
    }
}
