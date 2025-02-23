package defpackage;

import android.media.session.MediaSessionManager;

/* renamed from: Sk  reason: default package */
/* compiled from: MediaSessionManagerImplApi28 */
public final class Sk extends Tk {
    public Sk(String str, int i, int i2) {
        super(str, i, i2);
        new MediaSessionManager.RemoteUserInfo(str, i, i2);
    }

    public Sk(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        super(remoteUserInfo.getPackageName(), remoteUserInfo.getPid(), remoteUserInfo.getUid());
    }
}
