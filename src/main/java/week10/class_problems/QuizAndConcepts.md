# Week 10 — Part B Quiz and Part C Concepts

## Part B — Quiz answers
1. **B** — protected age and public getName()
2. **C** — Diagram 3 attempts multiple class inheritance
3. **B** — Person → Employee → Manager
4. **C** — Derived can directly access protectedField
5. **B** — the Bus implementation of fare()
6. **B** — overloads use different parameter lists; the subclass method overrides print(String)
7. **A** — only members declared in Shape are directly accessible through a Shape reference
8. **C** — dynamic dispatch calls Circle.area() and Square.area() respectively
9. **B** — Savings cast fails; Current cast succeeds
10. **B** — uniform processing through base references without type checks
11. **A** — printDocument() is exposed behavior; buffer/loading/print-head details are hidden
12. **B** — a Vehicle reference can refer to a Car object
13. **B** — SavingsAccount must also be abstract if it omits the abstract method
14. **B** — concrete MonthlyReport must implement generateBody()
15. **A** — an interface specifies operations/contracts, not per-object state or direct implementation
16. **B** — interface methods are implicitly public abstract (unless otherwise specified by language rules)
17. **C** — implement both serialize() and reset()
18. **C** — interface
19. **B** — Dog IS-A Animal; Eagle CAN-DO Flyable
20. **A** — equals(), hashCode(), toString()

## Part C — Concept answers

### 1. Overloading vs overriding
Overloading uses the same method name with different parameter lists and is resolved at compile time. Overriding replaces an inherited method implementation with the same signature in a subclass, and the implementation is selected at run time according to the object's actual type.

### 2. Constructor invocation
When a derived object is created, the base-class constructor runs first, followed by constructors down the inheritance chain to the derived class. In Java, a derived constructor passes values to a base constructor using `super(arguments)`, which must be the first constructor statement.

### 3. Concrete classes, abstract classes, and interfaces
A concrete class can be instantiated and can hold state and implemented behavior. An abstract class cannot be instantiated directly and can combine fields, implemented methods, and abstract methods. An interface defines a contract that unrelated classes can implement; use it when types need shared capabilities without a shared class hierarchy.

### 4. Identical methods from two interfaces
If two interfaces declare the same abstract method signature, one public implementation in the implementing class satisfies both contracts. This shows that a class can implement multiple interfaces while providing a single implementation for a common operation.

### 5. equals() and hashCode()
If equals() defines content equality, equal objects must return the same hash code. If hashCode() is not overridden consistently, hash-based collections such as HashSet and HashMap may place equal objects in different buckets and fail to detect duplicates reliably.

### 6. Shallow vs deep copy
A shallow copy duplicates the outer object but shares references to nested mutable objects. Changes through one copy can therefore affect the other. A deep copy also duplicates the mutable nested objects, keeping the copies independent.

### 7. Inner vs static nested classes
A non-static inner class is associated with an instance of its enclosing class and can access that instance's members. A static nested class does not require an enclosing instance and cannot directly access instance members. Inner classes suit objects tied to a specific outer object; static nested classes suit helper types logically grouped with the outer class.

### 8. Array operation complexity
Access by index is O(1) because the address can be calculated directly. Inserting or deleting in the middle of a fixed-size array is O(n) because later elements may need to shift to preserve order.

### 9. Polymorphic arrays and dynamic dispatch
A base-type array can store objects of different subclasses. Calling an overridden method through each base reference runs the implementation belonging to that object's actual class, allowing uniform processing without explicit type checks.

### 10. IS-A vs CAN-DO
Use inheritance for an IS-A relationship, such as Dog extending Animal. Use an interface for a CAN-DO capability that can apply to unrelated classes, such as Bird and Drone both implementing Flyable.