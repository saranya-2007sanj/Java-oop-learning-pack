# Java OOP Learning Pack

> Capstone 43: How can AI help teach OOP ideas (classes, inheritance, polymorphism) with clear examples and exercises?

An AI-assisted, **verified** learning pack for second-year CSE students. Every code example is compiled and run with self-checking assertions, and AI output is tested for hallucinations, wrong advice and outdated information.

![Java](https://img.shields.io/badge/Java-21-orange) ![Tests](https://img.shields.io/badge/examples-10%20passing-brightgreen) ![Exercises](https://img.shields.io/badge/exercises-20%20passing-brightgreen)

## What's inside

| Item | Location |
|---|---|
| 8 OOP concepts with real-life analogies | `docs/concept_notes.md` |
| OOP concepts checklist | `docs/oop_checklist.md` |
| 10 tested Java examples | `src/examples/` |
| 10 UML class diagrams (Mermaid) | `uml/UML.md` |
| 20 exercises with solutions | `docs/exercises.md`, `exercises/Solutions.java` |
| 15-question quiz + answer key | `docs/quiz.md` |
| 7-slide presentation | `OOP_Learning_Pack.pptx` |  
| Research report | `docs/research_report.md` |
| Prompt library | `docs/prompt_library.md` |
| Verification report (hallucination tests) | `docs/verification_report.md` |
| Before/after analysis | `docs/before_after_analysis.md` |
| Ethics statement | `docs/ethics.md` |
| Exercise generator (automation) | `tools/generate.py` |

## Concepts covered

Class & object, encapsulation, abstraction, inheritance, polymorphism, interfaces, composition, overloading vs overriding, plus common Java gotchas (field hiding, `==` vs `equals`, pass-by-value).

## Quick start

**Requirements:** JDK 21+ and Python 3.8+ (no other dependencies).

```bash
git clone https://github.com/<your-username>/java-oop-learning-pack.git
cd java-oop-learning-pack

./run_all.sh                                  # run all 10 examples + 20 exercises
java src/examples/E04_Polymorphism.java       # run a single example
```

## Automation: exercise generator

```bash
python3 tools/generate.py exercises                      # rebuild docs/exercises.md from tested solutions
python3 tools/generate.py variations --n 12 --seed 7     # generate new exercise variations
```

## Suggested study path

1. Read a concept in `docs/concept_notes.md`
2. Run the matching example in `src/examples/` and view its UML in `uml/UML.md`
3. Solve the related exercises in `docs/exercises.md`
4. Test yourself with `docs/quiz.md` and tick off `docs/oop_checklist.md`

## How AI was used (and checked)

AI tools helped draft explanations, code, diagrams, quiz questions and the generator script. Nothing is included unless it was compiled, run and understood by the author. Details are in the [prompt library](docs/prompt_library.md), [verification report](docs/verification_report.md) and [ethics statement](docs/ethics.md).

## Sources

- [Oracle Java Tutorials: OOP Concepts](https://docs.oracle.com/javase/tutorial/java/concepts/index.html)
- [Oracle Java Tutorials: Interfaces and Inheritance](https://docs.oracle.com/javase/tutorial/java/IandI/index.html)
- [Java Language Specification, SE 21](https://docs.oracle.com/javase/specs/jls/se21/html/index.html)
- Bloch, *Effective Java* (3rd ed.)

## Author

<Your Name>, <Your University>, <Year>

## License

MIT (or your choice). Educational use.
