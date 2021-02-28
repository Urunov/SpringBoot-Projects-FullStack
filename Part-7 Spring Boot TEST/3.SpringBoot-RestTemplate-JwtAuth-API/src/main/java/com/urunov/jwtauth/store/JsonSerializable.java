package com.urunov.jwtauth.store;

public interface JsonSerializable {

    default String toJson() {
        return JsonUtil.toJson(this);
    }

    default String toPrettyJson() {
        return JsonUtil.toPrettyJson(this);
    }

}
