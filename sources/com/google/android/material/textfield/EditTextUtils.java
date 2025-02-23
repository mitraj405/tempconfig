package com.google.android.material.textfield;

import android.widget.EditText;

class EditTextUtils {
    private EditTextUtils() {
    }

    public static boolean isEditable(EditText editText) {
        if (editText.getInputType() != 0) {
            return true;
        }
        return false;
    }
}
