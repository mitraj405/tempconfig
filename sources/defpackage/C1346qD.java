package defpackage;

import cris.org.in.ima.activities.WebActivity;
import cris.prs.webservices.dto.StatusDTO;
import rx.Subscriber;

/* renamed from: qD  reason: default package and case insensitive filesystem */
/* compiled from: WebActivity */
public final class C1346qD extends Subscriber<StatusDTO> {
    public final void onCompleted() {
        int i = WebActivity.c;
    }

    public final void onError(Throwable th) {
        int i = WebActivity.c;
        xx.S(th, true, th);
    }

    public final /* bridge */ /* synthetic */ void onNext(Object obj) {
        StatusDTO statusDTO = (StatusDTO) obj;
    }
}
