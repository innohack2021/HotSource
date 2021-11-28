package com.innohotsource.hotjson.Json.sample;

public class Sample {
    public String name;
    public Long id;


    public SubSample subSample;

    public Sample() {
    }

    @Override
    public String toString() {
        return "Sample{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", subSample=" + subSample +
                '}';
    }
}
