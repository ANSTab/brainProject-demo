package com.tabachenko.test1Brain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


public class Person {

    private String name;

    private String phonenumber;

    public String getName() {
        return name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public Person(String name, String phonenumber) {
        this.name = name;
        this.phonenumber = phonenumber;
    }

}
