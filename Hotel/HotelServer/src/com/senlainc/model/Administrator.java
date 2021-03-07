package com.senlainc.model;

public class Administrator {
    private String name;

    public Administrator(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "name='" + name + '\'' +
                '}';
    }
}
