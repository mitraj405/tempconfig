package com.paytm.pgsdk.sdknative.modal;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class ResponseSavedCardBin extends BaseResponseModal {
    @SerializedName("SIZE")
    public int SIZE;
    @SerializedName("STATUS")
    public String STATUS;
    @SerializedName("BIN_DETAILS")
    public ArrayList<SavedCardBinDetails> savedCardBinDetailsArrayList;

    public class SavedCardBinDetails {
        @SerializedName("BANK_NAME")
        public String BANK_NAME;
        @SerializedName("CARDBIN")
        public int CARDBIN;
        @SerializedName("CARDLASTDIGIT")
        public int CARDLASTDIGIT;
        @SerializedName("CARD_TYPE")
        public String CARD_TYPE;
        @SerializedName("PAYMENTMODE")
        public String PAYMENTMODE;
        @SerializedName("SAVE_CARD_ID")
        public long SAVE_CARD_ID;

        public SavedCardBinDetails() {
        }
    }
}
