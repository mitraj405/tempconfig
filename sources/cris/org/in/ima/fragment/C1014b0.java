package cris.org.in.ima.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.TrainBtwnStnsDTO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import rx.Subscriber;

/* renamed from: cris.org.in.ima.fragment.b0  reason: case insensitive filesystem */
/* compiled from: NewBookingFragment */
public final class C1014b0 extends Subscriber<Cf> {
    public final /* synthetic */ NewBookingFragment a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ C1469x0 f5234a;

    public C1014b0(NewBookingFragment newBookingFragment, C1469x0 x0Var) {
        this.a = newBookingFragment;
        this.f5234a = x0Var;
    }

    public final void onCompleted() {
        boolean z = NewBookingFragment.k;
    }

    public final void onError(Throwable th) {
        boolean z = NewBookingFragment.k;
        th.getClass();
        th.getMessage();
        this.a.f4844a.dismiss();
        Lt.a(true, th);
    }

    public final void onNext(Object obj) {
        boolean z;
        Cf cf = (Cf) obj;
        NewBookingFragment newBookingFragment = this.a;
        if (cf != null) {
            newBookingFragment.f4844a.dismiss();
            try {
                if (cf.getErrorMessage() != null) {
                    newBookingFragment.f4844a.dismiss();
                    if (!cf.getErrorMessage().contains("50035")) {
                        C0535I5.m(newBookingFragment.getActivity(), false, cf.getErrorMessage().split("-")[0], newBookingFragment.getString(R.string.error), newBookingFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                    } else if (C1450w1.f7013a == 3) {
                        C0535I5.m(newBookingFragment.getActivity(), false, newBookingFragment.getString(R.string.your_account_has_been_suspended), newBookingFragment.getString(R.string.error), newBookingFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                    } else {
                        C0535I5.m(newBookingFragment.getActivity(), false, cf.getErrorMessage().split("-")[0], newBookingFragment.getString(R.string.error), newBookingFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                    }
                } else if (cf.getJourneyDetailDTO() == null) {
                    C0535I5.m(newBookingFragment.getActivity(), false, newBookingFragment.getString(R.string.train_no_found), newBookingFragment.getString(R.string.error), newBookingFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                } else {
                    LinkedHashSet linkedHashSet = new LinkedHashSet();
                    if (newBookingFragment.s.equals("") || cf.getJourneyDetailDTO().get(0).getTrainBtwnStnsDTO().get(0).getAvlClasses() == null) {
                        z = false;
                    } else {
                        z = false;
                        for (TrainBtwnStnsDTO next : cf.getJourneyDetailDTO().get(0).getTrainBtwnStnsDTO()) {
                            for (String next2 : next.getAvlClasses()) {
                                if (newBookingFragment.s.equalsIgnoreCase(next2)) {
                                    linkedHashSet.add(next);
                                    z = true;
                                }
                                boolean equals = newBookingFragment.s.equals("");
                                HashMap<String, Boolean> hashMap = newBookingFragment.f4859b;
                                if (!equals) {
                                    if (!newBookingFragment.s.equals(next.getAvlClasses())) {
                                        hashMap.put(next2, Boolean.FALSE);
                                        newBookingFragment.f4857a.add(next2);
                                    }
                                }
                                hashMap.put(next2, Boolean.TRUE);
                                newBookingFragment.f4857a.add(next2);
                            }
                        }
                        newBookingFragment.f4870f = new ArrayList<>(linkedHashSet);
                    }
                    if (newBookingFragment.s.equals("") || z) {
                        C0535I5.f3647h = true;
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("indirectTbisResponse", cf);
                        bundle.putString("JourneyDate", newBookingFragment.f4861c);
                        bundle.putString("FromStationCode", newBookingFragment.f4867e);
                        bundle.putString("ToStationCode", newBookingFragment.f);
                        bundle.putString("FromStationString", newBookingFragment.g);
                        bundle.putString("ToStationString", newBookingFragment.h);
                        bundle.putString("flexiableWithDate", newBookingFragment.j);
                        bundle.putBoolean("isConnectingJourney", NewBookingFragment.k);
                        bundle.putString("spConcession", newBookingFragment.f4878k);
                        bundle.putString("jrnyClass", newBookingFragment.s);
                        bundle.putString("altAvlClass", this.f5234a.getJrnyClass());
                        bundle.putBoolean("rebookFlag", false);
                        bundle.putString("selectedQuota", NewBookingFragment.z);
                        bundle.putBoolean("altAvlEnqFlag", true);
                        bundle.putSerializable("avlClassModel", newBookingFragment.f4854a);
                        bundle.putSerializable("reebookPsgnList", newBookingFragment.f4855a);
                        bundle.putBoolean("trainAvailableBerthIsChecked", newBookingFragment.trainAvailableBerth.isChecked());
                        C0535I5.f3648i = cf.isBookingEnable();
                        bundle.putBoolean("indirectjourneyBookingEnable", cf.isBookingEnable());
                        if (!(cf.getInfo() == null || cf.getInfo() == "")) {
                            C0535I5.g = cf.getInfo();
                            bundle.putString("indirectjourneyInfo", cf.getInfo());
                        }
                        newBookingFragment.f4873g = true;
                        if (newBookingFragment.f4844a.isShowing()) {
                            newBookingFragment.f4844a.dismiss();
                        }
                        JourneyDetailsFragment journeyDetailsFragment = new JourneyDetailsFragment();
                        journeyDetailsFragment.setArguments(bundle);
                        HomeActivity.n(newBookingFragment.getActivity(), journeyDetailsFragment, C1218kf.TRAIN_LIST.a(), Boolean.TRUE, Boolean.FALSE);
                        return;
                    }
                    newBookingFragment.f4844a.dismiss();
                    C0535I5.o(newBookingFragment.getActivity(), newBookingFragment.getString(R.string.train_not_found_selectclass), newBookingFragment.getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
                }
            } catch (Exception e) {
                boolean z2 = NewBookingFragment.k;
                e.getMessage();
                if (newBookingFragment.f4844a.isShowing()) {
                    newBookingFragment.f4844a.dismiss();
                }
                C0535I5.t0(newBookingFragment.getActivity(), newBookingFragment.getString(R.string.please_try_again));
            }
        } else {
            newBookingFragment.f4844a.dismiss();
            C0535I5.m(newBookingFragment.getActivity(), false, newBookingFragment.getResources().getString(R.string.unable_process_message), newBookingFragment.getString(R.string.error), newBookingFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
        }
    }
}
