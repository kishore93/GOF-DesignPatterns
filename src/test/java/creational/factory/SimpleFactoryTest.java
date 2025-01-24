package creational.factory;

import creational.factory.simple.Factory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SimpleFactoryTest {

    public record TestCase(String input, Factory output) {

        static TestCase of(String input, Factory output) {
            return new TestCase(input, output);
        }

    }

    IFactory<Factory, String> factory = new Factory();

    public static Stream<TestCase> differentiatorProvider() {
        return Stream.of(
                TestCase.of(null, null),
                TestCase.of("TYPE1", new Factory.Type1()),
                TestCase.of("TYPE2", new Factory.Type2())
        );
    }


    @ParameterizedTest(name = "{0}")
    @MethodSource("differentiatorProvider")
    public void testFactory(TestCase testCase) {
         var output = factory.get(testCase.input());
         assertEquals(testCase.output(), output);
    }

    @Test
    public void testFactoryWithUnsupportedDifferentiator() {
        var type = "TYPE3";
        assertThrows(IllegalArgumentException.class,
                () -> factory.get(type),
                () -> "Unexpected value: " + type);
    }

}
