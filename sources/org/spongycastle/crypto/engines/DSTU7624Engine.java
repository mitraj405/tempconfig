package org.spongycastle.crypto.engines;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.google.common.primitives.UnsignedBytes;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Pack;

public class DSTU7624Engine implements BlockCipher {
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f5942a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f5943a;

    /* renamed from: a  reason: collision with other field name */
    public long[] f5944a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[][] f5945a = {new byte[]{1, 1, 5, 1, 8, 6, 7, 4}, new byte[]{4, 1, 1, 5, 1, 8, 6, 7}, new byte[]{7, 4, 1, 1, 5, 1, 8, 6}, new byte[]{6, 7, 4, 1, 1, 5, 1, 8}, new byte[]{8, 6, 7, 4, 1, 1, 5, 1}, new byte[]{1, 8, 6, 7, 4, 1, 1, 5}, new byte[]{5, 1, 8, 6, 7, 4, 1, 1}, new byte[]{1, 5, 1, 8, 6, 7, 4, 1}};

    /* renamed from: a  reason: collision with other field name */
    public long[][] f5946a;
    public int b;

    /* renamed from: b  reason: collision with other field name */
    public final byte[] f5947b;

    /* renamed from: b  reason: collision with other field name */
    public long[] f5948b;

    /* renamed from: b  reason: collision with other field name */
    public final byte[][] f5949b = {new byte[]{-83, -107, 118, -88, 47, 73, -41, -54}, new byte[]{-54, -83, -107, 118, -88, 47, 73, -41}, new byte[]{-41, -54, -83, -107, 118, -88, 47, 73}, new byte[]{73, -41, -54, -83, -107, 118, -88, 47}, new byte[]{47, 73, -41, -54, -83, -107, 118, -88}, new byte[]{-88, 47, 73, -41, -54, -83, -107, 118}, new byte[]{118, -88, 47, 73, -41, -54, -83, -107}, new byte[]{-107, 118, -88, 47, 73, -41, -54, -83}};
    public int c;

