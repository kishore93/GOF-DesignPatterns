# GoF Design Patterns

## Creational Patterns
1. **Singleton**: Ensures a class has only one instance and provides a global access point to it.
2. **Factory Method**: Defines an interface for creating objects but allows subclasses to alter the type of objects created.
3. **Abstract Factory**: Provides an interface to create families of related or dependent objects without specifying their concrete classes.
4. **Builder**: Separates the construction of a complex object from its representation, allowing the same construction process to create different representations.
5. **Prototype**: Creates new objects by copying an existing object, maintaining performance and flexibility.

## Structural Patterns
1. **Adapter**: Converts the interface of a class into another interface clients expect, enabling interoperability.
2. **Bridge**: Decouples abstraction from implementation, allowing both to vary independently.
3. **Composite**: Composes objects into tree structures to represent part-whole hierarchies, allowing clients to treat individual objects and compositions uniformly.
4. **Decorator**: Adds new behaviors or responsibilities to objects dynamically without modifying their structure.
5. **Facade**: Provides a simplified interface to a larger body of code, reducing complexity for the client.
6. **Flyweight**: Reduces memory usage by sharing as much data as possible with other similar objects.
7. **Proxy**: Provides a placeholder or surrogate to control access to an object.

## Behavioral Patterns
1. **Chain of Responsibility**: Passes a request along a chain of handlers until one of them handles it.
2. **Command**: Encapsulates a request as an object, allowing parameterization and queuing of requests.
3. **Interpreter**: Defines a representation for a language's grammar and an interpreter to process sentences in the language.
4. **Iterator**: Provides a way to access elements of a collection sequentially without exposing its underlying representation.
5. **Mediator**: Centralizes complex communication and control logic between objects, reducing direct dependencies.
6. **Memento**: Captures and restores an object's state without violating encapsulation.
7. **Observer**: Defines a one-to-many dependency between objects so that when one object changes state, its dependents are notified.
8. **State**: Allows an object to alter its behavior when its internal state changes.
9. **Strategy**: Defines a family of algorithms, encapsulates them, and makes them interchangeable.
10. **Template Method**: Defines the skeleton of an algorithm in a method, allowing subclasses to override specific steps.
11. **Visitor**: Separates an algorithm from the objects it operates on, allowing new operations without modifying the object structure.
