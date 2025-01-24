package creational.factory.parameterized;

import creational.factory.IParameterizedFactory;

import java.util.Objects;

@SuppressWarnings("rawtypes")
public class Factory<ParameterType> implements IParameterizedFactory<Factory<ParameterType>, String, ParameterType> {

    public static class Type1<ParameterType> extends Factory<ParameterType> {

        private final ParameterType parameter;

        public Type1(ParameterType parameter) {
            this.parameter = parameter;
        }

        @Override
        public int hashCode() {
            return Objects.hash(parameter);
        }

        @Override
        public boolean equals(Object other) {
            return other instanceof Type1 type1 && type1.hashCode() == this.hashCode();
        }
    }

    public static class Type2<ParameterType> extends Factory<ParameterType> {

        private final ParameterType parameter;

        public Type2(ParameterType parameter) {
            this.parameter = parameter;
        }

        @Override
        public int hashCode() {
            return Objects.hash(parameter);
        }

        @Override
        public boolean equals(Object other) {
            return other instanceof Type2 type2 && type2.hashCode() == this.hashCode();
        }

    }

    @Override
    public Factory<ParameterType> get(String differentiator, ParameterType parameter) {
        return switch (differentiator) {
            case null -> null;
            case "TYPE1" -> new Type1<>(parameter);
            case "TYPE2" -> new Type2<>(parameter);
            default -> throw new IllegalArgumentException("Unexpected value: " + differentiator);
        };
    }

}