    /* renamed from: c  reason: collision with other field name */
    public final byte[][] f5950c = {new byte[]{-88, 67, 95, 6, 107, 117, 108, 89, 113, -33, -121, -107, Ascii.ETB, -16, -40, 9, 109, -13, Ascii.GS, -53, -55, 77, 44, -81, 121, -32, -105, -3, 111, 75, 69, 57, 62, -35, -93, 79, -76, -74, -102, Ascii.SO, Ascii.US, -65, Ascii.NAK, -31, 73, -46, -109, -58, -110, 114, -98, 97, -47, 99, -6, -18, -12, Ascii.EM, -43, -83, 88, -92, -69, -95, -36, -14, -125, 55, 66, -28, 122, 50, -100, -52, -85, 74, -113, 110, 4, 39, 46, -25, -30, 90, -106, Ascii.SYN, 35, 43, -62, 101, 102, Ascii.SI, -68, -87, 71, 65, 52, 72, -4, -73, 106, -120, -91, 83, -122, -7, 91, -37, 56, 123, -61, Ascii.RS, 34, 51, 36, 40, 54, -57, -78, 59, -114, 119, -70, -11, Ascii.DC4, -97, 8, 85, -101, 76, -2, 96, 92, -38, Ascii.CAN, 70, -51, 125, 33, -80, 63, Ascii.ESC, -119, -1, -21, -124, 105, 58, -99, -41, -45, 112, 103, SignedBytes.MAX_POWER_OF_TWO, -75, -34, 93, 48, -111, -79, 120, 17, 1, -27, 0, 104, -104, -96, -59, 2, -90, 116, 45, Ascii.VT, -94, 118, -77, -66, -50, -67, -82, -23, -118, 49, Ascii.FS, -20, -15, -103, -108, -86, -10, 38, 47, -17, -24, -116, 53, 3, -44, Ascii.DEL, -5, 5, -63, 94, -112, 32, 61, -126, -9, -22, 10, Ascii.CR, 126, -8, 80, Ascii.SUB, -60, 7, 87, -72, 60, 98, -29, -56, -84, 82, 100, Ascii.DLE, -48, -39, 19, Ascii.FF, Ascii.DC2, 41, 81, -71, -49, -42, 115, -115, -127, 84, -64, -19, 78, 68, -89, 42, -123, 37, -26, -54, 124, -117, 86, UnsignedBytes.MAX_POWER_OF_TWO}, new byte[]{-50, -69, -21, -110, -22, -53, 19, -63, -23, 58, -42, -78, -46, -112, Ascii.ETB, -8, 66, Ascii.NAK, 86, -76, 101, Ascii.FS, -120, 67, -59, 92, 54, -70, -11, 87, 103, -115, 49, -10, 100, 88, -98, -12, 34, -86, 117, Ascii.SI, 2, -79, -33, 109, 115, 77, 124, 38, 46, -9, 8, 93, 68, 62, -97, Ascii.DC4, -56, -82, 84, Ascii.DLE, -40, -68, Ascii.SUB, 107, 105, -13, -67, 51, -85, -6, -47, -101, 104, 78, Ascii.SYN, -107, -111, -18, 76, 99, -114, 91, -52, 60, Ascii.EM, -95, -127, 73, 123, -39, 111, 55, 96, -54, -25, 43, 72, -3, -106, 69, -4, 65, Ascii.DC2, Ascii.CR, 121, -27, -119, -116, -29, 32, 48, -36, -73, 108, 74, -75, 63, -105, -44, 98, 45, 6, -92, -91, -125, 95, 42, -38, -55, 0, 126, -94, 85, -65, 17, -43, -100, -49, Ascii.SO, 10, 61, 81, 125, -109, Ascii.ESC, -2, -60, 71, 9, -122, Ascii.VT, -113, -99, 106, 7, -71, -80, -104, Ascii.CAN, 50, 113, 75, -17, 59, 112, -96, -28, SignedBytes.MAX_POWER_OF_TWO, -1, -61, -87, -26, 120, -7, -117, 70, UnsignedBytes.MAX_POWER_OF_TWO, Ascii.RS, 56, -31, -72, -88, -32, Ascii.FF, 35, 118, Ascii.GS, 37, 36, 5, -15, 110, -108, 40, -102, -124, -24, -93, 79, 119, -45, -123, -30, 82, -14, -126, 80, 122, 47, 116, 83, -77, 97, -81, 57, 53, -34, -51, Ascii.US, -103, -84, -83, 114, 44, -35, -48, -121, -66, 94, -90, -20, 4, -58, 3, 52, -5, -37, 89, -74, -62, 1, -16, 90, -19, -89, 102, 33, Ascii.DEL, -118, 39, -57, -64, 41, -41}, new byte[]{-109, -39, -102, -75, -104, 34, 69, -4, -70, 106, -33, 2, -97, -36, 81, 89, 74, Ascii.ETB, 43, -62, -108, -12, -69, -93, 98, -28, 113, -44, -51, 112, Ascii.SYN, -31, 73, 60, -64, -40, 92, -101, -83, -123, 83, -95, 122, -56, 45, -32, -47, 114, -90, 44, -60, -29, 118, 120, -73, -76, 9, 59, Ascii.SO, 65, 76, -34, -78, -112, 37, -91, -41, 3, 17, 0, -61, 46, -110, -17, 78, Ascii.DC2, -99, 125, -53, 53, Ascii.DLE, -43, 79, -98, 77, -87, 85, -58, -48, 123, Ascii.CAN, -105, -45, 54, -26, 72, 86, -127, -113, 119, -52, -100, -71, -30, -84, -72, 47, Ascii.NAK, -92, 124, -38, 56, Ascii.RS, Ascii.VT, 5, -42, Ascii.DC4, 110, 108, 126, 102, -3, -79, -27, 96, -81, 94, 51, -121, -55, -16, 93, 109, 63, -120, -115, -57, -9, Ascii.GS, -23, -20, -19, UnsignedBytes.MAX_POWER_OF_TWO, 41, 39, -49, -103, -88, 80, Ascii.SI, 55, 36, 40, 48, -107, -46, 62, 91, SignedBytes.MAX_POWER_OF_TWO, -125, -77, 105, 87, Ascii.US, 7, Ascii.FS, -118, -68, 32, -21, -50, -114, -85, -18, 49, -94, 115, -7, -54, 58, Ascii.SUB, -5, Ascii.CR, -63, -2, -6, -14, 111, -67, -106, -35, 67, 82, -74, 8, -13, -82, -66, Ascii.EM, -119, 50, 38, -80, -22, 75, 100, -124, -126, 107, -11, 121, -65, 1, 95, 117, 99, Ascii.ESC, 35, 61, 104, 42, 101, -24, -111, -10, -1, 19, 88, -15, 71, 10, Ascii.DEL, -59, -89, -25, 97, 90, 6, 70, 68, 66, 4, -96, -37, 57, -122, 84, -86, -116, 52, 33, -117, -8, Ascii.FF, 116, 103}, new byte[]{104, -115, -54, 77, 115, 75, 78, 42, -44, 82, 38, -77, 84, Ascii.RS, Ascii.EM, Ascii.US, 34, 3, 70, 61, 45, 74, 83, -125, 19, -118, -73, -43, 37, 121, -11, -67, 88, 47, Ascii.CR, 2, -19, 81, -98, 17, -14, 62, 85, 94, -47, Ascii.SYN, 60, 102, 112, 93, -13, 69, SignedBytes.MAX_POWER_OF_TWO, -52, -24, -108, 86, 8, -50, Ascii.SUB, 58, -46, -31, -33, -75, 56, 110, Ascii.SO, -27, -12, -7, -122, -23, 79, -42, -123, 35, -49, 50, -103, 49, Ascii.DC4, -82, -18, -56, 72, -45, 48, -95, -110, 65, -79, Ascii.CAN, -60, 44, 113, 114, 68, Ascii.NAK, -3, 55, -66, 95, -86, -101, -120, -40, -85, -119, -100, -6, 96, -22, -68, 98, Ascii.FF, 36, -90, -88, -20, 103, 32, -37, 124, 40, -35, -84, 91, 52, 126, Ascii.DLE, -15, 123, -113, 99, -96, 5, -102, 67, 119, 33, -65, 39, 9, -61, -97, -74, -41, 41, -62, -21, -64, -92, -117, -116, Ascii.GS, -5, -1, -63, -78, -105, 46, -8, 101, -10, 117, 7, 4, 73, 51, -28, -39, -71, -48, 66, -57, 108, -112, 0, -114, 111, 80, 1, -59, -38, 71, 63, -51, 105, -94, -30, 122, -89, -58, -109, Ascii.SI, 10, 6, -26, 43, -106, -93, Ascii.FS, -81, 106, Ascii.DC2, -124, 57, -25, -80, -126, -9, -2, -99, -121, 92, -127, 53, -34, -76, -91, -4, UnsignedBytes.MAX_POWER_OF_TWO, -17, -53, -69, 107, 118, -70, 90, 125, 120, Ascii.VT, -107, -29, -83, 116, -104, 59, 54, 100, 109, -36, -16, 89, -87, 76, Ascii.ETB, Ascii.DEL, -111, -72, -55, 87, Ascii.ESC, -32, 97}};
    public final byte[][] d = {new byte[]{-92, -94, -87, -59, 78, -55, 3, -39, 126, Ascii.SI, -46, -83, -25, -45, 39, 91, -29, -95, -24, -26, 124, 42, 85, Ascii.FF, -122, 57, -41, -115, -72, Ascii.DC2, 111, 40, -51, -118, 112, 86, 114, -7, -65, 79, 115, -23, -9, 87, Ascii.SYN, -84, 80, -64, -99, -73, 71, 113, 96, -60, 116, 67, 108, Ascii.US, -109, 119, -36, -50, 32, -116, -103, 95, 68, 1, -11, Ascii.RS, -121, 94, 97, 44, 75, Ascii.GS, -127, Ascii.NAK, -12, 35, -42, -22, -31, 103, -15, Ascii.DEL, -2, -38, 60, 7, 83, 106, -124, -100, -53, 2, -125, 51, -35, 53, -30, 89, 90, -104, -91, -110, 100, 4, 6, Ascii.DLE, 77, Ascii.FS, -105, 8, 49, -18, -85, 5, -81, 121, -96, Ascii.CAN, 70, 109, -4, -119, -44, -57, -1, -16, -49, 66, -111, -8, 104, 10, 101, -114, -74, -3, -61, -17, 120, 76, -52, -98, 48, 46, -68, Ascii.VT, 84, Ascii.SUB, -90, -69, 38, UnsignedBytes.MAX_POWER_OF_TWO, 72, -108, 50, 125, -89, 63, -82, 34, 61, 102, -86, -10, 0, 93, -67, 74, -32, 59, -76, Ascii.ETB, -117, -97, 118, -80, 36, -102, 37, 99, -37, -21, 122, 62, 92, -77, -79, 41, -14, -54, 88, 110, -40, -88, 47, 117, -33, Ascii.DC4, -5, 19, 73, -120, -78, -20, -28, 52, 45, -106, -58, 58, -19, -107, Ascii.SO, -27, -123, 107, SignedBytes.MAX_POWER_OF_TWO, 33, -101, 9, Ascii.EM, 43, 82, -34, 69, -93, -6, 81, -62, -75, -47, -112, -71, -13, 55, -63, Ascii.CR, -70, 65, 17, 56, 123, -66, -48, -43, 105, 54, -56, 98, Ascii.ESC, -126, -113}, new byte[]{-125, -14, 42, -21, -23, -65, 123, -100, 52, -106, -115, -104, -71, 105, -116, 41, 61, -120, 104, 6, 57, 17, 76, Ascii.SO, -96, 86, SignedBytes.MAX_POWER_OF_TWO, -110, Ascii.NAK, -68, -77, -36, 111, -8, 38, -70, -66, -67, 49, -5, -61, -2, UnsignedBytes.MAX_POWER_OF_TWO, 97, -31, 122, 50, -46, 112, 32, -95, 69, -20, -39, Ascii.SUB, 93, -76, -40, 9, -91, 85, -114, 55, 118, -87, 103, Ascii.DLE, Ascii.ETB, 54, 101, -79, -107, 98, 89, 116, -93, 80, 47, 75, -56, -48, -113, -51, -44, 60, -122, Ascii.DC2, Ascii.GS, 35, -17, -12, 83, Ascii.EM, 53, -26, Ascii.DEL, 94, -42, 121, 81, 34, Ascii.DC4, -9, Ascii.RS, 74, 66, -101, 65, 115, 45, -63, 92, -90, -94, -32, 46, -45, 40, -69, -55, -82, 106, -47, 90, 48, -112, -124, -7, -78, 88, -49, 126, -59, -53, -105, -28, Ascii.SYN, 108, -6, -80, 109, Ascii.US, 82, -103, Ascii.CR, 78, 3, -111, -62, 77, 100, 119, -97, -35, -60, 73, -118, -102, 36, 56, -89, 87, -123, -57, 124, 125, -25, -10, -73, -84, 39, 70, -34, -33, 59, -41, -98, 43, Ascii.VT, -43, 19, 117, -16, 114, -74, -99, Ascii.ESC, 1, 63, 68, -27, -121, -3, 7, -15, -85, -108, Ascii.CAN, -22, -4, 58, -126, 95, 5, 84, -37, 0, -117, -29, 72, Ascii.FF, -54, 120, -119, 10, -1, 62, 91, -127, -18, 113, -30, -38, 44, -72, -75, -52, 110, -88, 107, -83, 96, -58, 8, 4, 2, -24, -11, 79, -92, -13, -64, -50, 67, 37, Ascii.FS, 33, 51, Ascii.SI, -81, 71, -19, 102, 99, -109, -86}, new byte[]{69, -44, Ascii.VT, 67, -15, 114, -19, -92, -62, 56, -26, 113, -3, -74, 58, -107, 80, 68, 75, -30, 116, 107, Ascii.RS, 17, 90, -58, -76, -40, -91, -118, 112, -93, -88, -6, 5, -39, -105, SignedBytes.MAX_POWER_OF_TWO, -55, -112, -104, -113, -36, Ascii.DC2, 49, 44, 71, 106, -103, -82, -56, Ascii.DEL, -7, 79, 93, -106, 111, -12, -77, 57, 33, -38, -100, -123, -98, 59, -16, -65, -17, 6, -18, -27, 95, 32, Ascii.DLE, -52, 60, 84, 74, 82, -108, Ascii.SO, -64, 40, -10, 86, 96, -94, -29, Ascii.SI, -20, -99, 36, -125, 126, -43, 124, -21, Ascii.CAN, -41, -51, -35, 120, -1, -37, -95, 9, -48, 118, -124, 117, -69, Ascii.GS, Ascii.SUB, 47, -80, -2, -42, 52, 99, 53, -46, 42, 89, 109, 77, 119, -25, -114, 97, -49, -97, -50, 39, -11, UnsignedBytes.MAX_POWER_OF_TWO, -122, -57, -90, -5, -8, -121, -85, 98, 63, -33, 72, 0, Ascii.DC4, -102, -67, 91, 4, -110, 2, 37, 101, 76, 83, Ascii.FF, -14, 41, -81, Ascii.ETB, 108, 65, 48, -23, -109, 85, -9, -84, 104, 38, -60, 125, -54, 122, 62, -96, 55, 3, -63, 54, 105, 102, 8, Ascii.SYN, -89, -68, -59, -45, 34, -73, 19, 70, 50, -24, 87, -120, 43, -127, -78, 78, 100, Ascii.FS, -86, -111, 88, 46, -101, 92, Ascii.ESC, 81, 115, 66, 35, 1, 110, -13, Ascii.CR, -66, 61, 10, 45, Ascii.US, 103, 51, Ascii.EM, 123, 94, -22, -34, -117, -53, -87, -116, -115, -83, 73, -126, -28, -70, -61, Ascii.NAK, -47, -32, -119, -4, -79, -71, -75, 7, 121, -72, -31}, new byte[]{-78, -74, 35, 17, -89, -120, -59, -90, 57, -113, -60, -24, 115, 34, 67, -61, -126, 39, -51, Ascii.CAN, 81, 98, 45, -9, 92, Ascii.SO, 59, -3, -54, -101, Ascii.CR, Ascii.SI, 121, -116, Ascii.DLE, 76, 116, Ascii.FS, 10, -114, 124, -108, 7, -57, 94, Ascii.DC4, -95, 33, 87, 80, 78, -87, UnsignedBytes.MAX_POWER_OF_TWO, -39, -17, 100, 65, -49, 60, -18, 46, 19, 41, -70, 52, 90, -82, -118, 97, 51, Ascii.DC2, -71, 85, -88, Ascii.NAK, 5, -10, 3, 6, 73, -75, 37, 9, Ascii.SYN, Ascii.FF, 42, 56, -4, 32, -12, -27, Ascii.DEL, -41, 49, 43, 102, 111, -1, 114, -122, -16, -93, 47, 120, 0, -68, -52, -30, -80, -15, 66, -76, 48, 95, 96, 4, -20, -91, -29, -117, -25, Ascii.GS, -65, -124, 123, -26, -127, -8, -34, -40, -46, Ascii.ETB, -50, 75, 71, -42, 105, 108, Ascii.EM, -103, -102, 1, -77, -123, -79, -7, 89, -62, 55, -23, -56, -96, -19, 79, -119, 104, 109, -43, 38, -111, -121, 88, -67, -55, -104, -36, 117, -64, 118, -11, 103, 107, 126, -21, 82, -53, -47, 91, -97, Ascii.VT, -37, SignedBytes.MAX_POWER_OF_TWO, -110, Ascii.SUB, -6, -84, -28, -31, 113, Ascii.US, 101, -115, -105, -98, -107, -112, 93, -73, -63, -81, 84, -5, 2, -32, 53, -69, 58, 77, -83, 44, 61, 86, 8, Ascii.ESC, 74, -109, 106, -85, -72, 122, -14, 125, -38, 63, -2, 62, -66, -22, -86, 68, -58, -48, 54, 72, 112, -106, 119, 36, 83, -33, -13, -125, 40, 50, 69, Ascii.RS, -92, -45, -94, 70, 110, -100, -35, 99, -44, -99}};

