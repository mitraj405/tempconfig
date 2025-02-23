package defpackage;

import android.app.ProgressDialog;
import android.content.Context;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.fasterxml.jackson.databind.MapperFeature;
import cris.org.in.ima.adaptors.RouteMapAdapter;
import cris.org.in.ima.fragment.AllTrainListFragment;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.TrainScheduleViewDTO;
import rx.Subscriber;

/* renamed from: v0  reason: default package and case insensitive filesystem */
/* compiled from: AllTrainListFragment */
public final class C1434v0 extends Subscriber<TrainScheduleViewDTO> {
    public final /* synthetic */ ProgressDialog a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Context f6994a;
    public final /* synthetic */ String c;

    public C1434v0(ProgressDialog progressDialog, String str, Context context) {
        this.a = progressDialog;
        this.c = str;
        this.f6994a = context;
    }

    public final void onCompleted() {
        TextView textView = AllTrainListFragment.f4408a;
    }

    public final void onError(Throwable th) {
        this.a.dismiss();
        TextView textView = AllTrainListFragment.f4408a;
        xx.S(th, true, th);
    }

    public final void onNext(Object obj) {
        TrainScheduleViewDTO trainScheduleViewDTO = (TrainScheduleViewDTO) obj;
        ProgressDialog progressDialog = this.a;
        Context context = this.f6994a;
        if (trainScheduleViewDTO != null) {
            C0657Qt.h().configure(MapperFeature.USE_ANNOTATIONS, true);
            try {
                C1507z0.d(this.c);
                progressDialog.dismiss();
                AllTrainListFragment.a.setVisibility(0);
                TextView textView = AllTrainListFragment.b;
                textView.setText(context.getResources().getString(R.string.Route) + trainScheduleViewDTO.getTrainName() + " (" + trainScheduleViewDTO.getTrainNumber() + ")");
                AllTrainListFragment.f4408a.setVisibility(8);
                int i = 0;
                while (true) {
                    if (i >= trainScheduleViewDTO.getStationList().size()) {
                        break;
                    } else if (trainScheduleViewDTO.getStationList().get(i).getBoardingDisabled().booleanValue()) {
                        AllTrainListFragment.f4408a.setVisibility(0);
                        break;
                    } else {
                        i++;
                    }
                }
                AllTrainListFragment.f4410a.setLayoutManager(new LinearLayoutManager(context));
                AllTrainListFragment.f4410a.setAdapter(new RouteMapAdapter(context, trainScheduleViewDTO));
            } catch (Exception e) {
                progressDialog.dismiss();
                TextView textView2 = AllTrainListFragment.f4408a;
                e.getMessage();
            }
            trainScheduleViewDTO.toString();
            return;
        }
        progressDialog.dismiss();
        C0535I5.t0(context, context.getResources().getString(R.string.unable_process_message));
    }
}
