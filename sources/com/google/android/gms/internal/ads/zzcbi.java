package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.concurrent.CountDownLatch;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzcbi extends Thread implements SurfaceTexture.OnFrameAvailableListener, zzcbg {
    private static final float[] zza = {-1.0f, -1.0f, -1.0f, 1.0f, -1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f};
    private volatile boolean zzA;
    private volatile boolean zzB;
    private final zzcbh zzb;
    private final float[] zzc = new float[9];
    private final float[] zzd = new float[9];
    private final float[] zze = new float[9];
    private final float[] zzf = new float[9];
    private final float[] zzg = new float[9];
    private final float[] zzh = new float[9];
    private final float[] zzi = new float[9];
    private float zzj = Float.NaN;
    private float zzk;
    private float zzl;
    private int zzm;
    private int zzn;
    private SurfaceTexture zzo;
    private SurfaceTexture zzp;
    private int zzq;
    private int zzr;
    private int zzs;
    private final FloatBuffer zzt;
    private final CountDownLatch zzu;
    private final Object zzv;
    private EGL10 zzw;
    private EGLDisplay zzx;
    private EGLContext zzy;
    private EGLSurface zzz;

    public zzcbi(Context context) {
        super("SphericalVideoProcessor");
        float[] fArr = zza;
        int length = fArr.length;
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(48).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.zzt = asFloatBuffer;
        asFloatBuffer.put(fArr).position(0);
        zzcbh zzcbh = new zzcbh(context);
        this.zzb = zzcbh;
        zzcbh.zzb(this);
        this.zzu = new CountDownLatch(1);
        this.zzv = new Object();
    }

    private static final void zzh(String str) {
        GLES20.glGetError();
    }

    private static final void zzi(float[] fArr, float[] fArr2, float[] fArr3) {
        float f = fArr2[1];
        float f2 = fArr3[3];
        float f3 = fArr2[2];
        float f4 = fArr3[6];
        fArr[0] = (fArr2[0] * fArr3[0]) + (f * f2) + (f3 * f4);
        float f5 = fArr2[0];
        float f6 = fArr3[4];
        float f7 = fArr3[7];
        fArr[1] = (fArr3[1] * f5) + (f * f6) + (f3 * f7);
        float f8 = f5 * fArr3[2];
        float f9 = fArr2[1];
        float f10 = fArr3[5];
        float f11 = fArr3[8];
        fArr[2] = f8 + (f9 * f10) + (f3 * f11);
        float f12 = fArr2[3];
        float f13 = fArr3[0];
        float f14 = fArr2[4];
        float f15 = fArr2[5];
        fArr[3] = (f12 * f13) + (f2 * f14) + (f15 * f4);
        float f16 = fArr2[3];
        float f17 = fArr3[1];
        fArr[4] = (f16 * f17) + (f14 * f6) + (f15 * f7);
        float f18 = fArr3[2];
        fArr[5] = (f16 * f18) + (fArr2[4] * f10) + (f15 * f11);
        float f19 = fArr2[6] * f13;
        float f20 = fArr2[7];
        float f21 = fArr2[8];
        fArr[6] = f19 + (fArr3[3] * f20) + (f4 * f21);
        float f22 = fArr2[6];
        float f23 = f7 * f21;
        fArr[7] = f23 + (f20 * fArr3[4]) + (f17 * f22);
        fArr[8] = (f22 * f18) + (fArr2[7] * fArr3[5]) + (f21 * f11);
    }

    private static final void zzj(float[] fArr, float f) {
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        double d = (double) f;
        fArr[4] = (float) Math.cos(d);
        fArr[5] = (float) (-Math.sin(d));
        fArr[6] = 0.0f;
        fArr[7] = (float) Math.sin(d);
        fArr[8] = (float) Math.cos(d);
    }

    private static final void zzk(float[] fArr, float f) {
        double d = (double) f;
        fArr[0] = (float) Math.cos(d);
        fArr[1] = (float) (-Math.sin(d));
        fArr[2] = 0.0f;
        fArr[3] = (float) Math.sin(d);
        fArr[4] = (float) Math.cos(d);
        fArr[5] = 0.0f;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 1.0f;
    }

    private static final int zzl(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        zzh("createShader");
        if (glCreateShader != 0) {
            GLES20.glShaderSource(glCreateShader, str);
            zzh("shaderSource");
            GLES20.glCompileShader(glCreateShader);
            zzh("compileShader");
            int[] iArr = new int[1];
            GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
            zzh("getShaderiv");
            if (iArr[0] == 0) {
                GLES20.glGetShaderInfoLog(glCreateShader);
                GLES20.glDeleteShader(glCreateShader);
                zzh("deleteShader");
                return 0;
            }
        }
        return glCreateShader;
    }

    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.zzs++;
        synchronized (this.zzv) {
            this.zzv.notifyAll();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x01b2 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r14 = this;
            android.graphics.SurfaceTexture r0 = r14.zzp
            if (r0 == 0) goto L_0x0347
            javax.microedition.khronos.egl.EGL r0 = javax.microedition.khronos.egl.EGLContext.getEGL()
            javax.microedition.khronos.egl.EGL10 r0 = (javax.microedition.khronos.egl.EGL10) r0
            r14.zzw = r0
            java.lang.Object r1 = javax.microedition.khronos.egl.EGL10.EGL_DEFAULT_DISPLAY
            javax.microedition.khronos.egl.EGLDisplay r0 = r0.eglGetDisplay(r1)
            r14.zzx = r0
            javax.microedition.khronos.egl.EGLDisplay r1 = javax.microedition.khronos.egl.EGL10.EGL_NO_DISPLAY
            r2 = 3
            r3 = 2
            r4 = 0
            r5 = 1
            r6 = 0
            if (r0 != r1) goto L_0x0020
        L_0x001d:
            r0 = r6
            goto L_0x0087
        L_0x0020:
            int[] r1 = new int[r3]
            javax.microedition.khronos.egl.EGL10 r7 = r14.zzw
            boolean r0 = r7.eglInitialize(r0, r1)
            if (r0 != 0) goto L_0x002b
            goto L_0x001d
        L_0x002b:
            int[] r0 = new int[r5]
            javax.microedition.khronos.egl.EGLConfig[] r1 = new javax.microedition.khronos.egl.EGLConfig[r5]
            r7 = 11
            int[] r9 = new int[r7]
            r9 = {12352, 4, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12344} // fill-array
            javax.microedition.khronos.egl.EGL10 r7 = r14.zzw
            javax.microedition.khronos.egl.EGLDisplay r8 = r14.zzx
            r11 = 1
            r10 = r1
            r12 = r0
            boolean r7 = r7.eglChooseConfig(r8, r9, r10, r11, r12)
            if (r7 != 0) goto L_0x0045
        L_0x0043:
            r0 = r4
            goto L_0x004b
        L_0x0045:
            r0 = r0[r6]
            if (r0 <= 0) goto L_0x0043
            r0 = r1[r6]
        L_0x004b:
            if (r0 != 0) goto L_0x004e
            goto L_0x001d
        L_0x004e:
            int[] r1 = new int[r2]
            r1 = {12440, 2, 12344} // fill-array
            javax.microedition.khronos.egl.EGL10 r7 = r14.zzw
            javax.microedition.khronos.egl.EGLDisplay r8 = r14.zzx
            javax.microedition.khronos.egl.EGLContext r9 = javax.microedition.khronos.egl.EGL10.EGL_NO_CONTEXT
            javax.microedition.khronos.egl.EGLContext r1 = r7.eglCreateContext(r8, r0, r9, r1)
            r14.zzy = r1
            if (r1 == 0) goto L_0x001d
            javax.microedition.khronos.egl.EGLContext r7 = javax.microedition.khronos.egl.EGL10.EGL_NO_CONTEXT
            if (r1 != r7) goto L_0x0066
            goto L_0x001d
        L_0x0066:
            javax.microedition.khronos.egl.EGL10 r1 = r14.zzw
            javax.microedition.khronos.egl.EGLDisplay r7 = r14.zzx
            android.graphics.SurfaceTexture r8 = r14.zzp
            javax.microedition.khronos.egl.EGLSurface r0 = r1.eglCreateWindowSurface(r7, r0, r8, r4)
            r14.zzz = r0
            if (r0 == 0) goto L_0x001d
            javax.microedition.khronos.egl.EGLSurface r1 = javax.microedition.khronos.egl.EGL10.EGL_NO_SURFACE
            if (r0 != r1) goto L_0x0079
            goto L_0x001d
        L_0x0079:
            javax.microedition.khronos.egl.EGL10 r1 = r14.zzw
            javax.microedition.khronos.egl.EGLDisplay r7 = r14.zzx
            javax.microedition.khronos.egl.EGLContext r8 = r14.zzy
            boolean r0 = r1.eglMakeCurrent(r7, r0, r0, r8)
            if (r0 != 0) goto L_0x0086
            goto L_0x001d
        L_0x0086:
            r0 = r5
        L_0x0087:
            com.google.android.gms.internal.ads.zzbbn r1 = com.google.android.gms.internal.ads.zzbbw.zzba
            com.google.android.gms.internal.ads.zzbbu r7 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r7 = r7.zza(r1)
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r8 = r1.zzm()
            boolean r7 = r7.equals(r8)
            if (r7 != 0) goto L_0x00a8
            com.google.android.gms.internal.ads.zzbbu r7 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r1 = r7.zza(r1)
            java.lang.String r1 = (java.lang.String) r1
            goto L_0x00aa
        L_0x00a8:
            java.lang.String r1 = "attribute highp vec3 aPosition;varying vec3 pos;void main() {  gl_Position = vec4(aPosition, 1.0);  pos = aPosition;}"
        L_0x00aa:
            r7 = 35633(0x8b31, float:4.9932E-41)
            int r1 = zzl(r7, r1)
            if (r1 != 0) goto L_0x00b6
        L_0x00b3:
            r9 = r6
            goto L_0x012b
        L_0x00b6:
            com.google.android.gms.internal.ads.zzbbn r7 = com.google.android.gms.internal.ads.zzbbw.zzbb
            com.google.android.gms.internal.ads.zzbbu r8 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r8 = r8.zza(r7)
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r9 = r7.zzm()
            boolean r8 = r8.equals(r9)
            if (r8 != 0) goto L_0x00d7
            com.google.android.gms.internal.ads.zzbbu r8 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r7 = r8.zza(r7)
            java.lang.String r7 = (java.lang.String) r7
            goto L_0x00d9
        L_0x00d7:
            java.lang.String r7 = "#extension GL_OES_EGL_image_external : require\n#define INV_PI 0.3183\nprecision highp float;varying vec3 pos;uniform samplerExternalOES uSplr;uniform mat3 uVMat;uniform float uFOVx;uniform float uFOVy;void main() {  vec3 ray = vec3(pos.x * tan(uFOVx), pos.y * tan(uFOVy), -1);  ray = (uVMat * ray).xyz;  ray = normalize(ray);  vec2 texCrd = vec2(    0.5 + atan(ray.x, - ray.z) * INV_PI * 0.5, acos(ray.y) * INV_PI);  gl_FragColor = vec4(texture2D(uSplr, texCrd).xyz, 1.0);}"
        L_0x00d9:
            r8 = 35632(0x8b30, float:4.9931E-41)
            int r7 = zzl(r8, r7)
            if (r7 != 0) goto L_0x00e3
            goto L_0x00b3
        L_0x00e3:
            java.lang.String r8 = "createProgram"
            int r9 = android.opengl.GLES20.glCreateProgram()
            zzh(r8)
            if (r9 == 0) goto L_0x012b
            android.opengl.GLES20.glAttachShader(r9, r1)
            java.lang.String r1 = "attachShader"
            zzh(r1)
            android.opengl.GLES20.glAttachShader(r9, r7)
            java.lang.String r1 = "attachShader"
            zzh(r1)
            android.opengl.GLES20.glLinkProgram(r9)
            java.lang.String r1 = "linkProgram"
            zzh(r1)
            int[] r1 = new int[r5]
            r7 = 35714(0x8b82, float:5.0046E-41)
            android.opengl.GLES20.glGetProgramiv(r9, r7, r1, r6)
            java.lang.String r7 = "getProgramiv"
            zzh(r7)
            r1 = r1[r6]
            if (r1 == r5) goto L_0x0123
            android.opengl.GLES20.glGetProgramInfoLog(r9)
            android.opengl.GLES20.glDeleteProgram(r9)
            java.lang.String r1 = "deleteProgram"
            zzh(r1)
            goto L_0x00b3
        L_0x0123:
            android.opengl.GLES20.glValidateProgram(r9)
            java.lang.String r1 = "validateProgram"
            zzh(r1)
        L_0x012b:
            r14.zzq = r9
            android.opengl.GLES20.glUseProgram(r9)
            java.lang.String r1 = "useProgram"
            zzh(r1)
            int r1 = r14.zzq
            java.lang.String r7 = "aPosition"
            int r1 = android.opengl.GLES20.glGetAttribLocation(r1, r7)
            r9 = 3
            r10 = 5126(0x1406, float:7.183E-42)
            r11 = 0
            r12 = 12
            java.nio.FloatBuffer r13 = r14.zzt
            r8 = r1
            android.opengl.GLES20.glVertexAttribPointer(r8, r9, r10, r11, r12, r13)
            java.lang.String r7 = "vertexAttribPointer"
            zzh(r7)
            android.opengl.GLES20.glEnableVertexAttribArray(r1)
            java.lang.String r1 = "enableVertexAttribArray"
            zzh(r1)
            int[] r1 = new int[r5]
            android.opengl.GLES20.glGenTextures(r5, r1, r6)
            java.lang.String r7 = "genTextures"
            zzh(r7)
            r1 = r1[r6]
            r7 = 36197(0x8d65, float:5.0723E-41)
            android.opengl.GLES20.glBindTexture(r7, r1)
            java.lang.String r8 = "bindTextures"
            zzh(r8)
            r8 = 10240(0x2800, float:1.4349E-41)
            r9 = 9729(0x2601, float:1.3633E-41)
            android.opengl.GLES20.glTexParameteri(r7, r8, r9)
            java.lang.String r8 = "texParameteri"
            zzh(r8)
            r8 = 10241(0x2801, float:1.435E-41)
            android.opengl.GLES20.glTexParameteri(r7, r8, r9)
            java.lang.String r8 = "texParameteri"
            zzh(r8)
            r8 = 10242(0x2802, float:1.4352E-41)
            r9 = 33071(0x812f, float:4.6342E-41)
            android.opengl.GLES20.glTexParameteri(r7, r8, r9)
            java.lang.String r8 = "texParameteri"
            zzh(r8)
            r8 = 10243(0x2803, float:1.4354E-41)
            android.opengl.GLES20.glTexParameteri(r7, r8, r9)
            java.lang.String r7 = "texParameteri"
            zzh(r7)
            int r7 = r14.zzq
            java.lang.String r8 = "uVMat"
            int r7 = android.opengl.GLES20.glGetUniformLocation(r7, r8)
            r14.zzr = r7
            r8 = 9
            float[] r8 = new float[r8]
            r8 = {1065353216, 0, 0, 0, 1065353216, 0, 0, 0, 1065353216} // fill-array
            android.opengl.GLES20.glUniformMatrix3fv(r7, r5, r6, r8, r6)
            int r7 = r14.zzq
            if (r0 == 0) goto L_0x0319
            if (r7 != 0) goto L_0x01b6
            goto L_0x0319
        L_0x01b6:
            android.graphics.SurfaceTexture r0 = new android.graphics.SurfaceTexture
            r0.<init>(r1)
            r14.zzo = r0
            r0.setOnFrameAvailableListener(r14)
            java.util.concurrent.CountDownLatch r0 = r14.zzu
            r0.countDown()
            com.google.android.gms.internal.ads.zzcbh r0 = r14.zzb
            r0.zzc()
            r14.zzA = r5     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
        L_0x01cc:
            boolean r0 = r14.zzB     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            if (r0 == 0) goto L_0x01d2
            goto L_0x02f8
        L_0x01d2:
            int r0 = r14.zzs     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            if (r0 <= 0) goto L_0x01e2
            android.graphics.SurfaceTexture r0 = r14.zzo     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            r0.updateTexImage()     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            int r0 = r14.zzs     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            int r0 = r0 + -1
            r14.zzs = r0     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            goto L_0x01d2
        L_0x01e2:
            com.google.android.gms.internal.ads.zzcbh r0 = r14.zzb     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            float[] r1 = r14.zzc     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            boolean r0 = r0.zze(r1)     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            r1 = 5
            r7 = 4
            r8 = -1077342245(0xffffffffbfc90fdb, float:-1.5707964)
            if (r0 == 0) goto L_0x0234
            float r0 = r14.zzj     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            boolean r0 = java.lang.Float.isNaN(r0)     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            if (r0 == 0) goto L_0x0229
            float[] r0 = r14.zzc     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            r9 = r0[r6]     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            r10 = 0
            float r9 = r9 * r10
            r11 = r0[r5]     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            r12 = 1065353216(0x3f800000, float:1.0)
            float r11 = r11 * r12
            float r9 = r9 + r11
            r11 = r0[r3]     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            float r11 = r11 * r10
            float r11 = r11 + r9
            r9 = r0[r2]     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            float r9 = r9 * r10
            r13 = r0[r7]     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            float r13 = r13 * r12
            float r9 = r9 + r13
            r12 = r0[r1]     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            float r12 = r12 * r10
            float r12 = r12 + r9
            r9 = 6
            r9 = r0[r9]     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            r9 = 7
            r9 = r0[r9]     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            r9 = 8
            r0 = r0[r9]     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            double r9 = (double) r12     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            double r11 = (double) r11     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            double r9 = java.lang.Math.atan2(r9, r11)     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            float r0 = (float) r9     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            float r0 = r0 + r8
            float r0 = -r0
            r14.zzj = r0     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
        L_0x0229:
            float[] r0 = r14.zzh     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            float r8 = r14.zzj     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            float r9 = r14.zzk     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            float r8 = r8 + r9
            zzk(r0, r8)     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            goto L_0x0240
        L_0x0234:
            float[] r0 = r14.zzc     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            zzj(r0, r8)     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            float[] r0 = r14.zzh     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            float r8 = r14.zzk     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            zzk(r0, r8)     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
        L_0x0240:
            float[] r0 = r14.zzd     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            r8 = 1070141403(0x3fc90fdb, float:1.5707964)
            zzj(r0, r8)     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            float[] r0 = r14.zze     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            float[] r8 = r14.zzh     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            float[] r9 = r14.zzd     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            zzi(r0, r8, r9)     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            float[] r0 = r14.zzf     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            float[] r8 = r14.zzc     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            float[] r9 = r14.zze     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            zzi(r0, r8, r9)     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            float[] r0 = r14.zzg     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            float r8 = r14.zzl     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            zzj(r0, r8)     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            float[] r0 = r14.zzi     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            float[] r8 = r14.zzg     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            float[] r9 = r14.zzf     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            zzi(r0, r8, r9)     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            int r0 = r14.zzr     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            float[] r8 = r14.zzi     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            android.opengl.GLES20.glUniformMatrix3fv(r0, r5, r6, r8, r6)     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            android.opengl.GLES20.glDrawArrays(r1, r6, r7)     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            java.lang.String r0 = "drawArrays"
            zzh(r0)     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            android.opengl.GLES20.glFinish()     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            javax.microedition.khronos.egl.EGL10 r0 = r14.zzw     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            javax.microedition.khronos.egl.EGLDisplay r1 = r14.zzx     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            javax.microedition.khronos.egl.EGLSurface r7 = r14.zzz     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            r0.eglSwapBuffers(r1, r7)     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            boolean r0 = r14.zzA     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            if (r0 == 0) goto L_0x02c9
            int r0 = r14.zzn     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            int r1 = r14.zzm     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            android.opengl.GLES20.glViewport(r6, r6, r0, r1)     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            java.lang.String r0 = "viewport"
            zzh(r0)     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            int r0 = r14.zzq     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            java.lang.String r1 = "uFOVx"
            int r0 = android.opengl.GLES20.glGetUniformLocation(r0, r1)     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            int r1 = r14.zzq     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            java.lang.String r7 = "uFOVy"
            int r1 = android.opengl.GLES20.glGetUniformLocation(r1, r7)     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            int r7 = r14.zzn     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            int r8 = r14.zzm     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            r9 = 1063216883(0x3f5f66f3, float:0.87266463)
            if (r7 <= r8) goto L_0x02bd
            android.opengl.GLES20.glUniform1f(r0, r9)     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            int r0 = r14.zzm     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            float r0 = (float) r0     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            float r0 = r0 * r9
            int r7 = r14.zzn     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            float r7 = (float) r7     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            float r0 = r0 / r7
            android.opengl.GLES20.glUniform1f(r1, r0)     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            goto L_0x02c7
        L_0x02bd:
            float r7 = (float) r7     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            float r7 = r7 * r9
            float r8 = (float) r8     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            float r7 = r7 / r8
            android.opengl.GLES20.glUniform1f(r0, r7)     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
            android.opengl.GLES20.glUniform1f(r1, r9)     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
        L_0x02c7:
            r14.zzA = r6     // Catch:{ IllegalStateException -> 0x02f3, all -> 0x02e3 }
        L_0x02c9:
            java.lang.Object r0 = r14.zzv     // Catch:{ InterruptedException -> 0x01cc }
            monitor-enter(r0)     // Catch:{ InterruptedException -> 0x01cc }
            boolean r1 = r14.zzB     // Catch:{ all -> 0x02e0 }
            if (r1 != 0) goto L_0x02dd
            boolean r1 = r14.zzA     // Catch:{ all -> 0x02e0 }
            if (r1 != 0) goto L_0x02dd
            int r1 = r14.zzs     // Catch:{ all -> 0x02e0 }
            if (r1 != 0) goto L_0x02dd
            java.lang.Object r1 = r14.zzv     // Catch:{ all -> 0x02e0 }
            r1.wait()     // Catch:{ all -> 0x02e0 }
        L_0x02dd:
            monitor-exit(r0)     // Catch:{ all -> 0x02e0 }
            goto L_0x01cc
        L_0x02e0:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x02e0 }
            throw r1     // Catch:{ InterruptedException -> 0x01cc }
        L_0x02e3:
            r0 = move-exception
            java.lang.String r1 = "SphericalVideoProcessor died."
            com.google.android.gms.ads.internal.util.client.zzm.zzh(r1, r0)     // Catch:{ all -> 0x0308 }
            com.google.android.gms.internal.ads.zzbze r1 = com.google.android.gms.ads.internal.zzu.zzo()     // Catch:{ all -> 0x0308 }
            java.lang.String r2 = "SphericalVideoProcessor.run.2"
            r1.zzw(r0, r2)     // Catch:{ all -> 0x0308 }
            goto L_0x02f8
        L_0x02f3:
            java.lang.String r0 = "SphericalVideoProcessor halted unexpectedly."
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r0)     // Catch:{ all -> 0x0308 }
        L_0x02f8:
            com.google.android.gms.internal.ads.zzcbh r0 = r14.zzb
            r0.zzd()
            android.graphics.SurfaceTexture r0 = r14.zzo
            r0.setOnFrameAvailableListener(r4)
            r14.zzo = r4
            r14.zzg()
            return
        L_0x0308:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzcbh r1 = r14.zzb
            r1.zzd()
            android.graphics.SurfaceTexture r1 = r14.zzo
            r1.setOnFrameAvailableListener(r4)
            r14.zzo = r4
            r14.zzg()
            throw r0
        L_0x0319:
            javax.microedition.khronos.egl.EGL10 r0 = r14.zzw
            int r0 = r0.eglGetError()
            java.lang.String r0 = android.opengl.GLUtils.getEGLErrorString(r0)
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "EGL initialization failed: "
            java.lang.String r0 = r1.concat(r0)
            com.google.android.gms.ads.internal.util.client.zzm.zzg(r0)
            com.google.android.gms.internal.ads.zzbze r1 = com.google.android.gms.ads.internal.zzu.zzo()
            java.lang.Throwable r2 = new java.lang.Throwable
            r2.<init>(r0)
            java.lang.String r0 = "SphericalVideoProcessor.run.1"
            r1.zzw(r2, r0)
            r14.zzg()
            java.util.concurrent.CountDownLatch r0 = r14.zzu
            r0.countDown()
            return
        L_0x0347:
            java.lang.String r0 = "SphericalVideoProcessor started with no output texture."
            com.google.android.gms.ads.internal.util.client.zzm.zzg(r0)
            java.util.concurrent.CountDownLatch r0 = r14.zzu
            r0.countDown()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcbi.run():void");
    }

    public final void zza() {
        synchronized (this.zzv) {
            this.zzv.notifyAll();
        }
    }

    public final SurfaceTexture zzb() {
        if (this.zzp == null) {
            return null;
        }
        try {
            this.zzu.await();
        } catch (InterruptedException unused) {
        }
        return this.zzo;
    }

    public final void zzc(int i, int i2) {
        synchronized (this.zzv) {
            this.zzn = i;
            this.zzm = i2;
            this.zzA = true;
            this.zzv.notifyAll();
        }
    }

    public final void zzd(SurfaceTexture surfaceTexture, int i, int i2) {
        this.zzn = i;
        this.zzm = i2;
        this.zzp = surfaceTexture;
    }

    public final void zze() {
        synchronized (this.zzv) {
            this.zzB = true;
            this.zzp = null;
            this.zzv.notifyAll();
        }
    }

    public final void zzf(float f, float f2) {
        int i = this.zzn;
        int i2 = this.zzm;
        if (i <= i2) {
            i = i2;
        }
        float f3 = (float) i;
        this.zzk -= (f * 1.7453293f) / f3;
        float f4 = this.zzl - ((f2 * 1.7453293f) / f3);
        this.zzl = f4;
        if (f4 < -1.5707964f) {
            this.zzl = -1.5707964f;
            f4 = -1.5707964f;
        }
        if (f4 > 1.5707964f) {
            this.zzl = 1.5707964f;
        }
    }

    public final boolean zzg() {
        EGLSurface eGLSurface;
        EGLSurface eGLSurface2 = this.zzz;
        boolean z = false;
        if (!(eGLSurface2 == null || eGLSurface2 == (eGLSurface = EGL10.EGL_NO_SURFACE))) {
            z = this.zzw.eglDestroySurface(this.zzx, this.zzz) | this.zzw.eglMakeCurrent(this.zzx, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
            this.zzz = null;
        }
        EGLContext eGLContext = this.zzy;
        if (eGLContext != null) {
            z |= this.zzw.eglDestroyContext(this.zzx, eGLContext);
            this.zzy = null;
        }
        EGLDisplay eGLDisplay = this.zzx;
        if (eGLDisplay == null) {
            return z;
        }
        boolean eglTerminate = this.zzw.eglTerminate(eGLDisplay) | z;
        this.zzx = null;
        return eglTerminate;
    }
}