    public DSTU7624Engine(int i) throws IllegalArgumentException {
        if (i == 128 || i == 256 || i == 512) {
            int i2 = i / 64;
            this.a = i2;
            long[] jArr = new long[i2];
            this.f5944a = jArr;
            this.f5943a = new byte[((jArr.length * 64) / 8)];
            this.f5947b = new byte[((jArr.length * 64) / 8)];
            return;
        }
        throw new IllegalArgumentException("unsupported block length: only 128/256/512 are allowed");
    }

    public static void h(long[] jArr) {
        for (int i = 0; i < jArr.length; i++) {
            jArr[i] = jArr[i] << 1;
        }
        for (int i2 = 0; i2 < jArr.length / 2; i2++) {
            long j = jArr[i2];
            jArr[i2] = jArr[(jArr.length - i2) - 1];
            jArr[(jArr.length - i2) - 1] = j;
        }
    }

    public final void a(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        CipherParameters cipherParameters2 = cipherParameters;
        if (cipherParameters2 instanceof KeyParameter) {
            this.f5942a = z;
            byte[] bArr = ((KeyParameter) cipherParameters2).a;
            int length = bArr.length * 8;
            int i = this.a;
            int i2 = i * 64;
            if (length != 128 && length != 256 && length != 512) {
                throw new IllegalArgumentException("unsupported key length: only 128/256/512 are allowed");
            } else if (i2 == 128 && length == 512) {
                throw new IllegalArgumentException("Unsupported key length");
            } else if (i2 == 256 && length == 128) {
                throw new IllegalArgumentException("Unsupported key length");
            } else if (i2 != 512 || length == 512) {
                if (length == 128) {
                    this.c = 10;
                } else if (length == 256) {
                    this.c = 14;
                } else if (length == 512) {
                    this.c = 18;
                }
                this.b = length / 64;
                this.f5946a = new long[(this.c + 1)][];
                int i3 = 0;
                while (true) {
                    long[][] jArr = this.f5946a;
                    if (i3 >= jArr.length) {
                        break;
                    }
                    jArr[i3] = new long[i];
                    i3++;
                }
                int i4 = this.b;
                long[] jArr2 = new long[i4];
                this.f5948b = jArr2;
                if (bArr.length == (i4 * 64) / 8) {
                    Pack.i(0, bArr, jArr2);
                    long[] jArr3 = new long[i];
                    long[] jArr4 = this.f5948b;
                    long[] jArr5 = new long[i];
                    long[] jArr6 = new long[i];
                    long[] jArr7 = new long[i];
                    this.f5944a = jArr7;
                    long j = jArr7[0];
                    int i5 = this.b;
                    jArr7[0] = j + ((long) (i + i5 + 1));
                    if (i == i5) {
                        System.arraycopy(jArr4, 0, jArr5, 0, i);
                        System.arraycopy(jArr4, 0, jArr6, 0, i);
                    } else {
                        System.arraycopy(jArr4, 0, jArr5, 0, i);
                        System.arraycopy(jArr4, i, jArr6, 0, i);
                    }
                    int i6 = 0;
                    while (true) {
                        long[] jArr8 = this.f5944a;
                        if (i6 >= jArr8.length) {
                            break;
                        }
                        jArr8[i6] = jArr8[i6] + jArr5[i6];
                        i6++;
                    }
                    j();
                    i();
                    byte[][] bArr2 = this.f5945a;
                    g(bArr2);
                    int i7 = 0;
                    while (true) {
                        long[] jArr9 = this.f5944a;
                        if (i7 >= jArr9.length) {
                            break;
                        }
                        jArr9[i7] = jArr9[i7] ^ jArr6[i7];
                        i7++;
                    }
                    j();
                    i();
                    g(bArr2);
                    int i8 = 0;
                    while (true) {
                        long[] jArr10 = this.f5944a;
                        if (i8 >= jArr10.length) {
                            break;
                        }
                        jArr10[i8] = jArr10[i8] + jArr5[i8];
                        i8++;
                    }
                    j();
                    i();
                    g(bArr2);
                    System.arraycopy(this.f5944a, 0, jArr3, 0, i);
                    long[] jArr11 = this.f5948b;
                    int i9 = this.b;
                    long[] jArr12 = new long[i9];
                    long[] jArr13 = new long[i];
                    long[] jArr14 = new long[i];
                    System.arraycopy(jArr11, 0, jArr12, 0, i9);
                    for (int i10 = 0; i10 < i; i10++) {
                        jArr14[i10] = 281479271743489L;
                    }
                    int i11 = 0;
                    while (true) {
                        System.arraycopy(jArr3, 0, this.f5944a, 0, i);
                        for (int i12 = 0; i12 < i; i12++) {
                            long[] jArr15 = this.f5944a;
                            jArr15[i12] = jArr15[i12] + jArr14[i12];
                        }
                        System.arraycopy(this.f5944a, 0, jArr13, 0, i);
                        System.arraycopy(jArr12, 0, this.f5944a, 0, i);
                        for (int i13 = 0; i13 < i; i13++) {
                            long[] jArr16 = this.f5944a;
                            jArr16[i13] = jArr16[i13] + jArr13[i13];
                        }
                        j();
                        i();
                        g(bArr2);
                        for (int i14 = 0; i14 < i; i14++) {
                            long[] jArr17 = this.f5944a;
                            jArr17[i14] = jArr17[i14] ^ jArr13[i14];
                        }
                        j();
                        i();
                        g(bArr2);
                        for (int i15 = 0; i15 < i; i15++) {
                            long[] jArr18 = this.f5944a;
                            jArr18[i15] = jArr18[i15] + jArr13[i15];
                        }
                        System.arraycopy(this.f5944a, 0, this.f5946a[i11], 0, i);
                        if (this.c == i11) {
                            break;
                        }
                        if (i != this.b) {
                            i11 += 2;
                            h(jArr14);
                            System.arraycopy(jArr3, 0, this.f5944a, 0, i);
                            for (int i16 = 0; i16 < i; i16++) {
                                long[] jArr19 = this.f5944a;
                                jArr19[i16] = jArr19[i16] + jArr14[i16];
                            }
                            System.arraycopy(this.f5944a, 0, jArr13, 0, i);
                            System.arraycopy(jArr12, i, this.f5944a, 0, i);
                            for (int i17 = 0; i17 < i; i17++) {
                                long[] jArr20 = this.f5944a;
                                jArr20[i17] = jArr20[i17] + jArr13[i17];
                            }
                            j();
                            i();
                            g(bArr2);
                            for (int i18 = 0; i18 < i; i18++) {
                                long[] jArr21 = this.f5944a;
                                jArr21[i18] = jArr21[i18] ^ jArr13[i18];
                            }
                            j();
                            i();
                            g(bArr2);
                            for (int i19 = 0; i19 < i; i19++) {
                                long[] jArr22 = this.f5944a;
                                jArr22[i19] = jArr22[i19] + jArr13[i19];
                            }
                            System.arraycopy(this.f5944a, 0, this.f5946a[i11], 0, i);
                            if (this.c == i11) {
                                break;
                            }
                        }
                        i11 += 2;
                        h(jArr14);
                        long j2 = jArr12[0];
                        int i20 = i9 - 1;
                        System.arraycopy(jArr12, 1, jArr12, 0, i20);
                        jArr12[i20] = j2;
                    }
                    for (int i21 = 1; i21 < this.c; i21 += 2) {
                        long[][] jArr23 = this.f5946a;
                        System.arraycopy(jArr23[i21 - 1], 0, jArr23[i21], 0, i);
                        long[] jArr24 = this.f5946a[i21];
                        int length2 = (jArr24.length * 2) + 3;
                        byte[] bArr3 = new byte[((jArr24.length * 64) / 8)];
                        Pack.k(0, bArr3, jArr24);
                        byte[] bArr4 = new byte[length2];
                        System.arraycopy(bArr3, 0, bArr4, 0, length2);
                        int length3 = (jArr24.length * 8) - length2;
                        System.arraycopy(bArr3, length2, bArr3, 0, length3);
                        System.arraycopy(bArr4, 0, bArr3, length3, length2);
                        Pack.i(0, bArr3, jArr24);
                    }
                    return;
                }
                throw new IllegalArgumentException("Invalid key parameter passed to DSTU7624Engine init");
            } else {
                throw new IllegalArgumentException("Unsupported key length");
            }
        } else {
            throw new IllegalArgumentException("Invalid parameter passed to DSTU7624Engine init");
        }
    }

