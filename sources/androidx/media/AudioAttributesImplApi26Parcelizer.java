package androidx.media;

import android.media.AudioAttributes;

public class AudioAttributesImplApi26Parcelizer {
    public static AudioAttributesImplApi26 read(C0177eC eCVar) {
        AudioAttributesImplApi26 audioAttributesImplApi26 = new AudioAttributesImplApi26();
        audioAttributesImplApi26.f2221a = (AudioAttributes) eCVar.l(audioAttributesImplApi26.f2221a, 1);
        audioAttributesImplApi26.a = eCVar.j(audioAttributesImplApi26.a, 2);
        return audioAttributesImplApi26;
    }

    public static void write(AudioAttributesImplApi26 audioAttributesImplApi26, C0177eC eCVar) {
        eCVar.getClass();
        AudioAttributes audioAttributes = audioAttributesImplApi26.f2221a;
        eCVar.o(1);
        eCVar.u(audioAttributes);
        eCVar.t(audioAttributesImplApi26.a, 2);
    }
}
