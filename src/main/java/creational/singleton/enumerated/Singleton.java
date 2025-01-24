package creational.singleton.enumerated;

import creational.singleton.ISingleton;

public enum Singleton implements ISingleton {

    INSTANCE;

    public static Singleton getInstance() {
        return INSTANCE;
    }
}
