package androidx.media;

public class AudioAttributesImplBaseParcelizer {
    public static AudioAttributesImplBase read(C0177eC eCVar) {
        AudioAttributesImplBase audioAttributesImplBase = new AudioAttributesImplBase();
        audioAttributesImplBase.a = eCVar.j(audioAttributesImplBase.a, 1);
        audioAttributesImplBase.b = eCVar.j(audioAttributesImplBase.b, 2);
        audioAttributesImplBase.c = eCVar.j(audioAttributesImplBase.c, 3);
        audioAttributesImplBase.d = eCVar.j(audioAttributesImplBase.d, 4);
        return audioAttributesImplBase;
    }

    public static void write(AudioAttributesImplBase audioAttributesImplBase, C0177eC eCVar) {
        eCVar.getClass();
        eCVar.t(audioAttributesImplBase.a, 1);
        eCVar.t(audioAttributesImplBase.b, 2);
        eCVar.t(audioAttributesImplBase.c, 3);
        eCVar.t(audioAttributesImplBase.d, 4);
    }
}
