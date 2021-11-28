package com.innohotsource.hotjson.Json.sample;

public class SubSample {
    private String subName;
    private Long subId;
    private Sub sub;

    public SubSample(){};

    @Override
    public String toString() {
        return "SubSample{" +
                "subName='" + subName + '\'' +
                ", subId=" + subId +
                ", sub=" + sub +
                '}';
    }

    public String getSubName() {
        return subName;
    }

    public Long getSubId() {
        return subId;
    }

    public Sub getSub() {
        return sub;
    }
}
