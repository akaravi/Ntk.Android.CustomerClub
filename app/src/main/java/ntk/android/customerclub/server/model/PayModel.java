package ntk.android.customerclub.server.model;

import com.google.gson.annotations.SerializedName;

public class PayModel {
    @SerializedName("Name")
    public String Name;
    @SerializedName("AccountId")
    public String AccountId;
    @SerializedName("AccountType")
    public String AccountType;
    @SerializedName("price")
    public int price;
}
