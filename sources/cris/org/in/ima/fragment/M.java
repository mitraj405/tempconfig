package cris.org.in.ima.fragment;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.fasterxml.jackson.databind.ObjectMapper;
import cris.org.in.ima.adaptors.BoardingStationChangeAdapter;
import cris.org.in.ima.model.WrapperBoardingStationModel;
import cris.org.in.prs.ima.R;
import defpackage.Z2;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import rx.Subscriber;

/* compiled from: ErsDisplayFragment */
public final class M extends Subscriber<Z2> {
    public final /* synthetic */ ProgressDialog a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ ErsDisplayFragment f4761a;

    public M(ErsDisplayFragment ersDisplayFragment, ProgressDialog progressDialog) {
        this.f4761a = ersDisplayFragment;
        this.a = progressDialog;
    }

    public final void onCompleted() {
        SimpleDateFormat simpleDateFormat = ErsDisplayFragment.d;
    }

    public final void onError(Throwable th) {
        this.a.dismiss();
        SimpleDateFormat simpleDateFormat = ErsDisplayFragment.d;
        xx.S(th, true, th);
    }

    public final void onNext(Object obj) {
        ArrayList<String> arrayList;
        Z2 z2 = (Z2) obj;
        ProgressDialog progressDialog = this.a;
        ErsDisplayFragment ersDisplayFragment = this.f4761a;
        if (z2 != null) {
            ObjectMapper h = C0657Qt.h();
            try {
                if (z2.getErrorMessage() == null) {
                    h.writeValueAsString(z2.getBoardingStationList());
                    SimpleDateFormat simpleDateFormat = ErsDisplayFragment.d;
                    ersDisplayFragment.f4581a.clear();
                    HashMap<String, String> hashMap = ersDisplayFragment.f4583a;
                    hashMap.clear();
                    Iterator<Z2.a> it = z2.getBoardingStationList().iterator();
                    while (true) {
                        boolean hasNext = it.hasNext();
                        arrayList = ersDisplayFragment.f4581a;
                        if (!hasNext) {
                            break;
                        }
                        Z2.a next = it.next();
                        arrayList.add(next.getStnNameCode());
                        hashMap.put(next.getStnNameCode().substring(next.getStnNameCode().indexOf(45) + 2), next.getStnNameCode());
                    }
                    if (arrayList != null && !arrayList.isEmpty()) {
                        if (!hashMap.isEmpty()) {
                            ersDisplayFragment.changeBoardingLl.setVisibility(0);
                            ersDisplayFragment.f4589b = z2.getBoardingStationList();
                            ersDisplayFragment.f4575a = null;
                            ArrayList arrayList2 = new ArrayList();
                            Iterator<Z2.a> it2 = ersDisplayFragment.f4589b.iterator();
                            while (it2.hasNext()) {
                                WrapperBoardingStationModel wrapperBoardingStationModel = new WrapperBoardingStationModel();
                                wrapperBoardingStationModel.a = it2.next();
                                arrayList2.add(wrapperBoardingStationModel);
                            }
                            PassengerDetailFragment.o = arrayList2.size() - 1;
                            ersDisplayFragment.boardingStnView.setLayoutManager(new LinearLayoutManager(ersDisplayFragment.getContext()));
                            BoardingStationChangeAdapter boardingStationChangeAdapter = new BoardingStationChangeAdapter(ersDisplayFragment.getContext(), arrayList2, ersDisplayFragment.f4572a);
                            ersDisplayFragment.f4570a = boardingStationChangeAdapter;
                            ersDisplayFragment.boardingStnView.setAdapter(boardingStationChangeAdapter);
                            progressDialog.dismiss();
                            progressDialog.dismiss();
                            return;
                        }
                    }
                    ersDisplayFragment.changeBoardingLl.setVisibility(8);
                    C0535I5.p(ersDisplayFragment.getActivity(), false, "No Boarding Option is Available", ersDisplayFragment.getString(R.string.Info), ersDisplayFragment.getString(R.string.OK), new C0664Ra(), (String) null, (DialogInterface.OnClickListener) null).show();
                    progressDialog.dismiss();
                    return;
                }
                progressDialog.dismiss();
                C0535I5.m(ersDisplayFragment.getActivity(), false, z2.getErrorMessage(), ersDisplayFragment.getString(R.string.error), ersDisplayFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
            } catch (Exception e) {
                progressDialog.dismiss();
                SimpleDateFormat simpleDateFormat2 = ErsDisplayFragment.d;
                e.getMessage();
            }
        } else {
            progressDialog.dismiss();
            C0535I5.m(ersDisplayFragment.getActivity(), false, ersDisplayFragment.getResources().getString(R.string.unable_process_message), ersDisplayFragment.getString(R.string.error), ersDisplayFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
        }
    }
}
