package creational.singleton;

import creational.singleton.enumerated.Singleton;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static creational.singleton.ISingleton.INSTANCE_METHOD;

public class SingletonTest {

    @ParameterizedTest(name = "{index} - {0}")
    @ValueSource(classes = {
            creational.singleton.generic.Singleton.class,
            creational.singleton.holder.Singleton.class,
            Singleton.class
    })
    public void testSingleton(Class<? extends ISingleton> clazz)
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = clazz.getMethod(INSTANCE_METHOD);
        //obj will be null for static method invocations
        var singleton1 = method.invoke(null);
        var singleton2 = method.invoke(null);
        assertEquals(singleton1, singleton2);
    }

}
