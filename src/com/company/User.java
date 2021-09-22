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
class Handler{
    public static void handle(Object o) throws IllegalAccessException {
        for(Field field : o.getClass().getDeclaredFields()) {
            if (field.getAnnotation(Printable.class) == null)
                continue;
            field.setAccessible(true);
            StringBuilder ans = new StringBuilder(field.getName() + " = " + field.get(o) + ". It is ");
            String mods = Modifier.toString(field.getModifiers());
            String[] parts = mods.split(" ");
            if (parts.length > 1) {
                for (int i = 0; i < parts.length - 1; i++) {
                    ans.append(parts[i]).append(" and ");
                }
                ans.append(parts[parts.length - 1]);
            } else {
                ans.append(parts[0]);
            }
            ans.append(" field");

            System.out.println(ans);
        }
    }

}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Printable {
}

class Main{
    public static void main(String[] args) throws IllegalAccessException {
        User user= new User("test", 1, 123);
        Handler.handle(user);
    }
}