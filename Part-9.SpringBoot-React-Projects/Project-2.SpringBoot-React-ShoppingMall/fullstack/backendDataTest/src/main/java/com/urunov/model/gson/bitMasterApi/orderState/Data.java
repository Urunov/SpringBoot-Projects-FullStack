package com.urunov.model.gson.bitMasterApi.orderState;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.*;

/**
 * Created by:
 * User: hamdamboy
 * Project: IntelliJ IDEA
 * Github: @urunov
 */
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class Data {

    @SerializedName("order_id")
    @Expose
    private Integer orderId;
    @SerializedName("state_id")
    @Expose
    private Integer stateId;
    @SerializedName("state_kind")
    @Expose
    private String stateKind;
    @SerializedName("crew_id")
    @Expose
    private Integer crewId;
    @SerializedName("prior_crew_id")
    @Expose
    private Integer priorCrewId;
    @SerializedName("driver_id")
    @Expose
    private Integer driverId;
    @SerializedName("car_id")
    @Expose
    private Integer carId;
    @SerializedName("server_time_offset")
    @Expose
    private Integer serverTimeOffset;
    @SerializedName("start_time")
    @Expose
    private String startTime;
    @SerializedName("source_time")
    @Expose
    private String sourceTime;
    @SerializedName("finish_time")
    @Expose
    private Object finishTime;
    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("source_lat")
    @Expose
    private Float sourceLat;
    @SerializedName("source_lon")
    @Expose
    private Float sourceLon;
    @SerializedName("destination")
    @Expose
    private String destination;
    @SerializedName("destination_lat")
    @Expose
    private Float destinationLat;
    @SerializedName("destination_lon")
    @Expose
    private Float destinationLon;
    @SerializedName("stops")
    @Expose
    private List<Object> stops = null;
    @SerializedName("customer")
    @Expose
    private String customer;
    @SerializedName("passenger")
    @Expose
    private String passenger;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("client_id")
    @Expose
    private Integer clientId;
    @SerializedName("client_employee_id")
    @Expose
    private Integer clientEmployeeId;
    @SerializedName("order_crew_group_id")
    @Expose
    private Integer orderCrewGroupId;
    @SerializedName("tariff_id")
    @Expose
    private Integer tariffId;
    @SerializedName("order_params")
    @Expose
    private List<Object> orderParams = null;
    @SerializedName("creation_way")
    @Expose
    private String creationWay;
    @SerializedName("is_prior")
    @Expose
    private Boolean isPrior;
    @SerializedName("is_really_prior")
    @Expose
    private Boolean isReallyPrior;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("prior_to_current_before_minutes")
    @Expose
    private Integer priorToCurrentBeforeMinutes;
    @SerializedName("flight_number")
    @Expose
    private String flightNumber;
    @SerializedName("car_mark")
    @Expose
    private String carMark;
    @SerializedName("car_model")
    @Expose
    private String carModel;
    @SerializedName("car_color")
    @Expose
    private String carColor;
    @SerializedName("car_number")
    @Expose
    private String carNumber;
    @SerializedName("confirmed")
    @Expose
    private String confirmed;
}
