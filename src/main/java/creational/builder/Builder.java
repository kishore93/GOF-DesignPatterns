package creational.builder;

public interface Builder<T> {

    /**
     * Method that returns a builder instance of the class
     * @return T
     */
    T build();

}
