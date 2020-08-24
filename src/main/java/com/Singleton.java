package com;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class Singleton {

    private static Map<String, Object> instances = new HashMap<>();

    private Singleton() {
    }


    /**
     * To instantiate the bean only once
     * @param name
     * @param <T>
     * @return
     */
    public static <T> T Instance(String name) {
        Class<T> c;
        try {
            c = (Class<T>) Class.forName(name);
        } catch (ClassNotFoundException e1) {
            System.err.println("ClassNotFoundException: " + name);
            e1.printStackTrace();
            return null;
        }

        if (!instances.containsKey(name)) {
            T inst;
            try {
                inst = c.getConstructor().newInstance();
            } catch (IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException
                    | InstantiationException | IllegalAccessException e) {
                System.err.println("Can't get or call constructor");
                e.printStackTrace();
                return null;
            }
            instances.put(name, inst);
        }

        return c.cast(instances.get(name));
    }
}
