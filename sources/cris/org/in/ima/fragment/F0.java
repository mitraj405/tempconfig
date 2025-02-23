package cris.org.in.ima.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.fasterxml.jackson.databind.MapperFeature;
import cris.org.in.ima.adaptors.TrainScheduleAdapterNew;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.TrainScheduleViewDTO;
import rx.Subscriber;

/* compiled from: TrainScheduleFragment */
public final class F0 extends Subscriber<TrainScheduleViewDTO> {
    public final /* synthetic */ ProgressDialog a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Context f4626a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ TrainScheduleFragment f4627a;
    public final /* synthetic */ String c;

    public F0(TrainScheduleFragment trainScheduleFragment, ProgressDialog progressDialog, String str, Context context) {
        this.f4627a = trainScheduleFragment;
        this.a = progressDialog;
        this.c = str;
        this.f4626a = context;
    }

    public final void onCompleted() {
        int i = TrainScheduleFragment.c;
    }

    public final void onError(Throwable th) {
        this.a.dismiss();
        int i = TrainScheduleFragment.c;
        xx.S(th, true, th);
    }

    public final void onNext(Object obj) {
        TrainScheduleViewDTO trainScheduleViewDTO = (TrainScheduleViewDTO) obj;
        Context context = this.f4626a;
        ProgressDialog progressDialog = this.a;
        if (trainScheduleViewDTO != null) {
            C0657Qt.h().configure(MapperFeature.USE_ANNOTATIONS, true);
            String errorMessage = trainScheduleViewDTO.getErrorMessage();
            TrainScheduleFragment trainScheduleFragment = this.f4627a;
            if (errorMessage == null || trainScheduleViewDTO.getErrorMessage() == "" || trainScheduleViewDTO.getErrorMessage().length() <= 0) {
                try {
                    C1507z0.d(this.c);
                    progressDialog.dismiss();
                    trainScheduleFragment.route_ll.setVisibility(0);
                    TextView textView = trainScheduleFragment.tv_train_name;
                    textView.setText(trainScheduleViewDTO.getTrainName() + " (" + trainScheduleViewDTO.getTrainNumber() + ")");
                    if (trainScheduleViewDTO.getTrainRunsOnMon().equalsIgnoreCase("Y")) {
                        trainScheduleFragment.tv_runs_on_Mon.setTextColor(trainScheduleFragment.getResources().getColor(R.color.dark));
                        trainScheduleFragment.tv_runs_on_Mon.setEnabled(true);
                    } else {
                        trainScheduleFragment.tv_runs_on_Mon.setTextColor(trainScheduleFragment.getResources().getColor(R.color.shadow_line2));
                        trainScheduleFragment.tv_runs_on_Mon.setEnabled(false);
                    }
                    if (trainScheduleViewDTO.getTrainRunsOnTue().equalsIgnoreCase("Y")) {
                        trainScheduleFragment.tv_runs_on_Tue.setTextColor(trainScheduleFragment.getResources().getColor(R.color.dark));
                        trainScheduleFragment.tv_runs_on_Tue.setEnabled(true);
                    } else {
                        trainScheduleFragment.tv_runs_on_Tue.setTextColor(trainScheduleFragment.getResources().getColor(R.color.shadow_line2));
                        trainScheduleFragment.tv_runs_on_Tue.setEnabled(false);
                    }
                    if (trainScheduleViewDTO.getTrainRunsOnWed().equalsIgnoreCase("Y")) {
                        trainScheduleFragment.tv_runs_on_Wed.setTextColor(trainScheduleFragment.getResources().getColor(R.color.dark));
                        trainScheduleFragment.tv_runs_on_Wed.setEnabled(true);
                    } else {
                        trainScheduleFragment.tv_runs_on_Wed.setTextColor(trainScheduleFragment.getResources().getColor(R.color.shadow_line2));
                        trainScheduleFragment.tv_runs_on_Wed.setEnabled(false);
                    }
                    if (trainScheduleViewDTO.getTrainRunsOnThu().equalsIgnoreCase("Y")) {
                        trainScheduleFragment.tv_runs_on_Thu.setTextColor(trainScheduleFragment.getResources().getColor(R.color.dark));
                        trainScheduleFragment.tv_runs_on_Thu.setEnabled(true);
                    } else {
                        trainScheduleFragment.tv_runs_on_Thu.setTextColor(trainScheduleFragment.getResources().getColor(R.color.shadow_line2));
                        trainScheduleFragment.tv_runs_on_Thu.setEnabled(false);
                    }
                    if (trainScheduleViewDTO.getTrainRunsOnFri().equalsIgnoreCase("Y")) {
                        trainScheduleFragment.tv_runs_on_Fri.setTextColor(trainScheduleFragment.getResources().getColor(R.color.dark));
                        trainScheduleFragment.tv_runs_on_Fri.setEnabled(true);
                    } else {
                        trainScheduleFragment.tv_runs_on_Fri.setTextColor(trainScheduleFragment.getResources().getColor(R.color.shadow_line2));
                        trainScheduleFragment.tv_runs_on_Fri.setEnabled(false);
                    }
                    if (trainScheduleViewDTO.getTrainRunsOnSat().equalsIgnoreCase("Y")) {
                        trainScheduleFragment.tv_runs_on_Sat.setTextColor(trainScheduleFragment.getResources().getColor(R.color.dark));
                        trainScheduleFragment.tv_runs_on_Sat.setEnabled(true);
                    } else {
                        trainScheduleFragment.tv_runs_on_Sat.setTextColor(trainScheduleFragment.getResources().getColor(R.color.shadow_line2));
                        trainScheduleFragment.tv_runs_on_Sat.setEnabled(false);
                    }
                    if (trainScheduleViewDTO.getTrainRunsOnSun().equalsIgnoreCase("Y")) {
                        trainScheduleFragment.tv_runs_on_Sun.setTextColor(trainScheduleFragment.getResources().getColor(R.color.dark));
                        trainScheduleFragment.tv_runs_on_Sun.setEnabled(true);
                    } else {
                        trainScheduleFragment.tv_runs_on_Sun.setTextColor(trainScheduleFragment.getResources().getColor(R.color.shadow_line2));
                        trainScheduleFragment.tv_runs_on_Sun.setEnabled(false);
                    }
                    trainScheduleFragment.rv_station_list.setLayoutManager(new LinearLayoutManager(context));
                    trainScheduleFragment.rv_station_list.setAdapter(new TrainScheduleAdapterNew(trainScheduleViewDTO));
                } catch (Exception e) {
                    progressDialog.dismiss();
                    int i = TrainScheduleFragment.c;
                    e.getMessage();
                }
                int i2 = TrainScheduleFragment.c;
                trainScheduleViewDTO.toString();
                return;
            }
            progressDialog.dismiss();
            C0535I5.m(trainScheduleFragment.getActivity(), false, trainScheduleViewDTO.getErrorMessage().toString(), trainScheduleFragment.getString(R.string.error), trainScheduleFragment.getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
            return;
        }
        progressDialog.dismiss();
        C0535I5.t0(context, context.getResources().getString(R.string.unable_process_message));
    }
}
