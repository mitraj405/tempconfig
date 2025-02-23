package defpackage;

import android.content.ClipData;
import android.content.ClipDescription;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.f;
import defpackage.Yf;

/* renamed from: Wf  reason: default package */
/* compiled from: InputConnectionCompat */
public final class Wf extends InputConnectionWrapper {
    public final /* synthetic */ Xf a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Wf(InputConnection inputConnection, Vf vf) {
        super(inputConnection, false);
        this.a = vf;
    }

    public final boolean commitContent(InputContentInfo inputContentInfo, int i, Bundle bundle) {
        Yf yf;
        Bundle bundle2;
        ContentInfoCompat.b bVar;
        if (inputContentInfo == null) {
            yf = null;
        } else {
            yf = new Yf(new Yf.a(inputContentInfo));
        }
        View view = (View) ((Vf) this.a).f600a;
        boolean z = false;
        if ((i & 1) != 0) {
            try {
                ((Yf.a) yf.a).b();
                Parcelable parcelable = (Parcelable) ((Yf.a) yf.a).a();
                if (bundle == null) {
                    bundle2 = new Bundle();
                } else {
                    bundle2 = new Bundle(bundle);
                }
                bundle2.putParcelable("androidx.core.view.extra.INPUT_CONTENT_INFO", parcelable);
            } catch (Exception unused) {
            }
        } else {
            bundle2 = bundle;
        }
        ClipDescription description = ((Yf.a) yf.a).a.getDescription();
        Yf.a aVar = (Yf.a) yf.a;
        ClipData clipData = new ClipData(description, new ClipData.Item(aVar.a.getContentUri()));
        if (Build.VERSION.SDK_INT >= 31) {
            bVar = new ContentInfoCompat.a(clipData, 2);
        } else {
            bVar = new ContentInfoCompat.c(clipData, 2);
        }
        bVar.b(aVar.a.getLinkUri());
        bVar.setExtras(bundle2);
        if (f.k(view, bVar.a()) == null) {
            z = true;
        }
        if (z) {
            return true;
        }
        return super.commitContent(inputContentInfo, i, bundle);
    }
}
