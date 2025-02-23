package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import defpackage.C0614Nv;

/* renamed from: Bw  reason: default package */
/* compiled from: SharedPreference */
public final class Bw {
    public static Bw a;

    /* renamed from: a  reason: collision with other field name */
    public final C0614Nv f3534a;

    /* renamed from: a  reason: collision with other field name */
    public final Context f3535a;

    public Bw(Context context) {
        this.f3535a = context;
        this.f3534a = new C0614Nv(context);
    }

    public static Bw e(Context context) {
        if (a == null) {
            if (context == null) {
                return null;
            }
            a = new Bw(context);
        }
        return a;
    }

    public final void A(String str) {
        C0614Nv.a c = this.f3534a.edit();
        c.putString("iniciarsesion", str);
        c.commit();
    }

    public final void B(String str) {
        C0614Nv.a c = this.f3534a.edit();
        c.putString("contrasena", str);
        c.commit();
    }

    public final void C(String str) {
        C0614Nv.a c = this.f3534a.edit();
        c.putString("alfiler", str);
        c.commit();
    }

    public final void D(String str) {
        C0614Nv.a c = this.f3534a.edit();
        c.putString("woieurowei", str);
        c.commit();
    }

    public final void E(long j) {
        C0614Nv.a c = this.f3534a.edit();
        c.putLong("fjieiej", j);
        c.commit();
    }

    public final void F(String str) {
        C0614Nv.a c = this.f3534a.edit();
        c.putString("xcmnxc", str);
        c.commit();
    }

    public final String a() {
        return this.f3534a.getString("DMRCIrStationList", "");
    }

    public final String b() {
        return this.f3534a.getString("DMRCStationList", "");
    }

    public final String c() {
        return this.f3534a.getString("Off", "");
    }

    public final String d() {
        return this.f3534a.getString("slghf", "");
    }

    public final String f() {
        return this.f3534a.getString("jhff", "");
    }

    public final String g() {
        return this.f3534a.getString("slthf", "");
    }

    public final String h() {
        return this.f3534a.getString("iniciarsesion", "");
    }

    public final String i() {
        return this.f3534a.getString("hash", "");
    }

    public final String j() {
        return this.f3534a.getString("woieurowei", "");
    }

    public final String k() {
        return this.f3534a.getString("xcmnxc", "");
    }

    public final String l() {
        return this.f3534a.getString("maxAsBerthKey", "-1");
    }

    public final String m() {
        return this.f3534a.getString("maxCbBerthKey", "-1");
    }

    public final String n() {
        return this.f3534a.getString("maxCpBerthKey", "-1");
    }

    public final String o() {
        return this.f3534a.getString("maxHbBerthKey", "-1");
    }

    public final String p() {
        return this.f3534a.getString("maxLbBerthKey", "-1");
    }

    public final String q() {
        return this.f3534a.getString("maxMbBerthKey", "-1");
    }

    public final String r() {
        return this.f3534a.getString("maxSlBerthKey", "-1");
    }

    public final String s() {
        return this.f3534a.getString("maxSmBerthKey", "-1");
    }

    public final String t() {
        return this.f3534a.getString("maxSuBerthKey", "-1");
    }

    public final String u() {
        return this.f3534a.getString("maxUbBerthKey", "-1");
    }

    public final String v() {
        return this.f3534a.getString("maxWsBerthKey", "-1");
    }

    public final void w(String str) {
        C0614Nv nv = this.f3534a;
        nv.getClass();
        SharedPreferences.Editor edit = nv.a.edit();
        edit.putString(C0614Nv.e("Off"), C0614Nv.a(nv, str));
        edit.commit();
    }

    public final void x(String str) {
        C0614Nv.a c = this.f3534a.edit();
        c.putString("slghf", str);
        c.commit();
    }

    public final void y(String str) {
        C0614Nv nv = this.f3534a;
        nv.getClass();
        SharedPreferences.Editor edit = nv.a.edit();
        edit.putString(C0614Nv.e("jhff"), C0614Nv.a(nv, str));
        edit.commit();
    }

    public final void z(String str) {
        C0614Nv.a c = this.f3534a.edit();
        c.putString("slthf", str);
        c.commit();
    }
}
