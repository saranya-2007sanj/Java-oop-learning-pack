# UML Class Diagrams for the 10 Java Examples

Written in Mermaid `classDiagram` syntax (renders natively on GitHub, VS Code with the Markdown Preview Mermaid extension, and mermaid.live).
Notation: `-` private, `+` public, `#` protected, `<|--` inheritance, `<|..` implements, `*--` composition, `o--` aggregation, `..>` dependency.

## E01 - Classes and Objects
```mermaid
classDiagram
class Book {
  -String title
  -String author
  -int pages
  +Book(String, String, int)
  +getPages() int
  +setPages(int) void
  +equals(Object) boolean
  +hashCode() int
  +toString() String
}
```

## E02 - Encapsulation
```mermaid
classDiagram
class BankAccount {
  -String id
  -double balance
  +BankAccount(String, double)
  +deposit(double) void
  +withdraw(double) void
  +getBalance() double
}
```

## E03 - Inheritance
```mermaid
classDiagram
class Vehicle {
  #String brand
  +Vehicle(String)
  +describe() String
}
class Car {
  #int wheels
  +describe() String
}
class ElectricCar {
  -int kwh
  +describe() String
}
Vehicle <|-- Car
Car <|-- ElectricCar
```

## E04 - Polymorphism
```mermaid
classDiagram
class Shape {
  +area() double
  +name() String
}
class Circle {
  -double r
}
class Rectangle {
  #double w
  #double h
}
class Square
Shape <|-- Circle
Shape <|-- Rectangle
Rectangle <|-- Square
```

## E05 - Abstraction
```mermaid
classDiagram
class Employee {
  <<abstract>>
  #String name
  +monthlyPay()* double
  +payslip() String
}
class FullTime {
  -double salary
}
class PartTime {
  -int hours
  -double rate
}
class Intern
Employee <|-- FullTime
Employee <|-- PartTime
Employee <|-- Intern
```

## E06 - Interfaces
```mermaid
classDiagram
class Flyable {
  <<interface>>
  +fly() String
  +mode() String
}
class Swimmable {
  <<interface>>
  +swim() String
}
class Duck
class Drone
Flyable <|.. Duck
Swimmable <|.. Duck
Flyable <|.. Drone
```

## E07 - Overloading vs Overriding
```mermaid
classDiagram
class Animal {
  +sound() String
}
class Dog {
  +sound() String
}
class E07_OverloadingOverriding {
  +print(Object) String$
  +print(String) String$
  +print(int) String$
}
Animal <|-- Dog
E07_OverloadingOverriding ..> Animal : uses
```

## E08 - Composition
```mermaid
classDiagram
class Engine {
  <<interface>>
  +start() String
}
class PetrolEngine
class ElectricEngine
class Automobile {
  -Engine engine
  +setEngine(Engine) void
  +drive() String
}
Engine <|.. PetrolEngine
Engine <|.. ElectricEngine
Automobile o-- Engine : has-a
```

## E09 - Static and Constructors
```mermaid
classDiagram
class Counter {
  +StringBuilder LOG$
  +int count$
  +Counter()
  +Counter(String label)
}
```

## E10 - Misconceptions (hiding)
```mermaid
classDiagram
class Parent {
  ~String name
  -String secret
  +who() String$
  +reveal() String
}
class Child {
  ~String name
  +who() String$
}
Parent <|-- Child
```