    public final String b() {
        return "DSTU7624";
    }

    public final int c() {
        return (this.a * 64) / 8;
    }

    public final void d() {
        long[] jArr = this.f5944a;
        byte[] bArr = this.f5943a;
        Pack.k(0, bArr, jArr);
        int i = -1;
        int i2 = 0;
        while (true) {
            byte[] bArr2 = this.f5947b;
            if (i2 < 8) {
                int i3 = this.a;
                if (i2 % (8 / i3) == 0) {
                    i++;
                }
                for (int i4 = 0; i4 < i3; i4++) {
                    bArr2[C1058d.L(i4, 64, 8, i2)] = bArr[((((i4 + i) % i3) * 64) / 8) + i2];
                }
                i2++;
            } else {
                Pack.i(0, bArr2, this.f5944a);
                return;
            }
        }
    }

    public final int e(int i, int i2, byte[] bArr, byte[] bArr2) throws DataLengthException, IllegalStateException {
        byte[][] bArr3;
        byte[][] bArr4;
        if (this.f5948b == null) {
            throw new IllegalStateException("DSTU7624 engine not initialised");
        } else if (c() + i > bArr.length) {
            throw new DataLengthException("Input buffer too short");
        } else if (c() + i2 <= bArr2.length) {
            boolean z = this.f5942a;
            int i3 = this.a;
            int i4 = 1;
            if (z) {
                Pack.i(i, bArr, this.f5944a);
                for (int i5 = 0; i5 < i3; i5++) {
                    long[] jArr = this.f5944a;
                    jArr[i5] = jArr[i5] + this.f5946a[0][i5];
                }
                while (true) {
                    int i6 = this.c;
                    bArr4 = this.f5945a;
                    if (i4 >= i6) {
                        break;
                    }
                    j();
                    i();
                    g(bArr4);
                    for (int i7 = 0; i7 < i3; i7++) {
                        long[] jArr2 = this.f5944a;
                        jArr2[i7] = jArr2[i7] ^ this.f5946a[i4][i7];
                    }
                    i4++;
                }
                j();
                i();
                g(bArr4);
                for (int i8 = 0; i8 < i3; i8++) {
                    long[] jArr3 = this.f5944a;
                    jArr3[i8] = jArr3[i8] + this.f5946a[this.c][i8];
                }
                Pack.k(i2, bArr2, this.f5944a);
            } else {
                int i9 = this.c;
                Pack.i(i, bArr, this.f5944a);
                for (int i10 = 0; i10 < i3; i10++) {
                    long[] jArr4 = this.f5944a;
                    jArr4[i10] = jArr4[i10] - this.f5946a[i9][i10];
                }
                int i11 = this.c - 1;
                while (true) {
                    bArr3 = this.f5949b;
                    if (i11 <= 0) {
                        break;
                    }
                    g(bArr3);
                    d();
                    f();
                    for (int i12 = 0; i12 < i3; i12++) {
                        long[] jArr5 = this.f5944a;
                        jArr5[i12] = jArr5[i12] ^ this.f5946a[i11][i12];
                    }
                    i11--;
                }
                g(bArr3);
                d();
                f();
                for (int i13 = 0; i13 < i3; i13++) {
                    long[] jArr6 = this.f5944a;
                    jArr6[i13] = jArr6[i13] - this.f5946a[0][i13];
                }
                Pack.k(i2, bArr2, this.f5944a);
            }
            return c();
        } else {
            throw new OutputLengthException("Output buffer too short");
        }
    }

