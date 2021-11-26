package com.innohotsource.hotjson.Json;

import com.innohotsource.hotjson.annotation.IgnoredField;
import org.json.simple.JSONObject;
import org.w3c.dom.Attr;

import java.lang.reflect.Field;

public class ObjectToJson {


    public static JSONObject toJson(Object o) throws IllegalAccessException {
        //Attribute attribute;
        JSONObject jsonObject = new JSONObject();
        Class clazz = o.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (!field.isAnnotationPresent(IgnoredField.class)) {
                field.setAccessible(true);
                jsonObject.put(field.getName(), field.get(o));
            }
        }
          return jsonObject;
    }

//    class Man0{
//        public Man1 man0(boolean ignored){
//            Attribute attribute;
//
//            return new Man1(attribute);
//        }
//
//    }
//
//    class Man1 {
//        Attribute attribute;
//        Man1(Attribute attribute){
//            this.attribute = attribute;
//        }
//        public JSONObject logic(Object o){
//            return toJson(attribute, o);
//        }
//    }
}
