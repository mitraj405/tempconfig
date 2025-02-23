package com.google.firebase.platforminfo;

public final class KotlinDetector {
    private KotlinDetector() {
    }

    public static String detectVersion() {
        try {
            return Ih.a.toString();
        } catch (NoClassDefFoundError unused) {
            return null;
        }
    }
}