    public final void f() {
        for (int i = 0; i < this.a; i++) {
            long[] jArr = this.f5944a;
            byte[][] bArr = this.d;
            byte[] bArr2 = bArr[0];
            long j = jArr[i];
            long j2 = 255 & ((long) bArr2[(int) (j & 255)]);
            byte[] bArr3 = bArr[1];
            long j3 = j2 | (65280 & (((long) bArr3[(int) ((j & 65280) >>> 8)]) << 8));
            byte[] bArr4 = bArr[2];
            byte[] bArr5 = bArr[3];
            jArr[i] = ((((long) bArr5[(int) ((j & -72057594037927936L) >>> 56)]) << 56) & -72057594037927936L) | j3 | (16711680 & (((long) bArr4[(int) ((j & 16711680) >>> 16)]) << 16)) | (4278190080L & (((long) bArr5[(int) ((j & 4278190080L) >>> 24)]) << 24)) | (1095216660480L & (((long) bArr2[(int) ((j & 1095216660480L) >>> 32)]) << 32)) | (280375465082880L & (((long) bArr3[(int) ((j & 280375465082880L) >>> 40)]) << 40)) | ((((long) bArr4[(int) ((j & 71776119061217280L) >>> 48)]) << 48) & 71776119061217280L);
        }
    }

