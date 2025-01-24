package creational.factory;

public interface IParameterizedFactory<ReturnType, Differentiator, ParameterType> {

    ReturnType get(Differentiator differentiator, ParameterType parameters);

}
