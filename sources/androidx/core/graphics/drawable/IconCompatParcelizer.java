package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Parcelable;
import java.nio.charset.Charset;

public class IconCompatParcelizer {
    public static IconCompat read(C0177eC eCVar) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.a = eCVar.j(iconCompat.a, 1);
        byte[] bArr = iconCompat.f1783a;
        if (eCVar.h(2)) {
            bArr = eCVar.f();
        }
        iconCompat.f1783a = bArr;
        iconCompat.f1780a = eCVar.l(iconCompat.f1780a, 3);
        iconCompat.f1784b = eCVar.j(iconCompat.f1784b, 4);
        iconCompat.c = eCVar.j(iconCompat.c, 5);
        iconCompat.f1778a = (ColorStateList) eCVar.l(iconCompat.f1778a, 6);
        String str = iconCompat.f1782a;
        if (eCVar.h(7)) {
            str = eCVar.m();
        }
        iconCompat.f1782a = str;
        String str2 = iconCompat.f1785b;
        if (eCVar.h(8)) {
            str2 = eCVar.m();
        }
        iconCompat.f1785b = str2;
        iconCompat.f1779a = PorterDuff.Mode.valueOf(iconCompat.f1782a);
        switch (iconCompat.a) {
            case -1:
                Parcelable parcelable = iconCompat.f1780a;
                if (parcelable != null) {
                    iconCompat.f1781a = parcelable;
                    break;
                } else {
                    throw new IllegalArgumentException("Invalid icon");
                }
            case 1:
            case 5:
                Parcelable parcelable2 = iconCompat.f1780a;
                if (parcelable2 == null) {
                    byte[] bArr2 = iconCompat.f1783a;
                    iconCompat.f1781a = bArr2;
                    iconCompat.a = 3;
                    iconCompat.f1784b = 0;
                    iconCompat.c = bArr2.length;
                    break;
                } else {
                    iconCompat.f1781a = parcelable2;
                    break;
                }
            case 2:
            case 4:
            case 6:
                String str3 = new String(iconCompat.f1783a, Charset.forName("UTF-16"));
                iconCompat.f1781a = str3;
                if (iconCompat.a == 2 && iconCompat.f1785b == null) {
                    iconCompat.f1785b = str3.split(":", -1)[0];
                    break;
                }
            case 3:
                iconCompat.f1781a = iconCompat.f1783a;
                break;
        }
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, C0177eC eCVar) {
        eCVar.getClass();
        iconCompat.f1782a = iconCompat.f1779a.name();
        switch (iconCompat.a) {
            case -1:
                iconCompat.f1780a = (Parcelable) iconCompat.f1781a;
                break;
            case 1:
            case 5:
                iconCompat.f1780a = (Parcelable) iconCompat.f1781a;
                break;
            case 2:
                iconCompat.f1783a = ((String) iconCompat.f1781a).getBytes(Charset.forName("UTF-16"));
                break;
            case 3:
                iconCompat.f1783a = (byte[]) iconCompat.f1781a;
                break;
            case 4:
            case 6:
                iconCompat.f1783a = iconCompat.f1781a.toString().getBytes(Charset.forName("UTF-16"));
                break;
        }
        int i = iconCompat.a;
        if (-1 != i) {
            eCVar.t(i, 1);
        }
        byte[] bArr = iconCompat.f1783a;
        if (bArr != null) {
            eCVar.o(2);
            eCVar.q(bArr);
        }
        Parcelable parcelable = iconCompat.f1780a;
        if (parcelable != null) {
            eCVar.o(3);
            eCVar.u(parcelable);
        }
        int i2 = iconCompat.f1784b;
        if (i2 != 0) {
            eCVar.t(i2, 4);
        }
        int i3 = iconCompat.c;
        if (i3 != 0) {
            eCVar.t(i3, 5);
        }
        ColorStateList colorStateList = iconCompat.f1778a;
        if (colorStateList != null) {
            eCVar.o(6);
            eCVar.u(colorStateList);
        }
        String str = iconCompat.f1782a;
        if (str != null) {
            eCVar.o(7);
            eCVar.v(str);
        }
        String str2 = iconCompat.f1785b;
        if (str2 != null) {
            eCVar.o(8);
            eCVar.v(str2);
        }
    }
}
