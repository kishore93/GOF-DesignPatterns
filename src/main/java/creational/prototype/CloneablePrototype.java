package creational.prototype;

import java.util.Objects;

public class CloneablePrototype implements IPrototype<CloneablePrototype> {

    private final Object defaultProperty;
    private Object modifiableProperty;

    /**
     * Expensive constructor call which builds {@link CloneablePrototype#defaultProperty}
     */
    public CloneablePrototype() {
        defaultProperty = new Object();
    }

    /**
     * Defined to support {@link IPrototype#basicClone()} contract API
     * @param defaultProperty expensive to build refer {@link CloneablePrototype#basicClone()}
     *                       implementation
     */
    private CloneablePrototype(Object defaultProperty) {
        this.defaultProperty = defaultProperty;
    }

    public void setModifiableProperty(Object modifiableProperty) {
        this.modifiableProperty = modifiableProperty;
    }

    public Object getModifiableProperty() {
        return modifiableProperty;
    }

    public Object getDefaultProperty() {
        return defaultProperty;
    }

    /**
     * Performs a basic clone, reusing common and expensive properties that remain unchanged.
     */
    @Override
    public CloneablePrototype basicClone() {
        // Reuses the costly default property
        return new CloneablePrototype(this.defaultProperty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(defaultProperty, modifiableProperty);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof CloneablePrototype clone
                && clone.defaultProperty == this.defaultProperty //Intentionally checking reference
                && Objects.equals(clone.modifiableProperty, this.modifiableProperty);
    }
}