    public final void g(byte[][] bArr) {
        long[] jArr = this.f5944a;
        int i = 0;
        byte[] bArr2 = this.f5943a;
        Pack.k(0, bArr2, jArr);
        byte b2 = 0;
        while (i < this.a) {
            long j = 0;
            long j2 = -72057594037927936L;
            int i2 = 7;
            while (i2 >= 0) {
                for (int i3 = 7; i3 >= 0; i3--) {
                    byte b3 = bArr2[C1058d.L(i, 64, 8, i3)];
                    byte b4 = bArr[i2][i3];
                    int i4 = b3 & UnsignedBytes.MAX_VALUE;
                    int i5 = b4 & UnsignedBytes.MAX_VALUE;
                    int i6 = (-(i5 & 1)) & i4;
                    for (int i7 = 1; i7 < 8; i7++) {
                        i4 <<= 1;
                        i5 >>>= 1;
                        i6 ^= (-(i5 & 1)) & i4;
                    }
                    int i8 = 65280 & i6;
                    int i9 = ((i8 >>> 8) ^ ((((i8 >>> 4) ^ i8) ^ (i8 >>> 5)) ^ (i8 >>> 6))) ^ i6;
                    int i10 = i9 & 3840;
                    b2 = (byte) (b2 ^ ((byte) (((i10 >>> 8) ^ ((((i10 >>> 4) ^ i10) ^ (i10 >>> 5)) ^ (i10 >>> 6))) ^ i9)));
                }
                j |= (((long) b2) << ((i2 * 64) / 8)) & j2;
                j2 >>>= 8;
                i2--;
                b2 = 0;
            }
            this.f5944a[i] = j;
            i++;
            b2 = 0;
        }
    }

