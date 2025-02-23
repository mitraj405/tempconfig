package androidx.activity.result.contract;

import android.content.Intent;
import androidx.activity.ComponentActivity;
import androidx.activity.result.contract.ActivityResultContract;
import in.juspay.hyper.constants.LogCategory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;

/* compiled from: ActivityResultContracts.kt */
public final class a extends ActivityResultContract<String[], Map<String, Boolean>> {
    public final Intent a(ComponentActivity componentActivity, Object obj) {
        String[] strArr = (String[]) obj;
        C1177ig.f(componentActivity, LogCategory.CONTEXT);
        C1177ig.f(strArr, "input");
        Intent putExtra = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr);
        C1177ig.e(putExtra, "Intent(ACTION_REQUEST_PE…EXTRA_PERMISSIONS, input)");
        return putExtra;
    }

    public final ActivityResultContract.a b(ComponentActivity componentActivity, Object obj) {
        boolean z;
        boolean z2;
        String[] strArr = (String[]) obj;
        C1177ig.f(componentActivity, LogCategory.CONTEXT);
        C1177ig.f(strArr, "input");
        boolean z3 = true;
        if (strArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return new ActivityResultContract.a(C1497ya.a);
        }
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            if (d7.a(componentActivity, strArr[i]) == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                z3 = false;
                break;
            }
            i++;
        }
        if (!z3) {
            return null;
        }
        int H = r1.H(strArr.length);
        if (H < 16) {
            H = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(H);
        for (String put : strArr) {
            linkedHashMap.put(put, Boolean.TRUE);
        }
        return new ActivityResultContract.a(linkedHashMap);
    }

    public final Object c(int i, Intent intent) {
        boolean z;
        C1497ya yaVar = C1497ya.a;
        if (i != -1 || intent == null) {
            return yaVar;
        }
        String[] stringArrayExtra = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
        int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
        if (intArrayExtra == null || stringArrayExtra == null) {
            return yaVar;
        }
        ArrayList arrayList = new ArrayList(intArrayExtra.length);
        for (int i2 : intArrayExtra) {
            if (i2 == 0) {
                z = true;
            } else {
                z = false;
            }
            arrayList.add(Boolean.valueOf(z));
        }
        ArrayList arrayList2 = new ArrayList();
        for (String str : stringArrayExtra) {
            if (str != null) {
                arrayList2.add(str);
            }
        }
        Iterator it = arrayList2.iterator();
        Iterator it2 = arrayList.iterator();
        ArrayList arrayList3 = new ArrayList(Math.min(C1418u5.W(arrayList2), C1418u5.W(arrayList)));
        while (it.hasNext() && it2.hasNext()) {
            arrayList3.add(new Pair(it.next(), it2.next()));
        }
        return C1328pk.W(arrayList3);
    }
}
