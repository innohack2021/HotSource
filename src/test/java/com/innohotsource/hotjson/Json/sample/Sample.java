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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SubSample getSubSample() {
        return subSample;
    }

    public void setSubSample(SubSample subSample) {
        this.subSample = subSample;
    }
}
