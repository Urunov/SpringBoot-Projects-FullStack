package com.urunov.model.gson.bitMasterAPI.orderState;

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
public class OrderState {

    @SerializedName("code")
    @Expose
    private Integer code;

    @SerializedName("descr")
    @Expose
    private String descr;

    @SerializedName("data")
    @Expose
    private com.urunov.model.gson.bitMasterAPI.orderState.Data data;


}
