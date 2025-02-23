package androidx.media;

import android.media.AudioAttributes;

public class AudioAttributesImplApi21Parcelizer {
    public static AudioAttributesImplApi21 read(C0177eC eCVar) {
        AudioAttributesImplApi21 audioAttributesImplApi21 = new AudioAttributesImplApi21();
        audioAttributesImplApi21.f2221a = (AudioAttributes) eCVar.l(audioAttributesImplApi21.f2221a, 1);
        audioAttributesImplApi21.a = eCVar.j(audioAttributesImplApi21.a, 2);
        return audioAttributesImplApi21;
    }

    public static void write(AudioAttributesImplApi21 audioAttributesImplApi21, C0177eC eCVar) {
        eCVar.getClass();
        AudioAttributes audioAttributes = audioAttributesImplApi21.f2221a;
        eCVar.o(1);
        eCVar.u(audioAttributes);
        eCVar.t(audioAttributesImplApi21.a, 2);
    }
}
