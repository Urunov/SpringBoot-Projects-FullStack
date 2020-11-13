package com.urunov.model.gson.bitMasterApi.driverInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by:
 * User: hamdamboy
 * Project: IntelliJ IDEA
 * Github: @urunov
 */
@Data
@Getter
@Setter
public class Account {

    @SerializedName("account_kind")
    @Expose
    private Integer accountKind;

    @SerializedName("balance")
    @Expose
    private Float balance;
}
