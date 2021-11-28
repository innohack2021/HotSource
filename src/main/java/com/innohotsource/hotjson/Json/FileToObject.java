package com.innohotsource.hotjson.Json;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class FileToObject {
    String pwd;

    FileToObject(String pwd){
        this.pwd = pwd;
    }

    public Object getFile(Object instance) {
        JSONParser parser = new JSONParser();
        try (Reader reader = new FileReader(pwd)) {
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            JsonToObject Jto = new JsonToObject();
            instance = Jto.fromJson(jsonObject, instance);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return instance;
    }
}
