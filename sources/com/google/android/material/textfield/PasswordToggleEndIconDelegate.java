package com.google.android.material.textfield;

import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.R;

class PasswordToggleEndIconDelegate extends EndIconDelegate {
    private EditText editText;
    private int iconResId = R.drawable.design_password_eye;
    private final View.OnClickListener onIconClickListener = new m(this);

    public PasswordToggleEndIconDelegate(EndCompoundLayout endCompoundLayout, int i) {
        super(endCompoundLayout);
        if (i != 0) {
            this.iconResId = i;
        }
    }

    private boolean hasPasswordTransformation() {
        EditText editText2 = this.editText;
        if (editText2 == null || !(editText2.getTransformationMethod() instanceof PasswordTransformationMethod)) {
            return false;
        }
        return true;
    }

    private static boolean isInputTypePassword(EditText editText2) {
        if (editText2 == null || (editText2.getInputType() != 16 && editText2.getInputType() != 128 && editText2.getInputType() != 144 && editText2.getInputType() != 224)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(View view) {
        EditText editText2 = this.editText;
        if (editText2 != null) {
            int selectionEnd = editText2.getSelectionEnd();
            if (hasPasswordTransformation()) {
                this.editText.setTransformationMethod((TransformationMethod) null);
            } else {
                this.editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            if (selectionEnd >= 0) {
                this.editText.setSelection(selectionEnd);
            }
            refreshIconState();
        }
    }

    public void beforeEditTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        refreshIconState();
    }

    public int getIconContentDescriptionResId() {
        return R.string.password_toggle_content_description;
    }

    public int getIconDrawableResId() {
        return this.iconResId;
    }

    public View.OnClickListener getOnIconClickListener() {
        return this.onIconClickListener;
    }

    public boolean isIconCheckable() {
        return true;
    }

    public boolean isIconChecked() {
        return !hasPasswordTransformation();
    }

    public void onEditTextAttached(EditText editText2) {
        this.editText = editText2;
        refreshIconState();
    }

    public void setUp() {
        if (isInputTypePassword(this.editText)) {
            this.editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }

    public void tearDown() {
        EditText editText2 = this.editText;
        if (editText2 != null) {
            editText2.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }
}
