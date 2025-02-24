package in.juspay.hypersdk.core;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.SurfaceTexture;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public class BlurProcessor {
    Activity activity;
    Allocation allocBlurred;
    Allocation allocOriginalScreenshot;
    RenderScript mRS;
    ScriptIntrinsicBlur scriptIntrinsicBlur;
    TextureView.SurfaceTextureListener surfaceTextureListener = new TextureView.SurfaceTextureListener() {
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            BlurProcessor.this.allocBlurred.setSurface(new Surface(surfaceTexture));
            BlurProcessor.this.executeBlur();
        }

        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return false;
        }

        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        }
    };
    TextureView textureViewBlurred;

    public BlurProcessor(RenderScript renderScript, int i, Activity activity2) {
        this.mRS = renderScript;
        ScriptIntrinsicBlur create = ScriptIntrinsicBlur.create(renderScript, Element.RGBA_8888(renderScript));
        this.scriptIntrinsicBlur = create;
        create.setRadius((float) i);
        this.activity = activity2;
    }

    public static Bitmap getBitmapFromView(View view) {
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        view.layout(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        view.draw(canvas);
        return createBitmap;
    }

    public void blurView(View view, View view2) {
        if (view != null && this.activity != null && view2 != null) {
            Bitmap bitmapFromView = getBitmapFromView(view);
            Allocation allocation = this.allocOriginalScreenshot;
            if (!(allocation == null || (allocation.getType().getX() == bitmapFromView.getWidth() && this.allocOriginalScreenshot.getType().getY() == bitmapFromView.getHeight()))) {
                this.allocOriginalScreenshot.destroy();
                this.allocBlurred.destroy();
                this.textureViewBlurred = null;
                this.allocOriginalScreenshot = null;
                this.allocBlurred = null;
            }
            Allocation allocation2 = this.allocOriginalScreenshot;
            if (allocation2 == null) {
                Allocation createFromBitmap = Allocation.createFromBitmap(this.mRS, bitmapFromView);
                this.allocOriginalScreenshot = createFromBitmap;
                this.allocBlurred = Allocation.createTyped(this.mRS, createFromBitmap.getType(), 65);
                TextureView textureView = new TextureView(this.activity);
                this.textureViewBlurred = textureView;
                textureView.setOpaque(false);
                this.textureViewBlurred.setSurfaceTextureListener(this.surfaceTextureListener);
            } else {
                allocation2.copyFrom(bitmapFromView);
            }
            replaceView(view2, this.textureViewBlurred);
        }
    }

    public void executeBlur() {
        this.scriptIntrinsicBlur.setInput(this.allocOriginalScreenshot);
        this.scriptIntrinsicBlur.forEach(this.allocBlurred);
        this.allocBlurred.ioSend();
    }

    public void replaceView(View view, View view2) {
        view2.setLayoutParams(new FrameLayout.LayoutParams(view.getLayoutParams()));
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        viewGroup.addView(view2, viewGroup.indexOfChild(view));
    }
}
