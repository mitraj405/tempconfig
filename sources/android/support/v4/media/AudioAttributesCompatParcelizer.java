package android.support.v4.media;

import androidx.media.AudioAttributesCompat;

public final class AudioAttributesCompatParcelizer extends androidx.media.AudioAttributesCompatParcelizer {
    public static AudioAttributesCompat read(C0177eC eCVar) {
        return androidx.media.AudioAttributesCompatParcelizer.read(eCVar);
    }

    public static void write(AudioAttributesCompat audioAttributesCompat, C0177eC eCVar) {
        androidx.media.AudioAttributesCompatParcelizer.write(audioAttributesCompat, eCVar);
    }
}
