package com.urunov.model.gson.bitMasterApi.driverInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by:
 * User: hamdamboy
 * Project: IntelliJ IDEA
 * Github: @urunov
 */

@Getter
@Setter
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
    @SerializedName("car_id")
    @Expose
    private Integer carId;
    @SerializedName("license")
    @Expose
    private String license;
    @SerializedName("home_phone")
    @Expose
    private String homePhone;
    @SerializedName("mobile_phone")
    @Expose
    private String mobilePhone;
    @SerializedName("is_locked")
    @Expose
    private Boolean isLocked;
    @SerializedName("is_dismissed")
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
