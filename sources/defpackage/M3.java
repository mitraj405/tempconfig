package defpackage;

import android.hardware.Camera;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

/* renamed from: M3  reason: default package */
/* compiled from: CameraConfigurationUtils */
public final class M3 {
    public static final /* synthetic */ int a = 0;

    static {
        Pattern.compile(";");
    }

    public static String a(List list, String... strArr) {
        Arrays.toString(strArr);
        Objects.toString(list);
        if (list == null) {
            return null;
        }
        for (String str : strArr) {
            if (list.contains(str)) {
                return str;
            }
        }
        return null;
    }

    public static void b(Camera.Parameters parameters, boolean z) {
        String str;
        List<String> supportedFlashModes = parameters.getSupportedFlashModes();
        if (z) {
            str = a(supportedFlashModes, "torch", "on");
        } else {
            str = a(supportedFlashModes, "off");
        }
        if (str != null && !str.equals(parameters.getFlashMode())) {
            parameters.setFlashMode(str);
        }
    }
}
