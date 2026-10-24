# Research Report: How can AI help teach OOP ideas in Java?

**Project question:** How can AI help teach OOP ideas (classes, inheritance, polymorphism) with clear examples and exercises?
**Target audience:** Second-year CSE students (know Java syntax, loops, arrays, methods; new to design with objects).
**Author / date:** ______ / ______  (fill in)

## 1. Method
1. Fixed the audience and 8 core concepts (see `concept_notes.md`).
2. Used AI tools for research, explanation drafting, code generation, diagram drafting, quiz design and slide outlining (log in section 5).
3. Cross-checked every factual claim against official sources (section 3).
4. Compiled and executed all code with JDK 21; self-checking assertions in each program (`verification/run_log.txt`).
5. Tested AI outputs for hallucinations, wrong or unsafe advice and outdated information (`verification_report.md`).

## 2. Summary of findings
| Finding | Evidence in this pack |
|---|---|
| AI is strong at producing quick, readable first-draft explanations and analogies. | `concept_notes.md` (analogies drafted with AI, then edited) |
| AI is useful for generating many exercise variants cheaply from a template. | `tools/generate.py` -> `docs/exercise_variations.md` (12 variants) |
| AI explanations of Java subtleties (field hiding, overload resolution, pass-by-value) are the highest-risk area; they must be proven by running code. | `E07`, `E10`, Quiz Q5, Q7, Q8, Q15 |
| Code that "looks right" must still be compiled; version-dependent features (pattern-matching `instanceof`, records) need a version check. | Ex. 18 (Java 16+), verification report |
| UML and quiz drafting is faster with AI, but diagrams need checking against the real code (visibility, arrows, abstract markers). | `uml/UML.md` |
| Learners benefit most when AI output is tied to a runnable example and a self-check question, not read passively. | `oop_checklist.md` |

## 3. Reliable sources (open each link and confirm before submission)
| # | Source | Used for |
|---|---|---|
| 1 | Oracle Java Tutorials - Object-Oriented Programming Concepts: https://docs.oracle.com/javase/tutorial/java/concepts/index.html | Definitions of object, class, inheritance, interface, package |
| 2 | Oracle Java Tutorials - Classes and Objects: https://docs.oracle.com/javase/tutorial/java/javaOO/index.html | Constructors, static members, `this` |
| 3 | Oracle Java Tutorials - Interfaces and Inheritance: https://docs.oracle.com/javase/tutorial/java/IandI/index.html | Overriding, hiding, abstract classes, default methods, polymorphism |
| 4 | Java Language Specification SE 21: https://docs.oracle.com/javase/specs/jls/se21/html/index.html | Overload resolution (ch. 15.12), field hiding (8.3), init order (12.4, 12.5) |
| 5 | Java SE 21 API docs: https://docs.oracle.com/en/java/javase/21/docs/api/ | `Object.equals/hashCode` contract, `Comparable`, `Objects` |
| 6 | Bloch, *Effective Java* (3rd ed.) - Items 10, 11, 17, 18 | equals/hashCode, immutability, composition over inheritance |
| 7 | Your university's OOP/Java lecture notes (add link/title) | Course alignment |

*Note: links were written from memory of the official site structure while offline; open each, confirm it loads and says what is claimed, and replace any that moved.*

## 4. Common misconceptions found (each verified by running code)
1. Fields are polymorphic -> false (E10).
2. `static` methods can be overridden -> they are hidden (E10).
3. `==` compares string content -> compares references (E10, Q12).
4. Java passes objects by reference -> pass-by-value of the reference (E10, Q15).
5. Overloads chosen from the runtime type -> declared type, compile time (E07, Q7).
6. Inheritance is the default tool for reuse -> prefer composition for has-a (E08).
7. Overriding `equals` alone is enough -> must keep `hashCode` consistent (Ex. 13).

## 5. AI tool log (fill with what you actually used; minimum 4 tools, 2 for research)
| Tool | Used for | Role | Date | Notes on quality |
|---|---|---|---|---|
| Claude | Draft of code, notes, UML, quiz, generator script | Research + generation | (fill) | Output compiled and passed all self-checks |
| ChatGPT | (e.g. second-opinion research on misconceptions) | Research | | |
| Gemini | (e.g. source search, quiz review) | Research | | |
| NotebookLM | (e.g. summarise Oracle tutorial PDFs) | Source-grounded summary | | |
| Gamma | (e.g. slide styling) | Presentation | | |
| GitHub | Version control and hosting | Repo | | |

## 6. Limitations
Examples target Java 21. The pack does not cover concurrency, generics beyond Exercise 20, or design patterns beyond Singleton and Strategy. Effectiveness for learners (e.g. quiz scores before/after) has not been measured with real students; `before_after_analysis.md` contains a table to record that.
