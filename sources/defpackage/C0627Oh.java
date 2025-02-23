package defpackage;

import android.app.ProgressDialog;
import android.content.Context;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.fasterxml.jackson.databind.MapperFeature;
import cris.org.in.ima.adaptors.RouteMapAdapter;
import cris.org.in.ima.fragment.LapAllTrainListFragment;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.TrainScheduleViewDTO;
import rx.Subscriber;

/* renamed from: Oh  reason: default package and case insensitive filesystem */
/* compiled from: LapAllTrainListFragment */
public final class C0627Oh extends Subscriber<TrainScheduleViewDTO> {
    public final /* synthetic */ ProgressDialog a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Context f3739a;
    public final /* synthetic */ String c;

    public C0627Oh(ProgressDialog progressDialog, String str, Context context) {
        this.a = progressDialog;
        this.c = str;
        this.f3739a = context;
    }

    public final void onCompleted() {
        FragmentActivity fragmentActivity = LapAllTrainListFragment.f4691a;
    }

    public final void onError(Throwable th) {
        this.a.dismiss();
        FragmentActivity fragmentActivity = LapAllTrainListFragment.f4691a;
        xx.S(th, true, th);
    }

    public final void onNext(Object obj) {
        TrainScheduleViewDTO trainScheduleViewDTO = (TrainScheduleViewDTO) obj;
        ProgressDialog progressDialog = this.a;
        Context context = this.f3739a;
        if (trainScheduleViewDTO != null) {
            C0657Qt.h().configure(MapperFeature.USE_ANNOTATIONS, true);
            try {
                C1507z0.d(this.c);
                progressDialog.dismiss();
                LapAllTrainListFragment.a.setVisibility(0);
                TextView textView = LapAllTrainListFragment.f4690a;
                textView.setText(context.getResources().getString(R.string.Route) + trainScheduleViewDTO.getTrainName() + " (" + trainScheduleViewDTO.getTrainNumber() + ")");
                LapAllTrainListFragment.f4692a.setLayoutManager(new LinearLayoutManager(context));
                LapAllTrainListFragment.f4692a.setAdapter(new RouteMapAdapter(context, trainScheduleViewDTO));
            } catch (Exception e) {
                progressDialog.dismiss();
                FragmentActivity fragmentActivity = LapAllTrainListFragment.f4691a;
                e.getMessage();
            }
            trainScheduleViewDTO.toString();
            return;
        }
        progressDialog.dismiss();
        C0535I5.t0(context, context.getResources().getString(R.string.unable_process_message));
    }
}
