package com.company;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyClassLoader extends ClassLoader {

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        Class<?> c = getSystemClassLoader().loadClass(name);
        try {
            Method main = c.getMethod("main");
            main.invoke(c);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            System.out.println("Main was not found");
        }

        return c;
    }


}
