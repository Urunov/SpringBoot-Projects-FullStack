package com.urunov.model.gson.bitMasterAPI.driverInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by:
 * User: hamdamboy
 * Project: IntelliJ IDEA
 * Github: @urunov
 */

@Data
@Getter
@Setter
@ToString
public class Account {

    @SerializedName("account_kind")
    @Expose
    private Integer accountKind;

    @SerializedName("balance")
    @Expose
    private Float balance;


}
