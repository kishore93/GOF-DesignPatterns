package creational.singleton.holder;

import creational.singleton.ISingleton;

public class Singleton implements ISingleton {

    private static class SingletonHolder {
        private static final Singleton valueHolder = new Singleton();

        private static Singleton getInstance() {
            return valueHolder;
        }

    }

    private Singleton() {
        // intentionally private
    }

    public static Singleton getInstance() {
        return SingletonHolder.getInstance();
    }

}
