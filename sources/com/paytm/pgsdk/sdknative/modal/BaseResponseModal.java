package com.paytm.pgsdk.sdknative.modal;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class BaseResponseModal implements Serializable {
    @SerializedName("error")
    public String error;
    public int errorCode;
}
