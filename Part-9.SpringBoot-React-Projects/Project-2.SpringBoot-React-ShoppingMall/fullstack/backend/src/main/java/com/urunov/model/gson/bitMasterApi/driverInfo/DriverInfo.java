package com.urunov.model.gson.bitMasterApi.driverInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by:
 * User: hamdamboy
 * Project: IntelliJ IDEA
 * Github: @urunov
 */

@Getter
@Setter
public class DriverInfo {

    @SerializedName("code")
    @Expose
    private Integer code;

    @SerializedName("descr")
    @Expose
    private String descr;

    @SerializedName("data")
    @Expose
    private Data data;
}
