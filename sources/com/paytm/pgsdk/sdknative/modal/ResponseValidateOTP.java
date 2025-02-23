package com.paytm.pgsdk.sdknative.modal;

import com.google.gson.annotations.SerializedName;

public class ResponseValidateOTP extends BaseResponseModal {
    @SerializedName("ErrorCode")
    public String ErrorCode;
    @SerializedName("ErrorMsg")
    public String ErrorMsg;
    @SerializedName("STATUS")
    public String STATUS;
    @SerializedName("TOKEN_DETAILS")
    public TokenDetails TokenDetails;

    public class TokenDetails {
        @SerializedName("PAYTM_TOKEN")
        public String PAYTM_TOKEN;
        @SerializedName("TXN_TOKEN")
        public String TXN_TOKEN;

        public TokenDetails() {
        }
    }
}
