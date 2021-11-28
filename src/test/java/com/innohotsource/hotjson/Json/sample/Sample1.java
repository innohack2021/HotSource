package com.innohotsource.hotjson.Json.sample;

import java.util.List;

public class Sample1 {
    private String name;
    private Long id;
    private List<SubSampleList> subSampleList;

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public List<SubSampleList> getSubSampleList() {
        return subSampleList;
    }

    @Override
    public String toString() {
        return "Sample1{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", subSampleList=" + subSampleList +
                '}';
    }
}
