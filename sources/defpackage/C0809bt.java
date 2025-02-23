package defpackage;

import android.content.DialogInterface;
import cris.org.in.ima.activities.J;
import cris.org.in.ima.activities.RegistrationPage2Activity;
import cris.prs.webservices.dto.StatusDTO;

/* renamed from: bt  reason: default package and case insensitive filesystem */
/* compiled from: RegistrationPage2Activity */
public final class C0809bt implements DialogInterface.OnClickListener {
    public final /* synthetic */ J a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ StatusDTO f3925a;

    public C0809bt(J j, StatusDTO statusDTO) {
        this.a = j;
        this.f3925a = statusDTO;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        J j = this.a;
        RegistrationPage2Activity registrationPage2Activity = j.f4204a;
        StatusDTO statusDTO = this.f3925a;
        registrationPage2Activity.c = statusDTO.getCaptchaDTO().getCaptcha().intValue();
        RegistrationPage2Activity registrationPage2Activity2 = j.f4204a;
        if (10 == registrationPage2Activity2.c) {
            RegistrationPage2Activity.l(registrationPage2Activity2, statusDTO.getCaptchaDTO().getCaptchaQuestion());
        }
    }
}
