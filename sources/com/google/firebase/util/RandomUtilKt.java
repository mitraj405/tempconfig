package com.google.firebase.util;

import androidx.datastore.preferences.core.MutablePreferences;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.random.Random;

/* compiled from: RandomUtil.kt */
public final class RandomUtilKt {
    private static final String ALPHANUMERIC_ALPHABET = "23456789abcdefghjkmnpqrstvwxyz";

    public static final String nextAlphanumericString(Random random, int i) {
        boolean z;
        C1112fg fgVar;
        boolean z2;
        C1177ig.f(random, "<this>");
        if (i >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (i <= Integer.MIN_VALUE) {
                fgVar = C1112fg.a;
            } else {
                fgVar = new C1112fg(0, i - 1);
            }
            ArrayList arrayList = new ArrayList(C1418u5.W(fgVar));
            Iterator it = fgVar.iterator();
            while (((C1091eg) it).a) {
                ((C0823cg) it).nextInt();
                if (ALPHANUMERIC_ALPHABET.length() == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    arrayList.add(Character.valueOf(ALPHANUMERIC_ALPHABET.charAt(random.c(ALPHANUMERIC_ALPHABET.length()))));
                } else {
                    throw new NoSuchElementException("Char sequence is empty.");
                }
            }
            return C1472x5.Z(arrayList, "", (String) null, (String) null, (MutablePreferences.a) null, 62);
        }
        throw new IllegalArgumentException(lf.h("invalid length: ", i).toString());
    }

    private static /* synthetic */ void getALPHANUMERIC_ALPHABET$annotations() {
    }
}
