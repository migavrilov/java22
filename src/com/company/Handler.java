package com.company;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

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
