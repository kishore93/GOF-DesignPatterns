package creational.builder;

public class ComplexObject {

    /**
     * Direct object building is discouraged instead
     * use {@link ComplexObjectBuilder} by invoking {@link ComplexObject#builder() builder()}
     * and take advantage of fluent style API
     */
    public ComplexObject() { }

    private SimpleObject header;
    private SimpleObject body;
    private SimpleObject footer;

    public static ComplexObjectBuilder builder() {
        return new ComplexObjectBuilder();
    }

    //Getter methods for accessing data

    public SimpleObject getHeader() {
        return header;
    }

    public SimpleObject getBody() {
        return body;
    }

    public SimpleObject getFooter() {
        return footer;
    }

    public static class ComplexObjectBuilder implements Builder<ComplexObject> {

        ComplexObject complexObject = new ComplexObject();

        public ComplexObjectBuilder header(SimpleObject header) {
            complexObject.header = header;
            return this;
        }

        public ComplexObjectBuilder body(SimpleObject body) {
            complexObject.body = body;
            return this;
        }

        public ComplexObjectBuilder footer(SimpleObject footer) {
            complexObject.footer = footer;
            return this;
        }

        @Override
        public ComplexObject build() {
            return complexObject;
        }

    }
}
