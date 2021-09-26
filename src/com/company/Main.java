package com.company;

class Main {
    public static void main(String[] args) throws IllegalAccessException {
        User user= new User("test", 1, 123);
        Handler.handle(user);
    }
}
