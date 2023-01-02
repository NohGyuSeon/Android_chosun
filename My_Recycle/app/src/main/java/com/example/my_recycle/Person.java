package com.example.my_recycle;

public class Person {
    String name;
    String mobile;
    String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Person(String name, String mobile, String id) {
        this.name = name;
        this.mobile = mobile;
        this.id = id;
    }
}
