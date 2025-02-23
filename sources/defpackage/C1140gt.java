package defpackage;

import android.content.DialogInterface;
import cris.org.in.ima.activities.M;
import cris.org.in.ima.activities.RegistrationPage3Activity;
import cris.prs.webservices.dto.StatusDTO;

/* renamed from: gt  reason: default package and case insensitive filesystem */
/* compiled from: RegistrationPage3Activity */
public final class C1140gt implements DialogInterface.OnClickListener {
    public final /* synthetic */ M a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ StatusDTO f5472a;

    public C1140gt(M m, StatusDTO statusDTO) {
        this.a = m;
        this.f5472a = statusDTO;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        M m = this.a;
        RegistrationPage3Activity registrationPage3Activity = m.f4232a;
        StatusDTO statusDTO = this.f5472a;
        registrationPage3Activity.c = statusDTO.getCaptchaDTO().getCaptcha().intValue();
        RegistrationPage3Activity registrationPage3Activity2 = m.f4232a;
        if (10 == registrationPage3Activity2.c) {
            RegistrationPage3Activity.l(registrationPage3Activity2, statusDTO.getCaptchaDTO().getCaptchaQuestion());
        }
    }
}
