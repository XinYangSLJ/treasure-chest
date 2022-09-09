package org.treasure.chest.dev.template.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;


@Slf4j
public class JackJsonUtils {

    private static final String SERVICE_NAME = "JackJsonUtil";
    private static final String METHOD_NAME_jsonToObject = SERVICE_NAME + ".jsonToObject";
    private static final String METHOD_NAME_objToJsonCatchError = SERVICE_NAME + ".objToJsonCatchError";


    public static ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }


    /**
     * 对象转换json字符串
     * @param obj
     * @return
     * @throws JsonProcessingException
     */
    public static String objToJson(Object obj) throws JsonProcessingException {
        if (Objects.isNull(obj)) {
            return null;
        }
        return mapper.writeValueAsString(obj);
    }

    /**
     * 对象转换json字符串,异常捕获
     *
     * @param obj
     * @return
     */
    public static String objToJsonCatchException(Object obj) {
        try {
            return objToJson(obj);
        } catch (Exception e) {
            log.error(METHOD_NAME_objToJsonCatchError + " JSON转对象出错, obj:{}, error:{}", obj, e);
        }
        return "";
    }


    /**
     * json字符串转对象
     */
    public static <T> T jsonToObject(String jsonStr, TypeReference<T> typeReference) {
        try {
            if (null == jsonStr) {
                return null;
            }
            return mapper.readValue(jsonStr, typeReference);
        } catch (Exception e) {
            log.error(METHOD_NAME_jsonToObject + " JSON转对象出错, error:{}", e.getMessage(), e);
        }
        return null;
    }

    /**
     * json字符串转对象
     */
    public static <T> T jsonToObject(String json, Class<T> type) {
        T pojo = null;
        try {
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            pojo = mapper.readValue(json, type);
        } catch (Exception e) {
            log.error(METHOD_NAME_jsonToObject + " JSON转对象出错, error:{}", e.getMessage(), e);
        }
        return pojo;
    }

//    public static final <T> T parseObject(String jsonStr, Class<T> clazz) {
//        try {
//            if (!StringUtils.isEmpty(jsonStr)) {
//                return JSONObject.parseObject(jsonStr, clazz);
//            }
//        } catch (Exception var3) {
//            log.error("将JSON串{}转换成 指定对象失败", jsonStr, var3);
//        }
//
//        return null;
//    }

}
