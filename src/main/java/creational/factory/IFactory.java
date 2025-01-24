package creational.factory;

public interface IFactory<ReturnType, Differentiator> {

    ReturnType get(Differentiator differentiator);

}
