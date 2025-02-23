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
import com.google.android.gms.ads.admanager.AdManagerAdView;
import cris.org.in.ima.adaptors.CustomAdapter;
import cris.org.in.ima.adaptors.VikalpTrainListAdapter;
import cris.org.in.ima.dto.oauth2.GoogleAdParamDTO;
import cris.org.in.ima.listener.OnSelectionListener;
import cris.org.in.ima.model.VikalpTrainListModel;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.TrainBtwnStnsDTO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeMap;
import rx.Subscriber;

public class VikalpTrainListFragment1 extends Fragment {
    public static String d;
    public C0660R1 a;

    /* renamed from: a  reason: collision with other field name */
    public C0716V1 f5218a = null;

    /* renamed from: a  reason: collision with other field name */
    public Context f5219a;

    /* renamed from: a  reason: collision with other field name */
    public CustomDialogFragment f5220a;

    /* renamed from: a  reason: collision with other field name */
    public final a f5221a = new a();

    /* renamed from: a  reason: collision with other field name */
    public VikalpTrainListModel f5222a;

    /* renamed from: a  reason: collision with other field name */
    public ArrayList<VikalpTrainListModel> f5223a;

    /* renamed from: a  reason: collision with other field name */
    public TreeMap<String, ArrayList<TrainBtwnStnsDTO>> f5224a;

    /* renamed from: a  reason: collision with other field name */
    public C1475xA f5225a;

    /* renamed from: a  reason: collision with other field name */
    public String[] f5226a;

    /* renamed from: a  reason: collision with other field name */
    public boolean[] f5227a;
    @BindView(2131364293)
    TextView arrDeptTime;
    public boolean[] b;
    public String c = null;

    /* renamed from: c  reason: collision with other field name */
    public boolean[] f5228c;
    @BindView(2131362715)
    TextView fromStation;
    @BindView(2131362920)
    TextView jrnyDate;
    @BindView(2131363506)
    TextView pnrNumber;
    @BindView(2131364595)
    TextView selectTrnTxt;
    @BindView(2131363931)
    AdManagerAdView selectvikalptrainbottom;
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

    public class a implements VikalpTrainListAdapter.VikalpTrainListListener {
        public a() {
        }

        public final void onSelectMaxTrain() {
            VikalpTrainListFragment1 vikalpTrainListFragment1 = VikalpTrainListFragment1.this;
            Toast.makeText(vikalpTrainListFragment1.f5219a, vikalpTrainListFragment1.getString(R.string.vikalp_train_validation), 1).show();
        }

        public final void onSelectVikalpTrain(Integer num, boolean z) {
            num.getClass();
            VikalpTrainListFragment1 vikalpTrainListFragment1 = VikalpTrainListFragment1.this;
            Iterator<VikalpTrainListModel> it = vikalpTrainListFragment1.f5223a.iterator();
            while (it.hasNext()) {
                VikalpTrainListModel next = it.next();
                if (next.a.getsNo() == num) {
                    next.f5350a = z;
                    vikalpTrainListFragment1.f5227a[num.intValue()] = z;
                }
            }
            vikalpTrainListFragment1.f();
        }
    }

    public class b implements Comparator<String> {
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

    public class c implements OnSelectionListener {
        public c() {
        }

