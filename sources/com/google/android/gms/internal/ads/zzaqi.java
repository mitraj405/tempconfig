package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzaqi extends zzapv {
    public zzaqi() {
        throw null;
    }

    public zzaqi(zzaqh zzaqh, SSLSocketFactory sSLSocketFactory) {
    }

    public static List zza(Map map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getKey() != null) {
                for (String zzaoz : (List) entry.getValue()) {
                    arrayList.add(new zzaoz((String) entry.getKey(), zzaoz));
                }
            }
        }
        return arrayList;
    }
}
