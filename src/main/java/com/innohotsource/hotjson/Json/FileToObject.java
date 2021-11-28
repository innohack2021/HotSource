package com.innohotsource.hotjson.Json;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class FileToObject {

    Attribute attribute;
    private FileToObject(){}

    class SetPwd{
    Attribute attribute;
    SetPwd(Attribute attribute){
        this.attribute = attribute;
    }
        public Bind setPwd(String pwd){
            attribute = new Attribute(pwd);
            return new Bind(attribute);
        }
    }
    class Bind{
        Attribute attribute;
        Bind(Attribute attribute){
            this.attribute = attribute;
        }
        public Object bind(Object instance) throws IllegalAccessException {

            return getFile(instance, attribute);
        }
    }

    public Object getFile(Object instance, Attribute attribute) throws IllegalAccessException {
        JSONParser parser = new JSONParser();
        try (Reader reader = new FileReader(attribute.getPwd())) {
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            instance = JsonToObject.fromJson(jsonObject, instance.getClass());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return instance;
    }
}
