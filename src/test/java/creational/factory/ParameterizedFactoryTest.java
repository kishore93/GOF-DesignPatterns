package creational.factory;

import creational.factory.parameterized.Factory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class ParameterizedFactoryTest {

    public record Testcase<ParamType>(Factory<ParamType> output, String input, ParamType parameter) { }

    public static Stream<Testcase<String>> testDataProviderString() {
        var stringParam = "sample_string";
        return Stream.of(
                new Testcase<>(null, null, null),
                new Testcase<>( new Factory.Type1<>(stringParam), "TYPE1", stringParam),
                new Testcase<>( new Factory.Type2<>(stringParam), "TYPE2", stringParam)
        );
    }

    public static Stream<Testcase<Integer>> testDataProviderInteger() {
        var integerParam = Integer.MAX_VALUE;
        return Stream.of(
                new Testcase<>( new Factory.Type1<>(integerParam), "TYPE1", integerParam),
                new Testcase<>( new Factory.Type2<>(integerParam), "TYPE2", integerParam)
        );
    }


    @ParameterizedTest(name = "{0}")
    @MethodSource("testDataProviderString")
    public void testParameterizedFactoryString(Testcase<String> testcase) {
        IParameterizedFactory<Factory<String>, String, String> factory = new Factory<>();
        assertEquals(testcase.output(), factory.get(testcase.input(), testcase.parameter()));
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("testDataProviderInteger")
    public void testParameterizedFactoryInteger(Testcase<Integer> testcase) {
        IParameterizedFactory<Factory<Integer>, String, Integer> factory = new Factory<>();
        assertEquals(testcase.output(), factory.get(testcase.input(), testcase.parameter()));
    }

    @Test
    public void testFactoryFailure() {
        IParameterizedFactory<Factory<Object>, String, Object> factory = new Factory<>();
        String differentiator = "UNKNOWN_TYPE";
        assertThrows(IllegalArgumentException.class,
                () -> factory.get(differentiator, null),
                () -> "Unexpected value: " + differentiator);
    }

    public static Stream<Testcase<Integer>> negativeTestDataProvider() {
        var integerParam1 = Integer.MAX_VALUE;
        var integerParam2 = Integer.MIN_VALUE;
        return Stream.of(
                new Testcase<>( new Factory.Type2<>(integerParam1), "TYPE1", integerParam1),
                new Testcase<>( new Factory.Type1<>(integerParam1), "TYPE2", integerParam1),
                new Testcase<>( new Factory.Type1<>(integerParam1), "TYPE1", integerParam2),
                new Testcase<>( new Factory.Type2<>(integerParam1), "TYPE2", integerParam2)
        );
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("negativeTestDataProvider")
    public void testFactoryNegative(Testcase<Integer> testcase) {
        IParameterizedFactory<Factory<Integer>, String, Integer> factory = new Factory<>();
        assertNotEquals(testcase.output(), factory.get(testcase.input(), testcase.parameter()));
    }

}
