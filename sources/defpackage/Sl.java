package defpackage;

import cris.org.in.ima.activities.MoreDrawerActivity;
import cris.prs.webservices.dto.StatusDTO;
import rx.Subscriber;

/* renamed from: Sl  reason: default package */
/* compiled from: MoreDrawerActivity */
public final class Sl extends Subscriber<StatusDTO> {
    public final void onCompleted() {
        int i = MoreDrawerActivity.c;
    }

    public final void onError(Throwable th) {
        int i = MoreDrawerActivity.c;
        xx.S(th, true, th);
    }

    public final /* bridge */ /* synthetic */ void onNext(Object obj) {
        StatusDTO statusDTO = (StatusDTO) obj;
    }
}
