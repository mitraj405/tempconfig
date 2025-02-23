package defpackage;

import android.media.MediaPlayer;
import com.google.zxing.client.android.BeepManager;

/* renamed from: J2  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class J2 implements MediaPlayer.OnErrorListener {
    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        return BeepManager.lambda$playBeepSound$1(mediaPlayer, i, i2);
    }
}
