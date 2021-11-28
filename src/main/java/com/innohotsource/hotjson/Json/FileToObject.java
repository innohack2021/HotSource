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

    public <T> T getFile(Class<T> clazz) {
        //<T> T instance;
        T instance = null;
        JSONParser parser = new JSONParser();
        try (Reader reader = new FileReader(pwd)) {
            JSONObject json = (JSONObject) parser.parse(reader);
            instance = JsonToObject.fromJson(json, clazz);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return instance;
    }
}