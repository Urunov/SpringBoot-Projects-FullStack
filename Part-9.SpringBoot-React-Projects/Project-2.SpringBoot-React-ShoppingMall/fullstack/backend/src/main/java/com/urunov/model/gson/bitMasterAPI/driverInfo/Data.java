package com.urunov.model.gson.bitMasterAPI.driverInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * Created by:
 * User: hamdamboy
 * Project: IntelliJ IDEA
 * Github: @urunov
 */
@lombok.Data
@Getter
@Setter
@ToString
public class Data {

    @SerializedName("driver_id")
    @Expose
    private Integer driverId;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("balance")
    @Expose
    private Integer balance;

    @SerializedName("birthday")
    @Expose
    private String birthday;

    @SerializedName("cardId")
    @Expose
    private Integer carId;

    @SerializedName("license")
    @Expose
    private String license;

    @SerializedName("homePhone")
    @Expose
    private String homePhone;

    @SerializedName("mobilePhone")
    @Expose
    private String mobilePhone;

    @SerializedName("isLocked")
    @Expose
    private Boolean isLocked;

    @SerializedName("isDismissed")
    @Expose
    private Boolean isDismissed;

    @SerializedName("order_params")
    @Expose
    private List<Integer> orderParams = null;

    @SerializedName("phones")
    @Expose
    private List<Phone> phones = null;

    @SerializedName("term_account")
    @Expose
    private String termAccount;

    @SerializedName("name_for_taxophone")
    @Expose
    private String nameForTaxophone;

    @SerializedName("accounts")
    @Expose
    private List<Account> accounts = null;
}
