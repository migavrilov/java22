package com.company;


public class User {

    @Printable
    private String name;

    @Printable
    private static Integer klass;


    private final int age;

    User(String name, int klass, int age) {
        this.name = name;
        User.klass = klass;
        this.age = age;
    }

    public static void main() {
        System.out.println("User.Main() was called");
    }


}