package cris.org.in.ima;

import android.app.AlertDialog;
import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;

public class NLPCaptchaWebView extends WebView {
    public final Context a;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;

    static {
        C1354qp.R(NLPCaptchaWebView.class);
    }

    public NLPCaptchaWebView(Context context) {
        this(context, (AttributeSet) null);
    }

    public String getAge() {
        return this.c;
    }

    public String getArrivalDate() {
        return this.h;
    }

    public String getDepartureDate() {
        return this.g;
    }

    public String getDestination() {
        return this.f;
    }

    public String getGender() {
        return this.d;
    }

    public String getQuata() {
        return this.l;
    }

    public String getSource() {
        return this.e;
    }

    public String getStatus() {
        return this.k;
    }

    public String getTrainType() {
        return this.j;
    }

    public String getjClass() {
        return this.i;
    }

    public void setAge(String str) {
        this.c = str;
    }

    public void setArrivalDate(String str) {
        this.h = str;
    }

    public void setDepartureDate(String str) {
        this.g = str;
    }

    public void setDestination(String str) {
        this.f = str;
    }

    public void setGender(String str) {
        this.d = str;
    }

    public void setQuata(String str) {
        this.l = str;
    }

    public void setSource(String str) {
        this.e = str;
    }

    public void setStatus(String str) {
        this.k = str;
    }

    public void setTrainType(String str) {
        this.j = str;
    }

    public void setjClass(String str) {
        this.i = str;
    }

    public NLPCaptchaWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = context;
        AlertDialog alertDialog = C0535I5.f3619a;
    }
}
