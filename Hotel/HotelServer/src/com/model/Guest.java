package com.model;

import java.io.Serializable;
import java.util.List;

public class Guest extends AEntity implements Serializable {
    private Integer id;
    private String name;
    private  Integer age;


    public Guest(){}
    public Guest(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Guest{"+" id="+getId()+", name="+name+", age="+age+'}';
    }
}
