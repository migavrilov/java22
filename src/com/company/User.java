package com.company;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class User {

    @Printable
    private String name;

    @Printable
    private static Integer klass;


    private final int age;

    public User(String name, int klass, int age) {
        this.name = name;
        User.klass = klass;
        this.age = age;
    }
}