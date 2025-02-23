package androidx.media;

import android.media.AudioAttributes;

public class AudioAttributesImplApi21 implements AudioAttributesImpl {
    public int a = -1;

    /* renamed from: a  reason: collision with other field name */
    public AudioAttributes f2221a;

    public AudioAttributesImplApi21() {
    }

    public final int a() {
        int i = this.a;
        if (i != -1) {
            return i;
        }
        return AudioAttributesCompat.b(this.f2221a.getFlags(), this.f2221a.getUsage());
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesImplApi21)) {
            return false;
        }
        return this.f2221a.equals(((AudioAttributesImplApi21) obj).f2221a);
    }

    public final int hashCode() {
        return this.f2221a.hashCode();
    }

    public final String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.f2221a;
    }

    public AudioAttributesImplApi21(AudioAttributes audioAttributes) {
        this.f2221a = audioAttributes;
    }
}
