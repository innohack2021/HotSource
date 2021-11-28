package com.innohotsource.hotjson.Json.sample;

import java.util.List;

public class Sample1 {
    private String name;
    private Long id;
    private List<SubSample> subSampleList;

    @Override
    public String toString() {
        return "Sample1{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", subSampleList=" + subSampleList +
                '}';
    }

    public String getName() {
        return name;
    }
}
