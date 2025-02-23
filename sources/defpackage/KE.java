package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Timer;

/* renamed from: KE  reason: default package */
public class KE {
    public static final Locale a = Locale.US;

    /* renamed from: a  reason: collision with other field name */
    public int f337a = 0;

    /* renamed from: a  reason: collision with other field name */
    public long f338a;

    /* renamed from: a  reason: collision with other field name */
    public String f339a;

    /* renamed from: a  reason: collision with other field name */
    public ArrayList<String> f340a = new ArrayList<>();
    public int b = 0;

    /* renamed from: b  reason: collision with other field name */
    public long f341b;

    /* renamed from: b  reason: collision with other field name */
    public String f342b;

    /* renamed from: b  reason: collision with other field name */
    public ArrayList<Long> f343b = new ArrayList<>();
    public int c = -1;

    /* renamed from: c  reason: collision with other field name */
    public long f344c;

    /* renamed from: c  reason: collision with other field name */
    public String f345c;

    /* renamed from: c  reason: collision with other field name */
    public ArrayList<Integer> f346c = new ArrayList<>();
    public int d;

    /* renamed from: d  reason: collision with other field name */
    public long f347d;

    /* renamed from: d  reason: collision with other field name */
    public String f348d = "";
    public int e;

    /* renamed from: e  reason: collision with other field name */
    public long f349e;

    /* renamed from: e  reason: collision with other field name */
    public String f350e = "";
    public long f;

    static {
        new KE();
    }

    public final void b(int i, long j) {
        new Timer().schedule(new IE(this, i), j);
    }

    public void c() {
        C1488xu.e(6, "PoW", "Error: ".concat("Get Params error"), new Throwable[0]);
    }

    public final void d() {
        this.d = 0;
        this.e = 0;
        this.f340a = new ArrayList<>();
        this.f343b = new ArrayList<>();
        this.f346c = new ArrayList<>();
        i();
    }

    public final void e(int i) {
        synchronized (this) {
            this.f337a = i;
        }
    }

    public final void f() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f348d);
        sb.append(";");
        Iterator<String> it = this.f340a.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(";");
        Iterator<Long> it2 = this.f343b.iterator();
        while (it2.hasNext()) {
            sb.append(it2.next());
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(";");
        Iterator<Integer> it3 = this.f346c.iterator();
        while (it3.hasNext()) {
            sb.append(it3.next());
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        synchronized (this) {
            this.f350e = sb.toString();
        }
        C1488xu.f("PoW", "PoW Data: " + this.f350e, new Throwable[0]);
        C1488xu.f("PoW", "Time taken to solve PoW challenge: " + (SystemClock.uptimeMillis() - this.f349e) + "ms", new Throwable[0]);
    }

    public String g() {
        return "null/_bm/get_params?type=sdk-pow";
    }

    public void h() {
        LE le = LE.a;
        String str = this.f350e;
        synchronized (le) {
            Context context = le.f386a.get();
            if (context == null) {
                C1488xu.g("SensorDataCache", "savePoWResponse: Context is null", new Throwable[0]);
                return;
            }
            SharedPreferences.Editor edit = context.getSharedPreferences("com.akamai.botman.preferences", 0).edit();
            edit.putString("pow_response", str);
            edit.commit();
        }
    }

    public void i() {
    }

    public void a(int i) {
    }
}
