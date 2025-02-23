package com.paytm.pgsdk.sdknative.modal;

import com.google.gson.annotations.SerializedName;

public class ResponseCheckBalance extends BaseResponseModal {
    @SerializedName("response")
    public Response response;
    @SerializedName("statusCode")
    public String statusCode;
    public String statusMessage;

    public class Response {
        @SerializedName("amount")
        public String amount;
        @SerializedName("clwBalance")
        public String clwBalance;
        @SerializedName("currencyCode")
        public String currencyCode;
        @SerializedName("otpPinRequired")
        public String otpPinRequired;
        @SerializedName("ownerGuid")
        public String ownerGuid;
        @SerializedName("ssoId")
        public String ssoId;
        @SerializedName("txnPinRequired")
        public String txnPinRequired;
        @SerializedName("walletGrade")
        public String walletGrade;
        @SerializedName("walletType")
        public String walletType;

        public Response() {
        }
    }
}