        public final void onClick(String str) {
            VikalpTrainListFragment1 vikalpTrainListFragment1 = VikalpTrainListFragment1.this;
            vikalpTrainListFragment1.vikalpTrainDate.setText(str);
            VikalpTrainListFragment1.d = str;
            vikalpTrainListFragment1.f5220a.dismiss();
            int indexOf = Arrays.asList(vikalpTrainListFragment1.f5226a).indexOf(VikalpTrainListFragment1.d);
            boolean[] zArr = vikalpTrainListFragment1.b;
            if (!zArr[indexOf]) {
                zArr[indexOf] = true;
                vikalpTrainListFragment1.g();
                return;
            }
            vikalpTrainListFragment1.f5223a = new ArrayList<>();
            if (vikalpTrainListFragment1.f5225a.getVikalpInSpecialTrainsAccomFlag()) {
                vikalpTrainListFragment1.splTrain.setChecked(true);
            } else {
                vikalpTrainListFragment1.splTrain.setChecked(false);
            }
            for (int i = 0; i < vikalpTrainListFragment1.f5224a.get(VikalpTrainListFragment1.d).size(); i++) {
                VikalpTrainListModel vikalpTrainListModel = new VikalpTrainListModel();
                vikalpTrainListFragment1.f5222a = vikalpTrainListModel;
                vikalpTrainListModel.a = (TrainBtwnStnsDTO) vikalpTrainListFragment1.f5224a.get(VikalpTrainListFragment1.d).get(i);
                if (vikalpTrainListFragment1.f5227a[vikalpTrainListFragment1.f5222a.a.getsNo().intValue()]) {
                    vikalpTrainListFragment1.f5222a.f5350a = true;
                }
                vikalpTrainListFragment1.f5223a.add(i, vikalpTrainListFragment1.f5222a);
            }
            vikalpTrainListFragment1.trainList.setAdapter(new U9(vikalpTrainListFragment1.getActivity(), vikalpTrainListFragment1.f5223a, vikalpTrainListFragment1.f5221a));
            vikalpTrainListFragment1.trainList.setLayoutManager(new LinearLayoutManager(vikalpTrainListFragment1.getContext()));
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
            VikalpTrainListFragment1 vikalpTrainListFragment1 = VikalpTrainListFragment1.this;
            vikalpTrainListFragment1.h(vikalpTrainListFragment1.c);
        }
    }

    public class f implements DialogInterface.OnClickListener {
        public f() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            VikalpTrainListFragment1 vikalpTrainListFragment1 = VikalpTrainListFragment1.this;
            vikalpTrainListFragment1.h(vikalpTrainListFragment1.c);
        }
    }

