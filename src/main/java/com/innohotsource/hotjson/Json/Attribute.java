package com.innohotsource.hotjson.Json;

public class Attribute {
    private boolean ignored;
    private Object o;

    public Attribute(boolean ignored, Object o) {
        this.ignored = ignored;
        this.o = o;
    }

    public boolean isIgnored() {
        return ignored;
    }
}
