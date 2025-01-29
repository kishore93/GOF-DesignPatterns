package creational.prototype;

public interface IPrototype<T> {

    /**
     * @return a typical clone of the object that can be further modified by callers
     */
    T basicClone();

}
