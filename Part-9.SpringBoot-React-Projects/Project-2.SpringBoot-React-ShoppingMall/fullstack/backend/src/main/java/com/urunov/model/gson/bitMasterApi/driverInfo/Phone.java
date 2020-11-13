package com.urunov.model.gson.bitMasterApi.driverInfo;

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
public class Phone {

    @SerializedName("phone")
    @Expose
    private String phone;

    @SerializedName("is_default")
    @Expose
    private Boolean isDefault;

    @SerializedName("use_for_call")
    @Expose
    private Boolean useForCall;

}
