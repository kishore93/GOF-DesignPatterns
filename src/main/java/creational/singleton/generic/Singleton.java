package creational.singleton.generic;

import creational.singleton.ISingleton;

public class Singleton implements ISingleton {

    private static Singleton valueHolder;

    private Singleton() {
        // intentionally private
    }

    public static Singleton getInstance() {
        if(valueHolder == null) {
            synchronized (Singleton.class) {
                if(valueHolder == null) {
                    valueHolder = new Singleton();
                }
            }
        }
        return valueHolder;
    }

}
