package com.innohotsource.hotjson.Json;

import org.json.simple.JSONObject;
import java.io.FileWriter;
import java.io.IOException;

public class ObjectToFile {
    String pwd;

    ObjectToFile(){
        this.pwd = "./";
    }
    ObjectToFile(String pwd){
        this.pwd = pwd;
    }

    public void putFile(Object obj) throws IllegalAccessException{
        ObjectToJson jsonObject = new ObjectToJson();
        JSONObject json = jsonObject.toJson(obj);
        Class<?> clazz = obj.getClass();

        try (FileWriter file = new FileWriter(pwd + clazz.getSimpleName() + ".json")) {
            file.write(json.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