    public class g implements DialogInterface.OnClickListener {
        public final void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public class i extends Subscriber<C0750Xx> {
        public final /* synthetic */ ProgressDialog a;

        public i(ProgressDialog progressDialog) {
            this.a = progressDialog;
        }

        public final void onCompleted() {
            String str = VikalpTrainListFragment1.d;
        }

        public final void onError(Throwable th) {
            this.a.dismiss();
            String str = VikalpTrainListFragment1.d;
            th.getClass();
            th.getMessage();
            Mt.a(th);
        }

        public final void onNext(Object obj) {
            C0750Xx xx = (C0750Xx) obj;
            ProgressDialog progressDialog = this.a;
            VikalpTrainListFragment1 vikalpTrainListFragment1 = VikalpTrainListFragment1.this;
            if (xx != null) {
                C0657Qt.h();
                try {
                    if (!xx.isErrorFlag()) {
                        progressDialog.dismiss();
                        C0535I5.p(vikalpTrainListFragment1.f5219a, false, xx.getErrorMsg(), xx.d(5), vikalpTrainListFragment1.getString(R.string.OK), new S0(this), (String) null, (DialogInterface.OnClickListener) null).show();
                        return;
                    }
                    progressDialog.dismiss();
                    C0535I5.m(vikalpTrainListFragment1.f5219a, false, xx.getErrorMsg(), vikalpTrainListFragment1.getString(R.string.error), vikalpTrainListFragment1.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                } catch (Exception e) {
                    progressDialog.dismiss();
                    String str = VikalpTrainListFragment1.d;
                    e.getMessage();
                }
            } else {
                progressDialog.dismiss();
                C0535I5.m(vikalpTrainListFragment1.f5219a, false, vikalpTrainListFragment1.getResources().getString(R.string.unable_process_message), vikalpTrainListFragment1.getString(R.string.error), vikalpTrainListFragment1.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
            }
        }
    }

    static {
        C1354qp.R(VikalpTrainListFragment1.class);
        new SimpleDateFormat("HH:mm");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0019, code lost:
        if (r5 == 0) goto L_0x001b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void f() {
        /*
            r7 = this;
            boolean[] r0 = r7.f5228c
            boolean[] r1 = r7.f5227a
            boolean r0 = java.util.Arrays.equals(r0, r1)
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x001b
            boolean[] r0 = r7.f5227a
            int r3 = r0.length
            r4 = r1
            r5 = r4
        L_0x0011:
            if (r4 >= r3) goto L_0x0019
            boolean r6 = r0[r4]
            int r5 = r5 + r6
            int r4 = r4 + 1
            goto L_0x0011
        L_0x0019:
            if (r5 != 0) goto L_0x003e
        L_0x001b:
            xA r0 = r7.f5225a
            boolean r0 = r0.getVikalpInSpecialTrainsAccomFlag()
            android.widget.CheckBox r3 = r7.splTrain
            boolean r3 = r3.isChecked()
            if (r0 != r3) goto L_0x002b
            r0 = r1
            goto L_0x002c
        L_0x002b:
            r0 = r2
        L_0x002c:
            if (r0 != 0) goto L_0x003e
            android.widget.TextView r0 = r7.submitBtn
            r0.setEnabled(r1)
            android.widget.TextView r0 = r7.submitBtn
            android.content.Context r1 = r7.f5219a
            r2 = 2131099724(0x7f06004c, float:1.781181E38)
            defpackage.C1058d.H(r1, r2, r0)
            goto L_0x004d
        L_0x003e:
            android.widget.TextView r0 = r7.submitBtn
            r0.setEnabled(r2)
            android.widget.TextView r0 = r7.submitBtn
            android.content.Context r1 = r7.f5219a
            r2 = 2131099649(0x7f060001, float:1.7811657E38)
            defpackage.C1058d.H(r1, r2, r0)
        L_0x004d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cris.org.in.ima.fragment.VikalpTrainListFragment1.f():void");
    }

    public final void g() {
        this.f5223a = new ArrayList<>();
        for (int i2 = 0; i2 < this.f5224a.get(d).size(); i2++) {
            VikalpTrainListModel vikalpTrainListModel = new VikalpTrainListModel();
            this.f5222a = vikalpTrainListModel;
            vikalpTrainListModel.a = (TrainBtwnStnsDTO) this.f5224a.get(d).get(i2);
            this.f5222a.f5350a = false;
            if (this.f5218a.getAlreadyOptedVikalpList() != null) {
                Iterator<cris.prs.webservices.dto.c> it = this.f5218a.getAlreadyOptedVikalpList().iterator();
                while (it.hasNext()) {
                    cris.prs.webservices.dto.c next = it.next();
                    if (next.getTrainNo().equalsIgnoreCase(this.f5222a.a.getTrainNumber()) && next.getJourneyDate().equalsIgnoreCase(this.f5222a.a.getDepartureDate())) {
                        VikalpTrainListModel vikalpTrainListModel2 = this.f5222a;
                        vikalpTrainListModel2.f5350a = true;
                        this.f5227a[vikalpTrainListModel2.a.getsNo().intValue()] = true;
                        this.f5228c[this.f5222a.a.getsNo().intValue()] = true;
                    }
                }
            }
            this.f5223a.add(i2, this.f5222a);
        }
        this.trainList.setAdapter(new U9(getActivity(), this.f5223a, this.f5221a));
        this.trainList.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    public final void h(String str) {
        short s;
        if (this.splTrain.isChecked()) {
            s = (short) 1;
        } else {
            s = (short) 0;
        }
        if (!C0535I5.O((ConnectivityManager) this.f5219a.getSystemService("connectivity"), getContext())) {
            new Handler().postDelayed(new h(), 5000);
            return;
        }
        ProgressDialog progressDialog = new ProgressDialog(this.f5219a);
        progressDialog.requestWindowFeature(1);
        progressDialog.setMessage(getString(R.string.please_wait_text));
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
        String m = C0657Qt.m();
        String format = String.format("/%s/%s/%s", new Object[]{this.pnrNumber.getText().toString(), str, s});
        ((Om) C0657Qt.b()).t1(m + "optVikalp" + format).c(C1181iv.a()).a(E0.a()).b(new i(progressDialog));
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i2;
        View inflate = layoutInflater.inflate(R.layout.activity_vikalp_details, (ViewGroup) null);
        ButterKnife.bind((Object) this, inflate);
        this.f5219a = getContext();
        C0535I5.a = 0;
        C0535I5.a = 0;
        Bundle arguments = getArguments();
        if (arguments != null) {
            C0716V1 v1 = (C0716V1) arguments.getSerializable("AtasDTO");
            this.f5218a = v1;
            this.a = v1.getAtasPnrBuffer();
            C1475xA atasTrainList = this.f5218a.getAtasTrainList();
            TreeMap<String, ArrayList<TrainBtwnStnsDTO>> treeMap = new TreeMap<>();
            for (TrainBtwnStnsDTO next : atasTrainList.getTrainBtwnStnsList()) {
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
            this.f5224a = treeMap;
            this.f5225a = this.f5218a.getAtasTrainList();
            this.f5218a.getAlreadyOptedVikalpList();
            this.b = new boolean[this.f5224a.size()];
            d = this.f5224a.firstKey();
            this.vikalpTrainDate.setText(this.f5224a.firstKey());
            this.pnrNumber.setText(this.a.getPnrNumber());
            if (!(this.a.getTrainNumber() == null || this.a.getTrainName() == null)) {
                this.trainNumber.setText(this.a.getTrainName() + " (" + this.a.getTrainNumber() + ")");
            }
            this.fromStation.setText(this.a.getFromStaion());
            this.toStation.setText(this.a.getToStation());
            GoogleAdParamDTO googleAdParamDTO = new GoogleAdParamDTO();
            googleAdParamDTO.setAge(C1450w1.f7009a);
            googleAdParamDTO.setGender(C1450w1.f7021c);
            C0535I5.Y(getActivity(), this.selectvikalptrainbottom, googleAdParamDTO);
            this.jrnyDate.setText(C0535I5.d(this.a.getUtilJourneyDate()));
            if (this.f5225a.getVikalpInSpecialTrains().booleanValue()) {
                this.splTrainLayout.setVisibility(0);
                this.splTrain.setText(this.f5225a.getVikalpSpecialTrainsMsg());
            } else {
                this.splTrainLayout.setVisibility(8);
            }
            C0535I5.b = this.f5225a.getMaxNoOfVikalpTrains().intValue();
            this.selectTrnTxt.setText("Maximum of " + C0535I5.b + " trains can be selected");
            String[] strArr = (String[]) this.f5224a.keySet().toArray(new String[this.f5224a.size()]);
            this.f5226a = strArr;
            this.b[Arrays.asList(strArr).indexOf(d)] = true;
            this.f5227a = new boolean[this.f5225a.getTrainBtwnStnsList().size()];
            this.f5228c = new boolean[this.f5225a.getTrainBtwnStnsList().size()];
            if (this.f5218a.getAlreadyOptedVikalpList() == null) {
                i2 = 0;
            } else {
                i2 = this.f5218a.getAlreadyOptedVikalpList().size();
            }
            C0535I5.a = i2;
            if (this.f5225a.getVikalpInSpecialTrainsAccomFlag()) {
                this.splTrain.setChecked(true);
            } else {
                this.splTrain.setChecked(false);
            }
            g();
            f();
        }
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
            boolean[] zArr = this.f5227a;
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
            C0535I5.m(this.f5219a, false, getResources().getString(R.string.vikalp_selection_error_message), getString(R.string.error), getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
            return;
        }
        if (Arrays.equals(this.f5228c, this.f5227a)) {
            if (this.f5225a.getVikalpInSpecialTrainsAccomFlag() == this.splTrain.isChecked()) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                C0535I5.m(this.f5219a, false, getResources().getString(R.string.vikalp_not_edited), getString(R.string.error), getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
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
        this.f5220a = customDialogFragment;
        customDialogFragment.setShowsDialog(true);
        this.f5220a.show(getFragmentManager(), "");
        this.f5220a.setCancelable(true);
        getFragmentManager().z();
        ArrayList arrayList = new ArrayList(this.f5224a.keySet());
        Collections.sort(arrayList, new b());
        CustomAdapter customAdapter = new CustomAdapter(getContext(), arrayList, new c());
        this.f5220a.g().setText("Select Date for Vikalp Trains");
        this.f5220a.f().setAdapter(customAdapter);
    }

    public class h implements Runnable {
        public final void run() {
        }
    }
}
