package com.example.my_recycle2;

public class Person {
    String name;
    String mobile;
    String id;
    int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Person(String name, String mobile, String id, int num) {
        this.name = name;
        this.mobile = mobile;
        this.id = id;
        this.num = num;
    }

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
