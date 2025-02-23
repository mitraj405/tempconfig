package in.juspay.hypersdk.core;

import android.media.MediaPlayer;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class v implements MediaPlayer.OnPreparedListener {
    public final /* synthetic */ MediaPlayer a;

    public /* synthetic */ v(MediaPlayer mediaPlayer) {
        this.a = mediaPlayer;
    }

    public final void onPrepared(MediaPlayer mediaPlayer) {
        this.a.start();
    }
}
