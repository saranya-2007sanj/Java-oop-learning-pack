# Prompt Library

Format: ID | Task | Skill | Prompt | Result / what was changed. Re-run each prompt in at least one other tool and compare.

| ID | Task | AI skill | Prompt |
|---|---|---|---|
| P01 | Audience framing | Prompting | "I'm making a learning pack for second-year CSE students who know Java syntax but not OOP design. List the 8 OOP concepts to prioritise and the order to teach them, with one reason each." |
| P02 | Research | Prompting + research | "List the most common misconceptions Java learners have about inheritance, polymorphism, overloading vs overriding and pass-by-value. For each give a 5-line code snippet that exposes it and the official-doc section that confirms the correct behaviour." |
| P03 | Source finding | Source checking | "Which pages of the Oracle Java Tutorials and the JLS cover: overload resolution, field hiding, static method hiding, default methods? Give titles, not guesses; say 'not sure' if unsure." |
| P04 | Concept notes | Technical explanation | "Explain {concept} to a second-year student in 120 words, with one real-life analogy and a 6-line Java example. Then list one misconception." |
| P05 | Analogies | Technical explanation | "Give three alternative real-life analogies for {concept}. Mark any that are weak or misleading and say why." |
| P06 | Code | Code verification | "Write a single-file Java 21 program demonstrating {concept} with assertions that throw if the behaviour is wrong. No external libraries. Print results." |
| P07 | Code review | Code verification | "Here is my program and its output: <paste>. Find any bug, version-specific feature, or misleading comment. Do not rewrite unless necessary." |
| P08 | UML | Diagram design | "Produce a Mermaid classDiagram for this Java code: <paste>. Show visibility, abstract/interface stereotypes, and correct arrow types (inheritance, realization, composition, dependency)." |
| P09 | Exercises | Exercise design | "Create 20 graded exercises (easy->hard) covering these concepts: <list>. Each needs a one-sentence task and a reference solution with a self-check." |
| P10 | Quiz | Quiz design | "Write 15 multiple-choice questions on {concepts} for second-year students. Each distractor must reflect a real misconception. Include an answer key with a one-line reason. Mix conceptual and 'what is printed' questions." |
| P11 | Slides | Presentation | "Outline a 7-slide deck: audience & goals, 8 concepts, one code+UML example, exercises & automation, AI verification findings, ethics, demo & takeaways. Max 4 bullets per slide." |
| P12 | Hallucination test | Responsible AI | "Explain Java's multiple inheritance of classes and how `super.super.method()` works." (false-premise probe; correct answer: Java has no class multiple inheritance, and `super.super` is illegal) |
| P13 | Automation | Prompting + code | "Write a Python script that fills a template to generate new OOP exercise variations from lists of entities and hierarchies, seeded for reproducibility." |
| P14 | Ethics | Responsible AI | "List risks of using AI-generated code in coursework and a checklist to reduce them." |

## Result log (fill in as you run)
| ID | Tool | Date | Outcome (good / needed fixing / wrong) | What I changed |
|---|---|---|---|---|
| P01 | | | | |
| P06 | Claude | | Compiled; all assertions passed after run | - |
| P10 | Claude | | Answers cross-checked against E04, E07, E10 | - |
| (add rows) | | | | |
