# Concept Notes: 8 OOP Ideas with Real-Life Analogies

**Audience:** second-year CSE students who know basic Java syntax (variables, loops, methods).
**Source for definitions:** Oracle Java Tutorials ("Lesson: Object-Oriented Programming Concepts" and "Interfaces and Inheritance"). The analogies below are teaching analogies written for this pack (common classroom comparisons, reworded); none are quoted from a source.

---
## 1. Class and Object
**Idea:** A class is a blueprint that defines state (fields) and behaviour (methods). An object is one concrete instance made from it.
**Analogy:** A house plan vs the actual houses built from it. Ten houses, one plan; painting one house does not repaint the others.
```java
Book b = new Book("Clean Code", "Robert Martin", 464);
```
**Misconception:** "Two objects with the same data are `==`." No - `==` compares identity; use `equals`.
**See:** E01, Exercises 01, 13, Quiz Q12.

## 2. Encapsulation
**Idea:** Keep fields private and expose a small, validated public interface so an object can never be put into an invalid state.
**Analogy:** An ATM. You press buttons (methods); you cannot reach into the cash vault (fields).
```java
private double balance;
void withdraw(double amt) { if (amt > balance) throw new IllegalStateException(); balance -= amt; }
```
**Misconception:** "Private + getter/setter for every field is encapsulation." Blind setters expose the state just as publicly; design methods around behaviour.
**See:** E02, Exercises 02, 14.

## 3. Abstraction
**Idea:** Expose what something does, hide how. In Java: abstract classes and interfaces.
**Analogy:** A TV remote. You press "volume up" without knowing the electronics inside.
```java
abstract class Employee { abstract double monthlyPay(); }
```
**Misconception:** "Abstraction and encapsulation are the same." Abstraction is about the *design view* (what); encapsulation is about *protecting state* (how it is guarded).
**See:** E05, Exercise 08.

## 4. Inheritance
**Idea:** A subclass reuses and extends a superclass (is-a). Java allows one superclass, many interfaces.
**Analogy:** A child inherits family traits but adds their own skills.
```java
class ElectricCar extends Car { ... }
```
**Misconception:** "Use inheritance whenever you want to reuse code." Prefer it only for true is-a; otherwise use composition. Also, parent constructors run *first*.
**See:** E03, Exercise 05, Quiz Q2-Q3.

## 5. Polymorphism
**Idea:** The same call behaves differently depending on the actual object (dynamic dispatch).
**Analogy:** A "Play" button: on a music app it plays a song, on a video app a movie - the button is the same.
```java
for (Shape s : shapes) total += s.area();
```
**Misconception:** "Fields are polymorphic too." Only instance methods are (E10).
**See:** E04, Exercises 06, 07, Quiz Q4, Q8.

## 6. Interface
**Idea:** A contract of methods a class promises to provide; a class may implement many. Default methods (Java 8+) let interfaces evolve safely.
**Analogy:** A wall socket standard: any plug that fits works, regardless of whether it powers a lamp or a laptop.
```java
interface Flyable { String fly(); default String mode() { return "flying"; } }
```
**Misconception:** "Interfaces can't have any code." Since Java 8 they can (default and static methods).
**See:** E06, Exercises 09, 10, 19, Quiz Q13.

## 7. Composition
**Idea:** Build objects from other objects (has-a) and delegate work. More flexible than inheritance because parts can be swapped at run time.
**Analogy:** A laptop is assembled from battery, screen and keyboard; replace the battery without rebuilding the laptop.
```java
class Automobile { private Engine engine; }
```
**Misconception:** "Composition is just a fancy name for fields." The point is *delegation through an abstraction* so parts are replaceable.
**See:** E08, Exercise 12, Quiz Q9.

## 8. Overloading vs Overriding
**Idea:** *Overloading* = same name, different parameters, chosen at compile time from declared types. *Overriding* = subclass replaces an inherited instance method, chosen at run time from the actual object.
**Analogy:** Overloading: one "Open" menu with different file types (decided when you click). Overriding: a franchise outlet that serves the parent menu item its own local way.
```java
print(Object o) / print(String s)      // overload
@Override String sound() { return "Woof"; }   // override
```
**Misconception:** "`Object o = "hi"; print(o)` calls `print(String)`." It calls `print(Object)` (E07).
**See:** E07, Exercises 06, 11, Quiz Q5-Q7, Q11.
