package com.innohotsource.hotjson.Json;

import java.util.List;

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
