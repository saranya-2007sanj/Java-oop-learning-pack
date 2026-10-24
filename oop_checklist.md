# OOP Concepts Checklist (Second-year CSE)

Tick each box only after you can (a) explain it in your own words, (b) point to the working code, and (c) answer the quiz question without notes.

| Done | Concept | Code (run it) | Exercises | Quiz | Typical misconception to avoid |
|---|---|---|---|---|---|
| [ ] | Class vs object, identity vs equality | E01 | 01, 13 | Q12 | `==` means same content |
| [ ] | Constructors, `this(...)`, init order | E09 | 03 | - | Constructors can be inherited |
| [ ] | `static` members | E09 | 04 | - | `static` belongs to each object |
| [ ] | Encapsulation | E02 | 02, 14 | Q1 | Getters/setters on everything = encapsulation |
| [ ] | Inheritance, `super`, constructor order | E03 | 05 | Q2, Q3 | Inherit for code reuse only |
| [ ] | Method overriding, `@Override` | E04, E07 | 06 | Q4, Q11 | Overriding is decided at compile time |
| [ ] | Polymorphism / dynamic dispatch | E04 | 07 | Q4 | Fields are polymorphic |
| [ ] | Abstract classes, template method | E05 | 08 | Q6 | Abstract classes can't have constructors |
| [ ] | Interfaces, default methods | E06 | 09, 10, 19 | Q13 | Interfaces have no code |
| [ ] | Overloading resolution | E07 | 11 | Q5, Q7 | Chosen by runtime type |
| [ ] | Composition (has-a) | E08 | 12 | Q9 | Same as inheritance |
| [ ] | `equals` / `hashCode` contract | E01 | 13 | Q14 | Override only `equals` |
| [ ] | Immutability, `final` | E01, E02 | 14 | Q10 | `final` field = deep immutable |
| [ ] | Casting, `instanceof` | E10 | 18 | - | Any cast compiles *and* runs |
| [ ] | Pass-by-value | E10 | - | Q15 | Objects are passed by reference |
| [ ] | Exceptions in OO design | E02 | 17 | - | Catch `Exception` everywhere |
| [ ] | Generics + bounded types | - | 20 | - | `T` can call any method |
