package defpackage;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.widget.Toast;
import com.momagic.C0835h;
import cris.org.in.ima.IrctcImaApplication;
import cris.org.in.ima.activities.LoginWaitActivity;
import cris.org.in.ima.activities.x;
import cris.org.in.ima.utils.TicketHistoryUtil;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.InformationMessageDTO;
import defpackage.C0614Nv;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import rx.Subscriber;

/* renamed from: Si  reason: default package */
/* compiled from: LoginWaitActivity */
public final class Si extends Subscriber<JB> {
    public final /* synthetic */ LoginWaitActivity a;

    public Si(LoginWaitActivity loginWaitActivity) {
        this.a = loginWaitActivity;
    }

    public final void onCompleted() {
        AlertDialog alertDialog = C0535I5.f3619a;
    }

    public final void onError(Throwable th) {
        Lt.a(true, th);
        this.a.finish();
    }

    public final void onNext(Object obj) {
        JB jb = (JB) obj;
        int i = LoginWaitActivity.d;
        jb.getClass();
        String error = jb.getError();
        LoginWaitActivity loginWaitActivity = this.a;
        if (error != null) {
            C0793b1.a.f3912a = null;
            Toast makeText = Toast.makeText(loginWaitActivity, jb.getError(), 1);
            makeText.setGravity(1, 0, 0);
            makeText.show();
            loginWaitActivity.finish();
            return;
        }
        try {
            if (jb.getOtpLogin().intValue() == 1) {
                new Handler().postDelayed(new x(this, jb), 3000);
            } else if (jb.getOtpLogin().intValue() == 3) {
                C0535I5.m(loginWaitActivity.getApplicationContext(), false, jb.getStatus(), loginWaitActivity.getString(R.string.Info), loginWaitActivity.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                loginWaitActivity.finish();
            } else if (jb.getOtpLogin().intValue() == 0 || jb.getOtpLogin().intValue() == 4) {
                jb.getServerId();
                jb.getUserName();
                if (jb.getUserEnableState() != null) {
                    C1450w1.f7013a = jb.getUserEnableState().shortValue();
                }
                if (jb.getGender() != null) {
                    C1450w1.f7021c = jb.getGender();
                }
                if (jb.getDob() != null) {
                    String substring = ("USR_DES-" + jb.getGender() + jb.getUserIdHash() + IrctcImaApplication.c).substring(0, 16);
                    jb.setDob(C0535I5.t(jb.getDob(), substring));
                    C1450w1.f7016b = jb.getDob();
                    jb.setUserName(C0535I5.t(jb.getUserName(), substring));
                    jb.setEmail(C0535I5.t(jb.getEmail(), substring));
                    jb.setMobile(C0535I5.t(jb.getMobile(), substring));
                    C1450w1.f7009a = String.valueOf(C0535I5.f(new SimpleDateFormat("dd-MM-yyyy").parse(jb.getDob())));
                }
                if (jb.getErsTktSendEmailFlag() == 0 || jb.getErsTktSendEmailFlag() == 1) {
                    C1450w1.d = jb.getErsTktSendEmailFlag();
                }
                if (jb.getErsTktDownloadFlag() == 0 || jb.getErsTktDownloadFlag() == 1) {
                    C1450w1.c = jb.getErsTktDownloadFlag();
                }
                if (jb.getUserIdHash() != null) {
                    try {
                        C1450w1.f7026d = jb.getUserIdHash();
                        Bw e = Bw.e(loginWaitActivity.getApplicationContext());
                        String userIdHash = jb.getUserIdHash();
                        C0614Nv.a c = e.f3534a.edit();
                        c.putString("sdflkjl", userIdHash);
                        c.commit();
                        C0835h.k(jb.getUserIdHash());
                    } catch (Exception e2) {
                        int i2 = LoginWaitActivity.d;
                        e2.getMessage();
                    }
                }
                C1413ts[] ratingOptions = jb.getRatingOptions();
                ArrayList<C1413ts> arrayList = C1450w1.f7027d;
                arrayList.clear();
                for (C1413ts add : ratingOptions) {
                    arrayList.add(add);
                }
                arrayList.toString();
                if (jb.getFevJourney() != null) {
                    C1450w1.f7030e = jb.getFevJourney().booleanValue();
                }
                if (jb.getMasterList() != null) {
                    C1450w1.b = jb.getMasterList().intValue();
                }
                C1450w1.f7012a = jb.getMobileAppConfigDTO();
                if (jb.getAadhaarVerifyFlag() != null) {
                    jb.getAadhaarVerifyFlag().intValue();
                    AlertDialog alertDialog = C0535I5.f3619a;
                }
                if (jb.getAadhaarReverifyFlag() != null) {
                    C1450w1.f7019b = jb.getAadhaarReverifyFlag().booleanValue();
                }
                TicketHistoryUtil.f5371a = null;
                C0494EB eb = C1450w1.f7006a;
                eb.a = jb.getRdsFlag().intValue();
                eb.b = jb.getRenewFlag().intValue();
                eb.f3576a = jb.getVerified().booleanValue();
                eb.f3577b = jb.geteWalletExpireFlag().booleanValue();
                eb.f3575a = jb.getUserEnableState().shortValue();
                eb.toString();
                TicketHistoryUtil.c();
                jb.getRecentTransactionsFlag();
                AlertDialog alertDialog2 = C0535I5.f3619a;
                jb.getRecentTransactionsList();
                ArrayList<InformationMessageDTO> informationMessage = jb.getInformationMessage();
                if (informationMessage != null) {
                    HashMap<String, String> hashMap = new HashMap<>();
                    Iterator<InformationMessageDTO> it = informationMessage.iterator();
                    while (it.hasNext()) {
                        InformationMessageDTO next = it.next();
                        if (next.getParamName().equalsIgnoreCase("ERS")) {
                            if (next.getPopup().booleanValue()) {
                                hashMap.put("ersPopupMsg", next.getMessage());
                            } else {
                                hashMap.put("ersLableMsg", next.getMessage());
                            }
                        } else if (next.getParamName().equalsIgnoreCase("SHOPNAME")) {
                            hashMap.put("SHOPNAME", next.getMessage());
                        } else if (next.getParamName().equalsIgnoreCase("SHOPURL")) {
                            hashMap.put("SHOPURL", next.getMessage());
                        } else if (next.getParamName().equalsIgnoreCase("GOVT_ADS_ENABLE")) {
                            hashMap.put("GOVT_ADS_ENABLE", next.getMessage());
                        } else if (next.getParamName().equalsIgnoreCase("PLEDGE_ENABLE")) {
                            if (next.getPopup().booleanValue()) {
                                hashMap.put("pledgePopupMsg", next.getMessage());
                            }
                            hashMap.put("pledgeLableMsg", next.getMessage());
                            hashMap.put("pledgeUrl", next.getUrl());
                        } else if (next.getParamName().equalsIgnoreCase("CAPTCHA_POC_ENABLE")) {
                            hashMap.put("CAPTCHA_POC_ENABLE", next.getMessage());
                        }
                    }
                    if (!hashMap.isEmpty()) {
                        C1450w1.f7018b = hashMap;
                    }
                }
                if (jb.getRolles() == null || jb.getRolles().size() < 20 || !jb.getRolles().get(20).equals((short) 1)) {
                    C1450w1.f7014a = false;
                } else {
                    C1450w1.f7014a = true;
                }
                if (jb.getRolles() == null || jb.getRolles().size() < 20 || !jb.getRolles().get(18).equals((short) 1)) {
                    C1450w1.f7024c = false;
                    C1450w1.f7029e = null;
                } else {
                    C1450w1.f7024c = true;
                    C1450w1.f7007a = jb.getMpUserDetailsDTO();
                    C1450w1.f7029e = jb.getMpPhoto();
                }
                if (jb.getRolles() != null && jb.getRolles().size() >= 21) {
                    jb.getRolles().get(21).equals((short) 1);
                }
                if (jb.getKycMode() != 0) {
                    C1450w1.a = jb.getKycMode();
                }
                if (jb.getKycDocToken() != null) {
                    C1450w1.f7031f = jb.getKycDocToken();
                }
                if (jb.getRolles() == null || jb.getRolles().size() < 24 || !jb.getRolles().get(23).equals((short) 1) || C1450w1.f7027d.isEmpty()) {
                    C1450w1.f7028d = false;
                } else {
                    C1450w1.f7028d = true;
                }
                Bw e3 = Bw.e(loginWaitActivity.getApplicationContext());
                if (!jb.getVerified().booleanValue()) {
                    new Handler().postDelayed(new Oi(this, jb), 3000);
                } else {
                    e3.x(jb.getFirstName());
                    e3.z(jb.getLastName());
                    e3.D(jb.getEmail());
                    e3.F(jb.getMobile());
                    e3.E(jb.getUserId().longValue());
                    if (jb.getIsdCode() == null || jb.getIsdCode().intValue() != 0) {
                        C0535I5.d = jb.getIsdCode().intValue();
                    } else {
                        C0535I5.d = 91;
                    }
                    if (!loginWaitActivity.f4227a || loginWaitActivity.f4230d) {
                        if (!loginWaitActivity.b) {
                            if (!loginWaitActivity.f4230d) {
                                new Handler().postDelayed(new Ri(this), 3000);
                            }
                        }
                        new Handler().postDelayed(new Qi(this, jb), 3000);
                    } else {
                        new Handler().postDelayed(new Pi(this, jb), 3000);
                    }
                }
            }
        } catch (Exception e4) {
            int i3 = LoginWaitActivity.d;
            e4.getMessage();
            loginWaitActivity.finish();
        }
        if (jb.getUserConfigurablesDTOs() != null) {
            C1450w1.f7017b = jb.getUserConfigurablesDTOs();
        }
        if (jb.getSoftBankList() != null && jb.getSoftBankList().size() > 0) {
            C1450w1.f7022c = jb.getSoftBankList();
        }
        int i4 = LoginWaitActivity.d;
    }
}
