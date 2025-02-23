package cris.org.in.ima.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.model.FevJourneyModel;
import cris.org.in.ima.view_holder.FevouriteJourneyViewHolder;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.b;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import rx.Subscriber;

public class FevouriteJourneyFragment extends Fragment {
    public static final /* synthetic */ int c = 0;
    public Context a;

    /* renamed from: a  reason: collision with other field name */
    public final a f4637a;

    /* renamed from: a  reason: collision with other field name */
    public final b f4638a;

    /* renamed from: a  reason: collision with other field name */
    public FevJourneyModel f4639a = null;

    /* renamed from: a  reason: collision with other field name */
    public FevouriteJourneyViewHolder f4640a;

    /* renamed from: a  reason: collision with other field name */
    public ArrayList<FevJourneyModel> f4641a;
    public final ArrayList<FevJourneyModel> b = new ArrayList<>();
    @BindView(2131363327)
    TextView no_fevourite_jrny;
    @BindView(2131363815)
    RecyclerView rv_fevjourney;

    public class a implements FevouriteJourneyViewHolder.b {
        public a() {
        }
    }

    public class b implements FevouriteJourneyViewHolder.a {
        public b() {
        }
    }

    public class d extends Subscriber<cris.prs.webservices.dto.b> {
        public final /* synthetic */ ProgressDialog a;

        public d(ProgressDialog progressDialog) {
            this.a = progressDialog;
        }

        public final void onCompleted() {
            int i = FevouriteJourneyFragment.c;
            this.a.dismiss();
        }

        public final void onError(Throwable th) {
            int i = FevouriteJourneyFragment.c;
            th.getClass();
            th.getMessage();
            this.a.dismiss();
            Lt.a(true, th);
        }

        public final void onNext(Object obj) {
            cris.prs.webservices.dto.b bVar = (cris.prs.webservices.dto.b) obj;
            int i = FevouriteJourneyFragment.c;
            Objects.toString(bVar);
            if (bVar != null) {
                try {
                    ArrayList<FevJourneyModel> arrayList = new ArrayList<>();
                    new ArrayList();
                    new ArrayList();
                    Iterator<b.a> it = bVar.getFevJourneyLists().iterator();
                    while (it.hasNext()) {
                        b.a next = it.next();
                        if (next.getCls() != null && !next.getCls().isEmpty()) {
                            FevJourneyModel fevJourneyModel = new FevJourneyModel();
                            fevJourneyModel.d = next.getFromStnCode();
                            fevJourneyModel.e = next.getToStnCode();
                            fevJourneyModel.f = next.getCls();
                            fevJourneyModel.g = next.getQuota();
                            fevJourneyModel.a = next.getId();
                            fevJourneyModel.c = next.getTrainNumber();
                            arrayList.add(fevJourneyModel);
                        }
                    }
                    C0535I5.f3640e = arrayList;
                    int size = arrayList.size();
                    FevouriteJourneyFragment fevouriteJourneyFragment = FevouriteJourneyFragment.this;
                    if (size > 0) {
                        fevouriteJourneyFragment.no_fevourite_jrny.setVisibility(8);
                        fevouriteJourneyFragment.rv_fevjourney.setVisibility(0);
                        fevouriteJourneyFragment.getContext();
                        fevouriteJourneyFragment.f4640a = new FevouriteJourneyViewHolder(arrayList, fevouriteJourneyFragment.f4637a, fevouriteJourneyFragment.f4638a);
                        fevouriteJourneyFragment.rv_fevjourney.setLayoutManager(new LinearLayoutManager(fevouriteJourneyFragment.getContext()));
                        fevouriteJourneyFragment.rv_fevjourney.setAdapter(fevouriteJourneyFragment.f4640a);
                        return;
                    }
                    fevouriteJourneyFragment.no_fevourite_jrny.setVisibility(0);
                    fevouriteJourneyFragment.rv_fevjourney.setVisibility(8);
                } catch (Exception e) {
                    int i2 = FevouriteJourneyFragment.c;
                    e.getMessage();
                }
            }
        }
    }

    static {
        C1354qp.R(FevouriteJourneyFragment.class);
    }

    public FevouriteJourneyFragment() {
        new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss' HRS'");
        this.f4637a = new a();
        this.f4638a = new b();
    }

    public final void f() {
        if (!C0535I5.O((ConnectivityManager) getActivity().getSystemService("connectivity"), getContext())) {
            new Handler().postDelayed(new c(), 5000);
            return;
        }
        ArrayList<FevJourneyModel> arrayList = C0535I5.f3640e;
        this.f4641a = arrayList;
        if (arrayList == null || arrayList.size() == 0) {
            if (this.f4641a == null) {
                this.f4641a = new ArrayList<>();
            }
            ProgressDialog show = ProgressDialog.show(getActivity(), getString(R.string.fetch_fav_list), getString(R.string.please_wait_text));
            String f = C0657Qt.f();
            ((Om) C0657Qt.c(C0793b1.a.f3912a)).Y(f + "fetchJourneyDetails").c(C1181iv.a()).a(E0.a()).b(new d(show));
            return;
        }
        ArrayList<FevJourneyModel> arrayList2 = this.b;
        if (arrayList2 == null || arrayList2.size() <= 0) {
            this.no_fevourite_jrny.setVisibility(0);
            this.rv_fevjourney.setVisibility(8);
            return;
        }
        this.no_fevourite_jrny.setVisibility(8);
        this.rv_fevjourney.setVisibility(0);
        getContext();
        this.f4640a = new FevouriteJourneyViewHolder(this.f4641a, this.f4637a, this.f4638a);
        this.rv_fevjourney.setLayoutManager(new LinearLayoutManager(getContext()));
        this.rv_fevjourney.setAdapter(this.f4640a);
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_fevouriye_journet, (ViewGroup) null);
        ButterKnife.bind((Object) this, inflate);
        this.a = getContext();
        f();
        HomeActivity.J();
        return inflate;
    }

    public final void onDestroy() {
        super.onDestroy();
        C0535I5.u();
    }

    public final void onPause() {
        super.onPause();
        C0535I5.u();
    }

    public final void onStop() {
        super.onStop();
        C0535I5.u();
    }

    public class c implements Runnable {
        public final void run() {
        }
    }
}
