package creational.factory.simple;

import creational.factory.IFactory;

import java.util.Objects;

public class Factory implements IFactory<Factory, String> {

    public static class Type1 extends Factory {}
    public static class Type2 extends Factory {}

    @Override
    public Factory get(String key) {
        return switch (key) {
            case null -> null;
            case "TYPE1" -> new Type1();
            case "TYPE2" -> new Type2();
            default -> throw new IllegalArgumentException("Unexpected value: " + key);
        };
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getClass());
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof Factory && other.hashCode() == this.hashCode();
    }
}
