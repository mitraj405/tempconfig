package androidx.media;

public class AudioAttributesCompatParcelizer {
    public static AudioAttributesCompat read(C0177eC eCVar) {
        AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat();
        Object obj = audioAttributesCompat.f2220a;
        if (eCVar.h(1)) {
            obj = eCVar.n();
        }
        audioAttributesCompat.f2220a = (AudioAttributesImpl) obj;
        return audioAttributesCompat;
    }

    public static void write(AudioAttributesCompat audioAttributesCompat, C0177eC eCVar) {
        eCVar.getClass();
        AudioAttributesImpl audioAttributesImpl = audioAttributesCompat.f2220a;
        eCVar.o(1);
        eCVar.w(audioAttributesImpl);
    }
}
