package cris.org.in.ima.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import com.google.android.gms.common.Scopes;
import com.momagic.C0835h;
import com.paytm.pgsdk.sdknative.LoginActivity;
import cris.org.in.ima.IrctcImaApplication;
import cris.org.in.ima.utils.TicketHistoryUtil;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.InformationMessageDTO;
import defpackage.C0614Nv;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import rx.Subscriber;

/* compiled from: LoginWaitActivity */
public final class w extends Subscriber<JB> {
    public final /* synthetic */ LoginWaitActivity a;

    public w(LoginWaitActivity loginWaitActivity) {
        this.a = loginWaitActivity;
    }

    public final void onCompleted() {
        int i = LoginWaitActivity.d;
        AlertDialog alertDialog = C0535I5.f3619a;
    }

    public final void onError(Throwable th) {
        this.a.a.dismiss();
        int i = LoginWaitActivity.d;
        xx.S(th, true, th);
    }

    public final void onNext(Object obj) {
        JB jb = (JB) obj;
        LoginWaitActivity loginWaitActivity = this.a;
        if (jb != null) {
            try {
                loginWaitActivity.a.dismiss();
                if (jb.getError() != null) {
                    loginWaitActivity.otpInput.setText("");
                    C0535I5.m(this.a, false, jb.getError(), loginWaitActivity.getString(R.string.error), loginWaitActivity.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                    loginWaitActivity.a.dismiss();
                    return;
                }
                Bw e = Bw.e(loginWaitActivity.getApplicationContext());
                jb.getServerId();
                jb.getUserName();
                if (jb.getUserEnableState() != null) {
                    C1450w1.f7013a = jb.getUserEnableState().shortValue();
                }
                if (jb.getGender() != null) {
                    C1450w1.f7021c = jb.getGender();
                }
                if (jb.getAadhaarReverifyFlag() != null) {
                    Boolean aadhaarReverifyFlag = jb.getAadhaarReverifyFlag();
                    C1408tl tlVar = C1450w1.f7012a;
                    C1450w1.f7019b = aadhaarReverifyFlag.booleanValue();
                }
                if (jb.getErsTktSendEmailFlag() == 0 || jb.getErsTktSendEmailFlag() == 1) {
                    C1450w1.d = jb.getErsTktSendEmailFlag();
                }
                if (jb.getErsTktDownloadFlag() == 0 || jb.getErsTktDownloadFlag() == 1) {
                    C1450w1.c = jb.getErsTktDownloadFlag();
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
                if (jb.getUserIdHash() != null) {
                    try {
                        C1450w1.f7026d = jb.getUserIdHash();
                        String userIdHash = jb.getUserIdHash();
                        C0614Nv.a c = e.f3534a.edit();
                        c.putString("sdflkjl", userIdHash);
                        c.commit();
                        C0835h.k(jb.getUserIdHash());
                    } catch (Exception e2) {
                        int i = LoginWaitActivity.d;
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
                C1450w1.f7012a = jb.getMobileAppConfigDTO();
                if (jb.getFevJourney() != null) {
                    C1450w1.f7030e = jb.getFevJourney().booleanValue();
                }
                if (jb.getMasterList() != null) {
                    C1450w1.b = jb.getMasterList().intValue();
                }
                TicketHistoryUtil.f5371a = null;
                C0494EB eb = C1450w1.f7006a;
                eb.a = jb.getRdsFlag().intValue();
                eb.b = jb.getRenewFlag().intValue();
                eb.f3576a = jb.getVerified().booleanValue();
                eb.f3577b = jb.geteWalletExpireFlag().booleanValue();
                eb.f3575a = jb.getUserEnableState().shortValue();
                jb.getRecentTransactionsFlag();
                AlertDialog alertDialog = C0535I5.f3619a;
                jb.getRecentTransactionsList();
                int i2 = LoginWaitActivity.d;
                eb.toString();
                TicketHistoryUtil.c();
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
                } else {
                    C1450w1.f7024c = true;
                    C1450w1.f7007a = jb.getMpUserDetailsDTO();
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
                if (!jb.getVerified().booleanValue()) {
                    Intent intent = new Intent(loginWaitActivity, UserVerificationActivity.class);
                    intent.putExtra(Scopes.EMAIL, jb.getEmail());
                    intent.putExtra("isd", jb.getIsdCode());
                    intent.putExtra(LoginActivity.MOBILE_KEY, jb.getMobile());
                    intent.putExtra("userName", jb.getUserName());
                    intent.putExtra("emailVerified", jb.getEmailVerified());
                    intent.putExtra("mobileVerified", jb.getMobileVerified());
                    intent.putExtra("gender", jb.getGender());
                    intent.putExtra("age", jb.getDob());
                    intent.putExtra("isDashBoardLanding", loginWaitActivity.c);
                    loginWaitActivity.finish();
                    loginWaitActivity.startActivity(intent);
                    int i3 = LoginWaitActivity.d;
                }
                e.x(jb.getFirstName());
                e.z(jb.getLastName());
                e.D(jb.getEmail());
                e.F(jb.getMobile());
                e.E(jb.getUserId().longValue());
                if (jb.getIsdCode() == null || jb.getIsdCode().intValue() != 0) {
                    C0535I5.d = jb.getIsdCode().intValue();
                } else {
                    C0535I5.d = 91;
                }
                boolean z = loginWaitActivity.f4227a;
                C0793b1 b1Var = C0793b1.a;
                if (z) {
                    b1Var.f3909a.b(jb.getUserName(), jb.getTimeStamp());
                    Intent intent2 = new Intent(loginWaitActivity, PinGenerationActivity.class);
                    intent2.putExtra("isDashBoardLanding", loginWaitActivity.c);
                    loginWaitActivity.finish();
                    loginWaitActivity.startActivity(intent2);
                } else if (loginWaitActivity.b) {
                    Intent intent3 = new Intent(loginWaitActivity, HomeActivity.class);
                    C0582Li li = b1Var.f3909a;
                    String a2 = li.a(jb.getUserName());
                    if (a2 != null && a2.length() > 0) {
                        intent3.putExtra("last_login", a2);
                    }
                    intent3.putExtra("isDashBoardLanding", loginWaitActivity.c);
                    C0535I5.f3616a.a = jb.getShowLastTxn();
                    C0535I5.f3616a.f3653a = jb.getLastTxnId();
                    C0535I5.f3616a.f3654a = jb.getLastTxnStatus();
                    C0535I5.f3616a.f3655a = jb.getLastTxnTimeStamp();
                    li.b(jb.getUserName(), jb.getTimeStamp());
                    loginWaitActivity.finish();
                    if (loginWaitActivity.c == 0) {
                        loginWaitActivity.startActivity(intent3);
                    }
                }
                int i32 = LoginWaitActivity.d;
            } catch (Exception e3) {
                int i4 = LoginWaitActivity.d;
                e3.getMessage();
                loginWaitActivity.a.dismiss();
            }
        }
    }
}