    public final void i() {
        long[] jArr = this.f5944a;
        byte[] bArr = this.f5943a;
        Pack.k(0, bArr, jArr);
        int i = -1;
        int i2 = 0;
        while (true) {
            byte[] bArr2 = this.f5947b;
            if (i2 < 8) {
                int i3 = this.a;
                if (i2 % (8 / i3) == 0) {
                    i++;
                }
                for (int i4 = 0; i4 < i3; i4++) {
                    bArr2[((((i4 + i) % i3) * 64) / 8) + i2] = bArr[C1058d.L(i4, 64, 8, i2)];
                }
                i2++;
            } else {
                Pack.i(0, bArr2, this.f5944a);
                return;
            }
        }
    }

    public final void j() {
        for (int i = 0; i < this.a; i++) {
            long[] jArr = this.f5944a;
            byte[][] bArr = this.f5950c;
            byte[] bArr2 = bArr[0];
            long j = jArr[i];
            long j2 = 255 & ((long) bArr2[(int) (j & 255)]);
            byte[] bArr3 = bArr[1];
            long j3 = j2 | (65280 & (((long) bArr3[(int) ((j & 65280) >>> 8)]) << 8));
            byte[] bArr4 = bArr[2];
            byte[] bArr5 = bArr[3];
            jArr[i] = ((((long) bArr5[(int) ((j & -72057594037927936L) >>> 56)]) << 56) & -72057594037927936L) | j3 | (16711680 & (((long) bArr4[(int) ((j & 16711680) >>> 16)]) << 16)) | (4278190080L & (((long) bArr5[(int) ((j & 4278190080L) >>> 24)]) << 24)) | (1095216660480L & (((long) bArr2[(int) ((j & 1095216660480L) >>> 32)]) << 32)) | (280375465082880L & (((long) bArr3[(int) ((j & 280375465082880L) >>> 40)]) << 40)) | ((((long) bArr4[(int) ((j & 71776119061217280L) >>> 48)]) << 48) & 71776119061217280L);
        }
    }

    public final void reset() {
        Arrays.q(this.f5944a);
        Arrays.p(this.f5943a, (byte) 0);
        Arrays.p(this.f5947b, (byte) 0);
    }
}
