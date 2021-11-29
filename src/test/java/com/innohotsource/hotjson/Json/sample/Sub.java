package com.innohotsource.hotjson.Json.sample;

public class Sub {
    private String subSubName;
    private Long subSubId;

    public Sub(){}

    @Override
    public String toString() {
        return "Sub{" +
                "subSubName='" + subSubName + '\'' +
                ", subSubId=" + subSubId +
                '}';
    }

    public String getSubSubName() {
        return subSubName;
    }

    public void setSubSubName(String subSubName) {
        this.subSubName = subSubName;
    }

    public Long getSubSubId() {
        return subSubId;
    }

    public void setSubSubId(Long subSubId) {
        this.subSubId = subSubId;
    }
}
