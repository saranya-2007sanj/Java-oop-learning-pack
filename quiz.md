# OOP in Java - 15-Question Quiz

Time: 20 minutes. One correct answer each. Answer key with explanations is at the bottom (do not scroll first).

**Q1.** Which principle hides an object's internal state behind validated methods?
A) Inheritance  B) Encapsulation  C) Polymorphism  D) Overloading

**Q2.** How many classes can a Java class extend directly?
A) One  B) Two  C) Any number  D) None

**Q3.** Which call invokes a parent-class constructor?
A) `this()`  B) `parent()`  C) `super()`  D) `base()`

**Q4.** What is printed?
```java
class A { String who() { return "A"; } }
class B extends A { String who() { return "B"; } }
A x = new B();
System.out.println(x.who());
```
A) A  B) Compile error  C) Runtime error  D) B

**Q5.** Which overloaded method is called is decided...
A) at run time from the object's actual class  B) at compile time from the declared argument types  C) at link time  D) while the class loads

**Q6.** Which of these can declare a constructor?
A) An abstract class  B) An interface  C) Both  D) Neither

**Q7.** Given `print(Object)` and `print(String)`, what does this call?
```java
Object o = "hi";
print(o);
```
A) `print(String)`  B) `print(Object)`  C) Compile error  D) ClassCastException

**Q8.** Both `Parent` and `Child extends Parent` declare a field `String name` ("Parent" / "Child"). What does this print?
```java
Parent p = new Child();
System.out.println(p.name);
```
A) Child  B) null  C) Parent  D) Compile error

**Q9.** "A Car has an Engine" is best described as:
A) is-a  B) static nesting  C) has-a (composition)  D) overriding

**Q10.** A class declared `final` means it:
A) cannot be instantiated  B) cannot be subclassed  C) has only static methods  D) has immutable fields

**Q11.** Which override is NOT allowed?
A) Returning a subtype of the parent's return type  B) Making a protected method public  C) Making a public method protected  D) Adding `@Override`

**Q12.** What does `new String("x") == new String("x")` evaluate to?
A) true  B) false  C) Compile error  D) Depends on the JVM

**Q13.** What is the main purpose of `default` methods in interfaces?
A) Add behaviour to an interface without breaking existing implementers  B) Allow private fields  C) Allow multiple inheritance of state  D) Replace abstract classes

**Q14.** Why must you override `hashCode` whenever you override `equals`?
A) The compiler requires it  B) Hash-based collections rely on equal objects having equal hash codes  C) `toString` depends on it  D) It makes `==` faster

**Q15.** What is printed?
```java
static void change(StringBuilder sb) { sb.append("!"); sb = new StringBuilder("new"); }
StringBuilder s = new StringBuilder("hi");
change(s);
System.out.println(s);
```
A) hi  B) hi!  C) new  D) new!

---
## Answer Key

| Q | Ans | Why |
|---|---|---|
| 1 | B | Encapsulation protects state behind methods. |
| 2 | A | Single class inheritance; multiple interfaces are allowed. |
| 3 | C | `super(...)` must be the first statement in a constructor. |
| 4 | D | Dynamic dispatch uses the actual object (B). Verified in E04/E07. |
| 5 | B | Overload resolution is compile-time on declared types. Verified in E07. |
| 6 | A | Abstract classes have constructors (called via `super`); interfaces do not. |
| 7 | B | Declared type is `Object`. Verified in E07. |
| 8 | C | Fields are not polymorphic; the declared type `Parent` decides. Verified in E10. |
| 9 | C | Composition = has-a. |
| 10 | B | `final` class cannot be extended (e.g. `String`). |
| 11 | C | An override may not reduce visibility. |
| 12 | B | Two distinct objects; `==` compares references. Verified in E10. |
| 13 | A | Interface evolution without breaking old implementers. |
| 14 | B | The equals/hashCode contract; otherwise HashSet/HashMap misbehave (see Exercise 13). |
| 15 | B | Reference copied by value; mutation visible, reassignment is not. Verified in E10. |

Scoring: 13-15 strong; 9-12 revisit concept notes; <9 re-run E01-E10 and retry.
