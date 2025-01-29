package creational.builder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ComplexObjectBuilderTests {

    @Test
    public void shouldBuildEmptyComplexObject() {
        var complexObject = ComplexObject.builder().build();
        assertAll(
                () -> assertNull(complexObject.getHeader()),
                () -> assertNull(complexObject.getBody()),
                () -> assertNull(complexObject.getFooter())
        );
    }

    @Test
    public void shouldBuildComplexObjectPartially() {
        var body = new SimpleObject();
        var complexObject = ComplexObject.builder()
                .body(body)
                .build();
        assertAll(
                () -> assertNull(complexObject.getHeader()),
                () -> assertEquals(body, complexObject.getBody()),
                () -> assertNull(complexObject.getFooter())
        );
    }

    @Test
    public void shouldBuildCompleteComplexObject() {
        var header = new SimpleObject();
        var body = new SimpleObject();
        var footer = new SimpleObject();
        var complexObject = ComplexObject.builder()
                .header(header)
                .body(body)
                .footer(footer)
                .build();
        assertAll(
                () -> assertEquals(header, complexObject.getHeader()),
                () -> assertEquals(body, complexObject.getBody()),
                () -> assertEquals(footer, complexObject.getFooter())
        );
    }

}
