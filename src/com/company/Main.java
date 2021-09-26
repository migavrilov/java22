package com.company;


class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        MyClassLoader mcl = new MyClassLoader();
        mcl.loadClass("com.company.User");
        mcl.loadClass("com.company.Test");
        //User user= new User("test", 1, 123);
        //AnnotationHandler.handle(user);
    }
}
