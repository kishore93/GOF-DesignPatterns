package creational.prototype;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PrototypeTests {

    @Test
    public void shouldSupportCloning() {
        var expensiveObject = new CloneablePrototype();
        var clonedObject = expensiveObject.basicClone();
        assertEquals(expensiveObject, clonedObject);
    }

    @Test
    public void shouldReturnMutableObject() {
        var modifiedValue = new Object();
        var expensiveObject = new CloneablePrototype();
        var clonedObject = expensiveObject.basicClone();
        clonedObject.setModifiableProperty(modifiedValue);
        assertAll(
                () -> assertNotEquals(expensiveObject, clonedObject),
                () -> assertEquals(expensiveObject.getDefaultProperty(), clonedObject.getDefaultProperty()),
                () -> assertEquals(modifiedValue, clonedObject.getModifiableProperty())
        );
    }

}
