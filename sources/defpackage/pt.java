package defpackage;

import android.app.RemoteInput;
import android.os.Build;
import android.os.Bundle;

/* renamed from: pt  reason: default package */
/* compiled from: RemoteInput */
public final class pt {

    /* renamed from: pt$a */
    /* compiled from: RemoteInput */
    public static class a {
        public static int a(Object obj) {
            return ((RemoteInput) obj).getEditChoicesBeforeSending();
        }

        public static RemoteInput.Builder b(RemoteInput.Builder builder, int i) {
            return builder.setEditChoicesBeforeSending(i);
        }
    }

    public static RemoteInput a(pt ptVar) {
        ptVar.getClass();
        RemoteInput.Builder addExtras = new RemoteInput.Builder((String) null).setLabel((CharSequence) null).setChoices((CharSequence[]) null).setAllowFreeFormInput(false).addExtras((Bundle) null);
        if (Build.VERSION.SDK_INT >= 29) {
            a.b(addExtras, 0);
        }
        return addExtras.build();
    }
}
