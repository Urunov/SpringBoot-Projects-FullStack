package com.urunov.model.gson.bitMasterAPI.driverInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;

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
