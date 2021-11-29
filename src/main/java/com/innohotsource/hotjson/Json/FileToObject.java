package com.innohotsource.hotjson.Json;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * <p>
 * file written by json format convert to object
 * </p>
 * @author : lee cheol
 * @version : 1.1
 */
public class FileToObject {
    String pwd;

    /**
     * setting path
     * @param pwd file path
     */
    public FileToObject(String pwd){
        this.pwd = pwd;
    }

    /**
     * Create an instance and initialize it to the value of json value
     * @param clazz clazz that wants to receive input class
     * @param <T> Generic Type
     * @return instance full of json data
     * @throws IllegalAccessException unable to create instance.
     */
    public <T> T getFile(Class<T> clazz) throws IllegalAccessException{
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