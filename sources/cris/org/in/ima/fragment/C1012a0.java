package cris.org.in.ima.fragment;

import android.app.ProgressDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import cris.org.in.ima.adaptors.FavourtyListJPPageAdapter;
import cris.org.in.ima.db.StationDb;
import cris.org.in.ima.model.FevJourneyModel;
import cris.org.in.ima.model.StationModel;
import cris.prs.webservices.dto.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import rx.Subscriber;

/* renamed from: cris.org.in.ima.fragment.a0  reason: case insensitive filesystem */
/* compiled from: NewBookingFragment */
public final class C1012a0 extends Subscriber<b> {
    public final /* synthetic */ ProgressDialog a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ NewBookingFragment f5233a;

    public C1012a0(NewBookingFragment newBookingFragment, ProgressDialog progressDialog) {
        this.f5233a = newBookingFragment;
        this.a = progressDialog;
    }

    public final void onCompleted() {
        boolean z = NewBookingFragment.k;
        this.a.dismiss();
    }

    public final void onError(Throwable th) {
        boolean z = NewBookingFragment.k;
        th.getClass();
        th.getMessage();
        this.a.dismiss();
        Lt.a(true, th);
    }

    public final void onNext(Object obj) {
        Iterator<b.a> it;
        String str;
        b bVar = (b) obj;
        String str2 = "#";
        boolean z = NewBookingFragment.k;
        Objects.toString(bVar);
        this.a.dismiss();
        if (bVar != null) {
            try {
                ArrayList<FevJourneyModel> arrayList = new ArrayList<>();
                ArrayList arrayList2 = new ArrayList();
                ArrayList<StationModel> arrayList3 = new ArrayList<>();
                for (Iterator<b.a> it2 = bVar.getFevJourneyLists().iterator(); it2.hasNext(); it2 = it) {
                    b.a next = it2.next();
                    if (next.getCls() == null || next.getCls().isEmpty()) {
                        it = it2;
                        str = str2;
                    } else {
                        StationModel stationModel = new StationModel();
                        String[] split = next.getFromStnCode().split("-");
                        String[] split2 = next.getToStnCode().split("-");
                        if (!(next.getCls() == null || next.getQuota() == null || next.getTrainNumber() == null)) {
                            C0535I5.f3646h.add(split[1].trim() + str2 + split2[1].trim() + str2 + next.getCls().trim() + str2 + next.getQuota().trim() + str2 + next.getTrainNumber().trim());
                        }
                        StationDb stationDb = C0793b1.a.f3911a;
                        if (stationDb.h(split[1]) == null) {
                            StringBuilder sb = new StringBuilder();
                            it = it2;
                            sb.append(stationDb.m(split[1]));
                            sb.append("-");
                            sb.append(split[1]);
                            String sb2 = sb.toString();
                            stationModel.d = "";
                            stationModel.b = sb2;
                            str = str2;
                        } else {
                            it = it2;
                            StringBuilder sb3 = new StringBuilder();
                            str = str2;
                            sb3.append(stationDb.m(split[1]));
                            sb3.append("-");
                            sb3.append(split[1]);
                            sb3.append(" (");
                            sb3.append(stationDb.h(split[1]));
                            sb3.append(")");
                            String sb4 = sb3.toString();
                            stationModel.d = "";
                            stationModel.b = sb4;
                        }
                        if (stationDb.h(split2[1]) == null) {
                            stationModel.f5341a = stationDb.m(split2[1]) + "-" + split2[1];
                        } else {
                            stationModel.f5341a = stationDb.m(split2[1]) + "-" + split2[1] + " (" + stationDb.h(split2[1]) + ")";
                        }
                        stationModel.a = next.getRecent();
                        if (!next.getRecent().booleanValue()) {
                            arrayList3.add(stationModel);
                        }
                        FevJourneyModel fevJourneyModel = new FevJourneyModel();
                        fevJourneyModel.d = next.getFromStnCode();
                        fevJourneyModel.e = next.getToStnCode();
                        fevJourneyModel.f = next.getCls();
                        fevJourneyModel.g = next.getQuota();
                        fevJourneyModel.c = next.getTrainNumber();
                        fevJourneyModel.a = next.getId();
                        if (!next.getRecent().booleanValue()) {
                            arrayList.add(fevJourneyModel);
                        }
                    }
                    str2 = str;
                }
                arrayList2.clear();
                C0535I5.f3640e = arrayList;
                C0535I5.f3636d = arrayList3;
                int size = arrayList.size();
                NewBookingFragment newBookingFragment = this.f5233a;
                if (size > 0) {
                    newBookingFragment.fav_heading_rl.setVisibility(0);
                    newBookingFragment.rv_Favourty.setVisibility(0);
                } else {
                    newBookingFragment.fav_heading_rl.setVisibility(8);
                    newBookingFragment.rv_Favourty.setVisibility(8);
                }
                ArrayList arrayList4 = new ArrayList();
                Iterator<FevJourneyModel> it3 = arrayList.iterator();
                int i = 0;
                while (it3.hasNext()) {
                    FevJourneyModel next2 = it3.next();
                    if (i > 7) {
                        break;
                    }
                    i++;
                    arrayList4.add(next2);
                }
                newBookingFragment.f4848a = new FavourtyListJPPageAdapter(newBookingFragment.getContext(), arrayList4, newBookingFragment.f4851a);
                newBookingFragment.rv_Favourty.setLayoutManager(new LinearLayoutManager(newBookingFragment.getContext(), 0, false));
                newBookingFragment.rv_Favourty.setAdapter(newBookingFragment.f4848a);
            } catch (Exception e) {
                boolean z2 = NewBookingFragment.k;
                e.getMessage();
            }
        }
    }
}
