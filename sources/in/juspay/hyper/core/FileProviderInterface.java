package in.juspay.hyper.core;

import android.content.Context;

public interface FileProviderInterface {
    String readFromFile(Context context, String str);

    void renewFile(String str, String str2, long j);
}
