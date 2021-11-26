package com.innohotsource.hotjson.Json;

import java.util.List;

public class Sample {
    private String name;
    private Long Id;

    private testLists testList;

    private class testLists {
        private String listName;

        public testLists() {
        }
    }

    public Sample() {
    }

    @Override
    public String toString() {
        return
                "{name : '" + name + '\'' +
                ", id : " + Id +
                ", testList : " + testList +
                '}';
    }
}
