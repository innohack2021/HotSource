package com.innohotsource.hotjson.Json.sample;

import java.util.List;

public class SubSampleList {
    private String subName;
    private Long subId;
    public List<Sub> subList;

    public String getSubName() {
        return subName;
    }

    public Long getSubId() {
        return subId;
    }


    public List<Sub> getSubList() {
        return subList;
    }

    @Override
    public String toString() {
        return "SubSampleList{" +
                "subName='" + subName + '\'' +
                ", subId=" + subId +
                ", subList=" + subList +
                '}';
    }
}
