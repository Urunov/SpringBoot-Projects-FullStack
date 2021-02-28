package com.urunov.jwtauth.store;

import com.fatboyindustrial.gsonjavatime.Converters;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JsonUtil {
    private static final Gson prettyGson = Converters.registerZonedDateTime(new GsonBuilder()).setPrettyPrinting().create();
    private static final Gson gson = Converters.registerZonedDateTime(new GsonBuilder()).create();

    public JsonUtil() {
    }

    public static String toJson(Object object) {
        return gson.toJson(object);
    }

    public static String toJson(Object object, boolean returnNull) {
        return returnNull && object == null ? null : gson.toJson(object);
    }

    public static String toPrettyJson(Object object) {
        return prettyGson.toJson(object);
    }

    public static <T> T fromJson(String json, Class<T> clazz) {
        return gson.fromJson(json, clazz);
    }

    public static <T> T fromJson(String jsonString, Type type) {
        return gson.fromJson(jsonString, type);
    }

    public static <T> List<T> fromJsonList(String json, Class<T> valueType) {
        if (json == null) {
            return null;
        } else {
            List<T> ObjectList = new ArrayList();
            if (StringUtil.isEmpty(json)) {
                return ObjectList;
            } else {
                Type collectionType = new JsonUtil.ListParameterizedType(valueType);
                Collection<T> links = (Collection)gson.fromJson(json, collectionType);
                if (links != null && !links.isEmpty()) {
                    ObjectList.addAll(links);
                    return ObjectList;
                } else {
                    return ObjectList;
                }
            }
        }
    }

    private static class ListParameterizedType implements ParameterizedType {
        private final Type type;

        private ListParameterizedType(Type type) {
            this.type = type;
        }

        public Type[] getActualTypeArguments() {
            return new Type[]{this.type};
        }

        public Type getRawType() {
            return Collection.class;
        }

        public Type getOwnerType() {
            return null;
        }
    }
}
