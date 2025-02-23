package defpackage;

import android.os.SystemClock;
import com.google.common.primitives.UnsignedBytes;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: JE  reason: default package */
public final class JE extends TimerTask {
    public final /* synthetic */ KE a;
    public final /* synthetic */ int c;

    /* renamed from: JE$a */
    public class a implements Runnable {
        public a() {
        }

        public final void run() {
            int i;
            char c;
            JE je = JE.this;
            KE ke = je.a;
            if (ke.f337a == 2) {
                ke.d();
                return;
            }
            String str = null;
            String str2 = "PoW";
            C1488xu.e(4, str2, "computeProofOfWork, Challenge Count: " + ke.d, new Throwable[0]);
            try {
                long uptimeMillis = SystemClock.uptimeMillis();
                long j = ke.f341b + ((long) ke.d);
                Random random = new Random();
                DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(KE.a);
                decimalFormat.applyPattern("#.############");
                boolean z = false;
                long j2 = 0;
                while (true) {
                    i = je.c;
                    if (z) {
                        String str3 = str2;
                        break;
                    }
                    String str4 = str2;
                    try {
                        String format = decimalFormat.format(random.nextDouble());
                        String str5 = ke.f345c + j + format;
                        MessageDigest instance = MessageDigest.getInstance("SHA-256");
                        instance.update(str5.getBytes());
                        byte[] digest = instance.digest();
                        int i2 = 0;
                        long j3 = 0;
                        while (i2 < digest.length) {
                            j3 = ((j3 << 8) | ((long) (digest[i2] & UnsignedBytes.MAX_VALUE))) % j;
                            i2++;
                            je = je;
                        }
                        JE je2 = je;
                        if (j3 != 0) {
                            str = str4;
                            c = 4;
                            int i3 = ke.e + 1;
                            ke.e = i3;
                            if (i3 % 1000 == 0) {
                                j2 = SystemClock.uptimeMillis() - uptimeMillis;
                                long j4 = ke.f347d;
                                if (j2 > j4 && ke.f337a != 2) {
                                    new Timer().schedule(new JE(ke, i), j4 + 1000);
                                    break;
                                }
                            }
                        } else {
                            long uptimeMillis2 = SystemClock.uptimeMillis();
                            j2 = uptimeMillis2 - uptimeMillis;
                            long j5 = uptimeMillis2 - ke.f;
                            str = str4;
                            c = 4;
                            try {
                                C1488xu.e(4, str, "Challenge (" + str5 + ") " + ke.d + " solved at iteration: " + ke.e + " in " + j5 + "ms", new Throwable[0]);
                                ke.f340a.add(format);
                                ke.f346c.add(Integer.valueOf(ke.e));
                                ke.f343b.add(Long.valueOf(j5));
                                z = true;
                            } catch (NoSuchAlgorithmException e) {
                                e = e;
                                C1488xu.e(6, str, "computeProofOfWork: " + e.toString(), new Throwable[0]);
                            }
                        }
                        if (ke.f337a == 2) {
                            ke.d();
                            return;
                        }
                        char c2 = c;
                        str2 = str;
                        je = je2;
                        str = null;
                    } catch (NoSuchAlgorithmException e2) {
                        e = e2;
                        str = str4;
                        C1488xu.e(6, str, "computeProofOfWork: " + e.toString(), new Throwable[0]);
                    }
                }
                if (z) {
                    ke.d++;
                    ke.f = SystemClock.uptimeMillis();
                    ke.a(ke.d);
                    if (ke.d < 10) {
                        ke.e = 0;
                        new Timer().schedule(new JE(ke, i), ke.f344c + j2);
                        return;
                    }
                    ke.e = 0;
                    ke.f();
                    ke.f340a = new ArrayList<>();
                    ke.f343b = new ArrayList<>();
                    ke.f346c = new ArrayList<>();
                    ke.e(0);
                    if (SystemClock.uptimeMillis() - ke.f349e > ke.f338a * 1000 && i == 0) {
                        ke.b(i, 100);
                    }
                    ke.h();
                }
            } catch (NoSuchAlgorithmException e3) {
                e = e3;
                str = str2;
                C1488xu.e(6, str, "computeProofOfWork: " + e.toString(), new Throwable[0]);
            }
        }
    }

    public JE(KE ke, int i) {
        this.a = ke;
        this.c = i;
    }

    public final void run() {
        new Thread(new a()).start();
    }
}
